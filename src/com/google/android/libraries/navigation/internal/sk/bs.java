package com.google.android.libraries.navigation.internal.sk;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.zip.ZipException;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs implements bn {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.bs");
    public final String a;
    private final Map c = new HashMap();
    private final com.google.android.libraries.navigation.internal.fz.d d;
    private final com.google.android.libraries.navigation.internal.iv.f e;
    private bq f;
    private final Executor g;
    private final com.google.android.libraries.navigation.internal.gq.ah h;
    private final eo i;
    private bh j;

    public bs(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.gq.ah ahVar, com.google.android.libraries.navigation.internal.fz.d dVar, eo eoVar, Executor executor, com.google.android.libraries.navigation.internal.id.d dVar2) {
        this.e = fVar;
        this.h = ahVar;
        this.d = dVar;
        this.i = eoVar;
        this.g = executor;
        this.a = String.valueOf(((File) dVar2.a.a()).getPath()).concat("/voice/");
        for (String str : fVar.i(com.google.android.libraries.navigation.internal.iv.ab.aJ, "").split(",")) {
            String str2 = this.a;
            String[] strArrSplit = str.split(":");
            bo boVar = strArrSplit.length != 5 ? null : new bo(strArrSplit[0], strArrSplit[1], com.google.android.libraries.navigation.internal.zy.n.a(strArrSplit[2]).b, com.google.android.libraries.navigation.internal.zy.n.a(strArrSplit[3]).b, com.google.android.libraries.navigation.internal.zy.n.a(strArrSplit[4]).b, str2);
            if (boVar != null) {
                this.c.put(boVar.a(), boVar);
            }
        }
        Iterator it2 = this.c.values().iterator();
        while (it2.hasNext()) {
            bo boVar2 = (bo) it2.next();
            if (System.currentTimeMillis() > boVar2.c + 2592000000L) {
                j(boVar2);
                it2.remove();
            }
        }
        f();
    }

    private final File i(bo boVar) {
        return new File(boVar.b(), b(boVar.a));
    }

    private static void j(bo boVar) {
        File fileB = boVar.b();
        String[] list = fileB.list();
        if (list != null) {
            for (String str : list) {
                new File(fileB, str).delete();
            }
            fileB.delete();
        }
    }

    private final synchronized void k(bq bqVar, File file, byte[] bArr) {
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1452)).s("Cannot save bundle to %s", file);
                file.delete();
                c(bqVar);
            }
        } catch (FileNotFoundException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1451)).s("Cannot save bundle to %s", file);
            c(bqVar);
        } catch (Exception unused3) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1453)).s("Cannot save bundle to %s", file);
            c(bqVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.bn
    public final synchronized bm a(Locale locale, bh bhVar) {
        bm bmVarA;
        String strB = b(locale.toString());
        bo boVar = (bo) this.c.get(new bp(locale.toString(), strB));
        if (boVar != null) {
            try {
                bmVarA = bm.a(i(boVar));
                try {
                    boVar.c = System.currentTimeMillis();
                    f();
                } catch (FileNotFoundException unused) {
                    if (!com.google.android.libraries.navigation.internal.id.a.e()) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1443)).s("Missing bundle file: %s", strB);
                    }
                } catch (ZipException unused2) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1444)).s("Failed to zip %s", strB);
                } catch (IOException unused3) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1445)).s("Unable to parse speech bundle: %s", strB);
                }
            } catch (FileNotFoundException unused4) {
                bmVarA = null;
            } catch (ZipException unused5) {
                bmVarA = null;
            } catch (IOException unused6) {
                bmVarA = null;
            }
        } else {
            bmVarA = null;
        }
        if (this.f == null && ((boVar != null && System.currentTimeMillis() > boVar.d + DateUtils.MILLIS_PER_DAY) || bmVarA == null)) {
            if (bmVarA == null) {
                boVar = null;
            }
            bq bqVar = new bq(locale, strB, boVar);
            this.j = bhVar;
            this.h.a(bqVar.a(), new br(this, bqVar), this.g);
            this.f = bqVar;
        }
        return bmVarA;
    }

    final String b(String str) {
        String strI = this.e.i(com.google.android.libraries.navigation.internal.iv.ab.aH, "");
        if (!strI.isEmpty()) {
            return strI;
        }
        if (this.i.e()) {
            String strB = this.i.b();
            if (!strB.isEmpty() && !this.i.d()) {
                return str + RemoteSettings.FORWARD_SLASH_STRING + strB + "/voice_instructions_unitless.zip";
            }
        } else {
            String str2 = this.d.R().j;
            if (!str2.isEmpty()) {
                return str2;
            }
        }
        return "voice_instructions_unitless.zip";
    }

    public final synchronized void c(bq bqVar) {
        if (this.j != null) {
            this.j = null;
        }
    }

    public final synchronized void d(bq bqVar, bo boVar, byte[] bArr) {
        File fileI = i(boVar);
        File parentFile = fileI.getParentFile();
        if (parentFile == null) {
            c(bqVar);
            return;
        }
        parentFile.mkdirs();
        k(bqVar, fileI, bArr);
        try {
            bm bmVarA = bm.a(fileI);
            bh bhVar = this.j;
            if (bhVar == null) {
                try {
                    bmVarA.close();
                } catch (IOException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1448)).p("Failed to close CannedSpeechBundle.");
                }
                g(boVar);
            } else {
                synchronized (bhVar.a.a) {
                    bhVar.a.b = bmVarA;
                }
                this.j = null;
                g(boVar);
            }
        } catch (IOException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1449)).s("Cannot parse bundle %s", boVar.a);
            fileI.delete();
            c(bqVar);
        }
    }

    public final synchronized void e(bq bqVar) {
        bqVar.d--;
        this.h.a(bqVar.a(), new br(this, bqVar), this.g);
        this.f = bqVar;
    }

    public final synchronized void f() {
        StringBuilder sbH = new com.google.android.libraries.navigation.internal.yx.ah(",").h(new StringBuilder(), this.c.values());
        this.e.t(com.google.android.libraries.navigation.internal.iv.ab.aJ, sbH.toString());
    }

    final synchronized void g(bo boVar) {
        bo boVar2 = (bo) this.c.get(boVar.a());
        this.c.put(boVar.a(), boVar);
        if (boVar2 != null) {
            if (boVar2.b != boVar.b) {
                j(boVar2);
            }
        }
        f();
    }
}
