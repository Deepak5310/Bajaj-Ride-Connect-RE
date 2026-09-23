package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq {
    public static by a() {
        return new by() { // from class: com.google.android.libraries.navigation.internal.ms.ao
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return Boolean.valueOf(aq.b(context));
            }
        };
    }

    public static boolean b(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean c(Context context) {
        return !b(context);
    }
}
