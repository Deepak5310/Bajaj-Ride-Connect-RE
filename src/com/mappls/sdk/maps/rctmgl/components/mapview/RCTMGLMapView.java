package com.mappls.sdk.maps.rctmgl.components.mapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.location.Location;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsCallback;
import com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsPlugin;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.maps.AttributionDialogManager;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.MapplsMapOptions;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.OnMapReinitCallback;
import com.mappls.sdk.maps.OnPlaceClickListener;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.UiSettings;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdate;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.VisibleRegion;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.rctmgl.R;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.annotation.MarkerViewManager;
import com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLMarkerView;
import com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLPointAnnotation;
import com.mappls.sdk.maps.rctmgl.components.camera.RCTMGLCamera;
import com.mappls.sdk.maps.rctmgl.components.geoAnalytics.RCTMGLGeoAnalytics;
import com.mappls.sdk.maps.rctmgl.components.images.RCTMGLImages;
import com.mappls.sdk.maps.rctmgl.components.location.LocationComponentManager;
import com.mappls.sdk.maps.rctmgl.components.location.RCTMGLNativeUserLocation;
import com.mappls.sdk.maps.rctmgl.components.mapview.helpers.CameraChangeTracker;
import com.mappls.sdk.maps.rctmgl.components.styles.layers.RCTLayer;
import com.mappls.sdk.maps.rctmgl.components.styles.light.RCTMGLLight;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSource;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource;
import com.mappls.sdk.maps.rctmgl.events.AndroidCallbackEvent;
import com.mappls.sdk.maps.rctmgl.events.GeoAnalyticsClickEvent;
import com.mappls.sdk.maps.rctmgl.events.IndoorControlHideEvent;
import com.mappls.sdk.maps.rctmgl.events.IndoorControlShowEvent;
import com.mappls.sdk.maps.rctmgl.events.MapChangeEvent;
import com.mappls.sdk.maps.rctmgl.events.MapClickEvent;
import com.mappls.sdk.maps.rctmgl.events.MapErrorEvent;
import com.mappls.sdk.maps.rctmgl.events.MapReinitEvent;
import com.mappls.sdk.maps.rctmgl.events.MapplsPlaceClickEvent;
import com.mappls.sdk.maps.rctmgl.events.MapplsStyleLoadedEvent;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.utils.BitmapUtils;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import com.mappls.sdk.maps.rctmgl.utils.GeoViewport;
import com.mappls.sdk.maps.style.OnStyleLoadListener;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.widgets.LogoView;
import com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.plugin.annotation.OnSymbolClickListener;
import com.mappls.sdk.plugin.annotation.OnSymbolDragListener;
import com.mappls.sdk.plugin.annotation.Symbol;
import com.mappls.sdk.plugin.annotation.SymbolManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLMapView extends MapView implements OnMapReadyCallback, OnMapReinitCallback, MapplsMap.OnMapClickListener, MapplsMap.OnMapLongClickListener, MapView.OnCameraIsChangingListener, MapView.OnCameraDidChangeListener, MapView.OnDidFailLoadingMapListener, MapView.OnDidFinishLoadingMapListener, MapView.OnWillStartRenderingFrameListener, MapView.OnDidFinishRenderingFrameListener, MapView.OnWillStartRenderingMapListener, MapView.OnDidFinishRenderingMapListener, MapView.OnDidFinishLoadingStyleListener, MapView.OnStyleImageMissingListener {
    public static final String LOG_TAG = "RCTMGLMapView";
    private Integer floor;
    private MapplsGeoAnalyticsPlugin geoAnalyticsPlugin;
    private boolean isEnableTraffic;
    private boolean isEnableTrafficClosure;
    private boolean isEnableTrafficFreeFlow;
    private boolean isEnableTrafficNonFreeFlow;
    private boolean isEnableTrafficStopIcon;
    private Map<String, List<FoundLayerCallback>> layerWaiters;
    private long mActiveMarkerID;
    private Boolean mAnchorRotateOrZoomGesturesToCenter;
    private boolean mAnnotationClicked;
    private Boolean mAttributionEnabled;
    private Integer mAttributionGravity;
    private int[] mAttributionMargin;
    private RCTMGLCamera mCamera;
    private CameraChangeTracker mCameraChangeTracker;
    private Boolean mCompassEnabled;
    private ReadableMap mCompassViewMargins;
    private int mCompassViewPosition;
    private Context mContext;
    private boolean mDestroyed;
    private Boolean mEnableLogoClick;
    private Integer mEventGravity;
    private int[] mEventMargin;
    private List<AbstractMapFeature> mFeatures;
    private HashSet<String> mHandledMapChangedEvents;
    private Handler mHandler;
    private List<RCTMGLImages> mImages;
    private ReadableArray mInsets;
    private Boolean mLayerControlEnabled;
    private Integer mLayerControlGravity;
    private int[] mLayerControlMargin;
    private LifecycleEventListener mLifeCycleListener;
    private boolean mLocalizeLabels;
    private LocationComponentManager mLocationComponentManager;
    private Boolean mLogoEnabled;
    private Integer mLogoGravity;
    private int[] mLogoMargins;
    private RCTMGLMapViewManager mManager;
    private MapplsMap mMap;
    private ViewGroup mOffscreenAnnotationViewContainer;
    private boolean mPaused;
    private Boolean mPitchEnabled;
    private Map<String, RCTMGLPointAnnotation> mPointAnnotations;
    private List<Pair<Integer, ReadableArray>> mPreRenderMethods;
    private Integer mPreferredFramesPerSecond;
    private List<AbstractMapFeature> mQueuedFeatures;
    private Boolean mRotateEnabled;
    private Boolean mScrollEnabled;
    private Map<String, RCTSource> mSources;

    @Nullable
    private Integer mTintColor;
    private Boolean mZoomEnabled;
    private String mapplsStyle;
    private MarkerViewManager markerViewManager;
    private boolean shouldShowInfoWindow;
    private SymbolManager symbolManager;

    public interface FoundLayerCallback {
        void found(Layer layer);
    }

    public RCTMGLMapView(Context context, RCTMGLMapViewManager rCTMGLMapViewManager, MapplsMapOptions mapplsMapOptions) {
        super(context, mapplsMapOptions);
        this.mCameraChangeTracker = new CameraChangeTracker();
        this.mPreRenderMethods = new ArrayList();
        this.mCompassViewPosition = -1;
        this.floor = null;
        this.isEnableTraffic = false;
        this.isEnableTrafficClosure = true;
        this.isEnableTrafficFreeFlow = true;
        this.isEnableTrafficNonFreeFlow = true;
        this.isEnableTrafficStopIcon = true;
        this.mActiveMarkerID = -1L;
        this.mHandledMapChangedEvents = null;
        this.markerViewManager = null;
        this.mOffscreenAnnotationViewContainer = null;
        this.mAnnotationClicked = false;
        this.mLocationComponentManager = null;
        this.mTintColor = null;
        this.layerWaiters = new HashMap();
        this.mContext = context;
        onCreate(null);
        onStart();
        onResume();
        getMapAsync(this);
        getMapReinit(this);
        this.mManager = rCTMGLMapViewManager;
        this.mSources = new HashMap();
        this.mImages = new ArrayList();
        this.mPointAnnotations = new HashMap();
        this.mQueuedFeatures = new ArrayList();
        this.mFeatures = new ArrayList();
        this.mHandler = new Handler();
        setLifecycleListeners();
        addOnCameraIsChangingListener(this);
        addOnCameraDidChangeListener(this);
        addOnDidFailLoadingMapListener(this);
        addOnDidFinishLoadingMapListener(this);
        addOnStyleImageMissingListener(this);
        addOnWillStartRenderingFrameListener(this);
        addOnDidFinishRenderingFrameListener(this);
        addOnWillStartRenderingMapListener(this);
        addOnDidFinishRenderingMapListener(this);
        addOnDidFinishLoadingStyleListener(this);
    }

    @Override // com.mappls.sdk.maps.MapView
    public void onResume() {
        super.onResume();
        this.mPaused = false;
    }

    @Override // com.mappls.sdk.maps.MapView
    public void onPause() {
        super.onPause();
        this.mPaused = true;
    }

    @Override // com.mappls.sdk.maps.MapView
    public void onDestroy() {
        super.onDestroy();
        this.mDestroyed = true;
    }

    public void enqueuePreRenderMapMethod(Integer num, @Nullable ReadableArray readableArray) {
        this.mPreRenderMethods.add(new Pair<>(num, readableArray));
    }

    public void addFeature(View view, int i) {
        AbstractMapFeature abstractMapFeature;
        if (view instanceof RCTSource) {
            RCTSource rCTSource = (RCTSource) view;
            this.mSources.put(rCTSource.getID(), rCTSource);
            abstractMapFeature = (AbstractMapFeature) view;
        } else if (view instanceof RCTMGLImages) {
            this.mImages.add((RCTMGLImages) view);
            abstractMapFeature = (AbstractMapFeature) view;
        } else if ((view instanceof RCTMGLLight) || (view instanceof RCTMGLNativeUserLocation)) {
            abstractMapFeature = (AbstractMapFeature) view;
        } else if (view instanceof RCTMGLPointAnnotation) {
            RCTMGLPointAnnotation rCTMGLPointAnnotation = (RCTMGLPointAnnotation) view;
            this.mPointAnnotations.put(rCTMGLPointAnnotation.getID(), rCTMGLPointAnnotation);
            abstractMapFeature = (AbstractMapFeature) view;
        } else if (view instanceof RCTMGLMarkerView) {
            abstractMapFeature = (AbstractMapFeature) view;
        } else if (view instanceof RCTMGLCamera) {
            this.mCamera = (RCTMGLCamera) view;
            abstractMapFeature = (AbstractMapFeature) view;
        } else if (view instanceof RCTLayer) {
            abstractMapFeature = (RCTLayer) view;
        } else if (view instanceof RCTMGLGeoAnalytics) {
            abstractMapFeature = (AbstractMapFeature) view;
        } else {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    addFeature(viewGroup.getChildAt(i2), i);
                }
            }
            abstractMapFeature = null;
        }
        if (abstractMapFeature != null) {
            List<AbstractMapFeature> list = this.mQueuedFeatures;
            if (list == null) {
                abstractMapFeature.addToMap(this);
                this.mFeatures.add(i, abstractMapFeature);
            } else {
                list.add(i, abstractMapFeature);
            }
        }
    }

    public void removeFeature(int i) {
        AbstractMapFeature abstractMapFeature = features().get(i);
        if (abstractMapFeature == null) {
            return;
        }
        if (abstractMapFeature instanceof RCTSource) {
            this.mSources.remove(((RCTSource) abstractMapFeature).getID());
        } else if (abstractMapFeature instanceof RCTMGLPointAnnotation) {
            RCTMGLPointAnnotation rCTMGLPointAnnotation = (RCTMGLPointAnnotation) abstractMapFeature;
            if (rCTMGLPointAnnotation.getMapboxID() == this.mActiveMarkerID) {
                this.mActiveMarkerID = -1L;
            }
            this.mPointAnnotations.remove(rCTMGLPointAnnotation.getID());
        } else if (abstractMapFeature instanceof RCTMGLImages) {
            this.mImages.remove((RCTMGLImages) abstractMapFeature);
        }
        abstractMapFeature.removeFromMap(this);
        features().remove(abstractMapFeature);
    }

    private List<AbstractMapFeature> features() {
        List<AbstractMapFeature> list = this.mQueuedFeatures;
        if (list != null && list.size() > 0) {
            return this.mQueuedFeatures;
        }
        return this.mFeatures;
    }

    public int getFeatureCount() {
        return features().size();
    }

    public AbstractMapFeature getFeatureAt(int i) {
        return features().get(i);
    }

    public synchronized void dispose() {
        if (this.mDestroyed) {
            return;
        }
        if (!this.layerWaiters.isEmpty()) {
            this.layerWaiters.clear();
        }
        ((ReactContext) this.mContext).removeLifecycleEventListener(this.mLifeCycleListener);
        if (!this.mPaused) {
            onPause();
        }
        onStop();
        onDestroy();
    }

    public VisibleRegion getVisibleRegion(LatLng latLng, double d) {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        int[] padding = this.mMap.getPadding();
        return GeoViewport.getRegion(latLng, (int) d, (int) (((((double) this.mMap.getWidth()) * 0.75d) - ((double) (padding[0] + padding[2]))) / ((double) displayMetrics.scaledDensity)), (int) (((((double) this.mMap.getHeight()) * 0.75d) - ((double) (padding[1] + padding[3]))) / ((double) displayMetrics.scaledDensity)));
    }

    public CameraPosition getCameraPosition() {
        return this.mMap.getCameraPosition();
    }

    public void animateCamera(CameraUpdate cameraUpdate, MapplsMap.CancelableCallback cancelableCallback) {
        this.mMap.animateCamera(cameraUpdate, cancelableCallback);
    }

    public void moveCamera(CameraUpdate cameraUpdate, MapplsMap.CancelableCallback cancelableCallback) {
        this.mMap.moveCamera(cameraUpdate, cancelableCallback);
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.mMap.moveCamera(cameraUpdate);
    }

    public void easeCamera(CameraUpdate cameraUpdate, int i, boolean z, MapplsMap.CancelableCallback cancelableCallback) {
        this.mMap.easeCamera(cameraUpdate, i, z, cancelableCallback);
    }

    public void easeCamera(CameraUpdate cameraUpdate) {
        this.mMap.easeCamera(cameraUpdate);
    }

    public RCTMGLPointAnnotation getPointAnnotationByID(String str) {
        if (str == null) {
            return null;
        }
        Iterator<String> it2 = this.mPointAnnotations.keySet().iterator();
        while (it2.hasNext()) {
            RCTMGLPointAnnotation rCTMGLPointAnnotation = this.mPointAnnotations.get(it2.next());
            if (rCTMGLPointAnnotation != null && str.equals(rCTMGLPointAnnotation.getID())) {
                return rCTMGLPointAnnotation;
            }
        }
        return null;
    }

    public RCTMGLPointAnnotation getPointAnnotationByMarkerID(long j) {
        Iterator<String> it2 = this.mPointAnnotations.keySet().iterator();
        while (it2.hasNext()) {
            RCTMGLPointAnnotation rCTMGLPointAnnotation = this.mPointAnnotations.get(it2.next());
            if (rCTMGLPointAnnotation != null && j == rCTMGLPointAnnotation.getMapboxID()) {
                return rCTMGLPointAnnotation;
            }
        }
        return null;
    }

    public MapplsMap getMapplsMap() {
        return this.mMap;
    }

    public SymbolManager getSymbolManager() {
        return this.symbolManager;
    }

    public MapplsGeoAnalyticsPlugin getGeoAnalyticsPlugin() {
        return this.geoAnalyticsPlugin;
    }

    @Override // com.mappls.sdk.maps.OnMapReinitCallback
    public void onMapReinit(long j, int i, String str) {
        this.mManager.handleEvent(new MapReinitEvent(this, j, i, str));
    }

    public void layerAdded(Layer layer) {
        String id = layer.getId();
        List<FoundLayerCallback> list = this.layerWaiters.get(id);
        if (list != null) {
            Iterator<FoundLayerCallback> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().found(layer);
            }
        }
        this.layerWaiters.remove(id);
    }

    public void waitForLayer(String str, FoundLayerCallback foundLayerCallback) {
        Layer layer = this.mMap.getStyle().getLayer(str);
        if (layer != null) {
            foundLayerCallback.found(layer);
            return;
        }
        List<FoundLayerCallback> arrayList = this.layerWaiters.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.layerWaiters.put(str, arrayList);
        }
        arrayList.add(foundLayerCallback);
    }

    public boolean isJSONValid(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        this.mMap = mapplsMap;
        this.mManager.handleEvent(new MapplsStyleLoadedEvent(this, mapplsMap.getMapplsAvailableStyles()));
        LogoView logoView = (LogoView) findViewWithTag("logoView");
        if (logoView != null) {
            logoView.setRefreshListener(new LogoView.IRefreshListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.1
                @Override // com.mappls.sdk.maps.widgets.LogoView.IRefreshListener
                public void refresh() {
                    RCTMGLMapView.this.reflow();
                }
            });
        }
        reflow();
        String str = this.mapplsStyle;
        if (str != null) {
            this.mMap.setMapplsStyle(str, new OnStyleLoadListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.2
                @Override // com.mappls.sdk.maps.style.OnStyleLoadListener
                public void onError(String str2) {
                }

                @Override // com.mappls.sdk.maps.style.OnStyleLoadListener
                public void onStyleLoaded(Style style) {
                    RCTMGLMapView.this.createSymbolManager(style);
                    RCTMGLMapView.this.createGeoAnalyticsPlugin();
                    RCTMGLMapView.this.setUpImage(style);
                    RCTMGLMapView.this.addQueuedFeatures();
                }
            });
        } else {
            this.mMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.3
                @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                public void onStyleLoaded(Style style) {
                    RCTMGLMapView.this.createSymbolManager(style);
                    RCTMGLMapView.this.createGeoAnalyticsPlugin();
                    RCTMGLMapView.this.setUpImage(style);
                    RCTMGLMapView.this.addQueuedFeatures();
                }
            });
        }
        updatePreferredFramesPerSecond();
        updateInsets();
        updateUISettings();
        this.mMap.addOnCameraIdleListener(new MapplsMap.OnCameraIdleListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.4
            @Override // com.mappls.sdk.maps.MapplsMap.OnCameraIdleListener
            public void onCameraIdle() {
                RCTMGLMapView.this.sendRegionDidChangeEvent();
            }
        });
        this.mMap.addOnCameraMoveStartedListener(new MapplsMap.OnCameraMoveStartedListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.5
            @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveStartedListener
            public void onCameraMoveStarted(int i) {
                RCTMGLMapView.this.mCameraChangeTracker.setReason(i);
                RCTMGLMapView.this.handleMapChangedEvent(EventTypes.REGION_WILL_CHANGE);
            }
        });
        this.mMap.addOnMoveListener(new MapplsMap.OnMoveListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.6
            @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
            public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
            }

            @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
            public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
                RCTMGLMapView.this.mCameraChangeTracker.setReason(1);
                RCTMGLMapView.this.handleMapChangedEvent(EventTypes.REGION_WILL_CHANGE);
            }

            @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
            public void onMove(MoveGestureDetector moveGestureDetector) {
                RCTMGLMapView.this.mCameraChangeTracker.setReason(1);
                RCTMGLMapView.this.handleMapChangedEvent(EventTypes.REGION_IS_CHANGING);
            }
        });
        this.mMap.addOnIndoorListener(new IndoorListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.7
            @Override // com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener
            public void showControl(int i, int i2, int i3) {
                RCTMGLMapView.this.mManager.handleEvent(new IndoorControlShowEvent(RCTMGLMapView.this, i, i2, i3));
            }

            @Override // com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener
            public void hideControl() {
                RCTMGLMapView.this.mManager.handleEvent(new IndoorControlHideEvent(RCTMGLMapView.this));
            }
        });
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        this.mManager.handleEvent(new MapErrorEvent(this, i, str));
    }

    public void reflow() {
        this.mHandler.post(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.8
            @Override // java.lang.Runnable
            public void run() {
                RCTMGLMapView rCTMGLMapView = RCTMGLMapView.this;
                rCTMGLMapView.measure(View.MeasureSpec.makeMeasureSpec(rCTMGLMapView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(RCTMGLMapView.this.getMeasuredHeight(), 1073741824));
                RCTMGLMapView rCTMGLMapView2 = RCTMGLMapView.this;
                rCTMGLMapView2.layout(rCTMGLMapView2.getLeft(), RCTMGLMapView.this.getTop(), RCTMGLMapView.this.getRight(), RCTMGLMapView.this.getBottom());
            }
        });
    }

    public void createGeoAnalyticsPlugin() {
        MapplsGeoAnalyticsPlugin mapplsGeoAnalyticsPlugin = new MapplsGeoAnalyticsPlugin(this, this.mMap);
        this.geoAnalyticsPlugin = mapplsGeoAnalyticsPlugin;
        mapplsGeoAnalyticsPlugin.shouldShowInfoWindow(this.shouldShowInfoWindow);
        this.geoAnalyticsPlugin.setGeoAnalyticsCallback(new MapplsGeoAnalyticsCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView$$ExternalSyntheticLambda0
            @Override // com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsCallback
            public final void getSelectedFeatures(List list) {
                this.f$0.lambda$createGeoAnalyticsPlugin$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGeoAnalyticsPlugin$0(List list) {
        if (list.size() > 0) {
            this.mManager.handleEvent(new GeoAnalyticsClickEvent(this, list));
        }
    }

    public void createSymbolManager(Style style) {
        SymbolManager symbolManager = new SymbolManager(this, this.mMap, style);
        this.symbolManager = symbolManager;
        symbolManager.setIconAllowOverlap(true);
        this.symbolManager.addClickListener(new OnSymbolClickListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.9
            @Override // com.mappls.sdk.plugin.annotation.OnAnnotationClickListener
            public boolean onAnnotationClick(Symbol symbol) {
                RCTMGLMapView.this.onMarkerClick(symbol);
                return true;
            }
        });
        this.symbolManager.addDragListener(new OnSymbolDragListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.10
            @Override // com.mappls.sdk.plugin.annotation.OnAnnotationDragListener
            public void onAnnotationDragStarted(Symbol symbol) {
                RCTMGLMapView.this.mAnnotationClicked = true;
                RCTMGLPointAnnotation pointAnnotationByMarkerID = RCTMGLMapView.this.getPointAnnotationByMarkerID(symbol.getId());
                if (pointAnnotationByMarkerID != null) {
                    pointAnnotationByMarkerID.onDragStart();
                }
            }

            @Override // com.mappls.sdk.plugin.annotation.OnAnnotationDragListener
            public void onAnnotationDrag(Symbol symbol) {
                RCTMGLPointAnnotation pointAnnotationByMarkerID = RCTMGLMapView.this.getPointAnnotationByMarkerID(symbol.getId());
                if (pointAnnotationByMarkerID != null) {
                    pointAnnotationByMarkerID.onDrag();
                }
            }

            @Override // com.mappls.sdk.plugin.annotation.OnAnnotationDragListener
            public void onAnnotationDragFinished(Symbol symbol) {
                RCTMGLMapView.this.mAnnotationClicked = false;
                RCTMGLPointAnnotation pointAnnotationByMarkerID = RCTMGLMapView.this.getPointAnnotationByMarkerID(symbol.getId());
                if (pointAnnotationByMarkerID != null) {
                    pointAnnotationByMarkerID.onDragEnd();
                }
            }
        });
        this.mMap.addOnMapClickListener(this);
        this.mMap.addOnMapLongClickListener(this);
        this.mMap.setOnPlaceClickListener(new OnPlaceClickListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.11
            @Override // com.mappls.sdk.maps.OnPlaceClickListener
            public boolean onPlaceClick(String str) {
                RCTMGLMapView.this.mManager.handleEvent(new MapplsPlaceClickEvent(RCTMGLMapView.this, str));
                return str != null;
            }
        });
    }

    public void addQueuedFeatures() {
        List<AbstractMapFeature> list = this.mQueuedFeatures;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mQueuedFeatures.size(); i++) {
            AbstractMapFeature abstractMapFeature = this.mQueuedFeatures.get(i);
            abstractMapFeature.addToMap(this);
            this.mFeatures.add(abstractMapFeature);
        }
        this.mQueuedFeatures = null;
    }

    @Override // com.mappls.sdk.maps.MapView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent && this.mScrollEnabled.booleanValue()) {
            requestDisallowInterceptTouchEvent(true);
        }
        return zOnTouchEvent;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mPaused) {
            return;
        }
        MarkerViewManager markerViewManager = this.markerViewManager;
        if (markerViewManager != null) {
            markerViewManager.removeViews();
        }
        super.onLayout(z, i, i2, i3, i4);
        MarkerViewManager markerViewManager2 = this.markerViewManager;
        if (markerViewManager2 != null) {
            markerViewManager2.restoreViews();
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
    public boolean onMapClick(LatLng latLng) {
        RCTSource touchableSourceWithHighestZIndex;
        if (this.mAnnotationClicked) {
            this.mAnnotationClicked = false;
            return true;
        }
        PointF screenLocation = this.mMap.getProjection().toScreenLocation(latLng);
        List<RCTSource> allTouchableSources = getAllTouchableSources();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (RCTSource rCTSource : allTouchableSources) {
            Map<String, Double> touchHitbox = rCTSource.getTouchHitbox();
            if (touchHitbox != null) {
                float fFloatValue = touchHitbox.get("width").floatValue() / 2.0f;
                float fFloatValue2 = touchHitbox.get("height").floatValue() / 2.0f;
                RectF rectF = new RectF();
                rectF.set(screenLocation.x - fFloatValue, screenLocation.y - fFloatValue2, screenLocation.x + fFloatValue, screenLocation.y + fFloatValue2);
                List<Feature> listQueryRenderedFeatures = this.mMap.queryRenderedFeatures(rectF, rCTSource.getLayerIDs());
                if (listQueryRenderedFeatures.size() > 0) {
                    map.put(rCTSource.getID(), listQueryRenderedFeatures);
                    arrayList.add(rCTSource);
                }
            }
        }
        if (map.size() > 0 && (touchableSourceWithHighestZIndex = getTouchableSourceWithHighestZIndex(arrayList)) != null && touchableSourceWithHighestZIndex.hasPressListener()) {
            touchableSourceWithHighestZIndex.onPress(new RCTSource.OnPressEvent((List) map.get(touchableSourceWithHighestZIndex.getID()), latLng, screenLocation));
            return true;
        }
        this.mManager.handleEvent(new MapClickEvent(this, latLng, screenLocation));
        return false;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapLongClickListener
    public boolean onMapLongClick(LatLng latLng) {
        if (this.mAnnotationClicked) {
            this.mAnnotationClicked = false;
            return true;
        }
        this.mManager.handleEvent(new MapClickEvent(this, latLng, this.mMap.getProjection().toScreenLocation(latLng), EventTypes.MAP_LONG_CLICK));
        return false;
    }

    public void onMarkerClick(Symbol symbol) {
        this.mAnnotationClicked = true;
        long id = symbol.getId();
        Iterator<String> it2 = this.mPointAnnotations.keySet().iterator();
        RCTMGLPointAnnotation rCTMGLPointAnnotation = null;
        RCTMGLPointAnnotation rCTMGLPointAnnotation2 = null;
        while (it2.hasNext()) {
            RCTMGLPointAnnotation rCTMGLPointAnnotation3 = this.mPointAnnotations.get(it2.next());
            long mapboxID = rCTMGLPointAnnotation3.getMapboxID();
            long j = this.mActiveMarkerID;
            if (j == mapboxID) {
                rCTMGLPointAnnotation = rCTMGLPointAnnotation3;
            }
            if (id == mapboxID && j != mapboxID) {
                rCTMGLPointAnnotation2 = rCTMGLPointAnnotation3;
            }
        }
        if (rCTMGLPointAnnotation != null) {
            deselectAnnotation(rCTMGLPointAnnotation);
        }
        if (rCTMGLPointAnnotation2 != null) {
            selectAnnotation(rCTMGLPointAnnotation2);
        }
    }

    public void selectAnnotation(RCTMGLPointAnnotation rCTMGLPointAnnotation) {
        this.mActiveMarkerID = rCTMGLPointAnnotation.getMapboxID();
        rCTMGLPointAnnotation.onSelect(true);
    }

    public void deselectAnnotation(RCTMGLPointAnnotation rCTMGLPointAnnotation) {
        this.mActiveMarkerID = -1L;
        rCTMGLPointAnnotation.onDeselect();
    }

    @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
    public void onCameraDidChange(boolean z) {
        this.mCameraChangeTracker.setIsAnimating(z);
    }

    @Override // com.mappls.sdk.maps.MapView.OnCameraIsChangingListener
    public void onCameraIsChanging() {
        handleMapChangedEvent(EventTypes.REGION_IS_CHANGING);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFailLoadingMapListener
    public void onDidFailLoadingMap(String str) {
        handleMapChangedEvent(EventTypes.DID_FAIL_LOADING_MAP);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingMapListener
    public void onDidFinishLoadingMap() {
        handleMapChangedEvent(EventTypes.DID_FINISH_LOADING_MAP);
    }

    @Override // com.mappls.sdk.maps.MapView.OnWillStartRenderingFrameListener
    public void onWillStartRenderingFrame() {
        handleMapChangedEvent(EventTypes.WILL_START_RENDERING_FRAME);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishRenderingFrameListener
    public void onDidFinishRenderingFrame(boolean z) {
        if (z) {
            handleMapChangedEvent(EventTypes.DID_FINISH_RENDERING_FRAME_FULLY);
        } else {
            handleMapChangedEvent(EventTypes.DID_FINISH_RENDERING_FRAME);
        }
    }

    @Override // com.mappls.sdk.maps.MapView.OnWillStartRenderingMapListener
    public void onWillStartRenderingMap() {
        handleMapChangedEvent(EventTypes.WILL_START_RENDERING_MAP);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishRenderingMapListener
    public void onDidFinishRenderingMap(boolean z) {
        if (z) {
            for (Pair<Integer, ReadableArray> pair : this.mPreRenderMethods) {
                Integer num = (Integer) pair.first;
                this.mManager.receiveCommand(this, num.intValue(), (ReadableArray) pair.second);
            }
            this.mPreRenderMethods.clear();
            handleMapChangedEvent(EventTypes.DID_FINISH_RENDERING_MAP_FULLY);
            return;
        }
        handleMapChangedEvent(EventTypes.DID_FINISH_RENDERING_MAP);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        handleMapChangedEvent(EventTypes.DID_FINISH_LOADING_STYLE);
    }

    @Override // com.mappls.sdk.maps.MapView.OnStyleImageMissingListener
    public void onStyleImageMissing(String str) {
        Iterator<RCTMGLImages> it2 = this.mImages.iterator();
        while (it2.hasNext()) {
            if (it2.next().addMissingImageToStyle(str, this.mMap)) {
                return;
            }
        }
        Iterator<RCTMGLImages> it3 = this.mImages.iterator();
        while (it3.hasNext()) {
            it3.next().sendImageMissingEvent(str, this.mMap);
        }
    }

    private float getDisplayDensity() {
        return this.mContext.getResources().getDisplayMetrics().density;
    }

    public void setReactMapplsStyle(String str) {
        this.mapplsStyle = str;
        if (str == null || this.mMap == null) {
            return;
        }
        removeAllSourcesFromMap();
        this.mMap.setMapplsStyle(str, new OnStyleLoadListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.12
            @Override // com.mappls.sdk.maps.style.OnStyleLoadListener
            public void onError(String str2) {
            }

            @Override // com.mappls.sdk.maps.style.OnStyleLoadListener
            public void onStyleLoaded(Style style) {
                RCTMGLMapView.this.addAllSourcesToMap();
            }
        });
    }

    public void setReactPreferredFramesPerSecond(Integer num) {
        this.mPreferredFramesPerSecond = num;
        updatePreferredFramesPerSecond();
    }

    public void setReactContentInset(ReadableArray readableArray) {
        this.mInsets = readableArray;
        updateInsets();
    }

    public void setLocalizeLabels(boolean z) {
        this.mLocalizeLabels = z;
    }

    public void setReactZoomEnabled(boolean z) {
        this.mZoomEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactScrollEnabled(boolean z) {
        this.mScrollEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactPitchEnabled(boolean z) {
        this.mPitchEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactRotateEnabled(boolean z) {
        this.mRotateEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactAnchorRotateOrZoomGesturesToCenter(boolean z) {
        this.mAnchorRotateOrZoomGesturesToCenter = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactLogoEnabled(boolean z) {
        this.mLogoEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactLogoPosition(ReadableMap readableMap) {
        if (readableMap == null) {
            if (this.mLogoGravity != null) {
                MapplsMapOptions mapplsMapOptionsCreateFromAttributes = MapplsMapOptions.createFromAttributes(this.mContext);
                this.mLogoGravity = Integer.valueOf(mapplsMapOptionsCreateFromAttributes.getLogoGravity());
                this.mLogoMargins = Arrays.copyOf(mapplsMapOptionsCreateFromAttributes.getLogoMargins(), 4);
                updateUISettings();
                return;
            }
            return;
        }
        this.mLogoGravity = 0;
        if (readableMap.hasKey("left")) {
            this.mLogoGravity = Integer.valueOf(this.mLogoGravity.intValue() | 8388611);
        }
        if (readableMap.hasKey("right")) {
            this.mLogoGravity = Integer.valueOf(this.mLogoGravity.intValue() | GravityCompat.END);
        }
        if (readableMap.hasKey("top")) {
            this.mLogoGravity = Integer.valueOf(this.mLogoGravity.intValue() | 48);
        }
        if (readableMap.hasKey("bottom")) {
            this.mLogoGravity = Integer.valueOf(this.mLogoGravity.intValue() | 80);
        }
        float displayDensity = getDisplayDensity();
        this.mLogoMargins = new int[]{readableMap.hasKey("left") ? ((int) displayDensity) * readableMap.getInt("left") : 0, readableMap.hasKey("top") ? ((int) displayDensity) * readableMap.getInt("top") : 0, readableMap.hasKey("right") ? ((int) displayDensity) * readableMap.getInt("right") : 0, readableMap.hasKey("bottom") ? ((int) displayDensity) * readableMap.getInt("bottom") : 0};
        updateUISettings();
    }

    public void setReactCompassEnabled(boolean z) {
        this.mCompassEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactCompassViewMargins(ReadableMap readableMap) {
        this.mCompassViewMargins = readableMap;
        updateUISettings();
    }

    public void setReactCompassViewPosition(int i) {
        this.mCompassViewPosition = i;
        updateUISettings();
    }

    public void setReactAttributionEnabled(boolean z) {
        this.mAttributionEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactFloor(int i) {
        this.floor = Integer.valueOf(i);
        updateUISettings();
    }

    public void setReactEnableTraffic(boolean z) {
        this.isEnableTraffic = z;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap != null) {
            mapplsMap.enableTraffic(z);
        }
    }

    public void setReactEnableTrafficClosure(boolean z) {
        this.isEnableTrafficClosure = z;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap != null) {
            mapplsMap.enableTrafficClosure(z);
        }
    }

    public void setReactEnableTrafficFreeFlow(boolean z) {
        this.isEnableTrafficFreeFlow = z;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap != null) {
            mapplsMap.enableTrafficFreeFlow(z);
        }
    }

    public void setReactEnableTrafficNonFreeFlow(boolean z) {
        this.isEnableTrafficNonFreeFlow = z;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap != null) {
            mapplsMap.enableTrafficNonFreeFlow(z);
        }
    }

    public void setReactTrafficStopIcon(boolean z) {
        this.isEnableTrafficStopIcon = z;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap != null) {
            mapplsMap.enableTrafficStopIcon(z);
        }
    }

    public void setReactLayerControlEnabled(boolean z) {
        this.mLayerControlEnabled = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactLogoClickEnabled(boolean z) {
        this.mEnableLogoClick = Boolean.valueOf(z);
        updateUISettings();
    }

    public void setReactAttributionPosition(ReadableMap readableMap) {
        if (readableMap == null) {
            if (this.mAttributionGravity != null) {
                MapplsMapOptions mapplsMapOptionsCreateFromAttributes = MapplsMapOptions.createFromAttributes(this.mContext);
                this.mAttributionGravity = Integer.valueOf(mapplsMapOptionsCreateFromAttributes.getAttributionGravity());
                this.mAttributionMargin = Arrays.copyOf(mapplsMapOptionsCreateFromAttributes.getAttributionMargins(), 4);
                updateUISettings();
                return;
            }
            return;
        }
        this.mAttributionGravity = 0;
        if (readableMap.hasKey("left")) {
            this.mAttributionGravity = Integer.valueOf(this.mAttributionGravity.intValue() | 8388611);
        }
        if (readableMap.hasKey("right")) {
            this.mAttributionGravity = Integer.valueOf(this.mAttributionGravity.intValue() | GravityCompat.END);
        }
        if (readableMap.hasKey("top")) {
            this.mAttributionGravity = Integer.valueOf(this.mAttributionGravity.intValue() | 48);
        }
        if (readableMap.hasKey("bottom")) {
            this.mAttributionGravity = Integer.valueOf(this.mAttributionGravity.intValue() | 80);
        }
        float displayDensity = getDisplayDensity();
        this.mAttributionMargin = new int[]{readableMap.hasKey("left") ? ((int) displayDensity) * readableMap.getInt("left") : 0, readableMap.hasKey("top") ? ((int) displayDensity) * readableMap.getInt("top") : 0, readableMap.hasKey("right") ? ((int) displayDensity) * readableMap.getInt("right") : 0, readableMap.hasKey("bottom") ? ((int) displayDensity) * readableMap.getInt("bottom") : 0};
        updateUISettings();
    }

    public void setReactEventPosition(ReadableMap readableMap) {
        if (readableMap == null) {
            if (this.mEventGravity != null) {
                MapplsMapOptions mapplsMapOptionsCreateFromAttributes = MapplsMapOptions.createFromAttributes(this.mContext);
                this.mEventGravity = Integer.valueOf(mapplsMapOptionsCreateFromAttributes.getEventGravity());
                this.mEventMargin = Arrays.copyOf(mapplsMapOptionsCreateFromAttributes.getEventMargins(), 4);
                updateUISettings();
                return;
            }
            return;
        }
        this.mEventGravity = 0;
        if (readableMap.hasKey("left")) {
            this.mEventGravity = Integer.valueOf(this.mEventGravity.intValue() | 8388611);
        }
        if (readableMap.hasKey("right")) {
            this.mEventGravity = Integer.valueOf(this.mEventGravity.intValue() | GravityCompat.END);
        }
        if (readableMap.hasKey("top")) {
            this.mEventGravity = Integer.valueOf(this.mEventGravity.intValue() | 48);
        }
        if (readableMap.hasKey("bottom")) {
            this.mEventGravity = Integer.valueOf(this.mEventGravity.intValue() | 80);
        }
        float displayDensity = getDisplayDensity();
        this.mEventMargin = new int[]{readableMap.hasKey("left") ? ((int) displayDensity) * readableMap.getInt("left") : 0, readableMap.hasKey("top") ? ((int) displayDensity) * readableMap.getInt("top") : 0, readableMap.hasKey("right") ? ((int) displayDensity) * readableMap.getInt("right") : 0, readableMap.hasKey("bottom") ? ((int) displayDensity) * readableMap.getInt("bottom") : 0};
        updateUISettings();
    }

    public void setEnableInfoWindow(Boolean bool) {
        if (bool != null) {
            this.shouldShowInfoWindow = bool.booleanValue();
        }
    }

    public void setReactLayerControlPosition(ReadableMap readableMap) {
        if (readableMap == null) {
            if (this.mLayerControlGravity != null) {
                MapplsMapOptions mapplsMapOptionsCreateFromAttributes = MapplsMapOptions.createFromAttributes(this.mContext);
                this.mLayerControlGravity = Integer.valueOf(mapplsMapOptionsCreateFromAttributes.getLayerControlGravity());
                this.mLayerControlMargin = Arrays.copyOf(mapplsMapOptionsCreateFromAttributes.getLayerControlMargins(), 4);
                updateUISettings();
                return;
            }
            return;
        }
        this.mLayerControlGravity = 0;
        if (readableMap.hasKey("left")) {
            this.mLayerControlGravity = Integer.valueOf(this.mLayerControlGravity.intValue() | 8388611);
        }
        if (readableMap.hasKey("right")) {
            this.mLayerControlGravity = Integer.valueOf(this.mLayerControlGravity.intValue() | GravityCompat.END);
        }
        if (readableMap.hasKey("top")) {
            this.mLayerControlGravity = Integer.valueOf(this.mLayerControlGravity.intValue() | 48);
        }
        if (readableMap.hasKey("bottom")) {
            this.mLayerControlGravity = Integer.valueOf(this.mLayerControlGravity.intValue() | 80);
        }
        float displayDensity = getDisplayDensity();
        this.mLayerControlMargin = new int[]{readableMap.hasKey("left") ? ((int) displayDensity) * readableMap.getInt("left") : 0, readableMap.hasKey("top") ? ((int) displayDensity) * readableMap.getInt("top") : 0, readableMap.hasKey("right") ? ((int) displayDensity) * readableMap.getInt("right") : 0, readableMap.hasKey("bottom") ? ((int) displayDensity) * readableMap.getInt("bottom") : 0};
        updateUISettings();
    }

    public void queryRenderedFeaturesAtPoint(String str, PointF pointF, Expression expression, List<String> list) {
        List<Feature> listQueryRenderedFeatures = this.mMap.queryRenderedFeatures(pointF, expression, (String[]) list.toArray(new String[list.size()]));
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("data", FeatureCollection.fromFeatures(listQueryRenderedFeatures).toJson());
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getZoom(String str) {
        CameraPosition cameraPosition = this.mMap.getCameraPosition();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("zoom", cameraPosition.zoom);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void queryRenderedFeaturesInRect(String str, RectF rectF, Expression expression, List<String> list) {
        List<Feature> listQueryRenderedFeatures = this.mMap.queryRenderedFeatures(rectF, expression, (String[]) list.toArray(new String[list.size()]));
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("data", FeatureCollection.fromFeatures(listQueryRenderedFeatures).toJson());
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getVisibleBounds(String str) {
        VisibleRegion visibleRegion = this.mMap.getProjection().getVisibleRegion();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putArray("visibleBounds", GeoJSONUtils.fromLatLngBounds(visibleRegion.latLngBounds));
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getEnableTraffic(String str) {
        boolean zIsEnableTraffic = this.mMap.isEnableTraffic();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("isEnableTraffic", zIsEnableTraffic);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getEnableTrafficClosure(String str) {
        boolean zIsEnableTrafficClosure = this.mMap.isEnableTrafficClosure();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("isEnableTrafficClosure", zIsEnableTrafficClosure);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getEnableTrafficFreeFlow(String str) {
        boolean zIsEnableTrafficFreeFlow = this.mMap.isEnableTrafficFreeFlow();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("isEnableTrafficFreeFlow", zIsEnableTrafficFreeFlow);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getEnableTrafficNonFreeFlow(String str) {
        boolean zIsEnableTrafficNonFreeFlow = this.mMap.isEnableTrafficNonFreeFlow();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("isEnableTrafficNonFreeFlow", zIsEnableTrafficNonFreeFlow);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getEnableTrafficStopIcon(String str) {
        boolean zIsEnableTrafficStopIcon = this.mMap.isEnableTrafficStopIcon();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("isEnableTrafficStopIcon", zIsEnableTrafficStopIcon);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getPointInView(String str, LatLng latLng) {
        PointF screenLocation = this.mMap.getProjection().toScreenLocation(latLng);
        float displayDensity = getDisplayDensity();
        screenLocation.x /= displayDensity;
        screenLocation.y /= displayDensity;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        writableNativeArray.pushDouble(screenLocation.x);
        writableNativeArray.pushDouble(screenLocation.y);
        writableNativeMap.putArray("pointInView", writableNativeArray);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void getCoordinateFromView(String str, PointF pointF) {
        float displayDensity = getDisplayDensity();
        pointF.x *= displayDensity;
        pointF.y *= displayDensity;
        LatLng latLngFromScreenLocation = this.mMap.getProjection().fromScreenLocation(pointF);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        writableNativeArray.pushDouble(latLngFromScreenLocation.getLongitude());
        writableNativeArray.pushDouble(latLngFromScreenLocation.getLatitude());
        writableNativeMap.putArray("coordinateFromView", writableNativeArray);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void takeSnap(final String str, final boolean z) {
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null) {
            throw new Error("takeSnap should only be called after the map has rendered");
        }
        mapplsMap.snapshot(new MapplsMap.SnapshotReadyCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.13
            @Override // com.mappls.sdk.maps.MapplsMap.SnapshotReadyCallback
            public void onSnapshotReady(Bitmap bitmap) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString(ReactNativeBlobUtilConst.DATA_ENCODE_URI, z ? BitmapUtils.createTempFile(RCTMGLMapView.this.mContext, bitmap) : BitmapUtils.createBase64(bitmap));
                RCTMGLMapView.this.mManager.handleEvent(new AndroidCallbackEvent(RCTMGLMapView.this, str, writableNativeMap));
            }
        });
    }

    public void getCenter(String str) {
        LatLng latLng = this.mMap.getCameraPosition().target;
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        writableNativeArray.pushDouble(latLng.getLongitude());
        writableNativeArray.pushDouble(latLng.getLatitude());
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putArray("center", writableNativeArray);
        this.mManager.handleEvent(new AndroidCallbackEvent(this, str, writableNativeMap));
    }

    public void showAttribution() {
        new AttributionDialogManager(this.mContext, this.mMap).onClick(this);
    }

    public void setSourceVisibility(final boolean z, final String str, @Nullable final String str2) {
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null) {
            return;
        }
        mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.14
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                String str3;
                for (Layer layer : style.getLayers()) {
                    LayerSourceInfo layerSourceInfo = new LayerSourceInfo(layer);
                    if (layerSourceInfo.sourceId.equals(str) && ((str3 = str2) == null || str3.equals(layerSourceInfo.sourceLayerId))) {
                        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                        propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
                        layer.setProperties(propertyValueArr);
                    }
                }
            }
        });
    }

    public void init() {
        getViewTreeObserver().dispatchOnGlobalLayout();
    }

    @Override // com.mappls.sdk.maps.MapView
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public void getStyle(Style.OnStyleLoaded onStyleLoaded) {
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null) {
            return;
        }
        mapplsMap.getStyle(onStyleLoaded);
    }

    private void updateUISettings() {
        UiSettings uiSettings;
        Boolean bool;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null || (uiSettings = mapplsMap.getUiSettings()) == null) {
            return;
        }
        if (this.mScrollEnabled != null && uiSettings.isScrollGesturesEnabled() != this.mScrollEnabled.booleanValue()) {
            uiSettings.setScrollGesturesEnabled(this.mScrollEnabled.booleanValue());
            if (!this.mScrollEnabled.booleanValue()) {
                this.mMap.getGesturesManager().getMoveGestureDetector().interrupt();
            }
        }
        if (this.mPitchEnabled != null && uiSettings.isTiltGesturesEnabled() != this.mPitchEnabled.booleanValue()) {
            uiSettings.setTiltGesturesEnabled(this.mPitchEnabled.booleanValue());
        }
        if (this.mRotateEnabled != null && uiSettings.isRotateGesturesEnabled() != this.mRotateEnabled.booleanValue()) {
            uiSettings.setRotateGesturesEnabled(this.mRotateEnabled.booleanValue());
            if (!this.mRotateEnabled.booleanValue()) {
                this.mMap.getGesturesManager().getRotateGestureDetector().interrupt();
            }
        }
        if (this.mAttributionEnabled != null && uiSettings.isAttributionEnabled() != this.mAttributionEnabled.booleanValue()) {
            uiSettings.setAttributionEnabled(this.mAttributionEnabled.booleanValue());
        }
        uiSettings.setLayerControlEnabled(false);
        if (this.mAttributionGravity != null && uiSettings.getAttributionGravity() != this.mAttributionGravity.intValue()) {
            uiSettings.setAttributionGravity(this.mAttributionGravity.intValue());
        }
        if (this.mEventGravity != null && uiSettings.getEventGravity() != this.mEventGravity.intValue()) {
            uiSettings.setEventGravity(this.mEventGravity.intValue());
        }
        if (this.mLayerControlGravity != null && uiSettings.getLayerControlGravity() != this.mLayerControlGravity.intValue()) {
            uiSettings.setLayerControlGravity(this.mLayerControlGravity.intValue());
        }
        if (this.mAttributionMargin != null && (uiSettings.getAttributionMarginLeft() != this.mAttributionMargin[0] || uiSettings.getAttributionMarginTop() != this.mAttributionMargin[1] || uiSettings.getAttributionMarginRight() != this.mAttributionMargin[2] || uiSettings.getAttributionMarginBottom() != this.mAttributionMargin[3])) {
            int[] iArr = this.mAttributionMargin;
            uiSettings.setAttributionMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        if (this.mEventMargin != null && (uiSettings.getEventMarginLeft() != this.mEventMargin[0] || uiSettings.getEventMarginTop() != this.mEventMargin[1] || uiSettings.getEventMarginRight() != this.mEventMargin[2] || uiSettings.getEventMarginBottom() != this.mEventMargin[3])) {
            int[] iArr2 = this.mEventMargin;
            uiSettings.setEventMargins(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        }
        if (this.mLayerControlMargin != null && (uiSettings.getLayerControlMarginLeft() != this.mLayerControlMargin[0] || uiSettings.getLayerControlMarginTop() != this.mLayerControlMargin[1] || uiSettings.getLayerControlMarginRight() != this.mLayerControlMargin[2] || uiSettings.getLayerControlMarginBottom() != this.mLayerControlMargin[3])) {
            int[] iArr3 = this.mLayerControlMargin;
            uiSettings.setLayerControlMargins(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
        }
        if (this.mLogoEnabled != null && uiSettings.isLogoEnabled() != this.mLogoEnabled.booleanValue()) {
            uiSettings.setLogoEnabled(this.mLogoEnabled.booleanValue());
        }
        if (this.mLogoGravity != null && uiSettings.getLogoGravity() != this.mLogoGravity.intValue()) {
            uiSettings.setLogoGravity(this.mLogoGravity.intValue());
        }
        if (this.mAnchorRotateOrZoomGesturesToCenter != null && uiSettings.isAnchorRotateOrZoomGesturesToCenterCoordinate() != this.mAnchorRotateOrZoomGesturesToCenter.booleanValue()) {
            uiSettings.setAnchorRotateOrZoomGesturesToCenterCoordinate(this.mAnchorRotateOrZoomGesturesToCenter.booleanValue());
        }
        if (this.mLogoMargins != null && (uiSettings.getLogoMarginLeft() != this.mLogoMargins[0] || uiSettings.getLogoMarginTop() != this.mLogoMargins[1] || uiSettings.getLogoMarginRight() != this.mLogoMargins[2] || uiSettings.getLogoMarginBottom() != this.mLogoMargins[3])) {
            int[] iArr4 = this.mLogoMargins;
            uiSettings.setLogoMargins(iArr4[0], iArr4[1], iArr4[2], iArr4[3]);
        }
        if (this.mCompassEnabled != null && uiSettings.isCompassEnabled() != this.mCompassEnabled.booleanValue()) {
            uiSettings.setCompassEnabled(this.mCompassEnabled.booleanValue());
        }
        if (this.mCompassViewPosition != -1 && uiSettings.isCompassEnabled()) {
            int i = this.mCompassViewPosition;
            if (i == 0) {
                uiSettings.setCompassGravity(8388659);
            } else if (i == 1) {
                uiSettings.setCompassGravity(8388661);
            } else if (i == 2) {
                uiSettings.setCompassGravity(8388691);
            } else if (i == 3) {
                uiSettings.setCompassGravity(8388693);
            }
        }
        if (this.mCompassViewMargins != null && uiSettings.isCompassEnabled()) {
            int i2 = (int) getResources().getDisplayMetrics().density;
            int i3 = this.mCompassViewMargins.getInt("x") * i2;
            int i4 = this.mCompassViewMargins.getInt("y") * i2;
            int compassGravity = uiSettings.getCompassGravity();
            if (compassGravity == 8388659) {
                uiSettings.setCompassMargins(i3, i4, 0, 0);
            } else if (compassGravity == 8388691) {
                uiSettings.setCompassMargins(i3, 0, 0, i4);
            } else if (compassGravity != 8388693) {
                uiSettings.setCompassMargins(0, i4, i3, 0);
            } else {
                uiSettings.setCompassMargins(0, 0, i3, i4);
            }
        }
        if (this.floor != null && (bool = this.mLayerControlEnabled) != null && bool.booleanValue()) {
            this.mMap.setFloor(this.floor.intValue());
        }
        this.mMap.enableTraffic(this.isEnableTraffic);
        this.mMap.enableTrafficClosure(this.isEnableTrafficClosure);
        this.mMap.enableTrafficFreeFlow(this.isEnableTrafficFreeFlow);
        this.mMap.enableTrafficNonFreeFlow(this.isEnableTrafficNonFreeFlow);
        this.mMap.enableTrafficStopIcon(this.isEnableTrafficStopIcon);
        if (this.mZoomEnabled != null && uiSettings.isZoomGesturesEnabled() != this.mZoomEnabled.booleanValue()) {
            uiSettings.setZoomGesturesEnabled(this.mZoomEnabled.booleanValue());
            if (!this.mZoomEnabled.booleanValue()) {
                this.mMap.getGesturesManager().getStandardScaleGestureDetector().interrupt();
            }
        }
        if (this.mEnableLogoClick == null || uiSettings.isEnableLogoClick() == this.mEnableLogoClick.booleanValue()) {
            return;
        }
        uiSettings.enableLogoClick(this.mEnableLogoClick.booleanValue());
        if (this.mEnableLogoClick.booleanValue()) {
            return;
        }
        this.mMap.getGesturesManager().getStandardScaleGestureDetector().interrupt();
    }

    private void updatePreferredFramesPerSecond() {
        Integer num = this.mPreferredFramesPerSecond;
        if (num == null) {
            return;
        }
        setMaximumFps(num.intValue());
    }

    public double[] getContentInset() {
        double d;
        double d2;
        double d3;
        double d4;
        ReadableArray readableArray = this.mInsets;
        if (readableArray == null) {
            return new double[]{0.0d, 0.0d, 0.0d, 0.0d};
        }
        if (readableArray.size() == 4) {
            d = this.mInsets.getInt(0);
            d2 = this.mInsets.getInt(1);
            d3 = this.mInsets.getInt(2);
            d4 = this.mInsets.getInt(3);
        } else if (this.mInsets.size() == 2) {
            d = this.mInsets.getInt(0);
            d2 = this.mInsets.getInt(1);
            d3 = d;
            d4 = d2;
        } else {
            d = this.mInsets.size() == 1 ? this.mInsets.getInt(0) : 0.0d;
            d2 = d;
            d3 = d2;
            d4 = d3;
        }
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return new double[]{d4 * ((double) displayMetrics.scaledDensity), d * ((double) displayMetrics.scaledDensity), d2 * ((double) displayMetrics.scaledDensity), d3 * ((double) displayMetrics.scaledDensity)};
    }

    private void updateInsets() {
        if (this.mMap == null || this.mInsets == null) {
            return;
        }
        double[] contentInset = getContentInset();
        double d = contentInset[1];
        double d2 = contentInset[2];
        double d3 = contentInset[3];
        this.mMap.setPadding(Double.valueOf(contentInset[0]).intValue(), Double.valueOf(d).intValue(), Double.valueOf(d2).intValue(), Double.valueOf(d3).intValue());
    }

    private void setLifecycleListeners() {
        ReactContext reactContext = (ReactContext) this.mContext;
        LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView.15
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                RCTMGLMapView.this.onResume();
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                RCTMGLMapView.this.onPause();
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                RCTMGLMapView.this.dispose();
            }
        };
        this.mLifeCycleListener = lifecycleEventListener;
        reactContext.addLifecycleEventListener(lifecycleEventListener);
    }

    private WritableMap makeRegionPayload(Boolean bool) {
        CameraPosition cameraPosition = this.mMap.getCameraPosition();
        if (cameraPosition == null || cameraPosition.target == null) {
            return new WritableNativeMap();
        }
        LatLng latLng = new LatLng(cameraPosition.target.getLatitude(), cameraPosition.target.getLongitude());
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("zoomLevel", cameraPosition.zoom);
        writableNativeMap.putDouble("heading", cameraPosition.bearing);
        writableNativeMap.putDouble("pitch", cameraPosition.tilt);
        writableNativeMap.putBoolean("animated", bool == null ? this.mCameraChangeTracker.isAnimated() : bool.booleanValue());
        writableNativeMap.putBoolean("isUserInteraction", this.mCameraChangeTracker.isUserInteraction());
        try {
            writableNativeMap.putArray("visibleBounds", GeoJSONUtils.fromLatLngBounds(this.mMap.getProjection().getVisibleRegion().latLngBounds));
        } catch (Exception e) {
            Logger.e("RCTMGLMapView", String.format("An error occurred while attempting to make the region: %s", e.getMessage()));
        }
        return GeoJSONUtils.toPointFeature(latLng, writableNativeMap);
    }

    public void sendRegionChangeEvent(boolean z) {
        this.mManager.handleEvent(new MapChangeEvent(this, EventTypes.REGION_DID_CHANGE, makeRegionPayload(new Boolean(z))));
        this.mCameraChangeTracker.setReason(-1);
    }

    private void removeAllSourcesFromMap() {
        if (this.mSources.size() == 0) {
            return;
        }
        Iterator<String> it2 = this.mSources.keySet().iterator();
        while (it2.hasNext()) {
            this.mSources.get(it2.next()).removeFromMap(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSourcesToMap() {
        if (this.mSources.size() == 0) {
            return;
        }
        Iterator<String> it2 = this.mSources.keySet().iterator();
        while (it2.hasNext()) {
            this.mSources.get(it2.next()).addToMap(this);
        }
    }

    private List<RCTSource> getAllTouchableSources() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it2 = this.mSources.keySet().iterator();
        while (it2.hasNext()) {
            RCTSource rCTSource = this.mSources.get(it2.next());
            if (rCTSource != null && rCTSource.hasPressListener()) {
                arrayList.add(rCTSource);
            }
        }
        return arrayList;
    }

    private List<RCTMGLShapeSource> getAllShapeSources() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it2 = this.mSources.keySet().iterator();
        while (it2.hasNext()) {
            RCTSource rCTSource = this.mSources.get(it2.next());
            if (rCTSource instanceof RCTMGLShapeSource) {
                arrayList.add((RCTMGLShapeSource) rCTSource);
            }
        }
        return arrayList;
    }

    private RCTSource getTouchableSourceWithHighestZIndex(List<RCTSource> list) {
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            HashMap map = new HashMap();
            for (RCTSource rCTSource : list) {
                for (String str : rCTSource.getLayerIDs()) {
                    map.put(str, rCTSource);
                }
            }
            List<Layer> layers = this.mMap.getStyle().getLayers();
            for (int size = layers.size() - 1; size >= 0; size--) {
                String id = layers.get(size).getId();
                if (map.containsKey(id)) {
                    return (RCTSource) map.get(id);
                }
            }
        }
        return null;
    }

    private boolean hasSetCenterCoordinate() {
        LatLng latLng = this.mMap.getCameraPosition().target;
        return (latLng.getLatitude() == 0.0d || latLng.getLongitude() == 0.0d) ? false : true;
    }

    private double getMapRotation() {
        return this.mMap.getCameraPosition().bearing;
    }

    public void sendRegionDidChangeEvent() {
        handleMapChangedEvent(EventTypes.REGION_DID_CHANGE);
        this.mCameraChangeTracker.setReason(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMapChangedEvent(String str) {
        MapChangeEvent mapChangeEvent;
        if (canHandleEvent(str)) {
            str.hashCode();
            switch (str) {
                case "regiondidchange":
                case "regionischanging":
                case "regionwillchange":
                    mapChangeEvent = new MapChangeEvent(this, str, makeRegionPayload(null));
                    break;
                default:
                    mapChangeEvent = new MapChangeEvent(this, str);
                    break;
            }
            this.mManager.handleEvent(mapChangeEvent);
        }
    }

    private boolean canHandleEvent(String str) {
        HashSet<String> hashSet = this.mHandledMapChangedEvents;
        return hashSet == null || hashSet.contains(str);
    }

    public void setHandledMapChangedEvents(ArrayList<String> arrayList) {
        this.mHandledMapChangedEvents = new HashSet<>(arrayList);
    }

    private void sendUserLocationUpdateEvent(Location location) {
        if (location == null) {
            return;
        }
        this.mManager.handleEvent(new MapChangeEvent(this, EventTypes.USER_LOCATION_UPDATED, makeLocationChangePayload(location)));
    }

    private WritableMap makeLocationChangePayload(Location location) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("longitude", location.getLongitude());
        writableNativeMap2.putDouble("latitude", location.getLatitude());
        writableNativeMap2.putDouble(SavingTrackHelper.TRACK_COL_ALTITUDE, location.getAltitude());
        writableNativeMap2.putDouble("accuracy", location.getAccuracy());
        writableNativeMap2.putDouble("heading", location.getBearing());
        writableNativeMap2.putDouble("course", location.getBearing());
        writableNativeMap2.putDouble("speed", location.getSpeed());
        writableNativeMap.putMap("coords", writableNativeMap2);
        writableNativeMap.putDouble("timestamp", location.getTime());
        return writableNativeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpImage(Style style) {
        style.addImage("MARKER_IMAGE_ID", BitmapFactory.decodeResource(getResources(), R.drawable.red_marker));
    }

    public ViewGroup offscreenAnnotationViewContainer() {
        if (this.mOffscreenAnnotationViewContainer == null) {
            this.mOffscreenAnnotationViewContainer = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
            layoutParams.setMargins(-10000, -10000, -10000, -10000);
            this.mOffscreenAnnotationViewContainer.setLayoutParams(layoutParams);
            addView(this.mOffscreenAnnotationViewContainer);
        }
        return this.mOffscreenAnnotationViewContainer;
    }

    public MarkerViewManager getMarkerViewManager(MapplsMap mapplsMap) {
        if (this.markerViewManager == null) {
            if (mapplsMap == null) {
                throw new Error("makerViewManager should be called one the map has loaded");
            }
            this.markerViewManager = new MarkerViewManager(this, mapplsMap);
        }
        return this.markerViewManager;
    }

    public LocationComponentManager getLocationComponentManager() {
        if (this.mLocationComponentManager == null) {
            this.mLocationComponentManager = new LocationComponentManager(this, this.mContext);
        }
        return this.mLocationComponentManager;
    }

    @Nullable
    public Integer getTintColor() {
        return this.mTintColor;
    }

    public void setTintColor(@Nullable Integer num) {
        if (this.mTintColor == num) {
            return;
        }
        this.mTintColor = num;
        updateUISettings();
        LocationComponentManager locationComponentManager = this.mLocationComponentManager;
        if (locationComponentManager == null) {
            return;
        }
        locationComponentManager.update(getMapplsMap().getStyle());
    }
}
