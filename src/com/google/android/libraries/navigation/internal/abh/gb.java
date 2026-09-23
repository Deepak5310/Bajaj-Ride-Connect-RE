package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gb extends com.google.android.libraries.navigation.internal.ly.ce {
    public final ht a;
    public final ga b;

    public gb(ht htVar, ga gaVar) {
        this.b = gaVar;
        this.a = htVar;
    }

    public final String toString() {
        try {
            return String.valueOf(this.b);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }
}
