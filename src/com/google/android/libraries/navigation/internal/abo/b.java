package com.google.android.libraries.navigation.internal.abo;

import android.graphics.Bitmap;
import android.util.SparseIntArray;
import com.google.android.gms.maps.ak;
import com.google.android.gms.maps.al;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abh.be;
import com.google.android.libraries.navigation.internal.abm.df;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.ol.as;
import com.google.android.libraries.navigation.internal.ol.j;
import com.google.android.libraries.navigation.internal.ol.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final int a = al.a;
    public static final int b = al.m;
    public static final int c = ak.i;
    public j d;
    public z e;
    public be f;
    public df g;
    public x h;
    public boolean i;
    public boolean j;
    public final SparseIntArray k = new SparseIntArray();

    public final aq a(int i) {
        Bitmap bitmapK = this.f.k(i);
        s.d(bitmapK != null, "Unable to load MyLocation resources.");
        int iA = this.g.a(this.e, bitmapK, Float.MAX_VALUE);
        this.k.put(i, iA);
        return this.e.e().i().c(iA);
    }

    public final void b() {
        if (this.h == null || !this.j) {
            return;
        }
        this.e.a().e(this.d);
    }

    public final void c(as asVar) {
        s.k(this.d, "dot");
        this.d.k(asVar);
    }
}
