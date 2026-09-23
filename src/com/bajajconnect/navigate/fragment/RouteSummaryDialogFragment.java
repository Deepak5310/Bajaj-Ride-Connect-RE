package com.bajajconnect.navigate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bajajconnect.R;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.NavigationFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class RouteSummaryDialogFragment extends DialogFragment {
    private TextView tvAverageSpeed;
    private TextView tvTimeTaken;
    private TextView tvTotalDistance;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.routeSummaryDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(1);
            getDialog().getWindow().setLayout(-2, -2);
        }
        return layoutInflater.inflate(R.layout.fragment_route_summary, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(false);
        this.tvTotalDistance = (TextView) view.findViewById(R.id.tv_total_distance);
        this.tvTimeTaken = (TextView) view.findViewById(R.id.tv_total_time_taken);
        this.tvAverageSpeed = (TextView) view.findViewById(R.id.tv_avg_speed);
        this.tvTotalDistance.setText(NavigationFormatter.getFormattedDistance(MapplsNavigationHelper.getInstance().getNavigationSummary().getTotalDistance(), (NavigationApplication) requireActivity().getApplication()));
        this.tvTimeTaken.setText(NavigationFormatter.getFormattedDuration((int) MapplsNavigationHelper.getInstance().getNavigationSummary().getTotalTimeTaken(), (NavigationApplication) requireActivity().getApplication()));
        this.tvAverageSpeed.setText(NavigationFormatter.getFormattedSpeed(MapplsNavigationHelper.getInstance().getNavigationSummary().getAverageSpeed(), (NavigationApplication) requireActivity().getApplication()));
        view.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.RouteSummaryDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RouteSummaryDialogFragment.this.requireActivity().finish();
            }
        });
    }
}
