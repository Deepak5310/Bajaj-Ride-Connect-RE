package com.google.android.libraries.navigation.internal.fd;

import android.content.Context;
import com.google.android.libraries.navigation.internal.zr.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum c {
    UNSUCCESSFUL_STARTUP,
    JAVA,
    JAVA_FOREGROUND,
    JAVA_BACKGROUND,
    NATIVE,
    ANR;

    static {
        new h();
        new com.google.android.libraries.navigation.internal.fe.h("java-crashloop", z.c);
        int i = z.e;
        int i2 = b.d;
        new com.google.android.libraries.navigation.internal.fe.h("java-fg-crashloop", i);
        new com.google.android.libraries.navigation.internal.fe.h("java-bg-crashloop", z.f);
        new e() { // from class: com.google.android.libraries.navigation.internal.fd.a
            {
                new com.google.android.libraries.navigation.internal.fe.h("anr-crashloop", z.g);
                int i3 = b.d;
            }

            @Override // com.google.android.libraries.navigation.internal.fd.e
            public final void a(Context context) {
            }
        };
    }
}
