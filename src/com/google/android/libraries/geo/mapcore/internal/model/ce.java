package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ce {
    public final cd a;
    public final s b;
    public final int c;
    public final com.google.android.libraries.navigation.internal.oe.o d;
    public final int e;
    public final int f;

    public ce(cd cdVar, s sVar, int i, int i2, int i3) {
        this.a = cdVar;
        this.b = sVar;
        this.c = i;
        this.e = i2;
        this.f = i3;
        this.d = new com.google.android.libraries.navigation.internal.oe.ao(new com.google.android.libraries.navigation.internal.oe.ax(cdVar.e, cdVar.f, cdVar.g, i2, i3));
    }

    public final int a() {
        int i = this.f;
        if (i == 0) {
            throw null;
        }
        switch (i - 1) {
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            case 15:
                return 16;
            case 16:
                return 17;
            case 17:
                return 18;
            case 18:
                return 19;
            case 19:
                return 20;
            case 20:
                return 21;
            case 21:
                return 22;
            default:
                return 4;
        }
    }

    public final String toString() {
        return "TileGlobalData{ coords " + String.valueOf(this.a) + " @ " + this.c + "}";
    }
}
