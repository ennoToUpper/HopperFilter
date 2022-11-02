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
    private static final CustomTag DOORS;
    private static final CustomTag TRAP_DOORS;
    private static final CustomTag GATES;
    private static final CustomTag REDSTONE_SOURCES;
    private static final CustomTag REDSTONE_CONTROLLED;
    private static final CustomTag REDSTONE_ACTIVATED;
    private static final CustomTag REDSTONE_BASICS;
    private static final CustomTag REDSTONE;
    private static final CustomTag HELMETS;
    private static final CustomTag CHESTPLATES;
    private static final CustomTag LEGGINGS;
    private static final CustomTag BOOTS;
    private static final CustomTag LEATHER_ARMOR;
    private static final CustomTag CHAINMAIL_ARMOR;
    private static final CustomTag GOLDEN_ARMOR;
    private static final CustomTag IRON_ARMOR;
    private static final CustomTag DIAMOND_ARMOR;
    private static final CustomTag NETHERITE_ARMOR;
    private static final CustomTag HORSE_ARMOR;
    private static final CustomTag DISTANCE_WEAPONS;
    private static final CustomTag DEFENSE;
    private static final CustomTag MELEE;
    private static final CustomTag ARMOR;
    private static final CustomTag WEAPONS;
    private static final CustomTag COBBLESTONE;
    private static final CustomTag BREWING_INGREDIENTS;
    private static final CustomTag BREWING_UTENSILS;
    private static final CustomTag BREWING_MODIFIER;
    private static final CustomTag BREWING;

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
        //region [combat]
        HELMETS = CustomTag.Create("helmets", Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET,
                Material.GOLDEN_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET, Material.NETHERITE_HELMET,
                Material.TURTLE_HELMET);
        CHESTPLATES = CustomTag.Create("chestplates", Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE,
                Material.GOLDEN_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE,
                Material.NETHERITE_CHESTPLATE);
        LEGGINGS = CustomTag.Create("leggings", Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS,
                Material.GOLDEN_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS,
                Material.NETHERITE_LEGGINGS);
        BOOTS = CustomTag.Create("boots", Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS,
                Material.GOLDEN_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS, Material.NETHERITE_BOOTS);
        LEATHER_ARMOR = CustomTag.Create("leather_armor", Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE,
                Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        CHAINMAIL_ARMOR = CustomTag.Create("chainmail_armor", Material.CHAINMAIL_HELMET,
                Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS);
        GOLDEN_ARMOR = CustomTag.Create("golden_armor", Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE,
                Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS);
        IRON_ARMOR = CustomTag.Create("iron_armor", Material.IRON_HELMET, Material.IRON_CHESTPLATE,
                Material.IRON_LEGGINGS, Material.IRON_BOOTS);
        DIAMOND_ARMOR = CustomTag.Create("diamond_armor", Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE,
                Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
        NETHERITE_ARMOR = CustomTag.Create("netherite_armor", Material.NETHERITE_HELMET,
                Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS);
        HORSE_ARMOR = CustomTag.Create("horse_armor", Material.LEATHER_HORSE_ARMOR, Material.GOLDEN_HORSE_ARMOR,
                Material.IRON_HORSE_ARMOR, Material.DIAMOND_HORSE_ARMOR);
        DISTANCE_WEAPONS = CustomTag.Create("distance_weapons", Material.BOW, Material.CROSSBOW,
                Material.TRIDENT, Material.ARROW, Material.SPECTRAL_ARROW, Material.TIPPED_ARROW);
        DEFENSE = CustomTag.Create("defense", Material.SHIELD);
        ARMOR = CustomTag.CreateGroupTag("armor", HELMETS, CHESTPLATES, LEGGINGS, BOOTS, HORSE_ARMOR);
        WEAPONS = CustomTag.CreateGroupTag("weapons", DISTANCE_WEAPONS, SWORDS, AXES);
        MELEE = CustomTag.CreateGroupTag("melee", SWORDS, AXES, DEFENSE);
        AddToList(ARMOR, WEAPONS, MELEE, DEFENSE, DISTANCE_WEAPONS, HORSE_ARMOR, HELMETS, CHESTPLATES, LEGGINGS, BOOTS,
                LEATHER_ARMOR, CHAINMAIL_ARMOR, GOLDEN_ARMOR, IRON_ARMOR, DIAMOND_ARMOR, NETHERITE_ARMOR);
        //endregion
        //region [pathing]
        DOORS = CustomTag.Create("doors", Material.BIRCH_DOOR, Material.ACACIA_DOOR, Material.CRIMSON_DOOR,
                Material.IRON_DOOR, Material.OAK_DOOR, Material.DARK_OAK_DOOR, Material.JUNGLE_DOOR,
                Material.MANGROVE_DOOR, Material.SPRUCE_DOOR, Material.WARPED_DOOR);
        TRAP_DOORS = CustomTag.Create("trap_doors", Material.BIRCH_TRAPDOOR, Material.ACACIA_TRAPDOOR,
                Material.CRIMSON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.OAK_TRAPDOOR, Material.DARK_OAK_TRAPDOOR,
                Material.JUNGLE_TRAPDOOR, Material.MANGROVE_TRAPDOOR, Material.SPRUCE_TRAPDOOR,
                Material.WARPED_TRAPDOOR);
        GATES = CustomTag.Create("gates", Material.ACACIA_FENCE_GATE, Material.CRIMSON_FENCE_GATE,
                Material.BIRCH_FENCE_GATE, Material.JUNGLE_FENCE_GATE, Material.DARK_OAK_FENCE_GATE,
                Material.MANGROVE_FENCE_GATE, Material.SPRUCE_FENCE_GATE, Material.WARPED_FENCE_GATE,
                Material.OAK_FENCE_GATE);
        AddToList(DOORS, TRAP_DOORS, GATES);
        //endregion
        //region [redstone]
        REDSTONE_SOURCES = CustomTag.Create("redstone_sources", Material.DAYLIGHT_DETECTOR,
                Material.REDSTONE_BLOCK, Material.TRIPWIRE_HOOK, Material.TRIPWIRE, Material.OBSERVER, Material.LEVER,
                Material.LECTERN, Material.HOPPER, Material.TARGET, Material.REDSTONE_TORCH, Material.LIGHTNING_ROD,
                Material.DETECTOR_RAIL);
        REDSTONE_BASICS = CustomTag.Create("redstone_logic", Material.COMPARATOR, Material.REPEATER,
                Material.REDSTONE, Material.TORCH);
        REDSTONE_ACTIVATED = CustomTag.Create("redstone", Material.DROPPER, Material.PISTON,
                Material.STICKY_PISTON, Material.HOPPER, Material.TNT, Material.REDSTONE_LAMP, Material.NOTE_BLOCK,
                Material.POWERED_RAIL, Material.ACTIVATOR_RAIL);
        REDSTONE_CONTROLLED = CustomTag.CreateGroupTag("redstone_controlled", DOORS, TRAP_DOORS, GATES,
                REDSTONE_ACTIVATED);
        REDSTONE = CustomTag.CreateGroupTag("redstone", REDSTONE_ACTIVATED, REDSTONE_SOURCES,
                REDSTONE_CONTROLLED, REDSTONE_BASICS);
        AddToList(REDSTONE, REDSTONE_BASICS, REDSTONE_SOURCES, REDSTONE_ACTIVATED, REDSTONE_CONTROLLED);
        //endregion
        //region [stones]
        COBBLESTONE = CustomTag.Create("cobblestone", Material.COBBLESTONE, Material.COBBLED_DEEPSLATE,
                Material.COBBLED_DEEPSLATE_SLAB, Material.COBBLED_DEEPSLATE_STAIRS, Material.COBBLED_DEEPSLATE_WALL,
                Material.COBBLESTONE_SLAB, Material.COBBLESTONE_STAIRS, Material.COBBLESTONE_WALL,
                Material.INFESTED_COBBLESTONE, Material.MOSSY_COBBLESTONE, Material.MOSSY_COBBLESTONE_SLAB,
                Material.MOSSY_COBBLESTONE_STAIRS, Material.MOSSY_COBBLESTONE_WALL);
        //endregion
        //region [brewing]
        BREWING_INGREDIENTS = CustomTag.Create("brewing_ingredients", Material.BLAZE_POWDER, 
                Material.FERMENTED_SPIDER_EYE, Material.GLASS_BOTTLE, Material.NETHER_WART, Material.REDSTONE,
                Material.GLOWSTONE_DUST, Material.GUNPOWDER, Material.DRAGON_BREATH);
        BREWING_UTENSILS = CustomTag.Create("brewing_utensils", Material.BREWING_STAND, Material.CAULDRON);
        BREWING_MODIFIER = CustomTag.Create("brewing_modifier", Material.SUGAR, Material.RABBIT_FOOT,
                Material.GLISTERING_MELON_SLICE, Material.SPIDER_EYE, Material.PUFFERFISH, Material.MAGMA_CREAM,
                Material.GOLDEN_CARROT, Material.BLAZE_POWDER, Material.GHAST_TEAR, Material.TURTLE_HELMET,
                Material.PHANTOM_MEMBRANE);
        BREWING = CustomTag.CreateGroupTag("brewing", BREWING_INGREDIENTS, BREWING_UTENSILS);
        AddToList(BREWING, BREWING_INGREDIENTS, BREWING_UTENSILS);
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
