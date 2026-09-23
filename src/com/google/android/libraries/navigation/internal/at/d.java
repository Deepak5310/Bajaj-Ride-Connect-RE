package com.google.android.libraries.navigation.internal.at;

import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private final Deque a = new ArrayDeque(12);
    private final com.google.android.libraries.navigation.internal.mj.a b;

    public d(com.google.android.libraries.navigation.internal.mj.a aVar) {
        ar.q(aVar);
        this.b = aVar;
    }

    public final synchronized void a(Object obj) {
        if (this.a.isEmpty() || !am.a(obj, ((c) this.a.getLast()).a)) {
            if (this.a.size() == 12) {
                this.a.removeFirst();
            }
            Deque deque = this.a;
            this.b.f();
            deque.addLast(new c(obj));
        }
    }
}
