package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
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
public final class aq extends b implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient int[] a;
    protected transient int[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    protected int h;
    protected transient ez i;
    protected transient Cdo j;
    protected transient al k;

    public aq() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new int[i];
        this.b = new int[i];
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int i;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.h, 0.75f);
        this.e = iA;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        this.c = iA - 1;
        int i2 = iA + 1;
        int[] iArr = new int[i2];
        this.a = iArr;
        int[] iArr2 = new int[i2];
        this.b = iArr2;
        int i3 = this.h;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            int i5 = objectInputStream.readInt();
            int i6 = objectInputStream.readInt();
            if (i5 == 0) {
                i = this.e;
                this.d = true;
            } else {
                int i7 = this.c;
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(i5);
                while (true) {
                    i = i7 & iE;
                    if (iArr[i] != 0) {
                        i7 = i + 1;
                        iE = this.c;
                    }
                }
            }
            iArr[i] = i5;
            iArr2[i] = i6;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        ae aeVar = new ae(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iB = aeVar.b();
            objectOutputStream.writeInt(iArr[iB]);
            objectOutputStream.writeInt(iArr2[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public final int b(int i) {
        int i2;
        if (i == 0) {
            if (this.d) {
                return w();
            }
            return 0;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return 0;
        }
        if (i == i3) {
            return v(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            i2 = iArr[iE];
            if (i2 == 0) {
                return 0;
            }
        } while (i != i2);
        return v(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public final boolean d(int i) {
        int i2;
        if (i == 0) {
            return this.d;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return false;
        }
        if (i != i3) {
            do {
                iE = (iE + 1) & this.c;
                i2 = iArr[iE];
                if (i2 == 0) {
                    return false;
                }
            } while (i != i2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b
    /* JADX INFO: renamed from: e */
    public final Cdo values() {
        if (this.j == null) {
            this.j = new ad(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b
    /* JADX INFO: renamed from: f */
    public final ez keySet() {
        if (this.i == null) {
            this.i = new ai(this);
        }
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, java.util.Map
    public final int hashCode() {
        int i;
        int i2;
        int iU = u();
        int i3 = 0;
        int i4 = 0;
        while (iU != 0) {
            while (true) {
                i = this.a[i4];
                i2 = i4 + 1;
                if (i == 0) {
                    i4 = i2;
                }
            }
            i3 += this.b[i4] ^ i;
            iU--;
            i4 = i2;
        }
        return this.d ? i3 + this.b[this.e] : i3;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, com.google.android.libraries.navigation.internal.agg.aa
    public final boolean p(int i) {
        int[] iArr = this.b;
        int[] iArr2 = this.a;
        if (this.d && iArr[this.e] == i) {
            return true;
        }
        int i2 = this.e;
        while (i2 != 0) {
            i2--;
            if (iArr2[i2] != 0 && iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            y(iMin);
        }
        if (map instanceof aa) {
            gi giVarA = ac.a((aa) map);
            while (giVarA.hasNext()) {
                ak akVar = (ak) giVarA.next();
                a(akVar.a(), akVar.b());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            t.b(this, (Integer) entry.getKey(), (Integer) entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.u
    public final int s(int i) {
        int i2;
        if (i == 0) {
            if (this.d) {
                return this.b[this.e];
            }
            return 0;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return 0;
        }
        if (i == i3) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            i2 = iArr[iE];
            if (i2 == 0) {
                return 0;
            }
        } while (i != i2);
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* bridge */ /* synthetic */ hd t() {
        if (this.k == null) {
            this.k = new al(this);
        }
        return this.k;
    }

    public final int u() {
        return this.d ? this.h - 1 : this.h;
    }

    public final int v(int i) {
        int i2;
        int i3 = this.b[i];
        this.h--;
        int[] iArr = this.a;
        loop0: while (true) {
            int i4 = (i + 1) & this.c;
            while (true) {
                i2 = iArr[i4];
                if (i2 != 0) {
                    int i5 = this.c;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i5;
                    if (i > i4) {
                        if (i >= iE && iE > i4) {
                            break;
                        }
                        i4 = (i4 + 1) & i5;
                    } else {
                        if (i >= iE || iE > i4) {
                            break;
                        }
                        i4 = (i4 + 1) & i5;
                    }
                } else {
                    break loop0;
                }
            }
            iArr[i] = i2;
            int[] iArr2 = this.b;
            iArr2[i] = iArr2[i4];
            i = i4;
        }
        iArr[i] = 0;
        int i6 = this.e;
        if (i6 > this.g && this.h < this.f / 4 && i6 > 16) {
            y(i6 >> 1);
        }
        return i3;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.b, java.util.Map
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
    public final aq clone() {
        try {
            aq aqVar = (aq) super.clone();
            aqVar.i = null;
            aqVar.j = null;
            aqVar.k = null;
            aqVar.d = this.d;
            aqVar.a = (int[]) this.a.clone();
            aqVar.b = (int[]) this.b.clone();
            return aqVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void y(int i) {
        int i2;
        int i3 = i + 1;
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int i4 = this.e;
        int iU = u();
        while (true) {
            int i5 = i - 1;
            if (iU == 0) {
                iArr4[i] = iArr2[this.e];
                this.e = i;
                this.c = i5;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = iArr3;
                this.b = iArr4;
                return;
            }
            do {
                i4--;
                i2 = iArr[i4];
            } while (i2 == 0);
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i5;
            if (iArr3[iE] != 0) {
                do {
                    iE = (iE + 1) & i5;
                } while (iArr3[iE] != 0);
            }
            iArr3[iE] = iArr[i4];
            iArr4[iE] = iArr2[i4];
            iU--;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public final int a(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = this.d ? this.e : -(this.e + 1);
        } else {
            int[] iArr = this.a;
            int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
            int i4 = iArr[iE];
            if (i4 != 0) {
                if (i != i4) {
                    while (true) {
                        iE = (iE + 1) & this.c;
                        int i5 = iArr[iE];
                        if (i5 == 0) {
                            i3 = -(iE + 1);
                        } else if (i == i5) {
                        }
                    }
                }
                i3 = iE;
            } else {
                i3 = -(iE + 1);
            }
        }
        if (i3 >= 0) {
            int[] iArr2 = this.b;
            int i6 = iArr2[i3];
            iArr2[i3] = i2;
            return i6;
        }
        int i7 = (-i3) - 1;
        if (i7 == this.e) {
            this.d = true;
        }
        this.a[i7] = i;
        this.b[i7] = i2;
        int i8 = this.h;
        this.h = i8 + 1;
        if (i8 < this.f) {
            return 0;
        }
        y(com.google.android.libraries.navigation.internal.agc.e.a(i8 + 2, 0.75f));
        return 0;
    }
}
