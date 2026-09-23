package com.mappls.sdk.plugin.annotation;

import android.graphics.PointF;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.gestures.MoveDistancesObject;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.utils.ColorUtils;

/* JADX INFO: loaded from: classes4.dex */
public class Circle extends Annotation<Point> {
    private final AnnotationManager<?, Circle, ?, ?, ?, ?> annotationManager;

    Circle(long j, AnnotationManager<?, Circle, ?, ?, ?, ?> annotationManager, JsonObject jsonObject, Point point) {
        super(j, jsonObject, point);
        this.annotationManager = annotationManager;
    }

    public Float getCircleBlur() {
        if (this.jsonObject.get("circle-blur").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("circle-blur").getAsFloat());
    }

    public String getCircleColor() {
        if (this.jsonObject.get("circle-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("circle-color").getAsString();
    }

    public Integer getCircleColorAsInt() {
        if (this.jsonObject.get("circle-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("circle-color").getAsString()));
    }

    public Float getCircleOpacity() {
        if (this.jsonObject.get("circle-opacity").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("circle-opacity").getAsFloat());
    }

    public Float getCircleRadius() {
        if (this.jsonObject.get("circle-radius").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("circle-radius").getAsFloat());
    }

    public String getCircleStrokeColor() {
        if (this.jsonObject.get("circle-stroke-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("circle-stroke-color").getAsString();
    }

    public Integer getCircleStrokeColorAsInt() {
        if (this.jsonObject.get("circle-stroke-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("circle-stroke-color").getAsString()));
    }

    public Float getCircleStrokeOpacity() {
        if (this.jsonObject.get("circle-stroke-opacity").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("circle-stroke-opacity").getAsFloat());
    }

    public Float getCircleStrokeWidth() {
        if (this.jsonObject.get("circle-stroke-width").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("circle-stroke-width").getAsFloat());
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    String getName() {
        return "Circle";
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    Geometry getOffsetGeometry(Projection projection, MoveDistancesObject moveDistancesObject, float f, float f2) {
        LatLng latLngFromScreenLocation = projection.fromScreenLocation(new PointF(moveDistancesObject.getCurrentX() - f, moveDistancesObject.getCurrentY() - f2));
        if (latLngFromScreenLocation.getLatitude() > 85.05112877980659d || latLngFromScreenLocation.getLatitude() < -85.05112877980659d) {
            return null;
        }
        return Point.fromLngLat(latLngFromScreenLocation.getLongitude(), latLngFromScreenLocation.getLatitude());
    }

    public LatLng getPosition() {
        return new LatLng(((Point) this.geometry).latitude(), ((Point) this.geometry).longitude());
    }

    public void setCircleBlur(Float f) {
        this.jsonObject.addProperty("circle-blur", f);
    }

    public void setCircleColor(int i) {
        this.jsonObject.addProperty("circle-color", ColorUtils.colorToRgbaString(i));
    }

    public void setCircleColor(String str) {
        this.jsonObject.addProperty("circle-color", str);
    }

    public void setCircleOpacity(Float f) {
        this.jsonObject.addProperty("circle-opacity", f);
    }

    public void setCircleRadius(Float f) {
        this.jsonObject.addProperty("circle-radius", f);
    }

    public void setCircleStrokeColor(int i) {
        this.jsonObject.addProperty("circle-stroke-color", ColorUtils.colorToRgbaString(i));
    }

    public void setCircleStrokeColor(String str) {
        this.jsonObject.addProperty("circle-stroke-color", str);
    }

    public void setCircleStrokeOpacity(Float f) {
        this.jsonObject.addProperty("circle-stroke-opacity", f);
    }

    public void setCircleStrokeWidth(Float f) {
        this.jsonObject.addProperty("circle-stroke-width", f);
    }

    public void setPosition(LatLng latLng) {
        this.geometry = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    void setUsedDataDrivenProperties() {
        if (!(this.jsonObject.get("circle-radius") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("circle-radius");
        }
        if (!(this.jsonObject.get("circle-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("circle-color");
        }
        if (!(this.jsonObject.get("circle-blur") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("circle-blur");
        }
        if (!(this.jsonObject.get("circle-opacity") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("circle-opacity");
        }
        if (!(this.jsonObject.get("circle-stroke-width") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("circle-stroke-width");
        }
        if (!(this.jsonObject.get("circle-stroke-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("circle-stroke-color");
        }
        if (this.jsonObject.get("circle-stroke-opacity") instanceof JsonNull) {
            return;
        }
        this.annotationManager.enableDataDrivenProperty("circle-stroke-opacity");
    }
}
