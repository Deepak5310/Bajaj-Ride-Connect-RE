package com.mappls.sdk.maps;

import android.graphics.Bitmap;
import com.mappls.sdk.maps.annotations.Icon;
import com.mappls.sdk.maps.annotations.IconFactory;
import com.mappls.sdk.maps.annotations.Marker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class IconManager {
    private int highestIconHeight;
    private int highestIconWidth;
    private final Map<Icon, Integer> iconMap = new HashMap();
    private NativeMap nativeMap;

    IconManager(NativeMap nativeMap) {
        this.nativeMap = nativeMap;
    }

    Icon loadIconForMarker(Marker marker) {
        Icon icon = marker.getIcon();
        if (icon == null) {
            icon = loadDefaultIconForMarker(marker);
        } else {
            updateHighestIconSize(icon);
        }
        addIcon(icon);
        return icon;
    }

    int getTopOffsetPixelsForIcon(Icon icon) {
        return (int) (this.nativeMap.getTopOffsetPixelsForAnnotationSymbol(icon.getId()) * ((double) this.nativeMap.getPixelRatio()));
    }

    int getHighestIconWidth() {
        return this.highestIconWidth;
    }

    int getHighestIconHeight() {
        return this.highestIconHeight;
    }

    private Icon loadDefaultIconForMarker(Marker marker) {
        Icon iconDefaultMarker = IconFactory.getInstance(Mappls.getApplicationContext()).defaultMarker();
        Bitmap bitmap = iconDefaultMarker.getBitmap();
        updateHighestIconSize(bitmap.getWidth(), bitmap.getHeight() / 2);
        marker.setIcon(iconDefaultMarker);
        return iconDefaultMarker;
    }

    private void addIcon(Icon icon) {
        addIcon(icon, true);
    }

    private void addIcon(Icon icon, boolean z) {
        if (!this.iconMap.keySet().contains(icon)) {
            this.iconMap.put(icon, 1);
            if (z) {
                loadIcon(icon);
                return;
            }
            return;
        }
        Map<Icon, Integer> map = this.iconMap;
        map.put(icon, Integer.valueOf(map.get(icon).intValue() + 1));
    }

    private void updateHighestIconSize(Icon icon) {
        updateHighestIconSize(icon.getBitmap());
    }

    private void updateHighestIconSize(Bitmap bitmap) {
        updateHighestIconSize(bitmap.getWidth(), bitmap.getHeight());
    }

    private void updateHighestIconSize(int i, int i2) {
        if (i > this.highestIconWidth) {
            this.highestIconWidth = i;
        }
        if (i2 > this.highestIconHeight) {
            this.highestIconHeight = i2;
        }
    }

    private void loadIcon(Icon icon) {
        Bitmap bitmap = icon.getBitmap();
        this.nativeMap.addAnnotationIcon(icon.getId(), bitmap.getWidth(), bitmap.getHeight(), icon.getScale(), icon.toBytes());
    }

    void reloadIcons() {
        Iterator<Icon> it2 = this.iconMap.keySet().iterator();
        while (it2.hasNext()) {
            loadIcon(it2.next());
        }
    }

    void ensureIconLoaded(Marker marker, MapplsMap mapplsMap) {
        Icon icon = marker.getIcon();
        if (icon == null) {
            icon = loadDefaultIconForMarker(marker);
        }
        addIcon(icon);
        setTopOffsetPixels(marker, mapplsMap, icon);
    }

    private void setTopOffsetPixels(Marker marker, MapplsMap mapplsMap, Icon icon) {
        Marker marker2 = marker.getId() != -1 ? (Marker) mapplsMap.getAnnotation(marker.getId()) : null;
        if (marker2 == null || marker2.getIcon() == null || marker2.getIcon() != marker.getIcon()) {
            marker.setTopOffsetPixels(getTopOffsetPixelsForIcon(icon));
        }
    }

    void iconCleanup(Icon icon) {
        Integer num = this.iconMap.get(icon);
        if (num != null) {
            int iIntValue = num.intValue() - 1;
            Integer numValueOf = Integer.valueOf(iIntValue);
            numValueOf.getClass();
            if (iIntValue == 0) {
                remove(icon);
            } else {
                numValueOf.getClass();
                updateIconRefCounter(icon, iIntValue);
            }
        }
    }

    private void remove(Icon icon) {
        this.nativeMap.removeAnnotationIcon(icon.getId());
        this.iconMap.remove(icon);
    }

    private void updateIconRefCounter(Icon icon, int i) {
        this.iconMap.put(icon, Integer.valueOf(i));
    }
}
