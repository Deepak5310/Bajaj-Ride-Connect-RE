package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes3.dex */
public interface DebuggingOverlayManagerInterface<T extends View> {
    void clearElementsHighlights(T t);

    void highlightElements(T t, ReadableArray readableArray);

    void highlightTraceUpdates(T t, ReadableArray readableArray);
}
