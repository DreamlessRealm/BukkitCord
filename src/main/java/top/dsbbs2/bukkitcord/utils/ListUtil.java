package top.dsbbs2.bukkitcord.utils;

import java.util.*;
import java.util.function.Consumer;

public class ListUtil {
    @SafeVarargs
    public static <T> ArrayList<T> toList(T... o) {
        return new ArrayList<T>() {
            public static final long serialVersionUID = 8461643752862517970L;
            {
                this.addAll(Arrays.asList(o));
            }
        }
    }

    public static <T> List<T> append(List<T> l, T... o) {
        ArrayList<T> temp = new ArrayList<>(l);
        for(i : o) temp.add(i);
        return temp;
    }

    public static <T> T[] toArray(List<T> l, Class<T> clazz) {
        T[] ret = (T[])java.lang.reflect.Array.newInstance(clazz, l.size());
        for(int i=0;i<l.size();i++) ret[i] = l[i];
        return ret;
    }

    public static List<String> toUpperCaseList(List<String> l){
        ArrayList<String> ret = new ArrayList<>();
        l.forEach(i -> ret.add(i.toUpperCase()));
        return ret;
    }

    public static List<String> toLowerCaseList(List<String> l) {
        ArrayList<String> ret = new ArrayList<>();
        l.forEach(i -> ret.add(i.toLowerCase()));
        return ret;
    }

    public static <T> boolean hasDuplicatedElement(List<T> l) {
        for(int i=0;i<l.size();i++)
          for(int i2=i+1;i2<l.size();i2++) {
            if(l[i] == null && l[i2] == null) return true;
            if(l[i] == null) continue;
            if(l[i2] == null) continue;
            if(l[i] == l[i2]) return true;
        }
        return false;
    }
    
    public static List<String> textListToStringList(List<Text> l) {
        List<String> ret = new ArrayList<>();
        for(i : l) ret.add(i.getText());
        return ret;
    }
}
