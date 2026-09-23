package com.google.android.libraries.navigation.internal.iu;

import android.app.ActivityManager;
import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.nw.d;
import com.google.android.libraries.navigation.internal.nw.e;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private final Context a;

    public b(Context context) {
        this.a = context;
    }

    public final boolean a() throws a {
        return b(this.a, (ActivityManager) this.a.getSystemService("activity"));
    }

    public static boolean b(Context context, ActivityManager activityManager) throws a {
        if (activityManager == null) {
            throw new a("ActivityManager is not available.");
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            d dVarB = e.b("ProcessInfoFetcher.getCurrentProcessName");
            try {
                String strA = com.google.android.libraries.navigation.internal.xu.a.a(context);
                if (strA == null) {
                    strA = "<?>";
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(strA)) {
                        return runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
                    }
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
        }
        throw new a("Process not found in running list");
    }
}
