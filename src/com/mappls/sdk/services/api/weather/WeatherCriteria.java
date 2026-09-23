package com.mappls.sdk.services.api.weather;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherCriteria {
    public static final String SIZE_24PX = "24px";
    public static final String SIZE_36PX = "36px";
    public static final String THEME_DARK = "dark";
    public static final String THEME_LIGHT = "light";
    public static final String UNIT_CELSIUS = "C";
    public static final String UNIT_FARENHEIT = "F";
    public static final String UNIT_TYPE_DAY = "day";
    public static final String UNIT_TYPE_HOUR = "hour";

    @Retention(RetentionPolicy.SOURCE)
    public @interface SizeCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ThemeCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnitCriteria {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnitTypeCriteria {
    }
}
