package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class da {
    private static final String c = "da";
    public final com.google.android.libraries.navigation.internal.abf.z a;
    public com.google.android.libraries.navigation.internal.ly.m b;
    private final ViewGroup d;
    private final cz e;

    public da(com.google.android.libraries.navigation.internal.abf.z zVar, ViewGroup viewGroup, cz czVar) {
        this.a = zVar;
        this.d = viewGroup;
        this.e = czVar;
    }

    public final Bitmap a(es esVar, int i, int i2) {
        View viewB = b(esVar);
        if (viewB == null) {
            return null;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        viewB.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredWidth = viewB.getMeasuredWidth();
        int measuredHeight = viewB.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            com.google.android.libraries.navigation.internal.abf.p.f(c, 5);
            return null;
        }
        viewB.layout(0, 0, measuredWidth, measuredHeight);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setDensity(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.setDensity(0);
        viewB.draw(canvas);
        return bitmapCreateBitmap;
    }

    public final View b(es esVar) {
        try {
            com.google.android.libraries.navigation.internal.ly.m mVar = this.b;
            View view = mVar != null ? (View) com.google.android.libraries.navigation.internal.lo.n.b(new com.google.android.libraries.navigation.internal.lo.n(((com.google.android.gms.maps.e) mVar).a.getInfoWindow(new Marker(esVar)))) : null;
            if (view != null) {
                return view;
            }
            try {
                com.google.android.libraries.navigation.internal.ly.m mVar2 = this.b;
                View view2 = mVar2 != null ? (View) com.google.android.libraries.navigation.internal.lo.n.b(new com.google.android.libraries.navigation.internal.lo.n(((com.google.android.gms.maps.e) mVar2).a.getInfoContents(new Marker(esVar)))) : null;
                if (view2 == null) {
                    if (com.google.android.libraries.navigation.internal.abf.x.a(esVar.j())) {
                        return null;
                    }
                    cz czVar = this.e;
                    String strJ = esVar.j();
                    czVar.a.setText(strJ);
                    czVar.a.setVisibility(strJ != null ? 0 : 8);
                    cz czVar2 = this.e;
                    String strI = esVar.i();
                    czVar2.b.setText(strI);
                    czVar2.b.setVisibility(strI == null ? 8 : 0);
                    view2 = this.e;
                }
                this.d.removeAllViews();
                this.d.addView(view2);
                return this.d;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
