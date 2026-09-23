package com.mappls.sdk.navigation.apis;

import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.util.navigationLogs.NavigationTrace;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationLogger {
    private static final boolean DEBUG = false;
    private static final String TAG = "NavigationLogger";
    private static NavigationContext application;

    private NavigationLogger() {
    }

    public static void d(String str, Object... objArr) {
        NavigationTrace.writeLine(str, objArr);
    }

    public static void d(Throwable th) {
        NavigationTrace.writeLine(th.getMessage());
        NavigationContext navigationContext = application;
        if (navigationContext != null) {
            navigationContext.getClass();
        }
    }

    public static void d(Throwable th, String str, Object... objArr) {
        NavigationContext navigationContext;
        NavigationTrace.writeLine(str, objArr);
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }

    public static void e(String str, Object... objArr) {
        NavigationTrace.writeLine(str, objArr);
    }

    public static void e(Throwable th) {
        NavigationTrace.writeLine(th.getMessage());
        NavigationContext navigationContext = application;
        if (navigationContext != null) {
            navigationContext.getClass();
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        NavigationContext navigationContext;
        NavigationTrace.writeLine(str, objArr);
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }

    public static void i(String str, Object... objArr) {
        NavigationTrace.writeLine(str, objArr);
    }

    public static void i(Throwable th) {
        NavigationTrace.writeLine(th.getMessage());
        NavigationContext navigationContext = application;
        if (navigationContext != null) {
            navigationContext.getClass();
        }
    }

    public static void i(Throwable th, String str, Object... objArr) {
        NavigationContext navigationContext;
        NavigationTrace.writeLine(str, objArr);
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }

    public static void setApplication(NavigationContext navigationContext) {
        application = navigationContext;
    }

    public static void v(String str, Object... objArr) {
        NavigationTrace.writeLine(str, objArr);
    }

    public static void v(Throwable th) {
        NavigationTrace.writeLine(th.getMessage());
        NavigationContext navigationContext = application;
        if (navigationContext != null) {
            navigationContext.getClass();
        }
    }

    public static void v(Throwable th, String str, Object... objArr) {
        NavigationContext navigationContext;
        NavigationTrace.writeLine(str, objArr);
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }

    public static void w(String str, Object... objArr) {
        NavigationTrace.writeLine(str, objArr);
    }

    public static void w(Throwable th) {
        NavigationTrace.writeLine(th.getMessage());
        NavigationContext navigationContext = application;
        if (navigationContext != null) {
            navigationContext.getClass();
        }
    }

    public static void w(Throwable th, String str, Object... objArr) {
        NavigationContext navigationContext;
        NavigationTrace.writeLine(str, objArr);
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }

    public static void wtf(String str, Object... objArr) {
    }

    public static void wtf(Throwable th) {
        NavigationContext navigationContext;
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        NavigationContext navigationContext;
        if (th == null || (navigationContext = application) == null) {
            return;
        }
        navigationContext.getClass();
    }
}
