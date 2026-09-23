package com.mappls.sdk.navigation.ui;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends NavigationOptions.Builder {
    public Integer a;
    public Integer b;
    public String c;
    public String d;
    public Boolean e;
    public Boolean f;
    public Boolean g;
    public Boolean h;
    public Boolean i;
    public Boolean j;
    public Boolean k;
    public Boolean l;
    public Boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f715n;
    public Boolean o;
    public Boolean p;
    public Integer q;

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder isUsingInternalMap(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null isUsingInternalMap");
        }
        this.e = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder mapplsMapDarkStyle(String str) {
        if (str == null) {
            throw new NullPointerException("Null mapplsMapDarkStyle");
        }
        this.d = str;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder mapplsMapLightStyle(String str) {
        if (str == null) {
            throw new NullPointerException("Null mapplsMapLightStyle");
        }
        this.c = str;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder navigationDarkTheme(Integer num) {
        if (num == null) {
            throw new NullPointerException("Null navigationDarkTheme");
        }
        this.b = num;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder navigationLightTheme(Integer num) {
        if (num == null) {
            throw new NullPointerException("Null navigationLightTheme");
        }
        this.a = num;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder navigationTheme(Integer num) {
        if (num == null) {
            throw new NullPointerException("Null navigationTheme");
        }
        this.q = num;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showBottomInfoBar(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showBottomInfoBar");
        }
        this.m = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showCurrentSpeed(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showCurrentSpeed");
        }
        this.k = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showDayNightOption(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showDayNightOption");
        }
        this.f = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showInstructionBanner(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showInstructionBanner");
        }
        this.f715n = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showNavigationSettingsOption(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showNavigationSettingsOption");
        }
        this.h = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showNextInstructionBanner(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showNextInstructionBanner");
        }
        this.j = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showSearchDuringNavigationOption(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showSearchDuringNavigationOption");
        }
        this.i = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showSoundToggleButton(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showSoundToggleButton");
        }
        this.p = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showSpeedWarning(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showSpeedWarning");
        }
        this.l = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showTrafficOption(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showTrafficOption");
        }
        this.g = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions.Builder showWarningMessage(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null showWarningMessage");
        }
        this.o = bool;
        return this;
    }

    @Override // com.mappls.sdk.navigation.ui.NavigationOptions.Builder
    public final NavigationOptions build() {
        String strConcat = this.a == null ? " navigationLightTheme" : "";
        if (this.b == null) {
            strConcat = strConcat.concat(" navigationDarkTheme");
        }
        if (this.c == null) {
            strConcat = strConcat + " mapplsMapLightStyle";
        }
        if (this.d == null) {
            strConcat = strConcat + " mapplsMapDarkStyle";
        }
        if (this.e == null) {
            strConcat = strConcat + " isUsingInternalMap";
        }
        if (this.f == null) {
            strConcat = strConcat + " showDayNightOption";
        }
        if (this.g == null) {
            strConcat = strConcat + " showTrafficOption";
        }
        if (this.h == null) {
            strConcat = strConcat + " showNavigationSettingsOption";
        }
        if (this.i == null) {
            strConcat = strConcat + " showSearchDuringNavigationOption";
        }
        if (this.j == null) {
            strConcat = strConcat + " showNextInstructionBanner";
        }
        if (this.k == null) {
            strConcat = strConcat + " showCurrentSpeed";
        }
        if (this.l == null) {
            strConcat = strConcat + " showSpeedWarning";
        }
        if (this.m == null) {
            strConcat = strConcat + " showBottomInfoBar";
        }
        if (this.f715n == null) {
            strConcat = strConcat + " showInstructionBanner";
        }
        if (this.o == null) {
            strConcat = strConcat + " showWarningMessage";
        }
        if (this.p == null) {
            strConcat = strConcat + " showSoundToggleButton";
        }
        if (this.q == null) {
            strConcat = strConcat + " navigationTheme";
        }
        if (strConcat.isEmpty()) {
            return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f715n, this.o, this.p, this.q);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }
}
