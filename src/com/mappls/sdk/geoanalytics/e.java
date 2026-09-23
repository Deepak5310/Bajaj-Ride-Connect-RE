package com.mappls.sdk.geoanalytics;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import com.mappls.sdk.maps.MapView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class e extends AsyncTask<Void, Void, HashMap<String, Bitmap>> {
    private final HashMap<String, View> a = new HashMap<>();
    private final WeakReference<g> b;
    private final View c;
    private MapView d;

    e(g gVar, MapView mapView, View view) {
        this.b = new WeakReference<>(gVar);
        this.d = mapView;
        this.c = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Bitmap> doInBackground(Void... voidArr) {
        if (this.b.get() == null) {
            return null;
        }
        HashMap<String, Bitmap> map = new HashMap<>();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.c.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        map.put("custom_info", i.a(this.c));
        this.a.put("custom_info", this.c);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(HashMap<String, Bitmap> map) {
        super.onPostExecute(map);
        g gVar = this.b.get();
        if (gVar == null || map == null) {
            return;
        }
        gVar.a(map);
        gVar.c();
    }
}
