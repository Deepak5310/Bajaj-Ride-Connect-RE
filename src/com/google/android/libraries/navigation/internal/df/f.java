package com.google.android.libraries.navigation.internal.df;

import com.google.android.libraries.navigation.internal.agi.bi;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.oe.y;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    static final bi a;
    static final bi b;
    public float c;
    float d;
    float e;
    long f;
    float g;
    long h;
    public float i;
    public long j;
    long k;
    float l;
    float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final g f393n;
    final g o;
    final g p;
    public boolean q;
    private final bi r;
    private final bi s;
    private final bi t;

    static {
        bi biVar = new bi();
        a = biVar;
        biVar.a(e.DEVICE_MAGNETOMETER_ACCURACY, 6.26f);
        biVar.a(e.MAGNETIC_FIELD_STRENGTH_DIFF_FROM_IDEAL_MICROT, 0.87f);
        biVar.a(e.MAGNETIC_FIELD_STRENGTH_DEVIATION, 1.32f);
        biVar.a(e.CORRELATION_BETWEEN_DEVICE_AND_GYRO_ORIENTATION_CHANGES, -15.25f);
        biVar.a(e.RMS_DIFF_BETWEEN_DEVICE_AND_GYRO_ORIENTATION_CHANGES, 0.02f);
        biVar.a(e.CROSS_BETWEEN_ORIENTATION_CORRELATION_AND_ORIENTATION_RMS_DIFF, 15.77f);
        biVar.a(e.CROSS_BETWEEN_MAG_STRENGTH_DIFF_AND_MAG_STRENGTH_DEVIATION, 0.02f);
        bi biVar2 = new bi();
        b = biVar2;
        biVar2.a(e.DEVICE_MAGNETOMETER_ACCURACY, 6.26f);
        biVar2.a(e.MAGNETIC_FIELD_STRENGTH_DIFF_FROM_IDEAL_MICROT, 1.6f);
        biVar2.a(e.MAGNETIC_FIELD_STRENGTH_DEVIATION, 3.2f);
        biVar2.a(e.CROSS_BETWEEN_MAG_STRENGTH_DIFF_AND_MAG_STRENGTH_DEVIATION, 0.1f);
    }

    public f() {
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Long.MIN_VALUE;
        this.g = Float.NaN;
        this.h = Long.MIN_VALUE;
        this.i = Float.NaN;
        this.j = Long.MIN_VALUE;
        this.k = Long.MIN_VALUE;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.f393n = new g();
        this.o = new g();
        this.p = new g();
        this.q = true;
        this.t = new bi();
        this.c = 45.0f;
        this.r = a;
        this.s = b;
    }

    public final float a() {
        if (!e()) {
            return -1.0f;
        }
        bi biVarB = b();
        gi giVarListIterator = biVarB.keySet().listIterator();
        float fO = 0.0f;
        float fO2 = 0.0f;
        while (giVarListIterator.hasNext()) {
            e eVar = (e) giVarListIterator.next();
            if (this.r.containsKey(eVar)) {
                fO2 += this.r.o(eVar) * biVarB.o(eVar);
            }
            if (this.s.containsKey(eVar)) {
                fO += this.s.o(eVar) * biVarB.o(eVar);
            }
        }
        if (this.q && fO >= 30.0f && fO <= 60.0f) {
            fO = fO2;
        }
        return Math.min(Math.max(fO, 0.0f), 180.0f);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c7 A[LOOP:1: B:41:0x00c5->B:42:0x00c7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x010f  */
    public final bi b() {
        int i;
        float fB;
        float fB2;
        float fB3;
        float fB4;
        float fB5;
        int i2;
        this.t.clear();
        if (Float.isNaN(this.d) || Float.isNaN(this.e) || this.f393n.b != 10 || this.o.b != 10 || this.p.b != 10) {
            return this.t;
        }
        this.q = true;
        this.t.a(e.DEVICE_MAGNETOMETER_ACCURACY, this.d < 2.5f ? 3.0f : 1.0f);
        float f = this.c - this.e;
        float fSqrt = 0.0f;
        if (f > 0.0f) {
            f += f;
        }
        bi biVar = this.t;
        float fAbs = Math.abs(f);
        biVar.a(e.MAGNETIC_FIELD_STRENGTH_DIFF_FROM_IDEAL_MICROT, fAbs);
        float fA = (float) this.p.a();
        this.t.a(e.MAGNETIC_FIELD_STRENGTH_DEVIATION, fA);
        this.t.a(e.CROSS_BETWEEN_MAG_STRENGTH_DIFF_AND_MAG_STRENGTH_DEVIATION, fA * fAbs);
        g gVar = this.o;
        g gVar2 = this.f393n;
        double dA = gVar.a();
        double dA2 = gVar2.a();
        if (dA < 3.0d && (dA2 < 5.0d || dA2 > 300.0d)) {
            this.q = false;
        }
        g gVar3 = this.f393n;
        g gVar4 = this.o;
        int i3 = gVar3.b;
        int i4 = gVar4.b;
        float fSqrt2 = Float.NaN;
        if (i3 == i4 && i3 >= 2) {
            if (i3 != i4) {
                i = gVar3.b;
                fB = 0.0f;
                fB2 = 0.0f;
                fB3 = 0.0f;
                fB4 = 0.0f;
                fB5 = 0.0f;
                for (i2 = 0; i2 < i; i2++) {
                    fB2 += gVar3.b(i2);
                    fB4 += gVar3.b(i2) * gVar3.b(i2);
                    fB3 += gVar4.b(i2);
                    fB5 += gVar4.b(i2) * gVar4.b(i2);
                    fB += gVar3.b(i2) * gVar4.b(i2);
                }
                float f2 = i;
                fSqrt2 = (float) (((double) ((fB * f2) - (fB2 * fB3))) / Math.sqrt(((fB4 * f2) - (fB2 * fB2)) * ((f2 * fB5) - (fB3 * fB3))));
                if (Float.isNaN(fSqrt2)) {
                    fSqrt2 = 0.0f;
                }
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 >= gVar3.b) {
                        fSqrt2 = 1.0f;
                    } else if (gVar3.a[i5] == gVar4.b(i5)) {
                        i5++;
                    } else {
                        i = gVar3.b;
                        fB = 0.0f;
                        fB2 = 0.0f;
                        fB3 = 0.0f;
                        fB4 = 0.0f;
                        fB5 = 0.0f;
                        while (i2 < i) {
                            fB2 += gVar3.b(i2);
                            fB4 += gVar3.b(i2) * gVar3.b(i2);
                            fB3 += gVar4.b(i2);
                            fB5 += gVar4.b(i2) * gVar4.b(i2);
                            fB += gVar3.b(i2) * gVar4.b(i2);
                        }
                        float f3 = i;
                        fSqrt2 = (float) (((double) ((fB * f3) - (fB2 * fB3))) / Math.sqrt(((fB4 * f3) - (fB2 * fB2)) * ((f3 * fB5) - (fB3 * fB3))));
                        if (Float.isNaN(fSqrt2)) {
                            fSqrt2 = 0.0f;
                        }
                    }
                }
            }
        }
        g gVar5 = this.f393n;
        g gVar6 = this.o;
        if (gVar5.b == gVar6.b) {
            double dPow = 0.0d;
            int i6 = 0;
            while (i6 < gVar5.b) {
                dPow += Math.pow(d.b(gVar5.b(i6) - gVar6.b(i6), -180.0f, 180.0f), 2.0d);
                i6++;
                gVar5 = gVar5;
            }
            fSqrt = (float) Math.sqrt(dPow);
        }
        if (Math.log(Math.max((1.0f - fSqrt2) * fSqrt, 2.718281828459045d)) > 5.199999809265137d) {
            this.q = false;
        }
        float f4 = ((fSqrt2 >= -0.4f || fAbs >= 30.0f) && (fSqrt2 >= -0.4f || fAbs >= 30.0f) && (fSqrt2 >= -0.4f || this.d != 2.5f)) ? fSqrt2 : 0.0f;
        this.t.a(e.CORRELATION_BETWEEN_DEVICE_AND_GYRO_ORIENTATION_CHANGES, f4);
        this.t.a(e.RMS_DIFF_BETWEEN_DEVICE_AND_GYRO_ORIENTATION_CHANGES, fSqrt);
        this.t.a(e.CROSS_BETWEEN_ORIENTATION_CORRELATION_AND_ORIENTATION_RMS_DIFF, (float) Math.log(Math.max((1.0f - f4) * fSqrt, 2.718281828459045d)));
        return this.t;
    }

    public final void c(float f, long j) {
        if (Float.isNaN(f)) {
            return;
        }
        float f2 = this.g;
        if (!Float.isNaN(f2)) {
            f = d.b((y.d(f, f2) * 0.7f) + f, -180.0f, 180.0f);
        }
        this.g = f;
        this.h = j;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    public final void d(Long l) {
        long j = this.k;
        if (j == Long.MIN_VALUE || l.longValue() - j >= 500) {
            if (this.f != Long.MIN_VALUE) {
                float f = this.e;
                if (!Float.isNaN(f)) {
                    this.p.c(f);
                }
            }
            if (this.h != Long.MIN_VALUE) {
                float f2 = this.g;
                if (!Float.isNaN(f2)) {
                    float f3 = this.l;
                    if (!Float.isNaN(f3)) {
                        this.f393n.c(d.b(f2 - f3, -180.0f, 180.0f));
                    }
                }
            }
            long j2 = this.j;
            if (j2 != Long.MIN_VALUE && l.longValue() - j2 <= 500) {
                float f4 = this.i;
                if (!Float.isNaN(f4)) {
                    float f5 = this.m;
                    if (!Float.isNaN(f5)) {
                        this.o.c(d.b(f4 - f5, -180.0f, 180.0f));
                    } else if (j2 != Long.MIN_VALUE) {
                        this.o.c(1.0f);
                    }
                } else if (j2 != Long.MIN_VALUE) {
                    this.o.c(1.0f);
                }
            } else if (j2 != Long.MIN_VALUE && l.longValue() - j2 > 500) {
                this.o.c(1.0f);
            }
            this.l = this.g;
            this.m = this.i;
            this.k = l.longValue();
        }
    }

    public final boolean e() {
        return this.f393n.b == 10 && this.o.b == 10 && this.p.b == 10 && !Float.isNaN(this.d) && !Float.isNaN(this.e);
    }

    public f(float f) {
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Long.MIN_VALUE;
        this.g = Float.NaN;
        this.h = Long.MIN_VALUE;
        this.i = Float.NaN;
        this.j = Long.MIN_VALUE;
        this.k = Long.MIN_VALUE;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.f393n = new g();
        this.o = new g();
        this.p = new g();
        this.q = true;
        this.t = new bi();
        this.c = f;
        this.r = a;
        this.s = b;
    }
}
