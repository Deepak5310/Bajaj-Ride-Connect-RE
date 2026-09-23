package com.google.android.libraries.navigation.internal.lh;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends w {
    final /* synthetic */ Intent a;
    final /* synthetic */ Activity b;

    public v(Intent intent, Activity activity) {
        this.a = intent;
        this.b = activity;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.w
    public final void a() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, 2);
        }
    }
}
