package top.dsbbs2.bukkitcord.utils.command;

import top.dsbbs2.bukkitcord.utils.ListUtil.hasDuplicatedElement;
import top.dsbbs2.bukkitcord.utils.ListUtil.toLowerCaseList;
import top.dsbbs2.bukkitcord.utils.ListUtil.toUpperCaseList;
import java.util.*;
import java.util.function.Consumer;

public class TabUtil {
    public static List<String> betterGetStartsWithListLowerCase(List<String> o, String s) {
        List<String> temp = getStartsWithList(o, s, false);
        return (hasDuplicatedElement(toLowerCaseList(temp))) ? getStartsWithList(o, s, true) : temp;
    }

    public static List<String> betterGetStartsWithListUpperCase(List<String> o, String s) {
        List<String> temp = getStartsWithList(o, s, false);
        return (hasDuplicatedElement(toUpperCaseList(temp))) ? getStartsWithList(o, s, true) : temp;
    }

    public static List<String> getStartsWithList(List<String> o, String s) {
        return getStartsWithList(o, s, false);
    }

    public static List<String> getStartsWithList(List<String> o, String s, boolean caseSensitive) {
        ArrayList<String> ret = new ArrayList<>();
        if (caseSensitive) {
            o.forEach(i->{if(i.startsWith(s)) ret.add(i);});
        } else {
            o.forEach(i->{if(i.toLowerCase().startsWith(s.toLowerCase())) ret.add(i);});
        }
        return ret;
    }
}
