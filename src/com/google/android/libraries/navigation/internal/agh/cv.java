package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cv extends g implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient long[] b;
    protected transient long[] c;
    protected transient int d;
    protected transient boolean e;
    protected transient int f;
    protected transient int g;
    protected final transient int h;
    protected int i;
    protected transient he j;
    protected transient gf k;
    protected transient cq l;

    public cv() {
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
        long[] jArr = new long[i2];
        this.b = jArr;
        long[] jArr2 = new long[i2];
        this.c = jArr2;
        int i3 = this.i;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            long j = objectInputStream.readLong();
            long j2 = objectInputStream.readLong();
            if (j == 0) {
                i = this.f;
                this.e = true;
            } else {
                int i5 = this.d;
                int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                while (true) {
                    i = i5 & iG;
                    if (jArr[i] != 0) {
                        i5 = i + 1;
                        iG = this.d;
                    }
                }
            }
            jArr[i] = j;
            jArr2[i] = j2;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        long[] jArr = this.b;
        long[] jArr2 = this.c;
        cj cjVar = new cj(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.i; i != 0; i--) {
            int iB = cjVar.b();
            objectOutputStream.writeLong(jArr[iB]);
            objectOutputStream.writeLong(jArr2[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final cq u() {
        if (this.l == null) {
            this.l = new cq(this);
        }
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final long c(long j) {
        long j2;
        if (j != 0) {
            long[] jArr = this.b;
            int iG = this.d & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j3 = jArr[iG];
            if (j3 != 0) {
                if (j == j3) {
                    return w(iG);
                }
                do {
                    iG = (iG + 1) & this.d;
                    j2 = jArr[iG];
                    if (j2 != 0) {
                    }
                } while (j != j2);
                return w(iG);
            }
        } else if (this.e) {
            return x();
        }
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, java.util.Map
    public final void clear() {
        if (this.i == 0) {
            return;
        }
        this.i = 0;
        this.e = false;
        Arrays.fill(this.b, 0L);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final boolean e(long j) {
        long j2;
        if (j == 0) {
            return this.e;
        }
        long[] jArr = this.b;
        int iG = this.d & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return false;
        }
        if (j != j3) {
            do {
                iG = (iG + 1) & this.d;
                j2 = jArr[iG];
                if (j2 == 0) {
                    return false;
                }
            } while (j != j2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: f */
    public final gf values() {
        if (this.k == null) {
            this.k = new ci(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: g */
    public final he keySet() {
        if (this.j == null) {
            this.j = new cn(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, java.util.Map
    public final int hashCode() {
        long j;
        int i;
        int iV = v();
        int iC = 0;
        int i2 = 0;
        while (iV != 0) {
            while (true) {
                j = this.b[i2];
                i = i2 + 1;
                if (j == 0) {
                    i2 = i;
                }
            }
            iV--;
            iC += com.google.android.libraries.navigation.internal.agc.e.c(this.c[i2]) ^ com.google.android.libraries.navigation.internal.agc.e.c(j);
            i2 = i;
        }
        return this.e ? iC + com.google.android.libraries.navigation.internal.agc.e.c(this.c[this.f]) : iC;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, java.util.Map
    public final boolean isEmpty() {
        return this.i == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.i + map.size()) / 0.75f))));
        if (iMin > this.f) {
            z(iMin);
        }
        if (map instanceof ce) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = ch.a((ce) map);
            while (giVarA.hasNext()) {
                cp cpVar = (cp) giVarA.next();
                b(cpVar.a(), cpVar.b());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            bw.b(this, (Long) entry.getKey(), (Long) entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, com.google.android.libraries.navigation.internal.agh.ce
    public final boolean r(long j) {
        long[] jArr = this.c;
        long[] jArr2 = this.b;
        if (this.e && jArr[this.f] == j) {
            return true;
        }
        int i = this.f;
        while (i != 0) {
            i--;
            if (jArr2[i] != 0 && jArr[i] == j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bx
    public final long t(long j) {
        long j2;
        if (j == 0) {
            return this.e ? this.c[this.f] : this.a;
        }
        long[] jArr = this.b;
        int iG = this.d & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 != 0) {
            if (j == j3) {
                return this.c[iG];
            }
            do {
                iG = (iG + 1) & this.d;
                j2 = jArr[iG];
                if (j2 != 0) {
                }
            } while (j != j2);
            return this.c[iG];
        }
        return this.a;
    }

    public final int v() {
        return this.e ? this.i - 1 : this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.g, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public final long w(int i) {
        long j;
        long j2 = this.c[i];
        this.i--;
        long[] jArr = this.b;
        loop0: while (true) {
            int i2 = (i + 1) & this.d;
            while (true) {
                j = jArr[i2];
                if (j != 0) {
                    int i3 = this.d;
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
            long[] jArr2 = this.c;
            jArr2[i] = jArr2[i2];
            i = i2;
        }
        jArr[i] = 0;
        int i4 = this.f;
        if (i4 > this.h && this.i < this.g / 4 && i4 > 16) {
            z(i4 >> 1);
        }
        return j2;
    }

    public final long x() {
        this.e = false;
        long[] jArr = this.c;
        int i = this.f;
        long j = jArr[i];
        int i2 = this.i - 1;
        this.i = i2;
        if (i > this.h && i2 < this.g / 4 && i > 16) {
            z(i >> 1);
        }
        return j;
    }

    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final cv clone() {
        try {
            cv cvVar = (cv) super.clone();
            cvVar.j = null;
            cvVar.k = null;
            cvVar.l = null;
            cvVar.e = this.e;
            cvVar.b = (long[]) this.b.clone();
            cvVar.c = (long[]) this.c.clone();
            return cvVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void z(int i) {
        long j;
        int i2 = i + 1;
        long[] jArr = this.b;
        long[] jArr2 = this.c;
        long[] jArr3 = new long[i2];
        long[] jArr4 = new long[i2];
        int i3 = this.f;
        int iV = v();
        while (true) {
            int i4 = i - 1;
            if (iV == 0) {
                jArr4[i] = jArr2[this.f];
                this.f = i;
                this.d = i4;
                this.g = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.b = jArr3;
                this.c = jArr4;
                return;
            }
            do {
                i3--;
                j = jArr[i3];
            } while (j == 0);
            int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i4;
            if (jArr3[iG] != 0) {
                do {
                    iG = (iG + 1) & i4;
                } while (jArr3[iG] != 0);
            }
            jArr3[iG] = jArr[i3];
            jArr4[iG] = jArr2[i3];
            iV--;
        }
    }

    public cv(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, 0.75f);
        this.f = iA;
        this.h = iA;
        this.d = iA - 1;
        this.g = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i2 = iA + 1;
        this.b = new long[i2];
        this.c = new long[i2];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final long b(long j, long j2) {
        int i;
        if (j == 0) {
            i = this.e ? this.f : -(this.f + 1);
        } else {
            long[] jArr = this.b;
            int iG = this.d & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j3 = jArr[iG];
            if (j3 != 0) {
                if (j != j3) {
                    while (true) {
                        iG = (iG + 1) & this.d;
                        long j4 = jArr[iG];
                        if (j4 == 0) {
                            i = -(iG + 1);
                        } else if (j == j4) {
                        }
                    }
                }
                i = iG;
            } else {
                i = -(iG + 1);
            }
        }
        if (i >= 0) {
            long[] jArr2 = this.c;
            long j5 = jArr2[i];
            jArr2[i] = j2;
            return j5;
        }
        int i2 = (-i) - 1;
        if (i2 == this.f) {
            this.e = true;
        }
        this.b[i2] = j;
        this.c[i2] = j2;
        int i3 = this.i;
        this.i = i3 + 1;
        if (i3 >= this.g) {
            z(com.google.android.libraries.navigation.internal.agc.e.a(i3 + 2, 0.75f));
        }
        return this.a;
    }
}
