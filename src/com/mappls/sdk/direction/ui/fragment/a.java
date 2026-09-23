package com.mappls.sdk.direction.ui.fragment;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionFragmentAddWayPointDialogBinding;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraMapplsPinPosition;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.plugin.annotation.SymbolManager;
import com.mappls.sdk.plugin.annotation.SymbolOptions;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/mappls/sdk/direction/ui/fragment/a;", "Landroidx/fragment/app/Fragment;", "Lcom/mappls/sdk/maps/OnMapReadyCallback;", "<init>", "()V", "a", "direction-widget_release"}, k = 1, mv = {1, 8, 0})
public final class a extends Fragment implements OnMapReadyCallback {
    public static final /* synthetic */ int g = 0;
    private MapplsDirectionFragmentAddWayPointDialogBinding a;
    private PoiResult b;
    private InterfaceC0071a c;
    private MapView d;
    private SymbolManager e;
    private boolean f;

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.fragment.a$a, reason: collision with other inner class name */
    public interface InterfaceC0071a {
        void a(PoiResult poiResult);

        void onCancel();
    }

    private final void a(final PoiResult poiResult) {
        TextView textView;
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding = this.a;
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding2 = null;
        if (mapplsDirectionFragmentAddWayPointDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding = null;
        }
        CharSequence charSequenceFromHtml = "";
        mapplsDirectionFragmentAddWayPointDialogBinding.resultPlaceName.setText(!TextUtils.isEmpty(poiResult.getPlaceName()) ? poiResult.getPlaceName() : "");
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding3 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding3 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding3.itemPlaceResultPlaceAddress.setText(!TextUtils.isEmpty(poiResult.getPlaceAddress()) ? poiResult.getPlaceAddress() : "");
        Long distance = poiResult.getDistance();
        Intrinsics.checkNotNullExpressionValue(distance, "data.distance");
        if (distance.longValue() > 0) {
            MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding4 = this.a;
            if (mapplsDirectionFragmentAddWayPointDialogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mapplsDirectionFragmentAddWayPointDialogBinding4 = null;
            }
            textView = mapplsDirectionFragmentAddWayPointDialogBinding4.textViewDistance;
            String formattedDistance = DirectionFormatter.getFormattedDistance(poiResult.getDistance().longValue());
            Intrinsics.checkNotNullExpressionValue(formattedDistance, "getFormattedDistance(distance.toDouble())");
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) formattedDistance, new String[]{StringUtils.SPACE}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (strArr.length == 2) {
                charSequenceFromHtml = Html.fromHtml(strArr[0] + "<br>" + strArr[1]);
            } else {
                charSequenceFromHtml = null;
            }
        } else {
            MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding5 = this.a;
            if (mapplsDirectionFragmentAddWayPointDialogBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mapplsDirectionFragmentAddWayPointDialogBinding5 = null;
            }
            textView = mapplsDirectionFragmentAddWayPointDialogBinding5.textViewDistance;
        }
        textView.setText(charSequenceFromHtml);
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding6 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding6 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding6.itemPlaceResultRatingBar.setVisibility(8);
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding7 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding7 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding7.itemPlaceResultRatingBar.setRating(0.0f);
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding8 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding8 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding8.itemPlaceResultRatingBar.setEnabled(false);
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding9 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            mapplsDirectionFragmentAddWayPointDialogBinding2 = mapplsDirectionFragmentAddWayPointDialogBinding9;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding2.buttonAddWaypoint.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.a(this.f$0, poiResult, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC0071a interfaceC0071a = this$0.c;
        if (interfaceC0071a != null) {
            interfaceC0071a.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, PoiResult data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        InterfaceC0071a interfaceC0071a = this$0.c;
        if (interfaceC0071a != null) {
            interfaceC0071a.a(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, MapplsMap mapplsMap, Style it2) {
        SymbolManager symbolManager;
        SymbolManager symbolManager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mapplsMap, "$mapplsMap");
        Intrinsics.checkNotNullParameter(it2, "it");
        MapView mapView = this$0.d;
        Intrinsics.checkNotNull(mapView);
        this$0.e = new SymbolManager(mapView, mapplsMap, it2);
        PoiResult poiResult = this$0.b;
        if ((poiResult != null ? poiResult.getLatitude() : null) != null) {
            PoiResult poiResult2 = this$0.b;
            if ((poiResult2 != null ? poiResult2.getLongitude() : null) != null && (symbolManager2 = this$0.e) != null) {
                SymbolOptions symbolOptions = new SymbolOptions();
                PoiResult poiResult3 = this$0.b;
                Double latitude = poiResult3 != null ? poiResult3.getLatitude() : null;
                Intrinsics.checkNotNull(latitude);
                double dDoubleValue = latitude.doubleValue();
                PoiResult poiResult4 = this$0.b;
                Double longitude = poiResult4 != null ? poiResult4.getLongitude() : null;
                Intrinsics.checkNotNull(longitude);
                symbolManager2.create(symbolOptions.position(new LatLng(dDoubleValue, longitude.doubleValue())));
            }
        }
        PoiResult poiResult5 = this$0.b;
        if ((poiResult5 != null ? poiResult5.getMapplsPin() : null) == null || (symbolManager = this$0.e) == null) {
            return;
        }
        SymbolOptions symbolOptions2 = new SymbolOptions();
        PoiResult poiResult6 = this$0.b;
        String mapplsPin = poiResult6 != null ? poiResult6.getMapplsPin() : null;
        Intrinsics.checkNotNull(mapplsPin);
        symbolManager.create(symbolOptions2.mapplsPin(mapplsPin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC0071a interfaceC0071a = this$0.c;
        if (interfaceC0071a != null) {
            interfaceC0071a.onCancel();
        }
    }

    public final void a(InterfaceC0071a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.c = listener;
    }

    public final void a(MapView mapView) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.d = mapView;
        if (!isAdded() || this.f) {
            return;
        }
        MapView mapView2 = this.d;
        if (mapView2 != null) {
            mapView2.getMapAsync(this);
        }
        this.f = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.b = (PoiResult) new Gson().fromJson(arguments.getString("arg_search_data"), PoiResult.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBindingInflate = MapplsDirectionFragmentAddWayPointDialogBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(mapplsDirectionFragmentAddWayPointDialogBindingInflate, "inflate(inflater, container, false)");
        this.a = mapplsDirectionFragmentAddWayPointDialogBindingInflate;
        if (mapplsDirectionFragmentAddWayPointDialogBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBindingInflate = null;
        }
        View root = mapplsDirectionFragmentAddWayPointDialogBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        SymbolManager symbolManager = this.e;
        if (symbolManager != null) {
            symbolManager.onDestroy();
        }
        super.onDestroyView();
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public final void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public final void onMapReady(final MapplsMap mapplsMap) {
        Intrinsics.checkNotNullParameter(mapplsMap, "mapplsMap");
        PoiResult poiResult = this.b;
        if ((poiResult != null ? poiResult.getLatitude() : null) != null) {
            PoiResult poiResult2 = this.b;
            if ((poiResult2 != null ? poiResult2.getLongitude() : null) != null) {
                CameraPosition.Builder builder = new CameraPosition.Builder();
                PoiResult poiResult3 = this.b;
                Double latitude = poiResult3 != null ? poiResult3.getLatitude() : null;
                Intrinsics.checkNotNull(latitude);
                double dDoubleValue = latitude.doubleValue();
                PoiResult poiResult4 = this.b;
                Double longitude = poiResult4 != null ? poiResult4.getLongitude() : null;
                Intrinsics.checkNotNull(longitude);
                mapplsMap.setCameraPosition(builder.target(new LatLng(dDoubleValue, longitude.doubleValue())).zoom(12.0d).build());
            }
        }
        PoiResult poiResult5 = this.b;
        if ((poiResult5 != null ? poiResult5.getMapplsPin() : null) != null) {
            CameraMapplsPinPosition.Builder builder2 = new CameraMapplsPinPosition.Builder();
            PoiResult poiResult6 = this.b;
            String mapplsPin = poiResult6 != null ? poiResult6.getMapplsPin() : null;
            Intrinsics.checkNotNull(mapplsPin);
            mapplsMap.setCameraMapplsPinPosition(builder2.target(mapplsPin).zoom(12.0d).build());
        }
        mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.direction.ui.fragment.a$$ExternalSyntheticLambda3
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public final void onStyleLoaded(Style style) {
                a.a(this.f$0, mapplsMap, style);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TypedArray typedArrayObtainStyledAttributes = view.getContext().getTheme().obtainStyledAttributes(R.styleable.mappls_poi_along_route);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "view.context.theme.obtai…e.mappls_poi_along_route)");
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_poi_along_route_poi_add_way_point_button_text_color, ContextCompat.getColor(view.getContext(), R.color.mappls_directions_search_category_text_color));
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_poi_along_route_poi_add_way_point_button_background_color, ContextCompat.getColor(view.getContext(), R.color.mappls_directions_search_category_next_button_back));
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding.buttonAddWaypoint.setTextColor(color);
        if (!this.f) {
            MapView mapView = this.d;
            if (mapView != null) {
                mapView.getMapAsync(this);
            }
            this.f = true;
        }
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.mappls_direction_dr_button_background);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(color2, PorterDuff.Mode.SRC_IN));
        }
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding2 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding2 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding2.buttonAddWaypoint.setBackground(drawable);
        PoiResult poiResult = this.b;
        if (poiResult != null) {
            Intrinsics.checkNotNull(poiResult);
            a(poiResult);
        }
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding3 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding3 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding3.selectedWaypointBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.a(this.f$0, view2);
            }
        });
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding4 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding4 = null;
        }
        mapplsDirectionFragmentAddWayPointDialogBinding4.selectedWaypointClearBtn.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.a$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.b(this.f$0, view2);
            }
        });
        MapplsDirectionFragmentAddWayPointDialogBinding mapplsDirectionFragmentAddWayPointDialogBinding5 = this.a;
        if (mapplsDirectionFragmentAddWayPointDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            mapplsDirectionFragmentAddWayPointDialogBinding5 = null;
        }
        TextView textView = mapplsDirectionFragmentAddWayPointDialogBinding5.selectedWaypointSearchInput;
        PoiResult poiResult2 = this.b;
        textView.setText(poiResult2 != null ? poiResult2.getPoiType() : null);
    }
}
