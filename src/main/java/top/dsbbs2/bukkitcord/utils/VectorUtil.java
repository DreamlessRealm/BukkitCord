package top.dsbbs2.bukkitcord.utils;

import java.util.*;

public class VectorUtil {
    public static <T> ArrayList<T> toArrayList(Vector<T> v) {
        return new ArrayList(v);
    }

    @SafeVarargs
    public static <T> Vector<T> toVector(T... o){
        return new Vector<T>() {
            public static final long serialVersionUID = 8461643752862517970L;

            {
                this.addAll(Arrays.asList(o));
            }
        };
    }

    public static <T> Vector<String> toStringVector(Vector<T> v) {
        Vector<String> ret = new Vector<String>();
        for(i : v) ret.add(i.toString());
        return ret;
    }
}
