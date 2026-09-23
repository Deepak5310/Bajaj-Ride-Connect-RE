package com.mappls.sdk.maps.annotations;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class Annotation implements Comparable<Annotation> {
    private long id = -1;
    protected MapView mapView;
    protected MapplsMap mapplsMap;

    protected Annotation() {
    }

    public long getId() {
        return this.id;
    }

    public void remove() {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap == null) {
            return;
        }
        mapplsMap.removeAnnotation(this);
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMapplsMap(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
    }

    protected MapplsMap getMapplsMap() {
        return this.mapplsMap;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    protected MapView getMapView() {
        return this.mapView;
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        if (this.id < annotation.getId()) {
            return 1;
        }
        return this.id > annotation.getId() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof Annotation) && this.id == ((Annotation) obj).getId();
    }

    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
