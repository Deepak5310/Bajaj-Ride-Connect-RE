package com.mappls.sdk.maps;

import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class TrafficPlugin implements MapView.OnDidFinishLoadingStyleListener {
    private static final String CLOSURE_LAYER = "Traffic_closure";
    private static final String NON_FREE_FLOW_LAYER = "Traffic_nonfreeflow";
    private static final String STOP_ICON_LAYER = "Traffic_stopicon";
    private static final String TRAFFIC_FREEFLOW_LAYER = "Traffic_freeflow";
    private static final String TRAFFIC_OTH_1_LAYER = "Traffic_oth1";
    private static final String TRAFFIC_OTH_2_LAYER = "Traffic_oth2";
    private static final String TRAFFIC_OTH_3_LAYER = "Traffic_oth3";
    private static final String TRAFFIC_OTH_4_LAYER = "Traffic_oth4";
    private static final String TRAFFIC_OTH_5_LAYER = "Traffic_oth5";
    private MapplsMap mapplsMap;
    private boolean enable = false;
    private boolean enableNonFreeFlow = true;
    private boolean enableClosure = true;
    private boolean enableStopIcon = true;
    private boolean enableFreeFlow = true;
    private boolean enableOth1 = false;
    private boolean enableOth2 = false;
    private boolean enableOth3 = false;
    private boolean enableOth4 = false;
    private boolean enableOth5 = false;

    public void onStartLoadingMap() {
    }

    TrafficPlugin(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    public boolean isEnableNonFreeFlow() {
        return this.enableNonFreeFlow;
    }

    public void enableNonFreeFlow(boolean z) {
        this.enableNonFreeFlow = z;
        updateState();
    }

    public boolean isEnableClosure() {
        return this.enableClosure;
    }

    public void enableClosure(boolean z) {
        this.enableClosure = z;
        updateState();
    }

    public boolean isEnableStopIcon() {
        return this.enableStopIcon;
    }

    public void enableStopIcon(boolean z) {
        this.enableStopIcon = z;
        updateState();
    }

    public boolean isEnableFreeFlow() {
        return this.enableFreeFlow;
    }

    public void enableFreeFlow(boolean z) {
        this.enableFreeFlow = z;
        updateState();
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
        updateState();
    }

    public boolean isEnableOth1() {
        return this.enableOth1;
    }

    public void enableOth1(boolean z) {
        this.enableOth1 = z;
        updateState();
    }

    public boolean isEnableOth2() {
        return this.enableOth2;
    }

    public void enableOth2(boolean z) {
        this.enableOth2 = z;
        updateState();
    }

    public boolean isEnableOth3() {
        return this.enableOth3;
    }

    public void enableOth3(boolean z) {
        this.enableOth3 = z;
        updateState();
    }

    public boolean isEnableOth4() {
        return this.enableOth4;
    }

    public void enableOth4(boolean z) {
        this.enableOth4 = z;
        updateState();
    }

    public boolean isEnableOth5() {
        return this.enableOth5;
    }

    public void enableOth5(boolean z) {
        this.enableOth5 = z;
        updateState();
    }

    private void updateState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.TrafficPlugin.1
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                TrafficPlugin.this.setVisibility(style);
            }
        });
    }

    private void onFinishLoadingStyle() {
        updateState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void setVisibility(Style style) {
        List<Layer> layers = style.getLayers();
        if (layers.size() > 0) {
            for (Layer layer : layers) {
                String id = layer.getId();
                id.hashCode();
                byte b = -1;
                switch (id.hashCode()) {
                    case -1418677347:
                        if (id.equals(STOP_ICON_LAYER)) {
                            b = 0;
                        }
                        break;
                    case -376946244:
                        if (id.equals(TRAFFIC_FREEFLOW_LAYER)) {
                            b = 1;
                        }
                        break;
                    case 488357337:
                        if (id.equals(CLOSURE_LAYER)) {
                            b = 2;
                        }
                        break;
                    case 1002362512:
                        if (id.equals(TRAFFIC_OTH_1_LAYER)) {
                            b = 3;
                        }
                        break;
                    case 1002362513:
                        if (id.equals(TRAFFIC_OTH_2_LAYER)) {
                            b = 4;
                        }
                        break;
                    case 1002362514:
                        if (id.equals(TRAFFIC_OTH_3_LAYER)) {
                            b = 5;
                        }
                        break;
                    case 1002362515:
                        if (id.equals(TRAFFIC_OTH_4_LAYER)) {
                            b = 6;
                        }
                        break;
                    case 1002362516:
                        if (id.equals(TRAFFIC_OTH_5_LAYER)) {
                            b = 7;
                        }
                        break;
                    case 1043448837:
                        if (id.equals(NON_FREE_FLOW_LAYER)) {
                            b = 8;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                        propertyValueArr[0] = PropertyFactory.visibility((isEnableStopIcon() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr);
                        break;
                    case 1:
                        PropertyValue<?>[] propertyValueArr2 = new PropertyValue[1];
                        propertyValueArr2[0] = PropertyFactory.visibility((isEnableFreeFlow() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr2);
                        break;
                    case 2:
                        PropertyValue<?>[] propertyValueArr3 = new PropertyValue[1];
                        propertyValueArr3[0] = PropertyFactory.visibility((isEnableClosure() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr3);
                        break;
                    case 3:
                        PropertyValue<?>[] propertyValueArr4 = new PropertyValue[1];
                        propertyValueArr4[0] = PropertyFactory.visibility((isEnableOth1() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr4);
                        break;
                    case 4:
                        PropertyValue<?>[] propertyValueArr5 = new PropertyValue[1];
                        propertyValueArr5[0] = PropertyFactory.visibility((isEnableOth2() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr5);
                        break;
                    case 5:
                        PropertyValue<?>[] propertyValueArr6 = new PropertyValue[1];
                        propertyValueArr6[0] = PropertyFactory.visibility((isEnableOth3() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr6);
                        break;
                    case 6:
                        PropertyValue<?>[] propertyValueArr7 = new PropertyValue[1];
                        propertyValueArr7[0] = PropertyFactory.visibility((isEnableOth4() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr7);
                        break;
                    case 7:
                        PropertyValue<?>[] propertyValueArr8 = new PropertyValue[1];
                        propertyValueArr8[0] = PropertyFactory.visibility((isEnableOth5() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr8);
                        break;
                    case 8:
                        PropertyValue<?>[] propertyValueArr9 = new PropertyValue[1];
                        propertyValueArr9[0] = PropertyFactory.visibility((isEnableNonFreeFlow() && isEnable()) ? "visible" : "none");
                        layer.setProperties(propertyValueArr9);
                        break;
                }
            }
        }
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        onFinishLoadingStyle();
    }
}
