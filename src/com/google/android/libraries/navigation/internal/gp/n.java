package com.google.android.libraries.navigation.internal.gp;

import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.adi.ax;
import com.google.android.libraries.navigation.internal.adi.az;
import com.google.android.libraries.navigation.internal.adi.z;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.km.y;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zr.ds;
import com.google.common.net.HttpHeaders;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends UrlRequest.Callback {
    public final ca a;
    final /* synthetic */ q b;
    private final o c;
    private final com.google.android.libraries.navigation.internal.gt.a d = new com.google.android.libraries.navigation.internal.gt.a();
    private int e = 1;

    public n(q qVar, ca caVar, o oVar) {
        this.b = qVar;
        this.a = caVar;
        this.c = oVar;
    }

    private final void b(UrlResponseInfo urlResponseInfo) {
        Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
        if (allHeaders.containsKey(q.a)) {
            Iterator<String> it2 = allHeaders.get(q.a).iterator();
            while (it2.hasNext()) {
                String strTrim = aq.b(it2.next()).trim();
                if (!strTrim.isEmpty()) {
                    try {
                        byte[] bArrJ = com.google.android.libraries.navigation.internal.zn.g.d.j(strTrim);
                        com.google.android.libraries.navigation.internal.in.b bVar = this.b.f;
                        ar arVar = ar.a;
                        di diVar = di.a;
                        bi biVarV = bi.v(ds.a, bArrJ, 0, bArrJ.length, ar.a);
                        bi.I(biVarV);
                        bVar.a((ds) biVarV);
                    } catch (Exception unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 620)).p("Unable to parse a ServerVersionMetadata proto ");
                    }
                }
            }
        }
    }

    public final /* synthetic */ void a(UrlResponseInfo urlResponseInfo) {
        dg dgVar;
        try {
            try {
                ByteBuffer byteBufferA = this.d.a();
                o oVar = this.c;
                oVar.b.c.c(byteBufferA.position());
                byte[] bArr = new byte[byteBufferA.remaining()];
                byteBufferA.get(bArr);
                ar arVarC = ar.c();
                int iOrdinal = oVar.a.ordinal();
                if (iOrdinal == 0) {
                    dgVar = (dg) ax.a.aH(7, null);
                } else {
                    if (iOrdinal != 1) {
                        throw null;
                    }
                    dgVar = (dg) af.a.aH(7, null);
                }
                if (oVar.a.equals(p.PAINT)) {
                    arVarC.d(z.b);
                    arVarC.d(az.b);
                } else {
                    oVar.a.equals(p.GET_PARAMETERS);
                }
                Object objI = dgVar.i(bArr, arVarC);
                oVar.b.c.b(byteBufferA.position());
                oVar.b.d.b();
                this.a.d(objI);
                this.b.b();
            } catch (Exception e) {
                String str = q.a;
                this.a.ap(e);
            }
            b(urlResponseInfo);
        } catch (Throwable th) {
            b(urlResponseInfo);
            throw th;
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.b.g.execute(new l(this, cronetException));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        try {
            if (byteBuffer.hasRemaining()) {
                urlRequest.read(byteBuffer);
                return;
            }
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(131072);
            this.d.b(byteBufferAllocateDirect);
            urlRequest.read(byteBufferAllocateDirect);
        } catch (Exception e) {
            this.a.ap(e);
            throw e;
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        int i = this.e;
        this.e = i - 1;
        if (i > 0) {
            urlRequest.followRedirect();
            return;
        }
        urlRequest.cancel();
        this.b.g.execute(new m(this));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        y yVarA;
        try {
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (httpStatusCode != 200) {
                urlRequest.cancel();
                this.a.ap(new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.a(httpStatusCode)));
                return;
            }
            Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
            if (allHeaders.containsKey(HttpHeaders.SERVER_TIMING)) {
                Map mapA = com.google.android.libraries.navigation.internal.gt.d.a(allHeaders.get(HttpHeaders.SERVER_TIMING));
                if (mapA.containsKey("gfet4t7")) {
                    Map map = (Map) mapA.get("gfet4t7");
                    if (map.containsKey("dur") && (yVarA = com.google.android.libraries.navigation.internal.km.ar.a(this.b.b.getClass())) != null) {
                        ((com.google.android.libraries.navigation.internal.kk.l) this.b.e.a(yVarA)).a(Math.round(Double.parseDouble((String) map.get("dur"))));
                    }
                }
            }
            Map<String, List<String>> allHeaders2 = urlResponseInfo.getAllHeaders();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(allHeaders2.containsKey(HttpHeaders.CONTENT_LENGTH) ? Integer.parseInt(allHeaders2.get(HttpHeaders.CONTENT_LENGTH).get(0)) + 1 : 131072);
            this.d.b(byteBufferAllocateDirect);
            urlRequest.read(byteBufferAllocateDirect);
        } catch (Exception e) {
            this.a.ap(e);
            throw e;
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, final UrlResponseInfo urlResponseInfo) {
        this.b.g.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gp.k
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(urlResponseInfo);
            }
        });
    }
}
