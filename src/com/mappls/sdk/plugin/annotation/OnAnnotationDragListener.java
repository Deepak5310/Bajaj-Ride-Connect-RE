package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.plugin.annotation.Annotation;

/* JADX INFO: loaded from: classes4.dex */
public interface OnAnnotationDragListener<T extends Annotation> {
    void onAnnotationDrag(T t);

    void onAnnotationDragFinished(T t);

    void onAnnotationDragStarted(T t);
}
