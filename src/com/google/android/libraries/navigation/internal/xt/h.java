package com.google.android.libraries.navigation.internal.xt;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.ael.dr;
import com.google.android.libraries.navigation.internal.ael.ee;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements o {
    private final boolean a = true;
    private final Set b;
    private final bg c;
    private final bg d;

    public h(boolean z, Set set, bg bgVar, bg bgVar2) {
        this.b = set;
        this.c = bgVar;
        this.d = bgVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.libraries.navigation.internal.xt.ac] */
    private final ae c(final com.google.android.libraries.navigation.internal.xo.y yVar, final String str) {
        ae aeVar;
        ae[] aeVarArr;
        int length;
        final Set set = this.b;
        ad adVar = ae.a;
        com.google.android.libraries.navigation.internal.yx.br brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xt.z
            public final /* synthetic */ String c = "";

            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new ae(yVar, str, this.c, set);
            }
        });
        AtomicReference atomicReference = (AtomicReference) adVar.a.computeIfAbsent(str, new Function() { // from class: com.google.android.libraries.navigation.internal.xt.aa
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new AtomicReference();
            }
        });
        loop0: while (true) {
            ae[] aeVarArr2 = (ae[]) atomicReference.get();
            if (aeVarArr2 == null || (length = aeVarArr2.length) == 0) {
                ae aeVar2 = (ae) brVarA.a();
                aeVar = aeVar2;
                aeVarArr = new ae[]{aeVar2};
            } else {
                ae aeVar3 = aeVarArr2[0];
                if (aeVar3.d.equals("")) {
                    aeVar = aeVar3;
                    aeVarArr = null;
                } else {
                    aeVar = (ae) brVarA.a();
                    aeVarArr = new ae[length + 1];
                    aeVarArr[0] = aeVar;
                    System.arraycopy(aeVarArr2, 0, aeVarArr, 1, length);
                }
            }
            if (aeVarArr == null) {
                break;
            }
            do {
                if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, aeVarArr2, aeVarArr)) {
                    break loop0;
                }
            } while (atomicReference.get() == aeVarArr2);
        }
        if (aeVarArr != null) {
            Context context = yVar.d;
            ab abVar = new ab(adVar);
            ?? r1 = new Object() { // from class: com.google.android.libraries.navigation.internal.xt.ac
            };
            if (aw.a == null) {
                synchronized (aw.class) {
                    if (aw.a == null) {
                        if (!Objects.equals(context.getPackageName(), "com.google.android.gms")) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                context.registerReceiver(new aw(), new IntentFilter("com.google.android.gms.phenotype.UPDATE"), 2);
                            } else {
                                context.registerReceiver(new aw(), new IntentFilter("com.google.android.gms.phenotype.UPDATE"));
                            }
                        }
                        aw.a = abVar;
                        aw.b = r1;
                    }
                }
            }
        }
        boolean z = aeVar.e;
        com.google.android.libraries.navigation.internal.yx.ar.f(true, "Package %s cannot be registered both with and without stickyAccountSupport", str);
        return aeVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    @Override // com.google.android.libraries.navigation.internal.xt.o
    public final Object a(final com.google.android.libraries.navigation.internal.xo.y yVar, String str, String str2, boolean z) {
        Object objA;
        Object obj;
        com.google.android.libraries.navigation.internal.yx.an anVarA = com.google.android.libraries.navigation.internal.xo.m.a(yVar.d);
        Object objA2 = null;
        if (anVarA.g()) {
            String strA = ((com.google.android.libraries.navigation.internal.xo.f) anVarA.c()).a(com.google.android.libraries.navigation.internal.xo.o.a(str), null, str2);
            if (strA == null) {
                objA = null;
            } else {
                try {
                    objA = this.c.a(strA);
                } catch (IOException | IllegalArgumentException unused) {
                    objA = null;
                }
            }
        } else {
            objA = null;
        }
        final String strB = com.google.android.libraries.navigation.internal.xo.o.b(yVar.d, str);
        if (Build.VERSION.SDK_INT >= 26 && !yVar.d.getPackageName().equals("com.android.vending")) {
            ap.a(yVar.d().c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.g
                @Override // java.lang.Runnable
                public final void run() throws com.google.android.libraries.navigation.internal.ael.cc {
                    Context context = yVar.d;
                    Map map = ah.b;
                    if (map == null) {
                        synchronized (ah.a) {
                            map = ah.b;
                            if (map == null) {
                                ez ezVar = new ez();
                                try {
                                    String[] list = context.getAssets().list("phenotype");
                                    if (list != null) {
                                        for (String str3 : list) {
                                            if (str3.endsWith("_package_metadata.binarypb")) {
                                                try {
                                                    InputStream inputStreamOpen = context.getAssets().open("phenotype/" + str3);
                                                    try {
                                                        com.google.android.libraries.navigation.internal.ael.ar arVar = com.google.android.libraries.navigation.internal.ael.ar.a;
                                                        di diVar = di.a;
                                                        com.google.android.libraries.navigation.internal.ael.ar arVar2 = com.google.android.libraries.navigation.internal.ael.ar.a;
                                                        aj ajVar = aj.a;
                                                        com.google.android.libraries.navigation.internal.ael.ac acVarJ = com.google.android.libraries.navigation.internal.ael.ac.J(inputStreamOpen);
                                                        com.google.android.libraries.navigation.internal.ael.bi biVarU = ajVar.u();
                                                        try {
                                                            try {
                                                                try {
                                                                    dr drVarB = di.a.b(biVarU);
                                                                    drVarB.h(biVarU, com.google.android.libraries.navigation.internal.ael.ad.p(acVarJ), arVar2);
                                                                    drVarB.f(biVarU);
                                                                    com.google.android.libraries.navigation.internal.ael.bi.I(biVarU);
                                                                    ah ahVar = new ah(context, (aj) biVarU);
                                                                    ezVar.f(ahVar.c, ahVar);
                                                                    if (inputStreamOpen != null) {
                                                                        inputStreamOpen.close();
                                                                    }
                                                                } catch (ee e) {
                                                                    throw e.a();
                                                                }
                                                            } catch (IOException e2) {
                                                                if (!(e2.getCause() instanceof com.google.android.libraries.navigation.internal.ael.cc)) {
                                                                    throw new com.google.android.libraries.navigation.internal.ael.cc(e2);
                                                                }
                                                                throw ((com.google.android.libraries.navigation.internal.ael.cc) e2.getCause());
                                                            }
                                                        } catch (com.google.android.libraries.navigation.internal.ael.cc e3) {
                                                            if (!e3.a) {
                                                                throw e3;
                                                            }
                                                            throw new com.google.android.libraries.navigation.internal.ael.cc(e3);
                                                        } catch (RuntimeException e4) {
                                                            if (!(e4.getCause() instanceof com.google.android.libraries.navigation.internal.ael.cc)) {
                                                                throw e4;
                                                            }
                                                            throw ((com.google.android.libraries.navigation.internal.ael.cc) e4.getCause());
                                                        }
                                                    } catch (Throwable th) {
                                                        if (inputStreamOpen != null) {
                                                            try {
                                                                inputStreamOpen.close();
                                                            } catch (Throwable th2) {
                                                                th.addSuppressed(th2);
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                } catch (com.google.android.libraries.navigation.internal.ael.cc unused2) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } catch (IOException unused3) {
                                }
                                fd fdVarD = ezVar.d();
                                ah.b = fdVarD;
                                map = fdVarD;
                            }
                        }
                    }
                    map.containsKey(strB);
                }
            }));
        }
        ae aeVarC = c(yVar, strB);
        if (z) {
            br brVarA = aeVarC.a();
            obj = brVarA.c.contains(str2) ? brVarA.d.get(str2) : null;
        } else {
            obj = aeVarC.a().d.get(str2);
        }
        if (obj != null) {
            try {
                objA2 = this.d.a(obj);
            } catch (IOException | ClassCastException unused2) {
            }
        }
        return anVarA.g() ? objA : objA2;
    }

    @Override // com.google.android.libraries.navigation.internal.xt.o
    public final ak b(com.google.android.libraries.navigation.internal.xo.y yVar, String str) {
        com.google.android.libraries.navigation.internal.xo.y.f();
        return c(yVar, com.google.android.libraries.navigation.internal.xo.o.b(yVar.d, str)).g;
    }
}
