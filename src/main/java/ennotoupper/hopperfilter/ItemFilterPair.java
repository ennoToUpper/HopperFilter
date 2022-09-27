package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;

public class ItemFilterPair {

    FilterTypes type;
    boolean isReject;
    Tag<Material> tag;

    public ItemFilterPair(FilterTypes type, Tag<Material> tag, boolean isReject)
    {
        this.isReject = isReject;
        this.type = type;
        this.tag = tag;
    }

    public ItemFilterPair(FilterTypes type, Tag<Material> tag)
    {
        this(type,tag, false);
    }

    public int getValue() {
        int val = type.ordinal();

        if(isReject) return val + 1;
        return val;
    }
}
