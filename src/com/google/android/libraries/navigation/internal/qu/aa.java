package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import com.google.android.libraries.navigation.internal.afm.dc;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class aa implements com.google.android.libraries.navigation.internal.qv.k {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.aa");
    private static final long q = TimeUnit.MINUTES.toMillis(10);
    private static final com.google.android.libraries.navigation.internal.zl.m r = com.google.android.libraries.navigation.internal.zl.aa.a;
    private final Runnable A;
    private long B;
    private final br D;
    private final com.google.android.libraries.navigation.internal.ox.f E;
    public final ch c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final com.google.android.libraries.navigation.internal.adi.an f;
    public volatile int i;
    public final com.google.android.libraries.navigation.internal.qv.f j;
    public final Executor l;
    public final Executor m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.agl.a f561n;
    public final boolean o;
    public final ce p;
    private final com.google.android.libraries.navigation.internal.oe.aw s;
    private final com.google.android.libraries.navigation.internal.qp.w t;
    private final com.google.android.libraries.navigation.internal.oe.ap v;
    private final com.google.android.libraries.geo.mapcore.internal.model.cg w;
    private volatile int x;
    private final com.google.android.libraries.navigation.internal.qv.e y;
    private final com.google.android.libraries.navigation.internal.kl.a z;
    public final Object b = new Object();
    private volatile boolean u = false;
    public final m e = new m();
    public final u g = new u();
    public final w h = new w();
    public volatile long k = 0;
    private final Map C = new EnumMap(com.google.android.libraries.navigation.internal.km.o.class);

    public aa(com.google.android.libraries.navigation.internal.oe.ap apVar, com.google.android.libraries.geo.mapcore.internal.model.cg cgVar, ce ceVar, com.google.android.libraries.navigation.internal.qv.f fVar, com.google.android.libraries.navigation.internal.qv.e eVar, com.google.android.libraries.navigation.internal.qp.w wVar, com.google.android.libraries.navigation.internal.oe.aw awVar, com.google.android.libraries.navigation.internal.kl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.ox.f fVar2, Runnable runnable, com.google.android.libraries.navigation.internal.mj.a aVar3, Executor executor, Executor executor2, int i, br brVar, ch chVar) {
        this.i = -1;
        this.v = apVar;
        com.google.android.libraries.navigation.internal.adi.an anVar = apVar.c;
        this.f = anVar;
        this.w = cgVar;
        this.z = aVar;
        this.f561n = aVar2;
        this.E = fVar2;
        this.A = runnable;
        this.d = aVar3;
        this.l = executor;
        this.m = executor2;
        this.p = ceVar;
        this.s = awVar;
        this.c = chVar;
        this.j = fVar;
        this.y = eVar;
        this.t = wVar;
        this.i = i;
        this.D = brVar;
        com.google.android.libraries.navigation.internal.om.p pVar = (com.google.android.libraries.navigation.internal.om.p) aVar2.a();
        this.x = f(anVar, fVar2 == null ? pVar.f() : fVar2.a());
        this.o = ((com.google.android.libraries.navigation.internal.om.d) pVar.b()).a;
    }

    private final void B(final bq bqVar) {
        this.l.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.q
            /* JADX WARN: Code duplicated, block: B:100:0x01e3 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:140:0x0296 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:142:0x02a1  */
            /* JADX WARN: Code duplicated, block: B:143:0x02a3  */
            /* JADX WARN: Code duplicated, block: B:145:0x02a6  */
            /* JADX WARN: Code duplicated, block: B:146:0x02a8  */
            /* JADX WARN: Code duplicated, block: B:154:0x02be A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:155:0x02c0 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:156:0x02c5  */
            /* JADX WARN: Code duplicated, block: B:158:0x02c8 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:159:0x02ca A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:160:0x02cd A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:162:0x02d7 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:163:0x02d9 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:165:0x02df A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:166:0x02e2 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:171:0x02ee  */
            /* JADX WARN: Code duplicated, block: B:174:0x02f3 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:177:0x02ff A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:181:0x031f  */
            /* JADX WARN: Code duplicated, block: B:184:0x0324 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:186:0x033b A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:190:0x0354 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:192:0x0372 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:193:0x0382 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:198:0x038f A[Catch: all -> 0x03b3, TryCatch #9 {all -> 0x03b3, blocks: (B:196:0x038b, B:198:0x038f, B:200:0x0397, B:203:0x03a2, B:205:0x03a7, B:204:0x03a5, B:211:0x03b2), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:200:0x0397 A[Catch: all -> 0x03b3, TryCatch #9 {all -> 0x03b3, blocks: (B:196:0x038b, B:198:0x038f, B:200:0x0397, B:203:0x03a2, B:205:0x03a7, B:204:0x03a5, B:211:0x03b2), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:204:0x03a5 A[Catch: all -> 0x03b3, TryCatch #9 {all -> 0x03b3, blocks: (B:196:0x038b, B:198:0x038f, B:200:0x0397, B:203:0x03a2, B:205:0x03a7, B:204:0x03a5, B:211:0x03b2), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:235:0x03fd A[Catch: all -> 0x04e3, TryCatch #1 {all -> 0x04e3, blocks: (B:179:0x030a, B:233:0x03f6, B:235:0x03fd, B:237:0x0401, B:239:0x0405, B:224:0x03c4, B:223:0x03c1, B:206:0x03aa, B:232:0x03f3, B:311:0x04e2, B:310:0x04df, B:306:0x04d9, B:219:0x03bb), top: B:342:0x006f, inners: #19, #21 }] */
            /* JADX WARN: Code duplicated, block: B:241:0x0409 A[Catch: all -> 0x04fc, TRY_ENTER, TryCatch #18 {all -> 0x04fc, blocks: (B:241:0x0409, B:242:0x040c, B:244:0x0418, B:246:0x041e, B:248:0x042b, B:249:0x0432, B:275:0x04a0, B:276:0x04a3, B:290:0x04bf, B:291:0x04c2, B:288:0x04bc, B:287:0x04b9, B:300:0x04d2, B:299:0x04cf, B:326:0x04f8, B:323:0x04f4, B:322:0x04f1, B:295:0x04c9, B:318:0x04eb, B:278:0x04ab, B:283:0x04b3, B:254:0x045f, B:256:0x0467, B:258:0x0472, B:260:0x0478, B:269:0x048d, B:273:0x049b), top: B:369:0x0013, inners: #4, #6, #7, #14, #17 }] */
            /* JADX WARN: Code duplicated, block: B:244:0x0418 A[Catch: all -> 0x04fc, TryCatch #18 {all -> 0x04fc, blocks: (B:241:0x0409, B:242:0x040c, B:244:0x0418, B:246:0x041e, B:248:0x042b, B:249:0x0432, B:275:0x04a0, B:276:0x04a3, B:290:0x04bf, B:291:0x04c2, B:288:0x04bc, B:287:0x04b9, B:300:0x04d2, B:299:0x04cf, B:326:0x04f8, B:323:0x04f4, B:322:0x04f1, B:295:0x04c9, B:318:0x04eb, B:278:0x04ab, B:283:0x04b3, B:254:0x045f, B:256:0x0467, B:258:0x0472, B:260:0x0478, B:269:0x048d, B:273:0x049b), top: B:369:0x0013, inners: #4, #6, #7, #14, #17 }] */
            /* JADX WARN: Code duplicated, block: B:251:0x045a A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:252:0x045c  */
            /* JADX WARN: Code duplicated, block: B:253:0x045e  */
            /* JADX WARN: Code duplicated, block: B:256:0x0467 A[Catch: all -> 0x047b, TryCatch #17 {all -> 0x047b, blocks: (B:254:0x045f, B:256:0x0467, B:258:0x0472, B:260:0x0478, B:269:0x048d, B:273:0x049b), top: B:367:0x045f, outer: #18 }] */
            /* JADX WARN: Code duplicated, block: B:263:0x0483 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:264:0x0485  */
            /* JADX WARN: Code duplicated, block: B:265:0x0487  */
            /* JADX WARN: Code duplicated, block: B:267:0x048a  */
            /* JADX WARN: Code duplicated, block: B:268:0x048c  */
            /* JADX WARN: Code duplicated, block: B:271:0x0498  */
            /* JADX WARN: Code duplicated, block: B:272:0x049a  */
            /* JADX WARN: Code duplicated, block: B:275:0x04a0 A[Catch: all -> 0x04fc, TRY_ENTER, TryCatch #18 {all -> 0x04fc, blocks: (B:241:0x0409, B:242:0x040c, B:244:0x0418, B:246:0x041e, B:248:0x042b, B:249:0x0432, B:275:0x04a0, B:276:0x04a3, B:290:0x04bf, B:291:0x04c2, B:288:0x04bc, B:287:0x04b9, B:300:0x04d2, B:299:0x04cf, B:326:0x04f8, B:323:0x04f4, B:322:0x04f1, B:295:0x04c9, B:318:0x04eb, B:278:0x04ab, B:283:0x04b3, B:254:0x045f, B:256:0x0467, B:258:0x0472, B:260:0x0478, B:269:0x048d, B:273:0x049b), top: B:369:0x0013, inners: #4, #6, #7, #14, #17 }] */
            /* JADX WARN: Code duplicated, block: B:290:0x04bf A[Catch: all -> 0x04fc, TryCatch #18 {all -> 0x04fc, blocks: (B:241:0x0409, B:242:0x040c, B:244:0x0418, B:246:0x041e, B:248:0x042b, B:249:0x0432, B:275:0x04a0, B:276:0x04a3, B:290:0x04bf, B:291:0x04c2, B:288:0x04bc, B:287:0x04b9, B:300:0x04d2, B:299:0x04cf, B:326:0x04f8, B:323:0x04f4, B:322:0x04f1, B:295:0x04c9, B:318:0x04eb, B:278:0x04ab, B:283:0x04b3, B:254:0x045f, B:256:0x0467, B:258:0x0472, B:260:0x0478, B:269:0x048d, B:273:0x049b), top: B:369:0x0013, inners: #4, #6, #7, #14, #17 }] */
            /* JADX WARN: Code duplicated, block: B:349:0x04eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:351:0x04ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:382:? A[Catch: all -> 0x04fc, SYNTHETIC, TryCatch #18 {all -> 0x04fc, blocks: (B:241:0x0409, B:242:0x040c, B:244:0x0418, B:246:0x041e, B:248:0x042b, B:249:0x0432, B:275:0x04a0, B:276:0x04a3, B:290:0x04bf, B:291:0x04c2, B:288:0x04bc, B:287:0x04b9, B:300:0x04d2, B:299:0x04cf, B:326:0x04f8, B:323:0x04f4, B:322:0x04f1, B:295:0x04c9, B:318:0x04eb, B:278:0x04ab, B:283:0x04b3, B:254:0x045f, B:256:0x0467, B:258:0x0472, B:260:0x0478, B:269:0x048d, B:273:0x049b), top: B:369:0x0013, inners: #4, #6, #7, #14, #17 }] */
            /* JADX WARN: Code duplicated, block: B:93:0x01ce A[ADDED_TO_REGION] */
            /* JADX WARN: Code duplicated, block: B:94:0x01cf A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            /* JADX WARN: Code duplicated, block: B:99:0x01e0 A[Catch: all -> 0x03b5, TryCatch #11 {all -> 0x03b5, blocks: (B:103:0x0205, B:105:0x0209, B:106:0x020e, B:108:0x0211, B:110:0x0215, B:112:0x021d, B:113:0x022a, B:115:0x022d, B:117:0x0233, B:125:0x0250, B:127:0x0268, B:129:0x026d, B:130:0x0277, B:128:0x026b, B:120:0x023e, B:122:0x0247, B:132:0x027b, B:133:0x0280, B:140:0x0296, B:147:0x02a9, B:149:0x02ad, B:153:0x02b5, B:159:0x02ca, B:161:0x02cf, B:174:0x02f3, B:175:0x02f6, B:177:0x02ff, B:178:0x0309, B:182:0x0320, B:184:0x0324, B:186:0x033b, B:187:0x0345, B:188:0x0352, B:190:0x0354, B:192:0x0372, B:194:0x0385, B:195:0x038a, B:193:0x0382, B:160:0x02cd, B:163:0x02d9, B:165:0x02df, B:168:0x02e6, B:166:0x02e2, B:155:0x02c0, B:135:0x0283, B:137:0x0289, B:138:0x0293, B:102:0x01fa, B:94:0x01cf, B:97:0x01d7, B:99:0x01e0, B:101:0x01e5, B:100:0x01e3, B:78:0x019d, B:81:0x01a8, B:83:0x01ae, B:86:0x01bb, B:210:0x03b1), top: B:355:0x0148 }] */
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                Throwable th;
                Throwable th2;
                boolean z;
                com.google.android.libraries.navigation.internal.qv.h hVar;
                com.google.android.libraries.navigation.internal.qv.h hVar2;
                com.google.android.libraries.geo.mapcore.internal.model.cc ccVar;
                bq bqVar2;
                com.google.android.libraries.navigation.internal.nw.d dVarB;
                boolean z2;
                boolean z3;
                com.google.android.libraries.geo.mapcore.internal.model.cc ccVar2;
                com.google.android.libraries.navigation.internal.nw.d dVarB2;
                com.google.android.libraries.navigation.internal.yt.a aVarA;
                Throwable th3;
                com.google.android.libraries.navigation.internal.dm.s sVar;
                boolean z4;
                boolean z5;
                com.google.android.libraries.navigation.internal.km.x xVar;
                z zVar;
                com.google.android.libraries.navigation.internal.qv.d dVar;
                com.google.android.libraries.navigation.internal.qv.d dVar2;
                boolean z6;
                com.google.android.libraries.navigation.internal.qv.d dVar3;
                com.google.android.libraries.navigation.internal.qv.d dVar4;
                com.google.android.libraries.navigation.internal.dm.s sVar2;
                com.google.android.libraries.geo.mapcore.internal.model.cc ccVarB;
                int i;
                boolean zJ;
                v vVar;
                com.google.android.libraries.geo.mapcore.internal.model.cc ccVar3;
                com.google.android.libraries.geo.mapcore.internal.model.cc ccVar4;
                com.google.android.libraries.geo.mapcore.internal.model.cc ccVar5;
                com.google.android.libraries.navigation.internal.km.o oVar;
                bq bqVar3 = bqVar;
                com.google.android.libraries.navigation.internal.adi.an anVar = ((l) bqVar3).a;
                aa aaVar = this.a;
                com.google.android.libraries.navigation.internal.yt.a aVarC = com.google.android.libraries.navigation.internal.yt.d.c("DashServerTileStore.addTileRequest ", anVar);
                try {
                    try {
                        synchronized (aaVar.b) {
                            try {
                                if (((l) bqVar3).a != aaVar.f) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) aa.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1132)).p("Tile type mismatch");
                                }
                                if (((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) aaVar.f561n.a()).e()).e) {
                                    com.google.android.libraries.navigation.internal.gp.b bVar = ((l) bqVar3).j;
                                    com.google.android.libraries.navigation.internal.adi.an anVar2 = ((l) bqVar3).a;
                                    com.google.android.libraries.navigation.internal.adf.i iVar = bVar.a;
                                    if (!iVar.b.H()) {
                                        iVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adf.j jVar = (com.google.android.libraries.navigation.internal.adf.j) iVar.b;
                                    com.google.android.libraries.navigation.internal.adf.j jVar2 = com.google.android.libraries.navigation.internal.adf.j.a;
                                    jVar.f = anVar2.ah;
                                    jVar.b |= 8;
                                }
                                w wVar = aaVar.h;
                                aaVar.g.a();
                                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.doLocalRequest 1");
                                try {
                                    try {
                                        u uVar = aaVar.g;
                                        com.google.android.libraries.navigation.internal.yt.a aVarA2 = com.google.android.libraries.navigation.internal.yt.d.a("Tile lookup from in-memory Cache");
                                        try {
                                            com.google.android.libraries.geo.mapcore.internal.model.cc ccVarC = aaVar.c(aaVar.p.b, ((l) bqVar3).b, bqVar3);
                                            try {
                                                try {
                                                    if (ccVarC == null) {
                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.v, bqVar3);
                                                        aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                    } else {
                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.w, bqVar3);
                                                        com.google.android.libraries.navigation.internal.dm.s sVarB = ccVarC.b();
                                                        if (!com.google.android.libraries.geo.mapcore.internal.model.ch.b(sVarB, aaVar.d)) {
                                                            if (aaVar.p.b.j(ccVarC) || aaVar.u(ccVarC)) {
                                                                aVarC = aVarC;
                                                                z = false;
                                                                try {
                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.A, bqVar3);
                                                                    uVar.a = true;
                                                                    uVar.b = com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST;
                                                                    if (aaVar.u(ccVarC)) {
                                                                        uVar.d = aaVar.m(ccVarC, bqVar3);
                                                                        if (uVar.d == null) {
                                                                            aaVar.n(com.google.android.libraries.navigation.internal.km.p.x, bqVar3);
                                                                        }
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    th = th4;
                                                                    th2 = th;
                                                                    try {
                                                                        aVarA2.close();
                                                                        throw th2;
                                                                    } catch (Throwable th5) {
                                                                        th2.addSuppressed(th5);
                                                                        throw th2;
                                                                    }
                                                                }
                                                            } else {
                                                                if (!bqVar3.m()) {
                                                                    uVar.d = aaVar.m(ccVarC, bqVar3);
                                                                    uVar.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                                    uVar.c = ccVarC;
                                                                    uVar.a = true;
                                                                    if (uVar.d == null) {
                                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.x, bqVar3);
                                                                    }
                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.E, bqVar3);
                                                                } else if (!bqVar3.m()) {
                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.v, bqVar3);
                                                                    aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                                } else if (com.google.android.libraries.geo.mapcore.internal.model.ch.d(sVarB, aaVar.d)) {
                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.y, bqVar3);
                                                                    aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.c);
                                                                } else {
                                                                    uVar.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                                    uVar.a = true;
                                                                    uVar.c = ccVarC;
                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.F, bqVar3);
                                                                }
                                                                aVarC = aVarC;
                                                                z = false;
                                                            }
                                                            aaVar.z(bqVar3, com.google.android.libraries.navigation.internal.adf.f.b);
                                                            aaVar.s(bqVar3, com.google.android.libraries.navigation.internal.km.o.MEMORY);
                                                            aVarA2.close();
                                                            if (((l) bqVar3).e && !uVar.a && uVar.d == null) {
                                                                uVar.d = bqVar3;
                                                            }
                                                            if (dVarB3 != null) {
                                                                Trace.endSection();
                                                            }
                                                            hVar = aaVar.g.b;
                                                            if (hVar.equals(com.google.android.libraries.navigation.internal.qv.h.NOT_FOUND_LOCALLY) && aaVar.g.d != null && !aaVar.c.c(((l) bqVar3).b)) {
                                                                hVar = com.google.android.libraries.navigation.internal.qv.h.NETWORK_ERROR;
                                                                aaVar.g.d = null;
                                                            }
                                                            u uVar2 = aaVar.g;
                                                            com.google.android.libraries.geo.mapcore.internal.model.cc ccVar6 = uVar2.c;
                                                            bq bqVar4 = uVar2.d;
                                                            wVar.a = ccVar6;
                                                            wVar.b = hVar;
                                                            wVar.c = bqVar4;
                                                            uVar2.a();
                                                            w wVar2 = aaVar.h;
                                                            hVar2 = wVar2.b;
                                                            ccVar = wVar2.a;
                                                            bqVar2 = wVar2.c;
                                                            wVar2.a = null;
                                                            wVar2.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                            wVar2.c = null;
                                                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.addTileRequest.notifyTile");
                                                            if (ccVar != null) {
                                                                if (dVarB != null) {
                                                                    z2 = z;
                                                                } else {
                                                                    z2 = true;
                                                                }
                                                                try {
                                                                    if (hVar2.equals(com.google.android.libraries.navigation.internal.qv.h.OK) && bq.l(((l) bqVar3).d) && !aaVar.v(ccVar)) {
                                                                        hVar2 = com.google.android.libraries.navigation.internal.qv.h.NOT_OFFLINEABLE;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    if (true == z2) {
                                                                        throw th6;
                                                                    }
                                                                    try {
                                                                        Trace.endSection();
                                                                        throw th6;
                                                                    } catch (Throwable th7) {
                                                                        th6.addSuppressed(th7);
                                                                        throw th6;
                                                                    }
                                                                }
                                                            } else if (dVarB != null) {
                                                                z2 = z;
                                                            } else {
                                                                z2 = true;
                                                            }
                                                            if (bqVar2 != null) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = z;
                                                            }
                                                            com.google.android.libraries.navigation.internal.qv.h hVarA = com.google.android.libraries.navigation.internal.qv.h.a(hVar2, z3);
                                                            if (true != bqVar3.m()) {
                                                                ccVar2 = ccVar;
                                                            } else {
                                                                ccVar2 = null;
                                                            }
                                                            aaVar.r(bqVar3, hVarA, ccVar2);
                                                            if (true != z2) {
                                                                Trace.endSection();
                                                            }
                                                            dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.addTileRequest.addServerRequest");
                                                            if (bqVar2 != null) {
                                                                try {
                                                                    aaVar.d(bqVar2);
                                                                } catch (Throwable th8) {
                                                                    if (dVarB2 == null) {
                                                                        throw th8;
                                                                    }
                                                                    try {
                                                                        Trace.endSection();
                                                                        throw th8;
                                                                    } catch (Throwable th9) {
                                                                        th8.addSuppressed(th9);
                                                                        throw th8;
                                                                    }
                                                                }
                                                            }
                                                            if (dVarB2 != null) {
                                                                Trace.endSection();
                                                            }
                                                            aVarC.close();
                                                            return;
                                                        }
                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.G, bqVar3);
                                                        aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.c);
                                                    }
                                                    com.google.android.libraries.geo.mapcore.internal.model.cd cdVar = ((l) bqVar3).b;
                                                    ce ceVar = aaVar.p;
                                                    com.google.android.libraries.navigation.internal.qv.d dVar5 = ceVar.c;
                                                    com.google.android.libraries.navigation.internal.qv.d dVar6 = ceVar.d;
                                                    if (dVar5 == null && dVar6 == null) {
                                                        try {
                                                            aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                            aVarC = aVarC;
                                                        } catch (Throwable th10) {
                                                            th3 = th10;
                                                            aVarA.close();
                                                            throw th3;
                                                        }
                                                    } else {
                                                        try {
                                                            try {
                                                                synchronized (aaVar.b) {
                                                                    try {
                                                                        ce ceVar2 = aaVar.p;
                                                                        com.google.android.libraries.navigation.internal.qv.d dVar7 = ceVar2.c;
                                                                        com.google.android.libraries.navigation.internal.qv.d dVar8 = ceVar2.d;
                                                                        com.google.android.libraries.navigation.internal.dm.s sVarA = dVar7 != null ? dVar7.a(cdVar) : null;
                                                                        com.google.android.libraries.navigation.internal.dm.s sVarA2 = dVar8 != null ? dVar8.a(cdVar) : null;
                                                                        y yVar = new y(sVarA2);
                                                                        if (sVarA == null && sVarA2 == null) {
                                                                            bqVar3.m();
                                                                            aaVar.n(bqVar3.m() ? com.google.android.libraries.navigation.internal.km.p.D : com.google.android.libraries.navigation.internal.km.p.z, bqVar3);
                                                                            zVar = new z(false, null, yVar, false, false);
                                                                            aVarC = aVarC;
                                                                        } else {
                                                                            if (sVarA2 != null) {
                                                                                if (sVarA == null) {
                                                                                    aVarC = aVarC;
                                                                                    z4 = true;
                                                                                    sVar = sVarA2;
                                                                                } else {
                                                                                    long j = sVarA2.m;
                                                                                    aVarC = aVarC;
                                                                                    if (j <= sVarA.m) {
                                                                                        if ((sVarA.b & 8192) != 0) {
                                                                                            if (j == sVarA.p) {
                                                                                                sVar = sVarA;
                                                                                                z4 = false;
                                                                                                z5 = true;
                                                                                            }
                                                                                            if (sVarA == null && (sVarA.b & 8192) != 0 && sVarA2 == null) {
                                                                                                bqVar3.m();
                                                                                                if (bqVar3.m()) {
                                                                                                    xVar = com.google.android.libraries.navigation.internal.km.p.D;
                                                                                                } else {
                                                                                                    xVar = com.google.android.libraries.navigation.internal.km.p.z;
                                                                                                }
                                                                                                aaVar.n(xVar, bqVar3);
                                                                                                zVar = new z(false, null, yVar, false, false);
                                                                                            } else {
                                                                                                zVar = new z(true, sVar, yVar, z4, z5);
                                                                                            }
                                                                                        } else if (com.google.android.libraries.geo.mapcore.internal.model.ch.b(sVarA, aaVar.d)) {
                                                                                        }
                                                                                    }
                                                                                    sVar = sVarA2;
                                                                                    z4 = true;
                                                                                }
                                                                                z5 = false;
                                                                                if (sVarA == null) {
                                                                                    bqVar3.m();
                                                                                    if (bqVar3.m()) {
                                                                                        xVar = com.google.android.libraries.navigation.internal.km.p.D;
                                                                                    } else {
                                                                                        xVar = com.google.android.libraries.navigation.internal.km.p.z;
                                                                                    }
                                                                                    aaVar.n(xVar, bqVar3);
                                                                                    zVar = new z(false, null, yVar, false, false);
                                                                                }
                                                                                zVar = new z(true, sVar, yVar, z4, z5);
                                                                            } else {
                                                                                aVarC = aVarC;
                                                                            }
                                                                            sVar = sVarA;
                                                                            z4 = false;
                                                                            z5 = false;
                                                                            if (sVarA == null) {
                                                                                bqVar3.m();
                                                                                if (bqVar3.m()) {
                                                                                    xVar = com.google.android.libraries.navigation.internal.km.p.D;
                                                                                } else {
                                                                                    xVar = com.google.android.libraries.navigation.internal.km.p.z;
                                                                                }
                                                                                aaVar.n(xVar, bqVar3);
                                                                                zVar = new z(false, null, yVar, false, false);
                                                                            }
                                                                            zVar = new z(true, sVar, yVar, z4, z5);
                                                                        }
                                                                        if (zVar.a) {
                                                                            com.google.android.libraries.navigation.internal.dm.s sVar3 = zVar.b;
                                                                            if (sVar3 != null) {
                                                                                if (com.google.android.libraries.geo.mapcore.internal.model.ch.b(sVar3, aaVar.d)) {
                                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.k.c, bqVar3);
                                                                                    bqVar3.m();
                                                                                    aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.c);
                                                                                } else if (bqVar3.m()) {
                                                                                    y yVar2 = zVar.e;
                                                                                    if (com.google.android.libraries.geo.mapcore.internal.model.ch.d(sVar3, aaVar.d)) {
                                                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.y, bqVar3);
                                                                                        com.google.android.libraries.navigation.internal.dm.s sVar4 = yVar2.a;
                                                                                        if (sVar4 != null) {
                                                                                            if (com.google.android.libraries.geo.mapcore.internal.model.ch.d(sVar4, aaVar.d)) {
                                                                                            }
                                                                                        }
                                                                                        aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.c);
                                                                                    }
                                                                                    uVar.b = com.google.android.libraries.geo.mapcore.internal.model.ch.e(sVar3.j, ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) aaVar.f561n.a()).e()).a) ? com.google.android.libraries.navigation.internal.qv.h.OK : com.google.android.libraries.navigation.internal.qv.h.NOT_OFFLINEABLE;
                                                                                    uVar.a = true;
                                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.I, bqVar3);
                                                                                    z = false;
                                                                                    ccVar5 = uVar.c;
                                                                                    if (ccVar5 != null) {
                                                                                        if (ccVar5.c() != com.google.android.libraries.navigation.internal.oe.as.OFFLINE || uVar.c.c() == com.google.android.libraries.navigation.internal.oe.as.OFFLINE_UPDATED_FROM_NETWORK_DATA_UNCHANGED) {
                                                                                            oVar = com.google.android.libraries.navigation.internal.km.o.OFFROAD;
                                                                                        } else {
                                                                                            oVar = com.google.android.libraries.navigation.internal.km.o.SQLITE;
                                                                                        }
                                                                                        aaVar.s(bqVar3, oVar);
                                                                                    }
                                                                                    aVarA.close();
                                                                                } else {
                                                                                    ce ceVar3 = aaVar.p;
                                                                                    dVar = ceVar3.c;
                                                                                    dVar2 = ceVar3.d;
                                                                                    z6 = zVar.c;
                                                                                    if (true != z6) {
                                                                                        dVar3 = dVar2;
                                                                                    } else {
                                                                                        dVar3 = dVar;
                                                                                    }
                                                                                    if (true != z6) {
                                                                                        dVar4 = dVar;
                                                                                    } else {
                                                                                        dVar4 = dVar2;
                                                                                    }
                                                                                    sVar2 = zVar.b;
                                                                                    if (sVar2 == null && zVar.d && dVar != null && dVar2 != null) {
                                                                                        com.google.android.libraries.navigation.internal.yx.ar.q(sVar2);
                                                                                        ccVarB = aaVar.l(cdVar, dVar2, sVar2, false);
                                                                                    } else if (dVar4 != null) {
                                                                                        ccVarB = dVar4.b(cdVar);
                                                                                    } else {
                                                                                        ccVarB = null;
                                                                                    }
                                                                                    if (ccVarB != null) {
                                                                                        if (z6) {
                                                                                            i = com.google.android.libraries.navigation.internal.adf.f.d;
                                                                                        } else {
                                                                                            i = com.google.android.libraries.navigation.internal.adf.f.c;
                                                                                        }
                                                                                        com.google.android.libraries.navigation.internal.yx.ar.q(dVar4);
                                                                                        zJ = dVar4.j(ccVarB);
                                                                                    } else {
                                                                                        if (dVar3 != null) {
                                                                                            ccVarB = dVar3.b(cdVar);
                                                                                            if (z6) {
                                                                                                i = com.google.android.libraries.navigation.internal.adf.f.c;
                                                                                            } else {
                                                                                                i = com.google.android.libraries.navigation.internal.adf.f.d;
                                                                                            }
                                                                                            if (ccVarB == null && dVar3.j(ccVarB)) {
                                                                                                zJ = true;
                                                                                            }
                                                                                        } else {
                                                                                            ccVarB = null;
                                                                                            i = 0;
                                                                                        }
                                                                                        zJ = false;
                                                                                    }
                                                                                    if (i != 0) {
                                                                                        aaVar.z(bqVar3, i);
                                                                                    }
                                                                                    vVar = new v(ccVarB, zJ);
                                                                                    ccVar3 = vVar.a;
                                                                                    if (ccVar3 == null) {
                                                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.z, bqVar3);
                                                                                        aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                                                    } else {
                                                                                        z = false;
                                                                                        if (vVar.b) {
                                                                                            aaVar.q(bqVar3, ccVar3.b());
                                                                                            uVar.b = com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST;
                                                                                            uVar.d = aaVar.m(vVar.a, bqVar3);
                                                                                            if (uVar.d == null) {
                                                                                                aaVar.n(com.google.android.libraries.navigation.internal.km.p.B, bqVar3);
                                                                                                aaVar.p(com.google.android.libraries.navigation.internal.km.p.C, bqVar3);
                                                                                            }
                                                                                            uVar.a = true;
                                                                                            vVar.a.b();
                                                                                            aaVar.n(com.google.android.libraries.navigation.internal.km.p.A, bqVar3);
                                                                                        } else {
                                                                                            aaVar.p.b.e(cdVar, ccVar3);
                                                                                            uVar.d = aaVar.m(vVar.a, bqVar3);
                                                                                            uVar.a = true;
                                                                                            uVar.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                                                            ccVar4 = vVar.a;
                                                                                            uVar.c = ccVar4;
                                                                                            if (uVar.d == null) {
                                                                                                aaVar.n(com.google.android.libraries.navigation.internal.km.p.B, bqVar3);
                                                                                                aaVar.p(com.google.android.libraries.navigation.internal.km.p.C, bqVar3);
                                                                                                vVar.a.b();
                                                                                            } else {
                                                                                                ccVar4.b();
                                                                                            }
                                                                                            aaVar.n(com.google.android.libraries.navigation.internal.km.p.H, bqVar3);
                                                                                        }
                                                                                        ccVar5 = uVar.c;
                                                                                        if (ccVar5 != null) {
                                                                                            if (ccVar5.c() != com.google.android.libraries.navigation.internal.oe.as.OFFLINE) {
                                                                                                oVar = com.google.android.libraries.navigation.internal.km.o.OFFROAD;
                                                                                            } else {
                                                                                                oVar = com.google.android.libraries.navigation.internal.km.o.OFFROAD;
                                                                                            }
                                                                                            aaVar.s(bqVar3, oVar);
                                                                                        }
                                                                                        aVarA.close();
                                                                                    }
                                                                                }
                                                                            } else if (bqVar3.m()) {
                                                                                aaVar.n(com.google.android.libraries.navigation.internal.km.p.D, bqVar3);
                                                                                aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                                            } else {
                                                                                ce ceVar4 = aaVar.p;
                                                                                dVar = ceVar4.c;
                                                                                dVar2 = ceVar4.d;
                                                                                z6 = zVar.c;
                                                                                if (true != z6) {
                                                                                    dVar3 = dVar2;
                                                                                } else {
                                                                                    dVar3 = dVar;
                                                                                }
                                                                                if (true != z6) {
                                                                                    dVar4 = dVar;
                                                                                } else {
                                                                                    dVar4 = dVar2;
                                                                                }
                                                                                sVar2 = zVar.b;
                                                                                if (sVar2 == null) {
                                                                                    if (dVar4 != null) {
                                                                                        ccVarB = dVar4.b(cdVar);
                                                                                    } else {
                                                                                        ccVarB = null;
                                                                                    }
                                                                                } else if (dVar4 != null) {
                                                                                    ccVarB = dVar4.b(cdVar);
                                                                                } else {
                                                                                    ccVarB = null;
                                                                                }
                                                                                if (ccVarB != null) {
                                                                                    if (z6) {
                                                                                        i = com.google.android.libraries.navigation.internal.adf.f.d;
                                                                                    } else {
                                                                                        i = com.google.android.libraries.navigation.internal.adf.f.c;
                                                                                    }
                                                                                    com.google.android.libraries.navigation.internal.yx.ar.q(dVar4);
                                                                                    zJ = dVar4.j(ccVarB);
                                                                                } else {
                                                                                    if (dVar3 != null) {
                                                                                        ccVarB = dVar3.b(cdVar);
                                                                                        if (z6) {
                                                                                            i = com.google.android.libraries.navigation.internal.adf.f.c;
                                                                                        } else {
                                                                                            i = com.google.android.libraries.navigation.internal.adf.f.d;
                                                                                        }
                                                                                        if (ccVarB == null) {
                                                                                        }
                                                                                    } else {
                                                                                        ccVarB = null;
                                                                                        i = 0;
                                                                                    }
                                                                                    zJ = false;
                                                                                }
                                                                                if (i != 0) {
                                                                                    aaVar.z(bqVar3, i);
                                                                                }
                                                                                vVar = new v(ccVarB, zJ);
                                                                                ccVar3 = vVar.a;
                                                                                if (ccVar3 == null) {
                                                                                    aaVar.n(com.google.android.libraries.navigation.internal.km.p.z, bqVar3);
                                                                                    aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                                                } else {
                                                                                    z = false;
                                                                                    if (vVar.b) {
                                                                                        aaVar.q(bqVar3, ccVar3.b());
                                                                                        uVar.b = com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST;
                                                                                        uVar.d = aaVar.m(vVar.a, bqVar3);
                                                                                        if (uVar.d == null) {
                                                                                            aaVar.n(com.google.android.libraries.navigation.internal.km.p.B, bqVar3);
                                                                                            aaVar.p(com.google.android.libraries.navigation.internal.km.p.C, bqVar3);
                                                                                        }
                                                                                        uVar.a = true;
                                                                                        vVar.a.b();
                                                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.A, bqVar3);
                                                                                    } else {
                                                                                        aaVar.p.b.e(cdVar, ccVar3);
                                                                                        uVar.d = aaVar.m(vVar.a, bqVar3);
                                                                                        uVar.a = true;
                                                                                        uVar.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                                                        ccVar4 = vVar.a;
                                                                                        uVar.c = ccVar4;
                                                                                        if (uVar.d == null) {
                                                                                            aaVar.n(com.google.android.libraries.navigation.internal.km.p.B, bqVar3);
                                                                                            aaVar.p(com.google.android.libraries.navigation.internal.km.p.C, bqVar3);
                                                                                            vVar.a.b();
                                                                                        } else {
                                                                                            ccVar4.b();
                                                                                        }
                                                                                        aaVar.n(com.google.android.libraries.navigation.internal.km.p.H, bqVar3);
                                                                                    }
                                                                                    ccVar5 = uVar.c;
                                                                                    if (ccVar5 != null) {
                                                                                        if (ccVar5.c() != com.google.android.libraries.navigation.internal.oe.as.OFFLINE) {
                                                                                            oVar = com.google.android.libraries.navigation.internal.km.o.OFFROAD;
                                                                                        } else {
                                                                                            oVar = com.google.android.libraries.navigation.internal.km.o.OFFROAD;
                                                                                        }
                                                                                        aaVar.s(bqVar3, oVar);
                                                                                    }
                                                                                    aVarA.close();
                                                                                }
                                                                            }
                                                                            if (((l) bqVar3).e) {
                                                                                uVar.d = bqVar3;
                                                                            }
                                                                            if (dVarB3 != null) {
                                                                                Trace.endSection();
                                                                            }
                                                                            hVar = aaVar.g.b;
                                                                            if (hVar.equals(com.google.android.libraries.navigation.internal.qv.h.NOT_FOUND_LOCALLY)) {
                                                                                hVar = com.google.android.libraries.navigation.internal.qv.h.NETWORK_ERROR;
                                                                                aaVar.g.d = null;
                                                                            }
                                                                            u uVar3 = aaVar.g;
                                                                            com.google.android.libraries.geo.mapcore.internal.model.cc ccVar7 = uVar3.c;
                                                                            bq bqVar5 = uVar3.d;
                                                                            wVar.a = ccVar7;
                                                                            wVar.b = hVar;
                                                                            wVar.c = bqVar5;
                                                                            uVar3.a();
                                                                            w wVar3 = aaVar.h;
                                                                            hVar2 = wVar3.b;
                                                                            ccVar = wVar3.a;
                                                                            bqVar2 = wVar3.c;
                                                                            wVar3.a = null;
                                                                            wVar3.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                                            wVar3.c = null;
                                                                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.addTileRequest.notifyTile");
                                                                            if (ccVar != null) {
                                                                                if (dVarB != null) {
                                                                                    z2 = z;
                                                                                } else {
                                                                                    z2 = true;
                                                                                }
                                                                                if (hVar2.equals(com.google.android.libraries.navigation.internal.qv.h.OK)) {
                                                                                    hVar2 = com.google.android.libraries.navigation.internal.qv.h.NOT_OFFLINEABLE;
                                                                                }
                                                                            } else if (dVarB != null) {
                                                                                z2 = z;
                                                                            } else {
                                                                                z2 = true;
                                                                            }
                                                                            if (bqVar2 != null) {
                                                                                z3 = true;
                                                                            } else {
                                                                                z3 = z;
                                                                            }
                                                                            com.google.android.libraries.navigation.internal.qv.h hVarA2 = com.google.android.libraries.navigation.internal.qv.h.a(hVar2, z3);
                                                                            if (true != bqVar3.m()) {
                                                                                ccVar2 = ccVar;
                                                                            } else {
                                                                                ccVar2 = null;
                                                                            }
                                                                            aaVar.r(bqVar3, hVarA2, ccVar2);
                                                                            if (true != z2) {
                                                                                Trace.endSection();
                                                                            }
                                                                            dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.addTileRequest.addServerRequest");
                                                                            if (bqVar2 != null) {
                                                                                aaVar.d(bqVar2);
                                                                            }
                                                                            if (dVarB2 != null) {
                                                                                Trace.endSection();
                                                                            }
                                                                            aVarC.close();
                                                                            return;
                                                                        }
                                                                        aaVar.A(bqVar3, com.google.android.libraries.navigation.internal.adf.h.i);
                                                                    } catch (Throwable th11) {
                                                                        th = th11;
                                                                        throw th;
                                                                    }
                                                                }
                                                            } catch (Throwable th12) {
                                                                th = th12;
                                                                th3 = th;
                                                                try {
                                                                    aVarA.close();
                                                                    throw th3;
                                                                } catch (Throwable th13) {
                                                                    th3.addSuppressed(th13);
                                                                    throw th3;
                                                                }
                                                            }
                                                        } catch (Throwable th14) {
                                                            th = th14;
                                                        }
                                                    }
                                                    aVarA.close();
                                                    aaVar.z(bqVar3, com.google.android.libraries.navigation.internal.adf.f.e);
                                                    aaVar.s(bqVar3, com.google.android.libraries.navigation.internal.km.o.NOT_CACHED);
                                                    z = false;
                                                    uVar.a = false;
                                                    uVar.d = null;
                                                    if (((l) bqVar3).e) {
                                                        uVar.d = bqVar3;
                                                    }
                                                    if (dVarB3 != null) {
                                                        Trace.endSection();
                                                    }
                                                    hVar = aaVar.g.b;
                                                    if (hVar.equals(com.google.android.libraries.navigation.internal.qv.h.NOT_FOUND_LOCALLY)) {
                                                        hVar = com.google.android.libraries.navigation.internal.qv.h.NETWORK_ERROR;
                                                        aaVar.g.d = null;
                                                    }
                                                    u uVar4 = aaVar.g;
                                                    com.google.android.libraries.geo.mapcore.internal.model.cc ccVar8 = uVar4.c;
                                                    bq bqVar6 = uVar4.d;
                                                    wVar.a = ccVar8;
                                                    wVar.b = hVar;
                                                    wVar.c = bqVar6;
                                                    uVar4.a();
                                                    w wVar4 = aaVar.h;
                                                    hVar2 = wVar4.b;
                                                    ccVar = wVar4.a;
                                                    bqVar2 = wVar4.c;
                                                    wVar4.a = null;
                                                    wVar4.b = com.google.android.libraries.navigation.internal.qv.h.OK;
                                                    wVar4.c = null;
                                                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.addTileRequest.notifyTile");
                                                    if (ccVar != null) {
                                                        if (dVarB != null) {
                                                            z2 = z;
                                                        } else {
                                                            z2 = true;
                                                        }
                                                        if (hVar2.equals(com.google.android.libraries.navigation.internal.qv.h.OK)) {
                                                            hVar2 = com.google.android.libraries.navigation.internal.qv.h.NOT_OFFLINEABLE;
                                                        }
                                                    } else if (dVarB != null) {
                                                        z2 = z;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                    if (bqVar2 != null) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = z;
                                                    }
                                                    com.google.android.libraries.navigation.internal.qv.h hVarA3 = com.google.android.libraries.navigation.internal.qv.h.a(hVar2, z3);
                                                    if (true != bqVar3.m()) {
                                                        ccVar2 = ccVar;
                                                    } else {
                                                        ccVar2 = null;
                                                    }
                                                    aaVar.r(bqVar3, hVarA3, ccVar2);
                                                    if (true != z2) {
                                                        Trace.endSection();
                                                    }
                                                    dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.addTileRequest.addServerRequest");
                                                    if (bqVar2 != null) {
                                                        aaVar.d(bqVar2);
                                                    }
                                                    if (dVarB2 != null) {
                                                        Trace.endSection();
                                                    }
                                                    aVarC.close();
                                                    return;
                                                } catch (Throwable th15) {
                                                    th = th15;
                                                }
                                                aVarA2.close();
                                                aVarA = com.google.android.libraries.navigation.internal.yt.d.a("Tile lookup from on-disk Cache");
                                            } catch (Throwable th16) {
                                                th2 = th16;
                                                aVarC = aVarC;
                                                aVarA2.close();
                                                throw th2;
                                            }
                                        } catch (Throwable th17) {
                                            th = th17;
                                            aVarC = aVarC;
                                        }
                                    } catch (Throwable th18) {
                                        th = th18;
                                        th = th;
                                        if (dVarB3 != null) {
                                            throw th;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th;
                                        } catch (Throwable th19) {
                                            th.addSuppressed(th19);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th20) {
                                    th = th20;
                                    aVarC = aVarC;
                                    th = th;
                                    if (dVarB3 != null) {
                                        throw th;
                                    }
                                    Trace.endSection();
                                    throw th;
                                }
                            } catch (Throwable th21) {
                                th = th21;
                                aVarC = aVarC;
                            }
                        }
                    } catch (Throwable th22) {
                        th = th22;
                    }
                    try {
                        throw th;
                    } catch (Throwable th23) {
                        th = th23;
                        Throwable th24 = th;
                        try {
                            aVarC.close();
                            throw th24;
                        } catch (Throwable th25) {
                            th24.addSuppressed(th25);
                            throw th24;
                        }
                    }
                } catch (Throwable th26) {
                    th = th26;
                    aVarC = aVarC;
                }
            }
        });
    }

    private static final bq C(bq bqVar, String str, boolean z) {
        l lVar = (l) bqVar;
        return new l(lVar.a, lVar.b, lVar.c, dc.NORMAL, true, true, true, str, z, lVar.j);
    }

    private static int f(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.adi.af afVar) {
        com.google.android.libraries.navigation.internal.adi.ar arVar = afVar.c;
        if (arVar == null) {
            arVar = com.google.android.libraries.navigation.internal.adi.ar.a;
        }
        com.google.android.libraries.navigation.internal.ael.bq bqVar = null;
        for (com.google.android.libraries.navigation.internal.adi.al alVar : arVar.c) {
            com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
            if (anVarB == null) {
                anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
            }
            if (anVarB == anVar) {
                com.google.android.libraries.navigation.internal.adi.aj ajVar = alVar.d;
                if (ajVar == null) {
                    ajVar = com.google.android.libraries.navigation.internal.adi.aj.a;
                }
                bqVar = ajVar.j;
            }
        }
        if (bqVar != null) {
            return j(bqVar);
        }
        return 0;
    }

    public static int j(List list) {
        if (list.isEmpty()) {
            return 0;
        }
        int[] iArrF = com.google.android.libraries.navigation.internal.zy.i.f(list);
        Arrays.sort(iArrF);
        com.google.android.libraries.navigation.internal.zl.n nVarE = r.e();
        for (int i : iArrF) {
            nVarE.c(i);
        }
        return nVarE.o().a();
    }

    public static byte[] x(bq bqVar, com.google.android.libraries.navigation.internal.qp.ac acVar) {
        com.google.android.libraries.navigation.internal.adi.an anVar = ((l) bqVar).a;
        return (anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE || anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN || anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK) ? acVar.a(anVar) : acVar.a.d.B();
    }

    public final void A(bq bqVar, int i) {
        if (((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.f561n.a()).e()).e) {
            com.google.android.libraries.navigation.internal.gp.b bVar = ((l) bqVar).j;
            if (i == com.google.android.libraries.navigation.internal.adf.h.i) {
                int iA = com.google.android.libraries.navigation.internal.adf.h.a(((com.google.android.libraries.navigation.internal.adf.j) bVar.a.t()).d);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.adf.h.a;
                }
                if (iA != com.google.android.libraries.navigation.internal.adf.h.a) {
                    return;
                }
            }
            com.google.android.libraries.navigation.internal.adf.i iVar = bVar.a;
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.adf.j jVar = (com.google.android.libraries.navigation.internal.adf.j) iVar.b;
            com.google.android.libraries.navigation.internal.adf.j jVar2 = com.google.android.libraries.navigation.internal.adf.j.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            jVar.d = i2;
            jVar.b |= 2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final com.google.android.libraries.geo.mapcore.internal.model.cg D() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final com.google.android.libraries.navigation.internal.adi.an E() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void F() {
        this.m.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.o
            @Override // java.lang.Runnable
            public final void run() {
                final aa aaVar = this.a;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DashServerTileStore.clearCacheInternal");
                try {
                    synchronized (aaVar.b) {
                        try {
                            aaVar.p.b.t();
                            aaVar.m.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.p
                                @Override // java.lang.Runnable
                                public final void run() {
                                    aaVar.e.a();
                                }
                            });
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } catch (Throwable th2) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return null;
    }

    protected com.google.android.libraries.geo.mapcore.internal.model.cc b(bq bqVar, com.google.android.libraries.navigation.internal.qp.ac acVar, com.google.android.libraries.navigation.internal.gz.a aVar) throws IOException {
        com.google.android.libraries.navigation.internal.adi.an anVar;
        if ((acVar.a.b & 32) == 0) {
            return null;
        }
        int iJ = j(acVar.d);
        com.google.android.libraries.navigation.internal.dm.r rVar = (com.google.android.libraries.navigation.internal.dm.r) com.google.android.libraries.navigation.internal.dm.s.a.q();
        l lVar = (l) bqVar;
        y(rVar, lVar.b, acVar, aVar, iJ);
        com.google.android.libraries.navigation.internal.dm.s sVar = (com.google.android.libraries.navigation.internal.dm.s) rVar.t();
        byte[] bArrA = (lVar.a == com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE || (anVar = lVar.a) == com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN || anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK) ? acVar.a(lVar.a) : acVar.a.d.B();
        com.google.android.libraries.geo.mapcore.internal.model.q qVar = (com.google.android.libraries.geo.mapcore.internal.model.q) this.j.a(sVar, this.f, lVar.b, bArrA, lVar.g ? com.google.android.libraries.navigation.internal.oe.as.UPDATED_FROM_NETWORK : com.google.android.libraries.navigation.internal.oe.as.NETWORK);
        if (qVar.a == ck.IO_ERROR) {
            throw new IOException(String.format("Error unpacking network tile result for tile type %s and coords %s", this.f.name(), lVar.b));
        }
        if (qVar.a != ck.SUCCESS) {
            throw new x(String.format("Error unpacking network tile result for tile type %s and coords %s: %s", this.f.name(), lVar.b, qVar.a));
        }
        com.google.android.libraries.geo.mapcore.internal.model.cc ccVar = (com.google.android.libraries.geo.mapcore.internal.model.cc) qVar.b.f();
        if (!bqVar.m() && ccVar != null) {
            this.p.b.e(lVar.b, ccVar);
        }
        s(bqVar, lVar.g ? com.google.android.libraries.navigation.internal.km.o.NETWORK_UPDATE : com.google.android.libraries.navigation.internal.km.o.NETWORK);
        if (ccVar != null) {
            int i = ccVar.b().j;
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar2 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar2.b |= 128;
            sVar2.j = i;
            if ((sVar.b & 8) == 0 || sVar.f == -1) {
                int i2 = ccVar.b().f;
                if (!rVar.b.H()) {
                    rVar.v();
                }
                com.google.android.libraries.navigation.internal.dm.s sVar3 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
                sVar3.b |= 8;
                sVar3.f = i2;
            }
            sVar = (com.google.android.libraries.navigation.internal.dm.s) rVar.t();
        }
        com.google.android.libraries.navigation.internal.qv.d dVar = this.p.c;
        if (dVar != null && dVar.k()) {
            dVar.o(sVar, bArrA, aVar);
        }
        if (bqVar.m()) {
            return null;
        }
        return ccVar;
    }

    protected com.google.android.libraries.geo.mapcore.internal.model.cc c(com.google.android.libraries.navigation.internal.qv.g gVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, bq bqVar) {
        com.google.android.libraries.geo.mapcore.internal.model.cc ccVarB = gVar.b(cdVar);
        if (ccVarB == null) {
            return null;
        }
        if (gVar.j(ccVarB)) {
            return ccVarB;
        }
        com.google.android.libraries.navigation.internal.dm.o oVar = ccVarB.b().c;
        if (oVar == null) {
            oVar = com.google.android.libraries.navigation.internal.dm.o.a;
        }
        if (!oVar.h.isEmpty()) {
            com.google.android.libraries.navigation.internal.dm.o oVar2 = ccVarB.b().c;
            if (oVar2 == null) {
                oVar2 = com.google.android.libraries.navigation.internal.dm.o.a;
            }
            if (!oVar2.d.isEmpty()) {
                com.google.android.libraries.navigation.internal.dm.o oVar3 = ccVarB.b().c;
                if (oVar3 == null) {
                    oVar3 = com.google.android.libraries.navigation.internal.dm.o.a;
                }
                if (oVar3.h.equals(this.D.a())) {
                    com.google.android.libraries.navigation.internal.dm.o oVar4 = ccVarB.b().c;
                    if (oVar4 == null) {
                        oVar4 = com.google.android.libraries.navigation.internal.dm.o.a;
                    }
                    if (oVar4.d.equals(Locale.getDefault().toLanguageTag())) {
                        return ccVarB;
                    }
                }
                com.google.android.libraries.navigation.internal.dm.o oVar5 = ccVarB.b().c;
                if (oVar5 == null) {
                    oVar5 = com.google.android.libraries.navigation.internal.dm.o.a;
                }
                if (!oVar5.h.isEmpty()) {
                    com.google.android.libraries.navigation.internal.dm.o oVar6 = ccVarB.b().c;
                    if (oVar6 == null) {
                        oVar6 = com.google.android.libraries.navigation.internal.dm.o.a;
                    }
                    if (!oVar6.d.isEmpty()) {
                        com.google.android.libraries.navigation.internal.dm.o oVar7 = ccVarB.b().c;
                        if (oVar7 == null) {
                            oVar7 = com.google.android.libraries.navigation.internal.dm.o.a;
                        }
                        if (!oVar7.h.equals(this.D.a())) {
                            A(bqVar, com.google.android.libraries.navigation.internal.adf.h.d);
                        }
                        com.google.android.libraries.navigation.internal.dm.o oVar8 = ccVarB.b().c;
                        if (oVar8 == null) {
                            oVar8 = com.google.android.libraries.navigation.internal.dm.o.a;
                        }
                        if (!oVar8.d.equals(Locale.getDefault().toLanguageTag())) {
                            A(bqVar, com.google.android.libraries.navigation.internal.adf.h.e);
                        }
                    }
                }
                return null;
            }
        }
        return ccVarB;
    }

    protected void d(bq bqVar) {
        if (!t()) {
            this.f.name();
        }
        t tVar = new t(this, bqVar);
        l lVar = (l) bqVar;
        com.google.android.libraries.navigation.internal.adi.an anVar = lVar.a;
        com.google.android.libraries.geo.mapcore.internal.model.cd cdVar = lVar.b;
        String str = lVar.h;
        boolean z = lVar.i;
        com.google.android.libraries.navigation.internal.gp.b bVar = lVar.j;
        com.google.android.libraries.navigation.internal.gd.h hVar = bqVar.m() ? com.google.android.libraries.navigation.internal.gd.h.TIME_DEFERRABLE : null;
        if (hVar == null) {
            hVar = com.google.android.libraries.navigation.internal.gd.h.UNSPECIFIED;
        }
        final com.google.android.libraries.navigation.internal.qp.c cVar = new com.google.android.libraries.navigation.internal.qp.c(anVar, cdVar, str, z, tVar, bVar, hVar);
        final com.google.android.libraries.navigation.internal.qp.w wVar = this.t;
        wVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qp.t
            @Override // java.lang.Runnable
            public final void run() {
                wVar.c(cVar);
            }
        });
    }

    protected void e(bq bqVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.o)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.B > q) {
                this.B = jCurrentTimeMillis;
                this.A.run();
                return;
            }
            return;
        }
        ce ceVar = this.p;
        ceVar.b.f(bqVar.b());
        if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.h) || oVar.equals(com.google.android.libraries.navigation.internal.gg.o.m)) {
            this.c.b(bqVar.b());
        } else {
            this.c.a(bqVar.b());
        }
        r(bqVar, com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST, null);
        if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.m)) {
            n(com.google.android.libraries.navigation.internal.km.p.ad, bqVar);
        } else if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.h)) {
            n(com.google.android.libraries.navigation.internal.km.p.ae, bqVar);
        } else if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.j)) {
            n(com.google.android.libraries.navigation.internal.km.p.af, bqVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public void g(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, com.google.android.libraries.navigation.internal.adf.j jVar) {
        com.google.android.libraries.navigation.internal.gp.b bVar = new com.google.android.libraries.navigation.internal.gp.b();
        if (((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.f561n.a()).e()).e) {
            bVar.a.x(jVar);
        }
        B(new l(this.f, cdVar, iVar, dc.NORMAL, true, true, false, "", true, bVar));
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public void h(float f) {
        this.p.b.t();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void i(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, boolean z) {
        com.google.android.libraries.navigation.internal.gp.b bVar = new com.google.android.libraries.navigation.internal.gp.b();
        B(new l(this.f, cdVar, iVar, dc.NORMAL, false, z, false, "", true, bVar));
    }

    @Override // com.google.android.libraries.navigation.internal.qv.k
    public final void k(com.google.android.libraries.navigation.internal.qd.u uVar) {
        this.e.b(uVar);
    }

    public final com.google.android.libraries.geo.mapcore.internal.model.cc l(com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.d dVar, com.google.android.libraries.navigation.internal.dm.s sVar, boolean z) {
        byte[] bArrM = dVar.m(cdVar);
        if (bArrM == null) {
            return null;
        }
        com.google.android.libraries.navigation.internal.oe.as asVar = (z && dVar.k()) ? com.google.android.libraries.navigation.internal.oe.as.UPDATED_FROM_NETWORK_DATA_UNCHANGED : com.google.android.libraries.navigation.internal.oe.as.OFFLINE_UPDATED_FROM_NETWORK_DATA_UNCHANGED;
        if (bArrM.length == 0) {
            return new com.google.android.libraries.geo.mapcore.internal.model.t(sVar, this.f, cdVar, asVar);
        }
        com.google.android.libraries.navigation.internal.qv.e eVar = this.y;
        if (eVar == null) {
            return null;
        }
        cl clVarA = eVar.a(sVar, this.f, cdVar, bArrM, dVar.l(), asVar);
        com.google.android.libraries.navigation.internal.ox.d.a(this.z, this.f.ah, clVarA);
        com.google.android.libraries.geo.mapcore.internal.model.q qVar = (com.google.android.libraries.geo.mapcore.internal.model.q) clVarA;
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(qVar.a == ck.SUCCESS ? Level.FINE : Level.WARNING).F(1129)).y("unpackTileWithGivenMetadata tile unpack result: coords=%s, paintTileType=%s - %s", cdVar, this.f.name(), qVar.a);
        return (com.google.android.libraries.geo.mapcore.internal.model.cc) qVar.b.f();
    }

    public final bq m(com.google.android.libraries.geo.mapcore.internal.model.cc ccVar, bq bqVar) {
        if (!((l) bqVar).f || !t() || ccVar.d() == com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH) {
            return null;
        }
        if (!ccVar.b().o && this.i != 0 && this.i != ccVar.b().k) {
            n(com.google.android.libraries.navigation.internal.km.p.K, bqVar);
            A(bqVar, com.google.android.libraries.navigation.internal.adf.h.f);
            return C(bqVar, ccVar.b().l, true);
        }
        boolean z = ccVar.b().o;
        if (bqVar.m()) {
            return null;
        }
        if (com.google.android.libraries.geo.mapcore.internal.model.ch.d(ccVar.b(), this.d)) {
            n(com.google.android.libraries.navigation.internal.km.p.J, bqVar);
            A(bqVar, com.google.android.libraries.navigation.internal.adf.h.b);
            return C(bqVar, ccVar.b().l, true);
        }
        if (ccVar.b().o || ccVar.b().e == this.x) {
            return null;
        }
        n(com.google.android.libraries.navigation.internal.km.p.L, bqVar);
        A(bqVar, com.google.android.libraries.navigation.internal.adf.h.g);
        return C(bqVar, ccVar.b().l, false);
    }

    protected final void n(com.google.android.libraries.navigation.internal.km.x xVar, bq bqVar) {
        ((com.google.android.libraries.navigation.internal.kk.k) this.z.a(xVar)).a(bqVar.d().ah);
    }

    public final void o(com.google.android.libraries.navigation.internal.km.y yVar, bq bqVar, long j) {
        ((com.google.android.libraries.navigation.internal.kk.l) this.z.a(yVar)).b(((l) bqVar).a.ah, j);
    }

    protected final void p(com.google.android.libraries.navigation.internal.km.x xVar, bq bqVar) {
        l lVar = (l) bqVar;
        if (lVar.a == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.z.a(xVar)).a(lVar.b.a);
        }
    }

    public final void q(bq bqVar, com.google.android.libraries.navigation.internal.dm.s sVar) {
        l lVar = (l) bqVar;
        com.google.android.libraries.geo.mapcore.internal.model.t tVar = new com.google.android.libraries.geo.mapcore.internal.model.t(sVar, lVar.a, lVar.b, com.google.android.libraries.navigation.internal.oe.as.UNKNOWN);
        this.p.b.e(lVar.b, tVar);
    }

    public final void r(final bq bqVar, final com.google.android.libraries.navigation.internal.qv.h hVar, final com.google.android.libraries.geo.mapcore.internal.model.cc ccVar) {
        if (bqVar.c() == null) {
            return;
        }
        this.l.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.n
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.zb.j jVar = aa.a;
                bq bqVar2 = bqVar;
                com.google.android.libraries.navigation.internal.qv.i iVarC = bqVar2.c();
                if (iVarC != null) {
                    com.google.android.libraries.geo.mapcore.internal.model.cc ccVar2 = ccVar;
                    iVarC.a(bqVar2.b(), hVar, ccVar2);
                }
            }
        });
    }

    public final void s(bq bqVar, com.google.android.libraries.navigation.internal.km.o oVar) {
        if (((l) bqVar).a == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.z.a(com.google.android.libraries.navigation.internal.km.p.ar)).a(oVar.g);
        }
        if (!this.C.containsKey(oVar)) {
            this.C.put(oVar, 1);
        } else {
            Map map = this.C;
            map.put(oVar, Integer.valueOf(((Integer) map.get(oVar)).intValue() + 1));
        }
    }

    public final boolean t() {
        return this.i > 0 || !this.s.f(this.f);
    }

    public final boolean u(com.google.android.libraries.geo.mapcore.internal.model.cc ccVar) {
        return (ccVar instanceof com.google.android.libraries.geo.mapcore.internal.model.t) && !this.p.b.j(ccVar);
    }

    public final boolean v(com.google.android.libraries.geo.mapcore.internal.model.cc ccVar) {
        return com.google.android.libraries.geo.mapcore.internal.model.ch.e(ccVar.b().j, ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.f561n.a()).e()).a);
    }

    public final synchronized boolean w() {
        com.google.android.libraries.navigation.internal.ox.f fVar = this.E;
        int iF = f(this.f, fVar == null ? ((com.google.android.libraries.navigation.internal.om.p) this.f561n.a()).f() : fVar.a());
        if (iF == this.x) {
            return false;
        }
        this.x = iF;
        return true;
    }

    public final void y(com.google.android.libraries.navigation.internal.dm.r rVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qp.ac acVar, com.google.android.libraries.navigation.internal.gz.a aVar, int i) {
        com.google.android.libraries.navigation.internal.dm.o oVarA = com.google.android.libraries.geo.mapcore.internal.model.ch.a(this.v, this.w, cdVar, acVar.b, acVar.c);
        if (!rVar.b.H()) {
            rVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.s sVar = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
        com.google.android.libraries.navigation.internal.dm.s sVar2 = com.google.android.libraries.navigation.internal.dm.s.a;
        oVarA.getClass();
        sVar.c = oVarA;
        sVar.b |= 1;
        int i2 = acVar.a.e;
        if (i2 != 0) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar3 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar3.b |= 256;
            sVar3.k = i2;
        } else {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar4 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar4.b &= -257;
            sVar4.k = 0;
        }
        long jD = this.s.d(this.f, aVar);
        if (jD != -1) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar5 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar5.b |= 64;
            sVar5.i = jD;
        } else {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar6 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar6.b &= -65;
            sVar6.i = 0L;
        }
        long jB = this.s.b(this.f, aVar);
        if (jB != -1) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar7 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar7.b |= 32;
            sVar7.h = jB;
        } else {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar8 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar8.b &= -33;
            sVar8.h = 0L;
        }
        com.google.android.libraries.navigation.internal.adi.av avVar = acVar.a;
        if ((avVar.b & 1024) != 0) {
            String str = avVar.h;
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar9 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            str.getClass();
            sVar9.b |= 512;
            sVar9.l = str;
        } else {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar10 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar10.b &= -513;
            sVar10.l = com.google.android.libraries.navigation.internal.dm.s.a.l;
        }
        if (i != 0) {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar11 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar11.b |= 4;
            sVar11.e = i;
        } else {
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar12 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            sVar12.b &= -5;
            sVar12.e = 0;
        }
        if (!rVar.b.H()) {
            rVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.s sVar13 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
        sVar13.b &= -9;
        sVar13.f = 0;
        if (!rVar.b.H()) {
            rVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.s sVar14 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
        sVar14.b &= -17;
        sVar14.g = 0;
        com.google.android.libraries.navigation.internal.adi.av avVar2 = acVar.a;
        if ((avVar2.b & 512) != 0) {
            com.google.android.libraries.navigation.internal.ael.x xVar = avVar2.g;
            if (!rVar.b.H()) {
                rVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.s sVar15 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
            xVar.getClass();
            sVar15.b |= 2048;
            sVar15.f400n = xVar;
        }
    }

    public final void z(bq bqVar, int i) {
        if (((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.f561n.a()).e()).e) {
            com.google.android.libraries.navigation.internal.adf.i iVar = ((l) bqVar).j.a;
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.adf.j jVar = (com.google.android.libraries.navigation.internal.adf.j) iVar.b;
            com.google.android.libraries.navigation.internal.adf.j jVar2 = com.google.android.libraries.navigation.internal.adf.j.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            jVar.e = i2;
            jVar.b |= 4;
        }
    }
}
