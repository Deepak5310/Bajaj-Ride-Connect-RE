package com.google.android.libraries.navigation.internal.abv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abg.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.abt.m {
    public static final String a = "m";
    public final com.google.android.libraries.navigation.internal.abw.h b;
    public final Map c;
    public final Queue d;
    public com.google.android.libraries.navigation.internal.abt.l e;
    public boolean f;
    private final q g;
    private final f h;
    private final Bitmap.Config i;
    private final l j;

    public m(q qVar, f fVar, com.google.android.libraries.navigation.internal.abw.h hVar, Bitmap.Config config) {
        l lVar = l.b;
        s.k(qVar, "drd");
        this.g = qVar;
        s.k(fVar, "diskCache");
        this.h = fVar;
        s.k(hVar, "frameRequestor");
        this.b = hVar;
        s.k(config, "bitmapConfig");
        this.i = config;
        s.k(lVar, "streetViewProtoDefaults");
        this.j = lVar;
        synchronized (this) {
            this.c = new HashMap();
            this.d = new LinkedList();
            this.e = null;
            this.f = false;
        }
    }

    static final Bitmap d(byte[] bArr, Bitmap.Config config, com.google.android.libraries.navigation.internal.abt.d dVar) {
        if (bArr == null) {
            return null;
        }
        try {
            int length = bArr.length;
            s.a(length > 0, "Empty jpeg array.");
            s.k(config, "bitmapConfig");
            s.k(dVar, "keyForDebugging");
            if (bArr[0] == 67) {
                p.f(l.a, 4);
                bArr = com.google.android.libraries.navigation.internal.abb.c.b(bArr, 0, length);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = config;
            options.inDither = true;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Throwable th) {
            if (p.f(a, 6)) {
                th.getMessage();
            }
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abt.m
    public final void a(com.google.android.libraries.navigation.internal.abt.d dVar) {
        s.k(dVar, "key");
        String str = a;
        p.f(str, 3);
        synchronized (this) {
            if (this.f) {
                p.f(str, 5);
                return;
            }
            Bitmap bitmapD = d(this.h.d(dVar), this.i, dVar);
            if (bitmapD != null) {
                p.f(str, 4);
                this.d.add(new com.google.android.libraries.navigation.internal.abf.q(dVar, bitmapD));
                this.b.b();
            } else {
                if (this.c.containsKey(dVar)) {
                    p.f(str, 3);
                    return;
                }
                n nVar = new n(dVar, this);
                this.c.put(dVar, nVar);
                p.f(str, 4);
                this.g.j(nVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abt.m
    public final synchronized void b(com.google.android.libraries.navigation.internal.abt.l lVar) {
        this.e = lVar;
    }

    public final void c(com.google.android.libraries.navigation.internal.abt.d dVar, boolean z, boolean z2, Map map) {
        s.k(dVar, "requestKey");
        if (p.f(a, 4)) {
            map.keySet();
        }
        n nVar = null;
        Bitmap bitmap = null;
        for (com.google.android.libraries.navigation.internal.abt.d dVar2 : map.keySet()) {
            byte[] bArr = (byte[]) map.get(dVar2);
            Bitmap bitmapD = d(bArr, this.i, dVar2);
            if (bitmapD != null) {
                this.h.b(dVar2, bArr);
                if (r.a(dVar2, dVar)) {
                    bitmap = bitmapD;
                }
            }
        }
        boolean z3 = false;
        if (bitmap == null && !z2 && !z) {
            z3 = true;
        }
        synchronized (this) {
            if (this.f) {
                p.f(a, 5);
                return;
            }
            if (this.c.containsKey(dVar)) {
                if (z3) {
                    nVar = (n) this.c.get(dVar);
                } else {
                    this.c.remove(dVar);
                    this.d.add(new com.google.android.libraries.navigation.internal.abf.q(dVar, bitmap));
                }
            }
            p.f(a, 3);
            if (nVar != null) {
                this.g.j(nVar);
            } else {
                this.b.b();
            }
        }
    }
}
