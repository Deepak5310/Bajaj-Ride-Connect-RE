package com.google.android.libraries.navigation.internal.il;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.util.Consumer;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.afl.ad;
import com.google.android.libraries.navigation.internal.afl.ae;
import com.google.android.libraries.navigation.internal.afl.af;
import com.google.android.libraries.navigation.internal.afl.ao;
import com.google.android.libraries.navigation.internal.afl.aq;
import com.google.android.libraries.navigation.internal.afl.ar;
import com.google.android.libraries.navigation.internal.afl.at;
import com.google.android.libraries.navigation.internal.afl.bd;
import com.google.android.libraries.navigation.internal.afl.io;
import com.google.android.libraries.navigation.internal.fr.l;
import com.google.android.libraries.navigation.internal.fw.ac;
import com.google.android.libraries.navigation.internal.fw.n;
import com.google.android.libraries.navigation.internal.gz.g;
import com.google.android.libraries.navigation.internal.ho.cq;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.kk.k;
import com.google.android.libraries.navigation.internal.lc.ak;
import com.google.android.libraries.navigation.internal.lc.h;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zr.ds;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener, a {
    public final ao a;
    private final f b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.gf.c d;
    private final com.google.android.libraries.navigation.internal.in.b e;
    private final com.google.android.libraries.navigation.internal.fu.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.afo.a h;
    private final AtomicBoolean i = new AtomicBoolean(false);
    private String j = null;
    private final com.google.android.libraries.navigation.internal.au.b k;

    private d(f fVar, ao aoVar, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.gf.c cVar, com.google.android.libraries.navigation.internal.au.b bVar, com.google.android.libraries.navigation.internal.in.b bVar2, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.fu.a aVar4) {
        this.b = fVar;
        this.a = aoVar;
        this.c = aVar;
        this.d = cVar;
        this.k = bVar;
        this.e = bVar2;
        this.g = aVar2;
        this.h = aVar3;
        this.f = aVar4;
    }

    public static d i(f fVar, com.google.android.libraries.navigation.internal.fu.a aVar, Context context, com.google.android.libraries.navigation.internal.jb.c cVar, io ioVar, l lVar, String str, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.gf.c cVar2, an anVar, com.google.android.libraries.navigation.internal.au.b bVar, com.google.android.libraries.navigation.internal.in.b bVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4) {
        int i;
        String strB = com.google.android.libraries.navigation.internal.jd.a.b(cVar);
        String strA = com.google.android.libraries.navigation.internal.jd.a.a(context);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmServerImpl - create ClientPropertiesProtoBuf");
        try {
            long jLongValue = cVar.c().longValue();
            Resources resources = context.getResources();
            final ao aoVar = (ao) ar.a.q();
            String strI = fVar.i(ab.P, null);
            if (strI != null) {
                if (!aoVar.b.H()) {
                    aoVar.v();
                }
                ar arVar = (ar) aoVar.b;
                arVar.b |= 1;
                arVar.e = strI;
            }
            String strB2 = aVar.b();
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar2 = (ar) aoVar.b;
            strB2.getClass();
            arVar2.b |= 4;
            arVar2.f = strB2;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar.h((ar) aoVar.b);
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar3 = (ar) aoVar.b;
            arVar3.b |= 16384;
            arVar3.k = true;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar.g((ar) aoVar.b);
            Context applicationContext = lVar.b;
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            boolean z = applicationContext.getResources().getConfiguration().smallestScreenWidthDp >= 600;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar4 = (ar) aoVar.b;
            arVar4.b |= 268435456;
            arVar4.r = z;
            boolean zC = lVar.c();
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar5 = (ar) aoVar.b;
            arVar5.b |= Integer.MIN_VALUE;
            arVar5.s = zC;
            boolean z2 = !lVar.g();
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar6 = (ar) aoVar.b;
            arVar6.c |= 1;
            arVar6.t = z2;
            ae aeVar = (ae) af.a.q();
            int i2 = resources.getDisplayMetrics().densityDpi;
            if (!aeVar.b.H()) {
                aeVar.v();
            }
            af afVar = (af) aeVar.b;
            afVar.b = 1 | afVar.b;
            afVar.c = i2;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar7 = (ar) aoVar.b;
            af afVar2 = (af) aeVar.t();
            afVar2.getClass();
            arVar7.o = afVar2;
            arVar7.b |= 4194304;
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 > 300) {
                i = aq.d;
            } else {
                i = i3 > 200 ? aq.c : aq.a;
            }
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar8 = (ar) aoVar.b;
            if (i == 0) {
                throw null;
            }
            arVar8.f297n = i;
            arVar8.b |= 2097152;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar9 = (ar) aoVar.b;
            str.getClass();
            arVar9.b |= 1024;
            arVar9.h = str;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar.e((ar) aoVar.b);
            String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar10 = (ar) aoVar.b;
            strValueOf.getClass();
            arVar10.b |= 33554432;
            arVar10.q = strValueOf;
            h hVar = h.a;
            int iA = ak.a(context.getApplicationContext());
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar11 = (ar) aoVar.b;
            arVar11.c |= 16384;
            arVar11.C = iA;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar12 = (ar) aoVar.b;
            arVar12.c |= 512;
            arVar12.y = jLongValue;
            String strB3 = aVar.b();
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar13 = (ar) aoVar.b;
            strB3.getClass();
            arVar13.b |= 4;
            arVar13.f = strB3;
            int iE = cVar.e();
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar14 = (ar) aoVar.b;
            int i4 = iE - 1;
            if (iE == 0) {
                throw null;
            }
            arVar14.F = i4;
            arVar14.c |= 134217728;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar15 = (ar) aoVar.b;
            arVar15.A = ioVar.g;
            arVar15.c |= 2048;
            g.a(cVar.b(), new Consumer() { // from class: com.google.android.libraries.navigation.internal.il.b
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    String string = ((com.google.android.libraries.navigation.internal.jc.b) obj).toString();
                    ao aoVar2 = aoVar;
                    if (!aoVar2.b.H()) {
                        aoVar2.v();
                    }
                    ar arVar16 = (ar) aoVar2.b;
                    ar arVar17 = ar.a;
                    string.getClass();
                    arVar16.c |= 256;
                    arVar16.x = string;
                }
            });
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar16 = (ar) aoVar.b;
            arVar16.c |= 64;
            arVar16.v = strA;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar17 = (ar) aoVar.b;
            arVar17.c |= 128;
            arVar17.w = strB;
            String strC = com.google.android.libraries.navigation.internal.mh.b.c(context.getContentResolver(), "logging_id2", "");
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar arVar18 = (ar) aoVar.b;
            arVar18.b |= 131072;
            arVar18.l = strC;
            if (dVarB != null) {
                Trace.endSection();
            }
            return new d(fVar, aoVar, aVar2, cVar2, bVar, bVar2, aVar3, aVar4, aVar);
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

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final String a() {
        String str;
        synchronized (this.a) {
            str = ((ar) this.a.b).j;
        }
        return str;
    }

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final void b(String str) {
        ao aoVar;
        if (this.i.get()) {
            return;
        }
        synchronized (this.a) {
            aoVar = this.a;
        }
        if (!aoVar.b.H()) {
            aoVar.v();
        }
        ar arVar = (ar) aoVar.b;
        ar arVar2 = ar.a;
        str.getClass();
        arVar.c |= 32;
        arVar.u = str;
        this.i.set(true);
    }

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final void c() {
        synchronized (this.a) {
            ao aoVar = this.a;
            if (((ar) aoVar.b).i) {
                return;
            }
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ar.i((ar) aoVar.b);
            String strA = com.google.android.libraries.navigation.internal.hj.c.a.a();
            if (strA != null && !strA.isEmpty()) {
                ao aoVar2 = this.a;
                if (!aoVar2.b.H()) {
                    aoVar2.v();
                }
                ar arVar = (ar) aoVar2.b;
                arVar.b |= 4096;
                arVar.j = strA;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final void d(DataOutputStream dataOutputStream, n nVar) throws IOException {
        com.google.android.libraries.navigation.internal.xn.a aVar = com.google.android.libraries.navigation.internal.gh.d.a;
        com.google.android.libraries.navigation.internal.fw.ab.d(j(com.google.android.libraries.navigation.internal.io.b.c, null), bd.CLIENT_PROPERTIES_2_REQUEST, dataOutputStream, nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            z = (((ar) this.a.b).b & 4096) != 0;
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final at f(ByteBuffer byteBuffer, String str) throws IOException {
        String str2;
        at atVar = (at) com.google.android.libraries.navigation.internal.fw.ab.b(byteBuffer, (dg) at.a.aH(7, null));
        if (atVar != null) {
            synchronized (this.a) {
                if ((atVar.b & 1) != 0) {
                    String str3 = atVar.c;
                    synchronized (this.a) {
                        ao aoVar = this.a;
                        if (!aoVar.b.H()) {
                            aoVar.v();
                        }
                        ar arVar = (ar) aoVar.b;
                        ar arVar2 = ar.a;
                        str3.getClass();
                        arVar.b |= 1;
                        arVar.e = str3;
                        this.b.t(ab.P, str3);
                    }
                }
                if ((atVar.b & 256) != 0) {
                    com.google.android.libraries.navigation.internal.act.b bVar = atVar.j;
                    if (bVar == null) {
                        bVar = com.google.android.libraries.navigation.internal.act.b.a;
                    }
                    ((com.google.android.libraries.navigation.internal.ge.b) this.g.a()).b(bVar);
                }
                if ((atVar.b & 32) != 0) {
                    this.b.t(ab.O, atVar.f);
                }
                if ((atVar.b & 8) != 0) {
                    h(str, atVar.e);
                    ((k) ((com.google.android.libraries.navigation.internal.kl.a) this.h.a()).a(com.google.android.libraries.navigation.internal.km.at.a)).a(ac.a(5));
                } else {
                    ((k) ((com.google.android.libraries.navigation.internal.kl.a) this.h.a()).a(com.google.android.libraries.navigation.internal.km.at.a)).a(ac.a(4));
                    if (str == null && (str2 = this.j) != null) {
                        h(str2, null);
                        this.j = null;
                    }
                }
                if ((atVar.b & 128) != 0) {
                    com.google.android.libraries.navigation.internal.in.b bVar2 = this.e;
                    ds dsVar = atVar.i;
                    if (dsVar == null) {
                        dsVar = ds.a;
                    }
                    bVar2.a(dsVar);
                }
            }
        }
        return atVar;
    }

    @Override // com.google.android.libraries.navigation.internal.il.a
    public final void g(DataOutputStream dataOutputStream, n nVar, boolean z, com.google.android.libraries.navigation.internal.io.b bVar, String str) throws IOException {
        synchronized (this.a) {
            com.google.android.libraries.navigation.internal.fw.ab.d(j(bVar, str), bd.CLIENT_PROPERTIES_2_REQUEST, dataOutputStream, nVar);
        }
    }

    public final void h(String str, String str2) {
        synchronized (this.a) {
            if (Objects.equals(((ar) this.a.b).j, com.google.android.libraries.navigation.internal.yx.aq.b(str))) {
                if (str2 == null) {
                    ao aoVar = this.a;
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    ar arVar = (ar) aoVar.b;
                    arVar.b &= -4097;
                    arVar.j = ar.a.j;
                } else {
                    ao aoVar2 = this.a;
                    if (!aoVar2.b.H()) {
                        aoVar2.v();
                    }
                    ar arVar2 = (ar) aoVar2.b;
                    arVar2.b |= 4096;
                    arVar2.j = str2;
                }
                com.google.android.libraries.navigation.internal.hj.g gVar = com.google.android.libraries.navigation.internal.hj.c.a;
                com.google.android.libraries.navigation.internal.hj.a aVar = com.google.android.libraries.navigation.internal.hj.k.a;
                Object objA = aVar != null ? aVar.a() : null;
                com.google.android.libraries.navigation.internal.hj.b bVar = com.google.android.libraries.navigation.internal.hj.k.b;
                if (bVar == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                new Account(gVar.c, "com.google.android.apps.maps");
                bVar.b(str2, objA);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0070 A[Catch: all -> 0x021d, TryCatch #4 {, blocks: (B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:113:0x0066, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0085 A[Catch: all -> 0x021d, TryCatch #4 {, blocks: (B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:113:0x0066, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0094 A[Catch: all -> 0x021d, TryCatch #4 {, blocks: (B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:113:0x0066, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00af A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc A[Catch: all -> 0x00d0, TryCatch #0 {, blocks: (B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce), top: B:106:0x00b2, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d3 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ed A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fa A[Catch: all -> 0x010b, TryCatch #3 {, blocks: (B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109), top: B:111:0x00f0, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x010e A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x011b A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c), top: B:109:0x0111, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0134 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0187 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01a2 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01b2 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01ba A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01ce A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01da A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01f1 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0201 A[Catch: all -> 0x0220, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x000f, B:8:0x0012, B:10:0x0026, B:11:0x0029, B:13:0x0035, B:14:0x003b, B:15:0x0040, B:16:0x0065, B:28:0x00a0, B:30:0x00af, B:31:0x00b1, B:40:0x00d2, B:41:0x00d3, B:43:0x00ed, B:44:0x00ef, B:53:0x010d, B:54:0x010e, B:55:0x0110, B:61:0x012d, B:63:0x0134, B:65:0x013c, B:67:0x0140, B:69:0x015b, B:70:0x015e, B:71:0x017e, B:73:0x0180, B:75:0x0187, B:77:0x01a2, B:78:0x01a5, B:80:0x01b2, B:82:0x01ba, B:83:0x01bd, B:88:0x01e9, B:89:0x01ef, B:84:0x01ce, B:86:0x01da, B:87:0x01dd, B:91:0x01f1, B:93:0x0201, B:94:0x0204, B:95:0x0218, B:99:0x021c, B:102:0x021f, B:32:0x00b2, B:34:0x00bc, B:35:0x00bf, B:36:0x00ce, B:56:0x0111, B:58:0x011b, B:59:0x011e, B:60:0x012c, B:45:0x00f0, B:47:0x00fa, B:48:0x00fd, B:49:0x0109, B:17:0x0066, B:19:0x0070, B:20:0x0073, B:22:0x0085, B:23:0x0088, B:25:0x0094, B:26:0x009a, B:27:0x009f), top: B:108:0x0005, inners: #0, #2, #3, #4 }] */
    public final ar j(com.google.android.libraries.navigation.internal.io.b bVar, String str) {
        ev evVarG;
        ao aoVar;
        ar arVar;
        bq bqVar;
        ad adVar;
        long jB;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        ao aoVar6;
        synchronized (this.a) {
            if (str == null) {
                int i = ev.d;
                eq eqVar = new eq();
                bq bqVar2 = ((cq) this.c).a().b;
                com.google.android.libraries.navigation.internal.xn.a aVar = com.google.android.libraries.navigation.internal.gh.d.a;
                eqVar.j(bqVar2);
                eqVar.j(this.d.a());
                evVarG = eqVar.g();
                synchronized (this.a) {
                    aoVar = this.a;
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    ar arVar2 = (ar) aoVar.b;
                    ar arVar3 = ar.a;
                    arVar2.p = bj.a;
                    if (!aoVar.b.H()) {
                        aoVar.v();
                    }
                    arVar = (ar) aoVar.b;
                    bqVar = arVar.p;
                    if (!bqVar.c()) {
                        arVar.p = bi.w(bqVar);
                    }
                    com.google.android.libraries.navigation.internal.ael.b.m(evVarG, arVar.p);
                    adVar = (ad) this.b.g(ab.bV, ad.class, null);
                    if (adVar != null) {
                        g.a(com.google.android.libraries.navigation.internal.au.b.a(), new Consumer() { // from class: com.google.android.libraries.navigation.internal.il.c
                            @Override // androidx.core.util.Consumer
                            public final void accept(Object obj) {
                                com.google.android.libraries.navigation.internal.acd.l lVar = (com.google.android.libraries.navigation.internal.acd.l) obj;
                                d dVar = this.a;
                                synchronized (dVar.a) {
                                    ao aoVar7 = dVar.a;
                                    if (!aoVar7.b.H()) {
                                        aoVar7.v();
                                    }
                                    ar arVar4 = (ar) aoVar7.b;
                                    ar arVar5 = ar.a;
                                    lVar.getClass();
                                    arVar4.H = lVar;
                                    arVar4.c |= 1073741824;
                                }
                            }
                        });
                        jB = this.b.b(ab.f452cl, 0L);
                        if (jB > 0) {
                            synchronized (this.a) {
                                aoVar2 = this.a;
                                if (!aoVar2.b.H()) {
                                    aoVar2.v();
                                }
                                ar arVar4 = (ar) aoVar2.b;
                                arVar4.b |= 524288;
                                arVar4.m = true;
                                if (!e()) {
                                }
                                if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                                    aoVar3 = this.a;
                                    int iA = this.f.a();
                                    if (!aoVar3.b.H()) {
                                        aoVar3.v();
                                    }
                                    ar arVar5 = (ar) aoVar3.b;
                                    arVar5.c |= 1024;
                                    arVar5.z = iA;
                                    return (ar) this.a.t();
                                }
                                ar arVar6 = (ar) this.a.t();
                                bb bbVar = (bb) arVar6.aH(5, null);
                                bbVar.x(arVar6);
                                aoVar4 = (ao) bbVar;
                                if (!aoVar4.b.H()) {
                                    aoVar4.v();
                                }
                                ar.i((ar) aoVar4.b);
                                if (bVar.e()) {
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar7 = (ar) aoVar4.b;
                                    arVar7.b &= -4097;
                                    arVar7.j = ar.a.j;
                                } else {
                                    String strD = bVar.d();
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar8 = (ar) aoVar4.b;
                                    arVar8.b |= 4096;
                                    arVar8.j = strD;
                                }
                                return (ar) aoVar4.t();
                            }
                        }
                        synchronized (this.a) {
                            aoVar5 = this.a;
                            if (!aoVar5.b.H()) {
                                aoVar5.v();
                            }
                            ar arVar9 = (ar) aoVar5.b;
                            arVar9.d |= 8;
                            arVar9.I = jB;
                            synchronized (this.a) {
                                aoVar2 = this.a;
                                if (!aoVar2.b.H()) {
                                    aoVar2.v();
                                }
                                ar arVar10 = (ar) aoVar2.b;
                                arVar10.b |= 524288;
                                arVar10.m = true;
                                if (!e()) {
                                }
                                if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                                    aoVar3 = this.a;
                                    int iA2 = this.f.a();
                                    if (!aoVar3.b.H()) {
                                        aoVar3.v();
                                    }
                                    ar arVar11 = (ar) aoVar3.b;
                                    arVar11.c |= 1024;
                                    arVar11.z = iA2;
                                    return (ar) this.a.t();
                                }
                                ar arVar12 = (ar) this.a.t();
                                bb bbVar2 = (bb) arVar12.aH(5, null);
                                bbVar2.x(arVar12);
                                aoVar4 = (ao) bbVar2;
                                if (!aoVar4.b.H()) {
                                    aoVar4.v();
                                }
                                ar.i((ar) aoVar4.b);
                                if (bVar.e()) {
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar13 = (ar) aoVar4.b;
                                    arVar13.b &= -4097;
                                    arVar13.j = ar.a.j;
                                } else {
                                    String strD2 = bVar.d();
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar14 = (ar) aoVar4.b;
                                    arVar14.b |= 4096;
                                    arVar14.j = strD2;
                                }
                                return (ar) aoVar4.t();
                            }
                        }
                    }
                    synchronized (this.a) {
                        aoVar6 = this.a;
                        if (!aoVar6.b.H()) {
                            aoVar6.v();
                        }
                        ar arVar15 = (ar) aoVar6.b;
                        arVar15.E = adVar.e;
                        arVar15.c |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                        g.a(com.google.android.libraries.navigation.internal.au.b.a(), new Consumer() { // from class: com.google.android.libraries.navigation.internal.il.c
                            @Override // androidx.core.util.Consumer
                            public final void accept(Object obj) {
                                com.google.android.libraries.navigation.internal.acd.l lVar = (com.google.android.libraries.navigation.internal.acd.l) obj;
                                d dVar = this.a;
                                synchronized (dVar.a) {
                                    ao aoVar7 = dVar.a;
                                    if (!aoVar7.b.H()) {
                                        aoVar7.v();
                                    }
                                    ar arVar16 = (ar) aoVar7.b;
                                    ar arVar17 = ar.a;
                                    lVar.getClass();
                                    arVar16.H = lVar;
                                    arVar16.c |= 1073741824;
                                }
                            }
                        });
                        jB = this.b.b(ab.f452cl, 0L);
                        if (jB > 0) {
                            synchronized (this.a) {
                                aoVar2 = this.a;
                                if (!aoVar2.b.H()) {
                                    aoVar2.v();
                                }
                                ar arVar16 = (ar) aoVar2.b;
                                arVar16.b |= 524288;
                                arVar16.m = true;
                                if (!e()) {
                                }
                                if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                                    aoVar3 = this.a;
                                    int iA3 = this.f.a();
                                    if (!aoVar3.b.H()) {
                                        aoVar3.v();
                                    }
                                    ar arVar17 = (ar) aoVar3.b;
                                    arVar17.c |= 1024;
                                    arVar17.z = iA3;
                                    return (ar) this.a.t();
                                }
                                ar arVar18 = (ar) this.a.t();
                                bb bbVar3 = (bb) arVar18.aH(5, null);
                                bbVar3.x(arVar18);
                                aoVar4 = (ao) bbVar3;
                                if (!aoVar4.b.H()) {
                                    aoVar4.v();
                                }
                                ar.i((ar) aoVar4.b);
                                if (bVar.e()) {
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar19 = (ar) aoVar4.b;
                                    arVar19.b &= -4097;
                                    arVar19.j = ar.a.j;
                                } else {
                                    String strD3 = bVar.d();
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar110 = (ar) aoVar4.b;
                                    arVar110.b |= 4096;
                                    arVar110.j = strD3;
                                }
                                return (ar) aoVar4.t();
                            }
                        }
                        synchronized (this.a) {
                            aoVar5 = this.a;
                            if (!aoVar5.b.H()) {
                                aoVar5.v();
                            }
                            ar arVar20 = (ar) aoVar5.b;
                            arVar20.d |= 8;
                            arVar20.I = jB;
                            synchronized (this.a) {
                                aoVar2 = this.a;
                                if (!aoVar2.b.H()) {
                                    aoVar2.v();
                                }
                                ar arVar111 = (ar) aoVar2.b;
                                arVar111.b |= 524288;
                                arVar111.m = true;
                                if (!e()) {
                                }
                                if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                                    aoVar3 = this.a;
                                    int iA4 = this.f.a();
                                    if (!aoVar3.b.H()) {
                                        aoVar3.v();
                                    }
                                    ar arVar112 = (ar) aoVar3.b;
                                    arVar112.c |= 1024;
                                    arVar112.z = iA4;
                                    return (ar) this.a.t();
                                }
                                ar arVar113 = (ar) this.a.t();
                                bb bbVar4 = (bb) arVar113.aH(5, null);
                                bbVar4.x(arVar113);
                                aoVar4 = (ao) bbVar4;
                                if (!aoVar4.b.H()) {
                                    aoVar4.v();
                                }
                                ar.i((ar) aoVar4.b);
                                if (bVar.e()) {
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar114 = (ar) aoVar4.b;
                                    arVar114.b &= -4097;
                                    arVar114.j = ar.a.j;
                                } else {
                                    String strD4 = bVar.d();
                                    if (!aoVar4.b.H()) {
                                        aoVar4.v();
                                    }
                                    ar arVar115 = (ar) aoVar4.b;
                                    arVar115.b |= 4096;
                                    arVar115.j = strD4;
                                }
                                return (ar) aoVar4.t();
                            }
                        }
                    }
                }
            }
            ao aoVar7 = this.a;
            if (!aoVar7.b.H()) {
                aoVar7.v();
            }
            ar arVar21 = (ar) aoVar7.b;
            ar arVar22 = ar.a;
            arVar21.G = dj.b;
            ao aoVar8 = this.a;
            if (!aoVar8.b.H()) {
                aoVar8.v();
            }
            ar arVar23 = (ar) aoVar8.b;
            bz bzVar = arVar23.G;
            if (!bzVar.c()) {
                arVar23.G = bi.A(bzVar);
            }
            arVar23.G.add(str);
            int i2 = ev.d;
            eq eqVar2 = new eq();
            bq bqVar3 = ((cq) this.c).a().b;
            com.google.android.libraries.navigation.internal.xn.a aVar2 = com.google.android.libraries.navigation.internal.gh.d.a;
            eqVar2.j(bqVar3);
            eqVar2.j(this.d.a());
            evVarG = eqVar2.g();
            synchronized (this.a) {
                aoVar = this.a;
                if (!aoVar.b.H()) {
                    aoVar.v();
                }
                ar arVar24 = (ar) aoVar.b;
                ar arVar25 = ar.a;
                arVar24.p = bj.a;
                if (!aoVar.b.H()) {
                    aoVar.v();
                }
                arVar = (ar) aoVar.b;
                bqVar = arVar.p;
                if (!bqVar.c()) {
                    arVar.p = bi.w(bqVar);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVarG, arVar.p);
            }
            adVar = (ad) this.b.g(ab.bV, ad.class, null);
            if (adVar != null) {
                g.a(com.google.android.libraries.navigation.internal.au.b.a(), new Consumer() { // from class: com.google.android.libraries.navigation.internal.il.c
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        com.google.android.libraries.navigation.internal.acd.l lVar = (com.google.android.libraries.navigation.internal.acd.l) obj;
                        d dVar = this.a;
                        synchronized (dVar.a) {
                            ao aoVar9 = dVar.a;
                            if (!aoVar9.b.H()) {
                                aoVar9.v();
                            }
                            ar arVar116 = (ar) aoVar9.b;
                            ar arVar117 = ar.a;
                            lVar.getClass();
                            arVar116.H = lVar;
                            arVar116.c |= 1073741824;
                        }
                    }
                });
                jB = this.b.b(ab.f452cl, 0L);
                if (jB > 0) {
                    synchronized (this.a) {
                        aoVar2 = this.a;
                        if (!aoVar2.b.H()) {
                            aoVar2.v();
                        }
                        ar arVar116 = (ar) aoVar2.b;
                        arVar116.b |= 524288;
                        arVar116.m = true;
                        if (!e()) {
                        }
                        if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                            aoVar3 = this.a;
                            int iA5 = this.f.a();
                            if (!aoVar3.b.H()) {
                                aoVar3.v();
                            }
                            ar arVar117 = (ar) aoVar3.b;
                            arVar117.c |= 1024;
                            arVar117.z = iA5;
                            return (ar) this.a.t();
                        }
                        ar arVar118 = (ar) this.a.t();
                        bb bbVar5 = (bb) arVar118.aH(5, null);
                        bbVar5.x(arVar118);
                        aoVar4 = (ao) bbVar5;
                        if (!aoVar4.b.H()) {
                            aoVar4.v();
                        }
                        ar.i((ar) aoVar4.b);
                        if (bVar.e()) {
                            if (!aoVar4.b.H()) {
                                aoVar4.v();
                            }
                            ar arVar119 = (ar) aoVar4.b;
                            arVar119.b &= -4097;
                            arVar119.j = ar.a.j;
                        } else {
                            String strD5 = bVar.d();
                            if (!aoVar4.b.H()) {
                                aoVar4.v();
                            }
                            ar arVar1110 = (ar) aoVar4.b;
                            arVar1110.b |= 4096;
                            arVar1110.j = strD5;
                        }
                        return (ar) aoVar4.t();
                    }
                }
                synchronized (this.a) {
                    aoVar5 = this.a;
                    if (!aoVar5.b.H()) {
                        aoVar5.v();
                    }
                    ar arVar26 = (ar) aoVar5.b;
                    arVar26.d |= 8;
                    arVar26.I = jB;
                    synchronized (this.a) {
                        aoVar2 = this.a;
                        if (!aoVar2.b.H()) {
                            aoVar2.v();
                        }
                        ar arVar1111 = (ar) aoVar2.b;
                        arVar1111.b |= 524288;
                        arVar1111.m = true;
                        if (!e()) {
                        }
                        if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                            aoVar3 = this.a;
                            int iA6 = this.f.a();
                            if (!aoVar3.b.H()) {
                                aoVar3.v();
                            }
                            ar arVar1112 = (ar) aoVar3.b;
                            arVar1112.c |= 1024;
                            arVar1112.z = iA6;
                            return (ar) this.a.t();
                        }
                        ar arVar1113 = (ar) this.a.t();
                        bb bbVar6 = (bb) arVar1113.aH(5, null);
                        bbVar6.x(arVar1113);
                        aoVar4 = (ao) bbVar6;
                        if (!aoVar4.b.H()) {
                            aoVar4.v();
                        }
                        ar.i((ar) aoVar4.b);
                        if (bVar.e()) {
                            if (!aoVar4.b.H()) {
                                aoVar4.v();
                            }
                            ar arVar1114 = (ar) aoVar4.b;
                            arVar1114.b &= -4097;
                            arVar1114.j = ar.a.j;
                        } else {
                            String strD6 = bVar.d();
                            if (!aoVar4.b.H()) {
                                aoVar4.v();
                            }
                            ar arVar1115 = (ar) aoVar4.b;
                            arVar1115.b |= 4096;
                            arVar1115.j = strD6;
                        }
                        return (ar) aoVar4.t();
                    }
                }
            }
            synchronized (this.a) {
                aoVar6 = this.a;
                if (!aoVar6.b.H()) {
                    aoVar6.v();
                }
                ar arVar120 = (ar) aoVar6.b;
                arVar120.E = adVar.e;
                arVar120.c |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            }
            g.a(com.google.android.libraries.navigation.internal.au.b.a(), new Consumer() { // from class: com.google.android.libraries.navigation.internal.il.c
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    com.google.android.libraries.navigation.internal.acd.l lVar = (com.google.android.libraries.navigation.internal.acd.l) obj;
                    d dVar = this.a;
                    synchronized (dVar.a) {
                        ao aoVar9 = dVar.a;
                        if (!aoVar9.b.H()) {
                            aoVar9.v();
                        }
                        ar arVar1116 = (ar) aoVar9.b;
                        ar arVar1117 = ar.a;
                        lVar.getClass();
                        arVar1116.H = lVar;
                        arVar1116.c |= 1073741824;
                    }
                }
            });
            jB = this.b.b(ab.f452cl, 0L);
            if (jB > 0) {
                synchronized (this.a) {
                    aoVar2 = this.a;
                    if (!aoVar2.b.H()) {
                        aoVar2.v();
                    }
                    ar arVar1116 = (ar) aoVar2.b;
                    arVar1116.b |= 524288;
                    arVar1116.m = true;
                    if (!e()) {
                    }
                    if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                        aoVar3 = this.a;
                        int iA7 = this.f.a();
                        if (!aoVar3.b.H()) {
                            aoVar3.v();
                        }
                        ar arVar1117 = (ar) aoVar3.b;
                        arVar1117.c |= 1024;
                        arVar1117.z = iA7;
                        return (ar) this.a.t();
                    }
                    ar arVar1118 = (ar) this.a.t();
                    bb bbVar7 = (bb) arVar1118.aH(5, null);
                    bbVar7.x(arVar1118);
                    aoVar4 = (ao) bbVar7;
                    if (!aoVar4.b.H()) {
                        aoVar4.v();
                    }
                    ar.i((ar) aoVar4.b);
                    if (bVar.e()) {
                        if (!aoVar4.b.H()) {
                            aoVar4.v();
                        }
                        ar arVar1119 = (ar) aoVar4.b;
                        arVar1119.b &= -4097;
                        arVar1119.j = ar.a.j;
                    } else {
                        String strD7 = bVar.d();
                        if (!aoVar4.b.H()) {
                            aoVar4.v();
                        }
                        ar arVar11110 = (ar) aoVar4.b;
                        arVar11110.b |= 4096;
                        arVar11110.j = strD7;
                    }
                    return (ar) aoVar4.t();
                }
            }
            synchronized (this.a) {
                aoVar5 = this.a;
                if (!aoVar5.b.H()) {
                    aoVar5.v();
                }
                ar arVar27 = (ar) aoVar5.b;
                arVar27.d |= 8;
                arVar27.I = jB;
            }
            synchronized (this.a) {
                aoVar2 = this.a;
                if (!aoVar2.b.H()) {
                    aoVar2.v();
                }
                ar arVar11111 = (ar) aoVar2.b;
                arVar11111.b |= 524288;
                arVar11111.m = true;
            }
            if (!e() && com.google.android.libraries.navigation.internal.hj.c.a.a() == null && this.j == null) {
                ar arVar28 = (ar) this.a.t();
                bb bbVar8 = (bb) arVar28.aH(5, null);
                bbVar8.x(arVar28);
                ao aoVar9 = (ao) bbVar8;
                if (!aoVar9.b.H()) {
                    aoVar9.v();
                }
                ar arVar29 = (ar) aoVar9.b;
                arVar29.b &= -4097;
                arVar29.j = ar.a.j;
                ar arVar30 = (ar) aoVar9.t();
                this.j = ((ar) this.a.b).j;
                return arVar30;
            }
            if (((com.google.android.libraries.navigation.internal.io.a) bVar).a) {
                aoVar3 = this.a;
                int iA8 = this.f.a();
                if (!aoVar3.b.H()) {
                    aoVar3.v();
                }
                ar arVar11112 = (ar) aoVar3.b;
                arVar11112.c |= 1024;
                arVar11112.z = iA8;
                return (ar) this.a.t();
            }
            ar arVar11113 = (ar) this.a.t();
            bb bbVar9 = (bb) arVar11113.aH(5, null);
            bbVar9.x(arVar11113);
            aoVar4 = (ao) bbVar9;
            if (!aoVar4.b.H()) {
                aoVar4.v();
            }
            ar.i((ar) aoVar4.b);
            if (bVar.e()) {
                if (!aoVar4.b.H()) {
                    aoVar4.v();
                }
                ar arVar11114 = (ar) aoVar4.b;
                arVar11114.b &= -4097;
                arVar11114.j = ar.a.j;
            } else {
                String strD8 = bVar.d();
                if (!aoVar4.b.H()) {
                    aoVar4.v();
                }
                ar arVar11115 = (ar) aoVar4.b;
                arVar11115.b |= 4096;
                arVar11115.j = strD8;
            }
            return (ar) aoVar4.t();
            throw th;
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }
}
