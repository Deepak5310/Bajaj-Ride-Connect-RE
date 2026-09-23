package com.google.android.libraries.places.internal;

import android.graphics.Color;
import android.net.Uri;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.AddressComponent;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.AuthorAttribution;
import com.google.android.libraries.places.api.model.AuthorAttributions;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.android.libraries.places.api.model.PlusCode;
import com.google.android.libraries.places.api.model.Review;
import com.google.android.libraries.places.api.model.SpecialDay;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfr {
    static final zzfr zza = new zzfr();
    private final zzma zzb;
    private final zzma zzc;
    private final zzma zzd;

    private zzfr() {
        zzlz zzlzVar = new zzlz();
        zzlzVar.zza(zzaki.OPERATIONAL, Place.BusinessStatus.OPERATIONAL);
        zzlzVar.zza(zzaki.CLOSED_TEMPORARILY, Place.BusinessStatus.CLOSED_TEMPORARILY);
        zzlzVar.zza(zzaki.CLOSED_PERMANENTLY, Place.BusinessStatus.CLOSED_PERMANENTLY);
        this.zzb = zzlzVar.zzc();
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
        this.zzc = zzlzVar2.zzc();
        zzlz zzlzVar3 = new zzlz();
        zzlzVar3.zza(zzakp.ACCESS, OpeningHours.HoursType.ACCESS);
        zzlzVar3.zza(zzakp.BREAKFAST, OpeningHours.HoursType.BREAKFAST);
        zzlzVar3.zza(zzakp.BRUNCH, OpeningHours.HoursType.BRUNCH);
        zzlzVar3.zza(zzakp.DELIVERY, OpeningHours.HoursType.DELIVERY);
        zzlzVar3.zza(zzakp.DINNER, OpeningHours.HoursType.DINNER);
        zzlzVar3.zza(zzakp.DRIVE_THROUGH, OpeningHours.HoursType.DRIVE_THROUGH);
        zzlzVar3.zza(zzakp.HAPPY_HOUR, OpeningHours.HoursType.HAPPY_HOUR);
        zzlzVar3.zza(zzakp.KITCHEN, OpeningHours.HoursType.KITCHEN);
        zzlzVar3.zza(zzakp.LUNCH, OpeningHours.HoursType.LUNCH);
        zzlzVar3.zza(zzakp.ONLINE_SERVICE_HOURS, OpeningHours.HoursType.ONLINE_SERVICE_HOURS);
        zzlzVar3.zza(zzakp.PICKUP, OpeningHours.HoursType.PICKUP);
        zzlzVar3.zza(zzakp.SENIOR_HOURS, OpeningHours.HoursType.SENIOR_HOURS);
        zzlzVar3.zza(zzakp.TAKEOUT, OpeningHours.HoursType.TAKEOUT);
        this.zzd = zzlzVar3.zzc();
    }

    private final OpeningHours zzb(zzaks zzaksVar) throws ApiException {
        OpeningHours.Builder builder = OpeningHours.builder();
        List listZze = zzaksVar.zze();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = listZze.iterator();
        while (true) {
            TimeOfWeek timeOfWeekZzi = null;
            if (!it2.hasNext()) {
                break;
            }
            zzakn zzaknVar = (zzakn) it2.next();
            Period.Builder builder2 = Period.builder();
            builder2.setOpen(zzaknVar.zzf() ? zzi(zzaknVar.zzc()) : null);
            if (zzaknVar.zze()) {
                timeOfWeekZzi = zzi(zzaknVar.zza());
            }
            builder2.setClose(timeOfWeekZzi);
            arrayList.add(builder2.build());
        }
        builder.setPeriods(arrayList);
        builder.setWeekdayText(zzaksVar.zzg());
        builder.setHoursType((OpeningHours.HoursType) this.zzd.getOrDefault(zzaksVar.zza(), null));
        List listZzf = zzaksVar.zzf();
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = listZzf.iterator();
        while (it3.hasNext()) {
            try {
                SpecialDay.Builder builder3 = SpecialDay.builder(zzg(((zzakr) it3.next()).zzc()));
                builder3.setExceptional(true);
                arrayList2.add(builder3.build());
            } catch (IllegalArgumentException e) {
                throw zzc(String.format("Special day is not properly defined: %s", e.getMessage()));
            }
        }
        builder.setSpecialDays(arrayList2);
        return builder.build();
    }

    private static final ApiException zzc(String str) {
        return new ApiException(new Status(8, "Unexpected server error: ".concat(String.valueOf(str))));
    }

    private static final String zzd(String str) {
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static final Place.BooleanPlaceAttributeValue zze(boolean z, boolean z2) {
        if (z) {
            return z2 ? Place.BooleanPlaceAttributeValue.TRUE : Place.BooleanPlaceAttributeValue.FALSE;
        }
        return Place.BooleanPlaceAttributeValue.UNKNOWN;
    }

    private static final LatLng zzf(zzari zzariVar) {
        return new LatLng(zzariVar.zza(), zzariVar.zzc());
    }

    private static final LocalDate zzg(zzarf zzarfVar) {
        return LocalDate.newInstance(zzarfVar.zzd(), zzarfVar.zzc(), zzarfVar.zza());
    }

    private static final AuthorAttribution zzh(zzajf zzajfVar) throws ApiException {
        String strZzd = zzajfVar.zzd();
        if (strZzd.isEmpty()) {
            throw zzc("Author name not provided for an AuthorAttribution result.");
        }
        AuthorAttribution.Builder builder = AuthorAttribution.builder(strZzd);
        builder.setUri(zzd(zzajfVar.zzf()));
        builder.setPhotoUri(zzd(zzajfVar.zze()));
        return builder.build();
    }

    private static final TimeOfWeek zzi(zzakm zzakmVar) throws ApiException {
        DayOfWeek dayOfWeek;
        int iZza = zzakmVar.zza();
        LocalTime localTimeNewInstance = LocalTime.newInstance(zzakmVar.zzc(), zzakmVar.zzd());
        LocalDate localDateZzg = zzakmVar.zzi() ? zzg(zzakmVar.zzg()) : null;
        switch (iZza) {
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
                throw zzc("Day of week must an integer between 0 and 6");
        }
        TimeOfWeek.Builder builder = TimeOfWeek.builder(dayOfWeek, localTimeNewInstance);
        builder.setDate(localDateZzg);
        builder.setTruncated(zzakmVar.zzh());
        return builder.build();
    }

    final Place zza(zzalb zzalbVar) throws ApiException {
        AddressComponents addressComponentsNewInstance;
        Integer numValueOf;
        ArrayList arrayList;
        AuthorAttributions authorAttributionsNewInstance;
        PlusCode plusCodeBuild;
        Integer num;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        LatLngBounds latLngBounds;
        Place.Builder builder = Place.builder();
        builder.setAddress(zzd(zzalbVar.zzq()));
        List<zzakd> listZzw = zzalbVar.zzw();
        if (listZzw.isEmpty()) {
            addressComponentsNewInstance = null;
        } else {
            ArrayList arrayList5 = new ArrayList();
            for (zzakd zzakdVar : listZzw) {
                try {
                    AddressComponent.Builder builder2 = AddressComponent.builder(zzakdVar.zzc(), zzakdVar.zze());
                    builder2.setShortName(zzd(zzakdVar.zzd()));
                    arrayList5.add(builder2.build());
                } catch (IllegalStateException e) {
                    throw zzc(String.format("AddressComponent is not properly defined: %s.", e.getMessage()));
                }
            }
            addressComponentsNewInstance = AddressComponents.newInstance(arrayList5);
        }
        builder.setAddressComponents(addressComponentsNewInstance);
        builder.setBusinessStatus((Place.BusinessStatus) this.zzb.getOrDefault(zzalbVar.zzg(), null));
        builder.setCurbsidePickup(zze(zzalbVar.zzM(), zzalbVar.zzB()));
        builder.setCurrentOpeningHours(zzalbVar.zzN() ? zzb(zzalbVar.zzh()) : null);
        builder.setDelivery(zze(zzalbVar.zzO(), zzalbVar.zzC()));
        builder.setDineIn(zze(zzalbVar.zzP(), zzalbVar.zzD()));
        builder.setEditorialSummary(zzalbVar.zzR() ? zzd(zzalbVar.zzp().zze()) : null);
        builder.setEditorialSummaryLanguageCode(zzalbVar.zzR() ? zzd(zzalbVar.zzp().zzd()) : null);
        String strZzr = zzalbVar.zzr();
        if (strZzr.isEmpty()) {
            numValueOf = null;
        } else {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(strZzr));
            } catch (IllegalArgumentException unused) {
                numValueOf = null;
            }
        }
        builder.setIconBackgroundColor(numValueOf);
        String strZzs = zzalbVar.zzs();
        builder.setIconUrl(!strZzs.isEmpty() ? String.valueOf(strZzs).concat(".png") : null);
        builder.setId(zzd(zzalbVar.zzt()));
        builder.setLatLng(zzalbVar.zzS() ? zzf(zzalbVar.zzn()) : null);
        builder.setName(zzalbVar.zzQ() ? zzd(zzalbVar.zzo().zze()) : null);
        builder.setNameLanguageCode(zzalbVar.zzQ() ? zzd(zzalbVar.zzo().zzd()) : null);
        builder.setOpeningHours(zzalbVar.zzU() ? zzb(zzalbVar.zzi()) : null);
        builder.setPhoneNumber(zzd(zzalbVar.zzu()));
        List<zzajy> listZzx = zzalbVar.zzx();
        boolean z = false;
        if (listZzx.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (zzajy zzajyVar : listZzx) {
                String strZze = zzajyVar.zze();
                if (strZze.isEmpty() || strZze.split(RemoteSettings.FORWARD_SLASH_STRING).length != 4) {
                    throw zzc("Photo reference not provided for a PhotoMetadata result.");
                }
                Iterator it2 = zzky.zzb(zzkb.zzb('/')).zzd(strZze).iterator();
                it2.getClass();
                int i = 0;
                while (i < 3 && it2.hasNext()) {
                    it2.next();
                    i++;
                }
                if (!it2.hasNext()) {
                    throw new IndexOutOfBoundsException("position (3) must be less than the number of elements that remained (" + i + ")");
                }
                PhotoMetadata.Builder builder3 = PhotoMetadata.builder((String) it2.next());
                List<zzajf> listZzf = zzajyVar.zzf();
                ArrayList arrayList6 = new ArrayList();
                for (zzajf zzajfVar : listZzf) {
                    if (zzajfVar != null) {
                        String strZzf = zzajfVar.zzf();
                        if (strZzf.startsWith("//")) {
                            strZzf = "https:".concat(String.valueOf(strZzf));
                        }
                        zzqa zzqaVar = new zzqa("a");
                        int i2 = zzqc.zza;
                        zzqaVar.zzc(zzqc.zza(strZzf, zzqb.zza));
                        zzqaVar.zzb(zzajfVar.zzd());
                        arrayList6.add(zzqaVar.zza().zza());
                    }
                }
                builder3.setAttributions(zzki.zzc(", ").zzf(arrayList6));
                builder3.setHeight(zzajyVar.zza());
                builder3.setWidth(zzajyVar.zzc());
                List listZzf2 = zzajyVar.zzf();
                if (listZzf2.isEmpty()) {
                    authorAttributionsNewInstance = null;
                } else {
                    zzlu zzluVar = new zzlu();
                    Iterator it3 = listZzf2.iterator();
                    while (it3.hasNext()) {
                        zzluVar.zzb(zzh((zzajf) it3.next()));
                    }
                    authorAttributionsNewInstance = AuthorAttributions.newInstance(zzluVar.zzc());
                }
                builder3.setAuthorAttributions(authorAttributionsNewInstance);
                arrayList.add(builder3.build());
            }
        }
        builder.setPhotoMetadatas(arrayList);
        builder.setPlaceTypes(zzalbVar.zzA().isEmpty() ? null : zzalbVar.zzA());
        if (zzalbVar.zzT()) {
            zzaky zzakyVarZzj = zzalbVar.zzj();
            PlusCode.Builder builder4 = PlusCode.builder();
            builder4.setCompoundCode(zzd(zzakyVarZzj.zzd()));
            builder4.setGlobalCode(zzd(zzakyVarZzj.zze()));
            plusCodeBuild = builder4.build();
        } else {
            plusCodeBuild = null;
        }
        builder.setPlusCode(plusCodeBuild);
        zzalh zzalhVarZzm = zzalbVar.zzm();
        zzalh zzalhVar = zzalh.PRICE_LEVEL_UNSPECIFIED;
        int iOrdinal = zzalhVarZzm.ordinal();
        if (iOrdinal == 1) {
            num = 0;
        } else if (iOrdinal == 2) {
            num = 1;
        } else if (iOrdinal == 3) {
            num = 2;
        } else if (iOrdinal != 4) {
            num = iOrdinal != 5 ? null : 4;
        } else {
            num = 3;
        }
        builder.setPriceLevel(num);
        double dZza = zzalbVar.zza();
        builder.setRating(dZza < 1.0d ? null : Double.valueOf(dZza));
        builder.setReservable(zze(zzalbVar.zzV(), zzalbVar.zzE()));
        List<zzalk> listZzz = zzalbVar.zzz();
        if (listZzz.isEmpty()) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList();
            for (zzalk zzalkVar : listZzz) {
                double dZza2 = zzalkVar.zza();
                if (dZza2 == 0.0d) {
                    throw zzc("Review rating not provided for a Review result.");
                }
                if (!zzalkVar.zzi()) {
                    throw zzc("Author attribution not provided for a Review result.");
                }
                String strZza = zzalkVar.zzk() ? zzaqz.zza(zzalkVar.zze()) : null;
                String strZzd = zzalkVar.zzl() ? zzd(zzalkVar.zzg().zze()) : null;
                String strZzd2 = zzalkVar.zzl() ? zzd(zzalkVar.zzg().zzd()) : null;
                String strZzd3 = zzalkVar.zzj() ? zzd(zzalkVar.zzf().zze()) : null;
                String strZzd4 = zzalkVar.zzj() ? zzd(zzalkVar.zzf().zzd()) : null;
                String strZzd5 = zzd(zzalkVar.zzh());
                Review.Builder builder5 = Review.builder(Double.valueOf(dZza2), zzh(zzalkVar.zzc()));
                builder5.setPublishTime(strZza);
                builder5.setText(strZzd);
                builder5.setTextLanguageCode(strZzd2);
                builder5.setOriginalText(strZzd3);
                builder5.setOriginalTextLanguageCode(strZzd4);
                builder5.setRelativePublishTimeDescription(strZzd5);
                arrayList2.add(builder5.build());
            }
        }
        builder.setReviews(arrayList2);
        List listZzy = zzalbVar.zzy();
        if (listZzy.isEmpty()) {
            arrayList3 = null;
        } else {
            arrayList3 = new ArrayList();
            Iterator it4 = listZzy.iterator();
            while (it4.hasNext()) {
                arrayList3.add(zzb((zzaks) it4.next()));
            }
        }
        builder.setSecondaryOpeningHours(arrayList3);
        builder.setServesBeer(zze(zzalbVar.zzW(), zzalbVar.zzF()));
        builder.setServesBreakfast(zze(zzalbVar.zzX(), zzalbVar.zzG()));
        builder.setServesBrunch(zze(zzalbVar.zzW(), zzalbVar.zzF()));
        builder.setServesDinner(zze(zzalbVar.zzY(), zzalbVar.zzH()));
        builder.setServesLunch(zze(zzalbVar.zzZ(), zzalbVar.zzI()));
        builder.setServesVegetarianFood(zze(zzalbVar.zzaa(), zzalbVar.zzJ()));
        builder.setServesWine(zze(zzalbVar.zzab(), zzalbVar.zzK()));
        builder.setTakeout(zze(zzalbVar.zzac(), zzalbVar.zzL()));
        List<String> listZzA = zzalbVar.zzA();
        if (listZzA.isEmpty()) {
            arrayList4 = null;
        } else {
            arrayList4 = new ArrayList();
            for (String str : listZzA) {
                if (this.zzc.containsKey(str)) {
                    arrayList4.add((Place.Type) this.zzc.get(str));
                } else {
                    z = true;
                }
            }
            if (z) {
                arrayList4.add(Place.Type.OTHER);
            }
        }
        builder.setTypes(arrayList4);
        builder.setUserRatingsTotal(zzalbVar.zzad() ? Integer.valueOf(zzalbVar.zzc()) : null);
        builder.setUtcOffsetMinutes(zzalbVar.zzae() ? Integer.valueOf(zzalbVar.zzd()) : null);
        if (zzalbVar.zzaf()) {
            zzahw zzahwVarZze = zzalbVar.zze();
            latLngBounds = new LatLngBounds(zzf(zzahwVarZze.zzf()), zzf(zzahwVarZze.zze()));
        } else {
            latLngBounds = null;
        }
        builder.setViewport(latLngBounds);
        String strZzv = zzalbVar.zzv();
        builder.setWebsiteUri(strZzv.isEmpty() ? null : Uri.parse(strZzv));
        builder.setWheelchairAccessibleEntrance(zze(zzalbVar.zzf().zze(), zzalbVar.zzf().zzd()));
        return builder.build();
    }
}
