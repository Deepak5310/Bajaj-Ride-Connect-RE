package com.google.android.libraries.navigation.internal.tp;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static void a(RemoteViews remoteViews, int i, int i2) {
        remoteViews.setInt(i, "setBackgroundColor", i2);
    }

    public static void b(RemoteViews remoteViews, int i, Bitmap bitmap) {
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(i, bitmap);
        } else {
            remoteViews.setImageViewResource(i, com.google.android.libraries.navigation.internal.dw.c.v);
        }
    }

    public static void c(RemoteViews remoteViews, int i, CharSequence charSequence) {
        remoteViews.setTextViewText(i, charSequence);
        remoteViews.setViewVisibility(i, true != TextUtils.isEmpty(charSequence) ? 0 : 8);
    }
}
