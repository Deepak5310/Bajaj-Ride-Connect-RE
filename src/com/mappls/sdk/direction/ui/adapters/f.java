package com.mappls.sdk.direction.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.services.api.event.route.model.RouteReport;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends FragmentPagerAdapter {
    private final List<RouteReport> a;
    private com.mappls.sdk.direction.ui.fragment.f b;

    final class a implements com.mappls.sdk.direction.ui.fragment.k.b {
        a() {
        }

        @Override // com.mappls.sdk.direction.ui.fragment.k.b
        public final void a(String str, ArrayList<ReportDetails> arrayList) {
            if (f.this.b != null) {
                f.this.b.a(str, arrayList);
            }
        }
    }

    public f(FragmentManager fragmentManager, List<RouteReport> list) {
        super(fragmentManager);
        this.a = list;
    }

    public final void a(com.mappls.sdk.direction.ui.fragment.f fVar) {
        this.b = fVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<RouteReport> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment getItem(int i) {
        com.mappls.sdk.direction.ui.fragment.k kVar = new com.mappls.sdk.direction.ui.fragment.k(this.a.get(i));
        kVar.a(new a());
        return kVar;
    }
}
