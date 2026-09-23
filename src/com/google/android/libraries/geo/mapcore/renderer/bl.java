package com.google.android.libraries.geo.mapcore.renderer;

import android.os.Process;
import androidx.tracing.Trace;
import com.bajajconnect.wifi.NotificationUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bl extends Thread {
    final /* synthetic */ bo a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bo boVar, String str) {
        super(str);
        this.a = boVar;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x01fe A[Catch: all -> 0x037a, InterruptedException -> 0x038d, TryCatch #17 {InterruptedException -> 0x038d, all -> 0x037a, blocks: (B:13:0x0020, B:17:0x0032, B:129:0x01f5, B:130:0x01fe, B:133:0x0206, B:134:0x0229, B:135:0x022f, B:137:0x0233, B:140:0x023a, B:142:0x024a, B:152:0x0273, B:159:0x028d, B:143:0x024e, B:162:0x0294, B:165:0x02ab, B:167:0x02b2, B:169:0x02b9, B:170:0x02ca, B:172:0x02e0, B:174:0x02e4, B:177:0x02e9, B:179:0x02ef, B:183:0x02fd, B:189:0x030a, B:202:0x0336, B:206:0x0341, B:191:0x030e, B:194:0x0326, B:197:0x032c, B:200:0x0332, B:149:0x025c, B:150:0x025d, B:151:0x0264, B:225:0x0376, B:228:0x0379), top: B:271:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x028e  */
    /* JADX WARN: Code duplicated, block: B:162:0x0294 A[Catch: all -> 0x037a, InterruptedException -> 0x038d, TryCatch #17 {InterruptedException -> 0x038d, all -> 0x037a, blocks: (B:13:0x0020, B:17:0x0032, B:129:0x01f5, B:130:0x01fe, B:133:0x0206, B:134:0x0229, B:135:0x022f, B:137:0x0233, B:140:0x023a, B:142:0x024a, B:152:0x0273, B:159:0x028d, B:143:0x024e, B:162:0x0294, B:165:0x02ab, B:167:0x02b2, B:169:0x02b9, B:170:0x02ca, B:172:0x02e0, B:174:0x02e4, B:177:0x02e9, B:179:0x02ef, B:183:0x02fd, B:189:0x030a, B:202:0x0336, B:206:0x0341, B:191:0x030e, B:194:0x0326, B:197:0x032c, B:200:0x0332, B:149:0x025c, B:150:0x025d, B:151:0x0264, B:225:0x0376, B:228:0x0379), top: B:271:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x02b2 A[Catch: all -> 0x037a, InterruptedException -> 0x038d, TryCatch #17 {InterruptedException -> 0x038d, all -> 0x037a, blocks: (B:13:0x0020, B:17:0x0032, B:129:0x01f5, B:130:0x01fe, B:133:0x0206, B:134:0x0229, B:135:0x022f, B:137:0x0233, B:140:0x023a, B:142:0x024a, B:152:0x0273, B:159:0x028d, B:143:0x024e, B:162:0x0294, B:165:0x02ab, B:167:0x02b2, B:169:0x02b9, B:170:0x02ca, B:172:0x02e0, B:174:0x02e4, B:177:0x02e9, B:179:0x02ef, B:183:0x02fd, B:189:0x030a, B:202:0x0336, B:206:0x0341, B:191:0x030e, B:194:0x0326, B:197:0x032c, B:200:0x0332, B:149:0x025c, B:150:0x025d, B:151:0x0264, B:225:0x0376, B:228:0x0379), top: B:271:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x030e A[Catch: all -> 0x037a, InterruptedException -> 0x038d, TryCatch #17 {InterruptedException -> 0x038d, all -> 0x037a, blocks: (B:13:0x0020, B:17:0x0032, B:129:0x01f5, B:130:0x01fe, B:133:0x0206, B:134:0x0229, B:135:0x022f, B:137:0x0233, B:140:0x023a, B:142:0x024a, B:152:0x0273, B:159:0x028d, B:143:0x024e, B:162:0x0294, B:165:0x02ab, B:167:0x02b2, B:169:0x02b9, B:170:0x02ca, B:172:0x02e0, B:174:0x02e4, B:177:0x02e9, B:179:0x02ef, B:183:0x02fd, B:189:0x030a, B:202:0x0336, B:206:0x0341, B:191:0x030e, B:194:0x0326, B:197:0x032c, B:200:0x0332, B:149:0x025c, B:150:0x025d, B:151:0x0264, B:225:0x0376, B:228:0x0379), top: B:271:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0324  */
    /* JADX WARN: Code duplicated, block: B:196:0x032a  */
    /* JADX WARN: Code duplicated, block: B:199:0x0330  */
    /* JADX WARN: Code duplicated, block: B:204:0x033d  */
    /* JADX WARN: Code duplicated, block: B:205:0x033f  */
    /* JADX WARN: Code duplicated, block: B:212:0x035b A[Catch: all -> 0x0374, TRY_ENTER, TRY_LEAVE, TryCatch #11 {, blocks: (B:18:0x0033, B:20:0x0039, B:28:0x004b, B:30:0x0053, B:127:0x01f2, B:31:0x005e, B:33:0x0066, B:35:0x006d, B:37:0x0075, B:39:0x007c, B:43:0x008e, B:45:0x0094, B:46:0x0097, B:48:0x009d, B:50:0x00a3, B:52:0x00a9, B:53:0x00ac, B:54:0x00b7, B:56:0x00bd, B:58:0x00c3, B:60:0x00ca, B:61:0x00d2, B:63:0x00d8, B:65:0x00de, B:88:0x0163, B:109:0x01b3, B:108:0x01b0, B:110:0x01b4, B:112:0x01ba, B:114:0x01be, B:115:0x01c2, B:117:0x01c6, B:119:0x01cc, B:120:0x01d9, B:123:0x01e8, B:209:0x0350, B:212:0x035b, B:222:0x0373, B:221:0x0370, B:41:0x0082, B:210:0x0356, B:66:0x00e4, B:68:0x00fb, B:70:0x010c, B:72:0x011a, B:74:0x0126, B:75:0x012e, B:77:0x0132, B:79:0x013c, B:82:0x014d, B:84:0x0151, B:86:0x0157, B:91:0x0169, B:92:0x0185, B:81:0x0142, B:93:0x0186, B:94:0x018d, B:95:0x018e, B:96:0x0195, B:97:0x0196, B:98:0x019d, B:99:0x019e, B:100:0x01a5, B:217:0x036a, B:104:0x01aa), top: B:263:0x0033, inners: #0, #1, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:279:0x02b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:0x02ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x01f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x02a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x02ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x02b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x035e A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v74, types: [com.google.android.libraries.geo.mapcore.renderer.bk] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.google.android.libraries.geo.mapcore.renderer.ag, com.google.android.libraries.geo.mapcore.renderer.ah, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        ?? r4;
        ?? r6;
        ?? r0;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ?? r10;
        int i;
        int i2;
        Runnable runnable;
        ?? r14;
        boolean z6;
        ?? r1;
        ?? r16;
        boolean z7;
        boolean z8;
        ?? r17;
        boolean z9;
        bk bkVar;
        ag agVar;
        Object obj;
        Object obj2;
        Object obj3;
        du duVar;
        dv dvVar;
        int iA;
        ag agVar2;
        ?? r15;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        boolean z10;
        boolean z11;
        ?? r11;
        ?? r7;
        ?? r2;
        bo boVar = this.a;
        try {
            synchronized (boVar) {
                Process.setThreadPriority(boVar.d);
                z = true;
                try {
                    synchronized (boVar) {
                        bk bkVar2 = boVar.k;
                        r4 = 0;
                        bkVar2.b = false;
                        bkVar2.c = false;
                    }
                    if (runnable != null) {
                        runnable.run();
                        r16 = r1;
                        z7 = z6;
                    } else {
                        Object obj4 = boVar.h.b;
                        if (z3 || obj4 == null) {
                            r17 = r1;
                            z9 = z6;
                        } else {
                            bk bkVar3 = boVar.k;
                            ag agVar3 = bkVar3.a;
                            com.google.android.libraries.navigation.internal.yx.ar.q(agVar3);
                            du duVar2 = bkVar3.e;
                            com.google.android.libraries.navigation.internal.yx.ar.q(duVar2);
                            ?? r18 = r1;
                            ds dsVar = bkVar3.f;
                            com.google.android.libraries.navigation.internal.yx.ar.q(dsVar);
                            dt dtVar = bkVar3.g;
                            com.google.android.libraries.navigation.internal.yx.ar.q(dtVar);
                            bkVar3.a();
                            boolean z12 = z6;
                            try {
                                bkVar3.h = agVar3.f(duVar2, dsVar, obj4, new int[]{12344});
                                dv dvVar2 = bkVar3.h;
                                if (dvVar2 == null || dvVar2 == agVar3.g()) {
                                    bkVar3.h = null;
                                    agVar3.a();
                                } else {
                                    dv dvVar3 = bkVar3.h;
                                    com.google.android.libraries.navigation.internal.yx.ar.q(dvVar3);
                                    dv dvVar4 = bkVar3.h;
                                    com.google.android.libraries.navigation.internal.yx.ar.q(dvVar4);
                                    if (agVar3.j(duVar2, dvVar3, dvVar4, dtVar)) {
                                        synchronized (boVar) {
                                            boVar.j.b = true;
                                            boVar.notifyAll();
                                        }
                                        z3 = false;
                                        r17 = r18;
                                        z9 = z12;
                                    } else {
                                        agVar3.a();
                                    }
                                }
                            } catch (IllegalArgumentException unused) {
                                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1342)).p("Could not create window surface.");
                            }
                            synchronized (boVar) {
                                boVar.j.b = true;
                                boVar.k.d = true;
                                boVar.notifyAll();
                                r16 = r18;
                                z7 = z12;
                            }
                        }
                        if (z4) {
                            agVar2 = boVar.k.a;
                            com.google.android.libraries.navigation.internal.yx.ar.r(agVar2, "Trying to call onSurfaceCreated but EGL hasn't been initialized");
                            if (agVar2.c() == agVar2.d()) {
                                r0 = 1;
                                z8 = z9;
                                z2 = z8;
                                z = true;
                                r4 = 0;
                            } else {
                                boVar.g.e();
                            }
                        }
                        if (z5) {
                            boVar.g.d(i, i2);
                        }
                        if (r14 != 0) {
                            boVar.g.j();
                            r0 = r17;
                            z2 = z9;
                            z = true;
                            r4 = 0;
                            z4 = false;
                            z5 = false;
                        } else {
                            boVar.e.set(true);
                            boVar.g.m();
                            boVar.g.c();
                            bkVar = boVar.k;
                            agVar = bkVar.a;
                            if (agVar != null || (duVar = bkVar.e) == null || (dvVar = bkVar.h) == null) {
                                com.google.android.libraries.navigation.internal.zb.h hVar = (com.google.android.libraries.navigation.internal.zb.h) bo.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(NotificationUtils.NOTIFICATION_ID);
                                obj = bkVar.a;
                                if (obj == null) {
                                    obj = "<null>";
                                }
                                obj2 = bkVar.e;
                                if (obj2 == null) {
                                    obj2 = "<null>";
                                }
                                obj3 = bkVar.h;
                                if (obj3 == null) {
                                    obj3 = "<null>";
                                }
                                hVar.y("swap() called without a valid egl / display / surface - %s %s %s", obj, obj2, obj3);
                            } else {
                                if (!agVar.k(duVar, dvVar) && (iA = bkVar.a.a()) != 12288) {
                                    if (iA != 12302) {
                                        synchronized (boVar) {
                                            boVar.k.d = true;
                                            boVar.notifyAll();
                                        }
                                    }
                                    boVar.g.b();
                                    if (r10 != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = z9;
                                    }
                                    boVar.e.set(false);
                                    r4 = 0;
                                    z4 = false;
                                    z5 = false;
                                    z = true;
                                }
                                r0 = r17;
                                boVar.g.b();
                                if (r10 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z9;
                                }
                                boVar.e.set(false);
                                r4 = 0;
                                z4 = false;
                                z5 = false;
                                z = true;
                            }
                            r0 = 1;
                            boVar.g.b();
                            if (r10 != 0) {
                                z2 = true;
                            } else {
                                z2 = z9;
                            }
                            boVar.e.set(false);
                            r4 = 0;
                            z4 = false;
                            z5 = false;
                            z = true;
                        }
                    }
                    r0 = r16;
                    z8 = z7;
                    z2 = z8;
                    z = true;
                    r4 = 0;
                } catch (InterruptedException unused2) {
                    synchronized (boVar) {
                        boVar.n();
                        boVar.m();
                        boVar.b = true;
                        boVar.notifyAll();
                        return;
                    }
                } catch (Throwable th) {
                    synchronized (boVar) {
                        boVar.n();
                        boVar.m();
                        boVar.b = true;
                        boVar.notifyAll();
                        throw th;
                    }
                }
            }
            while (true) {
                synchronized (boVar) {
                    while (true) {
                        if (!boVar.i.d) {
                            if (!boVar.f.isEmpty()) {
                                runnable = (Runnable) boVar.f.remove(r4);
                                r14 = r4;
                                r1 = r0;
                                z6 = z2;
                                r6 = r6;
                                r10 = r10;
                                break;
                            }
                            boolean z13 = boVar.c;
                            boolean z14 = boVar.i.b;
                            if (z13 != z14) {
                                boVar.c = z14;
                                boVar.notifyAll();
                                r15 = z14;
                            } else {
                                r15 = r4;
                            }
                            int i3 = boVar.i.a;
                            if (i3 != boVar.d) {
                                boVar.d = i3;
                                Process.setThreadPriority(i3);
                            }
                            if (r0 != 0 || boVar.i.f) {
                                boVar.n();
                                boVar.m();
                                boVar.i.f = r4;
                            }
                            if (r15 != 0 && boVar.k.c) {
                                boVar.n();
                            }
                            if (!boVar.h.a && !boVar.j.a) {
                                if (boVar.k.c) {
                                    boVar.n();
                                }
                                boVar.j.a = z;
                                boVar.k.d = r4;
                                boVar.notifyAll();
                            }
                            if (boVar.h.a) {
                                bn bnVar = boVar.j;
                                if (bnVar.a) {
                                    bnVar.a = r4;
                                    boVar.notifyAll();
                                }
                            }
                            if (z2) {
                                boVar.j.c = z;
                                boVar.notifyAll();
                                r10 = r4;
                            }
                            r6 = r6;
                            if (!boVar.p()) {
                                if (r6 != 0 && boVar.o()) {
                                    z10 = z;
                                    ?? r3 = r4;
                                    z11 = r3 == true ? 1 : 0;
                                    r2 = r3;
                                    r7 = r6;
                                    r11 = r10;
                                    runnable = null;
                                    r1 = r2;
                                    z6 = z11;
                                    r6 = r7;
                                    r10 = r11;
                                    r14 = z10;
                                    break;
                                }
                                ?? r5 = r4;
                                dVarB = com.google.android.libraries.navigation.internal.nw.e.b("waitForFrame");
                                try {
                                    boVar.wait();
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    r0 = r5 == true ? 1 : 0;
                                    r4 = r0 == true ? 1 : 0;
                                    z2 = r4 == true ? 1 : 0;
                                    z = true;
                                } catch (Throwable th2) {
                                    if (dVarB == null) {
                                        throw th2;
                                    }
                                    try {
                                        Trace.endSection();
                                        throw th2;
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                        throw th2;
                                    }
                                }
                            } else {
                                if (!boVar.k.b) {
                                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GLViewThreadImpl.getEglContext");
                                    try {
                                        ?? r8 = boVar.k;
                                        ?? A = boVar.g.a().a();
                                        boVar.g.n();
                                        r8.a = A;
                                        if (r8.a == null) {
                                            throw new RuntimeException("EGLContext.getEGL failed");
                                        }
                                        com.google.android.libraries.navigation.internal.yx.ar.q(A);
                                        r8.e = A.n();
                                        if (r8.e == A.e()) {
                                            throw new RuntimeException("eglGetDisplay failed");
                                        }
                                        du duVar3 = r8.e;
                                        com.google.android.libraries.navigation.internal.yx.ar.q(duVar3);
                                        if (!A.i(duVar3, new int[2])) {
                                            throw new RuntimeException("eglInitialize failed");
                                        }
                                        r8.f = r8.b(8, 8, 8);
                                        if (r8.f == null) {
                                            r8.f = r8.b(5, 6, 5);
                                        }
                                        ds dsVar2 = r8.f;
                                        if (dsVar2 == null) {
                                            throw new IllegalArgumentException("eglChooseConfig failed");
                                        }
                                        r8.g = r8.c(A, dsVar2);
                                        dt dtVar2 = r8.g;
                                        if (dtVar2 == null || dtVar2 == A.d()) {
                                            ds dsVar3 = r8.f;
                                            com.google.android.libraries.navigation.internal.yx.ar.q(dsVar3);
                                            r8.g = r8.c(A, dsVar3);
                                        }
                                        dt dtVar3 = r8.g;
                                        if (dtVar3 == null || dtVar3 == A.d()) {
                                            r8.g = null;
                                            throw new AssertionError("eglCreateContext failed, error " + A.a());
                                        }
                                        r8.h = null;
                                        boVar.k.b = z;
                                        boVar.notifyAll();
                                        if (dVarB2 != null) {
                                            Trace.endSection();
                                        }
                                        z4 = z;
                                    } catch (Throwable th4) {
                                        if (dVarB2 == null) {
                                            throw th4;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th4;
                                        } catch (Throwable th5) {
                                            th4.addSuppressed(th5);
                                            throw th4;
                                        }
                                    }
                                }
                                bk bkVar4 = boVar.k;
                                if (bkVar4.b && !bkVar4.c) {
                                    bkVar4.c = z;
                                    z3 = z;
                                    z5 = z3;
                                }
                                if (bkVar4.c) {
                                    bm bmVar = boVar.i;
                                    ?? r12 = r10;
                                    if (bmVar.e) {
                                        bj bjVar = boVar.h;
                                        int i4 = bjVar.c;
                                        int i5 = bjVar.d;
                                        bmVar.e = r4;
                                        z3 = z;
                                        z5 = z3;
                                        r12 = z5;
                                        i2 = i5;
                                        i = i4;
                                    }
                                    boVar.notifyAll();
                                    boVar.i.c = r4;
                                    ?? r9 = r4;
                                    boolean z15 = r9 == true ? 1 : 0;
                                    boolean z16 = z15 ? 1 : 0;
                                    z10 = z16 ? 1 : 0;
                                    r2 = r9;
                                    z11 = z15;
                                    r7 = z16;
                                    r11 = r12;
                                } else {
                                    r6 = r4;
                                    if (r6 != 0) {
                                    }
                                    ?? r13 = r4;
                                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("waitForFrame");
                                    boVar.wait();
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    r0 = r13 == true ? 1 : 0;
                                    r4 = r0 == true ? 1 : 0;
                                    z2 = r4 == true ? 1 : 0;
                                    z = true;
                                }
                                runnable = null;
                                r1 = r2;
                                z6 = z11;
                                r6 = r7;
                                r10 = r11;
                                r14 = z10;
                                break;
                            }
                        } else {
                            synchronized (boVar) {
                                boVar.n();
                                boVar.m();
                                boVar.b = z;
                                boVar.notifyAll();
                            }
                        }
                    }
                    if (runnable != null) {
                        runnable.run();
                        r16 = r1;
                        z7 = z6;
                    } else {
                        Object obj5 = boVar.h.b;
                        if (z3) {
                            r17 = r1;
                            z9 = z6;
                        } else {
                            r17 = r1;
                            z9 = z6;
                        }
                        if (z4) {
                            agVar2 = boVar.k.a;
                            com.google.android.libraries.navigation.internal.yx.ar.r(agVar2, "Trying to call onSurfaceCreated but EGL hasn't been initialized");
                            if (agVar2.c() == agVar2.d()) {
                                r0 = 1;
                                z8 = z9;
                                z2 = z8;
                                z = true;
                                r4 = 0;
                            } else {
                                boVar.g.e();
                            }
                        }
                        if (z5) {
                            boVar.g.d(i, i2);
                        }
                        if (r14 != 0) {
                            boVar.g.j();
                            r0 = r17;
                            z2 = z9;
                            z = true;
                            r4 = 0;
                            z4 = false;
                            z5 = false;
                        } else {
                            boVar.e.set(true);
                            boVar.g.m();
                            boVar.g.c();
                            bkVar = boVar.k;
                            agVar = bkVar.a;
                            if (agVar != null) {
                                com.google.android.libraries.navigation.internal.zb.h hVar2 = (com.google.android.libraries.navigation.internal.zb.h) bo.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(NotificationUtils.NOTIFICATION_ID);
                                obj = bkVar.a;
                                if (obj == null) {
                                    obj = "<null>";
                                }
                                obj2 = bkVar.e;
                                if (obj2 == null) {
                                    obj2 = "<null>";
                                }
                                obj3 = bkVar.h;
                                if (obj3 == null) {
                                    obj3 = "<null>";
                                }
                                hVar2.y("swap() called without a valid egl / display / surface - %s %s %s", obj, obj2, obj3);
                                r0 = 1;
                            } else {
                                com.google.android.libraries.navigation.internal.zb.h hVar3 = (com.google.android.libraries.navigation.internal.zb.h) bo.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(NotificationUtils.NOTIFICATION_ID);
                                obj = bkVar.a;
                                if (obj == null) {
                                    obj = "<null>";
                                }
                                obj2 = bkVar.e;
                                if (obj2 == null) {
                                    obj2 = "<null>";
                                }
                                obj3 = bkVar.h;
                                if (obj3 == null) {
                                    obj3 = "<null>";
                                }
                                hVar3.y("swap() called without a valid egl / display / surface - %s %s %s", obj, obj2, obj3);
                                r0 = 1;
                            }
                            boVar.g.b();
                            if (r10 != 0) {
                                z2 = true;
                            } else {
                                z2 = z9;
                            }
                            boVar.e.set(false);
                            r4 = 0;
                            z4 = false;
                            z5 = false;
                            z = true;
                        }
                    }
                    r0 = r16;
                    z8 = z7;
                    z2 = z8;
                    z = true;
                    r4 = 0;
                }
                return;
            }
        } catch (SecurityException unused3) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) bo.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalArgumentException("You don't have permission to set thread GlViewThreadImpl priority"))).F((char) 1345)).o();
        }
        r6 = 1;
        r0 = 0;
        z2 = false;
        z3 = false;
        z4 = false;
        z5 = false;
        r10 = 0;
        i = 0;
        i2 = 0;
    }
}
