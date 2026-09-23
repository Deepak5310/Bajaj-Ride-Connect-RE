package com.google.android.libraries.navigation.internal.yy;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ad implements Iterator {
    int a;
    int b = -1;
    ao c;
    AtomicReferenceArray d;
    bj e;
    bh f;
    bh g;
    final /* synthetic */ bi h;

    public ad(bi biVar) {
        this.h = biVar;
        this.a = biVar.f.length - 1;
        b();
    }

    final bh a() {
        bh bhVar = this.f;
        if (bhVar == null) {
            throw new NoSuchElementException();
        }
        this.g = bhVar;
        b();
        return this.g;
    }

    final void b() {
        this.f = null;
        if (d() || e()) {
            return;
        }
        while (true) {
            int i = this.a;
            if (i < 0) {
                return;
            }
            bi biVar = this.h;
            this.a = i - 1;
            ao aoVar = biVar.f[i];
            this.c = aoVar;
            if (aoVar.b != 0) {
                AtomicReferenceArray atomicReferenceArray = this.c.f;
                this.d = atomicReferenceArray;
                this.b = atomicReferenceArray.length() - 1;
                if (e()) {
                    return;
                }
            }
        }
    }

    final boolean c(bj bjVar) {
        Object obj;
        boolean z;
        try {
            long jA = this.h.q.a();
            Object objJ = bjVar.j();
            bi biVar = this.h;
            Object obj2 = null;
            if (bjVar.j() != null && (obj = bjVar.d().get()) != null && !biVar.l(bjVar, jA)) {
                obj2 = obj;
            }
            if (obj2 != null) {
                this.f = new bh(this.h, objJ, obj2);
                z = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            this.c.p();
        }
    }

    final boolean d() {
        bj bjVar = this.e;
        if (bjVar == null) {
            return false;
        }
        while (true) {
            this.e = bjVar.e();
            bj bjVar2 = this.e;
            if (bjVar2 == null) {
                return false;
            }
            if (c(bjVar2)) {
                return true;
            }
            bjVar = this.e;
        }
    }

    final boolean e() {
        while (true) {
            int i = this.b;
            if (i < 0) {
                return false;
            }
            AtomicReferenceArray atomicReferenceArray = this.d;
            this.b = i - 1;
            bj bjVar = (bj) atomicReferenceArray.get(i);
            this.e = bjVar;
            if (bjVar != null && (c(bjVar) || d())) {
                return true;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.g != null);
        this.h.remove(this.g.a);
        this.g = null;
    }
}
