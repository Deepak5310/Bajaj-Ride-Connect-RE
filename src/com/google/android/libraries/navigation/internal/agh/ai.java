package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends c implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    protected transient long[] b;
    protected transient double[] c;
    protected int d;
    protected transient ar e;
    protected transient he f;
    protected transient com.google.android.libraries.navigation.internal.age.k g;

    public ai() {
        this.b = fz.a;
        this.c = com.google.android.libraries.navigation.internal.age.g.a;
    }

    public ai(as asVar) {
        ai aiVar = (ai) asVar;
        int i = aiVar.d;
        this.b = new long[i];
        this.c = new double[i];
        y yVar = new y((ab) aiVar.x());
        int i2 = 0;
        while (yVar.hasNext()) {
            b bVar = (b) yVar.next();
            this.b[i2] = bVar.b();
            this.c[i2] = bVar.a();
            i2++;
        }
        this.d = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.d;
        this.b = new long[i];
        this.c = new double[i];
        for (int i2 = 0; i2 < this.d; i2++) {
            this.b[i2] = objectInputStream.readLong();
            this.c[i2] = objectInputStream.readDouble();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objectOutputStream.writeLong(this.b[i2]);
            objectOutputStream.writeDouble(this.c[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final double b(long j, double d) {
        int iU = u(j);
        if (iU != -1) {
            double[] dArr = this.c;
            double d2 = dArr[iU];
            dArr[iU] = d;
            return d2;
        }
        int i = this.d;
        if (i == this.b.length) {
            long[] jArr = new long[i == 0 ? 2 : i + i];
            double[] dArr2 = new double[i != 0 ? i + i : 2];
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                jArr[i2] = this.b[i2];
                dArr2[i2] = this.c[i2];
                i = i2;
            }
            this.b = jArr;
            this.c = dArr2;
        }
        long[] jArr2 = this.b;
        int i3 = this.d;
        jArr2[i3] = j;
        this.c[i3] = d;
        this.d = i3 + 1;
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final double c(long j) {
        int iU = u(j);
        if (iU == -1) {
            return this.a;
        }
        double d = this.c[iU];
        int i = (this.d - iU) - 1;
        long[] jArr = this.b;
        int i2 = iU + 1;
        System.arraycopy(jArr, i2, jArr, iU, i);
        double[] dArr = this.c;
        System.arraycopy(dArr, i2, dArr, iU, i);
        this.d--;
        return d;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, java.util.Map
    public final void clear() {
        this.d = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final boolean e(long j) {
        return u(j) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c
    /* JADX INFO: renamed from: f */
    public final com.google.android.libraries.navigation.internal.age.k values() {
        if (this.g == null) {
            this.g = new ah(this);
        }
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, com.google.android.libraries.navigation.internal.agh.as
    /* JADX INFO: renamed from: g */
    public final he keySet() {
        if (this.f == null) {
            this.f = new ae(this);
        }
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, java.util.Map
    public final boolean isEmpty() {
        return this.d == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, com.google.android.libraries.navigation.internal.agh.as
    public final boolean q(double d) {
        int i = this.d;
        while (i != 0) {
            i--;
            if (Double.doubleToLongBits(this.c[i]) == Double.doubleToLongBits(d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public final double t(long j) {
        long[] jArr = this.b;
        int i = this.d;
        while (i != 0) {
            i--;
            if (jArr[i] == j) {
                return this.c[i];
            }
        }
        return this.a;
    }

    public final int u(long j) {
        long[] jArr = this.b;
        int i = this.d;
        while (i != 0) {
            i--;
            if (jArr[i] == j) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final ai clone() {
        try {
            ai aiVar = (ai) super.clone();
            aiVar.b = (long[]) this.b.clone();
            aiVar.c = (double[]) this.c.clone();
            aiVar.e = null;
            aiVar.f = null;
            aiVar.g = null;
            return aiVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.c, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final ar x() {
        if (this.e == null) {
            this.e = new ab(this);
        }
        return this.e;
    }
}
