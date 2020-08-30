package top.dsbbs2.bukkitcord.bukkit;

import org.bukkit.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;
import java.util.stream.*;

public class BukkitPluginDescriptionImpl implements IPluginDescription {
    @Override
    public String getName() {
        return i.getName();
    }

    @Override
    public String getVersion() {
        return i.getVersion();
    }

    @Override
    public List<String> getAuthor() {
        return i.getAuthors();
    }

    @Override
    public Set<String> getDepends() {
        return i.getDepend().parallelStream().collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSoftDepends() {
        return i.getSoftDepend().parallelStream().collect(Collectors.toSet());
    }

    @Override
    public String getMain() {
        return i.getMain();
    }

    @Override
    public String getDescription() {
        return i.getDescription();
    }

    private final PluginDescriptionFile i;
    public BukkitPluginDescriptionImpl(PluginDescriptionFile i)
    {
        this.i=i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BukkitPluginDescriptionImpl)) return i.equals(o);
        BukkitPluginDescriptionImpl that = (BukkitPluginDescriptionImpl) o;
        return Objects.equals(i, that.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    @Override
    public String toString() {
        return "BukkitPluginDescriptionImpl{" +
                "i=" + i +
                '}';
    }

    @Override
    public PluginDescriptionFile getDelegate() {
        return i;
    }
}
