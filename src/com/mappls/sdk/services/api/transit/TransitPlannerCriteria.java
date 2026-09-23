package com.mappls.sdk.services.api.transit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class TransitPlannerCriteria {
    public static final String MODE_BUS = "BUS";
    public static final String MODE_RAIL = "RAIL";
    public static final String MODE_SUBWAY = "SUBWAY";
    public static final String MODE_TRANSIT = "TRANSIT";

    @Retention(RetentionPolicy.SOURCE)
    public @interface ModeCriteria {
    }
}
