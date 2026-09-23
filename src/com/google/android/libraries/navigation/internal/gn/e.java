package com.google.android.libraries.navigation.internal.gn;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.km.ar;
import com.google.android.libraries.navigation.internal.km.y;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.common.net.HttpHeaders;
import j$.time.Duration;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends UrlRequest.Callback {
    public final ca a;
    public final g b;
    public h c;
    final /* synthetic */ i d;

    public e(i iVar, ca caVar, g gVar) {
        this.d = iVar;
        this.a = caVar;
        this.b = gVar;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.d.k.execute(new d(this, cronetException));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        byteBuffer.flip();
        try {
            h hVar = this.c;
            ByteBuffer byteBuffer2 = hVar.a;
            if (byteBuffer2 != null) {
                byteBuffer2.put(byteBuffer);
            } else {
                if (hVar.b == null) {
                    throw new NullPointerException("Neither the ByteBuffer nor the ByteArrayOutputStream is non-null!");
                }
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.get(bArr);
                hVar.b.write(bArr, 0, iRemaining);
            }
        } catch (Exception e) {
            this.a.ap(e);
        }
        byteBuffer.clear();
        urlRequest.read(byteBuffer);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        new RuntimeException("Unexpected redirect received from GMM Server for request: ".concat(String.valueOf(this.d.a.getClass().getName())));
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 607)).p("AsyncGmmServerProtocolRpc");
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        y yVarA;
        try {
            g gVar = this.b;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmServerResponseReader readResponseHeaders");
            try {
                gVar.a.b(Duration.ofMillis(gVar.b.f.a()));
                Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
                int httpStatusCode = urlResponseInfo.getHttpStatusCode();
                if (httpStatusCode != 200) {
                    throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.a(httpStatusCode));
                }
                if (allHeaders.containsKey(HttpHeaders.SERVER_TIMING)) {
                    Map mapA = com.google.android.libraries.navigation.internal.gt.d.a(allHeaders.get(HttpHeaders.SERVER_TIMING));
                    if (mapA.containsKey("gfet4t7")) {
                        Map map = (Map) mapA.get("gfet4t7");
                        if (map.containsKey("dur") && (yVarA = ar.a(gVar.b.a.getClass())) != null) {
                            ((com.google.android.libraries.navigation.internal.kk.l) gVar.b.g.a(yVarA)).a(Math.round(Double.parseDouble((String) map.get("dur"))));
                        }
                    }
                }
                if (!allHeaders.containsKey("Content-Type") || !"application/binary".equals(aq.b(allHeaders.get("Content-Type").get(0)))) {
                    throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.e);
                }
                h hVar = allHeaders.containsKey(HttpHeaders.CONTENT_LENGTH) ? new h(Integer.parseInt(allHeaders.get(HttpHeaders.CONTENT_LENGTH).get(0))) : new h();
                if (dVarB != null) {
                    Trace.endSection();
                }
                this.c = hVar;
                urlRequest.read(ByteBuffer.allocateDirect(131072));
            } catch (Throwable th) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            this.a.ap(e);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.d.k.execute(new c(this));
    }
}
