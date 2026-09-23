package com.google.android.libraries.navigation.internal.nu;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static boolean a(Context context) {
        return c(context);
    }

    public static boolean b(Context context) {
        return context.getResources().getConfiguration().screenHeightDp >= 600;
    }

    public static boolean c(Context context) {
        return context.getResources().getConfiguration().screenWidthDp >= 600;
    }
}
