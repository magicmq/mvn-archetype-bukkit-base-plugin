package ${groupId}.${artifactId}.config;

import ${groupId}.${artifactId}.${name};
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class PluginConfig {

    private static FileConfiguration config;

    static {
        reload();
    }

    public static void reload() {
        config = ${name}.get().getConfig();
    }

    public static String getMessage(String key, boolean withPrefix) {
        return ChatColor.translateAlternateColorCodes('&', (withPrefix ? config.getString("messages.plugin-prefix") : "") + config.getString("messages." + key));
    }
}