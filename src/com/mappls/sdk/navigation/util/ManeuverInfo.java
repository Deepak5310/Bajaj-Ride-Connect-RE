package com.mappls.sdk.navigation.util;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class ManeuverInfo {
    String infoText = "";
    Drawable icon = null;

    public Drawable getIcon() {
        return this.icon;
    }

    public String getInfoText() {
        return this.infoText;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setInfoText(String str) {
        this.infoText = str;
    }
}
