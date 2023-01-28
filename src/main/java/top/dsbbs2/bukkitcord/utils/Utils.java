package top.dsbbs2.bukkitcord.utils;

public class Utils {
    public static boolean isInRange(int check,int var1, int var2) {
        int max=Math.max(var1,var2);
        int min=Math.min(var1,var2);
        return max==min?check==max:(check>=min&&check<max);


    }
}
