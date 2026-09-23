package com.mappls.sdk.maps.annotations;

import android.view.View;
import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.maps.CoordinateResult;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.R;
import com.mappls.sdk.maps.geometry.LatLng;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Marker extends Annotation {
    private Icon icon;
    private String iconId;
    private InfoWindow infoWindow;
    private boolean infoWindowShown;
    private String mapplsPin;
    private LatLng position;
    private int rightOffsetPixels;
    private String snippet;
    private String title;
    private int topOffsetPixels;

    Marker() {
    }

    public Marker(BaseMarkerOptions baseMarkerOptions) {
        this(baseMarkerOptions.position, baseMarkerOptions.icon, baseMarkerOptions.title, baseMarkerOptions.snippet, baseMarkerOptions.mapplsPin);
    }

    Marker(LatLng latLng, Icon icon, String str, String str2, String str3) {
        this.position = latLng;
        this.title = str;
        this.snippet = str2;
        this.mapplsPin = str3;
        setIcon(icon);
    }

    public LatLng getPosition() {
        return this.position;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str.toUpperCase();
        if (str != null) {
            this.position = null;
        }
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updateMarker(this);
        }
    }

    public void updatePosition(LatLng latLng) {
        this.position = latLng;
    }

    public void setMapplsPin(String str, MapplsMap.OnMarkerAddedListener onMarkerAddedListener) {
        this.mapplsPin = str.toUpperCase();
        if (str != null) {
            this.position = null;
        }
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updateMarker(this, onMarkerAddedListener);
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void hideInfoWindow() {
        InfoWindow infoWindow = this.infoWindow;
        if (infoWindow != null) {
            infoWindow.close();
        }
        this.infoWindowShown = false;
    }

    public boolean isInfoWindowShown() {
        return this.infoWindowShown;
    }

    public void setPosition(LatLng latLng) {
        this.position = latLng;
        if (latLng != null) {
            this.mapplsPin = null;
        }
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updateMarker(this);
        }
    }

    public void setSnippet(String str) {
        this.snippet = str;
        refreshInfoWindowContent();
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        this.iconId = icon != null ? icon.getId() : null;
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updateMarker(this);
        }
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setTitle(String str) {
        this.title = str;
        refreshInfoWindowContent();
    }

    public InfoWindow getInfoWindow() {
        return this.infoWindow;
    }

    private void refreshInfoWindowContent() {
        if (!isInfoWindowShown() || this.mapView == null || this.mapplsMap == null || this.mapplsMap.getInfoWindowAdapter() != null) {
            return;
        }
        InfoWindow infoWindow = getInfoWindow(this.mapView);
        if (this.mapView.getContext() != null) {
            infoWindow.adaptDefaultMarker(this, this.mapplsMap, this.mapView);
        }
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updateMarker(this);
        }
        infoWindow.onContentUpdate();
    }

    public InfoWindow showInfoWindow(MapplsMap mapplsMap, MapView mapView) {
        View infoWindow;
        setMapplsMap(mapplsMap);
        setMapView(mapView);
        MapplsMap.InfoWindowAdapter infoWindowAdapter = getMapplsMap().getInfoWindowAdapter();
        if (infoWindowAdapter != null && (infoWindow = infoWindowAdapter.getInfoWindow(this)) != null) {
            InfoWindow infoWindow2 = new InfoWindow(infoWindow, mapplsMap);
            this.infoWindow = infoWindow2;
            showInfoWindow(infoWindow2, mapView);
            return this.infoWindow;
        }
        InfoWindow infoWindow3 = getInfoWindow(mapView);
        if (mapView.getContext() != null) {
            infoWindow3.adaptDefaultMarker(this, mapplsMap, mapView);
        }
        return showInfoWindow(infoWindow3, mapView);
    }

    private InfoWindow showInfoWindow(final InfoWindow infoWindow, final MapView mapView) {
        if (this.position == null) {
            try {
                Class<?> cls = Class.forName("com.mappls.sdk.maps.BaseMapplsHelper");
                System.out.println(cls.getName());
                Object objNewInstance = cls.newInstance();
                Method declaredMethod = cls.getDeclaredMethod("getAnnotation", String.class, CoordinateCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(objNewInstance, this.mapplsPin, new CoordinateCallback() { // from class: com.mappls.sdk.maps.annotations.Marker.1
                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void onFailure() {
                    }

                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void coordinateResultSuccess(List<CoordinateResult> list) {
                        if (list.size() > 0) {
                            LatLng latLng = new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue());
                            InfoWindow infoWindow2 = infoWindow;
                            MapView mapView2 = mapView;
                            Marker marker = Marker.this;
                            infoWindow2.open(mapView2, marker, latLng, marker.rightOffsetPixels, Marker.this.topOffsetPixels);
                            Marker.this.infoWindowShown = true;
                        }
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        } else {
            infoWindow.open(mapView, this, getPosition(), this.rightOffsetPixels, this.topOffsetPixels);
            this.infoWindowShown = true;
        }
        return infoWindow;
    }

    private InfoWindow getInfoWindow(MapView mapView) {
        if (this.infoWindow == null && mapView.getContext() != null) {
            this.infoWindow = new InfoWindow(mapView, R.layout.mappls_maps_infowindow_content, getMapplsMap());
        }
        return this.infoWindow;
    }

    public void setTopOffsetPixels(int i) {
        this.topOffsetPixels = i;
    }

    public void setRightOffsetPixels(int i) {
        this.rightOffsetPixels = i;
    }

    public String toString() {
        return "Marker [position[" + getPosition() + "]]";
    }
}
