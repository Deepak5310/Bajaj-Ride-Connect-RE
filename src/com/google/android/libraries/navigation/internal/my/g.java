package com.google.android.libraries.navigation.internal.my;

import android.content.Context;
import android.content.res.Resources;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static String a(int i, Context context) {
        try {
            return String.format(Locale.US, "R.%s.%s", context.getResources().getResourceTypeName(i), context.getResources().getResourceEntryName(i));
        } catch (Resources.NotFoundException unused) {
            return com.google.android.libraries.navigation.internal.b.b.j(i, "Unknown Android resource (", ")");
        }
    }
}
