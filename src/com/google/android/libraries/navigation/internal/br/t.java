package com.google.android.libraries.navigation.internal.br;

import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.br.t");

    public static String a(Resources resources, String str, String str2, String str3) {
        if (str3 == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('Z')).p("Cannot get transfer description for null head sign");
            str3 = "";
        }
        return aq.c(str2) ? resources.getString(com.google.android.libraries.navigation.internal.qr.e.v, str, str3) : resources.getString(com.google.android.libraries.navigation.internal.qr.e.w, str, str2, str3);
    }
}
