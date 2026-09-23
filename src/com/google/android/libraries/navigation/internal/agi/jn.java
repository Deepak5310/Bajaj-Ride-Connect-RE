package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jn extends aa implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient Object[] a;
    protected transient Object[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    protected int h;
    protected transient lb i;
    protected transient gf j;
    protected transient ji k;

    public jn() {
        this(16);
    }

    private final int k(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.d ? this.e : -(this.e + 1);
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 != null) {
            if (obj != obj3) {
                do {
                    iE = (iE + 1) & this.c;
                    obj2 = objArr[iE];
                    if (obj2 == null) {
                    }
                } while (obj != obj2);
            }
            return iE;
        }
        return -(iE + 1);
    }

    private final void l(int i, Object obj, Object obj2) {
        if (i == this.e) {
            this.d = true;
        }
        this.a[i] = obj;
        this.b[i] = obj2;
        int i2 = this.h;
        this.h = i2 + 1;
        if (i2 >= this.f) {
            i(com.google.android.libraries.navigation.internal.agc.e.a(i2 + 2, 0.75f));
        }
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
        Object[] objArr2 = new Object[i2];
        this.b = objArr2;
        int i3 = this.h;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            if (object == null) {
                i = this.e;
                this.d = true;
            } else {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(object));
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
            objArr2[i] = object2;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] objArr = this.a;
        Object[] objArr2 = this.b;
        jb jbVar = new jb(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iC = jbVar.c();
            objectOutputStream.writeObject(objArr[iC]);
            objectOutputStream.writeObject(objArr2[iC]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa
    /* JADX INFO: renamed from: a */
    public final gf values() {
        if (this.j == null) {
            this.j = new ja(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa
    /* JADX INFO: renamed from: c */
    public final lb keySet() {
        if (this.i == null) {
            this.i = new jf(this);
        }
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, (Object) null);
        Arrays.fill(this.b, (Object) null);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        int iK = k(obj);
        Object objApply = biFunction.apply(obj, iK >= 0 ? this.b[iK] : null);
        if (objApply == null) {
            if (iK >= 0) {
                if (obj == null) {
                    h();
                } else {
                    g(iK);
                }
            }
            return null;
        }
        if (iK < 0) {
            l((-iK) - 1, obj, objApply);
            return objApply;
        }
        this.b[iK] = objApply;
        return objApply;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        Object obj2;
        Objects.requireNonNull(biFunction);
        int iK = k(obj);
        if (iK < 0 || (obj2 = this.b[iK]) == null) {
            return null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply != null) {
            this.b[iK] = objApply;
            return objApply;
        }
        if (obj == null) {
            h();
            return null;
        }
        g(iK);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, com.google.android.libraries.navigation.internal.agi.z, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.d;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (obj != obj3) {
            do {
                iE = (iE + 1) & this.c;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (obj != obj2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final boolean containsValue(Object obj) {
        Object[] objArr = this.b;
        Object[] objArr2 = this.a;
        if (this.d && Objects.equals(objArr[this.e], obj)) {
            return true;
        }
        int i = this.e;
        while (i != 0) {
            i--;
            if (objArr2[i] != null && Objects.equals(objArr[i], obj)) {
                return true;
            }
        }
        return false;
    }

    public final int e() {
        return this.d ? this.h - 1 : this.h;
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final jn clone() {
        try {
            jn jnVar = (jn) super.clone();
            jnVar.i = null;
            jnVar.j = null;
            jnVar.k = null;
            jnVar.d = this.d;
            jnVar.a = (Object[]) this.a.clone();
            jnVar.b = (Object[]) this.b.clone();
            return jnVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public final Object g(int i) {
        Object obj;
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = null;
        this.h--;
        Object[] objArr2 = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.c;
            while (true) {
                obj = objArr2[i2];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj));
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
            objArr2[i] = obj;
            Object[] objArr3 = this.b;
            objArr3[i] = objArr3[i2];
            i = i2;
        }
        objArr2[i] = null;
        this.b[i] = null;
        int i5 = this.e;
        if (i5 > this.g && this.h < this.f / 4 && i5 > 16) {
            i(i5 >> 1);
        }
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.is, com.google.android.libraries.navigation.internal.agc.d
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return this.b[this.e];
            }
            return null;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return null;
        }
        if (obj == obj3) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return null;
            }
        } while (obj != obj2);
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3;
        if (obj != null) {
            Object[] objArr = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & this.c;
            Object obj4 = objArr[iE];
            if (obj4 != null) {
                if (obj == obj4) {
                    return this.b[iE];
                }
                do {
                    iE = (iE + 1) & this.c;
                    obj3 = objArr[iE];
                    if (obj3 != null) {
                    }
                } while (obj != obj3);
                return this.b[iE];
            }
        } else if (this.d) {
            return this.b[this.e];
        }
        return obj2;
    }

    public final Object h() {
        this.d = false;
        Object[] objArr = this.a;
        int i = this.e;
        objArr[i] = null;
        Object[] objArr2 = this.b;
        Object obj = objArr2[i];
        objArr2[i] = null;
        int i2 = this.h - 1;
        this.h = i2;
        if (i > this.g && i2 < this.f / 4 && i > 16) {
            i(i >> 1);
        }
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final int hashCode() {
        Object obj;
        int i;
        int iE = e();
        int i2 = 0;
        int i3 = 0;
        int iHashCode = 0;
        while (iE != 0) {
            while (true) {
                obj = this.a[i2];
                i = i2 + 1;
                if (obj != null) {
                    break;
                }
                i2 = i;
            }
            if (this != obj) {
                iHashCode = System.identityHashCode(obj);
            }
            Object obj2 = this.b[i2];
            if (this != obj2) {
                iHashCode = (obj2 == null ? 0 : obj2.hashCode()) ^ iHashCode;
            }
            i3 += iHashCode;
            iE--;
            i2 = i;
        }
        if (!this.d) {
            return i3;
        }
        Object obj3 = this.b[this.e];
        return i3 + (obj3 != null ? obj3.hashCode() : 0);
    }

    protected final void i(int i) {
        Object obj;
        int i2 = i + 1;
        Object[] objArr = this.a;
        Object[] objArr2 = this.b;
        Object[] objArr3 = new Object[i2];
        Object[] objArr4 = new Object[i2];
        int i3 = this.e;
        int iE = e();
        while (true) {
            int i4 = i - 1;
            if (iE == 0) {
                objArr4[i] = objArr2[this.e];
                this.e = i;
                this.c = i4;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = objArr3;
                this.b = objArr4;
                return;
            }
            do {
                i3--;
                obj = objArr[i3];
            } while (obj == null);
            int iE2 = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & i4;
            if (objArr3[iE2] != null) {
                do {
                    iE2 = (iE2 + 1) & i4;
                } while (objArr3[iE2] != null);
            }
            objArr3[iE2] = objArr[i3];
            objArr4[iE2] = objArr2[i3];
            iE--;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ix
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final ji d() {
        if (this.k == null) {
            this.k = new ji(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        Object obj3;
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(obj2);
        int iK = k(obj);
        if (iK < 0 || (obj3 = this.b[iK]) == null) {
            if (iK < 0) {
                l((-iK) - 1, obj, obj2);
            } else {
                this.b[iK] = obj2;
            }
            return obj2;
        }
        Object objApply = biFunction.apply(obj3, obj2);
        if (objApply != null) {
            this.b[iK] = objApply;
            return objApply;
        }
        if (obj == null) {
            h();
            return null;
        }
        g(iK);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, com.google.android.libraries.navigation.internal.agi.ix, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iK = k(obj);
        if (iK < 0) {
            l((-iK) - 1, obj, obj2);
            return null;
        }
        Object[] objArr = this.b;
        Object obj3 = objArr[iK];
        objArr[iK] = obj2;
        return obj3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            i(iMin);
        }
        if (map instanceof ix) {
            gi giVarA = iz.a((ix) map);
            while (giVarA.hasNext()) {
                jh jhVar = (jh) giVarA.next();
                put(jhVar.getKey(), jhVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        int iK = k(obj);
        if (iK >= 0) {
            return this.b[iK];
        }
        l((-iK) - 1, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, com.google.android.libraries.navigation.internal.agi.ix, java.util.Map
    public final Object remove(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return h();
            }
            return null;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return null;
        }
        if (obj == obj3) {
            return g(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return null;
            }
        } while (obj != obj2);
        return g(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final Object replace(Object obj, Object obj2) {
        int iK = k(obj);
        if (iK < 0) {
            return null;
        }
        Object[] objArr = this.b;
        Object obj3 = objArr[iK];
        objArr[iK] = obj2;
        return obj3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.z, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public jn(int i) {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i2 = iA + 1;
        this.a = new Object[i2];
        this.b = new Object[i2];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iK = k(obj);
        if (iK < 0 || !Objects.equals(obj2, this.b[iK])) {
            return false;
        }
        this.b[iK] = obj3;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aa, java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        if (obj == null) {
            if (!this.d || !Objects.equals(obj2, this.b[this.e])) {
                return false;
            }
            h();
            return true;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(System.identityHashCode(obj)) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (obj == obj3 && Objects.equals(obj2, this.b[iE])) {
            g(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.c;
            Object obj4 = objArr[iE];
            if (obj4 == null) {
                return false;
            }
            if (obj == obj4 && Objects.equals(obj2, this.b[iE])) {
                g(iE);
                return true;
            }
        }
    }
}
