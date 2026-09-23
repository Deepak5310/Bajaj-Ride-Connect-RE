package com.mappls.sdk.services.utils;

import android.content.Context;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.turf.TurfMeasurement;
import com.mappls.sdk.turf.TurfMisc;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class MapplsUtils {
    static Context context;
    static String text;

    private MapplsUtils() {
    }

    public static Context getSDKContext() {
        return context;
    }

    public static void setSDKContext(Context context2) {
        context = context2;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String str) {
        text = str;
        if (MapplsLMSManager.isInitialised()) {
            MapplsLMSManager.getInstance().setMapVersion(str);
        }
    }

    public static boolean isAccessTokenValid(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String join(CharSequence charSequence, Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        boolean z = true;
        if (objArr.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public static String formatCoordinate(double d) {
        return String.format(Locale.US, "%s", new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static String getDensityName() {
        Context context2 = context;
        if (context2 != null) {
            double d = context2.getResources().getDisplayMetrics().density;
            if (d <= 0.75d) {
                return "ldpi";
            }
            if (d <= 1.0d) {
                return "mdpi";
            }
            if (d <= 1.5d) {
                return "hdpi";
            }
            if (d <= 2.0d) {
                return "xhdpi";
            }
            if (d <= 3.0d) {
                return "xxhdpi";
            }
            if (d <= 4.0d) {
                return "xxxhdpi";
            }
        }
        return "xhdpi";
    }

    public static String formatCoordinate(double d, int i) {
        String str = "0." + new String(new char[i]).replace("\u0000", "0");
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        decimalFormat.applyPattern(str);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d);
    }

    public static String formatRadiuses(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return null;
        }
        String[] strArr = new String[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            if (dArr[i] == Double.POSITIVE_INFINITY) {
                strArr[i] = "unlimited";
            } else {
                strArr[i] = String.format(Locale.US, "%s", formatCoordinate(dArr[i]));
            }
        }
        return join(";", strArr);
    }

    public static String formatBearing(List<Double[]> list) {
        if (list.isEmpty()) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length == 0) {
                strArr[i] = "";
            } else {
                strArr[i] = String.format(Locale.US, "%s,%s", formatCoordinate(list.get(i)[0].doubleValue()), formatCoordinate(list.get(i)[1].doubleValue()));
            }
        }
        return join(";", strArr);
    }

    public static String formatDistributions(List<Integer[]> list) {
        if (list.isEmpty()) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length == 0) {
                strArr[i] = "";
            } else {
                strArr[i] = String.format(Locale.US, "%s,%s", formatCoordinate(list.get(i)[0].intValue()), formatCoordinate(list.get(i)[1].intValue()));
            }
        }
        return join(";", strArr);
    }

    public static String formatApproaches(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null) {
                strArr[i] = "";
            } else if (!str.equals(DirectionsCriteria.APPROACH_UNRESTRICTED) && !strArr[i].equals(DirectionsCriteria.APPROACH_CURB) && !strArr[i].isEmpty()) {
                return null;
            }
        }
        return join(";", strArr);
    }

    public static String formatWaypointNames(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                strArr[i] = "";
            }
        }
        return join(";", strArr);
    }

    public static List<CongestionDelayInfo> getCongestionDelayInfoFromRoute(DirectionsRoute directionsRoute, Point point, double d, int i) {
        return getCongestionDelayInfoFromRoute(directionsRoute, point, d, i, 6);
    }

    public static List<CongestionDelayInfo> getCongestionDelayInfoFromRoute(DirectionsRoute directionsRoute, Point point, double d, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (directionsRoute.legs() == null) {
            return arrayList;
        }
        int i3 = 0;
        RouteLeg routeLeg = directionsRoute.legs().get(0);
        if (routeLeg != null && routeLeg.annotation() != null && routeLeg.annotation().congestion() != null && routeLeg.annotation().baseDuration() != null && routeLeg.annotation().duration() != null) {
            double d2 = d > 50.0d ? 50.0d : d;
            int i4 = i;
            if (i4 < 1) {
                i4 = 1;
            }
            if (directionsRoute.geometry() != null) {
                List<Point> listDecode = PolylineUtils.decode(directionsRoute.geometry(), i2);
                Point point2 = (Point) TurfMisc.nearestPointOnLine(point, listDecode).geometry();
                for (int i5 = 0; i5 < listDecode.size(); i5++) {
                    if (listDecode.get(i5).equals(point2)) {
                        i3 = i5;
                        break;
                    }
                }
                if (i3 < listDecode.size() && !listDecode.get(i3).equals(listDecode.get(listDecode.size() - 1))) {
                    LineString lineStringLineSlice = TurfMisc.lineSlice(listDecode.get(i3), listDecode.get(listDecode.size() - 1), LineString.fromLngLats(listDecode));
                    if (TurfMeasurement.length(lineStringLineSlice, "kilometers") > d2) {
                        lineStringLineSlice = TurfMisc.lineSliceAlong(lineStringLineSlice, 0.0d, d2, "kilometers");
                    }
                    createDurationSegments(arrayList, directionsRoute, lineStringLineSlice, i3, i4);
                }
            }
        }
        return arrayList;
    }

    private static void createDurationSegments(List<CongestionDelayInfo> list, DirectionsRoute directionsRoute, LineString lineString, int i, int i2) {
        if (directionsRoute.legs() != null) {
            RouteLeg routeLeg = directionsRoute.legs().get(0);
            if (routeLeg == null || routeLeg.annotation() == null || routeLeg.annotation().congestion() == null || routeLeg.annotation().baseDuration() == null || routeLeg.annotation().duration() == null) {
                return;
            }
            List<String> listCongestion = routeLeg.annotation().congestion();
            List<Double> listBaseDuration = routeLeg.annotation().baseDuration();
            List<Double> listDuration = routeLeg.annotation().duration();
            ArrayList arrayList = new ArrayList();
            double dDoubleValue = 0.0d;
            for (int i3 = 0; i3 < lineString.coordinates().size(); i3++) {
                int i4 = i3 + i;
                if (listCongestion.size() > i4 && listDuration.size() > i4 && listBaseDuration.size() > i4) {
                    if (listCongestion.get(i4).equalsIgnoreCase("heavy") || listCongestion.get(i4).equalsIgnoreCase("severe")) {
                        dDoubleValue += listDuration.get(i4).doubleValue() - listBaseDuration.get(i4).doubleValue();
                        arrayList.add(lineString.coordinates().get(i3));
                    } else {
                        if (dDoubleValue >= i2 * 60) {
                            list.add(new CongestionDelayInfo(arrayList, (int) (dDoubleValue / 60.0d)));
                        }
                        arrayList = new ArrayList();
                        dDoubleValue = 0.0d;
                    }
                }
            }
        }
    }
}
