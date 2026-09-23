package com.google.android.libraries.geo.mapcore.renderer;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class eg implements Serializable {
    public abstract int a();

    public abstract int b();

    public final boolean c() {
        return b() > 0 && a() > 0;
    }
}
