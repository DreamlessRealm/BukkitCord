package top.dsbbs2.bukkitcord.bungee;

import com.google.common.collect.*;
import net.md_5.bungee.api.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BungeePluginDescriptionImpl implements IPluginDescription {
    @Override
    public String getName() {
        return i.getName();
    }

    @Override
    public String getMain() {
        return i.getMain();
    }

    @Override
    public String getVersion() {
        return i.getVersion();
    }

    @Override
    public List<String> getAuthor() {
        return Lists.newArrayList(i.getAuthor());
    }

    @Override
    public Set<String> getDepends() {
        return i.getDepends();
    }

    @Override
    public Set<String> getSoftDepends() {
        return i.getSoftDepends();
    }

    @Override
    public String getDescription() {
        return i.getDescription();
    }

    @Override
    public PluginDescription getDelegate() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BungeePluginDescriptionImpl)) return i.equals(o);
        BungeePluginDescriptionImpl that = (BungeePluginDescriptionImpl) o;
        return Objects.equals(i, that.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    @Override
    public String toString() {
        return "BungeePluginDescriptionImpl{" +
                "i=" + i +
                '}';
    }

    private final PluginDescription i;
    public BungeePluginDescriptionImpl(PluginDescription i)
    {
        this.i=i;
    }

}
