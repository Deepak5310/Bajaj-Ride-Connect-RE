package com.mappls.sdk.maps;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.internal.LinkedTreeMap;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.gestures.AndroidGesturesManager;
import com.mappls.sdk.maps.attribution.AttributionView;
import com.mappls.sdk.maps.auth.MapplsVectorKey;
import com.mappls.sdk.maps.auth.model.PublicKeyToken;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.exceptions.MapplsConfigurationException;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.module.http.MapplsMapManager;
import com.mappls.sdk.maps.net.ConnectivityReceiver;
import com.mappls.sdk.maps.promo.MapplsPromo;
import com.mappls.sdk.maps.promo.model.HyperlinkContent;
import com.mappls.sdk.maps.promo.model.Promo;
import com.mappls.sdk.maps.renderer.MapRenderer;
import com.mappls.sdk.maps.renderer.glsurfaceview.GLSurfaceViewMapRenderer;
import com.mappls.sdk.maps.renderer.glsurfaceview.MapplsGLSurfaceView;
import com.mappls.sdk.maps.renderer.textureview.TextureViewMapRenderer;
import com.mappls.sdk.maps.session.AuthenticationError;
import com.mappls.sdk.maps.session.IStopSession;
import com.mappls.sdk.maps.session.InitializationListener;
import com.mappls.sdk.maps.storage.FileSource;
import com.mappls.sdk.maps.style.IStyleListener;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.widgets.CompassView;
import com.mappls.sdk.maps.widgets.LogoView;
import com.mappls.sdk.maps.widgets.indoor.FloorControllerView;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.services.account.MapplsAccountManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class MapView extends FrameLayout implements NativeMapView.ViewCallback {
    private static final long RETRY_DELAY_FACTOR = 300;
    private AttributionClickListener attributionClickListener;
    private FloorControllerView attributionsView;
    private AuthenticationError authenticationError;
    private final CameraChangeDispatcher cameraDispatcher;
    private CompassView compassView;
    private boolean destroyed;
    private TextView errorTextView;
    private ImageView eventView;
    private final FocalPointInvalidator focalInvalidator;
    private PointF focalPoint;
    private final InitialRenderCallback initialRenderCallback;
    boolean isAct;
    boolean isInitialized;
    private boolean isStarted;
    private View loadingMapIssueLayout;
    private TextView loadingMapTextView;
    private LogoView logoView;
    private final MapCallback mapCallback;
    private final MapChangeReceiver mapChangeReceiver;
    private MapGestureDetector mapGestureDetector;
    private MapKeyListener mapKeyListener;
    private MapRenderer mapRenderer;
    private MapplsMap mapplsMap;
    MapplsMapOptions mapplsMapOptions;
    private NativeMap nativeMapView;
    private final GesturesManagerInteractionListener registerTouchListener;
    private View renderView;
    private Button retryButton;
    private int retryCount;
    private Handler retryHandler;
    private Bundle savedInstanceState;
    private View splashView;
    boolean surfaceCreated;

    public interface OnCameraDidChangeListener {
        void onCameraDidChange(boolean z);
    }

    public interface OnCameraIsChangingListener {
        void onCameraIsChanging();
    }

    public interface OnCameraWillChangeListener {
        void onCameraWillChange(boolean z);
    }

    public interface OnCanRemoveUnusedStyleImageListener {
        boolean onCanRemoveUnusedStyleImage(String str);
    }

    public interface OnDidBecomeIdleListener {
        void onDidBecomeIdle();
    }

    public interface OnDidFailLoadingMapListener {
        void onDidFailLoadingMap(String str);
    }

    public interface OnDidFinishLoadingMapListener {
        void onDidFinishLoadingMap();
    }

    public interface OnDidFinishLoadingStyleListener {
        void onDidFinishLoadingStyle();
    }

    public interface OnDidFinishRenderingFrameListener {
        void onDidFinishRenderingFrame(boolean z);
    }

    public interface OnDidFinishRenderingMapListener {
        void onDidFinishRenderingMap(boolean z);
    }

    public interface OnSourceChangedListener {
        void onSourceChangedListener(String str);
    }

    public interface OnStyleImageMissingListener {
        void onStyleImageMissing(String str);
    }

    public interface OnWillStartLoadingMapListener {
        void onWillStartLoadingMap();
    }

    public interface OnWillStartRenderingFrameListener {
        void onWillStartRenderingFrame();
    }

    public interface OnWillStartRenderingMapListener {
        void onWillStartRenderingMap();
    }

    static /* synthetic */ int access$1108(MapView mapView) {
        int i = mapView.retryCount;
        mapView.retryCount = i + 1;
        return i;
    }

    public MapView(Context context) {
        super(context);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        this.isAct = false;
        this.surfaceCreated = false;
        this.isInitialized = false;
        this.retryCount = 0;
        this.retryHandler = new Handler(Looper.getMainLooper());
        if (!ConnectivityReceiver.instance(context).isOffline()) {
            if (!MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
                initAuthenticationView(context, MapplsMapOptions.createFromAttributes(context, null));
                return;
            } else {
                initialiseStyles(context, MapplsMapOptions.createFromAttributes(context, null));
                return;
            }
        }
        initialiseStyles(context, MapplsMapOptions.createFromAttributes(context, null));
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        this.isAct = false;
        this.surfaceCreated = false;
        this.isInitialized = false;
        this.retryCount = 0;
        this.retryHandler = new Handler(Looper.getMainLooper());
        if (!MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
            initAuthenticationView(context, MapplsMapOptions.createFromAttributes(context, attributeSet));
        } else {
            initialiseStyles(context, MapplsMapOptions.createFromAttributes(context, attributeSet));
        }
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        this.isAct = false;
        this.surfaceCreated = false;
        this.isInitialized = false;
        this.retryCount = 0;
        this.retryHandler = new Handler(Looper.getMainLooper());
        if (!MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
            initAuthenticationView(context, MapplsMapOptions.createFromAttributes(context, attributeSet));
        } else {
            initialiseStyles(context, MapplsMapOptions.createFromAttributes(context, attributeSet));
        }
    }

    public MapView(Context context, MapplsMapOptions mapplsMapOptions) {
        super(context);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        this.isAct = false;
        this.surfaceCreated = false;
        this.isInitialized = false;
        this.retryCount = 0;
        this.retryHandler = new Handler(Looper.getMainLooper());
        if (!MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
            initAuthenticationView(context, mapplsMapOptions == null ? MapplsMapOptions.createFromAttributes(context, null) : mapplsMapOptions);
        } else {
            initialiseStyles(context, mapplsMapOptions == null ? MapplsMapOptions.createFromAttributes(context, null) : mapplsMapOptions);
        }
    }

    public static void setMapStrictModeEnabled(boolean z) {
        MapStrictMode.setStrictModeEnabled(z);
    }

    protected void initialize(Context context, MapplsMapOptions mapplsMapOptions) {
        this.authenticationError = null;
        if (isInEditMode()) {
            return;
        }
        this.isInitialized = true;
        setForeground(new ColorDrawable(mapplsMapOptions.getForegroundLoadColor()));
        View view = this.splashView;
        if (view != null) {
            view.setVisibility(8);
        }
        if (!Mappls.hasInstance()) {
            throw new MapplsConfigurationException();
        }
        if (this.surfaceCreated) {
            onSurfaceCreated();
        }
        if (MapplsMapConfiguration.getInstance().isEnablePromotion()) {
            MapplsPromo.builder().build().enqueueCall(new Callback<List<Promo>>() { // from class: com.mappls.sdk.maps.MapView.1
                @Override // retrofit2.Callback
                public void onResponse(Call<List<Promo>> call, Response<List<Promo>> response) {
                    if (response.code() == 200) {
                        if (response.body().size() <= 0) {
                            if (MapView.this.eventView != null) {
                                MapView.this.eventView.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        for (Promo promo : response.body()) {
                            if (promo.getContentType().equalsIgnoreCase("Hyperlink")) {
                                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) promo.getContent();
                                String string = linkedTreeMap.containsKey("title") ? linkedTreeMap.get("title").toString() : null;
                                if (string != null && string.equalsIgnoreCase("COVID-19")) {
                                    String string2 = linkedTreeMap.get("iconSource").toString();
                                    final String string3 = linkedTreeMap.get("triggerUrl").toString();
                                    String string4 = linkedTreeMap.get(SavingTrackHelper.POINT_COL_DESCRIPTION).toString();
                                    HyperlinkContent hyperlinkContent = new HyperlinkContent();
                                    hyperlinkContent.setTitle(string);
                                    hyperlinkContent.setIconSource(string2);
                                    hyperlinkContent.setTriggerUrl(string3);
                                    hyperlinkContent.setDescription(string4);
                                    if (MapView.this.eventView != null) {
                                        MapView.this.eventView.setVisibility(0);
                                        MapView.this.eventView.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.maps.MapView.1.1
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view2) {
                                                MapView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string3)));
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<List<Promo>> call, Throwable th) {
                    if (MapView.this.eventView != null) {
                        MapView.this.eventView.setVisibility(8);
                    }
                }
            });
        }
    }

    private void initialiseLogoClick() {
        this.logoView.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.maps.MapView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MapView.this.mapplsMap == null || MapView.this.mapplsMap.getUiSettings() == null || !MapView.this.mapplsMap.getUiSettings().isEnableLogoClick()) {
                    return;
                }
                if (MapplsLMSManager.isInitialised()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("event_view", "logo");
                        MapplsLMSManager.getInstance().add("click", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://about.mappls.com/"));
                    intent.setFlags(268435456);
                    MapView.this.getContext().startActivity(intent);
                } catch (ActivityNotFoundException unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseMap() {
        Context context = getContext();
        this.focalInvalidator.addListener(createFocalPointChangeListener());
        Projection projection = new Projection(this.nativeMapView, this);
        UiSettings uiSettings = new UiSettings(projection, this.focalInvalidator, getPixelRatio(), this);
        LongSparseArray longSparseArray = new LongSparseArray();
        LongSparseArray longSparseArray2 = new LongSparseArray();
        IconManager iconManager = new IconManager(this.nativeMapView);
        AnnotationManager annotationManager = new AnnotationManager(this, longSparseArray, iconManager, new AnnotationContainer(this.nativeMapView, longSparseArray), new MarkerContainer(this.nativeMapView, longSparseArray, iconManager, longSparseArray2), new PolygonContainer(this.nativeMapView, longSparseArray), new PolylineContainer(this.nativeMapView, longSparseArray), new ShapeAnnotationContainer(this.nativeMapView, longSparseArray), longSparseArray2);
        Transform transform = new Transform(this, this.nativeMapView, this.cameraDispatcher);
        ArrayList arrayList = new ArrayList();
        MapplsMap mapplsMap = new MapplsMap(this.nativeMapView, transform, uiSettings, projection, this.registerTouchListener, this.cameraDispatcher, arrayList);
        this.mapplsMap = mapplsMap;
        mapplsMap.injectAnnotationManager(annotationManager);
        MapGestureDetector mapGestureDetector = new MapGestureDetector(context, transform, projection, uiSettings, annotationManager, this.cameraDispatcher);
        this.mapGestureDetector = mapGestureDetector;
        this.mapKeyListener = new MapKeyListener(transform, uiSettings, mapGestureDetector);
        MapplsMap mapplsMap2 = this.mapplsMap;
        mapplsMap2.injectLocationComponent(new LocationComponent(mapplsMap2, transform, arrayList));
        MapplsMap mapplsMap3 = this.mapplsMap;
        mapplsMap3.injectStyleLayerControl(new StyleLayerControl(mapplsMap3));
        MapplsMap mapplsMap4 = this.mapplsMap;
        mapplsMap4.injectTrafficPlugin(new TrafficPlugin(this, mapplsMap4));
        this.mapplsMap.injectPlaceIdPlugin(new PlaceIdPlugin(this.mapplsMap));
        setClickable(true);
        setLongClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestDisallowInterceptTouchEvent(true);
        this.nativeMapView.setReachability(Mappls.isConnected().booleanValue());
        Bundle bundle = this.savedInstanceState;
        if (bundle == null) {
            this.mapplsMap.initialise(context, this.mapplsMapOptions);
        } else {
            this.mapplsMap.onRestoreInstanceState(bundle);
        }
        this.mapCallback.initialised();
    }

    protected CompassView initialiseCompassView() {
        CompassView compassView = new CompassView(getContext());
        this.compassView = compassView;
        addView(compassView);
        this.compassView.setTag("compassView");
        this.compassView.getLayoutParams().width = -2;
        this.compassView.getLayoutParams().height = -2;
        this.compassView.setContentDescription(getResources().getString(R.string.mappls_maps_compassContentDescription));
        this.compassView.injectCompassAnimationListener(createCompassAnimationListener(this.cameraDispatcher));
        this.compassView.setOnClickListener(createCompassClickListener(this.cameraDispatcher));
        return this.compassView;
    }

    protected AttributionView initialiseAttributionView() {
        AttributionView attributionView = new AttributionView(getContext());
        addView(attributionView);
        attributionView.setTag("attrView");
        attributionView.getLayoutParams().width = -2;
        attributionView.getLayoutParams().height = -2;
        attributionView.setAdjustViewBounds(true);
        attributionView.setClickable(true);
        attributionView.setFocusable(true);
        attributionView.setContentDescription(getResources().getString(R.string.mappls_maps_attributionsIconContentDescription));
        attributionView.setImageDrawable(BitmapUtils.getDrawableFromRes(getContext(), R.drawable.mappls_maps_info_bg_selector));
        AttributionClickListener attributionClickListener = new AttributionClickListener(getContext(), this.mapplsMap);
        this.attributionClickListener = attributionClickListener;
        attributionView.setOnClickListener(attributionClickListener);
        return attributionView;
    }

    protected FloorControllerView initialiseLayerControlView() {
        FloorControllerView floorControllerView = new FloorControllerView(getContext());
        this.attributionsView = floorControllerView;
        addView(floorControllerView);
        this.attributionsView.setTag("attrView");
        this.attributionsView.getLayoutParams().width = -2;
        this.attributionsView.getLayoutParams().height = -2;
        this.attributionsView.setBackgroundResource(R.drawable.mappls_maps_floor_layer_bg);
        this.attributionsView.setClickable(true);
        this.attributionsView.setFocusable(true);
        return this.attributionsView;
    }

    protected ImageView initialiseEventView() {
        ImageView imageView = new ImageView(getContext());
        this.eventView = imageView;
        addView(imageView);
        this.eventView.getLayoutParams().width = -2;
        this.eventView.getLayoutParams().height = -2;
        this.eventView.setTag("eventView");
        this.eventView.setImageDrawable(BitmapUtils.getDrawableFromRes(getContext(), R.drawable.mappls_maps_fab_corona));
        this.eventView.setVisibility(8);
        return this.eventView;
    }

    protected LogoView initialiseLogoView() {
        LogoView logoView = new LogoView(getContext());
        this.logoView = logoView;
        addView(logoView);
        this.logoView.injectLogoView(this, this.mapplsMap);
        this.logoView.setTag("logoView");
        this.logoView.getLayoutParams().width = -2;
        this.logoView.getLayoutParams().height = -2;
        this.logoView.setVisibility(8);
        initialiseLogoClick();
        return this.logoView;
    }

    protected View initialiseSplashView() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.mappls_maps_splash_layout, (ViewGroup) null);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.splashView = viewInflate.findViewById(R.id.splash_view);
        Button button = (Button) viewInflate.findViewById(R.id.map_retry_button);
        this.retryButton = button;
        ViewCompat.setBackgroundTintList(button, ContextCompat.getColorStateList(getContext(), R.color.mappls_maps_light_gray));
        this.loadingMapTextView = (TextView) viewInflate.findViewById(R.id.loading_map_text_view);
        this.errorTextView = (TextView) viewInflate.findViewById(R.id.error_text_view);
        this.loadingMapIssueLayout = viewInflate.findViewById(R.id.map_loading_issue_layout);
        this.splashView.setVisibility(MapplsMapConfiguration.getInstance().isDeveloperShowingSplash() ? 8 : 0);
        addView(viewInflate);
        return viewInflate;
    }

    private FocalPointChangeListener createFocalPointChangeListener() {
        return new FocalPointChangeListener() { // from class: com.mappls.sdk.maps.MapView.3
            @Override // com.mappls.sdk.maps.FocalPointChangeListener
            public void onFocalPointChanged(PointF pointF) {
                MapView.this.focalPoint = pointF;
            }
        };
    }

    private MapplsMap.OnCompassAnimationListener createCompassAnimationListener(final CameraChangeDispatcher cameraChangeDispatcher) {
        return new MapplsMap.OnCompassAnimationListener() { // from class: com.mappls.sdk.maps.MapView.4
            @Override // com.mappls.sdk.maps.MapplsMap.OnCompassAnimationListener
            public void onCompassAnimation() {
                cameraChangeDispatcher.onCameraMove();
            }

            @Override // com.mappls.sdk.maps.MapplsMap.OnCompassAnimationListener
            public void onCompassAnimationFinished() {
                if (MapView.this.compassView != null) {
                    MapView.this.compassView.isAnimating(false);
                }
                cameraChangeDispatcher.onCameraIdle();
            }
        };
    }

    private View.OnClickListener createCompassClickListener(final CameraChangeDispatcher cameraChangeDispatcher) {
        return new View.OnClickListener() { // from class: com.mappls.sdk.maps.MapView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MapView.this.mapplsMap == null || MapView.this.compassView == null) {
                    return;
                }
                double d = MapView.this.mapplsMap.getCameraPosition().bearing;
                if (MapView.this.focalPoint != null) {
                    MapView.this.mapplsMap.setFocalBearing(0.0d, MapView.this.focalPoint.x, MapView.this.focalPoint.y, 150L);
                } else {
                    MapView.this.mapplsMap.setFocalBearing(0.0d, MapView.this.mapplsMap.getWidth() / 2.0f, MapView.this.mapplsMap.getHeight() / 2.0f, 150L);
                }
                cameraChangeDispatcher.onCameraMoveStarted(3);
                MapView.this.compassView.isAnimating(true);
                MapView.this.compassView.postDelayed(MapView.this.compassView, 650L);
                if (MapplsLMSManager.isInitialised()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("event_view", "compass");
                        jSONObject.put("bearing", d);
                        MapplsLMSManager.getInstance().add("click", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        if (bundle == null || !bundle.getBoolean(MapplsConstants.STATE_HAS_SAVED_STATE)) {
            return;
        }
        this.savedInstanceState = bundle;
    }

    private void initialiseDrawingSurface(MapplsMapOptions mapplsMapOptions) {
        String localIdeographFontFamily = mapplsMapOptions.getLocalIdeographFontFamily();
        if (mapplsMapOptions.getTextureMode()) {
            TextureView textureView = new TextureView(getContext());
            this.mapRenderer = new TextureViewMapRenderer(getContext(), textureView, localIdeographFontFamily, mapplsMapOptions.getTranslucentTextureSurface()) { // from class: com.mappls.sdk.maps.MapView.6
                @Override // com.mappls.sdk.maps.renderer.textureview.TextureViewMapRenderer, com.mappls.sdk.maps.renderer.MapRenderer
                protected void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    if (MapView.this.isInitialized) {
                        MapView.this.onSurfaceCreated();
                    }
                    super.onSurfaceCreated(gl10, eGLConfig);
                    MapView.this.surfaceCreated = true;
                }
            };
            addView(textureView, 0);
            this.renderView = textureView;
        } else {
            MapplsGLSurfaceView mapplsGLSurfaceView = new MapplsGLSurfaceView(getContext());
            mapplsGLSurfaceView.setZOrderMediaOverlay(this.mapplsMapOptions.getRenderSurfaceOnTop());
            this.mapRenderer = new GLSurfaceViewMapRenderer(getContext(), mapplsGLSurfaceView, localIdeographFontFamily) { // from class: com.mappls.sdk.maps.MapView.7
                @Override // com.mappls.sdk.maps.renderer.glsurfaceview.GLSurfaceViewMapRenderer, com.mappls.sdk.maps.renderer.MapRenderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    if (MapView.this.isInitialized) {
                        MapView.this.onSurfaceCreated();
                    }
                    super.onSurfaceCreated(gl10, eGLConfig);
                    MapView.this.surfaceCreated = true;
                }
            };
            addView(mapplsGLSurfaceView, 0);
            this.renderView = mapplsGLSurfaceView;
        }
        this.nativeMapView = new NativeMapView(getContext(), getPixelRatio(), this.mapplsMapOptions.getCrossSourceCollisions(), this, this.mapChangeReceiver, this.mapRenderer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceCreated() {
        post(new Runnable() { // from class: com.mappls.sdk.maps.MapView.8
            @Override // java.lang.Runnable
            public void run() {
                if (MapView.this.destroyed || MapView.this.mapplsMap != null) {
                    return;
                }
                MapView.this.initialiseMap();
                MapView.this.mapplsMap.onStart();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.mapplsMap != null) {
            bundle.putBoolean(MapplsConstants.STATE_HAS_SAVED_STATE, true);
            this.mapplsMap.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        if (!this.isStarted) {
            ConnectivityReceiver.instance(getContext()).activate();
            FileSource.getInstance(getContext()).activate();
            this.isStarted = true;
        }
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.onStart();
        }
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onStart();
        }
    }

    public void onResume() {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onResume();
        }
    }

    public void onPause() {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onPause();
        }
    }

    public void onStop() {
        AttributionClickListener attributionClickListener = this.attributionClickListener;
        if (attributionClickListener != null) {
            attributionClickListener.onStop();
        }
        if (this.mapplsMap != null) {
            this.mapGestureDetector.cancelAnimators();
            this.mapplsMap.onStop();
        }
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onStop();
        }
        if (this.isStarted) {
            ConnectivityReceiver.instance(getContext()).deactivate();
            FileSource.getInstance(getContext()).deactivate();
            this.isStarted = false;
        }
    }

    public void onDestroy() {
        this.destroyed = true;
        if (MapplsLMSManager.isInitialised()) {
            MapplsLMSManager.getInstance().setMapCenter(0.0d, 0.0d);
        }
        this.retryHandler.removeCallbacksAndMessages(null);
        this.mapChangeReceiver.clear();
        this.mapCallback.onDestroy();
        this.initialRenderCallback.onDestroy();
        FloorControllerView floorControllerView = this.attributionsView;
        if (floorControllerView != null) {
            floorControllerView.onDestroy();
        }
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.resetAnimation();
        }
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.onDestroy();
        }
        NativeMap nativeMap = this.nativeMapView;
        if (nativeMap != null) {
            nativeMap.destroy();
            this.nativeMapView = null;
        }
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onDestroy();
        }
    }

    public void queueEvent(Runnable runnable) {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer == null) {
            throw new IllegalStateException("Calling MapView#queueEvent before mapRenderer is created.");
        }
        mapRenderer.queueEvent(runnable);
    }

    public void setMaximumFps(int i) {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.setMaximumFps(i);
            return;
        }
        throw new IllegalStateException("Calling MapView#setMaximumFps before mapRenderer is created.");
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public View getRenderView() {
        return this.renderView;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isGestureDetectorInitialized()) {
            return this.mapGestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onKeyLongPress(i, keyEvent) || super.onKeyLongPress(i, keyEvent);
        }
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onTrackballEvent(motionEvent) || super.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isGestureDetectorInitialized()) {
            return this.mapGestureDetector.onGenericMotionEvent(motionEvent) || super.onGenericMotionEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onLowMemory() {
        NativeMap nativeMap = this.nativeMapView;
        if (nativeMap == null || this.mapplsMap == null || this.destroyed) {
            return;
        }
        nativeMap.onLowMemory();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        NativeMap nativeMap;
        if (isInEditMode() || (nativeMap = this.nativeMapView) == null) {
            return;
        }
        nativeMap.resizeView(i, i2);
    }

    public float getPixelRatio() {
        float pixelRatio = this.mapplsMapOptions.getPixelRatio();
        return pixelRatio == 0.0f ? getResources().getDisplayMetrics().density : pixelRatio;
    }

    @Override // com.mappls.sdk.maps.NativeMapView.ViewCallback
    public Bitmap getViewContent() {
        return BitmapUtils.createBitmapFromView(this);
    }

    public void addOnCameraWillChangeListener(OnCameraWillChangeListener onCameraWillChangeListener) {
        this.mapChangeReceiver.addOnCameraWillChangeListener(onCameraWillChangeListener);
    }

    public void removeOnCameraWillChangeListener(OnCameraWillChangeListener onCameraWillChangeListener) {
        this.mapChangeReceiver.removeOnCameraWillChangeListener(onCameraWillChangeListener);
    }

    public void addOnCameraIsChangingListener(OnCameraIsChangingListener onCameraIsChangingListener) {
        this.mapChangeReceiver.addOnCameraIsChangingListener(onCameraIsChangingListener);
    }

    public void removeOnCameraIsChangingListener(OnCameraIsChangingListener onCameraIsChangingListener) {
        this.mapChangeReceiver.removeOnCameraIsChangingListener(onCameraIsChangingListener);
    }

    public void addOnCameraDidChangeListener(OnCameraDidChangeListener onCameraDidChangeListener) {
        this.mapChangeReceiver.addOnCameraDidChangeListener(onCameraDidChangeListener);
    }

    public void removeOnCameraDidChangeListener(OnCameraDidChangeListener onCameraDidChangeListener) {
        this.mapChangeReceiver.removeOnCameraDidChangeListener(onCameraDidChangeListener);
    }

    public void addOnWillStartLoadingMapListener(OnWillStartLoadingMapListener onWillStartLoadingMapListener) {
        this.mapChangeReceiver.addOnWillStartLoadingMapListener(onWillStartLoadingMapListener);
    }

    public void removeOnWillStartLoadingMapListener(OnWillStartLoadingMapListener onWillStartLoadingMapListener) {
        this.mapChangeReceiver.removeOnWillStartLoadingMapListener(onWillStartLoadingMapListener);
    }

    public void addOnDidFinishLoadingMapListener(OnDidFinishLoadingMapListener onDidFinishLoadingMapListener) {
        this.mapChangeReceiver.addOnDidFinishLoadingMapListener(onDidFinishLoadingMapListener);
    }

    public void removeOnDidFinishLoadingMapListener(OnDidFinishLoadingMapListener onDidFinishLoadingMapListener) {
        this.mapChangeReceiver.removeOnDidFinishLoadingMapListener(onDidFinishLoadingMapListener);
    }

    public void addOnDidFailLoadingMapListener(OnDidFailLoadingMapListener onDidFailLoadingMapListener) {
        this.mapChangeReceiver.addOnDidFailLoadingMapListener(onDidFailLoadingMapListener);
    }

    public void removeOnDidFailLoadingMapListener(OnDidFailLoadingMapListener onDidFailLoadingMapListener) {
        this.mapChangeReceiver.removeOnDidFailLoadingMapListener(onDidFailLoadingMapListener);
    }

    public void addOnWillStartRenderingFrameListener(OnWillStartRenderingFrameListener onWillStartRenderingFrameListener) {
        this.mapChangeReceiver.addOnWillStartRenderingFrameListener(onWillStartRenderingFrameListener);
    }

    public void removeOnWillStartRenderingFrameListener(OnWillStartRenderingFrameListener onWillStartRenderingFrameListener) {
        this.mapChangeReceiver.removeOnWillStartRenderingFrameListener(onWillStartRenderingFrameListener);
    }

    public void addOnDidFinishRenderingFrameListener(OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener) {
        this.mapChangeReceiver.addOnDidFinishRenderingFrameListener(onDidFinishRenderingFrameListener);
    }

    public void removeOnDidFinishRenderingFrameListener(OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener) {
        this.mapChangeReceiver.removeOnDidFinishRenderingFrameListener(onDidFinishRenderingFrameListener);
    }

    public void addOnWillStartRenderingMapListener(OnWillStartRenderingMapListener onWillStartRenderingMapListener) {
        this.mapChangeReceiver.addOnWillStartRenderingMapListener(onWillStartRenderingMapListener);
    }

    public void removeOnWillStartRenderingMapListener(OnWillStartRenderingMapListener onWillStartRenderingMapListener) {
        this.mapChangeReceiver.removeOnWillStartRenderingMapListener(onWillStartRenderingMapListener);
    }

    public void addOnDidFinishRenderingMapListener(OnDidFinishRenderingMapListener onDidFinishRenderingMapListener) {
        this.mapChangeReceiver.addOnDidFinishRenderingMapListener(onDidFinishRenderingMapListener);
    }

    public void removeOnDidFinishRenderingMapListener(OnDidFinishRenderingMapListener onDidFinishRenderingMapListener) {
        this.mapChangeReceiver.removeOnDidFinishRenderingMapListener(onDidFinishRenderingMapListener);
    }

    public void addOnDidBecomeIdleListener(OnDidBecomeIdleListener onDidBecomeIdleListener) {
        this.mapChangeReceiver.addOnDidBecomeIdleListener(onDidBecomeIdleListener);
    }

    public void removeOnDidBecomeIdleListener(OnDidBecomeIdleListener onDidBecomeIdleListener) {
        this.mapChangeReceiver.removeOnDidBecomeIdleListener(onDidBecomeIdleListener);
    }

    public void addOnDidFinishLoadingStyleListener(OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener) {
        this.mapChangeReceiver.addOnDidFinishLoadingStyleListener(onDidFinishLoadingStyleListener);
    }

    public void removeOnDidFinishLoadingStyleListener(OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener) {
        this.mapChangeReceiver.removeOnDidFinishLoadingStyleListener(onDidFinishLoadingStyleListener);
    }

    public void addOnSourceChangedListener(OnSourceChangedListener onSourceChangedListener) {
        this.mapChangeReceiver.addOnSourceChangedListener(onSourceChangedListener);
    }

    public void removeOnSourceChangedListener(OnSourceChangedListener onSourceChangedListener) {
        this.mapChangeReceiver.removeOnSourceChangedListener(onSourceChangedListener);
    }

    public void addOnStyleImageMissingListener(OnStyleImageMissingListener onStyleImageMissingListener) {
        this.mapChangeReceiver.addOnStyleImageMissingListener(onStyleImageMissingListener);
    }

    public void removeOnStyleImageMissingListener(OnStyleImageMissingListener onStyleImageMissingListener) {
        this.mapChangeReceiver.removeOnStyleImageMissingListener(onStyleImageMissingListener);
    }

    public void addOnCanRemoveUnusedStyleImageListener(OnCanRemoveUnusedStyleImageListener onCanRemoveUnusedStyleImageListener) {
        this.mapChangeReceiver.addOnCanRemoveUnusedStyleImageListener(onCanRemoveUnusedStyleImageListener);
    }

    public void removeOnCanRemoveUnusedStyleImageListener(OnCanRemoveUnusedStyleImageListener onCanRemoveUnusedStyleImageListener) {
        this.mapChangeReceiver.removeOnCanRemoveUnusedStyleImageListener(onCanRemoveUnusedStyleImageListener);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap == null && this.authenticationError == null) {
            this.mapCallback.addOnMapReadyCallback(onMapReadyCallback);
        } else if (mapplsMap != null) {
            onMapReadyCallback.onMapReady(mapplsMap);
        } else {
            onMapReadyCallback.onMapError(this.authenticationError.errorCode, this.authenticationError.errorMessage);
        }
    }

    public void getMapReinit(OnMapReinitCallback onMapReinitCallback) {
        this.mapCallback.addOnMapReinitCallback(onMapReinitCallback);
    }

    private boolean isGestureDetectorInitialized() {
        return this.mapGestureDetector != null;
    }

    private boolean isKeyDetectorInitialized() {
        return this.mapKeyListener != null;
    }

    MapplsMap getMapplsMap() {
        return this.mapplsMap;
    }

    void setMapplsMap(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
    }

    void startSession(final Context context, final MapplsMapOptions mapplsMapOptions) {
        if (!this.isAct) {
            Mappls.getSessionHelper().startGlobalSession(new InitializationListener() { // from class: com.mappls.sdk.maps.MapView.9
                @Override // com.mappls.sdk.maps.session.InitializationListener
                public void onSuccess() {
                    MapView.this.isAct = true;
                    MapView.this.retryCount = 0;
                    if (MapplsLMSManager.isInitialised()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("session_type", "global");
                            MapplsLMSManager.getInstance().add("session-api-success", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    MapView.this.initialize(context, mapplsMapOptions);
                }

                @Override // com.mappls.sdk.maps.session.InitializationListener
                public void onFailure(AuthenticationError authenticationError, Exception exc) {
                    String str;
                    int i;
                    String str2;
                    int i2;
                    MapView.this.isAct = false;
                    if (authenticationError.errorCode == 409) {
                        MapView.this.retryCount = 0;
                        Mappls.getSessionHelper().deleteNavigationSession(new IStopSession() { // from class: com.mappls.sdk.maps.MapView.9.2
                            @Override // com.mappls.sdk.maps.session.IStopSession
                            public void onSuccess() {
                                MapView.this.startSession(context, mapplsMapOptions);
                            }

                            @Override // com.mappls.sdk.maps.session.IStopSession
                            public void onFailure() {
                                MapView.this.onMapError(5, "Something went wrong - 104");
                            }
                        });
                        return;
                    }
                    try {
                        if (authenticationError.errorCode >= 200 && authenticationError.errorCode < 500) {
                            MapView.this.retryCount = 0;
                            String str3 = authenticationError.errorMessage + " - 103";
                            int i3 = authenticationError.errorCode;
                            MapView.this.onMapError(authenticationError.errorCode, authenticationError.errorMessage + " - 103");
                            if (!MapplsLMSManager.isInitialised()) {
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("error_code", i3);
                            jSONObject.put("error_message", str3);
                            MapplsLMSManager.getInstance().add("session-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                        } else if (!MapplsMapConfiguration.getInstance().isMapReinitEnable() || MapView.this.retryCount > 2) {
                            MapView.this.retryCount = 0;
                            if (authenticationError.errorCode == 101 || authenticationError.errorCode == 102 || authenticationError.errorCode == 103 || authenticationError.errorCode == 7 || authenticationError.errorCode == 8 || authenticationError.errorCode == 9) {
                                str = authenticationError.errorMessage;
                                i = authenticationError.errorCode;
                            } else {
                                str = "Something went wrong - 103";
                                i = 5;
                            }
                            MapView.this.onMapError(i, str);
                            if (!MapplsLMSManager.isInitialised()) {
                                return;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("error_code", i);
                            jSONObject2.put("error_message", str);
                            MapplsLMSManager.getInstance().add("session-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject2);
                        } else {
                            MapView.access$1108(MapView.this);
                            if (authenticationError.errorCode == 101 || authenticationError.errorCode == 102 || authenticationError.errorCode == 103 || authenticationError.errorCode == 7 || authenticationError.errorCode == 8 || authenticationError.errorCode == 9) {
                                str2 = authenticationError.errorMessage;
                                i2 = authenticationError.errorCode;
                            } else {
                                str2 = "Something went wrong - 103";
                                i2 = 5;
                            }
                            MapView mapView = MapView.this;
                            mapView.onMapReinit(((long) mapView.retryCount) * 300, i2, str2);
                            MapView.this.retryHandler.postDelayed(new Runnable() { // from class: com.mappls.sdk.maps.MapView.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MapView.this.startSession(context, mapplsMapOptions);
                                }
                            }, ((long) MapView.this.retryCount) * 300);
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
        } else {
            this.retryCount = 0;
            initialize(context, mapplsMapOptions);
        }
    }

    void initialiseStyles(final Context context, final MapplsMapOptions mapplsMapOptions) {
        this.mapplsMapOptions = mapplsMapOptions;
        if (MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
            setWillNotDraw(false);
            initialiseDrawingSurface(mapplsMapOptions);
        }
        setForeground(new ColorDrawable(mapplsMapOptions.getForegroundLoadColor()));
        Mappls.getStyleHelper().initialiseStyles(new IStyleListener() { // from class: com.mappls.sdk.maps.MapView.10
            @Override // com.mappls.sdk.maps.style.IStyleListener
            public void onSuccess() {
                MapView.this.retryCount = 0;
                if (!ConnectivityReceiver.instance(context).isOffline()) {
                    MapView.this.initialiseVectorKey(context, mapplsMapOptions);
                } else {
                    MapView.this.initialize(context, mapplsMapOptions);
                }
            }

            @Override // com.mappls.sdk.maps.style.IStyleListener
            public void onFailure(int i, String str) {
                if ((i >= 200 && i <= 499) || MapView.this.retryCount > 2 || !MapplsMapConfiguration.getInstance().isMapReinitEnable()) {
                    MapView.this.retryCount = 0;
                    if (MapplsLMSManager.isInitialised()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("error_code", i);
                            jSONObject.put("error_message", str);
                            MapplsLMSManager.getInstance().add("style-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    MapView.this.onMapError(i, str);
                    return;
                }
                MapView.access$1108(MapView.this);
                MapView mapView = MapView.this;
                mapView.onMapReinit(((long) mapView.retryCount) * 300, i, str);
                MapView.this.retryHandler.postDelayed(new Runnable() { // from class: com.mappls.sdk.maps.MapView.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MapView.this.initialiseStyles(context, mapplsMapOptions);
                    }
                }, ((long) MapView.this.retryCount) * 300);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseVectorKey(final Context context, final MapplsMapOptions mapplsMapOptions) {
        if (MapplsMapConfiguration.getInstance().isUsingRasterStyle() || MapplsMapManager.getInstance().getRawPublicKey() != null) {
            startSession(context, mapplsMapOptions);
        } else {
            MapplsVectorKey.builder().build().enqueueCall(new Callback<PublicKeyToken>() { // from class: com.mappls.sdk.maps.MapView.11
                @Override // retrofit2.Callback
                public void onResponse(Call<PublicKeyToken> call, Response<PublicKeyToken> response) {
                    if (response.code() == 200 && response.body() != null) {
                        MapView.this.retryCount = 0;
                        MapplsMapManager.getInstance().setRawPublicKey(response.body().getPublicKey());
                        MapplsMapManager.getInstance().setKeyExpirationTime(response.body().getExpiresOn());
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("key_expiry", response.body().getExpiresOn());
                                MapplsLMSManager.getInstance().add("vector-key-api-success", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        MapView.this.startSession(context, mapplsMapOptions);
                        return;
                    }
                    String strMessage = "Something went wrong - 102";
                    try {
                        if (response.code() >= 200 && response.code() <= 499) {
                            MapView.this.retryCount = 0;
                            if (response.headers().get(StackTraceHelper.MESSAGE_KEY) != null) {
                                strMessage = response.headers().get(StackTraceHelper.MESSAGE_KEY) + " - 102";
                            }
                            MapView.this.onMapError(response.code(), strMessage);
                            if (!MapplsLMSManager.isInitialised()) {
                                return;
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("error_code", response.code());
                            jSONObject2.put("error_message", strMessage);
                            MapplsLMSManager.getInstance().add("vector-key-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject2);
                        } else if (!MapplsMapConfiguration.getInstance().isMapReinitEnable() || MapView.this.retryCount > 2) {
                            MapView.this.retryCount = 0;
                            if (response.code() == 7 || response.code() == 8 || response.code() == 9 || response.code() == 101 || response.code() == 102 || response.code() == 103) {
                                strMessage = response.message();
                            } else if (response.headers().get(StackTraceHelper.MESSAGE_KEY) != null) {
                                strMessage = response.headers().get(StackTraceHelper.MESSAGE_KEY) + " - 102";
                            }
                            MapView.this.onMapError(response.code(), strMessage);
                            if (!MapplsLMSManager.isInitialised()) {
                                return;
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("error_code", response.code());
                            jSONObject3.put("error_message", strMessage);
                            MapplsLMSManager.getInstance().add("vector-key-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject3);
                        } else {
                            if (response.code() == 7 || response.code() == 8 || response.code() == 9 || response.code() == 101 || response.code() == 102 || response.code() == 103) {
                                strMessage = response.message();
                            } else if (response.headers().get(StackTraceHelper.MESSAGE_KEY) != null) {
                                strMessage = response.headers().get(StackTraceHelper.MESSAGE_KEY) + " - 102";
                            }
                            MapView.access$1108(MapView.this);
                            MapView mapView = MapView.this;
                            mapView.onMapReinit(((long) mapView.retryCount) * 300, response.code(), strMessage);
                            MapView.this.retryHandler.postDelayed(new Runnable() { // from class: com.mappls.sdk.maps.MapView.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MapView.this.initialiseVectorKey(context, mapplsMapOptions);
                                }
                            }, ((long) MapView.this.retryCount) * 300);
                        }
                    } catch (JSONException unused2) {
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<PublicKeyToken> call, Throwable th) {
                    if (!MapplsMapConfiguration.getInstance().isMapReinitEnable() || MapView.this.retryCount > 2) {
                        MapView.this.retryCount = 0;
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("error_code", 5);
                                jSONObject.put("error_message", th.getMessage());
                                MapplsLMSManager.getInstance().add("vector-key-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        MapView.this.onMapError(5, "Something went wrong - 102");
                        return;
                    }
                    MapView.access$1108(MapView.this);
                    MapView mapView = MapView.this;
                    mapView.onMapReinit(((long) mapView.retryCount) * 300, 5, "Something went wrong - 102");
                    MapView.this.retryHandler.postDelayed(new Runnable() { // from class: com.mappls.sdk.maps.MapView.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MapView.this.initialiseVectorKey(context, mapplsMapOptions);
                        }
                    }, ((long) MapView.this.retryCount) * 300);
                }
            });
        }
    }

    public void setIsSatellite(boolean z) {
        this.logoView.setImageResource(z ? R.drawable.mappls_maps_logo_icon : R.drawable.mappls_maps_bhuwan_logo_icon);
    }

    public CompassView getCompassView() {
        return this.compassView;
    }

    private void initAuthenticationView(final Context context, final MapplsMapOptions mapplsMapOptions) {
        if (isInEditMode()) {
            return;
        }
        setForeground(new ColorDrawable(mapplsMapOptions.getForegroundLoadColor()));
        this.mapplsMapOptions = mapplsMapOptions;
        setContentDescription(context.getString(R.string.mappls_maps_mapActionDescription));
        setWillNotDraw(false);
        initialiseDrawingSurface(mapplsMapOptions);
        final View viewInitialiseSplashView = initialiseSplashView();
        checkForPublicKey(viewInitialiseSplashView, context, mapplsMapOptions);
        this.retryButton.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.maps.MapView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MapplsLMSManager.isInitialised()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("event_view", "retry");
                        if (MapView.this.authenticationError != null) {
                            jSONObject.put("error_code", MapView.this.authenticationError.errorCode);
                            jSONObject.put("error_message", MapView.this.authenticationError.errorMessage);
                        }
                        MapplsLMSManager.getInstance().add("click", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                MapView.this.retryCount = 0;
                MapView.this.checkForPublicKey(viewInitialiseSplashView, context, mapplsMapOptions);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMapReinit(long j, int i, String str) {
        this.mapCallback.onMapReinit(j, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMapError(int i, String str) {
        this.authenticationError = new AuthenticationError(i, str);
        setForeground(null);
        this.mapCallback.onMapError(i, str);
        if (MapplsMapConfiguration.getInstance().isUsingRasterStyle()) {
            return;
        }
        this.loadingMapIssueLayout.setVisibility(0);
        this.errorTextView.setText(str);
        this.loadingMapTextView.setVisibility(8);
        this.retryButton.setVisibility((i == 1 || i == 2 || i == 3 || i == 4) ? false : true ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForPublicKey(View view, Context context, MapplsMapOptions mapplsMapOptions) {
        this.authenticationError = null;
        try {
            if (TextUtils.isEmpty(MapplsAccountManager.getInstance().getMapSDKKey())) {
                onMapError(1, "Map SDK Key is missing.\n\nPlease set it in MapplsAccountManager");
                return;
            }
            if (TextUtils.isEmpty(MapplsAccountManager.getInstance().getRestAPIKey())) {
                onMapError(2, "Rest API Key is missing.\n\nPlease set it in MapplsAccountManager");
                return;
            }
            if (TextUtils.isEmpty(MapplsAccountManager.getInstance().getAtlasClientId())) {
                onMapError(3, "Atlas client ID is missing.\n\nPlease set it in MapplsAccountManager");
                return;
            }
            if (TextUtils.isEmpty(MapplsAccountManager.getInstance().getAtlasClientSecret())) {
                onMapError(4, "Atlas client Secret is missing.\n\nPlease set it in MapplsAccountManager");
                return;
            }
            this.loadingMapIssueLayout.setVisibility(4);
            this.loadingMapTextView.setVisibility(0);
            setForeground(null);
            initialiseStyles(context, mapplsMapOptions);
        } catch (Exception e) {
            Timber.e(e);
            onMapError(5, "Something went wrong.Please try again.");
        }
    }

    public void loadMap() {
        Button button = this.retryButton;
        if (button != null) {
            button.performClick();
        }
    }

    private static class AttributionClickListener implements View.OnClickListener {
        private final AttributionDialogManager defaultDialogManager;
        private UiSettings uiSettings;

        private AttributionClickListener(Context context, MapplsMap mapplsMap) {
            this.defaultDialogManager = new AttributionDialogManager(context, mapplsMap);
            this.uiSettings = mapplsMap.getUiSettings();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            getDialogManager().onClick(view);
            if (MapplsLMSManager.isInitialised()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("event_view", "attribution");
                    MapplsLMSManager.getInstance().add("click", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                } catch (JSONException unused) {
                }
            }
        }

        public void onStop() {
            getDialogManager().onStop();
        }

        private AttributionDialogManager getDialogManager() {
            if (this.uiSettings.getAttributionDialogManager() != null) {
                return this.uiSettings.getAttributionDialogManager();
            }
            return this.defaultDialogManager;
        }
    }

    private class FocalPointInvalidator implements FocalPointChangeListener {
        private final List<FocalPointChangeListener> focalPointChangeListeners;

        private FocalPointInvalidator() {
            this.focalPointChangeListeners = new ArrayList();
        }

        void addListener(FocalPointChangeListener focalPointChangeListener) {
            this.focalPointChangeListeners.add(focalPointChangeListener);
        }

        @Override // com.mappls.sdk.maps.FocalPointChangeListener
        public void onFocalPointChanged(PointF pointF) {
            MapView.this.mapGestureDetector.setFocalPoint(pointF);
            Iterator<FocalPointChangeListener> it2 = this.focalPointChangeListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onFocalPointChanged(pointF);
            }
        }
    }

    private class InitialRenderCallback implements OnDidFinishRenderingFrameListener {
        private int renderCount;

        InitialRenderCallback() {
            MapView.this.addOnDidFinishRenderingFrameListener(this);
        }

        @Override // com.mappls.sdk.maps.MapView.OnDidFinishRenderingFrameListener
        public void onDidFinishRenderingFrame(boolean z) {
            if (MapView.this.mapplsMap == null || MapView.this.mapplsMap.getStyle() == null || !MapView.this.mapplsMap.getStyle().isFullyLoaded()) {
                return;
            }
            int i = this.renderCount + 1;
            this.renderCount = i;
            if (i == 3) {
                MapView.this.setForeground(null);
                MapView.this.removeOnDidFinishRenderingFrameListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDestroy() {
            MapView.this.removeOnDidFinishRenderingFrameListener(this);
        }
    }

    private class GesturesManagerInteractionListener implements MapplsMap.OnGesturesManagerInteractionListener {
        private GesturesManagerInteractionListener() {
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddMapClickListener(MapplsMap.OnMapClickListener onMapClickListener) {
            MapView.this.mapGestureDetector.addOnMapClickListener(onMapClickListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveMapClickListener(MapplsMap.OnMapClickListener onMapClickListener) {
            MapView.this.mapGestureDetector.removeOnMapClickListener(onMapClickListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddMapLongClickListener(MapplsMap.OnMapLongClickListener onMapLongClickListener) {
            MapView.this.mapGestureDetector.addOnMapLongClickListener(onMapLongClickListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveMapLongClickListener(MapplsMap.OnMapLongClickListener onMapLongClickListener) {
            MapView.this.mapGestureDetector.removeOnMapLongClickListener(onMapLongClickListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddFlingListener(MapplsMap.OnFlingListener onFlingListener) {
            MapView.this.mapGestureDetector.addOnFlingListener(onFlingListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveFlingListener(MapplsMap.OnFlingListener onFlingListener) {
            MapView.this.mapGestureDetector.removeOnFlingListener(onFlingListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddMoveListener(MapplsMap.OnMoveListener onMoveListener) {
            MapView.this.mapGestureDetector.addOnMoveListener(onMoveListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveMoveListener(MapplsMap.OnMoveListener onMoveListener) {
            MapView.this.mapGestureDetector.removeOnMoveListener(onMoveListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddRotateListener(MapplsMap.OnRotateListener onRotateListener) {
            MapView.this.mapGestureDetector.addOnRotateListener(onRotateListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveRotateListener(MapplsMap.OnRotateListener onRotateListener) {
            MapView.this.mapGestureDetector.removeOnRotateListener(onRotateListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddScaleListener(MapplsMap.OnScaleListener onScaleListener) {
            MapView.this.mapGestureDetector.addOnScaleListener(onScaleListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveScaleListener(MapplsMap.OnScaleListener onScaleListener) {
            MapView.this.mapGestureDetector.removeOnScaleListener(onScaleListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onAddShoveListener(MapplsMap.OnShoveListener onShoveListener) {
            MapView.this.mapGestureDetector.addShoveListener(onShoveListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void onRemoveShoveListener(MapplsMap.OnShoveListener onShoveListener) {
            MapView.this.mapGestureDetector.removeShoveListener(onShoveListener);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public AndroidGesturesManager getGesturesManager() {
            return MapView.this.mapGestureDetector.getGesturesManager();
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void setGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z, boolean z2) {
            MapView.this.mapGestureDetector.setGesturesManager(MapView.this.getContext(), androidGesturesManager, z, z2);
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnGesturesManagerInteractionListener
        public void cancelAllVelocityAnimations() {
            MapView.this.mapGestureDetector.cancelAnimators();
        }
    }

    private class MapCallback implements OnDidFinishLoadingStyleListener, OnDidFinishRenderingFrameListener, OnDidFinishLoadingMapListener, OnCameraIsChangingListener, OnCameraDidChangeListener, OnDidFailLoadingMapListener {
        private final List<OnMapReadyCallback> onMapReadyCallbackList = new ArrayList();
        private final List<OnMapReinitCallback> onMapReinitCallbacks = new ArrayList();

        MapCallback() {
            MapView.this.addOnDidFinishLoadingStyleListener(this);
            MapView.this.addOnDidFinishRenderingFrameListener(this);
            MapView.this.addOnDidFinishLoadingMapListener(this);
            MapView.this.addOnCameraIsChangingListener(this);
            MapView.this.addOnCameraDidChangeListener(this);
            MapView.this.addOnDidFailLoadingMapListener(this);
        }

        void initialised() {
            MapView.this.mapplsMap.onPreMapReady();
            onMapReady();
            MapView.this.mapplsMap.onPostMapReady();
        }

        private void onMapReady() {
            if (this.onMapReadyCallbackList.size() > 0) {
                Iterator<OnMapReadyCallback> it2 = this.onMapReadyCallbackList.iterator();
                while (it2.hasNext()) {
                    OnMapReadyCallback next = it2.next();
                    if (next != null) {
                        next.onMapReady(MapView.this.mapplsMap);
                    }
                    it2.remove();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onMapError(int i, String str) {
            Timber.e(i + "----" + str, new Object[0]);
            if (this.onMapReadyCallbackList.size() > 0) {
                Iterator<OnMapReadyCallback> it2 = this.onMapReadyCallbackList.iterator();
                while (it2.hasNext()) {
                    it2.next().onMapError(i, str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onMapReinit(long j, int i, String str) {
            if (this.onMapReinitCallbacks.size() > 0) {
                Iterator<OnMapReinitCallback> it2 = this.onMapReinitCallbacks.iterator();
                while (it2.hasNext()) {
                    it2.next().onMapReinit(j, i, str);
                }
            }
        }

        void addOnMapReadyCallback(OnMapReadyCallback onMapReadyCallback) {
            this.onMapReadyCallbackList.add(onMapReadyCallback);
        }

        void addOnMapReinitCallback(OnMapReinitCallback onMapReinitCallback) {
            this.onMapReinitCallbacks.add(onMapReinitCallback);
        }

        void onDestroy() {
            this.onMapReadyCallbackList.clear();
            this.onMapReinitCallbacks.clear();
            MapView.this.removeOnDidFinishLoadingStyleListener(this);
            MapView.this.removeOnDidFinishRenderingFrameListener(this);
            MapView.this.removeOnDidFinishLoadingMapListener(this);
            MapView.this.removeOnCameraIsChangingListener(this);
            MapView.this.removeOnCameraDidChangeListener(this);
            MapView.this.removeOnDidFailLoadingMapListener(this);
        }

        @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
        public void onDidFinishLoadingStyle() {
            if (MapView.this.mapplsMap != null) {
                MapView.this.mapplsMap.onFinishLoadingStyle();
            }
        }

        @Override // com.mappls.sdk.maps.MapView.OnDidFailLoadingMapListener
        public void onDidFailLoadingMap(String str) {
            if (MapView.this.mapplsMap != null) {
                MapView.this.mapplsMap.onFailLoadingStyle();
                if (ConnectivityReceiver.instance(MapView.this.getContext()).isOffline()) {
                    MapView.this.mapplsMap.setStyle(new Style.Builder().fromJson("{\"version\": 8,\"sources\": {},\"layers\": []}"));
                }
            }
        }

        @Override // com.mappls.sdk.maps.MapView.OnDidFinishRenderingFrameListener
        public void onDidFinishRenderingFrame(boolean z) {
            if (MapView.this.mapplsMap != null) {
                if (MapplsLMSManager.isInitialised() && MapView.this.mapplsMap.getCameraPosition() != null) {
                    LatLng latLng = MapView.this.mapplsMap.getCameraPosition().target;
                    MapplsLMSManager.getInstance().setMapCenter(latLng.getLatitude(), latLng.getLongitude());
                }
                MapView.this.mapplsMap.onUpdateFullyRendered();
            }
        }

        @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingMapListener
        public void onDidFinishLoadingMap() {
            if (MapView.this.mapplsMap != null) {
                MapView.this.mapplsMap.onUpdateRegionChange();
            }
        }

        @Override // com.mappls.sdk.maps.MapView.OnCameraIsChangingListener
        public void onCameraIsChanging() {
            if (MapView.this.mapplsMap != null) {
                MapView.this.mapplsMap.onUpdateRegionChange();
            }
        }

        @Override // com.mappls.sdk.maps.MapView.OnCameraDidChangeListener
        public void onCameraDidChange(boolean z) {
            if (MapView.this.mapplsMap != null) {
                MapView.this.mapplsMap.onUpdateRegionChange();
            }
        }
    }
}
