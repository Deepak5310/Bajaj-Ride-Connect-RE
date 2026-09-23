package com.mappls.sdk.maps.widgets.indoor;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.maps.BuildConfig;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.R;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.FillExtrusionLayer;
import com.mappls.sdk.maps.style.layers.FillLayer;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.widgets.indoor.iface.IndoorListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FloorControllerView extends ScrollView implements MapplsMap.OnCameraMoveStartedListener, MapplsMap.OnCameraIdleListener, MapView.OnDidFinishRenderingMapListener {
    private boolean cameraMoveHappened;
    private boolean controlHidden;
    boolean followMe;
    private final List<IndoorListener> indoorListeners;
    private boolean isDestroyed;
    private String lastSelectedBuildingId;
    private LinearLayout linearLayout;
    private MapplsMap map;
    private int selectedFloor;
    private int viewSize;

    public boolean isFollowMe() {
        return this.followMe;
    }

    public void setFollowMe(boolean z) {
        this.followMe = z;
    }

    public FloorControllerView(Context context) {
        super(context);
        this.indoorListeners = new ArrayList();
        this.viewSize = 0;
        this.lastSelectedBuildingId = null;
        this.selectedFloor = 0;
        this.controlHidden = true;
        this.cameraMoveHappened = false;
        this.followMe = false;
        this.isDestroyed = false;
        initLayout();
    }

    public FloorControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.indoorListeners = new ArrayList();
        this.viewSize = 0;
        this.lastSelectedBuildingId = null;
        this.selectedFloor = 0;
        this.controlHidden = true;
        this.cameraMoveHappened = false;
        this.followMe = false;
        this.isDestroyed = false;
        initLayout();
    }

    public FloorControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.indoorListeners = new ArrayList();
        this.viewSize = 0;
        this.lastSelectedBuildingId = null;
        this.selectedFloor = 0;
        this.controlHidden = true;
        this.cameraMoveHappened = false;
        this.followMe = false;
        this.isDestroyed = false;
        initLayout();
    }

    private void initLayout() {
        setVerticalScrollBarEnabled(true);
        this.viewSize = (int) getContext().getResources().getDimension(R.dimen.mappls_maps_ui_floor_button_size);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.linearLayout = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.viewSize + 10, -2));
        this.linearLayout.setOrientation(1);
        this.linearLayout.setBackgroundColor(0);
        this.linearLayout.setVerticalGravity(80);
        this.linearLayout.setLayoutTransition(new LayoutTransition());
        setLayoutTransition(new LayoutTransition());
        getLayoutTransition().enableTransitionType(4);
        this.linearLayout.getLayoutTransition().enableTransitionType(4);
        addView(this.linearLayout);
    }

    public MapplsMap getMap() {
        return this.map;
    }

    public void setMap(MapplsMap mapplsMap) {
        this.map = mapplsMap;
        mapplsMap.addOnCameraIdleListener(this);
        mapplsMap.addOnCameraMoveStartedListener(this);
    }

    public void onFloorsChange(List<Floor> list) {
        this.linearLayout.removeAllViews();
        if (this.map.getUiSettings().isLayerControlEnabled()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.reverse(arrayList);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                FloorView floorView = new FloorView(getContext(), (Floor) it2.next());
                int i = this.viewSize;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
                layoutParams.setMargins(5, 5, 5, 5);
                floorView.setLayoutParams(layoutParams);
                floorView.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.maps.widgets.indoor.FloorControllerView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FloorView floorView2 = (FloorView) view;
                        Integer number = floorView2.getFloor().getNumber();
                        FloorControllerView.this.setFloor(number.intValue());
                        FloorControllerView.this.onFloorWillChange(floorView2.getFloor());
                        FloorControllerView.this.onFloorChange(floorView2.getFloor());
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event_view", "indoor_floor");
                                jSONObject.put("selected_floor", number);
                                jSONObject.put("building_id", FloorControllerView.this.lastSelectedBuildingId);
                                MapplsLMSManager.getInstance().add("click", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                    }
                });
                this.linearLayout.addView(floorView);
            }
            scrollToBottom();
            onFloorChange(new Floor(0, IndoorConstants.getFloorName(0), IndoorConstants.getInternalFloorName(0)));
        }
    }

    public void onFloorWillChange(Floor floor) {
        for (int i = 0; i < this.linearLayout.getChildCount(); i++) {
            FloorView floorView = (FloorView) this.linearLayout.getChildAt(i);
            Integer number = floorView.getFloor().getNumber();
            if (floor != null && floor.getNumber().equals(number)) {
                floorView.setLoading();
            } else {
                floorView.setSelected(false);
            }
        }
    }

    public void onFloorChange(Floor floor) {
        for (int i = 0; i < this.linearLayout.getChildCount(); i++) {
            FloorView floorView = (FloorView) this.linearLayout.getChildAt(i);
            Integer number = floorView.getFloor().getNumber();
            if (floor != null && floor.getNumber().equals(number)) {
                floorView.setSelected(true);
            } else {
                floorView.setSelected(false);
            }
        }
    }

    public void addOnIndoorListener(IndoorListener indoorListener) {
        this.indoorListeners.add(indoorListener);
    }

    public boolean removeIndoorListener(IndoorListener indoorListener) {
        Iterator<IndoorListener> it2 = this.indoorListeners.iterator();
        while (it2.hasNext()) {
            IndoorListener next = it2.next();
            if (next == null || indoorListener == next) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    public int getSelectedFloor() {
        return this.selectedFloor;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraMoveStartedListener
    public void onCameraMoveStarted(int i) {
        if (1 == i || 3 == i) {
            this.cameraMoveHappened = true;
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraIdleListener
    public void onCameraIdle() {
        if (this.cameraMoveHappened) {
            this.cameraMoveHappened = false;
            onCameraMove();
        }
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishRenderingMapListener
    public void onDidFinishRenderingMap(boolean z) {
        if (z) {
            onCameraMove();
        }
    }

    public void onCameraMove() {
        if (this.followMe || this.isDestroyed) {
            return;
        }
        if (this.map.getCameraPosition().zoom > 15.9d) {
            MapplsMap mapplsMap = this.map;
            List<Feature> listQueryRenderedFeatures = mapplsMap.queryRenderedFeatures(mapplsMap.getProjection().toScreenLocation(this.map.getCameraPosition().target), "footprints_indoor_3d_1_floor");
            if (listQueryRenderedFeatures.size() > 0) {
                Feature feature = listQueryRenderedFeatures.get(0);
                int iIntValue = feature.hasProperty("FLOOR") ? feature.getNumberProperty("FLOOR").intValue() : 0;
                int iIntValue2 = feature.hasProperty("INI_FLOOR") ? feature.getNumberProperty("INI_FLOOR").intValue() : 0;
                if (iIntValue > 1) {
                    if (feature.hasProperty("BLDG_ID")) {
                        String stringProperty = feature.getStringProperty("BLDG_ID");
                        String str = this.lastSelectedBuildingId;
                        if ((str != null && !str.equalsIgnoreCase(stringProperty)) || this.controlHidden) {
                            showControlWithSelectedFloor(iIntValue2, 0, iIntValue);
                        }
                        this.lastSelectedBuildingId = stringProperty;
                        return;
                    }
                    return;
                }
                hideControl();
                return;
            }
            hideControl();
            return;
        }
        hideControl();
    }

    private void showControlWithSelectedFloor(int i, int i2, int i3) {
        this.controlHidden = false;
        this.selectedFloor = i2;
        if (this.indoorListeners.size() > 0) {
            Iterator<IndoorListener> it2 = this.indoorListeners.iterator();
            while (it2.hasNext()) {
                it2.next().showControl(i, i2, i3);
            }
        }
    }

    private void hideControl() {
        this.controlHidden = true;
        if (this.indoorListeners.size() > 0) {
            Iterator<IndoorListener> it2 = this.indoorListeners.iterator();
            while (it2.hasNext()) {
                it2.next().hideControl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUpdatedFilterForFloor(int i, String str) {
        List<String> possibleFloors = IndoorConstants.getPossibleFloors();
        String internalFloorName = IndoorConstants.getInternalFloorName(i);
        String strReplaceAll = str;
        for (String str2 : possibleFloors) {
            if (str.contains(str2)) {
                strReplaceAll = str.replaceAll(str2, internalFloorName);
            }
        }
        return strReplaceAll;
    }

    public void setFloor(final int i) {
        this.map.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.widgets.indoor.FloorControllerView.2
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                FloorControllerView.this.selectedFloor = i;
                for (String str : IndoorConstants.INDOOR_LAYERS) {
                    Layer layer = style.getLayer(str);
                    if (layer != null) {
                        if (layer instanceof FillLayer) {
                            FillLayer fillLayer = (FillLayer) layer;
                            if (fillLayer.getFilter() != null) {
                                fillLayer.setFilter(Expression.Converter.convert(FloorControllerView.this.getUpdatedFilterForFloor(i, fillLayer.getFilter().toString())));
                            }
                        } else if (layer instanceof SymbolLayer) {
                            SymbolLayer symbolLayer = (SymbolLayer) layer;
                            if (symbolLayer.getFilter() != null) {
                                symbolLayer.setFilter(Expression.Converter.convert(FloorControllerView.this.getUpdatedFilterForFloor(i, symbolLayer.getFilter().toString())));
                            }
                        } else if (layer instanceof FillExtrusionLayer) {
                            FillExtrusionLayer fillExtrusionLayer = (FillExtrusionLayer) layer;
                            if (fillExtrusionLayer.getFilter() != null) {
                                fillExtrusionLayer.setFilter(Expression.Converter.convert(FloorControllerView.this.getUpdatedFilterForFloor(i, fillExtrusionLayer.getFilter().toString())));
                            }
                        } else if (layer instanceof LineLayer) {
                            LineLayer lineLayer = (LineLayer) layer;
                            if (lineLayer.getFilter() != null) {
                                lineLayer.setFilter(Expression.Converter.convert(FloorControllerView.this.getUpdatedFilterForFloor(i, lineLayer.getFilter().toString())));
                            }
                        }
                    }
                }
                Layer layer2 = style.getLayer("footprints_indoor_2_3floors");
                if (layer2 != null) {
                    PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                    propertyValueArr[0] = PropertyFactory.visibility(i > 0 ? "visible" : "none");
                    layer2.setProperties(propertyValueArr);
                }
            }
        });
    }

    public void onDestroy() {
        this.isDestroyed = true;
        MapplsMap mapplsMap = this.map;
        if (mapplsMap != null) {
            mapplsMap.removeOnCameraIdleListener(this);
            this.map.removeOnCameraMoveStartedListener(this);
        }
    }

    void scrollToBottom() {
        postDelayed(new Runnable() { // from class: com.mappls.sdk.maps.widgets.indoor.FloorControllerView.3
            @Override // java.lang.Runnable
            public void run() {
                FloorControllerView floorControllerView = FloorControllerView.this;
                FloorControllerView.this.smoothScrollBy(0, (floorControllerView.getChildAt(floorControllerView.getChildCount() - 1).getBottom() + FloorControllerView.this.getPaddingBottom()) - (FloorControllerView.this.getScrollY() + FloorControllerView.this.getHeight()));
            }
        }, 300L);
    }
}
