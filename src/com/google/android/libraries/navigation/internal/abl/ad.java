package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.google.android.libraries.navigation.internal.abh.id;
import com.google.android.libraries.navigation.internal.ly.ch;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad extends com.google.android.libraries.navigation.internal.abh.a {
    protected ad(View view, View view2, View view3, Executor executor, id idVar) {
        super(view, view2, executor, idVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.a
    protected final void d(final Bitmap bitmap, final ch chVar) {
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abl.ac
            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmap2 = bitmap;
                Canvas canvas = new Canvas(bitmap2);
                ad adVar = this.a;
                adVar.a.draw(canvas);
                adVar.a(bitmap2);
                ad.b(chVar, bitmap2);
            }
        });
    }
}
