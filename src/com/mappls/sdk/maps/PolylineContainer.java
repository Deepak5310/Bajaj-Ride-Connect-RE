package com.mappls.sdk.maps;

import androidx.collection.LongSparseArray;
import com.mappls.sdk.maps.annotations.Annotation;
import com.mappls.sdk.maps.annotations.Polyline;
import com.mappls.sdk.maps.annotations.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class PolylineContainer implements Polylines {
    private final LongSparseArray<Annotation> annotations;
    private final NativeMap nativeMap;

    PolylineContainer(NativeMap nativeMap, LongSparseArray<Annotation> longSparseArray) {
        this.nativeMap = nativeMap;
        this.annotations = longSparseArray;
    }

    @Override // com.mappls.sdk.maps.Polylines
    public Polyline addBy(PolylineOptions polylineOptions, MapplsMap mapplsMap) {
        Polyline polyline = polylineOptions.getPolyline();
        if (!polyline.getPoints().isEmpty()) {
            NativeMap nativeMap = this.nativeMap;
            long jAddPolyline = nativeMap != null ? nativeMap.addPolyline(polyline) : 0L;
            polyline.setMapplsMap(mapplsMap);
            polyline.setId(jAddPolyline);
            this.annotations.put(jAddPolyline, polyline);
        }
        return polyline;
    }

    @Override // com.mappls.sdk.maps.Polylines
    public List<Polyline> addBy(List<PolylineOptions> list, MapplsMap mapplsMap) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (this.nativeMap != null && size > 0) {
            Iterator<PolylineOptions> it2 = list.iterator();
            while (it2.hasNext()) {
                Polyline polyline = it2.next().getPolyline();
                if (!polyline.getPoints().isEmpty()) {
                    arrayList.add(polyline);
                }
            }
            long[] jArrAddPolylines = this.nativeMap.addPolylines(arrayList);
            for (int i = 0; i < jArrAddPolylines.length; i++) {
                Polyline polyline2 = (Polyline) arrayList.get(i);
                polyline2.setMapplsMap(mapplsMap);
                polyline2.setId(jArrAddPolylines[i]);
                this.annotations.put(jArrAddPolylines[i], polyline2);
            }
        }
        return arrayList;
    }

    @Override // com.mappls.sdk.maps.Polylines
    public void update(Polyline polyline) {
        this.nativeMap.updatePolyline(polyline);
        LongSparseArray<Annotation> longSparseArray = this.annotations;
        longSparseArray.setValueAt(longSparseArray.indexOfKey(polyline.getId()), polyline);
    }

    @Override // com.mappls.sdk.maps.Polylines
    public List<Polyline> obtainAll() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            Annotation annotation = longSparseArray.get(longSparseArray.keyAt(i));
            if (annotation instanceof Polyline) {
                arrayList.add((Polyline) annotation);
            }
        }
        return arrayList;
    }
}
