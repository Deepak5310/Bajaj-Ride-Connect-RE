package com.google.android.libraries.navigation.internal.ag;

import android.content.Context;
import androidx.core.view.GravityCompat;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.q.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements com.google.android.libraries.navigation.internal.ai.b {
    private static final com.google.android.libraries.navigation.internal.ms.c b = ab.a(true);
    private static final com.google.android.libraries.navigation.internal.ms.c c = ab.a(false);
    protected com.google.android.libraries.navigation.internal.ai.b.a a;
    private final ah d;
    private ah e;
    private final String f;
    private final aa g;
    private boolean h = true;
    private final int i;
    private final b j;

    /* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.ag.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PG */
    public enum EnumC0031a {
        FIXED,
        SLIDER_TOP,
        SLIDER_DYNAMIC
    }

    /* JADX INFO: compiled from: PG */
    public enum b {
        FULL,
        MEDIUM,
        MOD_FULL,
        MINI,
        MOD_MINI,
        SUPER_MINI
    }

    public a(Context context, EnumC0031a enumC0031a, com.google.android.libraries.navigation.internal.ai.b.a aVar, ah ahVar, String str, aa aaVar, boolean z, int i, b bVar) {
        this.a = aVar;
        this.d = ahVar;
        this.f = str;
        this.g = aaVar;
        this.i = i;
        this.j = bVar;
        x();
    }

    private final void x() {
        x xVar = this.a.r;
        this.e = xVar != null ? j.j(this.d, xVar) : this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public /* synthetic */ float a() {
        return 1.0f;
    }

    public void aD(com.google.android.libraries.navigation.internal.ai.b.a aVar) {
        if (aVar != this.a) {
            this.a = aVar;
            x();
        }
    }

    public boolean aE() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public float b() {
        return 0.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public int c() {
        return GravityCompat.END;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public int d() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public aa e() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public com.google.android.libraries.navigation.internal.ms.c f() {
        return aE() ? b : c;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public cs.a g() {
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public ah h() {
        return this.a.q;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public ah i() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public ah j() {
        int iOrdinal = this.j.ordinal();
        return (iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5) ? j.g(com.google.android.libraries.navigation.internal.f.d.l) : j.g(com.google.android.libraries.navigation.internal.f.d.k);
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public ap k() {
        int i;
        int iOrdinal = this.j.ordinal();
        if (iOrdinal == 1) {
            i = 56;
        } else if (iOrdinal == 3) {
            i = 48;
        } else if (iOrdinal != 4) {
            i = iOrdinal != 5 ? 64 : 40;
        } else {
            i = 46;
        }
        return com.google.android.libraries.navigation.internal.nc.a.g(i);
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public ap l() {
        return k();
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public String m() {
        return this.f;
    }

    public void n(boolean z) {
        if (z != this.h) {
            this.h = z;
            cy.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public boolean p() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public boolean q() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public boolean r() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public boolean s() {
        return this.j == b.FULL;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public boolean t() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.b
    public boolean u() {
        return false;
    }
}
