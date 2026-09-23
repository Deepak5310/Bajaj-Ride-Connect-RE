package com.google.android.libraries.navigation.internal.xm;

import com.google.android.libraries.navigation.internal.aac.ca;
import java.nio.ByteBuffer;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s extends UrlRequest.Callback {
    public final ca a;
    final /* synthetic */ t b;

    public s(t tVar, ca caVar) {
        this.b = tVar;
        this.a = caVar;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.b.a.execute(new q(this));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.b.a.execute(new p(this, cronetException));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        this.b.a.execute(new r(this));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        try {
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (httpStatusCode == 200) {
                urlRequest.read(ByteBuffer.allocateDirect(1024));
            } else {
                this.a.ap(new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.a(httpStatusCode)));
            }
        } catch (Exception e) {
            this.a.ap(e);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.b.a.execute(new o(this));
    }
}
