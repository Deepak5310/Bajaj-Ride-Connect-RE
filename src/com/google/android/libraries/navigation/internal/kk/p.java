package com.google.android.libraries.navigation.internal.kk;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.zr.ef;
import com.google.android.libraries.navigation.internal.zr.eg;
import com.google.android.libraries.navigation.internal.zr.eh;
import com.google.android.libraries.navigation.internal.zr.ei;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static eh a(Throwable th) {
        StackTraceElement[] stackTrace;
        eh ehVar = (eh) ei.a.q();
        String name = th.getClass().getName();
        if (!ehVar.b.H()) {
            ehVar.v();
        }
        ei eiVar = (ei) ehVar.b;
        name.getClass();
        eiVar.b |= 1;
        eiVar.c = name;
        try {
            stackTrace = th.getStackTrace();
        } catch (NullPointerException unused) {
            stackTrace = null;
        }
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                ef efVar = (ef) eg.a.q();
                if (stackTraceElement != null) {
                    String className = stackTraceElement.getClassName();
                    if (!efVar.b.H()) {
                        efVar.v();
                    }
                    eg egVar = (eg) efVar.b;
                    className.getClass();
                    egVar.b |= 1;
                    egVar.c = className;
                    String methodName = stackTraceElement.getMethodName();
                    if (!efVar.b.H()) {
                        efVar.v();
                    }
                    eg egVar2 = (eg) efVar.b;
                    methodName.getClass();
                    egVar2.b |= 2;
                    egVar2.d = methodName;
                    int lineNumber = stackTraceElement.getLineNumber();
                    if (!efVar.b.H()) {
                        efVar.v();
                    }
                    eg egVar3 = (eg) efVar.b;
                    egVar3.b |= 8;
                    egVar3.f = lineNumber;
                    String fileName = stackTraceElement.getFileName();
                    if (fileName != null) {
                        if (!efVar.b.H()) {
                            efVar.v();
                        }
                        eg egVar4 = (eg) efVar.b;
                        egVar4.b |= 4;
                        egVar4.e = fileName;
                    }
                }
                if (!ehVar.b.H()) {
                    ehVar.v();
                }
                ei eiVar2 = (ei) ehVar.b;
                eg egVar5 = (eg) efVar.t();
                egVar5.getClass();
                bz bzVar = eiVar2.d;
                if (!bzVar.c()) {
                    eiVar2.d = bi.A(bzVar);
                }
                eiVar2.d.add(egVar5);
            }
        }
        return ehVar;
    }
}
