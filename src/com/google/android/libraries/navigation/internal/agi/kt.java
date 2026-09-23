package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kt extends aj implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353131L;
    protected transient Object[] a;
    protected int b;

    static {
        Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.agi.kl
            @Override // java.util.function.Supplier
            public final Object get() {
                return new kt();
            }
        }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.agi.km
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((kt) obj).add(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.agi.kn
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                kt ktVar = (kt) obj;
                ktVar.m(ktVar.size(), (kt) obj2);
                return ktVar;
            }
        }, new Collector.Characteristics[0]);
    }

    public kt() {
        this.a = gd.b;
    }

    private final void p(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        if (i <= length) {
            return;
        }
        if (objArr != gd.b) {
            i = (int) Math.max(Math.min(((long) length) + ((long) (length >> 1)), 2147483639L), i);
        } else if (i < 10) {
            i = 10;
        }
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, this.b);
        this.a = objArr2;
    }

    private static final Object[] q(Object[] objArr, int i) {
        return i == 0 ? gd.a : Arrays.copyOf(objArr, i, Object[].class);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new Object[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeObject(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final void add(int i, Object obj) {
        j(i);
        p(this.b + 1);
        int i2 = this.b;
        if (i != i2) {
            Object[] objArr = this.a;
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        }
        this.a[i] = obj;
        this.b++;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection instanceof la) {
            return m(i, (la) collection);
        }
        j(i);
        int size = collection.size();
        if (size == 0) {
            return false;
        }
        p(this.b + size);
        Object[] objArr = this.a;
        System.arraycopy(objArr, i, objArr, i + size, this.b - i);
        Iterator it2 = collection.iterator();
        this.b += size;
        while (size != 0) {
            size--;
            this.a[i] = it2.next();
            i++;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final hj spliterator() {
        return new kp(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj
    /* JADX INFO: renamed from: c */
    public final la subList(int i, int i2) {
        if (i == 0) {
            if (i2 == this.b) {
                return this;
            }
            i = 0;
        }
        j(i);
        j(i2);
        if (i <= i2) {
            return new ks(this, i, i2);
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        Arrays.fill(this.a, 0, this.b, (Object) null);
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    /* JADX INFO: renamed from: d */
    public final gw listIterator(int i) {
        j(i);
        return new ko(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final void e(int i, Object[] objArr, int i2, int i3) {
        gd.a(objArr, i2, i3);
        System.arraycopy(this.a, i, objArr, i2, i3);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof kt)) {
            return obj instanceof ks ? ((ks) obj).equals(this) : super.equals(obj);
        }
        kt ktVar = (kt) obj;
        if (ktVar == this) {
            return true;
        }
        int i = this.b;
        int i2 = ktVar.b;
        if (i == i2) {
            Object[] objArr = this.a;
            Object[] objArr2 = ktVar.a;
            if (objArr == objArr2 && i == i2) {
                return true;
            }
            while (i != 0) {
                i--;
                if (objArr[i] != objArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final void f(int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.a(this.b, i, i2);
        Object[] objArr = this.a;
        System.arraycopy(objArr, i2, objArr, i, this.b - i2);
        int i3 = i2 - i;
        this.b -= i3;
        while (i3 != 0) {
            i3--;
            this.a[this.b + i3] = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.lang.Iterable
    public final void forEach(Consumer consumer) {
        for (int i = 0; i < this.b; i++) {
            consumer.accept(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final void g(int i, Object[] objArr, int i2) {
        j(i);
        gd.a(objArr, 0, i2);
        int i3 = i + i2;
        int i4 = this.b;
        if (i3 > i4) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i4, i3, "End index (", ") is greater than list size (", ")"));
        }
        System.arraycopy(objArr, 0, this.a, i, i2);
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.b;
        if (i < i2) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.b; i++) {
            if (obj == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final int lastIndexOf(Object obj) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (obj == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    public final boolean m(int i, la laVar) {
        j(i);
        int size = laVar.size();
        if (size == 0) {
            return false;
        }
        p(this.b + size);
        Object[] objArr = this.a;
        System.arraycopy(objArr, i, objArr, i + size, this.b - i);
        laVar.e(0, this.a, i, size);
        this.b += size;
        return true;
    }

    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final kt clone() {
        if (getClass() == kt.class) {
            kt ktVar = new kt(q(this.a, this.b));
            ktVar.b = this.b;
            return ktVar;
        }
        try {
            kt ktVar2 = (kt) super.clone();
            ktVar2.a = q(this.a, this.b);
            return ktVar2;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final Object remove(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        Object[] objArr = this.a;
        Object obj = objArr[i];
        int i3 = i2 - 1;
        this.b = i3;
        if (i != i3) {
            System.arraycopy(objArr, i + 1, objArr, i, i3 - i);
        }
        this.a[this.b] = null;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int i;
        Object[] objArr = this.a;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                break;
            }
            if (!collection.contains(objArr[i2])) {
                objArr[i3] = objArr[i2];
                i3++;
            }
            i2++;
        }
        Arrays.fill(objArr, i3, i, (Object) null);
        boolean z = this.b != i3;
        this.b = i3;
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        Object[] objArr = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final void sort(Comparator comparator) {
        if (comparator == null) {
            gd.d(this.a, this.b);
        } else {
            gd.e(this.a, this.b, comparator);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new kp(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        int i = this.b;
        return i == 0 ? gd.a : Arrays.copyOf(this.a, i, Object[].class);
    }

    public kt(byte[] bArr) {
        this.a = new Object[2];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            objArr = new Object[this.b];
        } else {
            if (objArr.length < this.b) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.b);
            }
        }
        System.arraycopy(this.a, 0, objArr, 0, this.b);
        int length = objArr.length;
        int i = this.b;
        if (length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    protected kt(Object[] objArr) {
        this.a = objArr;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        p(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }
}
