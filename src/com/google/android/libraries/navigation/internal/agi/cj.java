package com.google.android.libraries.navigation.internal.agi;

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
public final class cj extends e implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient Object[] a;
    protected transient int[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    public int h;
    protected transient hd i;
    protected transient Cdo j;
    protected transient ce k;

    public cj() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new Object[i];
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
        Object[] objArr = new Object[i2];
        this.a = objArr;
        int[] iArr = new int[i2];
        this.b = iArr;
        int i3 = this.h;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            Object object = objectInputStream.readObject();
            int i5 = objectInputStream.readInt();
            if (object == null) {
                i = this.e;
                this.d = true;
            } else {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(object.hashCode());
                int i6 = this.c;
                while (true) {
                    i = iE & i6;
                    if (objArr[i] != null) {
                        iE = i + 1;
                        i6 = this.c;
                    }
                }
            }
            objArr[i] = object;
            iArr[i] = i5;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] objArr = this.a;
        int[] iArr = this.b;
        bx bxVar = new bx(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iB = bxVar.b();
            objectOutputStream.writeObject(objArr[iB]);
            objectOutputStream.writeInt(iArr[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agi.bk
    public final int b(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return s();
            }
            return 0;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return 0;
        }
        if (obj.equals(obj3)) {
            return r(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return 0;
            }
        } while (!obj.equals(obj2));
        return r(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, (Object) null);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.d;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (!obj.equals(obj3)) {
            do {
                iE = (iE + 1) & this.c;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!obj.equals(obj2));
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e
    /* JADX INFO: renamed from: d */
    public final Cdo values() {
        if (this.j == null) {
            this.j = new bw(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e
    /* JADX INFO: renamed from: f */
    public final hd keySet() {
        if (this.i == null) {
            this.i = new cb(this);
        }
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, java.util.Map
    public final int hashCode() {
        Object obj;
        int i;
        int iQ = q();
        int i2 = 0;
        int i3 = 0;
        int iHashCode = 0;
        while (iQ != 0) {
            while (true) {
                obj = this.a[i2];
                i = i2 + 1;
                if (obj != null) {
                    break;
                }
                i2 = i;
            }
            if (this != obj) {
                iHashCode = obj.hashCode();
            }
            iQ--;
            iHashCode ^= this.b[i2];
            i3 += iHashCode;
            i2 = i;
        }
        return this.d ? i3 + this.b[this.e] : i3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, com.google.android.libraries.navigation.internal.agi.bs
    public final boolean m(int i) {
        int[] iArr = this.b;
        Object[] objArr = this.a;
        if (this.d && iArr[this.e] == i) {
            return true;
        }
        int i2 = this.e;
        while (i2 != 0) {
            i2--;
            if (objArr[i2] != null && iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bk
    public final int o(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return this.b[this.e];
            }
            return 0;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return 0;
        }
        if (obj.equals(obj3)) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return 0;
            }
        } while (!obj.equals(obj2));
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* bridge */ /* synthetic */ hd p() {
        if (this.k == null) {
            this.k = new ce(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            u(iMin);
        }
        if (map instanceof bs) {
            gi giVarA = bv.a((bs) map);
            while (giVarA.hasNext()) {
                br brVar = (br) giVarA.next();
                a(brVar.getKey(), brVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            bj.b(this, entry.getKey(), (Integer) entry.getValue());
        }
    }

    public final int q() {
        return this.d ? this.h - 1 : this.h;
    }

    public final int r(int i) {
        Object obj;
        int i2 = this.b[i];
        this.h--;
        Object[] objArr = this.a;
        loop0: while (true) {
            int i3 = (i + 1) & this.c;
            while (true) {
                obj = objArr[i3];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    int i4 = this.c;
                    int i5 = iE & i4;
                    if (i > i3) {
                        if (i >= i5 && i5 > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    } else {
                        if (i >= i5 || i5 > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    break loop0;
                }
            }
            objArr[i] = obj;
            int[] iArr = this.b;
            iArr[i] = iArr[i3];
            i = i3;
        }
        objArr[i] = null;
        int i6 = this.e;
        if (i6 > this.g && this.h < this.f / 4 && i6 > 16) {
            u(i6 >> 1);
        }
        return i2;
    }

    public final int s() {
        this.d = false;
        Object[] objArr = this.a;
        int i = this.e;
        objArr[i] = null;
        int i2 = this.b[i];
        int i3 = this.h - 1;
        this.h = i3;
        if (i > this.g && i3 < this.f / 4 && i > 16) {
            u(i >> 1);
        }
        return i2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final cj clone() {
        try {
            cj cjVar = (cj) super.clone();
            cjVar.i = null;
            cjVar.j = null;
            cjVar.k = null;
            cjVar.d = this.d;
            cjVar.a = (Object[]) this.a.clone();
            cjVar.b = (int[]) this.b.clone();
            return cjVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void u(int i) {
        Object obj;
        int i2 = i + 1;
        Object[] objArr = this.a;
        int[] iArr = this.b;
        Object[] objArr2 = new Object[i2];
        int[] iArr2 = new int[i2];
        int i3 = this.e;
        int iQ = q();
        while (true) {
            int i4 = i - 1;
            if (iQ == 0) {
                iArr2[i] = iArr[this.e];
                this.e = i;
                this.c = i4;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = objArr2;
                this.b = iArr2;
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
            iArr2[iE] = iArr[i3];
            iQ--;
        }
    }

    public final void v(int i) {
        int iF = com.google.android.libraries.navigation.internal.agc.e.f((int) Math.ceil(i / 0.75f));
        if (iF >= this.e || this.h > com.google.android.libraries.navigation.internal.agc.e.d(iF, 0.75f)) {
            return;
        }
        try {
            u(iF);
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.e, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agi.bk
    public final int a(Object obj, int i) {
        int i2;
        if (obj == null) {
            i2 = this.d ? this.e : -(this.e + 1);
        } else {
            Object[] objArr = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
            Object obj2 = objArr[iE];
            if (obj2 != null) {
                if (!obj.equals(obj2)) {
                    while (true) {
                        iE = (iE + 1) & this.c;
                        Object obj3 = objArr[iE];
                        if (obj3 == null) {
                            i2 = -(iE + 1);
                        } else if (obj.equals(obj3)) {
                        }
                    }
                }
                i2 = iE;
            } else {
                i2 = -(iE + 1);
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
        this.a[i4] = obj;
        this.b[i4] = i;
        int i5 = this.h;
        this.h = i5 + 1;
        if (i5 < this.f) {
            return 0;
        }
        u(com.google.android.libraries.navigation.internal.agc.e.a(i5 + 2, 0.75f));
        return 0;
    }
}
