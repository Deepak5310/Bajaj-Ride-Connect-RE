package com.mappls.sdk.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static LinkedHashMap f = new LinkedHashMap();
    private static ArrayList g;
    public static final d h;
    public static final d i;
    public static final d j;
    public static final d k;
    public static final d l;
    private final String a;
    private d b;
    private float c = 10.0f;
    private int d = 50;
    private int e = 30;

    private static class a {
        private d a;

        private a() {
        }

        /* synthetic */ a(int i) {
            this();
        }

        public final a a(float f, int i) {
            this.a.c = f;
            this.a.d = i;
            return this;
        }

        public final a a(int i) {
            this.a.e = i;
            return this;
        }

        public final a a(d dVar) {
            this.a.b = dVar;
            return this;
        }

        public final d a() {
            d.g.add(this.a);
            return this.a;
        }
    }

    static {
        new LinkedHashMap();
        g = new ArrayList();
        h = a(R.string.mappls_app_mode_default, "default").a(1.5f, 5).a(30).a();
        d dVarA = a(R.string.mappls_app_mode_car, "car").a(15.3f, 35).a(30).a();
        i = dVarA;
        j = a(R.string.mappls_app_mode_bicycle, "bicycle").a(5.5f, 15).a(15).a();
        d dVarA2 = a(R.string.mappls_app_mode_pedestrian, "pedestrian").a(1.5f, 5).a(30).a();
        k = dVarA2;
        a(R.string.mappls_app_mode_aircraft, "aircraft").a(40.0f, 100).a();
        l = a(R.string.mappls_app_mode_boat, "boat").a(5.5f, 20).a();
        a(R.string.mappls_app_mode_hiking, "hiking").a(1.5f, 5).a(dVarA2).a();
        a(R.string.mappls_app_mode_motorcycle, "motorcycle").a(15.3f, 40).a(dVarA).a();
        a(R.string.mappls_app_mode_truck, "truck").a(15.3f, 40).a(dVarA).a();
        a(R.string.mappls_app_mode_bus, "bus").a(15.3f, 40).a(dVarA).a();
        a(R.string.mappls_app_mode_train, "train").a(25.0f, 40).a();
        new ArrayList();
    }

    private d(String str) {
        this.a = str;
    }

    private static a a(int i2, String str) {
        a aVar = new a(0);
        aVar.a = new d(str);
        return aVar;
    }

    public static ArrayList b() {
        return new ArrayList(g);
    }

    public final boolean a(d dVar) {
        return this == dVar || this.b == dVar;
    }

    public final int c() {
        return this.e;
    }

    public final float d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final d f() {
        return this.b;
    }

    public final String g() {
        return this.a;
    }

    public final boolean h() {
        return this.c > 10.0f;
    }

    public static void a(d... dVarArr) {
        HashSet hashSet = new HashSet();
        if (dVarArr == null) {
            hashSet.addAll(g);
        } else {
            Collections.addAll(hashSet, dVarArr);
        }
        for (d dVar : g) {
            if (hashSet.contains(dVar.b)) {
                hashSet.add(dVar);
            }
        }
        f.put("monitoring", hashSet);
    }

    public static d a(String str, d dVar) {
        for (d dVar2 : g) {
            if (dVar2.a.equals(str)) {
                return dVar2;
            }
        }
        return dVar;
    }
}
