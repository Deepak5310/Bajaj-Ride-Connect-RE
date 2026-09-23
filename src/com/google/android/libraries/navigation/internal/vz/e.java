package com.google.android.libraries.navigation.internal.vz;

import android.app.Application;
import android.app.NotificationManager;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements br {
    final /* synthetic */ Application a;

    public e(Application application) {
        this.a = application;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        return (NotificationManager) this.a.getSystemService("notification");
    }
}
