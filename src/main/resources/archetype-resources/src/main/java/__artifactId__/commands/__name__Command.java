package ${groupId}.${artifactId}.commands;

import ${groupId}.${artifactId}.${name};
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ${name}Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("${artifactId}.command")) {

        } else {
            sender.sendMessage(ChatColor.RED + "Insufficient permissions!");
        }
        return true;
    }
}