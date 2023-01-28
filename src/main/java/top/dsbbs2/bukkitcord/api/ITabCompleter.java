package top.dsbbs2.bukkitcord.api;

public interface ITabCompleter {
    List<String> tabComplete(ICommandSender sender, ICommand command, String alias, String[] args) throws IllegalArgumentException;
}
