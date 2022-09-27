package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Filter {

    public boolean isItemAllowedInHopper(ItemStack item)
    {
        if(!isFilterSet()) return true;

        List<Tag<Material>> tagFromItem = FilterUtility.GetAllTags(item);

        ItemFilterPair strongestFilter = new ItemFilterPair(FilterTypes.None, null);

        for (ItemFilterPair itemFilter: itemFilterPairs) {
            int i = tagFromItem.indexOf(itemFilter.tag);
            if( i == -1) continue;

            //DEF - NORTH > 0
            //255 - 0 > 0 => stronger Filter
            if(strongestFilter.getValue() - itemFilter.getValue() > 0 )
            {
                strongestFilter = itemFilter;
            }
        }

        return !strongestFilter.isReject;
    }

    private boolean isFilterSet()
    {
        return itemFilterPairs.size() > 0;
    }

    List<ItemFilterPair> itemFilterPairs = new ArrayList<>();

    public void AddSetting(FilterTypes filterType, ItemStack item, boolean isReject)
    {
        ItemFilterPair itemPair =
                new ItemFilterPair(filterType, FilterUtility.GetTagBySetting(filterType, item), isReject);
        AddSettingWithTag(itemPair);
    }

    protected void AddSettingWithTag(ItemFilterPair itemPair)
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
        int count = 0;
        boolean isReversed = false;

        //Adding filterTypeIn to the correct position according to it's hierarchy
        while (searching)
        {
            count++;
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
            } //filterTypeIn is equally important as the current filter type
            else {
                itemFilterPairs.add(position, itemPairIn);
                searching = false;
            }

            if(count > 1000)
            {
                count = 0;
            }
        }
    }
}
