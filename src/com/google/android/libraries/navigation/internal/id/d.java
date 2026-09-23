package com.google.android.libraries.navigation.internal.id;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.zb.j;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    private static final j c = j.e("com.google.android.libraries.navigation.internal.id.d");
    public final br a;
    public final br b;
    private final br d;

    public d(Context context, Executor executor) {
        this.a = c(context, false, "testdata", executor);
        this.d = c(context, true, "testdata", executor);
        this.b = c(context, false, "cache", executor);
    }

    public static File a(Context context, boolean z, String str) {
        File dir = null;
        if (!z && a.e()) {
            try {
                dir = context.getExternalFilesDir(null);
            } catch (Exception unused) {
            }
            dir = a.b(dir);
        }
        if (dir == null) {
            dir = context.getDir("", 0);
        }
        return new File(dir, str);
    }

    private static br c(Context context, boolean z, String str, Executor executor) {
        br brVarA = bw.a(new b(context, z, str));
        executor.execute(new c(brVarA));
        return brVarA;
    }

    public final File b() {
        return (File) this.d.a();
    }
}
