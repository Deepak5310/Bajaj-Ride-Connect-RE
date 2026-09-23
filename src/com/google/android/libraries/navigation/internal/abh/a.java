package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements gv {
    public final View a;
    public final Executor b;
    private final View c;
    private final id d;

    protected a(View view, View view2, Executor executor, id idVar) {
        this.a = view;
        this.c = view2;
        this.b = executor;
        this.d = idVar;
    }

    public static final void b(com.google.android.libraries.navigation.internal.ly.ch chVar, Bitmap bitmap) {
        try {
            ((com.google.android.gms.maps.o) chVar).a.onSnapshotReady((Bitmap) com.google.android.libraries.navigation.internal.lo.n.b(new com.google.android.libraries.navigation.internal.lo.n(bitmap)));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void a(Bitmap bitmap) {
        com.google.android.libraries.navigation.internal.afu.d.a.a().N();
        this.c.draw(new Canvas(bitmap));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.gv
    public final synchronized void c(Bitmap bitmap, com.google.android.libraries.navigation.internal.ly.ch chVar) {
        View view = this.a;
        int width = view.getWidth();
        int height = view.getHeight();
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        } else if (bitmap.getWidth() != width || bitmap.getHeight() != height) {
            com.google.android.libraries.navigation.internal.abf.p.a(5, "The Bitmap provided in the snapshot() method does not match the map's dimensions, hence another Bitmap is allocated with the right dimensions. If you think this is due to the fact that the map was resized, you can ignore this message. Otherwise, you should check the dimensions of the Bitmap passed to the method.", new Object[0]);
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        d(bitmap, chVar);
    }

    protected abstract void d(Bitmap bitmap, com.google.android.libraries.navigation.internal.ly.ch chVar);
}
