package com.google.android.libraries.navigation.internal.ig;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class b {
    public static c a(Context context) {
        Context applicationContext = context.getApplicationContext();
        Object systemService = applicationContext.getSystemService(c.a);
        if (systemService == null) {
            systemService = new a(applicationContext);
        }
        return (c) systemService;
    }
}
