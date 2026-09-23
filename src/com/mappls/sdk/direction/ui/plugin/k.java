package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.maps.Style;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
final class k implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ f b;

    final class a implements Style.OnStyleLoaded {
        a() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            style.addImagesAsync(k.this.a);
        }
    }

    k(f fVar, HashMap map) {
        this.b = fVar;
        this.a = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.getStyle(new a());
    }
}
