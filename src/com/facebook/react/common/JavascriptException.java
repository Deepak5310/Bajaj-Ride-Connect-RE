package com.facebook.react.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JavascriptException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/react/common/JavascriptException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/facebook/react/common/HasJavascriptExceptionMetadata;", "jsStackTrace", "", "(Ljava/lang/String;)V", "extraDataAsJson", "getExtraDataAsJson", "setExtraDataAsJson", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class JavascriptException extends RuntimeException implements HasJavascriptExceptionMetadata {
    private String extraDataAsJson;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavascriptException(String jsStackTrace) {
        super(jsStackTrace);
        Intrinsics.checkNotNullParameter(jsStackTrace, "jsStackTrace");
    }

    @Override // com.facebook.react.common.HasJavascriptExceptionMetadata
    public String getExtraDataAsJson() {
        return this.extraDataAsJson;
    }

    public final JavascriptException setExtraDataAsJson(String extraDataAsJson) {
        this.extraDataAsJson = extraDataAsJson;
        return this;
    }
}
