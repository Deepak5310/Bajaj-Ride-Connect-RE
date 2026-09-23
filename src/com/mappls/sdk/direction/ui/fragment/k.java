package com.mappls.sdk.direction.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionRouteEventFragmentBinding;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.services.api.event.route.model.RouteReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class k extends Fragment {
    private MapplsDirectionRouteEventFragmentBinding a;
    private RouteReport b;
    private b c;

    final class a implements com.mappls.sdk.direction.ui.adapters.e.b {
        a() {
        }

        @Override // com.mappls.sdk.direction.ui.adapters.e.b
        public final void a(String str, ArrayList<ReportDetails> arrayList) {
            if (k.this.c != null) {
                k.this.c.a(str, arrayList);
            }
        }
    }

    public interface b {
        void a(String str, ArrayList<ReportDetails> arrayList);
    }

    public k(RouteReport routeReport) {
        this.b = routeReport;
    }

    public final void a(b bVar) {
        this.c = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MapplsDirectionRouteEventFragmentBinding mapplsDirectionRouteEventFragmentBinding = (MapplsDirectionRouteEventFragmentBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_route_event_fragment, viewGroup, false);
        this.a = mapplsDirectionRouteEventFragmentBinding;
        return mapplsDirectionRouteEventFragmentBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ArrayList arrayList = new ArrayList();
        RouteReport routeReport = this.b;
        if (routeReport != null && routeReport.getReports() != null) {
            HashMap map = new HashMap();
            for (ReportDetails reportDetails : this.b.getReports()) {
                String parentCategory = reportDetails.getParentCategory();
                if (map.containsKey(parentCategory)) {
                    ArrayList arrayList2 = (ArrayList) map.get(parentCategory);
                    if (arrayList2 != null) {
                        arrayList2.add(reportDetails);
                    }
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(reportDetails);
                    map.put(parentCategory, arrayList3);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                ArrayList arrayList4 = (ArrayList) entry.getValue();
                if (arrayList4.size() > 2) {
                    arrayList.add(new com.mappls.sdk.direction.ui.event.c(str, arrayList4, ((ReportDetails) arrayList4.get(0)).getParentReportIcon("48px"), arrayList4.size(), true));
                    arrayList.add(new com.mappls.sdk.direction.ui.event.b((ReportDetails) arrayList4.get(0)));
                    arrayList.add(new com.mappls.sdk.direction.ui.event.b((ReportDetails) arrayList4.get(1)));
                } else {
                    arrayList.add(new com.mappls.sdk.direction.ui.event.c(str, arrayList4, ((ReportDetails) arrayList4.get(0)).getParentReportIcon("48px"), arrayList4.size(), false));
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new com.mappls.sdk.direction.ui.event.b((ReportDetails) it2.next()));
                    }
                }
            }
        }
        com.mappls.sdk.direction.ui.adapters.e eVar = new com.mappls.sdk.direction.ui.adapters.e(arrayList);
        eVar.a(new a());
        this.a.routeEventRecyclerView.setHasFixedSize(true);
        this.a.routeEventRecyclerView.setAdapter(eVar);
        this.a.routeEventRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
