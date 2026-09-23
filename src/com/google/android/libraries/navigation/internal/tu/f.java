package com.google.android.libraries.navigation.internal.tu;

import android.speech.tts.TextToSpeech;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.sk.ef;
import com.google.android.libraries.navigation.internal.sk.ej;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yx.ao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.tv.d {
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.tu.f");
    public com.google.android.libraries.navigation.internal.sl.p a;
    public final com.google.android.libraries.navigation.internal.sl.o b;
    public final com.google.android.libraries.navigation.internal.cw.a c;
    public com.google.android.libraries.navigation.internal.tv.b d;
    public boolean e;
    public final eo f;
    private final ad h;
    private final z i;
    private final com.google.android.libraries.navigation.internal.th.c j;
    private final boolean k;
    private final Map l = new HashMap();
    private final Map m = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Executor f606n;
    private final Executor o;
    private final com.google.android.libraries.navigation.internal.hn.r p;
    private final ej q;

    public f(z zVar, ej ejVar, com.google.android.libraries.navigation.internal.sl.o oVar, ad adVar, com.google.android.libraries.navigation.internal.th.c cVar, com.google.android.libraries.navigation.internal.cw.a aVar, eo eoVar, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.i = zVar;
        this.q = ejVar;
        this.h = adVar;
        this.b = oVar;
        this.j = cVar;
        this.c = aVar;
        this.f = eoVar;
        this.f606n = executor;
        this.o = executor2;
        this.p = rVar;
        this.k = ((hm) rVar.b()).j;
    }

    static String b(t tVar) {
        return String.valueOf(tVar.hashCode());
    }

    @Override // com.google.android.libraries.navigation.internal.tv.d
    public final synchronized File a(t tVar) {
        Map map = this.l;
        String strB = b(tVar);
        if (!map.containsKey(strB) || this.l.get(strB) == null || !((Boolean) ((ao) this.l.get(strB)).b).booleanValue()) {
            return null;
        }
        return (File) ((ao) this.l.get(strB)).a;
    }

    @Override // com.google.android.libraries.navigation.internal.tv.d
    public final void c() {
        com.google.android.libraries.navigation.internal.tv.b bVar;
        TextToSpeech textToSpeech;
        synchronized (this) {
            bVar = this.d;
            if (bVar == null) {
                bVar = null;
            }
            this.d = null;
        }
        if (bVar != null) {
            f(bVar.a);
        }
        com.google.android.libraries.navigation.internal.sl.p pVar = this.a;
        if (pVar != null && (textToSpeech = ((ef) pVar).h) != null) {
            textToSpeech.stop();
        }
        synchronized (this) {
            this.l.clear();
            this.m.clear();
        }
    }

    final void d(String str) {
        File file;
        t tVar;
        synchronized (this) {
            file = null;
            if (this.l.containsKey(str) && this.l.get(str) != null) {
                file = (File) ((ao) this.l.get(str)).a;
            }
            tVar = (t) this.m.get(str);
        }
        if (file != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[44];
                    if (fileInputStream.read(bArr) == 44) {
                        if (bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 65 && bArr[10] == 86 && bArr[11] == 69) {
                            int i = ((bArr[41] & 255) << 8) | (bArr[40] & 255) | ((bArr[42] & 255) << 16) | ((bArr[43] & 255) << 24);
                            if (i > 0 && i + 44 == file.length()) {
                                byte[] bArr2 = new byte[65536];
                                if (fileInputStream.read(bArr2) == Math.min(i, 65536) && !Arrays.equals(bArr2, z.a)) {
                                }
                            }
                            fileInputStream.close();
                        }
                        fileInputStream.close();
                        if (tVar != null) {
                            synchronized (this) {
                                this.l.put(str, new ao(file, true));
                                this.j.l(tVar.b());
                            }
                            ej ejVar = this.q;
                            if (ejVar != null) {
                                ejVar.a(tVar, true);
                                return;
                            }
                            return;
                        }
                    } else {
                        fileInputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
            }
        }
        e(str);
    }

    final void e(String str) {
        t tVar;
        synchronized (this) {
            this.l.remove(str);
            tVar = (t) this.m.remove(str);
        }
        ej ejVar = this.q;
        if (ejVar == null || tVar == null) {
            return;
        }
        ejVar.a(tVar, false);
    }

    public final void f(t tVar) {
        ej ejVar = this.q;
        if (ejVar != null) {
            ejVar.a(tVar, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r2.setOnUtteranceProgressListener(r0) == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void g(int i) {
        com.google.android.libraries.navigation.internal.tv.b bVar;
        if (i == 0) {
            synchronized (this) {
                if (this.a == null) {
                    com.google.android.libraries.navigation.internal.sl.p pVarA = this.b.a();
                    this.a = pVarA;
                    if (pVarA != null) {
                        e eVar = new e(this);
                        TextToSpeech textToSpeech = ((ef) pVarA).h;
                        if (textToSpeech != null) {
                        }
                    }
                    return;
                }
                synchronized (this) {
                    this.e = true;
                    bVar = this.d;
                    if (bVar != null) {
                        this.d = null;
                    } else {
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    h(bVar);
                }
            }
        }
    }

    public final void h(com.google.android.libraries.navigation.internal.tv.b bVar) {
        boolean z;
        bj bjVarH;
        File fileA = this.h.a();
        t tVar = bVar.a;
        String strB = b(tVar);
        synchronized (this) {
            if (this.l.get(strB) != null) {
                z = true;
            } else {
                this.l.put(strB, new ao(fileA, false));
                this.m.put(strB, tVar);
                z = false;
            }
        }
        if (z) {
            d(strB);
            return;
        }
        if (this.k) {
            final z zVar = this.i;
            Objects.requireNonNull(zVar);
            bjVarH = az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.tu.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(zVar.a());
                }
            }, this.f606n);
        } else {
            bjVarH = az.h(Boolean.valueOf(this.i.a()));
        }
        az.o(bjVarH, new c(this, strB, ((g) tVar).a, fileA), this.k ? this.o : com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    }
}
