package com.google.android.libraries.navigation.internal.fq;

import com.google.android.libraries.navigation.internal.km.an;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class o implements p {
    public static volatile f a;
    protected int b;
    private final List c;
    private final f d;
    private final com.google.android.libraries.navigation.internal.xn.a e;
    private boolean f;
    private final n g;
    private final a h;

    public o(int i, f fVar, n nVar, String str) {
        this.c = new ArrayList();
        this.f = false;
        this.b = i;
        this.g = nVar;
        if (fVar != null) {
            this.d = fVar;
        } else {
            this.d = a;
        }
        if (str.isEmpty()) {
            this.e = com.google.android.libraries.navigation.internal.xn.a.e(nVar);
        } else {
            this.e = com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.e(nVar), com.google.android.libraries.navigation.internal.xn.a.d(": ")), com.google.android.libraries.navigation.internal.xn.a.d(str));
        }
        com.google.android.libraries.navigation.internal.kl.a aVar = fVar == null ? null : fVar.c;
        if (aVar == null || !nVar.f431n) {
            this.h = null;
        } else {
            this.h = b.a(nVar.m, n.ALL_OBJECT_POOL.m, an.u, an.v, aVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized String a() {
        return "size: " + this.c.size();
    }

    protected final synchronized int b(List list, float f) {
        int size;
        int i;
        size = list.size();
        float f2 = size;
        while (true) {
            i = (int) (f * f2);
            if (list.size() <= i) {
                break;
            }
            list.remove(list.size() - 1);
        }
        if (this.f && this.c.isEmpty()) {
            f fVar = this.d;
            if (fVar != null) {
                fVar.e(this);
            }
            this.f = false;
        }
        return size - i;
    }

    public final synchronized Object c() {
        int size;
        size = this.c.size();
        a aVar = this.h;
        if (aVar != null && this.g.f431n) {
            if (size != 0) {
                aVar.a();
            } else {
                aVar.b();
            }
        }
        return size == 0 ? d() : this.c.remove(size - 1);
    }

    protected abstract Object d();

    public final synchronized void e() {
        h(0.0f);
    }

    protected final synchronized void f(List list, Object obj) {
        f fVar;
        if (!this.f && (fVar = this.d) != null) {
            fVar.c(this, this.e);
            this.f = true;
        }
        list.add(obj);
    }

    public final synchronized void g(Object obj) {
        if (this.c.size() >= this.b) {
            return;
        }
        f(this.c, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized void h(float f) {
        b(this.c, f);
    }

    public final synchronized String toString() {
        return "ObjectPool[name: " + this.e.a + "; " + this.c.size() + RemoteSettings.FORWARD_SLASH_STRING + this.b + "]";
    }

    public o(int i, String str) {
        this(i, null, n.OTHER, str);
    }
}
