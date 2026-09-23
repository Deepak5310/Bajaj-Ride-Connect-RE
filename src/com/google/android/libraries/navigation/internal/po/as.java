package com.google.android.libraries.navigation.internal.po;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.ClientLineStampShaderState;
import com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.RoadStrokePointSpriteShaderState;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class as implements Runnable {
    final /* synthetic */ ay a;

    public as(ay ayVar) {
        this.a = ayVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x023e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0240 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0250 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x028a */
    /* JADX WARN: Code duplicated, block: B:229:0x0292 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x02b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:? A[Catch: all -> 0x029c, SYNTHETIC, TRY_LEAVE, TryCatch #20 {all -> 0x029c, blocks: (B:152:0x0269, B:151:0x0266, B:141:0x0256, B:154:0x026c, B:178:0x029b, B:177:0x0298, B:147:0x0260, B:173:0x0292), top: B:239:0x0044, inners: #2, #15 }] */
    /* JADX WARN: Code duplicated, block: B:282:? A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0243, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0244, code lost:
    
        if (r11 == null) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0246, code lost:
    
        androidx.tracing.Trace.endSection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x024a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x024c, code lost:
    
        r2.addSuppressed(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x024f, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        Throwable th;
        Throwable th2;
        com.google.android.libraries.navigation.internal.nw.d dVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        com.google.android.libraries.geo.mapcore.renderer.ef efVar;
        com.google.android.libraries.geo.mapcore.renderer.ek ekVarT;
        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("cameraRunnable.run");
        try {
            try {
                ay ayVar = this.a;
                float f = ayVar.j.w().k;
                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("onCameraUpdate");
                try {
                    com.google.android.libraries.geo.mapcore.renderer.ea eaVar = com.google.android.libraries.geo.mapcore.renderer.ea.INVALID;
                    float fMax = Math.max(0.0f, f);
                    ayVar.s = fMax;
                    int iFloor = (int) Math.floor(fMax);
                    boolean z = ayVar.v;
                    int i = 0;
                    ayVar.v = false;
                    boolean z2 = true;
                    boolean z3 = z || Math.abs(ayVar.t - iFloor) != 0;
                    if (z3) {
                        ayVar.t = Math.max(0, iFloor);
                    }
                    try {
                        if (!z) {
                            com.google.android.libraries.navigation.internal.yz.ev evVar = ayVar.w;
                            int i2 = ((lv) evVar).c;
                            int i3 = 0;
                            while (i3 < i2) {
                                boolean zF = ((gw) evVar.get(i3)).f();
                                i3++;
                                if (zF) {
                                    if (ay.a(ayVar.s) == ay.a(ayVar.u)) {
                                        break;
                                    }
                                    ayVar.c();
                                    break;
                                }
                            }
                        } else {
                            com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("updateGroupStyles");
                            try {
                                com.google.android.libraries.navigation.internal.qq.p pVar = ayVar.e;
                                if (pVar != null) {
                                    synchronized (pVar.a) {
                                        pVar.a.clear();
                                    }
                                }
                                no it2 = ayVar.w.iterator();
                                int i4 = 0;
                                while (it2.hasNext()) {
                                    List<com.google.android.libraries.geo.mapcore.internal.model.bt[]> listC = ((gw) it2.next()).c(true, ayVar.f, ayVar.t);
                                    if (ayVar.e != null) {
                                        for (com.google.android.libraries.geo.mapcore.internal.model.bt[] btVarArr : listC) {
                                            if (btVarArr != null && btVarArr.length > 0) {
                                                com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr = btVarArr[0].g(ayVar.t).o;
                                                int length = bsVarArr.length;
                                                int i5 = 0;
                                                while (true) {
                                                    if (i5 >= length) {
                                                        com.google.android.libraries.navigation.internal.qq.p pVar2 = ayVar.e;
                                                        synchronized (pVar2.a) {
                                                            pVar2.a.add(Integer.valueOf(i4));
                                                        }
                                                        break;
                                                    } else if (bsVarArr[i5].d()) {
                                                        break;
                                                    } else {
                                                        i5++;
                                                    }
                                                }
                                            }
                                            i4++;
                                        }
                                    }
                                }
                                synchronized (ayVar) {
                                    try {
                                        if (ayVar.i) {
                                            no it3 = ayVar.w.iterator();
                                            while (it3.hasNext()) {
                                                ayVar.h.h(((gw) it3.next()).d);
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                th2 = th;
                                                if (dVarB4 != null) {
                                                    throw th2;
                                                }
                                                try {
                                                    Trace.endSection();
                                                    throw th2;
                                                } catch (Throwable th5) {
                                                    th2.addSuppressed(th5);
                                                    throw th2;
                                                }
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                if (dVarB4 != null) {
                                    Trace.endSection();
                                }
                                ayVar.c();
                            } catch (Throwable th6) {
                                th = th6;
                                th2 = th;
                                if (dVarB4 != null) {
                                    throw th2;
                                }
                                Trace.endSection();
                                throw th2;
                            }
                        }
                        if (z3) {
                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("zoomChange");
                            try {
                                no it4 = ayVar.w.iterator();
                                while (it4.hasNext()) {
                                    gw gwVar = (gw) it4.next();
                                    int i6 = ayVar.t;
                                    com.google.android.libraries.geo.mapcore.internal.vector.gl.p pVar3 = ayVar.f;
                                    com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("updateShaderState");
                                    com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar = gwVar.g;
                                    if (aVar != null) {
                                        aVar.f = i6;
                                        if (gwVar.f()) {
                                            com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar2 = gwVar.g;
                                            com.google.android.libraries.navigation.internal.nw.d dVarB6 = com.google.android.libraries.navigation.internal.nw.e.b("updatePointSpriteShaderState");
                                            try {
                                                RoadStrokePointSpriteShaderState roadStrokePointSpriteShaderState = new RoadStrokePointSpriteShaderState(null);
                                                roadStrokePointSpriteShaderState.a = (gwVar.b instanceof com.google.android.libraries.navigation.internal.oe.am) ^ z2;
                                                com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA = gw.a(aVar2, i6);
                                                if (aVar2.d(aiVarA) > 0 && (ekVarT = pVar3.t(aVar2.f(aiVarA, i).i)) != null) {
                                                    gwVar.d.B(3, ekVarT);
                                                }
                                                gwVar.d.f(aVar2.c, gwVar.e);
                                                gwVar.d.e(i6);
                                                if (dVarB6 != null) {
                                                    Trace.endSection();
                                                }
                                                dVarB2 = dVarB2;
                                                efVar = roadStrokePointSpriteShaderState;
                                            } catch (Throwable th7) {
                                                if (dVarB6 == null) {
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
                                        } else {
                                            com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar3 = gwVar.g;
                                            com.google.android.libraries.navigation.internal.nw.d dVarB7 = com.google.android.libraries.navigation.internal.nw.e.b("updateRoadStrokeShaderState");
                                            try {
                                                gwVar.d.f(aVar3.c, gwVar.e);
                                                float f2 = i6;
                                                gwVar.d.e(f2);
                                                com.google.android.libraries.navigation.internal.qq.d dVar2 = gwVar.d;
                                                dVarB2 = dVarB2;
                                                try {
                                                    com.google.android.libraries.geo.mapcore.renderer.ey eyVar = new com.google.android.libraries.geo.mapcore.renderer.ey("stroke_color", null, 2, 1);
                                                    eyVar.d(new com.google.android.libraries.geo.mapcore.renderer.cs(aVar3.b(), 4, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a.a, 96, false));
                                                    dVar2.B(4, eyVar);
                                                    com.google.android.libraries.navigation.internal.qq.d dVar3 = gwVar.d;
                                                    com.google.android.libraries.geo.mapcore.renderer.ey eyVar2 = new com.google.android.libraries.geo.mapcore.renderer.ey("stroke_dash", null, 2, 3);
                                                    eyVar2.d(new com.google.android.libraries.geo.mapcore.renderer.cs(aVar3.a(i6), 1, 64, 32, true));
                                                    dVar3.B(5, eyVar2);
                                                    ClientLineStampShaderState clientLineStampShaderState = new ClientLineStampShaderState(f2, gwVar.d, null);
                                                    if (dVarB7 != null) {
                                                        Trace.endSection();
                                                    }
                                                    efVar = clientLineStampShaderState;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    Throwable th10 = th;
                                                    if (dVarB7 == null) {
                                                        throw th10;
                                                    }
                                                    try {
                                                        Trace.endSection();
                                                        throw th10;
                                                    } catch (Throwable th11) {
                                                        th10.addSuppressed(th11);
                                                        throw th10;
                                                    }
                                                }
                                            } catch (Throwable th12) {
                                                th = th12;
                                                dVarB2 = dVarB2;
                                            }
                                        }
                                        gwVar.h = efVar;
                                        gwVar.d.v(gwVar.h);
                                        if (dVarB5 != null) {
                                            Trace.endSection();
                                        }
                                        it4 = it4;
                                        dVarB2 = dVarB2;
                                        i = 0;
                                        z2 = true;
                                    } else if (dVarB5 != null) {
                                        Trace.endSection();
                                    } else {
                                        continue;
                                    }
                                }
                                dVar = dVarB2;
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                dVarB2 = dVarB2;
                            }
                        } else {
                            dVar = dVarB2;
                        }
                        ayVar.d();
                        if (dVarB3 != null) {
                            Trace.endSection();
                        }
                        ay ayVar2 = this.a;
                        ayVar2.y.d(ayVar2.x);
                        if (dVar != null) {
                            Trace.endSection();
                            return;
                        }
                        return;
                        Throwable th14 = th;
                        if (dVarB == null) {
                            throw th14;
                        }
                        try {
                            Trace.endSection();
                            throw th14;
                        } catch (Throwable th15) {
                            th14.addSuppressed(th15);
                            throw th14;
                        }
                    } catch (Throwable th16) {
                        th = th16;
                        Throwable th17 = th;
                        if (dVarB3 == null) {
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
                    th = th19;
                    dVarB2 = dVarB2;
                }
            } catch (Throwable th20) {
                th = th20;
                th = th;
                if (dVarB2 != null) {
                    throw th;
                }
                try {
                    Trace.endSection();
                    throw th;
                } catch (Throwable th21) {
                    th.addSuppressed(th21);
                    throw th;
                }
            }
        } catch (Throwable th22) {
            th = th22;
            dVarB2 = dVarB2;
            th = th;
            if (dVarB2 != null) {
                throw th;
            }
            Trace.endSection();
            throw th;
        }
    }
}
