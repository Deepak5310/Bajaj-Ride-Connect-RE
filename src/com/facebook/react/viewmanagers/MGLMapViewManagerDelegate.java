package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.MGLMapViewManagerInterface;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class MGLMapViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & MGLMapViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public MGLMapViewManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1886632150:
                if (str.equals("preferredFramesPerSecond")) {
                    b = 0;
                }
                break;
            case -1849628684:
                if (str.equals("logoPosition")) {
                    b = 1;
                }
                break;
            case -1741886763:
                if (str.equals("layerControlEnabled")) {
                    b = 2;
                }
                break;
            case -1734653664:
                if (str.equals("compassViewPosition")) {
                    b = 3;
                }
                break;
            case -1663040992:
                if (str.equals("anchorRotateOrZoomGesturesToCenter")) {
                    b = 4;
                }
                break;
            case -1375324191:
                if (str.equals("pitchEnabled")) {
                    b = 5;
                }
                break;
            case -1286103352:
                if (str.equals("attributionPosition")) {
                    b = 6;
                }
                break;
            case -1198970156:
                if (str.equals("enableTrafficFreeFlow")) {
                    b = 7;
                }
                break;
            case -1161021981:
                if (str.equals("eventPosition")) {
                    b = 8;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    b = 9;
                }
                break;
            case -1040869018:
                if (str.equals("rotateEnabled")) {
                    b = 10;
                }
                break;
            case -551362712:
                if (str.equals("localizeLabels")) {
                    b = Ascii.VT;
                }
                break;
            case 52161274:
                if (str.equals("enableTraffic")) {
                    b = Ascii.FF;
                }
                break;
            case 97526796:
                if (str.equals(PlaceTypes.FLOOR)) {
                    b = Ascii.CR;
                }
                break;
            case 105344463:
                if (str.equals("compassEnabled")) {
                    b = Ascii.SO;
                }
                break;
            case 431645773:
                if (str.equals("enableTrafficNonFreeFlow")) {
                    b = Ascii.SI;
                }
                break;
            case 481961390:
                if (str.equals("compassViewMargins")) {
                    b = Ascii.DLE;
                }
                break;
            case 811343908:
                if (str.equals("contentInset")) {
                    b = 17;
                }
                break;
            case 877513185:
                if (str.equals("enableTrafficClosure")) {
                    b = Ascii.DC2;
                }
                break;
            case 900629988:
                if (str.equals("logoClickEnabled")) {
                    b = 19;
                }
                break;
            case 941698069:
                if (str.equals("layerControlPosition")) {
                    b = Ascii.DC4;
                }
                break;
            case 1372837314:
                if (str.equals("attributionEnabled")) {
                    b = Ascii.NAK;
                }
                break;
            case 1607378774:
                if (str.equals("mapplsStyle")) {
                    b = Ascii.SYN;
                }
                break;
            case 1755945966:
                if (str.equals("zoomEnabled")) {
                    b = Ascii.ETB;
                }
                break;
            case 1908848406:
                if (str.equals("logoEnabled")) {
                    b = Ascii.CAN;
                }
                break;
            case 1955062966:
                if (str.equals("enableGeoAnalyticsInfoWindow")) {
                    b = Ascii.EM;
                }
                break;
            case 1997898238:
                if (str.equals("styleURL")) {
                    b = Ascii.SUB;
                }
                break;
            case 2054266037:
                if (str.equals("enableTrafficStopIcon")) {
                    b = Ascii.ESC;
                }
                break;
        }
        switch (b) {
            case 0:
                ((MGLMapViewManagerInterface) this.mViewManager).setPreferredFramesPerSecond(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                ((MGLMapViewManagerInterface) this.mViewManager).setLogoPosition(t, (ReadableMap) obj);
                break;
            case 2:
                ((MGLMapViewManagerInterface) this.mViewManager).setLayerControlEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((MGLMapViewManagerInterface) this.mViewManager).setCompassViewPosition(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 4:
                ((MGLMapViewManagerInterface) this.mViewManager).setAnchorRotateOrZoomGesturesToCenter(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((MGLMapViewManagerInterface) this.mViewManager).setPitchEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((MGLMapViewManagerInterface) this.mViewManager).setAttributionPosition(t, (ReadableMap) obj);
                break;
            case 7:
                ((MGLMapViewManagerInterface) this.mViewManager).setEnableTrafficFreeFlow(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 8:
                ((MGLMapViewManagerInterface) this.mViewManager).setEventPosition(t, (ReadableMap) obj);
                break;
            case 9:
                ((MGLMapViewManagerInterface) this.mViewManager).setScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((MGLMapViewManagerInterface) this.mViewManager).setRotateEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 11:
                ((MGLMapViewManagerInterface) this.mViewManager).setLocalizeLabels(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 12:
                ((MGLMapViewManagerInterface) this.mViewManager).setEnableTraffic(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((MGLMapViewManagerInterface) this.mViewManager).setFloor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 14:
                ((MGLMapViewManagerInterface) this.mViewManager).setCompassEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 15:
                ((MGLMapViewManagerInterface) this.mViewManager).setEnableTrafficNonFreeFlow(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 16:
                ((MGLMapViewManagerInterface) this.mViewManager).setCompassViewMargins(t, (ReadableMap) obj);
                break;
            case 17:
                ((MGLMapViewManagerInterface) this.mViewManager).setContentInset(t, (ReadableArray) obj);
                break;
            case 18:
                ((MGLMapViewManagerInterface) this.mViewManager).setEnableTrafficClosure(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 19:
                ((MGLMapViewManagerInterface) this.mViewManager).setLogoClickEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 20:
                ((MGLMapViewManagerInterface) this.mViewManager).setLayerControlPosition(t, (ReadableMap) obj);
                break;
            case 21:
                ((MGLMapViewManagerInterface) this.mViewManager).setAttributionEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 22:
                ((MGLMapViewManagerInterface) this.mViewManager).setMapplsStyle(t, obj != null ? (String) obj : null);
                break;
            case 23:
                ((MGLMapViewManagerInterface) this.mViewManager).setZoomEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 24:
                ((MGLMapViewManagerInterface) this.mViewManager).setLogoEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 25:
                ((MGLMapViewManagerInterface) this.mViewManager).setEnableGeoAnalyticsInfoWindow(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((MGLMapViewManagerInterface) this.mViewManager).setStyleURL(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((MGLMapViewManagerInterface) this.mViewManager).setEnableTrafficStopIcon(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
