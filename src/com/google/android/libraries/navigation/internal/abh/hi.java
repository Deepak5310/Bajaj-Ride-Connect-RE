package com.google.android.libraries.navigation.internal.abh;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hi {
    private final Context a;

    public hi(Context context) {
        com.google.android.libraries.navigation.internal.abf.s.k(context, "context");
        this.a = context;
    }

    public final void a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            this.a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            com.google.android.libraries.navigation.internal.abf.p.d("Could not start activty.", e);
        }
    }
}
