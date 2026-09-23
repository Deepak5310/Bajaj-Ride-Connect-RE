package com.mappls.sdk.services.api.costestimation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public final class CostEstimationCriteria {
    public static final String UNIT_KM_P_KG = "km/kg";
    public static final String UNIT_KM_P_L = "km/l";
    public static final String UNIT_KM_P_UNIT = "km/unit";
    public static final String VEHICLE_FUEL_TYPE_CNG = "CNG";
    public static final String VEHICLE_FUEL_TYPE_DIESEL = "diesel";
    public static final String VEHICLE_FUEL_TYPE_ELECTRIC = "electric";
    public static final String VEHICLE_FUEL_TYPE_PETROL = "petrol";
    public static final String VEHICLE_TYPE_AUTO = "2AxlesAuto";
    public static final String VEHICLE_TYPE_BUS = "2AxlesBus";
    public static final String VEHICLE_TYPE_FIVE_AXLES = "5Axles";
    public static final String VEHICLE_TYPE_FOUR_AXLES = "4Axles";
    public static final String VEHICLE_TYPE_HCMEME = "2AxlesHCMEME";
    public static final String VEHICLE_TYPE_LCV = "2AxlesLCV";
    public static final String VEHICLE_TYPE_MOTO = "2AxlesMoto";
    public static final String VEHICLE_TYPE_SEVEN_AXLES = "7Axles";
    public static final String VEHICLE_TYPE_SIX_AXLES = "6Axles";
    public static final String VEHICLE_TYPE_THREE_AXLES = "3Axles";
    public static final String VEHICLE_TYPE_TRUCK = "2AxlesTruck";

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnitType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VehicleFuelType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VehicleType {
    }
}
