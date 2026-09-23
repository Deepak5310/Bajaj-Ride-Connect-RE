package com.google.android.libraries.navigation.internal.p002do;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.libraries.navigation.internal.db.aa;
import com.google.android.libraries.navigation.internal.db.ak;
import com.google.android.libraries.navigation.internal.db.m;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.dt.f;
import com.google.android.libraries.navigation.internal.ni.a;
import com.google.android.libraries.navigation.internal.oe.b;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oe.y;
import com.google.android.libraries.navigation.internal.oq.d;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zb.an;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements l {
    public final n a;
    public final o b;
    private final a c;
    private final com.google.android.libraries.navigation.internal.nt.p d;
    private final t e;
    private int f = 0;
    private final m g;

    public p(a aVar, boolean z, com.google.android.libraries.navigation.internal.nt.p pVar) {
        ar.q(aVar);
        this.c = aVar;
        this.a = new n();
        this.b = new o(aVar);
        this.d = null;
        this.e = new w(false);
        this.g = new m();
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void a(boolean z) {
        n nVar = this.a;
        if (nVar.a == z) {
            return;
        }
        nVar.a = z;
        if (nVar.b == null) {
            nVar.b = new a();
        }
        if (nVar.a) {
            return;
        }
        nVar.b.b();
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final synchronized void b(f fVar) {
        a aVar;
        t tVar = this.e;
        v vVar = ((w) tVar).a;
        fVar.d(vVar.a, vVar.c, 0, ((w) tVar).f());
        v vVar2 = ((w) tVar).a;
        fVar.e = Math.abs(vVar2.d) + Math.abs(vVar2.e) > 1.0f;
        fVar.d = vVar2.f;
        fVar.f = this.f;
        m mVar = this.g;
        if (mVar.a) {
            fVar.b = mVar.b.a;
            fVar.d = 0.0f;
        }
        o oVar = this.b;
        boolean z = fVar.c;
        float f = true != z ? 0.8f : 1.0f;
        float f2 = oVar.b;
        fVar.m = f * com.google.android.libraries.navigation.internal.nq.a.a(com.google.android.libraries.navigation.internal.nq.a.a(0.4f, 0.65f, 12.0f, 16.0f, f2), com.google.android.libraries.navigation.internal.nq.a.a(0.5f, 1.0f, 12.0f, 16.0f, f2), 0.0f, 55.0f, oVar.c);
        if (z) {
            fVar.f413n = 1.0f;
        } else {
            fVar.f413n = (float) ((Math.abs(Math.sin(((oVar.a.a() % 2500) * 6.283185307179586d) / 2500.0d)) * 0.15d) + 0.925d);
        }
        fVar.o = 1.0f;
        n nVar = this.a;
        if (!nVar.a || (aVar = nVar.b) == null) {
            return;
        }
        aVar.a(fVar, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final synchronized void c() {
        t tVar = this.e;
        ((w) tVar).c = false;
        ((w) tVar).q = null;
        ((w) tVar).r = null;
        ((w) tVar).s = null;
        ((w) tVar).j = null;
        ((w) tVar).l = null;
        ((w) tVar).h = -4611686018427387904L;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a aVar = this.a.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void d(boolean z) {
        this.g.a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final /* synthetic */ void e() {
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final /* synthetic */ void f() {
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final /* synthetic */ void g() {
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final /* synthetic */ void h() {
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void i(d dVar) {
        float fC = dVar.a().c();
        o oVar = this.b;
        oVar.b = fC;
        oVar.c = dVar.a().b();
        this.a.c = dVar.a().c();
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void j(float f) {
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final synchronized boolean k(long j) {
        boolean z;
        m mVar = this.g;
        if (mVar.a) {
            mVar.b.b(j);
        }
        t tVar = this.e;
        z = false;
        if (((w) tVar).c && ((w) tVar).t) {
            long j2 = j - ((w) tVar).d;
            double d = (j - ((w) tVar).e) / 1000.0d;
            if (((w) tVar).p != null && d > 2.0d) {
                ((w) tVar).p = null;
            }
            ((w) tVar).e(j, j2 / 1000.0d, ((w) tVar).c(j), d, ((w) tVar).a);
            z = true;
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final boolean l(float f) {
        m mVar = this.g;
        mVar.b.a(f);
        return mVar.a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0201 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0203 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0211  */
    /* JADX WARN: Code duplicated, block: B:104:0x0212 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x021a A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x022e  */
    /* JADX WARN: Code duplicated, block: B:111:0x023f A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x025e A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0266 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x026c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0271  */
    /* JADX WARN: Code duplicated, block: B:118:0x0272  */
    /* JADX WARN: Code duplicated, block: B:121:0x0278  */
    /* JADX WARN: Code duplicated, block: B:124:0x02c4 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02d7 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02df A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x02f9 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0300 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0306 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0309  */
    /* JADX WARN: Code duplicated, block: B:140:0x0314 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0322 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x032a  */
    /* JADX WARN: Code duplicated, block: B:147:0x0350 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x040d A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0419 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x042b  */
    /* JADX WARN: Code duplicated, block: B:177:0x042e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0435 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0455 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0474 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0480  */
    /* JADX WARN: Code duplicated, block: B:191:0x0483  */
    /* JADX WARN: Code duplicated, block: B:194:0x048a A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x04a8 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x04c3 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x04d0 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x04d8 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x050c A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0518 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x051f A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0531  */
    /* JADX WARN: Code duplicated, block: B:218:0x053a A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x0543 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x055b A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x0570  */
    /* JADX WARN: Code duplicated, block: B:226:0x0579 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:228:0x0581  */
    /* JADX WARN: Code duplicated, block: B:238:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:242:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:245:0x05f5 A[Catch: all -> 0x062a, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0025, B:14:0x0030, B:16:0x003a, B:22:0x0056, B:24:0x0068, B:28:0x007a, B:30:0x0083, B:32:0x00a3, B:34:0x00aa, B:38:0x00b3, B:40:0x00d5, B:42:0x00e8, B:44:0x00f6, B:46:0x00fa, B:50:0x0105, B:54:0x0115, B:56:0x011e, B:58:0x0122, B:60:0x0160, B:94:0x01ce, B:98:0x01f2, B:101:0x0203, B:107:0x0225, B:109:0x0230, B:111:0x023f, B:125:0x02cf, B:127:0x02d7, B:129:0x02df, B:130:0x02e3, B:132:0x02f9, B:138:0x030b, B:140:0x0314, B:142:0x0322, B:145:0x032e, B:147:0x0350, B:150:0x035a, B:152:0x038e, B:154:0x0394, B:156:0x039a, B:158:0x03a0, B:161:0x03c5, B:163:0x03d7, B:165:0x03dd, B:167:0x03e3, B:169:0x03e9, B:170:0x03f4, B:200:0x04bf, B:202:0x04c3, B:205:0x04f2, B:207:0x050c, B:209:0x0518, B:210:0x051f, B:212:0x0527, B:216:0x0532, B:218:0x053a, B:220:0x054b, B:222:0x055b, B:224:0x0571, B:226:0x0579, B:227:0x057d, B:246:0x0622, B:232:0x0593, B:233:0x0598, B:235:0x05a2, B:236:0x05a7, B:243:0x05ed, B:245:0x05f5, B:219:0x0543, B:203:0x04d0, B:159:0x03ac, B:171:0x040d, B:173:0x0419, B:174:0x0421, B:178:0x042f, B:180:0x0435, B:182:0x043b, B:184:0x0441, B:186:0x046c, B:188:0x0474, B:192:0x0484, B:194:0x048a, B:196:0x0490, B:198:0x0496, B:199:0x04a8, B:185:0x0455, B:133:0x0300, B:135:0x0306, B:137:0x030a, B:204:0x04d8, B:112:0x025e, B:114:0x0266, B:122:0x027a, B:124:0x02c4, B:104:0x0212, B:106:0x021a, B:64:0x016d, B:68:0x017c, B:70:0x0184, B:81:0x01a4, B:29:0x007f, B:17:0x0040, B:19:0x0047, B:21:0x0051, B:7:0x000e), top: B:252:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0192  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:90:0x01bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c6  */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b4, code lost:
    
        if (r28 > 0.2d) goto L86;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:171:0x040d, please report this as an issue */
    @Override // com.google.android.libraries.navigation.internal.p002do.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean m(r rVar) {
        t tVar;
        Boolean boolValueOf;
        long j;
        double d;
        b bVar;
        boolean z;
        double dE;
        b bVar2;
        m mVar;
        boolean z2;
        long j2;
        boolean z3;
        boolean z4;
        long j3;
        double dC;
        boolean z5;
        v vVar;
        v vVar2;
        boolean z6;
        w wVar;
        long j4;
        x xVarN;
        double dE2;
        double dA;
        long j5;
        float f;
        double d2;
        double d3;
        double d4;
        double dMin;
        double d5;
        double dA2;
        double d6;
        m mVar2;
        b bVar3;
        this.f = rVar.B() ? 0 : Math.round(rVar.d);
        a aVar = this.c;
        tVar = this.e;
        m mVar3 = this.g;
        long jA = aVar.a();
        boolean z7 = mVar3.a && !mVar3.b.c();
        if (rVar.l().d()) {
            ((w) tVar).y = true;
        } else if (((w) tVar).y && rVar.l().c()) {
            ((w) tVar).y = false;
        }
        long j6 = rVar.l().j;
        ak akVarL = rVar.l();
        if (akVarL.i.e(j6)) {
            boolValueOf = Boolean.valueOf(akVarL.i.c(j6) > 0.9d);
        } else {
            boolValueOf = false;
        }
        ((w) tVar).i = boolValueOf.booleanValue();
        long j7 = jA - ((w) tVar).d;
        ((w) tVar).d = jA;
        x xVarN2 = rVar.n();
        double d7 = j7;
        boolean z8 = rVar.t() && (((w) tVar).c || rVar.v());
        double dF = rVar.f();
        boolean zX = rVar.x();
        double d8 = rVar.f;
        aa aaVar = rVar.l().Q;
        boolean z9 = !((w) tVar).m;
        double d9 = d8;
        if (aaVar != null) {
            boolean z10 = z8;
            if (com.google.android.libraries.navigation.internal.ja.a.a(rVar.g) - aaVar.c < 1500) {
                x xVarA = x.A(aaVar.d, aaVar.e);
                int i = aaVar.b;
                boolean z11 = ((i & 128) == 0 || (i & 256) == 0 || aaVar.i >= 50.0f) ? false : true;
                double d10 = aaVar.h;
                boolean z12 = (i & 32) != 0;
                d7 = d7;
                double d11 = aaVar.g;
                double dSqrt = 1.0d;
                if (z11 && (i & 8) != 0) {
                    dSqrt = Math.sqrt(com.google.android.libraries.navigation.internal.db.p.b(Math.max(0.0f, xVarN2.l(xVarA) - 10.0f), aaVar.f) * com.google.android.libraries.navigation.internal.db.p.b(Math.max(0.0d, y.a(rVar.f(), (float) d10) - 35.0f), aaVar.i));
                }
                if (!rVar.l().d()) {
                    if (rVar.B()) {
                        if (dSqrt < 0.005d && aaVar.f < 20.0f) {
                            float f2 = rVar.f;
                            if (f2 < 15.0f) {
                                if (f2 != 0.0f) {
                                }
                                if (z9) {
                                    d11 = d9;
                                    z8 = z10;
                                    dF = dF;
                                    z12 = zX;
                                } else if (z11) {
                                    dF = d10;
                                    z8 = true;
                                } else {
                                    z8 = z10;
                                    dF = dF;
                                }
                                boolean z13 = ((w) tVar).m;
                                d9 = d11;
                                xVarN2 = xVarA;
                                zX = z12;
                            }
                        }
                        if (z12 && d11 > 5.5d) {
                            if (dSqrt <= 0.019d) {
                                if (aaVar.f > 40.0f) {
                                }
                            }
                        }
                        if (z9) {
                            d11 = d9;
                            z8 = z10;
                            dF = dF;
                            z12 = zX;
                        } else if (z11) {
                            dF = d10;
                            z8 = true;
                        } else {
                            z8 = z10;
                            dF = dF;
                        }
                        boolean z14 = ((w) tVar).m;
                        d9 = d11;
                        xVarN2 = xVarA;
                        zX = z12;
                    }
                    z9 = true;
                    if (z9) {
                        d11 = d9;
                        z8 = z10;
                        dF = dF;
                        z12 = zX;
                    } else if (z11) {
                        dF = d10;
                        z8 = true;
                    } else {
                        z8 = z10;
                        dF = dF;
                    }
                    boolean z15 = ((w) tVar).m;
                    d9 = d11;
                    xVarN2 = xVarA;
                    zX = z12;
                }
                z9 = false;
                if (z9) {
                    d11 = d9;
                    z8 = z10;
                    dF = dF;
                    z12 = zX;
                } else if (z11) {
                    dF = d10;
                    z8 = true;
                } else {
                    z8 = z10;
                    dF = dF;
                }
                boolean z16 = ((w) tVar).m;
                d9 = d11;
                xVarN2 = xVarA;
                zX = z12;
            } else {
                z8 = z10;
                dF = dF;
            }
            if (jA - ((w) tVar).h <= 3000) {
                j = jA;
            } else if (!z8) {
                bVar3 = ((w) tVar).s;
                ((w) tVar).s = null;
                if (bVar3 != null) {
                    j = jA;
                    ((w) tVar).h = j;
                } else {
                    j = jA;
                }
            } else if (((w) tVar).s == null) {
                ((w) tVar).s = new b(dF);
                j = jA;
                ((w) tVar).h = j;
            } else {
                j = jA;
            }
            d = d7 / 1000.0d;
            if (((w) tVar).q == null) {
                ((w) tVar).q = new b(xVarN2.a);
                ((w) tVar).r = new b(xVarN2.b);
            } else {
                bVar = ((w) tVar).s;
                if (bVar != null) {
                    dE = bVar.e(d);
                    z = true;
                } else {
                    z = true;
                    dE = 0.0d;
                }
                if (z != z8) {
                    dE = dF;
                }
                if (zX || !z8) {
                    d9 = 0.0d;
                }
                double radians = Math.toRadians(dE);
                double dE3 = d9 * xVarN2.e();
                double dSin = dE3 * Math.sin(radians);
                double dCos = Math.cos(radians) * dE3;
                b bVar4 = ((w) tVar).q;
                ar.q(bVar4);
                bVar4.h(d, ((double) xVarN2.a) + dSin, dSin);
                b bVar5 = ((w) tVar).r;
                ar.q(bVar5);
                bVar5.h(d, ((double) xVarN2.b) + dCos, dCos);
                bVar2 = ((w) tVar).s;
                if (bVar2 != null) {
                    bVar2.g(d, dE, 0.0d);
                }
            }
            mVar = rVar.l().A;
            if (mVar != null) {
                xVarN = rVar.l().e;
                if (xVarN == null) {
                    xVarN = rVar.n();
                }
                dE2 = xVarN.e();
                dA = mVar.a(xVarN);
                j5 = j;
                if (Double.isNaN(rVar.l().N)) {
                    if (rVar.x()) {
                        f = rVar.f;
                    } else {
                        f = 0.0f;
                    }
                    d2 = f;
                } else {
                    d2 = rVar.l().N;
                }
                d3 = d2 * dE2;
                if (((w) tVar).o != null) {
                    z3 = z9;
                    d4 = Double.isNaN(rVar.l().P) ? 0.0d : rVar.l().P * dE2;
                    ((w) tVar).u = j5;
                    ((w) tVar).v = dA;
                    ((w) tVar).w = d3;
                    ((w) tVar).x = dE2;
                    if (!rVar.l().m || (mVar2 = ((w) tVar).j) == null) {
                        j2 = j5;
                        z2 = z7;
                        dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                        if (Math.abs(d3) < dMin) {
                            d5 = 0.0d;
                        } else {
                            d5 = d3;
                        }
                        if (!u.a(dA) && u.a(d3) && u.a(d5)) {
                            ((w) tVar).f402n.i(dA, d3, dA + d5, d3);
                        } else {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                        }
                        if (((w) tVar).o != null) {
                            dA2 = w.a(mVar, dA, xVarN);
                            if (Math.abs(d4) < dMin) {
                                d6 = 0.0d;
                            } else {
                                d6 = d4;
                            }
                            if (!u.a(dA2) && u.a(d4) && u.a(d6)) {
                                ((w) tVar).o.i(dA2, d4, dA2 + d6, d4);
                            } else {
                                ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                            }
                        }
                    } else {
                        b bVar6 = ((w) tVar).f402n;
                        b bVar7 = ((w) tVar).o;
                        x xVar = new x();
                        w.b(mVar2, xVar, bVar6, bVar7, d);
                        double dC2 = bVar6.c(d);
                        z2 = z7;
                        double dA3 = mVar.a(xVar);
                        j2 = j5;
                        double dA4 = mVar.a(xVarN);
                        if (u.a(dA3) && u.a(dC2) && u.a(dA4) && u.a(d3)) {
                            bVar6.i(dA3, dC2, dA4 + d3, d3);
                        } else {
                            ((h) ((h) j.b.h(an.LARGE)).F(399)).p("Tried to update polyline down-track animation with invalid values.");
                        }
                        if (bVar7 != null) {
                            double dC3 = bVar7.c(d);
                            double dA5 = w.a(mVar, dA3, xVar);
                            double dA6 = w.a(mVar, dA4, xVarN);
                            if (u.a(dA5) && u.a(dC3) && u.a(dA6) && u.a(d4)) {
                                bVar7.i(dA5, dC3, dA6 + d4, d4);
                            } else {
                                ((h) ((h) j.b.h(an.LARGE)).F(400)).p("Tried to update polyline cross-track animation with invalid values.");
                            }
                        }
                    }
                    if (mVar.c) {
                        ((w) tVar).k = rVar.l().M;
                    } else {
                        ((w) tVar).k = null;
                    }
                } else {
                    z3 = z9;
                }
                ((w) tVar).u = j5;
                ((w) tVar).v = dA;
                ((w) tVar).w = d3;
                ((w) tVar).x = dE2;
                if (rVar.l().m) {
                    j2 = j5;
                    z2 = z7;
                    dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                    if (Math.abs(d3) < dMin) {
                        d5 = 0.0d;
                    } else {
                        d5 = d3;
                    }
                    if (!u.a(dA)) {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    }
                    if (((w) tVar).o != null) {
                        dA2 = w.a(mVar, dA, xVarN);
                        if (Math.abs(d4) < dMin) {
                            d6 = 0.0d;
                        } else {
                            d6 = d4;
                        }
                        if (!u.a(dA2)) {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        } else {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        }
                    }
                } else {
                    j2 = j5;
                    z2 = z7;
                    dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                    if (Math.abs(d3) < dMin) {
                        d5 = 0.0d;
                    } else {
                        d5 = d3;
                    }
                    if (!u.a(dA)) {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    }
                    if (((w) tVar).o != null) {
                        dA2 = w.a(mVar, dA, xVarN);
                        if (Math.abs(d4) < dMin) {
                            d6 = 0.0d;
                        } else {
                            d6 = d4;
                        }
                        if (!u.a(dA2)) {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        } else {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        }
                    }
                }
                if (mVar.c) {
                    ((w) tVar).k = rVar.l().M;
                } else {
                    ((w) tVar).k = null;
                }
            } else {
                z2 = z7;
                j2 = j;
                z3 = z9;
                ((w) tVar).k = rVar.l().M;
                ((w) tVar).u = -1000L;
            }
            ((w) tVar).j = mVar;
            ((w) tVar).l = rVar.l().B;
            if (((w) tVar).c) {
                j4 = j2 - 1;
                if (((w) tVar).m) {
                    ((w) tVar).f = j4;
                } else {
                    ((w) tVar).g = j4;
                }
            }
            if (!z3 || ((w) tVar).j == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            ((w) tVar).m = z4;
            if (z4) {
                j3 = j2;
                ((w) tVar).f = j3;
            } else {
                j3 = j2;
                ((w) tVar).g = j3;
            }
            dC = ((w) tVar).c(j3);
            if (((w) tVar).c) {
                z5 = true;
            } else {
                v vVar3 = ((w) tVar).a;
                z5 = true;
                ((w) tVar).e(j3, 0.0d, dC, 0.0d, vVar3);
            }
            ((w) tVar).c = z5;
            if (z2) {
                wVar = (w) tVar;
            } else {
                if ((dC > 1.0E-6d || dC >= 0.999999d) && ((w) tVar).f()) {
                    vVar = ((w) tVar).b;
                    ((w) tVar).e(j3, 1.0d, dC, 1.0d, vVar);
                    x xVar2 = vVar.a;
                    ar.q(xVar2);
                    x xVar3 = ((w) tVar).a.a;
                    ar.q(xVar3);
                    vVar2 = ((w) tVar).a;
                    float fH = xVar2.h(xVar3);
                    if (y.a(vVar.c, vVar2.c) <= 5.0f || fH > 60.0f) {
                        z6 = z5;
                    } else {
                        z6 = false;
                    }
                    ((w) tVar).t = z6;
                    if (!z6) {
                        w.d(((w) tVar).q);
                        w.d(((w) tVar).r);
                        w.d(((w) tVar).s);
                        w.d(((w) tVar).f402n);
                        w.d(((w) tVar).o);
                    }
                } else {
                    wVar = (w) tVar;
                }
            }
            wVar.t = z5;
        }
        z9 = false;
        if (jA - ((w) tVar).h <= 3000) {
            j = jA;
        } else if (!z8) {
            bVar3 = ((w) tVar).s;
            ((w) tVar).s = null;
            if (bVar3 != null) {
                j = jA;
                ((w) tVar).h = j;
            } else {
                j = jA;
            }
        } else if (((w) tVar).s == null) {
            ((w) tVar).s = new b(dF);
            j = jA;
            ((w) tVar).h = j;
        } else {
            j = jA;
        }
        d = d7 / 1000.0d;
        if (((w) tVar).q == null) {
            ((w) tVar).q = new b(xVarN2.a);
            ((w) tVar).r = new b(xVarN2.b);
        } else {
            bVar = ((w) tVar).s;
            if (bVar != null) {
                dE = bVar.e(d);
                z = true;
            } else {
                z = true;
                dE = 0.0d;
            }
            if (z != z8) {
                dE = dF;
            }
            if (zX) {
                d9 = 0.0d;
            } else {
                d9 = 0.0d;
            }
            double radians2 = Math.toRadians(dE);
            double dE4 = d9 * xVarN2.e();
            double dSin2 = dE4 * Math.sin(radians2);
            double dCos2 = Math.cos(radians2) * dE4;
            b bVar8 = ((w) tVar).q;
            ar.q(bVar8);
            bVar8.h(d, ((double) xVarN2.a) + dSin2, dSin2);
            b bVar9 = ((w) tVar).r;
            ar.q(bVar9);
            bVar9.h(d, ((double) xVarN2.b) + dCos2, dCos2);
            bVar2 = ((w) tVar).s;
            if (bVar2 != null) {
                bVar2.g(d, dE, 0.0d);
            }
        }
        mVar = rVar.l().A;
        if (mVar != null) {
            xVarN = rVar.l().e;
            if (xVarN == null) {
                xVarN = rVar.n();
            }
            dE2 = xVarN.e();
            dA = mVar.a(xVarN);
            j5 = j;
            if (Double.isNaN(rVar.l().N)) {
                d2 = rVar.l().N;
            } else {
                if (rVar.x()) {
                    f = rVar.f;
                } else {
                    f = 0.0f;
                }
                d2 = f;
            }
            d3 = d2 * dE2;
            if (((w) tVar).o != null) {
                z3 = z9;
                if (Double.isNaN(rVar.l().P)) {
                }
                ((w) tVar).u = j5;
                ((w) tVar).v = dA;
                ((w) tVar).w = d3;
                ((w) tVar).x = dE2;
                if (rVar.l().m) {
                    j2 = j5;
                    z2 = z7;
                    dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                    if (Math.abs(d3) < dMin) {
                        d5 = 0.0d;
                    } else {
                        d5 = d3;
                    }
                    if (!u.a(dA)) {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    }
                    if (((w) tVar).o != null) {
                        dA2 = w.a(mVar, dA, xVarN);
                        if (Math.abs(d4) < dMin) {
                            d6 = 0.0d;
                        } else {
                            d6 = d4;
                        }
                        if (!u.a(dA2)) {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        } else {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        }
                    }
                } else {
                    j2 = j5;
                    z2 = z7;
                    dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                    if (Math.abs(d3) < dMin) {
                        d5 = 0.0d;
                    } else {
                        d5 = d3;
                    }
                    if (!u.a(dA)) {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                    }
                    if (((w) tVar).o != null) {
                        dA2 = w.a(mVar, dA, xVarN);
                        if (Math.abs(d4) < dMin) {
                            d6 = 0.0d;
                        } else {
                            d6 = d4;
                        }
                        if (!u.a(dA2)) {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        } else {
                            ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                        }
                    }
                }
                if (mVar.c) {
                    ((w) tVar).k = rVar.l().M;
                } else {
                    ((w) tVar).k = null;
                }
            } else {
                z3 = z9;
            }
            ((w) tVar).u = j5;
            ((w) tVar).v = dA;
            ((w) tVar).w = d3;
            ((w) tVar).x = dE2;
            if (rVar.l().m) {
                j2 = j5;
                z2 = z7;
                dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                if (Math.abs(d3) < dMin) {
                    d5 = 0.0d;
                } else {
                    d5 = d3;
                }
                if (!u.a(dA)) {
                    ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                } else {
                    ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                }
                if (((w) tVar).o != null) {
                    dA2 = w.a(mVar, dA, xVarN);
                    if (Math.abs(d4) < dMin) {
                        d6 = 0.0d;
                    } else {
                        d6 = d4;
                    }
                    if (!u.a(dA2)) {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                    }
                }
            } else {
                j2 = j5;
                z2 = z7;
                dMin = ((double) (rVar.y() ? Math.min(1.0f, rVar.h()) : 1.0f)) * dE2;
                if (Math.abs(d3) < dMin) {
                    d5 = 0.0d;
                } else {
                    d5 = d3;
                }
                if (!u.a(dA)) {
                    ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                } else {
                    ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_VISIBILITY)).p("Tried to update polyline down-track animation with invalid values.");
                }
                if (((w) tVar).o != null) {
                    dA2 = w.a(mVar, dA, xVarN);
                    if (Math.abs(d4) < dMin) {
                        d6 = 0.0d;
                    } else {
                        d6 = d4;
                    }
                    if (!u.a(dA2)) {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_ALPHA)).p("Tried to update polyline cross-track animation with invalid values.");
                    }
                }
            }
            if (mVar.c) {
                ((w) tVar).k = rVar.l().M;
            } else {
                ((w) tVar).k = null;
            }
        } else {
            z2 = z7;
            j2 = j;
            z3 = z9;
            ((w) tVar).k = rVar.l().M;
            ((w) tVar).u = -1000L;
        }
        ((w) tVar).j = mVar;
        ((w) tVar).l = rVar.l().B;
        if (((w) tVar).c) {
            j4 = j2 - 1;
            if (((w) tVar).m) {
                ((w) tVar).f = j4;
            } else {
                ((w) tVar).g = j4;
            }
        }
        if (z3) {
            z4 = false;
        } else {
            z4 = false;
        }
        ((w) tVar).m = z4;
        if (z4) {
            j3 = j2;
            ((w) tVar).f = j3;
        } else {
            j3 = j2;
            ((w) tVar).g = j3;
        }
        dC = ((w) tVar).c(j3);
        if (((w) tVar).c) {
            v vVar4 = ((w) tVar).a;
            z5 = true;
            ((w) tVar).e(j3, 0.0d, dC, 0.0d, vVar4);
        } else {
            z5 = true;
        }
        ((w) tVar).c = z5;
        if (z2) {
            wVar = (w) tVar;
        } else {
            if (dC > 1.0E-6d) {
                vVar = ((w) tVar).b;
                ((w) tVar).e(j3, 1.0d, dC, 1.0d, vVar);
                x xVar4 = vVar.a;
                ar.q(xVar4);
                x xVar5 = ((w) tVar).a.a;
                ar.q(xVar5);
                vVar2 = ((w) tVar).a;
                float fH2 = xVar4.h(xVar5);
                if (y.a(vVar.c, vVar2.c) <= 5.0f) {
                    z6 = z5;
                } else {
                    z6 = z5;
                }
                ((w) tVar).t = z6;
                if (!z6) {
                    w.d(((w) tVar).q);
                    w.d(((w) tVar).r);
                    w.d(((w) tVar).s);
                    w.d(((w) tVar).f402n);
                    w.d(((w) tVar).o);
                }
            } else {
                vVar = ((w) tVar).b;
                ((w) tVar).e(j3, 1.0d, dC, 1.0d, vVar);
                x xVar6 = vVar.a;
                ar.q(xVar6);
                x xVar7 = ((w) tVar).a.a;
                ar.q(xVar7);
                vVar2 = ((w) tVar).a;
                float fH3 = xVar6.h(xVar7);
                if (y.a(vVar.c, vVar2.c) <= 5.0f) {
                    z6 = z5;
                } else {
                    z6 = z5;
                }
                ((w) tVar).t = z6;
                if (!z6) {
                    w.d(((w) tVar).q);
                    w.d(((w) tVar).r);
                    w.d(((w) tVar).s);
                    w.d(((w) tVar).f402n);
                    w.d(((w) tVar).o);
                }
            }
        }
        wVar.t = z5;
        return ((w) tVar).t;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void n() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0030 A[Catch: all -> 0x0065, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0011, B:9:0x001b, B:16:0x0030, B:17:0x003f, B:14:0x0028), top: B:23:0x0001 }] */
    public final synchronized boolean o(com.google.android.libraries.navigation.internal.cy.a aVar) {
        boolean z;
        t tVar = this.e;
        long jA = this.c.a();
        z = true;
        boolean z2 = aVar.l() && !((w) tVar).y;
        b bVar = ((w) tVar).p;
        if (bVar == null) {
            if (z2) {
                if (bVar == null) {
                    bVar = new b(aVar.f());
                    ((w) tVar).p = bVar;
                }
                b bVar2 = bVar;
                long j = jA - ((w) tVar).e;
                double dH = aVar.h() / 2.0f;
                bVar2.g(j / 1000.0d, ((double) aVar.f()) - dH, dH);
                ((w) tVar).e = jA;
            } else {
                z = false;
            }
        } else if (z2) {
            if (bVar == null) {
                bVar = new b(aVar.f());
                ((w) tVar).p = bVar;
            }
            b bVar3 = bVar;
            long j2 = jA - ((w) tVar).e;
            double dH2 = aVar.h() / 2.0f;
            bVar3.g(j2 / 1000.0d, ((double) aVar.f()) - dH2, dH2);
            ((w) tVar).e = jA;
        } else {
            ((w) tVar).p = null;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00c2  */
    public final synchronized boolean p(com.google.android.libraries.navigation.internal.dh.p pVar) {
        boolean z;
        t tVar = this.e;
        long jA = this.c.a();
        long j = ((w) tVar).u;
        long j2 = jA - j;
        if (j >= 0) {
            double d = j2 / 1000.0d;
            if (d < 0.0d || d > 2.0d) {
                z = false;
            } else {
                float f = pVar.b;
                double d2 = ((w) tVar).x;
                double d3 = 0.0d * d2;
                long j3 = ((w) tVar).d;
                double d4 = (jA - j3) / 1000.0d;
                double d5 = ((w) tVar).v + (((((w) tVar).w + d3) / 2.0d) * d);
                ((w) tVar).v = d5;
                ((w) tVar).u = jA;
                ((w) tVar).w = d3;
                b bVar = ((w) tVar).f402n;
                if (Math.abs(bVar.e(1.0d) - (((((j3 - jA) + 1000.0d) / 1000.0d) * d3) + d5)) >= d2) {
                    if (u.a(d4) && u.a(d5) && u.a(d3)) {
                        bVar.h(d4, d5 + d3, d3);
                        ((w) tVar).d = jA;
                        z = true;
                    } else {
                        ((h) ((h) j.b.h(an.LARGE)).F(TypedValues.CycleType.TYPE_CURVE_FIT)).p("Tried to update polyline down-track animation with invalid values.");
                    }
                }
                z = false;
            }
        } else {
            z = false;
        }
        return z;
    }
}
