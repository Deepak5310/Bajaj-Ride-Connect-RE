package com.google.android.libraries.navigation.internal.gn;

import android.util.Base64;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.acd.aj;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.bd;
import com.google.android.libraries.navigation.internal.db.as;
import com.google.android.libraries.navigation.internal.fw.ab;
import com.google.android.libraries.navigation.internal.fw.z;
import com.google.android.libraries.navigation.internal.gm.am;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.StringUtils;
import org.chromium.net.CronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UploadDataProvider;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements l {
    public static final /* synthetic */ int l = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j m = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.gn.i");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Executor f444n = ac.INSTANCE;
    public final cy a;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final an c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final com.google.android.libraries.navigation.internal.fw.n e;
    public final com.google.android.libraries.navigation.internal.mj.a f;
    public final com.google.android.libraries.navigation.internal.kl.a g;
    public final com.google.android.libraries.navigation.internal.kl.c h;
    public final bd i;
    public volatile String j;
    public final Executor k;
    private final com.google.android.libraries.navigation.internal.fy.f o;
    private final z p;
    private final com.google.android.libraries.navigation.internal.gh.d q;
    private final String r;
    private final String s;
    private final com.google.android.libraries.navigation.internal.no.a t;
    private final com.google.android.libraries.navigation.internal.yx.an u;
    private final dg v;

    public i(cy cyVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.fy.f fVar, z zVar, an anVar, com.google.android.libraries.navigation.internal.gh.d dVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.fw.n nVar, com.google.android.libraries.navigation.internal.mj.a aVar3, com.google.android.libraries.navigation.internal.kl.a aVar4, com.google.android.libraries.navigation.internal.kl.c cVar, Executor executor, String str, com.google.android.libraries.navigation.internal.no.a aVar5, com.google.android.libraries.navigation.internal.yx.an anVar2) {
        this.a = cyVar;
        this.b = aVar;
        this.o = fVar;
        this.p = zVar;
        this.c = anVar;
        this.q = dVar;
        this.d = aVar2;
        this.e = nVar;
        this.k = executor;
        boolean z = true;
        if (str != null && str.isEmpty()) {
            z = false;
        }
        ar.a(z);
        this.s = str;
        this.f = aVar3;
        this.g = aVar4;
        this.h = cVar;
        this.t = aVar5;
        this.u = anVar2;
        bd bdVar = dVar.h;
        ar.r(bdVar, "Null RequestId. Make sure request_handler is added to the rpc definition.");
        this.i = bdVar;
        dg dgVar = dVar.i;
        ar.r(dgVar, "Null response Parser.");
        this.v = dgVar;
        this.r = Thread.currentThread().getName();
    }

    @Override // com.google.android.libraries.navigation.internal.gn.l
    public final bj a(am amVar, final com.google.android.libraries.navigation.internal.gg.k kVar) {
        String str;
        com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("AsyncGmmServerProtocolRpc.send");
        try {
            ca caVar = new ca();
            this.c.d(amVar);
            com.google.android.libraries.navigation.internal.gh.b bVarA = amVar.a("apiToken");
            if (bVarA != null) {
                ((com.google.android.libraries.navigation.internal.il.a) this.d.a()).b((String) bVarA.a());
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                z zVar = this.p;
                com.google.android.libraries.navigation.internal.fw.n nVar = this.e;
                com.google.android.libraries.navigation.internal.no.a aVar = this.t;
                nVar.c(dataOutputStream.size());
                dataOutputStream.writeShort(24);
                dataOutputStream.writeLong(-1L);
                dataOutputStream.writeUTF(aVar.c().toLanguageTag());
                dataOutputStream.writeUTF(zVar.a);
                dataOutputStream.writeUTF(zVar.b);
                dataOutputStream.writeUTF((String) zVar.c.a());
                int size = dataOutputStream.size() - ((int) nVar.d);
                nVar.e = size;
                nVar.a.b += (long) size;
                nVar.c.a();
                nVar.b.f(nVar.e);
                if (this.a instanceof aj) {
                    ((com.google.android.libraries.navigation.internal.il.a) this.d.a()).d(dataOutputStream, this.e);
                    this.j = null;
                } else {
                    com.google.android.libraries.navigation.internal.io.b bVar = this.q.g;
                    if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                        this.j = bVar.d();
                    } else {
                        ((com.google.android.libraries.navigation.internal.il.a) this.d.a()).c();
                        this.j = ((com.google.android.libraries.navigation.internal.il.a) this.d.a()).a();
                    }
                    com.google.android.libraries.navigation.internal.il.a aVar2 = (com.google.android.libraries.navigation.internal.il.a) this.d.a();
                    com.google.android.libraries.navigation.internal.fw.n nVar2 = this.e;
                    boolean z = this.a instanceof com.google.android.libraries.navigation.internal.afl.aj;
                    com.google.android.libraries.navigation.internal.io.b bVar2 = this.q.g;
                    if (this.u.g()) {
                        com.google.android.libraries.navigation.internal.ir.c cVar = (com.google.android.libraries.navigation.internal.ir.c) this.u.c();
                        this.a.getClass();
                        str = (String) cVar.a().orElse(null);
                    } else {
                        str = null;
                    }
                    aVar2.g(dataOutputStream, nVar2, z, bVar2, str);
                }
                ab.d(this.a, this.i, dataOutputStream, this.e);
                dataOutputStream.close();
                URL urlA = this.o.a();
                f fVar = new f(this, byteArrayOutputStream, kVar);
                e eVar = new e(this, caVar, new g(this, kVar, this.v));
                CronetEngine cronetEngine = (CronetEngine) this.b.a();
                String externalForm = urlA.toExternalForm();
                Executor executor = f444n;
                ExperimentalUrlRequest.Builder builder = (ExperimentalUrlRequest.Builder) cronetEngine.newUrlRequestBuilder(externalForm, eVar, executor).allowDirectExecutor();
                builder.addRequestAnnotation((Object) new com.google.android.libraries.navigation.internal.gk.a(this.a.getClass(), kVar));
                builder.setUploadDataProvider((UploadDataProvider) fVar, executor);
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("AsyncGmmServerProtocolRpc writeMetadata");
                try {
                    builder.setHttpMethod("POST");
                    builder.addHeader("Content-Type", "application/binary");
                    com.google.android.libraries.navigation.internal.gh.b bVarA2 = amVar.a(HttpHeaders.AUTHORIZATION);
                    if (bVarA2 != null) {
                        builder.addHeader(bVarA2.b(), "Bearer " + ((String) bVarA2.a()));
                    }
                    com.google.android.libraries.navigation.internal.gh.b bVar3 = amVar.a;
                    if (bVar3 != null) {
                        String strB = bVar3.b();
                        String strConcat = "";
                        Iterator it2 = ((List) bVar3.a()).iterator();
                        while (it2.hasNext()) {
                            String strEncodeToString = Base64.encodeToString(((as) it2.next()).o().m(), 11);
                            if (!strConcat.isEmpty()) {
                                strConcat = String.valueOf(strConcat).concat(StringUtils.SPACE);
                            }
                            strConcat = strConcat + "w " + strEncodeToString;
                        }
                        builder.addHeader(strB, strConcat);
                    }
                    String str2 = this.s;
                    if (!aq.c(str2)) {
                        builder.addHeader("X-Google-Maps-Mobile-API", str2);
                    }
                    com.google.android.libraries.navigation.internal.gh.b bVarA3 = amVar.a("X-Device-Elapsed-Time");
                    if (bVarA3 != null) {
                        builder.addHeader("X-Device-Elapsed-Time", (String) bVarA3.a());
                    }
                    com.google.android.libraries.navigation.internal.gh.b bVarA4 = amVar.a("X-Device-Boot-Count");
                    if (bVarA4 != null) {
                        builder.addHeader("X-Device-Boot-Count", (String) bVarA4.a());
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    ExperimentalUrlRequest experimentalUrlRequestBuild = builder.build();
                    com.google.android.libraries.navigation.internal.yu.c.d(caVar, new b(experimentalUrlRequestBuild), ac.INSTANCE);
                    Objects.requireNonNull(kVar);
                    caVar.l(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gn.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            kVar.a();
                        }
                    }), this.k);
                    experimentalUrlRequestBuild.start();
                } catch (Throwable th) {
                    if (dVarB == null) {
                        throw th;
                    }
                    try {
                        Trace.endSection();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (Exception e) {
                caVar.ap(e);
            }
            aVarA.close();
            return caVar;
        } catch (Throwable th3) {
            try {
                aVarA.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }
}
