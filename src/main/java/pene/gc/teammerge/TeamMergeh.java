package pene.gc.teammerge;

import emu.grasscutter.plugin.Plugin;

public final class TeamMergeh extends Plugin {
    private static TeamMergeh instance;
    public static TeamMergeh getInstance() {
        return instance;
    }
    @Override public void onLoad() {
        // Set the plugin instance.
        instance = this;
    }
    @Override public void onEnable() {

        // Register commands.
        this.getHandle().registerCommand(new pene.gc.teammerge.commands.TeamMerge());

        // Log a plugin status message.
        this.getLogger().info("The TeamMerge plugin has been enabled.");
    }

    @Override public void onDisable() {
        // Log a plugin status message.
        this.getLogger().info("The TeamMerge plugin has been disabled.");
    }
}
