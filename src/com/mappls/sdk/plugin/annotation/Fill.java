package com.mappls.sdk.plugin.annotation;

import android.graphics.PointF;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.Polygon;
import com.mappls.sdk.gestures.MoveDistancesObject;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.utils.ColorUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Fill extends Annotation<Polygon> {
    private final AnnotationManager<?, Fill, ?, ?, ?, ?> annotationManager;

    Fill(long j, AnnotationManager<?, Fill, ?, ?, ?, ?> annotationManager, JsonObject jsonObject, Polygon polygon) {
        super(j, jsonObject, polygon);
        this.annotationManager = annotationManager;
    }

    public String getFillColor() {
        if (this.jsonObject.get("fill-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("fill-color").getAsString();
    }

    public Integer getFillColorAsInt() {
        if (this.jsonObject.get("fill-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("fill-color").getAsString()));
    }

    public Float getFillOpacity() {
        if (this.jsonObject.get("fill-opacity").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("fill-opacity").getAsFloat());
    }

    public String getFillOutlineColor() {
        if (this.jsonObject.get("fill-outline-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("fill-outline-color").getAsString();
    }

    public Integer getFillOutlineColorAsInt() {
        if (this.jsonObject.get("fill-outline-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("fill-outline-color").getAsString()));
    }

    public String getFillPattern() {
        if (this.jsonObject.get("fill-pattern").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("fill-pattern").getAsString();
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    String getName() {
        return "Fill";
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    Geometry getOffsetGeometry(Projection projection, MoveDistancesObject moveDistancesObject, float f, float f2) {
        List<List<Point>> listCoordinates = ((Polygon) this.geometry).coordinates();
        if (listCoordinates == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listCoordinates.size());
        for (List<Point> list : listCoordinates) {
            ArrayList arrayList2 = new ArrayList();
            for (Point point : list) {
                PointF screenLocation = projection.toScreenLocation(new LatLng(point.latitude(), point.longitude()));
                screenLocation.x -= moveDistancesObject.getDistanceXSinceLast();
                screenLocation.y -= moveDistancesObject.getDistanceYSinceLast();
                LatLng latLngFromScreenLocation = projection.fromScreenLocation(screenLocation);
                if (latLngFromScreenLocation.getLatitude() > 85.05112877980659d || latLngFromScreenLocation.getLatitude() < -85.05112877980659d) {
                    return null;
                }
                arrayList2.add(Point.fromLngLat(latLngFromScreenLocation.getLongitude(), latLngFromScreenLocation.getLatitude()));
            }
            arrayList.add(arrayList2);
        }
        return Polygon.fromLngLats(arrayList);
    }

    public List<List<LatLng>> getPoints() {
        Polygon polygon = (Polygon) this.geometry;
        ArrayList arrayList = new ArrayList();
        List<List<Point>> listCoordinates = polygon.coordinates();
        if (listCoordinates != null) {
            for (List<Point> list : listCoordinates) {
                ArrayList arrayList2 = new ArrayList();
                for (Point point : list) {
                    arrayList2.add(new LatLng(point.latitude(), point.longitude()));
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public void setFillColor(int i) {
        this.jsonObject.addProperty("fill-color", ColorUtils.colorToRgbaString(i));
    }

    public void setFillColor(String str) {
        this.jsonObject.addProperty("fill-color", str);
    }

    public void setFillOpacity(Float f) {
        this.jsonObject.addProperty("fill-opacity", f);
    }

    public void setFillOutlineColor(int i) {
        this.jsonObject.addProperty("fill-outline-color", ColorUtils.colorToRgbaString(i));
    }

    public void setFillOutlineColor(String str) {
        this.jsonObject.addProperty("fill-outline-color", str);
    }

    public void setFillPattern(String str) {
        this.jsonObject.addProperty("fill-pattern", str);
    }

    public void setPoints(List<List<LatLng>> list) {
        ArrayList arrayList = new ArrayList();
        for (List<LatLng> list2 : list) {
            ArrayList arrayList2 = new ArrayList();
            for (LatLng latLng : list2) {
                arrayList2.add(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
            }
            arrayList.add(arrayList2);
        }
        this.geometry = Polygon.fromLngLats(arrayList);
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    void setUsedDataDrivenProperties() {
        if (!(this.jsonObject.get("fill-opacity") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("fill-opacity");
        }
        if (!(this.jsonObject.get("fill-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("fill-color");
        }
        if (!(this.jsonObject.get("fill-outline-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("fill-outline-color");
        }
        if (this.jsonObject.get("fill-pattern") instanceof JsonNull) {
            return;
        }
        this.annotationManager.enableDataDrivenProperty("fill-pattern");
    }
}
