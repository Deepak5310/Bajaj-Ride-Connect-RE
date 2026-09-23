package com.bajajconnect.navigate.maps.traffic;

import android.graphics.Color;
import android.os.Handler;
import com.google.gson.JsonObject;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.style.sources.Source;
import com.mappls.sdk.maps.utils.ColorUtils;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.predictive.distance.PredictiveDistanceCriteria;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public final class TrafficPlugin implements MapView.OnDidFinishLoadingStyleListener, MapView.OnCameraDidChangeListener {
    private static final double EARTH_RADIUS = 6371009.0d;
    private boolean enabled;
    private List<String> layerIds;
    private MapplsMap mapplsMap;
    private Handler handler = new Handler();
    private Call<JsonObject> stringCall = null;
    private Runnable callTrafficAPI = new Runnable() { // from class: com.bajajconnect.navigate.maps.traffic.TrafficPlugin$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.hitTrafficAPi();
        }
    };

    public TrafficPlugin(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        updateState();
        mapView.addOnDidFinishLoadingStyleListener(this);
        mapView.addOnCameraDidChangeListener(this);
    }

    private static LatLng computeOffset(LatLng latLng, double d, double d2) {
        double d3 = d / EARTH_RADIUS;
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(latLng.getLatitude());
        double radians3 = Math.toRadians(latLng.getLongitude());
        double dCos = Math.cos(d3);
        double dSin = Math.sin(d3);
        double dSin2 = Math.sin(radians2);
        double dCos2 = dSin * Math.cos(radians2);
        double dCos3 = (dCos * dSin2) + (Math.cos(radians) * dCos2);
        return new LatLng(Math.toDegrees(Math.asin(dCos3)), Math.toDegrees(radians3 + Math.atan2(dCos2 * Math.sin(radians), dCos - (dSin2 * dCos3))));
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        if (z != this.enabled) {
            this.enabled = z;
            updateState();
        }
        if (z) {
            scheduleAPICall();
        }
    }

    public void toggle() {
        this.enabled = !this.enabled;
        updateState();
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        updateState();
        if (isEnabled()) {
            scheduleAPICall();
        }
    }

    @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
    public void onCameraDidChange(boolean z) {
        scheduleAPICall();
    }

    private void scheduleAPICall() {
        this.handler.removeCallbacksAndMessages(null);
        Call<JsonObject> call = this.stringCall;
        if (call != null && call.isExecuted()) {
            this.stringCall.cancel();
        }
        this.handler.postDelayed(this.callTrafficAPI, 400L);
    }

    private void updateState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.traffic.TrafficPlugin.1
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (style.getSource(PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC) == null) {
                    TrafficPlugin.this.initialise(style);
                } else {
                    TrafficPlugin trafficPlugin = TrafficPlugin.this;
                    trafficPlugin.setVisibility(trafficPlugin.enabled, style);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialise(Style style) {
        this.layerIds = new ArrayList();
        addTrafficSource(style);
        addTrafficLayers(style);
    }

    private void addTrafficSource(Style style) {
        style.addSource(new GeoJsonSource(PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC));
    }

    private void addTrafficLayers(Style style) {
        try {
            addLocalLayer(style);
        } catch (Exception e) {
            Timber.e(e);
            Timber.e("Unable to attach Traffic Layers to current style.", new Object[0]);
        }
    }

    private void addLocalLayer(Style style) {
        addTrafficLayersToMap(TrafficLayer.getLineLayer("traffic-local-case", 0.0f, null, Local.FUNCTION_LINE_COLOR_CASE, Local.FUNCTION_LINE_WIDTH_CASE, null, Local.FUNCTION_LINE_OPACITY_CASE), TrafficLayer.getLineLayer("traffic-local", 0.0f, null, Local.FUNCTION_LINE_COLOR, Local.FUNCTION_LINE_WIDTH, null), "water_str_lbl", style);
    }

    private String getLastAddedLayerId() {
        List<String> list = this.layerIds;
        return list.get(list.size() - 1);
    }

    private void addTrafficLayersToMap(Layer layer, Layer layer2, String str, Style style) {
        if (style.getLayer(str) != null) {
            style.addLayerBelow(layer, str);
        } else {
            style.addLayer(layer);
        }
        style.addLayerAbove(layer2, layer.getId());
        this.layerIds.add(layer.getId());
        this.layerIds.add(layer2.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibility(boolean z, Style style) {
        if (this.layerIds == null) {
            return;
        }
        for (Layer layer : style.getLayers()) {
            if (this.layerIds.contains(layer.getId())) {
                PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
                layer.setProperties(propertyValueArr);
            }
        }
    }

    public LatLngBounds toBounds(LatLng latLng, double d) {
        double dSqrt = d * Math.sqrt(2.0d);
        LatLng latLngComputeOffset = computeOffset(latLng, dSqrt, 225.0d);
        LatLng latLngComputeOffset2 = computeOffset(latLng, dSqrt, 45.0d);
        return LatLngBounds.from(latLngComputeOffset2.getLatitude(), latLngComputeOffset2.getLongitude(), latLngComputeOffset.getLatitude(), latLngComputeOffset.getLongitude());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hitTrafficAPi() {
        Source source;
        LatLngBounds latLngBounds = this.mapplsMap.getProjection().getVisibleRegion().latLngBounds;
        int i = (int) this.mapplsMap.getCameraPosition().zoom;
        try {
            LatLngBounds bounds = toBounds(latLngBounds.getCenter(), latLngBounds.getNorthEast().distanceTo(latLngBounds.getCenter()));
            if (i < 10) {
                return;
            }
            BoundingBox boundingBox = new BoundingBox(bounds.getLatSouth(), bounds.getLonWest(), bounds.getLatNorth(), bounds.getLonEast());
            if (this.mapplsMap.getStyle() == null || !this.mapplsMap.getStyle().isFullyLoaded() || (source = this.mapplsMap.getStyle().getSource(PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC)) == null) {
                return;
            }
            ((GeoJsonSource) source).setUri(getUrl(boundingBox, i));
        } catch (IllegalArgumentException | Exception unused) {
        }
    }

    private String getUrl(BoundingBox boundingBox, int i) {
        return "https://apis.mappls.com/advancedmaps/v1/" + MapplsAccountManager.getInstance().getRestAPIKey() + "/traffic_geo_json?minx=" + boundingBox.getMinX() + "&maxx=" + boundingBox.getMaxX() + "&maxy=" + boundingBox.getMaxY() + "&miny=" + boundingBox.getMinY() + "&zoom=" + i;
    }

    private static class TrafficLayer {
        private TrafficLayer() {
        }

        static LineLayer getLineLayer(String str, float f, Expression expression, Expression expression2, Expression expression3, Expression expression4) {
            return getLineLayer(str, f, expression, expression2, expression3, expression4, null);
        }

        static LineLayer getLineLayer(String str, float f, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5) {
            LineLayer lineLayer = new LineLayer(str, PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC);
            lineLayer.setSourceLayer(PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC);
            lineLayer.setProperties(PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.lineColor(expression2), PropertyFactory.lineWidth(expression3), PropertyFactory.lineOffset(expression4));
            if (expression5 != null) {
                lineLayer.setProperties(PropertyFactory.lineOpacity(expression5));
            }
            if (expression != null) {
                lineLayer.setFilter(expression);
            }
            lineLayer.setMinZoom(f);
            return lineLayer;
        }
    }

    private static class TrafficFunction {
        private TrafficFunction() {
        }

        static Expression getLineColorFunction(int i, int i2, int i3, int i4) {
            return Expression.match(Expression.get("tType"), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(0))), Expression.stop("fast", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i)))), Expression.stop("medium", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2)))), Expression.stop("slow", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i3)))), Expression.stop("severe", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i4)))));
        }
    }

    private static class TrafficData {
        private static final String SOURCE_ID = "traffic";
        private static final String SOURCE_LAYER = "traffic";

        private TrafficData() {
        }
    }

    private static class TrafficType {
        static final Expression FUNCTION_LINE_COLOR = TrafficFunction.getLineColorFunction(TrafficColor.BASE_GREEN, TrafficColor.BASE_YELLOW, TrafficColor.BASE_ORANGE, TrafficColor.BASE_RED);
        static final Expression FUNCTION_LINE_COLOR_CASE = TrafficFunction.getLineColorFunction(TrafficColor.CASE_GREEN, TrafficColor.CASE_YELLOW, TrafficColor.CASE_ORANGE, TrafficColor.CASE_RED);

        private TrafficType() {
        }
    }

    private static class Local extends TrafficType {
        private static final String BASE_LAYER_ID = "traffic-local";
        static final Expression FUNCTION_LINE_OFFSET;
        static final Expression FUNCTION_LINE_OPACITY_CASE;
        static final Expression FUNCTION_LINE_WIDTH;
        static final Expression FUNCTION_LINE_WIDTH_CASE;
        private static final String LOCAL_CASE_LAYER_ID = "traffic-local-case";
        private static final float ZOOM_LEVEL = 15.0f;

        private Local() {
            super();
        }

        static {
            Float fValueOf = Float.valueOf(1.5f);
            FUNCTION_LINE_WIDTH = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(14, fValueOf), Expression.stop(20, Float.valueOf(10.5f)));
            FUNCTION_LINE_WIDTH_CASE = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(14, Float.valueOf(2.5f)), Expression.stop(20, Float.valueOf(12.5f)));
            FUNCTION_LINE_OFFSET = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(14, Float.valueOf(2.0f)), Expression.stop(20, Float.valueOf(18.0f)));
            Float fValueOf2 = Float.valueOf(1.0f);
            FUNCTION_LINE_OPACITY_CASE = Expression.interpolate(Expression.exponential(fValueOf2), Expression.zoom(), Expression.stop(15, Float.valueOf(0.0f)), Expression.stop(16, fValueOf2));
        }
    }

    private static class TrafficColor {
        private static final int BASE_GREEN = Color.parseColor("#39c66d");
        private static final int CASE_GREEN = Color.parseColor("#059441");
        private static final int BASE_YELLOW = Color.parseColor("#ff8c1a");
        private static final int CASE_YELLOW = Color.parseColor("#d66b00");
        private static final int BASE_ORANGE = Color.parseColor("#ff0015");
        private static final int CASE_ORANGE = Color.parseColor("#bd0010");
        private static final int BASE_RED = Color.parseColor("#981b25");
        private static final int CASE_RED = Color.parseColor("#5f1117");

        private TrafficColor() {
        }
    }
}
