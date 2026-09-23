package com.mappls.sdk.navigation.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSettingsViewBinding extends ViewDataBinding {
    public final ImageView closeBottomSheet;
    public final TextView resetMapType;
    public final RelativeLayout settingView;
    public final Switch swInterruptMusic;
    public final Switch swJunctionView;
    public final Switch swNavigationEvent;
    public final Switch swNavigationEventAudio;
    public final Switch swPlayDuringPhoneCall;
    public final SwitchCompat swPlayVoiceCall;
    public final Switch swRoadCondEvent;
    public final SwitchCompat swRoadCondEventAudio;
    public final Switch swSafetyEvent;
    public final Switch swSafetyEventAudio;
    public final Switch swTrafficEvent;
    public final SwitchCompat swTrafficEventAudio;
    public final CardView toolbarSetting;
    public final TextView toolbarText;
    public final TextView tvEnableInstructionDuringPhoneCall;
    public final TextView tvInterruptMusic;
    public final TextView tvJunctionView;
    public final TextView tvKmUnit;
    public final TextView tvMapSetting;
    public final TextView tvMapType;
    public final TextView tvMileUnit;
    public final TextView tvNavSetting;
    public final TextView tvNavVoiceSetting;
    public final TextView tvNavigationEvent;
    public final TextView tvNavigationEventAudio;
    public final TextView tvPlayVoiceCall;
    public final TextView tvRoadCondEvent;
    public final TextView tvRoadCondEventAudio;
    public final TextView tvSafetyEvent;
    public final TextView tvSafetyEventAudio;
    public final TextView tvSoundVolume;
    public final TextView tvThreeD;
    public final TextView tvTrafficEvent;
    public final TextView tvTrafficEventAudio;
    public final TextView tvTwoD;
    public final TextView tvUnitType;
    public final SeekBar volumeSeekBar;

    protected LayoutSettingsViewBinding(Object obj, View view, int i, ImageView imageView, TextView textView, RelativeLayout relativeLayout, Switch r9, Switch r10, Switch r11, Switch r12, Switch r13, SwitchCompat switchCompat, Switch r15, SwitchCompat switchCompat2, Switch r17, Switch r18, Switch r19, SwitchCompat switchCompat3, CardView cardView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, SeekBar seekBar) {
        super(obj, view, i);
        this.closeBottomSheet = imageView;
        this.resetMapType = textView;
        this.settingView = relativeLayout;
        this.swInterruptMusic = r9;
        this.swJunctionView = r10;
        this.swNavigationEvent = r11;
        this.swNavigationEventAudio = r12;
        this.swPlayDuringPhoneCall = r13;
        this.swPlayVoiceCall = switchCompat;
        this.swRoadCondEvent = r15;
        this.swRoadCondEventAudio = switchCompat2;
        this.swSafetyEvent = r17;
        this.swSafetyEventAudio = r18;
        this.swTrafficEvent = r19;
        this.swTrafficEventAudio = switchCompat3;
        this.toolbarSetting = cardView;
        this.toolbarText = textView2;
        this.tvEnableInstructionDuringPhoneCall = textView3;
        this.tvInterruptMusic = textView4;
        this.tvJunctionView = textView5;
        this.tvKmUnit = textView6;
        this.tvMapSetting = textView7;
        this.tvMapType = textView8;
        this.tvMileUnit = textView9;
        this.tvNavSetting = textView10;
        this.tvNavVoiceSetting = textView11;
        this.tvNavigationEvent = textView12;
        this.tvNavigationEventAudio = textView13;
        this.tvPlayVoiceCall = textView14;
        this.tvRoadCondEvent = textView15;
        this.tvRoadCondEventAudio = textView16;
        this.tvSafetyEvent = textView17;
        this.tvSafetyEventAudio = textView18;
        this.tvSoundVolume = textView19;
        this.tvThreeD = textView20;
        this.tvTrafficEvent = textView21;
        this.tvTrafficEventAudio = textView22;
        this.tvTwoD = textView23;
        this.tvUnitType = textView24;
        this.volumeSeekBar = seekBar;
    }

    public static LayoutSettingsViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static LayoutSettingsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSettingsViewBinding bind(View view, Object obj) {
        return (LayoutSettingsViewBinding) ViewDataBinding.bind(obj, view, R.layout.layout_settings_view);
    }

    @Deprecated
    public static LayoutSettingsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutSettingsViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_settings_view, viewGroup, z, obj);
    }

    public static LayoutSettingsViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSettingsViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutSettingsViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_settings_view, null, false, obj);
    }
}
