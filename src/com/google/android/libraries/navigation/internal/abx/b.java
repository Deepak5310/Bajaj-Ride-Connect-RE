package com.google.android.libraries.navigation.internal.abx;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.volley.DefaultRetryPolicy;
import com.drew.metadata.avi.AviDirectory;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.mov.metadata.QuickTimeMetadataDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.libraries.navigation.internal.ael.bm;
import com.google.firebase.perf.util.Constants;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.navigation.NavigationConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum b implements bm {
    UNKNOWN_EVENT(0),
    MAP_CREATED(100),
    MAP_SET_ZOOM_LIMIT(101),
    MAP_SET_ON_MAP_READY_CALLBACK(102),
    MAP_SET_FRAMERATE(103),
    MAP_READY(104),
    MAP_SET_BACKGROUND_COLOR(105),
    MAP_SET_BACKGROUND_COLOR_POST_INIT(3900),
    MAP_TILE_LOAD(RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN),
    MAP_LABEL_LOAD(107),
    MAP_FRAMERATE_SNAPSHOT(108),
    MAP_INITIALIZATION_REQUEST_DEFAULT(109),
    MAP_INITIALIZATION_REQUEST_OPT_IN(110),
    MAP_INITIALIZATION_REQUEST_OPT_OUT(PanasonicMakernoteDirectory.TAG_LANDMARK),
    MAP_INITIALIZATION_RESULT_LATEST(PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION),
    MAP_INITIALIZATION_RESULT_LEGACY(113),
    MAP_METAL_RENDERING(114),
    MAP_LIFE_CYCLE(115),
    MAP_REALTIME_COUNTERS(116),
    STYLED_MAP_READY(117),
    MAP_SET_DARK_MODE(118),
    MAP_FALLBACK_LITE_MODE(PanasonicMakernoteDirectory.TAG_BURST_SPEED),
    MAP_ADD_MARKER(200),
    MARKER_REMOVE(201),
    MARKER_SET_POSITION(202),
    MARKER_TITLE(203),
    MARKER_SNIPPET(204),
    MARKER_ICON(205),
    MARKER_ANCHOR(206),
    MARKER_DRAGGABLE(207),
    MARKER_WAS_DRAGGED(208),
    MARKER_VISIBILITY(Mp4VideoDirectory.TAG_DEPTH),
    MARKER_FLAT(Mp4VideoDirectory.TAG_COMPRESSION_TYPE),
    MARKER_ROTATION(Mp4VideoDirectory.TAG_GRAPHICS_MODE),
    MARKER_INFO_WINDOW_ANCHOR(Mp4VideoDirectory.TAG_OPCOLOR),
    MARKER_ALPHA(Mp4VideoDirectory.TAG_COLOR_TABLE),
    MARKER_SHOW_INFO_BUBBLE(Mp4VideoDirectory.TAG_FRAME_RATE),
    MARKER_HIDE_INFO_BUBBLE(JfifUtil.MARKER_RST7),
    MARKER_SET_INFO_CONTENTS_ADAPTER(JfifUtil.MARKER_SOI),
    MARKER_INFO_WINDOW_CLICK_WITH_LISTENER(JfifUtil.MARKER_EOI),
    MARKER_INFO_WINDOW_CLICK_WITHOUT_LISTENER(JfifUtil.MARKER_SOS),
    MARKER_CLICK_WITH_LISTENER(219),
    MARKER_CLICK_WITH_INTERRUPTING_LISTENER(220),
    MARKER_CLICK_WITHOUT_LISTENER(221),
    OBSOLETE_MARKER_SHOW_INFO_BUBBLE_CONTENTS(222),
    MARKER_INFO_WINDOW_LONG_CLICK_WITH_LISTENER(223),
    MARKER_INFO_WINDOW_LONG_CLICK_WITHOUT_LISTENER(CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY),
    MARKER_INFO_WINDOW_CLOSE_WITH_LISTENER(JfifUtil.MARKER_APP1),
    MARKER_INFO_WINDOW_CLOSE_WITHOUT_LISTENER(226),
    MARKER_SET_TAG(227),
    MARKER_Z_INDEX(228),
    MARKER_COLLISION_BEHAVIOR(229),
    MARKER_COLLISION_BEHAVIOR_IOS(230),
    MARKER_CONTENT_DESCRIPTION(231),
    MAP_ADD_POLYLINE(300),
    POLYLINE_REMOVE(301),
    POLYLINE_SET_POINTS(302),
    POLYLINE_WIDTH(303),
    POLYLINE_COLOR(304),
    POLYLINE_Z_INDEX(305),
    POLYLINE_VISIBILITY(306),
    POLYLINE_GEODESIC(307),
    POLYLINE_TEXTURE(308),
    POLYLINE_SPANS(309),
    POLYLINE_SPANS_GRADIENT(310),
    POLYLINE_SPANS_FRACTIONAL(311),
    POLYLINE_CLICK_WITH_LISTENER(312),
    POLYLINE_CLICK_WITHOUT_LISTENER(313),
    POLYLINE_CLICKABILITY(314),
    POLYLINE_START_CAP(315),
    POLYLINE_END_CAP(316),
    POLYLINE_JOINT_TYPE(317),
    POLYLINE_PATTERN(318),
    POLYLINE_SET_TAG(ExifDirectoryBase.TAG_PRIMARY_CHROMATICITIES),
    POLYLINE_RESET_POINTS(AviDirectory.TAG_DATETIME_ORIGINAL),
    POLYLINE_SPANS_CHANGED(321),
    POLYLINE_SPANS_COUNT_CHANGED(ExifDirectoryBase.TAG_TILE_WIDTH),
    POLYLINE_SPANS_SEGMENTS_CHANGED(ExifDirectoryBase.TAG_TILE_LENGTH),
    POLYLINE_SPANS_COLOR_CHANGED(ExifDirectoryBase.TAG_TILE_OFFSETS),
    POLYLINE_SPANS_STAMP(ExifDirectoryBase.TAG_TILE_BYTE_COUNTS),
    POLYLINE_SPRITE(IptcDirectory.TAG_DATE_SENT),
    MAP_ADD_POLYGON(400),
    POLYGON_REMOVE(TypedValues.CycleType.TYPE_CURVE_FIT),
    POLYGON_SET_POINTS(TypedValues.CycleType.TYPE_VISIBILITY),
    POLYGON_HOLES(TypedValues.CycleType.TYPE_ALPHA),
    POLYGON_WIDTH(404),
    POLYGON_STROKE_COLOR(405),
    POLYGON_FILL_COLOR(406),
    POLYGON_Z_INDEX(407),
    POLYGON_VISIBILITY(408),
    POLYGON_GEODESIC(409),
    POLYGON_CLICK_WITH_LISTENER(410),
    POLYGON_CLICK_WITHOUT_LISTENER(411),
    POLYGON_CLICKABILITY(412),
    POLYGON_STROKE_JOINT_TYPE(413),
    POLYGON_STROKE_PATTERN(414),
    POLYGON_SET_TAG(415),
    MAP_ADD_CIRCLE(500),
    CIRCLE_REMOVE(TypedValues.PositionType.TYPE_TRANSITION_EASING),
    CIRCLE_SET_CENTER(TypedValues.PositionType.TYPE_DRAWPATH),
    CIRCLE_SET_RADIUS(TypedValues.PositionType.TYPE_PERCENT_WIDTH),
    CIRCLE_WIDTH(TypedValues.PositionType.TYPE_PERCENT_HEIGHT),
    CIRCLE_STROKE_COLOR(TypedValues.PositionType.TYPE_SIZE_PERCENT),
    CIRCLE_FILL_COLOR(TypedValues.PositionType.TYPE_PERCENT_X),
    CIRCLE_Z_INDEX(TypedValues.PositionType.TYPE_PERCENT_Y),
    CIRCLE_VISIBILITY(TypedValues.PositionType.TYPE_CURVE_FIT),
    CIRCLE_CLICK_WITH_LISTENER(509),
    CIRCLE_CLICK_WITHOUT_LISTENER(TypedValues.PositionType.TYPE_POSITION_TYPE),
    CIRCLE_CLICKABILITY(511),
    CIRCLE_STROKE_PATTERN(512),
    CIRCLE_SET_TAG(513),
    MAP_ADD_GROUND_OVERLAY(600),
    GROUND_OVERLAY_REMOVE(601),
    GROUND_OVERLAY_BEARING(602),
    GROUND_OVERLAY_SET_DIMENSIONS(TypedValues.MotionType.TYPE_EASING),
    GROUND_OVERLAY_SET_LOCATION(604),
    GROUND_OVERLAY_Z_INDEX(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO),
    GROUND_OVERLAY_VISIBILITY(TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO),
    GROUND_OVERLAY_TRANSPARENCY(607),
    GROUND_OVERLAY_SET_IMAGE(TypedValues.MotionType.TYPE_DRAW_PATH),
    GROUND_OVERLAY_CLICK_WITH_LISTENER(TypedValues.MotionType.TYPE_POLAR_RELATIVETO),
    GROUND_OVERLAY_CLICK_WITHOUT_LISTENER(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS),
    GROUND_OVERLAY_CLICKABILITY(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE),
    GROUND_OVERLAY_SET_TAG(612),
    MAP_ADD_TILE_OVERLAY(700),
    TILE_OVERLAY_CLEAR_CACHE(TypedValues.TransitionType.TYPE_FROM),
    TILE_OVERLAY_REMOVE(TypedValues.TransitionType.TYPE_TO),
    TILE_OVERLAY_Z_INDEX(703),
    TILE_OVERLAY_VISIBILITY(TypedValues.TransitionType.TYPE_AUTO_TRANSITION),
    TILE_OVERLAY_FADE(TypedValues.TransitionType.TYPE_INTERPOLATOR),
    TILE_OVERLAY_TRANSPARENCY(TypedValues.TransitionType.TYPE_STAGGERED),
    MAP_ADD_MAPS_ENGINE_OVERLAY(800),
    MAPS_ENGINE_OVERLAY_REMOVE(LeicaMakernoteDirectory.TAG_COLOR_TEMPERATURE),
    MAPS_ENGINE_OVERLAY_Z_INDEX(LeicaMakernoteDirectory.TAG_WB_RED_LEVEL),
    MAPS_ENGINE_OVERLAY_VISIBILITY(LeicaMakernoteDirectory.TAG_WB_GREEN_LEVEL),
    MAPS_ENGINE_OVERLAY_DEFAULT_UI(LeicaMakernoteDirectory.TAG_WB_BLUE_LEVEL),
    MAPS_ENGINE_OVERLAY_CLICK_LISTENER(805),
    MAP_ANIMATE_CAMERA(900),
    MAP_ANIMATE_CAMERA_WITH_CALLBACK(TypedValues.Custom.TYPE_FLOAT),
    MAP_ANIMATE_CAMERA_WITH_CALLBACK_AND_CUSTOM_DURATION(TypedValues.Custom.TYPE_COLOR),
    MAP_MOVE_CAMERA(TypedValues.Custom.TYPE_STRING),
    MAP_STOP_ANIMATION(TypedValues.Custom.TYPE_BOOLEAN),
    CAMERA_UPDATE_ZOOM_IN(1000),
    CAMERA_UPDATE_ZOOM_OUT(1001),
    CAMERA_UPDATE_SCROLL_BY(1002),
    CAMERA_UPDATE_ZOOM_TO(1003),
    CAMERA_UPDATE_ZOOM_BY(1004),
    CAMERA_UPDATE_ZOOM_BY_FIXING(1005),
    CAMERA_UPDATE_NEW_CAMERA_POSITION(1006),
    CAMERA_UPDATE_NEW_LATLNG(1007),
    CAMERA_UPDATE_NEW_LATLNG_ZOOM(1008),
    CAMERA_UPDATE_NEW_LATLNG_BOUNDS(1009),
    CAMERA_UPDATE_NEW_LATLNG_BOUNDS_WITH_DIMENSIONS(1010),
    CAMERA_ZOOM_DEVELOPER_MINIMUM(1011),
    CAMERA_ZOOM_DEVELOPER_MAXIMUM(1012),
    CAMERA_ZOOM_DEVELOPER_RESET(1013),
    CAMERA_LAT_LNG_DEVELOPER_CLAMP(1014),
    MAP_CLEAR(1100),
    MAP_SET_MAP_TYPE(1101),
    MAP_SET_TRAFFIC_DISABLED(1102),
    MAP_SET_TRAFFIC_ENABLED(1103),
    MAP_SET_TRANSIT_DISABLED(1104),
    MAP_SET_TRANSIT_ENABLED(1105),
    MAP_SET_MY_LOCATION_DISABLED(1106),
    MAP_SET_MY_LOCATION_ENABLED(1107),
    MAP_SET_BUILDINGS_DISABLED(1108),
    MAP_SET_BUILDINGS_ENABLED(1109),
    MAP_SET_MAP_TYPE_NONE(1120),
    MAP_SET_MAP_TYPE_NORMAL(1121),
    MAP_SET_MAP_TYPE_SATELLITE(1122),
    MAP_SET_MAP_TYPE_TERRAIN(1123),
    MAP_SET_MAP_TYPE_HYBRID(1124),
    MAP_CLEAR_LOCATION_SOURCE(1200),
    MAP_GET_MY_LOCATION(1201),
    MAP_SET_LOCATION_SOURCE(1202),
    MAP_SET_ON_MY_LOCATION_CHANGE_LISTENER(1203),
    MAP_SET_ON_MY_LOCATION_BUTTON_CLICK_LISTENER(1204),
    MAP_SET_FOLLOW_MY_LOCATION_ENABLED(1205),
    MAP_SET_FOLLOW_MY_LOCATION_DISABLED(1206),
    MAP_SET_ON_MY_LOCATION_CLICK_LISTENER(1207),
    MY_LOCATION_CLICK_WITH_LISTENER(1208),
    MY_LOCATION_CLICK_WITHOUT_LISTENER(1209),
    MAP_SET_ON_BUBBLE_CLICK_LISTENER(1300),
    MAP_SET_ON_BUBBLE_DOUBLE_CLICK_LISTENER(QuickTimeMetadataDirectory.TAG_LOCATION_BODY),
    MAP_SET_ON_CAMERA_CHANGE_LISTENER(QuickTimeMetadataDirectory.TAG_LOCATION_NOTE),
    MAP_SET_ON_INDOOR_LISTENER(QuickTimeMetadataDirectory.TAG_LOCATION_ROLE),
    OBSOLETE_MAP_SET_ON_MAP_GESTURE_LISTENER(QuickTimeMetadataDirectory.TAG_LOCATION_DATE),
    MAP_SET_ON_MAP_CLICK_LISTENER(QuickTimeMetadataDirectory.TAG_DIRECTION_FACING),
    MAP_SET_ON_MAP_LONG_CLICK_LISTENER(QuickTimeMetadataDirectory.TAG_DIRECTION_MOTION),
    MAP_SET_ON_MARKER_CLICK_LISTENER(QuickTimeMetadataDirectory.TAG_DISPLAY_NAME),
    MAP_SET_ON_MARKER_DRAG_LISTENER(QuickTimeMetadataDirectory.TAG_CONTENT_IDENTIFIER),
    MAP_SET_ON_MAP_IDLE_LISTENER(QuickTimeMetadataDirectory.TAG_MAKE),
    MAP_SET_ON_GROUND_OVERLAY_CLICK_LISTENER(QuickTimeMetadataDirectory.TAG_MODEL),
    MAP_SET_ON_BUBBLE_LONG_CLICK_LISTENER(QuickTimeMetadataDirectory.TAG_ORIGINATING_SIGNATURE),
    MAP_SET_ON_BUBBLE_CLOSE_LISTENER(1312),
    MAP_SET_ON_POLYGON_CLICK_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeSaturation),
    MAP_SET_ON_POLYLINE_CLICK_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue),
    MAP_SET_ON_CIRCLE_CLICK_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeContrast),
    MAP_SET_ON_CAMERA_IDLE_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeSharpness),
    MAP_SET_ON_CAMERA_MOVE_CANCELED_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeBWFilter),
    MAP_SET_ON_CAMERA_MOVE_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeTone),
    MAP_SET_ON_CAMERA_MOVE_STARTED_LISTENER(OlympusCameraSettingsMakernoteDirectory.TagNoiseFilter),
    COMPASS_BUTTON_CLICK(1400),
    MAP_DISABLE_COMPASS(1401),
    MAP_DISABLE_MY_LOCATION_BUTTON(1402),
    MAP_DISABLE_ZOOM_CONTROLS(1403),
    MAP_ENABLE_COMPASS(1404),
    MAP_ENABLE_MY_LOCATION_BUTTON(1405),
    MAP_ENABLE_ZOOM_CONTROLS(1406),
    MY_LOCATION_BUTTON_CLICK(1407),
    GOOGLE_LOGO_CLICK(1408),
    ZOOM_IN_BUTTON_CLICK(1409),
    ZOOM_OUT_BUTTON_CLICK(1410),
    MAP_ENABLE_SCROLL(1411),
    MAP_DISABLE_SCROLL(1412),
    MAP_ENABLE_ZOOM(1413),
    MAP_DISABLE_ZOOM(1414),
    MAP_ENABLE_ROTATE(1415),
    MAP_DISABLE_ROTATE(1416),
    MAP_ENABLE_TILT(1417),
    MAP_DISABLE_TILT(1418),
    MAP_ENABLE_ALL_GESTURES(1419),
    MAP_DISABLE_ALL_GESTURES(1420),
    MAP_ENABLE_MAP_TOOLBAR(1421),
    MAP_DISABLE_MAP_TOOLBAR(1422),
    MAP_ENABLE_SCROLL_DURING_ROTATE_OR_ZOOM(1423),
    MAP_DISABLE_SCROLL_DURING_ROTATE_OR_ZOOM(1424),
    MAP_SET_INFO_WINDOW(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED),
    MAP_GET_PROJECTION(1600),
    PROJECTION_FROM_SCREEN_LOCATION(1601),
    PROJECTION_GET_FRUSTUM(1602),
    PROJECTION_TO_SCREEN_LOCATION(1603),
    PROJECTION_TO_SCREEN_LOCATION_WITH_ALTITUDE(1604),
    KEYBOARD_UP(1700),
    KEYBOARD_DOWN(1701),
    KEYBOARD_LEFT(1702),
    KEYBOARD_RIGHT(1703),
    MAP_ENABLE_INDOOR(1800),
    MAP_DISABLE_INDOOR(1801),
    MAP_ENABLE_INDOOR_LEVEL_PICKER(1802),
    MAP_DISABLE_INDOOR_LEVEL_PICKER(1803),
    INDOOR_ACTIVATE_LEVEL(1804),
    INDOOR_GET_ACTIVE_LEVEL(1805),
    INDOOR_GET_FOCUSED_BUILDING(1806),
    INDOOR_GET_LEVELS(1807),
    INDOOR_GET_VISIBLE_BUILDINGS(1808),
    INDOOR_GET_DEFAULT_LEVEL(1809),
    INDOOR_IS_UNDERGROUND(1810),
    MAP_REQUEST_TILE_PREFETCH_AREA(1900),
    MAP_SET_EXTERNAL_CACHE(1901),
    MAP_CLEAR_EXTERNAL_CACHE(1902),
    MAP_SET_NETWORK_ENABLED(1903),
    MAP_SET_NETWORK_DISABLED(1904),
    MAP_SNAPSHOT(Constants.MAX_URL_LENGTH),
    MAP_SNAPSHOT_ALLOCATED_BITMAP(2001),
    PANORAMA_CREATED(2100),
    PANORAMA_ADD_MARKER(2101),
    PANORAMA_REMOVE_MARKER(2102),
    PANORAMA_ENABLE_ZOOM(2103),
    PANORAMA_ENABLE_PANNING(2104),
    PANORAMA_ENABLE_NAVIGATION(2105),
    PANORAMA_ENABLE_STREET_NAMES(2106),
    PANORAMA_ANIMATE_TO(2107),
    PANORAMA_SET_POSITION_WITH_ID(2108),
    PANORAMA_SET_POSITION(2109),
    PANORAMA_SET_POSITION_WITH_RADIUS(2110),
    PANORAMA_SET_CHANGE_LISTENER(2111),
    PANORAMA_SET_CAMERA_CHANGE_LISTENER(2112),
    PANORAMA_SET_CLICK_LISTENER(2113),
    PANORAMA_PROJECT_TO_ORIENTATION(2114),
    PANORAMA_PROJECT_TO_POINT(2115),
    PANORAMA_SET_ON_PANORAMA_READY_CALLBACK(2116),
    PANORAMA_SET_LONG_CLICK_LISTENER(2117),
    PANORAMA_SET_POSITION_WITH_SOURCE_DEFAULT(2118),
    PANORAMA_SET_POSITION_WITH_RADIUS_AND_SOURCE_DEFAULT(2119),
    PANORAMA_SET_POSITION_WITH_SOURCE_OUTDOOR(2120),
    PANORAMA_SET_POSITION_WITH_RADIUS_AND_SOURCE_OUTDOOR(2121),
    MAP_SET_VISIBLE_REGION(2200),
    MAP_SET_OAUTH_TOKEN_PROVIDER(2300),
    INTENT_VIEW_NO_MARKERS(2400),
    INTENT_VIEW_ONE_MARKER(2401),
    INTENT_VIEW_MULTIPLE_MARKERS_ONE_SELECTED(2402),
    INTENT_VIEW_MULTIPLE_MARKERS_NONE_SELECTED(2403),
    INTENT_DIRECTIONS(2404),
    MAP_ENABLE_AMBIENT_STYLING(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS),
    MAP_SET_STYLE(2600),
    MAP_SET_STYLE_ILLEGAL_ARGUMENT(2601),
    MAP_SET_STYLE_INVALID_STYLE(2602),
    MAP_SET_STYLE_NULL(2603),
    MAP_SET_STYLE_WITH_MAP_ID(2604),
    RENDERER_STREETVIEW_ONLY_ONE_RENDERER(2700),
    RENDERER_STREETVIEW_SERVER_INVALID(2701),
    RENDERER_STREETVIEW_SERVER_UNKNOWN(2702),
    RENDERER_STREETVIEW_SERVER_BLACKLIST(2703),
    RENDERER_STREETVIEW_SERVER_FORCE_NEW(2704),
    RENDERER_STREETVIEW_CLIENT_ATTEMPT_ROCKET(2705),
    RENDERER_STREETVIEW_CLIENT_FALLBACK_GMM6(2706),
    RENDERER_STREETVIEW_CLIENT_CHOOSE_ROCKET_ALWAYS(2707),
    RENDERER_STREETVIEW_CLIENT_SET_ROCKET_ALWAYS(2708),
    MAP_MAPID(2800),
    MAP_TIER_CHANGED(2801),
    MAP_READY_LEGENDARY(2802),
    MAP_USE_CLOUD_STYLING(2803),
    MAP_ADD_POLYLINE_GROUP(2900),
    POLYLINE_GROUP_REMOVE(2901),
    NAVIGATION_SET_DESTINATION(3000),
    NAVIGATION_START_GUIDANCE(AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN),
    NAVIGATION_STOP_GUIDANCE(AuthApiStatusCodes.AUTH_API_CLIENT_ERROR),
    NAVIGATION_SERVICE_READY(AuthApiStatusCodes.AUTH_API_SERVER_ERROR),
    NAVIGATION_REROUTE_REQUEST(AuthApiStatusCodes.AUTH_TOKEN_ERROR),
    NAVIGATION_HEARTBEAT_REQUEST(AuthApiStatusCodes.AUTH_URL_RESOLUTION),
    NAVIGATION_AUDIO_GUIDANCE_EVENT(AuthApiStatusCodes.AUTH_APP_CERT_ERROR),
    NAVIGATION_PROMPT_GUIDANCE_EVENT(3007),
    NAVIGATION_ROUTE_STATE_CHANGE_EVENT(3008),
    NAVIGATION_LIFE_CYCLE(3009),
    NAVIGATION_REALTIME_COUNTERS(3010),
    MAP_ADD_ADVANCED_MARKER(3100),
    ADVANCED_MARKER_REMOVE(3101),
    ADVANCED_MARKER_ICON_VIEW(3102),
    ADVANCED_MARKER_CUSTOMIZED_GLYPH_IMAGE(3103),
    ADVANCED_MARKER_CUSTOMIZED_GLYPH_TEXT(3104),
    ADVANCED_MARKER_CUSTOMIZED_BORDER_COLOR(3105),
    ADVANCED_MARKER_CUSTOMIZED_BACKGROUND_COLOR(3106),
    ADVANCED_MARKER_CUSTOMIZED_GLYPH_COLOR(3107),
    ADVANCED_MARKER_MARKER_ALTITUDE(3108),
    PREMIUM_QUOTA_REQUEST_FAILED(3200),
    PREMIUM_QUOTA_REQUEST_EXCEEDED(3201),
    PREMIUM_QUOTA_REQUEST_BLOCKED(3202),
    PREMIUM_QUOTA_REQUEST_OK(3203),
    QUOTA_REQUESTED(3204),
    ONE_PLATFORM_DEDUCT_QUOTA_EVENT(3300),
    DASH_CONNECTION_API_QUOTA_EVENT(3301),
    ONE_PLATFORM_NAV_SDK_DEDUCT_QUOTA_EVENT(3302),
    DASH_CONNECTION_NAV_SDK_API_QUOTA_EVENT(3304),
    ONE_PLATFORM_REVERSE_GEOCODE_EVENT(3400),
    DASH_CONNECTION_REVERSE_GEOCODE_EVENT(3401),
    APOPHIS_CHAOS_TESTING_NAV_SDK(3500),
    MAP_CAPABILITIES_CHANGED(3600),
    MAP_CAPABILITIES_QUERIED(3601),
    MAP_CAPABILITIES_SUBSCRIBED(3602),
    MAP_GET_FEATURE_LAYER(3700),
    FEATURE_LAYER_SET_STYLE(3701),
    PLACE_FEATURE_ACCESS_PLACEID(3702),
    PLACE_FEATURE_DISPLAY_NAME(3703),
    FEATURE_STYLE_WITH_OPTIONS(3704),
    FEATURE_LAYER_ADD_CLICK_LISTENER(3705),
    MAP_COLD_START_WITHOUT_CACHES_TO_INITIAL_DISPLAY(3800),
    MAP_COLD_START_WITHOUT_CACHES_TO_FULL_DISPLAY(3801),
    MAP_COLD_START_WITHOUT_CACHES_TO_MAP_LOAD(3802),
    MAP_COLD_START_WITH_CACHES_TO_INITIAL_DISPLAY(3803),
    MAP_COLD_START_WITH_CACHES_TO_FULL_DISPLAY(3804),
    MAP_COLD_START_WITH_CACHES_TO_MAP_LOAD(3805),
    MAP_WARM_START_TO_INITIAL_DISPLAY(3806),
    MAP_WARM_START_TO_FULL_DISPLAY(3807),
    MAP_WARM_START_TO_MAP_LOAD(3808),
    MAP_HOT_START_TO_INITIAL_DISPLAY(3809),
    MAP_HOT_START_TO_FULL_DISPLAY(3810),
    MAP_HOT_START_TO_MAP_LOAD(3811),
    MAPS_API_TOKEN_REQUEST(4001),
    MAPS_CORE_MODULE_INSTALL(NavigationConstants.UI_HANDLER_MAP_CONTROLS),
    MAPS_CORE_MODULE_INSTALL_REQUEST(4002);

    public final int fX;

    b(int i) {
        this.fX = i;
    }

    public static b b(int i) {
        if (i != 0) {
            switch (i) {
                case 0:
                    break;
                case 200:
                    return MAP_ADD_MARKER;
                case 201:
                    return MARKER_REMOVE;
                case 202:
                    return MARKER_SET_POSITION;
                case 203:
                    return MARKER_TITLE;
                case 204:
                    return MARKER_SNIPPET;
                case 205:
                    return MARKER_ICON;
                case 206:
                    return MARKER_ANCHOR;
                case 207:
                    return MARKER_DRAGGABLE;
                case 208:
                    return MARKER_WAS_DRAGGED;
                case Mp4VideoDirectory.TAG_DEPTH /* 209 */:
                    return MARKER_VISIBILITY;
                case Mp4VideoDirectory.TAG_COMPRESSION_TYPE /* 210 */:
                    return MARKER_FLAT;
                case Mp4VideoDirectory.TAG_GRAPHICS_MODE /* 211 */:
                    return MARKER_ROTATION;
                case Mp4VideoDirectory.TAG_OPCOLOR /* 212 */:
                    return MARKER_INFO_WINDOW_ANCHOR;
                case Mp4VideoDirectory.TAG_COLOR_TABLE /* 213 */:
                    return MARKER_ALPHA;
                case Mp4VideoDirectory.TAG_FRAME_RATE /* 214 */:
                    return MARKER_SHOW_INFO_BUBBLE;
                case JfifUtil.MARKER_RST7 /* 215 */:
                    return MARKER_HIDE_INFO_BUBBLE;
                case JfifUtil.MARKER_SOI /* 216 */:
                    return MARKER_SET_INFO_CONTENTS_ADAPTER;
                case JfifUtil.MARKER_EOI /* 217 */:
                    return MARKER_INFO_WINDOW_CLICK_WITH_LISTENER;
                case JfifUtil.MARKER_SOS /* 218 */:
                    return MARKER_INFO_WINDOW_CLICK_WITHOUT_LISTENER;
                case 219:
                    return MARKER_CLICK_WITH_LISTENER;
                case 220:
                    return MARKER_CLICK_WITH_INTERRUPTING_LISTENER;
                case 221:
                    return MARKER_CLICK_WITHOUT_LISTENER;
                case 222:
                    return OBSOLETE_MARKER_SHOW_INFO_BUBBLE_CONTENTS;
                case 223:
                    return MARKER_INFO_WINDOW_LONG_CLICK_WITH_LISTENER;
                case CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY /* 224 */:
                    return MARKER_INFO_WINDOW_LONG_CLICK_WITHOUT_LISTENER;
                case JfifUtil.MARKER_APP1 /* 225 */:
                    return MARKER_INFO_WINDOW_CLOSE_WITH_LISTENER;
                case 226:
                    return MARKER_INFO_WINDOW_CLOSE_WITHOUT_LISTENER;
                case 227:
                    return MARKER_SET_TAG;
                case 228:
                    return MARKER_Z_INDEX;
                case 229:
                    return MARKER_COLLISION_BEHAVIOR;
                case 230:
                    return MARKER_COLLISION_BEHAVIOR_IOS;
                case 231:
                    return MARKER_CONTENT_DESCRIPTION;
                case 1100:
                    return MAP_CLEAR;
                case 1101:
                    return MAP_SET_MAP_TYPE;
                case 1102:
                    return MAP_SET_TRAFFIC_DISABLED;
                case 1103:
                    return MAP_SET_TRAFFIC_ENABLED;
                case 1104:
                    return MAP_SET_TRANSIT_DISABLED;
                case 1105:
                    return MAP_SET_TRANSIT_ENABLED;
                case 1106:
                    return MAP_SET_MY_LOCATION_DISABLED;
                case 1107:
                    return MAP_SET_MY_LOCATION_ENABLED;
                case 1108:
                    return MAP_SET_BUILDINGS_DISABLED;
                case 1109:
                    return MAP_SET_BUILDINGS_ENABLED;
                case 1120:
                    return MAP_SET_MAP_TYPE_NONE;
                case 1121:
                    return MAP_SET_MAP_TYPE_NORMAL;
                case 1122:
                    return MAP_SET_MAP_TYPE_SATELLITE;
                case 1123:
                    return MAP_SET_MAP_TYPE_TERRAIN;
                case 1124:
                    return MAP_SET_MAP_TYPE_HYBRID;
                case 1200:
                    return MAP_CLEAR_LOCATION_SOURCE;
                case 1201:
                    return MAP_GET_MY_LOCATION;
                case 1202:
                    return MAP_SET_LOCATION_SOURCE;
                case 1203:
                    return MAP_SET_ON_MY_LOCATION_CHANGE_LISTENER;
                case 1204:
                    return MAP_SET_ON_MY_LOCATION_BUTTON_CLICK_LISTENER;
                case 1205:
                    return MAP_SET_FOLLOW_MY_LOCATION_ENABLED;
                case 1206:
                    return MAP_SET_FOLLOW_MY_LOCATION_DISABLED;
                case 1207:
                    return MAP_SET_ON_MY_LOCATION_CLICK_LISTENER;
                case 1208:
                    return MY_LOCATION_CLICK_WITH_LISTENER;
                case 1209:
                    return MY_LOCATION_CLICK_WITHOUT_LISTENER;
                case 1300:
                    return MAP_SET_ON_BUBBLE_CLICK_LISTENER;
                case QuickTimeMetadataDirectory.TAG_LOCATION_BODY /* 1301 */:
                    return MAP_SET_ON_BUBBLE_DOUBLE_CLICK_LISTENER;
                case QuickTimeMetadataDirectory.TAG_LOCATION_NOTE /* 1302 */:
                    return MAP_SET_ON_CAMERA_CHANGE_LISTENER;
                case QuickTimeMetadataDirectory.TAG_LOCATION_ROLE /* 1303 */:
                    return MAP_SET_ON_INDOOR_LISTENER;
                case QuickTimeMetadataDirectory.TAG_LOCATION_DATE /* 1304 */:
                    return OBSOLETE_MAP_SET_ON_MAP_GESTURE_LISTENER;
                case QuickTimeMetadataDirectory.TAG_DIRECTION_FACING /* 1305 */:
                    return MAP_SET_ON_MAP_CLICK_LISTENER;
                case QuickTimeMetadataDirectory.TAG_DIRECTION_MOTION /* 1306 */:
                    return MAP_SET_ON_MAP_LONG_CLICK_LISTENER;
                case QuickTimeMetadataDirectory.TAG_DISPLAY_NAME /* 1307 */:
                    return MAP_SET_ON_MARKER_CLICK_LISTENER;
                case QuickTimeMetadataDirectory.TAG_CONTENT_IDENTIFIER /* 1308 */:
                    return MAP_SET_ON_MARKER_DRAG_LISTENER;
                case QuickTimeMetadataDirectory.TAG_MAKE /* 1309 */:
                    return MAP_SET_ON_MAP_IDLE_LISTENER;
                case QuickTimeMetadataDirectory.TAG_MODEL /* 1310 */:
                    return MAP_SET_ON_GROUND_OVERLAY_CLICK_LISTENER;
                case QuickTimeMetadataDirectory.TAG_ORIGINATING_SIGNATURE /* 1311 */:
                    return MAP_SET_ON_BUBBLE_LONG_CLICK_LISTENER;
                case 1312:
                    return MAP_SET_ON_BUBBLE_CLOSE_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeSaturation /* 1313 */:
                    return MAP_SET_ON_POLYGON_CLICK_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue /* 1314 */:
                    return MAP_SET_ON_POLYLINE_CLICK_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeContrast /* 1315 */:
                    return MAP_SET_ON_CIRCLE_CLICK_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeSharpness /* 1316 */:
                    return MAP_SET_ON_CAMERA_IDLE_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeBWFilter /* 1317 */:
                    return MAP_SET_ON_CAMERA_MOVE_CANCELED_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeTone /* 1318 */:
                    return MAP_SET_ON_CAMERA_MOVE_LISTENER;
                case OlympusCameraSettingsMakernoteDirectory.TagNoiseFilter /* 1319 */:
                    return MAP_SET_ON_CAMERA_MOVE_STARTED_LISTENER;
                case 1400:
                    return COMPASS_BUTTON_CLICK;
                case 1401:
                    return MAP_DISABLE_COMPASS;
                case 1402:
                    return MAP_DISABLE_MY_LOCATION_BUTTON;
                case 1403:
                    return MAP_DISABLE_ZOOM_CONTROLS;
                case 1404:
                    return MAP_ENABLE_COMPASS;
                case 1405:
                    return MAP_ENABLE_MY_LOCATION_BUTTON;
                case 1406:
                    return MAP_ENABLE_ZOOM_CONTROLS;
                case 1407:
                    return MY_LOCATION_BUTTON_CLICK;
                case 1408:
                    return GOOGLE_LOGO_CLICK;
                case 1409:
                    return ZOOM_IN_BUTTON_CLICK;
                case 1410:
                    return ZOOM_OUT_BUTTON_CLICK;
                case 1411:
                    return MAP_ENABLE_SCROLL;
                case 1412:
                    return MAP_DISABLE_SCROLL;
                case 1413:
                    return MAP_ENABLE_ZOOM;
                case 1414:
                    return MAP_DISABLE_ZOOM;
                case 1415:
                    return MAP_ENABLE_ROTATE;
                case 1416:
                    return MAP_DISABLE_ROTATE;
                case 1417:
                    return MAP_ENABLE_TILT;
                case 1418:
                    return MAP_DISABLE_TILT;
                case 1419:
                    return MAP_ENABLE_ALL_GESTURES;
                case 1420:
                    return MAP_DISABLE_ALL_GESTURES;
                case 1421:
                    return MAP_ENABLE_MAP_TOOLBAR;
                case 1422:
                    return MAP_DISABLE_MAP_TOOLBAR;
                case 1423:
                    return MAP_ENABLE_SCROLL_DURING_ROTATE_OR_ZOOM;
                case 1424:
                    return MAP_DISABLE_SCROLL_DURING_ROTATE_OR_ZOOM;
                case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 1500 */:
                    return MAP_SET_INFO_WINDOW;
                case 1600:
                    return MAP_GET_PROJECTION;
                case 1601:
                    return PROJECTION_FROM_SCREEN_LOCATION;
                case 1602:
                    return PROJECTION_GET_FRUSTUM;
                case 1603:
                    return PROJECTION_TO_SCREEN_LOCATION;
                case 1604:
                    return PROJECTION_TO_SCREEN_LOCATION_WITH_ALTITUDE;
                case 1700:
                    return KEYBOARD_UP;
                case 1701:
                    return KEYBOARD_DOWN;
                case 1702:
                    return KEYBOARD_LEFT;
                case 1703:
                    return KEYBOARD_RIGHT;
                case 1800:
                    return MAP_ENABLE_INDOOR;
                case 1801:
                    return MAP_DISABLE_INDOOR;
                case 1802:
                    return MAP_ENABLE_INDOOR_LEVEL_PICKER;
                case 1803:
                    return MAP_DISABLE_INDOOR_LEVEL_PICKER;
                case 1804:
                    return INDOOR_ACTIVATE_LEVEL;
                case 1805:
                    return INDOOR_GET_ACTIVE_LEVEL;
                case 1806:
                    return INDOOR_GET_FOCUSED_BUILDING;
                case 1807:
                    return INDOOR_GET_LEVELS;
                case 1808:
                    return INDOOR_GET_VISIBLE_BUILDINGS;
                case 1809:
                    return INDOOR_GET_DEFAULT_LEVEL;
                case 1810:
                    return INDOOR_IS_UNDERGROUND;
                case 1900:
                    return MAP_REQUEST_TILE_PREFETCH_AREA;
                case 1901:
                    return MAP_SET_EXTERNAL_CACHE;
                case 1902:
                    return MAP_CLEAR_EXTERNAL_CACHE;
                case 1903:
                    return MAP_SET_NETWORK_ENABLED;
                case 1904:
                    return MAP_SET_NETWORK_DISABLED;
                case Constants.MAX_URL_LENGTH /* 2000 */:
                    return MAP_SNAPSHOT;
                case 2001:
                    return MAP_SNAPSHOT_ALLOCATED_BITMAP;
                case 2100:
                    return PANORAMA_CREATED;
                case 2101:
                    return PANORAMA_ADD_MARKER;
                case 2102:
                    return PANORAMA_REMOVE_MARKER;
                case 2103:
                    return PANORAMA_ENABLE_ZOOM;
                case 2104:
                    return PANORAMA_ENABLE_PANNING;
                case 2105:
                    return PANORAMA_ENABLE_NAVIGATION;
                case 2106:
                    return PANORAMA_ENABLE_STREET_NAMES;
                case 2107:
                    return PANORAMA_ANIMATE_TO;
                case 2108:
                    return PANORAMA_SET_POSITION_WITH_ID;
                case 2109:
                    return PANORAMA_SET_POSITION;
                case 2110:
                    return PANORAMA_SET_POSITION_WITH_RADIUS;
                case 2111:
                    return PANORAMA_SET_CHANGE_LISTENER;
                case 2112:
                    return PANORAMA_SET_CAMERA_CHANGE_LISTENER;
                case 2113:
                    return PANORAMA_SET_CLICK_LISTENER;
                case 2114:
                    return PANORAMA_PROJECT_TO_ORIENTATION;
                case 2115:
                    return PANORAMA_PROJECT_TO_POINT;
                case 2116:
                    return PANORAMA_SET_ON_PANORAMA_READY_CALLBACK;
                case 2117:
                    return PANORAMA_SET_LONG_CLICK_LISTENER;
                case 2118:
                    return PANORAMA_SET_POSITION_WITH_SOURCE_DEFAULT;
                case 2119:
                    return PANORAMA_SET_POSITION_WITH_RADIUS_AND_SOURCE_DEFAULT;
                case 2120:
                    return PANORAMA_SET_POSITION_WITH_SOURCE_OUTDOOR;
                case 2121:
                    return PANORAMA_SET_POSITION_WITH_RADIUS_AND_SOURCE_OUTDOOR;
                case 2200:
                    return MAP_SET_VISIBLE_REGION;
                case 2300:
                    return MAP_SET_OAUTH_TOKEN_PROVIDER;
                case 2400:
                    return INTENT_VIEW_NO_MARKERS;
                case 2401:
                    return INTENT_VIEW_ONE_MARKER;
                case 2402:
                    return INTENT_VIEW_MULTIPLE_MARKERS_ONE_SELECTED;
                case 2403:
                    return INTENT_VIEW_MULTIPLE_MARKERS_NONE_SELECTED;
                case 2404:
                    return INTENT_DIRECTIONS;
                case DefaultRetryPolicy.DEFAULT_TIMEOUT_MS /* 2500 */:
                    return MAP_ENABLE_AMBIENT_STYLING;
                case 2600:
                    return MAP_SET_STYLE;
                case 2601:
                    return MAP_SET_STYLE_ILLEGAL_ARGUMENT;
                case 2602:
                    return MAP_SET_STYLE_INVALID_STYLE;
                case 2603:
                    return MAP_SET_STYLE_NULL;
                case 2604:
                    return MAP_SET_STYLE_WITH_MAP_ID;
                case 2700:
                    return RENDERER_STREETVIEW_ONLY_ONE_RENDERER;
                case 2701:
                    return RENDERER_STREETVIEW_SERVER_INVALID;
                case 2702:
                    return RENDERER_STREETVIEW_SERVER_UNKNOWN;
                case 2703:
                    return RENDERER_STREETVIEW_SERVER_BLACKLIST;
                case 2704:
                    return RENDERER_STREETVIEW_SERVER_FORCE_NEW;
                case 2705:
                    return RENDERER_STREETVIEW_CLIENT_ATTEMPT_ROCKET;
                case 2706:
                    return RENDERER_STREETVIEW_CLIENT_FALLBACK_GMM6;
                case 2707:
                    return RENDERER_STREETVIEW_CLIENT_CHOOSE_ROCKET_ALWAYS;
                case 2708:
                    return RENDERER_STREETVIEW_CLIENT_SET_ROCKET_ALWAYS;
                case 2800:
                    return MAP_MAPID;
                case 2801:
                    return MAP_TIER_CHANGED;
                case 2802:
                    return MAP_READY_LEGENDARY;
                case 2803:
                    return MAP_USE_CLOUD_STYLING;
                case 2900:
                    return MAP_ADD_POLYLINE_GROUP;
                case 2901:
                    return POLYLINE_GROUP_REMOVE;
                case 3000:
                    return NAVIGATION_SET_DESTINATION;
                case AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN /* 3001 */:
                    return NAVIGATION_START_GUIDANCE;
                case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR /* 3002 */:
                    return NAVIGATION_STOP_GUIDANCE;
                case AuthApiStatusCodes.AUTH_API_SERVER_ERROR /* 3003 */:
                    return NAVIGATION_SERVICE_READY;
                case AuthApiStatusCodes.AUTH_TOKEN_ERROR /* 3004 */:
                    return NAVIGATION_REROUTE_REQUEST;
                case AuthApiStatusCodes.AUTH_URL_RESOLUTION /* 3005 */:
                    return NAVIGATION_HEARTBEAT_REQUEST;
                case AuthApiStatusCodes.AUTH_APP_CERT_ERROR /* 3006 */:
                    return NAVIGATION_AUDIO_GUIDANCE_EVENT;
                case 3007:
                    return NAVIGATION_PROMPT_GUIDANCE_EVENT;
                case 3008:
                    return NAVIGATION_ROUTE_STATE_CHANGE_EVENT;
                case 3009:
                    return NAVIGATION_LIFE_CYCLE;
                case 3010:
                    return NAVIGATION_REALTIME_COUNTERS;
                case 3100:
                    return MAP_ADD_ADVANCED_MARKER;
                case 3101:
                    return ADVANCED_MARKER_REMOVE;
                case 3102:
                    return ADVANCED_MARKER_ICON_VIEW;
                case 3103:
                    return ADVANCED_MARKER_CUSTOMIZED_GLYPH_IMAGE;
                case 3104:
                    return ADVANCED_MARKER_CUSTOMIZED_GLYPH_TEXT;
                case 3105:
                    return ADVANCED_MARKER_CUSTOMIZED_BORDER_COLOR;
                case 3106:
                    return ADVANCED_MARKER_CUSTOMIZED_BACKGROUND_COLOR;
                case 3107:
                    return ADVANCED_MARKER_CUSTOMIZED_GLYPH_COLOR;
                case 3108:
                    return ADVANCED_MARKER_MARKER_ALTITUDE;
                case 3200:
                    return PREMIUM_QUOTA_REQUEST_FAILED;
                case 3201:
                    return PREMIUM_QUOTA_REQUEST_EXCEEDED;
                case 3202:
                    return PREMIUM_QUOTA_REQUEST_BLOCKED;
                case 3203:
                    return PREMIUM_QUOTA_REQUEST_OK;
                case 3204:
                    return QUOTA_REQUESTED;
                case 3300:
                    return ONE_PLATFORM_DEDUCT_QUOTA_EVENT;
                case 3301:
                    return DASH_CONNECTION_API_QUOTA_EVENT;
                case 3302:
                    return ONE_PLATFORM_NAV_SDK_DEDUCT_QUOTA_EVENT;
                case 3304:
                    return DASH_CONNECTION_NAV_SDK_API_QUOTA_EVENT;
                case 3400:
                    return ONE_PLATFORM_REVERSE_GEOCODE_EVENT;
                case 3401:
                    return DASH_CONNECTION_REVERSE_GEOCODE_EVENT;
                case 3500:
                    return APOPHIS_CHAOS_TESTING_NAV_SDK;
                case 3600:
                    return MAP_CAPABILITIES_CHANGED;
                case 3601:
                    return MAP_CAPABILITIES_QUERIED;
                case 3602:
                    return MAP_CAPABILITIES_SUBSCRIBED;
                case 3700:
                    return MAP_GET_FEATURE_LAYER;
                case 3701:
                    return FEATURE_LAYER_SET_STYLE;
                case 3702:
                    return PLACE_FEATURE_ACCESS_PLACEID;
                case 3703:
                    return PLACE_FEATURE_DISPLAY_NAME;
                case 3704:
                    return FEATURE_STYLE_WITH_OPTIONS;
                case 3705:
                    return FEATURE_LAYER_ADD_CLICK_LISTENER;
                case 3800:
                    return MAP_COLD_START_WITHOUT_CACHES_TO_INITIAL_DISPLAY;
                case 3801:
                    return MAP_COLD_START_WITHOUT_CACHES_TO_FULL_DISPLAY;
                case 3802:
                    return MAP_COLD_START_WITHOUT_CACHES_TO_MAP_LOAD;
                case 3803:
                    return MAP_COLD_START_WITH_CACHES_TO_INITIAL_DISPLAY;
                case 3804:
                    return MAP_COLD_START_WITH_CACHES_TO_FULL_DISPLAY;
                case 3805:
                    return MAP_COLD_START_WITH_CACHES_TO_MAP_LOAD;
                case 3806:
                    return MAP_WARM_START_TO_INITIAL_DISPLAY;
                case 3807:
                    return MAP_WARM_START_TO_FULL_DISPLAY;
                case 3808:
                    return MAP_WARM_START_TO_MAP_LOAD;
                case 3809:
                    return MAP_HOT_START_TO_INITIAL_DISPLAY;
                case 3810:
                    return MAP_HOT_START_TO_FULL_DISPLAY;
                case 3811:
                    return MAP_HOT_START_TO_MAP_LOAD;
                case 3900:
                    return MAP_SET_BACKGROUND_COLOR_POST_INIT;
                case NavigationConstants.UI_HANDLER_MAP_CONTROLS /* 4000 */:
                    return MAPS_CORE_MODULE_INSTALL;
                case 4001:
                    return MAPS_API_TOKEN_REQUEST;
                case 4002:
                    return MAPS_CORE_MODULE_INSTALL_REQUEST;
                default:
                    switch (i) {
                        case 100:
                            return MAP_CREATED;
                        case 101:
                            return MAP_SET_ZOOM_LIMIT;
                        case 102:
                            return MAP_SET_ON_MAP_READY_CALLBACK;
                        case 103:
                            return MAP_SET_FRAMERATE;
                        case 104:
                            return MAP_READY;
                        case 105:
                            return MAP_SET_BACKGROUND_COLOR;
                        case RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN /* 106 */:
                            return MAP_TILE_LOAD;
                        case 107:
                            return MAP_LABEL_LOAD;
                        case 108:
                            return MAP_FRAMERATE_SNAPSHOT;
                        case 109:
                            return MAP_INITIALIZATION_REQUEST_DEFAULT;
                        case 110:
                            return MAP_INITIALIZATION_REQUEST_OPT_IN;
                        case PanasonicMakernoteDirectory.TAG_LANDMARK /* 111 */:
                            return MAP_INITIALIZATION_REQUEST_OPT_OUT;
                        case PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION /* 112 */:
                            return MAP_INITIALIZATION_RESULT_LATEST;
                        case 113:
                            return MAP_INITIALIZATION_RESULT_LEGACY;
                        case 114:
                            return MAP_METAL_RENDERING;
                        case 115:
                            return MAP_LIFE_CYCLE;
                        case 116:
                            return MAP_REALTIME_COUNTERS;
                        case 117:
                            return STYLED_MAP_READY;
                        case 118:
                            return MAP_SET_DARK_MODE;
                        case PanasonicMakernoteDirectory.TAG_BURST_SPEED /* 119 */:
                            return MAP_FALLBACK_LITE_MODE;
                        default:
                            switch (i) {
                                case 300:
                                    return MAP_ADD_POLYLINE;
                                case 301:
                                    return POLYLINE_REMOVE;
                                case 302:
                                    return POLYLINE_SET_POINTS;
                                case 303:
                                    return POLYLINE_WIDTH;
                                case 304:
                                    return POLYLINE_COLOR;
                                case 305:
                                    return POLYLINE_Z_INDEX;
                                case 306:
                                    return POLYLINE_VISIBILITY;
                                case 307:
                                    return POLYLINE_GEODESIC;
                                case 308:
                                    return POLYLINE_TEXTURE;
                                case 309:
                                    return POLYLINE_SPANS;
                                case 310:
                                    return POLYLINE_SPANS_GRADIENT;
                                case 311:
                                    return POLYLINE_SPANS_FRACTIONAL;
                                case 312:
                                    return POLYLINE_CLICK_WITH_LISTENER;
                                case 313:
                                    return POLYLINE_CLICK_WITHOUT_LISTENER;
                                case 314:
                                    return POLYLINE_CLICKABILITY;
                                case 315:
                                    return POLYLINE_START_CAP;
                                case 316:
                                    return POLYLINE_END_CAP;
                                case 317:
                                    return POLYLINE_JOINT_TYPE;
                                case 318:
                                    return POLYLINE_PATTERN;
                                case ExifDirectoryBase.TAG_PRIMARY_CHROMATICITIES /* 319 */:
                                    return POLYLINE_SET_TAG;
                                case AviDirectory.TAG_DATETIME_ORIGINAL /* 320 */:
                                    return POLYLINE_RESET_POINTS;
                                case 321:
                                    return POLYLINE_SPANS_CHANGED;
                                case ExifDirectoryBase.TAG_TILE_WIDTH /* 322 */:
                                    return POLYLINE_SPANS_COUNT_CHANGED;
                                case ExifDirectoryBase.TAG_TILE_LENGTH /* 323 */:
                                    return POLYLINE_SPANS_SEGMENTS_CHANGED;
                                case ExifDirectoryBase.TAG_TILE_OFFSETS /* 324 */:
                                    return POLYLINE_SPANS_COLOR_CHANGED;
                                case ExifDirectoryBase.TAG_TILE_BYTE_COUNTS /* 325 */:
                                    return POLYLINE_SPANS_STAMP;
                                case IptcDirectory.TAG_DATE_SENT /* 326 */:
                                    return POLYLINE_SPRITE;
                                default:
                                    switch (i) {
                                        case 400:
                                            return MAP_ADD_POLYGON;
                                        case TypedValues.CycleType.TYPE_CURVE_FIT /* 401 */:
                                            return POLYGON_REMOVE;
                                        case TypedValues.CycleType.TYPE_VISIBILITY /* 402 */:
                                            return POLYGON_SET_POINTS;
                                        case TypedValues.CycleType.TYPE_ALPHA /* 403 */:
                                            return POLYGON_HOLES;
                                        case 404:
                                            return POLYGON_WIDTH;
                                        case 405:
                                            return POLYGON_STROKE_COLOR;
                                        case 406:
                                            return POLYGON_FILL_COLOR;
                                        case 407:
                                            return POLYGON_Z_INDEX;
                                        case 408:
                                            return POLYGON_VISIBILITY;
                                        case 409:
                                            return POLYGON_GEODESIC;
                                        case 410:
                                            return POLYGON_CLICK_WITH_LISTENER;
                                        case 411:
                                            return POLYGON_CLICK_WITHOUT_LISTENER;
                                        case 412:
                                            return POLYGON_CLICKABILITY;
                                        case 413:
                                            return POLYGON_STROKE_JOINT_TYPE;
                                        case 414:
                                            return POLYGON_STROKE_PATTERN;
                                        case 415:
                                            return POLYGON_SET_TAG;
                                        default:
                                            switch (i) {
                                                case 500:
                                                    return MAP_ADD_CIRCLE;
                                                case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
                                                    return CIRCLE_REMOVE;
                                                case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                                                    return CIRCLE_SET_CENTER;
                                                case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                                                    return CIRCLE_SET_RADIUS;
                                                case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                                                    return CIRCLE_WIDTH;
                                                case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                                                    return CIRCLE_STROKE_COLOR;
                                                case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
                                                    return CIRCLE_FILL_COLOR;
                                                case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                                                    return CIRCLE_Z_INDEX;
                                                case TypedValues.PositionType.TYPE_CURVE_FIT /* 508 */:
                                                    return CIRCLE_VISIBILITY;
                                                case 509:
                                                    return CIRCLE_CLICK_WITH_LISTENER;
                                                case TypedValues.PositionType.TYPE_POSITION_TYPE /* 510 */:
                                                    return CIRCLE_CLICK_WITHOUT_LISTENER;
                                                case 511:
                                                    return CIRCLE_CLICKABILITY;
                                                case 512:
                                                    return CIRCLE_STROKE_PATTERN;
                                                case 513:
                                                    return CIRCLE_SET_TAG;
                                                default:
                                                    switch (i) {
                                                        case 600:
                                                            return MAP_ADD_GROUND_OVERLAY;
                                                        case 601:
                                                            return GROUND_OVERLAY_REMOVE;
                                                        case 602:
                                                            return GROUND_OVERLAY_BEARING;
                                                        case TypedValues.MotionType.TYPE_EASING /* 603 */:
                                                            return GROUND_OVERLAY_SET_DIMENSIONS;
                                                        case 604:
                                                            return GROUND_OVERLAY_SET_LOCATION;
                                                        case TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO /* 605 */:
                                                            return GROUND_OVERLAY_Z_INDEX;
                                                        case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO /* 606 */:
                                                            return GROUND_OVERLAY_VISIBILITY;
                                                        case 607:
                                                            return GROUND_OVERLAY_TRANSPARENCY;
                                                        case TypedValues.MotionType.TYPE_DRAW_PATH /* 608 */:
                                                            return GROUND_OVERLAY_SET_IMAGE;
                                                        case TypedValues.MotionType.TYPE_POLAR_RELATIVETO /* 609 */:
                                                            return GROUND_OVERLAY_CLICK_WITH_LISTENER;
                                                        case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                                                            return GROUND_OVERLAY_CLICK_WITHOUT_LISTENER;
                                                        case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE /* 611 */:
                                                            return GROUND_OVERLAY_CLICKABILITY;
                                                        case 612:
                                                            return GROUND_OVERLAY_SET_TAG;
                                                        default:
                                                            switch (i) {
                                                                case 700:
                                                                    return MAP_ADD_TILE_OVERLAY;
                                                                case TypedValues.TransitionType.TYPE_FROM /* 701 */:
                                                                    return TILE_OVERLAY_CLEAR_CACHE;
                                                                case TypedValues.TransitionType.TYPE_TO /* 702 */:
                                                                    return TILE_OVERLAY_REMOVE;
                                                                case 703:
                                                                    return TILE_OVERLAY_Z_INDEX;
                                                                case TypedValues.TransitionType.TYPE_AUTO_TRANSITION /* 704 */:
                                                                    return TILE_OVERLAY_VISIBILITY;
                                                                case TypedValues.TransitionType.TYPE_INTERPOLATOR /* 705 */:
                                                                    return TILE_OVERLAY_FADE;
                                                                case TypedValues.TransitionType.TYPE_STAGGERED /* 706 */:
                                                                    return TILE_OVERLAY_TRANSPARENCY;
                                                                default:
                                                                    switch (i) {
                                                                        case 800:
                                                                            return MAP_ADD_MAPS_ENGINE_OVERLAY;
                                                                        case LeicaMakernoteDirectory.TAG_COLOR_TEMPERATURE /* 801 */:
                                                                            return MAPS_ENGINE_OVERLAY_REMOVE;
                                                                        case LeicaMakernoteDirectory.TAG_WB_RED_LEVEL /* 802 */:
                                                                            return MAPS_ENGINE_OVERLAY_Z_INDEX;
                                                                        case LeicaMakernoteDirectory.TAG_WB_GREEN_LEVEL /* 803 */:
                                                                            return MAPS_ENGINE_OVERLAY_VISIBILITY;
                                                                        case LeicaMakernoteDirectory.TAG_WB_BLUE_LEVEL /* 804 */:
                                                                            return MAPS_ENGINE_OVERLAY_DEFAULT_UI;
                                                                        case 805:
                                                                            return MAPS_ENGINE_OVERLAY_CLICK_LISTENER;
                                                                        default:
                                                                            switch (i) {
                                                                                case 900:
                                                                                    return MAP_ANIMATE_CAMERA;
                                                                                case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                                                                                    return MAP_ANIMATE_CAMERA_WITH_CALLBACK;
                                                                                case TypedValues.Custom.TYPE_COLOR /* 902 */:
                                                                                    return MAP_ANIMATE_CAMERA_WITH_CALLBACK_AND_CUSTOM_DURATION;
                                                                                case TypedValues.Custom.TYPE_STRING /* 903 */:
                                                                                    return MAP_MOVE_CAMERA;
                                                                                case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                                                                                    return MAP_STOP_ANIMATION;
                                                                                default:
                                                                                    switch (i) {
                                                                                        case 1000:
                                                                                            return CAMERA_UPDATE_ZOOM_IN;
                                                                                        case 1001:
                                                                                            return CAMERA_UPDATE_ZOOM_OUT;
                                                                                        case 1002:
                                                                                            return CAMERA_UPDATE_SCROLL_BY;
                                                                                        case 1003:
                                                                                            return CAMERA_UPDATE_ZOOM_TO;
                                                                                        case 1004:
                                                                                            return CAMERA_UPDATE_ZOOM_BY;
                                                                                        case 1005:
                                                                                            return CAMERA_UPDATE_ZOOM_BY_FIXING;
                                                                                        case 1006:
                                                                                            return CAMERA_UPDATE_NEW_CAMERA_POSITION;
                                                                                        case 1007:
                                                                                            return CAMERA_UPDATE_NEW_LATLNG;
                                                                                        case 1008:
                                                                                            return CAMERA_UPDATE_NEW_LATLNG_ZOOM;
                                                                                        case 1009:
                                                                                            return CAMERA_UPDATE_NEW_LATLNG_BOUNDS;
                                                                                        case 1010:
                                                                                            return CAMERA_UPDATE_NEW_LATLNG_BOUNDS_WITH_DIMENSIONS;
                                                                                        case 1011:
                                                                                            return CAMERA_ZOOM_DEVELOPER_MINIMUM;
                                                                                        case 1012:
                                                                                            return CAMERA_ZOOM_DEVELOPER_MAXIMUM;
                                                                                        case 1013:
                                                                                            return CAMERA_ZOOM_DEVELOPER_RESET;
                                                                                        case 1014:
                                                                                            return CAMERA_LAT_LNG_DEVELOPER_CLAMP;
                                                                                        default:
                                                                                            return null;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return UNKNOWN_EVENT;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.fX;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.fX);
    }
}
