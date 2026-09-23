package com.google.android.libraries.navigation.internal.lh;

import android.net.Uri;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    public static final /* synthetic */ int a = 0;
    private static final Uri b;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        b = uri;
        uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
