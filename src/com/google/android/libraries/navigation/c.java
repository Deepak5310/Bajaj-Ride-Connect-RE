package com.google.android.libraries.navigation;

import android.util.DisplayMetrics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends NavigationUpdatesOptions.Builder {
    public int a;
    public int b;
    public DisplayMetrics c;
    public byte d;

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions.Builder
    public final NavigationUpdatesOptions build() {
        DisplayMetrics displayMetrics;
        if (this.d == 3 && (displayMetrics = this.c) != null) {
            return new d(this.a, this.b, displayMetrics);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.d & 1) == 0) {
            sb.append(" numNextStepsToPreview");
        }
        if ((this.d & 2) == 0) {
            sb.append(" generatedStepImagesType");
        }
        if (this.c == null) {
            sb.append(" displayMetrics");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions.Builder
    public final NavigationUpdatesOptions.Builder setDisplayMetrics(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            throw new NullPointerException("Null displayMetrics");
        }
        this.c = displayMetrics;
        return this;
    }

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions.Builder
    public final NavigationUpdatesOptions.Builder setGeneratedStepImagesType(int i) {
        this.b = i;
        this.d = (byte) (this.d | 2);
        return this;
    }

    @Override // com.google.android.libraries.navigation.NavigationUpdatesOptions.Builder
    public final NavigationUpdatesOptions.Builder setNumNextStepsToPreview(int i) {
        this.a = i;
        this.d = (byte) (this.d | 1);
        return this;
    }
}
