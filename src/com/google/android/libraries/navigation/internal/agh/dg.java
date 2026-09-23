package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dg extends j implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient long[] a;
    protected transient Object[] b;
    protected int c;
    protected transient dz d;
    protected transient he e;
    protected transient com.google.android.libraries.navigation.internal.agi.gf f;

    public dg() {
        this.a = fz.a;
        this.b = com.google.android.libraries.navigation.internal.agi.gd.a;
    }

    public dg(ea eaVar) {
        dg dgVar = (dg) eaVar;
        int i = dgVar.c;
        this.a = new long[i];
        this.b = new Object[i];
        cw cwVar = new cw((cz) dgVar.t());
        int i2 = 0;
        while (cwVar.hasNext()) {
            dy dyVar = (dy) cwVar.next();
            this.a[i2] = dyVar.a();
            this.b[i2] = dyVar.getValue();
            i2++;
        }
        this.c = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.c;
        this.a = new long[i];
        this.b = new Object[i];
        for (int i2 = 0; i2 < this.c; i2++) {
            this.a[i2] = objectInputStream.readLong();
            this.b[i2] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objectOutputStream.writeLong(this.a[i2]);
            objectOutputStream.writeObject(this.b[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final Object a(long j, Object obj) {
        int iH = h(j);
        if (iH != -1) {
            Object[] objArr = this.b;
            Object obj2 = objArr[iH];
            objArr[iH] = obj;
            return obj2;
        }
        int i = this.c;
        if (i == this.a.length) {
            long[] jArr = new long[i == 0 ? 2 : i + i];
            Object[] objArr2 = new Object[i != 0 ? i + i : 2];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                jArr[i2] = this.a[i2];
                objArr2[i2] = this.b[i2];
                i = i2;
            }
            this.a = jArr;
            this.b = objArr2;
        }
        long[] jArr2 = this.a;
        int i3 = this.c;
        jArr2[i3] = j;
        this.b[i3] = obj;
        this.c = i3 + 1;
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.di
    public final Object aO(long j) {
        long[] jArr = this.a;
        int i = this.c;
        while (i != 0) {
            i--;
            if (jArr[i] == j) {
                return this.b[i];
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final Object b(long j) {
        int iH = h(j);
        if (iH == -1) {
            return null;
        }
        Object obj = this.b[iH];
        int i = (this.c - iH) - 1;
        long[] jArr = this.a;
        int i2 = iH + 1;
        System.arraycopy(jArr, i2, jArr, iH, i);
        Object[] objArr = this.b;
        System.arraycopy(objArr, i2, objArr, iH, i);
        int i3 = this.c - 1;
        this.c = i3;
        this.b[i3] = null;
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final boolean c(long j) {
        return h(j) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea, java.util.Map
    public final void clear() {
        int i = this.c;
        while (i != 0) {
            i--;
            this.b[i] = null;
        }
        this.c = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final boolean containsValue(Object obj) {
        int i = this.c;
        while (i != 0) {
            i--;
            if (Objects.equals(this.b[i], obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: d */
    public final he keySet() {
        if (this.e == null) {
            this.e = new dc(this);
        }
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: e */
    public final com.google.android.libraries.navigation.internal.agi.gf values() {
        if (this.f == null) {
            this.f = new df(this);
        }
        return this.f;
    }

    public final int h(long j) {
        long[] jArr = this.a;
        int i = this.c;
        while (i != 0) {
            i--;
            if (jArr[i] == j) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final dg clone() {
        try {
            dg dgVar = (dg) super.clone();
            dgVar.a = (long[]) this.a.clone();
            dgVar.b = (Object[]) this.b.clone();
            dgVar.d = null;
            dgVar.e = null;
            dgVar.f = null;
            return dgVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final boolean isEmpty() {
        return this.c == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final dz t() {
        if (this.d == null) {
            this.d = new cz(this);
        }
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
