package com.mappls.sdk.navigation.ui.map.route;

import android.os.Handler;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class G extends Thread {
    public final int a;
    public final ArrayList b;
    public final WeakReference c;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final Handler e;

    public G(int i, ArrayList arrayList, s sVar, Handler handler) {
        this.a = i;
        this.b = arrayList;
        this.c = new WeakReference(sVar);
        this.e = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        FeatureCollection featureCollection;
        List<Feature> listFeatures;
        D d;
        ArrayList<FeatureCollection> arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty() || this.d.get() || (listFeatures = (featureCollection = (FeatureCollection) arrayList.remove(this.a)).features()) == null || listFeatures.isEmpty()) {
            return;
        }
        for (Feature feature : listFeatures) {
            if (this.d.get()) {
                return;
            } else {
                feature.addBooleanProperty("primary-route", Boolean.TRUE);
            }
        }
        for (FeatureCollection featureCollection2 : arrayList) {
            if (this.d.get()) {
                return;
            }
            List<Feature> listFeatures2 = featureCollection2.features();
            if (listFeatures2 != null && !listFeatures2.isEmpty()) {
                for (Feature feature2 : listFeatures2) {
                    if (this.d.get()) {
                        return;
                    } else {
                        feature2.addBooleanProperty("primary-route", Boolean.FALSE);
                    }
                }
            }
        }
        if (this.d.get()) {
            return;
        }
        arrayList.add(0, featureCollection);
        if (this.d.get() || (d = (D) this.c.get()) == null) {
            return;
        }
        this.e.post(new F(this, d, arrayList));
    }
}
