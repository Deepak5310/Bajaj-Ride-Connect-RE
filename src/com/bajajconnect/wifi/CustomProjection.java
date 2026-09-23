package com.bajajconnect.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.views.GoogleMapPresentation;
import com.bajajconnect.wifi.views.RouteInfoPresentation;
import com.bajajconnect.wifi.views.VirtualNavigationPresentation;
import com.drew.metadata.avi.AviDirectory;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class CustomProjection {
    private static final long MIN_CAPTURE_INTERVAL_MS = 70;
    private LocalBroadcastManager broadcastManager;
    private final Context context;
    final DisplayManager displayManager;
    public ImageReader mImageReader;
    public VirtualNavigationPresentation myNavigationPresentation;
    private ByteBuffer packedPixelBuffer;
    private Handler projectionHandler;
    HandlerThread projectionThread;
    private Bitmap reusableBitmap;
    public GoogleMapPresentation routeInfoPresentation;
    public RouteInfoPresentation routeInfoPresentationMMI;
    private byte[] rowScratch;
    private VirtualDisplay virtualDisplay;
    private final int mWidth = 800;
    private final int mHeight = StreamingImageHandler.TFT_HEIGHT;
    public Bitmap bitmap = null;
    private volatile long lastCapturePostedMs = 0;
    VirtualDisplay.Callback callback = new VirtualDisplay.Callback() { // from class: com.bajajconnect.wifi.CustomProjection.1
        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onPaused() {
            super.onPaused();
            Log.e("VirtualDisplay", "on display paused");
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onResumed() {
            super.onResumed();
            Log.e("VirtualDisplay", "on display resume");
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onStopped() {
            super.onStopped();
            Log.e("VirtualDisplay", "on display stopped");
        }
    };
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public CustomProjection(Context context) {
        this.context = context.getApplicationContext();
        this.displayManager = (DisplayManager) context.getApplicationContext().getSystemService("display");
        this.broadcastManager = LocalBroadcastManager.getInstance(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyImagePlaneToTightBitmap(Image image) {
        Image.Plane plane = image.getPlanes()[0];
        ByteBuffer buffer = plane.getBuffer();
        int pixelStride = plane.getPixelStride();
        int rowStride = plane.getRowStride();
        int i = pixelStride * 800;
        Bitmap bitmap = this.reusableBitmap;
        if (bitmap == null || bitmap.isRecycled() || this.reusableBitmap.getWidth() != 800 || this.reusableBitmap.getHeight() != 480) {
            Bitmap bitmap2 = this.reusableBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.reusableBitmap.recycle();
            }
            this.reusableBitmap = Bitmap.createBitmap(800, StreamingImageHandler.TFT_HEIGHT, Bitmap.Config.ARGB_8888);
        }
        buffer.rewind();
        if (rowStride == i) {
            this.reusableBitmap.copyPixelsFromBuffer(buffer);
        } else {
            int i2 = pixelStride * 384000;
            ByteBuffer byteBuffer = this.packedPixelBuffer;
            if (byteBuffer == null || byteBuffer.capacity() < i2) {
                this.packedPixelBuffer = ByteBuffer.allocate(i2);
            }
            byte[] bArr = this.rowScratch;
            if (bArr == null || bArr.length < i) {
                this.rowScratch = new byte[i];
            }
            this.packedPixelBuffer.clear();
            for (int i3 = 0; i3 < 480; i3++) {
                buffer.position(i3 * rowStride);
                buffer.get(this.rowScratch, 0, i);
                this.packedPixelBuffer.put(this.rowScratch, 0, i);
            }
            this.packedPixelBuffer.flip();
            this.reusableBitmap.copyPixelsFromBuffer(this.packedPixelBuffer);
        }
        this.bitmap = this.reusableBitmap;
    }

    private class ImageAvailableListener implements ImageReader.OnImageAvailableListener {
        private ImageAvailableListener() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            if (MirroringGlobarVar.currentScreen == Screens.SEARCH_SCREEN || SystemClock.elapsedRealtime() - CustomProjection.this.lastCapturePostedMs < CustomProjection.MIN_CAPTURE_INTERVAL_MS) {
                try {
                    Image imageAcquireLatestImage = CustomProjection.this.mImageReader.acquireLatestImage();
                    if (imageAcquireLatestImage != null) {
                        imageAcquireLatestImage.close();
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            CustomProjection.this.lastCapturePostedMs = SystemClock.elapsedRealtime();
            try {
                Image imageAcquireLatestImage2 = CustomProjection.this.mImageReader.acquireLatestImage();
                if (imageAcquireLatestImage2 != null) {
                    try {
                        CustomProjection.this.copyImagePlaneToTightBitmap(imageAcquireLatestImage2);
                        if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.udpServerService != null) {
                            NavApplication.streamingHandler.udpServerService.onSearchScreenUpdated(CustomProjection.this.bitmap);
                        }
                    } catch (Throwable th) {
                        if (imageAcquireLatestImage2 != null) {
                            try {
                                imageAcquireLatestImage2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                if (imageAcquireLatestImage2 != null) {
                    imageAcquireLatestImage2.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void startActivity() {
        try {
            this.routeInfoPresentation.hide();
        } catch (Exception unused) {
        }
        this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.CustomProjection$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startActivity$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startActivity$0() {
        this.broadcastManager.sendBroadcast(new Intent(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
        VirtualNavigationPresentation virtualNavigationPresentation = new VirtualNavigationPresentation(this.context.getApplicationContext(), this.virtualDisplay.getDisplay(), R.style.AppTheme);
        this.myNavigationPresentation = virtualNavigationPresentation;
        virtualNavigationPresentation.show();
    }

    public void startActivityRoute(final Activity activity) {
        try {
            VirtualDisplay virtualDisplay = this.virtualDisplay;
            if (virtualDisplay != null) {
                try {
                    virtualDisplay.release();
                } catch (Exception unused) {
                }
                this.virtualDisplay = null;
            }
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                try {
                    imageReader.setOnImageAvailableListener(null, null);
                    this.mImageReader.close();
                } catch (Exception unused2) {
                }
                this.mImageReader = null;
            }
            if (this.projectionThread == null) {
                HandlerThread handlerThread = new HandlerThread("Projection");
                this.projectionThread = handlerThread;
                handlerThread.start();
                this.projectionHandler = new Handler(this.projectionThread.getLooper());
            }
            this.mImageReader = ImageReader.newInstance(800, StreamingImageHandler.TFT_HEIGHT, 1, 2);
            this.virtualDisplay = this.displayManager.createVirtualDisplay("MyVirtualDisplay", 800, StreamingImageHandler.TFT_HEIGHT, GlobalVar.isGoogleNavigation ? 240 : AviDirectory.TAG_DATETIME_ORIGINAL, this.mImageReader.getSurface(), 2, this.callback, this.projectionHandler);
            this.mImageReader.setOnImageAvailableListener(new ImageAvailableListener(), this.projectionHandler);
            this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.CustomProjection$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startActivityRoute$1(activity);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startActivityRoute$1(Activity activity) {
        try {
            if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.udpServerService != null) {
                NavApplication.streamingHandler.udpServerService.stopScreenCapture();
            }
            if (GlobalVar.isGoogleNavigation) {
                GoogleMapPresentation googleMapPresentation = new GoogleMapPresentation(this.context, this.virtualDisplay.getDisplay(), R.style.AppTheme, this.mainHandler, activity);
                this.routeInfoPresentation = googleMapPresentation;
                googleMapPresentation.show();
            } else {
                RouteInfoPresentation routeInfoPresentation = new RouteInfoPresentation(this.context, this.virtualDisplay.getDisplay(), R.style.AppTheme, this.mainHandler);
                this.routeInfoPresentationMMI = routeInfoPresentation;
                routeInfoPresentation.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopNavigationCombined() {
        this.broadcastManager.sendBroadcast(new Intent(MirroringGlobarVar.ACTION_STOP_NAVIGATION));
    }

    public synchronized void releaseCaptureBuffers() {
        try {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.setOnImageAvailableListener(null, null);
                this.mImageReader.close();
            }
        } catch (Exception unused) {
        }
        this.mImageReader = null;
        try {
            VirtualDisplay virtualDisplay = this.virtualDisplay;
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        } catch (Exception unused2) {
        }
        this.virtualDisplay = null;
        try {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null && bitmap != this.reusableBitmap && !bitmap.isRecycled()) {
                this.bitmap.recycle();
            }
        } catch (Exception unused3) {
        }
        this.bitmap = null;
        try {
            Bitmap bitmap2 = this.reusableBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.reusableBitmap.recycle();
            }
        } catch (Exception unused4) {
        }
        this.reusableBitmap = null;
        this.packedPixelBuffer = null;
        this.rowScratch = null;
    }

    public synchronized void releaseProjectionForNavBound(final Runnable runnable) {
        GlobalVar.isNavigationActive = false;
        this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.CustomProjection$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$releaseProjectionForNavBound$2(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseProjectionForNavBound$2(Runnable runnable) {
        GoogleMapPresentation googleMapPresentation;
        try {
            if (GlobalVar.isGoogleNavigation && (googleMapPresentation = this.routeInfoPresentation) != null) {
                googleMapPresentation.hide();
                this.routeInfoPresentation.dismiss();
                this.routeInfoPresentation = null;
            } else {
                RouteInfoPresentation routeInfoPresentation = this.routeInfoPresentationMMI;
                if (routeInfoPresentation != null) {
                    routeInfoPresentation.hide();
                    this.routeInfoPresentationMMI.dismiss();
                    this.routeInfoPresentationMMI = null;
                }
            }
            VirtualNavigationPresentation virtualNavigationPresentation = this.myNavigationPresentation;
            if (virtualNavigationPresentation != null) {
                virtualNavigationPresentation.hide();
                this.myNavigationPresentation.dismiss();
                this.myNavigationPresentation = null;
            }
        } catch (Exception unused) {
        }
        releaseCaptureBuffers();
        if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void stopPresentation() {
        GlobalVar.isNavigationActive = false;
        try {
            this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.CustomProjection$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$stopPresentation$3();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopPresentation$3() {
        GoogleMapPresentation googleMapPresentation;
        try {
            if (GlobalVar.isGoogleNavigation && (googleMapPresentation = this.routeInfoPresentation) != null) {
                googleMapPresentation.hide();
                this.virtualDisplay.getSurface().release();
                this.routeInfoPresentation.dismiss();
            } else {
                this.routeInfoPresentationMMI.hide();
                VirtualNavigationPresentation virtualNavigationPresentation = this.myNavigationPresentation;
                if (virtualNavigationPresentation != null) {
                    virtualNavigationPresentation.hide();
                    this.virtualDisplay.getSurface().release();
                    this.myNavigationPresentation.dismiss();
                } else {
                    this.virtualDisplay.getSurface().release();
                    this.routeInfoPresentationMMI.dismiss();
                }
            }
        } catch (Exception unused) {
        }
        VirtualDisplay virtualDisplay = this.virtualDisplay;
        if (virtualDisplay != null) {
            virtualDisplay.getSurface().release();
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null && imageReader.getSurface() != null) {
                this.mImageReader.getSurface().release();
                this.mImageReader.setOnImageAvailableListener(null, null);
                this.mImageReader.close();
            }
            this.mImageReader = null;
            ImageReader imageReaderNewInstance = ImageReader.newInstance(800, StreamingImageHandler.TFT_HEIGHT, 256, 2);
            this.mImageReader = imageReaderNewInstance;
            this.virtualDisplay.setSurface(imageReaderNewInstance.getSurface());
        }
    }

    public void navBackToSearchScreen() {
        try {
            this.routeInfoPresentationMMI.hide();
            stopPresentation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navBackToRouteScreen() {
        try {
            NavApplication.customProjection.myNavigationPresentation.onBackPressed();
            this.myNavigationPresentation.hide();
            this.myNavigationPresentation.dismiss();
            this.routeInfoPresentationMMI.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MirroringGlobarVar.currentScreen = Screens.ROUTE_SCREEN;
        NavApplication.streamingHandler.udpServerService.onScreenChange();
    }
}
