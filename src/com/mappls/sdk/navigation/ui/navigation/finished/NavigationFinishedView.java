package com.mappls.sdk.navigation.ui.navigation.finished;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutNavigationFinishedBinding;
import com.mappls.sdk.navigation.ui.navigation.MapplsNavigationViewHelper;
import com.mappls.sdk.navigation.util.NavigationSummaryHelper;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationFinishedView extends CoordinatorLayout {
    LayoutNavigationFinishedBinding binding;
    private a callback;
    private BottomSheetBehavior mBottomSheetBehavior;

    public NavigationFinishedView(Context context) {
        super(context);
        this.binding = LayoutNavigationFinishedBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    public void hide() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(5);
        }
    }

    public boolean isVisible() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        return bottomSheetBehavior != null && bottomSheetBehavior.getState() == 3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setClickable(false);
        setFocusableInTouchMode(false);
        toggleTheme();
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.binding.navigationFinishedLayout);
        this.mBottomSheetBehavior = bottomSheetBehaviorFrom;
        bottomSheetBehaviorFrom.setHideable(true);
        this.mBottomSheetBehavior.setSkipCollapsed(true);
        this.mBottomSheetBehavior.setPeekHeight(0);
        this.mBottomSheetBehavior.setState(5);
        ELocation destination = MapplsNavigationViewHelper.getInstance().getDestination();
        if (destination != null) {
            this.binding.destinationTextView.setText(destination.placeName + ", " + destination.placeAddress);
        } else {
            this.binding.destinationTextView.setText("End Stop");
        }
        this.binding.tripStatsRecyclerView.addItemDecoration(new com.mappls.sdk.navigation.ui.common.b());
        this.binding.finishedButton.setOnClickListener(new b(this));
        this.binding.knowMoreButton.setOnClickListener(new c(this));
    }

    public void refreshNavigationFinished() {
        ArrayList arrayList = new ArrayList();
        if (getContext() != null) {
            arrayList.add(new f("duration", "Duration", DirectionFormatter.getFormattedDuration(NavigationSummaryHelper.getInstance().getTotalTimeTaken())));
            arrayList.add(new f(DirectionsCriteria.ANNOTATION_DISTANCE, "Distance Elapsed", DirectionFormatter.getFormattedDistanceRound(NavigationSummaryHelper.getInstance().getTotalDistance(), com.mappls.sdk.navigation.ui.utils.d.a())));
            arrayList.add(new f("avg_speed", "Average Speed", NavigationFormatter.getFormattedSpeed(NavigationSummaryHelper.getInstance().getAverageSpeed() > 0.0f ? NavigationSummaryHelper.getInstance().getAverageSpeed() : 0.0f, getContext())));
        }
        this.binding.tripStatsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.binding.tripStatsRecyclerView.setAdapter(new e(arrayList));
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void show() {
        refreshNavigationFinished();
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public void toggleTheme() {
        this.binding.navFinishedHeaderText.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        ImageButton imageButton = this.binding.finishedButton;
        Context context = getContext();
        imageButton.setImageDrawable(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationFinishedCloseButton).resourceId));
        this.binding.navigationFinishedContainerLayout.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.containerDestinationHeader.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationFinishedDestinationHeaderBackground));
        this.binding.containerDestinationReached.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
    }

    public NavigationFinishedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.binding = LayoutNavigationFinishedBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    public NavigationFinishedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = LayoutNavigationFinishedBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
