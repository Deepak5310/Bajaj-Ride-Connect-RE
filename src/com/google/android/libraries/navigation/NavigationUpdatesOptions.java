package com.google.android.libraries.navigation;

import android.util.DisplayMetrics;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationUpdatesOptions {

    /* JADX INFO: compiled from: PG */
    public static abstract class Builder {
        public abstract NavigationUpdatesOptions build();

        public abstract Builder setDisplayMetrics(DisplayMetrics displayMetrics);

        public abstract Builder setGeneratedStepImagesType(int i);

        public abstract Builder setNumNextStepsToPreview(int i);
    }

    /* JADX INFO: compiled from: PG */
    @Target({ElementType.TYPE_USE})
    public @interface GeneratedStepImagesType {
        public static final int BITMAP = 1;
        public static final int NONE = 0;
    }

    public static Builder builder() {
        try {
            return new c();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public abstract DisplayMetrics displayMetrics();

    public abstract int generatedStepImagesType();

    public abstract int numNextStepsToPreview();
}
