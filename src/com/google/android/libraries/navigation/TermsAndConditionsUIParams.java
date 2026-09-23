package com.google.android.libraries.navigation;

import android.graphics.Typeface;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class TermsAndConditionsUIParams {
    public final int acceptButtonTextColor;
    public final int backgroundColor;
    public final int buttonsTextSize;
    public final Typeface buttonsTypeface;
    public final int cancelButtonTextColor;
    public final int mainTextColor;
    public final int mainTextTextSize;
    public final Typeface mainTextTypeface;
    public final int titleColor;
    public final int titleTextSize;
    public final Typeface titleTypeface;

    /* JADX INFO: compiled from: PG */
    public static class Builder {
        public int a = -1;
        public int b = ViewCompat.MEASURED_STATE_MASK;
        public Typeface c = Typeface.DEFAULT;
        public int d = 20;
        public int e = ViewCompat.MEASURED_STATE_MASK;
        public Typeface f = Typeface.DEFAULT;
        public int g = 20;
        public Typeface h = Typeface.DEFAULT;
        public int i = 20;
        public int j = ViewCompat.MEASURED_STATE_MASK;
        public int k = ViewCompat.MEASURED_STATE_MASK;

        public TermsAndConditionsUIParams build() {
            try {
                return new TermsAndConditionsUIParams(this);
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setAcceptButtonTextColor(int i) {
            try {
                this.j = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setBackgroundColor(int i) {
            try {
                this.a = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setButtonsTextSize(int i) {
            try {
                this.i = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setButtonsTypeface(Typeface typeface) {
            try {
                this.h = typeface;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setCancelButtonTextColor(int i) {
            try {
                this.k = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setMainTextColor(int i) {
            try {
                this.e = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setMainTextTextSize(int i) {
            try {
                this.g = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setMainTextTypeface(Typeface typeface) {
            try {
                this.f = typeface;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setTitleColor(int i) {
            try {
                this.b = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setTitleTextSize(int i) {
            try {
                this.d = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setTitleTypeface(Typeface typeface) {
            try {
                this.c = typeface;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }
    }

    public TermsAndConditionsUIParams(Builder builder) {
        this.backgroundColor = builder.a;
        this.titleColor = builder.b;
        this.titleTypeface = builder.c;
        this.titleTextSize = builder.d;
        this.mainTextColor = builder.e;
        this.mainTextTypeface = builder.f;
        this.mainTextTextSize = builder.g;
        this.buttonsTypeface = builder.h;
        this.buttonsTextSize = builder.i;
        this.acceptButtonTextColor = builder.j;
        this.cancelButtonTextColor = builder.k;
    }

    public static Builder builder() {
        try {
            return new Builder();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
