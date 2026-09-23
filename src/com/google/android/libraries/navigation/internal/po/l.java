package com.google.android.libraries.navigation.internal.po;

import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l implements com.google.android.libraries.navigation.internal.pc.f {
    private static final com.google.android.libraries.navigation.internal.zb.j e = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.l");
    public final com.google.android.libraries.navigation.internal.pc.g a;
    public final View b;
    public final com.google.android.libraries.navigation.internal.pb.t c;
    private final Executor f;
    private final com.google.android.libraries.navigation.internal.pb.b g = new k(this);
    public Set d = null;

    public l(View view, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.pc.g gVar, Executor executor) {
        this.b = view;
        this.c = tVar;
        this.a = gVar;
        this.f = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.f
    public final void a() {
        e();
    }

    @Override // com.google.android.libraries.navigation.internal.pc.f
    public final void b(final com.google.android.libraries.navigation.internal.pd.d dVar) {
        this.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.j
            @Override // java.lang.Runnable
            public final void run() {
                HashSet hashSet = new HashSet();
                l lVar = this.a;
                synchronized (lVar) {
                    Set set = lVar.d;
                    if (set != null) {
                        hashSet.addAll(set);
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.pc.e) it2.next()).f();
                }
                lVar.e();
            }
        });
    }

    public final void c() {
        Set set;
        synchronized (this) {
            set = this.d;
        }
        this.a.f(set == null ? null : this);
    }

    public final void d(com.google.android.libraries.navigation.internal.pb.c cVar) {
        com.google.android.libraries.navigation.internal.yx.ar.l(true, "GmmCamera moved during a cancellation");
        com.google.android.libraries.navigation.internal.yx.ca.a(true);
        synchronized (this) {
        }
        c();
        cVar.a(this.g);
    }

    public final synchronized void e() {
        c();
    }
}
