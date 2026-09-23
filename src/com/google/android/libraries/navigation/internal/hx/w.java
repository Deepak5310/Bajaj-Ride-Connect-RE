package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements ThreadFactory {
    final AtomicInteger a = new AtomicInteger(1);
    private final ap b;

    public w(ap apVar) {
        this.b = apVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        ap apVar = this.b;
        String strConcat = apVar.N;
        int andIncrement = this.a.getAndIncrement();
        if (apVar.j()) {
            Locale locale = Locale.US;
            ar.k(apVar.j());
            strConcat = String.format(locale, "%s_%d", strConcat, Integer.valueOf(andIncrement));
            if (strConcat.length() > 15) {
                String string = Integer.toString(andIncrement, 10);
                strConcat = String.valueOf(strConcat.substring(0, 15 - string.length())).concat(String.valueOf(string));
            }
        }
        x xVar = new x(runnable, this.b, strConcat);
        xVar.setDaemon(false);
        return xVar;
    }
}
