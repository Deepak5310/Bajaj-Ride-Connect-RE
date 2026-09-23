package com.google.android.libraries.mapsplatform.turnbyturn.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LaneDirection {

    /* JADX INFO: compiled from: PG */
    public static abstract class Builder {
        public abstract LaneDirection build();

        public abstract Builder setIsRecommended(Boolean bool);

        public abstract Builder setLaneShape(int i);
    }

    /* JADX INFO: compiled from: PG */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LaneShape {
        public static final int NORMAL_LEFT = 4;
        public static final int NORMAL_RIGHT = 5;
        public static final int SHARP_LEFT = 6;
        public static final int SHARP_RIGHT = 7;
        public static final int SLIGHT_LEFT = 2;
        public static final int SLIGHT_RIGHT = 3;
        public static final int STRAIGHT = 1;
        public static final int UNKNOWN = 0;
        public static final int U_TURN_LEFT = 8;
        public static final int U_TURN_RIGHT = 9;
    }

    public static Builder builder() {
        return new c();
    }

    public abstract Boolean isRecommended();

    public abstract int laneShape();
}
