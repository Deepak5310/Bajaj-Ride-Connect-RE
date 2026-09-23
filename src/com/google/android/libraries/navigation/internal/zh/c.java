package com.google.android.libraries.navigation.internal.zh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c {
    public final int a;
    public final com.google.android.libraries.navigation.internal.zd.c b;

    protected c(com.google.android.libraries.navigation.internal.zd.c cVar, int i) {
        if (cVar == null) {
            throw new IllegalArgumentException("format options cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "invalid index: "));
        }
        this.a = i;
        this.b = cVar;
    }

    public abstract void a(d dVar, Object obj);
}
