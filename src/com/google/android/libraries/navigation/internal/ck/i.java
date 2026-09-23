package com.google.android.libraries.navigation.internal.ck;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements ck {
    private final com.google.android.libraries.navigation.internal.ol.j a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private boolean c;

    public i(com.google.android.libraries.navigation.internal.ol.j clientAreaScreenSpace, com.google.android.libraries.navigation.internal.afo.a areas) {
        Intrinsics.checkNotNullParameter(clientAreaScreenSpace, "clientAreaScreenSpace");
        Intrinsics.checkNotNullParameter(areas, "areas");
        this.a = clientAreaScreenSpace;
        this.b = areas;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final float a() {
        return this.a.c().b.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void b() {
        synchronized (this) {
            ((com.google.android.libraries.navigation.internal.ol.a) this.b.a()).d(this.a);
            ((com.google.android.libraries.navigation.internal.ol.a) this.b.a()).c(this.a);
            this.c = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void c() {
        synchronized (this) {
            if (this.c) {
                return;
            }
            ((com.google.android.libraries.navigation.internal.ol.a) this.b.a()).d(this.a);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void d(float f) {
        synchronized (this) {
            if (this.c) {
                return;
            }
            com.google.android.libraries.navigation.internal.ol.i iVarC = this.a.c();
            iVarC.c(f, iVarC.a);
            this.a.d(iVarC);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void e(float f) {
        synchronized (this) {
            if (this.c) {
                return;
            }
            com.google.android.libraries.navigation.internal.ol.i iVarC = this.a.c();
            iVarC.d(f, com.google.android.libraries.navigation.internal.ol.h.PIXEL);
            this.a.d(iVarC);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void f() {
        synchronized (this) {
            if (this.c) {
                return;
            }
            ((com.google.android.libraries.navigation.internal.ol.a) this.b.a()).e(this.a);
            Unit unit = Unit.INSTANCE;
        }
    }
}
