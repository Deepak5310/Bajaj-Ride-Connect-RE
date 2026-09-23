package com.google.android.libraries.navigation.internal.vt;

import android.content.Intent;
import com.google.android.libraries.navigation.internal.ady.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final com.google.android.libraries.navigation.internal.so.c a;
    private final com.google.android.libraries.navigation.internal.tk.e b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;

    public a(com.google.android.libraries.navigation.internal.so.c cVar, com.google.android.libraries.navigation.internal.tk.e eVar) {
        this.a = cVar;
        this.b = eVar;
    }

    private final void h() {
        this.a.a(new com.google.android.libraries.navigation.internal.so.e(com.google.android.libraries.navigation.internal.so.d.a(com.google.android.libraries.navigation.internal.su.d.d(al.DRIVE))));
        j(true, false);
    }

    private final void j(boolean z, boolean z2) {
        this.d = z;
        this.e = z2;
    }

    public final synchronized void a() {
        this.c = false;
        i();
    }

    public final synchronized void b() {
        this.c = true;
        i();
    }

    public final synchronized void c() {
        this.f = true;
        i();
    }

    public final synchronized void d() {
        this.f = false;
        i();
    }

    public final synchronized void e(com.google.android.libraries.navigation.internal.so.e eVar, Intent intent) {
        if (intent != null) {
            this.b.c = intent;
        }
        this.a.a(eVar);
        j(false, true);
    }

    public final synchronized void f() {
        if (!this.c && !this.f) {
            if (this.e) {
                this.a.b(true);
                j(false, false);
                return;
            }
            return;
        }
        h();
    }

    public final boolean g() {
        return this.d;
    }

    private final void i() {
        if (!this.e && (this.c || this.f)) {
            if (this.d) {
                return;
            }
            h();
        } else if (this.d) {
            this.a.b(false);
            j(false, false);
        }
    }
}
