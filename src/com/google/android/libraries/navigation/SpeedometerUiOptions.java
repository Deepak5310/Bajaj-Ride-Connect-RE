package com.google.android.libraries.navigation;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class SpeedometerUiOptions implements Parcelable {
    public static final Parcelable.Creator<SpeedometerUiOptions> CREATOR = new au();
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        private int a = 16777215;
        private int b = 0;
        private int c = 14233637;
        private int d = 14233637;
        private int e = 14233637;
        private int f = 14233637;
        private int g = 16777215;
        private int h = 16777215;

        public SpeedometerUiOptions build() {
            try {
                return new SpeedometerUiOptions(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setBackgroundColorDayMode(SpeedAlertSeverity speedAlertSeverity, int i) {
            try {
                com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
                if (speedAlertSeverity == SpeedAlertSeverity.MINOR) {
                    this.a = i;
                } else if (speedAlertSeverity == SpeedAlertSeverity.MAJOR) {
                    this.e = i;
                }
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setBackgroundColorNightMode(SpeedAlertSeverity speedAlertSeverity, int i) {
            try {
                com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
                if (speedAlertSeverity == SpeedAlertSeverity.MINOR) {
                    this.b = i;
                } else if (speedAlertSeverity == SpeedAlertSeverity.MAJOR) {
                    this.f = i;
                }
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setTextColorDayMode(SpeedAlertSeverity speedAlertSeverity, int i) {
            try {
                com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
                if (speedAlertSeverity == SpeedAlertSeverity.MINOR) {
                    this.c = i;
                } else if (speedAlertSeverity == SpeedAlertSeverity.MAJOR) {
                    this.g = i;
                }
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setTextColorNightMode(SpeedAlertSeverity speedAlertSeverity, int i) {
            try {
                com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
                if (speedAlertSeverity == SpeedAlertSeverity.MINOR) {
                    this.d = i;
                } else if (speedAlertSeverity == SpeedAlertSeverity.MAJOR) {
                    this.h = i;
                }
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }
    }

    public SpeedometerUiOptions(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public int getBackgroundColorDayMode(SpeedAlertSeverity speedAlertSeverity) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
            return speedAlertSeverity == SpeedAlertSeverity.MINOR ? this.a : this.e;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getBackgroundColorNightMode(SpeedAlertSeverity speedAlertSeverity) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
            return speedAlertSeverity == SpeedAlertSeverity.MINOR ? this.b : this.f;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getTextColorDayMode(SpeedAlertSeverity speedAlertSeverity) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
            return speedAlertSeverity == SpeedAlertSeverity.MINOR ? this.c : this.g;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getTextColorNightMode(SpeedAlertSeverity speedAlertSeverity) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
            return speedAlertSeverity == SpeedAlertSeverity.MINOR ? this.d : this.h;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
