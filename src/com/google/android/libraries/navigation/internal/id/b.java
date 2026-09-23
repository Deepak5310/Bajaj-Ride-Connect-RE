package com.google.android.libraries.navigation.internal.id;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements br {
    private final Context a;
    private final boolean b;
    private final String c;

    public b(Context context, boolean z, String str) {
        this.a = context;
        this.b = z;
        this.c = str;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        File fileA = d.a(this.a, this.b, this.c);
        try {
            if (!fileA.exists() && !fileA.mkdirs()) {
                fileA.getPath();
            }
        } catch (SecurityException unused) {
            ((h) j.b.F(721)).s("Unable to create directory: %s", fileA.getPath());
        }
        return fileA;
    }
}
