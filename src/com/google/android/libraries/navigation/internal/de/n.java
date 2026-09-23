package com.google.android.libraries.navigation.internal.de;

import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public n(int i, Class cls, i iVar, ap apVar) {
        super(cls, iVar, apVar, null);
        this.f = i;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009a  */
    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        float degrees;
        float f;
        long j;
        int i = this.f;
        if (i == 0) {
            i.c();
            return;
        }
        if (i == 1) {
            ((i) this.c).a((com.google.android.libraries.navigation.internal.sq.a) aVar);
            return;
        }
        if (i != 2) {
            ((i) this.c).b((com.google.android.libraries.navigation.internal.cy.c) aVar);
            return;
        }
        com.google.android.libraries.navigation.internal.cy.a aVar2 = (com.google.android.libraries.navigation.internal.cy.a) aVar;
        com.google.android.libraries.navigation.internal.cw.p pVar = ((i) this.c).a.e;
        v vVar = (v) pVar;
        if (vVar.r.k) {
            synchronized (vVar.g) {
                if (((v) pVar).t != null) {
                    long jA = ((v) pVar).h.b.a();
                    b bVar = ((v) pVar).t;
                    com.google.android.libraries.navigation.internal.db.r rVarA = ((v) pVar).h.a();
                    if (rVarA != null) {
                        float fMax = (Math.max(0L, jA - com.google.android.libraries.navigation.internal.ja.a.a(rVarA.g)) * 1.5f) / TimeUnit.SECONDS.toMillis(1L);
                        if (fMax < 15.0f && rVarA.t() && rVarA.x()) {
                            float f2 = rVarA.f;
                            if (f2 > 0.0f) {
                                f = rVarA.f();
                                degrees = ((float) Math.toDegrees(1.0d / ((double) f2))) + fMax;
                                j = jA;
                            } else {
                                degrees = Float.MAX_VALUE;
                                f = -1.0f;
                                j = Long.MIN_VALUE;
                            }
                        } else {
                            degrees = Float.MAX_VALUE;
                            f = -1.0f;
                            j = Long.MIN_VALUE;
                        }
                    } else {
                        degrees = Float.MAX_VALUE;
                        f = -1.0f;
                        j = Long.MIN_VALUE;
                    }
                    if (aVar2 != null && aVar2.g() != Float.MAX_VALUE && aVar2.h() != 0.0f) {
                        long j2 = j;
                        long j3 = bVar.d;
                        if (j3 == Long.MIN_VALUE || jA - j3 > 5000) {
                            bVar.d = jA;
                        }
                        if (aVar2.l() && aVar2.g() <= 15.0f) {
                            bVar.a = b.a(bVar.a, aVar2.f(), 0.9f);
                            bVar.b = aVar2.g();
                            bVar.c = jA;
                        } else if (degrees <= 15.0f) {
                            bVar.a = b.a(bVar.a, f + (((-aVar2.h()) * (jA - j2)) / 1000.0f), 0.9f);
                            bVar.b = degrees;
                            bVar.c = jA;
                        } else if (bVar.a != -1.0f && bVar.b != Float.MAX_VALUE) {
                            if (Math.abs(aVar2.h()) > 100.0f) {
                                bVar.a = -1.0f;
                                bVar.b = Float.MAX_VALUE;
                                bVar.c = Long.MIN_VALUE;
                            } else {
                                float f3 = -aVar2.h();
                                float f4 = jA - bVar.c;
                                float f5 = bVar.a;
                                bVar.a = b.a(f5, ((f3 * f4) / 1000.0f) + f5, 0.1f);
                                bVar.b += f4 * 2.5E-4f;
                                bVar.c = jA;
                            }
                        }
                    } else if (degrees <= 15.0f) {
                        bVar.a = b.a(bVar.a, f, 0.9f);
                        bVar.b = degrees;
                        bVar.c = jA;
                    } else {
                        bVar.a = -1.0f;
                        bVar.b = Float.MAX_VALUE;
                        bVar.c = Long.MIN_VALUE;
                    }
                    w wVar = ((v) pVar).h;
                    b bVar2 = ((v) pVar).t;
                    float f6 = bVar2.a;
                    float f7 = bVar2.b;
                    wVar.h = f6;
                    wVar.i = f7;
                    wVar.c();
                }
            }
        }
    }
}
