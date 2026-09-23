package com.mappls.sdk.maps.renderer.glsurfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.renderer.egl.EGLLogWrapper;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private static final String TAG = "GLSurfaceView";
    private static final GLThreadManager glThreadManager = new GLThreadManager();
    private boolean detached;
    private OnGLSurfaceViewDetachedListener detachedListener;
    private GLSurfaceView.EGLConfigChooser eglConfigChooser;
    private GLSurfaceView.EGLContextFactory eglContextFactory;
    private GLSurfaceView.EGLWindowSurfaceFactory eglWindowSurfaceFactory;
    private GLThread glThread;
    private MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener;
    private boolean preserveEGLContextOnPause;
    private GLSurfaceView.Renderer renderer;
    private final WeakReference<MapplsGLSurfaceView> viewWeakReference;

    public interface OnGLSurfaceViewDetachedListener {
        void onGLSurfaceViewDetached();
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    public MapplsGLSurfaceView(Context context) {
        super(context);
        this.viewWeakReference = new WeakReference<>(this);
        init();
    }

    public MapplsGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.viewWeakReference = new WeakReference<>(this);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
    }

    protected void finalize() throws Throwable {
        try {
            GLThread gLThread = this.glThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public void setDetachedListener(OnGLSurfaceViewDetachedListener onGLSurfaceViewDetachedListener) {
        if (this.detachedListener != null) {
            throw new IllegalArgumentException("Detached from window listener has been already set.");
        }
        this.detachedListener = onGLSurfaceViewDetachedListener;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.preserveEGLContextOnPause = z;
    }

    public void setOnSurfaceBitmapChangeListener(MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener) {
        this.onSurfaceBitmapChangeListener = onSurfaceBitmapChangeListener;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.preserveEGLContextOnPause;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        checkRenderThreadState();
        if (this.eglConfigChooser == null) {
            throw new IllegalStateException("No eglConfigChooser provided");
        }
        if (this.eglContextFactory == null) {
            throw new IllegalStateException("No eglContextFactory provided");
        }
        if (this.eglWindowSurfaceFactory == null) {
            throw new IllegalStateException("No eglWindowSurfaceFactory provided");
        }
        this.renderer = renderer;
        GLThread gLThread = new GLThread(this.viewWeakReference);
        this.glThread = gLThread;
        gLThread.start();
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.eglContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.eglWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.eglConfigChooser = eGLConfigChooser;
    }

    public void setRenderMode(int i) {
        this.glThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.glThread.getRenderMode();
    }

    public void requestRender() {
        this.glThread.requestRender();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.glThread.surfaceCreated();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.glThread.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.glThread.onWindowResize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        GLThread gLThread = this.glThread;
        if (gLThread != null) {
            gLThread.requestRenderAndNotify(runnable);
        }
    }

    public void onPause() {
        this.glThread.onPause();
    }

    public void onResume() {
        this.glThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.glThread.queueEvent(runnable);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.detached && this.renderer != null) {
            GLThread gLThread = this.glThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.viewWeakReference);
            this.glThread = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.glThread.start();
        }
        this.detached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        OnGLSurfaceViewDetachedListener onGLSurfaceViewDetachedListener = this.detachedListener;
        if (onGLSurfaceViewDetachedListener != null) {
            onGLSurfaceViewDetachedListener.onGLSurfaceViewDetached();
        }
        GLThread gLThread = this.glThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.detached = true;
        super.onDetachedFromWindow();
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<MapplsGLSurfaceView> mGLSurfaceViewWeakRef;

        private EglHelper(WeakReference<MapplsGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                this.mEgl = egl10;
                EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.mEglDisplay = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                    Log.e(MapplsGLSurfaceView.TAG, "eglGetDisplay failed");
                    return;
                }
                if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                    Log.e(MapplsGLSurfaceView.TAG, "eglInitialize failed");
                    return;
                }
                MapplsGLSurfaceView mapplsGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
                if (mapplsGLSurfaceView != null) {
                    this.mEglConfig = mapplsGLSurfaceView.eglConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                    this.mEglContext = mapplsGLSurfaceView.eglContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                } else {
                    this.mEglConfig = null;
                    this.mEglContext = null;
                }
                EGLContext eGLContext = this.mEglContext;
                if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                    this.mEglContext = null;
                    Log.e(MapplsGLSurfaceView.TAG, "createContext failed");
                    return;
                }
                this.mEglSurface = null;
            } catch (Exception e) {
                Log.e(MapplsGLSurfaceView.TAG, "createContext failed: ", e);
            }
        }

        boolean createSurface() {
            if (this.mEgl == null) {
                Log.e(MapplsGLSurfaceView.TAG, "egl not initialized");
                return false;
            }
            if (this.mEglDisplay == null) {
                Log.e(MapplsGLSurfaceView.TAG, "eglDisplay not initialized");
                return false;
            }
            if (this.mEglConfig == null) {
                Log.e(MapplsGLSurfaceView.TAG, "mEglConfig not initialized");
                return false;
            }
            destroySurfaceImp();
            MapplsGLSurfaceView mapplsGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (mapplsGLSurfaceView != null) {
                this.mEglSurface = mapplsGLSurfaceView.eglWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, mapplsGLSurfaceView.getHolder());
            } else {
                this.mEglSurface = null;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.mEgl.eglGetError() == 12299) {
                    Log.e(MapplsGLSurfaceView.TAG, "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            EGL10 egl10 = this.mEgl;
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                return true;
            }
            logEglErrorAsWarning(MapplsGLSurfaceView.TAG, "eglMakeCurrent", this.mEgl.eglGetError());
            return false;
        }

        GL createGL() {
            return this.mEglContext.getGL();
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }

        void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            MapplsGLSurfaceView mapplsGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (mapplsGLSurfaceView != null) {
                mapplsGLSurfaceView.eglWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public void finish() {
            if (this.mEglContext != null) {
                MapplsGLSurfaceView mapplsGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
                if (mapplsGLSurfaceView != null) {
                    mapplsGLSurfaceView.eglContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        static String formatEglError(String str, int i) {
            return str + " failed: " + EGLLogWrapper.getErrorString(i);
        }
    }

    static class GLThread extends Thread {
        private EglHelper eglHelper;
        private boolean exited;
        private boolean finishedCreatingEglSurface;
        private boolean hasSurface;
        private boolean haveEglContext;
        private boolean haveEglSurface;
        private WeakReference<MapplsGLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean paused;
        private boolean renderComplete;
        private boolean requestPaused;
        private boolean shouldExit;
        private boolean shouldReleaseEglContext;
        private boolean surfaceIsBad;
        private boolean waitingForSurface;
        private ArrayList<Runnable> eventQueue = new ArrayList<>();
        private boolean sizeChanged = true;
        private Runnable finishDrawingRunnable = null;
        private int width = 0;
        private int height = 0;
        private boolean requestRender = true;
        private int renderMode = 1;
        private boolean wantRenderNotification = false;

        GLThread(WeakReference<MapplsGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } finally {
                MapplsGLSurfaceView.glThreadManager.threadExiting(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.haveEglSurface) {
                this.haveEglSurface = false;
                this.eglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.haveEglContext) {
                this.eglHelper.finish();
                this.haveEglContext = false;
                MapplsGLSurfaceView.glThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARN: Code duplicated, block: B:154:0x0220  */
        /* JADX WARN: Code duplicated, block: B:185:0x0246 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        private void guardedRun() throws InterruptedException {
            Runnable runnable;
            boolean z;
            boolean z2;
            MapplsGLSurfaceView mapplsGLSurfaceView;
            this.eglHelper = new EglHelper(this.mGLSurfaceViewWeakRef);
            this.haveEglContext = false;
            this.haveEglSurface = false;
            this.wantRenderNotification = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            int i = 0;
            int i2 = 0;
            Runnable runnable2 = null;
            GL10 gl10 = null;
            Runnable runnableRemove = null;
            while (true) {
                try {
                    synchronized (MapplsGLSurfaceView.glThreadManager) {
                        while (true) {
                            if (this.shouldExit) {
                                synchronized (MapplsGLSurfaceView.glThreadManager) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                }
                                return;
                            }
                            if (!this.eventQueue.isEmpty()) {
                                runnableRemove = this.eventQueue.remove(0);
                                runnable = null;
                                break;
                            }
                            boolean z11 = this.paused;
                            boolean z12 = this.requestPaused;
                            if (z11 != z12) {
                                this.paused = z12;
                                MapplsGLSurfaceView.glThreadManager.notifyAll();
                            } else {
                                z12 = false;
                            }
                            if (this.shouldReleaseEglContext) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                this.shouldReleaseEglContext = false;
                                z5 = true;
                            }
                            if (z3) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                z3 = false;
                            }
                            if (z12 && this.haveEglSurface) {
                                stopEglSurfaceLocked();
                            }
                            if (z12 && this.haveEglContext && ((mapplsGLSurfaceView = this.mGLSurfaceViewWeakRef.get()) == null || !mapplsGLSurfaceView.preserveEGLContextOnPause)) {
                                stopEglContextLocked();
                            }
                            if (!this.hasSurface && !this.waitingForSurface) {
                                if (this.haveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                this.waitingForSurface = true;
                                this.surfaceIsBad = false;
                                MapplsGLSurfaceView.glThreadManager.notifyAll();
                            }
                            if (this.hasSurface && this.waitingForSurface) {
                                this.waitingForSurface = false;
                                MapplsGLSurfaceView.glThreadManager.notifyAll();
                            }
                            if (z4) {
                                this.wantRenderNotification = false;
                                this.renderComplete = true;
                                MapplsGLSurfaceView.glThreadManager.notifyAll();
                                z4 = false;
                            }
                            Runnable runnable3 = this.finishDrawingRunnable;
                            if (runnable3 != null) {
                                runnable = null;
                                this.finishDrawingRunnable = null;
                                runnable2 = runnable3;
                            } else {
                                runnable = null;
                            }
                            if (readyToDraw()) {
                                if (!this.haveEglContext) {
                                    if (z5) {
                                        z5 = false;
                                    } else {
                                        try {
                                            this.eglHelper.start();
                                            this.haveEglContext = true;
                                            MapplsGLSurfaceView.glThreadManager.notifyAll();
                                            z6 = true;
                                        } catch (RuntimeException unused) {
                                            MapplsGLSurfaceView.glThreadManager.releaseEglContextLocked(this);
                                            synchronized (MapplsGLSurfaceView.glThreadManager) {
                                                stopEglSurfaceLocked();
                                                stopEglContextLocked();
                                                return;
                                            }
                                        }
                                    }
                                }
                                if (this.haveEglContext && !this.haveEglSurface) {
                                    this.haveEglSurface = true;
                                    z7 = true;
                                    z8 = true;
                                    z9 = true;
                                }
                                if (this.haveEglSurface) {
                                    if (this.sizeChanged) {
                                        i = this.width;
                                        i2 = this.height;
                                        this.wantRenderNotification = true;
                                        this.sizeChanged = false;
                                        z2 = false;
                                        z7 = true;
                                        z9 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    this.requestRender = z2;
                                    MapplsGLSurfaceView.glThreadManager.notifyAll();
                                    if (!this.wantRenderNotification) {
                                        break;
                                    }
                                    z10 = true;
                                    break;
                                }
                            } else if (runnable2 != null) {
                                Log.w(MapplsGLSurfaceView.TAG, "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                runnable2.run();
                                runnable2 = null;
                            }
                            MapplsGLSurfaceView.glThreadManager.wait();
                        }
                    }
                    if (runnableRemove != null) {
                        runnableRemove.run();
                        runnableRemove = runnable;
                    } else {
                        if (z7) {
                            if (this.eglHelper.createSurface()) {
                                synchronized (MapplsGLSurfaceView.glThreadManager) {
                                    this.finishedCreatingEglSurface = true;
                                    MapplsGLSurfaceView.glThreadManager.notifyAll();
                                }
                                z7 = false;
                            } else {
                                synchronized (MapplsGLSurfaceView.glThreadManager) {
                                    this.finishedCreatingEglSurface = true;
                                    this.surfaceIsBad = true;
                                    MapplsGLSurfaceView.glThreadManager.notifyAll();
                                }
                            }
                            synchronized (MapplsGLSurfaceView.glThreadManager) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                throw th;
                            }
                        }
                        if (z8) {
                            gl10 = (GL10) this.eglHelper.createGL();
                            z8 = false;
                        }
                        if (z6) {
                            MapplsGLSurfaceView mapplsGLSurfaceView2 = this.mGLSurfaceViewWeakRef.get();
                            if (mapplsGLSurfaceView2 != null) {
                                mapplsGLSurfaceView2.renderer.onSurfaceCreated(gl10, this.eglHelper.mEglConfig);
                            }
                            z6 = false;
                        }
                        if (z9) {
                            MapplsGLSurfaceView mapplsGLSurfaceView3 = this.mGLSurfaceViewWeakRef.get();
                            if (mapplsGLSurfaceView3 != null) {
                                mapplsGLSurfaceView3.renderer.onSurfaceChanged(gl10, i, i2);
                            }
                            z9 = false;
                        }
                        MapplsGLSurfaceView mapplsGLSurfaceView4 = this.mGLSurfaceViewWeakRef.get();
                        if (mapplsGLSurfaceView4 != null) {
                            mapplsGLSurfaceView4.renderer.onDrawFrame(gl10);
                            if (mapplsGLSurfaceView4.onSurfaceBitmapChangeListener != null) {
                                mapplsGLSurfaceView4.onSurfaceBitmapChangeListener.onSurfaceBitmapChanged(getSurfaceBitmap());
                            }
                            if (runnable2 != null) {
                                runnable2.run();
                                runnable2 = null;
                            }
                        }
                        int iSwap = this.eglHelper.swap();
                        if (iSwap != 12288) {
                            if (iSwap != 12302) {
                                EglHelper.logEglErrorAsWarning(MapplsGLSurfaceView.TAG, "eglSwapBuffers", iSwap);
                                synchronized (MapplsGLSurfaceView.glThreadManager) {
                                    z = true;
                                    this.surfaceIsBad = true;
                                    MapplsGLSurfaceView.glThreadManager.notifyAll();
                                }
                            } else {
                                z = true;
                                z3 = true;
                            }
                            if (z10) {
                                z4 = z;
                                z10 = false;
                            }
                        } else {
                            z = true;
                        }
                        z3 = z3;
                        if (z10) {
                            z4 = z;
                            z10 = false;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (MapplsGLSurfaceView.glThreadManager) {
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th;
                    }
                }
            }
        }

        public boolean ableToDraw() {
            return this.haveEglContext && this.haveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.paused && this.hasSurface && !this.surfaceIsBad && this.width > 0 && this.height > 0 && (this.requestRender || this.renderMode == 1);
        }

        public void setRenderMode(int i) {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.renderMode = i;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                i = this.renderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.requestRender = true;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
            }
        }

        public void requestRenderAndNotify(Runnable runnable) {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.wantRenderNotification = true;
                this.requestRender = true;
                this.renderComplete = false;
                this.finishDrawingRunnable = runnable;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.hasSurface = true;
                this.finishedCreatingEglSurface = false;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
                while (this.waitingForSurface && !this.finishedCreatingEglSurface && !this.exited) {
                    try {
                        MapplsGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.hasSurface = false;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
                while (!this.waitingForSurface && !this.exited) {
                    try {
                        MapplsGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onPause() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.requestPaused = true;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited && !this.paused) {
                    try {
                        MapplsGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.requestPaused = false;
                this.requestRender = true;
                this.renderComplete = false;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited && this.paused && !this.renderComplete) {
                    try {
                        MapplsGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.width = i;
                this.height = i2;
                this.sizeChanged = true;
                this.requestRender = true;
                this.renderComplete = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                MapplsGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited && !this.paused && !this.renderComplete && ableToDraw()) {
                    try {
                        MapplsGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public Bitmap getSurfaceBitmap() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                WeakReference<MapplsGLSurfaceView> weakReference = this.mGLSurfaceViewWeakRef;
                if (weakReference == null) {
                    return null;
                }
                MapplsGLSurfaceView mapplsGLSurfaceView = weakReference.get();
                if (mapplsGLSurfaceView == null && mapplsGLSurfaceView.eglWindowSurfaceFactory != null) {
                    return null;
                }
                int i = this.width;
                int i2 = this.height;
                int i3 = i * i2;
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
                intBufferWrap.position(0);
                GLES10.glReadPixels(0, 0, i, i2, 6408, FujifilmMakernoteDirectory.TAG_FILM_MODE, intBufferWrap);
                for (int i4 = 0; i4 < i2; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = iArr[(i4 * i) + i5];
                        iArr2[(((i2 - i4) - 1) * i) + i5] = (((i6 >> 24) & 255) << 24) | ((i6 & 255) << 16) | (((i6 >> 8) & 255) << 8) | ((i6 >> 16) & 255);
                    }
                }
                return Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
            }
        }

        public void requestExitAndWait() {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.shouldExit = true;
                MapplsGLSurfaceView.glThreadManager.notifyAll();
                while (!this.exited) {
                    try {
                        MapplsGLSurfaceView.glThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.shouldReleaseEglContext = true;
            MapplsGLSurfaceView.glThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            synchronized (MapplsGLSurfaceView.glThreadManager) {
                this.eventQueue.add(runnable);
                MapplsGLSurfaceView.glThreadManager.notifyAll();
            }
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(MapplsGLSurfaceView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.glThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private GLThreadManager() {
        }

        synchronized void threadExiting(GLThread gLThread) {
            gLThread.exited = true;
            notifyAll();
        }

        void releaseEglContextLocked(GLThread gLThread) {
            notifyAll();
        }
    }
}
