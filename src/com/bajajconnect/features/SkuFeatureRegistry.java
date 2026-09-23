package com.bajajconnect.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class SkuFeatureRegistry {
    private static final Map<String, Set<String>> COHORTS;
    public static final String COHORT_BLE_ONLY_GENERAL_V2 = "BLE_ONLY_GENERAL_V2";
    public static final String COHORT_CLUSTER_V1 = "CLUSTER_V1";
    private static final Set<String> DEFAULT_BLE_ONLY_GENERAL_V2_SKUS;
    private static final Set<String> DEFAULT_CLUSTER_V1_SKUS;
    private static final Map<VehicleFeature, Set<String>> FEATURE_TO_COHORTS;

    static {
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList("00JR54", "00JRGF", "00JRGG", "00JR66", "00JF63", "00JL31", "00DT23", "00JL34", "00JF68", "00JF69", "00JF64", "00JFNK", "00JR73", "00JR90")));
        DEFAULT_CLUSTER_V1_SKUS = setUnmodifiableSet;
        Set<String> setUnmodifiableSet2 = Collections.unmodifiableSet(new HashSet(Arrays.asList("00JR88", "00JR72", "00JR71", "00JR68", "00JR91")));
        DEFAULT_BLE_ONLY_GENERAL_V2_SKUS = setUnmodifiableSet2;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        COHORTS = concurrentHashMap;
        concurrentHashMap.put(COHORT_CLUSTER_V1, newConcurrentSkuSet(setUnmodifiableSet));
        concurrentHashMap.put(COHORT_BLE_ONLY_GENERAL_V2, newConcurrentSkuSet(setUnmodifiableSet2));
        EnumMap enumMap = new EnumMap(VehicleFeature.class);
        register(enumMap, VehicleFeature.BLE_GENERAL_PACKET_V2, COHORT_CLUSTER_V1, COHORT_BLE_ONLY_GENERAL_V2);
        register(enumMap, VehicleFeature.BLE_PROTOCOL_V2, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.BLE_FAV_RECENT_CALLS, COHORT_CLUSTER_V1, COHORT_BLE_ONLY_GENERAL_V2);
        register(enumMap, VehicleFeature.APP_NAVIGATION, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.BLE_TBT, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.WIFI_CLUSTER_CONNECT, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.WIFI_DOCUMENTS_SYNC, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.UI_DRAWER_DOCUMENTS, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.UI_NAV_POI, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.UI_NAV_SAVED_LOCATIONS, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.UI_DASHBOARD_WIFI, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.MAP_GOOGLE_NAV, COHORT_CLUSTER_V1);
        register(enumMap, VehicleFeature.WIFI_MIRROR_NAV_BOUND, COHORT_CLUSTER_V1);
        FEATURE_TO_COHORTS = Collections.unmodifiableMap(enumMap);
    }

    private SkuFeatureRegistry() {
    }

    private static Set<String> newConcurrentSkuSet(Set<String> set) {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        if (set != null) {
            keySetViewNewKeySet.addAll(set);
        }
        return keySetViewNewKeySet;
    }

    public static void setCohortSkus(String str, List<String> list) {
        if (str == null || str.isEmpty() || list == null || list.isEmpty()) {
            return;
        }
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            String strNormalizeSku = normalizeSku(it2.next());
            if (!strNormalizeSku.isEmpty()) {
                keySetViewNewKeySet.add(strNormalizeSku);
            }
        }
        if (keySetViewNewKeySet.isEmpty()) {
            return;
        }
        COHORTS.put(str, keySetViewNewKeySet);
    }

    private static void register(Map<VehicleFeature, Set<String>> map, VehicleFeature vehicleFeature, String... strArr) {
        map.put(vehicleFeature, Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr))));
    }

    public static String normalizeSku(String str) {
        if (str == null) {
            return "";
        }
        return str.trim().toUpperCase(Locale.US);
    }

    public static boolean isEnabled(VehicleFeature vehicleFeature, String str) {
        Set<String> set;
        if (vehicleFeature == null) {
            return false;
        }
        String strNormalizeSku = normalizeSku(str);
        if (!strNormalizeSku.isEmpty() && (set = FEATURE_TO_COHORTS.get(vehicleFeature)) != null && !set.isEmpty()) {
            Iterator<String> it2 = set.iterator();
            while (it2.hasNext()) {
                Set<String> set2 = COHORTS.get(it2.next());
                if (set2 != null) {
                    Iterator<String> it3 = set2.iterator();
                    while (it3.hasNext()) {
                        if (matchesRegisteredSku(strNormalizeSku, it3.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean matchesRegisteredSku(String str, String str2) {
        String strNormalizeSku = normalizeSku(str2);
        if (strNormalizeSku.length() == 6) {
            return str.startsWith(strNormalizeSku);
        }
        return str.equals(strNormalizeSku);
    }

    public static boolean isAnyFeatureEnabled(String str) {
        String strNormalizeSku = normalizeSku(str);
        if (strNormalizeSku.isEmpty()) {
            return false;
        }
        for (VehicleFeature vehicleFeature : VehicleFeature.values()) {
            if (isEnabled(vehicleFeature, strNormalizeSku)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnabled(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            try {
                return isEnabled(VehicleFeature.valueOf(str), str2);
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }
}
