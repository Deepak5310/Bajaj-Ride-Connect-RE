package com.google.android.apps.gmm.base.views.viewpager;

import android.database.DataSetObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class i extends DataSetObserver {
    private final WeakReference a;

    public i(GmmViewPager gmmViewPager) {
        this.a = new WeakReference(gmmViewPager);
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        GmmViewPager.a aVar;
        GmmViewPager gmmViewPager = (GmmViewPager) this.a.get();
        if (gmmViewPager == null || (aVar = gmmViewPager.e) == null) {
            return;
        }
        gmmViewPager.d = false;
        aVar.b(2);
        gmmViewPager.d = true;
    }
}
