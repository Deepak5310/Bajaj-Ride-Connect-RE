package com.mappls.sdk.navigation.ui.navigation.directions;

import android.view.View;
import com.mappls.sdk.navigation.routing.NavigationStep;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ NavigationStep a;
    public final /* synthetic */ e b;

    public a(e eVar, NavigationStep navigationStep) {
        this.b = eVar;
        this.a = navigationStep;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h hVar = this.b.b;
        if (hVar != null) {
            ((com.mappls.sdk.navigation.ui.navigation.b) hVar).a(this.a);
        }
    }
}
