package com.mappls.sdk.maps.renderer.textureview;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES10;
import android.opengl.GLUtils;
import android.view.TextureView;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.renderer.egl.EGLConfigChooser;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
class TextureViewRenderThread extends Thread implements TextureView.SurfaceTextureListener {
    private static final String TAG = "Mbgl-TextureViewRenderThread";
    private boolean destroyContext;
    private boolean destroySurface;
    private final EGLHolder eglHolder;
    private boolean exited;
    private int height;
    private final TextureViewMapRenderer mapRenderer;
    private MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener;
    private boolean paused;
    private boolean requestRender;
    private boolean shouldExit;
    private boolean sizeChanged;
    private SurfaceTexture surface;
    private int width;
    private final Object lock = new Object();
    private final ArrayList<Runnable> eventQueue = new ArrayList<>();

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    TextureViewRenderThread(TextureView textureView, TextureViewMapRenderer textureViewMapRenderer) {
        textureView.setOpaque(!textureViewMapRenderer.isTranslucentSurface());
        textureView.setSurfaceTextureListener(this);
        this.mapRenderer = textureViewMapRenderer;
        this.eglHolder = new EGLHolder(new WeakReference(textureView), textureViewMapRenderer.isTranslucentSurface());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        synchronized (this.lock) {
            this.surface = surfaceTexture;
            this.width = i;
            this.height = i2;
            this.requestRender = true;
            this.lock.notifyAll();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        synchronized (this.lock) {
            this.width = i;
            this.height = i2;
            this.sizeChanged = true;
            this.requestRender = true;
            this.lock.notifyAll();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        synchronized (this.lock) {
            this.surface = null;
            this.destroySurface = true;
            this.requestRender = false;
            this.lock.notifyAll();
        }
        return true;
    }

    void requestRender() {
        synchronized (this.lock) {
            this.requestRender = true;
            this.lock.notifyAll();
        }
    }

    void queueEvent(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable must not be null");
        }
        synchronized (this.lock) {
            this.eventQueue.add(runnable);
            this.lock.notifyAll();
        }
    }

    void onPause() {
        synchronized (this.lock) {
            this.paused = true;
            this.lock.notifyAll();
        }
    }

    void onResume() {
        synchronized (this.lock) {
            this.paused = false;
            this.lock.notifyAll();
        }
    }

    void onDestroy() {
        synchronized (this.lock) {
            this.shouldExit = true;
            this.lock.notifyAll();
            while (!this.exited) {
                try {
                    this.lock.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i;
        Runnable runnableRemove;
        int i2;
        boolean z;
        boolean z2;
        while (true) {
            try {
                synchronized (this.lock) {
                    while (true) {
                        if (this.shouldExit) {
                            this.eglHolder.cleanup();
                            synchronized (this.lock) {
                                this.exited = true;
                                this.lock.notifyAll();
                            }
                            return;
                        }
                        i = -1;
                        if (this.eventQueue.isEmpty()) {
                            if (this.destroySurface) {
                                this.eglHolder.destroySurface();
                                this.destroySurface = false;
                            } else if (this.destroyContext) {
                                this.eglHolder.destroyContext();
                                this.destroyContext = false;
                            } else if (this.surface == null || this.paused || !this.requestRender) {
                                this.lock.wait();
                            } else {
                                i = this.width;
                                int i3 = this.height;
                                if (this.eglHolder.eglContext == EGL10.EGL_NO_CONTEXT) {
                                    z = true;
                                    i2 = i3;
                                    runnableRemove = null;
                                    z2 = false;
                                } else if (this.eglHolder.eglSurface == EGL10.EGL_NO_SURFACE) {
                                    z2 = true;
                                    i2 = i3;
                                    runnableRemove = null;
                                    z = false;
                                } else {
                                    this.requestRender = false;
                                    i2 = i3;
                                    runnableRemove = null;
                                }
                            }
                            i2 = -1;
                            runnableRemove = null;
                        } else {
                            runnableRemove = this.eventQueue.remove(0);
                            i2 = -1;
                        }
                        z = false;
                        z2 = false;
                    }
                }
                if (runnableRemove != null) {
                    runnableRemove.run();
                } else {
                    GL10 gl10CreateGL = this.eglHolder.createGL();
                    if (z) {
                        this.eglHolder.prepare();
                        synchronized (this.lock) {
                            if (this.eglHolder.createSurface()) {
                                this.mapRenderer.onSurfaceCreated(gl10CreateGL, this.eglHolder.eglConfig);
                                this.mapRenderer.onSurfaceChanged(gl10CreateGL, i, i2);
                            } else {
                                this.destroySurface = true;
                            }
                        }
                    } else if (z2) {
                        synchronized (this.lock) {
                            this.eglHolder.createSurface();
                        }
                        this.mapRenderer.onSurfaceChanged(gl10CreateGL, i, i2);
                    } else if (this.sizeChanged) {
                        this.mapRenderer.onSurfaceChanged(gl10CreateGL, i, i2);
                        this.sizeChanged = false;
                    } else if (this.eglHolder.eglSurface != EGL10.EGL_NO_SURFACE) {
                        this.mapRenderer.onDrawFrame(gl10CreateGL);
                        MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener = this.onSurfaceBitmapChangeListener;
                        if (onSurfaceBitmapChangeListener != null) {
                            onSurfaceBitmapChangeListener.onSurfaceBitmapChanged(getSurfaceBitmap());
                        }
                        int iSwap = this.eglHolder.swap();
                        if (iSwap == 12288) {
                            continue;
                        } else if (iSwap != 12302) {
                            Logger.w(TAG, String.format("eglSwapBuffer error: %s. Waiting or new surface", Integer.valueOf(iSwap)));
                            synchronized (this.lock) {
                                this.surface = null;
                                this.destroySurface = true;
                            }
                        } else {
                            Logger.w(TAG, "Context lost. Waiting for re-aquire");
                            synchronized (this.lock) {
                                this.surface = null;
                                this.destroySurface = true;
                                this.destroyContext = true;
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                this.eglHolder.cleanup();
                synchronized (this.lock) {
                    this.exited = true;
                    this.lock.notifyAll();
                    return;
                }
            } catch (Throwable th) {
                this.eglHolder.cleanup();
                synchronized (this.lock) {
                    this.exited = true;
                    this.lock.notifyAll();
                    throw th;
                }
            }
        }
    }

    public void setOnSurfaceBitmapChangeListener(MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener) {
        this.onSurfaceBitmapChangeListener = onSurfaceBitmapChangeListener;
    }

    public Bitmap getSurfaceBitmap() {
        synchronized (this.lock) {
            if (this.eglHolder.eglSurface == EGL10.EGL_NO_SURFACE) {
                return null;
            }
            if (this.eglHolder.egl.eglMakeCurrent(this.eglHolder.eglDisplay, this.eglHolder.eglSurface, this.eglHolder.eglSurface, this.eglHolder.eglContext)) {
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
            Logger.e(TAG, "eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.eglHolder.egl.eglGetError()));
            return null;
        }
    }

    private static class EGLHolder {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
        private EGL10 egl;
        private EGLConfig eglConfig;
        private final WeakReference<TextureView> textureViewWeakRef;
        private boolean translucentSurface;
        private EGLDisplay eglDisplay = EGL10.EGL_NO_DISPLAY;
        private EGLContext eglContext = EGL10.EGL_NO_CONTEXT;
        private EGLSurface eglSurface = EGL10.EGL_NO_SURFACE;

        EGLHolder(WeakReference<TextureView> weakReference, boolean z) {
            this.textureViewWeakRef = weakReference;
            this.translucentSurface = z;
        }

        void prepare() {
            this.egl = (EGL10) EGLContext.getEGL();
            if (this.eglDisplay == EGL10.EGL_NO_DISPLAY) {
                EGLDisplay eGLDisplayEglGetDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.eglDisplay = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                    throw new RuntimeException("eglGetDisplay failed");
                }
                if (!this.egl.eglInitialize(this.eglDisplay, new int[2])) {
                    throw new RuntimeException("eglInitialize failed");
                }
            }
            if (this.textureViewWeakRef == null) {
                this.eglConfig = null;
                this.eglContext = EGL10.EGL_NO_CONTEXT;
            } else if (this.eglContext == EGL10.EGL_NO_CONTEXT) {
                EGLConfig eGLConfigChooseConfig = new EGLConfigChooser(this.translucentSurface).chooseConfig(this.egl, this.eglDisplay);
                this.eglConfig = eGLConfigChooseConfig;
                this.eglContext = this.egl.eglCreateContext(this.eglDisplay, eGLConfigChooseConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            }
            if (this.eglContext == EGL10.EGL_NO_CONTEXT) {
                throw new RuntimeException("createContext");
            }
        }

        GL10 createGL() {
            return (GL10) this.eglContext.getGL();
        }

        boolean createSurface() {
            destroySurface();
            TextureView textureView = this.textureViewWeakRef.get();
            if (textureView != null && textureView.getSurfaceTexture() != null) {
                this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, textureView.getSurfaceTexture(), new int[]{12344});
            } else {
                this.eglSurface = EGL10.EGL_NO_SURFACE;
            }
            EGLSurface eGLSurface = this.eglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.egl.eglGetError() != 12299) {
                    return false;
                }
                Logger.e(TextureViewRenderThread.TAG, "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                return false;
            }
            return makeCurrent();
        }

        boolean makeCurrent() {
            EGL10 egl10 = this.egl;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = this.eglSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                return true;
            }
            Logger.w(TextureViewRenderThread.TAG, String.format("eglMakeCurrent: %s", Integer.valueOf(this.egl.eglGetError())));
            return false;
        }

        int swap() {
            if (this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface)) {
                return 12288;
            }
            return this.egl.eglGetError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroySurface() {
            if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            if (!this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface)) {
                Logger.w(TextureViewRenderThread.TAG, String.format("Could not destroy egl surface. Display %s, Surface %s", this.eglDisplay, this.eglSurface));
            }
            this.eglSurface = EGL10.EGL_NO_SURFACE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyContext() {
            if (this.eglContext == EGL10.EGL_NO_CONTEXT) {
                return;
            }
            if (!this.egl.eglDestroyContext(this.eglDisplay, this.eglContext)) {
                Logger.w(TextureViewRenderThread.TAG, String.format("Could not destroy egl context. Display %s, Context %s", this.eglDisplay, this.eglContext));
            }
            this.eglContext = EGL10.EGL_NO_CONTEXT;
        }

        private void terminate() {
            if (this.eglDisplay == EGL10.EGL_NO_DISPLAY) {
                return;
            }
            if (!this.egl.eglTerminate(this.eglDisplay)) {
                Logger.w(TextureViewRenderThread.TAG, String.format("Could not terminate egl. Display %s", this.eglDisplay));
            }
            this.eglDisplay = EGL10.EGL_NO_DISPLAY;
        }

        void cleanup() {
            destroySurface();
            destroyContext();
            terminate();
        }
    }
}
