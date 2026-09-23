package com.google.android.libraries.navigation;

import android.content.Intent;
import com.google.android.gms.maps.model.LatLng;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public interface Navigator {
    public static final int MAX_NUM_TRANSACTION_IDS = 100;
    public static final int MAX_TRANSACTION_ID_LENGTH = 64;

    /* JADX INFO: compiled from: PG */
    public interface ArrivalListener {
        void onArrival(ArrivalEvent arrivalEvent);
    }

    /* JADX INFO: compiled from: PG */
    public @interface AudioGuidance {
        public static final int BLUETOOTH_AUDIO = 8;
        public static final int SILENT = 0;
        public static final int VIBRATION = 1;
        public static final int VOICE_ALERTS_AND_GUIDANCE = 4;
        public static final int VOICE_ALERTS_ONLY = 2;
    }

    /* JADX INFO: compiled from: PG */
    public interface NavigationSessionListener {
        void onNewNavigationSession();
    }

    /* JADX INFO: compiled from: PG */
    public interface RemainingTimeOrDistanceChangedListener {
        void onRemainingTimeOrDistanceChanged();
    }

    /* JADX INFO: compiled from: PG */
    public interface ReroutingListener {
        void onReroutingRequestedByOffRoute();
    }

    /* JADX INFO: compiled from: PG */
    public interface RouteChangedListener {
        void onRouteChanged();
    }

    /* JADX INFO: compiled from: PG */
    public enum RouteStatus {
        OK,
        NO_ROUTE_FOUND,
        NETWORK_ERROR,
        QUOTA_CHECK_FAILED,
        ROUTE_CANCELED,
        LOCATION_DISABLED,
        LOCATION_UNKNOWN,
        WAYPOINT_ERROR
    }

    /* JADX INFO: compiled from: PG */
    @Target({ElementType.TYPE_USE})
    public @interface TaskRemovedBehavior {
        public static final int CONTINUE_SERVICE = 0;
        public static final int QUIT_SERVICE = 1;
    }

    /* JADX INFO: compiled from: PG */
    public interface TrafficUpdatedListener {
        void onTrafficUpdated();
    }

    void a(Intent intent);

    void addArrivalListener(ArrivalListener arrivalListener);

    void addNavigationSessionListener(NavigationSessionListener navigationSessionListener);

    void addRemainingTimeOrDistanceChangedListener(int i, int i2, RemainingTimeOrDistanceChangedListener remainingTimeOrDistanceChangedListener);

    void addReroutingListener(ReroutingListener reroutingListener);

    void addRouteChangedListener(RouteChangedListener routeChangedListener);

    void addTrafficUpdatedListener(TrafficUpdatedListener trafficUpdatedListener);

    void cleanup();

    void clearDestinations();

    void clearLicensePlateRestrictionInfo();

    Waypoint continueToNextDestination();

    @Deprecated
    ListenableResultFuture<RouteInfo> fetchRouteInfo(Waypoint waypoint, RoutingOptions routingOptions);

    RouteSegment getCurrentRouteSegment();

    TimeAndDistance getCurrentTimeAndDistance();

    List<RouteSegment> getRouteSegments();

    Simulator getSimulator();

    List<TimeAndDistance> getTimeAndDistanceList();

    List<LatLng> getTraveledRoute();

    boolean isGuidanceRunning();

    boolean registerServiceForNavUpdates(String str, String str2, int i);

    boolean registerServiceForNavUpdates(String str, String str2, NavigationUpdatesOptions navigationUpdatesOptions);

    void removeArrivalListener(ArrivalListener arrivalListener);

    void removeNavigationSessionListener(NavigationSessionListener navigationSessionListener);

    void removeRemainingTimeOrDistanceChangedListener(RemainingTimeOrDistanceChangedListener remainingTimeOrDistanceChangedListener);

    void removeReroutingListener(ReroutingListener reroutingListener);

    void removeRouteChangedListener(RouteChangedListener routeChangedListener);

    void removeTrafficUpdatedListener(TrafficUpdatedListener trafficUpdatedListener);

    void setAudioGuidance(int i);

    ListenableResultFuture<RouteStatus> setDestination(Waypoint waypoint);

    ListenableResultFuture<RouteStatus> setDestination(Waypoint waypoint, RoutingOptions routingOptions);

    ListenableResultFuture<RouteStatus> setDestination(Waypoint waypoint, RoutingOptions routingOptions, DisplayOptions displayOptions);

    ListenableResultFuture<RouteStatus> setDestinations(List<Waypoint> list);

    ListenableResultFuture<RouteStatus> setDestinations(List<Waypoint> list, CustomRoutesOptions customRoutesOptions);

    ListenableResultFuture<RouteStatus> setDestinations(List<Waypoint> list, CustomRoutesOptions customRoutesOptions, DisplayOptions displayOptions);

    ListenableResultFuture<RouteStatus> setDestinations(List<Waypoint> list, RoutingOptions routingOptions);

    ListenableResultFuture<RouteStatus> setDestinations(List<Waypoint> list, RoutingOptions routingOptions, DisplayOptions displayOptions);

    void setHeadsUpNotificationEnabled(boolean z);

    void setLicensePlateRestrictionInfo(int i, String str);

    void setSpeedAlertOptions(SpeedAlertOptions speedAlertOptions);

    void setSpeedingListener(SpeedingListener speedingListener);

    void setTaskRemovedBehavior(int i);

    void setTransactionIds(List<String> list) throws NavigationTransactionRecorder.TransactionException;

    void startGuidance();

    void stopGuidance();

    boolean unregisterServiceForNavUpdates();
}
