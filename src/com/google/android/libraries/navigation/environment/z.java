package com.google.android.libraries.navigation.environment;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class z implements com.google.android.libraries.navigation.internal.nz.b {
    @Override // com.google.android.libraries.navigation.internal.nz.b
    public final void a(Context context) {
        for (int i = 0; i < 2; i++) {
            try {
                ArrayList arrayList = new ArrayList(3);
                try {
                    for (File file : context.getExternalFilesDirs(null)) {
                        if (file != null) {
                            arrayList.add(new File(new File(com.google.android.libraries.navigation.internal.id.a.b(file), "cache"), "diskcache"));
                        }
                    }
                } catch (RuntimeException unused) {
                }
                arrayList.add(new File(context.getCacheDir(), "diskcache"));
                for (File file2 : (File[]) arrayList.toArray(new File[0])) {
                    com.google.android.libraries.navigation.internal.id.a.d(file2);
                }
                return;
            } catch (RuntimeException unused2) {
            }
        }
    }
}
