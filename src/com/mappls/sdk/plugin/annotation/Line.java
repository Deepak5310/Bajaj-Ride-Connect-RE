package com.mappls.sdk.plugin.annotation;

import android.graphics.PointF;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.gestures.MoveDistancesObject;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.utils.ColorUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Line extends Annotation<LineString> {
    private final AnnotationManager<?, Line, ?, ?, ?, ?> annotationManager;

    Line(long j, AnnotationManager<?, Line, ?, ?, ?, ?> annotationManager, JsonObject jsonObject, LineString lineString) {
        super(j, jsonObject, lineString);
        this.annotationManager = annotationManager;
    }

    public Float getLineBlur() {
        if (this.jsonObject.get("line-blur").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("line-blur").getAsFloat());
    }

    public String getLineColor() {
        if (this.jsonObject.get("line-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("line-color").getAsString();
    }

    public Integer getLineColorAsInt() {
        if (this.jsonObject.get("line-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("line-color").getAsString()));
    }

    public Float getLineGapWidth() {
        if (this.jsonObject.get("line-gap-width").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("line-gap-width").getAsFloat());
    }

    public String getLineJoin() {
        if (this.jsonObject.get("line-join").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("line-join").getAsString();
    }

    public Float getLineOffset() {
        if (this.jsonObject.get("line-offset").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("line-offset").getAsFloat());
    }

    public Float getLineOpacity() {
        if (this.jsonObject.get("line-opacity").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("line-opacity").getAsFloat());
    }

    public String getLinePattern() {
        if (this.jsonObject.get("line-pattern").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("line-pattern").getAsString();
    }

    public Float getLineWidth() {
        if (this.jsonObject.get("line-width").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("line-width").getAsFloat());
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    String getName() {
        return "Line";
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    Geometry getOffsetGeometry(Projection projection, MoveDistancesObject moveDistancesObject, float f, float f2) {
        List<Point> listCoordinates = ((LineString) this.geometry).coordinates();
        ArrayList arrayList = new ArrayList(listCoordinates.size());
        for (Point point : listCoordinates) {
            PointF screenLocation = projection.toScreenLocation(new LatLng(point.latitude(), point.longitude()));
            screenLocation.x -= moveDistancesObject.getDistanceXSinceLast();
            screenLocation.y -= moveDistancesObject.getDistanceYSinceLast();
            LatLng latLngFromScreenLocation = projection.fromScreenLocation(screenLocation);
            if (latLngFromScreenLocation.getLatitude() > 85.05112877980659d || latLngFromScreenLocation.getLatitude() < -85.05112877980659d) {
                return null;
            }
            arrayList.add(Point.fromLngLat(latLngFromScreenLocation.getLongitude(), latLngFromScreenLocation.getLatitude()));
        }
        return LineString.fromLngLats(arrayList);
    }

    public List<LatLng> getPoints() {
        LineString lineString = (LineString) this.geometry;
        ArrayList arrayList = new ArrayList();
        for (Point point : lineString.coordinates()) {
            arrayList.add(new LatLng(point.latitude(), point.longitude()));
        }
        return arrayList;
    }

    public void setLineBlur(Float f) {
        this.jsonObject.addProperty("line-blur", f);
    }

    public void setLineColor(int i) {
        this.jsonObject.addProperty("line-color", ColorUtils.colorToRgbaString(i));
    }

    public void setLineColor(String str) {
        this.jsonObject.addProperty("line-color", str);
    }

    public void setLineGapWidth(Float f) {
        this.jsonObject.addProperty("line-gap-width", f);
    }

    public void setLineJoin(String str) {
        this.jsonObject.addProperty("line-join", str);
    }

    public void setLineOffset(Float f) {
        this.jsonObject.addProperty("line-offset", f);
    }

    public void setLineOpacity(Float f) {
        this.jsonObject.addProperty("line-opacity", f);
    }

    public void setLinePattern(String str) {
        this.jsonObject.addProperty("line-pattern", str);
    }

    public void setLineWidth(Float f) {
        this.jsonObject.addProperty("line-width", f);
    }

    public void setPoints(List<LatLng> list) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : list) {
            arrayList.add(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
        }
        this.geometry = LineString.fromLngLats(arrayList);
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    void setUsedDataDrivenProperties() {
        if (!(this.jsonObject.get("line-join") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-join");
        }
        if (!(this.jsonObject.get("line-opacity") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-opacity");
        }
        if (!(this.jsonObject.get("line-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-color");
        }
        if (!(this.jsonObject.get("line-width") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-width");
        }
        if (!(this.jsonObject.get("line-gap-width") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-gap-width");
        }
        if (!(this.jsonObject.get("line-offset") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-offset");
        }
        if (!(this.jsonObject.get("line-blur") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("line-blur");
        }
        if (this.jsonObject.get("line-pattern") instanceof JsonNull) {
            return;
        }
        this.annotationManager.enableDataDrivenProperty("line-pattern");
    }
}
