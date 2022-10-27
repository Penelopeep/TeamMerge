package pene.gc.teammerge.utils;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.ConfigContainer;
import emu.grasscutter.game.player.Player;

public class SettingEditor {
    public static void ChangeTeamSize(Player targetplayer, int size){
        ConfigContainer newConfig = Grasscutter.getConfig();
        if (targetplayer.isInMultiplayer()){
            if (Grasscutter.getConfig().server.game.gameOptions.avatarLimits.multiplayerTeam<size){
                newConfig.server.game.gameOptions.avatarLimits.multiplayerTeam = size;
            }
        } else {
            if (Grasscutter.getConfig().server.game.gameOptions.avatarLimits.singlePlayerTeam<size){
                newConfig.server.game.gameOptions.avatarLimits.singlePlayerTeam = size;
            }
        }
        Grasscutter.saveConfig(newConfig);
        Grasscutter.loadConfig();

    }
}
