package com.google.android.libraries.navigation.internal.nx;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final AtomicInteger a = new AtomicInteger(2);

    public static synchronized void a(Context context) {
        int i;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String[] list = new File(absolutePath).list(new FilenameFilter() { // from class: com.google.android.libraries.navigation.internal.nx.b
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return str.startsWith("_google_maps_sdk_crash_count_");
            }
        });
        int i2 = 0;
        if (list != null) {
            int i3 = 0;
            for (String str : list) {
                try {
                    i = Integer.parseInt(str.substring(str.lastIndexOf("_") + 1));
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                if (i > i3) {
                    i3 = i;
                }
            }
            i2 = i3;
        }
        int i4 = i2 + 1;
        String strB = com.google.android.libraries.navigation.internal.b.b.b(i2, "_google_maps_sdk_crash_count_");
        if (i4 >= a.get()) {
            if (d.d(absolutePath, "_google_maps_sdk_recovery_needed_")) {
                d.b(absolutePath, strB);
            }
        } else if (d.d(absolutePath, com.google.android.libraries.navigation.internal.b.b.b(i4, "_google_maps_sdk_crash_count_")) && i4 > 1) {
            d.b(absolutePath, strB);
        }
    }

    public static void b(int i) {
        a.set(i);
    }
}
