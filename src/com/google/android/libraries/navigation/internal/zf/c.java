package com.google.android.libraries.navigation.internal.zf;

import com.google.android.libraries.navigation.internal.zb.t;
import com.google.android.libraries.navigation.internal.zd.ae;
import com.google.android.libraries.navigation.internal.zd.ai;
import com.google.android.libraries.navigation.internal.zd.aj;
import com.google.android.libraries.navigation.internal.zd.l;
import com.google.android.libraries.navigation.internal.zd.n;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends LogRecord {
    private static final Object[] b;
    public final ae a;
    private final com.google.android.libraries.navigation.internal.zd.f c;

    static {
        new b();
        b = new Object[0];
    }

    protected c(com.google.android.libraries.navigation.internal.zd.f fVar, n nVar) {
        super(fVar.m(), null);
        this.c = fVar;
        this.a = ae.g(nVar, fVar.i());
        t tVarF = fVar.f();
        setSourceClassName(tVarF.b());
        setSourceMethodName(tVarF.d());
        setLoggerName(fVar.l());
        setMillis(TimeUnit.NANOSECONDS.toMillis(fVar.e()));
        super.setParameters(b);
    }

    public static void a(com.google.android.libraries.navigation.internal.zd.f fVar, StringBuilder sb) {
        sb.append("  original message: ");
        if (fVar.j() == null) {
            sb.append(l.b(fVar.k()));
        } else {
            sb.append(fVar.j().b);
            sb.append("\n  original arguments:");
            for (Object obj : fVar.D()) {
                sb.append("\n    ");
                sb.append(l.b(obj));
            }
        }
        n nVarI = fVar.i();
        if (nVarI.b() > 0) {
            sb.append("\n  metadata:");
            for (int i = 0; i < nVarI.b(); i++) {
                sb.append("\n    ");
                sb.append(nVarI.c(i).a);
                sb.append(": ");
                sb.append(l.b(nVarI.e(i)));
            }
        }
        sb.append("\n  level: ");
        sb.append(l.b(fVar.m()));
        sb.append("\n  timestamp (nanos): ");
        sb.append(fVar.e());
        sb.append("\n  class: ");
        sb.append(fVar.f().b());
        sb.append("\n  method: ");
        sb.append(fVar.f().d());
        sb.append("\n  line number: ");
        sb.append(fVar.f().a());
    }

    @Override // java.util.logging.LogRecord
    public final String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            com.google.android.libraries.navigation.internal.zd.f fVar = this.c;
            ae aeVar = this.a;
            ai aiVar = (ai) aj.a;
            if (aj.b(fVar, aeVar, aiVar.b)) {
                StringBuilder sb = new StringBuilder();
                com.google.android.libraries.navigation.internal.zd.a.e(fVar, sb);
                aj.c(aeVar, aiVar.a, sb);
                message = sb.toString();
            } else {
                message = aj.a(fVar);
            }
            super.setMessage(message);
        }
        return message;
    }

    @Override // java.util.logging.LogRecord
    public final void setMessage(String str) {
        if (str == null) {
            str = "";
        }
        super.setMessage(str);
    }

    @Override // java.util.logging.LogRecord
    public final void setParameters(Object[] objArr) {
        getMessage();
        if (objArr == null) {
            objArr = b;
        }
        super.setParameters(objArr);
    }

    @Override // java.util.logging.LogRecord
    public final void setResourceBundle(ResourceBundle resourceBundle) {
    }

    @Override // java.util.logging.LogRecord
    public final void setResourceBundleName(String str) {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {\n  message: ");
        sb.append(getMessage());
        sb.append("\n  arguments: ");
        sb.append(getParameters() != null ? Arrays.asList(getParameters()) : "<none>");
        sb.append('\n');
        a(this.c, sb);
        sb.append("\n}");
        return sb.toString();
    }
}
