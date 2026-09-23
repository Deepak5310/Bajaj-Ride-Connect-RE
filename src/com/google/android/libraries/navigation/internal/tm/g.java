package com.google.android.libraries.navigation.internal.tm;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.hf.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    private final n a;
    private final com.google.android.libraries.navigation.internal.vz.a b;

    public g(Application application, com.google.android.libraries.navigation.internal.vz.a aVar) {
        this.a = new n(application.getResources());
        this.b = aVar;
    }

    public final i a(com.google.android.libraries.navigation.internal.tj.h hVar) {
        String str = hVar.b;
        if (!TextUtils.isEmpty(str)) {
            return i.e(str, null);
        }
        com.google.android.libraries.navigation.internal.vz.a aVar = this.b;
        String str2 = aVar.c;
        Intent intent = aVar.b;
        ComponentName component = intent != null ? intent.getComponent() : null;
        return str2 != null ? i.e(str2, component) : i.e(this.a.e(com.google.android.libraries.navigation.internal.dw.h.Q).b(), component);
    }
}
