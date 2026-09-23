package com.mappls.sdk.maps.renderer;

/* JADX INFO: loaded from: classes4.dex */
public interface MapRendererScheduler {
    void queueEvent(Runnable runnable);

    void requestRender();
}
