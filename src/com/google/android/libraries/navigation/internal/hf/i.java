package com.google.android.libraries.navigation.internal.hf;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i {
    private static final ThreadLocal a = new ThreadLocal();
    public static final /* synthetic */ int b = 0;

    private static g e() {
        Locale locale = Locale.getDefault();
        ThreadLocal threadLocal = a;
        g gVar = (g) threadLocal.get();
        if (gVar != null && gVar.a.equals(locale)) {
            return gVar;
        }
        g gVar2 = new g(locale);
        threadLocal.set(gVar2);
        return gVar2;
    }

    public abstract double a();

    public abstract int b();

    public abstract h c();

    public final String d() {
        return (c() == h.MILES_P1 || c() == h.KILOMETERS_P1) ? e().b.format(((double) b()) / 1000.0d) : e().c.format(b() / 1000);
    }
}
