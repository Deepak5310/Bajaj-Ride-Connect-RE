package com.google.android.libraries.navigation.internal.ct;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.os.BuildCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final Context a;

    public a(Context context) {
        this.a = context;
    }

    public final boolean a(String str) {
        if (str.equals("gmm.READ_MEDIA_IMAGES_AND_VIDEO")) {
            return a("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (str.equals("gmm.PARTIAL_READ_MEDIA_IMAGES_AND_VIDEO")) {
            return BuildCompat.isAtLeastU() && a("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") && !a("gmm.READ_MEDIA_IMAGES_AND_VIDEO");
        }
        return ((str.equals("android.permission.ACCESS_BACKGROUND_LOCATION") || str.equals("android.permission.ACTIVITY_RECOGNITION")) && Build.VERSION.SDK_INT < 29) || ContextCompat.checkSelfPermission(this.a, str) == 0;
    }
}
