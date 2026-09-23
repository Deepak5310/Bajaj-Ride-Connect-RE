package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adg.jf;
import com.google.android.libraries.navigation.internal.ael.dg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bd {
    public final bx a;
    public final f b;
    public final ci c;
    public final com.google.android.libraries.navigation.internal.ael.x d = null;

    private bd(bx bxVar, f fVar, ci ciVar) {
        this.a = bxVar;
        this.b = fVar;
        this.c = ciVar;
    }

    public static bd a(byte[] bArr) throws com.google.android.libraries.navigation.internal.ael.cc {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ParsedCommonStyleData.fromProto");
        try {
            com.google.android.libraries.navigation.internal.adh.a aVar = new com.google.android.libraries.navigation.internal.adh.a(com.google.android.libraries.navigation.internal.ael.ar.b());
            try {
                aVar.o(bArr, bArr.length);
                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("ParsedCommonStyleData.fromProto - StyleTransforms");
                try {
                    bx bxVar = new bx(aVar);
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("ParsedCommonStyleData.fromProto - AnnotationAttributeMatcher");
                    try {
                        f fVar = new f(!aVar.b.e(0) ? com.google.android.libraries.navigation.internal.adg.aa.a : (com.google.android.libraries.navigation.internal.adg.aa) ((dg) com.google.android.libraries.navigation.internal.adg.aa.a.aH(7, null)).j(aVar.t, aVar.b.b(0), aVar.b.a(0), aVar.a));
                        if (dVarB3 != null) {
                            Trace.endSection();
                        }
                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("ParsedCommonStyleData.fromProto - TransitionAnimationTable");
                        try {
                            ci ciVar = new ci(!aVar.b.e(1) ? jf.a : (jf) ((dg) jf.a.aH(7, null)).j(aVar.t, aVar.b.b(1), aVar.b.a(1), aVar.a));
                            if (dVarB4 != null) {
                                Trace.endSection();
                            }
                            bd bdVar = new bd(bxVar, fVar, ciVar);
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            return bdVar;
                        } catch (Throwable th) {
                            if (dVarB4 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (dVarB3 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    if (dVarB2 != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new com.google.android.libraries.navigation.internal.ael.cc("Error during lazy parsing " + e.toString());
            }
        } catch (Throwable th7) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
            }
            throw th7;
        }
    }
}
