package com.google.android.libraries.navigation.internal.kj;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static final fy a = fy.u("en-GB", "fr-CA", "pt-BR", "pt-PT", "ro-MD", "sr-ME", "zh-CN", "zh-TW");

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String str = language + "-" + locale.getCountry().toUpperCase(Locale.US);
        return a.contains(str) ? str : language;
    }
}
