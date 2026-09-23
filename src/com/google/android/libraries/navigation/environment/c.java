package com.google.android.libraries.navigation.environment;

import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    com.google.android.libraries.navigation.internal.afp.a a;
    public final an b;

    public c(an anVar) {
        this.b = anVar;
        this.a = new com.google.android.libraries.navigation.internal.afp.a(ma.b, fd.k("com.google.android.libraries.geo.navcore.service.logging.ActivityRecognitionForLoggingBroadcastReceiver", ((m) anVar).al));
    }

    public final com.google.android.libraries.navigation.internal.ii.e a(Class cls) {
        return (com.google.android.libraries.navigation.internal.ii.e) cls.cast(this.b);
    }
}
