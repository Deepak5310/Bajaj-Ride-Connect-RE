package com.google.android.libraries.navigation.internal.vm;

import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zl.o;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static int a(long j, String str) {
        if (aq.c(str)) {
            return 0;
        }
        return b(str + j);
    }

    public static int b(String str) {
        if (aq.c(str)) {
            return 0;
        }
        return o.a.b(str, StandardCharsets.UTF_8).hashCode();
    }

    public static int c(long j, String str) {
        if (aq.c(str)) {
            return 0;
        }
        return b(str + j);
    }
}
