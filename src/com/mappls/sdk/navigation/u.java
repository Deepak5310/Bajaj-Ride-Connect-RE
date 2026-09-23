package com.mappls.sdk.navigation;

import com.mappls.sdk.services.api.directions.DirectionsCriteria;

/* JADX INFO: loaded from: classes4.dex */
public final class u {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;

    public static class a {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private String f;
        private String g;
        private String h;

        private a() {
        }

        /* synthetic */ a(int i) {
            this();
        }

        public final a a() {
            this.c = false;
            return this;
        }

        public final a a(String str) {
            this.h = str;
            return this;
        }

        public final a b(String str) {
            this.g = str;
            return this;
        }

        public final u b() {
            return new u(this, 0);
        }

        public final a c() {
            this.a = true;
            return this;
        }

        public final a d() {
            this.e = "driving";
            return this;
        }

        public final a e() {
            this.f = DirectionsCriteria.RESOURCE_ROUTE_ETA;
            return this;
        }

        public final a f() {
            this.d = true;
            return this;
        }

        public final a g() {
            this.b = true;
            return this;
        }
    }

    private u(a aVar) {
        aVar.a;
        this.a = aVar.b;
        this.b = aVar.c;
        aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        aVar.getClass();
        aVar.getClass();
        aVar.getClass();
    }

    /* synthetic */ u(a aVar, int i) {
        this(aVar);
    }

    public static a a() {
        return new a(0);
    }
}
