package com.mappls.sdk.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.res.ResourcesCompat;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.utils.FontUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsMapOptions implements Parcelable {
    public static final Parcelable.Creator<MapplsMapOptions> CREATOR = new Parcelable.Creator<MapplsMapOptions>() { // from class: com.mappls.sdk.maps.MapplsMapOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapplsMapOptions createFromParcel(Parcel parcel) {
            return new MapplsMapOptions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapplsMapOptions[] newArray(int i) {
            return new MapplsMapOptions[i];
        }
    };
    private static final float EIGHT_DP = 8.0f;
    private static final float FOUR_DP = 4.0f;
    private static final float HUNDRED_TWELVE_DP = 112.0f;
    private static final int LIGHT_GRAY = -988703;
    private static final float NINETY_TWO_DP = 92.0f;
    private static final int UNDEFINED_COLOR = -1;
    private String apiBaseUri;
    private boolean attributionEnabled;
    private int attributionGravity;
    private int[] attributionMargins;
    private CameraPosition cameraPosition;
    private boolean compassEnabled;
    private int compassGravity;
    private Drawable compassImage;
    private int[] compassMargins;
    private boolean crossSourceCollisions;
    private boolean debugActive;
    private boolean doubleTapGesturesEnabled;
    private int eventGravity;
    private int[] eventMargins;
    private boolean fadeCompassFacingNorth;
    private int foregroundLoadColor;
    private boolean horizontalScrollGesturesEnabled;
    private boolean layerControlEnabled;
    private int layerControlGravity;
    private int[] layerControlMargins;
    private String[] localIdeographFontFamilies;
    private String localIdeographFontFamily;
    private boolean localIdeographFontFamilyEnabled;
    private boolean logoEnabled;
    private int logoGravity;
    private int[] logoMargins;
    private int logoSize;
    private double maxPitch;
    private double maxZoom;
    private double minPitch;
    private double minZoom;
    private float pixelRatio;
    private int prefetchZoomDelta;
    private boolean prefetchesTiles;
    private boolean quickZoomGesturesEnabled;
    private boolean rotateGesturesEnabled;
    private boolean scrollGesturesEnabled;
    private boolean textureMode;
    private boolean tiltGesturesEnabled;
    private boolean translucentTextureSurface;
    private boolean zMediaOverlay;
    private boolean zoomGesturesEnabled;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public MapplsMapOptions() {
        this.compassEnabled = true;
        this.fadeCompassFacingNorth = true;
        this.compassGravity = 8388661;
        this.logoEnabled = true;
        this.logoGravity = 8388691;
        this.logoSize = 0;
        this.eventGravity = 8388659;
        this.layerControlEnabled = true;
        this.layerControlGravity = 8388691;
        this.attributionEnabled = true;
        this.attributionGravity = 8388691;
        this.minZoom = 1.0d;
        this.maxZoom = 22.0d;
        this.minPitch = 0.0d;
        this.maxPitch = 60.0d;
        this.rotateGesturesEnabled = true;
        this.scrollGesturesEnabled = true;
        this.horizontalScrollGesturesEnabled = true;
        this.tiltGesturesEnabled = true;
        this.zoomGesturesEnabled = true;
        this.doubleTapGesturesEnabled = true;
        this.quickZoomGesturesEnabled = true;
        this.prefetchesTiles = true;
        this.prefetchZoomDelta = 4;
        this.zMediaOverlay = false;
        this.localIdeographFontFamilyEnabled = true;
        this.crossSourceCollisions = true;
    }

    private MapplsMapOptions(Parcel parcel) {
        this.compassEnabled = true;
        this.fadeCompassFacingNorth = true;
        this.compassGravity = 8388661;
        this.logoEnabled = true;
        this.logoGravity = 8388691;
        this.logoSize = 0;
        this.eventGravity = 8388659;
        this.layerControlEnabled = true;
        this.layerControlGravity = 8388691;
        this.attributionEnabled = true;
        this.attributionGravity = 8388691;
        this.minZoom = 1.0d;
        this.maxZoom = 22.0d;
        this.minPitch = 0.0d;
        this.maxPitch = 60.0d;
        this.rotateGesturesEnabled = true;
        this.scrollGesturesEnabled = true;
        this.horizontalScrollGesturesEnabled = true;
        this.tiltGesturesEnabled = true;
        this.zoomGesturesEnabled = true;
        this.doubleTapGesturesEnabled = true;
        this.quickZoomGesturesEnabled = true;
        this.prefetchesTiles = true;
        this.prefetchZoomDelta = 4;
        this.zMediaOverlay = false;
        this.localIdeographFontFamilyEnabled = true;
        this.crossSourceCollisions = true;
        this.cameraPosition = (CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader());
        this.debugActive = parcel.readByte() != 0;
        this.compassEnabled = parcel.readByte() != 0;
        this.compassGravity = parcel.readInt();
        this.compassMargins = parcel.createIntArray();
        this.fadeCompassFacingNorth = parcel.readByte() != 0;
        Bitmap bitmap = (Bitmap) parcel.readParcelable(getClass().getClassLoader());
        if (bitmap != null) {
            this.compassImage = new BitmapDrawable(bitmap);
        }
        this.logoEnabled = parcel.readByte() != 0;
        this.logoGravity = parcel.readInt();
        this.logoMargins = parcel.createIntArray();
        this.logoSize = parcel.readInt();
        this.eventGravity = parcel.readInt();
        this.eventMargins = parcel.createIntArray();
        this.layerControlEnabled = parcel.readByte() != 0;
        this.layerControlGravity = parcel.readInt();
        this.layerControlMargins = parcel.createIntArray();
        this.attributionEnabled = parcel.readByte() != 0;
        this.attributionGravity = parcel.readInt();
        this.attributionMargins = parcel.createIntArray();
        this.minZoom = parcel.readDouble();
        this.maxZoom = parcel.readDouble();
        this.minPitch = parcel.readDouble();
        this.maxPitch = parcel.readDouble();
        this.rotateGesturesEnabled = parcel.readByte() != 0;
        this.scrollGesturesEnabled = parcel.readByte() != 0;
        this.horizontalScrollGesturesEnabled = parcel.readByte() != 0;
        this.tiltGesturesEnabled = parcel.readByte() != 0;
        this.zoomGesturesEnabled = parcel.readByte() != 0;
        this.doubleTapGesturesEnabled = parcel.readByte() != 0;
        this.quickZoomGesturesEnabled = parcel.readByte() != 0;
        this.apiBaseUri = parcel.readString();
        this.textureMode = parcel.readByte() != 0;
        this.translucentTextureSurface = parcel.readByte() != 0;
        this.prefetchesTiles = parcel.readByte() != 0;
        this.prefetchZoomDelta = parcel.readInt();
        this.zMediaOverlay = parcel.readByte() != 0;
        this.localIdeographFontFamilyEnabled = parcel.readByte() != 0;
        this.localIdeographFontFamily = parcel.readString();
        this.localIdeographFontFamilies = parcel.createStringArray();
        this.pixelRatio = parcel.readFloat();
        this.foregroundLoadColor = parcel.readInt();
        this.crossSourceCollisions = parcel.readByte() != 0;
    }

    public static MapplsMapOptions createFromAttributes(Context context) {
        return createFromAttributes(context, null);
    }

    public static MapplsMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        return createFromAttributes(new MapplsMapOptions(), context, context.obtainStyledAttributes(attributeSet, R.styleable.mappls_maps_MapView, 0, 0));
    }

    static MapplsMapOptions createFromAttributes(MapplsMapOptions mapplsMapOptions, Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        try {
            mapplsMapOptions.camera(new CameraPosition.Builder(typedArray).build());
            mapplsMapOptions.apiBaseUrl(typedArray.getString(R.styleable.mappls_maps_MapView_mappls_maps_apiBaseUrl));
            String string = typedArray.getString(R.styleable.mappls_maps_MapView_mappls_maps_apiBaseUri);
            if (!TextUtils.isEmpty(string)) {
                mapplsMapOptions.apiBaseUri(string);
            }
            mapplsMapOptions.zoomGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiZoomGestures, true));
            mapplsMapOptions.scrollGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiScrollGestures, true));
            mapplsMapOptions.horizontalScrollGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiHorizontalScrollGestures, true));
            mapplsMapOptions.rotateGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiRotateGestures, true));
            mapplsMapOptions.tiltGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiTiltGestures, true));
            mapplsMapOptions.doubleTapGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiDoubleTapGestures, true));
            mapplsMapOptions.quickZoomGesturesEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiQuickZoomGestures, true));
            mapplsMapOptions.maxZoomPreference(typedArray.getFloat(R.styleable.mappls_maps_MapView_mappls_maps_cameraZoomMax, 22.0f));
            mapplsMapOptions.minZoomPreference(typedArray.getFloat(R.styleable.mappls_maps_MapView_mappls_maps_cameraZoomMin, 1.0f));
            mapplsMapOptions.maxPitchPreference(typedArray.getFloat(R.styleable.mappls_maps_MapView_mappls_maps_cameraPitchMax, 60.0f));
            mapplsMapOptions.minPitchPreference(typedArray.getFloat(R.styleable.mappls_maps_MapView_mappls_maps_cameraPitchMin, 0.0f));
            mapplsMapOptions.compassEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiCompass, true));
            mapplsMapOptions.compassGravity(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_uiCompassGravity, 8388661));
            int i = R.styleable.mappls_maps_MapView_mappls_maps_uiCompassMarginLeft;
            float f2 = FOUR_DP * f;
            mapplsMapOptions.compassMargins(new int[]{(int) typedArray.getDimension(i, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiCompassMarginTop, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiCompassMarginRight, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiCompassMarginBottom, f2)});
            mapplsMapOptions.compassFadesWhenFacingNorth(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiCompassFadeFacingNorth, true));
            Drawable drawable = typedArray.getDrawable(R.styleable.mappls_maps_MapView_mappls_maps_uiCompassDrawable);
            if (drawable == null) {
                drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.mappls_maps_compass_icon, null);
            }
            mapplsMapOptions.compassImage(drawable);
            mapplsMapOptions.logoEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiLogo, true));
            mapplsMapOptions.logoGravity(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_uiLogoGravity, 8388691));
            mapplsMapOptions.logoMargins(new int[]{(int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLogoMarginLeft, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLogoMarginTop, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLogoMarginRight, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLogoMarginBottom, f2)});
            mapplsMapOptions.logoSize(typedArray.getInteger(R.styleable.mappls_maps_MapView_mappls_maps_uiLogoSize, 0));
            mapplsMapOptions.eventGravity(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_uiEventGravity, 8388659));
            mapplsMapOptions.eventMargins(new int[]{(int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiEventMarginLeft, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiEventMarginTop, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiEventMarginRight, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiEventMarginBottom, f2)});
            mapplsMapOptions.layerControlEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiLayerControl, true));
            mapplsMapOptions.layerControlGravity(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_uiLayerControlGravity, 8388691));
            mapplsMapOptions.layerControlMargins(new int[]{(int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLayerControlMarginLeft, NINETY_TWO_DP * f), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLayerControlMarginTop, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLayerControlMarginRight, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiLayerControlMarginBottom, f2)});
            mapplsMapOptions.attributionEnabled(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_uiAttribution, true));
            mapplsMapOptions.attributionGravity(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_uiAttributionGravity, 8388691));
            mapplsMapOptions.attributionMargins(new int[]{(int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiAttributionMarginLeft, HUNDRED_TWELVE_DP * f), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiAttributionMarginTop, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiAttributionMarginRight, f2), (int) typedArray.getDimension(R.styleable.mappls_maps_MapView_mappls_maps_uiAttributionMarginBottom, f * EIGHT_DP)});
            mapplsMapOptions.textureMode(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_renderTextureMode, false));
            mapplsMapOptions.translucentTextureSurface(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_renderTextureTranslucentSurface, false));
            mapplsMapOptions.setPrefetchesTiles(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_enableTilePrefetch, true));
            mapplsMapOptions.setPrefetchZoomDelta(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_prefetchZoomDelta, 4));
            mapplsMapOptions.renderSurfaceOnTop(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_enableZMediaOverlay, false));
            mapplsMapOptions.localIdeographFontFamilyEnabled = typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_localIdeographEnabled, true);
            int resourceId = typedArray.getResourceId(R.styleable.mappls_maps_MapView_mappls_maps_localIdeographFontFamilies, 0);
            if (resourceId != 0) {
                mapplsMapOptions.localIdeographFontFamily(context.getResources().getStringArray(resourceId));
            } else {
                String string2 = typedArray.getString(R.styleable.mappls_maps_MapView_mappls_maps_localIdeographFontFamily);
                if (string2 == null) {
                    string2 = MapplsConstants.DEFAULT_FONT;
                }
                mapplsMapOptions.localIdeographFontFamily(string2);
            }
            mapplsMapOptions.pixelRatio(typedArray.getFloat(R.styleable.mappls_maps_MapView_mappls_maps_pixelRatio, 0.0f));
            mapplsMapOptions.foregroundLoadColor(typedArray.getInt(R.styleable.mappls_maps_MapView_mappls_maps_foregroundLoadColor, LIGHT_GRAY));
            mapplsMapOptions.crossSourceCollisions(typedArray.getBoolean(R.styleable.mappls_maps_MapView_mappls_maps_cross_source_collisions, true));
            return mapplsMapOptions;
        } finally {
            typedArray.recycle();
        }
    }

    @Deprecated
    public MapplsMapOptions apiBaseUrl(String str) {
        this.apiBaseUri = str;
        return this;
    }

    public MapplsMapOptions apiBaseUri(String str) {
        this.apiBaseUri = str;
        return this;
    }

    public MapplsMapOptions camera(CameraPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
        return this;
    }

    public MapplsMapOptions debugActive(boolean z) {
        this.debugActive = z;
        return this;
    }

    public MapplsMapOptions minZoomPreference(double d) {
        this.minZoom = d;
        return this;
    }

    public MapplsMapOptions maxZoomPreference(double d) {
        this.maxZoom = d;
        return this;
    }

    public MapplsMapOptions minPitchPreference(double d) {
        this.minPitch = d;
        return this;
    }

    public MapplsMapOptions maxPitchPreference(double d) {
        this.maxPitch = d;
        return this;
    }

    public MapplsMapOptions compassEnabled(boolean z) {
        this.compassEnabled = z;
        return this;
    }

    public MapplsMapOptions compassGravity(int i) {
        this.compassGravity = i;
        return this;
    }

    public MapplsMapOptions compassMargins(int[] iArr) {
        this.compassMargins = iArr;
        return this;
    }

    public MapplsMapOptions compassFadesWhenFacingNorth(boolean z) {
        this.fadeCompassFacingNorth = z;
        return this;
    }

    public MapplsMapOptions compassImage(Drawable drawable) {
        this.compassImage = drawable;
        return this;
    }

    public MapplsMapOptions logoEnabled(boolean z) {
        this.logoEnabled = z;
        return this;
    }

    public MapplsMapOptions logoGravity(int i) {
        this.logoGravity = i;
        return this;
    }

    public MapplsMapOptions logoMargins(int[] iArr) {
        this.logoMargins = iArr;
        return this;
    }

    public MapplsMapOptions logoSize(int i) {
        this.logoSize = i;
        return this;
    }

    public MapplsMapOptions eventGravity(int i) {
        this.eventGravity = i;
        return this;
    }

    public MapplsMapOptions eventMargins(int[] iArr) {
        this.eventMargins = iArr;
        return this;
    }

    public MapplsMapOptions layerControlEnabled(boolean z) {
        this.layerControlEnabled = z;
        return this;
    }

    public MapplsMapOptions layerControlGravity(int i) {
        this.layerControlGravity = i;
        return this;
    }

    public MapplsMapOptions layerControlMargins(int[] iArr) {
        this.layerControlMargins = iArr;
        return this;
    }

    public MapplsMapOptions attributionEnabled(boolean z) {
        this.attributionEnabled = z;
        return this;
    }

    public MapplsMapOptions attributionGravity(int i) {
        this.attributionGravity = i;
        return this;
    }

    public MapplsMapOptions attributionMargins(int[] iArr) {
        this.attributionMargins = iArr;
        return this;
    }

    public MapplsMapOptions rotateGesturesEnabled(boolean z) {
        this.rotateGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions scrollGesturesEnabled(boolean z) {
        this.scrollGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions horizontalScrollGesturesEnabled(boolean z) {
        this.horizontalScrollGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions tiltGesturesEnabled(boolean z) {
        this.tiltGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions zoomGesturesEnabled(boolean z) {
        this.zoomGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions doubleTapGesturesEnabled(boolean z) {
        this.doubleTapGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions quickZoomGesturesEnabled(boolean z) {
        this.quickZoomGesturesEnabled = z;
        return this;
    }

    public MapplsMapOptions textureMode(boolean z) {
        this.textureMode = z;
        return this;
    }

    public MapplsMapOptions translucentTextureSurface(boolean z) {
        this.translucentTextureSurface = z;
        return this;
    }

    public MapplsMapOptions foregroundLoadColor(int i) {
        this.foregroundLoadColor = i;
        return this;
    }

    @Deprecated
    public MapplsMapOptions setPrefetchesTiles(boolean z) {
        this.prefetchesTiles = z;
        return this;
    }

    public MapplsMapOptions setPrefetchZoomDelta(int i) {
        this.prefetchZoomDelta = i;
        return this;
    }

    public MapplsMapOptions crossSourceCollisions(boolean z) {
        this.crossSourceCollisions = z;
        return this;
    }

    public MapplsMapOptions localIdeographFontFamilyEnabled(boolean z) {
        this.localIdeographFontFamilyEnabled = z;
        return this;
    }

    public MapplsMapOptions localIdeographFontFamily(String str) {
        this.localIdeographFontFamily = FontUtils.extractValidFont(str);
        return this;
    }

    public MapplsMapOptions localIdeographFontFamily(String... strArr) {
        this.localIdeographFontFamily = FontUtils.extractValidFont(strArr);
        return this;
    }

    public MapplsMapOptions pixelRatio(float f) {
        this.pixelRatio = f;
        return this;
    }

    @Deprecated
    public boolean getPrefetchesTiles() {
        return this.prefetchesTiles;
    }

    public int getPrefetchZoomDelta() {
        return this.prefetchZoomDelta;
    }

    public boolean getCrossSourceCollisions() {
        return this.crossSourceCollisions;
    }

    public void renderSurfaceOnTop(boolean z) {
        this.zMediaOverlay = z;
    }

    public boolean getRenderSurfaceOnTop() {
        return this.zMediaOverlay;
    }

    @Deprecated
    public String getApiBaseUrl() {
        return this.apiBaseUri;
    }

    public String getApiBaseUri() {
        return this.apiBaseUri;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public double getMinZoomPreference() {
        return this.minZoom;
    }

    public double getMaxZoomPreference() {
        return this.maxZoom;
    }

    public double getMinPitchPreference() {
        return this.minPitch;
    }

    public double getMaxPitchPreference() {
        return this.maxPitch;
    }

    public boolean getCompassEnabled() {
        return this.compassEnabled;
    }

    public int getCompassGravity() {
        return this.compassGravity;
    }

    public int[] getCompassMargins() {
        return this.compassMargins;
    }

    public boolean getCompassFadeFacingNorth() {
        return this.fadeCompassFacingNorth;
    }

    public Drawable getCompassImage() {
        return this.compassImage;
    }

    public boolean getLogoEnabled() {
        return this.logoEnabled;
    }

    public int getLogoGravity() {
        return this.logoGravity;
    }

    public int[] getLogoMargins() {
        return this.logoMargins;
    }

    public int getLogoSize() {
        return this.logoSize;
    }

    public int getEventGravity() {
        return this.eventGravity;
    }

    public int[] getEventMargins() {
        return this.eventMargins;
    }

    public boolean getAttributionEnabled() {
        return this.attributionEnabled;
    }

    public int getAttributionGravity() {
        return this.attributionGravity;
    }

    public int[] getAttributionMargins() {
        return this.attributionMargins;
    }

    public boolean getRotateGesturesEnabled() {
        return this.rotateGesturesEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.scrollGesturesEnabled;
    }

    public boolean getHorizontalScrollGesturesEnabled() {
        return this.horizontalScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.tiltGesturesEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.zoomGesturesEnabled;
    }

    public boolean getDoubleTapGesturesEnabled() {
        return this.doubleTapGesturesEnabled;
    }

    public boolean getQuickZoomGesturesEnabled() {
        return this.quickZoomGesturesEnabled;
    }

    public boolean getLayerControlEnabled() {
        return this.layerControlEnabled;
    }

    public int getLayerControlGravity() {
        return this.layerControlGravity;
    }

    public int[] getLayerControlMargins() {
        return this.layerControlMargins;
    }

    public boolean getDebugActive() {
        return this.debugActive;
    }

    public boolean getTextureMode() {
        return this.textureMode;
    }

    public boolean getTranslucentTextureSurface() {
        return this.translucentTextureSurface;
    }

    public int getForegroundLoadColor() {
        return this.foregroundLoadColor;
    }

    public String getLocalIdeographFontFamily() {
        if (this.localIdeographFontFamilyEnabled) {
            return this.localIdeographFontFamily;
        }
        return null;
    }

    public boolean isLocalIdeographFontFamilyEnabled() {
        return this.localIdeographFontFamilyEnabled;
    }

    public float getPixelRatio() {
        return this.pixelRatio;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.cameraPosition, i);
        parcel.writeByte(this.debugActive ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.compassEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.compassGravity);
        parcel.writeIntArray(this.compassMargins);
        parcel.writeByte(this.fadeCompassFacingNorth ? (byte) 1 : (byte) 0);
        Drawable drawable = this.compassImage;
        parcel.writeParcelable(drawable != null ? BitmapUtils.getBitmapFromDrawable(drawable) : null, i);
        parcel.writeByte(this.logoEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.logoGravity);
        parcel.writeIntArray(this.logoMargins);
        parcel.writeInt(this.logoSize);
        parcel.writeInt(this.eventGravity);
        parcel.writeIntArray(this.eventMargins);
        parcel.writeByte(this.layerControlEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.layerControlGravity);
        parcel.writeIntArray(this.layerControlMargins);
        parcel.writeByte(this.attributionEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.attributionGravity);
        parcel.writeIntArray(this.attributionMargins);
        parcel.writeDouble(this.minZoom);
        parcel.writeDouble(this.maxZoom);
        parcel.writeDouble(this.minPitch);
        parcel.writeDouble(this.maxPitch);
        parcel.writeByte(this.rotateGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.scrollGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.horizontalScrollGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.tiltGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zoomGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.doubleTapGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.quickZoomGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeString(this.apiBaseUri);
        parcel.writeByte(this.textureMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.translucentTextureSurface ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.prefetchesTiles ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.prefetchZoomDelta);
        parcel.writeByte(this.zMediaOverlay ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.localIdeographFontFamilyEnabled ? (byte) 1 : (byte) 0);
        parcel.writeString(this.localIdeographFontFamily);
        parcel.writeStringArray(this.localIdeographFontFamilies);
        parcel.writeFloat(this.pixelRatio);
        parcel.writeInt(this.foregroundLoadColor);
        parcel.writeByte(this.crossSourceCollisions ? (byte) 1 : (byte) 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MapplsMapOptions mapplsMapOptions = (MapplsMapOptions) obj;
            if (this.debugActive != mapplsMapOptions.debugActive || this.compassEnabled != mapplsMapOptions.compassEnabled || this.fadeCompassFacingNorth != mapplsMapOptions.fadeCompassFacingNorth) {
                return false;
            }
            Drawable drawable = this.compassImage;
            if (drawable == null ? mapplsMapOptions.compassImage != null : !drawable.equals(mapplsMapOptions.compassImage)) {
                return false;
            }
            if (this.compassGravity != mapplsMapOptions.compassGravity || this.logoEnabled != mapplsMapOptions.logoEnabled || this.logoGravity != mapplsMapOptions.logoGravity || this.logoSize != mapplsMapOptions.logoSize || this.layerControlEnabled != mapplsMapOptions.layerControlEnabled || this.layerControlGravity != mapplsMapOptions.layerControlGravity || this.attributionEnabled != mapplsMapOptions.attributionEnabled || this.attributionGravity != mapplsMapOptions.attributionGravity || Double.compare(mapplsMapOptions.minZoom, this.minZoom) != 0 || Double.compare(mapplsMapOptions.maxZoom, this.maxZoom) != 0 || Double.compare(mapplsMapOptions.minPitch, this.minPitch) != 0 || Double.compare(mapplsMapOptions.maxPitch, this.maxPitch) != 0 || this.rotateGesturesEnabled != mapplsMapOptions.rotateGesturesEnabled || this.scrollGesturesEnabled != mapplsMapOptions.scrollGesturesEnabled || this.horizontalScrollGesturesEnabled != mapplsMapOptions.horizontalScrollGesturesEnabled || this.tiltGesturesEnabled != mapplsMapOptions.tiltGesturesEnabled || this.zoomGesturesEnabled != mapplsMapOptions.zoomGesturesEnabled || this.doubleTapGesturesEnabled != mapplsMapOptions.doubleTapGesturesEnabled || this.quickZoomGesturesEnabled != mapplsMapOptions.quickZoomGesturesEnabled) {
                return false;
            }
            CameraPosition cameraPosition = this.cameraPosition;
            if (cameraPosition == null ? mapplsMapOptions.cameraPosition != null : !cameraPosition.equals(mapplsMapOptions.cameraPosition)) {
                return false;
            }
            if (!Arrays.equals(this.compassMargins, mapplsMapOptions.compassMargins) || !Arrays.equals(this.logoMargins, mapplsMapOptions.logoMargins) || !Arrays.equals(this.layerControlMargins, mapplsMapOptions.layerControlMargins) || !Arrays.equals(this.attributionMargins, mapplsMapOptions.attributionMargins)) {
                return false;
            }
            String str = this.apiBaseUri;
            if (str == null ? mapplsMapOptions.apiBaseUri != null : !str.equals(mapplsMapOptions.apiBaseUri)) {
                return false;
            }
            if (this.prefetchesTiles != mapplsMapOptions.prefetchesTiles || this.prefetchZoomDelta != mapplsMapOptions.prefetchZoomDelta || this.zMediaOverlay != mapplsMapOptions.zMediaOverlay || this.localIdeographFontFamilyEnabled != mapplsMapOptions.localIdeographFontFamilyEnabled || !this.localIdeographFontFamily.equals(mapplsMapOptions.localIdeographFontFamily) || !Arrays.equals(this.localIdeographFontFamilies, mapplsMapOptions.localIdeographFontFamilies) || this.pixelRatio != mapplsMapOptions.pixelRatio) {
                return false;
            }
            boolean z = mapplsMapOptions.crossSourceCollisions;
        }
        return false;
    }

    public int hashCode() {
        CameraPosition cameraPosition = this.cameraPosition;
        int iHashCode = (((((((((cameraPosition != null ? cameraPosition.hashCode() : 0) * 31) + (this.debugActive ? 1 : 0)) * 31) + (this.compassEnabled ? 1 : 0)) * 31) + (this.fadeCompassFacingNorth ? 1 : 0)) * 31) + this.compassGravity) * 31;
        Drawable drawable = this.compassImage;
        int iHashCode2 = ((((((((((((((((((((((iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31) + Arrays.hashCode(this.compassMargins)) * 31) + (this.logoEnabled ? 1 : 0)) * 31) + this.logoGravity) * 31) + Arrays.hashCode(this.logoMargins)) * 31) + this.logoSize) * 31) + (this.layerControlEnabled ? 1 : 0)) * 31) + this.layerControlGravity) * 31) + Arrays.hashCode(this.layerControlMargins)) * 31) + (this.attributionEnabled ? 1 : 0)) * 31) + this.attributionGravity) * 31) + Arrays.hashCode(this.attributionMargins);
        long jDoubleToLongBits = Double.doubleToLongBits(this.minZoom);
        int i = (iHashCode2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.maxZoom);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.minPitch);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.maxPitch);
        int i4 = ((((((((((((((((i3 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)))) * 31) + (this.rotateGesturesEnabled ? 1 : 0)) * 31) + (this.scrollGesturesEnabled ? 1 : 0)) * 31) + (this.horizontalScrollGesturesEnabled ? 1 : 0)) * 31) + (this.tiltGesturesEnabled ? 1 : 0)) * 31) + (this.zoomGesturesEnabled ? 1 : 0)) * 31) + (this.doubleTapGesturesEnabled ? 1 : 0)) * 31) + (this.quickZoomGesturesEnabled ? 1 : 0)) * 31;
        String str = this.apiBaseUri;
        int iHashCode3 = (((((((((((((i4 + (str != null ? str.hashCode() : 0)) * 31) + (this.textureMode ? 1 : 0)) * 31) + (this.translucentTextureSurface ? 1 : 0)) * 31) + (this.prefetchesTiles ? 1 : 0)) * 31) + this.prefetchZoomDelta) * 31) + (this.zMediaOverlay ? 1 : 0)) * 31) + (this.localIdeographFontFamilyEnabled ? 1 : 0)) * 31;
        String str2 = this.localIdeographFontFamily;
        return ((((((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.localIdeographFontFamilies)) * 31) + ((int) this.pixelRatio)) * 31) + (this.crossSourceCollisions ? 1 : 0);
    }
}
