package com.example.recyclermuiltivewtask;

public class ItemLayout {
    public static final int LayoutOne = 0;
    public static final int LayoutTwo = 1;
    private int viewType;
    private String text;
    private int icon;

    public ItemLayout(int viewType, String text) {
        this.text = text;
        this.viewType = viewType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ItemLayout(int viewType, int icon) {
        this.viewType = viewType;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

}
