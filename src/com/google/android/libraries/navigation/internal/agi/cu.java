package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cu extends h implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient Object[] b = gd.a;
    protected transient long[] c = com.google.android.libraries.navigation.internal.agh.fz.a;
    protected int d;
    protected transient dd e;
    protected transient hd f;
    protected transient com.google.android.libraries.navigation.internal.agh.gf g;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.d;
        this.b = new Object[i];
        this.c = new long[i];
        for (int i2 = 0; i2 < this.d; i2++) {
            this.b[i2] = objectInputStream.readObject();
            this.c[i2] = objectInputStream.readLong();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objectOutputStream.writeObject(this.b[i2]);
            objectOutputStream.writeLong(this.c[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final long b(Object obj, long j) {
        int iP = p(obj);
        if (iP != -1) {
            long[] jArr = this.c;
            long j2 = jArr[iP];
            jArr[iP] = j;
            return j2;
        }
        int i = this.d;
        if (i == this.b.length) {
            Object[] objArr = new Object[i == 0 ? 2 : i + i];
            long[] jArr2 = new long[i != 0 ? i + i : 2];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                objArr[i2] = this.b[i2];
                jArr2[i2] = this.c[i2];
                i = i2;
            }
            this.b = objArr;
            this.c = jArr2;
        }
        Object[] objArr2 = this.b;
        int i3 = this.d;
        objArr2[i3] = obj;
        this.c[i3] = j;
        this.d = i3 + 1;
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final long c(Object obj) {
        int iP = p(obj);
        if (iP == -1) {
            return this.a;
        }
        long j = this.c[iP];
        int i = (this.d - iP) - 1;
        Object[] objArr = this.b;
        int i2 = iP + 1;
        System.arraycopy(objArr, i2, objArr, iP, i);
        long[] jArr = this.c;
        System.arraycopy(jArr, i2, jArr, iP, i);
        int i3 = this.d - 1;
        this.d = i3;
        this.b[i3] = null;
        return j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final void clear() {
        int i = this.d;
        while (i != 0) {
            i--;
            this.b[i] = null;
        }
        this.d = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return p(obj) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h
    /* JADX INFO: renamed from: e */
    public final com.google.android.libraries.navigation.internal.agh.gf values() {
        if (this.g == null) {
            this.g = new ct(this);
        }
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h
    /* JADX INFO: renamed from: g */
    public final hd keySet() {
        if (this.f == null) {
            this.f = new cq(this);
        }
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final boolean isEmpty() {
        return this.d == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, com.google.android.libraries.navigation.internal.agi.de
    public final boolean m(long j) {
        int i = this.d;
        while (i != 0) {
            i--;
            if (this.c[i] == j) {
                return true;
            }
        }
        return false;
    }

    public final int p(Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        while (i != 0) {
            i--;
            if (Objects.equals(objArr[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cw
    public final long q(Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        while (i != 0) {
            i--;
            if (Objects.equals(objArr[i], obj)) {
                return this.c[i];
            }
        }
        return this.a;
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final cu clone() {
        try {
            cu cuVar = (cu) super.clone();
            cuVar.b = (Object[]) this.b.clone();
            cuVar.c = (long[]) this.c.clone();
            cuVar.e = null;
            cuVar.f = null;
            cuVar.g = null;
            return cuVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final dd t() {
        if (this.e == null) {
            this.e = new cn(this);
        }
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.h, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
