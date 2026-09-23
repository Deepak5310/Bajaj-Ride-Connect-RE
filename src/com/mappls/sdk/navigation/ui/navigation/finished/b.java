package com.mappls.sdk.navigation.ui.navigation.finished;

import android.view.View;
import com.mappls.sdk.navigation.ui.navigation.j;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ NavigationFinishedView a;

    public b(NavigationFinishedView navigationFinishedView) {
        this.a = navigationFinishedView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar = this.a.callback;
        if (aVar != null) {
            ((j) aVar).a();
        }
    }
}
