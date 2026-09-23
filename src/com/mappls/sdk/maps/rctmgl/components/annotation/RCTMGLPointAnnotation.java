package com.mappls.sdk.maps.rctmgl.components.annotation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.View;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.events.PointAnnotationClickEvent;
import com.mappls.sdk.maps.rctmgl.events.PointAnnotationDragEvent;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.utils.BitmapUtils;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import com.mappls.sdk.plugin.annotation.Symbol;
import com.mappls.sdk.plugin.annotation.SymbolManager;
import com.mappls.sdk.plugin.annotation.SymbolOptions;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLPointAnnotation extends AbstractMapFeature implements View.OnLayoutChangeListener {
    private static final String MARKER_IMAGE_ID = "MARKER_IMAGE_ID";
    private Float[] mAnchor;
    private Symbol mAnnotation;
    private Bitmap mCalloutBitmap;
    private String mCalloutBitmapId;
    private Symbol mCalloutSymbol;
    private View mCalloutView;
    private Bitmap mChildBitmap;
    private String mChildBitmapId;
    private View mChildView;
    private Context mContext;
    private Point mCoordinate;
    private boolean mDraggable;
    private boolean mHasChildren;
    private String mID;
    private boolean mIsSelected;
    private RCTMGLPointAnnotationManager mManager;
    private MapplsMap mMap;
    private RCTMGLMapView mMapView;
    private String mMapplsPin;
    private String mSnippet;
    private String mTitle;

    public RCTMGLPointAnnotation(Context context, RCTMGLPointAnnotationManager rCTMGLPointAnnotationManager) {
        super(context);
        this.mContext = context;
        this.mManager = rCTMGLPointAnnotationManager;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (view instanceof RCTMGLCallout) {
            this.mCalloutView = view;
        } else {
            this.mChildView = view;
        }
        view.addOnLayoutChangeListener(this);
        RCTMGLMapView rCTMGLMapView = this.mMapView;
        if (rCTMGLMapView != null) {
            rCTMGLMapView.offscreenAnnotationViewContainer().addView(view);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mChildView != null) {
            this.mMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLPointAnnotation.1
                @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                public void onStyleLoaded(Style style) {
                    style.removeImage(RCTMGLPointAnnotation.this.mChildBitmapId);
                    RCTMGLPointAnnotation.this.mChildView = null;
                    RCTMGLPointAnnotation.this.mCalloutView = null;
                    RCTMGLPointAnnotation.this.mChildBitmap = null;
                    RCTMGLPointAnnotation.this.mChildBitmapId = null;
                    RCTMGLPointAnnotation.this.updateOptions();
                }
            });
        }
        RCTMGLMapView rCTMGLMapView = this.mMapView;
        if (rCTMGLMapView != null) {
            rCTMGLMapView.offscreenAnnotationViewContainer().removeView(view);
        }
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        this.mMapView = rCTMGLMapView;
        this.mMap = rCTMGLMapView.getMapplsMap();
        makeMarker();
        View view = this.mChildView;
        if (view != null) {
            if (!view.isAttachedToWindow()) {
                this.mMapView.offscreenAnnotationViewContainer().addView(this.mChildView);
            }
            addBitmapToStyle(this.mChildBitmap, this.mChildBitmapId);
            updateOptions();
        }
        View view2 = this.mCalloutView;
        if (view2 != null) {
            if (!view2.isAttachedToWindow()) {
                this.mMapView.offscreenAnnotationViewContainer().addView(this.mCalloutView);
            }
            addBitmapToStyle(this.mCalloutBitmap, this.mCalloutBitmapId);
        }
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
        RCTMGLMapView rCTMGLMapView2 = this.mMapView;
        if (rCTMGLMapView2 != null) {
            rCTMGLMapView = rCTMGLMapView2;
        }
        if (rCTMGLMapView == null) {
            return;
        }
        if (this.mAnnotation != null) {
            rCTMGLMapView.getSymbolManager().clear(this.mAnnotation);
        }
        if (this.mChildView != null) {
            rCTMGLMapView.offscreenAnnotationViewContainer().removeView(this.mChildView);
        }
        if (this.mCalloutView != null) {
            rCTMGLMapView.offscreenAnnotationViewContainer().removeView(this.mCalloutView);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        if (i == i5 && i3 == i7 && i2 == i6 && i4 == i8) {
            return;
        }
        refreshBitmap(view, i, i2, i3, i4);
    }

    private void refreshBitmap(View view, int i, int i2, int i3, int i4) {
        Bitmap bitmapViewToBitmap = BitmapUtils.viewToBitmap(view, i, i2, i3, i4);
        String string = Integer.toString(view.getId());
        addBitmapToStyle(bitmapViewToBitmap, string);
        if (view instanceof RCTMGLCallout) {
            this.mCalloutBitmap = bitmapViewToBitmap;
            this.mCalloutBitmapId = string;
        } else if (bitmapViewToBitmap != null) {
            this.mChildBitmap = bitmapViewToBitmap;
            this.mChildBitmapId = string;
            updateOptions();
        }
    }

    private void refreshBitmap(View view) {
        refreshBitmap(view, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public LatLng getLatLng() {
        return GeoJSONUtils.toLatLng(this.mCoordinate);
    }

    public long getMapboxID() {
        Symbol symbol = this.mAnnotation;
        if (symbol == null) {
            return -1L;
        }
        return symbol.getId();
    }

    public String getID() {
        return this.mID;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public View getCalloutView() {
        return this.mCalloutView;
    }

    public void setMapplsPin(String str) {
        if (str == null) {
            return;
        }
        this.mCoordinate = null;
        this.mMapplsPin = str;
        Symbol symbol = this.mAnnotation;
        if (symbol != null) {
            symbol.setMapplsPin(str);
            this.mMapView.getSymbolManager().update(this.mAnnotation);
        }
        Symbol symbol2 = this.mCalloutSymbol;
        if (symbol2 != null) {
            symbol2.setMapplsPin(str);
            this.mMapView.getSymbolManager().update(this.mCalloutSymbol);
        }
    }

    public void setCoordinate(Point point) {
        if (point == null) {
            return;
        }
        this.mCoordinate = point;
        this.mMapplsPin = null;
        Symbol symbol = this.mAnnotation;
        if (symbol != null) {
            symbol.setPosition(GeoJSONUtils.toLatLng(point));
            this.mMapView.getSymbolManager().update(this.mAnnotation);
        }
        Symbol symbol2 = this.mCalloutSymbol;
        if (symbol2 != null) {
            symbol2.setPosition(GeoJSONUtils.toLatLng(point));
            this.mMapView.getSymbolManager().update(this.mCalloutSymbol);
        }
    }

    public void setAnchor(float f, float f2) {
        this.mAnchor = new Float[]{Float.valueOf(f), Float.valueOf(f2)};
        if (this.mAnnotation != null) {
            updateAnchor();
            this.mMapView.getSymbolManager().update(this.mAnnotation);
        }
    }

    public void setDraggable(Boolean bool) {
        this.mDraggable = bool.booleanValue();
        Symbol symbol = this.mAnnotation;
        if (symbol != null) {
            symbol.setDraggable(bool.booleanValue());
            this.mMapView.getSymbolManager().update(this.mAnnotation);
        }
    }

    public Symbol getMarker() {
        return this.mAnnotation;
    }

    public void onSelect(boolean z) {
        if (this.mCalloutView != null) {
            makeCallout();
        }
        if (z) {
            this.mManager.handleEvent(makeEvent(true));
        }
    }

    public void onDeselect() {
        this.mManager.handleEvent(makeEvent(false));
        if (this.mCalloutSymbol != null) {
            this.mMapView.getSymbolManager().clear(this.mCalloutSymbol);
        }
    }

    public void onDragStart() {
        LatLng position = this.mAnnotation.getPosition();
        if (position != null) {
            this.mCoordinate = Point.fromLngLat(position.getLongitude(), position.getLatitude());
        }
        this.mManager.handleEvent(makeDragEvent(EventTypes.ANNOTATION_DRAG_START));
    }

    public void onDrag() {
        LatLng position = this.mAnnotation.getPosition();
        this.mCoordinate = Point.fromLngLat(position.getLongitude(), position.getLatitude());
        this.mManager.handleEvent(makeDragEvent(EventTypes.ANNOTATION_DRAG));
    }

    public void onDragEnd() {
        LatLng position = this.mAnnotation.getPosition();
        this.mCoordinate = Point.fromLngLat(position.getLongitude(), position.getLatitude());
        this.mManager.handleEvent(makeDragEvent(EventTypes.ANNOTATION_DRAG_END));
    }

    public void makeMarker() {
        SymbolOptions symbolOptionsSymbolSortKey = new SymbolOptions().draggable(this.mDraggable).iconSize(Float.valueOf(1.0f)).symbolSortKey(Float.valueOf(10.0f));
        Point point = this.mCoordinate;
        if (point != null) {
            symbolOptionsSymbolSortKey.geometry(point);
        } else {
            symbolOptionsSymbolSortKey.mapplsPin(this.mMapplsPin);
        }
        SymbolManager symbolManager = this.mMapView.getSymbolManager();
        if (symbolManager != null) {
            this.mAnnotation = symbolManager.create(symbolOptionsSymbolSortKey);
            updateOptions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOptions() {
        if (this.mAnnotation != null) {
            updateIconImage();
            updateAnchor();
            this.mMapView.getSymbolManager().update(this.mAnnotation);
        }
    }

    private void updateIconImage() {
        if (this.mChildView != null) {
            String str = this.mChildBitmapId;
            if (str != null) {
                this.mAnnotation.setIconImage(str);
                return;
            }
            return;
        }
        this.mAnnotation.setIconImage(MARKER_IMAGE_ID);
        this.mAnnotation.setIconAnchor("bottom");
    }

    private void updateAnchor() {
        Bitmap bitmap;
        if (this.mAnchor == null || this.mChildView == null || (bitmap = this.mChildBitmap) == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = this.mChildBitmap.getHeight();
        float f = getResources().getDisplayMetrics().density;
        this.mAnnotation.setIconAnchor("top-left");
        this.mAnnotation.setIconOffset(new PointF(((int) (width / f)) * this.mAnchor[0].floatValue() * (-1.0f), ((int) (height / f)) * this.mAnchor[1].floatValue() * (-1.0f)));
    }

    private void makeCallout() {
        float height;
        if (this.mChildView == null || this.mChildBitmap == null) {
            height = -28.0f;
        } else {
            height = ((int) ((this.mChildBitmap.getHeight() / 2) / getResources().getDisplayMetrics().density)) * (-1.0f);
        }
        SymbolOptions symbolOptionsDraggable = new SymbolOptions().icon(this.mCalloutBitmapId).iconSize(Float.valueOf(1.0f)).iconAnchor("bottom").iconOffset(new Float[]{Float.valueOf(0.0f), Float.valueOf(height)}).symbolSortKey(Float.valueOf(11.0f)).draggable(false);
        Point point = this.mCoordinate;
        if (point != null) {
            symbolOptionsDraggable.geometry(point);
        } else {
            symbolOptionsDraggable.mapplsPin(this.mMapplsPin);
        }
        SymbolManager symbolManager = this.mMapView.getSymbolManager();
        if (symbolManager != null) {
            this.mCalloutSymbol = symbolManager.create(symbolOptionsDraggable);
        }
    }

    private void addBitmapToStyle(final Bitmap bitmap, final String str) {
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null || str == null || bitmap == null) {
            return;
        }
        mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLPointAnnotation.2
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                style.addImage(str, bitmap);
            }
        });
    }

    private PointAnnotationClickEvent makeEvent(boolean z) {
        PointF screenPosition;
        String str = z ? EventTypes.ANNOTATION_SELECTED : EventTypes.ANNOTATION_DESELECTED;
        LatLng latLng = GeoJSONUtils.toLatLng(this.mCoordinate);
        if (latLng != null) {
            screenPosition = getScreenPosition(latLng);
        } else {
            screenPosition = getScreenPosition();
        }
        return new PointAnnotationClickEvent(this, latLng, screenPosition, str);
    }

    private PointAnnotationDragEvent makeDragEvent(String str) {
        PointF screenPosition;
        LatLng latLng = GeoJSONUtils.toLatLng(this.mCoordinate);
        if (latLng != null) {
            screenPosition = getScreenPosition(latLng);
        } else {
            screenPosition = getScreenPosition();
        }
        return new PointAnnotationDragEvent(this, latLng, screenPosition, str);
    }

    private float getDisplayDensity() {
        return this.mContext.getResources().getDisplayMetrics().density;
    }

    private PointF getScreenPosition() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return new PointF(iArr[0], iArr[1]);
    }

    private PointF getScreenPosition(LatLng latLng) {
        PointF screenLocation = this.mMap.getProjection().toScreenLocation(latLng);
        float displayDensity = getDisplayDensity();
        screenLocation.x /= displayDensity;
        screenLocation.y /= displayDensity;
        return screenLocation;
    }

    public void refresh() {
        View view = this.mChildView;
        if (view != null) {
            refreshBitmap(view);
        }
    }
}
