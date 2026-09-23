package com.google.android.libraries.navigation.internal.nd;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static UserManager a;
    private static volatile boolean b = !c();

    private a() {
    }

    public static boolean b(Context context) {
        return c() && !a(context);
    }

    public static boolean c() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0046 A[Catch: all -> 0x004a, TryCatch #1 {, blocks: (B:7:0x0009, B:9:0x000d, B:14:0x0015, B:16:0x0019, B:17:0x0023, B:29:0x0046, B:30:0x0048, B:20:0x0029, B:22:0x002f, B:25:0x003b, B:27:0x0042), top: B:37:0x0009, inners: #0 }] */
    public static boolean a(Context context) {
        if (b) {
            return true;
        }
        synchronized (a.class) {
            if (b) {
                return true;
            }
            int i = 1;
            while (true) {
                boolean z = false;
                if (i <= 2) {
                    if (a == null) {
                        a = (UserManager) context.getSystemService(UserManager.class);
                    }
                    UserManager userManager = a;
                    if (userManager == null) {
                        z = true;
                    } else {
                        try {
                            if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                                z = true;
                            }
                        } catch (NullPointerException unused) {
                            a = null;
                            i++;
                        }
                    }
                    if (z) {
                        b = true;
                    }
                    return z;
                }
                if (z) {
                    a = null;
                }
                if (z) {
                    b = true;
                }
                return z;
            }
        }
    }
}
