package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.navigation.alert.NavigationEventAlertView;
import com.mappls.sdk.navigation.ui.navigation.directions.DirectionsListView;
import com.mappls.sdk.navigation.ui.navigation.finished.NavigationFinishedView;
import com.mappls.sdk.navigation.ui.navigation.infobar.InfobarBottomSheetView;
import com.mappls.sdk.navigation.ui.navigation.instructioncontainer.InstructionContainerView;
import com.mappls.sdk.navigation.ui.navigation.instructioncontainer.InstructionContainrPIPView;
import com.mappls.sdk.navigation.ui.navigation.nextinstruction.NextInstructionView;
import com.mappls.sdk.navigation.ui.navigation.recenter.RecenterButton;
import com.mappls.sdk.navigation.ui.navigation.searchalongroute.SearchAlongRouteView;
import com.mappls.sdk.navigation.ui.navigation.settings.SettingView;
import com.mappls.sdk.navigation.ui.navigation.sound.SoundControllerView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutNavigationViewBinding extends ViewDataBinding {
    public final NavigationEventAlertView alertView;
    public final ConstraintLayout constraintLayout2;
    public final DirectionsListView directionList;
    public final TextView eventsText;
    public final RecenterButton followButton;
    public final InfobarBottomSheetView infobarView;
    public final InstructionContainerView instructionContainer;
    public final InstructionContainrPIPView instructionContainerPip;
    public final FrameLayout mapLayout;
    public final NavigationFinishedView navigationFinishedView;
    public final NextInstructionView nextAdviseView;
    public final FloatingActionButton resetBoundsButton;
    public final ImageView searchAlongRoute;
    public final SearchAlongRouteView searchAlongRouteView;
    public final SettingView settingsView;
    public final SoundControllerView soundView;
    public final TextView speedWarningButton;
    public final TextView tvSpeed;
    public final TextView warningTextView;

    protected LayoutNavigationViewBinding(Object obj, View view, int i, NavigationEventAlertView navigationEventAlertView, ConstraintLayout constraintLayout, DirectionsListView directionsListView, TextView textView, RecenterButton recenterButton, InfobarBottomSheetView infobarBottomSheetView, InstructionContainerView instructionContainerView, InstructionContainrPIPView instructionContainrPIPView, FrameLayout frameLayout, NavigationFinishedView navigationFinishedView, NextInstructionView nextInstructionView, FloatingActionButton floatingActionButton, ImageView imageView, SearchAlongRouteView searchAlongRouteView, SettingView settingView, SoundControllerView soundControllerView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.alertView = navigationEventAlertView;
        this.constraintLayout2 = constraintLayout;
        this.directionList = directionsListView;
        this.eventsText = textView;
        this.followButton = recenterButton;
        this.infobarView = infobarBottomSheetView;
        this.instructionContainer = instructionContainerView;
        this.instructionContainerPip = instructionContainrPIPView;
        this.mapLayout = frameLayout;
        this.navigationFinishedView = navigationFinishedView;
        this.nextAdviseView = nextInstructionView;
        this.resetBoundsButton = floatingActionButton;
        this.searchAlongRoute = imageView;
        this.searchAlongRouteView = searchAlongRouteView;
        this.settingsView = settingView;
        this.soundView = soundControllerView;
        this.speedWarningButton = textView2;
        this.tvSpeed = textView3;
        this.warningTextView = textView4;
    }

    public static LayoutNavigationViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutNavigationViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNavigationViewBinding bind(View view, Object obj) {
        return (LayoutNavigationViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_navigation_view);
    }

    @Deprecated
    public static LayoutNavigationViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutNavigationViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_navigation_view, viewGroup, z, obj);
    }

    public static LayoutNavigationViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutNavigationViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutNavigationViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_navigation_view, null, false, obj);
    }
}
