package com.google.android.libraries.navigation.internal.ub;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.afl.fa;
import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.zs.aq;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements com.google.android.libraries.navigation.internal.uc.l {
    static final com.google.android.libraries.navigation.internal.pd.g a = new com.google.android.libraries.navigation.internal.pd.g();
    private static final float c = (float) (1.0d / Math.log(2.0d));
    final com.google.android.libraries.navigation.internal.uc.i b;
    private final com.google.android.libraries.navigation.internal.fz.d d;
    private final com.google.android.libraries.navigation.internal.si.e e;
    private final com.google.android.libraries.navigation.internal.pd.h f;
    private float h = 0.0f;
    private ff i = ff.NORMAL;
    private float g = e(ff.NORMAL);

    public n(com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.uc.i iVar, com.google.android.libraries.navigation.internal.si.e eVar, com.google.android.libraries.navigation.internal.pd.h hVar) {
        this.d = dVar;
        this.b = iVar;
        this.e = eVar;
        this.f = hVar;
    }

    private static float a(ai aiVar, Rect rect, float f, boolean z) {
        if (aiVar.e() == 0 || aiVar.d() == 0) {
            return 21.0f;
        }
        float f2 = f * 256.0f;
        return 30.0f - (((float) Math.log(Math.max((aiVar.e() * f2) / rect.width(), (aiVar.d() * f2) / rect.height()) / 0.8f)) * c);
    }

    private final float e(ff ffVar) {
        com.google.android.libraries.navigation.internal.uc.b bVar = (com.google.android.libraries.navigation.internal.uc.b) this.b;
        boolean z = bVar.c;
        boolean z2 = bVar.b;
        fa faVar = this.d.b().i(bVar.a, z2, z, ffVar).d;
        if (faVar == null) {
            faVar = fa.a;
        }
        return faVar.d;
    }

    private static com.google.android.libraries.navigation.internal.pd.d f(ai aiVar, com.google.android.libraries.navigation.internal.pd.e eVar, float f, float f2, float f3) {
        float fMin = Math.min(f2, f);
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        x xVar = new x();
        aiVar.q(xVar);
        aVar.e(xVar);
        aVar.c = fMin;
        aVar.e = 0.0f;
        aVar.f = eVar;
        return aVar.a();
    }

    private static com.google.android.libraries.navigation.internal.pd.e g(Rect rect, int i, int i2, com.google.android.libraries.navigation.internal.pd.h hVar, boolean z) {
        return com.google.android.libraries.navigation.internal.pd.e.c(rect.exactCenterX(), (hVar != com.google.android.libraries.navigation.internal.pd.h.LOCATION_AND_BEARING || z) ? rect.exactCenterY() : rect.bottom - ((rect.bottom - rect.top) * 0.2f), i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.uc.l
    public final com.google.android.libraries.navigation.internal.pd.d b(bq bqVar, Rect rect, int i, int i2) {
        x xVar = bqVar.c;
        r rVar = new r(xVar.b(), xVar.d());
        float f = this.f == com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY ? 0.0f : bqVar.o;
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        aVar.d(rVar);
        aVar.e = f;
        aVar.c = e(ff.INSPECT_STEP);
        aVar.d = 0.0f;
        aVar.f = g(rect, i, i2, this.f, ((com.google.android.libraries.navigation.internal.uc.b) this.b).c);
        return aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.uc.l
    public final com.google.android.libraries.navigation.internal.pd.d d(com.google.android.libraries.navigation.internal.db.r rVar, List list, Rect rect, int i, int i2, float f) {
        x[] xVarArr;
        if (rVar == null) {
            int size = list.size();
            xVarArr = new x[size + size];
        } else {
            int size2 = list.size();
            int i3 = size2 + size2;
            x[] xVarArr2 = new x[i3 + 1];
            xVarArr2[i3] = rVar.n();
            xVarArr = xVarArr2;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            ai aiVarD = ((an) list.get(i4)).d();
            int i5 = i4 + i4;
            xVarArr[i5] = aiVarD.a;
            xVarArr[i5 + 1] = aiVarD.b;
        }
        ai aiVarI = ai.i(xVarArr);
        if (!list.isEmpty()) {
            ((an) list.get(0)).b(((an) list.get(0)).a() - 1);
            this.h = 0.0f;
        }
        return f(aiVarI, g(rect, i, i2, this.f, ((com.google.android.libraries.navigation.internal.uc.b) this.b).c), a(aiVarI, rect, f, false), e(ff.INSPECT_ROUTE), 0.0f);
    }

    @Override // com.google.android.libraries.navigation.internal.uc.l
    public final com.google.android.libraries.navigation.internal.uc.n c(com.google.android.libraries.navigation.internal.db.r rVar, bq bqVar, com.google.android.libraries.navigation.internal.se.b bVar, Rect rect, Float f, int i, int i2, float f2) {
        float fE;
        ff ffVar = ff.UNKNOWN_VIEW_MODE;
        if (f != null) {
            fE = f.floatValue();
        } else if (bqVar != null) {
            float fLog = 30.0f - (((float) Math.log(((rVar.n().h(bqVar.c) * 256.0f) * f2) / (Math.min(i, i2) * 0.5f))) * c);
            if (fLog >= e(ff.APPROACH)) {
                ff ffVar2 = ff.APPROACH;
                this.i = ffVar2;
                fE = e(ffVar2);
            } else if (fLog >= e(ff.NORMAL)) {
                ff ffVar3 = ff.NORMAL;
                this.i = ffVar3;
                fE = e(ffVar3);
            } else {
                ff ffVar4 = ff.FAR_VIEW_MODE;
                this.i = ffVar4;
                fE = e(ffVar4);
            }
            ffVar = this.i;
        } else if (this.e == com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV) {
            fE = this.g;
        } else {
            fE = e(ff.NORMAL);
            ffVar = ff.NORMAL;
        }
        this.g = fE;
        com.google.android.libraries.navigation.internal.uc.m mVarE = com.google.android.libraries.navigation.internal.uc.n.e();
        mVarE.b(h.c(com.google.android.libraries.navigation.internal.uc.g.FOLLOWING));
        mVarE.c(ffVar);
        mVarE.d(aq.UNKNOWN_CAMERA_TYPE);
        com.google.android.libraries.navigation.internal.pd.f fVar = new com.google.android.libraries.navigation.internal.pd.f();
        fVar.a = a;
        com.google.android.libraries.navigation.internal.pd.h hVar = this.f;
        fVar.f = hVar;
        fVar.b = fE;
        fVar.e = g(rect, i, i2, hVar, ((com.google.android.libraries.navigation.internal.uc.b) this.b).c);
        mVarE.e(fVar.a());
        return mVarE.a();
    }
}
