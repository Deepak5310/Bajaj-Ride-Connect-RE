package com.google.android.libraries.places.internal;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.AddressComponent;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.android.libraries.places.api.model.PlusCode;
import com.google.android.libraries.places.api.model.SpecialDay;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhb {
    private static final zzma zza;
    private static final zzma zzb;
    private static final zzma zzc;

    static {
        zzlz zzlzVar = new zzlz();
        zzlzVar.zza("OPERATIONAL", Place.BusinessStatus.OPERATIONAL);
        zzlzVar.zza("CLOSED_TEMPORARILY", Place.BusinessStatus.CLOSED_TEMPORARILY);
        zzlzVar.zza("CLOSED_PERMANENTLY", Place.BusinessStatus.CLOSED_PERMANENTLY);
        zza = zzlzVar.zzc();
        zzlz zzlzVar2 = new zzlz();
        zzlzVar2.zza(PlaceTypes.ACCOUNTING, Place.Type.ACCOUNTING);
        zzlzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_1, Place.Type.ADMINISTRATIVE_AREA_LEVEL_1);
        zzlzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_2, Place.Type.ADMINISTRATIVE_AREA_LEVEL_2);
        zzlzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_3, Place.Type.ADMINISTRATIVE_AREA_LEVEL_3);
        zzlzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_4, Place.Type.ADMINISTRATIVE_AREA_LEVEL_4);
        zzlzVar2.zza(PlaceTypes.ADMINISTRATIVE_AREA_LEVEL_5, Place.Type.ADMINISTRATIVE_AREA_LEVEL_5);
        zzlzVar2.zza(PlaceTypes.AIRPORT, Place.Type.AIRPORT);
        zzlzVar2.zza(PlaceTypes.AMUSEMENT_PARK, Place.Type.AMUSEMENT_PARK);
        zzlzVar2.zza(PlaceTypes.AQUARIUM, Place.Type.AQUARIUM);
        zzlzVar2.zza(PlaceTypes.ARCHIPELAGO, Place.Type.ARCHIPELAGO);
        zzlzVar2.zza(PlaceTypes.ART_GALLERY, Place.Type.ART_GALLERY);
        zzlzVar2.zza(PlaceTypes.ATM, Place.Type.ATM);
        zzlzVar2.zza(PlaceTypes.BAKERY, Place.Type.BAKERY);
        zzlzVar2.zza(PlaceTypes.BANK, Place.Type.BANK);
        zzlzVar2.zza(PlaceTypes.BAR, Place.Type.BAR);
        zzlzVar2.zza(PlaceTypes.BEAUTY_SALON, Place.Type.BEAUTY_SALON);
        zzlzVar2.zza(PlaceTypes.BICYCLE_STORE, Place.Type.BICYCLE_STORE);
        zzlzVar2.zza(PlaceTypes.BOOK_STORE, Place.Type.BOOK_STORE);
        zzlzVar2.zza(PlaceTypes.BOWLING_ALLEY, Place.Type.BOWLING_ALLEY);
        zzlzVar2.zza(PlaceTypes.BUS_STATION, Place.Type.BUS_STATION);
        zzlzVar2.zza(PlaceTypes.CAFE, Place.Type.CAFE);
        zzlzVar2.zza(PlaceTypes.CAMPGROUND, Place.Type.CAMPGROUND);
        zzlzVar2.zza(PlaceTypes.CAR_DEALER, Place.Type.CAR_DEALER);
        zzlzVar2.zza(PlaceTypes.CAR_RENTAL, Place.Type.CAR_RENTAL);
        zzlzVar2.zza(PlaceTypes.CAR_REPAIR, Place.Type.CAR_REPAIR);
        zzlzVar2.zza(PlaceTypes.CAR_WASH, Place.Type.CAR_WASH);
        zzlzVar2.zza(PlaceTypes.CASINO, Place.Type.CASINO);
        zzlzVar2.zza(PlaceTypes.CEMETERY, Place.Type.CEMETERY);
        zzlzVar2.zza(PlaceTypes.CHURCH, Place.Type.CHURCH);
        zzlzVar2.zza(PlaceTypes.CITY_HALL, Place.Type.CITY_HALL);
        zzlzVar2.zza(PlaceTypes.CLOTHING_STORE, Place.Type.CLOTHING_STORE);
        zzlzVar2.zza(PlaceTypes.COLLOQUIAL_AREA, Place.Type.COLLOQUIAL_AREA);
        zzlzVar2.zza(PlaceTypes.CONTINENT, Place.Type.CONTINENT);
        zzlzVar2.zza(PlaceTypes.CONVENIENCE_STORE, Place.Type.CONVENIENCE_STORE);
        zzlzVar2.zza(PlaceTypes.COUNTRY, Place.Type.COUNTRY);
        zzlzVar2.zza(PlaceTypes.COURTHOUSE, Place.Type.COURTHOUSE);
        zzlzVar2.zza(PlaceTypes.DENTIST, Place.Type.DENTIST);
        zzlzVar2.zza(PlaceTypes.DEPARTMENT_STORE, Place.Type.DEPARTMENT_STORE);
        zzlzVar2.zza(PlaceTypes.DOCTOR, Place.Type.DOCTOR);
        zzlzVar2.zza(PlaceTypes.DRUGSTORE, Place.Type.DRUGSTORE);
        zzlzVar2.zza(PlaceTypes.ELECTRICIAN, Place.Type.ELECTRICIAN);
        zzlzVar2.zza(PlaceTypes.ELECTRONICS_STORE, Place.Type.ELECTRONICS_STORE);
        zzlzVar2.zza(PlaceTypes.EMBASSY, Place.Type.EMBASSY);
        zzlzVar2.zza(PlaceTypes.ESTABLISHMENT, Place.Type.ESTABLISHMENT);
        zzlzVar2.zza(PlaceTypes.FINANCE, Place.Type.FINANCE);
        zzlzVar2.zza(PlaceTypes.FIRE_STATION, Place.Type.FIRE_STATION);
        zzlzVar2.zza(PlaceTypes.FLOOR, Place.Type.FLOOR);
        zzlzVar2.zza(PlaceTypes.FLORIST, Place.Type.FLORIST);
        zzlzVar2.zza(PlaceTypes.FOOD, Place.Type.FOOD);
        zzlzVar2.zza(PlaceTypes.FUNERAL_HOME, Place.Type.FUNERAL_HOME);
        zzlzVar2.zza(PlaceTypes.FURNITURE_STORE, Place.Type.FURNITURE_STORE);
        zzlzVar2.zza(PlaceTypes.GAS_STATION, Place.Type.GAS_STATION);
        zzlzVar2.zza(PlaceTypes.GENERAL_CONTRACTOR, Place.Type.GENERAL_CONTRACTOR);
        zzlzVar2.zza(PlaceTypes.GEOCODE, Place.Type.GEOCODE);
        zzlzVar2.zza("grocery_or_supermarket", Place.Type.GROCERY_OR_SUPERMARKET);
        zzlzVar2.zza(PlaceTypes.GYM, Place.Type.GYM);
        zzlzVar2.zza(PlaceTypes.HAIR_CARE, Place.Type.HAIR_CARE);
        zzlzVar2.zza(PlaceTypes.HARDWARE_STORE, Place.Type.HARDWARE_STORE);
        zzlzVar2.zza(PlaceTypes.HEALTH, Place.Type.HEALTH);
        zzlzVar2.zza(PlaceTypes.HINDU_TEMPLE, Place.Type.HINDU_TEMPLE);
        zzlzVar2.zza(PlaceTypes.HOME_GOODS_STORE, Place.Type.HOME_GOODS_STORE);
        zzlzVar2.zza(PlaceTypes.HOSPITAL, Place.Type.HOSPITAL);
        zzlzVar2.zza(PlaceTypes.INSURANCE_AGENCY, Place.Type.INSURANCE_AGENCY);
        zzlzVar2.zza(PlaceTypes.INTERSECTION, Place.Type.INTERSECTION);
        zzlzVar2.zza(PlaceTypes.JEWELRY_STORE, Place.Type.JEWELRY_STORE);
        zzlzVar2.zza(PlaceTypes.LAUNDRY, Place.Type.LAUNDRY);
        zzlzVar2.zza(PlaceTypes.LAWYER, Place.Type.LAWYER);
        zzlzVar2.zza(PlaceTypes.LIBRARY, Place.Type.LIBRARY);
        zzlzVar2.zza(PlaceTypes.LIGHT_RAIL_STATION, Place.Type.LIGHT_RAIL_STATION);
        zzlzVar2.zza(PlaceTypes.LIQUOR_STORE, Place.Type.LIQUOR_STORE);
        zzlzVar2.zza(PlaceTypes.LOCAL_GOVERNMENT_OFFICE, Place.Type.LOCAL_GOVERNMENT_OFFICE);
        zzlzVar2.zza(PlaceTypes.LOCALITY, Place.Type.LOCALITY);
        zzlzVar2.zza(PlaceTypes.LOCKSMITH, Place.Type.LOCKSMITH);
        zzlzVar2.zza(PlaceTypes.LODGING, Place.Type.LODGING);
        zzlzVar2.zza(PlaceTypes.MEAL_DELIVERY, Place.Type.MEAL_DELIVERY);
        zzlzVar2.zza(PlaceTypes.MEAL_TAKEAWAY, Place.Type.MEAL_TAKEAWAY);
        zzlzVar2.zza(PlaceTypes.MOSQUE, Place.Type.MOSQUE);
        zzlzVar2.zza(PlaceTypes.MOVIE_RENTAL, Place.Type.MOVIE_RENTAL);
        zzlzVar2.zza(PlaceTypes.MOVIE_THEATER, Place.Type.MOVIE_THEATER);
        zzlzVar2.zza(PlaceTypes.MOVING_COMPANY, Place.Type.MOVING_COMPANY);
        zzlzVar2.zza(PlaceTypes.MUSEUM, Place.Type.MUSEUM);
        zzlzVar2.zza(PlaceTypes.NATURAL_FEATURE, Place.Type.NATURAL_FEATURE);
        zzlzVar2.zza(PlaceTypes.NEIGHBORHOOD, Place.Type.NEIGHBORHOOD);
        zzlzVar2.zza(PlaceTypes.NIGHT_CLUB, Place.Type.NIGHT_CLUB);
        zzlzVar2.zza(PlaceTypes.PAINTER, Place.Type.PAINTER);
        zzlzVar2.zza(PlaceTypes.PARK, Place.Type.PARK);
        zzlzVar2.zza(PlaceTypes.PARKING, Place.Type.PARKING);
        zzlzVar2.zza(PlaceTypes.PET_STORE, Place.Type.PET_STORE);
        zzlzVar2.zza(PlaceTypes.PHARMACY, Place.Type.PHARMACY);
        zzlzVar2.zza(PlaceTypes.PHYSIOTHERAPIST, Place.Type.PHYSIOTHERAPIST);
        zzlzVar2.zza(PlaceTypes.PLACE_OF_WORSHIP, Place.Type.PLACE_OF_WORSHIP);
        zzlzVar2.zza(PlaceTypes.PLUMBER, Place.Type.PLUMBER);
        zzlzVar2.zza(PlaceTypes.PLUS_CODE, Place.Type.PLUS_CODE);
        zzlzVar2.zza(PlaceTypes.POINT_OF_INTEREST, Place.Type.POINT_OF_INTEREST);
        zzlzVar2.zza(PlaceTypes.POLICE, Place.Type.POLICE);
        zzlzVar2.zza(PlaceTypes.POLITICAL, Place.Type.POLITICAL);
        zzlzVar2.zza(PlaceTypes.POST_BOX, Place.Type.POST_BOX);
        zzlzVar2.zza(PlaceTypes.POST_OFFICE, Place.Type.POST_OFFICE);
        zzlzVar2.zza(PlaceTypes.POSTAL_CODE_PREFIX, Place.Type.POSTAL_CODE_PREFIX);
        zzlzVar2.zza(PlaceTypes.POSTAL_CODE_SUFFIX, Place.Type.POSTAL_CODE_SUFFIX);
        zzlzVar2.zza(PlaceTypes.POSTAL_CODE, Place.Type.POSTAL_CODE);
        zzlzVar2.zza(PlaceTypes.POSTAL_TOWN, Place.Type.POSTAL_TOWN);
        zzlzVar2.zza(PlaceTypes.PREMISE, Place.Type.PREMISE);
        zzlzVar2.zza(PlaceTypes.PRIMARY_SCHOOL, Place.Type.PRIMARY_SCHOOL);
        zzlzVar2.zza(PlaceTypes.REAL_ESTATE_AGENCY, Place.Type.REAL_ESTATE_AGENCY);
        zzlzVar2.zza(PlaceTypes.RESTAURANT, Place.Type.RESTAURANT);
        zzlzVar2.zza(PlaceTypes.ROOFING_CONTRACTOR, Place.Type.ROOFING_CONTRACTOR);
        zzlzVar2.zza(PlaceTypes.ROOM, Place.Type.ROOM);
        zzlzVar2.zza(PlaceTypes.ROUTE, Place.Type.ROUTE);
        zzlzVar2.zza(PlaceTypes.RV_PARK, Place.Type.RV_PARK);
        zzlzVar2.zza(PlaceTypes.SCHOOL, Place.Type.SCHOOL);
        zzlzVar2.zza(PlaceTypes.SECONDARY_SCHOOL, Place.Type.SECONDARY_SCHOOL);
        zzlzVar2.zza(PlaceTypes.SHOE_STORE, Place.Type.SHOE_STORE);
        zzlzVar2.zza(PlaceTypes.SHOPPING_MALL, Place.Type.SHOPPING_MALL);
        zzlzVar2.zza(PlaceTypes.SPA, Place.Type.SPA);
        zzlzVar2.zza(PlaceTypes.STADIUM, Place.Type.STADIUM);
        zzlzVar2.zza(PlaceTypes.STORAGE, Place.Type.STORAGE);
        zzlzVar2.zza(PlaceTypes.STORE, Place.Type.STORE);
        zzlzVar2.zza(PlaceTypes.STREET_ADDRESS, Place.Type.STREET_ADDRESS);
        zzlzVar2.zza(PlaceTypes.STREET_NUMBER, Place.Type.STREET_NUMBER);
        zzlzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_1, Place.Type.SUBLOCALITY_LEVEL_1);
        zzlzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_2, Place.Type.SUBLOCALITY_LEVEL_2);
        zzlzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_3, Place.Type.SUBLOCALITY_LEVEL_3);
        zzlzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_4, Place.Type.SUBLOCALITY_LEVEL_4);
        zzlzVar2.zza(PlaceTypes.SUBLOCALITY_LEVEL_5, Place.Type.SUBLOCALITY_LEVEL_5);
        zzlzVar2.zza(PlaceTypes.SUBLOCALITY, Place.Type.SUBLOCALITY);
        zzlzVar2.zza(PlaceTypes.SUBPREMISE, Place.Type.SUBPREMISE);
        zzlzVar2.zza(PlaceTypes.SUBWAY_STATION, Place.Type.SUBWAY_STATION);
        zzlzVar2.zza(PlaceTypes.SUPERMARKET, Place.Type.SUPERMARKET);
        zzlzVar2.zza(PlaceTypes.SYNAGOGUE, Place.Type.SYNAGOGUE);
        zzlzVar2.zza(PlaceTypes.TAXI_STAND, Place.Type.TAXI_STAND);
        zzlzVar2.zza(PlaceTypes.TOURIST_ATTRACTION, Place.Type.TOURIST_ATTRACTION);
        zzlzVar2.zza(PlaceTypes.TOWN_SQUARE, Place.Type.TOWN_SQUARE);
        zzlzVar2.zza(PlaceTypes.TRAIN_STATION, Place.Type.TRAIN_STATION);
        zzlzVar2.zza(PlaceTypes.TRANSIT_STATION, Place.Type.TRANSIT_STATION);
        zzlzVar2.zza(PlaceTypes.TRAVEL_AGENCY, Place.Type.TRAVEL_AGENCY);
        zzlzVar2.zza(PlaceTypes.UNIVERSITY, Place.Type.UNIVERSITY);
        zzlzVar2.zza(PlaceTypes.VETERINARY_CARE, Place.Type.VETERINARY_CARE);
        zzlzVar2.zza(PlaceTypes.ZOO, Place.Type.ZOO);
        zzb = zzlzVar2.zzc();
        zzlz zzlzVar3 = new zzlz();
        zzlzVar3.zza("ACCESS", OpeningHours.HoursType.ACCESS);
        zzlzVar3.zza("BREAKFAST", OpeningHours.HoursType.BREAKFAST);
        zzlzVar3.zza("BRUNCH", OpeningHours.HoursType.BRUNCH);
        zzlzVar3.zza("DELIVERY", OpeningHours.HoursType.DELIVERY);
        zzlzVar3.zza("DINNER", OpeningHours.HoursType.DINNER);
        zzlzVar3.zza("DRIVE_THROUGH", OpeningHours.HoursType.DRIVE_THROUGH);
        zzlzVar3.zza("HAPPY_HOUR", OpeningHours.HoursType.HAPPY_HOUR);
        zzlzVar3.zza("KITCHEN", OpeningHours.HoursType.KITCHEN);
        zzlzVar3.zza("LUNCH", OpeningHours.HoursType.LUNCH);
        zzlzVar3.zza("ONLINE_SERVICE_HOURS", OpeningHours.HoursType.ONLINE_SERVICE_HOURS);
        zzlzVar3.zza("PICKUP", OpeningHours.HoursType.PICKUP);
        zzlzVar3.zza("SENIOR_HOURS", OpeningHours.HoursType.SENIOR_HOURS);
        zzlzVar3.zza("TAKEOUT", OpeningHours.HoursType.TAKEOUT);
        zzc = zzlzVar3.zzc();
    }

    zzhb() {
    }

    static LocalDate zza(String str) {
        if (str == null) {
            return null;
        }
        try {
            return LocalDate.newInstance(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Unable to convert %s to LocalDate; date should be in format YYYY-MM-DD.", str), e);
        }
    }

    static Place.BooleanPlaceAttributeValue zzb(Boolean bool) {
        if (bool == null) {
            return Place.BooleanPlaceAttributeValue.UNKNOWN;
        }
        return bool.booleanValue() ? Place.BooleanPlaceAttributeValue.TRUE : Place.BooleanPlaceAttributeValue.FALSE;
    }

    static TimeOfWeek zzc(zzhe.zzd.zzc zzcVar) {
        DayOfWeek dayOfWeek;
        LocalDate localDateZza = null;
        if (zzcVar == null) {
            return null;
        }
        try {
            Integer numZzb = zzcVar.zzb();
            zzkt.zzc(numZzb, "Unable to convert Pablo response to TimeOfWeek: The \"day\" field is missing.");
            String strZzd = zzcVar.zzd();
            zzkt.zzc(strZzd, "Unable to convert Pablo response to TimeOfWeek: The \"time\" field is missing.");
            String str = String.format("Unable to convert %s to LocalTime, must be of format \"hhmm\".", strZzd);
            zzkt.zzf(strZzd.length() == 4, str);
            try {
                LocalTime localTimeNewInstance = LocalTime.newInstance(Integer.parseInt(strZzd.substring(0, 2)), Integer.parseInt(strZzd.substring(2, 4)));
                try {
                    localDateZza = zza(zzcVar.zzc());
                } catch (IllegalArgumentException unused) {
                }
                switch (numZzb.intValue()) {
                    case 0:
                        dayOfWeek = DayOfWeek.SUNDAY;
                        break;
                    case 1:
                        dayOfWeek = DayOfWeek.MONDAY;
                        break;
                    case 2:
                        dayOfWeek = DayOfWeek.TUESDAY;
                        break;
                    case 3:
                        dayOfWeek = DayOfWeek.WEDNESDAY;
                        break;
                    case 4:
                        dayOfWeek = DayOfWeek.THURSDAY;
                        break;
                    case 5:
                        dayOfWeek = DayOfWeek.FRIDAY;
                        break;
                    case 6:
                        dayOfWeek = DayOfWeek.SATURDAY;
                        break;
                    default:
                        throw new IllegalArgumentException("pabloDayOfWeek can only be an integer between 0 and 6");
                }
                TimeOfWeek.Builder builder = TimeOfWeek.builder(dayOfWeek, localTimeNewInstance);
                builder.setDate(localDateZza);
                builder.setTruncated(Boolean.TRUE.equals(zzcVar.zza()));
                return builder.build();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(str, e);
            }
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    static List zzd(List list) {
        return list != null ? list : new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    static List zze(List list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        zzmy zzmyVarListIterator = ((zzlx) list).listIterator(0);
        while (zzmyVarListIterator.hasNext()) {
            String str = (String) zzmyVarListIterator.next();
            zzma zzmaVar = zzb;
            if (zzmaVar.containsKey(str)) {
                arrayList.add((Place.Type) zzmaVar.get(str));
            } else {
                z = true;
            }
        }
        if (z) {
            arrayList.add(Place.Type.OTHER);
        }
        return arrayList;
    }

    static List zzf(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    /* JADX WARN: Multi-variable type inference failed */
    static final Place zzg(zzhe zzheVar, List list) throws ApiException {
        AddressComponents addressComponentsNewInstance;
        AddressComponent addressComponentBuild;
        LatLng latLngZzi;
        LatLngBounds latLngBounds;
        Integer numValueOf;
        ArrayList arrayList;
        PlusCode plusCodeBuild;
        PhotoMetadata photoMetadataBuild;
        Place.Builder builder = Place.builder();
        builder.setAttributions(list);
        if (zzheVar != null) {
            zzlx zzlxVarZzf = zzheVar.zzf();
            ArrayList arrayList2 = null;
            if (zzlxVarZzf.isEmpty()) {
                addressComponentsNewInstance = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                zzmy zzmyVarListIterator = zzlxVarZzf.listIterator(0);
                while (zzmyVarListIterator.hasNext()) {
                    zzhe.zza zzaVar = (zzhe.zza) zzmyVarListIterator.next();
                    if (zzaVar == null) {
                        addressComponentBuild = null;
                    } else {
                        try {
                            String strZzb = zzaVar.zzb();
                            if (strZzb == null) {
                                throw null;
                            }
                            AddressComponent.Builder builder2 = AddressComponent.builder(strZzb, zzaVar.zza());
                            builder2.setShortName(zzaVar.zzc());
                            addressComponentBuild = builder2.build();
                        } catch (IllegalStateException | NullPointerException e) {
                            throw zzh(String.format("AddressComponent not properly defined (%s).", e.getMessage()));
                        }
                    }
                    zzk(arrayList3, addressComponentBuild);
                }
                addressComponentsNewInstance = AddressComponents.newInstance(arrayList3);
            }
            zzhe.zzc zzcVarZzb = zzheVar.zzb();
            if (zzcVarZzb != null) {
                latLngZzi = zzi(zzcVarZzb.zza());
                zzhe.zzc.zzb zzbVarZzb = zzcVarZzb.zzb();
                if (zzbVarZzb == null) {
                    latLngBounds = null;
                } else {
                    LatLng latLngZzi2 = zzi(zzbVarZzb.zzb());
                    LatLng latLngZzi3 = zzi(zzbVarZzb.zza());
                    if (latLngZzi2 == null || latLngZzi3 == null) {
                        latLngBounds = null;
                    } else {
                        latLngBounds = new LatLngBounds(latLngZzi2, latLngZzi3);
                    }
                }
            } else {
                latLngZzi = null;
                latLngBounds = null;
            }
            String strZzG = zzheVar.zzG();
            Uri uri = strZzG != null ? Uri.parse(strZzG) : null;
            String strZzC = zzheVar.zzC();
            String strConcat = strZzC != null ? strZzC.concat(".png") : null;
            String strZzB = zzheVar.zzB();
            if (strZzB != null) {
                try {
                    numValueOf = Integer.valueOf(Color.parseColor(strZzB));
                } catch (IllegalArgumentException unused) {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            builder.setAddress(zzheVar.zzA());
            builder.setAddressComponents(addressComponentsNewInstance);
            builder.setBusinessStatus((Place.BusinessStatus) zza.getOrDefault(zzheVar.zzz(), null));
            builder.setCurbsidePickup(zzb(zzheVar.zzj()));
            builder.setCurrentOpeningHours(zzj(zzheVar.zzc()));
            builder.setDelivery(zzb(zzheVar.zzk()));
            builder.setDineIn(zzb(zzheVar.zzl()));
            zzhe.zzb zzbVarZza = zzheVar.zza();
            builder.setEditorialSummary(zzbVarZza == null ? null : zzbVarZza.zzb());
            zzhe.zzb zzbVarZza2 = zzheVar.zza();
            builder.setEditorialSummaryLanguageCode(zzbVarZza2 == null ? null : zzbVarZza2.zza());
            builder.setIconBackgroundColor(numValueOf);
            builder.setIconUrl(strConcat);
            builder.setId(zzheVar.zzF());
            builder.setLatLng(latLngZzi);
            builder.setName(zzheVar.zzE());
            builder.setOpeningHours(zzj(zzheVar.zzd()));
            builder.setPhoneNumber(zzheVar.zzD());
            zzlx zzlxVarZzg = zzheVar.zzg();
            if (zzlxVarZzg.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                zzmy zzmyVarListIterator2 = zzlxVarZzg.listIterator(0);
                while (zzmyVarListIterator2.hasNext()) {
                    zzhe.zze zzeVar = (zzhe.zze) zzmyVarListIterator2.next();
                    if (zzeVar == null) {
                        photoMetadataBuild = null;
                    } else {
                        String strZzd = zzeVar.zzd();
                        if (TextUtils.isEmpty(strZzd)) {
                            throw zzh("Photo reference not provided for a PhotoMetadata result.");
                        }
                        Integer numZzb = zzeVar.zzb();
                        Integer numZzc = zzeVar.zzc();
                        PhotoMetadata.Builder builder3 = PhotoMetadata.builder(strZzd);
                        zzlx zzlxVarZza = zzeVar.zza();
                        builder3.setAttributions(zzlxVarZza.isEmpty() ? "" : zzki.zzc(", ").zzd().zzf(zzlxVarZza));
                        builder3.setHeight(numZzb == null ? 0 : numZzb.intValue());
                        builder3.setWidth(numZzc == null ? 0 : numZzc.intValue());
                        photoMetadataBuild = builder3.build();
                    }
                    zzk(arrayList, photoMetadataBuild);
                }
            }
            builder.setPhotoMetadatas(arrayList);
            builder.setPlaceTypes(zzf(zzheVar.zzi()));
            zzhe.zzf zzfVarZze = zzheVar.zze();
            if (zzfVarZze == null) {
                plusCodeBuild = null;
            } else {
                PlusCode.Builder builder4 = PlusCode.builder();
                builder4.setCompoundCode(zzfVarZze.zza());
                builder4.setGlobalCode(zzfVarZze.zzb());
                plusCodeBuild = builder4.build();
            }
            builder.setPlusCode(plusCodeBuild);
            builder.setPriceLevel(zzheVar.zzw());
            builder.setRating(zzheVar.zzv());
            builder.setReservable(zzb(zzheVar.zzm()));
            zzlx zzlxVarZzh = zzheVar.zzh();
            if (!zzlxVarZzh.isEmpty()) {
                ArrayList arrayList4 = new ArrayList();
                zzmy zzmyVarListIterator3 = zzlxVarZzh.listIterator(0);
                while (zzmyVarListIterator3.hasNext()) {
                    zzk(arrayList4, zzj((zzhe.zzd) zzmyVarListIterator3.next()));
                }
                if (!arrayList4.isEmpty()) {
                    arrayList2 = arrayList4;
                }
            }
            builder.setSecondaryOpeningHours(arrayList2);
            builder.setServesBeer(zzb(zzheVar.zzn()));
            builder.setServesBreakfast(zzb(zzheVar.zzo()));
            builder.setServesBrunch(zzb(zzheVar.zzo()));
            builder.setServesDinner(zzb(zzheVar.zzp()));
            builder.setServesLunch(zzb(zzheVar.zzq()));
            builder.setServesVegetarianFood(zzb(zzheVar.zzr()));
            builder.setServesWine(zzb(zzheVar.zzs()));
            builder.setTakeout(zzb(zzheVar.zzt()));
            builder.setTypes(zze(zzheVar.zzi()));
            builder.setUserRatingsTotal(zzheVar.zzx());
            builder.setUtcOffsetMinutes(zzheVar.zzy());
            builder.setViewport(latLngBounds);
            builder.setWebsiteUri(uri);
            builder.setWheelchairAccessibleEntrance(zzb(zzheVar.zzu()));
        }
        return builder.build();
    }

    private static ApiException zzh(String str) {
        return new ApiException(new Status(8, "Unexpected server error: ".concat(String.valueOf(str))));
    }

    private static LatLng zzi(zzhe.zzc.zza zzaVar) {
        if (zzaVar == null) {
            return null;
        }
        Double dZza = zzaVar.zza();
        Double dZzb = zzaVar.zzb();
        if (dZza == null || dZzb == null) {
            return null;
        }
        return new LatLng(dZza.doubleValue(), dZzb.doubleValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OpeningHours zzj(zzhe.zzd zzdVar) {
        ArrayList arrayList;
        SpecialDay specialDayBuild;
        Period periodBuild;
        if (zzdVar == null) {
            return null;
        }
        OpeningHours.Builder builder = OpeningHours.builder();
        zzlx zzlxVarZza = zzdVar.zza();
        if (zzlxVarZza.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            zzmy zzmyVarListIterator = zzlxVarZza.listIterator(0);
            while (zzmyVarListIterator.hasNext()) {
                zzhe.zzd.zza zzaVar = (zzhe.zzd.zza) zzmyVarListIterator.next();
                if (zzaVar != null) {
                    Period.Builder builder2 = Period.builder();
                    builder2.setOpen(zzc(zzaVar.zzb()));
                    builder2.setClose(zzc(zzaVar.zza()));
                    periodBuild = builder2.build();
                } else {
                    periodBuild = null;
                }
                zzk(arrayList, periodBuild);
            }
        }
        builder.setPeriods(zzd(arrayList));
        builder.setWeekdayText(zzdVar.zzc());
        builder.setHoursType((OpeningHours.HoursType) zzc.getOrDefault(zzdVar.zzd(), null));
        zzlx zzlxVarZzb = zzdVar.zzb();
        ArrayList arrayList2 = new ArrayList();
        if (!zzlxVarZzb.isEmpty()) {
            zzmy zzmyVarListIterator2 = zzlxVarZzb.listIterator(0);
            while (zzmyVarListIterator2.hasNext()) {
                zzhe.zzd.zzb zzbVar = (zzhe.zzd.zzb) zzmyVarListIterator2.next();
                if (zzbVar == null) {
                    specialDayBuild = null;
                } else {
                    try {
                        LocalDate localDateZza = zza(zzbVar.zzb());
                        if (localDateZza == null) {
                            throw null;
                        }
                        SpecialDay.Builder builder3 = SpecialDay.builder(localDateZza);
                        builder3.setExceptional(Boolean.TRUE.equals(zzbVar.zza()));
                        specialDayBuild = builder3.build();
                    } catch (IllegalArgumentException | NullPointerException unused) {
                        specialDayBuild = null;
                    }
                }
                zzk(arrayList2, specialDayBuild);
            }
        }
        builder.setSpecialDays(arrayList2);
        return builder.build();
    }

    private static boolean zzk(Collection collection, Object obj) {
        if (obj != null) {
            return collection.add(obj);
        }
        return false;
    }
}
