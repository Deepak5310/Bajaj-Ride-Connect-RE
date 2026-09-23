package com.google.android.libraries.navigation.internal.ta;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.navigation.internal.aac.ad;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ci;
import com.google.android.libraries.navigation.internal.aac.cj;
import com.google.android.libraries.navigation.internal.aac.ck;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.afl.om;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zs.ew;
import com.google.android.libraries.navigation.internal.zs.ey;
import com.google.android.libraries.navigation.internal.zs.fa;
import com.google.android.libraries.navigation.internal.zs.fb;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac implements com.google.android.libraries.navigation.internal.sp.b {
    public final ExecutorService a;
    public final ev b;
    private final com.google.android.libraries.navigation.internal.hn.r c;
    private final com.google.android.libraries.navigation.internal.tc.j d;
    private final ev e;
    private final com.google.android.libraries.navigation.internal.te.a f;

    public ac(ExecutorService executorService, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.tc.j jVar, com.google.android.libraries.navigation.internal.te.a aVar, ev evVar, ev evVar2) {
        this.a = executorService;
        this.c = rVar;
        this.d = jVar;
        this.f = aVar;
        this.b = evVar;
        this.e = evVar2;
    }

    public static void c(final bj bjVar, Executor executor) {
        bjVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ta.ab
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    az.n(bjVar);
                } catch (ExecutionException e) {
                    throw new IllegalStateException("Failed to initialize", e);
                }
            }
        }, executor);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:104:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:107:0x030a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0325  */
    /* JADX WARN: Code duplicated, block: B:113:0x0340  */
    /* JADX WARN: Code duplicated, block: B:116:0x035b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0382  */
    /* JADX WARN: Code duplicated, block: B:122:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:125:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:128:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:131:0x0404  */
    /* JADX WARN: Code duplicated, block: B:134:0x0426  */
    /* JADX WARN: Code duplicated, block: B:137:0x0448  */
    /* JADX WARN: Code duplicated, block: B:140:0x0465  */
    /* JADX WARN: Code duplicated, block: B:143:0x0485  */
    /* JADX WARN: Code duplicated, block: B:146:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:149:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:152:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:155:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:158:0x050d  */
    /* JADX WARN: Code duplicated, block: B:161:0x052a  */
    /* JADX WARN: Code duplicated, block: B:164:0x0547  */
    /* JADX WARN: Code duplicated, block: B:167:0x0564  */
    /* JADX WARN: Code duplicated, block: B:170:0x0581  */
    /* JADX WARN: Code duplicated, block: B:173:0x059d  */
    /* JADX WARN: Code duplicated, block: B:176:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:179:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:182:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:184:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:186:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:193:0x0613  */
    /* JADX WARN: Code duplicated, block: B:196:0x061c  */
    /* JADX WARN: Code duplicated, block: B:199:0x0633  */
    /* JADX WARN: Code duplicated, block: B:203:0x0649  */
    /* JADX WARN: Code duplicated, block: B:205:0x0659  */
    /* JADX WARN: Code duplicated, block: B:207:0x065f  */
    /* JADX WARN: Code duplicated, block: B:209:0x0671  */
    /* JADX WARN: Code duplicated, block: B:211:0x0684  */
    /* JADX WARN: Code duplicated, block: B:213:0x069a  */
    /* JADX WARN: Code duplicated, block: B:216:0x06a4  */
    /* JADX WARN: Code duplicated, block: B:219:0x06af  */
    /* JADX WARN: Code duplicated, block: B:221:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:223:0x06d8  */
    /* JADX WARN: Code duplicated, block: B:228:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:230:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:232:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:235:0x0709  */
    /* JADX WARN: Code duplicated, block: B:236:0x0712  */
    /* JADX WARN: Code duplicated, block: B:238:0x0714  */
    /* JADX WARN: Code duplicated, block: B:240:0x0717  */
    /* JADX WARN: Code duplicated, block: B:242:0x0721  */
    /* JADX WARN: Code duplicated, block: B:245:0x072c  */
    /* JADX WARN: Code duplicated, block: B:246:0x0735  */
    /* JADX WARN: Code duplicated, block: B:248:0x0737  */
    /* JADX WARN: Code duplicated, block: B:250:0x073a  */
    /* JADX WARN: Code duplicated, block: B:252:0x0744  */
    /* JADX WARN: Code duplicated, block: B:255:0x074f  */
    /* JADX WARN: Code duplicated, block: B:256:0x0758  */
    /* JADX WARN: Code duplicated, block: B:258:0x075a  */
    /* JADX WARN: Code duplicated, block: B:260:0x0764  */
    /* JADX WARN: Code duplicated, block: B:263:0x076f  */
    /* JADX WARN: Code duplicated, block: B:266:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:268:0x07da  */
    /* JADX WARN: Code duplicated, block: B:46:0x00df  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:50:0x010b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0128  */
    /* JADX WARN: Code duplicated, block: B:56:0x0141  */
    /* JADX WARN: Code duplicated, block: B:58:0x0144  */
    /* JADX WARN: Code duplicated, block: B:59:0x0147  */
    /* JADX WARN: Code duplicated, block: B:60:0x014a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0154  */
    /* JADX WARN: Code duplicated, block: B:66:0x015f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0170  */
    /* JADX WARN: Code duplicated, block: B:71:0x018e  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x0209  */
    /* JADX WARN: Code duplicated, block: B:86:0x0229  */
    /* JADX WARN: Code duplicated, block: B:89:0x0244  */
    /* JADX WARN: Code duplicated, block: B:92:0x026a  */
    /* JADX WARN: Code duplicated, block: B:95:0x028a  */
    /* JADX WARN: Code duplicated, block: B:98:0x02aa  */
    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(final com.google.android.libraries.navigation.internal.sp.c cVar) {
        String str;
        String str2;
        Long lValueOf;
        al alVar;
        int i;
        boolean z;
        String strC;
        com.google.android.libraries.navigation.internal.hn.p pVarB;
        ew ewVar;
        int iOrdinal;
        int i2;
        fb fbVar;
        int i3;
        Resources resources;
        int identifier;
        int integer;
        int i4;
        fb fbVar2;
        int i5;
        int i6;
        fb fbVar3;
        int i7;
        int i8;
        fb fbVar4;
        int i9;
        int i10;
        fb fbVar5;
        int i11;
        Optional optionalK;
        com.google.android.libraries.navigation.internal.zr.j jVar;
        int iA;
        com.google.android.libraries.navigation.internal.zr.q qVar;
        int i12;
        int iC;
        boolean z2;
        boolean z3 = ((hm) this.c.b()).q;
        ev evVar = this.e;
        if (z3) {
            ArrayList arrayList = new ArrayList();
            int i13 = ((lv) evVar).c;
            for (int i14 = 0; i14 < i13; i14++) {
                final com.google.android.libraries.navigation.internal.sp.b bVar = (com.google.android.libraries.navigation.internal.sp.b) evVar.get(i14);
                arrayList.add(this.a.submit(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ta.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.a(cVar);
                    }
                }));
            }
            int size = arrayList.size();
            for (int i15 = 0; i15 < size; i15++) {
                Future future = (Future) arrayList.get(i15);
                ar.q(future);
                try {
                    ck.a(future);
                } catch (ExecutionException e) {
                    if (!(e.getCause() instanceof Error)) {
                        throw new cj(e.getCause());
                    }
                    throw new ad((Error) e.getCause());
                }
            }
        } else {
            int i16 = ((lv) evVar).c;
            for (int i17 = 0; i17 < i16; i17++) {
                ((com.google.android.libraries.navigation.internal.sp.b) evVar.get(i17)).a(cVar);
            }
        }
        this.f.a(cVar);
        com.google.android.libraries.navigation.internal.tc.j jVar2 = this.d;
        ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.so.e eVar = cVar.c;
        com.google.android.libraries.navigation.internal.si.e eVar2 = cVar.a;
        if (eVar != null) {
            str = eVar.c;
            if (eVar2 == com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV) {
                Context context = jVar2.a;
                bg bgVarF = eVar.b().f();
                if (bgVarF != null) {
                    mf mfVar = bgVarF.d;
                    if ((mfVar.b & 8) != 0) {
                        com.google.android.libraries.navigation.internal.afl.lv lvVar = mfVar.f;
                        if (lvVar == null) {
                            lvVar = com.google.android.libraries.navigation.internal.afl.lv.a;
                        }
                        int i18 = lvVar.b;
                        String str3 = (i18 & 2) != 0 ? lvVar.d : null;
                        if ((i18 & 4) != 0) {
                            lValueOf = Long.valueOf(lvVar.e);
                            str2 = str3;
                        } else {
                            str2 = str3;
                        }
                    }
                    lValueOf = null;
                }
            }
            alVar = cVar.b;
            i = jVar2.g + 1;
            jVar2.g = i;
            jVar2.hashCode();
            if (jVar2.d == null) {
                z = true;
            } else {
                z = false;
            }
            ar.k(z);
            strC = com.google.android.libraries.navigation.internal.tc.j.c(str);
            pVarB = jVar2.b.b();
            om omVarV = jVar2.b.V();
            ewVar = (ew) fb.a.q();
            int iG = pVarB.g();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar6 = (fb) ewVar.b;
            fbVar6.b |= 4194304;
            fbVar6.y = iG;
            int iE = pVarB.e();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar7 = (fb) ewVar.b;
            fbVar7.b |= 2097152;
            fbVar7.x = iE;
            com.google.android.libraries.navigation.internal.si.e eVar3 = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
            iOrdinal = eVar2.ordinal();
            if (iOrdinal != 0) {
                i2 = fa.c;
            } else if (iOrdinal != 1) {
                i2 = fa.a;
            } else {
                i2 = fa.b;
            }
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fbVar = (fb) ewVar.b;
            i3 = i2 - 1;
            if (i2 != 0) {
                throw null;
            }
            fbVar.z = i3;
            fbVar.b |= 268435456;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar8 = (fb) ewVar.b;
            fbVar8.A = alVar.k;
            fbVar8.b |= PropertyOptions.DELETE_EXISTING;
            boolean zQ = pVarB.q();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar9 = (fb) ewVar.b;
            fbVar9.b |= 1;
            fbVar9.d = zQ;
            boolean zS = pVarB.s();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar10 = (fb) ewVar.b;
            fbVar10.b |= 2;
            fbVar10.e = zS;
            int iMax = Math.max(1, pVarB.a.R);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar11 = (fb) ewVar.b;
            fbVar11.b |= 4;
            fbVar11.f = iMax;
            int iMax2 = Math.max(0, pVarB.a.S);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar12 = (fb) ewVar.b;
            fbVar12.b |= 8;
            fbVar12.g = iMax2;
            int iMax3 = Math.max(1, pVarB.a.T);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar13 = (fb) ewVar.b;
            fbVar13.b |= 16;
            fbVar13.h = iMax3;
            int iMax4 = Math.max(1, pVarB.a.U);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar14 = (fb) ewVar.b;
            fbVar14.b |= 32;
            fbVar14.i = iMax4;
            int iD = pVarB.d();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar15 = (fb) ewVar.b;
            fbVar15.b |= 64;
            fbVar15.j = iD;
            int iMax5 = Math.max(pVarB.d() + 100, pVarB.a.W);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar16 = (fb) ewVar.b;
            fbVar16.b |= 128;
            fbVar16.k = iMax5;
            int iMax6 = Math.max(0, pVarB.a.X);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar17 = (fb) ewVar.b;
            fbVar17.b |= 256;
            fbVar17.l = iMax6;
            int iMax7 = Math.max(1, pVarB.a.Y);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar18 = (fb) ewVar.b;
            fbVar18.b |= 512;
            fbVar18.m = iMax7;
            int iMax8 = Math.max(1, pVarB.a.Z);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar19 = (fb) ewVar.b;
            fbVar19.b |= 1024;
            fbVar19.f677n = iMax8;
            int iMax9 = Math.max(0, pVarB.a.aa);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar20 = (fb) ewVar.b;
            fbVar20.b |= 2048;
            fbVar20.o = iMax9;
            int iMax10 = Math.max(0, pVarB.a.ab);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar21 = (fb) ewVar.b;
            fbVar21.b |= 4096;
            fbVar21.p = iMax10;
            boolean z4 = pVarB.a.ac;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar22 = (fb) ewVar.b;
            fbVar22.b |= 8192;
            fbVar22.q = z4;
            boolean z5 = pVarB.a.ad;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar23 = (fb) ewVar.b;
            fbVar23.b |= 16384;
            fbVar23.r = z5;
            boolean z6 = pVarB.a.ae;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar24 = (fb) ewVar.b;
            fbVar24.b |= 32768;
            fbVar24.s = z6;
            int iMin = Math.min(100, Math.max(0, pVarB.a.af));
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar25 = (fb) ewVar.b;
            fbVar25.b |= 65536;
            fbVar25.t = iMin;
            int iMax11 = Math.max(0, pVarB.a.ag);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar26 = (fb) ewVar.b;
            fbVar26.b |= 131072;
            fbVar26.u = iMax11;
            boolean z7 = pVarB.a.ah;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar27 = (fb) ewVar.b;
            fbVar27.b |= 262144;
            fbVar27.v = z7;
            int iMax12 = Math.max(0, pVarB.a.ai);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar28 = (fb) ewVar.b;
            fbVar28.b |= 524288;
            fbVar28.w = iMax12;
            int iMax13 = Math.max(1, pVarB.a.aj);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar29 = (fb) ewVar.b;
            fbVar29.b |= 1073741824;
            fbVar29.B = iMax13;
            int iMax14 = Math.max(1, pVarB.a.ao);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar30 = (fb) ewVar.b;
            fbVar30.b |= Integer.MIN_VALUE;
            fbVar30.C = iMax14;
            int iMax15 = Math.max(0, pVarB.a.ap);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar31 = (fb) ewVar.b;
            fbVar31.c |= 1;
            fbVar31.D = iMax15;
            int iB = pVarB.b();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar32 = (fb) ewVar.b;
            fbVar32.c |= 4;
            fbVar32.E = iB;
            int iMax16 = Math.max(0, pVarB.a.ar);
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar33 = (fb) ewVar.b;
            fbVar33.c |= 8;
            fbVar33.F = iMax16;
            boolean zR = pVarB.r();
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar34 = (fb) ewVar.b;
            fbVar34.c |= 16;
            fbVar34.G = zR;
            boolean z8 = pVarB.a.au;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar35 = (fb) ewVar.b;
            fbVar35.c |= 32;
            fbVar35.H = z8;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar36 = (fb) ewVar.b;
            fbVar36.c |= 128;
            fbVar36.J = false;
            float f = pVarB.h().b;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar37 = (fb) ewVar.b;
            fbVar37.c |= 256;
            fbVar37.K = f;
            float f2 = pVarB.h().c;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar38 = (fb) ewVar.b;
            fbVar38.c |= 512;
            fbVar38.L = f2;
            float f3 = pVarB.h().d;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar39 = (fb) ewVar.b;
            fbVar39.c |= 1024;
            fbVar39.M = f3;
            float f4 = pVarB.h().e;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar40 = (fb) ewVar.b;
            fbVar40.c |= 2048;
            fbVar40.N = f4;
            boolean z9 = pVarB.h().h;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar41 = (fb) ewVar.b;
            fbVar41.c |= 32768;
            fbVar41.Q = z9;
            int i19 = pVarB.h().f;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar42 = (fb) ewVar.b;
            fbVar42.c |= 65536;
            fbVar42.R = i19;
            int i20 = pVarB.h().g;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar43 = (fb) ewVar.b;
            fbVar43.c |= 131072;
            fbVar43.S = i20;
            int i21 = pVarB.h().i;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar44 = (fb) ewVar.b;
            fbVar44.c |= 262144;
            fbVar44.T = i21;
            int i22 = pVarB.a.az;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar45 = (fb) ewVar.b;
            fbVar45.c |= 8192;
            fbVar45.P = i22;
            if (alVar == al.TRANSIT) {
                iC = pVarB.c();
                if (iC > 0) {
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fb fbVar46 = (fb) ewVar.b;
                    fbVar46.c |= 4;
                    fbVar46.E = iC;
                }
                if (((fb) ewVar.b).e || !omVarV.c) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fb fbVar47 = (fb) ewVar.b;
                fbVar47.b |= 2;
                fbVar47.e = z2;
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fb fbVar48 = (fb) ewVar.b;
                fbVar48.b |= 1;
                fbVar48.d = false;
            }
            if (pVarB.o()) {
                com.google.android.libraries.navigation.internal.au.c cVar2 = jVar2.h;
                optionalK = com.google.android.libraries.navigation.internal.au.c.a().k();
                if (optionalK.isPresent()) {
                    if (pVarB.p()) {
                        com.google.android.libraries.navigation.internal.zr.q qVarA = com.google.android.libraries.navigation.internal.tg.a.a((com.google.android.libraries.navigation.internal.zr.q) optionalK.get());
                        if (!ewVar.b.H()) {
                            ewVar.v();
                        }
                        fb fbVar49 = (fb) ewVar.b;
                        qVarA.getClass();
                        fbVar49.I = qVarA;
                        fbVar49.c |= 64;
                    } else {
                        jVar = (com.google.android.libraries.navigation.internal.zr.j) com.google.android.libraries.navigation.internal.zr.q.a.q();
                        iA = com.google.android.libraries.navigation.internal.zr.p.a(((com.google.android.libraries.navigation.internal.zr.q) optionalK.get()).c);
                        if (iA == 0) {
                            iA = com.google.android.libraries.navigation.internal.zr.p.a;
                        }
                        if (!jVar.b.H()) {
                            jVar.v();
                        }
                        qVar = (com.google.android.libraries.navigation.internal.zr.q) jVar.b;
                        i12 = iA - 1;
                        if (iA != 0) {
                            throw null;
                        }
                        qVar.c = i12;
                        qVar.b |= 1;
                        if (!ewVar.b.H()) {
                            ewVar.v();
                        }
                        fb fbVar50 = (fb) ewVar.b;
                        com.google.android.libraries.navigation.internal.zr.q qVar2 = (com.google.android.libraries.navigation.internal.zr.q) jVar.t();
                        qVar2.getClass();
                        fbVar50.I = qVar2;
                        fbVar50.c |= 64;
                    }
                }
            }
            resources = jVar2.a.getResources();
            identifier = resources.getIdentifier("config_navBarInteractionMode", TypedValues.Custom.S_INT, SystemMediaRouteProvider.PACKAGE_NAME);
            if (identifier != 0) {
                integer = resources.getInteger(identifier);
                if (integer == 0) {
                    i10 = ey.b;
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fbVar5 = (fb) ewVar.b;
                    i11 = i10 - 1;
                    if (i10 != 0) {
                        throw null;
                    }
                    fbVar5.O = i11;
                    fbVar5.c |= 4096;
                } else if (integer == 1) {
                    i8 = ey.c;
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fbVar4 = (fb) ewVar.b;
                    i9 = i8 - 1;
                    if (i8 != 0) {
                        throw null;
                    }
                    fbVar4.O = i9;
                    fbVar4.c |= 4096;
                } else if (integer == 2) {
                    i6 = ey.d;
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fbVar3 = (fb) ewVar.b;
                    i7 = i6 - 1;
                    if (i6 != 0) {
                        throw null;
                    }
                    fbVar3.O = i7;
                    fbVar3.c |= 4096;
                } else {
                    i4 = ey.a;
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fbVar2 = (fb) ewVar.b;
                    i5 = i4 - 1;
                    if (i4 != 0) {
                        throw null;
                    }
                    fbVar2.O = i5;
                    fbVar2.c |= 4096;
                }
            }
            com.google.android.libraries.navigation.internal.tc.i iVar = new com.google.android.libraries.navigation.internal.tc.i(i, (fb) ewVar.t(), strC, str2, lValueOf);
            ap.NAVIGATION_INTERNAL.f();
            jVar2.f(iVar);
            ap.NAVIGATION_INTERNAL.f();
            jVar2.e = new com.google.android.libraries.navigation.internal.tc.h(jVar2, iVar);
            com.google.android.libraries.navigation.internal.nt.m mVarC = jVar2.i.c();
            com.google.android.libraries.navigation.internal.tc.h hVar = jVar2.e;
            ar.q(hVar);
            mVarC.g(hVar, jVar2.c);
            jVar2.f = new com.google.android.libraries.navigation.internal.tc.g(jVar2, jVar2.j.c());
            com.google.android.libraries.navigation.internal.nt.a aVarA = jVar2.j.a();
            com.google.android.libraries.navigation.internal.tc.g gVar = jVar2.f;
            ar.q(gVar);
            aVarA.b(gVar, jVar2.c);
            bj bjVarA = jVar2.a(iVar);
            bjVarA.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ta.x
                @Override // java.lang.Runnable
                public final void run() {
                    ac acVar = this.a;
                    ev evVar2 = acVar.b;
                    int size2 = evVar2.size();
                    for (int i23 = 0; i23 < size2; i23++) {
                        final com.google.android.libraries.navigation.internal.sp.c cVar3 = cVar;
                        final com.google.android.libraries.navigation.internal.sp.b bVar2 = (com.google.android.libraries.navigation.internal.sp.b) evVar2.get(i23);
                        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.ta.y
                            @Override // java.lang.Runnable
                            public final void run() {
                                bVar2.a(cVar3);
                            }
                        };
                        ExecutorService executorService = acVar.a;
                        ci ciVarF = ci.f(runnable, null);
                        executorService.execute(ciVarF);
                        ac.c(ciVarF, acVar.a);
                    }
                }
            }, this.a);
            c(bjVarA, this.a);
        }
        str = "";
        str2 = null;
        lValueOf = null;
        alVar = cVar.b;
        i = jVar2.g + 1;
        jVar2.g = i;
        jVar2.hashCode();
        if (jVar2.d == null) {
            z = true;
        } else {
            z = false;
        }
        ar.k(z);
        strC = com.google.android.libraries.navigation.internal.tc.j.c(str);
        pVarB = jVar2.b.b();
        om omVarV2 = jVar2.b.V();
        ewVar = (ew) fb.a.q();
        int iG2 = pVarB.g();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar51 = (fb) ewVar.b;
        fbVar51.b |= 4194304;
        fbVar51.y = iG2;
        int iE2 = pVarB.e();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar52 = (fb) ewVar.b;
        fbVar52.b |= 2097152;
        fbVar52.x = iE2;
        com.google.android.libraries.navigation.internal.si.e eVar4 = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
        iOrdinal = eVar2.ordinal();
        if (iOrdinal != 0) {
            i2 = fa.c;
        } else if (iOrdinal != 1) {
            i2 = fa.a;
        } else {
            i2 = fa.b;
        }
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fbVar = (fb) ewVar.b;
        i3 = i2 - 1;
        if (i2 != 0) {
            throw null;
        }
        fbVar.z = i3;
        fbVar.b |= 268435456;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar53 = (fb) ewVar.b;
        fbVar53.A = alVar.k;
        fbVar53.b |= PropertyOptions.DELETE_EXISTING;
        boolean zQ2 = pVarB.q();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar54 = (fb) ewVar.b;
        fbVar54.b |= 1;
        fbVar54.d = zQ2;
        boolean zS2 = pVarB.s();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar110 = (fb) ewVar.b;
        fbVar110.b |= 2;
        fbVar110.e = zS2;
        int iMax17 = Math.max(1, pVarB.a.R);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar111 = (fb) ewVar.b;
        fbVar111.b |= 4;
        fbVar111.f = iMax17;
        int iMax18 = Math.max(0, pVarB.a.S);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar112 = (fb) ewVar.b;
        fbVar112.b |= 8;
        fbVar112.g = iMax18;
        int iMax19 = Math.max(1, pVarB.a.T);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar113 = (fb) ewVar.b;
        fbVar113.b |= 16;
        fbVar113.h = iMax19;
        int iMax20 = Math.max(1, pVarB.a.U);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar114 = (fb) ewVar.b;
        fbVar114.b |= 32;
        fbVar114.i = iMax20;
        int iD2 = pVarB.d();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar115 = (fb) ewVar.b;
        fbVar115.b |= 64;
        fbVar115.j = iD2;
        int iMax21 = Math.max(pVarB.d() + 100, pVarB.a.W);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar116 = (fb) ewVar.b;
        fbVar116.b |= 128;
        fbVar116.k = iMax21;
        int iMax22 = Math.max(0, pVarB.a.X);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar117 = (fb) ewVar.b;
        fbVar117.b |= 256;
        fbVar117.l = iMax22;
        int iMax23 = Math.max(1, pVarB.a.Y);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar118 = (fb) ewVar.b;
        fbVar118.b |= 512;
        fbVar118.m = iMax23;
        int iMax24 = Math.max(1, pVarB.a.Z);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar119 = (fb) ewVar.b;
        fbVar119.b |= 1024;
        fbVar119.f677n = iMax24;
        int iMax25 = Math.max(0, pVarB.a.aa);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar210 = (fb) ewVar.b;
        fbVar210.b |= 2048;
        fbVar210.o = iMax25;
        int iMax110 = Math.max(0, pVarB.a.ab);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar211 = (fb) ewVar.b;
        fbVar211.b |= 4096;
        fbVar211.p = iMax110;
        boolean z10 = pVarB.a.ac;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar212 = (fb) ewVar.b;
        fbVar212.b |= 8192;
        fbVar212.q = z10;
        boolean z11 = pVarB.a.ad;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar213 = (fb) ewVar.b;
        fbVar213.b |= 16384;
        fbVar213.r = z11;
        boolean z12 = pVarB.a.ae;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar214 = (fb) ewVar.b;
        fbVar214.b |= 32768;
        fbVar214.s = z12;
        int iMin2 = Math.min(100, Math.max(0, pVarB.a.af));
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar215 = (fb) ewVar.b;
        fbVar215.b |= 65536;
        fbVar215.t = iMin2;
        int iMax111 = Math.max(0, pVarB.a.ag);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar216 = (fb) ewVar.b;
        fbVar216.b |= 131072;
        fbVar216.u = iMax111;
        boolean z13 = pVarB.a.ah;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar217 = (fb) ewVar.b;
        fbVar217.b |= 262144;
        fbVar217.v = z13;
        int iMax112 = Math.max(0, pVarB.a.ai);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar218 = (fb) ewVar.b;
        fbVar218.b |= 524288;
        fbVar218.w = iMax112;
        int iMax113 = Math.max(1, pVarB.a.aj);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar219 = (fb) ewVar.b;
        fbVar219.b |= 1073741824;
        fbVar219.B = iMax113;
        int iMax114 = Math.max(1, pVarB.a.ao);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar310 = (fb) ewVar.b;
        fbVar310.b |= Integer.MIN_VALUE;
        fbVar310.C = iMax114;
        int iMax115 = Math.max(0, pVarB.a.ap);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar311 = (fb) ewVar.b;
        fbVar311.c |= 1;
        fbVar311.D = iMax115;
        int iB2 = pVarB.b();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar312 = (fb) ewVar.b;
        fbVar312.c |= 4;
        fbVar312.E = iB2;
        int iMax116 = Math.max(0, pVarB.a.ar);
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar313 = (fb) ewVar.b;
        fbVar313.c |= 8;
        fbVar313.F = iMax116;
        boolean zR2 = pVarB.r();
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar314 = (fb) ewVar.b;
        fbVar314.c |= 16;
        fbVar314.G = zR2;
        boolean z14 = pVarB.a.au;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar315 = (fb) ewVar.b;
        fbVar315.c |= 32;
        fbVar315.H = z14;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar316 = (fb) ewVar.b;
        fbVar316.c |= 128;
        fbVar316.J = false;
        float f5 = pVarB.h().b;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar317 = (fb) ewVar.b;
        fbVar317.c |= 256;
        fbVar317.K = f5;
        float f6 = pVarB.h().c;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar318 = (fb) ewVar.b;
        fbVar318.c |= 512;
        fbVar318.L = f6;
        float f7 = pVarB.h().d;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar319 = (fb) ewVar.b;
        fbVar319.c |= 1024;
        fbVar319.M = f7;
        float f8 = pVarB.h().e;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar410 = (fb) ewVar.b;
        fbVar410.c |= 2048;
        fbVar410.N = f8;
        boolean z15 = pVarB.h().h;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar411 = (fb) ewVar.b;
        fbVar411.c |= 32768;
        fbVar411.Q = z15;
        int i110 = pVarB.h().f;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar412 = (fb) ewVar.b;
        fbVar412.c |= 65536;
        fbVar412.R = i110;
        int i23 = pVarB.h().g;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar413 = (fb) ewVar.b;
        fbVar413.c |= 131072;
        fbVar413.S = i23;
        int i24 = pVarB.h().i;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar414 = (fb) ewVar.b;
        fbVar414.c |= 262144;
        fbVar414.T = i24;
        int i25 = pVarB.a.az;
        if (!ewVar.b.H()) {
            ewVar.v();
        }
        fb fbVar415 = (fb) ewVar.b;
        fbVar415.c |= 8192;
        fbVar415.P = i25;
        if (alVar == al.TRANSIT) {
            iC = pVarB.c();
            if (iC > 0) {
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fb fbVar416 = (fb) ewVar.b;
                fbVar416.c |= 4;
                fbVar416.E = iC;
            }
            if (((fb) ewVar.b).e) {
                z2 = false;
            } else {
                z2 = false;
            }
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar417 = (fb) ewVar.b;
            fbVar417.b |= 2;
            fbVar417.e = z2;
            if (!ewVar.b.H()) {
                ewVar.v();
            }
            fb fbVar418 = (fb) ewVar.b;
            fbVar418.b |= 1;
            fbVar418.d = false;
        }
        if (pVarB.o()) {
            com.google.android.libraries.navigation.internal.au.c cVar3 = jVar2.h;
            optionalK = com.google.android.libraries.navigation.internal.au.c.a().k();
            if (optionalK.isPresent()) {
                if (pVarB.p()) {
                    com.google.android.libraries.navigation.internal.zr.q qVarA2 = com.google.android.libraries.navigation.internal.tg.a.a((com.google.android.libraries.navigation.internal.zr.q) optionalK.get());
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fb fbVar419 = (fb) ewVar.b;
                    qVarA2.getClass();
                    fbVar419.I = qVarA2;
                    fbVar419.c |= 64;
                } else {
                    jVar = (com.google.android.libraries.navigation.internal.zr.j) com.google.android.libraries.navigation.internal.zr.q.a.q();
                    iA = com.google.android.libraries.navigation.internal.zr.p.a(((com.google.android.libraries.navigation.internal.zr.q) optionalK.get()).c);
                    if (iA == 0) {
                        iA = com.google.android.libraries.navigation.internal.zr.p.a;
                    }
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    qVar = (com.google.android.libraries.navigation.internal.zr.q) jVar.b;
                    i12 = iA - 1;
                    if (iA != 0) {
                        throw null;
                    }
                    qVar.c = i12;
                    qVar.b |= 1;
                    if (!ewVar.b.H()) {
                        ewVar.v();
                    }
                    fb fbVar55 = (fb) ewVar.b;
                    com.google.android.libraries.navigation.internal.zr.q qVar3 = (com.google.android.libraries.navigation.internal.zr.q) jVar.t();
                    qVar3.getClass();
                    fbVar55.I = qVar3;
                    fbVar55.c |= 64;
                }
            }
        }
        resources = jVar2.a.getResources();
        identifier = resources.getIdentifier("config_navBarInteractionMode", TypedValues.Custom.S_INT, SystemMediaRouteProvider.PACKAGE_NAME);
        if (identifier != 0) {
            integer = resources.getInteger(identifier);
            if (integer == 0) {
                i10 = ey.b;
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fbVar5 = (fb) ewVar.b;
                i11 = i10 - 1;
                if (i10 != 0) {
                    throw null;
                }
                fbVar5.O = i11;
                fbVar5.c |= 4096;
            } else if (integer == 1) {
                i8 = ey.c;
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fbVar4 = (fb) ewVar.b;
                i9 = i8 - 1;
                if (i8 != 0) {
                    throw null;
                }
                fbVar4.O = i9;
                fbVar4.c |= 4096;
            } else if (integer == 2) {
                i6 = ey.d;
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fbVar3 = (fb) ewVar.b;
                i7 = i6 - 1;
                if (i6 != 0) {
                    throw null;
                }
                fbVar3.O = i7;
                fbVar3.c |= 4096;
            } else {
                i4 = ey.a;
                if (!ewVar.b.H()) {
                    ewVar.v();
                }
                fbVar2 = (fb) ewVar.b;
                i5 = i4 - 1;
                if (i4 != 0) {
                    throw null;
                }
                fbVar2.O = i5;
                fbVar2.c |= 4096;
            }
        }
        com.google.android.libraries.navigation.internal.tc.i iVar2 = new com.google.android.libraries.navigation.internal.tc.i(i, (fb) ewVar.t(), strC, str2, lValueOf);
        ap.NAVIGATION_INTERNAL.f();
        jVar2.f(iVar2);
        ap.NAVIGATION_INTERNAL.f();
        jVar2.e = new com.google.android.libraries.navigation.internal.tc.h(jVar2, iVar2);
        com.google.android.libraries.navigation.internal.nt.m mVarC2 = jVar2.i.c();
        com.google.android.libraries.navigation.internal.tc.h hVar2 = jVar2.e;
        ar.q(hVar2);
        mVarC2.g(hVar2, jVar2.c);
        jVar2.f = new com.google.android.libraries.navigation.internal.tc.g(jVar2, jVar2.j.c());
        com.google.android.libraries.navigation.internal.nt.a aVarA2 = jVar2.j.a();
        com.google.android.libraries.navigation.internal.tc.g gVar2 = jVar2.f;
        ar.q(gVar2);
        aVarA2.b(gVar2, jVar2.c);
        bj bjVarA2 = jVar2.a(iVar2);
        bjVarA2.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ta.x
            @Override // java.lang.Runnable
            public final void run() {
                ac acVar = this.a;
                ev evVar2 = acVar.b;
                int size2 = evVar2.size();
                for (int i26 = 0; i26 < size2; i26++) {
                    final com.google.android.libraries.navigation.internal.sp.c cVar4 = cVar;
                    final com.google.android.libraries.navigation.internal.sp.b bVar2 = (com.google.android.libraries.navigation.internal.sp.b) evVar2.get(i26);
                    Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.ta.y
                        @Override // java.lang.Runnable
                        public final void run() {
                            bVar2.a(cVar4);
                        }
                    };
                    ExecutorService executorService = acVar.a;
                    ci ciVarF = ci.f(runnable, null);
                    executorService.execute(ciVarF);
                    ac.c(ciVarF, acVar.a);
                }
            }
        }, this.a);
        c(bjVarA2, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(final boolean z) {
        this.e.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.ta.z
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((com.google.android.libraries.navigation.internal.sp.b) obj).b(z);
            }
        });
        this.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.ta.aa
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((com.google.android.libraries.navigation.internal.sp.b) obj).b(z);
            }
        });
        ap.NAVIGATION_INTERNAL.f();
        this.d.d(z);
        this.f.b(z);
    }
}
