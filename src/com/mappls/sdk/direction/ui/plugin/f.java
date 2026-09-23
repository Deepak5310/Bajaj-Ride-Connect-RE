package com.mappls.sdk.direction.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.EnvironmentCompat;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.Property;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.utils.ColorUtils;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.utils.CongestionDelayInfo;
import com.mappls.sdk.services.utils.MapplsUtils;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements MapView.OnDidFinishLoadingStyleListener, MapplsMap.OnMapClickListener {
    private MapplsMap c;
    private MapView d;
    private ArrayList e;
    private ArrayList f;
    private List<LatLng> i;
    private HashMap<Integer, CostEstimationResponse> m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private o f702n;
    private DirectionOptions o;
    Handler a = new Handler(Looper.getMainLooper());
    boolean b = false;
    private LatLng g = null;
    private LatLng h = null;
    private List<DirectionsRoute> j = null;
    private int k = 0;
    private String l = "driving";
    private boolean p = true;
    Runnable q = new a();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a(f.this);
        }
    }

    final class b implements Style.OnStyleLoaded {
        b() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            if (style.getSourceAs("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID") == null) {
                f.a(f.this, style);
                return;
            }
            f fVar = f.this;
            fVar.getClass();
            f.a(fVar, false, style);
        }
    }

    final class c implements Style.OnStyleLoaded {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            if (style.getLayer("com.mappls.sdk.directions.route_alternate") != null) {
                Layer layer = style.getLayer("com.mappls.sdk.directions.route_alternate");
                PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                propertyValueArr[0] = PropertyFactory.visibility(this.a ? "none" : "visible");
                layer.setProperties(propertyValueArr);
            }
            if (style.getLayer("com.mappls.sdk.directions.route_alternate_case") != null) {
                Layer layer2 = style.getLayer("com.mappls.sdk.directions.route_alternate_case");
                PropertyValue<?>[] propertyValueArr2 = new PropertyValue[1];
                propertyValueArr2[0] = PropertyFactory.visibility(this.a ? "none" : "visible");
                layer2.setProperties(propertyValueArr2);
            }
            if (style.getLayer("com.mappls.sdk.direction.ui.route_alternate_dotted") != null) {
                Layer layer3 = style.getLayer("com.mappls.sdk.direction.ui.route_alternate_dotted");
                PropertyValue<?>[] propertyValueArr3 = new PropertyValue[1];
                propertyValueArr3[0] = PropertyFactory.visibility(this.a ? "none" : "visible");
                layer3.setProperties(propertyValueArr3);
            }
            if (style.getLayer("com.mappls.sdk.directions.directions-callout-marker-layer") != null) {
                Layer layer4 = style.getLayer("com.mappls.sdk.directions.directions-callout-marker-layer");
                PropertyValue<?>[] propertyValueArr4 = new PropertyValue[1];
                propertyValueArr4[0] = PropertyFactory.visibility(this.a ? "none" : "visible");
                layer4.setProperties(propertyValueArr4);
            }
        }
    }

    final class d implements Style.OnStyleLoaded {
        d() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            f.a(f.this, true, style);
        }
    }

    private static class e extends h {
        private static final Expression a = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("alternate-walking", Boolean.TRUE));
    }

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.plugin.f$f, reason: collision with other inner class name */
    private static class C0075f extends h {
        static final Expression a;
        static final Expression b;
        static final Expression c;
        private static final Expression d;

        static {
            Float fValueOf = Float.valueOf(1.5f);
            Expression.Interpolator interpolatorExponential = Expression.exponential(fValueOf);
            Expression expressionZoom = Expression.zoom();
            Float fValueOf2 = Float.valueOf(4.0f);
            Float fValueOf3 = Float.valueOf(10.0f);
            Float fValueOf4 = Float.valueOf(13.0f);
            Float fValueOf5 = Float.valueOf(16.0f);
            Float fValueOf6 = Float.valueOf(19.0f);
            Float fValueOf7 = Float.valueOf(22.0f);
            a = Expression.interpolate(interpolatorExponential, expressionZoom, Expression.stop(fValueOf2, fValueOf2), Expression.stop(fValueOf3, Float.valueOf(6.5f)), Expression.stop(fValueOf4, Float.valueOf(7.0f)), Expression.stop(fValueOf5, Float.valueOf(9.0f)), Expression.stop(fValueOf6, Float.valueOf(14.0f)), Expression.stop(fValueOf7, Float.valueOf(18.0f)));
            b = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(fValueOf2, Float.valueOf(5.0f)), Expression.stop(fValueOf3, Float.valueOf(7.5f)), Expression.stop(fValueOf4, Float.valueOf(8.5f)), Expression.stop(fValueOf5, Float.valueOf(10.5f)), Expression.stop(fValueOf6, fValueOf5), Expression.stop(fValueOf7, Float.valueOf(27.0f)));
            Expression.Interpolator interpolatorExponential2 = Expression.exponential(fValueOf);
            Expression expressionZoom2 = Expression.zoom();
            Float fValueOf8 = Float.valueOf(0.0f);
            c = Expression.interpolate(interpolatorExponential2, expressionZoom2, Expression.stop(7, fValueOf8), Expression.stop(9, fValueOf8), Expression.stop(11, fValueOf8), Expression.stop(18, fValueOf8), Expression.stop(20, fValueOf8));
            Float fValueOf9 = Float.valueOf(1.0f);
            Expression.interpolate(Expression.exponential(fValueOf9), Expression.zoom(), Expression.stop(15, fValueOf9), Expression.stop(16, fValueOf9));
            d = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("alternate", Boolean.TRUE));
        }
    }

    private static class g extends h {
        private static final Expression a = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("line-point-marker", Boolean.TRUE));
    }

    private static class h {
        static {
            k.a(j.a, j.c);
            k.a(j.b, j.d);
        }
    }

    private static class i extends h {
        private static final Expression a = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("com.mappls.sdk.directions.directions-property-value-filter-callouts", Expression.literal(true)));
    }

    private static class j {
        private static final int a = Color.parseColor("#07b9fc");
        private static final int b = Color.parseColor("#000000");
        private static final int c = Color.parseColor("#a1bbd2");
        private static final int d = Color.parseColor("#000000");
    }

    private static class k {
        static void a(int i, int i2) {
            Expression.match(Expression.get("mappls_direction_direction_type"), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(0))), Expression.stop("selected", Expression.match(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i))), Expression.stop("moderate", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#ff8c1a"))))), Expression.stop("heavy", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#981b25"))))), Expression.stop("severe", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#8b0000"))))))), Expression.stop("alternate", Expression.match(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2))), Expression.stop("moderate", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#BEA087")))), Expression.stop("heavy", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#B58281")))), Expression.stop("severe", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#EFA7A7")))))));
        }
    }

    private static class l {
        static LineLayer a(String str, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5) {
            LineLayer lineLayer = new LineLayer(str, "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
            lineLayer.setSourceLayer("directions");
            lineLayer.setProperties(PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.lineColor(expression2), PropertyFactory.lineWidth(expression3), PropertyFactory.lineOffset(expression4));
            if (expression5 != null) {
                lineLayer.setProperties(PropertyFactory.lineOpacity(expression5));
            }
            if (expression != null) {
                lineLayer.setFilter(expression);
            }
            return lineLayer;
        }
    }

    private static class m extends h {
        private static final Expression a = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("segment", Boolean.TRUE));
    }

    private static class n extends h {
        private static final Expression a;

        static {
            Expression expression = Expression.get("mappls_direction_direction_type");
            Expression expressionLiteral = Expression.literal(false);
            Boolean bool = Boolean.TRUE;
            a = Expression.match(expression, expressionLiteral, Expression.stop("marker", bool));
            Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("advices", bool));
        }
    }

    public interface o {
        void a(int i, DirectionsRoute directionsRoute);
    }

    private static class p extends h {
        private static final Expression a = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("selected-walking", Boolean.TRUE));
    }

    private static class q extends h {
        static final Expression a;
        static final Expression b;
        static final Expression c;
        static final Expression d;
        private static final Expression e;

        static {
            Float fValueOf = Float.valueOf(1.5f);
            Expression.Interpolator interpolatorExponential = Expression.exponential(fValueOf);
            Expression expressionZoom = Expression.zoom();
            Float fValueOf2 = Float.valueOf(4.0f);
            Float fValueOf3 = Float.valueOf(10.0f);
            Float fValueOf4 = Float.valueOf(13.0f);
            Float fValueOf5 = Float.valueOf(16.0f);
            Float fValueOf6 = Float.valueOf(19.0f);
            Float fValueOf7 = Float.valueOf(22.0f);
            a = Expression.interpolate(interpolatorExponential, expressionZoom, Expression.stop(fValueOf2, fValueOf2), Expression.stop(fValueOf3, Float.valueOf(6.5f)), Expression.stop(fValueOf4, Float.valueOf(7.0f)), Expression.stop(fValueOf5, Float.valueOf(9.0f)), Expression.stop(fValueOf6, Float.valueOf(14.0f)), Expression.stop(fValueOf7, Float.valueOf(18.0f)));
            b = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(fValueOf2, Float.valueOf(5.0f)), Expression.stop(fValueOf3, Float.valueOf(7.5f)), Expression.stop(fValueOf4, Float.valueOf(8.5f)), Expression.stop(fValueOf5, Float.valueOf(10.5f)), Expression.stop(fValueOf6, fValueOf5), Expression.stop(fValueOf7, Float.valueOf(27.0f)));
            Expression.Interpolator interpolatorExponential2 = Expression.exponential(fValueOf);
            Expression expressionZoom2 = Expression.zoom();
            Float fValueOf8 = Float.valueOf(0.0f);
            c = Expression.interpolate(interpolatorExponential2, expressionZoom2, Expression.stop(14, fValueOf8), Expression.stop(20, fValueOf8));
            Float fValueOf9 = Float.valueOf(1.0f);
            d = Expression.interpolate(Expression.exponential(fValueOf9), Expression.zoom(), Expression.stop(15, fValueOf9), Expression.stop(16, fValueOf9));
            e = Expression.match(Expression.get("mappls_direction_direction_type"), Expression.literal(false), Expression.stop("selected", Boolean.TRUE));
        }
    }

    private static class r {
        static Bitmap a(LinearLayout linearLayout) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            linearLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            int measuredWidth = linearLayout.getMeasuredWidth();
            int measuredHeight = linearLayout.getMeasuredHeight();
            linearLayout.layout(0, 0, measuredWidth, measuredHeight);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            options.inBitmap = bitmapCreateBitmap;
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 > measuredHeight || i3 > measuredWidth) {
                int i4 = i2 / 2;
                int i5 = i3 / 2;
                while (i4 / i >= measuredHeight && i5 / i >= measuredWidth) {
                    i *= 2;
                }
            }
            options.inSampleSize = i;
            Bitmap bitmap = options.inBitmap;
            bitmap.eraseColor(0);
            linearLayout.draw(new Canvas(bitmap));
            return bitmap;
        }
    }

    public f(MapView mapView, MapplsMap mapplsMap, DirectionOptions directionOptions) {
        this.c = mapplsMap;
        this.d = mapView;
        this.o = directionOptions;
        c();
        mapView.addOnDidFinishLoadingStyleListener(this);
        mapplsMap.addOnMapClickListener(this);
    }

    private static Expression a(int i2, int i3) {
        return Expression.match(Expression.get("mappls_direction_direction_type"), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(0))), Expression.stop("selected", Expression.match(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2))), Expression.stop("moderate", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#ff8c1a"))))), Expression.stop("heavy", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#981b25"))))), Expression.stop("severe", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#8b0000"))))), Expression.stop("low", Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2)))), Expression.stop(EnvironmentCompat.MEDIA_UNKNOWN, Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i2)))))), Expression.stop("alternate", Expression.match(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION), Expression.toColor(Expression.literal(ColorUtils.colorToRgbaString(i3))), Expression.stop("moderate", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#BEA087")))), Expression.stop("heavy", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#B58281")))), Expression.stop("severe", Expression.literal(ColorUtils.colorToRgbaString(Color.parseColor("#EFA7A7")))))));
    }

    static void a(f fVar) {
        synchronized (fVar) {
            if (fVar.f != null) {
                Executors.newSingleThreadExecutor().execute(new com.mappls.sdk.direction.ui.plugin.g(fVar));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ed  */
    private void a(ArrayList arrayList) {
        int i2;
        String str;
        HashMap map = new HashMap();
        int i3 = 0;
        while (i3 < this.j.size()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.d.getContext()).inflate(R.layout.mappls_direction_duration_bubble, (ViewGroup) null);
            TextView textView = (TextView) linearLayout.findViewById(R.id.text_view_duration_callout);
            HashMap<Integer, CostEstimationResponse> map2 = this.m;
            if (map2 != null && map2.containsKey(Integer.valueOf(i3))) {
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.text_view_toll_callout);
                textView2.setTextColor(Color.parseColor(i3 == this.k ? "#ffffff" : "#212121"));
                CostEstimationResponse costEstimationResponse = this.m.get(Integer.valueOf(i3));
                if (costEstimationResponse != null) {
                    StringBuilder sb = new StringBuilder(" ₹ ");
                    if (costEstimationResponse.getHasTolls().booleanValue()) {
                        textView2.setVisibility(0);
                        if (costEstimationResponse.getTotalTollCost() == null) {
                            if (costEstimationResponse.getTotalFuelCost() == null || costEstimationResponse.getTotalFuelCost().intValue() <= 0) {
                                sb.append("NA (");
                                sb.append(costEstimationResponse.getTotalTolls());
                                sb.append(StringUtils.SPACE);
                                if (costEstimationResponse.getTotalTolls().intValue() > 1) {
                                    str = "Tolls)";
                                } else {
                                    str = "Toll)";
                                }
                            } else {
                                sb.append(costEstimationResponse.getTotalFuelCost());
                                str = " (Trip Cost) ";
                            }
                            sb.append(str);
                        } else if (costEstimationResponse.getTotalFuelCost() != null) {
                            sb.append(costEstimationResponse.getTotalTripCostEstimate());
                            sb.append(" (Trip Cost)");
                        } else {
                            sb.append(costEstimationResponse.getTotalTollCost());
                            sb.append(" (");
                            sb.append(costEstimationResponse.getTotalTolls());
                            sb.append(StringUtils.SPACE);
                            if (costEstimationResponse.getTotalTolls().intValue() > 1) {
                                str = "Tolls)";
                            } else {
                                str = "Toll)";
                            }
                            sb.append(str);
                        }
                    } else if (costEstimationResponse.getTotalFuelCost() == null || costEstimationResponse.getTotalFuelCost().intValue() <= 0) {
                        textView2.setVisibility(8);
                    } else {
                        sb.append(costEstimationResponse.getTotalFuelCost());
                        sb.append(" (Trip Cost)");
                        textView2.setVisibility(0);
                    }
                    textView2.setText(sb.toString());
                } else {
                    textView2.setVisibility(8);
                }
            }
            if (i3 == this.k) {
                linearLayout.setBackgroundResource(R.drawable.mappls_direction_eta_bubble_selected);
                textView.setTextColor(Color.parseColor("#ffffff"));
                i2 = R.drawable.mappls_direction_ic_baseline_access_time_white;
            } else {
                linearLayout.setBackgroundResource(R.drawable.mappls_direction_eta_bubble_alternate);
                textView.setTextColor(Color.parseColor("#212121"));
                i2 = R.drawable.mappls_direction_ic_baseline_access_time;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            DirectionOptions directionOptions = this.o;
            textView.setText((directionOptions == null || directionOptions.distanceType().intValue() == 0) ? String.format(Locale.getDefault(), "%s (%s)", DirectionFormatter.getFormattedDuration(this.j.get(i3).duration().doubleValue()), DirectionFormatter.getFormattedDistanceRound(this.j.get(i3).distance().doubleValue(), DistanceType.METRIC)) : String.format(Locale.getDefault(), "%s (%s)", DirectionFormatter.getFormattedDuration(this.j.get(i3).duration().doubleValue()), DirectionFormatter.getFormattedDistanceRound(this.j.get(i3).distance().doubleValue(), DistanceType.IMPERIAL)));
            textView.setPadding(com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 16.0f), com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 0.0f), com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 24.0f), com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 0.0f));
            Bitmap bitmapA = r.a(linearLayout);
            textView.setPadding(com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 24.0f), com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 0.0f), com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 16.0f), com.mappls.sdk.direction.ui.common.e.a(this.d.getContext(), 0.0f));
            Bitmap bitmapA2 = r.a(linearLayout);
            map.put(this.j.get(i3).duration() + "-selected", bitmapA);
            map.put(this.j.get(i3).duration() + "-alternative", bitmapA2);
            i3++;
        }
        this.d.post(new com.mappls.sdk.direction.ui.plugin.i(this, map, arrayList));
    }

    private void b(Style style) {
        Float fValueOf = Float.valueOf(1.0f);
        Expression expressionInterpolate = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(1, fValueOf), Expression.stop(2, fValueOf), Expression.stop(3, fValueOf), Expression.stop(4, fValueOf), Expression.stop(5, fValueOf), Expression.stop(6, Float.valueOf(2.0f)), Expression.stop(7, Float.valueOf(3.0f)), Expression.stop(8, Float.valueOf(4.0f)), Expression.stop(9, Float.valueOf(5.0f)), Expression.stop(10, Float.valueOf(6.0f)), Expression.stop(22, Float.valueOf(30.0f)));
        SymbolLayer symbolLayer = new SymbolLayer("com.mappls.sdk.direction.ui.route_alternate_dotted", "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
        Boolean bool = Boolean.TRUE;
        SymbolLayer symbolLayerWithFilter = symbolLayer.withProperties(PropertyFactory.iconImage("com.mappls.sdk.direction.ui.alternate_dotted_route_image"), PropertyFactory.iconIgnorePlacement(bool), PropertyFactory.symbolPlacement(Property.SYMBOL_PLACEMENT_LINE), PropertyFactory.symbolSpacing(expressionInterpolate), PropertyFactory.iconAllowOverlap(bool)).withFilter(e.a);
        ArrayList arrayList = this.e;
        String str = (String) arrayList.get(arrayList.size() - 1);
        if (str == null || style.getLayer(str) == null) {
            style.addLayer(symbolLayerWithFilter);
        } else {
            style.addLayerBelow(symbolLayerWithFilter, str);
        }
        this.e.add(symbolLayerWithFilter.getId());
    }

    private void c() {
        this.c.getStyle(new b());
    }

    private void c(Style style) {
        SymbolLayer symbolLayerWithFilter = new SymbolLayer("com.mappls.sdk.directions.directions-callout-marker-layer", "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID").withProperties(PropertyFactory.iconImage(Expression.string(Expression.get("com.mappls.sdk.directions.directions-property-icon-eta"))), PropertyFactory.iconAnchor(Expression.match(Expression.get("com.mappls.sdk.directions.directions-property-eta-selection-type"), Expression.literal("bottom-right"), Expression.stop("com.mappls.sdk.directions.directions-property-eta-selected-filter", Expression.literal("bottom-right")), Expression.stop("com.mappls.sdk.directions.directions-property-eta-alternative-filter", Expression.literal("bottom-left")))), PropertyFactory.iconAllowOverlap(Boolean.TRUE)).withFilter(i.a);
        symbolLayerWithFilter.setSourceLayer("directions");
        style.addLayer(symbolLayerWithFilter);
        this.e.add(symbolLayerWithFilter.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(Style style) {
        SymbolLayer symbolLayerWithProperties = new SymbolLayer("com.mappls.sdk.directions.directions-congestion-segment-marker-layer", "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID").withProperties(PropertyFactory.iconImage("{icon}"), PropertyFactory.iconAnchor("bottom-left"), PropertyFactory.symbolSortKey(Expression.get("com.mappls.sdk.directions.mappls_direction_segment-delay_marker-sort-key")), PropertyFactory.iconOffset(new Float[]{Float.valueOf(0.0f), Float.valueOf(2.0f)}));
        symbolLayerWithProperties.withFilter(m.a);
        symbolLayerWithProperties.setSourceLayer("directions");
        style.addLayer(symbolLayerWithProperties);
        this.e.add(symbolLayerWithProperties.getId());
    }

    private void e(Style style) {
        SymbolLayer symbolLayerWithProperties = new SymbolLayer("com.mappls.sdk.directions.directions-line-point-layer", "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID").withProperties(PropertyFactory.iconImage("{icon}"), PropertyFactory.iconPitchAlignment("map"), PropertyFactory.iconAllowOverlap(Boolean.TRUE), PropertyFactory.iconIgnorePlacement(Boolean.FALSE));
        symbolLayerWithProperties.withFilter(g.a);
        symbolLayerWithProperties.setSourceLayer("directions");
        style.addLayer(symbolLayerWithProperties);
        this.e.add(symbolLayerWithProperties.getId());
    }

    private void f(Style style) {
        Float fValueOf = Float.valueOf(1.0f);
        Expression expressionInterpolate = Expression.interpolate(Expression.exponential(fValueOf), Expression.zoom(), Expression.stop(1, fValueOf), Expression.stop(2, fValueOf), Expression.stop(3, fValueOf), Expression.stop(4, fValueOf), Expression.stop(5, fValueOf), Expression.stop(6, Float.valueOf(2.0f)), Expression.stop(7, Float.valueOf(3.0f)), Expression.stop(8, Float.valueOf(4.0f)), Expression.stop(9, Float.valueOf(5.0f)), Expression.stop(10, Float.valueOf(6.0f)), Expression.stop(22, Float.valueOf(30.0f)));
        SymbolLayer symbolLayer = new SymbolLayer("com.mappls.sdk.direction.ui.route_selected_dotted", "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
        Boolean bool = Boolean.TRUE;
        SymbolLayer symbolLayerWithFilter = symbolLayer.withProperties(PropertyFactory.iconImage("com.mappls.sdk.direction.ui.selected_dotted_route_image"), PropertyFactory.iconIgnorePlacement(bool), PropertyFactory.symbolPlacement(Property.SYMBOL_PLACEMENT_LINE), PropertyFactory.symbolSpacing(expressionInterpolate), PropertyFactory.iconAllowOverlap(bool)).withFilter(p.a);
        ArrayList arrayList = this.e;
        String str = (String) arrayList.get(arrayList.size() - 1);
        if (str == null || style.getLayer(str) == null) {
            style.addLayer(symbolLayerWithFilter);
        } else {
            style.addLayerAbove(symbolLayerWithFilter, str);
        }
        this.e.add(symbolLayerWithFilter.getId());
    }

    private void g(Style style) {
        Expression expression = q.e;
        Expression expressionA = a(this.o.selectedRouteColor().intValue(), this.o.alternateRouteColor().intValue());
        Expression expression2 = q.a;
        Expression expression3 = q.c;
        LineLayer lineLayerA = l.a("com.mappls.sdk.directions.route_selected", expression, expressionA, expression2, expression3, null);
        LineLayer lineLayerA2 = l.a("com.mappls.sdk.directions.route_selected_case", q.e, a(this.o.selectedCasingRouteColor().intValue(), this.o.alternateCasingRouteColor().intValue()), q.b, expression3, q.d);
        if (style.getLayer("traffic-local") != null) {
            style.addLayerAbove(lineLayerA2, "traffic-local");
        } else {
            style.addLayer(lineLayerA2);
        }
        style.addLayerAbove(lineLayerA, lineLayerA2.getId());
        this.e.add(lineLayerA2.getId());
        this.e.add(lineLayerA.getId());
    }

    private void h(Style style) {
        SymbolLayer symbolLayer = new SymbolLayer("com.mappls.sdk.directions.directions-marker-layer", "com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
        Boolean bool = Boolean.TRUE;
        SymbolLayer symbolLayerWithProperties = symbolLayer.withProperties(PropertyFactory.iconImage(Expression.get("com.mappls.sdk.directions.directions-marker-image")), PropertyFactory.iconAnchor("bottom"), PropertyFactory.iconAllowOverlap(bool), PropertyFactory.iconIgnorePlacement(bool));
        symbolLayerWithProperties.withFilter(n.a);
        symbolLayerWithProperties.setSourceLayer("directions");
        style.addLayer(symbolLayerWithProperties);
        this.e.add(symbolLayerWithProperties.getId());
    }

    public final void a() {
        if (this.c.getStyle() == null || !this.c.getStyle().isFullyLoaded()) {
            return;
        }
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.route_selected");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.route_selected_case");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.route_alternate_case");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.route_alternate");
        this.c.getStyle().removeLayer("com.mappls.sdk.direction.ui.route_alternate_dotted");
        this.c.getStyle().removeLayer("com.mappls.sdk.direction.ui.route_selected_dotted");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.directions-marker-layer");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.directions-line-point-layer");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.directions-marker-bearing-layer");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.directions-congestion-segment-marker-layer");
        this.c.getStyle().removeLayer("com.mappls.sdk.directions.directions-callout-marker-layer");
        this.c.getStyle().removeSource("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
    }

    public final void a(o oVar) {
        this.f702n = oVar;
    }

    public final void a(String str) {
        if (str != null) {
            this.l = str;
        }
    }

    public final void a(HashMap<Integer, CostEstimationResponse> map) {
        this.m = map;
        a((ArrayList) null);
    }

    public final void a(boolean z) {
        this.c.getStyle(new c(z));
    }

    public final void b() {
        GeoJsonSource geoJsonSource;
        if (this.c.getStyle() == null || !this.c.getStyle().isFullyLoaded() || (geoJsonSource = (GeoJsonSource) this.c.getStyle().getSourceAs("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID")) == null) {
            return;
        }
        geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(new ArrayList()));
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        c();
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
    public final boolean onMapClick(LatLng latLng) {
        int iIntValue;
        if (this.j == null) {
            return false;
        }
        HashMap map = new HashMap();
        for (DirectionsRoute directionsRoute : this.j) {
            if (directionsRoute.geometry() != null) {
                map.put(LineString.fromPolyline(directionsRoute.geometry(), 6), directionsRoute);
            }
        }
        MapplsMap mapplsMap = this.c;
        List<DirectionsRoute> list = this.j;
        HashMap map2 = new HashMap();
        Point pointFromLngLat = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
        PointF screenLocation = mapplsMap.getProjection().toScreenLocation(latLng);
        for (LineString lineString : map.keySet()) {
            Point point = (Point) TurfMisc.nearestPointOnLine(pointFromLngLat, lineString.coordinates()).geometry();
            if (point == null) {
                break;
            }
            PointF screenLocation2 = mapplsMap.getProjection().toScreenLocation(new LatLng(point.latitude(), point.longitude()));
            map2.put(Double.valueOf(Math.hypot(screenLocation.x - screenLocation2.x, screenLocation.y - screenLocation2.y)), (DirectionsRoute) map.get(lineString));
            mapplsMap = mapplsMap;
        }
        MapplsMap mapplsMap2 = mapplsMap;
        ArrayList arrayList = new ArrayList(map2.keySet());
        Collections.sort(arrayList);
        Double d2 = (Double) arrayList.get(0);
        if (d2.doubleValue() < 20.0d) {
            DirectionsRoute directionsRoute2 = (DirectionsRoute) map2.get(d2);
            int iIndexOf = list.indexOf(directionsRoute2);
            if (this.k == iIndexOf) {
                return false;
            }
            this.k = iIndexOf;
            this.a.removeCallbacks(this.q);
            this.a.postDelayed(this.q, 100L);
            this.d.post(new com.mappls.sdk.direction.ui.plugin.d(this, iIndexOf, directionsRoute2));
            return false;
        }
        List<Feature> listQueryRenderedFeatures = mapplsMap2.queryRenderedFeatures(screenLocation, "com.mappls.sdk.directions.directions-callout-marker-layer");
        if (listQueryRenderedFeatures.isEmpty() || this.k == (iIntValue = listQueryRenderedFeatures.get(0).getNumberProperty("com.mappls.sdk.directions.directions-property-value-eta-index").intValue())) {
            return false;
        }
        this.k = iIntValue;
        this.a.removeCallbacks(this.q);
        this.a.postDelayed(this.q, 100L);
        this.d.post(new com.mappls.sdk.direction.ui.plugin.e(this, list, iIntValue));
        return false;
    }

    static void a(f fVar, Style style) {
        fVar.getClass();
        fVar.e = new ArrayList();
        style.addSource(new GeoJsonSource("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID"));
        try {
            fVar.g(style);
            fVar.a(style);
            fVar.f(style);
            fVar.b(style);
            fVar.e(style);
            fVar.h(style);
            fVar.d(style);
            fVar.c(style);
        } catch (Exception unused) {
            Timber.e("Unable to attach directions Layers to current style.", new Object[0]);
        }
        try {
            Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(fVar.o.sourceMarker().intValue()));
            Bitmap bitmapFromDrawable2 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(fVar.o.destinationMarker().intValue()));
            Bitmap bitmapFromDrawable3 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(fVar.o.firstWayPointMarker().intValue()));
            Bitmap bitmapFromDrawable4 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(fVar.o.secondWayPointMarker().intValue()));
            Bitmap bitmapFromDrawable5 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(fVar.o.thirdWayPointMarker().intValue()));
            Bitmap bitmapFromDrawable6 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(R.drawable.mappls_direction_location_on_black_24dp));
            Bitmap bitmapFromDrawable7 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(R.drawable.mappls_direction_walking_selected));
            Bitmap bitmapFromDrawable8 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(R.drawable.mappls_direction_walking_alternate));
            Bitmap bitmapFromDrawable9 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(R.drawable.mappls_direction_start_polyline_icon));
            Bitmap bitmapFromDrawable10 = BitmapUtils.getBitmapFromDrawable(fVar.d.getContext().getResources().getDrawable(R.drawable.mappls_direction_end_polyline_icon));
            style.addImage("com.mappls.sdk.directions.mappls_direction_start_marker", bitmapFromDrawable);
            style.addImage("com.mappls.sdk.directions.mappls_direction_end_marker", bitmapFromDrawable2);
            style.addImage("com.mappls.sdk.directions.mappls_direction_via_points_1", bitmapFromDrawable3);
            style.addImage("com.mappls.sdk.directions.mappls_direction_via_points_2", bitmapFromDrawable4);
            style.addImage("com.mappls.sdk.directions.mappls_direction_via_points_3", bitmapFromDrawable5);
            style.addImage("com.mappls.sdk.directions.mappls_direction_track_points", bitmapFromDrawable6);
            style.addImage("com.mappls.sdk.directions.mappls_direction_start_polyline", bitmapFromDrawable9);
            style.addImage("com.mappls.sdk.directions.mappls_direction_end_polyline", bitmapFromDrawable10);
            style.addImage("com.mappls.sdk.direction.ui.selected_dotted_route_image", bitmapFromDrawable7);
            style.addImage("com.mappls.sdk.direction.ui.alternate_dotted_route_image", bitmapFromDrawable8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static Feature a(f fVar, Feature feature, String str) {
        fVar.getClass();
        try {
            JSONObject jSONObject = new JSONObject(feature.toJson());
            jSONObject.put("id", str);
            return Feature.fromJson(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static void a(f fVar, ArrayList arrayList) {
        Feature featureFromJson;
        if (fVar.j != null) {
            fVar.a(arrayList);
            if (!fVar.p || fVar.o.annotation() == null || !fVar.o.annotation().contains(DirectionsCriteria.ANNOTATION_CONGESTION) || fVar.j == null || fVar.f == null) {
                return;
            }
            int i2 = 0;
            while (i2 < fVar.f.size()) {
                LineString lineString = (LineString) fVar.f.get(i2);
                DirectionsRoute directionsRoute = fVar.j.get(i2);
                boolean z = fVar.k == i2;
                ArrayList arrayList2 = new ArrayList();
                if (directionsRoute.legs() != null) {
                    List<RouteLeg> listLegs = directionsRoute.legs();
                    if (listLegs.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        for (RouteLeg routeLeg : listLegs) {
                            if (routeLeg != null && routeLeg.annotation() != null && routeLeg.annotation().congestion() != null) {
                                arrayList3.addAll(routeLeg.annotation().congestion());
                            }
                        }
                        if (arrayList3.size() > 0) {
                            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                                if (arrayList3.size() + 1 <= lineString.coordinates().size()) {
                                    String str = (String) arrayList3.get(i3);
                                    Point point = lineString.coordinates().get(i3);
                                    Point point2 = lineString.coordinates().get(i3 + 1);
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(point);
                                    arrayList4.add(point2);
                                    Feature featureFromGeometry = Feature.fromGeometry(LineString.fromLngLats(arrayList4));
                                    featureFromGeometry.addStringProperty("mappls_direction_direction_type", z ? "selected" : "alternate");
                                    featureFromGeometry.addStringProperty(DirectionsCriteria.ANNOTATION_CONGESTION, str);
                                    arrayList2.add(featureFromGeometry);
                                }
                            }
                        }
                    }
                }
                arrayList.addAll(arrayList2);
                i2++;
            }
            fVar.d.post(new com.mappls.sdk.direction.ui.plugin.h(fVar, arrayList));
            if (fVar.o.annotation() != null && fVar.o.annotation().contains(DirectionsCriteria.ANNOTATION_BASE_DURATION) && fVar.o.annotation().contains("duration")) {
                List<CongestionDelayInfo> congestionDelayInfoFromRoute = MapplsUtils.getCongestionDelayInfoFromRoute(fVar.j.get(fVar.k), LineString.fromPolyline(fVar.j.get(fVar.k).geometry(), 6).coordinates().get(0), 50.0d, 1);
                HashMap map = new HashMap();
                for (int i4 = 0; i4 < congestionDelayInfoFromRoute.size(); i4++) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(fVar.d.getContext()).inflate(R.layout.mappls_direction_segment_delay_layout, (ViewGroup) null);
                    ((TextView) linearLayout.findViewById(R.id.mappls_direction_delay_text)).setText("+" + congestionDelayInfoFromRoute.get(i4).getDelayDuration() + " min");
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    linearLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    map.put("com.mappls.sdk.directions.mappls_direction_segment-delay_marker" + i4, r.a(linearLayout));
                }
                fVar.d.post(new com.mappls.sdk.direction.ui.plugin.k(fVar, map));
                int i5 = 0;
                for (CongestionDelayInfo congestionDelayInfo : congestionDelayInfoFromRoute) {
                    Feature featureFromGeometry2 = Feature.fromGeometry(congestionDelayInfo.getPoint());
                    featureFromGeometry2.addStringProperty("icon", "com.mappls.sdk.directions.mappls_direction_segment-delay_marker" + i5);
                    featureFromGeometry2.addStringProperty("mappls_direction_direction_type", "segment");
                    featureFromGeometry2.addNumberProperty("com.mappls.sdk.directions.mappls_direction_segment-delay_marker-sort-key", Integer.valueOf(0 - congestionDelayInfo.getDelayDuration()));
                    String str2 = "segment-delay-" + i5;
                    try {
                        JSONObject jSONObject = new JSONObject(featureFromGeometry2.toJson());
                        jSONObject.put("id", str2);
                        featureFromJson = Feature.fromJson(jSONObject.toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        featureFromJson = null;
                    }
                    arrayList.add(featureFromJson);
                    i5++;
                    arrayList.add(featureFromGeometry2);
                }
                fVar.d.post(new com.mappls.sdk.direction.ui.plugin.j(fVar, arrayList));
            }
        }
    }

    static void a(f fVar, boolean z, Style style) {
        ArrayList arrayList;
        List<Layer> layers;
        if (fVar.c == null || (arrayList = fVar.e) == null || arrayList.size() <= 0 || (layers = style.getLayers()) == null || layers.size() <= 0) {
            return;
        }
        for (Layer layer : layers) {
            if (fVar.e.contains(layer.getId())) {
                PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
                layer.setProperties(propertyValueArr);
            }
        }
        boolean z2 = fVar.b;
        fVar.c.getStyle(new com.mappls.sdk.direction.ui.plugin.c(z2));
        fVar.b = z2;
    }

    private void a(Style style) {
        Expression expression = C0075f.d;
        Expression expressionA = a(this.o.selectedRouteColor().intValue(), this.o.alternateRouteColor().intValue());
        Expression expression2 = C0075f.a;
        Expression expression3 = C0075f.c;
        LineLayer lineLayerA = l.a("com.mappls.sdk.directions.route_alternate", expression, expressionA, expression2, expression3, null);
        LineLayer lineLayerA2 = l.a("com.mappls.sdk.directions.route_alternate_case", C0075f.d, a(this.o.selectedCasingRouteColor().intValue(), this.o.alternateCasingRouteColor().intValue()), C0075f.b, expression3, null);
        ArrayList arrayList = this.e;
        String str = (String) arrayList.get(arrayList.size() - 1);
        if (style.getLayer(str) != null) {
            style.addLayerBelow(lineLayerA2, str);
        } else {
            style.addLayer(lineLayerA2);
        }
        style.addLayerAbove(lineLayerA, lineLayerA2.getId());
        this.e.add(lineLayerA2.getId());
        this.e.add(lineLayerA.getId());
    }

    public final void a(int i2) {
        this.k = i2;
        this.c.getStyle(new d());
        this.a.removeCallbacks(this.q);
        this.a.postDelayed(this.q, 100L);
    }

    public final void a(LatLng latLng, LatLng latLng2, List<LatLng> list, List<DirectionsRoute> list2, int i2) {
        this.m = null;
        this.g = latLng;
        this.h = latLng2;
        this.i = list;
        this.f = new ArrayList();
        for (DirectionsRoute directionsRoute : list2) {
            if (directionsRoute.geometry() != null) {
                this.f.add(LineString.fromPolyline(directionsRoute.geometry(), 6));
            }
        }
        this.j = list2;
        this.k = i2;
        this.a.removeCallbacks(this.q);
        this.a.postDelayed(this.q, 100L);
    }
}
