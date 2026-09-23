package com.google.android.libraries.navigation.internal.de;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.view.WindowManager;
import androidx.collection.SimpleArrayMap;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.ds;
import com.google.android.libraries.navigation.internal.le.ao;
import com.google.android.libraries.navigation.internal.le.aq;
import com.google.android.libraries.navigation.internal.le.bb;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.oe.y;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.zr.bc;
import j$.time.Duration;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class v implements com.google.android.libraries.navigation.internal.cw.p {
    private static final com.google.android.libraries.navigation.internal.zb.j U = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.de.v");
    private static final long V = TimeUnit.HOURS.toMillis(2);
    static final long a = TimeUnit.SECONDS.toMillis(5);
    public static final fy b = fy.q("Google Inc.", "LG Electronics Inc.");
    public static final float c = (float) Math.cos(Math.toRadians(2.0d));
    public static final float d = (float) Math.cos(Math.toRadians(0.20000000298023224d));
    public static final float e = (float) Math.cos(Math.toRadians(1.0d));
    public static final float f = (float) Math.cos(Math.toRadians(0.10000000149011612d));
    public long E;
    public long F;
    public Sensor G;
    public WindowManager L;
    public final bn M;
    public final com.google.android.libraries.navigation.internal.mj.a P;
    public com.google.android.libraries.navigation.internal.lu.m S;
    public boolean T;
    private com.google.android.libraries.navigation.internal.lu.h ac;
    public final w h;
    public boolean k;
    public Context l;
    SensorManager m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Sensor f390n;
    public Sensor p;
    public com.google.android.libraries.navigation.internal.df.b q;
    public final ds r;
    public final boolean s;
    public Sensor u;
    public Sensor v;
    public Sensor w;
    public Sensor x;
    public final Object g = new Object();
    public boolean i = false;
    public com.google.android.libraries.navigation.internal.cw.n j = com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_NONE;
    private final a W = new a(true);
    private final a X = new a(false);
    public final float[] o = new float[3];
    public final float[] y = new float[3];
    public final float[] z = new float[3];
    public final float[] A = new float[3];
    public final float[] B = new float[3];
    public final float[] C = new float[3];
    public final float[] D = new float[3];
    public final float[] H = new float[4];
    public final float[] I = new float[4];
    public long J = Long.MIN_VALUE;
    public long K = Long.MIN_VALUE;
    private final float[] Y = new float[9];
    private final float[] Z = new float[9];
    private final int aa = -1;
    private final s ab = new s();
    public final AtomicInteger N = new AtomicInteger();
    final AtomicLong O = new AtomicLong(0);
    public long Q = Long.MIN_VALUE;
    public int R = 0;
    private Looper ad = null;
    private final SensorEventListener ae = new t(this);
    public final b t = new b();

    public v(l lVar, com.google.android.libraries.navigation.internal.mj.a aVar, bn bnVar, ds dsVar) {
        this.M = bnVar;
        this.h = new w(lVar, aVar);
        this.r = dsVar;
        this.s = dsVar.c;
        this.P = aVar;
        r(lVar.a(), aVar.f().toEpochMilli());
    }

    static float f(float[] fArr, float[] fArr2) {
        ar.a(fArr.length == fArr2.length);
        float f2 = 0.0f;
        for (int i = 0; i < fArr.length; i++) {
            f2 += fArr[i] * fArr2[i];
        }
        return f2;
    }

    public static String i(Sensor sensor) {
        return String.format(Locale.US, "sensor of %s \"%s\" v%d by %s", q(sensor.getType()), sensor.getName(), Integer.valueOf(sensor.getVersion()), sensor.getVendor());
    }

    static void j(float[] fArr, float[] fArr2) {
        ar.a(true);
        int i = 0;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            float f3 = fArr[i2];
            f2 += f3 * f3;
        }
        float fSqrt = (float) Math.sqrt(f2);
        if (fSqrt == 0.0f) {
            while (i < 3) {
                fArr2[i] = 0.0f;
                i++;
            }
        } else {
            while (i < 3) {
                fArr2[i] = fArr[i] / fSqrt;
                i++;
            }
        }
    }

    static boolean n(Sensor sensor, float[] fArr) {
        if (sensor != null && fArr != null) {
            if (sensor.getType() != 11 && sensor.getType() != 15) {
                return false;
            }
            if (fArr.length >= 3) {
                for (int i = 0; i < 3; i++) {
                    float f2 = fArr[i];
                    if (Float.isNaN(f2) || Math.abs(f2) > 1.0E-6f) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final SensorManager p() {
        if (this.m == null) {
            ar.q(this.l);
            this.m = (SensorManager) this.l.getSystemService("sensor");
        }
        SensorManager sensorManager = this.m;
        ar.q(sensorManager);
        return sensorManager;
    }

    private static String q(int i) {
        if (i == 1) {
            return "TYPE_ACCELEROMETER";
        }
        if (i == 2) {
            return "TYPE_MAGNETIC_FIELD";
        }
        if (i == 3) {
            return "TYPE_ORIENTATION";
        }
        if (i == 4) {
            return "TYPE_GYROSCOPE";
        }
        if (i != 11) {
            return i != 15 ? com.google.android.libraries.navigation.internal.b.b.b(i, "type ") : "TYPE_GAME_ROTATION_VECTOR";
        }
        return "TYPE_ROTATION_VECTOR";
    }

    private final void r(com.google.android.libraries.navigation.internal.db.r rVar, long j) {
        if (!this.s) {
            this.q = null;
            this.Q = Long.MIN_VALUE;
            return;
        }
        float f2 = rVar != null ? (float) rVar.b : Float.NaN;
        com.google.android.libraries.navigation.internal.df.b bVar = this.q;
        if (bVar == null) {
            this.q = new com.google.android.libraries.navigation.internal.df.b(f2, f2, f2, j);
            ar.q(this.P);
            if (this.O.compareAndSet(0L, this.P.f().toEpochMilli())) {
                ar.q(this.M);
                this.M.execute(new u(this));
            }
        } else {
            Long lValueOf = Long.valueOf(j);
            bVar.d();
            bVar.j = null;
            bVar.l = Long.MIN_VALUE;
            lValueOf.getClass();
            bVar.e(f2, f2, f2, j);
            bVar.v = Float.NaN;
        }
        this.Q = j;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void a() {
        Object obj;
        synchronized (this.g) {
            if (this.ac == null) {
                this.ac = new com.google.android.libraries.navigation.internal.lu.h() { // from class: com.google.android.libraries.navigation.internal.de.p
                    @Override // com.google.android.libraries.navigation.internal.lu.h
                    public final void a(com.google.android.libraries.navigation.internal.lu.f fVar) {
                        this.a.k(fVar);
                    }
                };
            }
            this.i = true;
            c(com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_SLOW);
            this.h.d();
            if (!o() || (obj = this.S) == null) {
                r(this.h.a(), this.h.b.f().toEpochMilli());
            } else {
                if (this.ad == null) {
                    this.ad = Looper.getMainLooper();
                }
                final com.google.android.libraries.navigation.internal.lu.j jVarA = new com.google.android.libraries.navigation.internal.lu.i().a();
                com.google.android.libraries.navigation.internal.lu.h hVar = this.ac;
                Looper looperMyLooper = this.ad;
                if (looperMyLooper == null) {
                    looperMyLooper = Looper.myLooper();
                    be.k(looperMyLooper, "invalid null looper");
                }
                final aq aqVarB = com.google.android.libraries.navigation.internal.le.ar.b(hVar, looperMyLooper, "h");
                bd bdVar = new bd() { // from class: com.google.android.libraries.navigation.internal.lv.p
                    @Override // com.google.android.libraries.navigation.internal.le.bd
                    public final void a(Object obj2, Object obj3) {
                        aq aqVar = aqVarB;
                        ah ahVar = (ah) obj2;
                        ao aoVar = (ao) Objects.requireNonNull(aqVar.b);
                        SimpleArrayMap simpleArrayMap = ahVar.u;
                        com.google.android.libraries.navigation.internal.lu.j jVar = jVarA;
                        synchronized (simpleArrayMap) {
                            ac acVar = (ac) ahVar.u.get(aoVar);
                            if (acVar == null) {
                                acVar = new ac(aqVar);
                                ahVar.u.put(aoVar, acVar);
                            } else {
                                acVar.c(aqVar);
                            }
                            ((l) ahVar.u()).h(new d(1, new b(jVar), acVar, new aa(null, (com.google.android.libraries.navigation.internal.me.aa) obj3)));
                        }
                    }
                };
                bd bdVar2 = new bd() { // from class: com.google.android.libraries.navigation.internal.lv.q
                    @Override // com.google.android.libraries.navigation.internal.le.bd
                    public final void a(Object obj2, Object obj3) {
                        ah ahVar = (ah) obj2;
                        ao aoVar = aqVarB.b;
                        if (aoVar != null) {
                            synchronized (ahVar.u) {
                                ac acVar = (ac) ahVar.u.remove(aoVar);
                                if (acVar == null) {
                                    ((com.google.android.libraries.navigation.internal.me.aa) obj3).b(Boolean.FALSE);
                                } else {
                                    acVar.b();
                                    ((l) ahVar.u()).h(new d(2, null, acVar, new aa(Boolean.TRUE, (com.google.android.libraries.navigation.internal.me.aa) obj3)));
                                }
                            }
                        }
                    }
                };
                bb bbVar = new bb();
                bbVar.a = bdVar;
                bbVar.b = bdVar2;
                bbVar.c = aqVarB;
                bbVar.f = 2434;
                ((com.google.android.libraries.navigation.internal.ld.o) obj).h(bbVar.a()).h(new com.google.android.libraries.navigation.internal.me.r() { // from class: com.google.android.libraries.navigation.internal.de.q
                    @Override // com.google.android.libraries.navigation.internal.me.r
                    public final void c(Exception exc) {
                        fy fyVar = v.b;
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(331)).p("Failed to request device orientation updates");
                    }
                });
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void b() {
        synchronized (this.g) {
            l();
            this.i = false;
            this.j = com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_NONE;
            this.G = null;
            this.p = null;
            this.x = null;
            this.f390n = null;
            this.u = null;
            this.v = null;
            this.q = null;
            this.Q = Long.MIN_VALUE;
            this.h.d();
            this.O.set(0L);
            if (o() && this.S != null) {
                ar.q(this.ac);
                ((com.google.android.libraries.navigation.internal.ld.o) this.S).i(com.google.android.libraries.navigation.internal.le.ar.a(this.ac, "h"), 2440).a(new com.google.android.libraries.navigation.internal.lv.r(), new com.google.android.libraries.navigation.internal.me.e() { // from class: com.google.android.libraries.navigation.internal.lv.o
                    @Override // com.google.android.libraries.navigation.internal.me.e
                    public final Object a(com.google.android.libraries.navigation.internal.me.w wVar) {
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void c(final com.google.android.libraries.navigation.internal.cw.n nVar) {
        final int iIncrementAndGet = this.N.incrementAndGet();
        this.M.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.de.r
            @Override // java.lang.Runnable
            public final void run() {
                int iB;
                v vVar = this.a;
                synchronized (vVar.g) {
                    if (!Build.HARDWARE.equals("goldfish") && !Build.HARDWARE.equals("ranchu") && !Build.HARDWARE.equals("cutf_cvm") && !Build.HARDWARE.equals("starfish")) {
                        if (vVar.i) {
                            if (iIncrementAndGet != vVar.N.get()) {
                                return;
                            }
                            com.google.android.libraries.navigation.internal.cw.n nVar2 = vVar.j;
                            com.google.android.libraries.navigation.internal.cw.n nVar3 = nVar;
                            if (nVar2 == nVar3) {
                                return;
                            }
                            vVar.j = nVar3;
                            if (nVar3.d.isZero()) {
                                iB = 3;
                            } else {
                                Duration duration = nVar3.d;
                                double d2 = com.google.android.libraries.navigation.internal.aaa.a.b;
                                iB = (int) (duration.getSeconds() < -9223372036854L ? com.google.android.libraries.navigation.internal.zw.g.b(com.google.android.libraries.navigation.internal.zw.g.c(duration.getSeconds() + 1, 1000000L), (duration.getNano() / 1000) - 1000000) : com.google.android.libraries.navigation.internal.zw.g.b(com.google.android.libraries.navigation.internal.zw.g.c(duration.getSeconds(), 1000000L), duration.getNano() / 1000));
                            }
                            vVar.l();
                            if (vVar.o()) {
                                return;
                            }
                            Sensor sensorH = vVar.h(iB, 11);
                            if (sensorH != null) {
                                vVar.G = sensorH;
                                Sensor sensorH2 = vVar.h(iB, 2);
                                if (sensorH2 != null) {
                                    vVar.w = sensorH2;
                                } else if (vVar.s) {
                                    vVar.q = null;
                                    vVar.Q = Long.MIN_VALUE;
                                }
                                if (vVar.s) {
                                    Sensor sensorH3 = vVar.h(iB, 15);
                                    if (sensorH3 != null) {
                                        vVar.v = sensorH3;
                                    } else {
                                        vVar.q = null;
                                        vVar.Q = Long.MIN_VALUE;
                                    }
                                }
                                return;
                            }
                            Sensor sensorH4 = vVar.h(iB, 2);
                            Sensor sensorH5 = vVar.h(iB, 1);
                            if (sensorH4 != null && sensorH5 != null) {
                                vVar.p = sensorH4;
                                vVar.x = sensorH5;
                                if (vVar.s) {
                                    Sensor sensorH6 = vVar.h(0, 4);
                                    if (sensorH6 != null) {
                                        vVar.u = sensorH6;
                                    } else {
                                        vVar.q = null;
                                        vVar.Q = Long.MIN_VALUE;
                                    }
                                }
                                return;
                            }
                            if (sensorH4 != null || sensorH5 != null) {
                                vVar.l();
                            }
                            if (vVar.s) {
                                vVar.q = null;
                                vVar.Q = Long.MIN_VALUE;
                            }
                            Sensor sensorH7 = vVar.h(iB, 3);
                            if (sensorH7 != null) {
                                vVar.f390n = sensorH7;
                                vVar.k = v.b.contains(sensorH7.getVendor());
                            }
                        }
                    }
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void d(h hVar) {
        synchronized (this.g) {
            this.h.c.put(hVar, null);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void e(h hVar) {
        synchronized (this.g) {
            this.h.c.remove(hVar);
        }
    }

    public final int g() {
        WindowManager windowManager = this.L;
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public final Sensor h(int i, int i2) {
        q(i2);
        Sensor defaultSensor = p().getDefaultSensor(i2);
        if (defaultSensor == null) {
            return null;
        }
        i(defaultSensor);
        if (p().registerListener(this.ae, defaultSensor, i, DateTimeConstants.MILLIS_PER_MINUTE)) {
            return defaultSensor;
        }
        return null;
    }

    public final void k(com.google.android.libraries.navigation.internal.lu.f fVar) {
        synchronized (this.g) {
            long epochMilli = this.h.b.f().toEpochMilli();
            if (o()) {
                synchronized (this.g) {
                    float f2 = this.j == com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_FAST ? 0.2f : 2.0f;
                    w wVar = this.h;
                    if (Math.abs(fVar.a - wVar.f) <= f2) {
                        if (wVar.f() && Math.abs(fVar.b - this.h.e) <= f2) {
                            long j = this.J;
                            if (j != Long.MIN_VALUE) {
                            }
                        }
                    }
                }
                synchronized (this.g) {
                    int i = bc.a;
                    this.J = epochMilli;
                    w wVar2 = this.h;
                    wVar2.f = fVar.a;
                    wVar2.e(fVar.b);
                    this.h.g(i, com.google.android.libraries.navigation.internal.zr.bd.a);
                    s sVar = this.ab;
                    w wVar3 = this.h;
                    if (sVar.a(epochMilli, wVar3.f, wVar3.g, this.j)) {
                        this.h.c();
                    }
                }
            }
        }
    }

    protected final void l() {
        p().unregisterListener(this.ae);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x010e  */
    final void m(long j, Sensor sensor) throws Throwable {
        int i;
        Object obj;
        float fAtan2;
        float f2;
        com.google.android.libraries.navigation.internal.df.b bVar;
        long j2;
        float[] fArr;
        com.google.android.libraries.navigation.internal.db.r rVarA;
        float fSignum;
        float fAbs;
        Object obj2 = this.g;
        synchronized (obj2) {
            try {
                try {
                    int i2 = com.google.android.libraries.navigation.internal.zr.bd.a;
                    if (sensor == this.f390n) {
                        i = bc.a;
                        float[] fArr2 = this.o;
                        fAtan2 = fArr2[0];
                        f2 = fArr2[1];
                        float f3 = fArr2[2];
                        int iG = g();
                        if (iG != 1) {
                            if (iG == 2) {
                                fAtan2 += 180.0f;
                                f2 = -f2;
                            } else if (iG == 3) {
                                if (Math.abs(f2) > 90.0f) {
                                    fAtan2 -= true != this.k ? 90.0f : -90.0f;
                                    fSignum = Math.signum(f3);
                                    fAbs = Math.abs(f3);
                                    f2 = fSignum * (180.0f - fAbs);
                                } else {
                                    fAtan2 -= 90.0f;
                                    obj = obj2;
                                    f2 = f3;
                                }
                            }
                            obj = obj2;
                        } else {
                            if (Math.abs(f2) > 90.0f) {
                                fAtan2 += true != this.k ? 90.0f : -90.0f;
                                fSignum = -Math.signum(f3);
                                fAbs = Math.abs(f3);
                                f2 = fSignum * (180.0f - fAbs);
                            } else {
                                fAtan2 += 90.0f;
                                f2 = -f3;
                            }
                            obj = obj2;
                        }
                    } else {
                        this.J = j;
                        if (sensor == this.G) {
                            i = bc.b;
                            System.arraycopy(this.H, 0, this.I, 0, 4);
                            SensorManager.getRotationMatrixFromVector(this.Y, this.H);
                        } else {
                            i = bc.c;
                            System.arraycopy(this.A, 0, this.C, 0, 3);
                            System.arraycopy(this.B, 0, this.D, 0, 3);
                            if (!SensorManager.getRotationMatrix(this.Y, null, this.z, this.y)) {
                                this.h.g(i, com.google.android.libraries.navigation.internal.zr.bd.b);
                                return;
                            }
                        }
                        ds dsVar = this.r;
                        if (dsVar == null || !dsVar.c || (bVar = this.q) == null) {
                            obj = obj2;
                        } else {
                            if (this.Q != Long.MIN_VALUE) {
                                long epochMilli = this.h.b.f().toEpochMilli();
                                com.google.android.libraries.navigation.internal.db.r rVarA2 = this.h.a();
                                if (rVarA2 != null) {
                                    obj = obj2;
                                    if (epochMilli - this.Q > V || Float.isNaN(bVar.t)) {
                                        float f4 = (float) rVarA2.b;
                                        float f5 = (float) rVarA2.c;
                                        float f6 = (float) rVarA2.e;
                                        Long.valueOf(epochMilli).getClass();
                                        bVar.e(f4, f5, f6, epochMilli);
                                        this.Q = epochMilli;
                                    }
                                } else {
                                    obj = obj2;
                                }
                            } else {
                                obj = obj2;
                            }
                            float[] fArr3 = this.Y;
                            long j3 = this.K;
                            int i3 = this.R;
                            if (bVar.j == null) {
                                bVar.j = new float[9];
                            }
                            System.arraycopy(fArr3, 0, bVar.j, 0, 9);
                            bVar.l = j3;
                            bVar.i.d(bVar.j);
                            com.google.android.libraries.navigation.internal.df.f fVar = bVar.s;
                            if (fVar != null) {
                                float fA = bVar.a(i3, bVar.j);
                                bVar.k = fA;
                                j2 = j3;
                                long j4 = bVar.l;
                                if (!Float.isNaN(fA)) {
                                    float f7 = fVar.i;
                                    if (Float.isNaN(f7)) {
                                        fVar.i = fA;
                                    } else {
                                        fVar.i = com.google.android.libraries.navigation.internal.df.d.b((y.d(fA, f7) * 0.7f) + fA, -180.0f, 180.0f);
                                    }
                                    fVar.j = j4;
                                    fVar.d(Long.valueOf(j4));
                                }
                            } else {
                                j2 = j3;
                            }
                            bVar.b(j2);
                            if (bVar.g(this.K)) {
                                if (bVar.g(this.K)) {
                                    bVar.g.b(bVar.h);
                                    fArr = bVar.h;
                                } else {
                                    fArr = null;
                                }
                                if (fArr != null) {
                                    System.arraycopy(fArr, 0, this.Y, 0, 9);
                                }
                                w wVar = this.h;
                                float f8 = bVar.v;
                                if (true == Float.isNaN(f8)) {
                                    f8 = Float.NaN;
                                }
                                wVar.e(f8);
                            } else {
                                this.h.d();
                            }
                        }
                        int iG2 = g();
                        int i4 = 129;
                        int i5 = 1;
                        if (iG2 == 1) {
                            i5 = 2;
                        } else if (iG2 == 2) {
                            i5 = 129;
                            i4 = 130;
                        } else if (iG2 != 3) {
                            i4 = 2;
                        } else {
                            i4 = 1;
                            i5 = 130;
                        }
                        if (!SensorManager.remapCoordinateSystem(this.Y, i5, i4, this.Z)) {
                            i2 = com.google.android.libraries.navigation.internal.zr.bd.c;
                        }
                        float[] fArr4 = this.Z;
                        double d2 = -Math.atan2(fArr4[7], fArr4[8]);
                        fAtan2 = (float) ((Math.atan2(fArr4[0], fArr4[3]) * 57.2957763671875d) - 90.0d);
                        f2 = (float) (d2 * 57.2957763671875d);
                    }
                    if (Float.isNaN(fAtan2) || n(sensor, this.H)) {
                        f2 = f2;
                        this.h.f = -1.0f;
                        i2 = com.google.android.libraries.navigation.internal.zr.bd.c;
                    } else {
                        float fC = com.google.android.libraries.navigation.internal.nq.a.c(fAtan2);
                        w wVar2 = this.h;
                        long jA = wVar2.b.a();
                        if (jA - wVar2.j > w.a && (rVarA = wVar2.m.a()) != null) {
                            wVar2.j = jA;
                            wVar2.k = new GeomagneticField((float) rVarA.b, (float) rVarA.c, (float) rVarA.e, jA).getDeclination();
                        }
                        this.h.f = this.W.a(j, com.google.android.libraries.navigation.internal.nq.a.c(fC + wVar2.k));
                    }
                    if (Float.isNaN(f2)) {
                        this.h.g = -1000.0f;
                        i2 = com.google.android.libraries.navigation.internal.zr.bd.e;
                    } else {
                        this.h.g = f2 != -1000.0f ? this.X.a(j, f2) : f2;
                    }
                    this.h.g(i, i2);
                    s sVar = this.ab;
                    w wVar3 = this.h;
                    if (sVar.a(j, wVar3.f, wVar3.g, this.j)) {
                        this.h.c();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final boolean o() {
        return false;
    }
}
