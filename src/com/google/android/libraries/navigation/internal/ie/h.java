package com.google.android.libraries.navigation.internal.ie;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.FutureTarget;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "There is no use case for this in GMM. (for migration purposes only)")
public final class h {
    public static final g a = new g();
    private final Executor b;
    private final RequestManager c;

    public h(Context context, Executor uiExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uiExecutor, "uiExecutor");
        this.b = uiExecutor;
        RequestManager requestManagerWith = Glide.with(context);
        Intrinsics.checkNotNullExpressionValue(requestManagerWith, "with(...)");
        this.c = requestManagerWith;
    }

    public final FutureTarget a(String url, com.google.android.libraries.navigation.internal.kt.a listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RequestBuilder<Bitmap> requestBuilderAddListener = this.c.asBitmap().load(g.a(url)).addListener(new l(listener, this.b));
        Intrinsics.checkNotNullExpressionValue(requestBuilderAddListener, "addListener(...)");
        Intrinsics.checkNotNullParameter(requestBuilderAddListener, "<this>");
        requestBuilderAddListener.downsample(DownsampleStrategy.FIT_CENTER);
        FutureTarget<Bitmap> futureTargetSubmit = requestBuilderAddListener.submit();
        Intrinsics.checkNotNullExpressionValue(futureTargetSubmit, "submit(...)");
        return futureTargetSubmit;
    }
}
