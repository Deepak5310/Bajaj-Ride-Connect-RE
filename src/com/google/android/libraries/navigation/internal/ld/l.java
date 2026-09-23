package com.google.android.libraries.navigation.internal.ld;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l extends Exception {

    @Deprecated
    public final ab a;

    /* JADX WARN: Illegal instructions before constructor call */
    public l(ab abVar) {
        int i = abVar.f;
        String str = abVar.g;
        super(i + ": " + (str == null ? "" : str));
        this.a = abVar;
    }

    public final int a() {
        return this.a.f;
    }
}
