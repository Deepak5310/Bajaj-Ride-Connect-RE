package com.google.android.libraries.navigation.internal.xt;

import android.app.ActivityManager;
import android.os.Process;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av implements ax {
    private static boolean b;
    public final com.google.android.libraries.navigation.internal.yx.br a;
    private final com.google.android.libraries.navigation.internal.yx.br c;
    private final int d;

    public av(com.google.android.libraries.navigation.internal.yx.br brVar) {
        com.google.android.libraries.navigation.internal.yx.br brVar2 = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.xt.as
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                boolean z = false;
                try {
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    int i = runningAppProcessInfo.importance;
                    if (runningAppProcessInfo.importance >= 400) {
                        z = true;
                    }
                } catch (RuntimeException unused) {
                }
                return Boolean.valueOf(z);
            }
        };
        this.c = brVar;
        this.d = Math.max(5, 10);
        this.a = brVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.xt.ax
    public final void a() {
        synchronized (av.class) {
            if (!b) {
                Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.at
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (((Boolean) this.a.a.a()).booleanValue()) {
                            Process.killProcess(Process.myPid());
                            System.exit(0);
                        }
                    }
                };
                long j = this.d;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                com.google.android.libraries.navigation.internal.aac.bn bnVar = (com.google.android.libraries.navigation.internal.aac.bn) this.c.a();
                ap.a(bnVar.schedule(new au(runnable, bnVar, j, timeUnit), j, timeUnit));
                b = true;
            }
        }
    }
}
