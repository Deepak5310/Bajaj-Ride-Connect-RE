package com.google.android.libraries.navigation.internal.de;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t implements SensorEventListener {
    final /* synthetic */ v a;

    public t(v vVar) {
        this.a = vVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
        float f;
        synchronized (this.a.g) {
            v vVar = this.a;
            if (sensor == vVar.w) {
                if (vVar.r.c && vVar.q != null) {
                    synchronized (vVar.g) {
                        f = vVar.h.e;
                    }
                    i = com.google.android.libraries.navigation.internal.cw.o.a((int) f);
                }
                w wVar = this.a.h;
                wVar.d = i;
                wVar.b();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        com.google.android.libraries.navigation.internal.df.f fVar;
        synchronized (this.a.g) {
            long jA = this.a.h.b.a();
            int i = 0;
            if (sensorEvent.sensor == this.a.f390n) {
                System.arraycopy(sensorEvent.values, 0, this.a.o, 0, 3);
            } else if (sensorEvent.sensor == this.a.p) {
                System.arraycopy(sensorEvent.values, 0, this.a.y, 0, 3);
                v vVar = this.a;
                v.j(vVar.y, vVar.A);
                v vVar2 = this.a;
                vVar2.E = jA;
                com.google.android.libraries.navigation.internal.df.b bVar = vVar2.q;
                if (bVar != null) {
                    bVar.f(vVar2.y, sensorEvent.accuracy, TimeUnit.NANOSECONDS.toMillis(sensorEvent.timestamp));
                }
            } else {
                if (sensorEvent.sensor != this.a.x) {
                    if (sensorEvent.sensor == this.a.G) {
                        System.arraycopy(sensorEvent.values, 0, this.a.H, 0, Math.min(sensorEvent.values.length, 4));
                        if (sensorEvent.values.length == 3) {
                            float[] fArr = this.a.H;
                            float f = 0.0f;
                            for (int i2 = 0; i2 < 3; i2++) {
                                float f2 = fArr[i2];
                                f += f2 * f2;
                            }
                            fArr[3] = (float) Math.sqrt(1.0d - ((double) Math.min(f, 1.0f)));
                        }
                        v vVar3 = this.a;
                        if (v.n(vVar3.G, vVar3.H)) {
                            return;
                        }
                        if (sensorEvent.values.length >= 5) {
                            synchronized (this.a.g) {
                                this.a.h.l = Float.valueOf(sensorEvent.values[4]);
                            }
                        }
                        throw th;
                    }
                    Sensor sensor = sensorEvent.sensor;
                    v vVar4 = this.a;
                    if (sensor == vVar4.w) {
                        com.google.android.libraries.navigation.internal.df.b bVar2 = vVar4.q;
                        if (bVar2 != null && sensorEvent.values.length >= 3) {
                            bVar2.f(Arrays.copyOf(sensorEvent.values, 3), sensorEvent.accuracy, TimeUnit.NANOSECONDS.toMillis(sensorEvent.timestamp));
                        }
                        return;
                    }
                    Sensor sensor2 = sensorEvent.sensor;
                    v vVar5 = this.a;
                    if (sensor2 == vVar5.u && vVar5.v == null) {
                        com.google.android.libraries.navigation.internal.df.b bVar3 = vVar5.q;
                        if (bVar3 != null) {
                            float[] fArr2 = sensorEvent.values;
                            long j = sensorEvent.timestamp;
                            int i3 = this.a.R;
                            if (bVar3.m > 0 && TimeUnit.NANOSECONDS.toSeconds(j - bVar3.m) > 1) {
                                bVar3.d();
                            }
                            System.arraycopy(fArr2, 0, bVar3.b, 0, 3);
                            bVar3.m = j;
                            bVar3.c(j, i3);
                        }
                        return;
                    }
                    Sensor sensor3 = sensorEvent.sensor;
                    v vVar6 = this.a;
                    Sensor sensor4 = vVar6.v;
                    if (sensor3 != sensor4 || vVar6.u != null) {
                        v.i(sensorEvent.sensor);
                        return;
                    }
                    com.google.android.libraries.navigation.internal.df.b bVar4 = vVar6.q;
                    if (bVar4 != null) {
                        if (v.n(sensor4, sensorEvent.values)) {
                            return;
                        }
                        float[] fArr3 = sensorEvent.values;
                        long j2 = sensorEvent.timestamp;
                        int i4 = this.a.R;
                        long millis = TimeUnit.NANOSECONDS.toMillis(j2);
                        float[] fArr4 = bVar4.j;
                        if (fArr4 != null && (fVar = bVar4.s) != null) {
                            SensorManager.getQuaternionFromVector(bVar4.w, fArr3);
                            x xVar = bVar4.y;
                            float[] fArr5 = bVar4.w;
                            xVar.h(fArr5[1], fArr5[2], fArr5[3], fArr5[0]);
                            if (bVar4.o) {
                                x xVar2 = bVar4.d;
                                x xVar3 = bVar4.x;
                                x xVar4 = bVar4.y;
                                float f3 = xVar3.d;
                                float f4 = xVar4.a;
                                float f5 = xVar3.a;
                                float f6 = xVar4.d;
                                float f7 = xVar3.b;
                                float f8 = xVar4.c;
                                float f9 = xVar3.c;
                                float f10 = xVar4.b;
                                xVar2.a = (((f3 * f4) - (f5 * f6)) - (f7 * f8)) + (f9 * f10);
                                xVar2.b = (((f3 * f10) + (f5 * f8)) - (f7 * f6)) - (f9 * f4);
                                xVar2.c = (((f3 * f8) - (f5 * f10)) + (f7 * f4)) - (f9 * f6);
                                xVar2.d = (f3 * f6) + (f5 * f4) + (f7 * f10) + (f9 * f8);
                                xVar3.i(xVar4);
                                x xVar5 = bVar4.g;
                                xVar5.e(xVar5, bVar4.d);
                                xVar5.f(xVar5);
                                SensorManager.getRotationMatrixFromVector(bVar4.e, fArr3);
                                float fA = bVar4.a(i4, bVar4.e);
                                bVar4.f = fA;
                                fVar.c(fA, millis);
                                if (millis - bVar4.u > 1000) {
                                    bVar4.g.b(bVar4.h);
                                    bVar4.a(i4, bVar4.h);
                                    bVar4.u = millis;
                                }
                                bVar4.b(millis);
                            } else {
                                System.arraycopy(fArr4, 0, bVar4.h, 0, 9);
                                bVar4.g.d(bVar4.h);
                                bVar4.x.i(bVar4.y);
                                bVar4.o = true;
                            }
                        }
                    }
                    return;
                }
                System.arraycopy(sensorEvent.values, 0, this.a.z, 0, 3);
                v vVar7 = this.a;
                v.j(vVar7.z, vVar7.B);
                this.a.F = jA;
            }
            v vVar8 = this.a;
            Sensor sensor5 = sensorEvent.sensor;
            synchronized (vVar8.g) {
                if (sensor5 != vVar8.f390n) {
                    if (sensor5 == vVar8.G) {
                        if (vVar8.J != Long.MIN_VALUE) {
                            while (true) {
                                if (i >= 4) {
                                    if (Math.abs(v.f(vVar8.H, vVar8.I)) < (vVar8.j == com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_FAST ? v.f : v.e)) {
                                        break;
                                    }
                                } else if (Float.isNaN(vVar8.H[i]) != Float.isNaN(vVar8.I[i])) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                    } else if (sensor5 != vVar8.u && sensor5 != vVar8.v) {
                        if (Math.abs(vVar8.E - vVar8.F) <= v.a) {
                            if (vVar8.J != Long.MIN_VALUE) {
                                double d = vVar8.j == com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_FAST ? v.d : v.c;
                                if (v.f(vVar8.A, vVar8.C) < d || v.f(vVar8.B, vVar8.D) < d) {
                                }
                            }
                        }
                    }
                }
                v vVar9 = this.a;
                if (vVar9.q != null) {
                    vVar9.K = TimeUnit.NANOSECONDS.toMillis(sensorEvent.timestamp);
                }
                this.a.m(jA, sensorEvent.sensor);
            }
        }
    }
}
