package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.SpeedAlertSeverity;
import com.google.android.libraries.navigation.SpeedingListener;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements com.google.android.libraries.navigation.internal.uu.k {
    private com.google.android.libraries.navigation.internal.adr.bm.a c = com.google.android.libraries.navigation.internal.adr.bm.a.KILOMETERS;
    final Map a = new EnumMap(SpeedAlertSeverity.class);
    com.google.android.libraries.navigation.internal.yx.an b = com.google.android.libraries.navigation.internal.yx.a.a;
    private int d = -1;

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void b(float f) {
        float fB;
        float fC;
        if (this.b.g()) {
            float f2 = f * (this.c == com.google.android.libraries.navigation.internal.adr.bm.a.KILOMETERS ? 3.6f : 2.2369363f);
            Float f3 = (Float) this.a.get(SpeedAlertSeverity.MAJOR);
            Float f4 = (Float) this.a.get(SpeedAlertSeverity.MINOR);
            int i = this.d;
            if (i == -1 || i == 0) {
                ((SpeedingListener) this.b.c()).onSpeedingUpdated(-1.0f, SpeedAlertSeverity.NONE);
                return;
            }
            if (f2 <= i) {
                ((SpeedingListener) this.b.c()).onSpeedingUpdated(0.0f, SpeedAlertSeverity.NONE);
                return;
            }
            SpeedAlertSeverity speedAlertSeverity = SpeedAlertSeverity.NONE;
            if (f3 == null || f4 == null) {
                fB = com.google.android.libraries.navigation.internal.xf.q.b(i, this.c);
                fC = com.google.android.libraries.navigation.internal.xf.q.c(this.d, this.c);
            } else {
                fB = com.google.android.libraries.navigation.internal.xf.q.a(f3.floatValue(), i);
                fC = com.google.android.libraries.navigation.internal.xf.q.a(f4.floatValue(), i);
            }
            if (f2 >= fB) {
                speedAlertSeverity = SpeedAlertSeverity.MAJOR;
            } else if (f2 >= fC) {
                speedAlertSeverity = SpeedAlertSeverity.MINOR;
            }
            float f5 = this.d;
            ((SpeedingListener) this.b.c()).onSpeedingUpdated(((f2 - f5) * 100.0f) / f5, speedAlertSeverity);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void c() {
        if (this.b.g()) {
            ((SpeedingListener) this.b.c()).onSpeedingUpdated(-1.0f, SpeedAlertSeverity.NONE);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void d(com.google.android.libraries.navigation.internal.ady.al alVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void e(int i) {
    }

    @Override // com.google.android.libraries.navigation.internal.uu.k
    public final void f(int i, com.google.android.libraries.navigation.internal.adr.bm.a aVar) {
        if (aVar != null && !this.c.equals(aVar)) {
            this.c = aVar;
        }
        this.d = i;
    }
}
