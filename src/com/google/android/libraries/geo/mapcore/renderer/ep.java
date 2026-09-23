package com.google.android.libraries.geo.mapcore.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.agi.jd;
import com.google.android.libraries.navigation.internal.agi.jh;
import com.google.android.libraries.navigation.internal.agi.jn;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ep {
    public final Object a;
    public final eq b;
    public final com.google.android.libraries.navigation.internal.agg.ci c;
    public final en d;
    private final es e;

    public ep(String str, int i, int i2, int i3, int i4, int i5, boolean z) {
        eq eqVar = new eq(i, i2, i4, i5);
        es esVar = new es(str, i, 2, z);
        this.a = new Object();
        this.c = new com.google.android.libraries.navigation.internal.agg.cy();
        this.b = eqVar;
        this.e = esVar;
        this.d = new en(esVar.k);
    }

    public final int a() {
        int iC;
        synchronized (this.a) {
            iC = this.b.c();
        }
        return iC;
    }

    public final int b() {
        int i;
        synchronized (this.a) {
            eq eqVar = this.b;
            i = eqVar.a.a * eqVar.b;
        }
        return i;
    }

    public final int c() {
        int i;
        synchronized (this.e) {
            i = this.e.g;
        }
        return i;
    }

    public final int d() {
        int i;
        synchronized (this.e) {
            i = this.e.f;
        }
        return i;
    }

    public final bw e() {
        bw bwVarA;
        synchronized (this.e) {
            bwVarA = this.e.a();
        }
        return bwVarA;
    }

    public final er f(Bitmap bitmap, int i, int i2, int i3, int i4, float f) throws Throwable {
        synchronized (this.a) {
            try {
                try {
                    el elVar = (el) this.c.h(i);
                    if (elVar != null) {
                        com.google.android.libraries.navigation.internal.yx.ar.k(elVar.a.l != -1);
                        com.google.android.libraries.navigation.internal.yx.ar.k(elVar.b > 0);
                        elVar.b++;
                        return elVar.a;
                    }
                    int iA = i2 < 0 ? this.b.a(bitmap.getWidth() + i3, bitmap.getHeight() + i3) : i2;
                    if (iA == -1) {
                        return null;
                    }
                    int iD = this.b.d(iA);
                    int iE = this.b.e(iA);
                    int i5 = i4 + i4;
                    int width = bitmap.getWidth() - i5;
                    int height = bitmap.getHeight() - i5;
                    eq eqVar = this.b;
                    boolean z = iA >= 0;
                    com.google.android.libraries.navigation.internal.yx.ar.k(z);
                    int iD2 = eqVar.a.d(iA) * eqVar.b;
                    eq eqVar2 = this.b;
                    com.google.android.libraries.navigation.internal.yx.ar.k(z);
                    try {
                        el elVar2 = new el(new er(this, i, iA, iD2, eqVar2.a.b(iA) * eqVar2.c, iD, iE, width, height, i3, i4, f));
                        elVar2.b++;
                        this.c.a(i, elVar2);
                        synchronized (this.d) {
                            en enVar = this.d;
                            er erVar = elVar2.a;
                            eq eqVar3 = this.b;
                            boolean z2 = eqVar3.b() == 0;
                            int iF = eqVar3.f();
                            enVar.b = z2;
                            enVar.c = iF;
                            for (int i6 = 0; i6 < enVar.a.size(); i6++) {
                                ((jn) enVar.a.get(i6)).put(erVar, bitmap);
                            }
                        }
                        return elVar2.a;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    public final er g(int i) {
        synchronized (this.a) {
            el elVar = (el) this.c.h(i);
            if (elVar == null) {
                return null;
            }
            com.google.android.libraries.navigation.internal.yx.ar.k(elVar.a.l != -1);
            com.google.android.libraries.navigation.internal.yx.ar.k(elVar.b > 0);
            elVar.b++;
            return elVar.a;
        }
    }

    public final void h(bv bvVar) {
        int i;
        synchronized (this.e) {
            es esVar = this.e;
            esVar.b = null;
            int i2 = 0;
            while (true) {
                bw[] bwVarArr = esVar.e;
                if (i2 < bwVarArr.length) {
                    bwVarArr[i2] = bw.a;
                    esVar.h[i2] = 0;
                    i2++;
                } else {
                    es esVar2 = this.e;
                    esVar2.b = bvVar;
                    esVar2.c = bt.a().b;
                    i = this.e.c;
                }
            }
        }
        synchronized (this.a) {
            this.b.d = i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x020b  */
    /* JADX WARN: Code duplicated, block: B:101:0x020d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0210 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x0212  */
    /* JADX WARN: Code duplicated, block: B:105:0x0214  */
    /* JADX WARN: Code duplicated, block: B:107:0x0217  */
    /* JADX WARN: Code duplicated, block: B:112:0x0224 A[Catch: all -> 0x0332, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0229 A[Catch: all -> 0x02e6, TRY_ENTER, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0235  */
    /* JADX WARN: Code duplicated, block: B:120:0x0238 A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0256 A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x025b  */
    /* JADX WARN: Code duplicated, block: B:125:0x025e A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0263  */
    /* JADX WARN: Code duplicated, block: B:129:0x026f A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0281  */
    /* JADX WARN: Code duplicated, block: B:133:0x0295 A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x02ba A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x02d6 A[Catch: all -> 0x02e6, TryCatch #6 {all -> 0x02e6, blocks: (B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6), top: B:207:0x0218, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0309 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:163:0x030a A[Catch: all -> 0x0332, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0311 A[Catch: all -> 0x0332, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0316 A[Catch: all -> 0x0332, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0320  */
    /* JADX WARN: Code duplicated, block: B:199:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x02e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x01df A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x0232 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0087 A[Catch: all -> 0x0332, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01a7 A[Catch: all -> 0x0332, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01e1 A[Catch: all -> 0x0332, TryCatch #3 {, blocks: (B:9:0x0038, B:11:0x003d, B:21:0x0066, B:15:0x0045, B:17:0x004a, B:19:0x0052, B:20:0x0063, B:25:0x006d, B:30:0x0087, B:81:0x019d, B:82:0x01a1, B:84:0x01a7, B:152:0x02f5, B:153:0x02f7, B:159:0x0302, B:87:0x01e1, B:89:0x01e5, B:91:0x01eb, B:93:0x01f1, B:95:0x01f9, B:97:0x0201, B:112:0x0224, B:141:0x02e1, B:151:0x02f4, B:150:0x02f1, B:160:0x0303, B:169:0x0318, B:163:0x030a, B:167:0x0311, B:168:0x0316, B:182:0x0331, B:181:0x032e, B:154:0x02f8, B:155:0x02fd, B:26:0x0080, B:32:0x008c, B:34:0x0090, B:37:0x0096, B:39:0x00a2, B:42:0x00a8, B:44:0x00b4, B:78:0x0191, B:46:0x00be, B:48:0x00e3, B:50:0x00fc, B:61:0x0166, B:74:0x017c, B:76:0x0182, B:77:0x0185, B:71:0x0177, B:70:0x0174, B:41:0x00a6, B:108:0x0218, B:114:0x0229, B:120:0x0238, B:122:0x0256, B:125:0x025e, B:127:0x0265, B:129:0x026f, B:131:0x0285, B:133:0x0295, B:134:0x02a3, B:135:0x02b2, B:137:0x02ba, B:139:0x02d9, B:138:0x02d6, B:177:0x0328, B:146:0x02eb), top: B:203:0x0038, outer: #7, inners: #1, #4, #6, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0209 A[DONT_INVERT] */
    public final void i() {
        em emVar;
        bw bwVar;
        Iterator it2;
        es esVar;
        int i;
        er erVar;
        Bitmap bitmap;
        es esVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        bv bvVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        boolean z;
        int width;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        byte[] bArr;
        byte[] bArr2;
        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlas2.uploadPendingBlocks");
        try {
            ea eaVar = ea.INVALID;
            synchronized (this.d) {
                en enVar = this.d;
                emVar = new em(enVar.b, enVar.c, (jn) enVar.a.set(enVar.d, new jn()));
                enVar.d = (enVar.d + 1) % enVar.a.size();
            }
            synchronized (this.e) {
                if (emVar.a) {
                    es esVar3 = this.e;
                    bv bvVar2 = esVar3.b;
                    if (bvVar2 != null) {
                        int i12 = 0;
                        while (true) {
                            bw[] bwVarArr = esVar3.e;
                            if (i12 >= bwVarArr.length) {
                                break;
                            }
                            if (bwVarArr[i12].b()) {
                                bvVar2.m(esVar3.e[i12]);
                                esVar3.e[i12] = bw.a;
                                esVar3.h[i12] = 0;
                            }
                            i12++;
                        }
                    }
                    if (dVarB2 != null) {
                        Trace.endSection();
                        return;
                    }
                    return;
                }
                es esVar4 = this.e;
                int i13 = emVar.b;
                esVar4.d = (esVar4.d + 1) % esVar4.e.length;
                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlasUploadManager.bindForUpload");
                try {
                    bv bvVar3 = esVar4.b;
                    if (bvVar3 == null) {
                        if (dVarB3 != null) {
                            Trace.endSection();
                        }
                        it2 = emVar.iterator();
                        while (it2.hasNext()) {
                            jh jhVarB = ((jd) it2).next();
                            erVar = (er) jhVarB.getKey();
                            bitmap = (Bitmap) jhVarB.getValue();
                            bitmap.isRecycled();
                            Trace.setCounter("texelBytes", bitmap.getWidth() * bitmap.getHeight() * 4);
                            esVar2 = this.e;
                            i2 = erVar.b;
                            i3 = erVar.c;
                            int i14 = erVar.f;
                            int i15 = erVar.g;
                            i4 = erVar.j;
                            i5 = erVar.k;
                            bvVar = esVar2.b;
                            if (bvVar == null && esVar2.i > 0 && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && (bitmap.getWidth() + i4) - i5 <= i14 && (bitmap.getHeight() + i4) - i5 <= i15) {
                                dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlasUploadManager.upload");
                                if (i2 >= i5) {
                                    if (dVarB != null) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    i2 -= i5;
                                } else if (dVarB != null) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (i3 >= i5) {
                                    i3 -= i5;
                                }
                                try {
                                    if (bitmap.getWidth() + i2 > esVar2.f) {
                                        if (true != z) {
                                            Trace.endSection();
                                        }
                                    } else if (bitmap.getHeight() + i3 <= esVar2.g) {
                                        if (i4 > 0) {
                                            width = bitmap.getWidth();
                                            i6 = width + 2;
                                            height = bitmap.getHeight();
                                            i7 = height + 2;
                                            i8 = i2 - 1;
                                            i9 = i3 - 1;
                                            int width2 = i2 + bitmap.getWidth();
                                            int height2 = i3 + bitmap.getHeight();
                                            if (i2 <= 0) {
                                                i6 = width + 1;
                                                i10 = i2;
                                            } else {
                                                i10 = i8;
                                            }
                                            if (i3 <= 0) {
                                                i7 = height + 1;
                                                i11 = i3;
                                            } else {
                                                i11 = i9;
                                            }
                                            bArr = new byte[Math.max(i6, i7) * 4];
                                            if (i3 > 0) {
                                                bArr2 = bArr;
                                                bvVar.W(i10, i11, i6, 1, bArr2);
                                            } else {
                                                bArr2 = bArr;
                                            }
                                            bvVar.W(i10, height2, i6, 1, bArr2);
                                            if (i2 > 0) {
                                                bvVar.W(i10, i11, 1, i7, bArr2);
                                            }
                                            bvVar.W(width2, i11, 1, i7, bArr2);
                                        }
                                        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                                            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                                            bv.X(i2, i3, bitmapCreateBitmap);
                                        } else {
                                            bv.X(i2, i3, bitmap);
                                        }
                                        esVar2.j++;
                                        if (true != z) {
                                            Trace.endSection();
                                        }
                                    } else if (true != z) {
                                        Trace.endSection();
                                    }
                                } catch (Throwable th) {
                                    if (true == z) {
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
                            synchronized (this.d) {
                                this.d.a(erVar);
                            }
                        }
                        esVar = this.e;
                        if (esVar.b == null && (i = esVar.i) != 0) {
                            if (i > 1) {
                                esVar.i = i - 1;
                            } else {
                                esVar.i = 0;
                            }
                        }
                        Trace.setCounter("texelBytes", 0);
                        if (dVarB2 != null) {
                            Trace.endSection();
                            return;
                        }
                        return;
                    }
                    int i16 = esVar4.i;
                    if (i16 != 0) {
                        esVar4.i = i16 + 1;
                        if (dVarB3 != null) {
                            Trace.endSection();
                        }
                        it2 = emVar.iterator();
                        while (it2.hasNext()) {
                            jh jhVarB2 = ((jd) it2).next();
                            erVar = (er) jhVarB2.getKey();
                            bitmap = (Bitmap) jhVarB2.getValue();
                            bitmap.isRecycled();
                            Trace.setCounter("texelBytes", bitmap.getWidth() * bitmap.getHeight() * 4);
                            esVar2 = this.e;
                            i2 = erVar.b;
                            i3 = erVar.c;
                            int i17 = erVar.f;
                            int i18 = erVar.g;
                            i4 = erVar.j;
                            i5 = erVar.k;
                            bvVar = esVar2.b;
                            if (bvVar == null) {
                                dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlasUploadManager.upload");
                                if (i2 >= i5) {
                                    if (dVarB != null) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    i2 -= i5;
                                } else if (dVarB != null) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (i3 >= i5) {
                                    i3 -= i5;
                                }
                                if (bitmap.getWidth() + i2 > esVar2.f) {
                                    if (true != z) {
                                        Trace.endSection();
                                    }
                                } else if (bitmap.getHeight() + i3 <= esVar2.g) {
                                    if (i4 > 0) {
                                        width = bitmap.getWidth();
                                        i6 = width + 2;
                                        height = bitmap.getHeight();
                                        i7 = height + 2;
                                        i8 = i2 - 1;
                                        i9 = i3 - 1;
                                        int width3 = i2 + bitmap.getWidth();
                                        int height3 = i3 + bitmap.getHeight();
                                        if (i2 <= 0) {
                                            i6 = width + 1;
                                            i10 = i2;
                                        } else {
                                            i10 = i8;
                                        }
                                        if (i3 <= 0) {
                                            i7 = height + 1;
                                            i11 = i3;
                                        } else {
                                            i11 = i9;
                                        }
                                        bArr = new byte[Math.max(i6, i7) * 4];
                                        if (i3 > 0) {
                                            bArr2 = bArr;
                                            bvVar.W(i10, i11, i6, 1, bArr2);
                                        } else {
                                            bArr2 = bArr;
                                        }
                                        bvVar.W(i10, height3, i6, 1, bArr2);
                                        if (i2 > 0) {
                                            bvVar.W(i10, i11, 1, i7, bArr2);
                                        }
                                        bvVar.W(width3, i11, 1, i7, bArr2);
                                    }
                                    if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                                        new Canvas(bitmapCreateBitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                                        bv.X(i2, i3, bitmapCreateBitmap2);
                                    } else {
                                        bv.X(i2, i3, bitmap);
                                    }
                                    esVar2.j++;
                                    if (true != z) {
                                        Trace.endSection();
                                    }
                                } else if (true != z) {
                                    Trace.endSection();
                                }
                            }
                            synchronized (this.d) {
                                this.d.a(erVar);
                            }
                        }
                        esVar = this.e;
                        if (esVar.b == null) {
                            if (i > 1) {
                                esVar.i = i - 1;
                            } else {
                                esVar.i = 0;
                            }
                        }
                        Trace.setCounter("texelBytes", 0);
                        if (dVarB2 != null) {
                            Trace.endSection();
                            return;
                        }
                        return;
                    }
                    esVar4.i = 1;
                    if (!esVar4.e[0].b() || i13 > esVar4.g) {
                        esVar4.g = i13;
                    }
                    if (!esVar4.e[esVar4.d].b() || esVar4.h[esVar4.d] != esVar4.g) {
                        bw[] bwVarArr2 = esVar4.e;
                        int i19 = esVar4.d;
                        bw bwVar2 = bwVarArr2[i19];
                        int i20 = esVar4.h[i19];
                        bw bwVarE = bvVar3.e(esVar4.a + i19);
                        if (bwVarE.b()) {
                            bvVar3.D(bwVarE, esVar4.f, esVar4.g, 2, 1);
                            if (bwVar2.b()) {
                                int i21 = esVar4.f;
                                com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlasUploadManager.copyTexture");
                                try {
                                    com.google.android.libraries.navigation.internal.yx.ar.k(bwVar2.b());
                                    com.google.android.libraries.navigation.internal.yx.ar.k(bwVarE.b());
                                    int[] iArr = bvVar3.k;
                                    iArr[0] = 0;
                                    GLES20.glGenFramebuffers(1, iArr, 0);
                                    int i22 = bvVar3.k[0];
                                    com.google.android.libraries.navigation.internal.yx.ar.k(i22 != -1);
                                    GLES20.glBindFramebuffer(36160, i22);
                                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, bwVar2.d, 0);
                                    bvVar3.o = i22;
                                    bwVar = bwVarE;
                                    bvVar3.B(1, bwVar);
                                    GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, i21, i20);
                                    GLES20.glBindFramebuffer(36160, 0);
                                    bvVar3.o = 0;
                                    com.google.android.libraries.navigation.internal.yx.ar.k(i22 != 0);
                                    int[] iArr2 = bvVar3.k;
                                    iArr2[0] = i22;
                                    GLES20.glDeleteFramebuffers(1, iArr2, 0);
                                    if (dVarB4 != null) {
                                        Trace.endSection();
                                    }
                                } catch (Throwable th3) {
                                    if (dVarB4 == null) {
                                        throw th3;
                                    }
                                    try {
                                        Trace.endSection();
                                        throw th3;
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                        throw th3;
                                    }
                                }
                            } else {
                                bwVar = bwVarE;
                            }
                        } else {
                            bwVar = bwVarE;
                        }
                        if (bwVar2.b()) {
                            bvVar3.m(bwVar2);
                        }
                        bw[] bwVarArr3 = esVar4.e;
                        int i23 = esVar4.d;
                        bwVarArr3[i23] = bwVar;
                        esVar4.h[i23] = esVar4.g;
                    }
                    bvVar3.B(1, esVar4.a());
                    if (dVarB3 != null) {
                        Trace.endSection();
                    }
                    it2 = emVar.iterator();
                    while (it2.hasNext()) {
                        jh jhVarB3 = ((jd) it2).next();
                        erVar = (er) jhVarB3.getKey();
                        bitmap = (Bitmap) jhVarB3.getValue();
                        bitmap.isRecycled();
                        Trace.setCounter("texelBytes", bitmap.getWidth() * bitmap.getHeight() * 4);
                        esVar2 = this.e;
                        i2 = erVar.b;
                        i3 = erVar.c;
                        int i110 = erVar.f;
                        int i111 = erVar.g;
                        i4 = erVar.j;
                        i5 = erVar.k;
                        bvVar = esVar2.b;
                        if (bvVar == null) {
                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TextureAtlasUploadManager.upload");
                            if (i2 >= i5) {
                                if (dVarB != null) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                i2 -= i5;
                            } else if (dVarB != null) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (i3 >= i5) {
                                i3 -= i5;
                            }
                            if (bitmap.getWidth() + i2 > esVar2.f) {
                                if (true != z) {
                                    Trace.endSection();
                                }
                            } else if (bitmap.getHeight() + i3 <= esVar2.g) {
                                if (i4 > 0) {
                                    width = bitmap.getWidth();
                                    i6 = width + 2;
                                    height = bitmap.getHeight();
                                    i7 = height + 2;
                                    i8 = i2 - 1;
                                    i9 = i3 - 1;
                                    int width4 = i2 + bitmap.getWidth();
                                    int height4 = i3 + bitmap.getHeight();
                                    if (i2 <= 0) {
                                        i6 = width + 1;
                                        i10 = i2;
                                    } else {
                                        i10 = i8;
                                    }
                                    if (i3 <= 0) {
                                        i7 = height + 1;
                                        i11 = i3;
                                    } else {
                                        i11 = i9;
                                    }
                                    bArr = new byte[Math.max(i6, i7) * 4];
                                    if (i3 > 0) {
                                        bArr2 = bArr;
                                        bvVar.W(i10, i11, i6, 1, bArr2);
                                    } else {
                                        bArr2 = bArr;
                                    }
                                    bvVar.W(i10, height4, i6, 1, bArr2);
                                    if (i2 > 0) {
                                        bvVar.W(i10, i11, 1, i7, bArr2);
                                    }
                                    bvVar.W(width4, i11, 1, i7, bArr2);
                                }
                                if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                                    Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                                    new Canvas(bitmapCreateBitmap3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                                    bv.X(i2, i3, bitmapCreateBitmap3);
                                } else {
                                    bv.X(i2, i3, bitmap);
                                }
                                esVar2.j++;
                                if (true != z) {
                                    Trace.endSection();
                                }
                            } else if (true != z) {
                                Trace.endSection();
                            }
                        }
                        synchronized (this.d) {
                            this.d.a(erVar);
                        }
                    }
                    esVar = this.e;
                    if (esVar.b == null) {
                        if (i > 1) {
                            esVar.i = i - 1;
                        } else {
                            esVar.i = 0;
                        }
                    }
                    Trace.setCounter("texelBytes", 0);
                    if (dVarB2 != null) {
                        Trace.endSection();
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    if (dVarB3 == null) {
                        throw th5;
                    }
                    try {
                        Trace.endSection();
                        throw th5;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                        throw th5;
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            if (dVarB2 == null) {
                throw th7;
            }
            try {
                Trace.endSection();
                throw th7;
            } catch (Throwable th8) {
                th7.addSuppressed(th8);
                throw th7;
            }
        }
    }

    public final eo j(int i, int i2, int i3) {
        int iA;
        synchronized (this.a) {
            el elVar = (el) this.c.h(i);
            boolean z = false;
            if (elVar != null) {
                com.google.android.libraries.navigation.internal.yx.ar.k(elVar.a.l != -1);
                com.google.android.libraries.navigation.internal.yx.ar.k(elVar.b > 0);
                iA = elVar.a.l;
            } else {
                iA = this.b.a(i2 + 1, i3 + 1);
            }
            if (iA < 0) {
                return new eo(iA, false);
            }
            int iD = this.b.d(iA);
            int iE = this.b.e(iA);
            if (iD > 0 && iE > 0) {
                z = true;
            }
            return new eo(iA, z);
        }
    }
}
