package com.google.android.libraries.navigation.internal.abs;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public static final String a = "h";
    public final int b;
    public final ev c;
    public final float d;
    public final int[] e;
    public final d f;
    public final b g;
    public Map h;
    public float[] i;
    public Map j;
    public float[] k;

    public h(int i, ev evVar, d dVar, b bVar) {
        com.google.android.libraries.navigation.internal.abf.s.b(i >= 0, "illegal zoomLevel: %s", Integer.valueOf(i));
        this.b = i;
        com.google.android.libraries.navigation.internal.abf.s.k(evVar, "keys");
        this.c = evVar;
        com.google.android.libraries.navigation.internal.abf.s.a(!evVar.isEmpty(), "keys.isEmpty()");
        com.google.android.libraries.navigation.internal.abf.s.i(200.0f, "defaultRadiusM != NaN");
        this.d = 200.0f;
        com.google.android.libraries.navigation.internal.abf.s.a(true, "defaultRadiusM > 0");
        com.google.android.libraries.navigation.internal.abf.s.b(true, "Illegal mesh size %s", 32);
        this.e = new int[evVar.size()];
        com.google.android.libraries.navigation.internal.abf.s.k(dVar, "glTileFactory");
        this.f = dVar;
        this.g = bVar;
        synchronized (this) {
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
        }
    }

    public final g a(com.google.android.libraries.navigation.internal.abt.e eVar) {
        if (b()) {
            return (g) this.h.get(eVar);
        }
        return null;
    }

    public final boolean b() {
        return this.h != null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.c, ((h) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c});
    }

    public final String toString() {
        return aj.f(this).c("zoomLevel", this.b).e("meshes", this.h != null).toString();
    }
}
