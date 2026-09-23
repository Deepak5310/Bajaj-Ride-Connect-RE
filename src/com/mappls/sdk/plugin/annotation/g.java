package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.plugin.annotation.Annotation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g<T extends Annotation> {
    abstract T build(long j, AnnotationManager<?, T, ?, ?, ?, ?> annotationManager);
}
