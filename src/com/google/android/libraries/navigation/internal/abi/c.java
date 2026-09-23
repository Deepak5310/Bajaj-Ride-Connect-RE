package com.google.android.libraries.navigation.internal.abi;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c {
    protected final i a;
    public boolean b;

    public c(i iVar) {
        this.a = iVar;
    }

    protected static float a(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return 0.0f;
        }
        float f3 = ((f2 - f) + 6.2831855f) % 6.2831855f;
        return ((double) f3) > 3.141592653589793d ? f3 - 6.2831855f : f3;
    }

    public final void b(j jVar) {
        if (!this.b) {
            throw new IllegalStateException("Gesture already inactive: ".concat(String.valueOf(getClass().getName())));
        }
        this.b = false;
        c(jVar);
    }

    protected abstract void c(j jVar);

    protected abstract boolean d(j jVar);

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    protected abstract boolean h(j jVar);

    protected abstract int i(long j, LinkedList linkedList, List list);
}
