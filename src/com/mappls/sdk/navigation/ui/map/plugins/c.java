package com.mappls.sdk.navigation.ui.map.plugins;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements MapView.OnDidFinishLoadingStyleListener {
    public LatLng d;
    public final MapplsMap e;
    public final MapView f;
    public ArrayList g;
    public final Handler a = new Handler();
    public boolean b = false;
    public float c = 0.0f;
    public final Runnable h = new Runnable() { // from class: com.mappls.sdk.navigation.ui.map.plugins.c$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.a();
        }
    };

    public c(MapView mapView, MapplsMap mapplsMap) {
        this.e = mapplsMap;
        this.f = mapView;
        mapplsMap.getStyle(new a(this));
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    public final void a(boolean z, Style style) {
        if (this.g == null) {
            return;
        }
        List<Layer> layers = style.getLayers();
        if (layers != null && layers.size() > 0) {
            for (Layer layer : layers) {
                if (this.g.contains(layer.getId())) {
                    layer.setProperties(PropertyFactory.visibility(z ? "visible" : "none"));
                }
            }
        }
        a(this.b);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        this.e.getStyle(new a(this));
    }

    public final synchronized void a() {
        this.e.getStyle(new b(this));
    }

    public final void a(boolean z) {
        Layer layer;
        if (this.e.getStyle() != null && this.e.getStyle().isFullyLoaded() && (layer = this.e.getStyle().getLayer("directions-marker-bearing-layer")) != null) {
            layer.setProperties(PropertyFactory.visibility(z ? "visible" : "none"));
        }
        this.b = z;
    }

    public final void a(Drawable drawable, Style style) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        style.addImage("directions-marker-bearing-image", bitmap);
        SymbolLayer symbolLayer = new SymbolLayer("directions-marker-bearing-layer", "directions_bearing");
        PropertyValue<String> propertyValueIconImage = PropertyFactory.iconImage("directions-marker-bearing-image");
        Boolean bool = Boolean.TRUE;
        SymbolLayer symbolLayerWithFilter = symbolLayer.withProperties(propertyValueIconImage, PropertyFactory.iconAllowOverlap(bool), PropertyFactory.iconIgnorePlacement(bool), PropertyFactory.iconRotationAlignment("map")).withFilter(Expression.match(Expression.get("direction_type"), Expression.literal(false), Expression.stop("bearing", bool)));
        style.addLayer(symbolLayerWithFilter);
        this.g.add(symbolLayerWithFilter.getId());
    }
}
