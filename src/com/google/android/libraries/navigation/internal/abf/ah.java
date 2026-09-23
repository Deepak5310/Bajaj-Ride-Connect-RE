package com.google.android.libraries.navigation.internal.abf;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    public static final ExecutorService a = Executors.newFixedThreadPool(2, g("bg", 4));
    public static final ExecutorService b = Executors.newSingleThreadExecutor(g("lpbg", 1));
    public static final ah c = new ah();
    public static final Runnable d = new Runnable() { // from class: com.google.android.libraries.navigation.internal.abf.ab
        @Override // java.lang.Runnable
        public final void run() {
            ExecutorService executorService = ah.a;
        }
    };

    private ah() {
    }

    public static Executor a() {
        return b(new Handler(Looper.getMainLooper()));
    }

    public static Executor b(final Handler handler) {
        return new Executor() { // from class: com.google.android.libraries.navigation.internal.abf.aa
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                ExecutorService executorService = ah.a;
                if (!handler.post(runnable)) {
                    throw new RuntimeException("Operation could not be posted on handler. Looper may be exiting.");
                }
            }
        };
    }

    public static ExecutorService c(String str, int i) {
        return Executors.newFixedThreadPool(i, f(str));
    }

    public static ExecutorService d(String str) {
        return Executors.newSingleThreadExecutor(f(str));
    }

    public static ScheduledExecutorService e(String str) {
        return Executors.newSingleThreadScheduledExecutor(f(str));
    }

    public static ThreadFactory f(String str) {
        return new ag("androidmapsapi-".concat(str), 5);
    }

    public static ThreadFactory g(String str, int i) {
        return new ag("androidmapsapi-".concat(str), i);
    }
}
