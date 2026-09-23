package com.google.android.libraries.navigation.internal.lh;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class b extends d {
    public final int a;
    public final Bundle b;
    final /* synthetic */ k c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected b(k kVar, int i, Bundle bundle) {
        super(kVar, true);
        this.c = kVar;
        this.a = i;
        this.b = bundle;
    }

    protected abstract void a(com.google.android.libraries.navigation.internal.lc.a aVar);

    @Override // com.google.android.libraries.navigation.internal.lh.d
    protected final void b() {
    }

    protected abstract boolean c();

    @Override // com.google.android.libraries.navigation.internal.lh.d
    protected final /* bridge */ /* synthetic */ void d() {
        if (this.a != 0) {
            this.c.H(1, null);
            Bundle bundle = this.b;
            a(new com.google.android.libraries.navigation.internal.lc.a(this.a, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        } else {
            if (c()) {
                return;
            }
            this.c.H(1, null);
            a(new com.google.android.libraries.navigation.internal.lc.a(8, null));
        }
    }
}
