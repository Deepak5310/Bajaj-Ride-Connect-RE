package com.google.android.libraries.navigation.internal.age;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends b implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient double[] a;
    protected int b;

    public f() {
        this.a = g.a;
    }

    private final int m(double d) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (Double.doubleToLongBits(this.a[i]) == Double.doubleToLongBits(d)) {
                return i;
            }
        }
        return -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new double[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readDouble();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeDouble(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.age.b, com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: a */
    public final q iterator() {
        return new d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.age.b, com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    public final aa b() {
        return new e(this);
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    public final boolean c(double d) {
        if (m(d) != -1) {
            return false;
        }
        int i = this.b;
        if (i == this.a.length) {
            double[] dArr = new double[i == 0 ? 2 : i + i];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                dArr[i2] = this.a[i2];
                i = i2;
            }
            this.a = dArr;
        }
        double[] dArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        dArr2[i3] = d;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    public final boolean e(double d) {
        return m(d) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.age.b, com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.age.b
    public final boolean k(double d) {
        int iM = m(d);
        if (iM == -1) {
            return false;
        }
        int i = (this.b - iM) - 1;
        for (int i2 = 0; i2 < i; i2++) {
            double[] dArr = this.a;
            int i3 = iM + i2;
            dArr[i3] = dArr[i3 + 1];
        }
        this.b--;
        return true;
    }

    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final f clone() {
        try {
            f fVar = (f) super.clone();
            fVar.a = (double[]) this.a.clone();
            return fVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.age.b, com.google.android.libraries.navigation.internal.age.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new e(this);
    }

    public f(double[] dArr) {
        this.a = dArr;
        this.b = 0;
    }
}
