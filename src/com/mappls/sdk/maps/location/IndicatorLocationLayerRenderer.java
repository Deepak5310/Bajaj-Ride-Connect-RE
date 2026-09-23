package com.mappls.sdk.maps.location;

import android.graphics.Bitmap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.utils.ColorUtils;

/* JADX INFO: loaded from: classes4.dex */
class IndicatorLocationLayerRenderer implements LocationLayerRenderer {
    private LatLng lastLatLng;
    private Layer layer;
    private final LayerSourceProvider layerSourceProvider;
    private Style style;
    private double lastBearing = 0.0d;
    private float lastAccuracy = 0.0f;

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void adjustPulsingCircleLayerVisibility(boolean z) {
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void cameraBearingUpdated(double d) {
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void cameraTiltUpdated(double d) {
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void stylePulsingCircle(LocationComponentOptions locationComponentOptions) {
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void updateIconIds(String str, String str2, String str3, String str4, String str5) {
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void updatePulsingUi(float f, Float f2) {
    }

    IndicatorLocationLayerRenderer(LayerSourceProvider layerSourceProvider) {
        this.layerSourceProvider = layerSourceProvider;
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void initializeComponents(Style style) {
        this.style = style;
        this.layer = this.layerSourceProvider.generateLocationComponentLayer();
        LatLng latLng = this.lastLatLng;
        if (latLng != null) {
            setLatLng(latLng);
        }
        setLayerBearing(this.lastBearing);
        setAccuracyRadius(Float.valueOf(this.lastAccuracy));
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void addLayers(LocationComponentPositionManager locationComponentPositionManager) {
        locationComponentPositionManager.addLayerToMap(this.layer);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void removeLayers() {
        this.style.removeLayer(this.layer);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void hide() {
        setLayerVisibility(false);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void show(int i, boolean z) {
        setImages(i, z);
        setLayerVisibility(true);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void styleAccuracy(float f, int i) {
        float[] fArrColorToRgbaArray = ColorUtils.colorToRgbaArray(i);
        fArrColorToRgbaArray[3] = f;
        Expression expressionRgba = Expression.rgba(Float.valueOf(fArrColorToRgbaArray[0]), Float.valueOf(fArrColorToRgbaArray[1]), Float.valueOf(fArrColorToRgbaArray[2]), Float.valueOf(fArrColorToRgbaArray[3]));
        this.layer.setProperties(LocationPropertyFactory.accuracyRadiusColor(expressionRgba), LocationPropertyFactory.accuracyRadiusBorderColor(expressionRgba));
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setLatLng(LatLng latLng) {
        setLayerLocation(latLng);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setGpsBearing(Float f) {
        setLayerBearing(f.floatValue());
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setCompassBearing(Float f) {
        setLayerBearing(f.floatValue());
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setAccuracyRadius(Float f) {
        this.layer.setProperties(LocationPropertyFactory.accuracyRadius(f));
        this.lastAccuracy = f.floatValue();
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void styleScaling(Expression expression) {
        this.layer.setProperties(LocationPropertyFactory.shadowImageSize(expression), LocationPropertyFactory.bearingImageSize(expression), LocationPropertyFactory.topImageSize(expression));
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setLocationStale(boolean z, int i) {
        setImages(i, z);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void addBitmaps(int i, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        if (bitmap != null) {
            this.style.addImage("mappls-location-shadow-icon", bitmap);
        } else {
            this.style.removeImage("mappls-location-shadow-icon");
        }
        this.style.addImage("mappls-location-icon", bitmap5);
        this.style.addImage("mappls-location-stale-icon", bitmap6);
        if (i == 4) {
            this.style.addImage("mappls-location-bearing-icon", BitmapUtils.mergeBitmap(bitmap4, bitmap2, (bitmap4.getWidth() - bitmap2.getWidth()) / 2.0f, (bitmap4.getHeight() - bitmap2.getHeight()) / 2.0f));
            this.style.addImage("mappls-location-bearing-stale-icon", BitmapUtils.mergeBitmap(bitmap4, bitmap3, (bitmap4.getWidth() - bitmap3.getWidth()) / 2.0f, (bitmap4.getHeight() - bitmap3.getHeight()) / 2.0f));
            return;
        }
        this.style.addImage("mappls-location-stroke-icon", bitmap2);
        this.style.addImage("mappls-location-background-stale-icon", bitmap3);
        this.style.addImage("mappls-location-bearing-icon", bitmap4);
    }

    private void setLayerVisibility(boolean z) {
        Layer layer = this.layer;
        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
        propertyValueArr[0] = LocationPropertyFactory.visibility(z ? "visible" : "none");
        layer.setProperties(propertyValueArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void setLayerLocation(LatLng latLng) {
        this.layer.setProperties(LocationPropertyFactory.location(new Double[]{Double.valueOf(latLng.getLatitude()), Double.valueOf(latLng.getLongitude()), Double.valueOf(0.0d)}));
        this.lastLatLng = latLng;
    }

    private void setLayerBearing(double d) {
        this.layer.setProperties(LocationPropertyFactory.bearing(Double.valueOf(d)));
        this.lastBearing = d;
    }

    private void setImages(int i, boolean z) {
        String str;
        String str2;
        String str3 = "mappls-location-shadow-icon";
        if (i != 4) {
            str = "";
            if (i == 8) {
                str2 = z ? "mappls-location-stale-icon" : "mappls-location-icon";
                str3 = z ? "mappls-location-background-stale-icon" : "mappls-location-stroke-icon";
                setAccuracyRadius(Float.valueOf(0.0f));
            } else if (i != 18) {
                str3 = "";
                str2 = str3;
            } else {
                str = z ? "mappls-location-stale-icon" : "mappls-location-icon";
                str2 = z ? "mappls-location-background-stale-icon" : "mappls-location-stroke-icon";
            }
        } else {
            str = z ? "mappls-location-stale-icon" : "mappls-location-icon";
            str2 = z ? "mappls-location-bearing-stale-icon" : "mappls-location-bearing-icon";
        }
        this.layer.setProperties(LocationPropertyFactory.topImage(str), LocationPropertyFactory.bearingImage(str2), LocationPropertyFactory.shadowImage(str3));
    }
}
