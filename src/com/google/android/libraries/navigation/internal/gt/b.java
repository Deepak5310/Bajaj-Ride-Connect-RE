package com.google.android.libraries.navigation.internal.gt;

import com.google.android.libraries.navigation.internal.gg.o;
import com.google.android.libraries.navigation.internal.gg.p;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bx;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import javax.net.ssl.SSLException;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.impl.CronetExceptionImpl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static p a(CronetException cronetException) {
        if (cronetException instanceof NetworkException) {
            switch (((NetworkException) cronetException).getErrorCode()) {
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return new p(o.c.c(cronetException));
                case 2:
                    return new p(o.k.c(cronetException));
                case 4:
                    return new p(o.b.c(cronetException));
                default:
                    return new p(o.a.c(cronetException));
            }
        }
        if (cronetException instanceof CronetExceptionImpl) {
            int i = bx.a;
            ar.q(cronetException);
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(cronetException);
            boolean z = false;
            Throwable cause = cronetException;
            Throwable cause2 = cause;
            while (true) {
                cause = cause.getCause();
                if (cause == null) {
                    for (Throwable th : Collections.unmodifiableList(arrayList)) {
                        if ((th instanceof UnknownHostException) || (th instanceof ConnectException) || (th instanceof SSLException)) {
                            return new p(o.k.c(cronetException));
                        }
                    }
                    break;
                }
                arrayList.add(cause);
                if (cause == cause2) {
                    throw new IllegalArgumentException("Loop in causal chain detected.", cause);
                }
                if (z) {
                    cause2 = cause2.getCause();
                }
                z = !z;
            }
        }
        return new p(o.a.c(cronetException));
    }
}
