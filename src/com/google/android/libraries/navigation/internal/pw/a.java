package com.google.android.libraries.navigation.internal.pw;

import android.content.Intent;
import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.libraries.navigation.internal.kp.c;
import com.google.android.libraries.navigation.internal.kp.d;
import com.google.android.libraries.navigation.internal.kp.f;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c implements d, com.google.android.libraries.navigation.internal.ic.a {
    private final Intent a;

    public a(String str) {
        this.a = new Intent().setAction("android.intent.action.VIEW").setData(Uri.parse(str));
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final f c() {
        return new f("intent").k("action", this.a.getAction()).k(ReactNativeBlobUtilConst.DATA_ENCODE_URI, this.a.getDataString()).l("synthetic", true);
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c, com.google.android.libraries.navigation.internal.kp.a
    public final String d() {
        return "intent";
    }

    @Override // com.google.android.libraries.navigation.internal.kp.d
    public final /* synthetic */ String f() {
        return null;
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.h();
        akVarB.g("action", this.a.getAction());
        akVarB.g(ReactNativeBlobUtilConst.DATA_ENCODE_URI, this.a.getDataString());
        akVarB.g("synthetic", true);
        return akVarB.toString();
    }
}
