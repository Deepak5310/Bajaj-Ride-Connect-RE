package com.google.android.libraries.navigation.internal.la;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.ky.ar;
import com.google.android.libraries.navigation.internal.xo.ae;
import com.google.android.libraries.navigation.internal.xo.af;
import com.google.android.libraries.navigation.internal.xo.ag;
import com.google.android.libraries.navigation.internal.xo.ah;
import com.google.android.libraries.navigation.internal.xo.ak;
import com.google.android.libraries.navigation.internal.yx.an;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements ar {
    public static final Charset a = Charset.forName("UTF-8");
    static Boolean b;
    static Long c;
    private static final af e;
    private static final ConcurrentHashMap f;
    public final Context d;

    static {
        af afVar = new af(com.google.android.libraries.navigation.internal.xo.o.a("com.google.android.gms.clearcut.public"), "", "");
        af afVar2 = new af(afVar.a, "gms:playlog:service:samplingrules_", afVar.c);
        e = new af(afVar2.a, afVar2.b, "LogSamplingRulesV2__");
        f = new ConcurrentHashMap();
        b = null;
        c = null;
    }

    public v(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        if (applicationContext != null) {
            ah.f(applicationContext);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0071 A[PHI: r3
      0x0071: PHI (r3v1 com.google.android.libraries.navigation.internal.yx.an) = 
      (r3v0 com.google.android.libraries.navigation.internal.yx.an)
      (r3v7 com.google.android.libraries.navigation.internal.yx.an)
     binds: [B:17:0x004b, B:19:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0098  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6 A[Catch: all -> 0x0152, TRY_LEAVE, TryCatch #1 {, blocks: (B:36:0x00b4, B:38:0x00bc, B:39:0x00c8, B:41:0x00ca, B:43:0x00d6, B:47:0x00e6, B:49:0x00ec, B:57:0x0108, B:58:0x0112, B:51:0x00f6, B:52:0x00fa, B:53:0x0100), top: B:123:0x00b4, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0106  */
    /* JADX WARN: Code duplicated, block: B:56:0x0107  */
    /* JADX WARN: Code duplicated, block: B:87:0x0182  */
    /* JADX WARN: Code duplicated, block: B:89:0x0185 A[Catch: all -> 0x01cd, TryCatch #6 {, blocks: (B:14:0x0042, B:16:0x0046, B:18:0x004d, B:20:0x005e, B:22:0x0072, B:26:0x007a, B:28:0x0085, B:84:0x0173, B:86:0x017d, B:89:0x0185, B:91:0x019b, B:93:0x01a1, B:95:0x01a7, B:98:0x01af, B:99:0x01b4, B:100:0x01b8, B:31:0x009b, B:33:0x00a3, B:61:0x0121, B:62:0x0137, B:72:0x0151, B:34:0x00b1, B:35:0x00b3, B:59:0x0113, B:75:0x0154, B:76:0x0155, B:79:0x0164, B:109:0x01c9, B:110:0x01ca, B:111:0x01cb, B:36:0x00b4, B:38:0x00bc, B:39:0x00c8, B:41:0x00ca, B:43:0x00d6, B:47:0x00e6, B:49:0x00ec, B:57:0x0108, B:58:0x0112, B:51:0x00f6, B:52:0x00fa, B:53:0x0100, B:80:0x0165, B:82:0x0170, B:102:0x01bd, B:105:0x01c3, B:106:0x01c6, B:103:0x01c1, B:63:0x0138, B:65:0x0142, B:66:0x0147, B:68:0x014d), top: B:131:0x0042, inners: #1, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x019b A[Catch: all -> 0x01cd, TryCatch #6 {, blocks: (B:14:0x0042, B:16:0x0046, B:18:0x004d, B:20:0x005e, B:22:0x0072, B:26:0x007a, B:28:0x0085, B:84:0x0173, B:86:0x017d, B:89:0x0185, B:91:0x019b, B:93:0x01a1, B:95:0x01a7, B:98:0x01af, B:99:0x01b4, B:100:0x01b8, B:31:0x009b, B:33:0x00a3, B:61:0x0121, B:62:0x0137, B:72:0x0151, B:34:0x00b1, B:35:0x00b3, B:59:0x0113, B:75:0x0154, B:76:0x0155, B:79:0x0164, B:109:0x01c9, B:110:0x01ca, B:111:0x01cb, B:36:0x00b4, B:38:0x00bc, B:39:0x00c8, B:41:0x00ca, B:43:0x00d6, B:47:0x00e6, B:49:0x00ec, B:57:0x0108, B:58:0x0112, B:51:0x00f6, B:52:0x00fa, B:53:0x0100, B:80:0x0165, B:82:0x0170, B:102:0x01bd, B:105:0x01c3, B:106:0x01c6, B:103:0x01c1, B:63:0x0138, B:65:0x0142, B:66:0x0147, B:68:0x014d), top: B:131:0x0042, inners: #1, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01a1 A[Catch: all -> 0x01cd, TryCatch #6 {, blocks: (B:14:0x0042, B:16:0x0046, B:18:0x004d, B:20:0x005e, B:22:0x0072, B:26:0x007a, B:28:0x0085, B:84:0x0173, B:86:0x017d, B:89:0x0185, B:91:0x019b, B:93:0x01a1, B:95:0x01a7, B:98:0x01af, B:99:0x01b4, B:100:0x01b8, B:31:0x009b, B:33:0x00a3, B:61:0x0121, B:62:0x0137, B:72:0x0151, B:34:0x00b1, B:35:0x00b3, B:59:0x0113, B:75:0x0154, B:76:0x0155, B:79:0x0164, B:109:0x01c9, B:110:0x01ca, B:111:0x01cb, B:36:0x00b4, B:38:0x00bc, B:39:0x00c8, B:41:0x00ca, B:43:0x00d6, B:47:0x00e6, B:49:0x00ec, B:57:0x0108, B:58:0x0112, B:51:0x00f6, B:52:0x00fa, B:53:0x0100, B:80:0x0165, B:82:0x0170, B:102:0x01bd, B:105:0x01c3, B:106:0x01c6, B:103:0x01c1, B:63:0x0138, B:65:0x0142, B:66:0x0147, B:68:0x014d), top: B:131:0x0042, inners: #1, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x01af A[Catch: all -> 0x01cd, TryCatch #6 {, blocks: (B:14:0x0042, B:16:0x0046, B:18:0x004d, B:20:0x005e, B:22:0x0072, B:26:0x007a, B:28:0x0085, B:84:0x0173, B:86:0x017d, B:89:0x0185, B:91:0x019b, B:93:0x01a1, B:95:0x01a7, B:98:0x01af, B:99:0x01b4, B:100:0x01b8, B:31:0x009b, B:33:0x00a3, B:61:0x0121, B:62:0x0137, B:72:0x0151, B:34:0x00b1, B:35:0x00b3, B:59:0x0113, B:75:0x0154, B:76:0x0155, B:79:0x0164, B:109:0x01c9, B:110:0x01ca, B:111:0x01cb, B:36:0x00b4, B:38:0x00bc, B:39:0x00c8, B:41:0x00ca, B:43:0x00d6, B:47:0x00e6, B:49:0x00ec, B:57:0x0108, B:58:0x0112, B:51:0x00f6, B:52:0x00fa, B:53:0x0100, B:80:0x0165, B:82:0x0170, B:102:0x01bd, B:105:0x01c3, B:106:0x01c6, B:103:0x01c1, B:63:0x0138, B:65:0x0142, B:66:0x0147, B:68:0x014d), top: B:131:0x0042, inners: #1, #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01b4 A[Catch: all -> 0x01cd, TryCatch #6 {, blocks: (B:14:0x0042, B:16:0x0046, B:18:0x004d, B:20:0x005e, B:22:0x0072, B:26:0x007a, B:28:0x0085, B:84:0x0173, B:86:0x017d, B:89:0x0185, B:91:0x019b, B:93:0x01a1, B:95:0x01a7, B:98:0x01af, B:99:0x01b4, B:100:0x01b8, B:31:0x009b, B:33:0x00a3, B:61:0x0121, B:62:0x0137, B:72:0x0151, B:34:0x00b1, B:35:0x00b3, B:59:0x0113, B:75:0x0154, B:76:0x0155, B:79:0x0164, B:109:0x01c9, B:110:0x01ca, B:111:0x01cb, B:36:0x00b4, B:38:0x00bc, B:39:0x00c8, B:41:0x00ca, B:43:0x00d6, B:47:0x00e6, B:49:0x00ec, B:57:0x0108, B:58:0x0112, B:51:0x00f6, B:52:0x00fa, B:53:0x0100, B:80:0x0165, B:82:0x0170, B:102:0x01bd, B:105:0x01c3, B:106:0x01c6, B:103:0x01c1, B:63:0x0138, B:65:0x0142, B:66:0x0147, B:68:0x014d), top: B:131:0x0042, inners: #1, #3, #7 }] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.android.libraries.navigation.internal.la.u] */
    final List a(String str) {
        String strA;
        com.google.android.libraries.navigation.internal.xo.i iVar;
        Object objA;
        Object objA2;
        Object objA3;
        boolean zBooleanValue;
        if (this.d == null) {
            return Collections.emptyList();
        }
        ConcurrentHashMap concurrentHashMap = f;
        ah ahVar = (ah) concurrentHashMap.get(str);
        if (ahVar == null) {
            af afVar = e;
            com.google.android.libraries.navigation.internal.afk.q qVar = com.google.android.libraries.navigation.internal.afk.q.a;
            ?? r3 = new Object() { // from class: com.google.android.libraries.navigation.internal.la.u
            };
            ag agVar = ah.b;
            ae aeVar = new ae(afVar, str, qVar, r3);
            ahVar = (ah) concurrentHashMap.putIfAbsent(str, aeVar);
            if (ahVar == null) {
                ahVar = aeVar;
            }
        }
        boolean z = ah.d.a;
        boolean z2 = true;
        com.google.android.libraries.navigation.internal.yx.ar.l(true, "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        int i = ah.e.get();
        if (ahVar.h < i) {
            synchronized (ahVar) {
                if (ahVar.h < i) {
                    ag agVar2 = ah.b;
                    an anVar = com.google.android.libraries.navigation.internal.yx.a.a;
                    if (agVar2 != null) {
                        anVar = (an) ((com.google.android.libraries.navigation.internal.xo.a) agVar2).b.a();
                        if (anVar.g()) {
                            com.google.android.libraries.navigation.internal.xo.f fVar = (com.google.android.libraries.navigation.internal.xo.f) anVar.c();
                            af afVar2 = ahVar.f;
                            strA = fVar.a(afVar2.a, afVar2.c, ahVar.g);
                        } else {
                            strA = null;
                        }
                    } else {
                        strA = null;
                    }
                    boolean z3 = ah.c;
                    com.google.android.libraries.navigation.internal.yx.ar.l(agVar2 != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    Uri uri = ahVar.f.a;
                    if (uri != null) {
                        Context context = ((com.google.android.libraries.navigation.internal.xo.a) agVar2).a;
                        an anVar2 = com.google.android.libraries.navigation.internal.xo.n.a;
                        if ("com.google.android.gms.phenotype".equals(uri.getAuthority())) {
                            if (com.google.android.libraries.navigation.internal.xo.n.a.g()) {
                                zBooleanValue = ((Boolean) com.google.android.libraries.navigation.internal.xo.n.a.c()).booleanValue();
                            } else {
                                synchronized (com.google.android.libraries.navigation.internal.xo.n.b) {
                                    if (com.google.android.libraries.navigation.internal.xo.n.a.g()) {
                                        zBooleanValue = ((Boolean) com.google.android.libraries.navigation.internal.xo.n.a.c()).booleanValue();
                                    } else {
                                        if (!"com.google.android.gms".equals(context.getPackageName())) {
                                            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                                            if (providerInfoResolveContentProvider == null || !"com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                                                z2 = false;
                                            } else {
                                                try {
                                                    if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                                                        z2 = false;
                                                    }
                                                } catch (PackageManager.NameNotFoundException unused) {
                                                }
                                            }
                                        } else if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                                            z2 = false;
                                        }
                                        com.google.android.libraries.navigation.internal.xo.n.a = an.j(Boolean.valueOf(z2));
                                        zBooleanValue = ((Boolean) com.google.android.libraries.navigation.internal.xo.n.a.c()).booleanValue();
                                    }
                                }
                            }
                            if (zBooleanValue) {
                                ContentResolver contentResolver = ((com.google.android.libraries.navigation.internal.xo.a) agVar2).a.getContentResolver();
                                Uri uri2 = ahVar.f.a;
                                Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.xo.ab
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ah.e();
                                    }
                                };
                                Map map = com.google.android.libraries.navigation.internal.xo.d.a;
                                synchronized (com.google.android.libraries.navigation.internal.xo.d.class) {
                                    iVar = (com.google.android.libraries.navigation.internal.xo.d) com.google.android.libraries.navigation.internal.xo.d.a.get(uri2);
                                    if (iVar == null) {
                                        try {
                                            com.google.android.libraries.navigation.internal.xo.d dVar = new com.google.android.libraries.navigation.internal.xo.d(contentResolver, uri2, runnable);
                                            try {
                                                com.google.android.libraries.navigation.internal.xo.d.a.put(uri2, dVar);
                                            } catch (SecurityException unused2) {
                                            }
                                            iVar = dVar;
                                        } catch (SecurityException unused3) {
                                        }
                                    }
                                }
                            } else {
                                iVar = null;
                            }
                        } else {
                            iVar = null;
                        }
                        if (iVar != null || (objA3 = iVar.a(ahVar.c())) == null) {
                            objA = null;
                        } else {
                            objA = ahVar.a(objA3);
                        }
                        if (objA == null) {
                            String strA2 = com.google.android.libraries.navigation.internal.xo.l.b(((com.google.android.libraries.navigation.internal.xo.a) agVar2).a).a(ahVar.d(ahVar.f.b));
                            objA2 = strA2 != null ? ahVar.a(strA2) : null;
                            if (objA2 == null) {
                                objA = ahVar.b();
                            } else {
                                objA = objA2;
                            }
                        }
                        if (anVar.g()) {
                            if (strA == null) {
                                objA = ahVar.b();
                            } else {
                                objA = ahVar.a(strA);
                            }
                        }
                        ahVar.i = objA;
                        ahVar.h = i;
                    } else {
                        Context context2 = ((com.google.android.libraries.navigation.internal.xo.a) agVar2).a;
                        Map map2 = ak.a;
                        if (com.google.android.libraries.navigation.internal.nd.a.c()) {
                            throw null;
                        }
                        synchronized (ak.class) {
                            iVar = (ak) ak.a.get(null);
                            if (iVar == null) {
                                StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                try {
                                    throw null;
                                } catch (Throwable th) {
                                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                    throw th;
                                }
                            }
                        }
                        if (iVar != null) {
                            objA = null;
                        } else {
                            objA = null;
                        }
                        if (objA == null) {
                            String strA3 = com.google.android.libraries.navigation.internal.xo.l.b(((com.google.android.libraries.navigation.internal.xo.a) agVar2).a).a(ahVar.d(ahVar.f.b));
                            if (strA3 != null) {
                            }
                            if (objA2 == null) {
                                objA = ahVar.b();
                            } else {
                                objA = objA2;
                            }
                        }
                        if (anVar.g()) {
                            if (strA == null) {
                                objA = ahVar.b();
                            } else {
                                objA = ahVar.a(strA);
                            }
                        }
                        ahVar.i = objA;
                        ahVar.h = i;
                    }
                }
            }
        }
        return ((com.google.android.libraries.navigation.internal.afk.q) ahVar.i).b;
    }
}
