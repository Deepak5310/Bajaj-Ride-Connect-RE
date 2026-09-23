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
public final class ef extends k implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient Object[] a;
    protected transient Object[] b;
    protected int c;
    protected transient ex d;
    protected transient hd e;
    protected transient gf f;

    public ef() {
        Object[] objArr = gd.a;
        this.a = objArr;
        this.b = objArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.c;
        this.a = new Object[i];
        this.b = new Object[i];
        for (int i2 = 0; i2 < this.c; i2++) {
            this.a[i2] = objectInputStream.readObject();
            this.b[i2] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objectOutputStream.writeObject(this.a[i2]);
            objectOutputStream.writeObject(this.b[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k
    /* JADX INFO: renamed from: a */
    public final gf values() {
        if (this.f == null) {
            this.f = new ee(this);
        }
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k
    /* JADX INFO: renamed from: c */
    public final hd keySet() {
        if (this.e == null) {
            this.e = new eb(this);
        }
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final void clear() {
        int i = this.c;
        while (i != 0) {
            i--;
            this.a[i] = null;
            this.b[i] = null;
        }
        this.c = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.i, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return e(obj) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
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

    public final int e(Object obj) {
        Object[] objArr = this.a;
        int i = this.c;
        while (i != 0) {
            i--;
            if (Objects.equals(objArr[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final ef clone() {
        try {
            ef efVar = (ef) super.clone();
            efVar.a = (Object[]) this.a.clone();
            efVar.b = (Object[]) this.b.clone();
            efVar.d = null;
            efVar.e = null;
            efVar.f = null;
            return efVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ey
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final ex i() {
        if (this.d == null) {
            this.d = new dy(this);
        }
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.eh, com.google.android.libraries.navigation.internal.agc.d
    public final Object get(Object obj) {
        Object[] objArr = this.a;
        int i = this.c;
        while (i != 0) {
            i--;
            if (Objects.equals(objArr[i], obj)) {
                return this.b[i];
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final boolean isEmpty() {
        return this.c == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE != -1) {
            Object[] objArr = this.b;
            Object obj3 = objArr[iE];
            objArr[iE] = obj2;
            return obj3;
        }
        int i = this.c;
        if (i == this.a.length) {
            Object[] objArr2 = new Object[i == 0 ? 2 : i + i];
            Object[] objArr3 = new Object[i != 0 ? i + i : 2];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                objArr2[i2] = this.a[i2];
                objArr3[i2] = this.b[i2];
                i = i2;
            }
            this.a = objArr2;
            this.b = objArr3;
        }
        Object[] objArr4 = this.a;
        int i3 = this.c;
        objArr4[i3] = obj;
        this.b[i3] = obj2;
        this.c = i3 + 1;
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final Object remove(Object obj) {
        int iE = e(obj);
        if (iE == -1) {
            return null;
        }
        Object obj2 = this.b[iE];
        int i = (this.c - iE) - 1;
        Object[] objArr = this.a;
        int i2 = iE + 1;
        System.arraycopy(objArr, i2, objArr, iE, i);
        Object[] objArr2 = this.b;
        System.arraycopy(objArr2, i2, objArr2, iE, i);
        int i3 = this.c - 1;
        this.c = i3;
        this.a[i3] = null;
        this.b[i3] = null;
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.i, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
