package com.mappls.sdk.category.fragment;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mappls.sdk.category.R;
import com.mappls.sdk.category.databinding.MapplsCategoryResultFragmentBinding;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.category.utils.c;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.UiSettings;
import com.mappls.sdk.maps.camera.CameraMapplsPinPosition;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdateFactory;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.plugin.annotation.OnSymbolClickListener;
import com.mappls.sdk.plugin.annotation.Symbol;
import com.mappls.sdk.services.api.alongroute.models.POIAlongRouteResponse;
import com.mappls.sdk.services.api.alongroute.models.SuggestedPOI;
import com.mappls.sdk.services.api.autosuggest.model.AddressTokens;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class CategoryResultFragment extends Fragment implements OnMapReadyCallback, OnSymbolClickListener {
    public static final a Companion = new a(0);
    private MapplsCategoryResultFragmentBinding mBinding;
    private ICategoryResultListener mCallback;
    private com.mappls.sdk.category.utils.a mMapPlugin;
    private MapView mMapView;
    private MapplsMap mMapplsMap;
    private com.mappls.sdk.category.viewmodel.a mViewModel;
    private com.mappls.sdk.category.adapters.b poiResultAdapter;
    private final Map<String, String> iconMap = new HashMap();
    private final Observer<com.mappls.sdk.category.utils.c<NearbyAtlasResponse>> nearbyObserver = new Observer() { // from class: com.mappls.sdk.category.fragment.CategoryResultFragment$$ExternalSyntheticLambda1
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            CategoryResultFragment.nearbyObserver$lambda$0(this.f$0, (c) obj);
        }
    };
    private final Observer<com.mappls.sdk.category.utils.c<POIAlongRouteResponse>> poiAlongRouteObserver = new Observer() { // from class: com.mappls.sdk.category.fragment.CategoryResultFragment$$ExternalSyntheticLambda2
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            CategoryResultFragment.poiAlongRouteObserver$lambda$1(this.f$0, (c) obj);
        }
    };

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }

        @JvmStatic
        public static CategoryResultFragment a(ArrayList selectedCategories) {
            Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
            SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
            Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
            return a(selectedCategories, searchCategoryUIOptionBuild);
        }

        @JvmStatic
        public static CategoryResultFragment a(ArrayList selectedCategories, SearchCategoryUIOption options) {
            Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
            Intrinsics.checkNotNullParameter(options, "options");
            CategoryResultFragment categoryResultFragment = new CategoryResultFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.mappls.sdk.category.CATEGORY_UI_OPTION", options);
            bundle.putParcelableArrayList("com.mappls.sdk.category.SELECTED_CATEGORY_CODES", selectedCategories);
            categoryResultFragment.setArguments(bundle);
            return categoryResultFragment;
        }
    }

    public static final class b extends OnBackPressedCallback {
        b() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            CategoryResultFragment.this.getParentFragmentManager().popBackStack("CategoryResultFragment", 1);
        }
    }

    public static final class c implements com.mappls.sdk.category.adapters.b.a {
        c() {
        }

        @Override // com.mappls.sdk.category.adapters.b.a
        public final void a(PoiResult data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ICategoryResultListener iCategoryResultListener = CategoryResultFragment.this.mCallback;
            if (iCategoryResultListener != null) {
                iCategoryResultListener.onCategorySelectedResult(data);
            }
        }
    }

    private final void callPoi() {
        com.mappls.sdk.category.viewmodel.a aVar = this.mViewModel;
        com.mappls.sdk.category.viewmodel.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        Integer numSearchType = aVar.d().searchType();
        if (numSearchType != null && numSearchType.intValue() == 0) {
            com.mappls.sdk.category.viewmodel.a aVar3 = this.mViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar3 = null;
            }
            List<CategoryCode> listF = aVar3.f();
            if (listF != null) {
                com.mappls.sdk.category.viewmodel.a aVar4 = this.mViewModel;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar2 = aVar4;
                }
                aVar2.a(listF);
                return;
            }
            return;
        }
        com.mappls.sdk.category.viewmodel.a aVar5 = this.mViewModel;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar5 = null;
        }
        List<CategoryCode> listF2 = aVar5.f();
        if (listF2 != null) {
            com.mappls.sdk.category.viewmodel.a aVar6 = this.mViewModel;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                aVar2 = aVar6;
            }
            aVar2.b(listF2);
        }
    }

    private final List<PoiResult> getPOIResultFromAlongRoute(List<? extends SuggestedPOI> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SuggestedPOI suggestedPOI : list) {
                PoiResult poiResult = new PoiResult();
                poiResult.setPlaceName(suggestedPOI.getPoi());
                poiResult.setPlaceAddress(suggestedPOI.getAddress());
                Integer distance = suggestedPOI.getDistance();
                com.mappls.sdk.category.viewmodel.a aVar = null;
                poiResult.setDistance(distance != null ? Long.valueOf(distance.intValue()) : null);
                poiResult.setLatitude(suggestedPOI.getLatitude());
                poiResult.setLongitude(suggestedPOI.getLongitude());
                poiResult.setMapplsPin(suggestedPOI.getMapplsPin());
                poiResult.setKeywords(CollectionsKt.listOf(suggestedPOI.getCategory()));
                com.mappls.sdk.category.viewmodel.a aVar2 = this.mViewModel;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar = aVar2;
                }
                poiResult.setPoiType((String) aVar.b().get(suggestedPOI.getCategory()));
                poiResult.setBrandCode(suggestedPOI.getBrandCode());
                AddressTokens addressTokens = new AddressTokens();
                addressTokens.city = suggestedPOI.getCity();
                addressTokens.district = suggestedPOI.getDistrict();
                addressTokens.locality = suggestedPOI.getLocality();
                addressTokens.pincode = suggestedPOI.getLocality();
                addressTokens.state = suggestedPOI.getState();
                addressTokens.subDistrict = suggestedPOI.getSubDistrict();
                addressTokens.subLocality = suggestedPOI.getSubLocality();
                addressTokens.subSubLocality = suggestedPOI.getSubSubLocality();
                poiResult.setAddressToken(addressTokens);
                arrayList.add(poiResult);
            }
        }
        return arrayList;
    }

    private final List<PoiResult> getPOIResultFromNearby(List<? extends NearbyAtlasResult> list) {
        ArrayList arrayList = new ArrayList();
        for (NearbyAtlasResult nearbyAtlasResult : list) {
            PoiResult poiResult = new PoiResult();
            poiResult.setPlaceName(nearbyAtlasResult.placeName);
            poiResult.setPlaceAddress(nearbyAtlasResult.placeAddress);
            poiResult.setDistance(nearbyAtlasResult.distance);
            poiResult.setLatitude(nearbyAtlasResult.latitude);
            poiResult.setLongitude(nearbyAtlasResult.longitude);
            poiResult.setMapplsPin(nearbyAtlasResult.mapplsPin);
            poiResult.setKeywords(nearbyAtlasResult.keywords);
            com.mappls.sdk.category.viewmodel.a aVar = this.mViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar = null;
            }
            poiResult.setPoiType((String) aVar.b().get(nearbyAtlasResult.keywords.get(0)));
            poiResult.setAddressToken(nearbyAtlasResult.addressTokens);
            arrayList.add(poiResult);
        }
        return arrayList;
    }

    private final void initialiseMapCamera() {
        List listSplit$default;
        String str;
        List listSplit$default2;
        String str2;
        com.mappls.sdk.category.viewmodel.a aVar = this.mViewModel;
        com.mappls.sdk.category.viewmodel.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        Integer numSearchType = aVar.d().searchType();
        if (numSearchType == null || numSearchType.intValue() != 0) {
            ArrayList arrayList = new ArrayList();
            com.mappls.sdk.category.viewmodel.a aVar3 = this.mViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar3 = null;
            }
            String strGeometries = aVar3.d().geometries();
            if (strGeometries == null || !StringsKt.equals(strGeometries, "polyline", true)) {
                com.mappls.sdk.category.viewmodel.a aVar4 = this.mViewModel;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar2 = aVar4;
                }
                String strPath = aVar2.d().path();
                Intrinsics.checkNotNull(strPath);
                List<Point> listDecode = PolylineUtils.decode(strPath, 6);
                Intrinsics.checkNotNullExpressionValue(listDecode, "decode(mViewModel.option…!, Constants.PRECISION_6)");
                for (Point point : listDecode) {
                    arrayList.add(new LatLng(point.latitude(), point.longitude()));
                }
            } else {
                com.mappls.sdk.category.viewmodel.a aVar5 = this.mViewModel;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar2 = aVar5;
                }
                String strPath2 = aVar2.d().path();
                Intrinsics.checkNotNull(strPath2);
                List<Point> listDecode2 = PolylineUtils.decode(strPath2, 5);
                Intrinsics.checkNotNullExpressionValue(listDecode2, "decode(mViewModel.option…!, Constants.PRECISION_5)");
                for (Point point2 : listDecode2) {
                    arrayList.add(new LatLng(point2.latitude(), point2.longitude()));
                }
            }
            MapplsMap mapplsMap = this.mMapplsMap;
            if (mapplsMap != null) {
                mapplsMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds.Builder().includes(arrayList).build(), 20));
                return;
            }
            return;
        }
        com.mappls.sdk.category.viewmodel.a aVar6 = this.mViewModel;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar6 = null;
        }
        String strLocation = aVar6.d().location();
        if (strLocation == null || !StringsKt.contains$default((CharSequence) strLocation, (CharSequence) ",", false, 2, (Object) null)) {
            MapplsMap mapplsMap2 = this.mMapplsMap;
            if (mapplsMap2 != null) {
                CameraMapplsPinPosition.Builder builder = new CameraMapplsPinPosition.Builder();
                com.mappls.sdk.category.viewmodel.a aVar7 = this.mViewModel;
                if (aVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar2 = aVar7;
                }
                mapplsMap2.setCameraMapplsPinPosition(builder.target(aVar2.d().location()).zoom(12.0d).build());
                return;
            }
            return;
        }
        MapplsMap mapplsMap3 = this.mMapplsMap;
        if (mapplsMap3 == null) {
            return;
        }
        CameraPosition.Builder builder2 = new CameraPosition.Builder();
        com.mappls.sdk.category.viewmodel.a aVar8 = this.mViewModel;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar8 = null;
        }
        String strLocation2 = aVar8.d().location();
        double d = 0.0d;
        double d2 = (strLocation2 == null || (listSplit$default2 = StringsKt.split$default((CharSequence) strLocation2, new String[]{","}, false, 0, 6, (Object) null)) == null || (str2 = (String) listSplit$default2.get(0)) == null) ? 0.0d : Double.parseDouble(str2);
        com.mappls.sdk.category.viewmodel.a aVar9 = this.mViewModel;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar2 = aVar9;
        }
        String strLocation3 = aVar2.d().location();
        if (strLocation3 != null && (listSplit$default = StringsKt.split$default((CharSequence) strLocation3, new String[]{","}, false, 0, 6, (Object) null)) != null && (str = (String) listSplit$default.get(1)) != null) {
            d = Double.parseDouble(str);
        }
        mapplsMap3.setCameraPosition(builder2.target(new LatLng(d2, d)).zoom(12.0d).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nearbyObserver$lambda$0(CategoryResultFragment this$0, com.mappls.sdk.category.utils.c cVar) {
        View view;
        Integer totalPages;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int iOrdinal = cVar.c().ordinal();
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding = null;
        com.mappls.sdk.category.adapters.b bVar = null;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding2 = null;
        if (iOrdinal == 0) {
            if (cVar.a() == null || ((totalPages = ((NearbyAtlasResponse) cVar.a()).getPageInfo().getTotalPages()) != null && totalPages.intValue() == 0)) {
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding3 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding3 = null;
                }
                mapplsCategoryResultFragmentBinding3.mapplsCategoryLayoutEmptyErrorState.setVisibility(0);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding4 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding4 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding4.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_empty_state)).setText(this$0.getString(R.string.mappls_category_no_results));
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding5 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding5 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding5.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_retry)).setVisibility(8);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding6 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding6 = null;
                }
                mapplsCategoryResultFragmentBinding6.mapplsCategoryTextViewResults.setVisibility(8);
                com.mappls.sdk.category.adapters.b bVar2 = this$0.poiResultAdapter;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
                    bVar2 = null;
                }
                bVar2.a(new ArrayList());
            } else {
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding7 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding7 = null;
                }
                mapplsCategoryResultFragmentBinding7.mapplsCategoryLayoutEmptyErrorState.setVisibility(8);
                ArrayList<NearbyAtlasResult> suggestedLocations = ((NearbyAtlasResponse) cVar.a()).getSuggestedLocations();
                Intrinsics.checkNotNullExpressionValue(suggestedLocations, "it.data.suggestedLocations");
                this$0.setPoiResultData(this$0.getPOIResultFromNearby(suggestedLocations));
            }
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding8 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                mapplsCategoryResultFragmentBinding = mapplsCategoryResultFragmentBinding8;
            }
            view = mapplsCategoryResultFragmentBinding.mapplsCategoryProgressLayout;
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    return;
                }
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding9 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding9 = null;
                }
                mapplsCategoryResultFragmentBinding9.mapplsCategoryLayoutEmptyErrorState.setVisibility(0);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding10 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding10 = null;
                }
                mapplsCategoryResultFragmentBinding10.mapplsCategoryProgressLayout.setVisibility(8);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding11 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding11 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding11.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_empty_state)).setText(cVar.b());
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding12 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding12 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding12.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_retry)).setVisibility(0);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding13 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding13 = null;
                }
                mapplsCategoryResultFragmentBinding13.mapplsCategoryTextViewResults.setVisibility(8);
                com.mappls.sdk.category.adapters.b bVar3 = this$0.poiResultAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
                } else {
                    bVar = bVar3;
                }
                bVar.a(new ArrayList());
                return;
            }
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding14 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                mapplsCategoryResultFragmentBinding14 = null;
            }
            mapplsCategoryResultFragmentBinding14.mapplsCategoryLayoutEmptyErrorState.setVisibility(8);
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding15 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                mapplsCategoryResultFragmentBinding15 = null;
            }
            mapplsCategoryResultFragmentBinding15.mapplsCategoryProgressLayout.setVisibility(0);
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding16 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                mapplsCategoryResultFragmentBinding2 = mapplsCategoryResultFragmentBinding16;
            }
            view = mapplsCategoryResultFragmentBinding2.mapplsCategoryTextViewResults;
        }
        view.setVisibility(8);
    }

    @JvmStatic
    public static final CategoryResultFragment newInstance(ArrayList<CategoryCode> arrayList) {
        Companion.getClass();
        return a.a(arrayList);
    }

    @JvmStatic
    public static final CategoryResultFragment newInstance(ArrayList<CategoryCode> arrayList, SearchCategoryUIOption searchCategoryUIOption) {
        Companion.getClass();
        return a.a(arrayList, searchCategoryUIOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$18(CategoryResultFragment this$0, MapplsMap mapplsMap, Style it2) {
        com.mappls.sdk.category.utils.a aVar;
        String strPath;
        int i;
        com.mappls.sdk.category.utils.a aVar2;
        List listSplit$default;
        String str;
        List listSplit$default2;
        String str2;
        String category;
        Bitmap bitmapFromDrawable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mapplsMap, "$mapplsMap");
        Intrinsics.checkNotNullParameter(it2, "it");
        com.mappls.sdk.category.viewmodel.a aVar3 = this$0.mViewModel;
        com.mappls.sdk.category.viewmodel.a aVar4 = null;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar3 = null;
        }
        List<CategoryCode> listF = aVar3.f();
        if (listF != null) {
            for (CategoryCode categoryCode : listF) {
                if (categoryCode.getMarkerBitmap() != null) {
                    category = categoryCode.getCategory();
                    bitmapFromDrawable = categoryCode.getMarkerBitmap();
                } else {
                    category = categoryCode.getCategory();
                    bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(this$0.requireContext(), categoryCode.getMarkerIcon()));
                    Intrinsics.checkNotNull(bitmapFromDrawable);
                }
                it2.addImage(category, bitmapFromDrawable);
                List<String> categoryCode2 = categoryCode.getCategoryCode();
                Intrinsics.checkNotNullExpressionValue(categoryCode2, "categoryCode.categoryCode");
                for (String category2 : categoryCode2) {
                    Map<String, String> map = this$0.iconMap;
                    Intrinsics.checkNotNullExpressionValue(category2, "category");
                    String category3 = categoryCode.getCategory();
                    Intrinsics.checkNotNullExpressionValue(category3, "categoryCode.category");
                    map.put(category2, category3);
                }
            }
        }
        MapView mapView = this$0.mMapView;
        Intrinsics.checkNotNull(mapView);
        com.mappls.sdk.category.viewmodel.a aVar5 = this$0.mViewModel;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar5 = null;
        }
        this$0.mMapPlugin = new com.mappls.sdk.category.utils.a(mapView, mapplsMap, it2, this$0, aVar5.e());
        com.mappls.sdk.category.viewmodel.a aVar6 = this$0.mViewModel;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar6 = null;
        }
        Boolean boolShowRequestOnMap = aVar6.d().showRequestOnMap();
        Intrinsics.checkNotNullExpressionValue(boolShowRequestOnMap, "mViewModel.options.showRequestOnMap()");
        if (boolShowRequestOnMap.booleanValue()) {
            com.mappls.sdk.category.viewmodel.a aVar7 = this$0.mViewModel;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar7 = null;
            }
            Integer numSearchType = aVar7.d().searchType();
            if (numSearchType == null || numSearchType.intValue() != 0) {
                com.mappls.sdk.category.viewmodel.a aVar8 = this$0.mViewModel;
                if (aVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    aVar8 = null;
                }
                String strGeometries = aVar8.d().geometries();
                if (strGeometries == null || !StringsKt.equals(strGeometries, "polyline", true)) {
                    aVar = this$0.mMapPlugin;
                    if (aVar == null) {
                        return;
                    }
                    com.mappls.sdk.category.viewmodel.a aVar9 = this$0.mViewModel;
                    if (aVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        aVar4 = aVar9;
                    }
                    strPath = aVar4.d().path();
                    Intrinsics.checkNotNull(strPath);
                    i = 6;
                } else {
                    aVar = this$0.mMapPlugin;
                    if (aVar == null) {
                        return;
                    }
                    com.mappls.sdk.category.viewmodel.a aVar10 = this$0.mViewModel;
                    if (aVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    } else {
                        aVar4 = aVar10;
                    }
                    strPath = aVar4.d().path();
                    Intrinsics.checkNotNull(strPath);
                    i = 5;
                }
                LineString lineStringFromPolyline = LineString.fromPolyline(strPath, i);
                Intrinsics.checkNotNullExpressionValue(lineStringFromPolyline, "fromPolyline(\n          …                        )");
                aVar.a(lineStringFromPolyline);
                return;
            }
            com.mappls.sdk.category.viewmodel.a aVar11 = this$0.mViewModel;
            if (aVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar11 = null;
            }
            String strLocation = aVar11.d().location();
            if (strLocation == null || !StringsKt.contains$default((CharSequence) strLocation, (CharSequence) ",", false, 2, (Object) null)) {
                com.mappls.sdk.category.viewmodel.a aVar12 = this$0.mViewModel;
                if (aVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    aVar12 = null;
                }
                if (aVar12.d().location() == null || (aVar2 = this$0.mMapPlugin) == null) {
                    return;
                }
                com.mappls.sdk.category.viewmodel.a aVar13 = this$0.mViewModel;
                if (aVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar4 = aVar13;
                }
                String strLocation2 = aVar4.d().location();
                Intrinsics.checkNotNull(strLocation2);
                aVar2.a(strLocation2);
                return;
            }
            com.mappls.sdk.category.utils.a aVar14 = this$0.mMapPlugin;
            if (aVar14 != null) {
                com.mappls.sdk.category.viewmodel.a aVar15 = this$0.mViewModel;
                if (aVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    aVar15 = null;
                }
                String strLocation3 = aVar15.d().location();
                double d = 0.0d;
                double d2 = (strLocation3 == null || (listSplit$default2 = StringsKt.split$default((CharSequence) strLocation3, new String[]{","}, false, 0, 6, (Object) null)) == null || (str2 = (String) listSplit$default2.get(0)) == null) ? 0.0d : Double.parseDouble(str2);
                com.mappls.sdk.category.viewmodel.a aVar16 = this$0.mViewModel;
                if (aVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    aVar4 = aVar16;
                }
                String strLocation4 = aVar4.d().location();
                if (strLocation4 != null && (listSplit$default = StringsKt.split$default((CharSequence) strLocation4, new String[]{","}, false, 0, 6, (Object) null)) != null && (str = (String) listSplit$default.get(1)) != null) {
                    d = Double.parseDouble(str);
                }
                aVar14.a(new LatLng(d2, d));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(CategoryResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding = this$0.mBinding;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding2 = null;
        if (mapplsCategoryResultFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding = null;
        }
        mapplsCategoryResultFragmentBinding.mapplsCategoryLayoutEmptyErrorState.setVisibility(8);
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding3 = this$0.mBinding;
        if (mapplsCategoryResultFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            mapplsCategoryResultFragmentBinding2 = mapplsCategoryResultFragmentBinding3;
        }
        mapplsCategoryResultFragmentBinding2.mapplsCategoryProgressLayout.setVisibility(0);
        this$0.callPoi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(CategoryResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ICategoryResultListener iCategoryResultListener = this$0.mCallback;
        if (iCategoryResultListener != null) {
            iCategoryResultListener.onResultCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(CategoryResultFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ICategoryResultListener iCategoryResultListener = this$0.mCallback;
        if (iCategoryResultListener != null) {
            iCategoryResultListener.onResultCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:57:0x0109  */
    /* JADX WARN: Code duplicated, block: B:60:0x0124  */
    /* JADX WARN: Code duplicated, block: B:63:0x0139  */
    public static final void poiAlongRouteObserver$lambda$1(CategoryResultFragment this$0, com.mappls.sdk.category.utils.c cVar) {
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding2;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding3;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding4;
        com.mappls.sdk.category.adapters.b bVar;
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int iOrdinal = cVar.c().ordinal();
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding5 = null;
        com.mappls.sdk.category.adapters.b bVar2 = null;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding6 = null;
        if (iOrdinal == 0) {
            if (cVar.a() != null) {
                List<SuggestedPOI> suggestedPOIs = ((POIAlongRouteResponse) cVar.a()).getSuggestedPOIs();
                Intrinsics.checkNotNullExpressionValue(suggestedPOIs, "it.data.suggestedPOIs");
                if (suggestedPOIs.isEmpty()) {
                    mapplsCategoryResultFragmentBinding = this$0.mBinding;
                    if (mapplsCategoryResultFragmentBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        mapplsCategoryResultFragmentBinding = null;
                    }
                    mapplsCategoryResultFragmentBinding.mapplsCategoryLayoutEmptyErrorState.setVisibility(0);
                    mapplsCategoryResultFragmentBinding2 = this$0.mBinding;
                    if (mapplsCategoryResultFragmentBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        mapplsCategoryResultFragmentBinding2 = null;
                    }
                    mapplsCategoryResultFragmentBinding2.mapplsCategoryTextViewResults.setVisibility(8);
                    mapplsCategoryResultFragmentBinding3 = this$0.mBinding;
                    if (mapplsCategoryResultFragmentBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        mapplsCategoryResultFragmentBinding3 = null;
                    }
                    ((TextView) mapplsCategoryResultFragmentBinding3.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_empty_state)).setText(this$0.getString(R.string.mappls_category_no_results));
                    mapplsCategoryResultFragmentBinding4 = this$0.mBinding;
                    if (mapplsCategoryResultFragmentBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        mapplsCategoryResultFragmentBinding4 = null;
                    }
                    ((TextView) mapplsCategoryResultFragmentBinding4.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_retry)).setVisibility(8);
                    bVar = this$0.poiResultAdapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
                        bVar = null;
                    }
                    bVar.a(new ArrayList());
                } else {
                    MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding7 = this$0.mBinding;
                    if (mapplsCategoryResultFragmentBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        mapplsCategoryResultFragmentBinding7 = null;
                    }
                    mapplsCategoryResultFragmentBinding7.mapplsCategoryLayoutEmptyErrorState.setVisibility(8);
                    this$0.setPoiResultData(this$0.getPOIResultFromAlongRoute(((POIAlongRouteResponse) cVar.a()).getSuggestedPOIs()));
                }
            } else {
                mapplsCategoryResultFragmentBinding = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding = null;
                }
                mapplsCategoryResultFragmentBinding.mapplsCategoryLayoutEmptyErrorState.setVisibility(0);
                mapplsCategoryResultFragmentBinding2 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding2 = null;
                }
                mapplsCategoryResultFragmentBinding2.mapplsCategoryTextViewResults.setVisibility(8);
                mapplsCategoryResultFragmentBinding3 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding3 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding3.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_empty_state)).setText(this$0.getString(R.string.mappls_category_no_results));
                mapplsCategoryResultFragmentBinding4 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding4 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding4.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_retry)).setVisibility(8);
                bVar = this$0.poiResultAdapter;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
                    bVar = null;
                }
                bVar.a(new ArrayList());
            }
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding8 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                mapplsCategoryResultFragmentBinding5 = mapplsCategoryResultFragmentBinding8;
            }
            view = mapplsCategoryResultFragmentBinding5.mapplsCategoryProgressLayout;
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    return;
                }
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding9 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding9 = null;
                }
                mapplsCategoryResultFragmentBinding9.mapplsCategoryLayoutEmptyErrorState.setVisibility(0);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding10 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding10 = null;
                }
                mapplsCategoryResultFragmentBinding10.mapplsCategoryTextViewResults.setVisibility(8);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding11 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding11 = null;
                }
                mapplsCategoryResultFragmentBinding11.mapplsCategoryProgressLayout.setVisibility(8);
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding12 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding12 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding12.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_empty_state)).setText(cVar.b());
                MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding13 = this$0.mBinding;
                if (mapplsCategoryResultFragmentBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    mapplsCategoryResultFragmentBinding13 = null;
                }
                ((TextView) mapplsCategoryResultFragmentBinding13.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_retry)).setVisibility(0);
                com.mappls.sdk.category.adapters.b bVar3 = this$0.poiResultAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
                } else {
                    bVar2 = bVar3;
                }
                bVar2.a(new ArrayList());
                return;
            }
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding14 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                mapplsCategoryResultFragmentBinding14 = null;
            }
            mapplsCategoryResultFragmentBinding14.mapplsCategoryLayoutEmptyErrorState.setVisibility(8);
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding15 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                mapplsCategoryResultFragmentBinding15 = null;
            }
            mapplsCategoryResultFragmentBinding15.mapplsCategoryProgressLayout.setVisibility(0);
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding16 = this$0.mBinding;
            if (mapplsCategoryResultFragmentBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                mapplsCategoryResultFragmentBinding6 = mapplsCategoryResultFragmentBinding16;
            }
            view = mapplsCategoryResultFragmentBinding6.mapplsCategoryTextViewResults;
        }
        view.setVisibility(8);
    }

    private final void setPoiResultData(List<? extends PoiResult> list) {
        TextView textView;
        int i;
        com.mappls.sdk.category.adapters.b bVar = this.poiResultAdapter;
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
            bVar = null;
        }
        bVar.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add((PoiResult) it2.next());
        }
        ICategoryResultListener iCategoryResultListener = this.mCallback;
        if (iCategoryResultListener != null) {
            iCategoryResultListener.onCategoryResult(arrayList);
        }
        if (list.isEmpty()) {
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding2 = this.mBinding;
            if (mapplsCategoryResultFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                mapplsCategoryResultFragmentBinding = mapplsCategoryResultFragmentBinding2;
            }
            textView = mapplsCategoryResultFragmentBinding.mapplsCategoryTextViewResults;
            i = 8;
        } else {
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding3 = this.mBinding;
            if (mapplsCategoryResultFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                mapplsCategoryResultFragmentBinding3 = null;
            }
            mapplsCategoryResultFragmentBinding3.mapplsCategoryTextViewResults.setText(list.size() + "  results found");
            MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding4 = this.mBinding;
            if (mapplsCategoryResultFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                mapplsCategoryResultFragmentBinding = mapplsCategoryResultFragmentBinding4;
            }
            textView = mapplsCategoryResultFragmentBinding.mapplsCategoryTextViewResults;
            i = 0;
        }
        textView.setVisibility(i);
        com.mappls.sdk.category.utils.a aVar = this.mMapPlugin;
        if (aVar != null) {
            aVar.a(list, this.iconMap);
        }
        showResults(list);
    }

    private final void showResults(List<? extends PoiResult> list) {
        MapplsMap mapplsMap;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PoiResult poiResult : list) {
            if (poiResult.getLatitude() == null || poiResult.getLongitude() == null) {
                String mapplsPin = poiResult.getMapplsPin();
                Intrinsics.checkNotNullExpressionValue(mapplsPin, "it.mapplsPin");
                arrayList2.add(mapplsPin);
            } else {
                Double latitude = poiResult.getLatitude();
                Intrinsics.checkNotNullExpressionValue(latitude, "it.latitude");
                double dDoubleValue = latitude.doubleValue();
                Double longitude = poiResult.getLongitude();
                Intrinsics.checkNotNullExpressionValue(longitude, "it.longitude");
                arrayList.add(new LatLng(dDoubleValue, longitude.doubleValue()));
            }
        }
        if (arrayList.size() > 1) {
            MapplsMap mapplsMap2 = this.mMapplsMap;
            if (mapplsMap2 != null) {
                mapplsMap2.animateCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds.Builder().includes(arrayList).build(), 10, 10, 10, 200));
                return;
            }
            return;
        }
        if (arrayList2.size() <= 1 || (mapplsMap = this.mMapplsMap) == null) {
            return;
        }
        mapplsMap.animateCamera(CameraMapplsPinUpdateFactory.newMapplsPinBounds(arrayList2, 10, 10, 10, 200));
    }

    private final void storeCategoryNames() {
        com.mappls.sdk.category.viewmodel.a aVar = this.mViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        List<CategoryCode> listF = aVar.f();
        if (listF != null) {
            for (CategoryCode categoryCode : listF) {
                List<String> categoryCode2 = categoryCode.getCategoryCode();
                if (categoryCode2 != null) {
                    Intrinsics.checkNotNullExpressionValue(categoryCode2, "categoryCode");
                    for (String it2 : categoryCode2) {
                        com.mappls.sdk.category.viewmodel.a aVar2 = this.mViewModel;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                            aVar2 = null;
                        }
                        LinkedHashMap linkedHashMapB = aVar2.b();
                        Intrinsics.checkNotNullExpressionValue(it2, "it");
                        String category = categoryCode.getCategory();
                        Intrinsics.checkNotNullExpressionValue(category, "categoryCode.category");
                        linkedHashMapB.put(it2, category);
                    }
                }
            }
        }
    }

    private final void subscribeViewModel() {
        com.mappls.sdk.category.viewmodel.a aVar = this.mViewModel;
        com.mappls.sdk.category.viewmodel.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar = null;
        }
        aVar.a().observe(getViewLifecycleOwner(), this.poiAlongRouteObserver);
        com.mappls.sdk.category.viewmodel.a aVar3 = this.mViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.c().observe(getViewLifecycleOwner(), this.nearbyObserver);
    }

    @Override // com.mappls.sdk.plugin.annotation.OnAnnotationClickListener
    public boolean onAnnotationClick(Symbol symbol) {
        JsonElement data;
        if (symbol == null || (data = symbol.getData()) == null || !data.isJsonObject()) {
            return false;
        }
        JsonElement data2 = symbol.getData();
        Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.google.gson.JsonObject");
        JsonObject jsonObject = (JsonObject) data2;
        ICategoryResultListener iCategoryResultListener = this.mCallback;
        if (iCategoryResultListener == null) {
            return false;
        }
        Object objFromJson = new Gson().fromJson(jsonObject.get("com.mappls.sdk.category.plugin.NEARBY_RESULT_DATA").getAsString(), (Class<Object>) PoiResult.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(\n       …ss.java\n                )");
        iCategoryResultListener.onCategorySelectedResult((PoiResult) objFromJson);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBindingInflate = MapplsCategoryResultFragmentBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(mapplsCategoryResultFragmentBindingInflate, "inflate(inflater, container, false)");
        this.mBinding = mapplsCategoryResultFragmentBindingInflate;
        if (mapplsCategoryResultFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBindingInflate = null;
        }
        View root = mapplsCategoryResultFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.mappls.sdk.category.utils.a aVar = this.mMapPlugin;
        if (aVar != null) {
            aVar.a();
        }
        com.mappls.sdk.category.utils.a aVar2 = this.mMapPlugin;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(final MapplsMap mapplsMap) {
        Intrinsics.checkNotNullParameter(mapplsMap, "mapplsMap");
        this.mMapplsMap = mapplsMap;
        UiSettings uiSettings = mapplsMap.getUiSettings();
        if (uiSettings != null) {
            uiSettings.setLogoMargins(0, 0, 0, TypedValues.CycleType.TYPE_EASING);
        }
        callPoi();
        initialiseMapCamera();
        mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.category.fragment.CategoryResultFragment$$ExternalSyntheticLambda0
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public final void onStyleLoaded(Style style) {
                CategoryResultFragment.onMapReady$lambda$18(this.f$0, mapplsMap, style);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CategoryCode categoryCode;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.mViewModel = (com.mappls.sdk.category.viewmodel.a) new ViewModelProvider(this).get(com.mappls.sdk.category.viewmodel.a.class);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new b());
        Bundle arguments = getArguments();
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding = null;
        if (arguments != null) {
            com.mappls.sdk.category.viewmodel.a aVar = this.mViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar = null;
            }
            SearchCategoryUIOption searchCategoryUIOptionD = (SearchCategoryUIOption) arguments.getParcelable("com.mappls.sdk.category.CATEGORY_UI_OPTION");
            if (searchCategoryUIOptionD == null) {
                searchCategoryUIOptionD = com.mappls.sdk.category.a.d();
            }
            aVar.a(searchCategoryUIOptionD);
            com.mappls.sdk.category.viewmodel.a aVar2 = this.mViewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar2 = null;
            }
            aVar2.a(arguments.getParcelableArrayList("com.mappls.sdk.category.SELECTED_CATEGORY_CODES"));
            arguments.clear();
        }
        subscribeViewModel();
        StringBuilder sb = new StringBuilder();
        com.mappls.sdk.category.viewmodel.a aVar3 = this.mViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar3 = null;
        }
        List<CategoryCode> listF = aVar3.f();
        Integer numValueOf = listF != null ? Integer.valueOf(listF.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        for (int i = 0; i < iIntValue; i++) {
            com.mappls.sdk.category.viewmodel.a aVar4 = this.mViewModel;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar4 = null;
            }
            List<CategoryCode> listF2 = aVar4.f();
            sb.append(String.valueOf((listF2 == null || (categoryCode = listF2.get(i)) == null) ? null : categoryCode.getCategory()));
            com.mappls.sdk.category.viewmodel.a aVar5 = this.mViewModel;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar5 = null;
            }
            List<CategoryCode> listF3 = aVar5.f();
            Integer numValueOf2 = listF3 != null ? Integer.valueOf(listF3.size()) : null;
            Intrinsics.checkNotNull(numValueOf2);
            if (i != numValueOf2.intValue() - 1) {
                sb.append(",");
            }
        }
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding2 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding2 = null;
        }
        mapplsCategoryResultFragmentBinding2.mapplsCategoryResultSearchInput.setText(sb);
        MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.getMapAsync(this);
        }
        ArrayList arrayList = new ArrayList();
        com.mappls.sdk.category.viewmodel.a aVar6 = this.mViewModel;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar6 = null;
        }
        this.poiResultAdapter = new com.mappls.sdk.category.adapters.b(arrayList, aVar6.e(), new c());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding3 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding3 = null;
        }
        mapplsCategoryResultFragmentBinding3.mapplsCategoryPoiList.setLayoutManager(linearLayoutManager);
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding4 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding4 = null;
        }
        RecyclerView recyclerView = mapplsCategoryResultFragmentBinding4.mapplsCategoryPoiList;
        com.mappls.sdk.category.adapters.b bVar = this.poiResultAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("poiResultAdapter");
            bVar = null;
        }
        recyclerView.setAdapter(bVar);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.mappls_search_bottom_sheet_bg);
        if (drawable != null) {
            com.mappls.sdk.category.viewmodel.a aVar7 = this.mViewModel;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar7 = null;
            }
            Integer numBackgroundColor = aVar7.e().backgroundColor();
            Intrinsics.checkNotNullExpressionValue(numBackgroundColor, "mViewModel.searchUiOption.backgroundColor()");
            drawable.setColorFilter(new PorterDuffColorFilter(numBackgroundColor.intValue(), PorterDuff.Mode.SRC_IN));
        }
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding5 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding5 = null;
        }
        mapplsCategoryResultFragmentBinding5.mapplsCategoryPoiListBottomSheetContainer.setBackground(drawable);
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding6 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding6 = null;
        }
        TextView textView = (TextView) mapplsCategoryResultFragmentBinding6.mapplsCategoryProgressLayout.findViewById(R.id.mappls_category_description_text);
        com.mappls.sdk.category.viewmodel.a aVar8 = this.mViewModel;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar8 = null;
        }
        Integer numResultMessageTextColor = aVar8.e().resultMessageTextColor();
        Intrinsics.checkNotNullExpressionValue(numResultMessageTextColor, "mViewModel.searchUiOption.resultMessageTextColor()");
        textView.setTextColor(numResultMessageTextColor.intValue());
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding7 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding7 = null;
        }
        TextView textView2 = mapplsCategoryResultFragmentBinding7.mapplsCategoryTextViewResults;
        com.mappls.sdk.category.viewmodel.a aVar9 = this.mViewModel;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar9 = null;
        }
        Integer numResultCountTextColor = aVar9.e().resultCountTextColor();
        Intrinsics.checkNotNullExpressionValue(numResultCountTextColor, "mViewModel.searchUiOption.resultCountTextColor()");
        textView2.setTextColor(numResultCountTextColor.intValue());
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding8 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding8 = null;
        }
        TextView textView3 = (TextView) mapplsCategoryResultFragmentBinding8.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_empty_state);
        com.mappls.sdk.category.viewmodel.a aVar10 = this.mViewModel;
        if (aVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar10 = null;
        }
        Integer numResultMessageTextColor2 = aVar10.e().resultMessageTextColor();
        Intrinsics.checkNotNullExpressionValue(numResultMessageTextColor2, "mViewModel.searchUiOption.resultMessageTextColor()");
        textView3.setTextColor(numResultMessageTextColor2.intValue());
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding9 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding9 = null;
        }
        ((TextView) mapplsCategoryResultFragmentBinding9.mapplsCategoryLayoutEmptyErrorState.findViewById(R.id.mappls_category_text_view_retry)).setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.fragment.CategoryResultFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategoryResultFragment.onViewCreated$lambda$5(this.f$0, view2);
            }
        });
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding10 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding10 = null;
        }
        AppBarLayout appBarLayout = mapplsCategoryResultFragmentBinding10.resultAppbar;
        com.mappls.sdk.category.viewmodel.a aVar11 = this.mViewModel;
        if (aVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            aVar11 = null;
        }
        Integer numBackgroundColor2 = aVar11.e().backgroundColor();
        Intrinsics.checkNotNullExpressionValue(numBackgroundColor2, "mViewModel.searchUiOption.backgroundColor()");
        appBarLayout.setBackgroundColor(numBackgroundColor2.intValue());
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding11 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            mapplsCategoryResultFragmentBinding11 = null;
        }
        mapplsCategoryResultFragmentBinding11.mapplsCategoryResultBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.fragment.CategoryResultFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategoryResultFragment.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
        MapplsCategoryResultFragmentBinding mapplsCategoryResultFragmentBinding12 = this.mBinding;
        if (mapplsCategoryResultFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            mapplsCategoryResultFragmentBinding = mapplsCategoryResultFragmentBinding12;
        }
        mapplsCategoryResultFragmentBinding.mapplsCategorySearchClearBtn.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.fragment.CategoryResultFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CategoryResultFragment.onViewCreated$lambda$7(this.f$0, view2);
            }
        });
        storeCategoryNames();
    }

    public final void setCategoryResultListener(ICategoryResultListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }

    public final void setMapView(MapView mapView) {
        MapView mapView2;
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.mMapView = mapView;
        if (!isAdded() || (mapView2 = this.mMapView) == null) {
            return;
        }
        mapView2.getMapAsync(this);
    }
}
