package com.google.android.libraries.navigation.environment;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.google.android.libraries.navigation.internal.nz.b {
    @Override // com.google.android.libraries.navigation.internal.nz.b
    public final void a(Context context) {
        for (int i = 0; i < 2; i++) {
            try {
                File file = new File(context.getFilesDir(), "SavedClientParameters.data.cs");
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            } catch (RuntimeException unused) {
            }
        }
    }
}
