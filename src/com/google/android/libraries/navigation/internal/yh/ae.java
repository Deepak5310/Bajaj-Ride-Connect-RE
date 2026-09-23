package com.google.android.libraries.navigation.internal.yh;

import android.net.Uri;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bz;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yr.ax;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae implements at {
    public final String a;
    public final bj b;
    public final Executor c;
    public final com.google.android.libraries.navigation.internal.xy.f d;
    public final com.google.android.libraries.navigation.internal.yx.an e;
    private final r h;
    private final com.google.android.libraries.navigation.internal.yr.o i;
    public final Object f = new Object();
    private final com.google.android.libraries.navigation.internal.aac.al j = new com.google.android.libraries.navigation.internal.aac.al();
    public bj g = null;

    public ae(String str, bj bjVar, r rVar, Executor executor, com.google.android.libraries.navigation.internal.xy.f fVar, com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.yr.o oVar) {
        this.a = str;
        this.b = az.i(bjVar);
        this.h = rVar;
        this.c = new bz(executor);
        this.d = fVar;
        this.e = anVar;
        this.i = oVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001a A[Catch: all -> 0x0035, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000d, B:11:0x0014, B:12:0x0016, B:14:0x001a, B:15:0x0031, B:16:0x0033), top: B:21:0x0003, inners: #1 }] */
    public final bj a() {
        bj bjVar;
        synchronized (this.f) {
            bj bjVar2 = this.g;
            if (bjVar2 == null || !bjVar2.isDone()) {
                if (this.g == null) {
                    this.g = az.i(this.j.a(com.google.android.libraries.navigation.internal.yr.am.c(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.z
                        @Override // com.google.android.libraries.navigation.internal.aac.s
                        public final bj a() {
                            final ae aeVar = this.a;
                            try {
                                return az.h(aeVar.b((Uri) az.n(aeVar.b)));
                            } catch (IOException e) {
                                ad adVar = new ad(aeVar);
                                if (aeVar.e.g()) {
                                    return ((e instanceof com.google.android.libraries.navigation.internal.yb.b) || (e.getCause() instanceof com.google.android.libraries.navigation.internal.yb.b)) ? az.g(e) : com.google.android.libraries.navigation.internal.aac.j.i(((c) aeVar.e.c()).a(e, adVar), com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.u
                                        @Override // com.google.android.libraries.navigation.internal.aac.t
                                        public final bj a(Object obj) {
                                            ae aeVar2 = aeVar;
                                            return az.h(aeVar2.b((Uri) az.n(aeVar2.b)));
                                        }
                                    }), aeVar.c);
                                }
                                return az.g(e);
                            }
                        }
                    }), this.c));
                }
                bjVar = this.g;
            } else {
                try {
                    az.n(this.g);
                } catch (ExecutionException unused) {
                    this.g = null;
                }
                if (this.g == null) {
                    this.g = az.i(this.j.a(com.google.android.libraries.navigation.internal.yr.am.c(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.z
                        @Override // com.google.android.libraries.navigation.internal.aac.s
                        public final bj a() {
                            final ae aeVar = this.a;
                            try {
                                return az.h(aeVar.b((Uri) az.n(aeVar.b)));
                            } catch (IOException e) {
                                ad adVar = new ad(aeVar);
                                if (aeVar.e.g()) {
                                    return ((e instanceof com.google.android.libraries.navigation.internal.yb.b) || (e.getCause() instanceof com.google.android.libraries.navigation.internal.yb.b)) ? az.g(e) : com.google.android.libraries.navigation.internal.aac.j.i(((c) aeVar.e.c()).a(e, adVar), com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.u
                                        @Override // com.google.android.libraries.navigation.internal.aac.t
                                        public final bj a(Object obj) {
                                            ae aeVar2 = aeVar;
                                            return az.h(aeVar2.b((Uri) az.n(aeVar2.b)));
                                        }
                                    }), aeVar.c);
                                }
                                return az.g(e);
                            }
                        }
                    }), this.c));
                }
                bjVar = this.g;
            }
            throw th;
        }
        return bjVar;
    }

    public final Object b(Uri uri) throws IOException {
        try {
            try {
                com.google.android.libraries.navigation.internal.yr.w wVarA = this.i.a("Read " + this.a, ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
                try {
                    InputStream inputStream = (InputStream) this.d.b(uri, new com.google.android.libraries.navigation.internal.ye.c());
                    try {
                        r rVar = this.h;
                        Object objH = ((com.google.android.libraries.navigation.internal.ym.b) rVar).b().B().h(inputStream, ((com.google.android.libraries.navigation.internal.ym.b) rVar).a());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        wVarA.close();
                        return objH;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        wVarA.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (FileNotFoundException e) {
                if (this.d.d(uri)) {
                    throw e;
                }
                return ((com.google.android.libraries.navigation.internal.ym.a) this.h).a;
            }
        } catch (IOException e2) {
            throw com.google.android.libraries.navigation.internal.yi.a.a(this.d, uri, e2, this.a);
        }
    }

    public final void c(Uri uri, Object obj) throws IOException {
        Uri uriA = com.google.android.libraries.navigation.internal.yi.c.a(uri, DefaultDiskStorage.FileType.TEMP);
        try {
            com.google.android.libraries.navigation.internal.yr.w wVarA = this.i.a("Write " + this.a, ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
            try {
                com.google.android.libraries.navigation.internal.ya.a aVar = new com.google.android.libraries.navigation.internal.ya.a();
                try {
                    com.google.android.libraries.navigation.internal.xy.f fVar = this.d;
                    com.google.android.libraries.navigation.internal.ye.f fVar2 = new com.google.android.libraries.navigation.internal.ye.f();
                    fVar2.a = new com.google.android.libraries.navigation.internal.ya.a[]{aVar};
                    OutputStream outputStream = (OutputStream) fVar.b(uriA, fVar2);
                    try {
                        ((cy) obj).l(outputStream);
                        aVar.c();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        wVarA.close();
                        this.d.c(uriA, uri);
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    throw com.google.android.libraries.navigation.internal.yi.a.a(this.d, uri, e, this.a);
                }
            } catch (Throwable th3) {
                try {
                    wVarA.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException e2) {
            if (this.d.d(uriA)) {
                try {
                    com.google.android.libraries.navigation.internal.xy.d dVarA = this.d.a(uriA);
                    dVarA.a.k(dVarA.e);
                } catch (IOException e3) {
                    e2.addSuppressed(e3);
                }
            }
            throw e2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yh.at
    public final bj d(final com.google.android.libraries.navigation.internal.aac.t tVar, final Executor executor) {
        final bj bjVarA = a();
        return this.j.a(com.google.android.libraries.navigation.internal.yr.am.c(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.aa
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                final ae aeVar = this.a;
                final bj bjVarI = com.google.android.libraries.navigation.internal.aac.j.i(bjVarA, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.w
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        bj bjVar;
                        ae aeVar2 = aeVar;
                        synchronized (aeVar2.f) {
                            bjVar = aeVar2.g;
                        }
                        return bjVar;
                    }
                }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                final bj bjVarI2 = com.google.android.libraries.navigation.internal.aac.j.i(bjVarI, tVar, executor);
                return com.google.android.libraries.navigation.internal.aac.j.i(bjVarI2, com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.ab
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        final bj bjVar = bjVarI2;
                        if (az.n(bjVarI).equals(az.n(bjVar))) {
                            return az.h(obj);
                        }
                        final ae aeVar2 = aeVar;
                        bj bjVarI3 = com.google.android.libraries.navigation.internal.aac.j.i(bjVar, com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.x
                            @Override // com.google.android.libraries.navigation.internal.aac.t
                            public final bj a(Object obj2) throws IOException {
                                ae aeVar3 = aeVar2;
                                aeVar3.c((Uri) az.n(aeVar3.b), obj2);
                                bj bjVar2 = bjVar;
                                synchronized (aeVar3.f) {
                                    aeVar3.g = bjVar2;
                                }
                                return az.h(obj2);
                            }
                        }), aeVar2.c);
                        synchronized (aeVar2.f) {
                        }
                        return bjVarI3;
                    }
                }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            }
        }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    }
}
