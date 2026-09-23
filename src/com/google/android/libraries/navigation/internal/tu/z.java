package com.google.android.libraries.navigation.internal.tu;

import android.app.Application;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z {
    public static final byte[] a = new byte[65536];
    private final Application b;

    public z(Application application) {
        this.b = application;
    }

    final boolean a() {
        try {
            StatFs statFs = new StatFs(this.b.getFilesDir().getAbsolutePath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}
