package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static final fd a;
    private final int b;

    static {
        ez ezVar = new ez();
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.ACCOUNT_SETTINGS.eU), j.z);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.ANNOUNCEMENTS.eU), j.w);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.ADD_YOUR_PICKUP_ORDER.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LAST_CHANCE_FOR_PICKUP.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PICKUP_ORDER_ADDED.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PICKUP_ORDER_CANCELED.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PICKUP_ORDER_CHECK_IN.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PICKUP_ORDER_REMINDER.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PICKUP_ORDER_WAITING_TO_BE_ADDED.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.READY_FOR_PICKUP.eU), j.h);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.AT_A_PLACE_SAMPLE.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_LISTINGS.eU), j.A);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.INSIGHTS_BUSINESS_NOTIFICATION.eU), j.A);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_OWNER_HOURS.eU), j.p);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.CAR_ROADBLOCK_FIRST_RUN.eU), j.C);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.CONTRIBUTION_IMPACT_MILESTONE.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.DESKTOP_CALL.eU), j.D);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.EDIT_PUBLISHED.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.EMPLOYEE_HOURS.eU), j.f421n);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.FOOD_REMINDER.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.IN_APP_SHARE.eU), j.p);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.JOURNEY_SHARING_ARRIVAL_NOTIFICATION_RECEIVED.eU), j.t);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LIVE_TRIPS_STATUS.eU), j.B);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LIVE_TRIPS_END_TRIP.eU), j.B);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCAL_DISCOVERY_AT_A_PLACE.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCAL_DISCOVERY_NEW_POST.eU), j.j);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCAL_DISCOVERY_WELCOME_TO_DESTINATION.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCAL_EVENT.eU), j.b);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCAL_GUIDES_PERKS.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SHARED_LOCATION_RECEIVED.eU), j.t);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_ONGOING_BURSTING.eU), j.x);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SHARED_LOCATION_REQUEST.eU), j.u);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_DEBUG.eU), j.E);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_USER_SALVAGE_AND_RESCUE.eU), j.u);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_AADC_REMINDER_NOTIFICATION.eU), j.u);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_GEOFENCE_ALERT_CREATED.eU), j.u);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_GEOFENCE_ALERT_TRIGGERED.eU), j.t);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.MAPS_BADGES.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_MESSAGE_FROM_MERCHANT.eU), j.p);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_MESSAGE_FROM_CUSTOMER.eU), j.q);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.MERCHANT_MISSED_CALLS.eU), j.A);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_MESSAGING_MERCHANT_UNRESPONSIVE_SUMMARY.eU), j.A);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_PROMPTS.eU), j.B);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_STATUS.eU), j.B);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_DONATE_SESSION.eU), j.E);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.NEW_BUSINESS_REVIEW.eU), j.A);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_APP_UPGRADE.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_BACKEND_CLEARED_ERROR.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_COVERAGE_LOST.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_DOWNLOAD.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_DOWNLOAD_FAILED.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_DOWNLOAD_SUCCESS.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_MAP_EXPIRED.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_REGION_EXPIRING_SOON.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_TRIP_REGION_EXPIRED.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_TRIP_REGION_EXPIRING_SOON.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_UNUSED_REGION_EXPIRED.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_UNUSED_REGION_EXPIRING_SOON.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_ONBOARDING_PROMPT.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_RECOMMENDATION_FROM_GEOMETRY_CHANGE.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_RECOMMENDED_REGIONS_CHANGED.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_REGION_PARTLY_REPLACED_FROM_GEOMETRY_CHANGE.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_REGION_REPLACED_FROM_GEOMETRY_CHANGE.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_REGION_SOURCES_GONE.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_TRIPS.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_UPCOMING_TRIP.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_CURRENT_TRIP.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_MULTI_UPCOMING_TRIPS.eU), j.f);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SAVED_PARKING_LOCATION.eU), j.e);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SAVED_PARKING_LOCATION_EXPIRE_TIME.eU), j.e);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PARKING_PAYMENT_SESSION_EXPIRATION.eU), j.e);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PEOPLE_FOLLOW_NEW_FOLLOWER.eU), j.y);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PEOPLE_FOLLOW_NEW_REQUEST.eU), j.y);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PHOTO_TAKEN.eU), j.m);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.GEO_PHOTO_UPLOADS.eU), j.m);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.GEO_PHOTO_UPLOAD_PREPROCESSING.eU), j.m);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PLACE_LIST_JOINED.eU), j.r);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PLACE_QA.eU), j.f421n);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.PLACE_QA_MERCHANT.eU), j.p);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REVIEW_AT_A_PLACE_PLACE_REMOVED_FROM_TIMELINE.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.POST_CONTRIBUTION_IMPACT.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.POST_INLINE_REVIEW_THANKS.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.POST_PHOTO_VIEWS.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REENGAGEMENT_CATEGORICAL_SEARCH_REOPENED_BUSINESS.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REENGAGEMENT_PLACESHEET_REOPENED_BUSINESS.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REENGAGEMENT_CATEGORICAL_SEARCH_TAKEOUT.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SHERPA_DRIVING_CONGESTION_AHEAD.eU), j.b);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REENGAGEMENT_PLACESHEET_TAKEOUT.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REVIEW_AT_A_PLACE.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REVIEW_AT_A_PLACE_SUBMISSION_FAILURE.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.REVIEW_REPLY.eU), j.p);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.RIDDLER.eU), j.f421n);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SEND_TO_PHONE.eU), j.D);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SET_ALIAS.eU), j.v);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SOCIAL_PLANNING_PLACE_ADDED.eU), j.r);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SOCIAL_PLANNING_PLACE_REACTION.eU), j.r);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.SOCIAL_PLANNING_GROUP_SUMMARY.eU), j.r);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TIMELINE_ADD_VISIT.eU), j.s);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TIMELINE_RECEIPTS_PARSED.eU), j.s);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TIMELINE_VISIT_CONFIRMATION.eU), j.s);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TIMELINE_WARM_WELCOME.eU), j.s);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TODO_LIST.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TODO_PHOTO.eU), j.m);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TODO_REVIEW.eU), j.l);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_GUIDANCE.eU), j.D);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_GUIDANCE_QUESTIONS.eU), j.o);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_REROUTING.eU), j.D);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_SEND_TRACK.eU), j.E);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_STATION.eU), j.d);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_STATION_FEEDBACK.eU), j.d);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UGC_AT_A_PLACE_POI_WIZARD_NOTIFICATION.eU), j.f421n);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UGC_FACTUAL_IMPACT_ADD_A_PLACE.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UGC_FACTUAL_IMPACT_LOCATION_EDIT.eU), j.k);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UGC_HOME_STREET.eU), j.o);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UGC_PHOTO_BECAME_PLACE_HERO_IMAGE.eU), j.o);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UGC_POST_TRIP_QUESTIONS.eU), j.o);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.UPDATE_COMMUTE_TRAVEL_MODE.eU), j.v);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.HERE_AT_A_PLACE_NOTIFICATION.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.HERE_AT_A_PLACE_MALL_NOTIFICATION.eU), j.i);
        ezVar.f(Integer.valueOf(com.google.android.libraries.navigation.internal.adu.m.HERE_AT_A_PLACE_TRANSIT_NOTIFICATION.eU), j.i);
        a = ezVar.d();
    }

    public u(w wVar) {
        this.b = ((h) wVar).a;
    }

    public final m a() {
        j jVar = (j) a.get(Integer.valueOf(this.b));
        ev evVar = jVar == null ? null : jVar.G;
        l lVarB = m.b();
        if (evVar != null) {
            ((a) lVarB).a = ev.o(evVar);
        }
        return lVarB.c();
    }
}
