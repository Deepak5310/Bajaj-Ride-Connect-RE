package com.mappls.sdk.navigation.model;

import android.location.Location;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.h;

/* JADX INFO: loaded from: classes4.dex */
public class AdviseInfo {
    private Double currentRoadSpeed;
    private double distanceFromRoute;
    private int distanceToNextAdvise;
    private String eta;
    private long etaInSecond;
    private Object info;
    private int leftDistance;
    private int leftTime;
    private int leftTimeStep;
    private NavLocation location;
    private long maneuverID;
    private long maneuverIDLegacy;
    private Object nextInstructionInfo;
    private String nextInstructionText;
    private int position;
    private String shortText;
    private String text;
    private boolean routeBeingRecalculated = false;
    private boolean uTurnSuggestion = false;
    private boolean isOnRoute = true;
    private boolean isOverSpeed = false;
    private boolean isOnTollRoad = false;
    private boolean intermediate = false;

    public Double getCurrentRoadSpeed() {
        return this.currentRoadSpeed;
    }

    public double getDistanceFromRoute() {
        return this.distanceFromRoute;
    }

    public int getDistanceToNextAdvise() {
        return this.distanceToNextAdvise;
    }

    public String getEta() {
        return this.eta;
    }

    public long getEtaInSecond() {
        return this.etaInSecond;
    }

    public Object getInfo() {
        return this.info;
    }

    public int getLeftDistance() {
        return this.leftDistance;
    }

    public int getLeftTime() {
        return this.leftTime;
    }

    public int getLeftTimeStep() {
        return this.leftTimeStep;
    }

    public Location getLocation() {
        Location location = new Location("gps");
        NavLocation navLocation = this.location;
        if (navLocation != null) {
            location.setLatitude(navLocation.getLatitude());
            location.setLongitude(this.location.getLongitude());
            location.setBearing(this.location.getBearing());
            location.setAccuracy(this.location.getAccuracy());
            location.setSpeed(this.location.getSpeed());
        }
        return location;
    }

    public long getManeuverID() {
        return this.maneuverID;
    }

    @Deprecated
    public long getManeuverIDLegacy() {
        return this.maneuverIDLegacy;
    }

    public NavLocation getNavLocation() {
        return this.location;
    }

    public Object getNextInstructionInfo() {
        return this.nextInstructionInfo;
    }

    public String getNextInstructionText() {
        return this.nextInstructionText;
    }

    public int getPosition() {
        return this.position;
    }

    public String getShortText() {
        return this.shortText;
    }

    public String getText() {
        return this.text;
    }

    public boolean isIntermediate() {
        return this.intermediate;
    }

    public boolean isOnRoute() {
        return this.isOnRoute;
    }

    public boolean isOnTollRoad() {
        return this.isOnTollRoad;
    }

    public boolean isOverSpeed() {
        return this.isOverSpeed;
    }

    public boolean isRouteBeingRecalculated() {
        return this.routeBeingRecalculated;
    }

    public boolean isuTurnSuggestion() {
        return this.uTurnSuggestion;
    }

    public void setCurrentRoadSpeed(Double d) {
        this.currentRoadSpeed = d;
    }

    public void setDistanceFromRoute(double d) {
        this.distanceFromRoute = d;
    }

    public void setDistanceToNextAdvise(int i) {
        this.distanceToNextAdvise = i;
    }

    public void setEta(String str) {
        this.eta = str;
    }

    public void setEtaInSecond(long j) {
        this.etaInSecond = j;
    }

    public void setInfo(Object obj) {
        this.info = obj;
    }

    public void setIntermediate(boolean z) {
        this.intermediate = z;
    }

    public void setLeftDistance(int i) {
        this.leftDistance = i;
    }

    public void setLeftTime(int i) {
        this.leftTime = i;
    }

    public void setLeftTimeStep(int i) {
        this.leftTimeStep = i;
    }

    public void setLocation(NavLocation navLocation) {
        this.location = navLocation;
    }

    public void setManeuverID(long j) {
        this.maneuverID = j;
    }

    @Deprecated
    public void setManeuverIDLegacy(long j) {
        this.maneuverIDLegacy = j;
    }

    public void setNextInstructionInfo(Object obj) {
        this.nextInstructionInfo = obj;
    }

    public void setNextInstructionText(String str) {
        this.nextInstructionText = str;
    }

    public void setOnRoute(boolean z) {
        this.isOnRoute = z;
    }

    public void setOnTollRoad(boolean z) {
        this.isOnTollRoad = z;
    }

    public void setOverSpeed(boolean z) {
        this.isOverSpeed = z;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setRouteBeingRecalculated(boolean z) {
        this.routeBeingRecalculated = z;
    }

    public AdviseInfo setShortText(String str) {
        this.shortText = str;
        return this;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setuTurnSuggestion(boolean z) {
        this.uTurnSuggestion = z;
    }

    public String toString() {
        StringBuilder sbA = h.a("AdviseInfo{text='");
        sbA.append(this.text);
        sbA.append('\'');
        sbA.append(", shortText='");
        sbA.append(this.shortText);
        sbA.append('\'');
        sbA.append(", distanceToNextAdvise=");
        sbA.append(this.distanceToNextAdvise);
        sbA.append(", leftDistance=");
        sbA.append(this.leftDistance);
        sbA.append(", eta='");
        sbA.append(this.eta);
        sbA.append('\'');
        sbA.append(", maneuverID=");
        sbA.append(this.maneuverID);
        sbA.append(", routeBeingRecalculated=");
        sbA.append(this.routeBeingRecalculated);
        sbA.append(", uTurnSuggestion=");
        sbA.append(this.uTurnSuggestion);
        sbA.append(", isOnRoute=");
        sbA.append(this.isOnRoute);
        sbA.append(", leftTime=");
        sbA.append(this.leftTime);
        sbA.append(", leftTimeStep=");
        sbA.append(this.leftTimeStep);
        sbA.append(", etaInSecond=");
        sbA.append(this.etaInSecond);
        sbA.append(", position=");
        sbA.append(this.position);
        sbA.append(", info=");
        sbA.append(this.info);
        sbA.append(", nextInstructionInfo=");
        sbA.append(this.nextInstructionInfo);
        sbA.append(", location=");
        sbA.append(this.location);
        sbA.append(", distanceFromRoute=");
        sbA.append(this.distanceFromRoute);
        sbA.append(", nextInstructionText='");
        sbA.append(this.nextInstructionText);
        sbA.append('\'');
        sbA.append(", currentRoadSpeed=");
        sbA.append(this.currentRoadSpeed);
        sbA.append(", isOverSpeed=");
        sbA.append(this.isOverSpeed);
        sbA.append(", isOnTollRoad=");
        sbA.append(this.isOnTollRoad);
        sbA.append(", intermediate=");
        sbA.append(this.intermediate);
        sbA.append('}');
        return sbA.toString();
    }
}
