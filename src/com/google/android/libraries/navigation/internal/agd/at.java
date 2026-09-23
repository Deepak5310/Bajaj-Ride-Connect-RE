package com.google.android.libraries.navigation.internal.agd;

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
public final class at extends i implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient byte[] a;
    protected transient int b;
    protected transient boolean c;
    protected transient int d;
    protected transient int e;
    protected final transient int f;
    protected int g;
    protected final float h = 0.75f;

    public at() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.d = iA;
        this.f = iA;
        this.b = iA - 1;
        this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        this.a = new byte[iA + 1];
    }

    private final void p(long j) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil(j / this.h))));
        if (iMin > this.d) {
            o(iMin);
        }
    }

    private final void q(int i) {
        byte b;
        this.g--;
        byte[] bArr = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.b;
            while (true) {
                b = bArr[i2];
                if (b != 0) {
                    int i3 = this.b;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(b) & i3;
                    if (i > i2) {
                        if (i >= iE && iE > i2) {
                            break;
                        } else {
                            i2 = (i2 + 1) & i3;
                        }
                    } else if (i >= iE || iE > i2) {
                        break;
                    } else {
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    break loop0;
                }
            }
            bArr[i] = b;
            i = i2;
        }
        bArr[i] = 0;
        int i4 = this.d;
        if (i4 <= this.f || this.g >= this.e / 4 || i4 <= 16) {
            return;
        }
        o(i4 >> 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int iE;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.g, this.h);
        this.d = iA;
        this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, this.h);
        this.b = iA - 1;
        byte[] bArr = new byte[iA + 1];
        this.a = bArr;
        int i = this.g;
        while (true) {
            int i2 = i - 1;
            if (i == 0) {
                return;
            }
            byte b = objectInputStream.readByte();
            if (b == 0) {
                iE = this.d;
                this.c = true;
            } else {
                iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(b);
                if (bArr[iE] != 0) {
                    do {
                        iE = (iE + 1) & this.b;
                    } while (bArr[iE] != 0);
                }
            }
            bArr[iE] = b;
            i = i2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ar arVar = new ar(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.g; i != 0; i--) {
            objectOutputStream.writeByte(arVar.c());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.i, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    /* JADX INFO: renamed from: a */
    public final al iterator() {
        return new ar(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.i, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final be b() {
        return new as(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (this.g == 0) {
            return;
        }
        this.g = 0;
        this.c = false;
        Arrays.fill(this.a, (byte) 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean e(byte b) {
        byte b2;
        if (b == 0) {
            return this.c;
        }
        byte[] bArr = this.a;
        int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(b);
        byte b3 = bArr[iE];
        if (b3 == 0) {
            return false;
        }
        if (b != b3) {
            do {
                iE = (iE + 1) & this.b;
                b2 = bArr[iE];
                if (b2 == 0) {
                    return false;
                }
            } while (b != b2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.i, java.util.Collection, java.util.Set
    public final int hashCode() {
        byte b;
        int i = 0;
        int i2 = 0;
        for (int iL = l(); iL != 0; iL--) {
            do {
                b = this.a[i2];
                i2++;
            } while (b == 0);
            i += b;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.g == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.i, com.google.android.libraries.navigation.internal.agd.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new ar(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.i
    public final boolean k(byte b) {
        byte b2;
        if (b == 0) {
            if (!this.c) {
                return false;
            }
            this.c = false;
            byte[] bArr = this.a;
            int i = this.d;
            bArr[i] = 0;
            int i2 = this.g - 1;
            this.g = i2;
            if (i > this.f && i2 < this.e / 4 && i > 16) {
                o(i >> 1);
            }
            return true;
        }
        byte[] bArr2 = this.a;
        int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(b);
        byte b3 = bArr2[iE];
        if (b3 == 0) {
            return false;
        }
        if (b == b3) {
            q(iE);
            return true;
        }
        do {
            iE = (iE + 1) & this.b;
            b2 = bArr2[iE];
            if (b2 == 0) {
                return false;
            }
        } while (b != b2);
        q(iE);
        return true;
    }

    public final int l() {
        return this.c ? this.g - 1 : this.g;
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final at clone() {
        try {
            at atVar = (at) super.clone();
            atVar.a = (byte[]) this.a.clone();
            atVar.c = this.c;
            return atVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public final void n(int i) {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, this.h);
        if (iA > this.d) {
            o(iA);
        }
    }

    protected final void o(int i) {
        byte b;
        byte[] bArr = this.a;
        byte[] bArr2 = new byte[i + 1];
        int i2 = this.d;
        int iL = l();
        while (true) {
            int i3 = i - 1;
            if (iL == 0) {
                this.d = i;
                this.b = i3;
                this.e = com.google.android.libraries.navigation.internal.agc.e.d(i, this.h);
                this.a = bArr2;
                return;
            }
            do {
                i2--;
                b = bArr[i2];
            } while (b == 0);
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(b) & i3;
            if (bArr2[iE] != 0) {
                do {
                    iE = (iE + 1) & i3;
                } while (bArr2[iE] != 0);
            }
            bArr2[iE] = bArr[i2];
            iL--;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.i, com.google.android.libraries.navigation.internal.agd.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new as(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (this.h <= 0.5d) {
            n(collection.size());
        } else {
            p(this.g + collection.size());
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a
    public final boolean d(w wVar) {
        if (this.h <= 0.5d) {
            n(wVar.size());
        } else {
            p(this.g + wVar.size());
        }
        al it2 = wVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (c(it2.c())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean c(byte b) {
        byte b2;
        if (b != 0) {
            byte[] bArr = this.a;
            int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(b);
            byte b3 = bArr[iE];
            if (b3 != 0) {
                if (b3 != b) {
                    do {
                        iE = (iE + 1) & this.b;
                        b2 = bArr[iE];
                        if (b2 != 0) {
                        }
                    } while (b2 != b);
                }
                return false;
            }
            bArr[iE] = b;
        } else {
            if (this.c) {
                return false;
            }
            this.c = true;
        }
        int i = this.g;
        this.g = i + 1;
        if (i >= this.e) {
            o(com.google.android.libraries.navigation.internal.agc.e.a(i + 2, this.h));
        }
        return true;
    }
}
