package com.bajajconnect.wifi.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.Screens;
import com.bajajconnect.wifi.StreamingImageHandler;
import com.bajajconnect.wifi.TouchPoint;
import com.bajajconnect.wifi.UdpServerService;
import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.iface.INavigationListener;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TftTurnByTurnScreen implements INavigationListener {
    Bitmap bitmap;
    Canvas canvas;
    private final Context context;
    private Handler handler;
    private TouchPoint lastTouchPoint1;
    private TouchPoint lastTouchPoint2;
    private LinearLayout linearLayout;
    ScaleGestureDetector mScaleDetector;
    private ImageView tftCloseIcon;
    private ImageView tftMinusIcon;
    private ImageView tftPlusIcon;
    private final View view;
    private boolean isSecondFingerDown = false;
    private boolean iconHidden = false;
    private double preDistance = 0.0d;
    private int touchMoveCounter = 2;

    public enum TouchEventType {
        NULL,
        DOWN,
        UP,
        MOVE
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onETARefreshed(String str) {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onEvent(NavEvent navEvent) {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationCancelled() {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationFinished() {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationStarted() {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNewRoute(String str) {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onReRoutingRequested() {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onRouteProgress(AdviseInfo adviseInfo) {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onWayPointReached(WayPoint wayPoint) {
    }

    public TftTurnByTurnScreen(Context context) {
        this.context = context.getApplicationContext();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tft_tbt_layout, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 0, 800, StreamingImageHandler.TFT_HEIGHT);
        this.handler = new Handler(Looper.getMainLooper());
        initVariables();
        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.1
            @Override // java.lang.Runnable
            public void run() {
                TftTurnByTurnScreen.this.initGestureDetector();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGestureDetector() {
        this.mScaleDetector = new ScaleGestureDetector(this.context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                scaleGestureDetector.getScaleFactor();
                return super.onScaleBegin(scaleGestureDetector);
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (scaleFactor > 1.0f) {
                    if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                        NavApplication.customProjection.routeInfoPresentation.zoomInTFT();
                        StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
                    } else {
                        NavApplication.customProjection.routeInfoPresentation.zoomInTFT();
                        StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
                    }
                } else if (scaleFactor < 1.0f) {
                    if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                        NavApplication.customProjection.routeInfoPresentation.zoomOutTft();
                        StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
                    } else {
                        NavApplication.customProjection.routeInfoPresentation.zoomOutTft();
                        StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
                    }
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                super.onScaleEnd(scaleGestureDetector);
                Log.e("TftTurn", "onscale end");
            }
        });
    }

    public View getView() {
        return this.view;
    }

    private void initVariables() {
        LinearLayout linearLayout = (LinearLayout) this.view.findViewById(R.id.recenter_linear_layout);
        this.linearLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.tftPlusIcon = (ImageView) this.view.findViewById(R.id.tft_zoom_in);
        this.tftMinusIcon = (ImageView) this.view.findViewById(R.id.tft_zoom_out);
        this.tftCloseIcon = (ImageView) this.view.findViewById(R.id.tft_closeNav);
        this.handler = new Handler(Looper.getMainLooper());
    }

    public Bitmap drawView(Bitmap bitmap) {
        if (!this.iconHidden) {
            hideButtons();
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            this.bitmap = Bitmap.createBitmap(800, StreamingImageHandler.TFT_HEIGHT, Bitmap.Config.ARGB_8888);
            this.canvas = new Canvas(this.bitmap);
        } else {
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        if (MirroringGlobarVar.isSearchProcessing) {
            StreamingImageHandler.navigationSearchScreen.progressView.getView().draw(this.canvas);
        } else {
            if (bitmap != null) {
                if (bitmap.getWidth() > 800 || bitmap.getHeight() > 480) {
                    this.canvas.drawBitmap(bitmap, new Rect(0, 0, 800, StreamingImageHandler.TFT_HEIGHT), new Rect(0, 0, 800, StreamingImageHandler.TFT_HEIGHT), (Paint) null);
                } else {
                    this.canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                }
            }
            View view = this.view;
            if (view != null) {
                view.draw(this.canvas);
            }
        }
        return this.bitmap;
    }

    private void hideButtons() {
        this.iconHidden = true;
        ImageView imageView = this.tftMinusIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.tftPlusIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.tftCloseIcon;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        setRecenterBtnVisibility(false);
    }

    public void showButtons() {
        this.iconHidden = true;
        ImageView imageView = this.tftMinusIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.tftPlusIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.tftCloseIcon;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        setRecenterBtnVisibility(true);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onAlternateRoutesUpdate(List<AlternateRoute> list) {
        super.onAlternateRoutesUpdate(list);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onBetterRouteAvailable(List<DirectionsRoute> list) {
        super.onBetterRouteAvailable(list);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onRerouteFailed(int i, String str) {
        super.onRerouteFailed(i, str);
    }

    public void setRecenterBtnVisibility(boolean z) {
        this.linearLayout.setVisibility(z ? 0 : 8);
    }

    public void stopNavigationMain() {
        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopNavigationMain$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopNavigationMain$0() {
        try {
            if (MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION) {
                Log.e("NAvigation", "stop fragment nav");
                NavApplication.customProjection.stopNavigationCombined();
            } else {
                if (GlobalVar.isGoogleNavigation) {
                    NavApplication.customProjection.routeInfoPresentation.stopNavigation();
                }
                NavApplication.customProjection.stopPresentation();
                NavApplication.streamingHandler.udpServerService.startScreenCaptures();
            }
            MirroringGlobarVar.currentScreen = Screens.SEARCH_SCREEN;
            NavApplication.streamingHandler.udpServerService.onScreenChange();
            UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.3
                @Override // java.lang.Runnable
                public void run() {
                    MirroringGlobarVar.isSearchProcessing = false;
                    NavApplication.streamingHandler.udpServerService.onScreenChange();
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopNavigation() {
        MirroringGlobarVar.isSearchProcessing = true;
        if (MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION) {
            NavApplication.customProjection.stopNavigationCombined();
        } else {
            NavApplication.customProjection.myNavigationPresentation.onBackPressed();
            NavApplication.customProjection.stopPresentation();
            MirroringGlobarVar.currentScreen = Screens.SEARCH_SCREEN;
            NavApplication.streamingHandler.udpServerService.onScreenChange();
            NavApplication.streamingHandler.udpServerService.startScreenCaptures();
        }
        MirroringGlobarVar.isKeyboardOpen = false;
        UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.4
            @Override // java.lang.Runnable
            public void run() {
                MirroringGlobarVar.isSearchProcessing = false;
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    public void recenterMap() {
        this.handler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                TftTurnByTurnScreen.lambda$recenterMap$1();
            }
        }, 100L);
    }

    static /* synthetic */ void lambda$recenterMap$1() {
        try {
            if (GlobalVar.isGoogleNavigation) {
                NavApplication.customProjection.routeInfoPresentation.followMe(true);
                StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(false);
            } else {
                NavApplication.customProjection.myNavigationPresentation.followMe(true);
                StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void injectTouchPointsNew(TouchPoint touchPoint, int i, TouchEventType touchEventType) {
        try {
            if (touchEventType == TouchEventType.DOWN) {
                Log.e("TftTurnby tun", "touch down " + touchPoint.x + StringUtils.SPACE + touchPoint.y);
                this.touchMoveCounter = 3;
                if (touchPoint.y > 242 && touchPoint.y < 325 && touchPoint.x > 20 && touchPoint.x < 123) {
                    this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TftTurnByTurnScreen.lambda$injectTouchPointsNew$2();
                        }
                    });
                    return;
                }
                if (touchPoint.y > 76 && touchPoint.y < 159 && touchPoint.x > 20 && touchPoint.x < 123) {
                    Log.e("TftTurnby tun", "Zooom in0000");
                    this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
                        }
                    });
                    this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.e("TftTurnby tun", "Zooom in 00");
                            if (GlobalVar.isGoogleNavigation) {
                                NavApplication.customProjection.routeInfoPresentation.zoomInTFT();
                            } else {
                                Log.e("TftTurnby tun", "Zooom in");
                                NavApplication.customProjection.myNavigationPresentation.zoomInTFT();
                            }
                        }
                    });
                    return;
                } else if (touchPoint.x > 680 && touchPoint.x < 780 && touchPoint.y > 70 && touchPoint.y < 179) {
                    this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            TftTurnByTurnScreen.lambda$injectTouchPointsNew$4();
                        }
                    });
                    return;
                }
            }
            boolean z = true;
            if (touchEventType == TouchEventType.DOWN || touchEventType == TouchEventType.UP) {
                if (i == 0) {
                    this.lastTouchPoint1 = touchPoint;
                } else {
                    this.lastTouchPoint2 = touchPoint;
                }
                if (NavApplication.customProjection.myNavigationPresentation == null) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long jUptimeMillis2 = SystemClock.uptimeMillis() + 50;
                MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[2];
                MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[2];
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                MotionEvent.PointerProperties pointerProperties2 = new MotionEvent.PointerProperties();
                pointerProperties.id = 0;
                pointerProperties.toolType = 1;
                pointerPropertiesArr[0] = pointerProperties;
                if (i != 0) {
                    pointerProperties2.id = 1;
                    pointerProperties2.toolType = 1;
                    pointerPropertiesArr[1] = pointerProperties2;
                }
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
                pointerCoords.x = this.lastTouchPoint1.x;
                pointerCoords.y = this.lastTouchPoint1.y;
                pointerCoords.pressure = 1.0f;
                pointerCoords.size = 1.0f;
                pointerCoordsArr[0] = pointerCoords;
                if (i != 0) {
                    pointerCoords2.x = this.lastTouchPoint2.x;
                    pointerCoords2.y = this.lastTouchPoint2.y;
                    pointerCoords2.pressure = 1.0f;
                    pointerCoords2.size = 1.0f;
                    pointerCoordsArr[1] = pointerCoords2;
                }
                if (i == 0) {
                    final MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, touchEventType == TouchEventType.DOWN ? 0 : 1, 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                    if (GlobalVar.isGoogleNavigation) {
                        NavApplication.customProjection.routeInfoPresentation.gestureDetector.onTouchEvent(motionEventObtain);
                    } else {
                        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                    if (NavApplication.customProjection.myNavigationPresentation != null) {
                                        NavApplication.customProjection.myNavigationPresentation.mapView.onTouchEvent(motionEventObtain);
                                        return;
                                    }
                                    return;
                                }
                                NavApplication.customProjection.routeInfoPresentationMMI.mapView.onTouchEvent(motionEventObtain);
                            }
                        });
                    }
                } else if (i == 1) {
                    final MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, touchEventType == TouchEventType.DOWN ? 0 : 1, 2, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                    if (GlobalVar.isGoogleNavigation) {
                        NavApplication.customProjection.routeInfoPresentation.gestureDetector.onTouchEvent(motionEventObtain2);
                    } else {
                        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                    NavApplication.customProjection.myNavigationPresentation.mapView.onTouchEvent(motionEventObtain2);
                                } else {
                                    NavApplication.customProjection.routeInfoPresentationMMI.mapView.onTouchEvent(motionEventObtain2);
                                }
                            }
                        });
                    }
                }
                if (i == 1) {
                    if (touchEventType != TouchEventType.DOWN) {
                        z = false;
                    }
                    this.isSecondFingerDown = z;
                }
                if (touchEventType == TouchEventType.UP) {
                    this.isSecondFingerDown = false;
                    final MotionEvent motionEventObtain3 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, 1, 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                    if (GlobalVar.isGoogleNavigation) {
                        NavApplication.customProjection.routeInfoPresentation.gestureDetector.onTouchEvent(motionEventObtain3);
                    } else {
                        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                    NavApplication.customProjection.myNavigationPresentation.mapView.onTouchEvent(motionEventObtain3);
                                } else {
                                    NavApplication.customProjection.routeInfoPresentationMMI.mapView.onTouchEvent(motionEventObtain3);
                                }
                            }
                        });
                    }
                }
            } else if (touchEventType == TouchEventType.MOVE) {
                Log.e("TftScreen", "touch move");
                long jUptimeMillis3 = SystemClock.uptimeMillis();
                long jUptimeMillis4 = SystemClock.uptimeMillis() + 50;
                if (i == 0) {
                    this.lastTouchPoint1 = touchPoint;
                } else {
                    this.lastTouchPoint2 = touchPoint;
                }
                MotionEvent.PointerProperties[] pointerPropertiesArr2 = new MotionEvent.PointerProperties[2];
                MotionEvent.PointerCoords[] pointerCoordsArr2 = new MotionEvent.PointerCoords[2];
                MotionEvent.PointerProperties pointerProperties3 = new MotionEvent.PointerProperties();
                MotionEvent.PointerProperties pointerProperties4 = new MotionEvent.PointerProperties();
                pointerProperties3.id = 0;
                pointerProperties3.toolType = 1;
                pointerPropertiesArr2[0] = pointerProperties3;
                if (this.lastTouchPoint2 != null) {
                    pointerProperties4.id = 1;
                    pointerProperties4.toolType = 1;
                    pointerPropertiesArr2[1] = pointerProperties4;
                }
                MotionEvent.PointerCoords pointerCoords3 = new MotionEvent.PointerCoords();
                MotionEvent.PointerCoords pointerCoords4 = new MotionEvent.PointerCoords();
                pointerCoords3.x = this.lastTouchPoint1.x;
                pointerCoords3.y = this.lastTouchPoint1.y;
                pointerCoords3.pressure = 1.0f;
                pointerCoords3.size = 1.0f;
                pointerCoordsArr2[0] = pointerCoords3;
                if (i != 0) {
                    pointerCoords4.x = this.lastTouchPoint2.x;
                    pointerCoords4.y = this.lastTouchPoint2.y;
                    pointerCoords4.pressure = 1.0f;
                    pointerCoords4.size = 1.0f;
                    pointerCoordsArr2[1] = pointerCoords4;
                    if (!this.isSecondFingerDown) {
                        final MotionEvent motionEventObtain4 = MotionEvent.obtain(jUptimeMillis3, jUptimeMillis4, 0, 2, pointerPropertiesArr2, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                        if (GlobalVar.isGoogleNavigation) {
                            NavApplication.customProjection.routeInfoPresentation.gestureDetector.onTouchEvent(motionEventObtain4);
                        } else {
                            this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                        NavApplication.customProjection.myNavigationPresentation.mapView.onTouchEvent(motionEventObtain4);
                                    } else {
                                        NavApplication.customProjection.routeInfoPresentationMMI.mapView.onTouchEvent(motionEventObtain4);
                                    }
                                }
                            });
                        }
                        this.isSecondFingerDown = true;
                    }
                } else {
                    TouchPoint touchPoint2 = this.lastTouchPoint2;
                    if (touchPoint2 != null) {
                        pointerCoords4.x = touchPoint2.x;
                        pointerCoords4.y = this.lastTouchPoint2.y;
                        pointerCoords4.pressure = 1.0f;
                        pointerCoords4.size = 1.0f;
                        pointerCoordsArr2[1] = pointerCoords4;
                    }
                }
                if (this.isSecondFingerDown) {
                    MotionEvent.obtain(jUptimeMillis3, jUptimeMillis4, 2, 2, pointerPropertiesArr2, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                    if (GlobalVar.isGoogleNavigation) {
                        double dSqrt = (int) Math.sqrt(Math.pow(this.lastTouchPoint1.x - this.lastTouchPoint2.x, 2.0d) + Math.pow(this.lastTouchPoint1.y - this.lastTouchPoint2.y, 2.0d));
                        Log.e("TurnBytTun", "disance " + dSqrt);
                        double d = this.preDistance;
                        if (d == 0.0d) {
                            this.preDistance = dSqrt;
                        } else {
                            final double d2 = dSqrt / d;
                            this.preDistance = dSqrt;
                            this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    double d3 = d2;
                                    if (d3 > 1.0d) {
                                        NavApplication.customProjection.routeInfoPresentation.zoomInTFT();
                                    } else if (d3 < 1.0d) {
                                        NavApplication.customProjection.routeInfoPresentation.zoomOutTft();
                                    }
                                }
                            });
                        }
                    } else {
                        double dSqrt2 = (int) Math.sqrt(Math.pow(this.lastTouchPoint1.x - this.lastTouchPoint2.x, 2.0d) + Math.pow(this.lastTouchPoint1.y - this.lastTouchPoint2.y, 2.0d));
                        Log.e("TurnBytTun", "disance " + dSqrt2);
                        double d3 = this.preDistance;
                        if (d3 == 0.0d) {
                            this.preDistance = dSqrt2;
                        } else {
                            final double d4 = dSqrt2 / d3;
                            this.preDistance = dSqrt2;
                            this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.11
                                @Override // java.lang.Runnable
                                public void run() {
                                    double d5 = d4;
                                    if (d5 > 1.0d) {
                                        if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                            NavApplication.customProjection.myNavigationPresentation.zoomInTFT();
                                            return;
                                        } else {
                                            NavApplication.customProjection.routeInfoPresentationMMI.zoomInTFT();
                                            return;
                                        }
                                    }
                                    if (d5 < 1.0d) {
                                        if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                            NavApplication.customProjection.myNavigationPresentation.zoomOutTft();
                                        } else {
                                            NavApplication.customProjection.routeInfoPresentationMMI.zoomOutTft();
                                        }
                                    }
                                }
                            });
                        }
                    }
                } else {
                    int i2 = this.touchMoveCounter - 1;
                    this.touchMoveCounter = i2;
                    if (i2 > 0) {
                        return;
                    }
                    if (!GlobalVar.isGoogleNavigation) {
                        final MotionEvent motionEventObtain5 = MotionEvent.obtain(jUptimeMillis3, jUptimeMillis4, 2, 1, pointerPropertiesArr2, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen.12
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                                    NavApplication.customProjection.myNavigationPresentation.mapView.onTouchEvent(motionEventObtain5);
                                } else {
                                    NavApplication.customProjection.routeInfoPresentationMMI.mapView.onTouchEvent(motionEventObtain5);
                                }
                            }
                        });
                    } else if (Math.abs(pointerCoords4.x - pointerCoords3.x) > 20.0f || Math.abs(pointerCoords4.y - pointerCoords3.y) > 15.0f) {
                        MotionEvent motionEventObtain6 = MotionEvent.obtain(jUptimeMillis3, jUptimeMillis4, 2, 1, pointerPropertiesArr2, pointerCoordsArr2, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.TftTurnByTurnScreen$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
                            }
                        });
                        NavApplication.customProjection.routeInfoPresentation.gestureDetector.onTouchEvent(motionEventObtain6);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$injectTouchPointsNew$2() {
        StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
        if (GlobalVar.isGoogleNavigation) {
            NavApplication.customProjection.routeInfoPresentation.zoomOutTft();
        } else {
            NavApplication.customProjection.myNavigationPresentation.zoomOutTft();
        }
    }

    static /* synthetic */ void lambda$injectTouchPointsNew$4() {
        try {
            if (GlobalVar.isGoogleNavigation) {
                NavApplication.customProjection.routeInfoPresentation.currentMapZoom = 14.5f;
                NavApplication.customProjection.routeInfoPresentation.followMe(true);
            } else {
                NavApplication.customProjection.myNavigationPresentation.currentMapZoom = 14.5f;
                NavApplication.customProjection.myNavigationPresentation.followMe(true);
            }
            StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
