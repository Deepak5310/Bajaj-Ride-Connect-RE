package com.mappls.sdk.maps;

import androidx.collection.LongSparseArray;
import com.mappls.sdk.maps.annotations.Annotation;
import com.mappls.sdk.maps.annotations.Polygon;
import com.mappls.sdk.maps.annotations.PolygonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class PolygonContainer implements Polygons {
    private final LongSparseArray<Annotation> annotations;
    private final NativeMap nativeMap;

    PolygonContainer(NativeMap nativeMap, LongSparseArray<Annotation> longSparseArray) {
        this.nativeMap = nativeMap;
        this.annotations = longSparseArray;
    }

    @Override // com.mappls.sdk.maps.Polygons
    public Polygon addBy(PolygonOptions polygonOptions, MapplsMap mapplsMap) {
        Polygon polygon = polygonOptions.getPolygon();
        if (!polygon.getPoints().isEmpty()) {
            NativeMap nativeMap = this.nativeMap;
            long jAddPolygon = nativeMap != null ? nativeMap.addPolygon(polygon) : 0L;
            polygon.setId(jAddPolygon);
            polygon.setMapplsMap(mapplsMap);
            this.annotations.put(jAddPolygon, polygon);
        }
        return polygon;
    }

    @Override // com.mappls.sdk.maps.Polygons
    public List<Polygon> addBy(List<PolygonOptions> list, MapplsMap mapplsMap) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (this.nativeMap != null && size > 0) {
            Iterator<PolygonOptions> it2 = list.iterator();
            while (it2.hasNext()) {
                Polygon polygon = it2.next().getPolygon();
                if (!polygon.getPoints().isEmpty()) {
                    arrayList.add(polygon);
                }
            }
            long[] jArrAddPolygons = this.nativeMap.addPolygons(arrayList);
            for (int i = 0; i < jArrAddPolygons.length; i++) {
                Polygon polygon2 = (Polygon) arrayList.get(i);
                polygon2.setMapplsMap(mapplsMap);
                polygon2.setId(jArrAddPolygons[i]);
                this.annotations.put(jArrAddPolygons[i], polygon2);
            }
        }
        return arrayList;
    }

    @Override // com.mappls.sdk.maps.Polygons
    public void update(Polygon polygon) {
        this.nativeMap.updatePolygon(polygon);
        LongSparseArray<Annotation> longSparseArray = this.annotations;
        longSparseArray.setValueAt(longSparseArray.indexOfKey(polygon.getId()), polygon);
    }

    @Override // com.mappls.sdk.maps.Polygons
    public List<Polygon> obtainAll() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            Annotation annotation = longSparseArray.get(longSparseArray.keyAt(i));
            if (annotation instanceof Polygon) {
                arrayList.add((Polygon) annotation);
            }
        }
        return arrayList;
    }
}
