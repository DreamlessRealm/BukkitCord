package top.dsbbs2.bukkitcord.utils.command;

import top.dsbbs2.bukkitcord.api.ICommand;
import top.dsbbs2.bukkitcord.api.ICommandSender;

public interface IChildCommand {
    default void onCommand(ICommandSender sender, ICommand cmd,String[] args) {}
    default String getPermission(){return "";}
    default String getUsage(){return "";}
}
