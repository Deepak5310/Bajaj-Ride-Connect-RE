package com.mappls.sdk.navigation.ui.navigation.infobar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mappls.sdk.navigation.ui.NavigationOptions;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutBottomInfobarBinding;
import com.mappls.sdk.navigation.ui.model.CustomInfoBarItem;
import com.mappls.sdk.navigation.ui.navigation.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class InfobarBottomSheetView extends BaseInfobarBottomSheet implements LifecycleObserver {
    private c adapter;
    private final LayoutBottomInfobarBinding binding;
    private List<CustomInfoBarItem> customInfoBarItems;
    private boolean enableTraffic;
    private List<d> infoBarItems;
    private LifecycleOwner lifecycleOwner;
    private BottomSheetBehavior mBottomSheetBehavior;
    private q navigationViewModel;
    private m onInfobarCallback;

    public InfobarBottomSheetView(Context context) {
        this(context, null);
    }

    private SpannableString getColorSpannableString(String str, String str2, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str.length() > 0) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        if (str2.length() > 0) {
            SpannableString spannableString2 = new SpannableString(str2);
            spannableString2.setSpan(new ForegroundColorSpan(i2), 0, str2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
        }
        return SpannableString.valueOf(spannableStringBuilder);
    }

    private int getCongestionPercentage(List<String> list, int i) {
        if (list == null || list.isEmpty()) {
            return R.color.navigation_eta_text_color_with_out_traffic;
        }
        List<String> listSubList = (!list.isEmpty() && i < list.size()) ? list.subList(i, list.size()) : new ArrayList<>();
        int i2 = 0;
        for (int i3 = 0; i3 < listSubList.size(); i3++) {
            if (listSubList.get(i3).equals("heavy") || listSubList.get(i3).equals("moderate") || listSubList.get(i3).equals("severe")) {
                i2++;
            }
        }
        int size = !listSubList.isEmpty() ? (i2 * 100) / listSubList.size() : 1;
        if (size <= 10) {
            return R.color.navigation_eta_text_color_with_out_traffic;
        }
        return size <= 25 ? R.color.navigation_eta_text_color_with_low_traffic : R.color.navigation_eta_text_color_with_traffic;
    }

    private void initialiseItem() {
        c cVar = this.adapter;
        cVar.a = this.infoBarItems;
        cVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(l lVar) {
        int leftDistance;
        this.binding.textViewTotalDistanceLeft.setText(lVar.b);
        this.binding.textViewTotalTimeLeft.setText(lVar.d);
        this.binding.textViewReachEta.setText(lVar.c);
        this.binding.textViewTotalTimeLeft.setTextColor(ContextCompat.getColor(getContext(), getCongestionPercentage(lVar.e, lVar.f)));
        try {
            leftDistance = (int) (100.0d - (((double) (lVar.a.getLeftDistance() * 100)) / lVar.g));
        } catch (Exception e) {
            e.printStackTrace();
            leftDistance = 0;
        }
        updateProgress(leftDistance);
        this.binding.remainingDistanceTextView.setText(lVar.b + " to go");
        setTextColor();
    }

    private void setTextColor() {
        String string = this.binding.remainingDistanceTextView.getText().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.binding.remainingDistanceTextView.setText(getColorSpannableString(string.split("to go")[0], "to go", com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewDistanceValue), com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewDistanceText)));
    }

    private void updateProgress(int i) {
        this.binding.navProgress.setProgress(i);
    }

    public void isTrafficEnable(boolean z) {
        this.enableTraffic = z;
        for (d dVar : this.infoBarItems) {
            if (dVar.a == "mappls_navigation_ui_trafffic") {
                if (z) {
                    dVar.b = "Hide Traffic";
                    dVar.c = R.attr.navigationViewTrafficOffDrawable;
                } else {
                    dVar.b = "Show Traffic";
                    dVar.c = R.attr.navigationViewTrafficOnDrawable;
                }
            }
        }
        c cVar = this.adapter;
        cVar.a = this.infoBarItems;
        cVar.notifyDataSetChanged();
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.infobar.BaseInfobarBottomSheet, androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getResources().getConfiguration().orientation == 2) {
            this.binding.rvBottomItem.setLayoutManager(new GridLayoutManager(getContext(), 4));
        } else {
            this.binding.rvBottomItem.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        this.binding.rvBottomItem.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.binding.rvBottomItem.setAdapter(this.adapter);
        initialiseItem();
        this.adapter.b = new e(this);
        toogleTheme();
        setClickable(false);
        setFocusableInTouchMode(false);
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.binding.optionsRecyclerViewContainer);
        this.mBottomSheetBehavior = bottomSheetBehaviorFrom;
        bottomSheetBehaviorFrom.setHideable(false);
        this.mBottomSheetBehavior.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.navigation_bottom_sheet_top_shadow) + getResources().getDimensionPixelSize(R.dimen.navigation_bottom_sheet_header) + 1);
        this.mBottomSheetBehavior.setState(4);
        this.mBottomSheetBehavior.addBottomSheetCallback(new f(this));
        this.binding.ivBottomSheetArrow.setOnClickListener(new g(this));
        this.binding.imageRouteOverview.setOnClickListener(new h(this));
        this.binding.stopNavigation.setOnClickListener(new i(this));
    }

    public void setCustomInfoBarItem(List<CustomInfoBarItem> list) {
        System.out.println("setCustomInfoBarItem::  " + list.size());
        this.infoBarItems.clear();
        this.customInfoBarItems.clear();
        this.customInfoBarItems.addAll(list);
        q qVar = this.navigationViewModel;
        if (qVar != null) {
            updateOptions(qVar.d);
            for (CustomInfoBarItem customInfoBarItem : this.customInfoBarItems) {
                this.infoBarItems.add(new d(customInfoBarItem.getId(), customInfoBarItem.getText(), customInfoBarItem.getIconAttr()));
            }
            c cVar = this.adapter;
            cVar.a = this.infoBarItems;
            cVar.notifyDataSetChanged();
        }
    }

    public void setOnInfobarCallback(m mVar) {
        this.onInfobarCallback = mVar;
    }

    public void showRouteOverview(boolean z) {
        this.binding.imageRouteOverview.setVisibility(z ? 0 : 8);
    }

    public void subscribe(LifecycleOwner lifecycleOwner, q qVar) {
        this.lifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this);
        this.navigationViewModel = qVar;
        if (this.customInfoBarItems != null) {
            this.infoBarItems.clear();
            updateOptions(qVar.d);
            for (CustomInfoBarItem customInfoBarItem : this.customInfoBarItems) {
                this.infoBarItems.add(new d(customInfoBarItem.getId(), customInfoBarItem.getText(), customInfoBarItem.getIconAttr()));
            }
            c cVar = this.adapter;
            cVar.a = this.infoBarItems;
            cVar.notifyDataSetChanged();
        }
        qVar.c.observe(this.lifecycleOwner, new j(this));
        qVar.a.observe(this.lifecycleOwner, new k(this));
    }

    public void toogleTheme() {
        getContext();
        if (com.mappls.sdk.navigation.ui.theme.a.a()) {
            this.binding.topSeparatorViewNightMode.setVisibility(0);
            this.binding.topSeparatorViewDayMode.setVisibility(8);
        } else {
            this.binding.topSeparatorViewNightMode.setVisibility(8);
            this.binding.topSeparatorViewDayMode.setVisibility(0);
        }
        this.binding.verticalSeperatorView.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewBottomSheetVerticalSeperator));
        this.binding.cardView.setCardBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.textViewTotalDistanceLeft.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorSecondary));
        this.binding.textViewReachEta.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorSecondary));
        ImageView imageView = this.binding.ivBottomSheetArrow;
        Context context = getContext();
        imageView.setImageDrawable(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewBottomSheetArrow).resourceId));
        ImageView imageView2 = this.binding.imageRouteOverview;
        Context context2 = getContext();
        imageView2.setImageDrawable(AppCompatResources.getDrawable(context2, com.mappls.sdk.navigation.ui.theme.a.a(context2, R.attr.navigationViewRouteOverviewDrawable).resourceId));
        ImageView imageView3 = this.binding.stopNavigation;
        Context context3 = getContext();
        imageView3.setImageDrawable(AppCompatResources.getDrawable(context3, com.mappls.sdk.navigation.ui.theme.a.a(context3, R.attr.navigationViewStopDrawable).resourceId));
        this.binding.optionsRecyclerViewContainer.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.destinationText.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorSecondary));
        this.binding.carSpeedLightImageview.setImageResource(com.mappls.sdk.navigation.ui.theme.a.a(getContext(), R.attr.navigationViewCarSpeedDrawable).resourceId);
        this.binding.navDestinationImageview.setImageResource(com.mappls.sdk.navigation.ui.theme.a.a(getContext(), R.attr.navigationViewDestinationDrawable).resourceId);
        this.binding.navProgress.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewDistanceProgress), PorterDuff.Mode.SRC_IN));
        for (d dVar : this.infoBarItems) {
            if (dVar.a == "mappls_navigation_ui_day_night_mode") {
                getContext();
                dVar.b = com.mappls.sdk.navigation.ui.theme.a.a() ? "Day Theme" : "Night Theme";
            }
        }
        c cVar = this.adapter;
        cVar.a = this.infoBarItems;
        cVar.notifyDataSetChanged();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void unsubscribe() {
        q qVar = this.navigationViewModel;
        if (qVar != null) {
            qVar.a.removeObservers(this.lifecycleOwner);
        }
    }

    public void updateOptions(NavigationOptions navigationOptions) {
        this.infoBarItems.clear();
        if (navigationOptions != null) {
            if (navigationOptions.showDayNightOption().booleanValue()) {
                List<d> list = this.infoBarItems;
                getContext();
                list.add(new d("mappls_navigation_ui_day_night_mode", com.mappls.sdk.navigation.ui.theme.a.a() ? "Day Theme" : "Night Theme", R.attr.navigationDayNightThemeDrawable));
            }
            this.infoBarItems.add(new d("mappls_navigation_ui_direction_list", getResources().getString(R.string.direction_list), R.attr.navigationDirectionListDrawable));
            if (navigationOptions.showTrafficOption().booleanValue()) {
                this.infoBarItems.add(new d("mappls_navigation_ui_trafffic", this.enableTraffic ? "Show Traffic" : "Hide Traffic", R.attr.navigationViewTrafficOnDrawable));
            }
            if (navigationOptions.showNavigationSettingsOption().booleanValue()) {
                this.infoBarItems.add(new d("mappls_navigation_ui_setting", getResources().getString(R.string.settings), R.attr.navigationViewSettingsDrawable));
            }
            if (this.binding.rvBottomItem.getAdapter() != null) {
                c cVar = this.adapter;
                cVar.a = this.infoBarItems;
                cVar.notifyDataSetChanged();
            }
        }
    }

    public InfobarBottomSheetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetInfoBarStyle);
    }

    public InfobarBottomSheetView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.BottomSheetInfobarStyle);
    }

    public InfobarBottomSheetView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.binding = LayoutBottomInfobarBinding.inflate(LayoutInflater.from(getContext()), this, true);
        this.adapter = new c();
        this.infoBarItems = new ArrayList();
        this.enableTraffic = false;
        this.customInfoBarItems = new ArrayList();
    }
}
