package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.TermsAndConditionsCheckOption;
import com.google.android.libraries.navigation.TermsAndConditionsUIParams;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gh implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ TermsAndConditionsCheckOption a;
    final /* synthetic */ Activity b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.xd.a c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.fu.a d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ TermsAndConditionsUIParams g;
    final /* synthetic */ NavigationApi.OnTermsResponseListener h;
    final /* synthetic */ gk i;

    public gh(gk gkVar, TermsAndConditionsCheckOption termsAndConditionsCheckOption, Activity activity, com.google.android.libraries.navigation.internal.xd.a aVar, com.google.android.libraries.navigation.internal.fu.a aVar2, String str, String str2, TermsAndConditionsUIParams termsAndConditionsUIParams, NavigationApi.OnTermsResponseListener onTermsResponseListener) {
        this.a = termsAndConditionsCheckOption;
        this.b = activity;
        this.c = aVar;
        this.d = aVar2;
        this.e = str;
        this.f = str2;
        this.g = termsAndConditionsUIParams;
        this.h = onTermsResponseListener;
        this.i = gkVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        this.i.b(this.b, this.c, this.d, this.e, this.f, this.g, this.h, TermsAndConditionsCheckOption.ENABLED);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.i.b(this.b, this.c, this.d, this.e, this.f, this.g, this.h, ((com.google.android.libraries.navigation.internal.xh.b) obj).b() ? this.a : TermsAndConditionsCheckOption.ENABLED);
    }
}
