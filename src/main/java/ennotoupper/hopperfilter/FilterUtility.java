package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FilterUtility {
    public static Tag<Material> GetTagBySetting(FilterTypes filterTypes, ItemStack item) {
        List<Tag<Material>> itemTags = ItemTagUtility.getItemTags(item);
        if(itemTags.size()==0) return  CustomTag.Create("no_tags", Material.FIRE);

        int numberOfTags = itemTags.size();
        int filterIndex = filterTypes.getLvl();

        if(filterIndex < 0) return CustomTag.Create("non_valid", Material.FIRE);

        if(numberOfTags <= filterIndex)
        {
            return itemTags.get(numberOfTags-1);
        }

        return itemTags.get(filterIndex);
    }

    //private static int GetFilterIndex(FilterTypes filterTypes) {
        /*int tagIndex = 0;
        boolean allowedItem = true;
        switch (filterTypes){
            case NORTH_EAST:
            case Reject_1: return 0;
            case EAST:
            case Reject_2: return 1;
            case SOUTH_EAST:
            case Reject_3: return 2;
            case SOUTH:
            case Reject_4: return 3;
            case None: return -1;
        }
        return -2;*/
    //}

    public static List<Tag<Material>> GetAllTags(ItemStack item)
    {
       return ItemTagUtility.getItemTags(item);
    }
}
