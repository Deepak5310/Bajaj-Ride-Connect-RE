package com.mappls.sdk.navigation.ui.navigation.alert;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutAlertViewBinding;
import com.mappls.sdk.navigation.ui.theme.a;
import com.mappls.sdk.navigation.ui.utils.d;
import com.mappls.sdk.plugin.directions.DirectionFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationEventAlertView extends LinearLayout {
    LayoutAlertViewBinding binding;

    public NavigationEventAlertView(Context context) {
        super(context);
        this.binding = LayoutAlertViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    public boolean isShowingEvent() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        toggleTheme();
        setVisibility(8);
    }

    public void toggleTheme() {
        this.binding.reportLayout.setBackgroundResource(a.a(getContext(), R.attr.navigationViewAlertViewBackground).resourceId);
        this.binding.textReportDistanceLeft.setBackgroundResource(a.a(getContext(), R.attr.navigationViewAlertViewDistanceBackground).resourceId);
        this.binding.textReportDistanceLeft.setTextColor(a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.textReportCategoryName.setTextColor(a.b(getContext(), R.attr.navigationTextColorPrimary));
    }

    public void updateRouteEvent(NavEvent navEvent) {
        if (navEvent == null || navEvent.getName() == null) {
            setVisibility(8);
            return;
        }
        if (navEvent.getDistanceLeft() <= 0.0d) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        this.binding.textReportDistanceLeft.setText(DirectionFormatter.getFormattedDistanceRound((float) navEvent.getDistanceLeft(), d.a()));
        this.binding.textReportCategoryName.setText(navEvent.getName());
        if (navEvent.getReportDetails() == null) {
            this.binding.reportIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_report_placeholder_24_px));
        } else {
            Glide.with(this).load(navEvent.getReportDetails().getReportIcon("54px")).placeholder(R.drawable.ic_report_placeholder_24_px).into(this.binding.reportIcon);
        }
    }

    public NavigationEventAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.binding = LayoutAlertViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    public NavigationEventAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = LayoutAlertViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
