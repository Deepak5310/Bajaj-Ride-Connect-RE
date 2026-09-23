package com.google.android.libraries.navigation.internal.xm;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public final br a;
    public final br b;
    private final br c;

    public m(final Context context) {
        this.c = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xm.j
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return context.getPackageName();
            }
        });
        this.a = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xm.k
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return com.google.android.libraries.navigation.internal.fx.j.a.c(context, this.a.a());
            }
        });
        this.b = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xm.l
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return com.google.android.libraries.navigation.internal.fx.j.b(context.getPackageManager(), this.a.a());
            }
        });
    }

    public final String a() {
        return (String) this.c.a();
    }
}
