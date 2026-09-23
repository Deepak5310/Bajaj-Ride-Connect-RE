package com.mappls.sdk.direction.ui.plugin;

import android.graphics.Bitmap;
import com.mappls.sdk.maps.Style;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes6.dex */
final class m implements Style.OnStyleLoaded {
    final /* synthetic */ Map a;
    final /* synthetic */ l b;

    final class a implements Runnable {
        final /* synthetic */ Style a;

        a(Style style) {
            this.a = style;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (final String str : m.this.a.keySet()) {
                if (this.a.getImage(str) == null) {
                    m mVar = m.this;
                    l lVar = mVar.b;
                    String str2 = (String) mVar.a.get(str);
                    final Style style = this.a;
                    l.c cVar = new l.c() { // from class: com.mappls.sdk.direction.ui.plugin.m$a$$ExternalSyntheticLambda0
                        @Override // com.mappls.sdk.direction.ui.plugin.l.c
                        public final void a(Bitmap bitmap) {
                            style.addImageAsync(str, bitmap);
                        }
                    };
                    lVar.getClass();
                    Executors.newSingleThreadExecutor().execute(new n(str2, cVar));
                }
            }
        }
    }

    m(l lVar, HashMap map) {
        this.b = lVar;
        this.a = map;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        this.b.b.post(new a(style));
    }
}
