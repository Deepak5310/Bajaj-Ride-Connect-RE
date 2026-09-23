package com.google.android.libraries.navigation.internal.xo;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public static final /* synthetic */ int a = 0;
    private static final ArrayMap b = new ArrayMap();

    public static synchronized Uri a(String str) {
        ArrayMap arrayMap = b;
        Uri uri = (Uri) arrayMap.get(str);
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode(str))));
        arrayMap.put(str, uri2);
        return uri2;
    }

    public static String b(Context context, String str) {
        if (str.contains("#")) {
            throw new IllegalArgumentException("The passed in package cannot already have a subpackage: ".concat(String.valueOf(str)));
        }
        return str + "#" + context.getPackageName();
    }
}
