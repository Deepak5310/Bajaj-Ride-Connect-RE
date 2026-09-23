package com.google.android.libraries.navigation.internal.abf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static Application a(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return ((Activity) context).getApplication();
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context.getApplicationContext() instanceof Application) {
            return (Application) context.getApplicationContext();
        }
        return null;
    }
}
