package com.google.android.libraries.navigation.internal.ie;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "Just use the Future API.")
public final class l implements RequestListener {
    public final com.google.android.libraries.navigation.internal.kt.a a;
    private final Executor b;

    public l(com.google.android.libraries.navigation.internal.kt.a listener, Executor executor) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.a = listener;
        this.b = executor;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException glideException, Object model, Target target, boolean z) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        final com.google.android.libraries.navigation.internal.kt.a aVar = this.a;
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ie.k
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return true;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object model, Target target, DataSource dataSource, boolean z) {
        final Bitmap resource = (Bitmap) obj;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ie.j
            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmap = resource;
                if (true != (bitmap instanceof Bitmap)) {
                    bitmap = null;
                }
                this.a.a.a(bitmap);
            }
        });
        return true;
    }
}
