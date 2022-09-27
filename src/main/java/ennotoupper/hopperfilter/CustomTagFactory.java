package ennotoupper.hopperfilter;

import org.bukkit.Material;
import org.bukkit.Tag;

import java.util.LinkedHashMap;

public class CustomTagFactory {
    public static LinkedHashMap<Tag<Material>,String> customTags = new LinkedHashMap<>();

    public static CustomTag SEEDS;
    public static CustomTag FOOD;
    public static CustomTag RAW;
    public static CustomTag COOKED;
    public static CustomTag PORK;
    private static final CustomTag BEEF;
    private static final CustomTag MUTTON;
    private static final CustomTag RABBIT;
    private static final CustomTag CHICKEN;
    private static final CustomTag WOOD_TOOLS;
    private static final CustomTag STONE_TOOLS;
    private static final CustomTag GOLD_TOOLS;
    private static final CustomTag IRON_TOOLS;
    private static final CustomTag DIAMOND_TOOLS;
    private static final CustomTag NETHERITE_TOOLS;
    private static final CustomTag TOOLS;
    private static final CustomTag AXES;
    private static final CustomTag HOES;
    private static final CustomTag PICKAXES;
    private static final CustomTag SHOVELS;
    private static final CustomTag SWORDS;
    private static final CustomTag MISC_TOOLS;

    static {
        SEEDS = CustomTag.Create("seeds",
                Material.WHEAT_SEEDS, Material.PUMPKIN_SEEDS, Material.MELON_SEEDS, Material.BEETROOT_SEEDS);
        //region [Foods]
        RAW = CustomTag.Create("raw",
                Material.PORKCHOP, Material.BEEF, Material.MUTTON, Material.CHICKEN, Material.RABBIT,
                Material.SALMON, Material.COD, Material.POTATO, Material.BEETROOT, Material.CARROT);
        COOKED = CustomTag.Create("cooked",
                Material.COOKED_PORKCHOP, Material.COOKED_BEEF, Material.COOKED_MUTTON, Material.COOKED_CHICKEN,
                Material.COOKED_RABBIT, Material.COOKED_SALMON, Material.COOKED_COD, Material.BAKED_POTATO);
        PORK = CustomTag.Create("pork", Material.PORKCHOP, Material.COOKED_PORKCHOP);
        BEEF = CustomTag.Create("beef", Material.BEEF, Material.COOKED_BEEF);
        MUTTON = CustomTag.Create("mutton", Material.MUTTON, Material.COOKED_MUTTON);
        RABBIT = CustomTag.Create("rabbit", Material.RABBIT, Material.COOKED_RABBIT, Material.RABBIT_FOOT, Material.RABBIT_HIDE);
        CHICKEN = CustomTag.Create("chicken", Material.CHICKEN, Material.COOKED_CHICKEN);
        FOOD = CustomTag.CreateGroupTag("food", RAW, COOKED);

        AddToList(SEEDS, FOOD, RAW, COOKED, PORK, BEEF,MUTTON,RABBIT,CHICKEN);
        //endregion
        //region [tools]
        WOOD_TOOLS = CustomTag.Create("wood_tools", Material.WOODEN_AXE, Material.WOODEN_HOE,
                Material.WOODEN_PICKAXE, Material.WOODEN_SHOVEL, Material.WOODEN_SWORD);
        STONE_TOOLS = CustomTag.Create("stone_tools", Material.STONE_AXE, Material.STONE_HOE,
                Material.STONE_PICKAXE, Material.STONE_SHOVEL, Material.STONE_SWORD);
        GOLD_TOOLS = CustomTag.Create("gold_tools", Material.GOLDEN_AXE, Material.GOLDEN_HOE,
                Material.GOLDEN_PICKAXE, Material.GOLDEN_SHOVEL, Material.GOLDEN_SWORD);
        IRON_TOOLS = CustomTag.Create("iron_tools", Material.IRON_AXE, Material.IRON_HOE,
                Material.IRON_PICKAXE, Material.IRON_SHOVEL, Material.IRON_SWORD);
        DIAMOND_TOOLS = CustomTag.Create("diamond_tools", Material.DIAMOND_AXE, Material.DIAMOND_HOE,
                Material.DIAMOND_PICKAXE, Material.DIAMOND_SHOVEL, Material.DIAMOND_SWORD);
        NETHERITE_TOOLS = CustomTag.Create("netherite_tools", Material.NETHERITE_AXE, Material.NETHERITE_HOE,
                Material.NETHERITE_PICKAXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_SWORD);
        AXES = CustomTag.Create("axes", Material.WOODEN_AXE, Material.STONE_AXE, Material.GOLDEN_AXE,
                Material.IRON_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE);
        HOES = CustomTag.Create("hoes", Material.WOODEN_HOE, Material.STONE_HOE, Material.GOLDEN_HOE,
                Material.IRON_HOE, Material.DIAMOND_HOE, Material.NETHERITE_HOE);
        PICKAXES = CustomTag.Create("pickaxes", Material.WOODEN_PICKAXE, Material.STONE_PICKAXE,
                Material.GOLDEN_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE);
        SHOVELS = CustomTag.Create("shovels", Material.WOODEN_SHOVEL, Material.STONE_SHOVEL,
                Material.GOLDEN_SHOVEL, Material.IRON_SHOVEL, Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL);
        SWORDS = CustomTag.Create("swords", Material.WOODEN_SWORD, Material.STONE_SWORD, Material.GOLDEN_SWORD,
                Material.IRON_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD);
        MISC_TOOLS = CustomTag.Create("misc_tools", Material.COMPASS, Material.RECOVERY_COMPASS, Material.LEAD,
                Material.FLINT_AND_STEEL, Material.FISHING_ROD, Material.SHEARS);
        TOOLS = CustomTag.CreateGroupTag("tools", WOOD_TOOLS, STONE_TOOLS,
                GOLD_TOOLS, IRON_TOOLS, DIAMOND_TOOLS, NETHERITE_TOOLS, MISC_TOOLS);
        AddToList(TOOLS, WOOD_TOOLS,STONE_TOOLS, GOLD_TOOLS, IRON_TOOLS, DIAMOND_TOOLS, NETHERITE_TOOLS, AXES,
                HOES, PICKAXES, SHOVELS, SWORDS, MISC_TOOLS);
        //endregion
        //region [redstone]

        //endregion
    }

    private static void AddToList(CustomTag... allTags) {
        for (CustomTag tag: allTags) {
            customTags.put(tag, tag.getName());
        }
    }

    public static LinkedHashMap<Tag<Material>, String> GetTags() {
        return customTags;
    }
}
