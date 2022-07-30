package pene.gc.teammerge.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.TeamInfo;
import java.util.List;
import java.util.Map;

@Command(label = "TeamMerge", aliases = {"party", "tm"})
public final class TeamMerge implements CommandHandler {
    @Override
    public void execute(Player sender,Player targetPlayer, List<String> args) {

        Map<Integer, TeamInfo> list = targetPlayer.getTeamManager().getTeams();
        for (TeamInfo ti : list.values()) {
            List<Integer> tiAvatars = ti.getAvatars();
            for (int avatarid : tiAvatars) {
                int addChar = 0;
                List<EntityAvatar> entityAvatarList = targetPlayer.getTeamManager().getActiveTeam();
                for (EntityAvatar entityAvatar : entityAvatarList){
                    if (entityAvatar.getAvatar().getAvatarId() == avatarid){
                        addChar += 1;
                    }
                }
                if (addChar == 0) {
                    Avatar avatar = targetPlayer.getAvatars().getAvatarById(avatarid);
                    targetPlayer.getTeamManager().addAvatarToCurrentTeam(avatar);
                }
            }
        }
        if (sender != null) {
            CommandHandler.sendMessage(targetPlayer, "Characters added to party, if nothing changed then look into Github README");
        }
        else {
            Grasscutter.getLogger().info("Characters added to party, if nothing changed then look into Github README");
        }
    }
}
