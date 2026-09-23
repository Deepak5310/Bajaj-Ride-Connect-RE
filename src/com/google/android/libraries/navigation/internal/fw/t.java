package com.google.android.libraries.navigation.internal.fw;

import app.notifee.core.event.LogEvent;
import com.google.android.libraries.navigation.internal.ael.cy;
import org.joda.time.DateTime;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.kp.d {
    private final String a = "com.google.android.apps.gmm.location.navigation.InertialState";
    private final String b;
    private final long c;
    private final boolean d;

    public t(String str, cy cyVar, boolean z) {
        cyVar.m();
        DateTime dateTimeNow = DateTime.now();
        this.b = dateTimeNow.toString("yyyy-MM-dd HH:mm:ss");
        this.c = dateTimeNow.getMillis();
        this.d = true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("logged-proto");
        fVar.m("messageName", this.a);
        com.google.android.libraries.navigation.internal.kp.f fVarL = fVar.k("localTime", this.b).g("time", this.c).l(LogEvent.LEVEL_DEBUG, true);
        fVarL.k("protoMissingReason", "Not logged.");
        return fVarL;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c, com.google.android.libraries.navigation.internal.kp.a
    public final String d() {
        return "logged-proto";
    }

    @Override // com.google.android.libraries.navigation.internal.kp.d
    public final String f() {
        return this.a.concat("-debug");
    }
}
