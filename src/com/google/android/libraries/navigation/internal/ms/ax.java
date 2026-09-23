package com.google.android.libraries.navigation.internal.ms;

import android.content.res.Configuration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ax {
    private bl a;
    private be b;
    private cr c;
    private co d;
    private cx e;
    private bb f;
    private bg g;
    private cv h;

    protected ax(Configuration configuration) {
        com.google.android.libraries.navigation.internal.yx.ar.l(cy.a.add(this), "Environment was already registered.");
        com.google.android.libraries.navigation.internal.yx.ar.q(configuration);
        new Configuration(configuration);
    }

    protected abstract bb a();

    public final bb b() {
        if (this.f == null) {
            this.f = a();
        }
        return this.f;
    }

    protected abstract be c();

    public final be d() {
        if (this.b == null) {
            this.b = c();
        }
        return this.b;
    }

    protected abstract bg e();

    public final bg f() {
        if (this.g == null) {
            this.g = e();
        }
        return this.g;
    }

    protected abstract bl g();

    public final bl h() {
        if (this.a == null) {
            this.a = g();
        }
        return this.a;
    }

    protected abstract co i();

    public final co j() {
        if (this.d == null) {
            this.d = i();
        }
        return this.d;
    }

    protected abstract cr k();

    public final cr l() {
        if (this.c == null) {
            this.c = k();
        }
        return this.c;
    }

    protected abstract cv m();

    public final cv n() {
        if (this.h == null) {
            this.h = m();
        }
        return this.h;
    }

    protected abstract cx o();

    public final cx p() {
        if (this.e == null) {
            this.e = o();
        }
        return this.e;
    }
}
