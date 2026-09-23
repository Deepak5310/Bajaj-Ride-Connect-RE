package com.google.android.libraries.navigation.internal.aac;

import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi {
    private final com.google.android.libraries.navigation.internal.yx.cc a = new com.google.android.libraries.navigation.internal.yx.cc();
    private final String b;
    private volatile Logger c;

    public bi(Class cls) {
        this.b = cls.getName();
    }

    final Logger a() {
        Logger logger = this.c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.a) {
            Logger logger2 = this.c;
            if (logger2 != null) {
                return logger2;
            }
            Logger logger3 = Logger.getLogger(this.b);
            this.c = logger3;
            return logger3;
        }
    }
}
