package com.mappls.sdk.maps.utils;

import android.content.Context;
import android.os.Looper;
import com.mappls.sdk.maps.exceptions.CalledFromWorkerThreadException;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadUtils {
    private static Boolean debug;

    public static ThreadUtils init(Context context) {
        debug = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        return null;
    }

    public static void checkThread(String str) {
        Boolean bool = debug;
        if (bool == null) {
            throw new IllegalStateException("ThreadUtils isn't correctly initialised");
        }
        if (bool.booleanValue() && Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWorkerThreadException(String.format("%s interactions should happen on the UI thread.", str));
        }
    }
}
