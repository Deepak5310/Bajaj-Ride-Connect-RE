package com.google.android.libraries.navigation.internal.ye;

import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.di;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.xy.e {
    private final dg a;
    private final ar b;

    private b(dg dgVar) {
        ar arVar = ar.a;
        di diVar = di.a;
        this.b = ar.a;
        this.a = dgVar;
    }

    public static b b(cy cyVar) {
        return new b(cyVar.B());
    }

    @Override // com.google.android.libraries.navigation.internal.xy.e
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        InputStream inputStreamB = c.b(dVar);
        try {
            Object objH = this.a.h(inputStreamB, this.b);
            if (inputStreamB != null) {
                inputStreamB.close();
            }
            return objH;
        } catch (Throwable th) {
            if (inputStreamB != null) {
                try {
                    inputStreamB.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
