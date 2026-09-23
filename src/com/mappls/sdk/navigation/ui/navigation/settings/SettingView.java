package com.mappls.sdk.navigation.ui.navigation.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutSettingsViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public class SettingView extends CoordinatorLayout {
    LayoutSettingsViewBinding binding;
    private BottomSheetBehavior mBottomSheetBehavior;
    private s settingsCallback;

    public SettingView(Context context) {
        this(context, null);
    }

    private void initView() {
        this.binding.swPlayDuringPhoneCall.setChecked(MapplsNavigationHelper.getInstance().isPlayDuringPhoneCallEnabled());
        this.binding.swSafetyEventAudio.setChecked(MapplsNavigationHelper.getInstance().speakSafetyEvents());
        this.binding.swTrafficEventAudio.setChecked(MapplsNavigationHelper.getInstance().speakTrafficEvents());
        this.binding.swRoadCondEventAudio.setChecked(MapplsNavigationHelper.getInstance().speakRoadConditionsEvents());
        this.binding.swSafetyEvent.setChecked(MapplsNavigationHelper.getInstance().showSafetyEvents());
        this.binding.swTrafficEvent.setChecked(MapplsNavigationHelper.getInstance().showTrafficEvents());
        this.binding.swRoadCondEvent.setChecked(MapplsNavigationHelper.getInstance().showRoadConditionsEvents());
        this.binding.swNavigationEvent.setChecked(MapplsNavigationHelper.getInstance().isNavigationEventEnabled());
        this.binding.swPlayVoiceCall.setChecked(MapplsNavigationHelper.getInstance().isPlayAsVoiceCall());
        this.binding.swJunctionView.setChecked(MapplsNavigationHelper.getInstance().isJunctionViewEnabled());
        this.binding.swInterruptMusic.setChecked(MapplsNavigationHelper.getInstance().isInterruptMusicForNavigationInstructions());
        this.binding.swNavigationEventAudio.setChecked(MapplsNavigationHelper.getInstance().isNavigationEventAudioPromptEnabled());
        updateUnitView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationEvent(boolean z) {
        this.binding.swSafetyEvent.setEnabled(z);
        this.binding.swTrafficEvent.setEnabled(z);
        this.binding.swRoadCondEvent.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationEventAudio(boolean z) {
        this.binding.swRoadCondEventAudio.setEnabled(z);
        this.binding.swTrafficEventAudio.setEnabled(z);
        this.binding.swSafetyEventAudio.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnitView() {
        this.binding.tvKmUnit.setSelected(MapplsNavigationHelper.getInstance().isCurrentMetricSystemKm());
        this.binding.tvMileUnit.setSelected(!MapplsNavigationHelper.getInstance().isCurrentMetricSystemKm());
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
        initView();
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.binding.settingView);
        this.mBottomSheetBehavior = bottomSheetBehaviorFrom;
        bottomSheetBehaviorFrom.setHideable(true);
        this.mBottomSheetBehavior.setSkipCollapsed(true);
        this.mBottomSheetBehavior.setPeekHeight(0);
        this.mBottomSheetBehavior.setState(5);
        this.binding.closeBottomSheet.setOnClickListener(new j(this));
        this.binding.tvTwoD.setOnClickListener(new k(this));
        this.binding.tvThreeD.setOnClickListener(new l(this));
        this.binding.resetMapType.setOnClickListener(new m(this));
        this.binding.tvMileUnit.setOnClickListener(new n(this));
        this.binding.tvKmUnit.setOnClickListener(new o(this));
        this.binding.swPlayDuringPhoneCall.setOnCheckedChangeListener(new p());
        this.binding.swJunctionView.setOnCheckedChangeListener(new q());
        this.binding.swPlayVoiceCall.setOnCheckedChangeListener(new r());
        this.binding.swNavigationEvent.setOnCheckedChangeListener(new a(this));
        this.binding.swSafetyEvent.setOnCheckedChangeListener(new b());
        this.binding.swTrafficEvent.setOnCheckedChangeListener(new c());
        this.binding.swRoadCondEvent.setOnCheckedChangeListener(new d());
        this.binding.swSafetyEventAudio.setOnCheckedChangeListener(new e());
        this.binding.swTrafficEventAudio.setOnCheckedChangeListener(new f());
        this.binding.swRoadCondEventAudio.setOnCheckedChangeListener(new g());
        this.binding.swInterruptMusic.setOnCheckedChangeListener(new h());
        this.binding.swNavigationEventAudio.setOnCheckedChangeListener(new i(this));
    }

    public boolean onBackPress() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 3) {
            return false;
        }
        this.mBottomSheetBehavior.setState(5);
        return true;
    }

    public void setMapLayer(com.mappls.sdk.navigation.ui.utils.b bVar) {
        if (bVar == com.mappls.sdk.navigation.ui.utils.b.a) {
            this.binding.tvTwoD.setSelected(false);
            this.binding.tvThreeD.setSelected(false);
        } else if (bVar == com.mappls.sdk.navigation.ui.utils.b.b) {
            this.binding.tvTwoD.setSelected(true);
            this.binding.tvThreeD.setSelected(false);
        } else if (bVar == com.mappls.sdk.navigation.ui.utils.b.c) {
            this.binding.tvThreeD.setSelected(true);
            this.binding.tvTwoD.setSelected(false);
        }
    }

    public void setSettingsCallback(s sVar) {
        this.settingsCallback = sVar;
    }

    public void show() {
        BottomSheetBehavior bottomSheetBehavior = this.mBottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public void toggleTheme() {
        TextView textView = this.binding.tvTwoD;
        Context context = getContext();
        textView.setTextColor(ContextCompat.getColorStateList(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewTwoDThreeDTextColor).resourceId));
        TextView textView2 = this.binding.tvThreeD;
        Context context2 = getContext();
        textView2.setTextColor(ContextCompat.getColorStateList(context2, com.mappls.sdk.navigation.ui.theme.a.a(context2, R.attr.navigationViewTwoDThreeDTextColor).resourceId));
        TextView textView3 = this.binding.tvKmUnit;
        Context context3 = getContext();
        textView3.setTextColor(ContextCompat.getColorStateList(context3, com.mappls.sdk.navigation.ui.theme.a.a(context3, R.attr.navigationViewKmMileUnitTextColor).resourceId));
        TextView textView4 = this.binding.tvMileUnit;
        Context context4 = getContext();
        textView4.setTextColor(ContextCompat.getColorStateList(context4, com.mappls.sdk.navigation.ui.theme.a.a(context4, R.attr.navigationViewKmMileUnitTextColor).resourceId));
        this.binding.settingView.setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.toolbarSetting.setCardBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewPrimary));
        this.binding.toolbarText.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        ImageView imageView = this.binding.closeBottomSheet;
        Context context5 = getContext();
        imageView.setImageDrawable(AppCompatResources.getDrawable(context5, com.mappls.sdk.navigation.ui.theme.a.a(context5, R.attr.navigationViewBackButtonDrawable).resourceId));
        this.binding.tvMapType.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvUnitType.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvEnableInstructionDuringPhoneCall.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvJunctionView.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvPlayVoiceCall.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvNavigationEvent.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvTrafficEvent.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvRoadCondEvent.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvSafetyEvent.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvSafetyEventAudio.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvTrafficEventAudio.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvRoadCondEventAudio.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvInterruptMusic.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvNavigationEventAudio.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvMapSetting.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvNavSetting.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
        this.binding.tvNavVoiceSetting.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationTextColorPrimary));
    }

    public SettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = LayoutSettingsViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
