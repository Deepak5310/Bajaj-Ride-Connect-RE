package com.mappls.sdk.plugin.annotation;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.gestures.MoveDistancesObject;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.utils.ColorUtils;

/* JADX INFO: loaded from: classes4.dex */
public class Symbol extends Annotation<Point> {
    private final AnnotationManager<?, Symbol, ?, ?, ?, ?> annotationManager;
    Bitmap icon;
    String mapplsPin;

    Symbol(long j, AnnotationManager<?, Symbol, ?, ?, ?, ?> annotationManager, JsonObject jsonObject, Point point, String str, Bitmap bitmap) {
        super(j, jsonObject, point);
        this.annotationManager = annotationManager;
        this.mapplsPin = str;
        this.icon = bitmap;
    }

    public String getIconAnchor() {
        if (this.jsonObject.get("icon-anchor").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("icon-anchor").getAsString();
    }

    public String getIconColor() {
        if (this.jsonObject.get("icon-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("icon-color").getAsString();
    }

    public Integer getIconColorAsInt() {
        if (this.jsonObject.get("icon-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("icon-color").getAsString()));
    }

    public Float getIconHaloBlur() {
        if (this.jsonObject.get("icon-halo-blur").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("icon-halo-blur").getAsFloat());
    }

    public String getIconHaloColor() {
        if (this.jsonObject.get("icon-halo-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("icon-halo-color").getAsString();
    }

    public Integer getIconHaloColorAsInt() {
        if (this.jsonObject.get("icon-halo-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("icon-halo-color").getAsString()));
    }

    public Float getIconHaloWidth() {
        if (this.jsonObject.get("icon-halo-width").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("icon-halo-width").getAsFloat());
    }

    public String getIconImage() {
        if (this.jsonObject.get("icon-image").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("icon-image").getAsString();
    }

    public PointF getIconOffset() {
        if (this.jsonObject.get("icon-offset").isJsonNull()) {
            return null;
        }
        JsonArray asJsonArray = this.jsonObject.getAsJsonArray("icon-offset");
        return new PointF(asJsonArray.get(0).getAsFloat(), asJsonArray.get(1).getAsFloat());
    }

    public Float getIconOpacity() {
        if (this.jsonObject.get("icon-opacity").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("icon-opacity").getAsFloat());
    }

    public Float getIconRotate() {
        if (this.jsonObject.get("icon-rotate").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("icon-rotate").getAsFloat());
    }

    public Float getIconSize() {
        if (this.jsonObject.get("icon-size").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("icon-size").getAsFloat());
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    String getName() {
        return "Symbol";
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
        if (this.geometry == 0) {
            return null;
        }
        return new LatLng(((Point) this.geometry).latitude(), ((Point) this.geometry).longitude());
    }

    public Float getSymbolSortKey() {
        if (this.jsonObject.get("symbol-sort-key").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("symbol-sort-key").getAsFloat());
    }

    public String getTextAnchor() {
        if (this.jsonObject.get("text-anchor").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("text-anchor").getAsString();
    }

    public String getTextColor() {
        if (this.jsonObject.get("text-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("text-color").getAsString();
    }

    public Integer getTextColorAsInt() {
        if (this.jsonObject.get("text-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("text-color").getAsString()));
    }

    public String getTextField() {
        if (this.jsonObject.get("text-field").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("text-field").getAsString();
    }

    public String[] getTextFont() {
        if (this.jsonObject.get("text-font").isJsonNull()) {
            return null;
        }
        JsonArray asJsonArray = this.jsonObject.getAsJsonArray("text-font");
        String[] strArr = new String[asJsonArray.size()];
        for (int i = 0; i < asJsonArray.size(); i++) {
            strArr[i] = asJsonArray.get(i).getAsString();
        }
        return strArr;
    }

    public Float getTextHaloBlur() {
        if (this.jsonObject.get("text-halo-blur").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-halo-blur").getAsFloat());
    }

    public String getTextHaloColor() {
        if (this.jsonObject.get("text-halo-color").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("text-halo-color").getAsString();
    }

    public Integer getTextHaloColorAsInt() {
        if (this.jsonObject.get("text-halo-color").isJsonNull()) {
            return null;
        }
        return Integer.valueOf(ColorUtils.rgbaToColor(this.jsonObject.get("text-halo-color").getAsString()));
    }

    public Float getTextHaloWidth() {
        if (this.jsonObject.get("text-halo-width").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-halo-width").getAsFloat());
    }

    public String getTextJustify() {
        if (this.jsonObject.get("text-justify").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("text-justify").getAsString();
    }

    public Float getTextLetterSpacing() {
        if (this.jsonObject.get("text-letter-spacing").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-letter-spacing").getAsFloat());
    }

    public Float getTextMaxWidth() {
        if (this.jsonObject.get("text-max-width").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-max-width").getAsFloat());
    }

    public PointF getTextOffset() {
        if (this.jsonObject.get("text-offset").isJsonNull()) {
            return null;
        }
        JsonArray asJsonArray = this.jsonObject.getAsJsonArray("text-offset");
        return new PointF(asJsonArray.get(0).getAsFloat(), asJsonArray.get(1).getAsFloat());
    }

    public Float getTextOpacity() {
        if (this.jsonObject.get("text-opacity").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-opacity").getAsFloat());
    }

    public Float getTextRadialOffset() {
        if (this.jsonObject.get("text-radial-offset").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-radial-offset").getAsFloat());
    }

    public Float getTextRotate() {
        if (this.jsonObject.get("text-rotate").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-rotate").getAsFloat());
    }

    public Float getTextSize() {
        if (this.jsonObject.get("text-size").isJsonNull()) {
            return null;
        }
        return Float.valueOf(this.jsonObject.get("text-size").getAsFloat());
    }

    public String getTextTransform() {
        if (this.jsonObject.get("text-transform").isJsonNull()) {
            return null;
        }
        return this.jsonObject.get("text-transform").getAsString();
    }

    public void setIconAnchor(String str) {
        this.jsonObject.addProperty("icon-anchor", str);
    }

    public void setIconColor(int i) {
        this.jsonObject.addProperty("icon-color", ColorUtils.colorToRgbaString(i));
    }

    public void setIconColor(String str) {
        this.jsonObject.addProperty("icon-color", str);
    }

    public void setIconHaloBlur(Float f) {
        this.jsonObject.addProperty("icon-halo-blur", f);
    }

    public void setIconHaloColor(int i) {
        this.jsonObject.addProperty("icon-halo-color", ColorUtils.colorToRgbaString(i));
    }

    public void setIconHaloColor(String str) {
        this.jsonObject.addProperty("icon-halo-color", str);
    }

    public void setIconHaloWidth(Float f) {
        this.jsonObject.addProperty("icon-halo-width", f);
    }

    public void setIconImage(String str) {
        this.jsonObject.addProperty("icon-image", str);
    }

    public void setIconOffset(PointF pointF) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(Float.valueOf(pointF.x));
        jsonArray.add(Float.valueOf(pointF.y));
        this.jsonObject.add("icon-offset", jsonArray);
    }

    public void setIconOpacity(Float f) {
        this.jsonObject.addProperty("icon-opacity", f);
    }

    public void setIconRotate(Float f) {
        this.jsonObject.addProperty("icon-rotate", f);
    }

    public void setIconSize(Float f) {
        this.jsonObject.addProperty("icon-size", f);
    }

    public void setMapplsPin(String str) {
        this.geometry = null;
        this.mapplsPin = str;
    }

    public void setPosition(LatLng latLng) {
        this.mapplsPin = null;
        this.geometry = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
    }

    public void setSymbolSortKey(Float f) {
        this.jsonObject.addProperty("symbol-sort-key", f);
    }

    public void setTextAnchor(String str) {
        this.jsonObject.addProperty("text-anchor", str);
    }

    public void setTextColor(int i) {
        this.jsonObject.addProperty("text-color", ColorUtils.colorToRgbaString(i));
    }

    public void setTextColor(String str) {
        this.jsonObject.addProperty("text-color", str);
    }

    public void setTextField(String str) {
        this.jsonObject.addProperty("text-field", str);
    }

    public void setTextFont(String[] strArr) {
        JsonArray jsonArray = new JsonArray();
        for (String str : strArr) {
            jsonArray.add(str);
        }
        this.jsonObject.add("text-font", jsonArray);
    }

    public void setTextHaloBlur(Float f) {
        this.jsonObject.addProperty("text-halo-blur", f);
    }

    public void setTextHaloColor(int i) {
        this.jsonObject.addProperty("text-halo-color", ColorUtils.colorToRgbaString(i));
    }

    public void setTextHaloColor(String str) {
        this.jsonObject.addProperty("text-halo-color", str);
    }

    public void setTextHaloWidth(Float f) {
        this.jsonObject.addProperty("text-halo-width", f);
    }

    public void setTextJustify(String str) {
        this.jsonObject.addProperty("text-justify", str);
    }

    public void setTextLetterSpacing(Float f) {
        this.jsonObject.addProperty("text-letter-spacing", f);
    }

    public void setTextMaxWidth(Float f) {
        this.jsonObject.addProperty("text-max-width", f);
    }

    public void setTextOffset(PointF pointF) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(Float.valueOf(pointF.x));
        jsonArray.add(Float.valueOf(pointF.y));
        this.jsonObject.add("text-offset", jsonArray);
    }

    public void setTextOpacity(Float f) {
        this.jsonObject.addProperty("text-opacity", f);
    }

    public void setTextRadialOffset(Float f) {
        this.jsonObject.addProperty("text-radial-offset", f);
    }

    public void setTextRotate(Float f) {
        this.jsonObject.addProperty("text-rotate", f);
    }

    public void setTextSize(Float f) {
        this.jsonObject.addProperty("text-size", f);
    }

    public void setTextTransform(String str) {
        this.jsonObject.addProperty("text-transform", str);
    }

    @Override // com.mappls.sdk.plugin.annotation.Annotation
    void setUsedDataDrivenProperties() {
        if (!(this.jsonObject.get("symbol-sort-key") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("symbol-sort-key");
        }
        if (!(this.jsonObject.get("icon-size") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-size");
        }
        if (!(this.jsonObject.get("icon-image") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-image");
        }
        if (!(this.jsonObject.get("icon-rotate") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-rotate");
        }
        if (!(this.jsonObject.get("icon-offset") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-offset");
        }
        if (!(this.jsonObject.get("icon-anchor") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-anchor");
        }
        if (!(this.jsonObject.get("text-field") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-field");
        }
        if (!(this.jsonObject.get("text-font") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-font");
        }
        if (!(this.jsonObject.get("text-size") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-size");
        }
        if (!(this.jsonObject.get("text-max-width") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-max-width");
        }
        if (!(this.jsonObject.get("text-letter-spacing") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-letter-spacing");
        }
        if (!(this.jsonObject.get("text-justify") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-justify");
        }
        if (!(this.jsonObject.get("text-radial-offset") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-radial-offset");
        }
        if (!(this.jsonObject.get("text-anchor") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-anchor");
        }
        if (!(this.jsonObject.get("text-rotate") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-rotate");
        }
        if (!(this.jsonObject.get("text-transform") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-transform");
        }
        if (!(this.jsonObject.get("text-offset") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-offset");
        }
        if (!(this.jsonObject.get("icon-opacity") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-opacity");
        }
        if (!(this.jsonObject.get("icon-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-color");
        }
        if (!(this.jsonObject.get("icon-halo-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-halo-color");
        }
        if (!(this.jsonObject.get("icon-halo-width") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-halo-width");
        }
        if (!(this.jsonObject.get("icon-halo-blur") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("icon-halo-blur");
        }
        if (!(this.jsonObject.get("text-opacity") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-opacity");
        }
        if (!(this.jsonObject.get("text-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-color");
        }
        if (!(this.jsonObject.get("text-halo-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-halo-color");
        }
        if (!(this.jsonObject.get("text-halo-width") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("text-halo-width");
        }
        if (this.jsonObject.get("text-halo-blur") instanceof JsonNull) {
            return;
        }
        this.annotationManager.enableDataDrivenProperty("text-halo-blur");
    }
}
