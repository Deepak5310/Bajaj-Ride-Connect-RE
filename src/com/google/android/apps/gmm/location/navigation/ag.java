package com.google.android.apps.gmm.location.navigation;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class ag extends ContentObserver {
    final /* synthetic */ Context a;
    final /* synthetic */ al b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(al alVar, Handler handler, Context context) {
        super(handler);
        this.a = context;
        this.b = alVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        onChange(z, null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        this.b.C = m.a(this.a);
    }
}
