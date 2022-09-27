package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.Server;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public final class HopperFilter extends JavaPlugin implements Listener {

    public static JavaPlugin PLUGIN;

    Server server;

    @Override
    public void onEnable() {
        // Plugin startup logic

        server = getServer();
        server.getPluginManager().registerEvents(this, this);

        PLUGIN = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHopperMoveEvent(InventoryMoveItemEvent event) {
        if (!(event.getDestination().getHolder() instanceof Hopper)) return;
        if (event.getDestination().getLocation() == null) return;
        if (event.isCancelled()) return;
        if (event.getDestination().getLocation().getBlock().isBlockPowered()) return;

        Block block = event.getDestination().getLocation().getBlock();

        //Get the filters that are attached to the hopper
        ItemStack item = event.getItem();
        if(item.getType().equals(Material.GOLDEN_SHOVEL))
        {
            int i = 0;
        }

        Filter filter = FilterLogic.getFilters(block);

        //Checking if the item is allowed in the filter, if not moving the item will be cancelled.
        boolean isAllowed = filter.isItemAllowedInHopper(item);
        event.setCancelled(!isAllowed);
        if (event.isCancelled()) return;

//        //Checking the rest of the items in the initiating inventory. If an item has no space in the destination
//        //inventory it is rejected and
//        Inventory initiator = event.getInitiator();
//        Inventory receiver = event.getDestination();
//        ItemStack[] sourceInventory = initiator.getContents();
//
//        for (ItemStack inventoryItem:sourceInventory) {
//            if(inventoryItem == null) continue;
//            if(filter.isItemAllowedInHopper(inventoryItem)){
//
//                HashMap<Integer, ItemStack> rejected = receiver.addItem(inventoryItem.clone());
//
//                if(rejected.isEmpty()){
//                    initiator.remove(inventoryItem);
//                    continue;
//                }
//                int leftover = inventoryItem.getAmount()-rejected.get(0).getAmount();
//                inventoryItem.setAmount(leftover);
//            }
//        }
    }

    @EventHandler
    public void onHopperPickup(InventoryPickupItemEvent event) {
        if (!(event.getInventory().getHolder() instanceof Hopper)) return;

        Block block = Objects.requireNonNull(event.getInventory().getLocation()).getBlock();

        //Get the filters that are attached to the hopper
        ItemStack item = event.getItem().getItemStack();
        Filter filter = FilterLogic.getFilters(block);

        boolean isAllowed = filter.isItemAllowedInHopper(item);
        event.setCancelled(!isAllowed);
    }

    @EventHandler
    public void itemFrameInteract(PlayerInteractEntityEvent event) {
        if (event.isCancelled()) return;
        if (!event.getRightClicked().getType().equals(EntityType.ITEM_FRAME)) return;


        ItemFrame itemFrame = (ItemFrame) event.getRightClicked();
        Block attachedBlock = itemFrame.getLocation().getBlock().getRelative(itemFrame.getAttachedFace());
        if (!(attachedBlock.getState() instanceof Hopper)) return;
        Rotation rotation = itemFrame.getRotation();

        boolean puttingItemInFrame = false;
        ItemStack item = itemFrame.getItem();

        //ItemFrame event acts weird, it returns the values of the itemFrame *before* the event. So we have to calculate what the next state will be.
        if (!itemFrame.getItem().getType().equals(Material.AIR)) {
            rotation = rotation.rotateClockwise();
        }
        else
        {
            Material itemInHand = event.getPlayer().getInventory().getItemInMainHand().getType();
            event.getPlayer().sendMessage(itemInHand.toString());

            puttingItemInFrame = !itemInHand.equals(Material.AIR);
            item = event.getPlayer().getInventory().getItemInMainHand();
        }

        List<Tag<Material>> itemTags = FilterUtility.GetAllTags(item);

        Player player = event.getPlayer();

        if(puttingItemInFrame) {
            String initialMessage = "Filters available: ";
            MessageUtility.SendFilterInfoMessage(player, initialMessage, itemTags);
        }

        boolean isGlowFrame = itemFrame instanceof GlowItemFrame;
        int tagIndex = FilterLogic.GetFilterType(rotation).getLvl();
        MessageUtility.SendMessage(player, tagIndex, itemTags, !isGlowFrame);
    }
}
