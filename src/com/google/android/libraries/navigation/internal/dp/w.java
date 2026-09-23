package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public w(int i, Class cls, r rVar, ap apVar) {
        super(cls, rVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        boolean z;
        switch (this.f) {
            case 0:
                k kVar = ((r) this.c).a.f407n;
                if (kVar.o != null && kVar.s) {
                    kVar.o.e();
                } else {
                    kVar.y = true;
                }
                break;
            case 1:
                ((r) this.c).c((com.google.android.libraries.navigation.internal.db.s) aVar);
                break;
            case 2:
                r rVar = (r) this.c;
                com.google.android.libraries.navigation.internal.cy.f fVar = (com.google.android.libraries.navigation.internal.cy.f) aVar;
                v vVar = rVar.a;
                int i = fVar.a;
                int i2 = vVar.y;
                if (i2 == 0 && vVar.z && i == -1) {
                    i = -1;
                    z = true;
                } else {
                    z = false;
                }
                vVar.z = false;
                if (vVar.b.k && i2 == 1) {
                    vVar.A = 3;
                    vVar.f407n.c(3);
                } else if (vVar.A != i && !z) {
                    vVar.A = i;
                    vVar.f407n.c(i);
                    ((com.google.android.libraries.navigation.internal.cw.m) rVar.a.g.a()).c();
                }
                rVar.a.f.d(fVar);
                break;
            case 3:
                ((r) this.c).e();
                break;
            case 4:
                ((r) this.c).f();
                break;
            case 5:
                ((r) this.c).b((com.google.android.libraries.navigation.internal.cy.a) aVar);
                break;
            case 6:
                ((r) this.c).a((com.google.android.libraries.navigation.internal.dh.p) aVar);
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                ((r) this.c).d((com.google.android.libraries.navigation.internal.cw.d) aVar);
                break;
            default:
                r.g();
                break;
        }
    }
}
