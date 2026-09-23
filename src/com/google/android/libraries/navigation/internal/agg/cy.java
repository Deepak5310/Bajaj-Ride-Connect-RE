package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.kx;
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
public final class cy extends g implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient int[] a;
    protected transient Object[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e;
    protected transient int f;
    protected final transient int g;
    protected int h;
    protected transient ez i;
    protected transient kx j;
    protected transient ct k;

    public cy() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.e = iA;
        this.g = iA;
        this.c = iA - 1;
        this.f = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new int[i];
        this.b = new Object[i];
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
        Object[] objArr = new Object[i2];
        this.b = objArr;
        int i3 = this.h;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                return;
            }
            int i5 = objectInputStream.readInt();
            Object object = objectInputStream.readObject();
            if (i5 == 0) {
                i = this.e;
                this.d = true;
            } else {
                int i6 = this.c;
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(i5);
                while (true) {
                    i = i6 & iE;
                    if (iArr[i] != 0) {
                        i6 = i + 1;
                        iE = this.c;
                    }
                }
            }
            iArr[i] = i5;
            objArr[i] = object;
            i3 = i4;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        cm cmVar = new cm(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.h; i != 0; i--) {
            int iB = cmVar.b();
            objectOutputStream.writeInt(iArr[iB]);
            objectOutputStream.writeObject(objArr[iB]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agg.cd
    public final Object b(int i) {
        int i2;
        if (i == 0) {
            if (this.d) {
                return m();
            }
            return null;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return null;
        }
        if (i == i3) {
            return l(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            i2 = iArr[iE];
            if (i2 == 0) {
                return null;
            }
        } while (i != i2);
        return l(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agg.cd
    public final boolean c(int i) {
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

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final void clear() {
        if (this.h == 0) {
            return;
        }
        this.h = 0;
        this.d = false;
        Arrays.fill(this.a, 0);
        Arrays.fill(this.b, (Object) null);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final boolean containsValue(Object obj) {
        Object[] objArr = this.b;
        int[] iArr = this.a;
        if (this.d && objArr[this.e] == obj) {
            return true;
        }
        int i = this.e;
        while (i != 0) {
            i--;
            if (iArr[i] != 0 && objArr[i] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g
    /* JADX INFO: renamed from: d */
    public final ez keySet() {
        if (this.i == null) {
            this.i = new cq(this);
        }
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g
    /* JADX INFO: renamed from: f */
    public final kx values() {
        if (this.j == null) {
            this.j = new cl(this);
        }
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cd
    public final Object h(int i) {
        int i2;
        if (i == 0) {
            if (this.d) {
                return this.b[this.e];
            }
            return null;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return null;
        }
        if (i == i3) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            i2 = iArr[iE];
            if (i2 == 0) {
                return null;
            }
        } while (i != i2);
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final int hashCode() {
        int iIdentityHashCode;
        int i;
        int iJ = j();
        int i2 = 0;
        int i3 = 0;
        while (iJ != 0) {
            while (true) {
                iIdentityHashCode = this.a[i2];
                i = i2 + 1;
                if (iIdentityHashCode != 0) {
                    break;
                }
                i2 = i;
            }
            Object obj = this.b[i2];
            if (this != obj) {
                iIdentityHashCode ^= obj == null ? 0 : System.identityHashCode(obj);
            }
            i3 += iIdentityHashCode;
            iJ--;
            i2 = i;
        }
        if (!this.d) {
            return i3;
        }
        Object obj2 = this.b[this.e];
        return i3 + (obj2 != null ? System.identityHashCode(obj2) : 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ci
    public final /* bridge */ /* synthetic */ hd i() {
        if (this.k == null) {
            this.k = new ct(this);
        }
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    public final int j() {
        return this.d ? this.h - 1 : this.h;
    }

    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final cy clone() {
        try {
            cy cyVar = (cy) super.clone();
            cyVar.i = null;
            cyVar.j = null;
            cyVar.k = null;
            cyVar.d = this.d;
            cyVar.a = (int[]) this.a.clone();
            cyVar.b = (Object[]) this.b.clone();
            return cyVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    public final Object l(int i) {
        int i2;
        Object[] objArr = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.h--;
        int[] iArr = this.a;
        loop0: while (true) {
            int i3 = (i + 1) & this.c;
            while (true) {
                i2 = iArr[i3];
                if (i2 != 0) {
                    int i4 = this.c;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i4;
                    if (i > i3) {
                        if (i >= iE && iE > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    } else {
                        if (i >= iE || iE > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    break loop0;
                }
            }
            iArr[i] = i2;
            Object[] objArr2 = this.b;
            objArr2[i] = objArr2[i3];
            i = i3;
        }
        iArr[i] = 0;
        this.b[i] = null;
        int i5 = this.e;
        if (i5 > this.g && this.h < this.f / 4 && i5 > 16) {
            n(i5 >> 1);
        }
        return obj;
    }

    public final Object m() {
        this.d = false;
        Object[] objArr = this.b;
        int i = this.e;
        Object obj = objArr[i];
        objArr[i] = null;
        int i2 = this.h - 1;
        this.h = i2;
        if (i > this.g && i2 < this.f / 4 && i > 16) {
            n(i >> 1);
        }
        return obj;
    }

    protected final void n(int i) {
        int i2;
        int i3 = i + 1;
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int[] iArr2 = new int[i3];
        Object[] objArr2 = new Object[i3];
        int i4 = this.e;
        int iJ = j();
        while (true) {
            int i5 = i - 1;
            if (iJ == 0) {
                objArr2[i] = objArr[this.e];
                this.e = i;
                this.c = i5;
                this.f = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
                this.a = iArr2;
                this.b = objArr2;
                return;
            }
            do {
                i4--;
                i2 = iArr[i4];
            } while (i2 == 0);
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i5;
            if (iArr2[iE] != 0) {
                do {
                    iE = (iE + 1) & i5;
                } while (iArr2[iE] != 0);
            }
            iArr2[iE] = iArr[i4];
            objArr2[iE] = objArr[i4];
            iJ--;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.h + map.size()) / 0.75f))));
        if (iMin > this.e) {
            n(iMin);
        }
        if (map instanceof ci) {
            gi giVarA = ck.a((ci) map);
            while (giVarA.hasNext()) {
                cs csVar = (cs) giVarA.next();
                a(csVar.a(), csVar.getValue());
            }
            return;
        }
        int size = map.size();
        Iterator it2 = map.entrySet().iterator();
        while (size != 0) {
            size--;
            Map.Entry entry = (Map.Entry) it2.next();
            cc.b(this, (Integer) entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.g, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agg.cd
    public final Object a(int i, Object obj) {
        int i2;
        if (i == 0) {
            i2 = this.d ? this.e : -(this.e + 1);
        } else {
            int[] iArr = this.a;
            int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
            int i3 = iArr[iE];
            if (i3 != 0) {
                if (i != i3) {
                    while (true) {
                        iE = (iE + 1) & this.c;
                        int i4 = iArr[iE];
                        if (i4 == 0) {
                            i2 = -(iE + 1);
                        } else if (i == i4) {
                        }
                    }
                }
                i2 = iE;
            } else {
                i2 = -(iE + 1);
            }
        }
        if (i2 >= 0) {
            Object[] objArr = this.b;
            Object obj2 = objArr[i2];
            objArr[i2] = obj;
            return obj2;
        }
        int i5 = (-i2) - 1;
        if (i5 == this.e) {
            this.d = true;
        }
        this.a[i5] = i;
        this.b[i5] = obj;
        int i6 = this.h;
        this.h = i6 + 1;
        if (i6 < this.f) {
            return null;
        }
        n(com.google.android.libraries.navigation.internal.agc.e.a(i6 + 2, 0.75f));
        return null;
    }
}
