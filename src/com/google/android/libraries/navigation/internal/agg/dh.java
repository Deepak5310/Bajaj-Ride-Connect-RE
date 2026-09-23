package com.google.android.libraries.navigation.internal.agg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dh extends p implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient int[] a;
    public int b;

    public dh() {
        this.a = di.a;
    }

    private final int o(int i) {
        int i2 = this.b;
        while (i2 != 0) {
            i2--;
            if (this.a[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new int[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readInt();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeInt(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: a */
    public final ei iterator() {
        return new df(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final fh b() {
        return new dg(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public final boolean c(int i) {
        if (o(i) != -1) {
            return false;
        }
        int i2 = this.b;
        if (i2 == this.a.length) {
            int[] iArr = new int[i2 == 0 ? 2 : i2 + i2];
            while (true) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                iArr[i3] = this.a[i3];
                i2 = i3;
            }
            this.a = iArr;
        }
        int[] iArr2 = this.a;
        int i4 = this.b;
        this.b = i4 + 1;
        iArr2[i4] = i;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        return o(i) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new df(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p
    public final boolean m(int i) {
        int iO = o(i);
        if (iO == -1) {
            return false;
        }
        int i2 = (this.b - iO) - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = this.a;
            int i4 = iO + i3;
            iArr[i4] = iArr[i4 + 1];
        }
        this.b--;
        return true;
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final dh clone() {
        try {
            dh dhVar = (dh) super.clone();
            dhVar.a = (int[]) this.a.clone();
            return dhVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new dg(this);
    }

    public dh(int i) {
        this.a = new int[i];
    }

    public dh(int[] iArr) {
        this.a = iArr;
        this.b = 0;
    }
}
