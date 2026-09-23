package com.google.android.libraries.navigation.internal.qg;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d {
    public final cd a;
    public final boolean b;
    public int c;
    public boolean d;
    x e;

    public d(cd cdVar, boolean z) {
        this(cdVar, z, cdVar.a, z, new x());
    }

    public d(cd cdVar, boolean z, int i, boolean z2, x xVar) {
        this.a = cdVar;
        this.b = z;
        this.c = i;
        this.d = z2;
        this.e = xVar;
    }

    public final String toString() {
        return String.valueOf(this.a) + ", isLocalRequest=" + this.b + ", minZoomForAncestorTileFetch=" + this.c + ", ancestorsAreLocalRequests=" + this.d + ", viewportCenter=" + String.valueOf(this.e);
    }
}
