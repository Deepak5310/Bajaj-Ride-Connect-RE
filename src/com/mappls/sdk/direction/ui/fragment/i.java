package com.mappls.sdk.direction.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionRouteSummaryAllEventFragmentBinding;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends Fragment {
    private final String a;
    private final ArrayList<ReportDetails> b;
    private MapplsDirectionRouteSummaryAllEventFragmentBinding c;

    final class a extends OnBackPressedCallback {
        a() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            i.this.getParentFragmentManager().popBackStack(i.this.getClass().getName(), 1);
        }
    }

    public i(String str, ArrayList<ReportDetails> arrayList) {
        this.a = str;
        this.b = arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MapplsDirectionRouteSummaryAllEventFragmentBinding mapplsDirectionRouteSummaryAllEventFragmentBinding = (MapplsDirectionRouteSummaryAllEventFragmentBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_route_summary_all_event_fragment, viewGroup, false);
        this.c = mapplsDirectionRouteSummaryAllEventFragmentBinding;
        return mapplsDirectionRouteSummaryAllEventFragmentBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.c.layoutSummaryCommonToolbar.toolbar.setTitle(this.a);
        this.c.layoutSummaryCommonToolbar.toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary));
        this.c.layoutSummaryCommonToolbar.toolbar.setNavigationOnClickListener(new j(this));
        this.c.layoutSummaryCommonToolbar.toolbar.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(requireContext(), R.color.mappls_direction_colorPrimary), requireContext()));
        this.c.layoutSummaryCommonToolbar.toolbar.setTitleTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.c.layoutSummaryCommonToolbar.toolbar.setNavigationIcon(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_back, R.drawable.mappls_direction_baseline_arrow_back_24, requireContext()));
        this.c.previewView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_toolbar_seperator, Color.parseColor("#eeeeee"), requireContext()));
        this.c.routeAllSummaryRecyclerView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_summary_events_background, ContextCompat.getColor(requireContext(), R.color.mappls_directions_white), requireContext()));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new a());
        this.c.routeAllSummaryRecyclerView.setHasFixedSize(true);
        this.c.routeAllSummaryRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.c.routeAllSummaryRecyclerView.setAdapter(new com.mappls.sdk.direction.ui.adapters.g(this.b));
    }
}
