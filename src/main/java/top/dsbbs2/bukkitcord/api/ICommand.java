package top.dsbbs2.bukkitcord.api;

public interface ICommand {
    String getPermission();
    void setPermission(String permission);
    String[] getPlatformAliases();
    void setPlatformAliases(String[] aliases);
    ICommandExecutor getPlatformExecutor();
    void setPlatformExecutor(ICommandExecutor executor);
    String getPlatformUsage();
    void setPlatformUsage(String usage);
    ITabCompleter getPlatformTabCompleter();
    void setPlatformTabCompleter(ITabCompleter completer);
}
