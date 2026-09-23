package com.google.android.libraries.navigation.internal.tu;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.acd.qc;
import com.google.android.libraries.navigation.internal.acd.qd;
import com.google.android.libraries.navigation.internal.acd.qf;
import com.google.android.libraries.navigation.internal.gq.al;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yx.ao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o implements u {
    private final Executor a;
    private final com.google.android.libraries.navigation.internal.fz.d b;
    private final al c;
    private final eo d;

    public o(al alVar, Executor executor, com.google.android.libraries.navigation.internal.fz.d dVar, eo eoVar) {
        this.c = alVar;
        this.a = executor;
        this.b = dVar;
        this.d = eoVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final qf a(qd qdVar, String str) {
        ca caVar = new ca();
        ao aoVar = new ao(caVar, this.c.a(qdVar, new n(caVar), this.a));
        try {
            return (qf) ((bj) aoVar.a).get(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1857)).s("ExecutionException while synthesizing %s", str);
            return null;
        } catch (TimeoutException unused3) {
            ((com.google.android.libraries.navigation.internal.gg.b) aoVar.b).a();
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.tu.u
    public final boolean b(t tVar, String str) {
        qd qdVar;
        qf qfVarA;
        g gVar = (g) tVar;
        com.google.android.libraries.navigation.internal.ael.x xVar = gVar.b;
        if (xVar == null) {
            qdVar = null;
        } else {
            String languageTag = Locale.getDefault().toLanguageTag();
            qc qcVar = (qc) qd.a.q();
            if (!qcVar.b.H()) {
                qcVar.v();
            }
            qd qdVar2 = (qd) qcVar.b;
            qdVar2.b |= 1;
            qdVar2.c = xVar;
            if (!qcVar.b.H()) {
                qcVar.v();
            }
            eo eoVar = this.d;
            qd qdVar3 = (qd) qcVar.b;
            languageTag.getClass();
            qdVar3.b |= 2;
            qdVar3.d = languageTag;
            if (eoVar.e()) {
                String strA = eoVar.a();
                if (!qcVar.b.H()) {
                    qcVar.v();
                }
                qd qdVar4 = (qd) qcVar.b;
                strA.getClass();
                qdVar4.b |= 4;
                qdVar4.e = strA;
            } else {
                com.google.android.libraries.navigation.internal.fz.d dVar = this.b;
                if ((dVar.R().b & 512) != 0) {
                    String str2 = dVar.R().f321n;
                    if (!qcVar.b.H()) {
                        qcVar.v();
                    }
                    qd qdVar5 = (qd) qcVar.b;
                    str2.getClass();
                    qdVar5.b |= 4;
                    qdVar5.e = str2;
                }
            }
            qdVar = (qd) qcVar.t();
        }
        if (qdVar != null && (qfVarA = a(qdVar, gVar.a)) != null && (qfVarA.b & 1) != 0) {
            com.google.android.libraries.navigation.internal.ael.x xVar2 = qfVarA.c;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
                try {
                    xVar2.p(fileOutputStream);
                    return true;
                } catch (IOException unused) {
                } finally {
                    fileOutputStream.close();
                }
            } catch (FileNotFoundException | IOException unused2) {
            }
        }
        return false;
    }
}
