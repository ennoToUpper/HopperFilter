package ennotoupper.hopperfilter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageUtility {
    public static void SendFilterInfoMessage(Player player, String initialMessage, List<Tag<Material>> itemTags) {
        StringBuilder initialMessageBuilder = new StringBuilder(initialMessage);
        for (Tag<Material> tag: itemTags) {
            initialMessageBuilder.append(tag.getKey()).append(" ");
        }
        initialMessage = initialMessageBuilder.toString();

        player.sendMessage(ChatColor.DARK_AQUA + initialMessage);
    }

    public static final String ITEM_ALLOWED = ChatColor.GREEN + "Accepting: ";
    public static final String ITEM_REJECTED = ChatColor.RED + "Rejecting: ";

    public static void SendMessage(Player player, int tagIndex, List<Tag<Material>> itemTags, boolean allowed) {
        String debugMsg = "tagIndex: " + tagIndex + ", Tags: " + itemTags.size();
        player.sendMessage(debugMsg);
        tagIndex /= 2;
        if (tagIndex > itemTags.size()-1) return;

        String message = allowed ? ITEM_ALLOWED : ITEM_REJECTED;

        Tag<Material> tag = itemTags.get(tagIndex);

        player.sendMessage(message + ChatColor.WHITE + ItemTagUtility.GetName(tag));
    }
}
