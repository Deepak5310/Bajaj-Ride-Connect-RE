package com.google.android.libraries.navigation.internal.agh;

import com.google.android.libraries.navigation.internal.agg.Cdo;
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
public final class bu extends e implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient long[] a;
    protected transient int[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    public int h;
    protected transient bd i;
    protected transient he j;
    protected transient Cdo k;

    public bu() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new long[i];
        this.b = new int[i];
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
        int[] iArr = new int[i3];
        this.b = iArr;
        int i4 = this.h;
        while (true) {
            int i5 = i4 - 1;
            if (i4 == 0) {
                return;
            }
            long j = objectInputStream.readLong();
            int i6 = objectInputStream.readInt();
            if (j == 0) {
                i2 = this.e;
                this.d = true;
            } else {
                int i7 = this.c;
                int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                while (true) {
                    i = i7 & iG;
                    if (jArr[i] == 0) {
                        break;
                    }
                    i7 = i + 1;
                    iG = this.c;
                }
                i2 = i;
            }
            jArr[i2] = j;
            iArr[i2] = i6;
            i4 = i5;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        long[] jArr = this.a;
        int[] iArr = this.b;
        bi biVar = new bi(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iB = biVar.b();
            objectOutputStream.writeLong(jArr[iB]);
            objectOutputStream.writeInt(iArr[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public final int b(long j) {
        long j2;
        if (j == 0) {
            if (this.d) {
                return w();
            }
            return 0;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return 0;
        }
        if (j == j3) {
            return v(iG);
        }
        do {
            iG = (iG + 1) & this.c;
            j2 = jArr[iG];
            if (j2 == 0) {
                return 0;
            }
        } while (j != j2);
        return v(iG);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, 0L);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public final boolean d(long j) {
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

    @Override // com.google.android.libraries.navigation.internal.agh.e
    /* JADX INFO: renamed from: e */
    public final Cdo values() {
        if (this.k == null) {
            this.k = new bh(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e
    /* JADX INFO: renamed from: f */
    public final he keySet() {
        if (this.j == null) {
            this.j = new bm(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, java.util.Map
    public final int hashCode() {
        long j;
        int i;
        int iU = u();
        int iC = 0;
        int i2 = 0;
        while (iU != 0) {
            while (true) {
                j = this.a[i2];
                i = i2 + 1;
                if (j == 0) {
                    i2 = i;
                }
            }
            iU--;
            iC += this.b[i2] ^ com.google.android.libraries.navigation.internal.agc.e.c(j);
            i2 = i;
        }
        return this.d ? iC + this.b[this.e] : iC;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, com.google.android.libraries.navigation.internal.agh.be
    public final boolean p(int i) {
        int[] iArr = this.b;
        long[] jArr = this.a;
        if (this.d && iArr[this.e] == i) {
            return true;
        }
        int i2 = this.e;
        while (i2 != 0) {
            i2--;
            if (jArr[i2] != 0 && iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            y(iMin);
        }
        if (map instanceof be) {
            com.google.android.libraries.navigation.internal.agi.gi giVarA = bg.a((be) map);
            while (giVarA.hasNext()) {
                bo boVar = (bo) giVarA.next();
                a(boVar.b(), boVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            aw.b(this, (Long) entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ax
    public final int s(long j) {
        long j2;
        if (j == 0) {
            if (this.d) {
                return this.b[this.e];
            }
            return 0;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return 0;
        }
        if (j == j3) {
            return this.b[iG];
        }
        do {
            iG = (iG + 1) & this.c;
            j2 = jArr[iG];
            if (j2 == 0) {
                return 0;
            }
        } while (j != j2);
        return this.b[iG];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd t() {
        if (this.i == null) {
            this.i = new bp(this);
        }
        return this.i;
    }

    public final int u() {
        return this.d ? this.h - 1 : this.h;
    }

    public final int v(int i) {
        long j;
        int i2 = this.b[i];
        this.h--;
        long[] jArr = this.a;
        loop0: while (true) {
            int i3 = (i + 1) & this.c;
            while (true) {
                j = jArr[i3];
                if (j != 0) {
                    int i4 = this.c;
                    int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i4;
                    if (i > i3) {
                        if (i >= iG && iG > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    } else {
                        if (i >= iG || iG > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    break loop0;
                }
            }
            jArr[i] = j;
            int[] iArr = this.b;
            iArr[i] = iArr[i3];
            i = i3;
        }
        jArr[i] = 0;
        int i5 = this.e;
        if (i5 > this.g && this.h < this.f / 4 && i5 > 16) {
            y(i5 >> 1);
        }
        return i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.e, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public final int w() {
        this.d = false;
        int[] iArr = this.b;
        int i = this.e;
        int i2 = iArr[i];
        int i3 = this.h - 1;
        this.h = i3;
        if (i > this.g && i3 < this.f / 4 && i > 16) {
            y(i >> 1);
        }
        return i2;
    }

    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final bu clone() {
        try {
            bu buVar = (bu) super.clone();
            buVar.j = null;
            buVar.k = null;
            buVar.i = null;
            buVar.d = this.d;
            buVar.a = (long[]) this.a.clone();
            buVar.b = (int[]) this.b.clone();
            return buVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void y(int i) {
        long j;
        int i2 = i + 1;
        long[] jArr = this.a;
        int[] iArr = this.b;
        long[] jArr2 = new long[i2];
        int[] iArr2 = new int[i2];
        int i3 = this.e;
        int iU = u();
        while (true) {
            int i4 = i - 1;
            if (iU == 0) {
                iArr2[i] = iArr[this.e];
                this.e = i;
                this.c = i4;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = jArr2;
                this.b = iArr2;
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
            iArr2[iG] = iArr[i3];
            iU--;
        }
    }

    public final void z(int i) {
        int iF = com.google.android.libraries.navigation.internal.agc.e.f((int) Math.ceil(i / 0.75f));
        if (iF >= this.e || this.h > com.google.android.libraries.navigation.internal.agc.e.d(iF, 0.75f)) {
            return;
        }
        try {
            y(iF);
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public final int a(long j, int i) {
        int i2;
        if (j == 0) {
            i2 = this.d ? this.e : -(this.e + 1);
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
                            i2 = -(iG + 1);
                        } else if (j == j3) {
                        }
                    }
                }
                i2 = iG;
            } else {
                i2 = -(iG + 1);
            }
        }
        if (i2 >= 0) {
            int[] iArr = this.b;
            int i3 = iArr[i2];
            iArr[i2] = i;
            return i3;
        }
        int i4 = (-i2) - 1;
        if (i4 == this.e) {
            this.d = true;
        }
        this.a[i4] = j;
        this.b[i4] = i;
        int i5 = this.h;
        this.h = i5 + 1;
        if (i5 < this.f) {
            return 0;
        }
        y(com.google.android.libraries.navigation.internal.agc.e.a(i5 + 2, 0.75f));
        return 0;
    }
}
