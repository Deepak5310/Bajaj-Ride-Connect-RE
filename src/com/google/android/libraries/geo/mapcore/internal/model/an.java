package com.google.android.libraries.geo.mapcore.internal.model;

import android.util.SparseIntArray;
import androidx.tracing.Trace;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.libraries.navigation.internal.adg.el;
import com.google.android.libraries.navigation.internal.adg.en;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.he;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.adg.ii;
import com.google.android.libraries.navigation.internal.adg.ip;
import com.google.android.libraries.navigation.internal.adg.jp;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agh.du;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class an extends bv {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.model.an");
    private final com.google.android.libraries.navigation.internal.agg.bj b;
    private final com.google.android.libraries.navigation.internal.agg.bj e;
    private final com.google.android.libraries.navigation.internal.agg.bj f;
    private final com.google.android.libraries.navigation.internal.agg.bj g;
    private final com.google.android.libraries.navigation.internal.agg.bj h;
    private final du i;
    private final boolean j;
    private final a k;

    /* JADX INFO: compiled from: PG */
    final class a {
        public final com.google.android.libraries.navigation.internal.adh.c a;
        public final com.google.android.libraries.navigation.internal.adh.b b;
        public final byte[] c;
        public final byte[] d;

        public a(byte[] bArr, com.google.android.libraries.navigation.internal.adi.c cVar) {
            com.google.android.libraries.navigation.internal.adh.b bVar;
            com.google.android.libraries.navigation.internal.adh.e eVar;
            com.google.android.libraries.navigation.internal.adh.e eVar2;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LazyMultiZoomStyleTable.<init>");
            try {
                this.d = bArr;
                int iOrdinal = cVar.ordinal();
                com.google.android.libraries.navigation.internal.adh.c cVar2 = null;
                if (iOrdinal == 0) {
                    com.google.android.libraries.navigation.internal.adh.c cVar3 = new com.google.android.libraries.navigation.internal.adh.c(com.google.android.libraries.navigation.internal.ael.ar.b());
                    cVar3.o(bArr, bArr.length);
                    cVar2 = cVar3;
                    bVar = null;
                } else if (iOrdinal == 1 || iOrdinal == 2) {
                    bVar = new com.google.android.libraries.navigation.internal.adh.b(com.google.android.libraries.navigation.internal.ael.ar.b());
                    bVar.o(bArr, bArr.length);
                } else {
                    bVar = null;
                }
                if (cVar2 == null) {
                    com.google.android.libraries.navigation.internal.yx.ar.q(bVar);
                }
                this.a = cVar2;
                this.b = bVar;
                if (cVar2 != null) {
                    if (cVar2.d == null) {
                        cVar2.d = new com.google.android.libraries.navigation.internal.adh.e();
                    }
                    if (cVar2.b.e(0)) {
                        cVar2.d.b(cVar2.t, cVar2.b.b(0), cVar2.b.a(0));
                        eVar2 = cVar2.d;
                    } else {
                        cVar2.d.b(cVar2.t, 0, 0);
                        eVar2 = cVar2.d;
                    }
                    this.c = eVar2.toString().getBytes();
                } else {
                    com.google.android.libraries.navigation.internal.yx.ar.q(bVar);
                    if (bVar.p == null) {
                        bVar.p = new com.google.android.libraries.navigation.internal.adh.e();
                    }
                    if (bVar.b.e(2)) {
                        bVar.p.b(bVar.t, bVar.b.b(2), bVar.b.a(2));
                        eVar = bVar.p;
                    } else {
                        bVar.p.b(bVar.t, 0, 0);
                        eVar = bVar.p;
                    }
                    this.c = eVar.toString().getBytes();
                }
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

        public final synchronized int a(long j) {
            int i;
            int iBinarySearch;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("getGlobalStyleIdForNamedStyleIndex");
            try {
                com.google.android.libraries.navigation.internal.adh.b bVar = this.b;
                i = -1;
                try {
                    if (bVar != null) {
                        int iBinarySearch2 = Collections.binarySearch(new am(bVar), Integer.valueOf((int) j));
                        if (iBinarySearch2 >= 0) {
                            i = this.b.f(iBinarySearch2).c;
                        }
                    } else {
                        com.google.android.libraries.navigation.internal.adh.c cVar = this.a;
                        if (cVar != null && (iBinarySearch = Collections.binarySearch(new ap(cVar), Integer.valueOf((int) j))) >= 0) {
                            i = this.a.f(iBinarySearch).c;
                        }
                    }
                } catch (com.google.android.libraries.navigation.internal.ael.cc unused) {
                }
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
            return i;
        }

        public final int b(long j) {
            int iBinarySearch;
            com.google.android.libraries.navigation.internal.adh.b bVar = this.b;
            if (bVar != null) {
                int iBinarySearch2 = Collections.binarySearch(new al(bVar), Long.valueOf(j));
                if (iBinarySearch2 < 0 || this.b.e(iBinarySearch2) != j) {
                    return -1;
                }
                return iBinarySearch2;
            }
            com.google.android.libraries.navigation.internal.adh.c cVar = this.a;
            if (cVar == null || (iBinarySearch = Collections.binarySearch(new ao(cVar), Long.valueOf(j))) < 0 || this.a.e(iBinarySearch) != j) {
                return -1;
            }
            return iBinarySearch;
        }
    }

    public an() {
        this(new a(new byte[0], com.google.android.libraries.navigation.internal.adi.c.MULTIZOOM_STYLE_TABLE), false);
    }

    private final int l(int i) {
        return this.k.a(i);
    }

    /* JADX WARN: Code duplicated, block: B:140:0x03b6 A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x03be A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x03cf A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x03d7 A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x03e1 A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0408 A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x040d A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0411 A[Catch: cc -> 0x05c8, cc | IndexOutOfBoundsException -> 0x05ca, all -> 0x0634, TryCatch #7 {all -> 0x0634, blocks: (B:17:0x0075, B:19:0x008b, B:21:0x0093, B:230:0x05bf, B:250:0x05d9, B:268:0x064f, B:22:0x00ac, B:25:0x00b4, B:27:0x00c4, B:29:0x0105, B:31:0x010a, B:33:0x0116, B:35:0x0130, B:34:0x0121, B:37:0x0136, B:39:0x013e, B:40:0x0156, B:42:0x015d, B:44:0x0167, B:46:0x016f, B:50:0x0178, B:54:0x0194, B:56:0x01af, B:57:0x01b1, B:59:0x01bb, B:60:0x01bd, B:62:0x01c7, B:63:0x01c9, B:65:0x01d0, B:67:0x01d6, B:69:0x0206, B:71:0x020e, B:73:0x0212, B:75:0x0234, B:77:0x023a, B:78:0x0242, B:80:0x0246, B:81:0x024e, B:83:0x0252, B:84:0x025a, B:86:0x025e, B:87:0x0266, B:89:0x026a, B:91:0x0277, B:93:0x027e, B:96:0x02d5, B:97:0x02d8, B:99:0x02de, B:101:0x02ee, B:103:0x0304, B:102:0x02f7, B:105:0x0309, B:107:0x030f, B:108:0x0325, B:109:0x032b, B:110:0x032f, B:112:0x0335, B:114:0x035d, B:116:0x036d, B:118:0x0371, B:119:0x0373, B:121:0x037d, B:122:0x037f, B:124:0x0387, B:126:0x038b, B:127:0x038d, B:138:0x03ae, B:140:0x03b6, B:143:0x03c6, B:145:0x03cf, B:147:0x03d7, B:155:0x0416, B:157:0x0426, B:159:0x042c, B:160:0x0434, B:162:0x0438, B:163:0x0440, B:165:0x0444, B:166:0x044c, B:168:0x0450, B:170:0x0458, B:171:0x045a, B:172:0x045c, B:174:0x0463, B:176:0x046d, B:192:0x04f7, B:194:0x0501, B:196:0x0509, B:197:0x050b, B:198:0x050d, B:200:0x0515, B:201:0x051b, B:203:0x0521, B:205:0x0529, B:206:0x052b, B:208:0x052f, B:210:0x0537, B:211:0x0539, B:213:0x0540, B:215:0x0546, B:217:0x057a, B:219:0x057f, B:221:0x058c, B:222:0x0591, B:223:0x0594, B:225:0x059a, B:226:0x059e, B:227:0x05a1, B:177:0x0479, B:178:0x04a4, B:180:0x04ac, B:181:0x04b8, B:182:0x04c4, B:184:0x04cc, B:186:0x04d0, B:187:0x04d2, B:188:0x04db, B:190:0x04e3, B:191:0x04ef, B:148:0x03e1, B:149:0x0408, B:151:0x040d, B:153:0x0411, B:154:0x0413, B:142:0x03be, B:129:0x0395, B:131:0x0399, B:132:0x039b, B:134:0x03a1, B:135:0x03a3, B:136:0x03aa, B:156:0x041c, B:70:0x020b, B:45:0x016c, B:41:0x0159, B:228:0x05b5, B:253:0x05f2, B:258:0x0622, B:259:0x0625, B:256:0x05fa, B:267:0x063a), top: B:290:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x0653 A[Catch: all -> 0x0668, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0005, B:270:0x0653, B:282:0x0667, B:281:0x0664, B:277:0x065e), top: B:289:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:287:0x065e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:? A[Catch: all -> 0x0668, SYNTHETIC, TryCatch #1 {, blocks: (B:4:0x0005, B:270:0x0653, B:282:0x0667, B:281:0x0664, B:277:0x065e), top: B:289:0x0005, inners: #0 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final synchronized bt m(long j) {
        Throwable th;
        com.google.android.libraries.navigation.internal.nw.d dVar;
        ga gaVar;
        bt btVarJ;
        long j2;
        SparseIntArray sparseIntArrayG;
        com.google.android.libraries.navigation.internal.agg.bj bjVar;
        com.google.android.libraries.navigation.internal.agg.bj bjVar2;
        ab abVarB;
        int i;
        com.google.android.libraries.navigation.internal.adg.p pVar;
        int i2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("getStyleEntryLazily");
        try {
            a aVar = this.k;
            try {
                if (aVar.b != null) {
                    int iB = aVar.b(j);
                    if (iB < 0) {
                        try {
                            btVarJ = c;
                            dVar = dVarB;
                        } catch (Throwable th2) {
                            th = th2;
                            if (dVarB != null) {
                                throw th;
                            }
                            try {
                                Trace.endSection();
                                throw th;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th;
                            }
                        }
                    } else {
                        try {
                            com.google.android.libraries.navigation.internal.adh.b bVar = this.k.b;
                            com.google.android.libraries.navigation.internal.yx.ar.q(bVar);
                            bu buVar = new bu(this.j);
                            com.google.android.libraries.navigation.internal.agg.bj bjVar3 = this.b;
                            com.google.android.libraries.navigation.internal.agg.bj bjVar4 = this.e;
                            com.google.android.libraries.navigation.internal.agg.bj bjVar5 = this.f;
                            com.google.android.libraries.navigation.internal.agg.bj bjVar6 = this.g;
                            com.google.android.libraries.navigation.internal.adg.bq bqVar = (com.google.android.libraries.navigation.internal.adg.bq) ((dg) com.google.android.libraries.navigation.internal.adg.bq.a.aH(7, null)).j(bVar.t, bVar.c.b(iB), bVar.c.a(iB), bVar.a);
                            if ((bqVar.b & 2) != 0) {
                                int i3 = bqVar.e;
                                dVar = dVarB;
                                try {
                                    sparseIntArrayG = bv.g((ii) ((dg) ii.a.aH(7, null)).j(bVar.t, bVar.i.b(i3), bVar.i.a(i3), bVar.a));
                                } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                                    e = e;
                                    j2 = j;
                                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1079)).v("getStyleEntryLazily: Error in parsing CompactMultiZoomStyle with id: %s %s", j2, e);
                                    btVarJ = c;
                                    if (dVar != null) {
                                        Trace.endSection();
                                    }
                                    return btVarJ;
                                } catch (IndexOutOfBoundsException e2) {
                                    e = e2;
                                    j2 = j;
                                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1079)).v("getStyleEntryLazily: Error in parsing CompactMultiZoomStyle with id: %s %s", j2, e);
                                    btVarJ = c;
                                    if (dVar != null) {
                                        Trace.endSection();
                                    }
                                    return btVarJ;
                                }
                            } else {
                                dVar = dVarB;
                                sparseIntArrayG = null;
                            }
                            int size = bqVar.d.size();
                            if (size <= 0) {
                                j2 = j;
                                btVarJ = new bt(bqVar.c, null, null, sparseIntArrayG, buVar.c);
                            } else {
                                buVar.c(size);
                                ah ahVar = buVar.a;
                                int i4 = 0;
                                while (i4 < size) {
                                    try {
                                        com.google.android.libraries.navigation.internal.adg.bo boVar = (com.google.android.libraries.navigation.internal.adg.bo) bqVar.d.get(i4);
                                        int i5 = size;
                                        if ((boVar.b & 2) != 0) {
                                            int i6 = boVar.d;
                                            com.google.android.libraries.navigation.internal.adg.ba baVar = (com.google.android.libraries.navigation.internal.adg.ba) ((dg) com.google.android.libraries.navigation.internal.adg.ba.a.aH(7, null)).j(bVar.t, bVar.d.b(i6), bVar.d.a(i6), bVar.a);
                                            buVar.b = baVar.g;
                                            int size2 = baVar.c.size() + baVar.d.size();
                                            ahVar.b = baVar.h;
                                            ahVar.z = baVar.e;
                                            if (size2 > 0) {
                                                bs[] bsVarArr = new bs[size2];
                                                int i7 = 0;
                                                while (i7 < size2) {
                                                    int iD = baVar.d.d(i7);
                                                    if (bjVar3.c(iD)) {
                                                        bsVarArr[i7] = (bs) bjVar3.p(iD);
                                                    } else {
                                                        bs bsVarA = bs.a(bVar.g(iD), bVar);
                                                        bsVarArr[i7] = bsVarA;
                                                        bjVar3.a(iD, bsVarA);
                                                    }
                                                    i7++;
                                                    size2 = size2;
                                                }
                                                for (int i8 = 0; i8 < baVar.c.size(); i8++) {
                                                    bsVarArr[baVar.d.size() + i8] = bs.a((id) baVar.c.get(i8), bVar);
                                                }
                                                ahVar.j = bsVarArr;
                                            } else {
                                                ahVar.j = ai.b;
                                            }
                                            ahVar.a = baVar.i;
                                            int i9 = baVar.b;
                                            if ((i9 & 2) != 0) {
                                                ahVar.g = baVar.f;
                                            } else {
                                                ahVar.g = 0;
                                            }
                                            String strA = cm.a(baVar.j, (i9 & 64) != 0, baVar.k, bVar);
                                            com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP;
                                            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
                                            ahVar.A = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(strA, oVar);
                                            ahVar.C = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(cm.a(baVar.l, (baVar.b & 256) != 0, baVar.m, bVar), com.google.android.libraries.geo.mapcore.internal.vector.gl.o.WRAP_T);
                                            ahVar.B = boVar.c;
                                            int iA = com.google.android.libraries.navigation.internal.adg.az.a(baVar.f180n);
                                            if (iA == 0) {
                                                iA = com.google.android.libraries.navigation.internal.adg.az.a;
                                            }
                                            ahVar.T = iA;
                                            int iA2 = com.google.android.libraries.navigation.internal.adg.av.a(baVar.o);
                                            if (iA2 == 0) {
                                                iA2 = com.google.android.libraries.navigation.internal.adg.av.a;
                                            }
                                            ahVar.U = iA2;
                                            int iA3 = com.google.android.libraries.navigation.internal.adg.ax.a(baVar.p);
                                            if (iA3 == 0) {
                                                iA3 = com.google.android.libraries.navigation.internal.adg.ax.a;
                                            }
                                            ahVar.V = iA3;
                                        }
                                        if ((boVar.b & 32) != 0) {
                                            int i10 = boVar.g;
                                            jp jpVar = (jp) ((dg) jp.a.aH(7, null)).j(bVar.t, bVar.g.b(i10), bVar.g.a(i10), bVar.a);
                                            buVar.b = jpVar.g;
                                            ahVar.d = jpVar.h;
                                            int i11 = jpVar.b;
                                            if ((i11 & 4) != 0) {
                                                ahVar.h = jpVar.e;
                                            } else {
                                                ahVar.h = 0;
                                            }
                                            if ((i11 & 1) != 0) {
                                                ahVar.l = new bs[]{new bs(jpVar.c, ay.a(jpVar.d), new int[0], 0.0f)};
                                            }
                                            int i12 = jpVar.b;
                                            if ((i12 & 8) != 0) {
                                                ahVar.N = jpVar.f;
                                                ahVar.N = jpVar.f;
                                            }
                                            if ((i12 & 128) != 0) {
                                                ahVar.O = Float.valueOf(jpVar.i);
                                            }
                                            if ((i12 & 256) != 0) {
                                                ahVar.P = Float.valueOf(jpVar.j);
                                            }
                                            if ((i12 & 1024) != 0) {
                                                ahVar.Q = Float.valueOf(jpVar.k);
                                            }
                                            if ((i12 & 2048) != 0) {
                                                ahVar.R = Float.valueOf(jpVar.l);
                                            }
                                        } else {
                                            bjVar5 = bjVar5;
                                            i4 = i4;
                                        }
                                        if ((boVar.b & 8) != 0) {
                                            int i13 = boVar.f;
                                            fk fkVar = (fk) ((dg) fk.a.aH(7, null)).j(bVar.t, bVar.f.b(i13), bVar.f.a(i13), bVar.a);
                                            buVar.b = fkVar.g;
                                            ArrayList arrayList = new ArrayList(4);
                                            ArrayList arrayList2 = new ArrayList(4);
                                            arrayList.addAll(fkVar.c);
                                            arrayList.addAll(fkVar.e);
                                            arrayList2.addAll(fkVar.d);
                                            arrayList2.addAll(fkVar.f);
                                            int size3 = arrayList.size() + arrayList2.size();
                                            ahVar.y = fkVar.m;
                                            if (fkVar.h || size3 <= 0) {
                                                ahVar.k = ai.b;
                                            } else {
                                                bs[] bsVarArr2 = new bs[size3];
                                                for (int i14 = 0; i14 < arrayList2.size(); i14++) {
                                                    int iIntValue = ((Integer) arrayList2.get(i14)).intValue();
                                                    if (bjVar3.c(iIntValue)) {
                                                        bsVarArr2[i14] = (bs) bjVar3.p(iIntValue);
                                                    } else {
                                                        bs bsVarA2 = bs.a(bVar.g(iIntValue), bVar);
                                                        bsVarArr2[i14] = bsVarA2;
                                                        bjVar3.a(iIntValue, bsVarA2);
                                                    }
                                                }
                                                for (int i15 = 0; i15 < arrayList.size(); i15++) {
                                                    bsVarArr2[fkVar.d.size() + i15] = bs.a((id) arrayList.get(i15), bVar);
                                                }
                                                bv.k(fkVar, bsVarArr2);
                                                ahVar.k = bsVarArr2;
                                            }
                                        }
                                        if ((boVar.b & 4) != 0) {
                                            int i16 = boVar.e;
                                            eo eoVar = (eo) ((dg) eo.a.aH(7, null)).j(bVar.t, bVar.e.b(i16), bVar.e.a(i16), bVar.a);
                                            boolean z = eoVar.l;
                                            ahVar.c = z;
                                            if (z) {
                                                buVar.b = 0;
                                                ahVar.f57n = null;
                                                ahVar.o = null;
                                                ahVar.p = null;
                                            } else {
                                                buVar.b = eoVar.i;
                                                ahVar.f57n = cb.j(eoVar);
                                                if ((eoVar.b & 32) != 0) {
                                                    ip ipVar = eoVar.h;
                                                    if (ipVar == null) {
                                                        ipVar = ip.b;
                                                    }
                                                    ahVar.o = bz.v(ipVar);
                                                    ip ipVar2 = eoVar.h;
                                                    if (ipVar2 == null) {
                                                        ipVar2 = ip.b;
                                                    }
                                                    if (ipVar2.r.size() <= 0) {
                                                        ip ipVar3 = eoVar.h;
                                                        if (ipVar3 == null) {
                                                            ipVar3 = ip.b;
                                                        }
                                                        if (ipVar3.s.size() > 0) {
                                                        }
                                                        if (eoVar.e.size() <= 0 || eoVar.f.size() > 0) {
                                                            abVarB = ab.b(eoVar.f, eoVar.e, bjVar4, bVar);
                                                        }
                                                        ahVar.p = abVarB;
                                                        i = eoVar.b;
                                                        if ((262144 & i) != 0) {
                                                            i2 = eoVar.u;
                                                            if (bjVar6.c(i2)) {
                                                                ahVar.a((com.google.android.libraries.navigation.internal.adg.p) bjVar6.p(i2));
                                                            } else {
                                                                com.google.android.libraries.navigation.internal.adg.p pVar2 = (com.google.android.libraries.navigation.internal.adg.p) ((dg) com.google.android.libraries.navigation.internal.adg.p.a.aH(7, null)).j(bVar.t, bVar.q.b(i2), bVar.q.a(i2), bVar.a);
                                                                ahVar.a(pVar2);
                                                                bjVar6.a(i2, pVar2);
                                                            }
                                                        } else if ((i & 131072) != 0) {
                                                            pVar = eoVar.t;
                                                            if (pVar == null) {
                                                                pVar = com.google.android.libraries.navigation.internal.adg.p.a;
                                                            }
                                                            ahVar.a(pVar);
                                                        }
                                                        ahVar.M = eoVar.v;
                                                    }
                                                    ip ipVar4 = eoVar.h;
                                                    if (ipVar4 == null) {
                                                        ipVar4 = ip.b;
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bq bqVar2 = ipVar4.s;
                                                    ip ipVar5 = eoVar.h;
                                                    if (ipVar5 == null) {
                                                        ipVar5 = ip.b;
                                                    }
                                                    abVarB = ab.b(bqVar2, ipVar5.r, bjVar4, bVar);
                                                    if (eoVar.e.size() <= 0) {
                                                        abVarB = ab.b(eoVar.f, eoVar.e, bjVar4, bVar);
                                                    } else {
                                                        abVarB = ab.b(eoVar.f, eoVar.e, bjVar4, bVar);
                                                    }
                                                    ahVar.p = abVarB;
                                                    i = eoVar.b;
                                                    if ((262144 & i) != 0) {
                                                        i2 = eoVar.u;
                                                        if (bjVar6.c(i2)) {
                                                            ahVar.a((com.google.android.libraries.navigation.internal.adg.p) bjVar6.p(i2));
                                                        } else {
                                                            com.google.android.libraries.navigation.internal.adg.p pVar3 = (com.google.android.libraries.navigation.internal.adg.p) ((dg) com.google.android.libraries.navigation.internal.adg.p.a.aH(7, null)).j(bVar.t, bVar.q.b(i2), bVar.q.a(i2), bVar.a);
                                                            ahVar.a(pVar3);
                                                            bjVar6.a(i2, pVar3);
                                                        }
                                                    } else if ((i & 131072) != 0) {
                                                        pVar = eoVar.t;
                                                        if (pVar == null) {
                                                            pVar = com.google.android.libraries.navigation.internal.adg.p.a;
                                                        }
                                                        ahVar.a(pVar);
                                                    }
                                                    ahVar.M = eoVar.v;
                                                } else {
                                                    ahVar.o = null;
                                                }
                                                abVarB = null;
                                                if (eoVar.e.size() <= 0) {
                                                    abVarB = ab.b(eoVar.f, eoVar.e, bjVar4, bVar);
                                                } else {
                                                    abVarB = ab.b(eoVar.f, eoVar.e, bjVar4, bVar);
                                                }
                                                ahVar.p = abVarB;
                                                i = eoVar.b;
                                                if ((262144 & i) != 0) {
                                                    i2 = eoVar.u;
                                                    if (bjVar6.c(i2)) {
                                                        ahVar.a((com.google.android.libraries.navigation.internal.adg.p) bjVar6.p(i2));
                                                    } else {
                                                        com.google.android.libraries.navigation.internal.adg.p pVar4 = (com.google.android.libraries.navigation.internal.adg.p) ((dg) com.google.android.libraries.navigation.internal.adg.p.a.aH(7, null)).j(bVar.t, bVar.q.b(i2), bVar.q.a(i2), bVar.a);
                                                        ahVar.a(pVar4);
                                                        bjVar6.a(i2, pVar4);
                                                    }
                                                } else if ((i & 131072) != 0) {
                                                    pVar = eoVar.t;
                                                    if (pVar == null) {
                                                        pVar = com.google.android.libraries.navigation.internal.adg.p.a;
                                                    }
                                                    ahVar.a(pVar);
                                                }
                                                ahVar.M = eoVar.v;
                                            }
                                            int i17 = eoVar.b;
                                            if ((i17 & 1024) != 0) {
                                                ahVar.q = ay.a(eoVar.m);
                                            }
                                            if ((i17 & 2048) != 0) {
                                                ahVar.r = ay.a(eoVar.f187n);
                                            }
                                            if ((i17 & 4096) != 0) {
                                                ahVar.s = ay.a(eoVar.o);
                                            }
                                            if ((i17 & 8192) != 0) {
                                                en enVarB = en.b(eoVar.p);
                                                if (enVarB == null) {
                                                    enVarB = en.SUBTITLE_ANNOTATE_UNKNOWN;
                                                }
                                                ahVar.F = enVarB;
                                            }
                                            int i18 = eoVar.b;
                                            if ((65536 & i18) != 0) {
                                                int i19 = eoVar.s;
                                                bjVar = bjVar5;
                                                if (bjVar.c(i19)) {
                                                    ahVar.G = (com.google.android.libraries.navigation.internal.adg.ak) bjVar.p(i19);
                                                    bjVar2 = bjVar3;
                                                } else {
                                                    bjVar2 = bjVar3;
                                                    com.google.android.libraries.navigation.internal.adg.ak akVar = (com.google.android.libraries.navigation.internal.adg.ak) ((dg) com.google.android.libraries.navigation.internal.adg.ak.a.aH(7, null)).j(bVar.t, bVar.k.b(i19), bVar.k.a(i19), bVar.a);
                                                    com.google.android.libraries.navigation.internal.adg.aj ajVar = (com.google.android.libraries.navigation.internal.adg.aj) com.google.android.libraries.navigation.internal.adg.ak.a.q();
                                                    for (int i20 = 0; i20 < akVar.b.size(); i20++) {
                                                        ajVar.c(akVar.b.d(i20));
                                                    }
                                                    com.google.android.libraries.navigation.internal.adg.ak akVar2 = (com.google.android.libraries.navigation.internal.adg.ak) ajVar.t();
                                                    ahVar.G = akVar2;
                                                    bjVar.a(i19, akVar2);
                                                }
                                            } else {
                                                bjVar = bjVar5;
                                                bjVar2 = bjVar3;
                                                if ((i18 & 16384) != 0) {
                                                    com.google.android.libraries.navigation.internal.adg.ak akVar3 = eoVar.q;
                                                    if (akVar3 == null) {
                                                        akVar3 = com.google.android.libraries.navigation.internal.adg.ak.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.adg.aj ajVar2 = (com.google.android.libraries.navigation.internal.adg.aj) com.google.android.libraries.navigation.internal.adg.ak.a.q();
                                                    for (int i21 = 0; i21 < akVar3.b.size(); i21++) {
                                                        ajVar2.c(akVar3.b.d(i21));
                                                    }
                                                    ahVar.G = (com.google.android.libraries.navigation.internal.adg.ak) ajVar2.t();
                                                }
                                            }
                                            ahVar.H = eoVar.r;
                                            if ((eoVar.b & 128) != 0) {
                                                com.google.android.libraries.navigation.internal.adg.b bVarB = com.google.android.libraries.navigation.internal.adg.b.b(eoVar.j);
                                                if (bVarB == null) {
                                                    bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
                                                }
                                                ahVar.I = bVarB;
                                            }
                                            if (eoVar.w.size() > 0) {
                                                ahVar.J = ak.a(eoVar);
                                            }
                                            if ((eoVar.b & 256) != 0) {
                                                el elVarB = el.b(eoVar.k);
                                                if (elVarB == null) {
                                                    elVarB = el.PROJECTION_SCREEN_ALIGNED;
                                                }
                                                if (elVarB != el.UNKNOWN_PROJECTION_BEHAVIOR) {
                                                    el elVarB2 = el.b(eoVar.k);
                                                    if (elVarB2 == null) {
                                                        elVarB2 = el.PROJECTION_SCREEN_ALIGNED;
                                                    }
                                                    ahVar.K = elVarB2;
                                                }
                                            }
                                        } else {
                                            bjVar = bjVar5;
                                            bjVar2 = bjVar3;
                                        }
                                        if ((boVar.b & 64) != 0) {
                                            int i22 = boVar.h;
                                            he heVar = (he) ((dg) he.a.aH(7, null)).j(bVar.t, bVar.h.b(i22), bVar.h.a(i22), bVar.a);
                                            ahVar.e = heVar.d;
                                            buVar.b = heVar.c;
                                            if (heVar.b.size() == 20) {
                                                float[] fArr = new float[20];
                                                for (int i23 = 0; i23 < 20; i23++) {
                                                    float fD = heVar.b.d(i23);
                                                    fArr[i23] = fD;
                                                    if (i23 % 5 == 4) {
                                                        fArr[i23] = fD * 255.0f;
                                                    }
                                                }
                                                ahVar.u = fArr;
                                                if (heVar.d) {
                                                    Arrays.toString(fArr);
                                                }
                                            } else {
                                                ahVar.u = null;
                                            }
                                        }
                                        buVar.b(boVar.c);
                                        i4++;
                                        bjVar5 = bjVar;
                                        size = i5;
                                        sparseIntArrayG = sparseIntArrayG;
                                        bqVar = bqVar;
                                        bjVar3 = bjVar2;
                                    } catch (com.google.android.libraries.navigation.internal.ael.cc | IndexOutOfBoundsException e3) {
                                        e = e3;
                                        j2 = j;
                                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1079)).v("getStyleEntryLazily: Error in parsing CompactMultiZoomStyle with id: %s %s", j2, e);
                                        btVarJ = c;
                                        if (dVar != null) {
                                            Trace.endSection();
                                        }
                                        return btVarJ;
                                    }
                                }
                                btVarJ = buVar.a(bqVar.c, sparseIntArrayG);
                                j2 = j;
                            }
                            try {
                                f(j2, btVarJ);
                            } catch (com.google.android.libraries.navigation.internal.ael.cc e4) {
                                e = e4;
                                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1079)).v("getStyleEntryLazily: Error in parsing CompactMultiZoomStyle with id: %s %s", j2, e);
                                btVarJ = c;
                            } catch (IndexOutOfBoundsException e5) {
                                e = e5;
                                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1079)).v("getStyleEntryLazily: Error in parsing CompactMultiZoomStyle with id: %s %s", j2, e);
                                btVarJ = c;
                            }
                        } catch (com.google.android.libraries.navigation.internal.ael.cc | IndexOutOfBoundsException e6) {
                            e = e6;
                            dVar = dVarB;
                        }
                    }
                } else {
                    dVar = dVarB;
                    try {
                        int iB2 = aVar.b(j);
                        if (iB2 < 0) {
                            gaVar = null;
                        } else {
                            com.google.android.libraries.navigation.internal.adh.c cVar = aVar.a;
                            com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
                            gaVar = (ga) ((dg) ga.a.aH(7, null)).j(cVar.t, cVar.c.b(iB2), cVar.c.a(iB2), cVar.a);
                        }
                        if (gaVar == null) {
                            btVarJ = c;
                        } else {
                            btVarJ = j(gaVar, new bu(this.j));
                            f(j, btVarJ);
                        }
                    } catch (com.google.android.libraries.navigation.internal.ael.cc | IndexOutOfBoundsException e7) {
                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(PhotoshopDirectory.TAG_ONION_SKINS)).v("getStyleEntryLazily: Error in parsing MultiZoomStyle with id: %s %s", j, e7);
                        btVarJ = c;
                    }
                }
                if (dVar != null) {
                    Trace.endSection();
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (dVarB != null) {
                    throw th;
                }
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        return btVarJ;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final int a() {
        int i;
        synchronized (this.i) {
            i = this.i.k;
        }
        return i;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final bt b(int i) {
        bt btVar;
        synchronized (this) {
            if (!this.h.c(i)) {
                this.h.a(i, c(l(i)));
            }
            btVar = (bt) this.h.p(i);
        }
        return btVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final bt c(long j) {
        bt btVar;
        synchronized (this.i) {
            btVar = (bt) this.i.aO(j);
        }
        return btVar == null ? m(j) : btVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final bt d(int i, ez ezVar, bx bxVar) {
        return ezVar.isEmpty() ? b(i) : c(bxVar.a(l(i), ezVar));
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final byte[] e() {
        return this.k.c;
    }

    public final void f(long j, bt btVar) {
        synchronized (this.i) {
            this.i.a(j, btVar);
        }
    }

    public an(a aVar, boolean z) {
        this.b = new com.google.android.libraries.navigation.internal.agg.be();
        this.e = new com.google.android.libraries.navigation.internal.agg.be();
        this.f = new com.google.android.libraries.navigation.internal.agg.be();
        this.g = new com.google.android.libraries.navigation.internal.agg.be();
        this.h = new com.google.android.libraries.navigation.internal.agg.be();
        this.i = new du();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StyleEntryTable.<init>");
        try {
            this.k = aVar;
            this.j = z;
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
}
