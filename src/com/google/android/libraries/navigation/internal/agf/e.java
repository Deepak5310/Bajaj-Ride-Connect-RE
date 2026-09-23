package com.google.android.libraries.navigation.internal.agf;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends b implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient float[] a;
    protected int b;

    public e() {
        this.a = f.a;
    }

    private final int m(float f) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (Float.floatToIntBits(this.a[i]) == Float.floatToIntBits(f)) {
                return i;
            }
        }
        return -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new float[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readFloat();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeFloat(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agf.b, com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    /* JADX INFO: renamed from: a */
    public final v iterator() {
        return new c(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.b, com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    public final ao b() {
        return new d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    public final boolean c(float f) {
        if (m(f) != -1) {
            return false;
        }
        int i = this.b;
        if (i == this.a.length) {
            float[] fArr = new float[i == 0 ? 2 : i + i];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                fArr[i2] = this.a[i2];
                i = i2;
            }
            this.a = fArr;
        }
        float[] fArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        fArr2[i3] = f;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    public final boolean e(float f) {
        return m(f) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.b, com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new c(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.b
    public final boolean k(float f) {
        int iM = m(f);
        if (iM == -1) {
            return false;
        }
        int i = (this.b - iM) - 1;
        for (int i2 = 0; i2 < i; i2++) {
            float[] fArr = this.a;
            int i3 = iM + i2;
            fArr[i3] = fArr[i3 + 1];
        }
        this.b--;
        return true;
    }

    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final e clone() {
        try {
            e eVar = (e) super.clone();
            eVar.a = (float[]) this.a.clone();
            return eVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.b, com.google.android.libraries.navigation.internal.agf.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new d(this);
    }

    public e(float[] fArr) {
        this.a = fArr;
        this.b = 0;
    }
}
