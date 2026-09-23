package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hc extends u implements Serializable, Cloneable {
    public static final /* synthetic */ int i = 0;
    private static final long serialVersionUID = 0;
    protected transient Object[] a;
    protected transient int b;
    protected transient boolean c;
    protected transient int d;
    protected transient int e;
    protected final transient int f;
    protected int g;
    protected final float h;

    static {
        Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.agi.gz
            @Override // java.util.function.Supplier
            public final Object get() {
                return new hc();
            }
        }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.agi.gx
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((hc) obj).add(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.agi.gy
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                hc hcVar = (hc) obj;
                int i2 = hc.i;
                hcVar.addAll((hc) obj2);
                return hcVar;
            }
        }, Collector.Characteristics.UNORDERED);
    }

    public hc() {
        this(16, null);
    }

    private final void f(int i2) {
        Object obj;
        this.g--;
        Object[] objArr = this.a;
        loop0: while (true) {
            int i3 = (i2 + 1) & this.b;
            while (true) {
                obj = objArr[i3];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    int i4 = this.b;
                    int i5 = iE & i4;
                    if (i2 > i3) {
                        if (i2 >= i5 && i5 > i3) {
                            break;
                        } else {
                            i3 = (i3 + 1) & i4;
                        }
                    } else if (i2 >= i5 || i5 > i3) {
                        break;
                    } else {
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    break loop0;
                }
            }
            objArr[i2] = obj;
            i2 = i3;
        }
        objArr[i2] = null;
        int i6 = this.d;
        if (i6 <= this.f || this.g >= this.e / 4 || i6 <= 16) {
            return;
        }
        e(i6 >> 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int iE;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.g, this.h);
        this.d = iA;
        this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, this.h);
        this.b = iA - 1;
        Object[] objArr = new Object[iA + 1];
        this.a = objArr;
        int i2 = this.g;
        while (true) {
            int i3 = i2 - 1;
            if (i2 == 0) {
                return;
            }
            Object object = objectInputStream.readObject();
            if (object == null) {
                iE = this.d;
                this.c = true;
            } else {
                iE = com.google.android.libraries.navigation.internal.agc.e.e(object.hashCode()) & this.b;
                if (objArr[iE] != null) {
                    do {
                        iE = (iE + 1) & this.b;
                    } while (objArr[iE] != null);
                }
            }
            objArr[iE] = object;
            i2 = i3;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ha haVar = new ha(this);
        objectOutputStream.defaultWriteObject();
        for (int i2 = this.g; i2 != 0; i2--) {
            objectOutputStream.writeObject(haVar.next());
        }
    }

    public final int a() {
        return this.c ? this.g - 1 : this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final gi iterator() {
        return new ha(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new hb(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (this.g == 0) {
            return;
        }
        this.g = 0;
        this.c = false;
        Arrays.fill(this.a, (Object) null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.c;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.b;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (!obj.equals(obj3)) {
            do {
                iE = (iE + 1) & this.b;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!obj.equals(obj2));
        }
        return true;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final hc clone() {
        try {
            hc hcVar = (hc) super.clone();
            hcVar.a = (Object[]) this.a.clone();
            hcVar.c = this.c;
            return hcVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    protected final void e(int i2) {
        Object obj;
        Object[] objArr = this.a;
        Object[] objArr2 = new Object[i2 + 1];
        int i3 = this.d;
        int iA = a();
        while (true) {
            int i4 = i2 - 1;
            if (iA == 0) {
                this.d = i2;
                this.b = i4;
                this.e = com.google.android.libraries.navigation.internal.agc.e.d(i2, this.h);
                this.a = objArr2;
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
            iA--;
        }
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (this.c) {
            consumer.accept(this.a[this.d]);
        }
        Object[] objArr = this.a;
        int i2 = this.d;
        while (i2 != 0) {
            i2--;
            Object obj = objArr[i2];
            if (obj != null) {
                consumer.accept(obj);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, java.util.Collection, java.util.Set
    public final int hashCode() {
        Object obj;
        int iHashCode = 0;
        int i2 = 0;
        for (int iA = a(); iA != 0; iA--) {
            do {
                obj = this.a[i2];
                i2++;
            } while (obj == null);
            if (this != obj) {
                iHashCode += obj.hashCode();
            }
        }
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.g == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new ha(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Object obj2;
        if (obj == null) {
            if (!this.c) {
                return false;
            }
            this.c = false;
            Object[] objArr = this.a;
            int i2 = this.d;
            objArr[i2] = null;
            int i3 = this.g - 1;
            this.g = i3;
            if (i2 > this.f && i3 < this.e / 4 && i2 > 16) {
                e(i2 >> 1);
            }
            return true;
        }
        Object[] objArr2 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.b;
        Object obj3 = objArr2[iE];
        if (obj3 == null) {
            return false;
        }
        if (obj.equals(obj3)) {
            f(iE);
            return true;
        }
        do {
            iE = (iE + 1) & this.b;
            obj2 = objArr2[iE];
            if (obj2 == null) {
                return false;
            }
        } while (!obj.equals(obj2));
        f(iE);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return new hb(this);
    }

    public hc(int i2) {
        this(i2, null);
    }

    public hc(int i2, byte[] bArr) {
        if (i2 >= 0) {
            this.h = 0.75f;
            int iA = com.google.android.libraries.navigation.internal.agc.e.a(i2, 0.75f);
            this.d = iA;
            this.f = iA;
            this.b = iA - 1;
            this.e = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
            this.a = new Object[iA + 1];
            return;
        }
        throw new IllegalArgumentException("The expected number of elements must be nonnegative");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        if (this.h <= 0.5d) {
            int iA = com.google.android.libraries.navigation.internal.agc.e.a(collection.size(), this.h);
            if (iA > this.d) {
                e(iA);
            }
        } else {
            int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.g + collection.size()) / this.h))));
            if (iMin > this.d) {
                e(iMin);
            }
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Object obj2;
        if (obj != null) {
            Object[] objArr = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.b;
            Object obj3 = objArr[iE];
            if (obj3 != null) {
                if (!obj3.equals(obj)) {
                    do {
                        iE = (iE + 1) & this.b;
                        obj2 = objArr[iE];
                        if (obj2 != null) {
                        }
                    } while (!obj2.equals(obj));
                }
                return false;
            }
            objArr[iE] = obj;
        } else {
            if (this.c) {
                return false;
            }
            this.c = true;
        }
        int i2 = this.g;
        this.g = i2 + 1;
        if (i2 >= this.e) {
            e(com.google.android.libraries.navigation.internal.agc.e.a(i2 + 2, this.h));
        }
        return true;
    }
}
