package com.google.android.libraries.navigation.internal.sk;

import com.google.android.libraries.navigation.internal.afl.nk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi implements ds {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.bi");
    public final bn a;
    public bm b;
    private final ce d;
    private final com.google.android.libraries.navigation.internal.fz.d e;
    private final com.google.android.libraries.navigation.internal.iv.f f;
    private final bh g = new bh(this);

    public bi(ce ceVar, bn bnVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar) {
        this.e = dVar;
        this.d = ceVar;
        this.a = bnVar;
        this.f = fVar;
    }

    private final c f(com.google.android.libraries.navigation.internal.bp.ac acVar) throws Throwable {
        bl blVar;
        File file;
        if (acVar instanceof com.google.android.libraries.navigation.internal.bp.z) {
            com.google.android.libraries.navigation.internal.bp.ac[] acVarArr = ((com.google.android.libraries.navigation.internal.bp.z) acVar).a;
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (com.google.android.libraries.navigation.internal.bp.ac acVar2 : acVarArr) {
                c cVarF = f(acVar2);
                if (!acVar2.a() || (cVarF != null && !(cVarF instanceof dv))) {
                    if (cVarF == null) {
                        return null;
                    }
                    if (cVarF instanceof dv) {
                        return cVarF;
                    }
                    arrayList.add(cVarF);
                } else if (cVarF instanceof dv) {
                    z = true;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList.size() == 1 ? (c) arrayList.get(0) : new bw((c[]) arrayList.toArray(new c[arrayList.size()]));
            }
            if (!z) {
                return null;
            }
        } else {
            bm bmVar = this.b;
            if (bmVar == null) {
                return null;
            }
            int i = ((com.google.android.libraries.navigation.internal.bp.ab) acVar).a;
            if (i == 0) {
                blVar = bl.b;
            } else {
                Map map = bmVar.a;
                Integer numValueOf = Integer.valueOf(i);
                if (map.containsKey(numValueOf)) {
                    String str = (String) bmVar.a.get(numValueOf);
                    if (str == null) {
                        blVar = bl.b;
                    } else {
                        File file2 = new File(bmVar.b + "/._" + str);
                        if (!file2.exists()) {
                            ZipFile zipFile = bmVar.c;
                            if (zipFile == null) {
                                file2 = null;
                            } else {
                                try {
                                    ZipEntry entry = zipFile.getEntry(str);
                                    if (entry == null) {
                                        file2 = null;
                                    } else {
                                        bk bkVar = new bk(bmVar.c, entry);
                                        com.google.android.libraries.navigation.internal.zn.p pVar = new com.google.android.libraries.navigation.internal.zn.p(file2, new com.google.android.libraries.navigation.internal.zn.o[0]);
                                        com.google.android.libraries.navigation.internal.zn.n nVar = new com.google.android.libraries.navigation.internal.zn.n(com.google.android.libraries.navigation.internal.zn.n.a);
                                        try {
                                            InputStream inputStreamA = bkVar.a();
                                            nVar.b(inputStreamA);
                                            FileOutputStream fileOutputStream = new FileOutputStream(pVar.a, pVar.b.contains(com.google.android.libraries.navigation.internal.zn.o.APPEND));
                                            nVar.b(fileOutputStream);
                                            int i2 = com.google.android.libraries.navigation.internal.zn.k.a;
                                            com.google.android.libraries.navigation.internal.yx.ar.q(inputStreamA);
                                            com.google.android.libraries.navigation.internal.yx.ar.q(fileOutputStream);
                                            byte[] bArr = new byte[8192];
                                            long j = 0;
                                            while (true) {
                                                int i3 = inputStreamA.read(bArr);
                                                if (i3 == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, i3);
                                                j += (long) i3;
                                                file2.delete();
                                                file2 = null;
                                            }
                                            nVar.close();
                                            if (j != entry.getSize()) {
                                                throw new IOException("Copy incomplete");
                                            }
                                        } catch (Throwable th) {
                                            try {
                                                throw nVar.a(th);
                                            } catch (Throwable th2) {
                                                nVar.close();
                                                throw th2;
                                            }
                                        }
                                    }
                                } catch (IOException unused) {
                                    file2.delete();
                                }
                            }
                        }
                        blVar = file2 == null ? bl.a : new bl(false, file2);
                    }
                } else {
                    blVar = bl.a;
                }
            }
            if (!blVar.c) {
                if (blVar.d == null || (file = blVar.d) == null) {
                    return null;
                }
                return this.d.b(file, com.google.android.libraries.navigation.internal.sl.s.a(this.f), b.e);
            }
        }
        return new dv();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.z
    public final c a(com.google.android.libraries.navigation.internal.vn.d dVar) {
        synchronized (this.a) {
            if (this.b == null && !d(Locale.getDefault())) {
                return null;
            }
            com.google.android.libraries.navigation.internal.yx.ar.q(this.b);
            com.google.android.libraries.navigation.internal.bp.ac acVar = dVar.b;
            if (acVar == null) {
                return null;
            }
            return f(acVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.z
    public final void b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.du
    public final void c(Locale locale) {
        d(locale);
    }

    public final boolean d(Locale locale) {
        boolean z;
        synchronized (this.a) {
            String strI = this.f.i(com.google.android.libraries.navigation.internal.iv.ab.aH, "");
            if (!strI.isEmpty()) {
                Iterator it2 = this.e.R().i.iterator();
                do {
                    if (!it2.hasNext()) {
                        this.f.t(com.google.android.libraries.navigation.internal.iv.ab.aH, "");
                        break;
                    }
                } while (!((nk) it2.next()).b.equals(strI));
            }
            if (com.google.android.libraries.navigation.internal.id.a.e()) {
                bm bmVar = this.b;
                if (bmVar != null) {
                    try {
                        bmVar.close();
                    } catch (IOException unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1428)).p("Failed to close replaced CannedSpeechBundle.");
                    }
                }
                this.b = this.a.a(locale, this.g);
            } else {
                this.b = null;
            }
            z = this.b != null;
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.du
    public final void e(com.google.android.libraries.navigation.internal.vn.d dVar, com.google.android.libraries.navigation.internal.tv.c cVar) {
        throw null;
    }
}
