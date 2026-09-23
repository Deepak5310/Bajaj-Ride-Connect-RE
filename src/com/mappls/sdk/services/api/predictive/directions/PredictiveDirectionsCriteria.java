package com.mappls.sdk.services.api.predictive.directions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionsCriteria {
    public static final String PREFERRED_SIDE_EITHER = "either";
    public static final String PREFERRED_SIDE_OPPOSITE = "opposite";
    public static final String PREFERRED_SIDE_SAME = "same";
    public static final String PROFILE_BIKING = "biking";
    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_TRUCKING = "trucking";
    public static final String PROFILE_WALKING = "walking";
    public static final int SPECIFIED_ARRIVAL = 2;
    public static final int SPECIFIED_DEPARTURE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PreferredSideCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProfileCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpecifiedTypeCriteria {
    }
}
