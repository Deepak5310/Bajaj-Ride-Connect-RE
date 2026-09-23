package com.mappls.sdk.navigation.routing;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.StepManeuver;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationStep {
    public int afterLeftTime;
    private float averageSpeed;
    private String destinationName;
    public int distance;
    private Object extraInfo;
    private boolean isDestination;
    private int maneuverID;
    private int maneuverIdLegacy;
    private NavLocation navLocation;
    private Object nextExtraInfo;
    private int position;
    private String ref;
    public int routePointOffset;
    private String streetName;
    private final com.mappls.sdk.navigation.router.c turnType;
    public int routeEndPointOffset = 0;
    private String descriptionRoute = "";
    private String shortInstruction = "";

    public NavigationStep(float f, com.mappls.sdk.navigation.router.c cVar) {
        this.averageSpeed = f == 0.0f ? 1.0f : f;
        this.turnType = cVar;
    }

    public NavigationStep(float f, String str, Float f2, int[] iArr, boolean z) {
        com.mappls.sdk.navigation.router.c cVarA = str != null ? com.mappls.sdk.navigation.router.c.a(str.toUpperCase(), z) : com.mappls.sdk.navigation.router.c.h();
        if (f2 != null) {
            cVarA.a(f2.floatValue());
        }
        if (iArr != null && iArr.length > 0) {
            cVarA.a(iArr);
        }
        this.averageSpeed = f == 0.0f ? 1.0f : f;
        this.turnType = cVarA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.descriptionRoute.equals(((NavigationStep) obj).descriptionRoute);
    }

    public float getAverageSpeed() {
        return this.averageSpeed;
    }

    public String getDescriptionRoute(Context context, int i) {
        double d = i;
        if (!this.descriptionRoute.endsWith(DirectionFormatter.getFormattedDistanceRound(d))) {
            this.descriptionRoute += StringUtils.SPACE + DirectionFormatter.getFormattedDistanceRound(d);
        }
        return this.descriptionRoute.trim();
    }

    public String getDescriptionRoute(NavigationApplication navigationApplication) {
        if (!this.descriptionRoute.endsWith(DirectionFormatter.getFormattedDistanceRound(this.distance))) {
            this.descriptionRoute += StringUtils.SPACE + DirectionFormatter.getFormattedDistanceRound(this.distance);
        }
        return this.descriptionRoute.trim();
    }

    public String getDescriptionRoutePart() {
        return Html.fromHtml(this.descriptionRoute).toString();
    }

    public Spanned getDescriptionRoutePartHTML() {
        return Html.fromHtml(this.descriptionRoute);
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public int getDistance() {
        return this.distance;
    }

    public float getExitAngle() {
        return this.turnType.b();
    }

    public int getExitNumber() {
        return this.turnType.a();
    }

    public double getExpectedTime() {
        return Math.round(this.distance / this.averageSpeed);
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    LegStep getLegStep(String str, NavLocation navLocation, String str2, boolean z, boolean z2) {
        LegStep.Builder builder = LegStep.builder();
        builder.distance(getDistance());
        StepManeuver.Builder builder2 = StepManeuver.builder();
        builder2.modifier(getModifier());
        if (z2) {
            builder2.type("depart");
            builder2.bearingAfter(Double.valueOf(Math.abs(this.turnType.b())));
        } else if (z) {
            builder2.type("arrive");
            builder2.modifier(null);
        } else {
            builder2.type(getTurnTypeString());
        }
        builder2.instruction(this.shortInstruction);
        builder2.rawLocation(new double[]{navLocation.getLongitude(), navLocation.getLatitude()});
        if (this.turnType.e()) {
            builder2.exit(Integer.valueOf(this.turnType.a()));
            builder2.degree(Double.valueOf(this.turnType.b() > 0.0f ? this.turnType.b() : 180.0f));
        }
        builder.maneuver(builder2.build());
        builder.duration(getExpectedTime());
        builder.weight(Double.valueOf(getExpectedTime()));
        builder.geometry(str2);
        builder.mode(str);
        builder.name(this.streetName);
        return builder.build();
    }

    public int getManeuverID() {
        return this.maneuverID;
    }

    @Deprecated
    public int getManeuverIdLegacy() {
        return this.maneuverIdLegacy;
    }

    String getModifier() {
        Object obj = this.extraInfo;
        if (obj != null && (obj instanceof LegStep)) {
            return ((LegStep) obj).maneuver().modifier();
        }
        int iC = this.turnType.c();
        if (iC == 19) {
            return "left";
        }
        if (iC == 20) {
            return "right";
        }
        if (iC == 34) {
            return "left";
        }
        if (iC == 35) {
            return "right";
        }
        if (iC == 41) {
            return "uturn";
        }
        if (iC == 68 || iC == 69) {
            return "roundabout";
        }
        switch (iC) {
            case 0:
                return "left";
            case 1:
                return "sharp left";
            case 2:
                return "slight left";
            case 3:
                return "right";
            case 4:
                return "sharp right";
            case 5:
                return "slight right";
            case 6:
                return "uturn";
            default:
                switch (iC) {
                    case 9:
                    case 11:
                    case 13:
                    case 15:
                        return "left";
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                        return "right";
                    default:
                        return "straight";
                }
        }
    }

    public NavLocation getNavLocation() {
        return this.navLocation;
    }

    public Object getNextExtraInfo() {
        return this.nextExtraInfo;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRef() {
        return this.ref;
    }

    public String getShortInstruction() {
        return this.shortInstruction;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public float getTurnAngle() {
        return this.turnType.b();
    }

    public com.mappls.sdk.navigation.router.c getTurnType() {
        return this.turnType;
    }

    public int getTurnTypeConstants() {
        return this.turnType.c();
    }

    public String getTurnTypeString() {
        Object obj = this.extraInfo;
        if (obj != null && (obj instanceof LegStep)) {
            return ((LegStep) obj).maneuver().type();
        }
        int iC = this.turnType.c();
        if (iC == 19 || iC == 20) {
            return "fork";
        }
        if (iC == 34 || iC == 35 || iC == 41) {
            return "turn";
        }
        if (iC == 68 || iC == 69) {
            return "roundabout";
        }
        switch (iC) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return "turn";
            default:
                switch (iC) {
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        return "turn";
                    case 15:
                    case 16:
                        return "fork";
                    default:
                        return "continue";
                }
        }
    }

    public int getTurnValue() {
        return this.turnType.c();
    }

    public int hashCode() {
        return this.descriptionRoute.hashCode();
    }

    public boolean isDestination() {
        return this.isDestination;
    }

    public boolean isRoundAbout() {
        return this.turnType.e();
    }

    boolean isValidName(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && ((c < '0' || c > '9') && c != ' '))) {
                return false;
            }
        }
        return true;
    }

    public void setAverageSpeed(float f) {
        if (f == 0.0f) {
            f = 1.0f;
        }
        this.averageSpeed = f;
    }

    public void setDescriptionRoute(String str) {
        this.descriptionRoute = str;
    }

    public void setDestination(boolean z) {
        this.isDestination = z;
    }

    public void setDestinationName(String str) {
        this.destinationName = str;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setExtraInfo(Object obj) {
        this.extraInfo = obj;
    }

    public void setManeuverID(int i) {
        this.maneuverID = i;
    }

    @Deprecated
    public void setManeuverIdLegacy(int i) {
        this.maneuverIdLegacy = i;
    }

    public void setNavLocation(NavLocation navLocation) {
        this.navLocation = navLocation;
    }

    public void setNextExtraInfo(Object obj) {
        this.nextExtraInfo = obj;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setRef(String str) {
        this.ref = str;
    }

    public void setShortInstruction(String str) {
        this.shortInstruction = str;
    }

    public void setStreetName(String str) {
        if (isValidName(str)) {
            this.streetName = str;
        }
    }

    public void setTurnAngle(float f) {
        this.turnType.a(f);
    }

    public LatLng toLatLng() {
        return new LatLng(this.navLocation.getLatitude(), this.navLocation.getLongitude(), this.navLocation.getAltitude());
    }

    public Point toPoint() {
        return Point.fromLngLat(this.navLocation.getLongitude(), this.navLocation.getLatitude(), this.navLocation.getAltitude());
    }

    public String toString() {
        StringBuilder sbA = com.mappls.sdk.navigation.h.a("NavigationStep{routePointOffset=");
        sbA.append(this.routePointOffset);
        sbA.append(", routeEndPointOffset=");
        sbA.append(this.routeEndPointOffset);
        sbA.append(", afterLeftTime=");
        sbA.append(this.afterLeftTime);
        sbA.append(", distance=");
        sbA.append(this.distance);
        sbA.append(", turnType=");
        sbA.append(this.turnType);
        sbA.append(", descriptionRoute='");
        sbA.append(this.descriptionRoute);
        sbA.append('\'');
        sbA.append(", shortInstruction='");
        sbA.append(this.shortInstruction);
        sbA.append('\'');
        sbA.append(", averageSpeed=");
        sbA.append(this.averageSpeed);
        sbA.append(", ref='");
        sbA.append(this.ref);
        sbA.append('\'');
        sbA.append(", maneuverID=");
        sbA.append(this.maneuverID);
        sbA.append(", streetName='");
        sbA.append(this.streetName);
        sbA.append('\'');
        sbA.append(", destinationName='");
        sbA.append(this.destinationName);
        sbA.append('\'');
        sbA.append(", position=");
        sbA.append(this.position);
        sbA.append(", navLocation=");
        sbA.append(this.navLocation);
        sbA.append(", extraInfo=");
        sbA.append(this.extraInfo);
        sbA.append(", nextExtraInfo=");
        sbA.append(this.nextExtraInfo);
        sbA.append(", isDestination=");
        sbA.append(this.isDestination);
        sbA.append('}');
        return sbA.toString();
    }
}
