package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class fw extends ei {
    Object[] d;
    private int e;

    public fw() {
        super(4);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ei, com.google.android.libraries.navigation.internal.yz.ej
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public fw c(Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        if (this.d != null) {
            int iJ = fy.j(this.b);
            Object[] objArr = this.d;
            if (iJ <= objArr.length) {
                Objects.requireNonNull(objArr);
                int length = this.d.length - 1;
                int iHashCode = obj.hashCode();
                int iA = eh.a(iHashCode);
                while (true) {
                    int i = iA & length;
                    Object[] objArr2 = this.d;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iA = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.e += iHashCode;
                        super.b(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.d = null;
        super.b(obj);
        return this;
    }

    public fw h(fw fwVar) {
        if (this.d != null) {
            for (int i = 0; i < fwVar.b; i++) {
                c(Objects.requireNonNull(fwVar.a[i]));
            }
        } else {
            a(fwVar.a, fwVar.b);
        }
        return this;
    }

    public final void j(Object... objArr) {
        if (this.d == null) {
            super.d(objArr);
            return;
        }
        for (Object obj : objArr) {
            c(obj);
        }
    }

    public final void k(Iterable iterable) {
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        if (this.d == null) {
            super.e(iterable);
            return;
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            c(it2.next());
        }
    }

    public final void l(Iterator it2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        while (it2.hasNext()) {
            c(it2.next());
        }
    }

    public fw(int i, boolean z) {
        super(i);
        this.d = new Object[fy.j(i)];
    }

    public fy i() {
        fy fyVarM;
        int i = this.b;
        if (i == 0) {
            return mb.a;
        }
        if (i == 1) {
            return new mq(Objects.requireNonNull(this.a[0]));
        }
        if (this.d == null || fy.j(i) != this.d.length) {
            fyVarM = fy.m(this.b, this.a);
            this.b = fyVarM.size();
        } else {
            int i2 = this.b;
            Object[] objArrCopyOf = this.a;
            if (fy.v(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            int i3 = this.e;
            Object[] objArr = this.d;
            fyVarM = new mb(objArrCopyOf, i3, objArr, objArr.length - 1, this.b);
        }
        this.c = true;
        this.d = null;
        return fyVarM;
    }
}
