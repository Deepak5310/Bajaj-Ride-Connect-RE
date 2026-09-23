package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class x extends a {
    public final boolean a;
    public final com.google.android.libraries.navigation.internal.adu.y b = null;
    private final com.google.android.libraries.navigation.internal.db.r c;

    public x(com.google.android.libraries.navigation.internal.db.r rVar, boolean z, com.google.android.libraries.navigation.internal.adu.y yVar) {
        this.c = rVar;
        this.a = z;
    }

    public final float g() {
        return this.c.l().f;
    }

    public final com.google.android.libraries.navigation.internal.oe.x h() {
        return (com.google.android.libraries.navigation.internal.oe.x) al.c(this.c.l().e, this.c.n());
    }

    public final String i() {
        com.google.android.libraries.navigation.internal.db.af afVar = this.c.l().d;
        if (afVar != null) {
            return afVar.a;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.REPORT_INCIDENT;
    }

    public final boolean k() {
        return this.c.p;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return true;
    }
}
