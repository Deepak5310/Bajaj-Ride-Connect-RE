package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class z {
    public final String b;
    public final w c;

    @Deprecated
    protected z(String str, w wVar) {
        this.b = str;
        this.c = wVar;
    }

    public abstract Object a(com.google.android.libraries.navigation.internal.kk.o oVar);

    public final String toString() {
        return String.format("%s; FeatureType: %s, Name: %s", getClass().getSimpleName(), this.c, this.b);
    }
}
