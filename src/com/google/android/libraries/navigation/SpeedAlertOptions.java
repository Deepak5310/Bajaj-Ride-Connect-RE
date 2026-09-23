package com.google.android.libraries.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class SpeedAlertOptions implements Parcelable {
    public static final Parcelable.Creator<SpeedAlertOptions> CREATOR = new at();
    public static final float UNKNOWN_PERCENTAGE = -1.0f;
    public static final double UNKNOWN_TIME = -1.0d;
    private final float a;
    private final float b;
    private final double c;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        private float a = -1.0f;
        private float b = -1.0f;
        private double c = -1.0d;

        public SpeedAlertOptions build() {
            try {
                float f = this.a;
                if (f >= 0.0f) {
                    float f2 = this.b;
                    if (f2 >= 0.0f && f2 >= f) {
                        double d = this.c;
                        if (d > 0.0d) {
                            return new SpeedAlertOptions(f, f2, d);
                        }
                    }
                }
                throw new ApiIllegalArgumentException("Not all speed alert triggering thresholds are properly configured!");
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setSeverityUpgradeDurationSeconds(double d) {
            try {
                this.c = d;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setSpeedAlertThresholdPercentage(SpeedAlertSeverity speedAlertSeverity, float f) {
            try {
                com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
                if (speedAlertSeverity == SpeedAlertSeverity.MINOR) {
                    this.a = f;
                } else if (speedAlertSeverity == SpeedAlertSeverity.MAJOR) {
                    this.b = f;
                }
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }
    }

    public SpeedAlertOptions(float f, float f2, double d) {
        this.a = f;
        this.b = f2;
        this.c = d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public double getSeverityUpgradeDurationSeconds() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public float getSpeedAlertThresholdPercentage(SpeedAlertSeverity speedAlertSeverity) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(speedAlertSeverity, "speedAlertSeverity cannot be null.");
            return speedAlertSeverity == SpeedAlertSeverity.MINOR ? this.a : this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeDouble(this.c);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
