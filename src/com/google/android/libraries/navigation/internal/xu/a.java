package com.google.android.libraries.navigation.internal.xu;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static Boolean a;
    private static String b;

    private a() {
    }

    public static String a(Context context) {
        String str;
        String strTrim;
        String str2 = b;
        if (str2 != null) {
            return str2;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            b = processName;
            return processName;
        }
        String str3 = null;
        if (!"robolectric".equals(Build.FINGERPRINT)) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, a.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, null);
                str = objInvoke instanceof String ? (String) objInvoke : null;
            } catch (Throwable unused) {
            }
            b = str;
            if (str != null) {
                return str;
            }
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"), 50);
                try {
                    strTrim = bufferedReader.readLine().trim();
                    bufferedReader.close();
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                strTrim = null;
            } catch (Throwable th3) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th3;
            }
            b = strTrim;
            if (strTrim != null) {
                return strTrim;
            }
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    str3 = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        b = str3;
        return str3;
    }
}
