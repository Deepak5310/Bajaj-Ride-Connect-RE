package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class du extends h implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient Object[] b;
    protected transient long[] c;
    protected transient int d;
    protected transient boolean e;
    protected transient int f;
    protected transient int g;
    protected final transient int h;
    protected int i;
    protected transient dd j;
    protected transient hd k;
    protected transient com.google.android.libraries.navigation.internal.agh.gf l;

    public du() {
        this(16);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int i;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.i, 0.75f);
        this.f = iA;
        this.g = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        this.d = iA - 1;
        int i2 = iA + 1;
        Object[] objArr = new Object[i2];
        this.b = objArr;
        long[] jArr = new long[i2];
        this.c = jArr;
        int i3 = this.i;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            Object object = objectInputStream.readObject();
            long j = objectInputStream.readLong();
            if (object == null) {
                i = this.f;
                this.e = true;
            } else {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(object.hashCode());
                int i5 = this.d;
                while (true) {
                    i = iE & i5;
                    if (objArr[i] != null) {
                        iE = i + 1;
                        i5 = this.d;
                    }
                }
            }
            objArr[i] = object;
            jArr[i] = j;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] objArr = this.b;
        long[] jArr = this.c;
        di diVar = new di(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.i; i != 0; i--) {
            int iB = diVar.b();
            objectOutputStream.writeObject(objArr[iB]);
            objectOutputStream.writeLong(jArr[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final long c(Object obj) {
        Object obj2;
        if (obj != null) {
            Object[] objArr = this.b;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.d;
            Object obj3 = objArr[iE];
            if (obj3 != null) {
                if (obj.equals(obj3)) {
                    return r(iE);
                }
                do {
                    iE = (iE + 1) & this.d;
                    obj2 = objArr[iE];
                    if (obj2 != null) {
                    }
                } while (!obj.equals(obj2));
                return r(iE);
            }
        } else if (this.e) {
            return s();
        }
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final void clear() {
        if (this.i == 0) {
            return;
        }
        this.i = 0;
        this.e = false;
        Arrays.fill(this.b, (Object) null);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.e;
        }
        Object[] objArr = this.b;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.d;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (!obj.equals(obj3)) {
            do {
                iE = (iE + 1) & this.d;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!obj.equals(obj2));
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h
    /* JADX INFO: renamed from: e */
    public final com.google.android.libraries.navigation.internal.agh.gf values() {
        if (this.l == null) {
            this.l = new dh(this);
        }
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h
    /* JADX INFO: renamed from: g */
    public final hd keySet() {
        if (this.k == null) {
            this.k = new dm(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final int hashCode() {
        Object obj;
        int i;
        int iP = p();
        int i2 = 0;
        int i3 = 0;
        int iC = 0;
        while (iP != 0) {
            while (true) {
                obj = this.b[i2];
                i = i2 + 1;
                if (obj != null) {
                    break;
                }
                i2 = i;
            }
            if (this != obj) {
                iC = obj.hashCode();
            }
            iP--;
            iC ^= com.google.android.libraries.navigation.internal.agc.e.c(this.c[i2]);
            i3 += iC;
            i2 = i;
        }
        return this.e ? i3 + com.google.android.libraries.navigation.internal.agc.e.c(this.c[this.f]) : i3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final boolean isEmpty() {
        return this.i == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, com.google.android.libraries.navigation.internal.agi.de
    public final boolean m(long j) {
        long[] jArr = this.c;
        Object[] objArr = this.b;
        if (this.e && jArr[this.f] == j) {
            return true;
        }
        int i = this.f;
        while (i != 0) {
            i--;
            if (objArr[i] != null && jArr[i] == j) {
                return true;
            }
        }
        return false;
    }

    public final int p() {
        return this.e ? this.i - 1 : this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.i + map.size()) / 0.75f))));
        if (iMin > this.f) {
            v(iMin);
        }
        super.putAll(map);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cw
    public final long q(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.e ? this.c[this.f] : this.a;
        }
        Object[] objArr = this.b;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.d;
        Object obj3 = objArr[iE];
        if (obj3 != null) {
            if (obj.equals(obj3)) {
                return this.c[iE];
            }
            do {
                iE = (iE + 1) & this.d;
                obj2 = objArr[iE];
                if (obj2 != null) {
                }
            } while (!obj.equals(obj2));
            return this.c[iE];
        }
        return this.a;
    }

    public final long r(int i) {
        Object obj;
        long j = this.c[i];
        this.i--;
        Object[] objArr = this.b;
        loop0: while (true) {
            int i2 = (i + 1) & this.d;
            while (true) {
                obj = objArr[i2];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    int i3 = this.d;
                    int i4 = iE & i3;
                    if (i > i2) {
                        if (i >= i4 && i4 > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    } else {
                        if (i >= i4 || i4 > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    break loop0;
                }
            }
            objArr[i] = obj;
            long[] jArr = this.c;
            jArr[i] = jArr[i2];
            i = i2;
        }
        objArr[i] = null;
        int i5 = this.f;
        if (i5 > this.h && this.i < this.g / 4 && i5 > 16) {
            v(i5 >> 1);
        }
        return j;
    }

    public final long s() {
        this.e = false;
        Object[] objArr = this.b;
        int i = this.f;
        objArr[i] = null;
        long j = this.c[i];
        int i2 = this.i - 1;
        this.i = i2;
        if (i > this.h && i2 < this.g / 4 && i > 16) {
            v(i >> 1);
        }
        return j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* bridge */ /* synthetic */ hd t() {
        if (this.j == null) {
            this.j = new dp(this);
        }
        return this.j;
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final du clone() {
        try {
            du duVar = (du) super.clone();
            duVar.k = null;
            duVar.l = null;
            duVar.j = null;
            duVar.e = this.e;
            duVar.b = (Object[]) this.b.clone();
            duVar.c = (long[]) this.c.clone();
            return duVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void v(int i) {
        Object obj;
        int i2 = i + 1;
        Object[] objArr = this.b;
        long[] jArr = this.c;
        Object[] objArr2 = new Object[i2];
        long[] jArr2 = new long[i2];
        int i3 = this.f;
        int iP = p();
        while (true) {
            int i4 = i - 1;
            if (iP == 0) {
                jArr2[i] = jArr[this.f];
                this.f = i;
                this.d = i4;
                this.g = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.b = objArr2;
                this.c = jArr2;
                return;
            }
            do {
                i3--;
                obj = objArr[i3];
            } while (obj == null);
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & i4;
            if (objArr2[iE] != null) {
                do {
                    iE = (iE + 1) & i4;
                } while (objArr2[iE] != null);
            }
            objArr2[iE] = objArr[i3];
            jArr2[iE] = jArr[i3];
            iP--;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public du(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, 0.75f);
        this.f = iA;
        this.h = iA;
        this.d = iA - 1;
        this.g = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i2 = iA + 1;
        this.b = new Object[i2];
        this.c = new long[i2];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final long b(Object obj, long j) {
        int i;
        if (obj == null) {
            i = this.e ? this.f : -(this.f + 1);
        } else {
            Object[] objArr = this.b;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.d;
            Object obj2 = objArr[iE];
            if (obj2 != null) {
                if (!obj.equals(obj2)) {
                    while (true) {
                        iE = (iE + 1) & this.d;
                        Object obj3 = objArr[iE];
                        if (obj3 == null) {
                            i = -(iE + 1);
                        } else if (obj.equals(obj3)) {
                        }
                    }
                }
                i = iE;
            } else {
                i = -(iE + 1);
            }
        }
        if (i >= 0) {
            long[] jArr = this.c;
            long j2 = jArr[i];
            jArr[i] = j;
            return j2;
        }
        int i2 = (-i) - 1;
        if (i2 == this.f) {
            this.e = true;
        }
        this.b[i2] = obj;
        this.c[i2] = j;
        int i3 = this.i;
        this.i = i3 + 1;
        if (i3 >= this.g) {
            v(com.google.android.libraries.navigation.internal.agc.e.a(i3 + 2, 0.75f));
        }
        return this.a;
    }
}
