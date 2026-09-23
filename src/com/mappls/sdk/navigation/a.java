package com.mappls.sdk.navigation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.mappls.sdk.navigation.apis.NavigationLogger;

/* JADX INFO: loaded from: classes4.dex */
final class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ ProgressDialog c;
    final /* synthetic */ Runnable d = null;

    a(String str, Context context, ProgressDialog progressDialog) {
        this.a = str;
        this.b = context;
        this.c = progressDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        try {
            if (NavigationContext.getNavigationContext().f705n != null) {
                NavigationContext.getNavigationContext().f705n.h();
            }
            NavigationContext navigationContext = NavigationContext.getNavigationContext();
            String str = this.a;
            navigationContext.f705n = str != null ? new com.mappls.sdk.navigation.voice.e(this.b, NavigationContext.getNavigationContext().l.o(), str) : null;
            com.mappls.sdk.navigation.routing.h hVarO = NavigationContext.getNavigationContext().l.o();
            com.mappls.sdk.navigation.voice.e eVar = NavigationContext.getNavigationContext().f705n;
            hVarO.getClass();
            com.mappls.sdk.navigation.routing.h.a(eVar);
            ProgressDialog progressDialog = this.c;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Runnable runnable = this.d;
            if (runnable == null || (context = this.b) == null || !(context instanceof Activity)) {
                return;
            }
            ((Activity) context).runOnUiThread(runnable);
        } catch (com.mappls.sdk.navigation.voice.d e) {
            ProgressDialog progressDialog2 = this.c;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            NavigationContext.getNavigationContext().q();
            NavigationLogger.d(e);
        }
    }
}
