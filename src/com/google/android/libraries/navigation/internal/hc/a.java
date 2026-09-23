package com.google.android.libraries.navigation.internal.hc;

import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.b.b;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ej;
import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Serializable {
    private volatile transient cy a;
    private byte[] b;

    private a() {
        this.b = null;
        this.a = null;
    }

    public a(cy cyVar) {
        this.b = null;
        this.a = cyVar;
    }

    public static a a(cy cyVar) {
        if (cyVar == null) {
            return null;
        }
        return new a(cyVar);
    }

    public static ek b(ek ekVar, ej ejVar, dg dgVar, cy cyVar) {
        if (ekVar != null) {
            nn nnVarListIterator = ekVar.listIterator();
            while (nnVarListIterator.hasNext()) {
                a aVar = (a) nnVarListIterator.next();
                ((eq) ejVar).h(aVar == null ? cyVar : aVar.d(dgVar, cyVar));
            }
        }
        return ((eq) ejVar).g();
    }

    public static ek c(ek ekVar, ej ejVar) {
        if (ekVar != null) {
            nn nnVarListIterator = ekVar.listIterator();
            while (nnVarListIterator.hasNext()) {
                ((eq) ejVar).h(a((cy) nnVarListIterator.next()));
            }
        }
        return ((eq) ejVar).g();
    }

    public static cy e(a aVar, dg dgVar, cy cyVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.d(dgVar, cyVar);
    }

    private final synchronized byte[] f() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return bArr;
        }
        cy cyVar = this.a;
        ar.q(cyVar);
        return cyVar.m();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        byte[] bArr = new byte[objectInputStream.readInt()];
        this.b = bArr;
        objectInputStream.readFully(bArr);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        byte[] bArrF = f();
        objectOutputStream.writeInt(bArrF.length);
        objectOutputStream.write(bArrF);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.libraries.navigation.internal.ael.cy, java.lang.Object] */
    public final cy d(dg dgVar, cy cyVar) {
        cy cyVar2 = this.a;
        if (cyVar2 != null) {
            return cyVar2;
        }
        synchronized (this) {
            cy cyVar3 = this.a;
            if (cyVar3 != null) {
                return cyVar3;
            }
            byte[] bArr = this.b;
            ar.q(bArr);
            try {
                ?? I = dgVar.i(bArr, com.google.android.libraries.navigation.internal.ael.ar.b());
                this.a = I;
                this.b = null;
                return I;
            } catch (cc unused) {
                return cyVar;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(f(), ((a) obj).f());
    }

    public final int hashCode() {
        return Arrays.hashCode(f());
    }

    public final synchronized String toString() {
        String string;
        if (this.a == null) {
            byte[] bArr = this.b;
            ar.q(bArr);
            string = Arrays.toString(bArr);
        } else {
            string = this.a.toString();
        }
        return b.g(string, "SerializableProto{", "}");
    }
}
