package com.mappls.sdk.direction.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionRouteSummaryFragmentBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegAnnotation;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class RouteSummaryBottomSheetFragment extends BottomSheetDialogFragment {
    private static final String KEY_ROUTE_SUMMARY = "com.mappls.sdk.direction.ui.fragment.RouteSummaryBottomSheetFragment.KEY_ROUTE_SUMMARY";
    private static final String KEY_SELECTED_TRIP = "com.mappls.sdk.direction.ui.fragment.RouteSummaryBottomSheetFragment.KEY_SELECTED_TRIP";
    private g callback;
    private final DirectionOptions directionOptions;
    private DirectionsResponse directionsResponse;
    private MapplsDirectionRouteSummaryFragmentBinding mBinding;
    private RouteReportSummaryResponse routeReportSummaryResponse;
    private Integer selectedTrip;

    final class a implements f {
        a() {
        }

        @Override // com.mappls.sdk.direction.ui.fragment.f
        public final void a(String str, ArrayList<ReportDetails> arrayList) {
            if (RouteSummaryBottomSheetFragment.this.callback != null) {
                RouteSummaryBottomSheetFragment.this.callback.a(str, arrayList);
            }
            RouteSummaryBottomSheetFragment.this.dismiss();
        }
    }

    final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            if (RouteSummaryBottomSheetFragment.this.callback != null) {
                RouteSummaryBottomSheetFragment.this.callback.a(i);
            }
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RouteSummaryBottomSheetFragment.this.dismiss();
        }
    }

    public RouteSummaryBottomSheetFragment(RouteReportSummaryResponse routeReportSummaryResponse, Integer num, DirectionsResponse directionsResponse, DirectionOptions directionOptions) {
        this.routeReportSummaryResponse = routeReportSummaryResponse;
        this.selectedTrip = num;
        this.directionsResponse = directionsResponse;
        this.directionOptions = directionOptions;
    }

    private void setTheme() {
        this.mBinding.routeSummaryLayout.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_summary_background, R.drawable.mappls_direction_dr_bottom_sheet_background, requireContext()));
        this.mBinding.routeSummaryTitleTxt.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
        this.mBinding.imageViewClose.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_clear_stop, R.drawable.mappls_direction_clear_input_text_dark, requireContext()));
        this.mBinding.routeSummarySelectorLayout.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_summary_selector_background, ContextCompat.getColor(requireContext(), R.color.mappls_directions_white_smoke), requireContext()));
    }

    private void setUpTabIcons() {
        LegAnnotation legAnnotationAnnotation;
        double dDoubleValue;
        DistanceType distanceType;
        RouteReportSummaryResponse routeReportSummaryResponse = this.routeReportSummaryResponse;
        if (routeReportSummaryResponse == null || routeReportSummaryResponse.getRoutes() == null) {
            return;
        }
        new LinearLayout.LayoutParams(-1, -2).setMargins(0, 0, 0, 0);
        for (int i = 0; i < this.routeReportSummaryResponse.getRoutes().size(); i++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.mappls_direction_route_summary_tab_layout, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.route_summary_eta_textview);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.route_summary_distance);
            textView2.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(requireContext(), R.color.mappls_directions_colorTextPrimary), requireContext()));
            DirectionsResponse directionsResponse = this.directionsResponse;
            if (directionsResponse != null && directionsResponse.routes().size() > i) {
                DirectionsRoute directionsRoute = this.directionsResponse.routes().get(i);
                if (this.directionsResponse.routes().get(i).duration() != null) {
                    textView.setText(DirectionFormatter.getFormattedDuration(this.directionsResponse.routes().get(i).duration().doubleValue()));
                }
                if (this.directionsResponse.routes().get(i).distance() != null) {
                    DirectionOptions directionOptions = this.directionOptions;
                    if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
                        dDoubleValue = this.directionsResponse.routes().get(i).distance().doubleValue();
                        distanceType = DistanceType.METRIC;
                    } else {
                        dDoubleValue = this.directionsResponse.routes().get(i).distance().doubleValue();
                        distanceType = DistanceType.IMPERIAL;
                    }
                    textView2.setText(DirectionFormatter.getFormattedDistanceRound(dDoubleValue, distanceType));
                }
                textView.setTextColor((directionsRoute.legs() == null || directionsRoute.legs().size() <= 0 || (legAnnotationAnnotation = directionsRoute.legs().get(0).annotation()) == null) ? ContextCompat.getColor(requireContext(), R.color.mappls_direction_eta_text_color_with_out_traffic) : ContextCompat.getColor(requireContext(), com.mappls.sdk.direction.ui.common.e.a(legAnnotationAnnotation.congestion())));
            }
            if (this.mBinding.routeSummaryTabLayout.getTabAt(i) != null) {
                this.mBinding.routeSummaryTabLayout.getTabAt(i).setCustomView(viewInflate);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MapplsDirectionBottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MapplsDirectionRouteSummaryFragmentBinding mapplsDirectionRouteSummaryFragmentBinding = (MapplsDirectionRouteSummaryFragmentBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_direction_route_summary_fragment, viewGroup, true);
        this.mBinding = mapplsDirectionRouteSummaryFragmentBinding;
        return mapplsDirectionRouteSummaryFragmentBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTheme();
        com.mappls.sdk.direction.ui.adapters.f fVar = new com.mappls.sdk.direction.ui.adapters.f(getChildFragmentManager(), this.routeReportSummaryResponse.getRoutes());
        fVar.a(new a());
        this.mBinding.routeSummaryEventViewPager.setAdapter(fVar);
        MapplsDirectionRouteSummaryFragmentBinding mapplsDirectionRouteSummaryFragmentBinding = this.mBinding;
        mapplsDirectionRouteSummaryFragmentBinding.routeSummaryTabLayout.setupWithViewPager(mapplsDirectionRouteSummaryFragmentBinding.routeSummaryEventViewPager);
        if (this.routeReportSummaryResponse.getRoutes() != null || this.routeReportSummaryResponse.getRoutes().size() >= 2) {
            this.mBinding.routeSummaryTabLayout.setVisibility(0);
        } else {
            this.mBinding.routeSummaryTabLayout.setVisibility(8);
        }
        this.mBinding.routeSummaryEventViewPager.setCurrentItem(this.selectedTrip.intValue());
        this.mBinding.routeSummaryEventViewPager.setOffscreenPageLimit(0);
        setUpTabIcons();
        this.mBinding.routeSummaryEventViewPager.addOnPageChangeListener(new b());
        this.mBinding.imageViewClose.setOnClickListener(new c());
    }

    public void setRouteSummaryCallback(g gVar) {
        this.callback = gVar;
    }
}
