package ${groupId}.${artifactId};

import ${groupId}.${artifactId}.commands.${name}Command;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author ${author}
 */
public class ${name} extends JavaPlugin {

    private static ${name} instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        reloadConfig();

        Bukkit.getPluginManager().registerEvents(new PluginListener(), this);

        getCommand("${artifactId}").setExecutor(new ${name}Command());
    }

    @Override
    public void onDisable() {

    }

    public void reload() {
        reloadConfig();
    }

    public static ${name} get() {
        return instance;
    }
}
