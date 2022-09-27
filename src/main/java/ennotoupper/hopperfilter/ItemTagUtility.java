package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemTagUtility {

    private static final LinkedHashMap<Tag<Material>, String> tags;

    static {
        tags = new LinkedHashMap<>();

        tags.put(Tag.WOOL, "WOOL");
        tags.put(Tag.PLANKS, "PLANKS");
        tags.put(Tag.STONE_BRICKS, "STONE_BRICKS");
        tags.put(Tag.WOODEN_BUTTONS, "WOODEN_BUTTONS");
        tags.put(Tag.BUTTONS, "BUTTONS");
        tags.put(Tag.WOODEN_DOORS, "WOODEN_DOORS");
        tags.put(Tag.WOODEN_STAIRS, "WOODEN_STAIRS");
        tags.put(Tag.WOODEN_SLABS, "WOODEN_SLABS");
        tags.put(Tag.WOODEN_FENCES, "WOODEN_FENCES");
        tags.put(Tag.WOODEN_PRESSURE_PLATES, "WOODEN_PRESSURE_PLATES");
        tags.put(Tag.WOODEN_TRAPDOORS, "WOODEN_TRAPDOORS");
        tags.put(Tag.DOORS, "DOORS");
        tags.put(Tag.SAPLINGS, "SAPLINGS");
        tags.put(Tag.LOGS, "LOGS");
        tags.put(Tag.DARK_OAK_LOGS, "DARK_OAK_LOGS");
        tags.put(Tag.OAK_LOGS, "OAK_LOGS");
        tags.put(Tag.BIRCH_LOGS, "BIRCH_LOGS");
        tags.put(Tag.ACACIA_LOGS, "ACACIA_LOGS");
        tags.put(Tag.JUNGLE_LOGS, "JUNGLE_LOGS");
        tags.put(Tag.SPRUCE_LOGS, "SPRUCE_LOGS");
        tags.put(Tag.BANNERS, "BANNERS");
        tags.put(Tag.SAND, "SAND");
        tags.put(Tag.STAIRS, "STAIRS");
        tags.put(Tag.SLABS, "SLABS");
        tags.put(Tag.WALLS, "WALLS");
        tags.put(Tag.ANVIL, "ANVIL");
        tags.put(Tag.RAILS, "RAILS");
        tags.put(Tag.LEAVES, "LEAVES");
        tags.put(Tag.TRAPDOORS, "TRAPDOORS");
        tags.put(Tag.FLOWER_POTS, "FLOWER_POTS");
        tags.put(Tag.SMALL_FLOWERS, "SMALL_FLOWERS");
        tags.put(Tag.BEDS, "BEDS");
        tags.put(Tag.FENCES, "FENCES");
        tags.put(Tag.ICE, "ICE");
        tags.put(Tag.CORAL_BLOCKS, "CORAL_BLOCKS");
        tags.put(Tag.WALL_CORALS, "WALL_CORALS");
        tags.put(Tag.CORAL_PLANTS, "CORAL_PLANTS");
        tags.put(Tag.SIGNS, "SIGNS");
        tags.put(Tag.ITEMS_BANNERS, "ITEMS_BANNERS");
        tags.put(Tag.ITEMS_BOATS, "BOATS");
        tags.put(Tag.ITEMS_FISHES, "ALL_FISHES");
        tags.put(Tag.ITEMS_MUSIC_DISCS, "MUSIC_DISCS");
        tags.put(Tag.ITEMS_COALS, "COALS");
        tags.put(Tag.ITEMS_ARROWS, "ARROWS");
        tags.putAll(CustomTagFactory.GetTags());
    }


    public static boolean isSimilarTag(ItemStack is1, ItemStack is2){
        for (Tag<Material> tag : tags.keySet()) {
            if (tag.isTagged(is1.getType()) && tag.isTagged(is2.getType())) return true;
        }
        return false;
    }

    public static List<Tag<Material>> getItemTags(ItemStack itemStack)
    {
        Material material = itemStack.getType();
        return getItemTagsByMaterial(material);
    }

    protected static List<Tag<Material>> getItemTagsByMaterial(Material type)
    {
        return compareTags(type, tags.keySet());
    }

    private static List<Tag<Material>> compareTags(Material type, Set<Tag<Material>> tags) {
        List<Tag<Material>> itemTags = new ArrayList<>();

        for (Tag<Material> tag : tags) {
/*            if(tag instanceof CustomTag customTag){
                if(customTag.GroupTag)
                {
                    Set<Tag<Material>> groupTags = customTag.getTags();
                    itemTags.addAll(compareTags(type, groupTags));
                    continue;
                }
            }*/
            if (!tag.isTagged(type)) continue;
            itemTags.add(tag);
        }

        return itemTags;
    }

    public static String GetName(Tag<Material> tag) {
        return tags.get(tag);
    }
}
