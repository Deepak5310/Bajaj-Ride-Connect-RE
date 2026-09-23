package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.aac.bj;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {

    /* JADX INFO: compiled from: PG */
    class a implements as {
        @Override // com.google.android.libraries.navigation.internal.aac.as
        public void a(Throwable th) {
            if (th instanceof CancellationException) {
                return;
            }
            th.getMessage();
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 709)).p("Future resolved as failure");
        }

        @Override // com.google.android.libraries.navigation.internal.aac.as
        public void b(Object obj) {
        }
    }

    public static void a(bj bjVar, Executor executor) {
        com.google.android.libraries.navigation.internal.yu.c.d(bjVar, new a(), executor);
    }
}
