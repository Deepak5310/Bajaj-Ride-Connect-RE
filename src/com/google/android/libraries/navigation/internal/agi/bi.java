package com.google.android.libraries.navigation.internal.agi;

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
public final class bi extends b implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient Object[] a;
    protected transient float[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    protected int h;
    protected transient hd i;
    protected transient com.google.android.libraries.navigation.internal.agf.l j;
    protected transient bd k;

    public bi() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new Object[i];
        this.b = new float[i];
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
        float[] fArr = new float[i2];
        this.b = fArr;
        int i3 = this.h;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            Object object = objectInputStream.readObject();
            float f = objectInputStream.readFloat();
            if (object == null) {
                i = this.e;
                this.d = true;
            } else {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(object.hashCode());
                int i5 = this.c;
                while (true) {
                    i = iE & i5;
                    if (objArr[i] != null) {
                        iE = i + 1;
                        i5 = this.c;
                    }
                }
            }
            objArr[i] = object;
            fArr[i] = f;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] objArr = this.a;
        float[] fArr = this.b;
        aw awVar = new aw(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iD = awVar.d();
            objectOutputStream.writeObject(objArr[iD]);
            objectOutputStream.writeFloat(fArr[iD]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agi.am
    public final float b(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return r();
            }
            return 0.0f;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return 0.0f;
        }
        if (obj.equals(obj3)) {
            return q(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return 0.0f;
            }
        } while (!obj.equals(obj2));
        return q(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, (Object) null);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
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

    @Override // com.google.android.libraries.navigation.internal.agi.b
    /* JADX INFO: renamed from: d */
    public final com.google.android.libraries.navigation.internal.agf.l values() {
        if (this.j == null) {
            this.j = new av(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b
    /* JADX INFO: renamed from: f */
    public final hd keySet() {
        if (this.i == null) {
            this.i = new ba(this);
        }
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, java.util.Map
    public final int hashCode() {
        Object obj;
        int i;
        int iS = s();
        int i2 = 0;
        int i3 = 0;
        int iFloatToIntBits = 0;
        while (iS != 0) {
            while (true) {
                obj = this.a[i2];
                i = i2 + 1;
                if (obj != null) {
                    break;
                }
                i2 = i;
            }
            if (this != obj) {
                iFloatToIntBits = obj.hashCode();
            }
            iS--;
            iFloatToIntBits ^= Float.floatToIntBits(this.b[i2]);
            i3 += iFloatToIntBits;
            i2 = i;
        }
        return this.d ? i3 + Float.floatToIntBits(this.b[this.e]) : i3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, com.google.android.libraries.navigation.internal.agi.as
    public final boolean l(float f) {
        float[] fArr = this.b;
        Object[] objArr = this.a;
        if (this.d && Float.floatToIntBits(fArr[this.e]) == Float.floatToIntBits(f)) {
            return true;
        }
        int i = this.e;
        while (i != 0) {
            i--;
            if (objArr[i] != null && Float.floatToIntBits(fArr[i]) == Float.floatToIntBits(f)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.am
    public final float o(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return this.b[this.e];
            }
            return 0.0f;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return 0.0f;
        }
        if (obj.equals(obj3)) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return 0.0f;
            }
        } while (!obj.equals(obj2));
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* bridge */ /* synthetic */ hd p() {
        if (this.k == null) {
            this.k = new bd(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            u(iMin);
        }
        if (map instanceof as) {
            gi giVarA = au.a((as) map);
            while (giVarA.hasNext()) {
                bc bcVar = (bc) giVarA.next();
                a(bcVar.getKey(), bcVar.a());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            al.b(this, entry.getKey(), (Float) entry.getValue());
        }
    }

    public final float q(int i) {
        Object obj;
        float f = this.b[i];
        this.h--;
        Object[] objArr = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.c;
            while (true) {
                obj = objArr[i2];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    int i3 = this.c;
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
            float[] fArr = this.b;
            fArr[i] = fArr[i2];
            i = i2;
        }
        objArr[i] = null;
        int i5 = this.e;
        if (i5 > this.g && this.h < this.f / 4 && i5 > 16) {
            u(i5 >> 1);
        }
        return f;
    }

    public final float r() {
        this.d = false;
        Object[] objArr = this.a;
        int i = this.e;
        objArr[i] = null;
        float f = this.b[i];
        int i2 = this.h - 1;
        this.h = i2;
        if (i > this.g && i2 < this.f / 4 && i > 16) {
            u(i >> 1);
        }
        return f;
    }

    public final int s() {
        return this.d ? this.h - 1 : this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final bi clone() {
        try {
            bi biVar = (bi) super.clone();
            biVar.i = null;
            biVar.j = null;
            biVar.k = null;
            biVar.d = this.d;
            biVar.a = (Object[]) this.a.clone();
            biVar.b = (float[]) this.b.clone();
            return biVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void u(int i) {
        Object obj;
        int i2 = i + 1;
        Object[] objArr = this.a;
        float[] fArr = this.b;
        Object[] objArr2 = new Object[i2];
        float[] fArr2 = new float[i2];
        int i3 = this.e;
        int iS = s();
        while (true) {
            int i4 = i - 1;
            if (iS == 0) {
                fArr2[i] = fArr[this.e];
                this.e = i;
                this.c = i4;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = objArr2;
                this.b = fArr2;
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
            fArr2[iE] = fArr[i3];
            iS--;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.b, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agi.am
    public final float a(Object obj, float f) {
        int i;
        if (obj == null) {
            i = this.d ? this.e : -(this.e + 1);
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
            float[] fArr = this.b;
            float f2 = fArr[i];
            fArr[i] = f;
            return f2;
        }
        int i2 = (-i) - 1;
        if (i2 == this.e) {
            this.d = true;
        }
        this.a[i2] = obj;
        this.b[i2] = f;
        int i3 = this.h;
        this.h = i3 + 1;
        if (i3 < this.f) {
            return 0.0f;
        }
        u(com.google.android.libraries.navigation.internal.agc.e.a(i3 + 2, 0.75f));
        return 0.0f;
    }
}
