package com.google.android.libraries.navigation.internal.nz;

import android.content.Context;
import com.google.android.libraries.navigation.internal.nx.d;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final synchronized boolean a(Context context, ev evVar) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!new File(absolutePath, "_google_maps_sdk_recovery_needed_").exists()) {
            return false;
        }
        try {
            no it2 = evVar.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).a(context);
            }
            d.b(absolutePath, "_google_maps_sdk_recovery_needed_");
            for (String str : new File(absolutePath).list(new FilenameFilter() { // from class: com.google.android.libraries.navigation.internal.nx.c
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    return str2.startsWith("_google_maps_sdk_crash_count_");
                }
            })) {
                d.b(absolutePath, str);
            }
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
