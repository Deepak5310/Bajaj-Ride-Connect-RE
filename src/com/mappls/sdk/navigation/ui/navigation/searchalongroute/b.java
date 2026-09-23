package com.mappls.sdk.navigation.ui.navigation.searchalongroute;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SearchAlongRouteView a;

    public b(SearchAlongRouteView searchAlongRouteView) {
        this.a = searchAlongRouteView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.hide();
        SearchAlongRouteView searchAlongRouteView = this.a;
        c cVar = searchAlongRouteView.searchRouteCallback;
        if (cVar != null) {
            ((com.mappls.sdk.navigation.ui.navigation.a) cVar).b(searchAlongRouteView.eLocation);
        }
    }
}
