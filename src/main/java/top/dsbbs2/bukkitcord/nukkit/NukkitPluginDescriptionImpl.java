package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;
import java.util.stream.*;

public class NukkitPluginDescriptionImpl implements IPluginDescription {
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

    private final PluginDescription i;
    public NukkitPluginDescriptionImpl(PluginDescription i)
    {
        this.i=i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NukkitPluginDescriptionImpl)) return i.equals(o);
        NukkitPluginDescriptionImpl that = (NukkitPluginDescriptionImpl) o;
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
    public PluginDescription getDelegate() {
        return i;
    }
}
