package com.google.android.libraries.navigation.internal.zj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final e a;
    private static final String[] b = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};

    static {
        e gVar;
        for (int i = 0; i < 2; i++) {
            gVar = null;
            try {
                gVar = (e) Class.forName(b[i]).asSubclass(e.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (gVar != null) {
                a = gVar;
            }
        }
        gVar = new g();
        a = gVar;
    }

    public static StackTraceElement a(Class cls, int i) {
        b.d(cls, "target");
        if (i < 0) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "skip count cannot be negative: "));
        }
        return a.a(cls, i + 1);
    }
}
