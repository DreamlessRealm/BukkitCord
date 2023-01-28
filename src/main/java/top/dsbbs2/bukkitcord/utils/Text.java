package top.dsbbs2.bukkitcord.utils;

import java.util.*;

public class Text implements Comparable<Object> {
    private volatile String text;

    public Text() {
        this.text = "";
    }

    public Text(String t) {
        if(t == null) t = "";
        this.text = t.toLowerCase(Locale.ENGLISH);
    }

    public void setText(String t) {
        if(t == null) t = "";
        this.text = t.toLowerCase(Locale.ENGLISH);
    }

    public String getText() {
        if(text == null) text = "";
        return text.toLowerCase(Locale.ENGLISH);
    }
    @Override
    public String toString() {
        return getText();
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Text) return ((Text)o).getText().equalsIgnoreCase(this.getText());
        if(o instanceof String) return ((String)o).equalsIgnoreCase(this.getText());
        if(o !=null ) return o.toString().equalsIgnoreCase(this.getText());
        return false;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Text) return ((Text)o).getText().toLowerCase().compareTo(this.getText().toLowerCase());
        if(o instanceof String) return ((String)o).toLowerCase().compareTo(this.getText().toLowerCase());
        if(o!=null) return this.getText().toLowerCase().compareTo(o.toString().toLowerCase());
        return 0;
    }
}
