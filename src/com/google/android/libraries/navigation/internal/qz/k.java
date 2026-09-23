package com.google.android.libraries.navigation.internal.qz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.afm.ai;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qz.k");
    public boolean b;
    public byte[] c;
    public f d;
    public long e;
    public final Object f;
    private final ArrayList g;
    private int h;
    private boolean i;
    private long j;

    public k() {
        this(new Object());
    }

    public final synchronized int a() {
        return this.h;
    }

    public final synchronized long b() {
        return this.j;
    }

    public final Bitmap c() {
        f fVar;
        if (this.h != 3 || (fVar = this.d) == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) fVar.c();
        if (bitmap == null) {
            m();
        }
        return bitmap;
    }

    public final Picture d() {
        f fVar;
        if (this.h != 6 || (fVar = this.d) == null) {
            return null;
        }
        Picture picture = (Picture) fVar.c();
        if (picture == null) {
            m();
        }
        return picture;
    }

    public final Drawable e(Context context) {
        ah ahVarF = f();
        if (ahVarF == null) {
            return null;
        }
        return ahVarF.a(context);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return am.a(this.f, ((k) obj).f);
        }
        return false;
    }

    public final ah f() {
        return g(x.c);
    }

    public final ah g(x xVar) {
        f fVar = this.d;
        if (fVar == null) {
            return null;
        }
        return fVar.d(xVar);
    }

    public final synchronized void h(g gVar) {
        if (gVar != null) {
            this.g.add(gVar);
        }
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final synchronized void i() {
        for (int i = 0; i < this.g.size(); i++) {
            ((g) this.g.get(i)).a(this);
        }
        this.g.clear();
    }

    public final synchronized void j(boolean z) {
        this.i = z;
    }

    public final synchronized void k(Rect rect) {
        new Rect(rect);
    }

    public final synchronized void l(Bitmap bitmap) {
        this.i = false;
        this.h = 3;
        this.d = new e(this, bitmap);
    }

    public final synchronized void m() {
        this.h = 1;
        this.c = null;
        this.d = null;
    }

    public final synchronized void n(long j) {
        this.j = j;
    }

    public final synchronized void o(int i) {
        this.h = i;
    }

    public final synchronized boolean p() {
        int i = this.h;
        return (i == 0 || i == 1 || i == 2) ? false : true;
    }

    public final synchronized boolean q() {
        return this.i;
    }

    public final synchronized boolean r(ai aiVar) {
        this.i = false;
        int i = aiVar.d;
        if (i != 200) {
            if (i != 304) {
            }
            return false;
        }
        if ((aiVar.b & 16) != 0) {
            String lowerCase = aiVar.g.toLowerCase(Locale.US);
            this.e = aiVar.e;
            if (lowerCase.startsWith("image/svg")) {
                byte[] bArrB = aiVar.f.B();
                this.c = bArrB;
                this.h = 6;
                this.d = new j(this, bArrB);
            } else if (lowerCase.startsWith("image/")) {
                byte[] bArrB2 = aiVar.f.B();
                this.c = bArrB2;
                this.h = 3;
                this.d = new d(this, bArrB2);
            } else if (lowerCase.equals("application/binary") || lowerCase.equals("application/octet-stream") || lowerCase.equals("application/zip") || lowerCase.equals("application/vnd.google.octet-stream-compressible")) {
                this.c = aiVar.f.B();
                this.h = 4;
            } else {
                if (!lowerCase.equals("text/html")) {
                    this.h = 1;
                    return false;
                }
                this.c = aiVar.f.B();
                this.h = 5;
            }
            return true;
        }
        this.h = 1;
        return false;
    }

    public k(Object obj) {
        this.f = obj;
        this.h = 0;
        this.g = new ArrayList();
        this.j = -1L;
    }
}
