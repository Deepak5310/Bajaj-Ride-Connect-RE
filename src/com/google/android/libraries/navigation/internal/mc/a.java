package com.google.android.libraries.navigation.internal.mc;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.ld.i;
import com.google.android.libraries.navigation.internal.ld.q;
import com.google.android.libraries.navigation.internal.ld.r;
import com.google.android.libraries.navigation.internal.lh.p;
import com.google.android.libraries.navigation.internal.md.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends com.google.android.libraries.navigation.internal.ld.a {
    @Override // com.google.android.libraries.navigation.internal.ld.a
    public final /* bridge */ /* synthetic */ i a(Context context, Looper looper, p pVar, Object obj, q qVar, r rVar) {
        f fVar = pVar.f;
        Integer num = pVar.g;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", pVar.a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return new j(context, looper, true, pVar, bundle, qVar, rVar);
    }
}
