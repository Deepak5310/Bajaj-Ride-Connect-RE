package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.core.view.ViewCompat;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Serializable {
    public static final aa a = new j(0, 0, 0, 0);

    public static y h() {
        h hVar = new h();
        hVar.f("");
        hVar.a = null;
        hVar.g(0);
        hVar.d(ViewCompat.MEASURED_STATE_MASK);
        hVar.c(0);
        hVar.b(0);
        hVar.e(a);
        return hVar;
    }

    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract aa e();

    public abstract String f();

    public abstract byte[] g();
}
