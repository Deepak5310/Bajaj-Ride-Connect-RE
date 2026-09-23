package com.google.android.libraries.navigation.internal.xt;

import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.ael.dr;
import com.google.android.libraries.navigation.internal.ael.ee;
import com.google.android.libraries.navigation.internal.yz.gj;
import com.google.android.libraries.navigation.internal.yz.lg;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bo implements com.google.android.libraries.navigation.internal.xy.e {
    @Override // com.google.android.libraries.navigation.internal.xy.e
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        long j;
        String strX;
        com.google.android.libraries.navigation.internal.xs.f fVar;
        InputStream inputStreamB = com.google.android.libraries.navigation.internal.ye.c.b(dVar);
        try {
            com.google.android.libraries.navigation.internal.ael.ac acVarJ = com.google.android.libraries.navigation.internal.ael.ac.J(inputStreamB);
            com.google.android.libraries.navigation.internal.xs.k kVar = com.google.android.libraries.navigation.internal.xs.k.a;
            int iK = acVarJ.k();
            if (iK > 1) {
                throw new com.google.android.libraries.navigation.internal.ael.cc("Unsupported version: " + iK + ". Current version is: 1");
            }
            acVarJ.k();
            int iE = acVarJ.e(acVarJ.n());
            com.google.android.libraries.navigation.internal.ael.ar arVar = com.google.android.libraries.navigation.internal.ael.ar.a;
            di diVar = di.a;
            com.google.android.libraries.navigation.internal.ael.ar arVar2 = com.google.android.libraries.navigation.internal.ael.ar.a;
            com.google.android.libraries.navigation.internal.ael.bi biVarU = com.google.android.libraries.navigation.internal.xs.c.a.u();
            try {
                try {
                    try {
                        dr drVarB = di.a.b(biVarU);
                        drVarB.h(biVarU, com.google.android.libraries.navigation.internal.ael.ad.p(acVarJ), arVar2);
                        drVarB.f(biVarU);
                        com.google.android.libraries.navigation.internal.ael.bi.I(biVarU);
                        com.google.android.libraries.navigation.internal.xs.c cVar = (com.google.android.libraries.navigation.internal.xs.c) biVarU;
                        acVarJ.A(iE);
                        byte[] bArrF = acVarJ.F();
                        com.google.android.libraries.navigation.internal.xs.e eVar = new com.google.android.libraries.navigation.internal.xs.e();
                        try {
                            eVar.a.setInput(bArrF);
                            try {
                                com.google.android.libraries.navigation.internal.ael.ac acVarJ2 = com.google.android.libraries.navigation.internal.ael.ac.J(new com.google.android.libraries.navigation.internal.xs.d(eVar));
                                int iJ = acVarJ2.j();
                                if (iJ < 0) {
                                    throw new com.google.android.libraries.navigation.internal.ael.cc("Negative number of flags");
                                }
                                gj gjVar = new gj(lg.a);
                                long j2 = 0;
                                for (int i = 0; i < iJ; i++) {
                                    long jR = acVarJ2.r();
                                    int i2 = (int) jR;
                                    long j3 = jR >>> 3;
                                    if (j3 == 0) {
                                        j = 0;
                                        strX = acVarJ2.x();
                                    } else {
                                        long j4 = j3 + j2;
                                        if (j4 > 2305843009213693951L) {
                                            throw new com.google.android.libraries.navigation.internal.ael.cc("Flag name larger than max size");
                                        }
                                        j = j4;
                                        strX = null;
                                    }
                                    int i3 = i2 & 7;
                                    if (i3 == 0 || i3 == 1) {
                                        fVar = new com.google.android.libraries.navigation.internal.xs.f(j, strX, i3, 0L, null);
                                    } else if (i3 == 2) {
                                        fVar = new com.google.android.libraries.navigation.internal.xs.f(j, strX, i3, acVarJ2.r(), null);
                                    } else if (i3 == 3) {
                                        fVar = new com.google.android.libraries.navigation.internal.xs.f(j, strX, i3, Double.doubleToRawLongBits(acVarJ2.b()), null);
                                    } else if (i3 == 4) {
                                        fVar = new com.google.android.libraries.navigation.internal.xs.f(j, strX, i3, 0L, acVarJ2.x());
                                    } else {
                                        if (i3 != 5) {
                                            throw new com.google.android.libraries.navigation.internal.ael.cc(com.google.android.libraries.navigation.internal.b.b.b(i3, "Unrecognized flag type "));
                                        }
                                        fVar = new com.google.android.libraries.navigation.internal.xs.f(j, strX, i3, 0L, acVarJ2.F());
                                    }
                                    long j5 = fVar.a;
                                    if (j5 != 0) {
                                        j2 = j5;
                                    }
                                    gjVar.n(fVar);
                                }
                                com.google.android.libraries.navigation.internal.xs.g gVar = new com.google.android.libraries.navigation.internal.xs.g(gjVar.i());
                                eVar.a.reset();
                                eVar.close();
                                com.google.android.libraries.navigation.internal.xs.k kVar2 = new com.google.android.libraries.navigation.internal.xs.k(gVar, cVar);
                                if (inputStreamB != null) {
                                    inputStreamB.close();
                                }
                                return kVar2;
                            } catch (Throwable th) {
                                eVar.a.reset();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                eVar.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        if (e.getCause() instanceof com.google.android.libraries.navigation.internal.ael.cc) {
                            throw ((com.google.android.libraries.navigation.internal.ael.cc) e.getCause());
                        }
                        throw new com.google.android.libraries.navigation.internal.ael.cc(e);
                    }
                } catch (RuntimeException e2) {
                    if (e2.getCause() instanceof com.google.android.libraries.navigation.internal.ael.cc) {
                        throw ((com.google.android.libraries.navigation.internal.ael.cc) e2.getCause());
                    }
                    throw e2;
                }
            } catch (com.google.android.libraries.navigation.internal.ael.cc e3) {
                if (e3.a) {
                    throw new com.google.android.libraries.navigation.internal.ael.cc(e3);
                }
                throw e3;
            } catch (ee e4) {
                throw e4.a();
            }
        } catch (Throwable th4) {
            if (inputStreamB == null) {
                throw th4;
            }
            try {
                inputStreamB.close();
                throw th4;
            } catch (Throwable th5) {
                th4.addSuppressed(th5);
                throw th4;
            }
        }
    }
}
