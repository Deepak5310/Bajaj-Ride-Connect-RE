package com.mappls.sdk.services.api.predictive.distance;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDistanceCriteria {
    public static final String PROFILE_BIKING = "biking";
    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_TRUCKING = "trucking";
    public static final String PROFILE_WALKING = "walking";
    public static final String SPEED_TYPES_OPTIMAL = "optimal";
    public static final String SPEED_TYPES_PREDICTIVE = "predictive";
    public static final String SPEED_TYPES_TRAFFIC = "traffic";

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProfileCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpeedTypeCriteria {
    }
}
