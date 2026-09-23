package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ig implements Iterator {
    int a;
    int b = -1;
    il c;
    AtomicReferenceArray d;
    ih e;
    jj f;
    jj g;
    final /* synthetic */ jk h;

    public ig(jk jkVar) {
        this.h = jkVar;
        this.a = jkVar.d.length - 1;
        b();
    }

    final jj a() {
        jj jjVar = this.f;
        if (jjVar == null) {
            throw new NoSuchElementException();
        }
        this.g = jjVar;
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
            jk jkVar = this.h;
            this.a = i - 1;
            il ilVar = jkVar.d[i];
            this.c = ilVar;
            if (ilVar.b != 0) {
                AtomicReferenceArray atomicReferenceArray = this.c.e;
                this.d = atomicReferenceArray;
                this.b = atomicReferenceArray.length() - 1;
                if (e()) {
                    return;
                }
            }
        }
    }

    final boolean c(ih ihVar) {
        boolean z;
        try {
            Object objC = ihVar.c();
            Object objD = ihVar.c() == null ? null : ihVar.d();
            if (objD != null) {
                this.f = new jj(this.h, objC, objD);
                z = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            this.c.j();
        }
    }

    final boolean d() {
        ih ihVar = this.e;
        if (ihVar == null) {
            return false;
        }
        while (true) {
            this.e = ihVar.b();
            ih ihVar2 = this.e;
            if (ihVar2 == null) {
                return false;
            }
            if (c(ihVar2)) {
                return true;
            }
            ihVar = this.e;
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
            ih ihVar = (ih) atomicReferenceArray.get(i);
            this.e = ihVar;
            if (ihVar != null && (c(ihVar) || d())) {
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
        bs.c(this.g != null);
        this.h.remove(this.g.a);
        this.g = null;
    }
}
