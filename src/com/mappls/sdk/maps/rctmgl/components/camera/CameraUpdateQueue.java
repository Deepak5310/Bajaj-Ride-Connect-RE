package com.mappls.sdk.maps.rctmgl.components.camera;

import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public class CameraUpdateQueue {
    private OnCompleteAllListener mCompleteListener;
    private Queue<CameraStop> mQueue = new LinkedList();

    public interface OnCompleteAllListener {
        void onCompleteAll();
    }

    public void offer(CameraStop cameraStop) {
        this.mQueue.offer(cameraStop);
    }

    public int size() {
        return this.mQueue.size();
    }

    public boolean isEmpty() {
        return this.mQueue.isEmpty();
    }

    public void flush() {
        while (this.mQueue.size() > 0) {
            this.mQueue.remove();
        }
        this.mQueue = new LinkedList();
    }

    public void setOnCompleteAllListener(OnCompleteAllListener onCompleteAllListener) {
        this.mCompleteListener = onCompleteAllListener;
    }

    public void execute(RCTMGLMapView rCTMGLMapView) {
        if (this.mQueue.isEmpty()) {
            OnCompleteAllListener onCompleteAllListener = this.mCompleteListener;
            if (onCompleteAllListener != null) {
                onCompleteAllListener.onCompleteAll();
                return;
            }
            return;
        }
        CameraStop cameraStopPoll = this.mQueue.poll();
        if (cameraStopPoll == null) {
            return;
        }
        if (cameraStopPoll.isMapplsPinStrategyEnabled()) {
            cameraStopPoll.toCameraMapplsPinUpdate(rCTMGLMapView).run();
        } else {
            cameraStopPoll.toCameraUpdate(rCTMGLMapView).run();
        }
        execute(rCTMGLMapView);
    }
}
