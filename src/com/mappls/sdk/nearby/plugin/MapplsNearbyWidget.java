package com.mappls.sdk.nearby.plugin;

import android.app.Activity;
import android.content.Intent;
import com.google.gson.Gson;
import com.mappls.sdk.nearby.plugin.model.NearbyOption;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MapplsNearbyWidget {
    public static final MapplsNearbyWidget INSTANCE = new MapplsNearbyWidget();
    private static List<? extends CategoryCode> categoryList;
    private static NearbyOption nearbyOption;
    private static NearbyUIOption nearbyUIOption;

    public static final class IntentBuilder {
        private final Intent intent = new Intent();

        public IntentBuilder() {
            MapplsNearbyWidget.INSTANCE.clear$mappls_nearby_widget_othersRelease();
        }

        public final Intent build(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.intent.setClass(activity, MapplsNearbyActivity.class);
            return this.intent;
        }

        public final IntentBuilder nearbyOptions(NearbyOption nearbyOption) {
            Intrinsics.checkNotNullParameter(nearbyOption, "nearbyOption");
            MapplsNearbyWidget.INSTANCE.setNearbyOption$mappls_nearby_widget_othersRelease(nearbyOption);
            return this;
        }

        public final IntentBuilder nearbyUIOptions(NearbyUIOption nearbyUIOption) {
            Intrinsics.checkNotNullParameter(nearbyUIOption, "nearbyUIOption");
            MapplsNearbyWidget.INSTANCE.setNearbyUIOption$mappls_nearby_widget_othersRelease(nearbyUIOption);
            return this;
        }

        public final IntentBuilder setCategoryList(List<? extends CategoryCode> categories) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            MapplsNearbyWidget.INSTANCE.setCategoryList$mappls_nearby_widget_othersRelease(categories);
            return this;
        }
    }

    static {
        NearbyOption nearbyOptionBuild = NearbyOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(nearbyOptionBuild, "builder().build()");
        nearbyOption = nearbyOptionBuild;
        NearbyUIOption nearbyUIOptionBuild = NearbyUIOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(nearbyUIOptionBuild, "builder().build()");
        nearbyUIOption = nearbyUIOptionBuild;
        categoryList = CollectionsKt.arrayListOf(new CategoryCode("Coffee", R.drawable.mappls_nearby_coffee_icon, (List<String>) CollectionsKt.arrayListOf("FODCOF"), R.drawable.mappls_nearby_coffee_marker, true), new CategoryCode("Restaurants", R.drawable.mappls_nearby_restaurant_icon, CollectionsKt.arrayListOf("FODOTH", "FODOTL", "FODIND", "FODCON", "FODFFD", "FODBAK"), R.drawable.mappls_nearby_restaurant_marker), new CategoryCode("Pubs & Bars", R.drawable.mappls_nearby_bar_icon, CollectionsKt.arrayListOf("FODPUB"), R.drawable.mappls_nearby_pub_marker), new CategoryCode("Parking", R.drawable.mappls_nearby_parking_icon, CollectionsKt.arrayListOf("PRKSRF", "PRKWPM", "PRKRDS", "PRKMBK", "TRNPRK", "PRKUNG", "PRKTRK", "PRKCYC", "PRKMLT"), R.drawable.mappls_nearby_parking_marker), new CategoryCode("ATMs", R.drawable.mappls_nearby_atm_icon, CollectionsKt.arrayListOf("FINATM"), R.drawable.mappls_nearby_atm_marker), new CategoryCode("Pharmacy", R.drawable.mappls_nearby_pharmacy_icon, CollectionsKt.arrayListOf("HLTMDS", "SHPCOM", "MDS24H", "MDSJAN", "COMHDO"), R.drawable.mappls_nearby_pharmacy_marker), new CategoryCode("Transport", R.drawable.mappls_nearby_transport_icon, CollectionsKt.arrayListOf("TRNBUS", "TRNOTH", "TRNTRO", "TRNTXI", "TRNRAL", "TRNCAR", "TRNBST", "TRNMET"), R.drawable.mappls_nearby_transport_marker), new CategoryCode("Hospitals", R.drawable.mappls_nearby_hospital_icon, CollectionsKt.arrayListOf("HSPHMH", "HSPVTH", "HSPEYH", "HSPDNH", "HSPCHD", "HSPMAT", "HSPORH", "HSPHMH", "HSPENT", "HSPHRH"), R.drawable.mappls_nearby_hospital_marker), new CategoryCode("Hotels", R.drawable.mappls_nearby_hotel_icon, CollectionsKt.arrayListOf("HOTALL", "HOTHST", "HOTYTH", "HOTRES", "HOTNOP", "HOTSAP", "HOTPRE", "HOTHRG"), R.drawable.mappls_nearby_hotel_marker));
    }

    private MapplsNearbyWidget() {
    }

    @JvmStatic
    public static final NearbyAtlasResult getNearbyResponse(Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String stringExtra = data.getStringExtra("com.mappls.sdk.nearby.plugin.NEARBY_RESULT_KEY");
        if (stringExtra == null) {
            return null;
        }
        return (NearbyAtlasResult) new Gson().fromJson(stringExtra, NearbyAtlasResult.class);
    }

    public final void clear$mappls_nearby_widget_othersRelease() {
        NearbyOption nearbyOptionBuild = NearbyOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(nearbyOptionBuild, "builder().build()");
        nearbyOption = nearbyOptionBuild;
        NearbyUIOption nearbyUIOptionBuild = NearbyUIOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(nearbyUIOptionBuild, "builder().build()");
        nearbyUIOption = nearbyUIOptionBuild;
        categoryList = CollectionsKt.arrayListOf(new CategoryCode("Coffee", R.drawable.mappls_nearby_coffee_icon, (List<String>) CollectionsKt.arrayListOf("FODCOF"), R.drawable.mappls_nearby_coffee_marker, true), new CategoryCode("Restaurants", R.drawable.mappls_nearby_restaurant_icon, CollectionsKt.arrayListOf("FODOTH", "FODOTL", "FODIND", "FODCON", "FODFFD", "FODBAK"), R.drawable.mappls_nearby_restaurant_marker), new CategoryCode("Pubs & Bars", R.drawable.mappls_nearby_bar_icon, CollectionsKt.arrayListOf("FODPUB"), R.drawable.mappls_nearby_pub_marker), new CategoryCode("Parking", R.drawable.mappls_nearby_parking_icon, CollectionsKt.arrayListOf("PRKSRF", "PRKWPM", "PRKRDS", "PRKMBK", "TRNPRK", "PRKUNG", "PRKTRK", "PRKCYC", "PRKMLT"), R.drawable.mappls_nearby_parking_marker), new CategoryCode("ATMs", R.drawable.mappls_nearby_atm_icon, CollectionsKt.arrayListOf("FINATM"), R.drawable.mappls_nearby_atm_marker), new CategoryCode("Pharmacy", R.drawable.mappls_nearby_pharmacy_icon, CollectionsKt.arrayListOf("HLTMDS", "SHPCOM", "MDS24H", "MDSJAN", "COMHDO"), R.drawable.mappls_nearby_pharmacy_marker), new CategoryCode("Transport", R.drawable.mappls_nearby_transport_icon, CollectionsKt.arrayListOf("TRNBUS", "TRNOTH", "TRNTRO", "TRNTXI", "TRNRAL", "TRNCAR", "TRNBST", "TRNMET"), R.drawable.mappls_nearby_transport_marker), new CategoryCode("Hospitals", R.drawable.mappls_nearby_hospital_icon, CollectionsKt.arrayListOf("HSPHMH", "HSPVTH", "HSPEYH", "HSPDNH", "HSPCHD", "HSPMAT", "HSPORH", "HSPHMH", "HSPENT", "HSPHRH"), R.drawable.mappls_nearby_hospital_marker), new CategoryCode("Hotels", R.drawable.mappls_nearby_hotel_icon, CollectionsKt.arrayListOf("HOTALL", "HOTHST", "HOTYTH", "HOTRES", "HOTNOP", "HOTSAP", "HOTPRE", "HOTHRG"), R.drawable.mappls_nearby_hotel_marker));
    }

    public final List<CategoryCode> getCategoryList() {
        return categoryList;
    }

    public final List<CategoryCode> getCategoryList$mappls_nearby_widget_othersRelease() {
        return categoryList;
    }

    public final NearbyOption getNearbyOption() {
        return nearbyOption;
    }

    public final NearbyOption getNearbyOption$mappls_nearby_widget_othersRelease() {
        return nearbyOption;
    }

    public final NearbyUIOption getNearbyUIOption() {
        return nearbyUIOption;
    }

    public final NearbyUIOption getNearbyUIOption$mappls_nearby_widget_othersRelease() {
        return nearbyUIOption;
    }

    public final void setCategoryList$mappls_nearby_widget_othersRelease(List<? extends CategoryCode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        categoryList = list;
    }

    public final void setNearbyOption$mappls_nearby_widget_othersRelease(NearbyOption nearbyOption2) {
        Intrinsics.checkNotNullParameter(nearbyOption2, "<set-?>");
        nearbyOption = nearbyOption2;
    }

    public final void setNearbyUIOption$mappls_nearby_widget_othersRelease(NearbyUIOption nearbyUIOption2) {
        Intrinsics.checkNotNullParameter(nearbyUIOption2, "<set-?>");
        nearbyUIOption = nearbyUIOption2;
    }
}
