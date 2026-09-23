package com.google.android.libraries.navigation.internal.xm;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.gm.am;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements com.google.android.libraries.navigation.internal.gn.l {
    private static final Executor b = ac.INSTANCE;
    public final Executor a;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final CronetEngine d;
    private final an e;
    private final String f = "https://mapsmobilesdks-pa.googleapis.com/maps/api/sdks:getProjectProperties";

    public g(com.google.android.libraries.navigation.internal.mj.a aVar, CronetEngine cronetEngine, Executor executor, an anVar) {
        this.c = aVar;
        this.d = cronetEngine;
        this.a = executor;
        this.e = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.l
    public final bj a(am amVar, com.google.android.libraries.navigation.internal.gg.k kVar) {
        this.e.d(amVar);
        try {
            URL url = new URL(this.f);
            try {
                ar.r(amVar.a("apiToken"), "Android API token not available.");
                com.google.android.libraries.navigation.internal.aer.c cVar = (com.google.android.libraries.navigation.internal.aer.c) com.google.android.libraries.navigation.internal.aer.d.a.q();
                String str = (String) amVar.a("apiToken").a();
                if (!cVar.b.H()) {
                    cVar.v();
                }
                com.google.android.libraries.navigation.internal.aer.d dVar = (com.google.android.libraries.navigation.internal.aer.d) cVar.b;
                str.getClass();
                dVar.b = str;
                com.google.android.libraries.navigation.internal.aer.e eVar = (com.google.android.libraries.navigation.internal.aer.e) com.google.android.libraries.navigation.internal.aer.h.a.q();
                if (!eVar.b.H()) {
                    eVar.v();
                }
                com.google.android.libraries.navigation.internal.aer.h hVar = (com.google.android.libraries.navigation.internal.aer.h) eVar.b;
                com.google.android.libraries.navigation.internal.aer.d dVar2 = (com.google.android.libraries.navigation.internal.aer.d) cVar.t();
                dVar2.getClass();
                hVar.c = dVar2;
                hVar.b = 1;
                com.google.android.libraries.navigation.internal.aer.b bVar = (com.google.android.libraries.navigation.internal.aer.b) com.google.android.libraries.navigation.internal.aer.i.a.q();
                int i = com.google.android.libraries.navigation.internal.aer.a.d;
                if (!bVar.b.H()) {
                    bVar.v();
                }
                ((com.google.android.libraries.navigation.internal.aer.i) bVar.b).c = com.google.android.libraries.navigation.internal.aer.a.a(i);
                if (!bVar.b.H()) {
                    bVar.v();
                }
                com.google.android.libraries.navigation.internal.aer.i iVar = (com.google.android.libraries.navigation.internal.aer.i) bVar.b;
                com.google.android.libraries.navigation.internal.aer.h hVar2 = (com.google.android.libraries.navigation.internal.aer.h) eVar.t();
                hVar2.getClass();
                iVar.d = hVar2;
                iVar.b |= 1;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((com.google.android.libraries.navigation.internal.aer.i) bVar.t()).l(byteArrayOutputStream);
                ca caVar = new ca();
                com.google.android.libraries.navigation.internal.gt.c cVar2 = new com.google.android.libraries.navigation.internal.gt.c(byteArrayOutputStream, kVar, this.c);
                f fVar = new f(this, caVar);
                CronetEngine cronetEngine = this.d;
                String string = url.toString();
                Executor executor = b;
                UrlRequest.Builder builderAllowDirectExecutor = cronetEngine.newUrlRequestBuilder(string, fVar, executor).allowDirectExecutor();
                builderAllowDirectExecutor.setUploadDataProvider(cVar2, executor);
                builderAllowDirectExecutor.setHttpMethod("POST").addHeader("Content-Type", "application/x-protobuf").addHeader("X-Goog-Api-Key", "AIzaSyCbgGF3G_6xKd0tM6d5xMe_x6HZWvPN51Q");
                builderAllowDirectExecutor.build().start();
                return caVar;
            } catch (IOException e) {
                return az.g(e);
            }
        } catch (MalformedURLException e2) {
            return az.g(e2);
        }
    }
}
