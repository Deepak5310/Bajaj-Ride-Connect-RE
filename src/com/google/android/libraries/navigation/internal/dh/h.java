package com.google.android.libraries.navigation.internal.dh;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements SensorEventListener {
    public final SensorManager a;
    public final Sensor b;
    public com.google.android.libraries.navigation.internal.kl.a c;
    private final com.google.android.libraries.navigation.internal.ia.e d;
    private final com.google.android.libraries.navigation.internal.mj.a e;
    private long f = 0;

    public h(com.google.android.libraries.navigation.internal.ia.e eVar, SensorManager sensorManager, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.d = eVar;
        this.e = aVar;
        this.a = sensorManager;
        this.b = sensorManager.getDefaultSensor(6);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (sensorEvent.sensor.getType() != 6 || fArr.length <= 0 || sensorEvent.timestamp - this.f < 9.0E8d) {
            return;
        }
        this.f = sensorEvent.timestamp;
        long jA = this.e.a();
        long j = sensorEvent.timestamp / 1000000;
        long j2 = jA - 500;
        if (j < j2) {
            com.google.android.libraries.navigation.internal.kl.a aVar = this.c;
            if (aVar != null) {
                ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(17);
            }
            j = j2;
        }
        this.d.a(new g(j, fArr[0] * 100.0f));
    }
}
