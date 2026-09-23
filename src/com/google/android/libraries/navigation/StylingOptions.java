package com.google.android.libraries.navigation;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class StylingOptions implements Parcelable {
    public static final Parcelable.Creator<StylingOptions> CREATOR = new av();
    public final com.google.android.libraries.navigation.internal.vc.b a;

    public StylingOptions() {
        this.a = new com.google.android.libraries.navigation.internal.vc.b();
    }

    public StylingOptions(com.google.android.libraries.navigation.internal.vc.b bVar) {
        this.a = new com.google.android.libraries.navigation.internal.vc.b(bVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHeaderDistanceTypefacePath() {
        try {
            return this.a.f634n;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderDistanceUnitsTextColor() {
        try {
            return this.a.q;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Float getHeaderDistanceUnitsTextSize() {
        try {
            return this.a.r;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderDistanceValueTextColor() {
        try {
            return this.a.o;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Float getHeaderDistanceValueTextSize() {
        try {
            return this.a.p;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderGuidanceRecommendedLaneColor() {
        try {
            return this.a.s;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Float getHeaderInstructionsFirstRowTextSize() {
        try {
            return this.a.i;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Float getHeaderInstructionsSecondRowTextSize() {
        try {
            return this.a.j;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderInstructionsTextColor() {
        try {
            return this.a.h;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String getHeaderInstructionsTypefacePath() {
        try {
            return this.a.g;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderLargeManeuverIconColor() {
        try {
            return this.a.e;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderNextStepTextColor() {
        try {
            return this.a.l;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Float getHeaderNextStepTextSize() {
        try {
            return this.a.m;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String getHeaderNextStepTypefacePath() {
        try {
            return this.a.k;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getHeaderSmallManeuverIconColor() {
        try {
            return this.a.f;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getPrimaryDayModeThemeColor() {
        try {
            return this.a.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getPrimaryNightModeThemeColor() {
        try {
            return this.a.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getSecondaryDayModeThemeColor() {
        try {
            return this.a.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Integer getSecondaryNightModeThemeColor() {
        try {
            return this.a.d;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerDistanceTypefacePath(String str) {
        try {
            this.a.f634n = str;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerDistanceUnitsTextColor(Integer num) {
        try {
            this.a.q = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerDistanceUnitsTextSize(Float f) {
        try {
            this.a.r = f;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerDistanceValueTextColor(Integer num) {
        try {
            this.a.o = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerDistanceValueTextSize(Float f) {
        try {
            this.a.p = f;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerGuidanceRecommendedLaneColor(Integer num) {
        try {
            this.a.s = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerInstructionsFirstRowTextSize(Float f) {
        try {
            this.a.i = f;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerInstructionsSecondRowTextSize(Float f) {
        try {
            this.a.j = f;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerInstructionsTextColor(Integer num) {
        try {
            this.a.h = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerInstructionsTypefacePath(String str) {
        try {
            this.a.g = str;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerLargeManeuverIconColor(Integer num) {
        try {
            this.a.e = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerNextStepTextColor(Integer num) {
        try {
            this.a.l = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerNextStepTextSize(Float f) {
        try {
            this.a.m = f;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerNextStepTypefacePath(String str) {
        try {
            this.a.k = str;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions headerSmallManeuverIconColor(Integer num) {
        try {
            this.a.f = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions primaryDayModeThemeColor(Integer num) {
        try {
            this.a.a = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions primaryNightModeThemeColor(Integer num) {
        try {
            this.a.c = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions secondaryDayModeThemeColor(Integer num) {
        try {
            this.a.b = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions secondaryNightModeThemeColor(Integer num) {
        try {
            this.a.d = num;
            return this;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public StylingOptions(StylingOptions stylingOptions) {
        this.a = new com.google.android.libraries.navigation.internal.vc.b();
        primaryDayModeThemeColor(stylingOptions.getPrimaryDayModeThemeColor());
        secondaryDayModeThemeColor(stylingOptions.getSecondaryDayModeThemeColor());
        primaryNightModeThemeColor(stylingOptions.getPrimaryNightModeThemeColor());
        secondaryNightModeThemeColor(stylingOptions.getSecondaryNightModeThemeColor());
        headerLargeManeuverIconColor(stylingOptions.getHeaderLargeManeuverIconColor());
        headerSmallManeuverIconColor(stylingOptions.getHeaderSmallManeuverIconColor());
        headerInstructionsTypefacePath(stylingOptions.getHeaderInstructionsTypefacePath());
        headerInstructionsTextColor(stylingOptions.getHeaderInstructionsTextColor());
        headerInstructionsFirstRowTextSize(stylingOptions.getHeaderInstructionsFirstRowTextSize());
        headerInstructionsSecondRowTextSize(stylingOptions.getHeaderInstructionsSecondRowTextSize());
        headerNextStepTypefacePath(stylingOptions.getHeaderNextStepTypefacePath());
        headerNextStepTextColor(stylingOptions.getHeaderNextStepTextColor());
        headerNextStepTextSize(stylingOptions.getHeaderNextStepTextSize());
        headerDistanceTypefacePath(stylingOptions.getHeaderDistanceTypefacePath());
        headerDistanceValueTextColor(stylingOptions.getHeaderDistanceValueTextColor());
        headerDistanceValueTextSize(stylingOptions.getHeaderDistanceValueTextSize());
        headerDistanceUnitsTextColor(stylingOptions.getHeaderDistanceUnitsTextColor());
        headerDistanceUnitsTextSize(stylingOptions.getHeaderDistanceUnitsTextSize());
        headerGuidanceRecommendedLaneColor(stylingOptions.getHeaderGuidanceRecommendedLaneColor());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            this.a.writeToParcel(parcel, i);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
