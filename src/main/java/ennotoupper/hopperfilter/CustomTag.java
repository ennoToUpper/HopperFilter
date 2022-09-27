package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomTag implements Tag<Material> {

    Set<Material> materials;
    Set<Tag<Material>> tags;
    String name;

    boolean GroupTag = false;
    private CustomTag(String name, Material... materialsIn){
        this.name = name.toLowerCase();
        materials = new HashSet<>(materialsIn.length);
        materials.addAll(Arrays.asList(materialsIn));
    }

    public static CustomTag Create(String name, Material... customTagsIn)
    {
        return new CustomTag(name, customTagsIn);
    }

    private CustomTag(String name, CustomTag... customTagsIn)
    {
        this.name = name.toLowerCase();
        tags = new HashSet<>(customTagsIn.length);
        tags.addAll(Arrays.asList(customTagsIn));
        GroupTag = true;
    }

    public static CustomTag CreateGroupTag(String name, CustomTag... customTagsIn) {
        return new CustomTag(name, customTagsIn);
    }

    @Override
    public boolean isTagged(@NotNull Material item) {
        if(GroupTag)
        {
            for (Tag<Material> tag : tags)
            {
                if(tag.isTagged(item)) return true;
            }
        }
        else
        {
            for (Material material : materials)
            {
                if (item.equals(material)) return true;
            }
        }

        return false;
    }

    @Override
    public @NotNull Set<Material> getValues() {
        return materials;
    }

    @Override
    public @NotNull NamespacedKey getKey() {
        return new NamespacedKey(HopperFilter.PLUGIN, name);
    }

    public String getName() {
        return name.toUpperCase();
    }
}
