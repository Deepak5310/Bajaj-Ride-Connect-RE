package com.google.android.libraries.navigation.internal.zf;

import java.util.logging.Logger;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends d {
    public static final d a = new g();

    private g() {
    }

    @Override // com.google.android.libraries.navigation.internal.zf.d
    public final com.google.android.libraries.navigation.internal.zd.j a(String str) {
        return new i(Logger.getLogger(str.replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR)));
    }

    public final String toString() {
        return "Default logger backend factory";
    }
}
