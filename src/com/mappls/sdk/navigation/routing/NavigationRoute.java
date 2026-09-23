package com.mappls.sdk.navigation.routing;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.model.CongestionInfo;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.model.JunctionApiResponse;
import com.mappls.sdk.navigation.textinstructions.TextInstructionHelper;
import com.mappls.sdk.navigation.util.NavigationUtils;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationRoute {
    private static double distanceClosestToIntermediate = 3000.0d;
    private static double distanceThresholdToIntermediate = 25.0d;
    public static float routeSpeed = 13.0f;
    private final List<com.mappls.sdk.navigation.routing.a> alarmInfo;
    protected com.mappls.sdk.navigation.d appMode;
    private final List<Double> baseDurations;
    protected List<NavigationStep> cacheAgreggatedDirections;
    protected int cacheCurrentTextDirectionInfo;
    private final List<String> congestion;
    private final List<CongestionInfo> congestionInfos;
    protected int currentDirectionInfo;
    protected int currentRoute;
    protected int currentWaypointGPX;
    private final List<NavigationStep> directions;
    public DirectionsRoute directionsRoute;
    private final List<Double> durations;
    private String end;
    private final int errorCode;
    private final String errorMessage;
    private final List<ReportDetails> events;
    private final int[] intermediatePoints;
    private List<LatLng> intermediates;
    private HashMap<String, String> junctionViewImage;
    private final List<Junction> junctionViews;
    protected int lastWaypointGPX;
    private final int[] listDistance;
    protected List<LocationPoint> locationPoints;
    private final List<NavLocation> locations;
    List<NavEvent> navEvents;
    protected int nextIntermediate;
    private final List<Long> nodes;
    protected b params;
    private final float routingTime;
    private final List<com.mappls.sdk.navigation.router.b> segments;
    private final List<Double> speedLimit;
    private NavLocation start;
    private final List<String> tollRoad;

    public static class a {
        public NavigationStep a;
        public int b;
        public boolean c;
        private int d;
    }

    public NavigationRoute(NavLocation navLocation, String str, List<LatLng> list, Context context, boolean z, List<LocationPoint> list2) {
        this.cacheCurrentTextDirectionInfo = -1;
        this.locationPoints = new ArrayList();
        this.currentDirectionInfo = 0;
        this.currentRoute = 0;
        this.nextIntermediate = 0;
        this.currentWaypointGPX = 0;
        this.lastWaypointGPX = 0;
        this.navEvents = new ArrayList();
        this.junctionViewImage = new HashMap<>();
        this.routingTime = 0.0f;
        b defaultParams = MapplsNavigationHelper.getInstance().getDefaultParams();
        this.params = defaultParams;
        defaultParams.a = navLocation;
        defaultParams.b = str;
        if (list2 != null) {
            this.locationPoints.addAll(list2);
        }
        this.start = navLocation;
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : list) {
            arrayList.add(new LatLng(latLng.getLatitude(), latLng.getLongitude()));
        }
        this.intermediates = arrayList;
        this.params.c = arrayList;
        this.end = str;
        this.navEvents = new ArrayList();
        this.junctionViews = new ArrayList();
        this.congestionInfos = new ArrayList();
        this.events = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.errorMessage = null;
        this.errorCode = -1;
        int[] iArr = new int[arrayList.size()];
        this.intermediatePoints = iArr;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.segments = new ArrayList();
        List<NavLocation> listUnmodifiableList = Collections.unmodifiableList(arrayList3);
        this.locations = listUnmodifiableList;
        int[] iArr2 = new int[arrayList3.size()];
        this.listDistance = iArr2;
        calculateIntermediateIndexes(context, listUnmodifiableList, arrayList, arrayList2, iArr);
        updateListDistanceTime(iArr2, listUnmodifiableList);
        this.appMode = com.mappls.sdk.navigation.d.i;
        ((NavigationStep) arrayList2.get(0)).getTurnType().a(navLocation.bearingTo((NavLocation) arrayList3.get(0)));
        List<NavigationStep> listUnmodifiableList2 = Collections.unmodifiableList(arrayList2);
        this.directions = listUnmodifiableList2;
        this.speedLimit = new ArrayList();
        this.nodes = new ArrayList();
        this.durations = new ArrayList();
        this.baseDurations = new ArrayList();
        this.congestion = new ArrayList();
        this.tollRoad = new ArrayList();
        updateDirectionsTime(listUnmodifiableList2, iArr2);
        removeUnnecessaryGoAhead(arrayList2);
        updatePosition(listUnmodifiableList2);
        this.alarmInfo = Collections.unmodifiableList(arrayList4);
    }

    public NavigationRoute(DirectionsRoute directionsRoute, List<NavLocation> list, List<NavigationStep> list2, b bVar, List<LocationPoint> list3, boolean z) {
        this(directionsRoute, list, list2, bVar, list3, z, null, null, null);
    }

    public NavigationRoute(DirectionsRoute directionsRoute, List<NavLocation> list, List<NavigationStep> list2, b bVar, List<LocationPoint> list3, boolean z, List<Junction> list4, List<ReportDetails> list5, List<CongestionInfo> list6) {
        List<String> arrayList;
        this.cacheCurrentTextDirectionInfo = -1;
        this.locationPoints = new ArrayList();
        this.currentDirectionInfo = 0;
        this.currentRoute = 0;
        this.nextIntermediate = 0;
        this.currentWaypointGPX = 0;
        this.lastWaypointGPX = 0;
        this.navEvents = new ArrayList();
        this.junctionViewImage = new HashMap<>();
        DirectionsRoute.Builder builder = directionsRoute.toBuilder();
        builder.legs(NavigationUtils.mergeRouteLegs(directionsRoute));
        this.directionsRoute = builder.build();
        this.routingTime = 0.0f;
        this.errorMessage = null;
        this.errorCode = -1;
        this.params = bVar;
        this.start = bVar.a;
        List<LatLng> list7 = bVar.c;
        this.intermediates = list7;
        this.end = bVar.b;
        int[] iArr = new int[list7 == null ? 0 : list7.size()];
        this.intermediatePoints = iArr;
        List<NavLocation> arrayList2 = list == null ? new ArrayList<>() : new ArrayList<>(list);
        ArrayList arrayList3 = list2 == null ? new ArrayList() : new ArrayList(list2);
        if (directionsRoute.distance() != null && directionsRoute.duration() != null) {
            routeSpeed = (float) (directionsRoute.distance().doubleValue() / directionsRoute.duration().doubleValue());
        }
        if (!arrayList2.isEmpty()) {
            checkForDuplicatePoints(arrayList2, arrayList3);
        }
        if (list3 != null) {
            this.locationPoints.addAll(list3);
        }
        if (z) {
            addMissingTurnsToRouteOSRM(arrayList2, arrayList3, bVar.e, bVar.d, bVar.g);
        }
        this.appMode = bVar.e;
        List<NavLocation> listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        this.locations = listUnmodifiableList;
        this.segments = new ArrayList();
        int[] iArr2 = new int[arrayList2.size()];
        this.listDistance = iArr2;
        updateListDistanceTime(iArr2, listUnmodifiableList);
        this.alarmInfo = new ArrayList();
        if (list5 != null) {
            this.events = list5;
        } else {
            this.events = new ArrayList();
        }
        this.junctionViews = (list4 == null || list4.size() <= 0) ? new ArrayList<>() : list4;
        this.congestionInfos = (list6 == null || list6.size() <= 0) ? new ArrayList<>() : list6;
        calculateIntermediateIndexes(bVar.d, listUnmodifiableList, bVar.c, arrayList3, iArr);
        List<NavigationStep> listUnmodifiableList2 = Collections.unmodifiableList(arrayList3);
        this.directions = listUnmodifiableList2;
        updateDirectionsTime(listUnmodifiableList2, iArr2);
        if (directionsRoute.legs() == null || directionsRoute.legs().get(0) == null || directionsRoute.legs().get(0).annotation() == null) {
            this.speedLimit = new ArrayList();
            this.nodes = new ArrayList();
            this.durations = new ArrayList();
            this.baseDurations = new ArrayList();
            this.congestion = new ArrayList();
            arrayList = new ArrayList<>();
        } else {
            this.speedLimit = directionsRoute.legs().get(0).annotation().speedLimit();
            this.nodes = directionsRoute.legs().get(0).annotation().nodes();
            this.durations = directionsRoute.legs().get(0).annotation().duration();
            this.baseDurations = directionsRoute.legs().get(0).annotation().baseDuration();
            this.congestion = directionsRoute.legs().get(0).annotation().congestion();
            arrayList = directionsRoute.legs().get(0).annotation().tollRoad();
        }
        this.tollRoad = arrayList;
        setInternalEvents(this.events);
        Point.fromLngLat(bVar.a.getLongitude(), bVar.a.getLatitude());
    }

    public NavigationRoute(String str) {
        this.cacheCurrentTextDirectionInfo = -1;
        this.locationPoints = new ArrayList();
        this.currentDirectionInfo = 0;
        this.currentRoute = 0;
        this.nextIntermediate = 0;
        this.currentWaypointGPX = 0;
        this.lastWaypointGPX = 0;
        this.navEvents = new ArrayList();
        this.junctionViewImage = new HashMap<>();
        this.errorMessage = str;
        this.routingTime = 0.0f;
        this.errorCode = 0;
        this.intermediatePoints = new int[0];
        this.locations = new ArrayList();
        this.segments = new ArrayList();
        this.listDistance = new int[0];
        this.directions = new ArrayList();
        this.alarmInfo = new ArrayList();
        this.events = new ArrayList();
        this.junctionViews = new ArrayList();
        this.congestionInfos = new ArrayList();
        this.speedLimit = new ArrayList();
        this.tollRoad = new ArrayList();
        this.nodes = new ArrayList();
        this.durations = new ArrayList();
        this.baseDurations = new ArrayList();
        this.congestion = new ArrayList();
    }

    public NavigationRoute(String str, int i) {
        this.cacheCurrentTextDirectionInfo = -1;
        this.locationPoints = new ArrayList();
        this.currentDirectionInfo = 0;
        this.currentRoute = 0;
        this.nextIntermediate = 0;
        this.currentWaypointGPX = 0;
        this.lastWaypointGPX = 0;
        this.navEvents = new ArrayList();
        this.junctionViewImage = new HashMap<>();
        this.errorMessage = str;
        this.routingTime = 0.0f;
        this.errorCode = i;
        this.intermediatePoints = new int[0];
        this.locations = new ArrayList();
        this.segments = new ArrayList();
        this.listDistance = new int[0];
        this.directions = new ArrayList();
        this.alarmInfo = new ArrayList();
        this.events = new ArrayList();
        this.junctionViews = new ArrayList();
        this.congestionInfos = new ArrayList();
        this.speedLimit = new ArrayList();
        this.tollRoad = new ArrayList();
        this.nodes = new ArrayList();
        this.durations = new ArrayList();
        this.baseDurations = new ArrayList();
        this.congestion = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0137  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0158, code lost:
    
        if (r27 != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void addMissingTurnsToRoute(List<NavLocation> list, List<NavigationStep> list2, NavLocation navLocation, LatLng latLng, com.mappls.sdk.navigation.d dVar, Context context, boolean z) {
        List list3;
        int i;
        int i2;
        int i3;
        String string;
        int i4;
        com.mappls.sdk.navigation.router.c cVarA;
        com.mappls.sdk.navigation.router.c cVarA2;
        int i5;
        if (list.isEmpty()) {
            return;
        }
        float fD = dVar.d();
        int iE = dVar.e();
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[list.size()];
        iArr[list.size() - 1] = 0;
        for (int size = list.size() - 1; size > 0; size--) {
            int i6 = size - 1;
            int iRound = Math.round(list.get(i6).distanceTo(list.get(size)));
            iArr[i6] = iRound;
            iArr[i6] = iRound + iArr[size];
        }
        NavigationStep navigationStep = new NavigationStep(fD, com.mappls.sdk.navigation.router.c.h());
        navigationStep.routePointOffset = 0;
        navigationStep.setDescriptionRoute(context.getString(R.string.mappls_navigation_route_head));
        arrayList.add(navigationStep);
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        float fBearingTo = 0.0f;
        while (i7 < list.size() - 1) {
            int i12 = i7 + 1;
            NavLocation navLocation2 = list.get(i12);
            NavLocation navLocation3 = list.get(i7);
            float fBearingTo2 = navLocation3.bearingTo(navLocation2);
            while (i9 < i7 - 1) {
                int i13 = i9 + 1;
                if (list.get(i13).distanceTo(navLocation3) <= 70.0f) {
                    break;
                } else {
                    i9 = i13;
                }
            }
            if (i10 == 0) {
                fBearingTo = list.get(i9).bearingTo(navLocation3);
                i2 = i7;
            } else {
                i2 = i11;
            }
            float f = fBearingTo - fBearingTo2;
            while (f < 0.0f) {
                f += 360.0f;
            }
            while (f > 360.0f) {
                f -= 360.0f;
            }
            int iDistanceTo = (int) (list.get(i7).distanceTo(list.get(i12)) + i10);
            if (i7 >= list.size() - 1 || iDistanceTo >= iE) {
                if (f <= 30.0f || f >= 330.0f) {
                    i3 = 0;
                    i7 = i9;
                } else {
                    if (f < 60.0f) {
                        com.mappls.sdk.navigation.router.c cVarA3 = com.mappls.sdk.navigation.router.c.a(2, z);
                        string = context.getString(R.string.mappls_route_tsll);
                        cVarA = cVarA3;
                        i3 = 0;
                    } else {
                        if (f < 120.0f) {
                            i3 = 0;
                            cVarA2 = com.mappls.sdk.navigation.router.c.a(0, z);
                            i5 = R.string.mappls_route_tl;
                        } else {
                            i3 = 0;
                            if (f >= 150.0f) {
                                if (f < 180.0f) {
                                    if (z) {
                                        cVarA = com.mappls.sdk.navigation.router.c.a(1, z);
                                        string = context.getString(R.string.mappls_route_tshl);
                                    }
                                } else if (f != 180.0f) {
                                    if (f >= 210.0f) {
                                        if (f >= 240.0f) {
                                            if (f < 300.0f) {
                                                string = context.getString(R.string.mappls_route_tr);
                                                i4 = 3;
                                            } else {
                                                string = context.getString(R.string.mappls_route_tslr);
                                                i4 = 5;
                                            }
                                        }
                                        cVarA = com.mappls.sdk.navigation.router.c.a(i4, z);
                                    }
                                    string = context.getString(R.string.mappls_route_tshr);
                                    i4 = 4;
                                    cVarA = com.mappls.sdk.navigation.router.c.a(i4, z);
                                }
                                cVarA2 = com.mappls.sdk.navigation.router.c.a(6, z);
                                i5 = R.string.mappls_route_tu;
                            } else {
                                cVarA = com.mappls.sdk.navigation.router.c.a(1, z);
                                string = context.getString(R.string.mappls_route_tshl);
                            }
                        }
                        String string2 = context.getString(i5);
                        cVarA = cVarA2;
                        string = string2;
                    }
                    navigationStep.distance = iArr[i8] - iArr[i7];
                    cVarA.a(360.0f - f);
                    navigationStep = new NavigationStep(fD, cVarA);
                    navigationStep.setDescriptionRoute(string);
                    navigationStep.routePointOffset = i2;
                    arrayList.add(navigationStep);
                    i8 = i2;
                }
                i10 = i3;
                i9 = i7;
            } else {
                i10 = iDistanceTo;
            }
            i11 = i2;
            i7 = i12;
        }
        int expectedTime = 0;
        navigationStep.distance = iArr[i8];
        if (list2.isEmpty()) {
            list3 = list2;
            list3.addAll(arrayList);
        } else {
            list3 = list2;
            int i14 = 0;
            int i15 = 0;
            while (i14 <= list2.size() && i15 < arrayList.size()) {
                while (i15 < arrayList.size()) {
                    if (i14 < list2.size()) {
                        NavigationStep navigationStep2 = (NavigationStep) list3.get(i14);
                        int i16 = ((NavigationStep) arrayList.get(i15)).routePointOffset;
                        int i17 = navigationStep2.routePointOffset;
                        i = iArr[i17];
                        if (list.get(i16).distanceTo(list.get(i17)) >= 100.0f) {
                            if (((NavigationStep) arrayList.get(i15)).routePointOffset > navigationStep2.routePointOffset) {
                                break;
                            }
                        } else {
                            continue;
                        }
                        i15++;
                    } else {
                        i = 0;
                    }
                    NavigationStep navigationStep3 = (NavigationStep) arrayList.get(i15);
                    if (i14 > 0) {
                        navigationStep3.setAverageSpeed(((NavigationStep) list3.get(i14 - 1)).getAverageSpeed());
                    }
                    navigationStep3.distance = iArr[navigationStep3.routePointOffset] - i;
                    if (i14 < list2.size()) {
                        list3.add(i14, navigationStep3);
                    } else {
                        list3.add(navigationStep3);
                    }
                    i14++;
                    i15++;
                }
                i14++;
            }
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ((NavigationStep) list3.get(size2)).afterLeftTime = expectedTime;
            expectedTime = (int) (((NavigationStep) list3.get(size2)).getExpectedTime() + ((double) expectedTime));
        }
    }

    private static void attachAlarmInfo(List<com.mappls.sdk.navigation.routing.a> list, com.mappls.sdk.navigation.router.b bVar, int i, int i2) {
    }

    private static void calculateIntermediateIndexes(Context context, List<NavLocation> list, List<LatLng> list2, List<NavigationStep> list3, int[] iArr) {
        if (list2 == null || list3 == null) {
            return;
        }
        int[] iArr2 = new int[list2.size()];
        int i = 0;
        int i2 = 0;
        while (i2 < list2.size()) {
            double d = distanceClosestToIntermediate;
            LatLng latLng = list2.get(i2);
            for (int i3 = i2 == 0 ? 0 : iArr2[i2 - 1]; i3 < list.size(); i3++) {
                double distanceToLocation = getDistanceToLocation(list, latLng, i3);
                if (((int) distanceToLocation) != 0) {
                    double d2 = distanceThresholdToIntermediate;
                    if (distanceToLocation > d2 && d < d2) {
                        break;
                    }
                } else {
                    iArr2[i2] = i3;
                    d = distanceToLocation;
                }
            }
            if (d == distanceClosestToIntermediate) {
                return;
            } else {
                i2++;
            }
        }
        for (int i4 = 0; i < list2.size() && i4 < list3.size(); i4++) {
            int i5 = list3.get(i4).routePointOffset;
            int i6 = iArr2[i];
            if (i5 >= i6) {
                if (i5 > i6 && getDistanceToLocation(list, list2.get(i), i5) > 50.0d) {
                    NavigationStep navigationStep = list3.get(i4);
                    NavigationStep navigationStep2 = new NavigationStep(list3.get(i4).getAverageSpeed(), com.mappls.sdk.navigation.router.c.h());
                    navigationStep2.setRef(navigationStep.getRef());
                    navigationStep2.setStreetName(navigationStep.getStreetName());
                    navigationStep2.setDestinationName(navigationStep.getDestinationName());
                    navigationStep2.routePointOffset = iArr2[i];
                    navigationStep2.setDescriptionRoute(context.getString(R.string.mappls_navigation_route_head));
                    list3.add(i4, navigationStep2);
                }
                iArr[i] = i4;
                i++;
            }
        }
    }

    public static void checkForDuplicatePoints(List<NavLocation> list, List<NavigationStep> list2) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            if (list.get(i).distanceTo(list.get(i2)) == 0.0f) {
                list.remove(i);
                if (list2 != null) {
                    for (NavigationStep navigationStep : list2) {
                        int i3 = navigationStep.routePointOffset;
                        if (i3 > i) {
                            navigationStep.routePointOffset = i3 - 1;
                        }
                    }
                }
            } else {
                i = i2;
            }
        }
    }

    private List<DirectionsRoute> generateRouteOptions(DirectionsResponse directionsResponse, MapplsDirections mapplsDirections) {
        List<DirectionsRoute> listRoutes = directionsResponse.routes();
        ArrayList arrayList = new ArrayList();
        Iterator<DirectionsRoute> it2 = listRoutes.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBuilder().routeOptions(RouteOptions.builder().profile(mapplsDirections.profile()).resource(mapplsDirections.resource()).baseUrl(mapplsDirections.baseUrl()).coordinates(mapplsDirections.coordinates()).waypointIndices(mapplsDirections.waypointIndices()).waypointNames(mapplsDirections.waypointNames()).waypointTargets(mapplsDirections.waypointTargets()).lessVerbose(mapplsDirections.lessVerbose()).annotations(mapplsDirections.annotation()).approaches(mapplsDirections.approaches()).bearings(mapplsDirections.bearing()).alternatives(mapplsDirections.alternatives()).language(mapplsDirections.language()).radiuses(mapplsDirections.radius()).user(mapplsDirections.user()).bannerInstructions(mapplsDirections.bannerInstructions()).geometries(mapplsDirections.geometries()).overview(mapplsDirections.overview()).steps(mapplsDirections.steps()).exclude(mapplsDirections.exclude()).walkingOptions(mapplsDirections.walkingOptions()).routeRefresh(mapplsDirections.routeRefresh()).deviceID(mapplsDirections.deviceId()).requestUuid(directionsResponse.uuid()).sessionId(directionsResponse.sessionId()).isSort(mapplsDirections.isSort()).routeType(mapplsDirections.routeType()).roundaboutExits(mapplsDirections.roundaboutExits()).build()).build());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0171  */
    /* JADX WARN: Code duplicated, block: B:42:0x0173  */
    private DirectionsRoute getDirectionsRoute(String str, String str2, Boolean bool) {
        RouteLeg.Builder builder;
        NavLocation navLocation;
        int i;
        LineString lineStringLineSlice;
        String polyline;
        boolean z;
        if (this.errorMessage != null) {
            return null;
        }
        DirectionsRoute directionsRoute = this.directionsRoute;
        if (directionsRoute != null) {
            return directionsRoute;
        }
        DirectionsRoute.Builder builder2 = DirectionsRoute.builder();
        builder2.distance(Double.valueOf(getWholeDistance()));
        builder2.duration(Double.valueOf(getLeftTime(getImmutableAllLocations().get(0))));
        List<NavLocation> immutableAllLocations = getImmutableAllLocations();
        String str3 = str.equalsIgnoreCase("walking") ? "walking" : "driving";
        ArrayList arrayList = new ArrayList();
        for (NavLocation navLocation2 : immutableAllLocations) {
            arrayList.add(Point.fromLngLat(navLocation2.getLongitude(), navLocation2.getLatitude()));
        }
        int i2 = 6;
        builder2.geometry(str2.equalsIgnoreCase("polyline6") ? PolylineUtils.encode(arrayList, 6) : PolylineUtils.encode(arrayList, 5));
        ArrayList arrayList2 = new ArrayList();
        RouteLeg.Builder builder3 = RouteLeg.builder();
        builder3.duration(Double.valueOf(getLeftTime(getImmutableAllLocations().get(0))));
        builder3.distance(Double.valueOf(getWholeDistance()));
        if (bool == null || bool.booleanValue()) {
            ArrayList arrayList3 = new ArrayList();
            List<NavigationStep> immutableAllDirections = getImmutableAllDirections();
            int i3 = 0;
            while (i3 < immutableAllDirections.size()) {
                NavigationStep navigationStep = immutableAllDirections.get(i3);
                NavLocation navLocation3 = getImmutableAllLocations().get(navigationStep.routePointOffset);
                int i4 = i3 + 1;
                if (i4 < immutableAllDirections.size()) {
                    NavLocation navLocation4 = getImmutableAllLocations().get(immutableAllDirections.get(i4).routePointOffset);
                    if (navLocation3.getLatitude() == navLocation4.getLatitude() && navLocation3.getLongitude() == navLocation4.getLongitude()) {
                        navLocation = navLocation3;
                        i4 = i4;
                        immutableAllDirections = immutableAllDirections;
                        builder3 = builder3;
                        polyline = null;
                    } else {
                        navLocation = navLocation3;
                        lineStringLineSlice = TurfMisc.lineSlice(Point.fromLngLat(navLocation3.getLongitude(), navLocation3.getLatitude()), Point.fromLngLat(navLocation4.getLongitude(), navLocation4.getLatitude()), LineString.fromLngLats(arrayList));
                        i = 6;
                    }
                    if (i3 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    arrayList3.add(navigationStep.getLegStep(str3, navLocation, polyline, false, z));
                    builder3 = builder3;
                    i3 = i4;
                    immutableAllDirections = immutableAllDirections;
                    i2 = 6;
                } else {
                    navLocation = navLocation3;
                    i = i2;
                    lineStringLineSlice = TurfMisc.lineSlice(Point.fromLngLat(navLocation.getLongitude(), navLocation.getLatitude()), (Point) arrayList.get(arrayList.size() - 1), LineString.fromLngLats(arrayList));
                }
                polyline = lineStringLineSlice.toPolyline(i);
                if (i3 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList3.add(navigationStep.getLegStep(str3, navLocation, polyline, false, z));
                builder3 = builder3;
                i3 = i4;
                immutableAllDirections = immutableAllDirections;
                i2 = 6;
            }
            ArrayList arrayList4 = new ArrayList();
            Point point = (Point) arrayList.get(arrayList.size() - 1);
            arrayList4.add(point);
            arrayList4.add(point);
            arrayList3.add(new NavigationStep(1.0f, com.mappls.sdk.navigation.router.c.a(8, true)).getLegStep(str3, getImmutableAllLocations().get(getImmutableAllLocations().size() - 1), LineString.fromLngLats(arrayList4).toPolyline(6), true, false));
            builder = builder3;
            builder.steps(arrayList3);
        } else {
            builder = builder3;
        }
        arrayList2.add(builder.build());
        builder2.legs(arrayList2);
        return builder2.build();
    }

    private static double getDistanceToLocation(List<NavLocation> list, LatLng latLng, int i) {
        return com.mappls.sdk.navigation.util.d.a(latLng, list.get(i).getLatitude(), list.get(i).getLongitude());
    }

    private int getListDistance(int i) {
        int[] iArr = this.listDistance;
        if (iArr.length > i) {
            return iArr[i];
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int getTurnType(String str, String str2) {
        if (str.equalsIgnoreCase("arrive") || str.equalsIgnoreCase("depart")) {
            return str.equalsIgnoreCase("arrive") ? 8 : 7;
        }
        str2.getClass();
        str2.hashCode();
        byte b = -1;
        switch (str2.hashCode()) {
            case -2016367553:
                if (str2.equals("slight right")) {
                    b = 0;
                }
                break;
            case -1531469187:
                if (str2.equals("sharp left")) {
                    b = 1;
                }
                break;
            case -757963388:
                if (str2.equals("slight left")) {
                    b = 2;
                }
                break;
            case -225243546:
                if (str2.equals("sharp right")) {
                    b = 3;
                }
                break;
            case 3317767:
                if (str2.equals("left")) {
                    b = 4;
                }
                break;
            case 108511772:
                if (str2.equals("right")) {
                    b = 5;
                }
                break;
            case 111623794:
                if (str2.equals("uturn")) {
                    b = 6;
                }
                break;
            case 1787472634:
                if (str2.equals("straight")) {
                    b = 7;
                }
                break;
        }
        switch (b) {
            case 0:
                return 5;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
            default:
                return 0;
            case 5:
                return 3;
            case 6:
                return 6;
            case 7:
                return 7;
        }
    }

    private static void introduceFirstPointAndLastPoint(List<NavLocation> list, List<NavigationStep> list2, List<com.mappls.sdk.navigation.router.b> list3, NavLocation navLocation, LatLng latLng, NavigationApplication navigationApplication) {
        int i;
        if (!list.isEmpty() && list.get(0).distanceTo(navLocation) > 50.0f) {
            list.add(0, navLocation);
            if (list3 != null) {
                list3.add(0, list3.get(0));
            }
            if (list2 != null && !list2.isEmpty()) {
                Iterator<NavigationStep> it2 = list2.iterator();
                while (it2.hasNext()) {
                    it2.next().routePointOffset++;
                }
                NavigationStep navigationStep = new NavigationStep(list2.get(0).getAverageSpeed(), com.mappls.sdk.navigation.router.c.h());
                navigationStep.routePointOffset = 0;
                list2.add(0, navigationStep);
            }
            checkForDuplicatePoints(list, list2);
        }
        NavigationStep navigationStep2 = list2.size() > 0 ? list2.get(list2.size() - 1) : null;
        if ((navigationStep2 == null || navigationStep2.routePointOffset < list.size() - 1) && list.size() - 1 > 0) {
            NavLocation navLocation2 = list.get(list.size() - 2);
            float fBearingTo = navLocation2.bearingTo(list.get(list.size() - 1));
            float[] fArr = new float[2];
            NavLocation.distanceBetween(navLocation2.getLatitude(), navLocation2.getLongitude(), latLng.getLatitude(), latLng.getLongitude(), fArr);
            double dA = com.mappls.sdk.navigation.util.d.a(fBearingTo, fArr[1]);
            if (Math.abs(dA) > 10.0d) {
                i = dA > 0.0d ? 9 : 10;
            } else {
                i = 7;
            }
            NavigationStep navigationStep3 = new NavigationStep(navigationStep2 != null ? navigationStep2.getAverageSpeed() : 1.0f, com.mappls.sdk.navigation.router.c.a(i, false));
            navigationStep3.distance = 0;
            navigationStep3.afterLeftTime = 0;
            navigationStep3.routePointOffset = list.size() - 1;
            list2.add(navigationStep3);
        }
    }

    static /* synthetic */ void lambda$setInternalEvents$0(List list) {
        if (MapplsNavigationHelper.getInstance().getNavigationEventLoadedListener() != null) {
            MapplsNavigationHelper.getInstance().getNavigationEventLoadedListener().onNavigationEventsLoaded(list);
        }
    }

    private void removeUnnecessaryGoAhead(List<NavigationStep> list) {
        if (list != null) {
            int i = 1;
            if (list.size() > 1) {
                while (i < list.size()) {
                    NavigationStep navigationStep = list.get(i);
                    if (navigationStep.getTurnType().c() == 7) {
                        NavigationStep navigationStep2 = list.get(i - 1);
                        int i2 = navigationStep2.distance;
                        navigationStep2.setAverageSpeed((navigationStep.distance + i2) / ((navigationStep.distance / navigationStep.getAverageSpeed()) + (i2 / navigationStep2.getAverageSpeed())));
                        navigationStep2.setDistance(navigationStep2.distance + navigationStep.distance);
                        list.remove(i);
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public static String toString(com.mappls.sdk.navigation.router.c cVar, Context context, boolean z) {
        if (cVar.e()) {
            return z ? context.getString(R.string.mappls_route_roundabout_short, Integer.valueOf(cVar.a())) : context.getString(R.string.mappls_route_roundabout, Integer.valueOf(cVar.a()));
        }
        if (cVar.c() == 7) {
            return context.getString(R.string.mappls_navigation_route_head);
        }
        if (cVar.c() == 2) {
            return context.getString(R.string.mappls_route_tsll);
        }
        if (cVar.c() == 11) {
            return context.getString(R.string.mappls_route_tl);
        }
        if (cVar.c() == 1) {
            return context.getString(R.string.mappls_route_tshl);
        }
        if (cVar.c() == 5) {
            return context.getString(R.string.mappls_route_tslr);
        }
        if (cVar.c() == 3) {
            return context.getString(R.string.mappls_route_tr);
        }
        if (cVar.c() == 4) {
            return context.getString(R.string.mappls_route_tshr);
        }
        if (cVar.c() != 6 && cVar.c() != 41) {
            if (cVar.c() == 9) {
                return context.getString(R.string.mappls_route_kl);
            }
            return cVar.c() == 10 ? context.getString(R.string.mappls_route_kr) : "";
        }
        return context.getString(R.string.mappls_route_tu);
    }

    private static void updateDirectionsTime(List<NavigationStep> list, int[] iArr) {
        int expectedTime = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).afterLeftTime = expectedTime;
            list.get(size).distance = iArr[list.get(size).routePointOffset];
            if (size < list.size() - 1) {
                list.get(size).distance -= iArr[list.get(size + 1).routePointOffset];
            }
            expectedTime = (int) (list.get(size).getExpectedTime() + ((double) expectedTime));
        }
    }

    private static void updateListDistanceTime(int[] iArr, List<NavLocation> list) {
        if (iArr.length > 0) {
            iArr[list.size() - 1] = 0;
            for (int size = list.size() - 1; size > 0; size--) {
                int i = size - 1;
                int iRound = Math.round(list.get(i).distanceTo(list.get(size)));
                iArr[i] = iRound;
                iArr[i] = iRound + iArr[size];
            }
        }
    }

    private void updatePosition(List<NavigationStep> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            NavigationStep navigationStep = list.get(i);
            if (i > 0) {
                navigationStep.setPosition(i - 1);
            }
        }
    }

    protected void addMissingTurnsToRouteOSRM(List<NavLocation> list, List<NavigationStep> list2, com.mappls.sdk.navigation.d dVar, Context context, boolean z) {
        ArrayList arrayList;
        List<LegStep> list3;
        if (list.isEmpty()) {
            return;
        }
        int i = 0;
        List<LegStep> listSteps = this.directionsRoute.legs().get(0).steps();
        if (routeSpeed <= 0.0f) {
            dVar.getClass();
        }
        ArrayList arrayList2 = new ArrayList();
        int[] iArr = new int[list.size()];
        int i2 = 1;
        iArr[list.size() - 1] = 0;
        for (int size = list.size() - 1; size > 0; size--) {
            int i3 = size - 1;
            int iRound = Math.round(list.get(i3).distanceTo(list.get(size)));
            iArr[i3] = iRound;
            iArr[i3] = iRound + iArr[size];
        }
        list.clear();
        NavigationStep navigationStep = new NavigationStep((float) (listSteps.get(0).distance() / listSteps.get(0).duration()), com.mappls.sdk.navigation.router.c.h());
        navigationStep.routePointOffset = 0;
        int i4 = 6;
        if (listSteps.size() - 1 > 0) {
            List<Point> listCoordinates = LineString.fromPolyline(listSteps.get(0).geometry(), 6).coordinates();
            int i5 = 0;
            while (i5 < listCoordinates.size()) {
                NavLocation navLocation = new NavLocation("router");
                navLocation.setLatitude(listCoordinates.get(i5).latitude());
                navLocation.setLongitude(listCoordinates.get(i5).longitude());
                list.add(navLocation);
                i5++;
                arrayList2 = arrayList2;
            }
            arrayList = arrayList2;
            NavLocation navLocation2 = list.get(0);
            NavigationStep navigationStep2 = new NavigationStep((float) (listSteps.get(0).distance() / listSteps.get(0).duration()), com.mappls.sdk.navigation.router.c.h());
            navigationStep2.setNavLocation(navLocation2);
            navigationStep2.setDescriptionRoute(TextInstructionHelper.getInstance().getInstruction(listSteps.get(0)));
            navigationStep2.setStreetName(listSteps.get(0).name());
            navigationStep2.routePointOffset = 0;
            navigationStep2.setPosition(0);
            navigationStep2.setExtraInfo(listSteps.get(0));
            navigationStep2.setNextExtraInfo(listSteps.get(1));
            try {
                if (listSteps.get(0) != null && listSteps.get(0).maneuver().type() != null) {
                    LegStep legStep = listSteps.get(0);
                    if (!legStep.maneuver().type().equalsIgnoreCase("roundabout")) {
                        navigationStep2.setShortInstruction(TextInstructionHelper.getInstance().getShortInstruction(legStep));
                    }
                    navigationStep2.setManeuverID(TextInstructionHelper.getInstance().getManeuverId(legStep).intValue());
                    navigationStep2.setManeuverIdLegacy(TextInstructionHelper.getInstance().getManeuverIdLegacy(legStep).intValue());
                }
            } catch (Exception e) {
                NavigationLogger.d(e);
            }
            navigationStep = navigationStep2;
        } else {
            arrayList = arrayList2;
            navigationStep.setDescriptionRoute(context.getString(R.string.mappls_navigation_route_head));
            navigationStep.setManeuverID(-1);
            navigationStep.setManeuverIdLegacy(-1);
            navigationStep.setPosition(0);
        }
        ArrayList arrayList3 = arrayList;
        arrayList3.add(navigationStep);
        List<LegStep> listSubList = listSteps.subList(1, listSteps.size());
        int i6 = 0;
        while (i6 < listSubList.size()) {
            try {
                LegStep legStep2 = listSubList.get(i6);
                LineString lineStringFromPolyline = LineString.fromPolyline(legStep2.geometry(), i4);
                List<Point> listSubList2 = lineStringFromPolyline.coordinates().subList(i2, lineStringFromPolyline.coordinates().size());
                int size2 = list.size() - i2;
                if (listSubList2 == null || listSubList2.size() <= 0) {
                    list3 = listSubList;
                    List<Point> listCoordinates2 = lineStringFromPolyline.coordinates();
                    if (listCoordinates2 != null && listCoordinates2.size() > 0) {
                        NavLocation navLocation3 = new NavLocation("router");
                        navLocation3.setLatitude(listCoordinates2.get(0).latitude());
                        navLocation3.setLongitude(listCoordinates2.get(0).longitude());
                        list.add(navLocation3);
                    }
                } else {
                    int i7 = i;
                    while (i7 < listSubList2.size()) {
                        NavLocation navLocation4 = new NavLocation("router");
                        navLocation4.setLatitude(listSubList2.get(i7).latitude());
                        navLocation4.setLongitude(listSubList2.get(i7).longitude());
                        list.add(navLocation4);
                        i7++;
                        listSubList = listSubList;
                    }
                    list3 = listSubList;
                }
                if (list.size() <= size2) {
                    listSubList = list3;
                } else {
                    NavLocation navLocation5 = list.get(size2);
                    String instruction = TextInstructionHelper.getInstance().getInstruction(legStep2);
                    navigationStep.distance = (int) legStep2.distance();
                    com.mappls.sdk.navigation.router.c cVarA = com.mappls.sdk.navigation.router.c.a(0, z);
                    try {
                        cVarA = legStep2.maneuver().type().equalsIgnoreCase("roundabout") ? com.mappls.sdk.navigation.router.c.a(legStep2.maneuver().exit() != null ? legStep2.maneuver().exit().intValue() : 0, legStep2.maneuver().degree() != null ? legStep2.maneuver().degree().intValue() : 0.0f, z) : com.mappls.sdk.navigation.router.c.a(getTurnType(legStep2.maneuver().type(), legStep2.maneuver().modifier()), z);
                    } catch (Exception e2) {
                        NavigationLogger.e(e2);
                    }
                    String strName = legStep2.name();
                    NavigationStep navigationStep3 = new NavigationStep((float) (legStep2.distance() / legStep2.duration()), cVarA);
                    navigationStep3.setNavLocation(navLocation5);
                    navigationStep3.setDescriptionRoute(instruction);
                    navigationStep3.setStreetName(strName);
                    navigationStep3.routePointOffset = size2;
                    int i8 = i6 + 1;
                    navigationStep3.setPosition(i8);
                    if (i6 == list3.size() - 1) {
                        navigationStep3.setDestination(true);
                    }
                    try {
                        if (!legStep2.maneuver().type().equalsIgnoreCase("roundabout")) {
                            navigationStep3.setShortInstruction(TextInstructionHelper.getInstance().getShortInstruction(legStep2));
                        }
                        navigationStep3.setManeuverID(TextInstructionHelper.getInstance().getManeuverId(legStep2).intValue());
                        navigationStep3.setManeuverIdLegacy(TextInstructionHelper.getInstance().getManeuverIdLegacy(legStep2).intValue());
                        if (!navigationStep3.isDestination() && navigationStep3.getManeuverID() == 8) {
                            navigationStep3.setDescriptionRoute(navigationStep3.getDescriptionRoutePart().replaceAll(FirebaseAnalytics.Param.DESTINATION, "Intermediate destination"));
                        }
                    } catch (Exception e3) {
                        NavigationLogger.d(e3);
                    }
                    navigationStep3.setExtraInfo(legStep2);
                    if (i8 < list3.size()) {
                        listSubList = list3;
                        navigationStep3.setNextExtraInfo(listSubList.get(i8));
                    } else {
                        listSubList = list3;
                    }
                    arrayList3.add(navigationStep3);
                    navigationStep = navigationStep3;
                }
                i6++;
                i = 0;
                i2 = 1;
                i4 = 6;
            } catch (Exception e4) {
                NavigationLogger.e(e4);
            }
        }
        if (list2.isEmpty()) {
            list2.addAll(arrayList3);
        }
        int expectedTime = 0;
        for (int size3 = list2.size() - 1; size3 >= 0; size3--) {
            list2.get(size3).afterLeftTime = expectedTime;
            expectedTime = (int) (list2.get(size3).getExpectedTime() + ((double) expectedTime));
        }
    }

    public double currentBaseDuration() {
        List<Double> list = this.baseDurations;
        if (list != null) {
            int size = list.size();
            int i = this.currentRoute;
            if (size > i) {
                return this.baseDurations.get(i).doubleValue();
            }
        }
        return 0.0d;
    }

    public double currentDuration() {
        List<Double> list = this.durations;
        if (list != null) {
            int size = list.size();
            int i = this.currentRoute;
            if (size > i) {
                return this.durations.get(i).doubleValue();
            }
        }
        return 0.0d;
    }

    public double currentNode() {
        List<Long> list = this.nodes;
        if (list != null) {
            int size = list.size();
            int i = this.currentRoute;
            if (size > i) {
                return this.nodes.get(i).longValue();
            }
        }
        return 0.0d;
    }

    public double currentRoadSpeed() {
        List<Double> list = this.speedLimit;
        if (list != null) {
            int size = list.size();
            int i = this.currentRoute;
            if (size > i) {
                return this.speedLimit.get(i).doubleValue();
            }
        }
        return 0.0d;
    }

    public boolean directionsAvailable() {
        return this.currentDirectionInfo < this.directions.size();
    }

    public List<com.mappls.sdk.navigation.routing.a> getAlarmInfo() {
        return this.alarmInfo;
    }

    public com.mappls.sdk.navigation.d getAppMode() {
        return this.appMode;
    }

    public double getBaseDurationToNodeFromCurrent(int i) {
        List<Double> list = this.baseDurations;
        double dDoubleValue = 0.0d;
        if (list != null && list.size() == 0) {
            return 0.0d;
        }
        if (this.currentRoute <= i && i < this.baseDurations.size()) {
            for (int i2 = this.currentRoute; i2 <= i; i2++) {
                dDoubleValue += this.baseDurations.get(i2).doubleValue();
            }
        }
        return dDoubleValue;
    }

    public List<Double> getBaseDurations() {
        return this.baseDurations;
    }

    public List<String> getCongestion() {
        return this.congestion;
    }

    public List<CongestionInfo> getCongestionInfos() {
        return this.congestionInfos;
    }

    public float getCurrentMaxSpeed() {
        getCurrentSegmentResult();
        return 0.0f;
    }

    public int getCurrentRoute() {
        return this.currentRoute;
    }

    public com.mappls.sdk.navigation.router.b getCurrentSegmentResult() {
        int i = this.currentRoute;
        int i2 = i > 0 ? i - 1 : 0;
        if (i2 < this.segments.size()) {
            return this.segments.get(i2);
        }
        return null;
    }

    public DirectionsResponse getDirectionsResponse(MapplsDirections mapplsDirections) {
        LatLng latLng = null;
        if (this.errorMessage != null) {
            return null;
        }
        DirectionsResponse.Builder builder = DirectionsResponse.builder();
        ArrayList arrayList = new ArrayList();
        arrayList.add(getDirectionsRoute(mapplsDirections.profile(), mapplsDirections.geometries(), mapplsDirections.steps()));
        builder.routes(arrayList);
        builder.code("OK");
        ArrayList arrayList2 = new ArrayList();
        NavLocation navLocation = this.start;
        arrayList2.add(DirectionsWaypoint.builder().rawLocation(new double[]{navLocation.getLongitude(), navLocation.getLatitude()}).name("").build());
        List<LatLng> list = this.intermediates;
        if (list != null) {
            for (LatLng latLng2 : list) {
                arrayList2.add(DirectionsWaypoint.builder().rawLocation(new double[]{latLng2.getLongitude(), latLng2.getLatitude()}).name("").build());
            }
        }
        if (this.end.contains(",")) {
            String[] strArrSplit = this.end.split(",");
            latLng = new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
        }
        if (latLng != null) {
            arrayList2.add(DirectionsWaypoint.builder().rawLocation(new double[]{latLng.getLongitude(), latLng.getLatitude()}).name("").build());
        }
        builder.waypoints(arrayList2);
        DirectionsResponse directionsResponseBuild = builder.build();
        return directionsResponseBuild.toBuilder().routes(generateRouteOptions(directionsResponseBuild, mapplsDirections)).build();
    }

    public int getDistanceToFinish(NavLocation navLocation) {
        int i;
        int[] iArr = this.listDistance;
        if (iArr == null || (i = this.currentRoute) >= iArr.length) {
            return 0;
        }
        int i2 = iArr[i];
        if (i < this.locations.size()) {
            return navLocation != null ? (int) (navLocation.distanceTo(this.locations.get(this.currentRoute)) + i2) : i2;
        }
        return i2;
    }

    public int getDistanceToNextIntermediate(NavLocation navLocation) {
        int i;
        int[] iArr = this.listDistance;
        if (iArr == null || (i = this.currentRoute) >= iArr.length) {
            return 0;
        }
        int iDistanceTo = iArr[i];
        NavLocation navLocation2 = this.locations.get(i);
        if (navLocation != null) {
            iDistanceTo = (int) (navLocation.distanceTo(navLocation2) + iDistanceTo);
        }
        int i2 = this.nextIntermediate;
        int[] iArr2 = this.intermediatePoints;
        if (i2 >= iArr2.length) {
            return 0;
        }
        return iDistanceTo - getListDistance(this.directions.get(iArr2[i2]).routePointOffset);
    }

    public int getDistanceToPoint(int i) {
        int i2;
        int[] iArr = this.listDistance;
        if (iArr == null || (i2 = this.currentRoute) >= iArr.length || i >= iArr.length || i <= i2) {
            return 0;
        }
        return iArr[i2] - iArr[i];
    }

    public double getDurationToNodeFromCurrent(int i) {
        List<Double> list = this.durations;
        double dDoubleValue = 0.0d;
        if (list != null && list.size() == 0) {
            return 0.0d;
        }
        if (this.currentRoute <= i && i < this.durations.size()) {
            for (int i2 = this.currentRoute; i2 <= i; i2++) {
                dDoubleValue += this.durations.get(i2).doubleValue();
            }
        }
        return dDoubleValue;
    }

    public List<Double> getDurations() {
        return this.durations;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<ReportDetails> getEvents() {
        return this.events;
    }

    public List<NavigationStep> getImmutableAllDirections() {
        return this.directions;
    }

    public List<NavLocation> getImmutableAllLocations() {
        return this.locations;
    }

    public int getIndexOfIntermediate(int i) {
        int[] iArr = this.intermediatePoints;
        int length = (iArr.length - i) - 1;
        if (length >= iArr.length || length < 0) {
            return -1;
        }
        return this.directions.get(iArr[length]).routePointOffset;
    }

    public int getIndexOfIntermediatePoint(int i) {
        int[] iArr = this.intermediatePoints;
        if (i >= iArr.length || i < 0) {
            return -1;
        }
        return this.directions.get(iArr[i]).routePointOffset;
    }

    public int getIndexToRouteFromIndexToDistance(int i, int i2) {
        int i3;
        int i4 = this.currentRoute;
        int[] iArr = this.listDistance;
        if (iArr != null && (i3 = i + i4) < iArr.length) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.listDistance;
                if (i3 >= iArr2.length) {
                    break;
                }
                if (i5 < i2) {
                    i5 += iArr2[i3];
                    i4 = i3;
                }
                i3++;
            }
        }
        return i4;
    }

    public int getIntermediatePointsToPass() {
        int i = this.nextIntermediate;
        int[] iArr = this.intermediatePoints;
        if (i >= iArr.length) {
            return 0;
        }
        return iArr.length - i;
    }

    public List<NavEvent> getInternalEvents() {
        return this.navEvents;
    }

    public String getJunctionImage(String str) {
        if (this.junctionViewImage.containsKey(str)) {
            return this.junctionViewImage.get(str);
        }
        return null;
    }

    public List<Junction> getJunctionViews() {
        return this.junctionViews;
    }

    public int getLeftTime(NavLocation navLocation) {
        if (this.currentDirectionInfo >= this.directions.size()) {
            return 0;
        }
        NavigationStep navigationStep = this.directions.get(this.currentDirectionInfo);
        int i = navigationStep.afterLeftTime;
        int listDistance = getListDistance(this.currentRoute);
        if (this.currentDirectionInfo + 1 < this.directions.size()) {
            listDistance -= getListDistance(this.directions.get(this.currentDirectionInfo + 1).routePointOffset);
        }
        NavLocation navLocation2 = this.locations.get(this.currentRoute);
        if (navLocation != null) {
            listDistance = (int) (navLocation.distanceTo(navLocation2) + listDistance);
        }
        return (int) ((listDistance / navigationStep.getAverageSpeed()) + i);
    }

    public int getLeftTimeToNextIntermediate(NavLocation navLocation) {
        if (this.nextIntermediate >= this.intermediatePoints.length) {
            return 0;
        }
        return getLeftTime(navLocation) - this.directions.get(this.intermediatePoints[this.nextIntermediate]).afterLeftTime;
    }

    public NavLocation getLocationFromRouteDirection(NavigationStep navigationStep) {
        List<NavLocation> list;
        if (navigationStep == null || (list = this.locations) == null || navigationStep.routePointOffset >= list.size()) {
            return null;
        }
        return this.locations.get(navigationStep.routePointOffset);
    }

    public List<LocationPoint> getLocationPoints() {
        return this.locationPoints;
    }

    public int getNextIntermediate() {
        return this.nextIntermediate;
    }

    public a getNextRouteDirectionInfo(a aVar, NavLocation navLocation, boolean z) {
        int i;
        try {
            int i2 = this.currentDirectionInfo;
            if (i2 >= this.directions.size()) {
                aVar.d = -1;
                aVar.b = -1;
                aVar.a = null;
                return null;
            }
            boolean z2 = true;
            int i3 = i2 + 1;
            if (z) {
                while (i3 < this.directions.size()) {
                    NavigationStep navigationStep = this.directions.get(i3);
                    if (navigationStep.getTurnType() != null) {
                        navigationStep.getTurnType().getClass();
                        break;
                    }
                    i3++;
                }
            }
            int[] iArr = this.listDistance;
            int i4 = this.currentRoute;
            int iDistanceTo = iArr[i4];
            if (navLocation != null) {
                iDistanceTo = (int) (iDistanceTo + navLocation.distanceTo(this.locations.get(i4)));
            }
            if (i3 < this.directions.size()) {
                aVar.a = this.directions.get(i3);
                int i5 = this.directions.get(i3).routePointOffset;
                int i6 = this.currentRoute;
                iDistanceTo -= (i5 > i6 || i6 > this.directions.get(i3).routeEndPointOffset) ? this.listDistance[this.directions.get(i3).routePointOffset] : this.listDistance[this.directions.get(i3).routeEndPointOffset];
            }
            int[] iArr2 = this.intermediatePoints;
            if (iArr2 != null && (i = this.nextIntermediate) < iArr2.length) {
                if (iArr2[i] != i3) {
                    z2 = false;
                }
                aVar.c = z2;
            }
            aVar.d = i3;
            aVar.b = iDistanceTo;
            return aVar;
        } catch (Exception e) {
            NavigationLogger.e(e);
            aVar.d = -1;
            aVar.b = -1;
            aVar.a = null;
            return null;
        }
    }

    public a getNextRouteDirectionInfoAfter(a aVar, a aVar2, boolean z) {
        NavigationStep navigationStep;
        int i;
        int i2 = aVar.d;
        if (i2 >= this.directions.size() || (navigationStep = aVar.a) == null) {
            aVar2.d = -1;
            aVar2.b = -1;
            aVar2.a = null;
            return null;
        }
        int i3 = this.listDistance[navigationStep.routePointOffset];
        int i4 = i2 + 1;
        if (z) {
            while (i4 < this.directions.size()) {
                NavigationStep navigationStep2 = this.directions.get(i4);
                if (navigationStep2.getTurnType() != null) {
                    navigationStep2.getTurnType().getClass();
                    break;
                }
                i4++;
            }
        }
        if (i4 < this.directions.size()) {
            aVar2.a = this.directions.get(i4);
            i3 -= this.listDistance[this.directions.get(i4).routePointOffset];
        }
        int[] iArr = this.intermediatePoints;
        if (iArr != null && (i = this.nextIntermediate) < iArr.length) {
            aVar2.c = iArr[i] == i4;
        }
        aVar2.b = i3;
        aVar2.d = i4;
        return aVar2;
    }

    public NavLocation getNextRouteLocation() {
        if (this.currentRoute < this.locations.size()) {
            return this.locations.get(this.currentRoute);
        }
        return null;
    }

    public NavLocation getNextRouteLocation(int i) {
        if (this.currentRoute + i < this.locations.size()) {
            return this.locations.get(this.currentRoute + i);
        }
        return null;
    }

    public List<com.mappls.sdk.navigation.router.b> getOriginalRoute() {
        if (this.segments.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.segments.get(0));
        for (int i = 1; i < this.segments.size(); i++) {
            if (this.segments.get(i - 1) != this.segments.get(i)) {
                arrayList.add(this.segments.get(i));
            }
        }
        return arrayList;
    }

    public b getParams() {
        return this.params;
    }

    public List<NavigationStep> getRouteDirections() {
        if (this.currentDirectionInfo >= this.directions.size() - 1) {
            return Collections.emptyList();
        }
        int i = this.cacheCurrentTextDirectionInfo;
        int i2 = this.currentDirectionInfo;
        if (i != i2) {
            this.cacheCurrentTextDirectionInfo = i2;
            List<NavigationStep> listSubList = this.directions;
            if (i2 != 0) {
                listSubList = listSubList.subList(i2 + 1, listSubList.size());
            }
            this.cacheAgreggatedDirections = new ArrayList();
            NavigationStep navigationStep = null;
            for (NavigationStep navigationStep2 : listSubList) {
                if (navigationStep == null) {
                    navigationStep = new NavigationStep(navigationStep2.getAverageSpeed(), navigationStep2.getTurnType());
                    navigationStep.routePointOffset = navigationStep2.routePointOffset;
                    navigationStep.routeEndPointOffset = navigationStep2.routeEndPointOffset;
                    navigationStep.setDestinationName(navigationStep2.getDestinationName());
                    navigationStep.setRef(navigationStep2.getRef());
                    navigationStep.setStreetName(navigationStep2.getStreetName());
                    navigationStep.setDescriptionRoute(navigationStep2.getDescriptionRoutePart());
                    this.cacheAgreggatedDirections.add(navigationStep);
                } else if (navigationStep2.getTurnType() != null) {
                    navigationStep2.getTurnType().getClass();
                    navigationStep = new NavigationStep(navigationStep2.getAverageSpeed(), navigationStep2.getTurnType());
                    navigationStep.routePointOffset = navigationStep2.routePointOffset;
                    navigationStep.routeEndPointOffset = navigationStep2.routeEndPointOffset;
                    navigationStep.setDestinationName(navigationStep2.getDestinationName());
                    navigationStep.setRef(navigationStep2.getRef());
                    navigationStep.setStreetName(navigationStep2.getStreetName());
                    navigationStep.setDescriptionRoute(navigationStep2.getDescriptionRoutePart());
                    this.cacheAgreggatedDirections.add(navigationStep);
                }
                double expectedTime = navigationStep.getExpectedTime() + navigationStep2.getExpectedTime();
                int i3 = navigationStep.distance + navigationStep2.distance;
                navigationStep.distance = i3;
                navigationStep.setAverageSpeed((float) (((double) i3) / expectedTime));
                navigationStep.afterLeftTime = navigationStep2.afterLeftTime;
            }
        }
        return this.cacheAgreggatedDirections;
    }

    public int getRouteDistanceToFinish(int i) {
        int i2;
        int[] iArr = this.listDistance;
        if (iArr == null || (i2 = this.currentRoute + i) >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    public List<NavLocation> getRouteLocations() {
        if (this.currentRoute >= this.locations.size()) {
            return Collections.emptyList();
        }
        List<NavLocation> list = this.locations;
        return list.subList(this.currentRoute, list.size());
    }

    public float getRoutingTime() {
        return this.routingTime;
    }

    com.mappls.sdk.navigation.router.c getTurnTypeValue(String str, String str2) {
        int i = 0;
        if (str2 == null || str2.equalsIgnoreCase("roundabout")) {
            if (str2 != null && str2.equalsIgnoreCase("roundabout")) {
                i = 68;
            }
        } else if (!str.equalsIgnoreCase("left")) {
            if (str.equalsIgnoreCase("right")) {
                i = 3;
            } else if (str.equalsIgnoreCase("sharp left")) {
                i = 1;
            } else if (str.equalsIgnoreCase("sharp right")) {
                i = 4;
            } else if (str.equalsIgnoreCase("slight left")) {
                i = 2;
            } else if (str.equalsIgnoreCase("slight right")) {
                i = 5;
            } else if (str.equalsIgnoreCase("straight")) {
                i = 7;
            } else if (str.equalsIgnoreCase("uturn")) {
                i = 6;
            }
        }
        return com.mappls.sdk.navigation.router.c.a(i, true);
    }

    public int getWholeDistance() {
        int[] iArr = this.listDistance;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return 0;
    }

    public boolean isCalculated() {
        return !this.locations.isEmpty();
    }

    public boolean isEmpty() {
        return this.locations.isEmpty() || this.currentRoute >= this.locations.size();
    }

    public boolean isToll() {
        List<String> list = this.tollRoad;
        if (list != null) {
            int size = list.size();
            int i = this.currentRoute;
            if (size > i && Integer.parseInt(this.tollRoad.get(i)) > 0) {
                return true;
            }
        }
        return false;
    }

    public void passIntermediatePoint() {
        this.nextIntermediate++;
    }

    public void setCongestionInfos(List<CongestionInfo> list) {
        this.congestionInfos.clear();
        if (list != null) {
            this.congestionInfos.addAll(list);
        }
        if (MapplsNavigationHelper.getInstance().getCongestionInfoLoadedListener() != null) {
            MapplsNavigationHelper.getInstance().getCongestionInfoLoadedListener().onCongestionInfoLoaded(this.congestionInfos);
        }
    }

    public void setEvents(List<ReportDetails> list) {
        this.events.clear();
        this.events.addAll(list);
        setInternalEvents(list);
    }

    public void setInternalEvents(final List<ReportDetails> list) {
        this.navEvents.clear();
        if (list != null && list.size() > 0) {
            NavigationLogger.d("Total events from API = %d", Integer.valueOf(list.size()));
            for (ReportDetails reportDetails : list) {
                NavEvent navEvent = new NavEvent(reportDetails.getChildCategory(), reportDetails.getLatitude().doubleValue(), reportDetails.getLongitude().doubleValue(), shouldSpeak(reportDetails), shouldShow(reportDetails));
                navEvent.setIndex(reportDetails.getNodeIdx());
                navEvent.setReportDetails(reportDetails);
                this.navEvents.add(navEvent);
            }
        }
        b bVar = this.params;
        if (bVar == null || bVar.d == null) {
            return;
        }
        NavigationContext.getNavigationContext().o().a(6);
        NavigationContext.getNavigationContext().a(new Runnable() { // from class: com.mappls.sdk.navigation.routing.NavigationRoute$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NavigationRoute.lambda$setInternalEvents$0(list);
            }
        });
    }

    public void setJunctionViews(JunctionApiResponse junctionApiResponse) {
        List<Junction> list;
        this.junctionViews.clear();
        if (junctionApiResponse != null && (list = junctionApiResponse.data) != null && list.size() > 0) {
            this.junctionViews.addAll(junctionApiResponse.data);
            for (Junction junction : this.junctionViews) {
                this.junctionViewImage.put(junction.id, junction.image);
            }
        }
        if (MapplsNavigationHelper.getInstance().getJunctionViewsLoadedListener() != null) {
            MapplsNavigationHelper.getInstance().getJunctionViewsLoadedListener().onJunctionViewsLoaded(this.junctionViews);
        }
    }

    public void settingChanged() {
        this.navEvents.clear();
        List<ReportDetails> list = this.events;
        if (list != null && list.size() > 0) {
            for (ReportDetails reportDetails : this.events) {
                NavEvent navEvent = new NavEvent(reportDetails.getChildCategory(), reportDetails.getLatitude().doubleValue(), reportDetails.getLongitude().doubleValue(), shouldSpeak(reportDetails), shouldShow(reportDetails));
                navEvent.setIndex(reportDetails.getNodeIdx());
                navEvent.setReportDetails(reportDetails);
                this.navEvents.add(navEvent);
            }
        }
        NavigationContext.getNavigationContext().o().a(6);
    }

    boolean shouldShow(ReportDetails reportDetails) {
        b bVar = this.params;
        if (bVar == null || bVar.d == null) {
            return true;
        }
        boolean zBooleanValue = ((Boolean) NavigationContext.getNavigationContext().k().Q.get()).booleanValue();
        boolean zBooleanValue2 = ((Boolean) NavigationContext.getNavigationContext().k().O.get()).booleanValue();
        boolean zBooleanValue3 = ((Boolean) NavigationContext.getNavigationContext().k().S.get()).booleanValue();
        if (reportDetails.getParentCategoryId() == null) {
            return true;
        }
        if (reportDetails.getParentCategoryId().intValue() == 5) {
            return zBooleanValue2;
        }
        if (reportDetails.getParentCategoryId().intValue() == 2) {
            return zBooleanValue;
        }
        if (reportDetails.getParentCategoryId().intValue() == 6) {
            return zBooleanValue3;
        }
        return true;
    }

    boolean shouldSpeak(ReportDetails reportDetails) {
        b bVar = this.params;
        if (bVar == null || bVar.d == null) {
            return true;
        }
        boolean zBooleanValue = ((Boolean) NavigationContext.getNavigationContext().k().P.get()).booleanValue();
        boolean zBooleanValue2 = ((Boolean) NavigationContext.getNavigationContext().k().N.get()).booleanValue();
        boolean zBooleanValue3 = ((Boolean) NavigationContext.getNavigationContext().k().R.get()).booleanValue();
        if (reportDetails.getParentCategoryId() == null) {
            return true;
        }
        if (reportDetails.getParentCategoryId().intValue() == 5) {
            return zBooleanValue2;
        }
        if (reportDetails.getParentCategoryId().intValue() == 2) {
            return zBooleanValue;
        }
        if (reportDetails.getParentCategoryId().intValue() == 6) {
            return zBooleanValue3;
        }
        return true;
    }

    public void updateCurrentRoute(int i) {
        this.currentRoute = i;
        while (this.currentDirectionInfo < this.directions.size() - 1 && this.directions.get(this.currentDirectionInfo + 1).routePointOffset < i && this.directions.get(this.currentDirectionInfo + 1).routeEndPointOffset < i) {
            this.currentDirectionInfo++;
        }
        while (true) {
            int i2 = this.nextIntermediate;
            int[] iArr = this.intermediatePoints;
            if (i2 >= iArr.length || this.directions.get(iArr[i2]).routePointOffset >= i) {
                return;
            } else {
                this.nextIntermediate++;
            }
        }
    }
}
