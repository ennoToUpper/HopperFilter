package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FilterUtility {
    public static Tag<Material> GetTagBySetting(FilterTypes filterType, ItemStack item) {
        List<Tag<Material>> itemTags = ItemTagUtility.getItemTags(item);
        if(itemTags.size()==0) return null;

        int numberOfTags = itemTags.size();
        int filterIndex = GetFilterType(filterType);

        if(filterIndex < 0) return null;

        if(numberOfTags <= filterIndex)
        {
            return itemTags.get(numberOfTags-1);
        }

        return itemTags.get(filterIndex);
    }

    protected static int GetFilterType(Rotation rotation)
    {
        return getFilterTypes(rotation).getLvl()/2;
    }

    protected static int GetFilterType(FilterTypes filterType)
    {
        return filterType.getLvl()/2;
    }

    @NotNull
    protected static FilterTypes getFilterTypes(Rotation rotation) {
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

    public static Tag<Material> GetTagByIndex(List<Tag<Material>> itemTags, int tagIndex) {
        if (tagIndex > itemTags.size()-1) return null;
        return itemTags.get(tagIndex);
    }
}
