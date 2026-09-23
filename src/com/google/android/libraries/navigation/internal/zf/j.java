package com.google.android.libraries.navigation.internal.zf;

import com.google.android.libraries.navigation.internal.zb.am;
import com.google.android.libraries.navigation.internal.zb.t;
import com.google.android.libraries.navigation.internal.zd.ag;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends ag {
    public static final ag a = new j();

    private j() {
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ag
    public final t a(Class<?> cls, int i) {
        StackTraceElement stackTraceElementA = com.google.android.libraries.navigation.internal.zj.a.a(cls, i + 1);
        return stackTraceElementA != null ? new am(stackTraceElementA) : t.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ag
    public final String b(Class<? extends com.google.android.libraries.navigation.internal.zb.a<?>> cls) {
        StackTraceElement stackTraceElementA = com.google.android.libraries.navigation.internal.zj.a.a(cls, 1);
        if (stackTraceElementA != null) {
            return stackTraceElementA.getClassName();
        }
        throw new IllegalStateException("no caller found on the stack for: ".concat(String.valueOf(cls.getName())));
    }

    public final String toString() {
        return "Default stack-based caller finder";
    }
}
