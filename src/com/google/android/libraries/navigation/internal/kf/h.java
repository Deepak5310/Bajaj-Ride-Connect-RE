package com.google.android.libraries.navigation.internal.kf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    private Integer a = null;

    public final synchronized Integer a() {
        return this.a;
    }

    public final synchronized void b(Integer num) {
        if (this.a != null) {
            this.a = num;
        }
    }
}
