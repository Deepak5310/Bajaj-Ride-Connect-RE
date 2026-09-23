package com.google.android.libraries.navigation.internal.lc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ac {
    public static final ac a = new ac(true, null, null);
    final boolean b;
    final String c;
    final Throwable d;

    public ac(boolean z, String str, Throwable th) {
        this.b = z;
        this.c = str;
        this.d = th;
    }

    static ac b(String str) {
        return new ac(false, str, null);
    }

    static ac c(String str, Throwable th) {
        return new ac(false, str, th);
    }

    public void a() {
    }
}
