package com.mappls.sdk.navigation.ui.model;

/* JADX INFO: loaded from: classes4.dex */
public class CustomInfoBarItem {
    private int iconAttr;
    private String id;
    private String text;

    public CustomInfoBarItem(String str, String str2, int i) {
        this.id = str;
        this.text = str2;
        this.iconAttr = i;
    }

    public int getIconAttr() {
        return this.iconAttr;
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setIconAttr(int i) {
        this.iconAttr = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
