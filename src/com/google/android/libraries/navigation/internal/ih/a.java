package com.google.android.libraries.navigation.internal.ih;

import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.afo.a {
    final br a;
    volatile transient boolean b;
    transient Object c;

    public a(br brVar) {
        this.a = brVar;
    }

    public static a b(br brVar) {
        return new a(brVar);
    }

    public static a c(Object obj) {
        return b(new bv(obj));
    }

    @Override // com.google.android.libraries.navigation.internal.afo.a
    public final Object a() {
        if (!this.b) {
            synchronized (this) {
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
        return "LazySingleton.of(" + String.valueOf(this.a) + ")";
    }
}
