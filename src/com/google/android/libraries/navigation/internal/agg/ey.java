package com.google.android.libraries.navigation.internal.agg;

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
public final class ey extends p implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient int[] a;
    protected transient int b;
    protected transient boolean c;
    protected transient int d;
    protected transient int e;
    protected final transient int f;
    protected int g;
    protected final float h;

    public ey() {
        this(16);
    }

    private final void r(long j) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil(j / this.h))));
        if (iMin > this.d) {
            q(iMin);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int iE;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.g, this.h);
        this.d = iA;
        this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, this.h);
        this.b = iA - 1;
        int[] iArr = new int[iA + 1];
        this.a = iArr;
        int i = this.g;
        while (true) {
            int i2 = i - 1;
            if (i == 0) {
                return;
            }
            int i3 = objectInputStream.readInt();
            if (i3 == 0) {
                iE = this.d;
                this.c = true;
            } else {
                iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i3);
                if (iArr[iE] != 0) {
                    do {
                        iE = (iE + 1) & this.b;
                    } while (iArr[iE] != 0);
                }
            }
            iArr[iE] = i3;
            i = i2;
        }
    }

    private final void s(int i) {
        int i2;
        this.g--;
        int[] iArr = this.a;
        loop0: while (true) {
            int i3 = (i + 1) & this.b;
            while (true) {
                i2 = iArr[i3];
                if (i2 != 0) {
                    int i4 = this.b;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i4;
                    if (i > i3) {
                        if (i >= iE && iE > i3) {
                            break;
                        } else {
                            i3 = (i3 + 1) & i4;
                        }
                    } else if (i >= iE || iE > i3) {
                        break;
                    } else {
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    break loop0;
                }
            }
            iArr[i] = i2;
            i = i3;
        }
        iArr[i] = 0;
        int i5 = this.d;
        if (i5 <= this.f || this.g >= this.e / 4 || i5 <= 16) {
            return;
        }
        q(i5 >> 1);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ew ewVar = new ew(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.g; i != 0; i--) {
            objectOutputStream.writeInt(ewVar.nextInt());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: a */
    public final ei iterator() {
        return new ew(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new ex(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (this.g == 0) {
            return;
        }
        this.g = 0;
        this.c = false;
        Arrays.fill(this.a, 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        int i2;
        if (i == 0) {
            return this.c;
        }
        int[] iArr = this.a;
        int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return false;
        }
        if (i != i3) {
            do {
                iE = (iE + 1) & this.b;
                i2 = iArr[iE];
                if (i2 == 0) {
                    return false;
                }
            } while (i != i2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (int iN = n(); iN != 0; iN--) {
            do {
                i = this.a[i3];
                i3++;
            } while (i == 0);
            i2 += i;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.g == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new ew(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p
    public final boolean m(int i) {
        int i2;
        if (i == 0) {
            if (!this.c) {
                return false;
            }
            this.c = false;
            int[] iArr = this.a;
            int i3 = this.d;
            iArr[i3] = 0;
            int i4 = this.g - 1;
            this.g = i4;
            if (i3 > this.f && i4 < this.e / 4 && i3 > 16) {
                q(i3 >> 1);
            }
            return true;
        }
        int[] iArr2 = this.a;
        int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i5 = iArr2[iE];
        if (i5 == 0) {
            return false;
        }
        if (i == i5) {
            s(iE);
            return true;
        }
        do {
            iE = (iE + 1) & this.b;
            i2 = iArr2[iE];
            if (i2 == 0) {
                return false;
            }
        } while (i != i2);
        s(iE);
        return true;
    }

    public final int n() {
        return this.c ? this.g - 1 : this.g;
    }

    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final ey clone() {
        try {
            ey eyVar = (ey) super.clone();
            eyVar.a = (int[]) this.a.clone();
            eyVar.c = this.c;
            return eyVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public final void p(int i) {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, this.h);
        if (iA > this.d) {
            q(iA);
        }
    }

    protected final void q(int i) {
        int i2;
        int[] iArr = this.a;
        int[] iArr2 = new int[i + 1];
        int i3 = this.d;
        int iN = n();
        while (true) {
            int i4 = i - 1;
            if (iN == 0) {
                this.d = i;
                this.b = i4;
                this.e = com.google.android.libraries.navigation.internal.agc.e.d(i, this.h);
                this.a = iArr2;
                return;
            }
            do {
                i3--;
                i2 = iArr[i3];
            } while (i2 == 0);
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i4;
            if (iArr2[iE] != 0) {
                do {
                    iE = (iE + 1) & i4;
                } while (iArr2[iE] != 0);
            }
            iArr2[iE] = iArr[i3];
            iN--;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new ex(this);
    }

    public ey(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.h = 0.75f;
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, 0.75f);
        this.d = iA;
        this.f = iA;
        this.b = iA - 1;
        this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        this.a = new int[iA + 1];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (this.h <= 0.5d) {
            p(collection.size());
        } else {
            r(this.g + collection.size());
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean e(Cdo cdo) {
        if (this.h <= 0.5d) {
            p(cdo.size());
        } else {
            r(this.g + cdo.size());
        }
        return super.e(cdo);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public final boolean c(int i) {
        int i2;
        if (i != 0) {
            int[] iArr = this.a;
            int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i);
            int i3 = iArr[iE];
            if (i3 != 0) {
                if (i3 != i) {
                    do {
                        iE = (iE + 1) & this.b;
                        i2 = iArr[iE];
                        if (i2 != 0) {
                        }
                    } while (i2 != i);
                }
                return false;
            }
            iArr[iE] = i;
        } else {
            if (this.c) {
                return false;
            }
            this.c = true;
        }
        int i4 = this.g;
        this.g = i4 + 1;
        if (i4 >= this.e) {
            q(com.google.android.libraries.navigation.internal.agc.e.a(i4 + 2, this.h));
        }
        return true;
    }

    public ey(Collection collection) {
        this(collection.size());
        addAll(collection);
    }
}
