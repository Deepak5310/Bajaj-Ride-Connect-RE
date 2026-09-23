package com.google.android.libraries.navigation.internal.afx;

import java.nio.charset.Charset;
import java.util.logging.Logger;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    static {
        Charset.forName(CharEncoding.US_ASCII);
        Logger logger = bo.a;
    }

    public static void a(String str, com.google.android.libraries.navigation.internal.aga.ax axVar) {
        boolean z = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        int i = bl.b;
        new bm(str, z, axVar);
    }
}
