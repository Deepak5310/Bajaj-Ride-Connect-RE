package com.google.android.libraries.navigation.internal.ie;

import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static final String a(String str) {
        return StringsKt.startsWith$default(str, "//", false, 2, (Object) null) ? "https:".concat(String.valueOf(str)) : str;
    }
}
