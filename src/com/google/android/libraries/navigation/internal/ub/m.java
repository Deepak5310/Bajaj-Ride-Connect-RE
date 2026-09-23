package com.google.android.libraries.navigation.internal.ub;

import android.graphics.Rect;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.fa;
import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oe.y;
import com.google.android.libraries.navigation.internal.pb.ac;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zs.aq;
import j$.time.Duration;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.uc.l {
    static final com.google.android.libraries.navigation.internal.pd.g a = new com.google.android.libraries.navigation.internal.pd.g();
    private ff b = ff.NORMAL;
    private float c = -1.0f;
    private r d;
    private final com.google.android.libraries.navigation.internal.fz.d e;
    private final t f;
    private final com.google.android.libraries.navigation.internal.uc.i g;
    private final j h;
    private final com.google.android.libraries.navigation.internal.pd.h i;
    private final com.google.android.libraries.navigation.internal.uc.t j;

    public m(com.google.android.libraries.navigation.internal.fz.d dVar, t tVar, com.google.android.libraries.navigation.internal.uc.i iVar, com.google.android.libraries.navigation.internal.pd.h hVar, j jVar, com.google.android.libraries.navigation.internal.uc.t tVar2) {
        this.e = dVar;
        this.f = tVar;
        this.g = iVar;
        this.i = hVar;
        this.h = jVar;
        this.j = tVar2;
    }

    private final boolean e(ff ffVar, x xVar, com.google.android.libraries.navigation.internal.pd.e eVar, int i, int i2, float f) {
        ff ffVar2 = this.b;
        r rVar = this.d;
        ar.q(rVar);
        com.google.android.libraries.navigation.internal.rf.g gVar = new com.google.android.libraries.navigation.internal.rf.g(com.google.android.libraries.navigation.internal.pd.d.b(new com.google.android.libraries.navigation.internal.pd.d(rVar.m(), this.h.a(ffVar), a(ffVar), rVar.f(), eVar)), i, i2, f);
        ay ayVarF = gVar.f(xVar);
        int iD = gVar.d();
        int iC = gVar.c();
        if (ayVarF == null) {
            return false;
        }
        float f2 = ffVar2 == ffVar ? 0.0f : 0.19999999f;
        float f3 = iD;
        float f4 = ayVarF.b;
        if (f4 <= f3 * f2 || f4 >= f3 * (1.0f - f2)) {
            return false;
        }
        float f5 = ayVarF.c;
        float f6 = iC;
        return f5 < f6 && f5 > f6 * f2;
    }

    final float a(ff ffVar) {
        com.google.android.libraries.navigation.internal.uc.b bVar = (com.google.android.libraries.navigation.internal.uc.b) this.g;
        boolean z = bVar.c;
        boolean z2 = bVar.b;
        fa faVar = this.e.b().i(bVar.a, z2, z, ffVar).d;
        if (faVar == null) {
            faVar = fa.a;
        }
        return faVar.c;
    }

    @Override // com.google.android.libraries.navigation.internal.uc.l
    public final com.google.android.libraries.navigation.internal.pd.d b(bq bqVar, Rect rect, int i, int i2) {
        com.google.android.libraries.navigation.internal.pd.e eVarC = com.google.android.libraries.navigation.internal.pd.e.c(rect.exactCenterX(), rect.exactCenterY(), i, i2);
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        x xVar = bqVar.c;
        aVar.d(new com.google.android.libraries.navigation.internal.oe.r(xVar.b(), xVar.d()));
        aVar.e = bqVar.o;
        aVar.c = this.h.a(ff.INSPECT_STEP);
        aVar.d = a(ff.INSPECT_STEP);
        aVar.f = eVarC;
        return aVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:122:0x027c  */
    /* JADX WARN: Code duplicated, block: B:123:0x027e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0299 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x02b2 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x02bc A[Catch: all -> 0x03fb, LOOP:1: B:124:0x0281->B:136:0x02bc, LOOP_END, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x02c7 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x02df A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x02f5 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02fd A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0305 A[PHI: r13
      0x0305: PHI (r13v13 boolean) = (r13v11 boolean), (r13v15 boolean) binds: [B:147:0x0303, B:151:0x0311] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:151:0x0311  */
    /* JADX WARN: Code duplicated, block: B:152:0x0312 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x031c A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x0328 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:166:0x0344 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x034f A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x0362 A[EDGE_INSN: B:198:0x0362->B:169:0x0362 BREAK  A[LOOP:0: B:91:0x01e6->B:168:0x035b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x0298 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0069 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0339 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0337 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c1 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c7 A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x016d A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01ef A[Catch: all -> 0x03fb, TryCatch #1 {all -> 0x03fb, blocks: (B:3:0x0012, B:5:0x001a, B:6:0x001e, B:10:0x0028, B:12:0x0043, B:14:0x0049, B:17:0x0054, B:19:0x0065, B:51:0x00c9, B:54:0x00d2, B:56:0x00d6, B:61:0x00e3, B:63:0x00e7, B:172:0x0370, B:175:0x038f, B:177:0x0397, B:179:0x039f, B:181:0x03c7, B:182:0x03d5, B:64:0x00ee, B:66:0x00f6, B:68:0x00fa, B:70:0x0106, B:72:0x0117, B:77:0x012b, B:80:0x013c, B:84:0x0147, B:86:0x016d, B:88:0x0176, B:90:0x017d, B:91:0x01e6, B:93:0x01ef, B:95:0x0207, B:98:0x020f, B:164:0x033c, B:166:0x0344, B:167:0x034f, B:102:0x022c, B:104:0x0236, B:106:0x0244, B:125:0x0283, B:128:0x028e, B:131:0x0299, B:133:0x02a3, B:134:0x02b2, B:136:0x02bc, B:111:0x024e, B:113:0x0259, B:116:0x0265, B:120:0x026e, B:137:0x02c7, B:139:0x02df, B:141:0x02e9, B:145:0x02f5, B:149:0x0307, B:160:0x0333, B:152:0x0312, B:154:0x031c, B:158:0x0329, B:146:0x02fd, B:169:0x0362, B:171:0x036c, B:82:0x0142, B:73:0x011e, B:75:0x0122, B:57:0x00da, B:60:0x00e0, B:20:0x0069, B:26:0x0079, B:28:0x007f, B:32:0x008a, B:44:0x00b5, B:35:0x0091, B:45:0x00b8, B:39:0x0098, B:41:0x00a3, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:9:0x0026), top: B:196:0x0012 }] */
    @Override // com.google.android.libraries.navigation.internal.uc.l
    public final com.google.android.libraries.navigation.internal.uc.n c(r rVar, bq bqVar, com.google.android.libraries.navigation.internal.se.b bVar, Rect rect, Float f, int i, int i2, float f2) {
        float f3;
        ff ffVar;
        r rVar2;
        com.google.android.libraries.navigation.internal.pd.e eVar;
        float fA;
        double dA;
        x xVarW;
        x xVar;
        com.google.android.libraries.navigation.internal.rf.g gVarB;
        an anVarD;
        float fA2;
        float f4;
        float f5;
        float f6;
        int iC;
        float f7;
        float f8;
        an anVar;
        ac acVar;
        ay ayVar;
        int iE;
        boolean zD;
        int i3;
        int i4;
        int i5;
        int i6;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ObliqueCameraPositioner.positionForFollowLocation");
        try {
            this.d = rVar;
            if (rVar.x()) {
                this.c = rVar.f;
            }
            com.google.android.libraries.navigation.internal.pd.e eVarC = com.google.android.libraries.navigation.internal.pd.e.c(rect.exactCenterX(), rect.bottom - ((int) ((57.0f * f2) + (rVar.t() ? 0 : i2 / 10))), i, i2);
            if (bqVar != null) {
                x xVar2 = bqVar.c;
                r rVar3 = this.d;
                if (rVar3 == null || rVar3.e(xVar2) > 1000.0f || !e(ff.APPROACH, xVar2, eVarC, i, i2, f2)) {
                    f3 = this.c;
                    if (f3 < 0.0f && f3 <= 100.0f) {
                        x xVar3 = bqVar != null ? bqVar.c : null;
                        ffVar = (this.c >= (this.b == ff.FAR_VIEW_MODE ? 15.0f : 20.0f) && ((rVar2 = this.d) == null || xVar3 == null || rVar2.e(xVar3) > 3000.0f || !e(ff.NORMAL, xVar3, eVarC, i, i2, f2))) ? ff.FAR_VIEW_MODE : ff.NORMAL;
                    } else if (this.b != ff.APPROACH || (ffVar = this.b) == ff.LIMITED_CONTROLLED_ACCESS_MANEUVER) {
                        ffVar = ff.NORMAL;
                    }
                } else {
                    ffVar = ff.APPROACH;
                }
            } else {
                f3 = this.c;
                if (f3 < 0.0f) {
                    if (this.b != ff.APPROACH) {
                        ffVar = ff.NORMAL;
                    } else {
                        ffVar = ff.NORMAL;
                    }
                } else if (this.b != ff.APPROACH) {
                    ffVar = ff.NORMAL;
                } else {
                    ffVar = ff.NORMAL;
                }
            }
            ff ffVar2 = this.b;
            if (ffVar != ff.LIMITED_CONTROLLED_ACCESS_MANEUVER || ffVar2 == ff.LIMITED_CONTROLLED_ACCESS_MANEUVER) {
                ff ffVar3 = ff.LIMITED_CONTROLLED_ACCESS_MANEUVER;
                if (ffVar != ffVar3 && ffVar2 == ffVar3) {
                    Trace.endAsyncSection("LimitedControlledAccessManeuverMode", 1);
                }
            } else {
                Trace.beginAsyncSection("LimitedControlledAccessManeuverMode", 1);
            }
            this.b = ffVar;
            if (f != null) {
                fA = f.floatValue();
                eVar = eVarC;
            } else {
                j jVar = this.h;
                x xVarN = rVar.n();
                if (bVar == null || bVar.c == null || jVar.a.b().a.aW) {
                    eVar = eVarC;
                } else {
                    bg bgVar = bVar.b;
                    Duration durationOfSeconds = Duration.ofSeconds(bVar.b() - 180);
                    if (bgVar.t != null) {
                        dA = bgVar.t.a(durationOfSeconds);
                    } else {
                        dA = bgVar.s != null ? bgVar.s.a(durationOfSeconds) : 0.0d;
                    }
                    double dA2 = ((double) bVar.f) + bVar.a();
                    bq bqVar2 = bVar.c;
                    if (dA > dA2) {
                        if (bqVar2 != null) {
                            xVarW = bqVar2.c;
                        } else {
                            xVar = null;
                        }
                        int i7 = ev.d;
                        eVar = eVarC;
                        gVarB = jVar.b(xVarN, xVar, lv.a, rect, ffVar, i, i2, (int) (128.0f * f2), (i2 * 4) / 100, Float.NaN, f2);
                        if (gVarB != null) {
                            anVarD = bVar.d(Float.MAX_VALUE);
                            if (anVarD != null && anVarD.a() > 2) {
                                ac acVar2 = jVar.c;
                                float f9 = rect.left;
                                float f10 = rect.top;
                                float f11 = rect.right;
                                float f12 = rect.bottom;
                                acVar2.h = anVarD.c();
                                acVar2.g.d(f9, f10, f11, f12);
                                acVar2.c.q(f9, f10);
                                acVar2.d.q(f9, f12);
                                acVar2.e.q(f11, f10);
                                acVar2.f.q(f11, f12);
                                com.google.android.libraries.navigation.internal.oq.a aVar = new com.google.android.libraries.navigation.internal.oq.a(gVarB.g());
                                aVar.h((float) x.a(anVarD.b(0), anVarD.b(1)));
                                gVarB = gVarB.i(aVar.l());
                                fA2 = jVar.a(ffVar);
                                f4 = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                                f5 = 2.0f;
                                f6 = ((rect.bottom - rect.top) / 2.0f) + rect.top;
                                iC = -1;
                                while (true) {
                                    f7 = fA2 - f4;
                                    if (f7 > 0.01f) {
                                        break;
                                    }
                                    com.google.android.libraries.navigation.internal.oq.a aVar2 = new com.google.android.libraries.navigation.internal.oq.a(gVarB.g());
                                    aVar2.k((f7 / f5) + f4);
                                    gVarB = gVarB.i(aVar2.l());
                                    if (iC >= 0 || iC >= anVarD.a()) {
                                        f8 = fA2;
                                        anVar = anVarD;
                                        acVar = jVar.c;
                                        ayVar = jVar.b;
                                        iE = acVar.h.e() - 1;
                                        if (acVar.d(gVarB, iE, acVar.b) || !acVar.g.e(acVar.b)) {
                                            zD = false;
                                            while (true) {
                                                if (iE <= 0) {
                                                    iE = -1;
                                                    break;
                                                }
                                                if (zD) {
                                                    acVar.b.r(acVar.a);
                                                } else {
                                                    if (!acVar.d(gVarB, iE, acVar.b)) {
                                                    }
                                                    iE--;
                                                }
                                                i3 = iE - 1;
                                                zD = acVar.d(gVarB, i3, acVar.a);
                                                if (zD) {
                                                    if (acVar.g.e(acVar.a) || !acVar.b(acVar.a, acVar.b, true, ayVar)) {
                                                        if (!acVar.a(acVar.a, acVar.b, ayVar)) {
                                                        }
                                                    }
                                                    iE = i3;
                                                    break;
                                                }
                                                iE--;
                                            }
                                        } else {
                                            ayVar.r(acVar.b);
                                        }
                                        iC = iE;
                                    } else {
                                        ac acVar3 = jVar.c;
                                        ay ayVar2 = jVar.b;
                                        ar.p(iC, acVar3.h.e());
                                        if (!acVar3.d(gVarB, iC, acVar3.a)) {
                                            f8 = fA2;
                                            anVar = anVarD;
                                        } else if (acVar3.g.e(acVar3.a)) {
                                            iC = acVar3.c(gVarB, iC, acVar3.a, ayVar2);
                                            f8 = fA2;
                                            anVar = anVarD;
                                        } else {
                                            ay ayVar3 = acVar3.a;
                                            if (iC == 0) {
                                                f8 = fA2;
                                            } else {
                                                ay ayVar4 = acVar3.b;
                                                f8 = fA2;
                                                int i8 = iC;
                                                int i9 = 0;
                                                int i10 = 10;
                                                while (true) {
                                                    if (i9 < i10) {
                                                        anVar = anVarD;
                                                        i4 = i8 - 1;
                                                        if (acVar3.d(gVarB, i4, ayVar4)) {
                                                            if (!acVar3.a(ayVar4, ayVar3, ayVar2)) {
                                                                if (i4 != 0) {
                                                                    ayVar3.r(ayVar4);
                                                                    i9++;
                                                                    i8 = i4;
                                                                    i10 = 10;
                                                                    anVarD = anVar;
                                                                }
                                                            }
                                                        }
                                                        i4 = -1;
                                                    }
                                                    if (i4 >= 0) {
                                                        iC = i4;
                                                    } else {
                                                        i5 = 0;
                                                        while (true) {
                                                            if (i5 < 10 && iC != acVar3.h.e() - 1) {
                                                                i6 = iC + 1;
                                                                if (!acVar3.d(gVarB, i6, acVar3.b)) {
                                                                    if (acVar3.g.e(acVar3.b)) {
                                                                        acVar3.a.r(acVar3.b);
                                                                        iC = acVar3.c(gVarB, i6, acVar3.a, ayVar2);
                                                                    } else if (!acVar3.a(acVar3.a, acVar3.b, ayVar2)) {
                                                                        acVar3.a.r(acVar3.b);
                                                                        i5++;
                                                                        iC = i6;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            anVar = anVarD;
                                            i4 = -1;
                                            if (i4 >= 0) {
                                                iC = i4;
                                            } else {
                                                i5 = 0;
                                                while (true) {
                                                    if (i5 < 10) {
                                                        i6 = iC + 1;
                                                        if (!acVar3.d(gVarB, i6, acVar3.b)) {
                                                            if (acVar3.g.e(acVar3.b)) {
                                                                acVar3.a.r(acVar3.b);
                                                                iC = acVar3.c(gVarB, i6, acVar3.a, ayVar2);
                                                            } else if (!acVar3.a(acVar3.a, acVar3.b, ayVar2)) {
                                                                acVar3.a.r(acVar3.b);
                                                                i5++;
                                                                iC = i6;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        iC = -1;
                                    }
                                    if (jVar.b.c < f6) {
                                        fA2 = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                                    } else {
                                        f4 = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                                        fA2 = f8;
                                    }
                                    anVarD = anVar;
                                    f5 = 2.0f;
                                }
                            }
                            fA = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                        }
                    } else {
                        xVarW = bgVar.w(dA);
                    }
                    xVar = xVarW;
                    int i11 = ev.d;
                    eVar = eVarC;
                    gVarB = jVar.b(xVarN, xVar, lv.a, rect, ffVar, i, i2, (int) (128.0f * f2), (i2 * 4) / 100, Float.NaN, f2);
                    if (gVarB != null) {
                        anVarD = bVar.d(Float.MAX_VALUE);
                        if (anVarD != null) {
                            ac acVar4 = jVar.c;
                            float f13 = rect.left;
                            float f14 = rect.top;
                            float f15 = rect.right;
                            float f16 = rect.bottom;
                            acVar4.h = anVarD.c();
                            acVar4.g.d(f13, f14, f15, f16);
                            acVar4.c.q(f13, f14);
                            acVar4.d.q(f13, f16);
                            acVar4.e.q(f15, f14);
                            acVar4.f.q(f15, f16);
                            com.google.android.libraries.navigation.internal.oq.a aVar3 = new com.google.android.libraries.navigation.internal.oq.a(gVarB.g());
                            aVar3.h((float) x.a(anVarD.b(0), anVarD.b(1)));
                            gVarB = gVarB.i(aVar3.l());
                            fA2 = jVar.a(ffVar);
                            f4 = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                            f5 = 2.0f;
                            f6 = ((rect.bottom - rect.top) / 2.0f) + rect.top;
                            iC = -1;
                            while (true) {
                                f7 = fA2 - f4;
                                if (f7 > 0.01f) {
                                    break;
                                    break;
                                }
                                com.google.android.libraries.navigation.internal.oq.a aVar4 = new com.google.android.libraries.navigation.internal.oq.a(gVarB.g());
                                aVar4.k((f7 / f5) + f4);
                                gVarB = gVarB.i(aVar4.l());
                                if (iC >= 0) {
                                    f8 = fA2;
                                    anVar = anVarD;
                                    acVar = jVar.c;
                                    ayVar = jVar.b;
                                    iE = acVar.h.e() - 1;
                                    if (acVar.d(gVarB, iE, acVar.b)) {
                                        zD = false;
                                        while (true) {
                                            if (iE <= 0) {
                                                iE = -1;
                                                break;
                                            }
                                            if (zD) {
                                                acVar.b.r(acVar.a);
                                            } else {
                                                if (!acVar.d(gVarB, iE, acVar.b)) {
                                                }
                                                iE--;
                                            }
                                            i3 = iE - 1;
                                            zD = acVar.d(gVarB, i3, acVar.a);
                                            if (zD) {
                                                if (acVar.g.e(acVar.a)) {
                                                }
                                                if (!acVar.a(acVar.a, acVar.b, ayVar)) {
                                                    iE = i3;
                                                    break;
                                                }
                                            }
                                            iE--;
                                        }
                                    } else {
                                        zD = false;
                                        while (true) {
                                            if (iE <= 0) {
                                                iE = -1;
                                                break;
                                            }
                                            if (zD) {
                                                acVar.b.r(acVar.a);
                                            } else {
                                                if (!acVar.d(gVarB, iE, acVar.b)) {
                                                }
                                                iE--;
                                            }
                                            i3 = iE - 1;
                                            zD = acVar.d(gVarB, i3, acVar.a);
                                            if (zD) {
                                                if (acVar.g.e(acVar.a)) {
                                                }
                                                if (!acVar.a(acVar.a, acVar.b, ayVar)) {
                                                    iE = i3;
                                                    break;
                                                }
                                            }
                                            iE--;
                                        }
                                    }
                                    iC = iE;
                                } else {
                                    f8 = fA2;
                                    anVar = anVarD;
                                    acVar = jVar.c;
                                    ayVar = jVar.b;
                                    iE = acVar.h.e() - 1;
                                    if (acVar.d(gVarB, iE, acVar.b)) {
                                        zD = false;
                                        while (true) {
                                            if (iE <= 0) {
                                                iE = -1;
                                                break;
                                            }
                                            if (zD) {
                                                acVar.b.r(acVar.a);
                                            } else {
                                                if (!acVar.d(gVarB, iE, acVar.b)) {
                                                }
                                                iE--;
                                            }
                                            i3 = iE - 1;
                                            zD = acVar.d(gVarB, i3, acVar.a);
                                            if (zD) {
                                                if (acVar.g.e(acVar.a)) {
                                                }
                                                if (!acVar.a(acVar.a, acVar.b, ayVar)) {
                                                    iE = i3;
                                                    break;
                                                }
                                            }
                                            iE--;
                                        }
                                    } else {
                                        zD = false;
                                        while (true) {
                                            if (iE <= 0) {
                                                iE = -1;
                                                break;
                                            }
                                            if (zD) {
                                                acVar.b.r(acVar.a);
                                            } else {
                                                if (!acVar.d(gVarB, iE, acVar.b)) {
                                                }
                                                iE--;
                                            }
                                            i3 = iE - 1;
                                            zD = acVar.d(gVarB, i3, acVar.a);
                                            if (zD) {
                                                if (acVar.g.e(acVar.a)) {
                                                }
                                                if (!acVar.a(acVar.a, acVar.b, ayVar)) {
                                                    iE = i3;
                                                    break;
                                                }
                                            }
                                            iE--;
                                        }
                                    }
                                    iC = iE;
                                }
                                if (jVar.b.c < f6) {
                                    fA2 = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                                } else {
                                    f4 = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                                    fA2 = f8;
                                }
                                anVarD = anVar;
                                f5 = 2.0f;
                            }
                        }
                        fA = ((com.google.android.libraries.navigation.internal.oq.b) gVarB.g()).e;
                    }
                }
                fA = jVar.a(ffVar);
            }
            float fA3 = a(ffVar);
            com.google.android.libraries.navigation.internal.pd.f fVar = new com.google.android.libraries.navigation.internal.pd.f();
            fVar.a = a;
            fVar.f = this.i;
            fVar.e = eVar;
            fVar.b = fA;
            fVar.c = fA3;
            if (!rVar.t() && bVar != null && (bVar.b.j == al.DRIVE || bVar.b.j == al.TWO_WHEELER)) {
                this.f.d().b(aa.k(com.google.android.libraries.navigation.internal.afe.i.a));
                bg bgVar2 = bVar.b;
                x xVarW2 = bgVar2.w(Math.min(bVar.a() + 500.0d, bgVar2.J));
                if (xVarW2 != null) {
                    float fC = y.c(rVar.n(), xVarW2);
                    fVar.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY;
                    fVar.d = fC;
                }
            }
            com.google.android.libraries.navigation.internal.uc.m mVarE = com.google.android.libraries.navigation.internal.uc.n.e();
            mVarE.c(ffVar);
            mVarE.b(h.c(com.google.android.libraries.navigation.internal.uc.g.FOLLOWING));
            mVarE.e(fVar.a());
            mVarE.d(aq.UNKNOWN_CAMERA_TYPE);
            com.google.android.libraries.navigation.internal.uc.n nVarA = mVarE.a();
            if (dVarB != null) {
                Trace.endSection();
            }
            return nVarA;
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

    @Override // com.google.android.libraries.navigation.internal.uc.l
    public final com.google.android.libraries.navigation.internal.pd.d d(r rVar, List list, Rect rect, int i, int i2, float f) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.android.libraries.navigation.internal.rf.g gVarB = this.h.b(rVar == null ? null : rVar.n(), null, list, rect, ff.INSPECT_ROUTE, i, i2, 0, (int) (65.0f * f), Float.NaN, f);
        if (gVarB != null) {
            return com.google.android.libraries.navigation.internal.pd.d.c(gVarB.g());
        }
        return null;
    }
}
