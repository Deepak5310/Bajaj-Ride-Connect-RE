package com.google.android.libraries.navigation.internal.im;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.fw.i;
import com.google.android.libraries.navigation.internal.kk.l;
import com.google.android.libraries.navigation.internal.km.ao;
import com.google.android.libraries.navigation.internal.km.v;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import org.chromium.net.RequestFinishedInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends RequestFinishedInfo.Listener {
    private final com.google.android.libraries.navigation.internal.afo.a a;

    public e(Executor executor, com.google.android.libraries.navigation.internal.afo.a aVar) {
        super(executor);
        this.a = aVar;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Listener
    public final void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        long jLongValue = ((Long) an.i(requestFinishedInfo.getMetrics().getSentByteCount()).e(0L)).longValue();
        long jLongValue2 = ((Long) an.i(requestFinishedInfo.getMetrics().getReceivedByteCount()).e(0L)).longValue();
        String host = Uri.parse(requestFinishedInfo.getUrl()).getHost();
        if (host != null) {
            i iVar = (i) this.a.a();
            Matcher matcher = i.a.matcher(host);
            if (matcher.find()) {
                matcher.group();
            }
            com.google.android.libraries.navigation.internal.kl.a aVar = iVar.b;
            v vVar = v.AUTO_PAN_MODE_ENABLED;
            aVar.l();
            ((l) iVar.b.a(ao.t)).a(jLongValue);
            ((l) iVar.b.a(ao.u)).a(jLongValue2);
        }
    }
}
