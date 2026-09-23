package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.jk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cd {
    public final int a;
    public final com.google.android.libraries.navigation.internal.oe.ag b;
    public final double c;
    public final int d;
    public final jk e;
    public final int f;
    public final float g;

    public cd(int i, com.google.android.libraries.navigation.internal.oe.ag agVar, double d, int i2, jk jkVar, int i3, float f) {
        this.a = i;
        this.b = agVar;
        this.c = d;
        this.d = i2;
        this.e = jkVar;
        this.f = i3;
        this.g = f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StopMetadata{stopIndex=");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", distanceFromPolylineStartMeters=");
        sb.append(this.c);
        sb.append(", stopCount=");
        sb.append(this.d);
        sb.append(", name=");
        sb.append(this.e.c);
        sb.append(", metersOnPolylineFromPrevStop=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
