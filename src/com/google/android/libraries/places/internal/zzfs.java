package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Place;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfs {
    private static final zzma zza;

    static {
        zzlz zzlzVar = new zzlz();
        zzlzVar.zza(Place.Field.ADDRESS, "formattedAddress");
        zzlzVar.zza(Place.Field.ADDRESS_COMPONENTS, "addressComponents");
        zzlzVar.zza(Place.Field.BUSINESS_STATUS, "businessStatus");
        zzlzVar.zza(Place.Field.CURBSIDE_PICKUP, "curbsidePickup");
        zzlzVar.zza(Place.Field.CURRENT_OPENING_HOURS, "currentOpeningHours");
        zzlzVar.zza(Place.Field.DELIVERY, "delivery");
        zzlzVar.zza(Place.Field.DINE_IN, "dineIn");
        zzlzVar.zza(Place.Field.EDITORIAL_SUMMARY, "editorialSummary");
        zzlzVar.zza(Place.Field.ICON_BACKGROUND_COLOR, "iconBackgroundColor");
        zzlzVar.zza(Place.Field.ICON_URL, "iconMaskBaseUri");
        zzlzVar.zza(Place.Field.ID, "id");
        zzlzVar.zza(Place.Field.LAT_LNG, FirebaseAnalytics.Param.LOCATION);
        zzlzVar.zza(Place.Field.NAME, "displayName");
        zzlzVar.zza(Place.Field.OPENING_HOURS, "regularOpeningHours");
        zzlzVar.zza(Place.Field.PHONE_NUMBER, "internationalPhoneNumber");
        zzlzVar.zza(Place.Field.PHOTO_METADATAS, "photos");
        zzlzVar.zza(Place.Field.PLUS_CODE, "plusCode");
        zzlzVar.zza(Place.Field.PRICE_LEVEL, "priceLevel");
        zzlzVar.zza(Place.Field.RATING, "rating");
        zzlzVar.zza(Place.Field.RESERVABLE, "reservable");
        zzlzVar.zza(Place.Field.REVIEWS, "reviews");
        zzlzVar.zza(Place.Field.SECONDARY_OPENING_HOURS, "regularSecondaryOpeningHours");
        zzlzVar.zza(Place.Field.SERVES_BEER, "servesBeer");
        zzlzVar.zza(Place.Field.SERVES_BREAKFAST, "servesBreakfast");
        zzlzVar.zza(Place.Field.SERVES_BRUNCH, "servesBrunch");
        zzlzVar.zza(Place.Field.SERVES_DINNER, "servesDinner");
        zzlzVar.zza(Place.Field.SERVES_LUNCH, "servesLunch");
        zzlzVar.zza(Place.Field.SERVES_VEGETARIAN_FOOD, "servesVegetarianFood");
        zzlzVar.zza(Place.Field.SERVES_WINE, "servesWine");
        zzlzVar.zza(Place.Field.TAKEOUT, "takeout");
        zzlzVar.zza(Place.Field.TYPES, "types");
        zzlzVar.zza(Place.Field.USER_RATINGS_TOTAL, "userRatingCount");
        zzlzVar.zza(Place.Field.UTC_OFFSET, "utcOffsetMinutes");
        zzlzVar.zza(Place.Field.VIEWPORT, "viewport");
        zzlzVar.zza(Place.Field.WEBSITE_URI, "websiteUri");
        zzlzVar.zza(Place.Field.WHEELCHAIR_ACCESSIBLE_ENTRANCE, "accessibilityOptions");
        zza = zzlzVar.zzc();
    }

    public static String zza(List list) {
        return zzd(list, true);
    }

    public static String zzb(List list) {
        return zzd(list, false);
    }

    public static List zzc(List list) {
        return zze(list, true);
    }

    private static String zzd(List list, boolean z) {
        if (list.isEmpty()) {
            return "";
        }
        List listZze = zze(list, z);
        listZze.add(true != z ? "attributions" : "places.attributions");
        return zzki.zzc(",").zzd().zzf(listZze);
    }

    private static List zze(List list, boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String strConcat = (String) zza.get((Place.Field) it2.next());
            if (strConcat != null) {
                if (z) {
                    strConcat = "places.".concat(strConcat);
                }
                arrayList.add(strConcat);
            }
        }
        return arrayList;
    }
}
