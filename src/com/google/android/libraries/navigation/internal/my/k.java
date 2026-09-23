package com.google.android.libraries.navigation.internal.my;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends WeakReference implements i {
    private final int a;
    private final Map b;

    public k(Object obj, Map map) {
        super(obj, l.a);
        this.a = System.identityHashCode(obj);
        this.b = map;
    }

    public final void a() {
        synchronized (this.b) {
            this.b.remove(this);
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof i) && l.b(this, (i) obj);
        }
        return true;
    }

    public final int hashCode() {
        return this.a;
    }
}
