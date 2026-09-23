package com.mappls.sdk.navigation.ui.navigation.searchalongroute;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.mappls.sdk.navigation.ui.databinding.LayoutSearchLongRouteBinding;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;

/* JADX INFO: loaded from: classes4.dex */
public class SearchAlongRouteView extends CoordinatorLayout {
    LayoutSearchLongRouteBinding binding;
    private ELocation eLocation;
    private c searchRouteCallback;

    public SearchAlongRouteView(Context context) {
        this(context, null);
    }

    public void hide() {
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hide();
        this.binding.startNewRouteTextView.setOnClickListener(new a(this));
        this.binding.addWayPointTextView.setOnClickListener(new b(this));
    }

    public void setRouteDetail(ELocation eLocation) {
        this.eLocation = eLocation;
        this.binding.tvPlaceTitle.setText(eLocation.placeName);
        this.binding.addressTextView.setText(eLocation.placeAddress);
    }

    public void setSearchRouteCallback(c cVar) {
        this.searchRouteCallback = cVar;
    }

    public void show() {
        setVisibility(0);
    }

    public SearchAlongRouteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SearchAlongRouteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = LayoutSearchLongRouteBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
