package com.google.android.libraries.navigation.internal.aft;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements b {
    public static final az a;
    public static final az b;
    public static final az c;

    static {
        mb mbVar = mb.a;
        a = bh.d("CollectionBasisVerifierFeatures__enable_cbv_v2", false, "com.google.android.libraries.consentverifier", mbVar, true);
        b = bh.d("CollectionBasisVerifierFeatures__enable_google_signature_check", false, "com.google.android.libraries.consentverifier", mbVar, true);
        c = bh.d("CollectionBasisVerifierFeatures__enable_using_log_verifier_result", false, "com.google.android.libraries.consentverifier", mbVar, true);
    }

    @Override // com.google.android.libraries.navigation.internal.aft.b
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.aft.b
    public final boolean b() {
        return ((Boolean) b.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.aft.b
    public final boolean c() {
        return ((Boolean) c.a()).booleanValue();
    }
}
