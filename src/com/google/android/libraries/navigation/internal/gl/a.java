package com.google.android.libraries.navigation.internal.gl;

import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.gg.o;
import com.google.android.libraries.navigation.internal.gg.p;
import com.google.android.libraries.navigation.internal.gj.e;
import com.google.android.libraries.navigation.internal.gj.f;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends UrlRequest.Callback {
    final /* synthetic */ b a;
    private final ca b;
    private final ByteArrayOutputStream c = new ByteArrayOutputStream(8192);
    private int d;

    public a(b bVar, ca caVar) {
        this.a = bVar;
        this.b = caVar;
        this.d = bVar.b.e.e;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.b.ap(com.google.android.libraries.navigation.internal.gt.b.a(cronetException));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        this.c.write(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit());
        byteBuffer.clear();
        urlRequest.read(byteBuffer);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (this.d > 0) {
            if (!this.a.b.b.c || b.b(str)) {
                this.d--;
                urlRequest.followRedirect();
                return;
            } else {
                urlRequest.cancel();
                this.b.ap(new p(o.h.d("Don't send authentication credentials to non-Google redirects.")));
                return;
            }
        }
        urlRequest.cancel();
        ca caVar = this.b;
        b bVar = this.a;
        caVar.ap(new p(o.h.d("More redirects than allowed: " + bVar.b.e.e)));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        if (b.a.contains(Integer.valueOf(urlResponseInfo.getHttpStatusCode()))) {
            urlRequest.read(ByteBuffer.allocateDirect(8192));
            return;
        }
        urlRequest.cancel();
        this.b.ap(new p(o.h.d("Expected HTTP status code 200, but got " + urlResponseInfo.getHttpStatusCode())));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        try {
            e eVar = (e) f.a.q();
            x xVarT = x.t(this.c.toByteArray());
            if (!eVar.b.H()) {
                eVar.v();
            }
            f fVar = (f) eVar.b;
            fVar.b |= 1;
            fVar.c = xVarT;
            if (urlResponseInfo.getAllHeaders().containsKey("content-type") && !urlResponseInfo.getAllHeaders().get("content-type").isEmpty()) {
                String str = urlResponseInfo.getAllHeaders().get("content-type").get(0);
                if (!eVar.b.H()) {
                    eVar.v();
                }
                f fVar2 = (f) eVar.b;
                str.getClass();
                fVar2.b |= 2;
                fVar2.d = str;
            }
            this.b.d(eVar.t());
        } catch (ClassCastException unused) {
            this.b.ap(new p(o.l.d("Expected type HttpResponse")));
        }
    }
}
