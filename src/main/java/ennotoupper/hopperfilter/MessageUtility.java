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
            initialMessageBuilder.append(ItemTagUtility.GetName(tag)).append(" ");
        }
        initialMessage = initialMessageBuilder.toString();

        player.sendMessage(ChatColor.DARK_AQUA + initialMessage);
    }

    public static final String ITEM_ALLOWED = ChatColor.GREEN + "Accepting: ";
    public static final String ITEM_REJECTED = ChatColor.RED + "Rejecting: ";

    public static void SendMessage(Player player, Tag<Material> tag, boolean allowed) {
        String message = allowed ? ITEM_ALLOWED : ITEM_REJECTED;
        message = message + ChatColor.WHITE + ItemTagUtility.GetName(tag);
        player.sendMessage(message);
    }
}
