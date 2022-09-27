package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

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

            Block attachedBlock = frame.getLocation().getBlock().getRelative(frame.getAttachedFace());

            if (block.equals(attachedBlock)) {
                FilterTypes filterSetting = GetFilterType(frame.getRotation());
                filter.AddSetting(filterSetting, item, frame instanceof GlowItemFrame);
            }
        }
        return filter;
    }

    protected static FilterTypes GetFilterType(Rotation rotation)
    {
        return switch (rotation) {
            case NONE -> FilterTypes.NORTH;
            case CLOCKWISE_45 -> FilterTypes.NORTH_EAST;
            case CLOCKWISE -> FilterTypes.EAST;
            case CLOCKWISE_135 -> FilterTypes.SOUTH_EAST;
            case FLIPPED -> FilterTypes.SOUTH;
            case FLIPPED_45 -> FilterTypes.SOUTH_WEST;
            case COUNTER_CLOCKWISE -> FilterTypes.WEST;
            case COUNTER_CLOCKWISE_45 -> FilterTypes.NORTH_WEST;
        };
    }

}
