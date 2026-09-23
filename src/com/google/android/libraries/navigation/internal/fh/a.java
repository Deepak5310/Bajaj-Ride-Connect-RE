package com.google.android.libraries.navigation.internal.fh;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static Object a(Callable callable) throws Exception {
        int i = 0;
        do {
            try {
                return callable.call();
            } catch (Exception e) {
                i++;
            }
        } while (i < 2);
        throw e;
    }
}
