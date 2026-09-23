package com.google.android.libraries.navigation.internal.afl;

import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.KodakMakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.imageutils.JfifUtil;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.navigation.camera.NavigationConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ha implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_TYPE(0),
    NAVIGATION(1),
    NAVIGATION2(247),
    NAVIGATION_CAMERA(ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE),
    ENABLE_FEATURES(2),
    SERVER_SETTING(3),
    VOICE_SEARCH(4),
    TILE_ZOOM_PROGRESSION(5),
    PREFETCHER_SETTINGS(6),
    DEPRECATED_7(7),
    VECTOR_MAPS(8),
    OFFERS(9),
    DEPRECATED_10(10),
    ADS(11),
    API(12),
    NEARBY_TRANSIT(13),
    GLS_REPORTING(14),
    EMERGENCY_MENU_ITEM(15),
    LOGGING(16),
    DEPRECATED_17(17),
    INSTALL_HANDSHAKE(18),
    PROMPT_TO_RATE_APP(19),
    USER_PREFERENCES_LOGGING(20),
    EXTERNAL_INVOCATION(21),
    CLIENT_URLS(22),
    SEARCH(23),
    PLACE_SHEET(24),
    PLACESHEET2(232),
    DIRECTIONS_PAGE(25),
    USER_GENERATED_CONTENT(26),
    OFFLINE_MAPS(27),
    TILE_TYPE_EXPIRATION(28),
    PARTNER_APPS(29),
    MEMORY_MANAGEMENT(30),
    SUGGEST(31),
    FEEDBACK(32),
    ODELAY(33),
    MAP_MOVEMENT_REQUERY(34),
    SEMANTIC_LOCATION(35),
    SURVEY(36),
    PAINT_PARAMETERS(37),
    TEXT_TO_SPEECH(38),
    HERE_NOTIFICATION(39),
    NETWORK(40),
    COMPASS_CALIBRATION(41),
    PROMO(42),
    CAR(43),
    PHOTO_TAKEN_NOTIFICATION(44),
    IMAGERY_VIEWER(45),
    DEPRECATED_46(46),
    MAPS_ACTIVITIES(47),
    DELHI_TRANSIT_PROMO(48),
    NUDGEBAR(49),
    DEPRECATED_50(50),
    LOCATION(51),
    ENROUTE(52),
    PASSIVE_ASSIST(53),
    DIRECTIONS_OVERVIEW(54),
    UGC_CONTRIBUTION_STATS(55),
    SAVED_STATE_EXPIRATION(56),
    NOTIFICATIONS(57),
    NOTIFICATIONS2(251),
    PLACE_LISTS(58),
    STARTUP_TIME(59),
    SATELLITE(60),
    DEPRECATED_61(61),
    TRAFFIC(62),
    IOS_TODAY_WIDGETS(63),
    SHARING(64),
    USER_LOCATION_ACTIONS(65),
    NAVIGATION_SHARING(66),
    ASSISTANT(67),
    RESOURCE_OVERRIDES(68),
    IMAGE_QUALITY(69),
    DEPRECATED_70(70),
    START_SCREEN(71),
    UGC_TASKS(72),
    DIRECTIONS_EXPERIMENTS(73),
    PROMO_PRESENTATION(74),
    TAXI(75),
    BATTERY_USAGE(76),
    ALIASED_LOCATIONS(77),
    PHOTO_UPLOAD(78),
    USER_TO_USER_BLOCKING(79),
    TANGO(80),
    PROMOTED_PLACES(81),
    HOTEL_BOOKING_MODULE(82),
    LOCATION_SHARING(83),
    SQLITE_TILE_CACHE(84),
    ACTIVE_DIRECTIONS(85),
    TRAFFIC_HUB(86),
    TUTORIAL(87),
    TRANSIT_PAGES(88),
    UGC_VIDEO(89),
    GMM_LAYER_CLIENTSIDE_EXPERIMENT(90),
    GOLDFINGER_LAYER_CLIENTSIDE_EXPERIMENT(91),
    NAVIGATION_SDK(92),
    PERSONAL_CONTEXT(93),
    TRANSIT_TRACKING(94),
    BADGES(95),
    EVENTS_UGC(96),
    COMMUTE_SETUP(97),
    COMMUTE_DRIVING_IMMERSIVE(NikonType2MakernoteDirectory.TAG_LENS),
    REVIEW_BONUS(98),
    TWO_WHEELER(99),
    TRANSIT_CROWDEDNESS(100),
    CLIENT_FLAGS(101),
    LOCAL_STREAM(102),
    LOCAL_PREFERENCES(103),
    TRIGGER_EXPERIMENT_ID(104),
    VEHICLE_ROTATION(105),
    HOME_SCREEN_MOD_EXPERIMENTS(RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN),
    UGC_OFFERINGS(107),
    MAP_LAYERS(108),
    DEPRECATED_109(109),
    TRIP_ASSISTANCE_NOTIFICATIONS(110),
    CONTRIBUTIONS_PAGE(PanasonicMakernoteDirectory.TAG_LANDMARK),
    HASHTAG(PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION),
    TRANSIT_ASSISTANCE_NOTIFICATIONS(113),
    PERSONAL_PLACES(114),
    MAP_CONTENT_ANNOTATIONS(115),
    SOCIAL_PLANNING_SHORTLISTING(116),
    CATEGORICAL_SEARCH(117),
    BUSINESS_MESSAGING(118),
    SPOTLIGHT_HIGHLIGHTING(PanasonicMakernoteDirectory.TAG_BURST_SPEED),
    LOCAL_FOLLOW(120),
    INBOX(PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE),
    OFF_ROUTE_ALERTS(122),
    MERCHANT_MODE(123),
    CREATOR_PROFILE(PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH),
    DIRECTIONS_FRAMEWORK(242),
    DRIVING_DIRECTIONS(243),
    TRANSIT_DIRECTIONS(244),
    BIKESHARING_DIRECTIONS(NavigationConstants.NAVIGATION_LOW_ALERT_DURATION),
    MULTIMODAL_DIRECTIONS(144),
    PRIVACY_ADVISOR(WebSocketProtocol.PAYLOAD_SHORT),
    MEDIA_INTEGRATION(127),
    MERCHANT(128),
    TRANSIT_TRIP_CHECK_IN(129),
    PEOPLE_FOLLOW(NikonType2MakernoteDirectory.TAG_ADAPTER),
    PLACE_OFFERINGS(131),
    DEALS(NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM),
    ZERO_RATING(NikonType2MakernoteDirectory.TAG_FLASH_USED),
    SERVICE_RECOMMENDATION_POST_INTERACTION_NOTIFICATION(137),
    EXPERIENCE(138),
    FLIGHT_DIRECTIONS(NikonType2MakernoteDirectory.TAG_LENS_STOPS),
    LENS(140),
    INCOGNITO(141),
    PLACE_MENU(142),
    EXPERIMENT_ATTRIBUTION_MAP(143),
    DEPRECATED_145(145),
    TRANSIT_DIRECTIONS_TRACKS(146),
    MAPS_API_PARAMETERS(147),
    PARKING_PAYMENT(148),
    HOME_SCREEN(149),
    EXPLORE_MAP(150),
    AUGMENTED_REALITY(151),
    JANK_ABLATION(152),
    BUSINESS_CALLS(153),
    FEDERATED_LOCATION(154),
    SAVED_TRIPS(NikonType2MakernoteDirectory.TAG_UNKNOWN_10),
    INFORMAL_TRANSIT(NikonType2MakernoteDirectory.TAG_SCENE_ASSIST),
    MEGA_PERSON(157),
    TRANSIT_TRIP_RESULTS(158),
    BUSINESS_DIRECTORY(159),
    MERCHANT_EXPERIENCE(160),
    GELLER(CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE),
    TRANSIT_PAYMENTS(162),
    TRANSIT_LINE_PAGE(163),
    STREET_VIEW_LAYER(164),
    ELECTRIC_VEHICLE(NikonType2MakernoteDirectory.TAG_IMAGE_COUNT),
    TWO_DIRECTION_PILOT(NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT),
    SYSTEM_HEALTH(NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER),
    NOTIFICATIONS_REPOSITORY(168),
    SERVICES_INTERACTIONS(169),
    LANGUAGE_SETTING(170),
    VMS_DATA_BACK(171),
    MAP_CONTENT(NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION),
    FACTUAL_PHOTO(NikonType2MakernoteDirectory.TAG_AF_RESPONSE),
    PROFILE_INCEPTION(174),
    ASSISTIVE_ORDER_PICKUP(176),
    VOICE_PLATE(177),
    ATOMIC_MAPS(178),
    CRISIS(179),
    BLUE_DOT(180),
    CRITICAL_USER_INTERACTION_TRACE(NikonType2MakernoteDirectory.TAG_UNKNOWN_48),
    VMS_PUBLISHING(182),
    PROACTIVE(NikonType2MakernoteDirectory.TAG_AF_INFO_2),
    TERRA(NikonType2MakernoteDirectory.TAG_FILE_INFO),
    WEBVIEW(NikonType2MakernoteDirectory.TAG_AF_TUNE),
    PLATFORM(186),
    PRIVACY(NikonType2MakernoteDirectory.TAG_UNKNOWN_49),
    SERVICE_LISTS_NOTIFICATION(188),
    REVIEW_SOLICITATION_NOTIFICATION(NikonType2MakernoteDirectory.TAG_UNKNOWN_50),
    SAVED_PLACES(190),
    OMNI_MAPS(191),
    PLUS_CODES(JfifUtil.MARKER_SOFn),
    ANDROID_WIDGET(193),
    DARK_MODE(194),
    LIVE_TRIPS(195),
    LOCALIZATION(196),
    ONBOARDING(197),
    UGC_PRIMITIVES(198),
    AREA_BUSYNESS(199),
    CURRENT_SEMANTIC_LOCATION(200),
    IOS_SIRI_SPOTLIGHT_INDEXING(201),
    NOVICE_EXPERIENCES(202),
    LOCALIZED_STRING(203),
    FUTURE_MAP_NOW_CAMERA(204),
    ECOSYSTEMS_WATCH(205),
    AT_A_PLACE(206),
    INDOOR(207),
    MOBILITY_DATA_REPORT_A_PROBLEM(208),
    DECOMMISSIONING(Mp4VideoDirectory.TAG_DEPTH),
    MOBILITY_INTELLIGENCE(Mp4VideoDirectory.TAG_COMPRESSION_TYPE),
    TRUCK_ROUTING(Mp4VideoDirectory.TAG_GRAPHICS_MODE),
    IMMERSIVE_VIEW(Mp4VideoDirectory.TAG_OPCOLOR),
    SHARED_WITH_YOU(Mp4VideoDirectory.TAG_COLOR_TABLE),
    TRANSPORTATION_LOGGER(Mp4VideoDirectory.TAG_FRAME_RATE),
    ON_DEVICE_LOCATION_HISTORY(JfifUtil.MARKER_RST7),
    ROUTE_DECORATIONS(JfifUtil.MARKER_SOI),
    ADAS(JfifUtil.MARKER_EOI),
    WEAR_MAPS_NAVIGATION(JfifUtil.MARKER_SOS),
    EXPLORE_THIS_AREA(219),
    AUTO_DESIGN_LIBRARY(220),
    UGC_REACTION(221),
    SETTINGS_PAGE(222),
    UGC_EXPERIMENT_ONLY(223),
    RAW_GNSS_LOGGING(CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY),
    UGC_PLACE_QA(JfifUtil.MARKER_APP1),
    VEHICLE_SETTINGS(226),
    UGC_LOCAL_GUIDE(227),
    FACTUAL_UGC(228),
    UGC_SUBJECTIVE(229),
    GROWTH_KIT(230),
    PLACESHEET_INFRASTRUCTURE(231),
    VIDEO_PLAYBACK(233),
    ROUTING_FEEDBACK(234),
    UGC_MIDTRIP(235),
    MAP_ADS(236),
    MAP_CORE(237),
    LIGHTBOX(238),
    XUIKIT(239),
    PHENOTYPE(240),
    UGC_REVIEWS(241),
    MAP_CORE_GEO_CONSUMER(245),
    PHENOTYPE_MIGRATION(246),
    UGC_MODERATION(248),
    PHENOTYPE_EXPERIMENT_IDS(249),
    SHARING2(250),
    UGC_CSL_AAPN(252),
    EXPLORE_ALONG_ROUTE(253),
    UGC_POST(255),
    GMSCORE_FREE_STATS(256),
    INFERRED_DIRECTIONS(258),
    IMAGERY_VIEWER2(259),
    OVERSIZE_UI(260),
    ZEN_CARD_STACK_MIGRATION(261),
    COMMUTE_NOTIFICATION_PARAMETERS(262),
    PHENOTYPE_CLIENT_DECOMMISSIONING_HTML(263),
    DEEP_LINK(264),
    ASKMAPS(265),
    MAPS_API_EXPERIMENT(266),
    CLUSTER_UI(267),
    THANKS_PAGE(268),
    UGC_ELIGIBILITY(269);

    public final int eg;

    ha(int i) {
        this.eg = i;
    }

    public static ha b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_TYPE;
            case 1:
                return NAVIGATION;
            case 2:
                return ENABLE_FEATURES;
            case 3:
                return SERVER_SETTING;
            case 4:
                return VOICE_SEARCH;
            case 5:
                return TILE_ZOOM_PROGRESSION;
            case 6:
                return PREFETCHER_SETTINGS;
            case 7:
                return DEPRECATED_7;
            case 8:
                return VECTOR_MAPS;
            case 9:
                return OFFERS;
            case 10:
                return DEPRECATED_10;
            case 11:
                return ADS;
            case 12:
                return API;
            case 13:
                return NEARBY_TRANSIT;
            case 14:
                return GLS_REPORTING;
            case 15:
                return EMERGENCY_MENU_ITEM;
            case 16:
                return LOGGING;
            case 17:
                return DEPRECATED_17;
            case 18:
                return INSTALL_HANDSHAKE;
            case 19:
                return PROMPT_TO_RATE_APP;
            case 20:
                return USER_PREFERENCES_LOGGING;
            case 21:
                return EXTERNAL_INVOCATION;
            case 22:
                return CLIENT_URLS;
            case 23:
                return SEARCH;
            case 24:
                return PLACE_SHEET;
            case 25:
                return DIRECTIONS_PAGE;
            case 26:
                return USER_GENERATED_CONTENT;
            case 27:
                return OFFLINE_MAPS;
            case 28:
                return TILE_TYPE_EXPIRATION;
            case 29:
                return PARTNER_APPS;
            case 30:
                return MEMORY_MANAGEMENT;
            case 31:
                return SUGGEST;
            case 32:
                return FEEDBACK;
            case 33:
                return ODELAY;
            case 34:
                return MAP_MOVEMENT_REQUERY;
            case 35:
                return SEMANTIC_LOCATION;
            case 36:
                return SURVEY;
            case 37:
                return PAINT_PARAMETERS;
            case 38:
                return TEXT_TO_SPEECH;
            case 39:
                return HERE_NOTIFICATION;
            case 40:
                return NETWORK;
            case 41:
                return COMPASS_CALIBRATION;
            case 42:
                return PROMO;
            case 43:
                return CAR;
            case 44:
                return PHOTO_TAKEN_NOTIFICATION;
            case 45:
                return IMAGERY_VIEWER;
            case 46:
                return DEPRECATED_46;
            case 47:
                return MAPS_ACTIVITIES;
            case 48:
                return DELHI_TRANSIT_PROMO;
            case 49:
                return NUDGEBAR;
            case 50:
                return DEPRECATED_50;
            case 51:
                return LOCATION;
            case 52:
                return ENROUTE;
            case 53:
                return PASSIVE_ASSIST;
            case 54:
                return DIRECTIONS_OVERVIEW;
            case 55:
                return UGC_CONTRIBUTION_STATS;
            case 56:
                return SAVED_STATE_EXPIRATION;
            case 57:
                return NOTIFICATIONS;
            case 58:
                return PLACE_LISTS;
            case 59:
                return STARTUP_TIME;
            case 60:
                return SATELLITE;
            case 61:
                return DEPRECATED_61;
            case 62:
                return TRAFFIC;
            case 63:
                return IOS_TODAY_WIDGETS;
            case 64:
                return SHARING;
            case 65:
                return USER_LOCATION_ACTIONS;
            case 66:
                return NAVIGATION_SHARING;
            case 67:
                return ASSISTANT;
            case 68:
                return RESOURCE_OVERRIDES;
            case 69:
                return IMAGE_QUALITY;
            case 70:
                return DEPRECATED_70;
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                return START_SCREEN;
            case 72:
                return UGC_TASKS;
            case 73:
                return DIRECTIONS_EXPERIMENTS;
            case ReconyxHyperFireMakernoteDirectory.TAG_BRIGHTNESS /* 74 */:
                return PROMO_PRESENTATION;
            case 75:
                return TAXI;
            case 76:
                return BATTERY_USAGE;
            case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                return ALIASED_LOCATIONS;
            case 78:
                return PHOTO_UPLOAD;
            case 79:
                return USER_TO_USER_BLOCKING;
            case 80:
                return TANGO;
            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                return PROMOTED_PLACES;
            case 82:
                return HOTEL_BOOKING_MODULE;
            case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                return LOCATION_SHARING;
            case 84:
                return SQLITE_TILE_CACHE;
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                return ACTIVE_DIRECTIONS;
            case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
                return TRAFFIC_HUB;
            case 87:
                return TUTORIAL;
            case 88:
                return TRANSIT_PAGES;
            case PanasonicMakernoteDirectory.TAG_TRANSFORM /* 89 */:
                return UGC_VIDEO;
            case 90:
                return GMM_LAYER_CLIENTSIDE_EXPERIMENT;
            case 91:
                return GOLDFINGER_LAYER_CLIENTSIDE_EXPERIMENT;
            case KodakMakernoteDirectory.TAG_FLASH_MODE /* 92 */:
                return NAVIGATION_SDK;
            case 93:
                return PERSONAL_CONTEXT;
            case KodakMakernoteDirectory.TAG_ISO_SETTING /* 94 */:
                return TRANSIT_TRACKING;
            case 95:
                return BADGES;
            case 96:
                return EVENTS_UGC;
            case PanasonicMakernoteDirectory.TAG_FACE_RECOGNITION_INFO /* 97 */:
                return COMMUTE_SETUP;
            case 98:
                return REVIEW_BONUS;
            case 99:
                return TWO_WHEELER;
            case 100:
                return TRANSIT_CROWDEDNESS;
            case 101:
                return CLIENT_FLAGS;
            case 102:
                return LOCAL_STREAM;
            case 103:
                return LOCAL_PREFERENCES;
            case 104:
                return TRIGGER_EXPERIMENT_ID;
            case 105:
                return VEHICLE_ROTATION;
            case RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN /* 106 */:
                return HOME_SCREEN_MOD_EXPERIMENTS;
            case 107:
                return UGC_OFFERINGS;
            case 108:
                return MAP_LAYERS;
            case 109:
                return DEPRECATED_109;
            case 110:
                return TRIP_ASSISTANCE_NOTIFICATIONS;
            case PanasonicMakernoteDirectory.TAG_LANDMARK /* 111 */:
                return CONTRIBUTIONS_PAGE;
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION /* 112 */:
                return HASHTAG;
            case 113:
                return TRANSIT_ASSISTANCE_NOTIFICATIONS;
            case 114:
                return PERSONAL_PLACES;
            case 115:
                return MAP_CONTENT_ANNOTATIONS;
            case 116:
                return SOCIAL_PLANNING_SHORTLISTING;
            case 117:
                return CATEGORICAL_SEARCH;
            case 118:
                return BUSINESS_MESSAGING;
            case PanasonicMakernoteDirectory.TAG_BURST_SPEED /* 119 */:
                return SPOTLIGHT_HIGHLIGHTING;
            case 120:
                return LOCAL_FOLLOW;
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE /* 121 */:
                return INBOX;
            case 122:
                return OFF_ROUTE_ALERTS;
            case 123:
                return MERCHANT_MODE;
            case PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH /* 124 */:
                return CREATOR_PROFILE;
            case NavigationConstants.NAVIGATION_LOW_ALERT_DURATION /* 125 */:
                return BIKESHARING_DIRECTIONS;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                return PRIVACY_ADVISOR;
            case 127:
                return MEDIA_INTEGRATION;
            case 128:
                return MERCHANT;
            case 129:
                return TRANSIT_TRIP_CHECK_IN;
            case NikonType2MakernoteDirectory.TAG_ADAPTER /* 130 */:
                return PEOPLE_FOLLOW;
            case 131:
                return PLACE_OFFERINGS;
            case NikonType2MakernoteDirectory.TAG_LENS /* 132 */:
                return COMMUTE_DRIVING_IMMERSIVE;
            case NikonType2MakernoteDirectory.TAG_MANUAL_FOCUS_DISTANCE /* 133 */:
            case 136:
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_30 /* 175 */:
            case 257:
            default:
                return null;
            case NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM /* 134 */:
                return DEALS;
            case NikonType2MakernoteDirectory.TAG_FLASH_USED /* 135 */:
                return ZERO_RATING;
            case 137:
                return SERVICE_RECOMMENDATION_POST_INTERACTION_NOTIFICATION;
            case 138:
                return EXPERIENCE;
            case NikonType2MakernoteDirectory.TAG_LENS_STOPS /* 139 */:
                return FLIGHT_DIRECTIONS;
            case 140:
                return LENS;
            case 141:
                return INCOGNITO;
            case 142:
                return PLACE_MENU;
            case 143:
                return EXPERIMENT_ATTRIBUTION_MAP;
            case 144:
                return MULTIMODAL_DIRECTIONS;
            case 145:
                return DEPRECATED_145;
            case 146:
                return TRANSIT_DIRECTIONS_TRACKS;
            case 147:
                return MAPS_API_PARAMETERS;
            case 148:
                return PARKING_PAYMENT;
            case 149:
                return HOME_SCREEN;
            case 150:
                return EXPLORE_MAP;
            case 151:
                return AUGMENTED_REALITY;
            case 152:
                return JANK_ABLATION;
            case 153:
                return BUSINESS_CALLS;
            case 154:
                return FEDERATED_LOCATION;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_10 /* 155 */:
                return SAVED_TRIPS;
            case NikonType2MakernoteDirectory.TAG_SCENE_ASSIST /* 156 */:
                return INFORMAL_TRANSIT;
            case 157:
                return MEGA_PERSON;
            case 158:
                return TRANSIT_TRIP_RESULTS;
            case 159:
                return BUSINESS_DIRECTORY;
            case 160:
                return MERCHANT_EXPERIENCE;
            case CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE /* 161 */:
                return GELLER;
            case 162:
                return TRANSIT_PAYMENTS;
            case 163:
                return TRANSIT_LINE_PAGE;
            case 164:
                return STREET_VIEW_LAYER;
            case NikonType2MakernoteDirectory.TAG_IMAGE_COUNT /* 165 */:
                return ELECTRIC_VEHICLE;
            case NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT /* 166 */:
                return TWO_DIRECTION_PILOT;
            case NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER /* 167 */:
                return SYSTEM_HEALTH;
            case 168:
                return NOTIFICATIONS_REPOSITORY;
            case 169:
                return SERVICES_INTERACTIONS;
            case 170:
                return LANGUAGE_SETTING;
            case 171:
                return VMS_DATA_BACK;
            case NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION /* 172 */:
                return MAP_CONTENT;
            case NikonType2MakernoteDirectory.TAG_AF_RESPONSE /* 173 */:
                return FACTUAL_PHOTO;
            case 174:
                return PROFILE_INCEPTION;
            case 176:
                return ASSISTIVE_ORDER_PICKUP;
            case 177:
                return VOICE_PLATE;
            case 178:
                return ATOMIC_MAPS;
            case 179:
                return CRISIS;
            case 180:
                return BLUE_DOT;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_48 /* 181 */:
                return CRITICAL_USER_INTERACTION_TRACE;
            case 182:
                return VMS_PUBLISHING;
            case NikonType2MakernoteDirectory.TAG_AF_INFO_2 /* 183 */:
                return PROACTIVE;
            case NikonType2MakernoteDirectory.TAG_FILE_INFO /* 184 */:
                return TERRA;
            case NikonType2MakernoteDirectory.TAG_AF_TUNE /* 185 */:
                return WEBVIEW;
            case 186:
                return PLATFORM;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_49 /* 187 */:
                return PRIVACY;
            case 188:
                return SERVICE_LISTS_NOTIFICATION;
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_50 /* 189 */:
                return REVIEW_SOLICITATION_NOTIFICATION;
            case 190:
                return SAVED_PLACES;
            case 191:
                return OMNI_MAPS;
            case JfifUtil.MARKER_SOFn /* 192 */:
                return PLUS_CODES;
            case 193:
                return ANDROID_WIDGET;
            case 194:
                return DARK_MODE;
            case 195:
                return LIVE_TRIPS;
            case 196:
                return LOCALIZATION;
            case 197:
                return ONBOARDING;
            case 198:
                return UGC_PRIMITIVES;
            case 199:
                return AREA_BUSYNESS;
            case 200:
                return CURRENT_SEMANTIC_LOCATION;
            case 201:
                return IOS_SIRI_SPOTLIGHT_INDEXING;
            case 202:
                return NOVICE_EXPERIENCES;
            case 203:
                return LOCALIZED_STRING;
            case 204:
                return FUTURE_MAP_NOW_CAMERA;
            case 205:
                return ECOSYSTEMS_WATCH;
            case 206:
                return AT_A_PLACE;
            case 207:
                return INDOOR;
            case 208:
                return MOBILITY_DATA_REPORT_A_PROBLEM;
            case Mp4VideoDirectory.TAG_DEPTH /* 209 */:
                return DECOMMISSIONING;
            case Mp4VideoDirectory.TAG_COMPRESSION_TYPE /* 210 */:
                return MOBILITY_INTELLIGENCE;
            case Mp4VideoDirectory.TAG_GRAPHICS_MODE /* 211 */:
                return TRUCK_ROUTING;
            case Mp4VideoDirectory.TAG_OPCOLOR /* 212 */:
                return IMMERSIVE_VIEW;
            case Mp4VideoDirectory.TAG_COLOR_TABLE /* 213 */:
                return SHARED_WITH_YOU;
            case Mp4VideoDirectory.TAG_FRAME_RATE /* 214 */:
                return TRANSPORTATION_LOGGER;
            case JfifUtil.MARKER_RST7 /* 215 */:
                return ON_DEVICE_LOCATION_HISTORY;
            case JfifUtil.MARKER_SOI /* 216 */:
                return ROUTE_DECORATIONS;
            case JfifUtil.MARKER_EOI /* 217 */:
                return ADAS;
            case JfifUtil.MARKER_SOS /* 218 */:
                return WEAR_MAPS_NAVIGATION;
            case 219:
                return EXPLORE_THIS_AREA;
            case 220:
                return AUTO_DESIGN_LIBRARY;
            case 221:
                return UGC_REACTION;
            case 222:
                return SETTINGS_PAGE;
            case 223:
                return UGC_EXPERIMENT_ONLY;
            case CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY /* 224 */:
                return RAW_GNSS_LOGGING;
            case JfifUtil.MARKER_APP1 /* 225 */:
                return UGC_PLACE_QA;
            case 226:
                return VEHICLE_SETTINGS;
            case 227:
                return UGC_LOCAL_GUIDE;
            case 228:
                return FACTUAL_UGC;
            case 229:
                return UGC_SUBJECTIVE;
            case 230:
                return GROWTH_KIT;
            case 231:
                return PLACESHEET_INFRASTRUCTURE;
            case 232:
                return PLACESHEET2;
            case 233:
                return VIDEO_PLAYBACK;
            case 234:
                return ROUTING_FEEDBACK;
            case 235:
                return UGC_MIDTRIP;
            case 236:
                return MAP_ADS;
            case 237:
                return MAP_CORE;
            case 238:
                return LIGHTBOX;
            case 239:
                return XUIKIT;
            case 240:
                return PHENOTYPE;
            case 241:
                return UGC_REVIEWS;
            case 242:
                return DIRECTIONS_FRAMEWORK;
            case 243:
                return DRIVING_DIRECTIONS;
            case 244:
                return TRANSIT_DIRECTIONS;
            case 245:
                return MAP_CORE_GEO_CONSUMER;
            case 246:
                return PHENOTYPE_MIGRATION;
            case 247:
                return NAVIGATION2;
            case 248:
                return UGC_MODERATION;
            case 249:
                return PHENOTYPE_EXPERIMENT_IDS;
            case 250:
                return SHARING2;
            case 251:
                return NOTIFICATIONS2;
            case 252:
                return UGC_CSL_AAPN;
            case 253:
                return EXPLORE_ALONG_ROUTE;
            case ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE /* 254 */:
                return NAVIGATION_CAMERA;
            case 255:
                return UGC_POST;
            case 256:
                return GMSCORE_FREE_STATS;
            case 258:
                return INFERRED_DIRECTIONS;
            case 259:
                return IMAGERY_VIEWER2;
            case 260:
                return OVERSIZE_UI;
            case 261:
                return ZEN_CARD_STACK_MIGRATION;
            case 262:
                return COMMUTE_NOTIFICATION_PARAMETERS;
            case 263:
                return PHENOTYPE_CLIENT_DECOMMISSIONING_HTML;
            case 264:
                return DEEP_LINK;
            case 265:
                return ASKMAPS;
            case 266:
                return MAPS_API_EXPERIMENT;
            case 267:
                return CLUSTER_UI;
            case 268:
                return THANKS_PAGE;
            case 269:
                return UGC_ELIGIBILITY;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.eg;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.eg);
    }
}
