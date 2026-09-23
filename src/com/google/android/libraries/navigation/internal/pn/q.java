package com.google.android.libraries.navigation.internal.pn;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.google.android.libraries.navigation.internal.oe.ay;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public final ay a = new ay();
    public float b;
    public float c;

    public q(MotionEvent motionEvent, VelocityTracker velocityTracker, EnumSet enumSet, boolean z) {
        float f;
        velocityTracker.computeCurrentVelocity(1);
        int pointerCount = motionEvent.getPointerCount();
        ay[] ayVarArr = new ay[pointerCount];
        int pointerCount2 = motionEvent.getPointerCount();
        ay[] ayVarArr2 = new ay[pointerCount2];
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            ayVarArr2[i] = new ay(motionEvent.getX(i), motionEvent.getY(i));
            ay ayVar = new ay(velocityTracker.getXVelocity(pointerId), velocityTracker.getYVelocity(pointerId));
            ayVarArr[i] = ayVar;
            ay ayVar2 = this.a;
            ay.j(ayVar2, ayVar, ayVar2);
        }
        ay ayVar3 = this.a;
        ay.l(ayVar3, TimeUnit.SECONDS.toMillis(1L), ayVar3);
        ay ayVar4 = this.a;
        ay.k(ayVar4, pointerCount, ayVar4);
        ay ayVar5 = ayVarArr2[0];
        float f2 = ayVar5.b;
        float f3 = ayVar5.c;
        int i2 = pointerCount2 - 1;
        ay ayVar6 = ayVarArr2[i2];
        float f4 = ayVar6.b;
        float f5 = ayVar6.c;
        ay ayVar7 = ayVarArr[0];
        float f6 = ayVar7.b + f2;
        float f7 = ayVar7.c + f3;
        ay ayVar8 = ayVarArr[i2];
        float f8 = ayVar8.b + f4;
        float f9 = ayVar8.c + f5;
        ay ayVar9 = new ay();
        ay.s(ayVar6, ayVar5, ayVar9);
        ay ayVar10 = new ay();
        ay.s(new ay(f8, f9), new ay(f6, f7), ayVar10);
        float fD = ayVar9.d();
        float fB = com.google.android.libraries.navigation.internal.nq.a.b(fD == 0.0f ? 1.0f : ayVar10.d() / fD);
        this.b = fB;
        this.b = fB * TimeUnit.SECONDS.toMillis(1L);
        float degrees = (float) Math.toDegrees(b.a(h.a(f2, f3, f4, f5), h.a(f6, f7, f8, f9)));
        this.c = degrees;
        this.c = degrees * TimeUnit.SECONDS.toMillis(1L);
        if (z) {
            ay ayVar11 = new ay(f6 - f2, f7 - f3);
            ay ayVar12 = new ay(f8 - f4, f9 - f5);
            this.c *= n.d(ay.a(ay.a, ayVar9, ayVar12) - ay.a(ay.a, ayVar9, ayVar11), ayVar9.c(ayVar12) - ayVar9.c(ayVar11));
        }
        if (enumSet.contains(m.PAN)) {
            f = 0.0f;
        } else {
            f = 0.0f;
            this.a.q(0.0f, 0.0f);
        }
        if (!enumSet.contains(m.ZOOM)) {
            this.b = f;
        }
        if (enumSet.contains(m.ROTATE)) {
            return;
        }
        this.c = f;
    }
}
