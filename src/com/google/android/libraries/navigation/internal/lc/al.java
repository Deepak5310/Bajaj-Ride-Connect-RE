package com.google.android.libraries.navigation.internal.lc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.libraries.navigation.internal.lh.au;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al {
    private static al b;
    private static volatile Set c;
    private static volatile Set d;
    public final Context a;
    private volatile String e;

    public al(Context context) {
        this.a = context.getApplicationContext();
    }

    public static al a(Context context) {
        be.j(context);
        synchronized (al.class) {
            if (b == null) {
                u.c(context);
                b = new al(context);
            }
        }
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static final boolean c(PackageInfo packageInfo, boolean z) {
        ev evVarG;
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo == null) {
            return false;
        }
        try {
            ev evVar = z ? t.c : t.b;
            int i = com.google.android.libraries.navigation.internal.ll.a.a;
            if (Build.VERSION.SDK_INT < 28) {
                byte[] byteArray = null;
                if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
                    byteArray = packageInfo.signatures[0].toByteArray();
                }
                if (byteArray != null) {
                    evVarG = ev.q(byteArray);
                } else {
                    int i2 = ev.d;
                    evVarG = lv.a;
                }
            } else {
                ar.k(Build.VERSION.SDK_INT >= 28);
                SigningInfo signingInfo = packageInfo.signingInfo;
                if (signingInfo == null || signingInfo.hasMultipleSigners() || signingInfo.getSigningCertificateHistory() == null) {
                    int i3 = ev.d;
                    evVarG = lv.a;
                } else {
                    int i4 = ev.d;
                    eq eqVar = new eq();
                    for (Signature signature : signingInfo.getSigningCertificateHistory()) {
                        eqVar.h(signature.toByteArray());
                    }
                    evVarG = eqVar.g();
                }
            }
            if (evVarG.isEmpty()) {
                throw new IllegalArgumentException("Unable to obtain package certificate history.");
            }
            ev evVarH = evVarG.h();
            int size = evVarH.size();
            int i5 = 0;
            while (i5 < size) {
                byte[] bArr = (byte[]) evVarH.get(i5);
                Iterator<E> it2 = evVar.iterator();
                do {
                    int i6 = i5 + 1;
                    if (!it2.hasNext()) {
                        i5 = i6;
                    }
                } while (!Arrays.equals(bArr, (byte[]) it2.next()));
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
            return (z ? d(packageInfo, t.a) : d(packageInfo, t.a[0])) != null;
        }
    }

    private static q d(PackageInfo packageInfo, q... qVarArr) {
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
            return null;
        }
        r rVar = new r(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < qVarArr.length; i++) {
            if (qVarArr[i].equals(rVar)) {
                return qVarArr[i];
            }
        }
        return null;
    }

    public final boolean b(String str) {
        ac acVarC;
        ac acVarB;
        String strConcat;
        Throwable th;
        ac acVarC2;
        if (str == null) {
            acVarC = ac.b("null pkg");
        } else if (str.equals(this.e)) {
            acVarC = ac.a;
        } else {
            au auVar = u.g;
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                u.d();
                boolean zG = u.g.g();
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                if (zG) {
                    boolean zD = ak.d(this.a);
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                    try {
                        be.j(u.h);
                        try {
                            u.d();
                            try {
                                x xVarE = u.g.e(new v(str, zD, false, new com.google.android.libraries.navigation.internal.lo.n(u.h), false, true));
                                if (xVarE.a) {
                                    xVarE.a();
                                    acVarC2 = new ac(true, null, null);
                                } else {
                                    String str2 = xVarE.b;
                                    PackageManager.NameNotFoundException nameNotFoundException = xVarE.b() == 4 ? new PackageManager.NameNotFoundException() : null;
                                    if (str2 == null) {
                                        str2 = "error checking package certificate";
                                    }
                                    xVarE.a();
                                    xVarE.b();
                                    acVarC2 = new ac(false, str2, nameNotFoundException);
                                }
                            } catch (RemoteException e) {
                                strConcat = "module call";
                                th = e;
                                acVarC2 = ac.c(strConcat, th);
                            }
                        } catch (com.google.android.libraries.navigation.internal.lp.j e2) {
                            strConcat = "module init: ".concat(String.valueOf(e2.getMessage()));
                            th = e2;
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                        acVarB = acVarC2;
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                        throw th2;
                    }
                } else {
                    try {
                        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(str, Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
                        boolean zD2 = ak.d(this.a);
                        if (packageInfo == null) {
                            acVarB = ac.b("null pkg");
                        } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                            acVarB = ac.b("single cert required");
                        } else {
                            r rVar = new r(packageInfo.signatures[0].toByteArray());
                            String str3 = packageInfo.packageName;
                            ac acVarA = u.a(str3, rVar, zD2, false);
                            acVarB = (!acVarA.b || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !u.a(str3, rVar, false, true).b) ? acVarA : ac.b("debuggable release cert app rejected");
                        }
                    } catch (PackageManager.NameNotFoundException e3) {
                        acVarC = ac.c("no pkg ".concat(str), e3);
                    }
                }
            } catch (RemoteException | com.google.android.libraries.navigation.internal.lp.j unused) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            } catch (Throwable th3) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th3;
            }
            if (acVarB.b) {
                this.e = str;
            }
            acVarC = acVarB;
        }
        if (!acVarC.b && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (acVarC.d != null) {
                acVarC.a();
            } else {
                acVarC.a();
            }
        }
        return acVarC.b;
    }
}
