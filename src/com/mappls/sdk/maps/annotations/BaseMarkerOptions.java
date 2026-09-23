package com.mappls.sdk.maps.annotations;

import android.os.Parcelable;
import com.mappls.sdk.maps.annotations.BaseMarkerOptions;
import com.mappls.sdk.maps.annotations.Marker;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class BaseMarkerOptions<U extends Marker, T extends BaseMarkerOptions<U, T>> implements Parcelable {
    protected Icon icon;
    protected String mapplsPin;
    protected LatLng position;
    protected String snippet;
    protected String title;

    public abstract U getMarker();

    public abstract T getThis();

    public T position(LatLng latLng) {
        this.mapplsPin = null;
        this.position = latLng;
        return (T) getThis();
    }

    public T snippet(String str) {
        this.snippet = str;
        return (T) getThis();
    }

    public T mapplsPin(String str) {
        this.position = null;
        this.mapplsPin = str.toUpperCase();
        return (T) getThis();
    }

    public T title(String str) {
        this.title = str;
        return (T) getThis();
    }

    public T icon(Icon icon) {
        this.icon = icon;
        return (T) getThis();
    }

    public T setIcon(Icon icon) {
        return (T) icon(icon);
    }

    public T setPosition(LatLng latLng) {
        return (T) position(latLng);
    }

    public T setMapplsPin(String str) {
        return (T) mapplsPin(str);
    }

    public T setSnippet(String str) {
        return (T) snippet(str);
    }

    public T setTitle(String str) {
        return (T) title(str);
    }
}
