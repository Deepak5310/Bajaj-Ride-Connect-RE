package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kw extends ak implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient Object[] a;
    public int b;

    public kw() {
        this.a = gd.a;
    }

    private final int d(Object obj) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (this.a[i] == obj) {
                return i;
            }
        }
        return -1;
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

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: a */
    public final gi iterator() {
        return new ku(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        if (d(obj) != -1) {
            return false;
        }
        int i = this.b;
        if (i == this.a.length) {
            Object[] objArr = new Object[i == 0 ? 2 : i + i];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                objArr[i2] = this.a[i2];
                i = i2;
            }
            this.a = objArr;
        }
        Object[] objArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        objArr2[i3] = obj;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final hj spliterator() {
        return new kv(this);
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final kw clone() {
        try {
            kw kwVar = (kw) super.clone();
            kwVar.a = (Object[]) this.a.clone();
            return kwVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Arrays.fill(this.a, 0, this.b, (Object) null);
        this.b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return d(obj) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new ku(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iD = d(obj);
        if (iD == -1) {
            return false;
        }
        int i = (this.b - iD) - 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object[] objArr = this.a;
            int i3 = iD + i2;
            objArr[i3] = objArr[i3 + 1];
        }
        int i4 = this.b - 1;
        this.b = i4;
        this.a[i4] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new kv(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i = this.b;
        return i == 0 ? gd.a : Arrays.copyOf(this.a, i, Object[].class);
    }

    public kw(Object[] objArr) {
        this.a = objArr;
        this.b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
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
}
