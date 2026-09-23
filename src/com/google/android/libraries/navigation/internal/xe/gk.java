package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.TermsAndConditionsCheckOption;
import com.google.android.libraries.navigation.TermsAndConditionsUIParams;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gk {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xe.gk");
    public WeakReference a = new WeakReference(null);
    public final ba b;
    private final Executor d;

    public gk(ba baVar, Executor executor) {
        com.google.android.libraries.navigation.internal.yx.ar.q(baVar);
        this.b = baVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        this.d = executor;
    }

    public final void a(Activity activity, com.google.android.libraries.navigation.internal.xd.a aVar, com.google.android.libraries.navigation.internal.fu.a aVar2, com.google.android.libraries.navigation.internal.xh.c cVar, String str, String str2, TermsAndConditionsUIParams termsAndConditionsUIParams, NavigationApi.OnTermsResponseListener onTermsResponseListener, TermsAndConditionsCheckOption termsAndConditionsCheckOption) {
        com.google.android.libraries.navigation.internal.aac.az.o(cVar.b(), new gh(this, termsAndConditionsCheckOption, activity, aVar, aVar2, str, str2, termsAndConditionsUIParams, onTermsResponseListener), this.d);
    }

    public final void b(Activity activity, com.google.android.libraries.navigation.internal.xd.a aVar, com.google.android.libraries.navigation.internal.fu.a aVar2, String str, String str2, TermsAndConditionsUIParams termsAndConditionsUIParams, NavigationApi.OnTermsResponseListener onTermsResponseListener, TermsAndConditionsCheckOption termsAndConditionsCheckOption) {
        this.d.execute(new gi(this, aVar, aVar2, onTermsResponseListener, termsAndConditionsCheckOption, str, str2, termsAndConditionsUIParams, activity));
    }
}
