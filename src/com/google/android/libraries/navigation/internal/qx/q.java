package com.google.android.libraries.navigation.internal.qx;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.webkit.URLUtil;
import androidx.core.view.ViewCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.y;
import com.google.android.libraries.geo.mapcore.internal.model.z;
import com.google.android.libraries.navigation.internal.ael.ac;
import com.google.android.libraries.navigation.internal.ael.ad;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.ael.dr;
import com.google.android.libraries.navigation.internal.ael.ee;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afm.ae;
import com.google.android.libraries.navigation.internal.afm.af;
import com.google.android.libraries.navigation.internal.afm.ai;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.km.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import j$.time.Instant;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class q implements com.google.android.libraries.navigation.internal.qy.h {
    public static final /* synthetic */ int o = 0;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final com.google.android.libraries.navigation.internal.agl.a e;
    public final Executor f;
    final br g;
    final br h;
    public final com.google.android.libraries.navigation.internal.afo.a i;
    public final com.google.android.libraries.navigation.internal.afo.a j;
    public final com.google.android.libraries.navigation.internal.afo.a k;
    volatile com.google.android.libraries.navigation.internal.qv.b l;
    private final com.google.android.libraries.navigation.internal.gg.g s;
    private final com.google.android.libraries.navigation.internal.agl.a t;
    private final Executor u;
    private final com.google.android.libraries.navigation.internal.qy.c v;
    private static final com.google.android.libraries.navigation.internal.zb.j p = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qx.q");
    private static final Duration q = Duration.ofDays(1);
    static final Duration a = Duration.ofSeconds(10);
    private final AtomicBoolean r = new AtomicBoolean();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.fq.p f565n = new j(this);
    public final CountDownLatch m = new CountDownLatch(1);

    public q(com.google.android.libraries.navigation.internal.gg.g gVar, com.google.android.libraries.navigation.internal.gg.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, final com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.afo.a aVar6, com.google.android.libraries.navigation.internal.afo.a aVar7, com.google.android.libraries.navigation.internal.afo.a aVar8) {
        this.s = gVar;
        this.v = new a(fVar);
        this.c = aVar;
        this.d = aVar2;
        this.t = aVar3;
        this.u = executor;
        this.f = executor2;
        this.g = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qx.h
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                int i = q.o;
                return new com.google.android.libraries.navigation.internal.fq.k(64, com.google.android.libraries.navigation.internal.fq.h.RESOURCE_MANAGER_RESOURCE, (com.google.android.libraries.navigation.internal.fq.f) aVar2.a());
            }
        });
        this.h = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qx.i
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                int i = q.o;
                return new com.google.android.libraries.navigation.internal.fq.k(32, com.google.android.libraries.navigation.internal.fq.h.RESOURCE_MANAGER_SOFT_RESOURCE, (com.google.android.libraries.navigation.internal.fq.f) aVar2.a());
            }
        });
        this.e = aVar4;
        this.k = aVar5;
        this.b = aVar6;
        this.i = aVar8;
        this.j = aVar7;
    }

    private final com.google.android.libraries.navigation.internal.qz.k h(String str, boolean z) throws cc {
        com.google.android.libraries.navigation.internal.qz.k kVar = null;
        if (z) {
            synchronized (this.h) {
                SoftReference softReference = (SoftReference) ((com.google.android.libraries.navigation.internal.fq.k) this.h.a()).f(str);
                kVar = softReference != null ? (com.google.android.libraries.navigation.internal.qz.k) softReference.get() : null;
                if (kVar == null) {
                    ((com.google.android.libraries.navigation.internal.kk.i) ((com.google.android.libraries.navigation.internal.kl.b) this.b.a()).a(an.r)).a(false);
                    kVar = new com.google.android.libraries.navigation.internal.qz.k(str);
                    kVar.b = false;
                    ((com.google.android.libraries.navigation.internal.fq.k) this.h.a()).m(str, new SoftReference(kVar));
                } else {
                    ((com.google.android.libraries.navigation.internal.kk.i) ((com.google.android.libraries.navigation.internal.kl.b) this.b.a()).a(an.r)).a(true);
                }
            }
        } else {
            synchronized (this.g) {
                com.google.android.libraries.navigation.internal.qz.k kVar2 = (com.google.android.libraries.navigation.internal.qz.k) ((com.google.android.libraries.navigation.internal.fq.k) this.g.a()).f(str);
                if (kVar2 != null || this.l == null) {
                    kVar = kVar2;
                } else {
                    com.google.android.libraries.navigation.internal.qv.b bVar = this.l;
                    com.google.android.libraries.navigation.internal.dm.h hVar = (com.google.android.libraries.navigation.internal.dm.h) com.google.android.libraries.navigation.internal.dm.i.a.q();
                    int i = com.google.android.libraries.navigation.internal.dm.m.a;
                    if (!hVar.b.H()) {
                        hVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.i iVar = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                    if (i == 0) {
                        throw null;
                    }
                    iVar.c = i;
                    iVar.b |= 1;
                    if (!hVar.b.H()) {
                        hVar.v();
                    }
                    com.google.android.libraries.navigation.internal.dm.i iVar2 = (com.google.android.libraries.navigation.internal.dm.i) hVar.b;
                    str.getClass();
                    iVar2.b |= 2;
                    iVar2.d = str;
                    com.google.android.libraries.navigation.internal.dm.i iVar3 = (com.google.android.libraries.navigation.internal.dm.i) hVar.t();
                    try {
                        com.google.android.libraries.navigation.internal.dm.g gVarB = ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.l) bVar).b.b(iVar3);
                        if (gVarB != null) {
                            try {
                                x xVar = gVarB.c;
                                ai aiVar = ai.a;
                                ar arVar = ar.a;
                                di diVar = di.a;
                                ar arVar2 = ar.a;
                                ac acVarK = xVar.k();
                                bi biVarU = aiVar.u();
                                try {
                                    dr drVarB = di.a.b(biVarU);
                                    drVarB.h(biVarU, ad.p(acVarK), arVar2);
                                    drVarB.f(biVarU);
                                    try {
                                        acVarK.z(0);
                                        bi.I(biVarU);
                                        bi.I(biVarU);
                                        ai aiVar2 = (ai) biVarU;
                                        kVar = new com.google.android.libraries.navigation.internal.qz.k(str);
                                        kVar.b = true;
                                        kVar.r(aiVar2);
                                    } catch (cc e) {
                                        throw e;
                                    }
                                } catch (cc e2) {
                                    if (e2.a) {
                                        throw new cc(e2);
                                    }
                                    throw e2;
                                } catch (ee e3) {
                                    throw e3.a();
                                } catch (IOException e4) {
                                    if (e4.getCause() instanceof cc) {
                                        throw ((cc) e4.getCause());
                                    }
                                    throw new cc(e4);
                                } catch (RuntimeException e5) {
                                    if (e5.getCause() instanceof cc) {
                                        throw ((cc) e5.getCause());
                                    }
                                    throw e5;
                                }
                            } catch (cc unused) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1230)).s("Failed to parse resource data from database of resource id= %s :", str);
                                try {
                                    ((com.google.android.libraries.geo.mapcore.internal.store.diskcache.l) bVar).b.e(iVar3);
                                } catch (IOException unused2) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1231)).s("Failed to delete corrupt resources id= %s :", str);
                                }
                            }
                        }
                    } catch (IOException unused3) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1232)).s("Failed to get resource %s", str);
                    }
                }
                if (kVar == null) {
                    ((com.google.android.libraries.navigation.internal.kk.i) ((com.google.android.libraries.navigation.internal.kl.b) this.b.a()).a(an.r)).a(false);
                    com.google.android.libraries.navigation.internal.qz.k kVar3 = new com.google.android.libraries.navigation.internal.qz.k(str);
                    kVar3.b = true;
                    kVar = kVar3;
                } else {
                    ((com.google.android.libraries.navigation.internal.kk.i) ((com.google.android.libraries.navigation.internal.kl.b) this.b.a()).a(an.r)).a(true);
                }
                ((com.google.android.libraries.navigation.internal.fq.k) this.g.a()).m(str, kVar);
            }
        }
        return kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.google.android.libraries.navigation.internal.qz.k i(ev evVar, int i, String str, float f, int i2, int i3, String str2, com.google.android.libraries.navigation.internal.qz.g gVar, int i4, int i5, com.google.android.libraries.navigation.internal.qz.m mVar) throws cc {
        com.google.android.libraries.navigation.internal.qz.k kVar;
        com.google.android.libraries.navigation.internal.qz.k kVarC;
        StringBuilder sb = new StringBuilder();
        int size = evVar.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            z zVar = (z) evVar.get(i7);
            sb.append("&name=");
            sb.append(zVar.f());
            sb.append("&highlight=");
            sb.append(zVar.c());
            sb.append("&filter=");
            sb.append(zVar.a());
            if (!aq.c(zVar.f())) {
                i6++;
            }
        }
        sb.append("&scale=");
        sb.append(i);
        sb.append("&text=");
        sb.append(str);
        sb.append("&size=");
        sb.append(f);
        sb.append("&color=");
        sb.append(i2);
        sb.append("&textAttributes=");
        sb.append(i3);
        sb.append("&contentWidth=0&contentHeight=0");
        com.google.android.libraries.navigation.internal.qz.k kVarH = h(sb.toString(), false);
        if (kVarH.p() || kVarH.q()) {
            kVar = kVarH;
            if (kVar.q()) {
                kVar.h(gVar);
            }
        } else {
            kVarH.j(true);
            kVar = kVarH;
            n nVar = new n(kVarH, i6, evVar.size(), this.c, false, new g(this, evVar, str, f, i2, i3, 0, 0));
            for (int i8 = 0; i8 < evVar.size(); i8++) {
                String strF = ((z) evVar.get(i8)).f();
                if (!strF.isEmpty()) {
                    synchronized (nVar) {
                        kVarC = c(strF, str2, nVar, mVar);
                        nVar.a[i8] = kVarC;
                    }
                    if (kVarC.p()) {
                        nVar.a(kVarC);
                    }
                }
            }
            if (kVar.q()) {
                kVar.h(gVar);
            }
        }
        return kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.h
    public final com.google.android.libraries.navigation.internal.qz.k a(ev evVar, int i, String str, float f, int i2, int i3, String str2, com.google.android.libraries.navigation.internal.qz.g gVar) {
        return i(evVar, i, str, f, i2, i3, str2, gVar, 0, 0, com.google.android.libraries.navigation.internal.qz.m.a);
    }

    @Override // com.google.android.libraries.navigation.internal.qy.h
    public final com.google.android.libraries.navigation.internal.qz.k b(String str, String str2, com.google.android.libraries.navigation.internal.qz.g gVar) {
        return c(str, str2, gVar, com.google.android.libraries.navigation.internal.qz.m.a);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0181  */
    public final com.google.android.libraries.navigation.internal.qz.k c(String str, String str2, com.google.android.libraries.navigation.internal.qz.g gVar, com.google.android.libraries.navigation.internal.qz.m mVar) {
        int color;
        int i;
        com.google.android.libraries.navigation.internal.qy.a aVar;
        Bitmap bitmapA;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ResourceManagerImpl.getIconResource");
        try {
            String str3 = (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("//") || str.startsWith("data:")) ? str : ((com.google.android.libraries.navigation.internal.om.f) ((com.google.android.libraries.navigation.internal.om.p) this.t.a()).c()).c + str;
            com.google.android.libraries.navigation.internal.qz.k kVarH = h(str3, false);
            if (!kVarH.p()) {
                if (str.startsWith("data:")) {
                    if (str.startsWith("data:image/svg")) {
                        ((com.google.android.libraries.navigation.internal.zb.h) p.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1283)).p("SVG format not supported by Glide for data urls");
                    }
                    synchronized (kVarH) {
                        kVarH.h(gVar);
                    }
                    g(str3, new k(kVarH));
                } else {
                    URL urlI = com.google.android.libraries.navigation.internal.qy.g.i(str3);
                    if (urlI == null) {
                        aVar = null;
                    } else {
                        boolean zContains = str3.contains("texture/name=");
                        String query = urlI.getQuery();
                        HashMap map = new HashMap();
                        if (query != null) {
                            Iterator it2 = com.google.android.libraries.navigation.internal.qy.g.j.g(query).iterator();
                            while (it2.hasNext()) {
                                String[] strArrSplit = ((String) it2.next()).split("=", 2);
                                if (strArrSplit.length == 2) {
                                    map.put(strArrSplit[0], strArrSplit[1]);
                                }
                            }
                        }
                        String str4 = (String) map.get("name");
                        if (!aq.c(str4)) {
                            ArrayList arrayList = new ArrayList();
                            for (String str5 : com.google.android.libraries.navigation.internal.qy.g.i.g(str4)) {
                                if (str5.isEmpty()) {
                                    arrayList.add("");
                                } else if (zContains) {
                                    arrayList.add(com.google.android.libraries.navigation.internal.b.b.g(str5, "assets/textures/", ".png"));
                                } else if (str5.toLowerCase(Locale.US).endsWith(".png")) {
                                    arrayList.add(str5.replaceAll("icon\\/name=", ""));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                String strDecode = (String) map.get("text");
                                if (!aq.c(strDecode)) {
                                    try {
                                        strDecode = URLDecoder.decode(strDecode, "UTF-8");
                                    } catch (UnsupportedEncodingException e) {
                                        e.getMessage();
                                        strDecode = "";
                                    }
                                }
                                if (map.containsKey("color")) {
                                    String strConcat = "#".concat(String.valueOf((String) map.get("color")));
                                    if (aq.c(strConcat)) {
                                        color = ViewCompat.MEASURED_STATE_MASK;
                                    } else {
                                        try {
                                            color = Color.parseColor(strConcat);
                                        } catch (IllegalArgumentException unused) {
                                            color = ViewCompat.MEASURED_STATE_MASK;
                                        }
                                    }
                                } else {
                                    color = ViewCompat.MEASURED_STATE_MASK;
                                }
                                if (map.containsKey("textAttributes")) {
                                    try {
                                        i = Integer.parseInt(aq.b((String) map.get("textAttributes")));
                                    } catch (NumberFormatException unused2) {
                                    }
                                } else {
                                    i = 8;
                                }
                                int i2 = i;
                                float fRound = map.containsKey("psize") ? Math.round(Float.parseFloat(aq.b((String) map.get("psize"))) * 10.0f) / 10.0f : 12.0f;
                                if (map.containsKey("scale")) {
                                    float f = Float.parseFloat(aq.b((String) map.get("scale")));
                                    if (f <= 0.125d || f > 8.0f) {
                                    }
                                }
                                int[] iArrJ = com.google.android.libraries.navigation.internal.qy.g.k;
                                if (map.containsKey("highlight") && !aq.c((String) map.get("highlight"))) {
                                    iArrJ = com.google.android.libraries.navigation.internal.qy.g.j((String) map.get("highlight"));
                                }
                                int[] iArrJ2 = com.google.android.libraries.navigation.internal.qy.g.k;
                                if (map.containsKey("filter") && !aq.c((String) map.get("filter"))) {
                                    iArrJ2 = com.google.android.libraries.navigation.internal.qy.g.j((String) map.get("filter"));
                                }
                                eq eqVar = new eq();
                                int i3 = 0;
                                while (i3 < arrayList.size()) {
                                    int i4 = i3 < iArrJ.length ? iArrJ[i3] : ViewCompat.MEASURED_STATE_MASK;
                                    int i5 = i3 < iArrJ2.length ? iArrJ2[i3] : 0;
                                    y yVarH = z.h();
                                    yVarH.f((String) arrayList.get(i3));
                                    yVarH.d(i4);
                                    yVarH.b(i5);
                                    eqVar.h(yVarH.a());
                                    i3++;
                                }
                                aVar = new com.google.android.libraries.navigation.internal.qy.a(eqVar.g(), aq.b(strDecode), fRound, color, i2, false, 0, 0);
                            }
                        }
                        aVar = null;
                    }
                    if (aVar == null || (bitmapA = ((com.google.android.libraries.navigation.internal.qy.f) this.k.a()).a(aVar, null, null)) == null) {
                        kVarH = e(str3, str2, gVar, false, mVar);
                    } else {
                        kVarH.n(this.c.f().toEpochMilli());
                        kVarH.l(bitmapA);
                        kVarH.o(3);
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return kVarH;
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
    }

    @Override // com.google.android.libraries.navigation.internal.qy.h
    public final com.google.android.libraries.navigation.internal.qz.k d(String str, String str2, com.google.android.libraries.navigation.internal.qz.g gVar) {
        return e(str, str2, gVar, false, com.google.android.libraries.navigation.internal.qz.m.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.qy.h
    public final com.google.android.libraries.navigation.internal.qz.k e(String str, String str2, com.google.android.libraries.navigation.internal.qz.g gVar, boolean z, com.google.android.libraries.navigation.internal.qz.m mVar) throws cc {
        boolean zMatches;
        com.google.android.libraries.navigation.internal.qz.k kVarH = h(str, z);
        try {
            ((com.google.android.libraries.navigation.internal.qy.f) this.k.a()).c(str);
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1284)).p("IOException loading a resource in getResource");
        }
        synchronized (kVarH) {
            if (!kVarH.q()) {
                Instant instantF = this.c.f();
                Instant instantOfEpochMilli = Instant.ofEpochMilli(kVarH.b());
                boolean z2 = kVarH.a() == 1 || kVarH.a() == 2;
                if (instantOfEpochMilli.plus(q).isBefore(instantF) || kVarH.a() == 0 || (z2 && instantOfEpochMilli.plus(a).isBefore(instantF))) {
                    kVarH.j(true);
                    kVarH.n(instantF.toEpochMilli());
                    boolean z3 = mVar.b;
                    if (((com.google.android.libraries.navigation.internal.om.d) ((com.google.android.libraries.navigation.internal.om.p) this.t.a()).b()).f && ((com.google.android.libraries.navigation.internal.om.d) ((com.google.android.libraries.navigation.internal.om.p) this.t.a()).b()).e && z3) {
                        com.google.android.libraries.navigation.internal.qy.c cVar = this.v;
                        m mVar2 = new m(this, str, kVarH);
                        Executor executor = this.f;
                        if (URLUtil.isNetworkUrl(str)) {
                            ev evVar = a.a;
                            int i = ((lv) evVar).c;
                            int i2 = 0;
                            do {
                                if (i2 < i) {
                                    zMatches = ((Pattern) evVar.get(i2)).matcher(str).matches();
                                    i2++;
                                }
                            } while (!zMatches);
                            com.google.android.libraries.navigation.internal.gj.d dVar = com.google.android.libraries.navigation.internal.gj.d.a;
                            com.google.android.libraries.navigation.internal.gd.e eVar = new com.google.android.libraries.navigation.internal.gh.d(((a) cVar).b.b()).e;
                            bb bbVar = (bb) eVar.aH(5, null);
                            bbVar.x(eVar);
                            com.google.android.libraries.navigation.internal.gd.b bVar = (com.google.android.libraries.navigation.internal.gd.b) bbVar;
                            if (!bVar.b.H()) {
                                bVar.v();
                            }
                            com.google.android.libraries.navigation.internal.gd.e eVar2 = (com.google.android.libraries.navigation.internal.gd.e) bVar.b;
                            com.google.android.libraries.navigation.internal.gd.e eVar3 = com.google.android.libraries.navigation.internal.gd.e.a;
                            str.getClass();
                            eVar2.b = 1 | eVar2.b;
                            eVar2.c = str;
                            if (!bVar.b.H()) {
                                bVar.v();
                            }
                            com.google.android.libraries.navigation.internal.gd.e eVar4 = (com.google.android.libraries.navigation.internal.gd.e) bVar.b;
                            eVar4.b |= 4;
                            eVar4.e = 0;
                            int i3 = com.google.android.libraries.navigation.internal.gd.d.b;
                            if (!bVar.b.H()) {
                                bVar.v();
                            }
                            com.google.android.libraries.navigation.internal.gd.e eVar5 = (com.google.android.libraries.navigation.internal.gd.e) bVar.b;
                            int i4 = i3 - 1;
                            if (i3 == 0) {
                                throw null;
                            }
                            eVar5.d = i4;
                            eVar5.b |= 2;
                            ((a) cVar).b.b().d = (com.google.android.libraries.navigation.internal.gd.e) bVar.t();
                            ((a) cVar).b.a().a(dVar, mVar2, executor);
                        }
                        throw new IllegalArgumentException("Invalid URL: ".concat(String.valueOf(str)));
                    }
                    ae aeVar = (ae) af.a.q();
                    if (!aeVar.b.H()) {
                        aeVar.v();
                    }
                    af afVar = (af) aeVar.b;
                    str.getClass();
                    afVar.b |= 2;
                    afVar.d = str;
                    if (str2 != null) {
                        if (!aeVar.b.H()) {
                            aeVar.v();
                        }
                        af afVar2 = (af) aeVar.b;
                        afVar2.b |= 8;
                        afVar2.e = str2;
                    }
                    if (kVarH.p()) {
                        long j = kVarH.e;
                        if (!aeVar.b.H()) {
                            aeVar.v();
                        }
                        af afVar3 = (af) aeVar.b;
                        afVar3.b |= 1;
                        afVar3.c = j;
                    }
                    this.s.a((af) aeVar.t(), new p(this, kVarH), this.u);
                }
            }
            if (gVar != null && !kVarH.p()) {
                kVarH.h(gVar);
            }
        }
        return kVarH;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.h
    public final void f() {
        if (this.r.compareAndSet(false, true)) {
            this.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qx.f
                @Override // java.lang.Runnable
                public final void run() {
                    q qVar = this.a;
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ResourceManagerImpl.init");
                    try {
                        ap.BACKGROUND_THREADPOOL.f();
                        ((com.google.android.libraries.navigation.internal.fq.f) qVar.d.a()).d(qVar.f565n, "ResourceManager");
                        com.google.android.libraries.navigation.internal.qv.b bVarA = ((com.google.android.libraries.navigation.internal.qv.a) qVar.j.a()).a(qVar.c);
                        if (bVarA != null) {
                            qVar.l = bVarA;
                        }
                        qVar.m.countDown();
                        if (dVarB != null) {
                            Trace.endSection();
                        }
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
                }
            });
        }
    }

    public final void g(String str, com.google.android.libraries.navigation.internal.kt.a aVar) {
        ((com.google.android.libraries.navigation.internal.ie.h) this.i.a()).a(str, aVar);
    }
}
