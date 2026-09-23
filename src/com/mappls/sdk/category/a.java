package com.mappls.sdk.category;

import com.mappls.sdk.category.model.SearchCategoryOption;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    private static SearchCategoryOption a;
    private static SearchCategoryUIOption b;
    private static List<? extends CategoryCode> c;

    static {
        SearchCategoryOption searchCategoryOptionBuild = SearchCategoryOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(searchCategoryOptionBuild, "builder().build()");
        a = searchCategoryOptionBuild;
        SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
        b = searchCategoryUIOptionBuild;
        c = CollectionsKt.arrayListOf(new CategoryCode("Coffee", R.drawable.mappls_category_icon_coffee, CollectionsKt.arrayListOf("FODCOF"), R.drawable.mappls_category_ic_map_coffee), new CategoryCode("Restaurant", R.drawable.mappls_category_icon_restaurant, CollectionsKt.arrayListOf("FODOTH"), R.drawable.mappls_category_ic_map_restaurant), new CategoryCode("Pubs & Bars", R.drawable.mappls_category_icon_bar, CollectionsKt.arrayListOf("FODPUB"), R.drawable.mappls_category_ic_map_pub), new CategoryCode("ATMs", R.drawable.mappls_category_icon_atm, CollectionsKt.arrayListOf("FINATM"), R.drawable.mappls_category_ic_map_atm), new CategoryCode("Pharmacy", R.drawable.mappls_category_icon_chemist, CollectionsKt.arrayListOf("HLTMDS"), R.drawable.mappls_category_ic_map_pharmacy), new CategoryCode("Parking", R.drawable.mappls_category_icon_parking, CollectionsKt.arrayListOf("TRNPRK"), R.drawable.mappls_category_ic_map_parking), new CategoryCode("EV Charging", R.drawable.mappls_category_icon_ev, CollectionsKt.arrayListOf("TRNECS"), R.drawable.mappls_category_ic_map_ev), new CategoryCode("Petrol Pump", R.drawable.mappls_category_icon_petrol, CollectionsKt.arrayListOf("TRNPMP"), R.drawable.mappls_category_ic_map_petrol), new CategoryCode("Transport", R.drawable.mappls_category_icon_transport, CollectionsKt.arrayListOf("TRNPRK"), R.drawable.mappls_category_ic_map_transport), new CategoryCode("Entertainment", R.drawable.mappls_category_icon_entertainment, CollectionsKt.arrayListOf("RCNCIN"), R.drawable.mappls_category_ic_map_entertainment), new CategoryCode("Hotels", R.drawable.mappls_category_icon_hotel, CollectionsKt.arrayListOf("HOTALL"), R.drawable.mappls_category_ic_map_hotel), new CategoryCode("Shopping", R.drawable.mappls_category_icon_shopping, CollectionsKt.arrayListOf("SHPRTC"), R.drawable.mappls_category_ic_map_shopping), new CategoryCode("Groceries", R.drawable.mappls_category_icon_groceries, CollectionsKt.arrayListOf("SHPMAN"), R.drawable.mappls_category_ic_map_groceries), new CategoryCode("Hospitals", R.drawable.mappls_category_icon_hospital, CollectionsKt.arrayListOf("HLTHSP"), R.drawable.mappls_category_ic_map_hospital), new CategoryCode("Police Stations", R.drawable.mappls_category_icon_police, CollectionsKt.arrayListOf("COMPOL"), R.drawable.mappls_category_ic_map_police), new CategoryCode("Post Offices", R.drawable.mappls_category_icon_postoffice, CollectionsKt.arrayListOf("COMPTO"), R.drawable.mappls_category_ic_map_postoffice), new CategoryCode("Banks", R.drawable.mappls_category_icon_bank, CollectionsKt.arrayListOf("FINBNK"), R.drawable.mappls_category_ic_map_bank), new CategoryCode("Spas", R.drawable.mappls_category_icon_spa, CollectionsKt.arrayListOf("HLTSPA"), R.drawable.mappls_category_ic_map_spa), new CategoryCode("Toilets", R.drawable.mappls_category_icon_wc, CollectionsKt.arrayListOf("COMPUB"), R.drawable.mappls_category_ic_map_wc), new CategoryCode("CNG Station", R.drawable.mappls_category_icon_cng, CollectionsKt.arrayListOf("TRNCNG"), R.drawable.mappls_category_ic_map_cng));
    }

    public static void a() {
        SearchCategoryOption searchCategoryOptionBuild = SearchCategoryOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(searchCategoryOptionBuild, "builder().build()");
        a = searchCategoryOptionBuild;
        SearchCategoryUIOption searchCategoryUIOptionBuild = SearchCategoryUIOption.builder().build();
        Intrinsics.checkNotNullExpressionValue(searchCategoryUIOptionBuild, "builder().build()");
        b = searchCategoryUIOptionBuild;
        c = CollectionsKt.arrayListOf(new CategoryCode("Coffee", R.drawable.mappls_category_icon_coffee, CollectionsKt.arrayListOf("FODCOF"), R.drawable.mappls_category_ic_map_coffee), new CategoryCode("Restaurant", R.drawable.mappls_category_icon_restaurant, CollectionsKt.arrayListOf("FODIND"), R.drawable.mappls_category_ic_map_restaurant), new CategoryCode("Pubs & Bars", R.drawable.mappls_category_icon_bar, CollectionsKt.arrayListOf("FODPUB"), R.drawable.mappls_category_ic_map_pub), new CategoryCode("ATMs", R.drawable.mappls_category_icon_atm, CollectionsKt.arrayListOf("FINATM"), R.drawable.mappls_category_ic_map_atm), new CategoryCode("Pharmacy", R.drawable.mappls_category_icon_chemist, CollectionsKt.arrayListOf("HLTMDS"), R.drawable.mappls_category_ic_map_pharmacy), new CategoryCode("Parking", R.drawable.mappls_category_icon_parking, CollectionsKt.arrayListOf("TRNPRK"), R.drawable.mappls_category_ic_map_parking), new CategoryCode("EV Charging", R.drawable.mappls_category_icon_ev, CollectionsKt.arrayListOf("TRNECS"), R.drawable.mappls_category_ic_map_ev), new CategoryCode("Petrol Pump", R.drawable.mappls_category_icon_petrol, CollectionsKt.arrayListOf("TRNPMP"), R.drawable.mappls_category_ic_map_petrol), new CategoryCode("Transport", R.drawable.mappls_category_icon_transport, CollectionsKt.arrayListOf("TRNPRK"), R.drawable.mappls_category_ic_map_transport), new CategoryCode("Entertainment", R.drawable.mappls_category_icon_entertainment, CollectionsKt.arrayListOf("RCNCIN"), R.drawable.mappls_category_ic_map_entertainment), new CategoryCode("Hotels", R.drawable.mappls_category_icon_hotel, CollectionsKt.arrayListOf("HOTALL"), R.drawable.mappls_category_ic_map_hotel), new CategoryCode("Shopping", R.drawable.mappls_category_icon_shopping, CollectionsKt.arrayListOf("SHPRTC"), R.drawable.mappls_category_ic_map_shopping), new CategoryCode("Groceries", R.drawable.mappls_category_icon_groceries, CollectionsKt.arrayListOf("SHPMAN"), R.drawable.mappls_category_ic_map_groceries), new CategoryCode("Hospitals", R.drawable.mappls_category_icon_hospital, CollectionsKt.arrayListOf("HLTHSP"), R.drawable.mappls_category_ic_map_hospital), new CategoryCode("Police Stations", R.drawable.mappls_category_icon_police, CollectionsKt.arrayListOf("COMPOL"), R.drawable.mappls_category_ic_map_police), new CategoryCode("Post Offices", R.drawable.mappls_category_icon_postoffice, CollectionsKt.arrayListOf("COMPTO"), R.drawable.mappls_category_ic_map_postoffice), new CategoryCode("Banks", R.drawable.mappls_category_icon_bank, CollectionsKt.arrayListOf("FINBNK"), R.drawable.mappls_category_ic_map_bank), new CategoryCode("Spas", R.drawable.mappls_category_icon_spa, CollectionsKt.arrayListOf("HLTSPA"), R.drawable.mappls_category_ic_map_spa), new CategoryCode("Toilets", R.drawable.mappls_category_icon_wc, CollectionsKt.arrayListOf("COMPUB"), R.drawable.mappls_category_ic_map_wc), new CategoryCode("CNG Station", R.drawable.mappls_category_icon_cng, CollectionsKt.arrayListOf("TRNCNG"), R.drawable.mappls_category_ic_map_cng));
    }

    public static void a(SearchCategoryOption searchCategoryOption) {
        Intrinsics.checkNotNullParameter(searchCategoryOption, "<set-?>");
        a = searchCategoryOption;
    }

    public static void a(SearchCategoryUIOption searchCategoryUIOption) {
        Intrinsics.checkNotNullParameter(searchCategoryUIOption, "<set-?>");
        b = searchCategoryUIOption;
    }

    public static void a(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        c = list;
    }

    public static List b() {
        return c;
    }

    public static SearchCategoryOption c() {
        return a;
    }

    public static SearchCategoryUIOption d() {
        return b;
    }
}
