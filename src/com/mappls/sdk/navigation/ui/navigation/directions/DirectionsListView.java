package com.mappls.sdk.navigation.ui.navigation.directions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutDirectionListBinding;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DirectionsListView extends CoordinatorLayout {
    private e adapter;
    LayoutDirectionListBinding binding;
    private BottomSheetBehavior mBottomSheetBehavior;
    private h onDirectionClick;

    public DirectionsListView(Context context) {
        this(context, null);
    }

    public void hide() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(5);
        }
    }

    public void init() {
        e eVar = new e();
        this.adapter = eVar;
        this.binding.rvDirectionList.setAdapter(eVar);
        this.binding.rvDirectionList.setLayoutManager(new LinearLayoutManager(getContext()));
        e eVar2 = this.adapter;
        eVar2.a = MapplsNavigationHelper.getInstance().getNavigationSteps();
        eVar2.notifyDataSetChanged();
        h hVar = this.onDirectionClick;
        if (hVar != null) {
            this.adapter.b = hVar;
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
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.binding.directionListView);
        this.mBottomSheetBehavior = bottomSheetBehaviorFrom;
        bottomSheetBehaviorFrom.setHideable(true);
        this.mBottomSheetBehavior.setSkipCollapsed(true);
        this.mBottomSheetBehavior.setPeekHeight(0);
        this.mBottomSheetBehavior.setState(5);
        this.binding.closeBottomSheet.setOnClickListener(new f(this));
        this.binding.btnShowMap.setOnClickListener(new g(this));
    }

    public boolean onBackPress() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 3) {
            return false;
        }
        this.mBottomSheetBehavior.setState(5);
        return true;
    }

    public void onNewRoute() {
        List navigationSteps = MapplsNavigationHelper.getInstance().getNavigationSteps();
        if (this.adapter == null) {
            e eVar = new e();
            this.adapter = eVar;
            this.binding.rvDirectionList.setAdapter(eVar);
            this.binding.rvDirectionList.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        e eVar2 = this.adapter;
        eVar2.a = navigationSteps;
        eVar2.notifyDataSetChanged();
    }

    public void setOnDirectionClick(h hVar) {
        this.onDirectionClick = hVar;
        e eVar = this.adapter;
        if (eVar != null) {
            eVar.b = hVar;
        }
    }

    public void show() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public void toggleTheme() {
        e eVar = this.adapter;
        if (eVar != null) {
            eVar.a = MapplsNavigationHelper.getInstance().getNavigationSteps();
            eVar.notifyDataSetChanged();
        }
        this.binding.directionListView.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.toolbarDirection.setCardBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.toolbarText.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        ImageView imageView = this.binding.closeBottomSheet;
        Context context = getContext();
        imageView.setImageDrawable(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewBackButtonDrawable).resourceId));
        this.binding.btnShowMap.setBackgroundResource(com.mappls.sdk.navigation.ui.theme.a.a(getContext(), R.attr.navigationViewShowMapDrawable).resourceId);
    }

    public DirectionsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DirectionsListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = LayoutDirectionListBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
