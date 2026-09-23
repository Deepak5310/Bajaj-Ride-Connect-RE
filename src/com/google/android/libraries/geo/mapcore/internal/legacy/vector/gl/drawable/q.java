package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.libraries.geo.mapcore.internal.model.bf;
import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.geo.mapcore.renderer.fg;
import com.google.android.libraries.navigation.internal.agg.de;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements g {
    private static final ThreadLocal a = new p();
    private int b = 0;

    private q() {
    }

    public static q c(ce ceVar, ba baVar, bq bqVar, cp cpVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, ef efVar, aj ajVar, List list) {
        int i;
        float fMin;
        int iA;
        de deVar = (de) a.get();
        q qVar = new q();
        cd cdVar = ceVar.a;
        com.google.android.libraries.navigation.internal.qq.k kVar = new com.google.android.libraries.navigation.internal.qq.k(cdVar);
        br brVar = null;
        while (cpVar.hasNext()) {
            br brVarB = cpVar.b();
            if (!(brVarB instanceof bf)) {
                break;
            }
            bf bfVar = (bf) brVarB;
            if (brVar == null) {
                brVar = brVarB;
            }
            float f = bfVar.c * 4.0f;
            byte b = (byte) (bfVar.d * 4.0f);
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG = ajVar.a.c(bfVar.q).g(b);
            bs bsVar = aiVarG.q;
            if (bsVar != null) {
                float f2 = bsVar.d;
                iA = com.google.android.libraries.navigation.internal.rq.b.a(bsVar.b);
                fMin = Math.min(127.5f, f2);
            } else {
                fMin = 0.0f;
                iA = 0;
            }
            float f3 = aiVarG.l;
            int iH = com.google.android.libraries.navigation.internal.nq.a.h(Math.min(255, (int) (f3 + f3)), (int) (fMin + fMin), (byte) f, b);
            int iH2 = com.google.android.libraries.navigation.internal.nq.a.h(0, 0, 128, 0);
            int iH3 = com.google.android.libraries.navigation.internal.nq.a.h(0, 0, 0, 128);
            int i2 = bfVar.a;
            int i3 = bfVar.b;
            int iA2 = com.google.android.libraries.navigation.internal.rq.b.a(aiVarG.k);
            int i4 = ((char) i2) | (i3 << 16);
            deVar.c(i4);
            deVar.c(iA2);
            deVar.c(iA);
            deVar.c(iH);
            deVar.c(i4);
            deVar.c(iA2);
            deVar.c(iA);
            deVar.c(iH2 | iH);
            deVar.c(i4);
            deVar.c(iA2);
            deVar.c(iA);
            deVar.c(iH | iH3);
            fd fdVar = bfVar.e;
            boolean z = bfVar.f;
            cpVar.next();
        }
        com.google.android.libraries.navigation.internal.qq.an anVar = new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar, baVar.b, brVar == null ? new fg(0, 0, 0) : com.google.android.libraries.navigation.internal.qq.an.k(brVar, ajVar.a.e(brVar)), false);
        anVar.v(efVar);
        anVar.t(770, 771);
        ff ffVar = new ff("client_point", deVar.l(), deVar.b / 4, 482, 4, 16, bqVar);
        qVar.b = ffVar.p;
        anVar.w(ffVar);
        anVar.f74n = new com.google.android.libraries.navigation.internal.qq.u(true, false, new com.google.android.libraries.navigation.internal.qq.m(kVar.b));
        list.add(anVar);
        deVar.clear();
        int[] iArr = deVar.a;
        int length = iArr.length;
        if (length > 16384 && (i = deVar.b) != length) {
            int[] iArr2 = new int[Math.max(16384, i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            deVar.a = iArr2;
        }
        return qVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int b() {
        return PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION;
    }
}
