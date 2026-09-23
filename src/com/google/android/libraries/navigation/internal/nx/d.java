package com.google.android.libraries.navigation.internal.nx;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static void a(String str) {
        b(str, "_google_maps_sdk_crash_");
    }

    public static void b(String str, String str2) {
        new File(str, str2).delete();
    }

    public static boolean c(String str) {
        return new File(str, "_google_maps_sdk_crash_").exists();
    }

    public static boolean d(String str, String str2) {
        try {
            return new File(str, str2).createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static void e(String str) {
        d(str, "_google_maps_sdk_crash_");
    }
}
