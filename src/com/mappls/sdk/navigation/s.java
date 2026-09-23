package com.mappls.sdk.navigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.google.android.gms.common.ConnectionResult;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.util.MapplsNavigationMode;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class s {
    public final j<Boolean> A;
    public final t<com.mappls.sdk.navigation.d> A0;
    public final j B;
    public final j B0;
    public final j<Boolean> C;
    public final j C0;
    public final j D;
    public final j D0;
    public final j E;
    private SharedPreferences E0;
    public final j F;
    private SharedPreferences F0;
    public final j G;
    private Object G0;
    public final j H;
    private com.mappls.sdk.navigation.d H0;
    public final j I;
    public final t<com.mappls.sdk.navigation.d> I0;
    public final j J;
    private boolean J0;
    public final j K;
    private p K0;
    public final j L;
    public final j M;
    public final j N;
    public final j O;
    public final j P;
    public final j Q;
    public final j R;
    public final j S;
    public final j T;
    public final j U;
    public final j V;
    public final j W;
    public final j X;
    public final j Y;
    public final j Z;
    public final j a;
    public final j a0;
    public final j b;
    public final j b0;
    public final j c;
    public final j c0;
    public final j d;
    public final j d0;
    public final j e;
    public final j<Integer> e0;
    public final j f;
    public final j<Float> f0;
    public final j g;
    public final j<Float> g0;
    public final j h;
    public final j<Float> h0;
    public final j i;
    public final j i0;
    public final j j;
    public final j<Integer> j0;
    public final j k;
    public final j<Integer> k0;
    public final j l;
    public final j l0;
    public final j m;
    public final j m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f714n;
    public final j n0;
    public final j o;
    public final j<Boolean> o0;
    public final j p;
    public final j p0;
    public final j<k> q;
    public final j q0;
    public final j<Float> r;
    public final j r0;
    public final j<MapplsNavigationMode> s;
    public final j s0;
    public final j<String> t;
    public final j t0;
    public final j u;
    public final j u0;
    public final j<Boolean> v;
    public final j v0;
    public final j<Boolean> w;
    private final Context w0;
    public final j<Boolean> x;
    public final j x0;
    public final j<Integer> y;
    private final j y0;
    public final j<Boolean> z;
    private com.mappls.sdk.navigation.apis.c z0;

    final class a extends o {
        a() {
            super(s.this, "audio_stream", 3, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mappls.sdk.navigation.s.o, com.mappls.sdk.navigation.s.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean b(Object obj, Integer num) {
            j jVar;
            int i;
            int iValueOf;
            boolean zB = super.b(obj, num);
            if (zB) {
                com.mappls.sdk.navigation.voice.e eVar = NavigationContext.getNavigationContext().f705n;
                if (eVar != null) {
                    eVar.a(get().intValue());
                }
                com.mappls.sdk.navigation.d dVar = s.this.H0;
                if (num.intValue() == 3) {
                    jVar = s.this.m0;
                    i = 12;
                } else if (num.intValue() == 5) {
                    jVar = s.this.m0;
                    iValueOf = 5;
                    jVar.a(dVar, iValueOf);
                } else if (num.intValue() == 0) {
                    jVar = s.this.m0;
                    i = 2;
                }
                iValueOf = Integer.valueOf(i);
                jVar.a(dVar, iValueOf);
            }
            return zB;
        }
    }

    final class b extends m<v> {
        final /* synthetic */ s l;

        /* JADX WARN: Illegal instructions before constructor call */
        b(s sVar, v[] vVarArr) {
            v vVar = v.KILOMETERS_PER_HOUR;
            this.l = sVar;
            super(sVar, "speed_system", vVar, vVarArr, 0);
        }

        @Override // com.mappls.sdk.navigation.s.j
        public final Object b(com.mappls.sdk.navigation.d dVar) {
            EnumC0101s enumC0101s = (EnumC0101s) this.l.C0.get();
            if (dVar.a(com.mappls.sdk.navigation.d.k)) {
                if (enumC0101s == EnumC0101s.KILOMETERS_AND_METERS) {
                    return v.MINUTES_PER_KILOMETER;
                }
            } else {
                if (dVar.a(com.mappls.sdk.navigation.d.l) || enumC0101s == EnumC0101s.NAUTICAL_MILES) {
                    return v.NAUTICALMILES_PER_HOUR;
                }
                if (enumC0101s == EnumC0101s.KILOMETERS_AND_METERS) {
                    return v.KILOMETERS_PER_HOUR;
                }
            }
            return v.MILES_PER_HOUR;
        }
    }

    final class c extends w {
        c(s sVar) {
            super(sVar, "voice_provider", "en-tts", 0);
        }
    }

    final class d extends j<com.mappls.sdk.navigation.d> {
        d(com.mappls.sdk.navigation.d dVar) {
            super("default_application_mode_string", dVar);
            c();
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final com.mappls.sdk.navigation.d a(Object obj, com.mappls.sdk.navigation.d dVar) {
            com.mappls.sdk.navigation.d dVar2 = dVar;
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            String strB = b();
            String strG = dVar2.g();
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return com.mappls.sdk.navigation.d.a(((SharedPreferences) obj).getString(strB, strG), dVar2);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final boolean b(Object obj, com.mappls.sdk.navigation.d dVar) {
            return ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj).putString(b(), dVar.g()).commit();
        }
    }

    final class e extends m<l> {
        e(l lVar, l[] lVarArr) {
            super(s.this, "default_driving_region", lVar, lVarArr, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mappls.sdk.navigation.s.m, com.mappls.sdk.navigation.s.j
        public final boolean b(Object obj, l lVar) {
            if (lVar != null) {
                s.this.C0.set(lVar.b);
            }
            return super.b(obj, lVar);
        }
    }

    final class f extends m<EnumC0101s> {
        f(s sVar, EnumC0101s[] enumC0101sArr) {
            super(sVar, "metric_system", EnumC0101s.KILOMETERS_AND_METERS, enumC0101sArr, 0);
        }
    }

    final class g extends u<com.mappls.sdk.navigation.d> {
        g() {
            super(0);
        }

        @Override // com.mappls.sdk.navigation.s.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean set(com.mappls.sdk.navigation.d dVar) {
            com.mappls.sdk.navigation.d dVar2 = s.this.H0;
            boolean zCommit = ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(s.this.E0).putString("navigation_mode", dVar.g()).commit();
            if (zCommit) {
                s.this.H0 = dVar;
                s sVar = s.this;
                sVar.G0 = sVar.a(sVar.H0);
                a(dVar2);
            }
            return zCommit;
        }

        @Override // com.mappls.sdk.navigation.s.t
        public final Object get() {
            return s.this.H0;
        }
    }

    private class h extends i {
        private h(s sVar, String str, boolean z) {
            super(sVar, str, z, 0);
        }

        /* synthetic */ h(s sVar, String str, boolean z, int i) {
            this(sVar, str, z);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mappls.sdk.navigation.s.i
        protected final Boolean a(Object obj, Boolean bool) {
            return super.a(obj, bool);
        }

        @Override // com.mappls.sdk.navigation.s.i, com.mappls.sdk.navigation.s.j
        protected final Boolean a(Object obj, Boolean bool) {
            return super.a(obj, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mappls.sdk.navigation.s.i, com.mappls.sdk.navigation.s.j
        public final boolean b(Object obj, Boolean bool) {
            return NavigationContext.getNavigationContext().a() && super.b(obj, bool);
        }
    }

    private class i extends j<Boolean> {
        private i(String str, boolean z) {
            super(str, Boolean.valueOf(z));
        }

        /* synthetic */ i(s sVar, String str, boolean z, int i) {
            this(str, z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mappls.sdk.navigation.s.j
        public Boolean a(Object obj, Boolean bool) {
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            String strB = b();
            boolean zBooleanValue = bool.booleanValue();
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return Boolean.valueOf(((SharedPreferences) obj).getBoolean(strB, zBooleanValue));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mappls.sdk.navigation.s.j
        public boolean b(Object obj, Boolean bool) {
            return ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj).putBoolean(b(), bool.booleanValue()).commit();
        }
    }

    public abstract class j<T> extends u<T> {
        private final String b;
        private boolean c;
        private T d;
        private Object e;
        private boolean f;
        private LinkedHashMap g;
        private T h;

        public j(String str, T t) {
            super(0);
            this.b = str;
            this.h = t;
        }

        public final j<T> a() {
            this.f = true;
            return this;
        }

        public final T a(com.mappls.sdk.navigation.d dVar) {
            if (this.c) {
                return get();
            }
            return a(s.this.a(dVar), b(dVar));
        }

        protected abstract T a(Object obj, T t);

        public final void a(com.mappls.sdk.navigation.d dVar, T t) {
            if (this.g == null) {
                this.g = new LinkedHashMap();
            }
            this.g.put(dVar, t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean a(com.mappls.sdk.navigation.d dVar, Integer num) {
            if (this.c) {
                return set(num);
            }
            boolean zB = b(s.this.a(dVar), num);
            super.a(num);
            return zB;
        }

        public T b(com.mappls.sdk.navigation.d dVar) {
            if (this.c) {
                return this.h;
            }
            LinkedHashMap linkedHashMap = this.g;
            if (linkedHashMap != null && linkedHashMap.containsKey(dVar)) {
                return (T) this.g.get(dVar);
            }
            com.mappls.sdk.navigation.d dVarF = dVar.f();
            if (dVarF != null) {
                return b(dVarF);
            }
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            SharedPreferences sharedPreferences = s.this.F0;
            String str = this.b;
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return sharedPreferences.contains(str) ? a(s.this.F0, this.h) : this.h;
        }

        public final String b() {
            return this.b;
        }

        protected abstract boolean b(Object obj, T t);

        public final j<T> c() {
            this.c = true;
            return this;
        }

        public final j<T> d() {
            this.c = false;
            return this;
        }

        @Override // com.mappls.sdk.navigation.s.t
        public final T get() {
            if (this.f && this.d != null) {
                if (this.e == (this.c ? s.this.E0 : s.this.G0)) {
                    return this.d;
                }
            }
            Object obj = this.c ? s.this.E0 : s.this.G0;
            this.e = obj;
            T tA = a(obj, b(s.this.H0));
            this.d = tA;
            return tA;
        }

        @Override // com.mappls.sdk.navigation.s.t
        public final boolean set(T t) {
            Object obj = this.c ? s.this.E0 : s.this.G0;
            if (!b(obj, t)) {
                return false;
            }
            this.d = t;
            this.e = obj;
            super.a(t);
            return true;
        }
    }

    public enum k {
        AUTO,
        DAY,
        NIGHT,
        SENSOR
    }

    public enum l {
        EUROPE_ASIA;

        public final boolean a;
        public final EnumC0101s b;

        l() {
            EnumC0101s enumC0101s = EnumC0101s.KILOMETERS_AND_METERS;
            this.b = enumC0101s;
            this.a = true;
        }
    }

    private class m<E extends Enum<E>> extends j<E> {
        private final E[] j;

        private m(String str, E e, E[] eArr) {
            super(str, e);
            this.j = eArr;
        }

        /* synthetic */ m(s sVar, String str, Enum r3, Enum[] enumArr, int i) {
            this(str, r3, enumArr);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final Object a(Object obj, Object obj2) {
            Enum r5 = (Enum) obj2;
            try {
                com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
                String strB = b();
                ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
                int i = ((SharedPreferences) obj).getInt(strB, -1);
                if (i < 0) {
                    return r5;
                }
                E[] eArr = this.j;
                return i < eArr.length ? eArr[i] : r5;
            } catch (ClassCastException e) {
                NavigationLogger.d(e);
                b(obj, r5);
                return r5;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.mappls.sdk.navigation.s.j
        /* JADX INFO: renamed from: a */
        public boolean b(Object obj, E e) {
            return ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj).a(e.ordinal(), b()).commit();
        }
    }

    private class n extends j<Float> {
        private n(String str, float f) {
            super(str, Float.valueOf(f));
        }

        /* synthetic */ n(s sVar, String str, float f, int i) {
            this(str, f);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final Float a(Object obj, Float f) {
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            String strB = b();
            float fFloatValue = f.floatValue();
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return Float.valueOf(((SharedPreferences) obj).getFloat(strB, fFloatValue));
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final boolean b(Object obj, Float f) {
            return ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj).putFloat(b(), f.floatValue()).commit();
        }
    }

    private class o extends j<Integer> {
        private o(String str, int i) {
            super(str, Integer.valueOf(i));
        }

        /* synthetic */ o(s sVar, String str, int i, int i2) {
            this(str, i);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final Integer a(Object obj, Integer num) {
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            String strB = b();
            int iIntValue = num.intValue();
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return Integer.valueOf(((SharedPreferences) obj).getInt(strB, iIntValue));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mappls.sdk.navigation.s.j
        /* JADX INFO: renamed from: a */
        public boolean b(Object obj, Integer num) {
            return ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj).a(num.intValue(), b()).commit();
        }
    }

    private class p extends r {
        public p() {
            super();
            this.a = "intermediate_points";
            this.b = "intermediate_points_description";
        }

        public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    sb.append(";");
                }
                sb.append((String) arrayList.get(i));
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (i2 > 0) {
                    sb2.append("--");
                }
                sb2.append(arrayList2.get(i2) == null ? "" : (String) arrayList2.get(i2));
            }
            boolean zCommit = ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(s.this.E0).putString(this.a, sb.toString()).putString(this.b, sb2.toString()).commit();
            s.this.a();
            return zCommit;
        }
    }

    private class q extends j<Long> {
        private q(String str, long j) {
            super(str, Long.valueOf(j));
        }

        /* synthetic */ q(s sVar, String str, long j, int i) {
            this(str, j);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final Long a(Object obj, Long l) {
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            String strB = b();
            long jLongValue = l.longValue();
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return Long.valueOf(((SharedPreferences) obj).getLong(strB, jLongValue));
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final boolean b(Object obj, Long l) {
            return ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj).putLong(b(), l.longValue()).commit();
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.s$s, reason: collision with other inner class name */
    public enum EnumC0101s {
        KILOMETERS_AND_METERS,
        MILES_AND_FEET,
        MILES_AND_METERS,
        MILES_AND_YARDS,
        NAUTICAL_MILES
    }

    public interface t<T> {
        void a(com.mappls.sdk.navigation.v<T> vVar);

        void a(com.mappls.sdk.navigation.voice.e eVar);

        T get();

        boolean set(T t);
    }

    private abstract class u<T> implements t<T> {
        private LinkedList a;

        private u() {
            this.a = null;
        }

        /* synthetic */ u(int i) {
            this();
        }

        @Override // com.mappls.sdk.navigation.s.t
        public synchronized void a(com.mappls.sdk.navigation.v<T> vVar) {
            if (this.a == null) {
                this.a = new LinkedList();
            }
            if (!this.a.contains(new WeakReference(vVar))) {
                this.a.add(new WeakReference(vVar));
            }
        }

        @Override // com.mappls.sdk.navigation.s.t
        public synchronized void a(com.mappls.sdk.navigation.voice.e eVar) {
            LinkedList linkedList = this.a;
            if (linkedList != null) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    if (((com.mappls.sdk.navigation.v) ((WeakReference) it2.next()).get()) == eVar) {
                        it2.remove();
                    }
                }
            }
        }

        public synchronized void a(T t) {
            LinkedList linkedList = this.a;
            if (linkedList != null) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    com.mappls.sdk.navigation.v vVar = (com.mappls.sdk.navigation.v) ((WeakReference) it2.next()).get();
                    if (vVar == null) {
                        it2.remove();
                    } else {
                        vVar.a(t);
                    }
                }
            }
        }
    }

    public enum v {
        KILOMETERS_PER_HOUR(R.string.mappls_km_h),
        MILES_PER_HOUR(R.string.mappls_mile_per_hour),
        METERS_PER_SECOND(R.string.mappls_m_s),
        MINUTES_PER_MILE(R.string.mappls_min_mile),
        MINUTES_PER_KILOMETER(R.string.mappls_min_km),
        NAUTICALMILES_PER_HOUR(R.string.mappls_nm_h);

        private final int a;

        v(int i) {
            this.a = i;
        }

        public final String a(Context context) {
            return context.getString(this.a);
        }
    }

    private class w extends j<String> {
        private w(String str, String str2) {
            super(str, str2);
        }

        /* synthetic */ w(s sVar, String str, String str2, int i) {
            this(str, str2);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final String a(Object obj, String str) {
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            String strB = b();
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            return ((SharedPreferences) obj).getString(strB, str);
        }

        @Override // com.mappls.sdk.navigation.s.j
        protected final boolean b(Object obj, String str) {
            String strTrim = str;
            com.mappls.sdk.navigation.apis.c.a aVarA = ((com.mappls.sdk.navigation.apis.d) s.this.z0).a(obj);
            String strB = b();
            if (strTrim != null) {
                strTrim = strTrim.trim();
            }
            return aVarA.putString(strB, strTrim).commit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected s(Context context, com.mappls.sdk.navigation.apis.d dVar) {
        new w(this, "available_navigation_modes", "car,bicycle,pedestrian", 0).c().a();
        this.a = new w(this, "route_options", null, null == true ? 1 : 0).c();
        this.b = new o(this, "refresh_interval", DateTimeConstants.MILLIS_PER_MINUTE, null == true ? 1 : 0).c();
        String str = "event_refresh_interval";
        this.c = new o(this, str, 300000, null == true ? 1 : 0).c();
        new o(this, str, 600000, null == true ? 1 : 0).c();
        int i2 = 200;
        this.d = new o(this, "safety_event_visual_before", i2, null == true ? 1 : 0).c();
        this.e = new o(this, "safety_event_audio_before", i2, null == true ? 1 : 0).c();
        this.f = new i(this, "enable_eta_vs_ata_logging", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.g = new o(this, "show_junction_view_before", i2, null == true ? 1 : 0).c();
        this.h = new o(this, "show_congestion_delay_view_before", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.i = new m(this, "accessibility_mode", com.mappls.sdk.navigation.apis.a.DEFAULT, com.mappls.sdk.navigation.apis.a.values(), 0).c().a();
        float f2 = 1.0f;
        Float fValueOf = Float.valueOf(1.0f);
        this.j = new n(this, "speech_rate", f2, null == true ? 1 : 0).c();
        this.k = new n(this, "arrival_distance_factor", f2, null == true ? 1 : 0).d();
        Float fValueOf2 = Float.valueOf(5.0f);
        new n(this, "speed_limit_exceed", 5.0f, null == true ? 1 : 0).d();
        this.l = new h(this, "disable_offroute_recalc", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.m = new h(this, "disable_wrong_direction_recalc", true, null == true ? 1 : 0).c();
        this.f714n = new i(this, "use_magnetic_field_sensor_compass", null == true ? 1 : 0, null == true ? 1 : 0).c().a();
        this.o = new i(this, "use_kalman_filter_compass", null == true ? 1 : 0, null == true ? 1 : 0).c().a();
        j<Float> jVarA = new n(this, "text_scale", f2, null == true ? 1 : 0).d().a();
        j<Float> jVarA2 = new n(this, "map_density_n", f2, null == true ? 1 : 0).d().a();
        String str2 = "";
        this.p = new w(this, "preferred_locale", str2, null == true ? 1 : 0).c();
        k kVar = k.AUTO;
        m mVar = new m(this, "daynight_mode", kVar, k.values(), 0);
        this.q = mVar;
        j<Float> jVarD = new n(this, "mappls_position_tolerance", 25.0f, null == true ? 1 : 0).d();
        this.r = jVarD;
        this.s = new m(this, "navigation_mode", MapplsNavigationMode.ONLINE, MapplsNavigationMode.values(), 0);
        this.t = new w(this, "offline_base_url", "http://localhost:1271/", null == true ? 1 : 0);
        this.u = new m(this, "mappls_router_service", com.mappls.sdk.navigation.routing.c.a.OSRM, com.mappls.sdk.navigation.routing.c.a.values(), 0).d();
        j<Boolean> jVarA3 = new i(this, "snap_to_road", true, null == true ? 1 : 0).d().a();
        this.v = jVarA3;
        this.w = new i(this, "interrupt_music", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.x = new i(this, "save_global_track_to_gpx", null == true ? 1 : 0, null == true ? 1 : 0).c().a();
        this.y = new o(this, "save_global_track_interval", NavigationConstants.UI_HANDLER_LOCATION_SERVICE, null == true ? 1 : 0).c().a();
        boolean z = true;
        this.z = new i(this, "save_global_track_remember", z, null == true ? 1 : 0).c().a();
        j<Boolean> jVarA4 = new i(this, "save_track_to_gpx", z, null == true ? 1 : 0).d().a();
        this.A = jVarA4;
        new i(this, "disable_recording_once_app_killed", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.B = new i(this, "fast_route_mode", z, null == true ? 1 : 0).d();
        j<Boolean> jVarA5 = new i(this, "show_traffic_warnings", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        this.C = jVarA5;
        j<Boolean> jVarA6 = new i(this, "show_pedestrian", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        boolean z2 = true;
        this.D = new i(this, "show_cameras", z2, null == true ? 1 : 0).d().a();
        j<Boolean> jVarA7 = new i(this, "show_lanes", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        this.E = new i(this, "show_gpx_wpt", z2, null == true ? 1 : 0).c().a();
        this.F = new i(this, "show_nearby_favorites", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        this.G = new i(this, "show_nearby_poi_along_route", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        int i3 = 0;
        this.H = new q(this, "along_the_route_buffer", 200L, i3).d().a();
        this.I = new w(this, "show_nearby_poi_categories", "FODCNV;FINATM;TRNCGS;TRNECS;TRNSPS;CGSBMW;TRNPMP;POLOFC", null == true ? 1 : 0).d().a();
        this.J = new i(this, "enable_junction", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        this.K = new i(this, "enable_events", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        this.L = new i(this, "enable_congestion_delay", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        boolean z3 = true;
        this.M = new i(this, "speak_events", z3, null == true ? 1 : 0).d().a();
        this.N = new i(this, "speak_events_safety", z3, null == true ? 1 : 0).d().a();
        this.O = new i(this, "show_events_safety", z3, null == true ? 1 : 0).d().a();
        this.P = new i(this, "speak_events_traffic", z3, null == true ? 1 : 0).d().a();
        this.Q = new i(this, "show_events_traffic", z3, null == true ? 1 : 0).d().a();
        this.R = new i(this, "speak_events_road_conditions", z3, null == true ? 1 : 0).d().a();
        this.S = new i(this, "show_events_road_conditions", z3, null == true ? 1 : 0).d().a();
        this.T = new i(this, "enable_traffic_data", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        boolean z4 = true;
        this.U = new i(this, "speak_street_names", z4, null == true ? 1 : 0).d().a();
        this.V = new i(this, "speak_traffic_warnings", z4, null == true ? 1 : 0).d().a();
        this.W = new i(this, "speak_pedestrian", z4, null == true ? 1 : 0).d().a();
        this.X = new i(this, "speak_speed_limit", z4, null == true ? 1 : 0).d().a();
        this.Y = new i(this, "speak_cameras", z4, null == true ? 1 : 0).d().a();
        this.Z = new i(this, "announce_wpt", z4, null == true ? 1 : 0).c().a();
        this.a0 = new i(this, "announce_nearby_favorites", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        this.b0 = new i(this, "announce_nearby_poi", null == true ? 1 : 0, null == true ? 1 : 0).d().a();
        boolean z5 = true;
        this.c0 = new i(this, "announce_junction", z5, null == true ? 1 : 0).d().a();
        this.d0 = new i(this, "announce_navigation_events", z5, null == true ? 1 : 0).d().a();
        new i(this, "gpx_routing_calculate_navigation_route", z5, null == true ? 1 : 0).c().a();
        new w(this, "report_master_list_category", str2, null == true ? 1 : 0).d().a();
        new q(this, "report_master_list_category_data_last_time_downloaded", 0L, i3).d().a();
        j<Integer> jVarD2 = new o(this, "save_track_interval", NavigationConstants.UI_HANDLER_LOCATION_SERVICE, null == true ? 1 : 0).d();
        this.e0 = jVarD2;
        float f3 = 0.0f;
        j<Float> jVarD3 = new n(this, "save_track_precision", f3, null == true ? 1 : 0).d();
        this.f0 = jVarD3;
        j<Float> jVarD4 = new n(this, "save_track_min_speed", f3, null == true ? 1 : 0).d();
        this.g0 = jVarD4;
        j<Float> jVarD5 = new n(this, "save_track_min_distance", f3, null == true ? 1 : 0).d();
        this.h0 = jVarD5;
        new i(this, "show_trip_recording_notification", true, null == true ? 1 : 0).c();
        this.i0 = new w(this, "selected_gpx", str2, null == true ? 1 : 0).c();
        j<Integer> jVarD6 = new o(this, "auto_follow_route", null == true ? 1 : 0, null == true ? 1 : 0).d();
        j<Integer> jVarD7 = new o(this, "keep_informing", null == true ? 1 : 0, null == true ? 1 : 0).d();
        this.j0 = jVarD7;
        j<Integer> jVarD8 = new o(this, "wake_on_voice_int", null == true ? 1 : 0, null == true ? 1 : 0).d();
        this.k0 = jVarD8;
        this.l0 = new o(this, "audio_stream", 3, null == true ? 1 : 0).c();
        this.m0 = new o(this, "audio_usage", 12, null == true ? 1 : 0).d();
        new a().d();
        this.n0 = new o(this, "bt_sco_delay", ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, null == true ? 1 : 0).c().a();
        new i(this, "use_map_markers", null == true ? 1 : 0, null == true ? 1 : 0).c().a();
        boolean z6 = true;
        this.o0 = new i(this, "use_intermediate_points_navigation", z6, null == true ? 1 : 0).c().a();
        this.p0 = new i(this, "voice_mute", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.q0 = new i(this, "navigation_prompt", z6, null == true ? 1 : 0).c();
        this.r0 = new o(this, "coordinates_format", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.s0 = new i(this, "follow_to_route", null == true ? 1 : 0, null == true ? 1 : 0).c();
        this.t0 = new w(this, "follow_gpx", null, null == true ? 1 : 0).c();
        this.u0 = new q(this, "agps_data_downloaded", 0L, 0).c();
        this.v0 = new b(this, v.values()).d();
        this.x0 = new c(this).c();
        this.y0 = new w(this, "enabled_plugins", str2, null == true ? 1 : 0).c();
        new LinkedHashMap();
        this.A0 = new d(com.mappls.sdk.navigation.d.h);
        this.B0 = new e(l.EUROPE_ASIA, l.values()).c().a();
        this.C0 = new f(this, EnumC0101s.values()).c();
        this.D0 = new o(this, "better_route_suggestion", 1, null == true ? 1 : 0).c();
        this.I0 = new g();
        this.J0 = true;
        this.K0 = new p();
        com.mappls.sdk.navigation.d dVar2 = com.mappls.sdk.navigation.d.i;
        jVarA.a(dVar2, Float.valueOf(1.25f));
        jVarA2.a(dVar2, Float.valueOf(1.5f));
        mVar.d().a();
        mVar.a(dVar2, kVar);
        com.mappls.sdk.navigation.d dVar3 = com.mappls.sdk.navigation.d.j;
        mVar.a(dVar3, kVar);
        com.mappls.sdk.navigation.d dVar4 = com.mappls.sdk.navigation.d.k;
        mVar.a(dVar4, k.DAY);
        Boolean bool = Boolean.TRUE;
        jVarA3.a(dVar2, bool);
        jVarA3.a(dVar3, bool);
        Boolean bool2 = Boolean.FALSE;
        jVarA4.a(dVar2, bool2);
        jVarA4.a(dVar3, bool2);
        jVarA4.a(dVar4, bool2);
        jVarA5.a(dVar2, bool);
        jVarA6.a(dVar2, bool);
        jVarA7.a(dVar2, bool);
        jVarA7.a(dVar3, bool);
        jVarD2.a(dVar2, 3000);
        jVarD2.a(dVar3, 7000);
        jVarD2.a(dVar4, 10000);
        jVarD.a(dVar2, Float.valueOf(25.0f));
        jVarD.a(dVar4, Float.valueOf(14.0f));
        jVarD3.a(dVar2, fValueOf);
        jVarD3.a(dVar3, fValueOf);
        jVarD3.a(dVar4, fValueOf);
        jVarD4.a(dVar2, fValueOf);
        jVarD4.a(dVar3, fValueOf);
        jVarD4.a(dVar4, Float.valueOf(0.0f));
        jVarD5.a(dVar2, fValueOf2);
        jVarD5.a(dVar3, fValueOf2);
        jVarD5.a(dVar4, fValueOf2);
        jVarD6.a(dVar2, 15);
        jVarD6.a(dVar3, 15);
        jVarD6.a(dVar4, 0);
        jVarD7.a(dVar2, 0);
        jVarD7.a(dVar3, 0);
        jVarD7.a(dVar4, 0);
        jVarD8.a(dVar2, 0);
        jVarD8.a(dVar3, 0);
        jVarD8.a(dVar4, 0);
        this.w0 = context;
        this.z0 = dVar;
        p();
    }

    public static boolean a(File file) {
        try {
            file.mkdirs();
            File fileCreateTempFile = File.createTempFile("navigation_", DefaultDiskStorage.FileType.TEMP, file);
            boolean zExists = fileCreateTempFile.exists();
            fileCreateTempFile.delete();
            return zExists;
        } catch (IOException e2) {
            NavigationLogger.d(e2);
            return false;
        }
    }

    private void p() {
        this.E0 = ((com.mappls.sdk.navigation.apis.d) this.z0).a("com.mmi.maps.settings");
        com.mappls.sdk.navigation.d dVar = com.mappls.sdk.navigation.d.h;
        this.F0 = a(dVar);
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        SharedPreferences sharedPreferences = this.E0;
        ((g) this.I0).getClass();
        String strG = dVar.g();
        ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
        com.mappls.sdk.navigation.d dVarA = com.mappls.sdk.navigation.d.a(sharedPreferences.getString("navigation_mode", strG), dVar);
        this.H0 = dVarA;
        this.G0 = a(dVarA);
    }

    public final void a() {
        com.mappls.sdk.navigation.apis.c.a aVarA = ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0);
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        SharedPreferences sharedPreferences = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
        com.mappls.sdk.navigation.apis.c.a aVarPutFloat = aVarA.putFloat("start_point_lat_backup", sharedPreferences.getFloat("start_point_lat", 0.0f));
        com.mappls.sdk.navigation.apis.c cVar2 = this.z0;
        SharedPreferences sharedPreferences2 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar2).getClass();
        com.mappls.sdk.navigation.apis.c.a aVarPutFloat2 = aVarPutFloat.putFloat("start_point_lon_backup", sharedPreferences2.getFloat("start_point_lon", 0.0f));
        com.mappls.sdk.navigation.apis.c cVar3 = this.z0;
        SharedPreferences sharedPreferences3 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar3).getClass();
        aVarPutFloat2.putString("start_point_description_backup", sharedPreferences3.getString("start_point_description", "")).commit();
        com.mappls.sdk.navigation.apis.c.a aVarA2 = ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0);
        com.mappls.sdk.navigation.apis.c cVar4 = this.z0;
        SharedPreferences sharedPreferences4 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar4).getClass();
        com.mappls.sdk.navigation.apis.c.a aVarPutString = aVarA2.putString("point_navigate_mappls_pin_backup", sharedPreferences4.getString("point_navigate_mappls_pin", null));
        com.mappls.sdk.navigation.apis.c cVar5 = this.z0;
        SharedPreferences sharedPreferences5 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar5).getClass();
        aVarPutString.putString("point_navigate_description_backup", sharedPreferences5.getString("point_navigate_description", "")).commit();
        com.mappls.sdk.navigation.apis.c.a aVarA3 = ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0);
        com.mappls.sdk.navigation.apis.c cVar6 = this.z0;
        SharedPreferences sharedPreferences6 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar6).getClass();
        com.mappls.sdk.navigation.apis.c.a aVarPutString2 = aVarA3.putString("intermediate_points_backup", sharedPreferences6.getString("intermediate_points", ""));
        com.mappls.sdk.navigation.apis.c cVar7 = this.z0;
        SharedPreferences sharedPreferences7 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar7).getClass();
        aVarPutString2.putString("intermediate_points_description_backup", sharedPreferences7.getString("intermediate_points_description", "")).commit();
    }

    public final void a(double d2, double d3, com.mappls.sdk.navigation.data.a aVar) {
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).putString("point_navigate_mappls_pin", d3 + "," + d2).commit();
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).putString("point_navigate_description", com.mappls.sdk.navigation.data.a.a(aVar)).commit();
        a();
    }

    public final void a(String str, com.mappls.sdk.navigation.data.a aVar) {
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).putString("point_navigate_mappls_pin", str).commit();
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).putString("point_navigate_description", com.mappls.sdk.navigation.data.a.a(aVar)).commit();
        a();
    }

    public final ArrayList b(int i2) {
        return this.K0.a(i2);
    }

    public final void b() {
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).remove("intermediate_points").remove("intermediate_points_description").commit();
    }

    public final void b(double d2, double d3, com.mappls.sdk.navigation.data.a aVar, int i2) {
        p pVar = this.K0;
        ArrayList arrayListA = pVar.a();
        ArrayList arrayListA2 = pVar.a(arrayListA.size());
        if (i2 < arrayListA.size()) {
            arrayListA.set(i2, d3 + "," + d2);
            arrayListA2.set(i2, com.mappls.sdk.navigation.data.a.a(aVar));
            pVar.a(arrayListA, arrayListA2);
        }
    }

    public final void c() {
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).remove("point_navigate_mappls_pin").remove("point_navigate_description").commit();
    }

    public final void d() {
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).remove("start_point_lat").remove("start_point_lon").remove("start_point_description").commit();
    }

    public final com.mappls.sdk.navigation.d e() {
        return s.this.H0;
    }

    public final Context f() {
        return this.w0;
    }

    public final LinkedHashSet g() {
        StringTokenizer stringTokenizer = new StringTokenizer((String) this.y0.get(), ",");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (!strNextToken.startsWith("-")) {
                linkedHashSet.add(strNextToken);
            }
        }
        return linkedHashSet;
    }

    public final ArrayList i() {
        return this.K0.a();
    }

    public final File j() {
        File noBackupFilesDir = this.w0.getNoBackupFilesDir();
        return noBackupFilesDir != null ? noBackupFilesDir : this.w0.getFilesDir();
    }

    public final com.mappls.sdk.navigation.data.a k() {
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        SharedPreferences sharedPreferences = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
        return com.mappls.sdk.navigation.data.a.a(sharedPreferences.getString("point_navigate_description", ""), l());
    }

    public final String l() {
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        SharedPreferences sharedPreferences = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
        return sharedPreferences.getString("point_navigate_mappls_pin", null);
    }

    public final LatLng m() {
        float fA = ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0, "start_point_lat");
        float fA2 = ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0, "start_point_lon");
        if (fA == 0.0f && fA2 == 0.0f) {
            return null;
        }
        return new LatLng(fA, fA2);
    }

    public final com.mappls.sdk.navigation.data.a n() {
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        SharedPreferences sharedPreferences = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
        return com.mappls.sdk.navigation.data.a.a(m(), sharedPreferences.getString("start_point_description", ""));
    }

    private abstract class r {
        protected String a;
        protected String b;

        public r() {
        }

        public final ArrayList a(int i) {
            ArrayList arrayList = new ArrayList();
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            SharedPreferences sharedPreferences = s.this.E0;
            String str = this.b;
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            String string = sharedPreferences.getString(str, "");
            if (string.trim().length() > 0) {
                arrayList.addAll(Arrays.asList(string.split("--")));
            }
            while (arrayList.size() > i) {
                arrayList.remove(arrayList.size() - 1);
            }
            while (arrayList.size() < i) {
                arrayList.add("");
            }
            return arrayList;
        }

        public final ArrayList a() {
            ArrayList arrayList = new ArrayList();
            com.mappls.sdk.navigation.apis.c cVar = s.this.z0;
            SharedPreferences sharedPreferences = s.this.E0;
            String str = this.a;
            ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
            String string = sharedPreferences.getString(str, "");
            if (string.trim().length() > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ";");
                while (stringTokenizer.hasMoreTokens()) {
                    arrayList.add(stringTokenizer.nextToken());
                }
            }
            return arrayList;
        }
    }

    public final void o() {
        File file = null;
        File[] externalFilesDirs = this.w0.getExternalFilesDirs(null);
        File file2 = (externalFilesDirs == null || externalFilesDirs.length <= 0) ? null : externalFilesDirs[0];
        if (file2 == null || !a(file2)) {
            ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).a(2, "external_storage_dir_type_newer_version").putString("external_storage_dir_newer_version", j().getAbsolutePath()).commit();
            return;
        }
        File[] externalFilesDirs2 = this.w0.getExternalFilesDirs(null);
        if (externalFilesDirs2 != null && externalFilesDirs2.length > 0) {
            file = externalFilesDirs2[0];
        }
        ((com.mappls.sdk.navigation.apis.d) this.z0).a(this.E0).a(1, "external_storage_dir_type_newer_version").putString("external_storage_dir_newer_version", file.getAbsolutePath()).commit();
    }

    public final File h() {
        File[] obbDirs;
        File file;
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        SharedPreferences sharedPreferences = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar).getClass();
        int i2 = sharedPreferences.getInt("external_storage_dir_type_newer_version", -1);
        com.mappls.sdk.navigation.apis.c cVar2 = this.z0;
        SharedPreferences sharedPreferences2 = this.E0;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        com.mappls.sdk.navigation.apis.c cVar3 = this.z0;
        SharedPreferences sharedPreferences3 = this.E0;
        ((com.mappls.sdk.navigation.apis.d) cVar3).getClass();
        String absolutePath2 = new File(new File(sharedPreferences3.getString("external_storage_dir", absolutePath)), "map/").getAbsolutePath();
        ((com.mappls.sdk.navigation.apis.d) cVar2).getClass();
        File file2 = new File(sharedPreferences2.getString("external_storage_dir_newer_version", absolutePath2));
        if (i2 != -1 || a(file2)) {
            return file2;
        }
        File[] externalFilesDirs = this.w0.getExternalFilesDirs(null);
        return ((externalFilesDirs == null || externalFilesDirs.length <= 0 || (file = externalFilesDirs[0]) == null) && ((obbDirs = this.w0.getObbDirs()) == null || obbDirs.length <= 0 || (file = obbDirs[0]) == null)) ? j() : file;
    }

    public final void a(int i2) {
        p pVar = this.K0;
        ArrayList arrayListA = pVar.a();
        ArrayList arrayListA2 = pVar.a(arrayListA.size());
        if (i2 < arrayListA.size()) {
            arrayListA.remove(i2);
            arrayListA2.remove(i2);
            pVar.a(arrayListA, arrayListA2);
        }
    }

    public final SharedPreferences a(com.mappls.sdk.navigation.d dVar) {
        String string;
        com.mappls.sdk.navigation.apis.c cVar = this.z0;
        if (dVar == null) {
            string = "com.mmi.maps.settings";
        } else {
            StringBuilder sbA = com.mappls.sdk.navigation.h.a("com.mmi.maps.settings.");
            sbA.append(dVar.g().toLowerCase());
            string = sbA.toString();
        }
        return ((com.mappls.sdk.navigation.apis.d) cVar).a(string);
    }

    public final void a(String str, com.mappls.sdk.navigation.data.a aVar, int i2) {
        p pVar = this.K0;
        ArrayList arrayListA = pVar.a();
        ArrayList arrayListA2 = pVar.a(arrayListA.size());
        arrayListA.add(i2, str);
        arrayListA2.add(i2, com.mappls.sdk.navigation.data.a.a(aVar));
        pVar.a(arrayListA, arrayListA2);
    }

    public final void a(double d2, double d3, com.mappls.sdk.navigation.data.a aVar, int i2) {
        p pVar = this.K0;
        ArrayList arrayListA = pVar.a();
        ArrayList arrayListA2 = pVar.a(arrayListA.size());
        arrayListA.add(i2, d3 + "," + d2);
        arrayListA2.add(i2, com.mappls.sdk.navigation.data.a.a(aVar));
        pVar.a(arrayListA, arrayListA2);
    }

    public final boolean a(boolean z) {
        NetworkInfo.State state;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 15000 || z) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.w0.getSystemService("connectivity")).getActiveNetworkInfo();
            this.J0 = (activeNetworkInfo == null || (state = activeNetworkInfo.getState()) == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
        }
        return this.J0;
    }
}
