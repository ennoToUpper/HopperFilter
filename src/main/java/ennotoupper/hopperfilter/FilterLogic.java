package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class FilterLogic {

    public static Filter getFilters(Block block)
    {
        return getHopperFilters(block);
    }

    private static Filter getHopperFilters(Block block) {
        Collection<Entity> nearbyEntities = block.getWorld().getNearbyEntities(block.getLocation(), 1.01, 1.01, 1.01);

        Filter filter = new Filter();

        for (Entity entity : nearbyEntities) {
            if (!(entity instanceof ItemFrame frame)) continue;

            ItemStack item = frame.getItem();
            if (item.getType().equals(Material.AIR)) continue;

            Block attachedBlock = getBlock(frame);
            if (block.equals(attachedBlock)) {
                FilterTypes filterSetting = FilterUtility.getFilterTypes(frame.getRotation());
                filter.AddSetting(filterSetting, item, entity instanceof GlowItemFrame);
            }
        }
        return filter;
    }

    @NotNull
    private static Block getBlock(ItemFrame frame) {
        return frame.getLocation().getBlock().getRelative(frame.getAttachedFace());
    }

}
