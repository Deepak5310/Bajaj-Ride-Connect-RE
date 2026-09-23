package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhh {
    private static final zzma zza;

    static {
        zzlz zzlzVar = new zzlz();
        zzlzVar.zza(Place.Field.ADDRESS, "formatted_address");
        zzlzVar.zza(Place.Field.ADDRESS_COMPONENTS, "address_components");
        zzlzVar.zza(Place.Field.BUSINESS_STATUS, "business_status");
        zzlzVar.zza(Place.Field.CURBSIDE_PICKUP, "curbside_pickup");
        zzlzVar.zza(Place.Field.CURRENT_OPENING_HOURS, "current_opening_hours");
        zzlzVar.zza(Place.Field.DELIVERY, "delivery");
        zzlzVar.zza(Place.Field.DINE_IN, "dine_in");
        zzlzVar.zza(Place.Field.EDITORIAL_SUMMARY, "editorial_summary");
        zzlzVar.zza(Place.Field.ICON_BACKGROUND_COLOR, "icon_background_color");
        zzlzVar.zza(Place.Field.ICON_URL, "icon_mask_base_uri");
        zzlzVar.zza(Place.Field.ID, "place_id");
        zzlzVar.zza(Place.Field.LAT_LNG, "geometry/location");
        zzlzVar.zza(Place.Field.NAME, "name");
        zzlzVar.zza(Place.Field.OPENING_HOURS, "opening_hours");
        zzlzVar.zza(Place.Field.PHONE_NUMBER, "international_phone_number");
        zzlzVar.zza(Place.Field.PHOTO_METADATAS, "photos");
        zzlzVar.zza(Place.Field.PLUS_CODE, PlaceTypes.PLUS_CODE);
        zzlzVar.zza(Place.Field.PRICE_LEVEL, "price_level");
        zzlzVar.zza(Place.Field.RATING, "rating");
        zzlzVar.zza(Place.Field.RESERVABLE, "reservable");
        zzlzVar.zza(Place.Field.SECONDARY_OPENING_HOURS, "secondary_opening_hours");
        zzlzVar.zza(Place.Field.SERVES_BEER, "serves_beer");
        zzlzVar.zza(Place.Field.SERVES_BREAKFAST, "serves_breakfast");
        zzlzVar.zza(Place.Field.SERVES_BRUNCH, "serves_brunch");
        zzlzVar.zza(Place.Field.SERVES_DINNER, "serves_dinner");
        zzlzVar.zza(Place.Field.SERVES_LUNCH, "serves_lunch");
        zzlzVar.zza(Place.Field.SERVES_VEGETARIAN_FOOD, "serves_vegetarian_food");
        zzlzVar.zza(Place.Field.SERVES_WINE, "serves_wine");
        zzlzVar.zza(Place.Field.TAKEOUT, "takeout");
        zzlzVar.zza(Place.Field.TYPES, "types");
        zzlzVar.zza(Place.Field.USER_RATINGS_TOTAL, "user_ratings_total");
        zzlzVar.zza(Place.Field.UTC_OFFSET, "utc_offset");
        zzlzVar.zza(Place.Field.VIEWPORT, "geometry/viewport");
        zzlzVar.zza(Place.Field.WEBSITE_URI, "website");
        zzlzVar.zza(Place.Field.WHEELCHAIR_ACCESSIBLE_ENTRANCE, "wheelchair_accessible_entrance");
        zza = zzlzVar.zzc();
    }

    public static String zza(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str = (String) zza.get((Place.Field) it2.next());
            if (!TextUtils.isEmpty(str)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static List zzb(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str = (String) zza.get((Place.Field) it2.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
