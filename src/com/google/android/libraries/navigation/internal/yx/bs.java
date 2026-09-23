package com.google.android.libraries.navigation.internal.yx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bs implements Serializable, br {
    private static final long serialVersionUID = 0;
    final br a;
    volatile transient boolean b;
    transient Object c;
    private transient cc d = new cc();

    public bs(br brVar) {
        ar.q(brVar);
        this.a = brVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.d = new cc();
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final Object a() {
        if (!this.b) {
            synchronized (this.d) {
                if (!this.b) {
                    Object objA = this.a.a();
                    this.c = objA;
                    this.b = true;
                    return objA;
                }
            }
        }
        return this.c;
    }

    public final String toString() {
        Object obj;
        if (this.b) {
            obj = "<supplier that returned " + String.valueOf(this.c) + ">";
        } else {
            obj = this.a;
        }
        return com.google.android.libraries.navigation.internal.b.b.e(obj, "Suppliers.memoize(", ")");
    }
}
