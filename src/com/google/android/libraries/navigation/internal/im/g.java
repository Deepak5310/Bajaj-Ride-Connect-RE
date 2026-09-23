package com.google.android.libraries.navigation.internal.im;

import com.google.android.libraries.navigation.internal.fw.u;
import com.google.android.libraries.navigation.internal.fw.v;
import com.google.android.libraries.navigation.internal.gg.k;
import com.google.android.libraries.navigation.internal.gk.ao;
import com.google.android.libraries.navigation.internal.yx.an;
import j$.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.chromium.net.RequestFinishedInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends RequestFinishedInfo.Listener {
    private final com.google.android.libraries.navigation.internal.afo.a a;

    public g(Executor executor, com.google.android.libraries.navigation.internal.afo.a aVar) {
        super(executor);
        this.a = aVar;
    }

    private static long a(Date date) {
        if (date != null) {
            return TimeUnit.MILLISECONDS.toNanos(date.getTime());
        }
        return 0L;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Listener
    public final void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        Collection<Object> annotations = requestFinishedInfo.getAnnotations();
        if (annotations == null) {
            return;
        }
        for (Object obj : annotations) {
            if (obj instanceof ao) {
                ao aoVar = (ao) obj;
                if (requestFinishedInfo.getFinishedReason() == 0) {
                    RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
                    u uVar = new u();
                    uVar.a = ((Long) an.i(metrics.getReceivedByteCount()).e(0L)).longValue();
                    uVar.b = ((Long) an.i(metrics.getSentByteCount()).e(0L)).longValue();
                    ((v) this.a.a()).g(uVar, a(metrics.getSendingEnd()), a(metrics.getResponseStart()), a(metrics.getRequestEnd()), aoVar.b());
                    k kVarA = aoVar.a();
                    Date sendingStart = metrics.getSendingStart();
                    if (sendingStart != null) {
                        kVarA.c(Duration.ofMillis(sendingStart.getTime()));
                    }
                    Date sendingEnd = metrics.getSendingEnd();
                    if (sendingEnd != null) {
                        kVarA.e(Duration.ofMillis(sendingEnd.getTime()));
                    }
                    Date responseStart = metrics.getResponseStart();
                    if (responseStart != null) {
                        kVarA.b(Duration.ofMillis(responseStart.getTime()));
                    }
                    Date requestEnd = metrics.getRequestEnd();
                    if (requestEnd != null) {
                        kVarA.d(Duration.ofMillis(requestEnd.getTime()));
                    }
                }
                aoVar.a().a();
            }
        }
    }
}
