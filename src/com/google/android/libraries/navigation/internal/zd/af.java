package com.google.android.libraries.navigation.internal.zd;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af {
    public static final ah a = a(ah.d);

    private static ah a(String[] strArr) {
        com.google.android.libraries.navigation.internal.ze.d dVar;
        try {
            dVar = com.google.android.libraries.navigation.internal.ze.e.a;
        } catch (NoClassDefFoundError unused) {
            dVar = null;
        }
        if (dVar != null) {
            return dVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (ah) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
