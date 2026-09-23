package com.mappls.sdk.navigation.ui;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends NavigationOptions {
    public final Integer a;
    public final Integer b;
    public final String c;
    public final String d;
    public final Boolean e;
    public final Boolean f;
    public final Boolean g;
    public final Boolean h;
    public final Boolean i;
    public final Boolean j;
    public final Boolean k;
    public final Boolean l;
    public final Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f716n;
    public final Boolean o;
    public final Boolean p;
    public final Integer q;

    public b(Integer num, Integer num2, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Integer num3) {
        if (num == null) {
            throw new NullPointerException("Null navigationLightTheme");
        }
        this.a = num;
        if (num2 == null) {
            throw new NullPointerException("Null navigationDarkTheme");
        }
        this.b = num2;
        if (str == null) {
            throw new NullPointerException("Null mapplsMapLightStyle");
        }
        this.c = str;
        if (str2 == null) {
            throw new NullPointerException("Null mapplsMapDarkStyle");
        }
        this.d = str2;
        if (bool == null) {
            throw new NullPointerException("Null isUsingInternalMap");
        }
        this.e = bool;
        if (bool2 == null) {
            throw new NullPointerException("Null showDayNightOption");
        }
        this.f = bool2;
        if (bool3 == null) {
            throw new NullPointerException("Null showTrafficOption");
        }
        this.g = bool3;
        if (bool4 == null) {
            throw new NullPointerException("Null showNavigationSettingsOption");
        }
        this.h = bool4;
        if (bool5 == null) {
            throw new NullPointerException("Null showSearchDuringNavigationOption");
        }
        this.i = bool5;
        if (bool6 == null) {
            throw new NullPointerException("Null showNextInstructionBanner");
        }
        this.j = bool6;
        if (bool7 == null) {
            throw new NullPointerException("Null showCurrentSpeed");
        }
        this.k = bool7;
        if (bool8 == null) {
            throw new NullPointerException("Null showSpeedWarning");
        }
        this.l = bool8;
        if (bool9 == null) {
            throw new NullPointerException("Null showBottomInfoBar");
        }
        this.m = bool9;
        if (bool10 == null) {
            throw new NullPointerException("Null showInstructionBanner");
        }
        this.f716n = bool10;
        if (bool11 == null) {
            throw new NullPointerException("Null showWarningMessage");
        }
        this.o = bool11;
        if (bool12 == null) {
            throw new NullPointerException("Null showSoundToggleButton");
        }
        this.p = bool12;
        if (num3 == null) {
            throw new NullPointerException("Null navigationTheme");
        }
        this.q = num3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NavigationOptions)) {
            return false;
        }
        NavigationOptions navigationOptions = (NavigationOptions) obj;
        return this.a.equals(navigationOptions.navigationLightTheme()) && this.b.equals(navigationOptions.navigationDarkTheme()) && this.c.equals(navigationOptions.mapplsMapLightStyle()) && this.d.equals(navigationOptions.mapplsMapDarkStyle()) && this.e.equals(navigationOptions.isUsingInternalMap()) && this.f.equals(navigationOptions.showDayNightOption()) && this.g.equals(navigationOptions.showTrafficOption()) && this.h.equals(navigationOptions.showNavigationSettingsOption()) && this.i.equals(navigationOptions.showSearchDuringNavigationOption()) && this.j.equals(navigationOptions.showNextInstructionBanner()) && this.k.equals(navigationOptions.showCurrentSpeed()) && this.l.equals(navigationOptions.showSpeedWarning()) && this.m.equals(navigationOptions.showBottomInfoBar()) && this.f716n.equals(navigationOptions.showInstructionBanner()) && this.o.equals(navigationOptions.showWarningMessage()) && this.p.equals(navigationOptions.showSoundToggleButton()) && this.q.equals(navigationOptions.navigationTheme());
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f716n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ this.p.hashCode()) * 1000003) ^ this.q.hashCode();
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean isUsingInternalMap() {
        return this.e;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final String mapplsMapDarkStyle() {
        return this.d;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final String mapplsMapLightStyle() {
        return this.c;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Integer navigationDarkTheme() {
        return this.b;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Integer navigationLightTheme() {
        return this.a;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Integer navigationTheme() {
        return this.q;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showBottomInfoBar() {
        return this.m;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showCurrentSpeed() {
        return this.k;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showDayNightOption() {
        return this.f;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showInstructionBanner() {
        return this.f716n;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showNavigationSettingsOption() {
        return this.h;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showNextInstructionBanner() {
        return this.j;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showSearchDuringNavigationOption() {
        return this.i;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showSoundToggleButton() {
        return this.p;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showSpeedWarning() {
        return this.l;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showTrafficOption() {
        return this.g;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions
    public final Boolean showWarningMessage() {
        return this.o;
    }

    public final String toString() {
        return "NavigationOptions{navigationLightTheme=" + this.a + ", navigationDarkTheme=" + this.b + ", mapplsMapLightStyle=" + this.c + ", mapplsMapDarkStyle=" + this.d + ", isUsingInternalMap=" + this.e + ", showDayNightOption=" + this.f + ", showTrafficOption=" + this.g + ", showNavigationSettingsOption=" + this.h + ", showSearchDuringNavigationOption=" + this.i + ", showNextInstructionBanner=" + this.j + ", showCurrentSpeed=" + this.k + ", showSpeedWarning=" + this.l + ", showBottomInfoBar=" + this.m + ", showInstructionBanner=" + this.f716n + ", showWarningMessage=" + this.o + ", showSoundToggleButton=" + this.p + ", navigationTheme=" + this.q + "}";
    }
}
