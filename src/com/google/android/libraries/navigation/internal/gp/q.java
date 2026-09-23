package com.google.android.libraries.navigation.internal.gp;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.adi.ad;
import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.adi.aj;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.gm.am;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.ExperimentalUrlRequest;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.gn.l {
    public final cy b;
    public final com.google.android.libraries.navigation.internal.fw.n c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final com.google.android.libraries.navigation.internal.kl.a e;
    public final com.google.android.libraries.navigation.internal.in.b f;
    public final Executor g;
    private final com.google.android.libraries.navigation.internal.afo.a j;
    private final g k;
    private final an l;
    private final com.google.android.libraries.navigation.internal.kl.c m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.agl.a f445n;
    private final x o = new x();
    private final String p;
    private final com.google.android.libraries.navigation.internal.gh.d q;
    private static final com.google.android.libraries.navigation.internal.zb.j h = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.gp.q");
    public static final String a = com.google.android.libraries.navigation.internal.gi.k.a.a;
    private static final Executor i = ac.INSTANCE;

    public q(cy cyVar, com.google.android.libraries.navigation.internal.afo.a aVar, g gVar, an anVar, com.google.android.libraries.navigation.internal.fw.n nVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.kl.a aVar3, com.google.android.libraries.navigation.internal.kl.c cVar, Executor executor, com.google.android.libraries.navigation.internal.agl.a aVar4, String str, com.google.android.libraries.navigation.internal.in.b bVar, com.google.android.libraries.navigation.internal.gh.d dVar) {
        this.b = cyVar;
        this.j = aVar;
        this.k = gVar;
        this.l = anVar;
        this.d = aVar2;
        this.e = aVar3;
        this.m = cVar;
        this.c = nVar;
        this.g = executor;
        this.f445n = aVar4;
        boolean z = true;
        if (str != null && str.isEmpty()) {
            z = false;
        }
        ar.a(z);
        this.p = str;
        this.f = bVar;
        this.q = dVar;
    }

    private final long c(String str) throws com.google.android.libraries.navigation.internal.gg.p {
        try {
            String file = new URL(str).getFile();
            long jA = t.a(((af) this.f445n.a()).e);
            int length = file.length() + 1;
            long[] jArr = new long[length];
            jArr[0] = jA;
            int i2 = 0;
            while (i2 < file.length()) {
                int i3 = i2 + 1;
                jArr[i3] = t.a(file.codePointAt(i2));
                i2 = i3;
            }
            long j = 0;
            for (int i4 = 0; i4 < length; i4++) {
                j = ((j * 1729) + jArr[i4]) % 131071;
            }
            return j;
        } catch (MalformedURLException e) {
            throw new com.google.android.libraries.navigation.internal.gg.p(com.google.android.libraries.navigation.internal.gg.o.g.c(e));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gn.l
    public final bj a(am amVar, final com.google.android.libraries.navigation.internal.gg.k kVar) {
        p pVar;
        ca caVar = new ca();
        cy cyVar = this.b;
        if (cyVar instanceof aj) {
            pVar = p.PAINT;
        } else {
            if (!(cyVar instanceof ad)) {
                throw new IllegalArgumentException("No Paint protocol RequestType for ".concat(String.valueOf(String.valueOf(cyVar))));
            }
            pVar = p.GET_PARAMETERS;
        }
        try {
            String externalForm = this.k.a().toExternalForm();
            if (!externalForm.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                externalForm = String.valueOf(externalForm).concat(RemoteSettings.FORWARD_SLASH_STRING);
            }
            if (pVar.equals(p.GET_PARAMETERS) && externalForm.endsWith("/vt/")) {
                externalForm = externalForm.substring(0, externalForm.length() - 3);
            }
            String strConcat = (externalForm + pVar.c + "?").concat(String.valueOf("bpb=".concat(String.valueOf(com.google.android.libraries.navigation.internal.zn.g.e.i(this.b.m())))));
            n nVar = new n(this, caVar, new o(this, pVar));
            this.c.c(0L);
            this.c.a(strConcat.length(), false);
            ExperimentalUrlRequest.Builder builder = (ExperimentalUrlRequest.Builder) ((CronetEngine) this.j.a()).newUrlRequestBuilder(strConcat, nVar, i).allowDirectExecutor();
            builder.setHttpMethod("GET");
            long jC = c(strConcat);
            this.l.d(amVar);
            com.google.android.libraries.navigation.internal.gh.b bVarA = amVar.a(HttpHeaders.AUTHORIZATION);
            if (bVarA != null) {
                builder.addHeader(bVarA.b(), "Bearer ".concat(String.valueOf((String) bVarA.a())));
            }
            builder.addHeader("X-Client-Signature", Long.toString(jC));
            String str = this.p;
            if (!aq.c(str)) {
                builder.addHeader("X-Google-Maps-Mobile-API", str);
            }
            b bVar = this.q.m;
            if (bVar != null && bVar.a()) {
                builder.addHeader("x-geo-tile-fetching-context", com.google.android.libraries.navigation.internal.zn.g.e.i(((com.google.android.libraries.navigation.internal.adf.j) bVar.a.t()).m()));
            }
            builder.addRequestAnnotation((Object) new com.google.android.libraries.navigation.internal.gk.a(this.b.getClass(), kVar));
            ExperimentalUrlRequest experimentalUrlRequestBuild = builder.build();
            com.google.android.libraries.navigation.internal.yu.c.d(caVar, new j(experimentalUrlRequestBuild), ac.INSTANCE);
            caVar.l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gp.i
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = q.a;
                    kVar.a();
                }
            }), this.g);
            experimentalUrlRequestBuild.start();
            this.d.b();
            return caVar;
        } catch (Exception e) {
            caVar.ap(e);
            return caVar;
        }
    }

    public final void b() {
        byte[] globalMetricsDeltas = ((CronetEngine) this.j.a()).getGlobalMetricsDeltas();
        if (globalMetricsDeltas == null || globalMetricsDeltas.length <= 0) {
            return;
        }
        this.m.j();
    }
}
