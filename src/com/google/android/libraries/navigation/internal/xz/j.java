package com.google.android.libraries.navigation.internal.xz;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static final j a = new j();

    private j() {
    }

    public static final File a(Uri uri) throws com.google.android.libraries.navigation.internal.yb.d {
        if (!uri.getScheme().equals("file")) {
            throw new com.google.android.libraries.navigation.internal.yb.d("Scheme must be 'file'");
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new com.google.android.libraries.navigation.internal.yb.d("Did not expect uri to have query");
        }
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return new File(uri.getPath());
        }
        throw new com.google.android.libraries.navigation.internal.yb.d("Did not expect uri to have authority");
    }
}
