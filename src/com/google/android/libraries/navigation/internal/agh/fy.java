package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fy extends v implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient long[] a;
    protected int b;

    public fy() {
        this.a = fz.a;
    }

    private final int n(long j) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (this.a[i] == j) {
                return i;
            }
        }
        return -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new long[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readLong();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeLong(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: a */
    public final gs iterator() {
        return new fw(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    public final hl b() {
        return new fx(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean c(long j) {
        if (n(j) != -1) {
            return false;
        }
        int i = this.b;
        if (i == this.a.length) {
            long[] jArr = new long[i == 0 ? 2 : i + i];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                jArr[i2] = this.a[i2];
                i = i2;
            }
            this.a = jArr;
        }
        long[] jArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        jArr2[i3] = j;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return n(j) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new fw(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v
    public final boolean l(long j) {
        int iN = n(j);
        if (iN == -1) {
            return false;
        }
        int i = (this.b - iN) - 1;
        for (int i2 = 0; i2 < i; i2++) {
            long[] jArr = this.a;
            int i3 = iN + i2;
            jArr[i3] = jArr[i3 + 1];
        }
        this.b--;
        return true;
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final fy clone() {
        try {
            fy fyVar = (fy) super.clone();
            fyVar.a = (long[]) this.a.clone();
            return fyVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return new fx(this);
    }

    public fy(he heVar) {
        this.a = new long[heVar.size()];
        gs it2 = heVar.iterator();
        int i = 0;
        while (it2.hasNext()) {
            this.a[i] = it2.next().longValue();
            i++;
        }
        this.b = i;
    }

    public fy(long[] jArr) {
        this.a = jArr;
        this.b = 0;
    }
}
