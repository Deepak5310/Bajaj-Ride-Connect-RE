package com.google.android.libraries.navigation.internal.xm;

import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.common.net.HttpHeaders;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends UrlRequest.Callback {
    public final ca b;
    final /* synthetic */ g c;
    public final com.google.android.libraries.navigation.internal.gt.a a = new com.google.android.libraries.navigation.internal.gt.a();
    private int d = 32;

    public f(g gVar, ca caVar) {
        this.c = gVar;
        this.b = caVar;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xm.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.cancel(false);
            }
        });
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, final CronetException cronetException) {
        this.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xm.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.ap(com.google.android.libraries.navigation.internal.gt.b.a(cronetException));
            }
        });
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            urlRequest.read(byteBuffer);
            return;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.d);
        this.a.b(byteBufferAllocateDirect);
        urlRequest.read(byteBufferAllocateDirect);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        this.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xm.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b.ap(new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.c));
            }
        });
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        try {
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (httpStatusCode != 200) {
                this.b.ap(new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.a(httpStatusCode)));
                return;
            }
            Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
            if (allHeaders.containsKey(HttpHeaders.CONTENT_LENGTH)) {
                this.d = Integer.parseInt(allHeaders.get(HttpHeaders.CONTENT_LENGTH).get(0));
            }
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.d);
            this.a.b(byteBufferAllocateDirect);
            urlRequest.read(byteBufferAllocateDirect);
        } catch (RuntimeException e) {
            this.b.ap(e);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xm.e
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = this.a;
                try {
                    fVar.b.d(((dg) com.google.android.libraries.navigation.internal.aer.l.b.aH(7, null)).f(fVar.a.a()));
                } catch (Exception e) {
                    fVar.b.ap(e);
                }
            }
        });
    }
}
