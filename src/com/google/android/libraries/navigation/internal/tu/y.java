package com.google.android.libraries.navigation.internal.tu;

import android.app.Application;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public final m a;

    public y(Application application, com.google.android.libraries.navigation.internal.sk.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar2) {
        Executor executor = (Executor) (dVar.e ? dVar.b : dVar.d).a();
        final m mVar = new m(executor, aVar, dVar2, application.getDir("tts-cache", 0).getAbsolutePath(), dVar2.R().k > 0 ? dVar2.R().k : 52428800L, dVar2.R().l > 0 ? dVar2.R().l : 1000);
        executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.tu.k
            @Override // java.lang.Runnable
            public final void run() {
                mVar.d();
            }
        });
        this.a = mVar;
    }

    public final File a(x xVar) {
        String strA;
        m mVar = this.a;
        String strB = b(xVar);
        if (!mVar.f(strB) || (strA = this.a.a(strB)) == null) {
            return null;
        }
        return new File(strA);
    }

    static String b(x xVar) {
        i iVar = (i) xVar;
        String strA = iVar.e != 0 ? w.a(1) : "";
        String str = iVar.d;
        return Integer.toString(str.isEmpty() ? Arrays.hashCode(new Object[]{iVar.a, iVar.b, Integer.valueOf(iVar.c), strA}) : Arrays.hashCode(new Object[]{iVar.a, iVar.b, Integer.valueOf(iVar.c), strA, str}));
    }
}
