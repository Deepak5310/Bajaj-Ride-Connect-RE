package com.mappls.sdk.maps;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
class CameraChangeDispatcher implements MapplsMap.OnCameraMoveStartedListener, MapplsMap.OnCameraMoveListener, MapplsMap.OnCameraMoveCanceledListener, MapplsMap.OnCameraIdleListener {
    private static final int IDLE = 3;
    private static final int MOVE = 1;
    private static final int MOVE_CANCELED = 2;
    private static final int MOVE_STARTED = 0;
    private int moveStartedReason;
    private final CameraChangeHandler handler = new CameraChangeHandler(this);
    private boolean idle = true;
    private final CopyOnWriteArrayList<MapplsMap.OnCameraMoveStartedListener> onCameraMoveStarted = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapplsMap.OnCameraMoveCanceledListener> onCameraMoveCanceled = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapplsMap.OnCameraMoveListener> onCameraMove = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapplsMap.OnCameraIdleListener> onCameraIdle = new CopyOnWriteArrayList<>();

    CameraChangeDispatcher() {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveStartedListener
    public void onCameraMoveStarted(int i) {
        this.moveStartedReason = i;
        this.handler.scheduleMessage(0);
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveListener
    public void onCameraMove() {
        this.handler.scheduleMessage(1);
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveCanceledListener
    public void onCameraMoveCanceled() {
        this.handler.scheduleMessage(2);
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraIdleListener
    public void onCameraIdle() {
        this.handler.scheduleMessage(3);
    }

    void addOnCameraIdleListener(MapplsMap.OnCameraIdleListener onCameraIdleListener) {
        this.onCameraIdle.add(onCameraIdleListener);
    }

    void removeOnCameraIdleListener(MapplsMap.OnCameraIdleListener onCameraIdleListener) {
        if (this.onCameraIdle.contains(onCameraIdleListener)) {
            this.onCameraIdle.remove(onCameraIdleListener);
        }
    }

    void addOnCameraMoveCancelListener(MapplsMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.onCameraMoveCanceled.add(onCameraMoveCanceledListener);
    }

    void removeOnCameraMoveCancelListener(MapplsMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (this.onCameraMoveCanceled.contains(onCameraMoveCanceledListener)) {
            this.onCameraMoveCanceled.remove(onCameraMoveCanceledListener);
        }
    }

    void addOnCameraMoveStartedListener(MapplsMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.onCameraMoveStarted.add(onCameraMoveStartedListener);
    }

    void removeOnCameraMoveStartedListener(MapplsMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        if (this.onCameraMoveStarted.contains(onCameraMoveStartedListener)) {
            this.onCameraMoveStarted.remove(onCameraMoveStartedListener);
        }
    }

    void addOnCameraMoveListener(MapplsMap.OnCameraMoveListener onCameraMoveListener) {
        this.onCameraMove.add(onCameraMoveListener);
    }

    void removeOnCameraMoveListener(MapplsMap.OnCameraMoveListener onCameraMoveListener) {
        if (this.onCameraMove.contains(onCameraMoveListener)) {
            this.onCameraMove.remove(onCameraMoveListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraMoveStarted() {
        if (this.idle) {
            this.idle = false;
            if (this.onCameraMoveStarted.isEmpty()) {
                return;
            }
            Iterator<MapplsMap.OnCameraMoveStartedListener> it2 = this.onCameraMoveStarted.iterator();
            while (it2.hasNext()) {
                it2.next().onCameraMoveStarted(this.moveStartedReason);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraMove() {
        if (this.onCameraMove.isEmpty() || this.idle) {
            return;
        }
        Iterator<MapplsMap.OnCameraMoveListener> it2 = this.onCameraMove.iterator();
        while (it2.hasNext()) {
            it2.next().onCameraMove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraMoveCancelled() {
        if (this.onCameraMoveCanceled.isEmpty() || this.idle) {
            return;
        }
        Iterator<MapplsMap.OnCameraMoveCanceledListener> it2 = this.onCameraMoveCanceled.iterator();
        while (it2.hasNext()) {
            it2.next().onCameraMoveCanceled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraIdle() {
        if (this.idle) {
            return;
        }
        this.idle = true;
        if (this.onCameraIdle.isEmpty()) {
            return;
        }
        Iterator<MapplsMap.OnCameraIdleListener> it2 = this.onCameraIdle.iterator();
        while (it2.hasNext()) {
            it2.next().onCameraIdle();
        }
    }

    void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        this.onCameraMoveStarted.clear();
        this.onCameraMoveCanceled.clear();
        this.onCameraMove.clear();
        this.onCameraIdle.clear();
    }

    private static class CameraChangeHandler extends Handler {
        private WeakReference<CameraChangeDispatcher> dispatcherWeakReference;

        CameraChangeHandler(CameraChangeDispatcher cameraChangeDispatcher) {
            this.dispatcherWeakReference = new WeakReference<>(cameraChangeDispatcher);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraChangeDispatcher cameraChangeDispatcher = this.dispatcherWeakReference.get();
            if (cameraChangeDispatcher != null) {
                int i = message.what;
                if (i == 0) {
                    cameraChangeDispatcher.executeOnCameraMoveStarted();
                    return;
                }
                if (i == 1) {
                    cameraChangeDispatcher.executeOnCameraMove();
                } else if (i == 2) {
                    cameraChangeDispatcher.executeOnCameraMoveCancelled();
                } else {
                    if (i != 3) {
                        return;
                    }
                    cameraChangeDispatcher.executeOnCameraIdle();
                }
            }
        }

        void scheduleMessage(int i) {
            CameraChangeDispatcher cameraChangeDispatcher = this.dispatcherWeakReference.get();
            if (cameraChangeDispatcher != null) {
                if (i == 0) {
                    boolean z = !cameraChangeDispatcher.idle && (hasMessages(3) || hasMessages(2));
                    removeMessages(3);
                    removeMessages(2);
                    if (z) {
                        return;
                    }
                }
                Message message = new Message();
                message.what = i;
                sendMessage(message);
            }
        }
    }
}
