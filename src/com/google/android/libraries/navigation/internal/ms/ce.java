package com.google.android.libraries.navigation.internal.ms;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ce {
    private static final cd a = new cd();

    static final cd a(String str, Class cls) {
        if (!c()) {
            return null;
        }
        String name = cls.getName();
        if (name.startsWith("com.google.android.apps")) {
            name = name.substring(23);
        }
        return b(str.concat(String.valueOf(name)));
    }

    public static cd b(String str) {
        Trace.beginSection(com.google.android.libraries.navigation.internal.yx.bp.b(str, 127));
        return a;
    }

    static boolean c() {
        return cf.b && Trace.isEnabled();
    }

    static cd d() {
        if (c()) {
            return b("ViewHierarchyFactory.create");
        }
        return null;
    }
}
