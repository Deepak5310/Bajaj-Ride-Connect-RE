package com.google.android.libraries.navigation.internal.lh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d {
    public Object d;
    public boolean e = false;
    final /* synthetic */ k f;

    public d(k kVar, Object obj) {
        this.f = kVar;
        this.d = obj;
    }

    protected abstract void b();

    protected abstract void d();

    public final void e() {
        synchronized (this) {
            this.d = null;
        }
    }

    public final void f() {
        e();
        synchronized (this.f.h) {
            this.f.h.remove(this);
        }
    }
}
