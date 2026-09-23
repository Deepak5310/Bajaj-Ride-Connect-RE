package com.mappls.sdk.navigation.util;

import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.textinstructions.TextInstructionHelper;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegAnnotation;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationUtils {
    public static DistanceType getDistanceType() {
        return ((s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get()).name().equalsIgnoreCase("KILOMETERS_AND_METERS") ? DistanceType.METRIC : DistanceType.IMPERIAL;
    }

    public static int getManeuverID(float f) {
        if (f <= 45.0f) {
            return 65;
        }
        if (f <= 90.0f) {
            return 66;
        }
        if (f <= 135.0f) {
            return 67;
        }
        if (f <= 180.0f) {
            return 68;
        }
        if (f <= 225.0f) {
            return 69;
        }
        return f <= 270.0f ? 70 : 71;
    }

    public static List<RouteLeg> mergeRouteLegs(DirectionsRoute directionsRoute) {
        ArrayList arrayList = new ArrayList();
        if (directionsRoute.legs() == null || directionsRoute.legs().size() == 0) {
            return arrayList;
        }
        if (directionsRoute.legs().size() == 1) {
            arrayList.addAll(directionsRoute.legs());
            return arrayList;
        }
        List<RouteLeg> listLegs = directionsRoute.legs();
        RouteLeg.Builder builder = RouteLeg.builder();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        double dDoubleValue = 0.0d;
        double dDoubleValue2 = 0.0d;
        for (int i = 0; i < listLegs.size(); i++) {
            sb.append(listLegs.get(i).summary());
            if (i != listLegs.size() - 1) {
                sb.append(",");
            }
            dDoubleValue2 = listLegs.get(i).distance().doubleValue() + dDoubleValue2;
            dDoubleValue = listLegs.get(i).duration().doubleValue() + dDoubleValue;
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().congestion() != null) {
                arrayList3.addAll(listLegs.get(i).annotation().congestion());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().distance() != null) {
                arrayList4.addAll(listLegs.get(i).annotation().distance());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().duration() != null) {
                arrayList5.addAll(listLegs.get(i).annotation().duration());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().nodes() != null) {
                arrayList7.addAll(listLegs.get(i).annotation().nodes());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().maxspeed() != null) {
                arrayList8.addAll(listLegs.get(i).annotation().maxspeed());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().speed() != null) {
                arrayList9.addAll(listLegs.get(i).annotation().speed());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().speedLimit() != null) {
                arrayList10.addAll(listLegs.get(i).annotation().speedLimit());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().tollRoad() != null) {
                arrayList11.addAll(listLegs.get(i).annotation().tollRoad());
            }
            if (listLegs.get(i).annotation() != null && listLegs.get(i).annotation().baseDuration() != null) {
                arrayList6.addAll(listLegs.get(i).annotation().baseDuration());
            }
            arrayList2.addAll(listLegs.get(i).steps());
        }
        builder.distance(Double.valueOf(dDoubleValue2));
        builder.duration(Double.valueOf(dDoubleValue));
        builder.summary(sb.toString());
        builder.steps(arrayList2);
        builder.annotation(LegAnnotation.builder().congestion(arrayList3).distance(arrayList4).duration(arrayList5).maxspeed(arrayList8).nodes(arrayList7).speed(arrayList9).speedLimit(arrayList10).tollRoad(arrayList11).baseDuration(arrayList6).build());
        arrayList.add(builder.build());
        return arrayList;
    }

    public static AdviseInfo toAdviseInfo(NavigationRoute.a aVar, boolean z, long j, int i, boolean z2, boolean z3, boolean z4, double d, boolean z5, NavLocation navLocation, NavigationRoute navigationRoute, float f) {
        NavigationStep navigationStep;
        NavigationStep navigationStep2;
        NavigationStep navigationStep3;
        NavigationStep navigationStep4;
        NavigationStep navigationStep5;
        NavigationStep navigationStep6;
        NavigationStep navigationStep7;
        NavigationStep navigationStep8;
        NavigationStep navigationStep9;
        NavigationStep navigationStep10;
        long j2 = z ? 0L : j;
        AdviseInfo adviseInfo = new AdviseInfo();
        String shortInstruction = "";
        adviseInfo.setText((aVar == null || (navigationStep10 = aVar.a) == null) ? "" : navigationStep10.getDescriptionRoutePart());
        adviseInfo.setDistanceToNextAdvise(aVar != null ? aVar.b : 0);
        adviseInfo.setLeftDistance(i);
        adviseInfo.setLeftTime((int) j2);
        adviseInfo.setOnTollRoad(z2);
        adviseInfo.setLeftTimeStep((aVar == null || (navigationStep9 = aVar.a) == null || aVar.b <= 0 || navigationStep9.getAverageSpeed() <= 0.0f) ? 0 : (int) (aVar.b / aVar.a.getAverageSpeed()));
        long j3 = j2 * 1000;
        adviseInfo.setEtaInSecond((System.currentTimeMillis() + j3) / 1000);
        adviseInfo.setEta(DateFormat.getTimeInstance(3).format(new Date(System.currentTimeMillis() + j3)));
        adviseInfo.setRouteBeingRecalculated(!z && z3);
        adviseInfo.setuTurnSuggestion(!z && z4);
        adviseInfo.setOnRoute(z || z5);
        adviseInfo.setPosition((aVar == null || (navigationStep8 = aVar.a) == null) ? 0 : navigationStep8.getPosition());
        adviseInfo.setLocation(navLocation);
        adviseInfo.setDistanceFromRoute(d);
        adviseInfo.setInfo((aVar == null || (navigationStep7 = aVar.a) == null) ? null : navigationStep7.getExtraInfo());
        adviseInfo.setNextInstructionInfo((aVar == null || (navigationStep6 = aVar.a) == null) ? null : navigationStep6.getNextExtraInfo());
        adviseInfo.setNextInstructionText((aVar == null || (navigationStep5 = aVar.a) == null || navigationStep5.getNextExtraInfo() == null) ? null : TextInstructionHelper.getInstance().getInstruction((LegStep) aVar.a.getNextExtraInfo()));
        long maneuverIdLegacy = -1;
        adviseInfo.setManeuverID((aVar == null || (navigationStep4 = aVar.a) == null) ? -1L : navigationStep4.getManeuverID());
        if (aVar != null && (navigationStep3 = aVar.a) != null) {
            maneuverIdLegacy = navigationStep3.getManeuverIdLegacy();
        }
        adviseInfo.setManeuverIDLegacy(maneuverIdLegacy);
        if (aVar != null && (navigationStep2 = aVar.a) != null) {
            shortInstruction = navigationStep2.getShortInstruction();
        }
        adviseInfo.setShortText(shortInstruction);
        if (navigationRoute != null) {
            adviseInfo.setCurrentRoadSpeed(Double.valueOf(navigationRoute.currentRoadSpeed()));
            adviseInfo.setOverSpeed(navLocation.hasSpeed() && ((double) navLocation.getSpeed()) * 3.6d > adviseInfo.getCurrentRoadSpeed().doubleValue() && adviseInfo.getCurrentRoadSpeed().doubleValue() > 0.0d);
        }
        adviseInfo.setIntermediate(false);
        if (adviseInfo.getDistanceToNextAdvise() < f && adviseInfo.getManeuverID() == 8 && aVar != null && (navigationStep = aVar.a) != null) {
            if (navigationStep.isDestination()) {
                adviseInfo.setText("You have arrived");
            } else {
                adviseInfo.setIntermediate(true);
                adviseInfo.setText("You have reached your intermediate destination");
            }
        }
        if (z) {
            adviseInfo.setText("You have arrived");
            adviseInfo.setShortText("You have arrived");
            adviseInfo.setDistanceToNextAdvise(0);
            adviseInfo.setNextInstructionInfo(null);
            adviseInfo.setInfo(null);
            adviseInfo.setNextInstructionText(null);
            adviseInfo.setManeuverID(8L);
            adviseInfo.setManeuverIDLegacy(8L);
        }
        return adviseInfo;
    }
}
