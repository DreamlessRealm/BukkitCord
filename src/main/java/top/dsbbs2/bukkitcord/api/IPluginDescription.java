package top.dsbbs2.bukkitcord.api;

public interface IPluginDescription {
    String getName();
    String getMain();
    String getVersion();
    List<String> getAuthor();
    Set<String> getDepends();
    Set<String> getSoftDepends();
    String getDescription();
    Object getDelegate();
}
