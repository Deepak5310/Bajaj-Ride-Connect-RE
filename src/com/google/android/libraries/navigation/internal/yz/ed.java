package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ed extends AbstractMap implements Serializable, az {
    transient Object[] a;
    transient Object[] b;
    public transient int c;
    transient int d;
    public transient int e;
    public transient int[] f;
    public transient az g;
    private transient int[] h;
    private transient int[] i;
    private transient int[] j;
    private transient int[] k;
    private transient int l;
    private transient int[] m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private transient Set f660n;
    private transient Set o;
    private transient Set p;

    private ed(int i) {
        i(16);
    }

    public static ed g() {
        return new ed(16);
    }

    private final int o(int i) {
        return i & (this.h.length - 1);
    }

    private final void p(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        int iO = o(i2);
        int[] iArr = this.h;
        int i3 = iArr[iO];
        if (i3 == i) {
            int[] iArr2 = this.j;
            iArr[iO] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.j[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with key ".concat(String.valueOf(String.valueOf(this.a[i]))));
            }
            if (i3 == i) {
                int[] iArr3 = this.j;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.j[i3];
        }
    }

    private final void q(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        int iO = o(i2);
        int[] iArr = this.i;
        int i3 = iArr[iO];
        if (i3 == i) {
            int[] iArr2 = this.k;
            iArr[iO] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.k[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                throw new AssertionError("Expected to find entry with value ".concat(String.valueOf(String.valueOf(this.b[i]))));
            }
            if (i3 == i) {
                int[] iArr3 = this.k;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.k[i3];
        }
    }

    private final void r(int i) {
        int length = this.j.length;
        if (length < i) {
            int iF = ej.f(length, i);
            this.a = Arrays.copyOf(this.a, iF);
            this.b = Arrays.copyOf(this.b, iF);
            this.j = x(this.j, iF);
            this.k = x(this.k, iF);
            this.m = x(this.m, iF);
            this.f = x(this.f, iF);
        }
        if (this.h.length < i) {
            int iC = eh.c(i);
            this.h = w(iC);
            this.i = w(iC);
            for (int i2 = 0; i2 < this.c; i2++) {
                int iO = o(eh.b(this.a[i2]));
                int[] iArr = this.j;
                int[] iArr2 = this.h;
                iArr[i2] = iArr2[iO];
                iArr2[iO] = i2;
                int iO2 = o(eh.b(this.b[i2]));
                int[] iArr3 = this.k;
                int[] iArr4 = this.i;
                iArr3[i2] = iArr4[iO2];
                iArr4[iO2] = i2;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        i(16);
        mg.b(this, objectInputStream, i);
    }

    private final void s(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        int iO = o(i2);
        int[] iArr = this.j;
        int[] iArr2 = this.h;
        iArr[i] = iArr2[iO];
        iArr2[iO] = i;
    }

    private final void t(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        int iO = o(i2);
        int[] iArr = this.k;
        int[] iArr2 = this.i;
        iArr[i] = iArr2[iO];
        iArr2[iO] = i;
    }

    private final void u(int i, int i2, int i3) {
        int i4;
        int i5;
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        p(i, i2);
        q(i, i3);
        v(this.m[i], this.f[i]);
        int i6 = this.c - 1;
        if (i6 != i) {
            int i7 = this.m[i6];
            int i8 = this.f[i6];
            v(i7, i);
            v(i, i8);
            Object[] objArr = this.a;
            Object obj = objArr[i6];
            Object[] objArr2 = this.b;
            Object obj2 = objArr2[i6];
            objArr[i] = obj;
            objArr2[i] = obj2;
            int iO = o(eh.b(obj));
            int[] iArr = this.h;
            int i9 = iArr[iO];
            if (i9 == i6) {
                iArr[iO] = i;
            } else {
                int i10 = this.j[i9];
                while (true) {
                    i4 = i9;
                    i9 = i10;
                    if (i9 == i6) {
                        break;
                    } else {
                        i10 = this.j[i9];
                    }
                }
                this.j[i4] = i;
            }
            int[] iArr2 = this.j;
            iArr2[i] = iArr2[i6];
            iArr2[i6] = -1;
            int iO2 = o(eh.b(obj2));
            int[] iArr3 = this.i;
            int i11 = iArr3[iO2];
            if (i11 == i6) {
                iArr3[iO2] = i;
            } else {
                int i12 = this.k[i11];
                while (true) {
                    i5 = i11;
                    i11 = i12;
                    if (i11 == i6) {
                        break;
                    } else {
                        i12 = this.k[i11];
                    }
                }
                this.k[i5] = i;
            }
            int[] iArr4 = this.k;
            iArr4[i] = iArr4[i6];
            iArr4[i6] = -1;
        }
        Object[] objArr3 = this.a;
        int i13 = this.c - 1;
        objArr3[i13] = null;
        this.b[i13] = null;
        this.c = i13;
        this.d++;
    }

    private static int[] w(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        mg.d(this, objectOutputStream);
    }

    private static int[] x(int[] iArr, int i) {
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(iArrCopyOf, length, i, -1);
        return iArrCopyOf;
    }

    final int a(Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[o(i)];
        while (i2 != -1) {
            if (com.google.android.libraries.navigation.internal.yx.am.a(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    final int b(Object obj) {
        return c(obj, eh.b(obj));
    }

    final int c(Object obj, int i) {
        return a(obj, i, this.h, this.j, this.a);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, (Object) null);
        Arrays.fill(this.h, -1);
        Arrays.fill(this.i, -1);
        Arrays.fill(this.j, 0, this.c, -1);
        Arrays.fill(this.k, 0, this.c, -1);
        Arrays.fill(this.m, 0, this.c, -1);
        Arrays.fill(this.f, 0, this.c, -1);
        this.c = 0;
        this.e = -2;
        this.l = -2;
        this.d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return e(obj) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.az
    public final az d() {
        az azVar = this.g;
        if (azVar != null) {
            return azVar;
        }
        dx dxVar = new dx(this);
        this.g = dxVar;
        return dxVar;
    }

    final int e(Object obj) {
        return f(obj, eh.b(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.p;
        if (set != null) {
            return set;
        }
        dw dwVar = new dw(this);
        this.p = dwVar;
        return dwVar;
    }

    final int f(Object obj, int i) {
        return a(obj, i, this.i, this.k, this.b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        int iB = b(obj);
        if (iB == -1) {
            return null;
        }
        return this.b[iB];
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Set values() {
        Set set = this.o;
        if (set != null) {
            return set;
        }
        ea eaVar = new ea(this);
        this.o = eaVar;
        return eaVar;
    }

    final void i(int i) {
        bs.d(16, "expectedSize");
        int iC = eh.c(16);
        this.c = 0;
        this.a = new Object[16];
        this.b = new Object[16];
        this.h = w(iC);
        this.i = w(iC);
        this.j = w(16);
        this.k = w(16);
        this.e = -2;
        this.l = -2;
        this.m = w(16);
        this.f = w(16);
    }

    final void j(int i, int i2) {
        u(i, i2, eh.b(this.b[i]));
    }

    final void k(int i, int i2) {
        u(i, eh.b(this.a[i]), i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f660n;
        if (set != null) {
            return set;
        }
        dz dzVar = new dz(this);
        this.f660n = dzVar;
        return dzVar;
    }

    final Object l(Object obj, Object obj2) {
        int iB = eh.b(obj);
        int iF = f(obj, iB);
        if (iF != -1) {
            Object obj3 = this.a[iF];
            if (com.google.android.libraries.navigation.internal.yx.am.a(obj3, obj2)) {
                return obj2;
            }
            m(iF, obj2);
            return obj3;
        }
        int i = this.l;
        int iB2 = eh.b(obj2);
        com.google.android.libraries.navigation.internal.yx.ar.f(c(obj2, iB2) == -1, "Key already present: %s", obj2);
        r(this.c + 1);
        Object[] objArr = this.a;
        int i2 = this.c;
        objArr[i2] = obj2;
        this.b[i2] = obj;
        s(i2, iB2);
        t(this.c, iB);
        int i3 = i == -2 ? this.e : this.f[i];
        v(i, this.c);
        v(this.c, i3);
        this.c++;
        this.d++;
        return null;
    }

    public final void m(int i, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        int iC = c(obj, eh.b(obj));
        int i2 = this.l;
        if (iC != -1) {
            throw new IllegalArgumentException("Key already present in map: ".concat(String.valueOf(String.valueOf(obj))));
        }
        if (i2 == i) {
            i2 = this.m[i];
        } else if (i2 == this.c) {
            i2 = iC;
        }
        if (i == -2) {
            iC = this.f[-2];
        } else if (this.c != -2) {
            iC = -2;
        }
        v(this.m[i], this.f[i]);
        p(i, eh.b(this.a[i]));
        this.a[i] = obj;
        s(i, eh.b(obj));
        v(i2, i);
        v(i, iC);
    }

    public final void n(int i, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i != -1);
        int iB = eh.b(obj);
        if (f(obj, iB) != -1) {
            throw new IllegalArgumentException("Value already present in map: ".concat(String.valueOf(String.valueOf(obj))));
        }
        q(i, eh.b(this.b[i]));
        this.b[i] = obj;
        t(i, iB);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.android.libraries.navigation.internal.yz.az
    public final Object put(Object obj, Object obj2) {
        int iB = eh.b(obj);
        int iC = c(obj, iB);
        if (iC != -1) {
            Object obj3 = this.b[iC];
            if (com.google.android.libraries.navigation.internal.yx.am.a(obj3, obj2)) {
                return obj2;
            }
            n(iC, obj2);
            return obj3;
        }
        int iB2 = eh.b(obj2);
        com.google.android.libraries.navigation.internal.yx.ar.f(f(obj2, iB2) == -1, "Value already present: %s", obj2);
        r(this.c + 1);
        Object[] objArr = this.a;
        int i = this.c;
        objArr[i] = obj;
        this.b[i] = obj2;
        s(i, iB);
        t(this.c, iB2);
        v(this.l, this.c);
        v(this.c, -2);
        this.c++;
        this.d++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        int iB = eh.b(obj);
        int iC = c(obj, iB);
        if (iC == -1) {
            return null;
        }
        Object obj2 = this.b[iC];
        j(iC, iB);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c;
    }

    private final void v(int i, int i2) {
        if (i == -2) {
            this.e = i2;
        } else {
            this.f[i] = i2;
        }
        if (i2 == -2) {
            this.l = i;
        } else {
            this.m[i2] = i;
        }
    }
}
