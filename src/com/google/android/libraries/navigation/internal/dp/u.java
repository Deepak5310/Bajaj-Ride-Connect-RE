package com.google.android.libraries.navigation.internal.dp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    final /* synthetic */ v a;

    public u(v vVar) {
        this.a = vVar;
    }

    private static float b(float f, float f2, float f3) {
        return com.google.android.libraries.navigation.internal.df.d.b(f2 + (f3 * com.google.android.libraries.navigation.internal.oe.y.d(f2, f)), 0.0f, 360.0f);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x0097  */
    public final void a(com.google.android.libraries.navigation.internal.cy.g gVar) {
        v vVar = this.a;
        if (vVar.b.k) {
            com.google.android.libraries.navigation.internal.iv.f fVar = vVar.h;
            if (fVar == null || !fVar.y(com.google.android.libraries.navigation.internal.iv.ab.G, false)) {
                this.a.s.j(-1.0f);
                v vVar2 = this.a;
                float f = gVar.f;
                long jA = vVar2.d.a();
                if (f != -1.0f) {
                    v vVar3 = this.a;
                    float f2 = gVar.f;
                    vVar3.t = f2;
                    long j = vVar3.w;
                    if (j != Long.MIN_VALUE) {
                        float f3 = jA - j;
                        if (f3 < 5000.0f) {
                            float f4 = vVar3.v;
                            if (f4 != -1.0f) {
                                vVar3.x = b(f2, f4, f3 / 5000.0f);
                            } else {
                                vVar3.x = f2;
                            }
                        } else {
                            vVar3.x = f2;
                        }
                    } else {
                        vVar3.x = f2;
                    }
                    vVar3.y = 1;
                    vVar3.u = jA;
                } else {
                    v vVar4 = this.a;
                    float f5 = gVar.a;
                    vVar4.v = f5;
                    if (f5 == -1.0f) {
                        vVar4.x = -1.0f;
                    } else {
                        long j2 = vVar4.u;
                        if (j2 != Long.MIN_VALUE) {
                            float f6 = jA - j2;
                            if (f6 < 5000.0f) {
                                float f7 = vVar4.t;
                                if (f7 != -1.0f) {
                                    vVar4.x = b(f5, f7, f6 / 5000.0f);
                                } else {
                                    vVar4.x = f5;
                                }
                            } else {
                                vVar4.x = f5;
                            }
                        } else {
                            vVar4.x = f5;
                        }
                        vVar4.w = jA;
                    }
                    vVar4.y = 0;
                }
                v vVar5 = this.a;
                vVar5.q(new com.google.android.libraries.navigation.internal.dq.a(vVar5.x, gVar.f, gVar.g, gVar.b, 0.0f, gVar.c, gVar.d, gVar.e, com.google.android.libraries.navigation.internal.dq.g.FAST));
            } else {
                this.a.s.j(gVar.f);
                this.a.x = gVar.a;
            }
        } else {
            vVar.y = 0;
            float f8 = gVar.a;
            vVar.x = f8;
            vVar.q(new com.google.android.libraries.navigation.internal.dq.a(f8, gVar.f, gVar.g, gVar.b, 0.0f, gVar.c, gVar.d, gVar.e, com.google.android.libraries.navigation.internal.dq.g.UNKNOWN));
        }
        v vVar6 = this.a;
        if (vVar6.m) {
            boolean zL = vVar6.s.l(vVar6.x);
            synchronized (this.a.r) {
                if (zL) {
                    v vVar7 = this.a;
                    if (vVar7.r.p) {
                        vVar7.r();
                    }
                }
            }
        }
    }
}
