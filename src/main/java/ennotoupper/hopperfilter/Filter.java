package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static ennotoupper.hopperfilter.FilterUtility.*;

public class Filter {

    public boolean isItemAllowedInHopper(ItemStack item)
    {
        if(!isFilterSet()) return true;

        List<Tag<Material>> tagFromItem = GetAllTags(item);

        return CheckIfInFilters(tagFromItem);
    }

    private boolean CheckIfInFilters(List<Tag<Material>> tagFromItem)
    {
        boolean allowFilterSet  = false;
        boolean rejectFilterSet = false;

        for (Tag<Material> tag : tagFromItem) {
            ItemFilterPair result = TraverseList(tag);
            if(result == null) continue;

            if(result.isReject) {
                rejectFilterSet = true;
            } else {
                allowFilterSet = true;
            }
        }

        return allowFilterSet && !rejectFilterSet;
    }

    private ItemFilterPair TraverseList(Tag<Material> tag) {
        for (ItemFilterPair itemPair : itemFilterPairs)
        {
            if(itemPair.tag.equals(tag))
            {
                return itemPair;
            }
        }
        return null;
    }

    private boolean isFilterSet()
    {
        return itemFilterPairs.size() > 0;
    }

    List<ItemFilterPair> itemFilterPairs = new ArrayList<>();

    public void AddSetting(FilterTypes filterType, ItemStack item, boolean isReject)
    {
        Tag<Material> tag = GetTagBySetting(filterType, item);
        if(tag == null) return;
        ItemFilterPair itemPair = new ItemFilterPair(filterType, tag, isReject);
        AddSettingWithTag(itemPair);
    }

    private void AddSettingWithTag(ItemFilterPair itemPair)
    {
        AddByHierarchy(itemPair);
    }

    private void AddByHierarchy(ItemFilterPair itemPairIn) {
        int position = 0;
        boolean searching = true;

        FilterTypes filterTypeIn = itemPairIn.type;
        ListIterator<ItemFilterPair> iterator = itemFilterPairs.listIterator(0);

        if(itemFilterPairs.size() == 0)
        {
            itemFilterPairs.add(itemPairIn);
            return;
        }

        ItemFilterPair current = itemFilterPairs.get(0);
        boolean isReversed = false;

        //Adding filterTypeIn to the correct position according to it's hierarchy
        while (searching)
        {
            FilterTypes currentType = current.type;
            int result = currentType.compareTo(filterTypeIn);
            result = itemPairIn.isReject ? result + 1 : result;
            //filterTypeIn is less important than the current filter type
            if(result < 0)
            {
                position++;

                if(iterator.hasNext())
                {
                    current = iterator.next();
                    continue;
                }

                itemFilterPairs.add(itemPairIn);
                return;
            }
            //filterTypeIn is more important than the current filter type
            else if (result > 0) {
                searching = iterator.hasPrevious();

                if(searching && isReversed) {
                    itemFilterPairs.add(position, itemPairIn);
                    return;
                } else if (searching) {
                    position--;
                    isReversed = true;
                    current = iterator.previous();
                    continue;
                }

                itemFilterPairs.add(0, itemPairIn);
                return;
            }
            //filterTypeIn is equally important as the current filter type
            else {
                itemFilterPairs.add(position, itemPairIn);
                searching = false;
            }
        }
    }
}
