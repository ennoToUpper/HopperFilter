package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FilterUtility {
    public static Tag<Material> GetTagBySetting(FilterTypes filterTypes, ItemStack item) {
        List<Tag<Material>> itemTags = ItemTagUtility.getItemTags(item);
        if(itemTags.size()==0) return null;

        int numberOfTags = itemTags.size();
        int filterIndex = filterTypes.getLvl()/2;

        if(filterIndex < 0) return CustomTag.Create("non_valid", Material.FIRE);

        if(numberOfTags <= filterIndex)
        {
            return itemTags.get(numberOfTags-1);
        }

        return itemTags.get(filterIndex);
    }

    public static List<Tag<Material>> GetAllTags(ItemStack item)
    {
       return ItemTagUtility.getItemTags(item);
    }
}
