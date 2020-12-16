package ${groupId}.${artifactId}.commands.subcommands;

import ${groupId}.${artifactId}.${name};
import ${groupId}.${artifactId}.commands.SubCommand;
import ${groupId}.${artifactId}.commands.SubCommandMeta;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@SubCommandMeta(
        command = "reload",
        permission = "${artifactId}.command.reload"
)
public class ReloadCommand implements SubCommand {

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        ${name}.get().reload();
        sender.sendMessage(ChatColor.GREEN + "Configuration has been reloaded.");
        return true;
    }
}