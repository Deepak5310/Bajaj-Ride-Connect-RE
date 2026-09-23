package com.google.android.libraries.navigation.internal.zu;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.zt.aa;
import com.google.android.libraries.navigation.internal.zt.x;
import com.google.android.libraries.navigation.internal.zt.y;
import com.google.android.libraries.navigation.internal.zt.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static x a(Throwable th, boolean z) {
        StackTraceElement[] stackTrace;
        x xVar = (x) aa.a.q();
        String name = th.getClass().getName();
        if (!xVar.b.H()) {
            xVar.v();
        }
        aa aaVar = (aa) xVar.b;
        name.getClass();
        aaVar.b |= 1;
        aaVar.c = name;
        if (th.getMessage() != null) {
            String message = th.getMessage();
            if (!xVar.b.H()) {
                xVar.v();
            }
            aa aaVar2 = (aa) xVar.b;
            message.getClass();
            aaVar2.b |= 2;
            aaVar2.d = message;
        }
        try {
            stackTrace = th.getStackTrace();
        } catch (NullPointerException unused) {
            stackTrace = null;
        }
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                y yVar = (y) z.a.q();
                if (stackTraceElement != null) {
                    String className = stackTraceElement.getClassName();
                    if (!yVar.b.H()) {
                        yVar.v();
                    }
                    z zVar = (z) yVar.b;
                    className.getClass();
                    zVar.b |= 1;
                    zVar.c = className;
                    String methodName = stackTraceElement.getMethodName();
                    if (!yVar.b.H()) {
                        yVar.v();
                    }
                    z zVar2 = (z) yVar.b;
                    methodName.getClass();
                    zVar2.b |= 2;
                    zVar2.d = methodName;
                    int lineNumber = stackTraceElement.getLineNumber();
                    if (!yVar.b.H()) {
                        yVar.v();
                    }
                    z zVar3 = (z) yVar.b;
                    zVar3.b |= 8;
                    zVar3.f = lineNumber;
                    if (stackTraceElement.getFileName() != null) {
                        String fileName = stackTraceElement.getFileName();
                        if (!yVar.b.H()) {
                            yVar.v();
                        }
                        z zVar4 = (z) yVar.b;
                        fileName.getClass();
                        zVar4.b |= 4;
                        zVar4.e = fileName;
                    }
                }
                if (!xVar.b.H()) {
                    xVar.v();
                }
                aa aaVar3 = (aa) xVar.b;
                z zVar5 = (z) yVar.t();
                zVar5.getClass();
                bz bzVar = aaVar3.e;
                if (!bzVar.c()) {
                    aaVar3.e = bi.A(bzVar);
                }
                aaVar3.e.add(zVar5);
            }
        }
        return xVar;
    }
}
