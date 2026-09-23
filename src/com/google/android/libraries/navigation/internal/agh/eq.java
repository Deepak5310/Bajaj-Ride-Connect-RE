package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eq extends j implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient long[] a;
    protected transient Object[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    protected int h;
    protected transient dz i;
    protected transient he j;
    protected transient com.google.android.libraries.navigation.internal.agi.gf k;

    public eq() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new long[i];
        this.b = new Object[i];
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int i;
        int i2;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.h, 0.75f);
        this.e = iA;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        this.c = iA - 1;
        int i3 = iA + 1;
        long[] jArr = new long[i3];
        this.a = jArr;
        Object[] objArr = new Object[i3];
        this.b = objArr;
        int i4 = this.h;
        while (true) {
            int i5 = i4 - 1;
            if (i4 == 0) {
                return;
            }
            long j = objectInputStream.readLong();
            Object object = objectInputStream.readObject();
            if (j == 0) {
                i2 = this.e;
                this.d = true;
            } else {
                int i6 = this.c;
                int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                while (true) {
                    i = i6 & iG;
                    if (jArr[i] == 0) {
                        break;
                    }
                    i6 = i + 1;
                    iG = this.c;
                }
                i2 = i;
            }
            jArr[i2] = j;
            objArr[i2] = object;
            i4 = i5;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        long[] jArr = this.a;
        Object[] objArr = this.b;
        ee eeVar = new ee(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iB = eeVar.b();
            objectOutputStream.writeLong(jArr[iB]);
            objectOutputStream.writeObject(objArr[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.di
    public final Object aO(long j) {
        long j2;
        if (j == 0) {
            if (this.d) {
                return this.b[this.e];
            }
            return null;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return null;
        }
        if (j == j3) {
            return this.b[iG];
        }
        do {
            iG = (iG + 1) & this.c;
            j2 = jArr[iG];
            if (j2 == 0) {
                return null;
            }
        } while (j != j2);
        return this.b[iG];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final Object b(long j) {
        long j2;
        if (j == 0) {
            if (this.d) {
                return m();
            }
            return null;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return null;
        }
        if (j == j3) {
            return j(iG);
        }
        do {
            iG = (iG + 1) & this.c;
            j2 = jArr[iG];
            if (j2 == 0) {
                return null;
            }
        } while (j != j2);
        return j(iG);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final boolean c(long j) {
        long j2;
        if (j == 0) {
            return this.d;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return false;
        }
        if (j != j3) {
            do {
                iG = (iG + 1) & this.c;
                j2 = jArr[iG];
                if (j2 == 0) {
                    return false;
                }
            } while (j != j2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, 0L);
        Arrays.fill(this.b, (Object) null);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final boolean containsValue(Object obj) {
        Object[] objArr = this.b;
        long[] jArr = this.a;
        if (this.d && Objects.equals(objArr[this.e], obj)) {
            return true;
        }
        int i = this.e;
        while (i != 0) {
            i--;
            if (jArr[i] != 0 && Objects.equals(objArr[i], obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: d */
    public final he keySet() {
        if (this.j == null) {
            this.j = new ei(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: e */
    public final com.google.android.libraries.navigation.internal.agi.gf values() {
        if (this.k == null) {
            this.k = new ed(this);
        }
        return this.k;
    }

    public final int h() {
        return this.d ? this.h - 1 : this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final int hashCode() {
        long j;
        int i;
        int iH = h();
        int i2 = 0;
        int i3 = 0;
        while (iH != 0) {
            while (true) {
                j = this.a[i2];
                i = i2 + 1;
                if (j != 0) {
                    break;
                }
                i2 = i;
            }
            Object obj = this.b[i2];
            int iC = com.google.android.libraries.navigation.internal.agc.e.c(j);
            if (this != obj) {
                iC ^= obj == null ? 0 : obj.hashCode();
            }
            i3 += iC;
            iH--;
            i2 = i;
        }
        if (!this.d) {
            return i3;
        }
        Object obj2 = this.b[this.e];
        return i3 + (obj2 != null ? obj2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final eq clone() {
        try {
            eq eqVar = (eq) super.clone();
            eqVar.j = null;
            eqVar.k = null;
            eqVar.i = null;
            eqVar.d = this.d;
            eqVar.a = (long[]) this.a.clone();
            eqVar.b = (Object[]) this.b.clone();
            return eqVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    public final Object j(int i) {
        long j;
        Object[] objArr = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.h--;
        long[] jArr = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.c;
            while (true) {
                j = jArr[i2];
                if (j != 0) {
                    int i3 = this.c;
                    int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i3;
                    if (i > i2) {
                        if (i >= iG && iG > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    } else {
                        if (i >= iG || iG > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    break loop0;
                }
            }
            jArr[i] = j;
            Object[] objArr2 = this.b;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        jArr[i] = 0;
        this.b[i] = null;
        int i4 = this.e;
        if (i4 > this.g && this.h < this.f / 4 && i4 > 16) {
            n(i4 >> 1);
        }
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd l() {
        if (this.i == null) {
            this.i = new el(this);
        }
        return this.i;
    }

    public final Object m() {
        this.d = false;
        Object[] objArr = this.b;
        int i = this.e;
        Object obj = objArr[i];
        objArr[i] = null;
        int i2 = this.h - 1;
        this.h = i2;
        if (i > this.g && i2 < this.f / 4 && i > 16) {
            n(i >> 1);
        }
        return obj;
    }

    protected final void n(int i) {
        long j;
        int i2 = i + 1;
        long[] jArr = this.a;
        Object[] objArr = this.b;
        long[] jArr2 = new long[i2];
        Object[] objArr2 = new Object[i2];
        int i3 = this.e;
        int iH = h();
        while (true) {
            int i4 = i - 1;
            if (iH == 0) {
                objArr2[i] = objArr[this.e];
                this.e = i;
                this.c = i4;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = jArr2;
                this.b = objArr2;
                return;
            }
            do {
                i3--;
                j = jArr[i3];
            } while (j == 0);
            int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i4;
            if (jArr2[iG] != 0) {
                do {
                    iG = (iG + 1) & i4;
                } while (jArr2[iG] != 0);
            }
            jArr2[iG] = jArr[i3];
            objArr2[iG] = objArr[i3];
            iH--;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            n(iMin);
        }
        super.putAll(map);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final Object a(long j, Object obj) {
        int i;
        if (j == 0) {
            i = this.d ? this.e : -(this.e + 1);
        } else {
            long[] jArr = this.a;
            int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j2 = jArr[iG];
            if (j2 != 0) {
                if (j != j2) {
                    while (true) {
                        iG = (iG + 1) & this.c;
                        long j3 = jArr[iG];
                        if (j3 == 0) {
                            i = -(iG + 1);
                        } else if (j == j3) {
                        }
                    }
                }
                i = iG;
            } else {
                i = -(iG + 1);
            }
        }
        if (i >= 0) {
            Object[] objArr = this.b;
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2;
        }
        int i2 = (-i) - 1;
        if (i2 == this.e) {
            this.d = true;
        }
        this.a[i2] = j;
        this.b[i2] = obj;
        int i3 = this.h;
        this.h = i3 + 1;
        if (i3 < this.f) {
            return null;
        }
        n(com.google.android.libraries.navigation.internal.agc.e.a(i3 + 2, 0.75f));
        return null;
    }
}
