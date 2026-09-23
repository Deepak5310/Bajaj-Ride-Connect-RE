package com.google.android.libraries.navigation.internal.b;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af {
    public static final boolean a = ag.b;
    private final List b = new ArrayList();
    private boolean c = false;

    public final synchronized void a(String str, long j) {
        if (this.c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.b.add(new ae(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void b(String str) {
        long j;
        this.c = true;
        if (this.b.size() == 0) {
            j = 0;
        } else {
            long j2 = ((ae) this.b.get(0)).c;
            List list = this.b;
            j = ((ae) list.get(list.size() - 1)).c - j2;
        }
        if (j > 0) {
            long j3 = ((ae) this.b.get(0)).c;
            ag.b("(%-4d ms) %s", Long.valueOf(j), str);
            for (ae aeVar : this.b) {
                long j4 = aeVar.c;
                ag.b("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(aeVar.b), aeVar.a);
                j3 = j4;
            }
        }
    }

    protected final void finalize() throws Throwable {
        if (this.c) {
            return;
        }
        b("Request on the loose");
        ag.b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}
