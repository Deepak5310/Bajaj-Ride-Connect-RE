package com.google.android.libraries.navigation.internal.dh;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import com.google.android.libraries.navigation.internal.aac.bn;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah implements SensorEventListener2 {
    private static final float s = (float) Math.toRadians(90.0d);
    private long E;
    private final ae F;
    public final SensorManager a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public final Sensor c;
    public Sensor d;
    public final Sensor e;
    public final Sensor f;
    public final Sensor g;
    public com.google.android.libraries.navigation.internal.kl.a i;
    public long j;
    public boolean k;
    public float o;
    public float p;
    public long r;
    private final bn t;
    private float[] u;
    private long w;
    public Future h = com.google.android.libraries.navigation.internal.aac.az.f();
    private final com.google.android.libraries.navigation.internal.de.x v = new com.google.android.libraries.navigation.internal.de.x();
    private final float[] x = new float[3];
    private int y = 0;
    private final float[] z = new float[3];
    public boolean l = true;
    public boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f395n = false;
    private final float[] A = new float[4];
    private final com.google.android.libraries.navigation.internal.de.x B = new com.google.android.libraries.navigation.internal.de.x();
    private final float[] C = new float[3];
    private int D = 0;
    public long q = 0;

    public ah(ae aeVar, SensorManager sensorManager, bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.F = aeVar;
        this.a = sensorManager;
        this.t = bnVar;
        this.b = aVar;
        this.c = sensorManager.getDefaultSensor(16);
        this.f = sensorManager.getDefaultSensor(9);
        this.e = sensorManager.getDefaultSensor(10);
        this.g = sensorManager.getDefaultSensor(14);
        this.d = null;
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            if ("android.sensor.gyroscope_limited_axes_uncalibrated".equals(sensor.getStringType())) {
                this.d = sensor;
                return;
            }
        }
    }

    private final void d(long j, float f, float f2, float f3, boolean z, boolean z2) {
        float[] fArr = this.u;
        if (fArr != null) {
            f -= fArr[0];
            f2 -= fArr[1];
            f3 -= fArr[2];
        }
        float[] fArr2 = this.A;
        if (true != z) {
            f = 0.0f;
        }
        fArr2[0] = f;
        if (true != z2) {
            f2 = 0.0f;
        }
        fArr2[1] = f2;
        fArr2[2] = f3;
        this.p = Math.max(this.p, (f * f) + (f2 * f2) + (f3 * f3));
        long j2 = this.j;
        if (j2 != 0 && j > j2) {
            long j3 = j - j2;
            this.B.c(fArr2, j3 * 1.0E-9f);
            com.google.android.libraries.navigation.internal.de.x xVar = this.v;
            xVar.e(xVar, this.B);
            this.w += j3;
        }
        this.j = j;
    }

    public final void a() {
        this.v.h(0.0f, 0.0f, 0.0f, 1.0f);
        this.w = 0L;
        float[] fArr = this.x;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.y = 0;
        float[] fArr2 = this.C;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        this.D = 0;
    }

    public final void b(long j) {
        long j2;
        long jA = this.b.a();
        long millis = jA - this.b.e().toMillis();
        long j3 = millis - this.r;
        this.r = millis;
        if (j3 > 1000) {
            this.q = 200 + jA;
        }
        long j4 = this.q;
        if (j4 > 0) {
            if (jA < j4) {
                com.google.android.libraries.navigation.internal.kl.a aVar = this.i;
                if (aVar != null) {
                    if (j < j4 - 300 || j > jA + 100) {
                        ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(21);
                        return;
                    }
                    return;
                }
                return;
            }
            this.l = true;
        }
        float f = this.p;
        float f2 = s;
        float fSqrt = f > f2 * f2 ? (float) Math.sqrt(f) : Float.NaN;
        float f3 = this.o;
        float fSqrt2 = f3 > 9.0f ? (float) Math.sqrt(f3) : Float.NaN;
        this.p = 0.0f;
        this.o = 0.0f;
        if (this.l) {
            this.v.h(0.0f, 0.0f, 0.0f, 1.0f);
        }
        com.google.android.libraries.navigation.internal.de.x xVar = this.v;
        xVar.f(xVar);
        int i = this.y;
        if (i > 0) {
            float[] fArr = this.x;
            float f4 = i;
            fArr[0] = fArr[0] / f4;
            fArr[1] = fArr[1] / f4;
            fArr[2] = fArr[2] / f4;
        }
        int i2 = this.D;
        if (i2 > 0) {
            float[] fArr2 = this.C;
            float f5 = i2;
            fArr2[0] = fArr2[0] / f5;
            fArr2[1] = fArr2[1] / f5;
            fArr2[2] = fArr2[2] / f5;
        }
        if (this.q > 0) {
            j2 = -1;
        } else {
            j2 = this.l ? 0L : this.w;
        }
        this.F.a.a.a(new ad(j, j2, this.v, this.f395n, i > 0 ? this.x : null, this.k ? this.z : null, fSqrt, fSqrt2, i2 > 0 ? this.C : null));
        this.l = false;
        this.q = 0L;
        a();
    }

    public final void c() {
        this.h.cancel(false);
        if (this.h.isDone() && !this.h.isCancelled()) {
            try {
                com.google.android.libraries.navigation.internal.aac.az.n(this.h);
            } catch (ExecutionException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 388)).p("Encountered exception when flushing sensors.");
            }
        }
        if (this.m) {
            this.h = this.t.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dh.ag
                @Override // java.lang.Runnable
                public final void run() {
                    ah ahVar = this.a;
                    ahVar.a.flush(ahVar);
                }
            }, 333000L, TimeUnit.MICROSECONDS);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener2
    public final void onFlushCompleted(Sensor sensor) {
        if (sensor.getType() == 16 || "android.sensor.gyroscope_limited_axes_uncalibrated".equals(sensor.getStringType())) {
            if (this.f == null || this.y > 0) {
                if (this.l || this.w > 0) {
                    b(this.j / 1000000);
                    this.E = this.j;
                    c();
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        char c;
        float[] fArr = sensorEvent.values;
        int type = sensorEvent.sensor.getType();
        if (type == 9) {
            float[] fArr2 = this.x;
            fArr2[0] = fArr2[0] + fArr[0];
            fArr2[1] = fArr2[1] + fArr[1];
            fArr2[2] = fArr2[2] + fArr[2];
            this.y++;
        } else if (type == 10) {
            float f = this.o;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            this.o = Math.max(f, (f2 * f2) + (f3 * f3) + (f4 * f4));
            float[] fArr3 = this.C;
            fArr3[0] = fArr3[0] + f2;
            fArr3[1] = fArr3[1] + fArr[1];
            fArr3[2] = fArr3[2] + fArr[2];
            this.D++;
        } else if (type == 14) {
            float[] fArr4 = this.z;
            fArr4[0] = fArr[0];
            fArr4[1] = fArr[1];
            fArr4[2] = fArr[2];
            this.k = true;
        } else if (type == 16) {
            if (fArr.length < 6 || this.u != null) {
                c = 2;
            } else {
                c = 2;
                this.u = new float[]{fArr[3], fArr[4], fArr[5]};
            }
            d(sensorEvent.timestamp, fArr[0], fArr[1], fArr[c], true, true);
        } else if ("android.sensor.gyroscope_limited_axes_uncalibrated".equals(sensorEvent.sensor.getStringType())) {
            float f5 = sensorEvent.values[0];
            float f6 = sensorEvent.values[1];
            float f7 = sensorEvent.values[2];
            float f8 = sensorEvent.values[3];
            float f9 = sensorEvent.values[4];
            float f10 = sensorEvent.values[5];
            float f11 = sensorEvent.values[6];
            boolean z = f11 != 0.0f;
            float f12 = sensorEvent.values[7];
            boolean z2 = f12 != 0.0f;
            if (sensorEvent.values[8] != 0.0f) {
                if (this.u == null) {
                    if (f11 == 0.0f) {
                        f8 = 0.0f;
                    }
                    if (f12 == 0.0f) {
                        f9 = 0.0f;
                    }
                    this.u = new float[]{f8, f9, f10};
                }
                d(sensorEvent.timestamp, f5, f6, f7, z, z2);
            }
        }
        if (Math.abs(sensorEvent.timestamp - this.E) > 33300000000L) {
            this.l = true;
            b(sensorEvent.timestamp / 1000000);
            this.E = sensorEvent.timestamp;
            c();
            return;
        }
        if (sensorEvent.timestamp >= this.E + 500000000) {
            if (this.f == null || this.y > 0) {
                if (this.l || this.w > 0) {
                    b(this.j / 1000000);
                    this.E = sensorEvent.timestamp;
                    c();
                    com.google.android.libraries.navigation.internal.kl.a aVar = this.i;
                    if (aVar != null) {
                        ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(22);
                    }
                }
            }
        }
    }
}
