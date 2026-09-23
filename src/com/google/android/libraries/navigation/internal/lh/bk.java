package com.google.android.libraries.navigation.internal.lh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk {
    private static bk b;
    private static final bl c = new bl(0, false, false, 0, 0);
    public bl a;

    private bk() {
    }

    public static synchronized bk a() {
        if (b == null) {
            b = new bk();
        }
        return b;
    }

    public final synchronized void b(bl blVar) {
        try {
            if (blVar == null) {
                this.a = c;
                return;
            }
            bl blVar2 = this.a;
            if (blVar2 != null) {
                if (blVar2.a >= blVar.a) {
                    return;
                }
            }
            this.a = blVar;
        } catch (Throwable th) {
            throw th;
        }
    }
}
