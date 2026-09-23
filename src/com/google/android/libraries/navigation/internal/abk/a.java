package com.google.android.libraries.navigation.internal.abk;

import android.content.Context;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.nz.b;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements b {
    private static final String a = "a";

    private static final void b(String str, String str2) {
        String str3 = a;
        p.f(str3, 4);
        if (new File(str, str2).delete()) {
            p.f(str3, 4);
        } else {
            p.f(str3, 4);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.nz.b
    public final void a(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        b(absolutePath, "SavedClientParameters.data.cs");
        b(absolutePath, "DATA_ServerControlledParametersManager.data.v1.".concat(String.valueOf(context.getPackageName())));
    }
}
