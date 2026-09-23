package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.de;
import com.google.android.libraries.navigation.internal.adg.df;
import com.google.android.libraries.navigation.internal.adg.dh;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.eh;
import com.google.android.libraries.navigation.internal.adg.eq;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.fi;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.gg;
import com.google.android.libraries.navigation.internal.adg.gi;
import com.google.android.libraries.navigation.internal.adg.gw;
import com.google.android.libraries.navigation.internal.adg.gy;
import com.google.android.libraries.navigation.internal.adg.ha;
import com.google.android.libraries.navigation.internal.adg.hc;
import com.google.android.libraries.navigation.internal.adg.hf;
import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.hm;
import com.google.android.libraries.navigation.internal.adg.iv;
import com.google.android.libraries.navigation.internal.adg.jh;
import com.google.android.libraries.navigation.internal.adg.jj;
import com.google.android.libraries.navigation.internal.adg.jn;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DataFormatException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cq implements cc {
    public static final com.google.android.libraries.navigation.internal.ael.ar a;
    public final ce b;
    public final ev c;
    public final ev d;
    public final int e;
    public final List f;
    public final eh g;
    public final jn i;
    public final ev j;
    public final ev k;
    public final com.google.android.libraries.navigation.internal.adg.bu[] l;
    public final com.google.android.libraries.navigation.internal.adi.an m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.oe.as f65n;
    public final int q;
    public final byte[] r;
    public final fd s;
    private com.google.android.libraries.navigation.internal.dm.s u;
    public volatile Boolean t = null;
    public final byte[] h = null;
    public final byte[] o = null;
    public final boolean p = false;

    static {
        com.google.android.libraries.navigation.internal.ael.ar arVarC = com.google.android.libraries.navigation.internal.ael.ar.c();
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.a);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.b);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.c);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.d);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.e);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.f);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.g);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.h);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.i);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.j);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.k);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.l);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.m);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.f182n);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.o);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.p);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.q);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.r);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.s);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.t);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.u);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.v);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.w);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.x);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.y);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.z);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.A);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.B);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.C);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.D);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.E);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.F);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.G);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.H);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.I);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.J);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.K);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.L);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.M);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.N);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.O);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.P);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.Q);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.R);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.S);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.T);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.U);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.V);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.W);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.X);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.Y);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.Z);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.aa);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ab);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ac);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ad);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ae);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.af);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ag);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ah);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ai);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.aj);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ak);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.al);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.am);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.an);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ao);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ap);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.aq);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bj.ar);
        arVarC.d(et.a);
        arVarC.d(et.b);
        arVarC.d(et.c);
        arVarC.d(et.d);
        arVarC.d(et.e);
        arVarC.d(et.f);
        arVarC.d(et.g);
        arVarC.d(et.h);
        arVarC.d(et.i);
        arVarC.d(et.j);
        arVarC.d(et.k);
        arVarC.d(et.l);
        arVarC.d(com.google.android.libraries.navigation.internal.acq.a.a);
        arVarC.d(com.google.android.libraries.navigation.internal.adg.bm.a);
        arVarC.d(fu.b);
        arVarC.d(fu.c);
        arVarC.d(fu.d);
        arVarC.d(fu.e);
        arVarC.d(fu.f);
        arVarC.d(fu.g);
        arVarC.d(fu.h);
        arVarC.d(fu.i);
        arVarC.d(fu.j);
        arVarC.d(fu.k);
        arVarC.d(fu.l);
        arVarC.d(fu.m);
        arVarC.d(fu.f199n);
        arVarC.d(fu.o);
        arVarC.d(fu.p);
        arVarC.d(fu.q);
        arVarC.d(fu.r);
        arVarC.d(fu.s);
        arVarC.d(fu.t);
        arVarC.d(fu.u);
        arVarC.d(fu.v);
        arVarC.d(fu.w);
        arVarC.d(fu.x);
        arVarC.d(fu.y);
        arVarC.d(fu.z);
        arVarC.d(fu.A);
        arVarC.d(fu.B);
        arVarC.d(fu.C);
        arVarC.d(fu.D);
        arVarC.d(fu.E);
        arVarC.d(fu.F);
        arVarC.d(fu.G);
        arVarC.d(fu.H);
        arVarC.d(fu.I);
        arVarC.d(fu.J);
        arVarC.d(fu.K);
        arVarC.d(fu.L);
        arVarC.d(fu.M);
        arVarC.d(fu.N);
        arVarC.d(fu.O);
        arVarC.d(fu.P);
        arVarC.d(fu.Q);
        arVarC.d(fu.R);
        arVarC.d(fu.S);
        arVarC.d(fu.T);
        arVarC.d(fu.U);
        arVarC.d(fu.V);
        arVarC.d(fu.W);
        arVarC.d(fu.X);
        arVarC.d(fu.Y);
        arVarC.d(fu.Z);
        arVarC.d(fu.aa);
        a = arVarC;
    }

    protected cq(ce ceVar, com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, ev evVar, ev evVar2, int i, List list, eh ehVar, byte[] bArr, jn jnVar, ev evVar3, ev evVar4, com.google.android.libraries.navigation.internal.adg.bu[] buVarArr, byte[] bArr2, int i2, com.google.android.libraries.navigation.internal.oe.as asVar, fd fdVar) {
        this.b = ceVar;
        this.u = sVar;
        this.m = anVar;
        this.c = evVar;
        this.d = evVar2;
        this.e = i;
        this.f = list;
        this.g = ehVar;
        this.i = jnVar;
        this.j = evVar3;
        this.k = evVar4;
        this.r = bArr2;
        this.q = i2;
        this.f65n = asVar;
        this.l = buVarArr;
        this.s = fdVar;
    }

    public static int g(byte[] bArr) throws IOException {
        j(bArr);
        com.google.android.libraries.navigation.internal.rq.e eVarA = com.google.android.libraries.navigation.internal.rq.h.a();
        try {
            try {
                com.google.android.libraries.navigation.internal.rq.k.c(bArr, bArr.length, eVarA);
                byte[] bArrE = eVarA.e();
                int iA = eVarA.a();
                long jR = com.google.android.libraries.navigation.internal.adg.bi.a.f181n;
                try {
                    com.google.android.libraries.navigation.internal.ael.ac acVarL = com.google.android.libraries.navigation.internal.ael.ac.L(bArrE, 0, iA);
                    while (!acVarL.C()) {
                        int iM = acVarL.m();
                        if (iM == 112) {
                            jR = ((com.google.android.libraries.navigation.internal.ael.y) acVarL).r();
                            break;
                        }
                        acVarL.E(iM);
                    }
                    com.google.android.libraries.navigation.internal.rq.h.b(eVarA);
                    j(bArr);
                    return (int) jR;
                } catch (IOException e) {
                    throw new com.google.android.libraries.navigation.internal.ael.cc(e);
                }
            } catch (Throwable th) {
                com.google.android.libraries.navigation.internal.rq.h.b(eVarA);
                j(bArr);
                throw th;
            }
        } catch (com.google.android.libraries.navigation.internal.ael.cc | DataFormatException e2) {
            throw new IOException("parseHeader: Error in decompressing or parsing proto - " + e2.toString(), e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:425:0x0675 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:447:0x068f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:500:? A[Catch: all -> 0x067f, SYNTHETIC, TRY_LEAVE, TryCatch #17 {all -> 0x067f, blocks: (B:343:0x067e, B:342:0x067b, B:123:0x02cf, B:124:0x02d2, B:147:0x034c, B:148:0x034f, B:160:0x0381, B:161:0x0384, B:173:0x03be, B:174:0x03c1, B:190:0x0435, B:191:0x0438, B:199:0x0450, B:200:0x0453, B:206:0x0463, B:207:0x0466, B:209:0x0471, B:210:0x0473, B:211:0x0479, B:213:0x047f, B:214:0x0486, B:216:0x048a, B:217:0x048c, B:219:0x0490, B:220:0x0492, B:222:0x049a, B:224:0x049e, B:225:0x04a0, B:227:0x04a4, B:228:0x04a6, B:230:0x04b4, B:232:0x04b8, B:233:0x04ba, B:235:0x04be, B:236:0x04c0, B:237:0x04ce, B:239:0x04da, B:241:0x04e4, B:243:0x04fd, B:244:0x0500, B:246:0x0514, B:247:0x0517, B:249:0x052c, B:250:0x0532, B:251:0x0537, B:252:0x053a, B:254:0x054b, B:255:0x054d, B:257:0x0562, B:258:0x0565, B:260:0x0582, B:261:0x0585, B:262:0x05a5, B:263:0x05ac, B:264:0x05b4, B:265:0x05c3, B:267:0x05c9, B:269:0x05e0, B:271:0x05f1, B:273:0x05f8, B:272:0x05f4, B:274:0x05fc, B:286:0x0620, B:285:0x061d, B:295:0x062e, B:294:0x062b, B:304:0x063c, B:303:0x0639, B:313:0x064a, B:312:0x0647, B:322:0x0658, B:321:0x0655, B:331:0x0666, B:330:0x0663, B:326:0x065d, B:192:0x0440, B:194:0x0446, B:196:0x044a, B:197:0x044c, B:290:0x0625, B:175:0x03c7, B:177:0x03cd, B:179:0x03d4, B:180:0x03d6, B:181:0x03dc, B:183:0x03e2, B:185:0x03ee, B:186:0x03f0, B:299:0x0633, B:338:0x0675, B:162:0x038a, B:164:0x0390, B:166:0x0394, B:167:0x0396, B:168:0x039c, B:170:0x03a2, B:308:0x0641, B:149:0x0355, B:151:0x035b, B:153:0x035f, B:154:0x0361, B:155:0x0367, B:157:0x036d, B:317:0x064f, B:201:0x0459, B:203:0x045d, B:204:0x045f, B:125:0x02dd, B:127:0x02e5, B:129:0x02e9, B:130:0x02eb, B:131:0x02f1, B:133:0x02f7, B:137:0x030f, B:141:0x031a, B:143:0x033c, B:144:0x033e, B:281:0x0617), top: B:433:0x01cc, inners: #0, #1, #4, #7, #10, #13, #15, #24, #25, #27, #28, #32, #33 }] */
    /* JADX WARN: Code duplicated, block: B:502:? A[Catch: IOException -> 0x06a1, cc | IndexOutOfBoundsException | DataFormatException -> 0x06ff, cc | IndexOutOfBoundsException | DataFormatException -> 0x06ff, cc | IndexOutOfBoundsException | DataFormatException -> 0x06ff, all -> 0x0758, SYNTHETIC, TRY_LEAVE, TryCatch #29 {all -> 0x0758, blocks: (B:276:0x060e, B:360:0x06db, B:357:0x06a1, B:370:0x06ff, B:355:0x0698, B:354:0x0695, B:358:0x06ba), top: B:453:0x0023 }] */
    public static cl i(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, cd cdVar, byte[] bArr, boolean z, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.oe.as asVar, Iterable iterable, boolean z2) throws Throwable {
        Throwable th;
        Throwable th2;
        byte[] bArr2;
        cl clVarC;
        int iA;
        byte[] bArrE;
        int i;
        q qVar;
        com.google.android.libraries.navigation.internal.nw.d dVar;
        Throwable th3;
        Throwable th4;
        ce ceVar;
        byte[] bArr3 = z ? (byte[]) bArr.clone() : bArr;
        com.google.android.libraries.navigation.internal.yt.a aVarC = com.google.android.libraries.navigation.internal.yt.d.c("VectorTile.unpack ", anVar);
        try {
            try {
                com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) bVar.a(com.google.android.libraries.navigation.internal.km.p.u)).a();
                try {
                    try {
                        try {
                            com.google.android.libraries.navigation.internal.rq.e eVarA = com.google.android.libraries.navigation.internal.rq.h.a();
                            try {
                                try {
                                    j(bArr3);
                                    int length = bArr3.length;
                                    if (z) {
                                        com.google.android.libraries.navigation.internal.rq.k.c(bArr3, length, eVarA);
                                        bArrE = eVarA.e();
                                        iA = eVarA.a();
                                    } else {
                                        iA = length;
                                        bArrE = bArr3;
                                    }
                                    co coVar = new co((com.google.android.libraries.navigation.internal.adg.bi) ((dg) com.google.android.libraries.navigation.internal.adg.bi.a.aH(7, null)).j(bArrE, 0, iA, a), null);
                                    com.google.android.libraries.navigation.internal.adg.bi biVar = coVar.a;
                                    String str = "psm";
                                    if (anVar != com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS) {
                                        str = "m";
                                    }
                                    Iterator it2 = biVar.o.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            if (biVar.o.size() <= 0) {
                                                i = -1;
                                                break;
                                            }
                                            i = ((eq) biVar.o.get(0)).c;
                                            break;
                                        }
                                        eq eqVar = (eq) it2.next();
                                        if (str.equals(eqVar.b)) {
                                            i = eqVar.c;
                                            break;
                                        }
                                    }
                                    if (i == -1) {
                                        i = (sVar.b & 8) != 0 ? sVar.f : -1;
                                    }
                                    com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) sVar.aH(5, null);
                                    bbVar.x(sVar);
                                    com.google.android.libraries.navigation.internal.dm.r rVar = (com.google.android.libraries.navigation.internal.dm.r) bbVar;
                                    byte b = (byte) coVar.a.f181n;
                                    if (!rVar.b.H()) {
                                        rVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.dm.s sVar2 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
                                    com.google.android.libraries.navigation.internal.dm.s sVar3 = com.google.android.libraries.navigation.internal.dm.s.a;
                                    sVar2.b |= 128;
                                    sVar2.j = b;
                                    if (i != -1) {
                                        if (!rVar.b.H()) {
                                            rVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.dm.s sVar4 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
                                        sVar4.b |= 8;
                                        sVar4.f = i;
                                    }
                                    if ((sVar.b & 512) == 0) {
                                        com.google.android.libraries.navigation.internal.adg.bi biVar2 = coVar.a;
                                        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.acq.a.a);
                                        biVar2.h(bhVarS);
                                        if (biVar2.w.n(bhVarS.d)) {
                                            com.google.android.libraries.navigation.internal.adg.bi biVar3 = coVar.a;
                                            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.acq.a.a);
                                            biVar3.h(bhVarS2);
                                            Object objK = biVar3.w.k(bhVarS2.d);
                                            String str2 = (String) (objK == null ? bhVarS2.b : bhVarS2.c(objK));
                                            if (!rVar.b.H()) {
                                                rVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.dm.s sVar5 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
                                            str2.getClass();
                                            sVar5.b |= 512;
                                            sVar5.l = str2;
                                        }
                                    }
                                    if ((sVar.b & 256) == 0) {
                                        com.google.android.libraries.navigation.internal.adg.bi biVar4 = coVar.a;
                                        if ((biVar4.b & 4) != 0) {
                                            int i2 = biVar4.e;
                                            if (!rVar.b.H()) {
                                                rVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.dm.s sVar6 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
                                            sVar6.b |= 256;
                                            sVar6.k = i2;
                                        }
                                    }
                                    try {
                                        com.google.android.libraries.navigation.internal.dm.s sVar7 = (com.google.android.libraries.navigation.internal.dm.s) rVar.t();
                                        com.google.android.libraries.navigation.internal.adg.bi biVar5 = coVar.a;
                                        int length2 = bArr3.length;
                                        int iL = l(sVar7, biVar5);
                                        try {
                                            s sVarH = bv.h(biVar5.d, false);
                                            iv ivVar = biVar5.c;
                                            if (ivVar == null) {
                                                ivVar = iv.a;
                                            }
                                            int iA2 = jh.a(ivVar.b);
                                            if (iA2 == 0) {
                                                iA2 = jh.a;
                                            }
                                            int i3 = iA2;
                                            iv ivVar2 = biVar5.c;
                                            if (ivVar2 == null) {
                                                ivVar2 = iv.a;
                                            }
                                            int iA3 = jj.a(ivVar2.c);
                                            if (iA3 == 0) {
                                                iA3 = jj.a;
                                            }
                                            ce ceVar2 = new ce(cdVar, sVarH, iL, i3, iA3);
                                            try {
                                                try {
                                                    com.google.android.libraries.navigation.internal.nw.d dVarC = com.google.android.libraries.navigation.internal.nw.e.c("VectorTile.unpackProto ", anVar);
                                                    try {
                                                        int iL2 = l(sVar7, biVar5);
                                                        com.google.android.libraries.navigation.internal.adg.bu[] buVarArr = (com.google.android.libraries.navigation.internal.adg.bu[]) biVar5.p.toArray(new com.google.android.libraries.navigation.internal.adg.bu[0]);
                                                        byte[] bArrB = bv.d;
                                                        if ((sVar7.b & 2048) != 0) {
                                                            try {
                                                                bArrB = sVar7.f400n.B();
                                                            } catch (Throwable th5) {
                                                                th3 = th5;
                                                                dVar = dVarC;
                                                                if (dVar != null) {
                                                                    throw th3;
                                                                }
                                                                try {
                                                                    Trace.endSection();
                                                                    throw th3;
                                                                } catch (Throwable th6) {
                                                                    th3.addSuppressed(th6);
                                                                    throw th3;
                                                                }
                                                            }
                                                        }
                                                        try {
                                                            cn cnVar = new cn(sVar7, anVar, ceVar2);
                                                            cnVar.k = asVar;
                                                            cnVar.j = length2;
                                                            cnVar.h = buVarArr;
                                                            cnVar.i = bArrB;
                                                            cnVar.d = null;
                                                            com.google.android.libraries.navigation.internal.yx.ar.q(biVar5);
                                                            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - Copyrights");
                                                            try {
                                                                if ((biVar5.b & 262144) != 0) {
                                                                    int i4 = ev.d;
                                                                    com.google.android.libraries.navigation.internal.yz.eq eqVar2 = new com.google.android.libraries.navigation.internal.yz.eq();
                                                                    com.google.android.libraries.navigation.internal.yz.eq eqVar3 = new com.google.android.libraries.navigation.internal.yz.eq();
                                                                    gy gyVar = biVar5.m;
                                                                    if (gyVar == null) {
                                                                        try {
                                                                            gyVar = gy.a;
                                                                        } catch (Throwable th7) {
                                                                            th4 = th7;
                                                                            dVar = dVarC;
                                                                            if (dVarB != null) {
                                                                                throw th4;
                                                                            }
                                                                            try {
                                                                                Trace.endSection();
                                                                                throw th4;
                                                                            } catch (Throwable th8) {
                                                                                th4.addSuppressed(th8);
                                                                                throw th4;
                                                                            }
                                                                        }
                                                                    }
                                                                    Iterator it3 = gyVar.b.iterator();
                                                                    while (it3.hasNext()) {
                                                                        gw gwVar = (gw) it3.next();
                                                                        Iterator it4 = it3;
                                                                        if ((gwVar.b & 2) != 0) {
                                                                            try {
                                                                                com.google.android.libraries.navigation.internal.oe.ad adVarH = ceVar2.d.h(gwVar.d, 2);
                                                                                try {
                                                                                    try {
                                                                                        dVar = dVarC;
                                                                                        try {
                                                                                            eqVar2.h(new r(gwVar.c, new com.google.android.libraries.navigation.internal.oe.ai(com.google.android.libraries.navigation.internal.oe.x.A(adVarH.l(0).b(), adVarH.l(0).d()), com.google.android.libraries.navigation.internal.oe.x.A(adVarH.l(1).b(), adVarH.l(1).d()))));
                                                                                        } catch (Throwable th9) {
                                                                                            th = th9;
                                                                                            th4 = th;
                                                                                            if (dVarB != null) {
                                                                                                throw th4;
                                                                                            }
                                                                                            Trace.endSection();
                                                                                            throw th4;
                                                                                        }
                                                                                    } catch (Throwable th10) {
                                                                                        th = th10;
                                                                                        dVar = dVarC;
                                                                                        th4 = th;
                                                                                        if (dVarB != null) {
                                                                                            throw th4;
                                                                                        }
                                                                                        Trace.endSection();
                                                                                        throw th4;
                                                                                    }
                                                                                } catch (Throwable th11) {
                                                                                    th = th11;
                                                                                }
                                                                            } catch (Throwable th12) {
                                                                                th = th12;
                                                                                dVar = dVarC;
                                                                                th4 = th;
                                                                                if (dVarB != null) {
                                                                                    throw th4;
                                                                                }
                                                                                Trace.endSection();
                                                                                throw th4;
                                                                            }
                                                                        } else {
                                                                            dVar = dVarC;
                                                                            eqVar3.h(gwVar.c);
                                                                        }
                                                                        ceVar2 = ceVar2;
                                                                        it3 = it4;
                                                                        aVarC = aVarC;
                                                                        mVarA = mVarA;
                                                                        eVarA = eVarA;
                                                                        bArr3 = bArr3;
                                                                        dVarC = dVar;
                                                                    }
                                                                    aVarC = aVarC;
                                                                    mVarA = mVarA;
                                                                    eVarA = eVarA;
                                                                    ceVar = ceVar2;
                                                                    dVar = dVarC;
                                                                    cnVar.g = eqVar2.g();
                                                                    cnVar.a = eqVar3.g();
                                                                } else {
                                                                    aVarC = aVarC;
                                                                    mVarA = mVarA;
                                                                    eVarA = eVarA;
                                                                    ceVar = ceVar2;
                                                                    dVar = dVarC;
                                                                }
                                                                if (dVarB != null) {
                                                                    Trace.endSection();
                                                                }
                                                                ArrayList arrayList = new ArrayList();
                                                                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - RasterOps");
                                                                try {
                                                                    if ((biVar5.b & 2048) != 0) {
                                                                        hc hcVar = biVar5.k;
                                                                        if (hcVar == null) {
                                                                            hcVar = hc.a;
                                                                        }
                                                                        for (ha haVar : hcVar.b) {
                                                                            int i5 = ceVar.a.a;
                                                                            az azVar = new az();
                                                                            int i6 = haVar.b;
                                                                            azVar.f((i6 & 4) != 0, haVar.e, (i6 & 2) != 0, haVar.d, es.a);
                                                                            ba baVarE = azVar.e();
                                                                            int i7 = haVar.g ^ Integer.MIN_VALUE;
                                                                            int i8 = haVar.f;
                                                                            byte[] bArrB2 = haVar.c.B();
                                                                            fs fsVar = haVar.h;
                                                                            if (fsVar == null) {
                                                                                fsVar = fs.a;
                                                                            }
                                                                            arrayList.add(new bq(i8, i7, bArrB2, baVarE, i5, fsVar));
                                                                        }
                                                                    }
                                                                    if (dVarB2 != null) {
                                                                        Trace.endSection();
                                                                    }
                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - AreaOps");
                                                                    try {
                                                                        if ((biVar5.b & 128) != 0) {
                                                                            com.google.android.libraries.navigation.internal.adg.as asVar2 = biVar5.h;
                                                                            if (asVar2 == null) {
                                                                                asVar2 = com.google.android.libraries.navigation.internal.adg.as.a;
                                                                            }
                                                                            Iterator it5 = asVar2.b.iterator();
                                                                            while (it5.hasNext()) {
                                                                                arrayList.add(g.d((com.google.android.libraries.navigation.internal.adg.aq) it5.next(), ceVar.d, null, ceVar, false));
                                                                            }
                                                                        }
                                                                        if (dVarB3 != null) {
                                                                            Trace.endSection();
                                                                        }
                                                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - LineOps");
                                                                        try {
                                                                            if ((biVar5.b & 64) != 0) {
                                                                                fi fiVar = biVar5.g;
                                                                                if (fiVar == null) {
                                                                                    fiVar = fi.a;
                                                                                }
                                                                                Iterator it6 = fiVar.b.iterator();
                                                                                while (it6.hasNext()) {
                                                                                    ar.d((fg) it6.next(), ceVar.d, null, ceVar, false, arrayList, com.google.android.libraries.navigation.internal.agg.fd.a);
                                                                                }
                                                                            }
                                                                            if (dVarB4 != null) {
                                                                                Trace.endSection();
                                                                            }
                                                                            com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - PointOps");
                                                                            try {
                                                                                if ((biVar5.b & 32) != 0) {
                                                                                    int[] iArr = new int[2];
                                                                                    gi giVar = biVar5.f;
                                                                                    if (giVar == null) {
                                                                                        giVar = gi.a;
                                                                                    }
                                                                                    for (gg ggVar : giVar.b) {
                                                                                        com.google.android.libraries.navigation.internal.oe.o oVar = ceVar.d;
                                                                                        com.google.android.libraries.navigation.internal.adg.h hVar = ggVar.c;
                                                                                        if (hVar == null) {
                                                                                            hVar = com.google.android.libraries.navigation.internal.adg.h.a;
                                                                                        }
                                                                                        oVar.l(hVar.c, 0, iArr);
                                                                                        int i9 = ceVar.a.a;
                                                                                        arrayList.add(new bf(iArr[0], iArr[1], ay.e(i9, ggVar.d), ay.c(i9, ggVar.e), ggVar.h, ggVar.i ^ Integer.MIN_VALUE, new az().c(ggVar).e(), i9, null, false));
                                                                                    }
                                                                                }
                                                                                if (dVarB5 != null) {
                                                                                    Trace.endSection();
                                                                                }
                                                                                cnVar.b = arrayList;
                                                                                com.google.android.libraries.navigation.internal.nw.d dVarB6 = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - VolumeOps");
                                                                                try {
                                                                                    if ((biVar5.b & 256) != 0) {
                                                                                        jn jnVar = biVar5.i;
                                                                                        if (jnVar == null) {
                                                                                            jnVar = jn.a;
                                                                                        }
                                                                                        cnVar.e = jnVar;
                                                                                    }
                                                                                    if (dVarB6 != null) {
                                                                                        Trace.endSection();
                                                                                    }
                                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB7 = com.google.android.libraries.navigation.internal.nw.e.b("VectorTile.unpackProto - LabelOps");
                                                                                    try {
                                                                                        eh ehVar = biVar5.j;
                                                                                        if (ehVar == null) {
                                                                                            ehVar = eh.a;
                                                                                        }
                                                                                        cnVar.c = ehVar;
                                                                                        if (dVarB7 != null) {
                                                                                            Trace.endSection();
                                                                                        }
                                                                                        int i10 = ev.d;
                                                                                        com.google.android.libraries.navigation.internal.yz.eq eqVar4 = new com.google.android.libraries.navigation.internal.yz.eq();
                                                                                        hm hmVar = biVar5.l;
                                                                                        if (hmVar == null) {
                                                                                            hmVar = hm.a;
                                                                                        }
                                                                                        for (hg hgVar : hmVar.b) {
                                                                                            int i11 = 0;
                                                                                            while (true) {
                                                                                                df dfVar = hgVar.d;
                                                                                                if (dfVar == null) {
                                                                                                    dfVar = df.a;
                                                                                                }
                                                                                                dh dhVar = dfVar.d;
                                                                                                if (dhVar == null) {
                                                                                                    dhVar = dh.a;
                                                                                                }
                                                                                                if (i11 >= dhVar.b.size()) {
                                                                                                    eqVar4.h(hgVar);
                                                                                                    break;
                                                                                                }
                                                                                                df dfVar2 = hgVar.d;
                                                                                                if (dfVar2 == null) {
                                                                                                    dfVar2 = df.a;
                                                                                                }
                                                                                                dh dhVar2 = dfVar2.d;
                                                                                                if (dhVar2 == null) {
                                                                                                    dhVar2 = dh.a;
                                                                                                }
                                                                                                if ((((dp) dhVar2.b.get(i11)).b & 4) != 0) {
                                                                                                    df dfVar3 = hgVar.d;
                                                                                                    if (dfVar3 == null) {
                                                                                                        dfVar3 = df.a;
                                                                                                    }
                                                                                                    dh dhVar3 = dfVar3.d;
                                                                                                    if (dhVar3 == null) {
                                                                                                        dhVar3 = dh.a;
                                                                                                    }
                                                                                                    com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) dhVar3.aH(5, null);
                                                                                                    bbVar2.x(dhVar3);
                                                                                                    com.google.android.libraries.navigation.internal.adg.dg dgVar = (com.google.android.libraries.navigation.internal.adg.dg) bbVar2;
                                                                                                    for (int i12 = 0; i12 < ((dh) dgVar.b).b.size(); i12++) {
                                                                                                        if ((dgVar.c(i12).b & 4) != 0) {
                                                                                                            dp dpVarC = dgVar.c(i12);
                                                                                                            com.google.android.libraries.navigation.internal.ael.bb bbVar3 = (com.google.android.libraries.navigation.internal.ael.bb) dpVarC.aH(5, null);
                                                                                                            bbVar3.x(dpVarC);
                                                                                                            Cdo cdo = (Cdo) bbVar3;
                                                                                                            if (!cdo.b.H()) {
                                                                                                                cdo.v();
                                                                                                            }
                                                                                                            dp dpVar = (dp) cdo.b;
                                                                                                            dpVar.b |= 8;
                                                                                                            dpVar.f = iL2;
                                                                                                            if (!dgVar.b.H()) {
                                                                                                                dgVar.v();
                                                                                                            }
                                                                                                            dh dhVar4 = (dh) dgVar.b;
                                                                                                            dp dpVar2 = (dp) cdo.t();
                                                                                                            dpVar2.getClass();
                                                                                                            com.google.android.libraries.navigation.internal.ael.bz bzVar = dhVar4.b;
                                                                                                            if (!bzVar.c()) {
                                                                                                                dhVar4.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                                                                                            }
                                                                                                            dhVar4.b.set(i12, dpVar2);
                                                                                                        }
                                                                                                    }
                                                                                                    com.google.android.libraries.navigation.internal.ael.bb bbVar4 = (com.google.android.libraries.navigation.internal.ael.bb) hgVar.aH(5, null);
                                                                                                    bbVar4.x(hgVar);
                                                                                                    hf hfVar = (hf) bbVar4;
                                                                                                    df dfVar4 = hgVar.d;
                                                                                                    if (dfVar4 == null) {
                                                                                                        dfVar4 = df.a;
                                                                                                    }
                                                                                                    com.google.android.libraries.navigation.internal.ael.bb bbVar5 = (com.google.android.libraries.navigation.internal.ael.bb) dfVar4.aH(5, null);
                                                                                                    bbVar5.x(dfVar4);
                                                                                                    de deVar = (de) bbVar5;
                                                                                                    if (!deVar.b.H()) {
                                                                                                        deVar.v();
                                                                                                    }
                                                                                                    df dfVar5 = (df) deVar.b;
                                                                                                    dh dhVar5 = (dh) dgVar.t();
                                                                                                    dhVar5.getClass();
                                                                                                    dfVar5.d = dhVar5;
                                                                                                    dfVar5.b |= 2;
                                                                                                    if (!hfVar.b.H()) {
                                                                                                        hfVar.v();
                                                                                                    }
                                                                                                    hg hgVar2 = (hg) hfVar.b;
                                                                                                    df dfVar6 = (df) deVar.t();
                                                                                                    dfVar6.getClass();
                                                                                                    hgVar2.d = dfVar6;
                                                                                                    hgVar2.b |= 2;
                                                                                                    eqVar4.h((hg) hfVar.t());
                                                                                                    break;
                                                                                                }
                                                                                                i11++;
                                                                                            }
                                                                                        }
                                                                                        cnVar.f = eqVar4.g();
                                                                                        ez ezVar = new ez();
                                                                                        Iterator it7 = iterable.iterator();
                                                                                        while (it7.hasNext()) {
                                                                                            com.google.android.libraries.navigation.internal.ael.ap apVar = (com.google.android.libraries.navigation.internal.ael.ap) it7.next();
                                                                                            com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(apVar);
                                                                                            biVar5.h(bhVarS3);
                                                                                            if (biVar5.w.n(bhVarS3.d)) {
                                                                                                com.google.android.libraries.navigation.internal.ael.bh bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(apVar);
                                                                                                biVar5.h(bhVarS4);
                                                                                                Object objK2 = biVar5.w.k(bhVarS4.d);
                                                                                                ezVar.f(apVar, objK2 == null ? bhVarS4.b : bhVarS4.c(objK2));
                                                                                            }
                                                                                        }
                                                                                        cnVar.l = ezVar.c();
                                                                                        clVarC = cl.c(cnVar.a(), ck.SUCCESS);
                                                                                        if (dVar != null) {
                                                                                            Trace.endSection();
                                                                                        }
                                                                                        if (((q) clVarC).a == ck.IO_ERROR) {
                                                                                            com.google.android.libraries.navigation.internal.rq.h.b(eVarA);
                                                                                        } else {
                                                                                            com.google.android.libraries.navigation.internal.rq.h.b(eVarA);
                                                                                        }
                                                                                        mVarA.a();
                                                                                        aVarC.close();
                                                                                        return clVarC;
                                                                                    } catch (Throwable th13) {
                                                                                        if (dVarB7 == null) {
                                                                                            throw th13;
                                                                                        }
                                                                                        try {
                                                                                            Trace.endSection();
                                                                                            throw th13;
                                                                                        } catch (Throwable th14) {
                                                                                            th13.addSuppressed(th14);
                                                                                            throw th13;
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th15) {
                                                                                    if (dVarB6 == null) {
                                                                                        throw th15;
                                                                                    }
                                                                                    try {
                                                                                        Trace.endSection();
                                                                                        throw th15;
                                                                                    } catch (Throwable th16) {
                                                                                        th15.addSuppressed(th16);
                                                                                        throw th15;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th17) {
                                                                                if (dVarB5 == null) {
                                                                                    throw th17;
                                                                                }
                                                                                try {
                                                                                    Trace.endSection();
                                                                                    throw th17;
                                                                                } catch (Throwable th18) {
                                                                                    th17.addSuppressed(th18);
                                                                                    throw th17;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th19) {
                                                                            if (dVarB4 == null) {
                                                                                throw th19;
                                                                            }
                                                                            try {
                                                                                Trace.endSection();
                                                                                throw th19;
                                                                            } catch (Throwable th20) {
                                                                                th19.addSuppressed(th20);
                                                                                throw th19;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th21) {
                                                                        if (dVarB3 == null) {
                                                                            throw th21;
                                                                        }
                                                                        try {
                                                                            Trace.endSection();
                                                                            throw th21;
                                                                        } catch (Throwable th22) {
                                                                            th21.addSuppressed(th22);
                                                                            throw th21;
                                                                        }
                                                                    }
                                                                } catch (Throwable th23) {
                                                                    if (dVarB2 == null) {
                                                                        throw th23;
                                                                    }
                                                                    try {
                                                                        Trace.endSection();
                                                                        throw th23;
                                                                    } catch (Throwable th24) {
                                                                        th23.addSuppressed(th24);
                                                                        throw th23;
                                                                    }
                                                                }
                                                            } catch (Throwable th25) {
                                                                th = th25;
                                                            }
                                                        } catch (Throwable th26) {
                                                            th = th26;
                                                            th3 = th;
                                                            if (dVar != null) {
                                                                throw th3;
                                                            }
                                                            Trace.endSection();
                                                            throw th3;
                                                        }
                                                    } catch (Throwable th27) {
                                                        th = th27;
                                                        dVar = dVarC;
                                                    }
                                                } catch (IOException unused) {
                                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1097)).p("Error unpacking vector tile with styles");
                                                    qVar = new q(ck.IO_ERROR, com.google.android.libraries.navigation.internal.yx.a.a);
                                                    clVarC = qVar;
                                                }
                                            } catch (IOException unused2) {
                                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1097)).p("Error unpacking vector tile with styles");
                                                qVar = new q(ck.IO_ERROR, com.google.android.libraries.navigation.internal.yx.a.a);
                                                clVarC = qVar;
                                            }
                                        } catch (IOException unused3) {
                                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1096)).p("Error unpacking style table entries in tile");
                                            qVar = new q(ck.STYLE_TABLES_UNAVAILABLE, com.google.android.libraries.navigation.internal.yx.a.a);
                                        }
                                    } catch (com.google.android.libraries.navigation.internal.ael.cc | IndexOutOfBoundsException | DataFormatException unused4) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1095)).y("Error parsing proto for tile %s %s %s exception=", cdVar, "type=" + anVar.name(), "data.length=" + bArr2.length);
                                        ((com.google.android.libraries.navigation.internal.kk.j) bVar.a(com.google.android.libraries.navigation.internal.km.p.q)).a();
                                        q qVar2 = new q(ck.PARSE_ERROR, com.google.android.libraries.navigation.internal.yx.a.a);
                                        com.google.android.libraries.navigation.internal.rq.h.b(eVarA);
                                        clVarC = qVar2;
                                    }
                                } catch (Throwable th28) {
                                    th = th28;
                                    com.google.android.libraries.navigation.internal.rq.h.b(eVarA);
                                    throw th;
                                }
                            } catch (com.google.android.libraries.navigation.internal.ael.cc | IndexOutOfBoundsException | DataFormatException unused5) {
                                bArr2 = bArr3;
                                aVarC = aVarC;
                                mVarA = mVarA;
                            }
                        } catch (Throwable th29) {
                            th = th29;
                        }
                    } catch (Throwable th30) {
                        th = th30;
                        th2 = th;
                        try {
                            mVarA.a();
                            throw th2;
                        } catch (Throwable th31) {
                            th2.addSuppressed(th31);
                            throw th2;
                        }
                    }
                } catch (Throwable th32) {
                    th = th32;
                    th2 = th;
                    mVarA.a();
                    throw th2;
                }
            } catch (Throwable th33) {
                th = th33;
                th = th;
                try {
                    aVarC.close();
                    throw th;
                } catch (Throwable th34) {
                    th.addSuppressed(th34);
                    throw th;
                }
            }
        } catch (Throwable th35) {
            th = th35;
            th = th;
            aVarC.close();
            throw th;
        }
    }

    static void j(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 95);
        }
    }

    private static int l(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adg.bi biVar) {
        int i = sVar.k;
        return i != 0 ? i : biVar.e;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final int a() {
        return this.q;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized com.google.android.libraries.navigation.internal.dm.s b() {
        return this.u;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized com.google.android.libraries.navigation.internal.oe.as c() {
        return this.f65n;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final com.google.android.libraries.navigation.internal.adi.an d() {
        return this.m;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized void e(com.google.android.libraries.navigation.internal.dm.s sVar) {
        this.u = sVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized void f(com.google.android.libraries.navigation.internal.oe.as asVar) {
        this.f65n = asVar;
    }

    public final cd h() {
        return this.b.a;
    }

    public final cp k() {
        return new cp(this.f);
    }
}
