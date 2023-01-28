package top.dsbbs2.bukkitcord.utils.command;

import java.util.*;

public class CommandUtil {
    public static Vector<String> commandListToCommandNameList(Vector<IChildCommand> v) {
        Vector<String> ret = new Vector<String>();
        for(i : v) {
            ret.add(i.class.getSimpleName());
        }
        return ret;
    }

    public static IChildCommand getCommand(Vector<IChildCommand> l, String cmd) {
        for(i : l) {
            if (i.class.getSimpleName().equalsIgnoreCase(cmd)) return i;
        }
        return null;
    }
}
