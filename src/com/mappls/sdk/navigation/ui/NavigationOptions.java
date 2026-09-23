package com.mappls.sdk.navigation.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NavigationOptions implements Parcelable {
    public static final int THEME_DAY = 1;
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_NIGHT = 2;

    public static abstract class Builder {
        public abstract NavigationOptions build();

        public abstract Builder isUsingInternalMap(Boolean bool);

        public abstract Builder mapplsMapDarkStyle(String str);

        public abstract Builder mapplsMapLightStyle(String str);

        public abstract Builder navigationDarkTheme(Integer num);

        public abstract Builder navigationLightTheme(Integer num);

        public abstract Builder navigationTheme(Integer num);

        public abstract Builder showBottomInfoBar(Boolean bool);

        public abstract Builder showCurrentSpeed(Boolean bool);

        public abstract Builder showDayNightOption(Boolean bool);

        public abstract Builder showInstructionBanner(Boolean bool);

        public abstract Builder showNavigationSettingsOption(Boolean bool);

        public abstract Builder showNextInstructionBanner(Boolean bool);

        public abstract Builder showSearchDuringNavigationOption(Boolean bool);

        public abstract Builder showSoundToggleButton(Boolean bool);

        public abstract Builder showSpeedWarning(Boolean bool);

        public abstract Builder showTrafficOption(Boolean bool);

        public abstract Builder showWarningMessage(Boolean bool);
    }

    public static Builder builder() {
        a aVar = new a();
        aVar.a = Integer.valueOf(R.style.NavigationViewLight);
        aVar.b = Integer.valueOf(R.style.NavigationViewDark);
        Boolean bool = Boolean.TRUE;
        aVar.e = bool;
        aVar.d = "standard_night";
        aVar.c = "standard_day";
        aVar.g = bool;
        Boolean bool2 = Boolean.FALSE;
        aVar.f = bool2;
        aVar.h = bool;
        aVar.i = bool2;
        aVar.j = bool;
        aVar.k = bool;
        aVar.l = bool;
        aVar.m = bool;
        aVar.f715n = bool;
        aVar.o = bool;
        aVar.p = bool;
        aVar.q = 1;
        return aVar;
    }

    public static NavigationOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavigationView, 0, 0);
        Builder builder = builder();
        builder.navigationLightTheme(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationView_navigationLightTheme, R.style.NavigationViewLight)));
        builder.navigationDarkTheme(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationView_navigationDarkTheme, R.style.NavigationViewDark)));
        builder.isUsingInternalMap(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_isUsingInternalMap, true)));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.NavigationView_mapplsMapLightStyle) && typedArrayObtainStyledAttributes.getString(R.styleable.NavigationView_mapplsMapLightStyle) != null) {
            builder.mapplsMapLightStyle(typedArrayObtainStyledAttributes.getString(R.styleable.NavigationView_mapplsMapLightStyle));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.NavigationView_mapplsMapDarkStyle) && typedArrayObtainStyledAttributes.getString(R.styleable.NavigationView_mapplsMapDarkStyle) != null) {
            builder.mapplsMapDarkStyle(typedArrayObtainStyledAttributes.getString(R.styleable.NavigationView_mapplsMapDarkStyle));
        }
        builder.showDayNightOption(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showDayNightOption, false)));
        builder.showNavigationSettingsOption(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showSettingsOption, true)));
        builder.showTrafficOption(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showTrafficOption, true)));
        builder.showSearchDuringNavigationOption(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showSearchDuringNavigationOption, false)));
        builder.navigationTheme(Integer.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.NavigationView_navigationTheme, 1)));
        builder.showNextInstructionBanner(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showNextInstructionBanner, true)));
        builder.showCurrentSpeed(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showCurrentSpeed, true)));
        builder.showSpeedWarning(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showSpeedWarning, true)));
        builder.showBottomInfoBar(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showBottomInfoBar, true)));
        builder.showInstructionBanner(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showInstructionBanner, true)));
        builder.showWarningMessage(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showWarningMessage, true)));
        builder.showSoundToggleButton(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationView_showSoundToggleButton, true)));
        return builder.build();
    }

    public abstract Boolean isUsingInternalMap();

    public abstract String mapplsMapDarkStyle();

    public abstract String mapplsMapLightStyle();

    public abstract Integer navigationDarkTheme();

    public abstract Integer navigationLightTheme();

    public abstract Integer navigationTheme();

    public abstract Boolean showBottomInfoBar();

    public abstract Boolean showCurrentSpeed();

    public abstract Boolean showDayNightOption();

    public abstract Boolean showInstructionBanner();

    public abstract Boolean showNavigationSettingsOption();

    public abstract Boolean showNextInstructionBanner();

    public abstract Boolean showSearchDuringNavigationOption();

    public abstract Boolean showSoundToggleButton();

    public abstract Boolean showSpeedWarning();

    public abstract Boolean showTrafficOption();

    public abstract Boolean showWarningMessage();
}
