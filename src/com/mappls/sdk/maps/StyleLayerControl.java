package com.mappls.sdk.maps;

import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class StyleLayerControl {
    private static final String AKSHARDHAM_LAYER = "Akshardham";
    private static final String BUDDHA_STATUE_LAYER = "Buddha_statue";
    private static final String DEM_LAYER = "dem";
    private static final String GATEWAY_OF_INDIA_LAYER = "Gateway_of_India";
    private static final String INDIA_GATE_LAYER = "India Gate";
    private static final String LOTUS_TEMPLE_LAYER = "Lotus_Temple";
    private static final String QUTUB_MINAR_LAYER = "Qutub_Minar";
    private static final String RED_FORT_LAYER = "red_fort";
    private static final String STATUE_OF_UNITY_LAYER = "statue_of_unity";
    private static final String TAJ_MAHAL_LAYER = "Taj_Mahal";
    private MapplsMap mapplsMap;
    private boolean isDemEnabled = true;
    private boolean isIndiaGateEnabled = true;
    private boolean isRedFortEnabled = true;
    private boolean isQutubMinarEnabled = true;
    private boolean isGatewayOfIndiaEnabled = true;
    private boolean isLotusTempleEnabled = true;
    private boolean isAkshardhamEnabled = true;
    private boolean isTajMahalEnabled = true;
    private boolean isBuddhaStatueEnabled = true;
    private boolean isStatueOfUnityEnabled = true;
    private boolean isMonumentsEnabled = true;

    public void onStartLoadingMap() {
    }

    StyleLayerControl(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
    }

    private void updateState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.StyleLayerControl.1
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                StyleLayerControl.this.setVisibility(style);
            }
        });
    }

    public void onFinishLoadingStyle() {
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
                    case -1868425955:
                        if (id.equals(TAJ_MAHAL_LAYER)) {
                            b = 0;
                        }
                        break;
                    case -1671746793:
                        if (id.equals(BUDDHA_STATUE_LAYER)) {
                            b = 1;
                        }
                        break;
                    case -868758264:
                        if (id.equals(STATUE_OF_UNITY_LAYER)) {
                            b = 2;
                        }
                        break;
                    case -785727559:
                        if (id.equals(RED_FORT_LAYER)) {
                            b = 3;
                        }
                        break;
                    case -756356032:
                        if (id.equals(AKSHARDHAM_LAYER)) {
                            b = 4;
                        }
                        break;
                    case 99340:
                        if (id.equals(DEM_LAYER)) {
                            b = 5;
                        }
                        break;
                    case 757421341:
                        if (id.equals(LOTUS_TEMPLE_LAYER)) {
                            b = 6;
                        }
                        break;
                    case 1277660756:
                        if (id.equals(INDIA_GATE_LAYER)) {
                            b = 7;
                        }
                        break;
                    case 1288874090:
                        if (id.equals(GATEWAY_OF_INDIA_LAYER)) {
                            b = 8;
                        }
                        break;
                    case 1367775329:
                        if (id.equals(QUTUB_MINAR_LAYER)) {
                            b = 9;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                        propertyValueArr[0] = PropertyFactory.visibility(isTajMahalEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr);
                        break;
                    case 1:
                        PropertyValue<?>[] propertyValueArr2 = new PropertyValue[1];
                        propertyValueArr2[0] = PropertyFactory.visibility(isBuddhaStatueEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr2);
                        break;
                    case 2:
                        PropertyValue<?>[] propertyValueArr3 = new PropertyValue[1];
                        propertyValueArr3[0] = PropertyFactory.visibility(isStatueOfUnityEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr3);
                        break;
                    case 3:
                        PropertyValue<?>[] propertyValueArr4 = new PropertyValue[1];
                        propertyValueArr4[0] = PropertyFactory.visibility(isRedFortEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr4);
                        break;
                    case 4:
                        PropertyValue<?>[] propertyValueArr5 = new PropertyValue[1];
                        propertyValueArr5[0] = PropertyFactory.visibility(isAkshardhamEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr5);
                        break;
                    case 5:
                        PropertyValue<?>[] propertyValueArr6 = new PropertyValue[1];
                        propertyValueArr6[0] = PropertyFactory.visibility(isDemEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr6);
                        break;
                    case 6:
                        PropertyValue<?>[] propertyValueArr7 = new PropertyValue[1];
                        propertyValueArr7[0] = PropertyFactory.visibility(isLotusTempleEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr7);
                        break;
                    case 7:
                        PropertyValue<?>[] propertyValueArr8 = new PropertyValue[1];
                        propertyValueArr8[0] = PropertyFactory.visibility(isIndiaGateEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr8);
                        break;
                    case 8:
                        PropertyValue<?>[] propertyValueArr9 = new PropertyValue[1];
                        propertyValueArr9[0] = PropertyFactory.visibility(isGatewayOfIndiaEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr9);
                        break;
                    case 9:
                        PropertyValue<?>[] propertyValueArr10 = new PropertyValue[1];
                        propertyValueArr10[0] = PropertyFactory.visibility(isQutubMinarEnabled() ? "visible" : "none");
                        layer.setProperties(propertyValueArr10);
                        break;
                }
            }
        }
    }

    public boolean isDemEnabled() {
        return this.isDemEnabled;
    }

    public void setDemEnabled(boolean z) {
        this.isDemEnabled = z;
        updateState();
    }

    public boolean isIndiaGateEnabled() {
        return this.isIndiaGateEnabled & isMonumentsEnabled();
    }

    public void setIndiaGateEnabled(boolean z) {
        this.isIndiaGateEnabled = z;
        updateState();
    }

    public boolean isRedFortEnabled() {
        return this.isRedFortEnabled & isMonumentsEnabled();
    }

    public void setRedFortEnabled(boolean z) {
        this.isRedFortEnabled = z;
        updateState();
    }

    public boolean isQutubMinarEnabled() {
        return this.isQutubMinarEnabled & isMonumentsEnabled();
    }

    public void setQutubMinarEnabled(boolean z) {
        this.isQutubMinarEnabled = z;
        updateState();
    }

    public boolean isGatewayOfIndiaEnabled() {
        return this.isGatewayOfIndiaEnabled & isMonumentsEnabled();
    }

    public void setGatewayOfIndiaEnabled(boolean z) {
        this.isGatewayOfIndiaEnabled = z;
        updateState();
    }

    public boolean isLotusTempleEnabled() {
        return this.isLotusTempleEnabled & isMonumentsEnabled();
    }

    public void setLotusTempleEnabled(boolean z) {
        this.isLotusTempleEnabled = z;
        updateState();
    }

    public boolean isAkshardhamEnabled() {
        return this.isAkshardhamEnabled & isMonumentsEnabled();
    }

    public void setAkshardhamEnabled(boolean z) {
        this.isAkshardhamEnabled = z;
        updateState();
    }

    public boolean isTajMahalEnabled() {
        return this.isTajMahalEnabled & isMonumentsEnabled();
    }

    public void setTajMahalEnabled(boolean z) {
        this.isTajMahalEnabled = z;
        updateState();
    }

    public boolean isBuddhaStatueEnabled() {
        return this.isBuddhaStatueEnabled & isMonumentsEnabled();
    }

    public void setBuddhaStatueEnabled(boolean z) {
        this.isBuddhaStatueEnabled = z;
        updateState();
    }

    public boolean isStatueOfUnityEnabled() {
        return this.isStatueOfUnityEnabled & isMonumentsEnabled();
    }

    public void setStatueOfUnityEnabled(boolean z) {
        this.isStatueOfUnityEnabled = z;
        updateState();
    }

    public boolean isMonumentsEnabled() {
        return this.isMonumentsEnabled;
    }

    public void setMonumentsEnabled(boolean z) {
        this.isMonumentsEnabled = z;
        updateState();
    }
}
