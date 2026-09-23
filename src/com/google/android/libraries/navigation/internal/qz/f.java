package com.google.android.libraries.navigation.internal.qz;

import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.yx.aa;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class f {
    private Reference a;
    final /* synthetic */ k b;
    private Reference c;

    public f(k kVar) {
        this.b = kVar;
    }

    private static final Object e(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    protected abstract aa a(Object obj);

    protected abstract Object b();

    public Object c() {
        Object objE = e(this.a);
        if (objE != null) {
            return objE;
        }
        synchronized (this) {
            Object objE2 = e(this.a);
            if (objE2 != null) {
                return objE2;
            }
            Object objB = b();
            if (objB == null) {
                return null;
            }
            this.a = new SoftReference(objB);
            return objB;
        }
    }

    final ah d(x xVar) {
        synchronized (this) {
            aa aaVarA = (aa) e(this.c);
            if (aaVarA == null) {
                Object objC = c();
                aaVarA = objC == null ? null : a(objC);
                this.c = aaVarA == null ? null : new SoftReference(aaVarA);
            }
            if (aaVarA != null) {
                return (ah) aaVarA.ak(xVar);
            }
            this.b.m();
            return null;
        }
    }
}
