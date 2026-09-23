package com.google.android.libraries.navigation.internal.ia;

import com.mappls.sdk.navigation.NavigationConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum a {
    DEFAULT("Default", 10, 120, 12000, 30),
    EXTERNAL("External", 10, 10, 12000, 30),
    EMBEDDED_DEFAULT("Embedded Default", 20, 120, 15000, 30),
    EV_IDAT("EV Certification", 100, 100, 100000, 200),
    HUGE("Huge", 90, 720, 100000, 200),
    UNLIMITED("Unlimited", 0, 0, 0, 0),
    SMALL("Small", 5, 5, NavigationConstants.UI_HANDLER_PROGRESS, 30);

    public final String h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;

    a(String str, int i, int i2, int i3, int i4) {
        this.h = str;
        this.k = i3;
        this.l = i4;
        this.i = i;
        this.j = i2;
    }

    public final boolean a() {
        int i;
        int i2 = this.i;
        return i2 != 0 && i2 <= 10 && (i = this.j) != 0 && i <= 10;
    }
}
