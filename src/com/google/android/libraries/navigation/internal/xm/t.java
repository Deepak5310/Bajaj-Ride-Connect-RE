package com.google.android.libraries.navigation.internal.xm;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.gm.am;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.google.android.libraries.navigation.internal.gn.l {
    public static final /* synthetic */ int b = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xm.t");
    private static final Executor d = ac.INSTANCE;
    public final Executor a;
    private final cy e;
    private final String f;
    private final CronetEngine g;
    private final an h;
    private final m i;
    private final com.google.android.libraries.navigation.internal.mj.a j;

    public t(cy cyVar, String str, CronetEngine cronetEngine, an anVar, m mVar, com.google.android.libraries.navigation.internal.mj.a aVar, Executor executor) {
        this.e = cyVar;
        this.f = str;
        this.g = cronetEngine;
        this.h = anVar;
        this.i = mVar;
        this.j = aVar;
        ar.r(executor, "'finishingExecutor' can not be null)");
        this.a = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.gn.l
    public final bj a(am amVar, com.google.android.libraries.navigation.internal.gg.k kVar) {
        ca caVar = new ca();
        this.h.d(amVar);
        try {
            URL url = new URL(this.f);
            cy cyVarT = this.e;
            if (cyVarT instanceof com.google.android.libraries.navigation.internal.adc.d) {
                com.google.android.libraries.navigation.internal.adc.a aVar = (com.google.android.libraries.navigation.internal.adc.a) com.google.android.libraries.navigation.internal.adc.d.a.r((com.google.android.libraries.navigation.internal.adc.d) cyVarT);
                int i = com.google.android.libraries.navigation.internal.adc.b.b;
                if (!aVar.b.H()) {
                    aVar.v();
                }
                ((com.google.android.libraries.navigation.internal.adc.d) aVar.b).j = com.google.android.libraries.navigation.internal.adc.b.a(i);
                String strA = this.i.a();
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.adc.d dVar = (com.google.android.libraries.navigation.internal.adc.d) aVar.b;
                strA.getClass();
                dVar.h = strA;
                com.google.android.libraries.navigation.internal.gh.b bVarA = amVar.a("apiToken");
                if (bVarA != null) {
                    String str = (String) bVarA.a();
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adc.d dVar2 = (com.google.android.libraries.navigation.internal.adc.d) aVar.b;
                    str.getClass();
                    dVar2.g = str;
                }
                com.google.android.libraries.navigation.internal.gh.b bVarA2 = amVar.a("ZwiebackCookie");
                if (bVarA2 != null) {
                    String str2 = (String) bVarA2.a();
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adc.d dVar3 = (com.google.android.libraries.navigation.internal.adc.d) aVar.b;
                    str2.getClass();
                    dVar3.c = str2;
                }
                cyVarT = aVar.t();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            cyVarT.l(byteArrayOutputStream);
            com.google.android.libraries.navigation.internal.gt.c cVar = new com.google.android.libraries.navigation.internal.gt.c(byteArrayOutputStream, kVar, this.j);
            s sVar = new s(this, caVar);
            CronetEngine cronetEngine = this.g;
            String string = url.toString();
            Executor executor = d;
            UrlRequest.Builder builderAllowDirectExecutor = cronetEngine.newUrlRequestBuilder(string, sVar, executor).allowDirectExecutor();
            builderAllowDirectExecutor.setUploadDataProvider(cVar, executor);
            builderAllowDirectExecutor.setHttpMethod("POST").addHeader("Content-Type", "application/x-protobuf").addHeader("X-Goog-Api-Key", (String) this.i.a.a()).addHeader("X-Android-Package", this.i.a()).addHeader("X-Android-Cert", (String) this.i.b.a());
            builderAllowDirectExecutor.build().start();
        } catch (Exception e) {
            caVar.ap(e);
        }
        return caVar;
    }
}
