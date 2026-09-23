package com.google.android.libraries.navigation.internal.abf;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.os.StrictMode;
import java.io.IOException;
import java.util.Scanner;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static final String a = "y";
    public static final y b = new y();

    private y() {
    }

    public static boolean b() {
        try {
            return n.a();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures != null && (systemAvailableFeatures.length) > 0) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (featureInfo.name == null && featureInfo.reqGlEsVersion >= 131072) {
                    return true;
                }
            }
        }
        return false;
    }

    static final Process d(String str) {
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", str});
            int i = 0;
            do {
                try {
                    try {
                        if (processExec.exitValue() != 0) {
                            break;
                        }
                        return processExec;
                    } catch (IllegalThreadStateException unused) {
                        Thread.sleep(5L);
                        i += 5;
                    }
                } catch (InterruptedException unused2) {
                    p.f(a, 5);
                    return null;
                }
            } while (i < 1000);
            p.f(a, 5);
            return null;
        } catch (IOException unused3) {
            p.f(a, 5);
            return null;
        }
    }

    public final String a(String str, String str2) {
        String property = System.getProperty(str);
        if (property == null) {
            Process processD = d(str);
            property = null;
            if (processD != null) {
                StrictMode.ThreadPolicy threadPolicyA = w.a.a();
                try {
                    Scanner scannerUseDelimiter = new Scanner(processD.getInputStream(), "UTF-8").useDelimiter("\n");
                    try {
                        property = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : null;
                        if (scannerUseDelimiter != null) {
                            scannerUseDelimiter.close();
                        }
                        w.a.d(threadPolicyA);
                    } catch (Throwable th) {
                        if (scannerUseDelimiter != null) {
                            try {
                                scannerUseDelimiter.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    w.a.d(threadPolicyA);
                    throw th3;
                }
            }
        }
        return property != null ? property : str2;
    }
}
