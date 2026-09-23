package com.google.android.libraries.navigation.internal.mh;

import android.content.ContentResolver;
import android.net.Uri;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {
    public static final Uri a = Uri.parse("content://com.google.settings/partner");

    public static String b(ContentResolver contentResolver, String str) {
        return a(contentResolver, a, str);
    }

    public static String c(ContentResolver contentResolver, String str, String str2) {
        String strB = b(contentResolver, str);
        return strB == null ? str2 : strB;
    }
}
