package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import android.content.Context;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.qu.br;
import com.google.android.libraries.navigation.internal.qu.bs;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements com.google.android.libraries.navigation.internal.qv.a {
    static final String[] a = {"map_cache.db", "map_cache.db-shm", "map_cache.db-wal"};
    private static final long h = TimeUnit.DAYS.toMillis(10);
    public final Context b;
    public final com.google.android.libraries.navigation.internal.id.d c;
    public final com.google.android.libraries.navigation.internal.ra.a d;
    public final com.google.android.libraries.navigation.internal.afo.a e;
    private final at i;
    private final com.google.android.libraries.navigation.internal.mj.a j;
    private final bn k;
    private final c l;
    private final com.google.android.libraries.navigation.internal.no.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private g f70n;
    private final bs r;
    private final br s;
    boolean f = false;
    private long o = 0;
    private long p = -1;
    private long q = -1;
    protected File g = null;

    public k(Context context, com.google.android.libraries.navigation.internal.id.d dVar, bs bsVar, at atVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ra.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, bn bnVar, c cVar, com.google.android.libraries.navigation.internal.no.a aVar4, br brVar) {
        this.b = context;
        this.c = dVar;
        this.r = bsVar;
        this.i = atVar;
        this.j = aVar;
        this.d = aVar2;
        this.e = aVar3;
        this.k = bnVar;
        this.l = cVar;
        this.m = aVar4;
        this.s = brVar;
    }

    public static void j(File file, boolean z) {
        File[] fileArrListFiles;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    private final synchronized long m() {
        long length;
        long j = this.p;
        if (j >= 0) {
            return j;
        }
        long jN = n();
        File file = new File(g(), a[0]);
        if (file.exists()) {
            length = file.length() + jN;
            this.p = length;
        } else {
            this.p = jN;
            length = jN;
        }
        if (jN >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            if (length < this.r.f()) {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.y)).a(com.google.android.libraries.navigation.internal.km.g.a(2));
            } else {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.y)).a(com.google.android.libraries.navigation.internal.km.g.a(3));
            }
        }
        return this.p;
    }

    private final synchronized long n() {
        long j = this.q;
        long usableSpace = 0;
        if (j >= 0) {
            return j;
        }
        File fileG = g();
        while (fileG != null && !fileG.exists()) {
            fileG = fileG.getParentFile();
        }
        if (fileG != null) {
            usableSpace = fileG.getUsableSpace();
            this.q = usableSpace;
        } else {
            this.q = 0L;
        }
        if (usableSpace < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.y)).a(com.google.android.libraries.navigation.internal.km.g.a(1));
        }
        return this.q;
    }

    private final synchronized void o(g gVar) throws d {
        try {
            try {
                int iNativeSqliteDiskCacheGetServerDataVersion = NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheGetServerDataVersion(((NativeSqliteDiskCacheImpl) gVar.c).b);
                int iD = this.r.d();
                if (iD != 0) {
                    if (iNativeSqliteDiskCacheGetServerDataVersion == 0) {
                        try {
                            gVar.m(iD);
                            return;
                        } catch (IOException unused) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1223)).q("Failed to set server data version to %d :", iD);
                            return;
                        }
                    } else if (iD != iNativeSqliteDiskCacheGetServerDataVersion) {
                        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.p)).a(com.google.android.libraries.navigation.internal.km.j.a(3));
                        try {
                            gVar.e.clear();
                            try {
                                NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheClear(((NativeSqliteDiskCacheImpl) gVar.c).b);
                                gVar.m(iD);
                                return;
                            } catch (com.google.android.apps.gmm.jni.util.c e) {
                                throw new d(e);
                            }
                        } catch (d e2) {
                            gVar.j(e2);
                            throw e2;
                        }
                    }
                    throw th;
                }
            } catch (com.google.android.apps.gmm.jni.util.c e3) {
                throw new d(e3);
            }
        } catch (d e4) {
            try {
                gVar.j(e4);
                throw e4;
            } catch (d e5) {
                ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.j)).a();
                throw e5;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.a
    public final synchronized com.google.android.libraries.navigation.internal.qv.b a(com.google.android.libraries.navigation.internal.mj.a aVar) {
        g gVarE = e();
        if (gVarE == null) {
            return null;
        }
        return new l(gVarE, aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qv.a
    public final synchronized com.google.android.libraries.navigation.internal.qv.c b(com.google.android.libraries.navigation.internal.mj.a aVar, pw pwVar) {
        g gVarE = e();
        if (gVarE == null) {
            return null;
        }
        return new n(gVarE, aVar, pwVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qv.a
    public final synchronized com.google.android.libraries.navigation.internal.qv.d c(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.e eVar) {
        if (m() < this.r.f()) {
            return null;
        }
        g gVarE = e();
        if (gVarE == null) {
            return null;
        }
        return new o(this.i, gVarE, apVar, cgVar, eVar, this.m, this.s, this.j, (com.google.android.libraries.navigation.internal.kl.b) this.e.a());
    }

    @Override // com.google.android.libraries.navigation.internal.qv.a
    public final synchronized void d() {
        g gVar = this.f70n;
        if (gVar != null) {
            try {
                try {
                    NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheClearTiles(((NativeSqliteDiskCacheImpl) gVar.c).b);
                } catch (com.google.android.apps.gmm.jni.util.c e) {
                    throw new d(e);
                }
            } catch (d e2) {
                try {
                    gVar.j(e2);
                    throw e2;
                } catch (d unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1229)).p("Failed to clear database:");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x010f A[Catch: all -> 0x018c, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x001d, B:9:0x0027, B:11:0x002b, B:13:0x0041, B:15:0x0047, B:16:0x005e, B:17:0x0061, B:19:0x0065, B:20:0x006c, B:22:0x0076, B:24:0x007c, B:37:0x00db, B:41:0x00e2, B:44:0x0106, B:43:0x00e6, B:46:0x010f, B:47:0x0112, B:49:0x013e, B:50:0x0146, B:52:0x014e, B:54:0x016a, B:55:0x0173, B:56:0x017a, B:58:0x017e, B:27:0x009e, B:31:0x00a5, B:33:0x00b2, B:35:0x00cb, B:59:0x0188), top: B:71:0x0001, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x013e A[Catch: IOException -> 0x014e, all -> 0x018c, TryCatch #4 {IOException -> 0x014e, blocks: (B:47:0x0112, B:49:0x013e, B:50:0x0146), top: B:73:0x0112, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0146 A[Catch: IOException -> 0x014e, all -> 0x018c, TRY_LEAVE, TryCatch #4 {IOException -> 0x014e, blocks: (B:47:0x0112, B:49:0x013e, B:50:0x0146), top: B:73:0x0112, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x017e A[Catch: all -> 0x018c, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x001d, B:9:0x0027, B:11:0x002b, B:13:0x0041, B:15:0x0047, B:16:0x005e, B:17:0x0061, B:19:0x0065, B:20:0x006c, B:22:0x0076, B:24:0x007c, B:37:0x00db, B:41:0x00e2, B:44:0x0106, B:43:0x00e6, B:46:0x010f, B:47:0x0112, B:49:0x013e, B:50:0x0146, B:52:0x014e, B:54:0x016a, B:55:0x0173, B:56:0x017a, B:58:0x017e, B:27:0x009e, B:31:0x00a5, B:33:0x00b2, B:35:0x00cb, B:59:0x0188), top: B:71:0x0001, inners: #0, #1, #2, #4 }] */
    final synchronized g e() {
        boolean z;
        g gVar;
        final g gVar2;
        com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.z);
        if (n() < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            kVar.a(com.google.android.libraries.navigation.internal.km.i.a(2));
            return null;
        }
        if (!this.f) {
            this.f = true;
            File file = new File(this.b.getCacheDir(), "map_cache.canary");
            if (!file.exists()) {
                if (k()) {
                    ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.p)).a(com.google.android.libraries.navigation.internal.km.j.a(2));
                }
                h();
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1218)).p("Failed to create database canary file");
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis > 0) {
                file.setLastModified(jCurrentTimeMillis);
            }
            boolean z2 = false;
            try {
                this.f70n = g.o(g(), this.c.b(), (com.google.android.libraries.navigation.internal.kl.b) this.e.a(), this.k, this.j, this.r, this.i);
            } catch (d e) {
                int i = e.a;
                if (i == 5 || i == 6) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1217)).p("Failed to open database; the database is locked.");
                    kVar.a(com.google.android.libraries.navigation.internal.km.i.a(3));
                } else {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1216)).p("Failed to open database; the database will be deleted and recreated:");
                    if (k()) {
                        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.p)).a(com.google.android.libraries.navigation.internal.km.j.a(1));
                    }
                    z = true;
                }
                gVar = this.f70n;
                if (gVar != null) {
                    try {
                        o(gVar);
                    } catch (IOException unused2) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1215)).p("Failed server data version check");
                        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.p)).a(com.google.android.libraries.navigation.internal.km.j.a(4));
                        z2 = true;
                        z = true;
                    }
                    kVar.a(com.google.android.libraries.navigation.internal.km.i.a(1));
                }
                if (z) {
                    h();
                    try {
                        g gVarO = g.o(g(), this.c.b(), (com.google.android.libraries.navigation.internal.kl.b) this.e.a(), this.k, this.j, this.r, this.i);
                        this.f70n = gVarO;
                        gVarO.m(this.r.d());
                        if (z2) {
                            kVar.a(com.google.android.libraries.navigation.internal.km.i.a(6));
                        } else {
                            kVar.a(com.google.android.libraries.navigation.internal.km.i.a(4));
                        }
                    } catch (IOException unused3) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1214)).p("Failed to recreate database:");
                        ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.q)).a();
                        if (z2) {
                            kVar.a(com.google.android.libraries.navigation.internal.km.i.a(7));
                        } else {
                            kVar.a(com.google.android.libraries.navigation.internal.km.i.a(5));
                        }
                    }
                }
                gVar2 = this.f70n;
                if (gVar2 != null) {
                    this.d.a(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.store.diskcache.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            k kVar2 = this.a;
                            g gVar3 = gVar2;
                            ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) kVar2.e.a()).a(com.google.android.libraries.navigation.internal.km.k.r)).a(gVar3.a());
                            kVar2.i(gVar3);
                            for (File file2 : kVar2.l()) {
                                if (!file2.equals(kVar2.g()) && file2.exists()) {
                                    String[] strArr = k.a;
                                    for (int i2 = 0; i2 < 3; i2++) {
                                        com.google.android.libraries.navigation.internal.id.a.d(new File(file2, strArr[i2]));
                                    }
                                }
                            }
                        }
                    });
                }
                return this.f70n;
            }
            z = false;
            gVar = this.f70n;
            if (gVar != null && !z) {
                o(gVar);
                kVar.a(com.google.android.libraries.navigation.internal.km.i.a(1));
            }
            if (z) {
                h();
                g gVarO2 = g.o(g(), this.c.b(), (com.google.android.libraries.navigation.internal.kl.b) this.e.a(), this.k, this.j, this.r, this.i);
                this.f70n = gVarO2;
                gVarO2.m(this.r.d());
                if (z2) {
                    kVar.a(com.google.android.libraries.navigation.internal.km.i.a(6));
                } else {
                    kVar.a(com.google.android.libraries.navigation.internal.km.i.a(4));
                }
            }
            gVar2 = this.f70n;
            if (gVar2 != null) {
                this.d.a(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.store.diskcache.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVar2 = this.a;
                        g gVar3 = gVar2;
                        ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) kVar2.e.a()).a(com.google.android.libraries.navigation.internal.km.k.r)).a(gVar3.a());
                        kVar2.i(gVar3);
                        for (File file2 : kVar2.l()) {
                            if (!file2.equals(kVar2.g()) && file2.exists()) {
                                String[] strArr = k.a;
                                for (int i2 = 0; i2 < 3; i2++) {
                                    com.google.android.libraries.navigation.internal.id.a.d(new File(file2, strArr[i2]));
                                }
                            }
                        }
                    }
                });
            }
        }
        return this.f70n;
    }

    final File f(boolean z) {
        return z ? com.google.android.libraries.navigation.internal.id.d.a(this.b, true, "cache") : (File) this.c.b.a();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a4 A[Catch: all -> 0x014b, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00be A[Catch: all -> 0x014b, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9 A[Catch: all -> 0x014b, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e2 A[Catch: all -> 0x014b, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ea A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0103 A[Catch: all -> 0x014b, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x010b A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0124 A[Catch: all -> 0x014b, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0140 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:63:0x0142 A[Catch: all -> 0x014b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0010, B:10:0x0012, B:12:0x001f, B:14:0x002d, B:16:0x003c, B:19:0x004e, B:18:0x003f, B:20:0x0051, B:22:0x0055, B:24:0x0058, B:27:0x005d, B:29:0x0063, B:31:0x006a, B:33:0x0070, B:43:0x009d, B:36:0x007f, B:38:0x0085, B:40:0x008b, B:42:0x008e, B:44:0x00a0, B:46:0x00a4, B:59:0x013c, B:63:0x0142, B:47:0x00be, B:49:0x00c9, B:50:0x00e2, B:51:0x00e4, B:53:0x00ea, B:54:0x0103, B:55:0x0105, B:57:0x010b, B:58:0x0124), top: B:75:0x0001, inners: #3, #4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x0140, please report this as an issue */
    protected final synchronized File g() {
        File file;
        File file2;
        File file3 = this.g;
        if (file3 != null) {
            return file3;
        }
        File[] fileArrL = l();
        for (File file4 : fileArrL) {
            try {
                File file5 = new File(file4, "map_cache.db");
                if (file5.exists() && file5.length() > this.r.f() && System.currentTimeMillis() - file5.lastModified() < h) {
                    this.g = file4;
                    break;
                }
            } catch (SecurityException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1221)).s("Unable to check sqlite cache dir %s", file4);
            }
        }
        if (this.g != null) {
            file = this.g;
            if (file == null) {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(1));
            } else if (file.equals(fileArrL[fileArrL.length - 1])) {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(2));
            } else if (Environment.isExternalStorageEmulated(this.g)) {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(3));
            } else if (Environment.isExternalStorageRemovable(this.g)) {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(4));
            } else {
                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(5));
            }
            file2 = this.g;
            if (file2 != null) {
                return file2;
            }
            File file6 = fileArrL[fileArrL.length - 1];
            this.g = file6;
            return file6;
        }
        for (File file7 : fileArrL) {
            File parentFile = file7;
            while (parentFile != null) {
                try {
                    if (parentFile.exists()) {
                        break;
                    }
                    parentFile = parentFile.getParentFile();
                } catch (SecurityException unused2) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1220)).s("Unable to make sqlite cache dir %s", file7);
                }
            }
            if ((parentFile == null || !parentFile.exists() || parentFile.getUsableSpace() >= this.r.f()) && (file7.exists() || file7.mkdirs())) {
                this.g = file7;
                break;
            }
        }
        file = this.g;
        if (file == null) {
            ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(1));
        } else if (file.equals(fileArrL[fileArrL.length - 1])) {
            ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(2));
        } else {
            try {
                if (Environment.isExternalStorageEmulated(this.g)) {
                    ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(3));
                } else {
                    try {
                        if (Environment.isExternalStorageRemovable(this.g)) {
                            ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(4));
                        } else {
                            ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.x)).a(com.google.android.libraries.navigation.internal.km.h.a(5));
                        }
                    } catch (IllegalArgumentException unused3) {
                    }
                }
            } catch (IllegalArgumentException unused4) {
            }
        }
        file2 = this.g;
        if (file2 != null) {
            return file2;
        }
        File file8 = fileArrL[fileArrL.length - 1];
        this.g = file8;
        return file8;
        throw th;
    }

    final void h() {
        String[] strArr = a;
        for (int i = 0; i < 3; i++) {
            com.google.android.libraries.navigation.internal.id.a.d(new File(g(), strArr[i]));
        }
        com.google.android.libraries.navigation.internal.id.a.d(new File(this.c.b(), "map_cache.key"));
    }

    final void i(final g gVar) {
        com.google.android.libraries.navigation.internal.kk.m mVarA;
        try {
            try {
                long jA = this.j.a();
                mVarA = ((com.google.android.libraries.navigation.internal.kk.n) gVar.d.a(com.google.android.libraries.navigation.internal.km.k.f470n)).a();
                try {
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SqliteDiskCache.deleteExpired");
                    try {
                        try {
                            int iNativeSqliteDiskCacheDeleteExpired = NativeSqliteDiskCacheImpl.nativeSqliteDiskCacheDeleteExpired(((NativeSqliteDiskCacheImpl) gVar.c).b);
                            gVar.c.b();
                            gVar.e.clear();
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            mVarA.a();
                            long jA2 = this.j.a() - jA;
                            synchronized (this) {
                                this.o += jA2;
                            }
                            if (iNativeSqliteDiskCacheDeleteExpired > 0) {
                                this.k.execute(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.store.diskcache.j
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.i(gVar);
                                    }
                                });
                                return;
                            }
                            synchronized (this) {
                                ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a()).a(com.google.android.libraries.navigation.internal.km.k.o)).a(this.o);
                                this.o = 0L;
                            }
                            gVar.l();
                        } catch (com.google.android.apps.gmm.jni.util.c e) {
                            throw new d(e);
                        }
                    } catch (Throwable th) {
                        if (dVarB != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (d e2) {
                    gVar.j(e2);
                    throw e2;
                }
            } catch (Throwable th3) {
                mVarA.a();
                throw th3;
            }
        } catch (IOException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1226)).p("Failed to delete expired resources:");
            gVar.l();
        }
    }

    final boolean k() {
        String[] strArr = a;
        for (int i = 0; i < 3; i++) {
            if (new File(g(), strArr[i]).exists()) {
                return true;
            }
        }
        return new File(this.c.b(), "map_cache.key").exists();
    }

    protected final File[] l() {
        ArrayList arrayList = new ArrayList(3);
        try {
            for (File file : this.b.getExternalFilesDirs(null)) {
                if (file != null) {
                    arrayList.add(new File(new File(com.google.android.libraries.navigation.internal.id.a.b(file), "cache"), "diskcache"));
                }
            }
        } catch (RuntimeException unused) {
        }
        arrayList.add(new File(this.b.getCacheDir(), "diskcache"));
        return (File[]) arrayList.toArray(new File[0]);
    }
}
