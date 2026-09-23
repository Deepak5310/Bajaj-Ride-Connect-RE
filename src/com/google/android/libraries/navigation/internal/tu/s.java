package com.google.android.libraries.navigation.internal.tu;

import android.app.Application;
import com.google.android.libraries.navigation.internal.sk.ej;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yr.ai;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements com.google.android.libraries.navigation.internal.tv.d {
    public static final com.google.android.libraries.navigation.internal.tv.b[] a = new com.google.android.libraries.navigation.internal.tv.b[0];
    public final Application b;
    public final com.google.android.libraries.navigation.internal.fz.d c;
    public final y d;
    public final a e;
    public final com.google.android.libraries.navigation.internal.th.c f;
    public final PriorityBlockingQueue g;
    public final eo h;

    /* JADX INFO: compiled from: PG */
    public final class a implements Runnable {
        public final PriorityBlockingQueue a;
        public final Executor b;
        public final ej c;
        private final Application d;
        private final ad e;
        private final com.google.android.libraries.navigation.internal.fz.d f;
        private final y g;
        private final Executor h;
        private final com.google.android.libraries.navigation.internal.th.c i;
        private final u j;
        private final u k;
        private final com.google.android.libraries.navigation.internal.gb.a l;
        private final eo m;

        public a(Application application, PriorityBlockingQueue priorityBlockingQueue, ej ejVar, ad adVar, com.google.android.libraries.navigation.internal.fz.d dVar, y yVar, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.th.c cVar, u uVar, u uVar2, com.google.android.libraries.navigation.internal.gb.a aVar, eo eoVar) {
            this.d = application;
            this.a = priorityBlockingQueue;
            this.c = ejVar;
            this.e = adVar;
            this.f = dVar;
            this.g = yVar;
            this.b = executor;
            this.h = executor2;
            this.i = cVar;
            this.j = uVar;
            this.k = uVar2;
            this.l = aVar;
            this.m = eoVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0074  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            String strA;
            try {
                com.google.android.libraries.navigation.internal.tv.b bVar = (com.google.android.libraries.navigation.internal.tv.b) this.a.take();
                if (bVar != null) {
                    final t tVar = bVar.a;
                    String absolutePath = this.e.a().getAbsolutePath();
                    final boolean z2 = true;
                    boolean z3 = this.g.a(s.b(this.f, tVar, this.m)) != null;
                    if (z3 || this.l.a()) {
                        z = false;
                    } else {
                        this.i.h();
                        this.i.g();
                        u uVar = (!this.f.R().m || ((g) tVar).b == null) ? this.j : this.k;
                        this.i.o(((g) tVar).a);
                        boolean zB = uVar.b(tVar, absolutePath);
                        this.i.n(((g) tVar).a);
                        if (zB) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (!z3) {
                        if (z) {
                            File file = new File(absolutePath);
                            y yVar = this.g;
                            String strB = y.b(s.b(this.f, tVar, this.m));
                            File file2 = null;
                            if (yVar.a.g(file, strB) && (strA = yVar.a.a(strB)) != null) {
                                file2 = new File(strA);
                            }
                            if (file2 == null) {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                        }
                    }
                    if (bVar.b == com.google.android.libraries.navigation.internal.tv.c.NOW) {
                        this.h.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.tu.r
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.c.a(tVar, z2);
                            }
                        });
                    }
                }
            } catch (InterruptedException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1877)).p("Interrupted while waiting for an element in the queue.");
            }
            ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
            try {
                this.b.execute(this);
                aiVarA.close();
            } catch (Throwable th) {
                try {
                    aiVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public s(Application application, y yVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.th.c cVar, PriorityBlockingQueue priorityBlockingQueue, a aVar, eo eoVar) {
        this.b = application;
        this.d = yVar;
        this.c = dVar;
        this.f = cVar;
        this.g = priorityBlockingQueue;
        this.e = aVar;
        this.h = eoVar;
    }

    public static x b(com.google.android.libraries.navigation.internal.fz.d dVar, t tVar, eo eoVar) {
        String str;
        int i = dVar.R().e;
        h hVar = new h();
        hVar.a("");
        hVar.a = tVar;
        hVar.b = Locale.getDefault();
        hVar.c = i;
        hVar.e = (byte) 1;
        hVar.f = 1;
        if (eoVar.e()) {
            hVar.a(eoVar.a());
        }
        if (hVar.e != 1 || (str = hVar.d) == null) {
            throw new IllegalStateException();
        }
        return new i(hVar.a, hVar.b, hVar.c, hVar.f, str);
    }

    @Override // com.google.android.libraries.navigation.internal.tv.d
    public final File a(t tVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.tv.d
    public final void c() {
        throw null;
    }
}
