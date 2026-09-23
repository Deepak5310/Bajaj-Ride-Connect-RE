package com.google.android.libraries.navigation.internal.hj;

import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "Don't use fake accounts.")
public final class e {
    @Deprecated(message = "Don't use fake accounts.")
    @JvmStatic
    public static final boolean a(String str) {
        return str != null && StringsKt.startsWith$default(str, StringUtils.SPACE, false, 2, (Object) null);
    }
}
