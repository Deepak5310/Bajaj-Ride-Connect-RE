package com.google.android.libraries.navigation.internal.pn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    protected final j a;
    public boolean b;
    protected final float c;
    protected final float d;

    public b(j jVar, float f, float f2) {
        ar.q(jVar);
        this.a = jVar;
        this.c = f;
        this.d = f2;
    }

    protected static float a(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return 0.0f;
        }
        float f3 = ((f2 - f) + 6.2831855f) % 6.2831855f;
        return ((double) f3) > 3.141592653589793d ? f3 - 6.2831855f : f3;
    }

    public final void b(n nVar) {
        if (!this.b) {
            throw new IllegalStateException("Gesture already inactive: ".concat(String.valueOf(getClass().getName())));
        }
        this.b = false;
        c(nVar);
    }

    protected abstract void c(n nVar);

    protected abstract boolean d(n nVar);

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    protected abstract boolean h(n nVar);

    protected abstract int i(long j, Deque deque, List list);
}
