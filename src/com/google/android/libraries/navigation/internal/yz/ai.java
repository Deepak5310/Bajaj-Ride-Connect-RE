package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ai extends aq implements Serializable {
    private static final long serialVersionUID = 0;
    transient ll a = g();
    transient long b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        this.a = g();
        for (int i2 = 0; i2 < i; i2++) {
            a(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(m().size());
        for (kt ktVar : m()) {
            objectOutputStream.writeObject(ktVar.b());
            objectOutputStream.writeInt(ktVar.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final int a(Object obj, int i) {
        long j;
        if (i == 0) {
            return b(obj);
        }
        com.google.android.libraries.navigation.internal.yx.ar.d(i > 0, "occurrences cannot be negative: %s", i);
        int iE = this.a.e(obj);
        if (iE != -1) {
            long j2 = i;
            int iC = this.a.c(iE);
            long j3 = ((long) iC) + j2;
            com.google.android.libraries.navigation.internal.yx.ar.e(j3 <= 2147483647L, "too many occurrences: %s", j3);
            this.a.p(iE, (int) j3);
            this.b += j2;
            return iC;
        }
        ll llVar = this.a;
        bs.b(i, "count");
        long[] jArr = llVar.f;
        Object[] objArr = llVar.a;
        int[] iArr = llVar.b;
        int iB = eh.b(obj);
        int iD = llVar.d() & iB;
        int i2 = llVar.c;
        int[] iArr2 = llVar.e;
        int i3 = iArr2[iD];
        if (i3 != -1) {
            while (true) {
                long j4 = jArr[i3];
                if (ll.b(j4) == iB && com.google.android.libraries.navigation.internal.yx.am.a(obj, objArr[i3])) {
                    j = i;
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                } else {
                    int i5 = (int) j4;
                    if (i5 == -1) {
                        jArr[i3] = ll.j(j4, i2);
                        break;
                    }
                    i3 = i5;
                }
                this.b += j;
                return 0;
            }
        }
        iArr2[iD] = i2;
        if (i2 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        long j5 = i;
        int i6 = i2 + 1;
        int length = llVar.f.length;
        if (i6 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                llVar.o(iMax);
            }
        }
        llVar.m(i2, obj, i, iB);
        llVar.c = i6;
        if (i2 >= llVar.h) {
            int length2 = llVar.e.length;
            int i7 = length2 + length2;
            if (length2 >= 1073741824) {
                llVar.h = Integer.MAX_VALUE;
            } else {
                int i8 = ((int) (i7 * llVar.g)) + 1;
                int[] iArrQ = ll.q(i7);
                long[] jArr2 = llVar.f;
                int length3 = iArrQ.length - 1;
                for (int i9 = 0; i9 < llVar.c; i9++) {
                    int iB2 = ll.b(jArr2[i9]);
                    int i10 = iB2 & length3;
                    int i11 = iArrQ[i10];
                    iArrQ[i10] = i9;
                    jArr2[i9] = (((long) i11) & 4294967295L) | (((long) iB2) << 32);
                }
                llVar.h = i8;
                llVar.e = iArrQ;
            }
        }
        llVar.d++;
        j = j5;
        this.b += j;
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ku
    public final int b(Object obj) {
        ll llVar = this.a;
        int iE = llVar.e(obj);
        if (iE == -1) {
            return 0;
        }
        return llVar.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final int c() {
        return this.a.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.l();
        this.b = 0L;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final int d(Object obj, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.d(true, "occurrences cannot be negative: %s", i);
        int iE = this.a.e(obj);
        if (iE == -1) {
            return 0;
        }
        int iC = this.a.c(iE);
        if (iC > i) {
            this.a.p(iE, iC - i);
        } else {
            this.a.i(iE);
            i = iC;
        }
        this.b -= (long) i;
        return iC;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final Iterator e() {
        return new af(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final Iterator f() {
        return new ag(this);
    }

    public abstract ll g();

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final void h(Object obj) {
        bs.d(0, "count");
        this.b += (long) (-this.a.h(obj, eh.b(obj)));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final boolean i(Object obj, int i) {
        bs.d(i, "oldCount");
        bs.d(0, "newCount");
        int iE = this.a.e(obj);
        if (iE == -1) {
            return i == 0;
        }
        if (this.a.c(iE) != i) {
            return false;
        }
        this.a.i(iE);
        this.b -= (long) i;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return la.a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.yz.ku
    public final int size() {
        return com.google.android.libraries.navigation.internal.zy.i.e(this.b);
    }
}
