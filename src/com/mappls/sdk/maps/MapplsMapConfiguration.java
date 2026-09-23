package com.mappls.sdk.maps;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsMapConfiguration {
    private static final MapplsMapConfiguration OUR_INSTANCE = new MapplsMapConfiguration();
    private boolean isShowLastSelectedStyle = true;
    private boolean usingRasterStyle = false;
    private boolean allowOtherUrls = false;
    private boolean developerShowingSplash = false;
    private boolean isEnablePromotion = false;
    private boolean isMapReinitEnable = false;

    public static MapplsMapConfiguration getInstance() {
        return OUR_INSTANCE;
    }

    public boolean isShowLastSelectedStyle() {
        return this.isShowLastSelectedStyle;
    }

    public void setShowLastSelectedStyle(boolean z) {
        this.isShowLastSelectedStyle = z;
    }

    public boolean isUsingRasterStyle() {
        return this.usingRasterStyle;
    }

    public void setUsingRasterStyle(boolean z) {
        this.usingRasterStyle = z;
    }

    public boolean isAllowOtherUrls() {
        return this.allowOtherUrls;
    }

    public void setAllowOtherUrls(boolean z) {
        this.allowOtherUrls = z;
    }

    public boolean isDeveloperShowingSplash() {
        return this.developerShowingSplash;
    }

    public void setDeveloperShowingSplash(boolean z) {
        this.developerShowingSplash = z;
    }

    public boolean isEnablePromotion() {
        return this.isEnablePromotion;
    }

    public void setEnablePromotion(boolean z) {
        this.isEnablePromotion = z;
    }

    public boolean isMapReinitEnable() {
        return this.isMapReinitEnable;
    }

    public void setReinitEnable(boolean z) {
        this.isMapReinitEnable = z;
    }
}
