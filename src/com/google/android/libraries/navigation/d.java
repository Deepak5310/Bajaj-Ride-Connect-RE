package com.google.android.libraries.navigation;

import android.util.DisplayMetrics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends NavigationUpdatesOptions {
    private final int a;
    private final int b;
    private final DisplayMetrics c;

    public d(int i, int i2, DisplayMetrics displayMetrics) {
        this.a = i;
        this.b = i2;
        this.c = displayMetrics;
    }

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions
    public final DisplayMetrics displayMetrics() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NavigationUpdatesOptions) {
            NavigationUpdatesOptions navigationUpdatesOptions = (NavigationUpdatesOptions) obj;
            if (this.a == navigationUpdatesOptions.numNextStepsToPreview() && this.b == navigationUpdatesOptions.generatedStepImagesType() && this.c.equals(navigationUpdatesOptions.displayMetrics())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions
    public final int generatedStepImagesType() {
        return this.b;
    }

    public final int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions
    public final int numNextStepsToPreview() {
        return this.a;
    }

    public final String toString() {
        return "NavigationUpdatesOptions{numNextStepsToPreview=" + this.a + ", generatedStepImagesType=" + this.b + ", displayMetrics=" + String.valueOf(this.c) + "}";
    }
}
