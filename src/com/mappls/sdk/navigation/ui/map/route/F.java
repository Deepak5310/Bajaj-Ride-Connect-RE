package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.FeatureCollection;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class F implements Runnable {
    public final /* synthetic */ D a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ G c;

    public F(G g, D d, ArrayList arrayList) {
        this.c = g;
        this.a = d;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.d.get()) {
            return;
        }
        D d = this.a;
        ArrayList arrayList = this.b;
        z zVar = ((s) d).a;
        zVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList2.addAll(((FeatureCollection) arrayList.get(size)).features());
        }
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(arrayList2);
        zVar.x = featureCollectionFromFeatures;
        zVar.t.setGeoJson(featureCollectionFromFeatures);
    }
}
