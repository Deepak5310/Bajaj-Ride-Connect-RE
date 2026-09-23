package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hd extends v implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient long[] a;
    protected transient int b;
    protected transient boolean c;
    protected transient int d;
    protected transient int e;
    protected final transient int f;
    protected int g;
    protected final float h;

    public hd() {
        this(16, null);
    }

    private final void q(long j) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil(j / this.h))));
        if (iMin > this.d) {
            p(iMin);
        }
    }

    private final void r(int i) {
        long j;
        this.g--;
        long[] jArr = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.b;
            while (true) {
                j = jArr[i2];
                if (j != 0) {
                    int i3 = this.b;
                    int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i3;
                    if (i > i2) {
                        if (i >= iG && iG > i2) {
                            break;
                        } else {
                            i2 = (i2 + 1) & i3;
                        }
                    } else if (i >= iG || iG > i2) {
                        break;
                    } else {
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    break loop0;
                }
            }
            jArr[i] = j;
            i = i2;
        }
        jArr[i] = 0;
        int i4 = this.d;
        if (i4 <= this.f || this.g >= this.e / 4 || i4 <= 16) {
            return;
        }
        p(i4 >> 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int iG;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.g, this.h);
        this.d = iA;
        this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, this.h);
        this.b = iA - 1;
        long[] jArr = new long[iA + 1];
        this.a = jArr;
        int i = this.g;
        while (true) {
            int i2 = i - 1;
            if (i == 0) {
                return;
            }
            long j = objectInputStream.readLong();
            if (j == 0) {
                iG = this.d;
                this.c = true;
            } else {
                iG = this.b & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
                if (jArr[iG] != 0) {
                    do {
                        iG = (iG + 1) & this.b;
                    } while (jArr[iG] != 0);
                }
            }
            jArr[iG] = j;
            i = i2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        hb hbVar = new hb(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.g; i != 0; i--) {
            objectOutputStream.writeLong(hbVar.nextLong());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: a */
    public final gs iterator() {
        return new hb(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new hc(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (this.g == 0) {
            return;
        }
        this.g = 0;
        this.c = false;
        Arrays.fill(this.a, 0L);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        long j2;
        if (j == 0) {
            return this.c;
        }
        long[] jArr = this.a;
        int iG = this.b & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return false;
        }
        if (j != j3) {
            do {
                iG = (iG + 1) & this.b;
                j2 = jArr[iG];
                if (j2 == 0) {
                    return false;
                }
            } while (j != j2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, java.util.Collection, java.util.Set
    public final int hashCode() {
        long j;
        int iC = 0;
        int i = 0;
        for (int iM = m(); iM != 0; iM--) {
            do {
                j = this.a[i];
                i++;
            } while (j == 0);
            iC += com.google.android.libraries.navigation.internal.agc.e.c(j);
        }
        return iC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.g == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator m() {
        return new hb(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v
    public final boolean l(long j) {
        long j2;
        if (j == 0) {
            if (!this.c) {
                return false;
            }
            this.c = false;
            long[] jArr = this.a;
            int i = this.d;
            jArr[i] = 0;
            int i2 = this.g - 1;
            this.g = i2;
            if (i > this.f && i2 < this.e / 4 && i > 16) {
                p(i >> 1);
            }
            return true;
        }
        long[] jArr2 = this.a;
        int iG = this.b & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr2[iG];
        if (j3 == 0) {
            return false;
        }
        if (j == j3) {
            r(iG);
            return true;
        }
        do {
            iG = (iG + 1) & this.b;
            j2 = jArr2[iG];
            if (j2 == 0) {
                return false;
            }
        } while (j != j2);
        r(iG);
        return true;
    }

    public final int m() {
        return this.c ? this.g - 1 : this.g;
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final hd clone() {
        try {
            hd hdVar = (hd) super.clone();
            hdVar.a = (long[]) this.a.clone();
            hdVar.c = this.c;
            return hdVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public final void o(int i) {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, this.h);
        if (iA > this.d) {
            p(iA);
        }
    }

    protected final void p(int i) {
        long j;
        long[] jArr = this.a;
        long[] jArr2 = new long[i + 1];
        int i2 = this.d;
        int iM = m();
        while (true) {
            int i3 = i - 1;
            if (iM == 0) {
                this.d = i;
                this.b = i3;
                this.e = com.google.android.libraries.navigation.internal.agc.e.d(i, this.h);
                this.a = jArr2;
                return;
            }
            do {
                i2--;
                j = jArr[i2];
            } while (j == 0);
            int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i3;
            if (jArr2[iG] != 0) {
                do {
                    iG = (iG + 1) & i3;
                } while (jArr2[iG] != 0);
            }
            jArr2[iG] = jArr[i2];
            iM--;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return new hc(this);
    }

    public hd(int i) {
        this(i, null);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (this.h <= 0.5d) {
            o(collection.size());
        } else {
            q(this.g + collection.size());
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean d(gf gfVar) {
        if (this.h <= 0.5d) {
            o(gfVar.size());
        } else {
            q(this.g + gfVar.size());
        }
        return super.d(gfVar);
    }

    public hd(int i, byte[] bArr) {
        if (i >= 0) {
            this.h = 0.75f;
            int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, 0.75f);
            this.d = iA;
            this.f = iA;
            this.b = iA - 1;
            this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
            this.a = new long[iA + 1];
            return;
        }
        throw new IllegalArgumentException("The expected number of elements must be nonnegative");
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean c(long j) {
        long j2;
        if (j != 0) {
            long[] jArr = this.a;
            int iG = this.b & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j3 = jArr[iG];
            if (j3 != 0) {
                if (j3 != j) {
                    do {
                        iG = (iG + 1) & this.b;
                        j2 = jArr[iG];
                        if (j2 != 0) {
                        }
                    } while (j2 != j);
                }
                return false;
            }
            jArr[iG] = j;
        } else {
            if (this.c) {
                return false;
            }
            this.c = true;
        }
        int i = this.g;
        this.g = i + 1;
        if (i >= this.e) {
            p(com.google.android.libraries.navigation.internal.agc.e.a(i + 2, this.h));
        }
        return true;
    }
}
