package pene.gc.teammerge.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import pene.gc.teammerge.utils.SettingEditor;

import java.util.List;

@Command(label = "TeamMerge", aliases = {"party", "tm"})
public final class TeamMerge implements CommandHandler {
    public int getTeamSize(Player targetPlayer){
        int TeamSize;
        if (targetPlayer.isInMultiplayer()) {
            TeamSize = Grasscutter.getConfig().server.game.gameOptions.avatarLimits.multiplayerTeam;
        }
        else {
            TeamSize = Grasscutter.getConfig().server.game.gameOptions.avatarLimits.singlePlayerTeam;
        }
        return TeamSize;
    }
    @Override
    public void execute(Player sender,Player targetPlayer, List<String> args) {
        int TeamSize = getTeamSize(targetPlayer);
        int OldTeamSize = TeamSize; //I'll use it someday
        if (TeamSize==2 || TeamSize==4){
            SettingEditor.ChangeTeamSize(targetPlayer,40); //Size 40 since there's now maximum of 10 teams
            TeamSize=getTeamSize(targetPlayer);
            if (TeamSize==OldTeamSize){
                if(sender!=null){
                    CommandHandler.sendMessage(sender,"TeamMerge couldn't change server setting");
                } else {
                    Grasscutter.getLogger().error("TeamMerge couldn't change server setting");
                }
            }
        }
        for (int i = 1; i <= targetPlayer.getTeamManager().getTeams().size(); i++) {
            try {
                List<Integer> tiAvatars = targetPlayer.getTeamManager().getTeams().get(i).getAvatars();
                for (int avatarid : tiAvatars) {
                    int addChar = 0;
                    List<EntityAvatar> entityAvatarList = targetPlayer.getTeamManager().getActiveTeam();
                    for (EntityAvatar entityAvatar : entityAvatarList) {
                        if (entityAvatar.getAvatar().getAvatarId() == avatarid) {
                            addChar += 1;
                        }
                    }
                    if (addChar == 0) {
                        Avatar avatar = targetPlayer.getAvatars().getAvatarById(avatarid);
                        targetPlayer.getTeamManager().addAvatarToCurrentTeam(avatar);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sender != null) {
            if (targetPlayer.getTeamManager().getCurrentTeamInfo().size() == TeamSize) {
                CommandHandler.sendMessage(targetPlayer, "Characters couldn't be added to party, probably server config isn't changed");
            } else if (targetPlayer.getTeamManager().getCurrentTeamInfo().size() < TeamSize) {
                CommandHandler.sendMessage(targetPlayer, "Characters added to party");
            } else {
                CommandHandler.sendMessage(targetPlayer, "Unknown error, report this on plugin github/dm Penelopeep#7963");
            }
        }
        else{
            if (targetPlayer.getTeamManager().getCurrentTeamInfo().size() == TeamSize) {
                Grasscutter.getLogger().warn("Characters couldn't be added to party, probably server config isn't changed");
            } else if (targetPlayer.getTeamManager().getCurrentTeamInfo().size() < TeamSize) {
                Grasscutter.getLogger().info("Characters added to party");
            } else {
                Grasscutter.getLogger().error("Unknown error, report this on plugin github/dm Penelopeep#7963");
            }
        }
    }
}
