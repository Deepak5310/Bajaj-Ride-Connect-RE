package com.google.android.libraries.navigation.internal.ft;

import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y implements m {
    public final com.google.android.libraries.navigation.internal.iv.f a;
    private final af b;

    public y(com.google.android.libraries.navigation.internal.iv.f fVar, af afVar) {
        this.a = fVar;
        this.b = afVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ft.m
    public final int a() {
        return ((Integer) this.b.a(new br() { // from class: com.google.android.libraries.navigation.internal.ft.u
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Integer.valueOf(this.a.a.a(z.c, 0));
            }
        })).intValue();
    }

    @Override // com.google.android.libraries.navigation.internal.ft.m
    public final int b() {
        return ((Integer) this.b.a(new br() { // from class: com.google.android.libraries.navigation.internal.ft.x
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Integer.valueOf(this.a.a.a(z.d, 0));
            }
        })).intValue();
    }

    @Override // com.google.android.libraries.navigation.internal.ft.m
    public final String c() {
        return (String) this.b.a(new br() { // from class: com.google.android.libraries.navigation.internal.ft.v
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.a.i(z.a, "");
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ft.m
    public final String d() {
        return (String) this.b.a(new br() { // from class: com.google.android.libraries.navigation.internal.ft.w
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.a.i(z.b, "");
            }
        });
    }
}
