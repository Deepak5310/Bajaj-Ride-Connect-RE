package com.google.android.libraries.navigation.internal.uu;

import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final cs a;
    private boolean b;
    private boolean c;

    public a(cs csVar) {
        ar.q(csVar);
        this.a = csVar;
    }

    private final void d() {
        cy.a(this.a);
    }

    public final void a() {
        ar.k(this.b);
        this.b = false;
        if (this.c) {
            d();
        }
    }

    public final void b() {
        if (this.b) {
            this.c = true;
        } else {
            d();
        }
    }

    public final void c() {
        ar.k(!this.b);
        this.b = true;
        this.c = false;
    }
}
