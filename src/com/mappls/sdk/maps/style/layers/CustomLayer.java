package com.mappls.sdk.maps.style.layers;

/* JADX INFO: loaded from: classes4.dex */
public class CustomLayer extends Layer {
    @Override // com.mappls.sdk.maps.style.layers.Layer
    protected native void finalize() throws Throwable;

    protected native void initialize(String str, long j);

    @Deprecated
    public void update() {
    }

    public CustomLayer(String str, long j) {
        initialize(str, j);
    }

    CustomLayer(long j) {
        super(j);
    }
}
