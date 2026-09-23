package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.TermsAndConditionsCheckOption;
import com.google.android.libraries.navigation.TermsAndConditionsUIParams;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gi implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.xd.a a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.fu.a b;
    final /* synthetic */ NavigationApi.OnTermsResponseListener c;
    final /* synthetic */ TermsAndConditionsCheckOption d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ TermsAndConditionsUIParams g;
    final /* synthetic */ Activity h;
    final /* synthetic */ gk i;

    public gi(gk gkVar, com.google.android.libraries.navigation.internal.xd.a aVar, com.google.android.libraries.navigation.internal.fu.a aVar2, NavigationApi.OnTermsResponseListener onTermsResponseListener, TermsAndConditionsCheckOption termsAndConditionsCheckOption, String str, String str2, TermsAndConditionsUIParams termsAndConditionsUIParams, Activity activity) {
        this.a = aVar;
        this.b = aVar2;
        this.c = onTermsResponseListener;
        this.d = termsAndConditionsCheckOption;
        this.e = str;
        this.f = str2;
        this.g = termsAndConditionsUIParams;
        this.h = activity;
        this.i = gkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bb bbVar = (bb) this.i.a.get();
        if (bbVar != null && bbVar.isAdded()) {
            try {
                bbVar.dismiss();
            } catch (IllegalStateException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2006)).p("suppressing IllegalStateException in dialog.dismiss()");
                return;
            }
        }
        bb bbVarA = ba.a(this.a, new gj(this.i, this.b, this.c), this.d);
        this.i.a = new WeakReference(bbVarA);
        bbVarA.a = this.e;
        bbVarA.b = this.f;
        bbVarA.c = this.g;
        try {
            bbVarA.show(this.h.getFragmentManager(), "navigation-terms");
        } catch (IllegalStateException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2005)).p("suppressing IllegalStateException in dialog.show()");
        }
    }
}
