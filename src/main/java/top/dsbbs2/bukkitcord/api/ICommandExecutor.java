package top.dsbbs2.bukkitcord.api;

@FunctionalInterface
public interface ICommandExecutor {
    boolean execute(ICommandSender sender, ICommand command, String[] args);
}
