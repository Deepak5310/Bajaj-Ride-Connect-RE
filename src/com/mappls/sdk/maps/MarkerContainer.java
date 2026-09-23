package com.mappls.sdk.maps;

import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.mappls.sdk.maps.annotations.Annotation;
import com.mappls.sdk.maps.annotations.BaseMarkerOptions;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class MarkerContainer implements Markers {
    private final LongSparseArray<Annotation> annotations;
    private final IconManager iconManager;
    private final NativeMap nativeMapView;
    private final LongSparseArray<LatLng> positions;

    MarkerContainer(NativeMap nativeMap, LongSparseArray<Annotation> longSparseArray, IconManager iconManager, LongSparseArray<LatLng> longSparseArray2) {
        this.nativeMapView = nativeMap;
        this.annotations = longSparseArray;
        this.iconManager = iconManager;
        this.positions = longSparseArray2;
    }

    @Override // com.mappls.sdk.maps.Markers
    public Marker addBy(BaseMarkerOptions baseMarkerOptions, final MapplsMap mapplsMap, final MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        final Marker markerPrepareMarker = prepareMarker(baseMarkerOptions);
        if (markerPrepareMarker.getMapplsPin() != null && markerPrepareMarker.getPosition() == null) {
            MapplsPinHelper.getInstance().getAnnotation(markerPrepareMarker.getMapplsPin(), new CoordinateCallback() { // from class: com.mappls.sdk.maps.MarkerContainer.1
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                    MapplsMap.OnMarkerAddedListener onMarkerAddedListener2 = onMarkerAddedListener;
                    if (onMarkerAddedListener2 != null) {
                        onMarkerAddedListener2.onFailure();
                    }
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list) {
                    if (list.size() > 0) {
                        markerPrepareMarker.setPosition(new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue()));
                        MarkerContainer.this.addMarker(markerPrepareMarker, mapplsMap);
                        if (onMarkerAddedListener != null) {
                            if (MarkerContainer.this.nativeMapView != null) {
                                onMarkerAddedListener.onSuccess();
                                return;
                            } else {
                                onMarkerAddedListener.onFailure();
                                return;
                            }
                        }
                        return;
                    }
                    MapplsMap.OnMarkerAddedListener onMarkerAddedListener2 = onMarkerAddedListener;
                    if (onMarkerAddedListener2 != null) {
                        onMarkerAddedListener2.onFailure();
                    }
                }
            });
        } else {
            addMarker(markerPrepareMarker, mapplsMap);
            if (onMarkerAddedListener != null) {
                if (this.nativeMapView != null) {
                    onMarkerAddedListener.onSuccess();
                } else {
                    onMarkerAddedListener.onFailure();
                }
            }
        }
        return markerPrepareMarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMarker(Marker marker, MapplsMap mapplsMap) {
        NativeMap nativeMap = this.nativeMapView;
        long jAddMarker = nativeMap != null ? nativeMap.addMarker(marker) : 0L;
        marker.setMapplsMap(mapplsMap);
        marker.setId(jAddMarker);
        this.annotations.put(jAddMarker, marker);
        this.positions.put(jAddMarker, marker.getPosition());
        if (marker.getMapplsPin() != null) {
            marker.setPosition(null);
        }
    }

    @Override // com.mappls.sdk.maps.Markers
    public List<Marker> addBy(List<? extends BaseMarkerOptions> list, final MapplsMap mapplsMap, final MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        int size = list.size();
        final ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList();
        final HashMap map = new HashMap();
        if (this.nativeMapView != null && size > 0) {
            for (int i = 0; i < size; i++) {
                Marker markerPrepareMarker = prepareMarker(list.get(i));
                if (markerPrepareMarker.getMapplsPin() != null && markerPrepareMarker.getPosition() == null) {
                    arrayList2.add(markerPrepareMarker.getMapplsPin());
                    map.put(markerPrepareMarker.getMapplsPin().toUpperCase(), markerPrepareMarker);
                }
                arrayList.add(markerPrepareMarker);
            }
            if (arrayList2.size() > 0) {
                MapplsPinHelper.getInstance().getAnnotation(arrayList2, new CoordinateCallback() { // from class: com.mappls.sdk.maps.MarkerContainer.2
                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void coordinateResultSuccess(List<CoordinateResult> list2) {
                        if (list2.size() <= 0) {
                            MarkerContainer.this.removeInvalidMarkers(arrayList);
                            MarkerContainer.this.addMarkers(arrayList, mapplsMap);
                            MapplsMap.OnMarkerAddedListener onMarkerAddedListener2 = onMarkerAddedListener;
                            if (onMarkerAddedListener2 != null) {
                                onMarkerAddedListener2.onFailure();
                                return;
                            }
                            return;
                        }
                        for (CoordinateResult coordinateResult : list2) {
                            if (map.containsKey(coordinateResult.getMapplsPin().toUpperCase())) {
                                ((Marker) map.get(coordinateResult.getMapplsPin().toUpperCase())).setPosition(new LatLng(coordinateResult.getLatitude().doubleValue(), coordinateResult.getLongitude().doubleValue()));
                            }
                        }
                        MarkerContainer.this.removeInvalidMarkers(arrayList);
                        MarkerContainer.this.addMarkers(arrayList, mapplsMap);
                        MapplsMap.OnMarkerAddedListener onMarkerAddedListener3 = onMarkerAddedListener;
                        if (onMarkerAddedListener3 != null) {
                            onMarkerAddedListener3.onSuccess();
                        }
                    }

                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void onFailure() {
                        MarkerContainer.this.removeInvalidMarkers(arrayList);
                        MarkerContainer.this.addMarkers(arrayList, mapplsMap);
                        MapplsMap.OnMarkerAddedListener onMarkerAddedListener2 = onMarkerAddedListener;
                        if (onMarkerAddedListener2 != null) {
                            onMarkerAddedListener2.onFailure();
                        }
                    }
                });
            } else {
                addMarkers(arrayList, mapplsMap);
                if (onMarkerAddedListener != null) {
                    onMarkerAddedListener.onSuccess();
                }
            }
        } else if (onMarkerAddedListener != null) {
            onMarkerAddedListener.onFailure();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeInvalidMarkers(List<Marker> list) {
        ArrayList arrayList = new ArrayList();
        for (Marker marker : list) {
            if (marker.getPosition() != null) {
                arrayList.add(marker);
            }
        }
        list.clear();
        list.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMarkers(List<Marker> list, MapplsMap mapplsMap) {
        if (list.size() > 0) {
            long[] jArrAddMarkers = this.nativeMapView.addMarkers(list);
            for (int i = 0; i < jArrAddMarkers.length; i++) {
                Marker marker = list.get(i);
                marker.setMapplsMap(mapplsMap);
                marker.setId(jArrAddMarkers[i]);
                this.positions.put(jArrAddMarkers[i], marker.getPosition());
                if (marker.getMapplsPin() != null) {
                    marker.setPosition(null);
                }
                this.annotations.put(jArrAddMarkers[i], marker);
            }
        }
    }

    @Override // com.mappls.sdk.maps.Markers
    public void update(final Marker marker, MapplsMap mapplsMap, final MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        ensureIconLoaded(marker, mapplsMap);
        if (marker.getMapplsPin() != null) {
            MapplsPinHelper.getInstance().getAnnotation(marker.getMapplsPin(), new CoordinateCallback() { // from class: com.mappls.sdk.maps.MarkerContainer.3
                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void coordinateResultSuccess(List<CoordinateResult> list) {
                    if (list.size() > 0) {
                        marker.updatePosition(new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue()));
                        MarkerContainer.this.nativeMapView.updateMarker(marker);
                        MarkerContainer.this.annotations.setValueAt(MarkerContainer.this.annotations.indexOfKey(marker.getId()), marker);
                        MarkerContainer.this.positions.setValueAt(MarkerContainer.this.positions.indexOfKey(marker.getId()), marker.getPosition());
                        marker.setPosition(null);
                        MapplsMap.OnMarkerAddedListener onMarkerAddedListener2 = onMarkerAddedListener;
                        if (onMarkerAddedListener2 != null) {
                            onMarkerAddedListener2.onSuccess();
                            return;
                        }
                        return;
                    }
                    MapplsMap.OnMarkerAddedListener onMarkerAddedListener3 = onMarkerAddedListener;
                    if (onMarkerAddedListener3 != null) {
                        onMarkerAddedListener3.onFailure();
                    }
                }

                @Override // com.mappls.sdk.maps.CoordinateCallback
                public void onFailure() {
                    MapplsMap.OnMarkerAddedListener onMarkerAddedListener2 = onMarkerAddedListener;
                    if (onMarkerAddedListener2 != null) {
                        onMarkerAddedListener2.onFailure();
                    }
                }
            });
            return;
        }
        this.nativeMapView.updateMarker(marker);
        LongSparseArray<Annotation> longSparseArray = this.annotations;
        longSparseArray.setValueAt(longSparseArray.indexOfKey(marker.getId()), marker);
        LongSparseArray<LatLng> longSparseArray2 = this.positions;
        longSparseArray2.setValueAt(longSparseArray2.indexOfKey(marker.getId()), marker.getPosition());
        if (onMarkerAddedListener != null) {
            onMarkerAddedListener.onSuccess();
        }
    }

    @Override // com.mappls.sdk.maps.Markers
    public List<Marker> obtainAll() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            Annotation annotation = longSparseArray.get(longSparseArray.keyAt(i));
            if (annotation instanceof Marker) {
                arrayList.add((Marker) annotation);
            }
        }
        return arrayList;
    }

    @Override // com.mappls.sdk.maps.Markers
    public List<Marker> obtainAllIn(RectF rectF) {
        long[] jArrQueryPointAnnotations = this.nativeMapView.queryPointAnnotations(this.nativeMapView.getDensityDependantRectangle(rectF));
        ArrayList arrayList = new ArrayList(jArrQueryPointAnnotations.length);
        for (long j : jArrQueryPointAnnotations) {
            arrayList.add(Long.valueOf(j));
        }
        ArrayList arrayList2 = new ArrayList(jArrQueryPointAnnotations.length);
        List<Annotation> listObtainAnnotations = obtainAnnotations();
        int size = listObtainAnnotations.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = listObtainAnnotations.get(i);
            if ((annotation instanceof Marker) && arrayList.contains(Long.valueOf(annotation.getId()))) {
                arrayList2.add((Marker) annotation);
            }
        }
        return new ArrayList(arrayList2);
    }

    @Override // com.mappls.sdk.maps.Markers
    public void reload() {
        this.iconManager.reloadIcons();
        int size = this.annotations.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = this.annotations.get(i);
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                this.nativeMapView.removeAnnotation(annotation.getId());
                marker.setId(this.nativeMapView.addMarker(marker));
            }
        }
    }

    private Marker prepareMarker(BaseMarkerOptions baseMarkerOptions) {
        Marker marker = baseMarkerOptions.getMarker();
        marker.setTopOffsetPixels(this.iconManager.getTopOffsetPixelsForIcon(this.iconManager.loadIconForMarker(marker)));
        return marker;
    }

    private void ensureIconLoaded(Marker marker, MapplsMap mapplsMap) {
        this.iconManager.ensureIconLoaded(marker, mapplsMap);
    }

    private List<Annotation> obtainAnnotations() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.annotations.size(); i++) {
            LongSparseArray<Annotation> longSparseArray = this.annotations;
            arrayList.add(longSparseArray.get(longSparseArray.keyAt(i)));
        }
        return arrayList;
    }
}
