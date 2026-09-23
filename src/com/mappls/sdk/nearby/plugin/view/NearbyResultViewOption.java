package com.mappls.sdk.nearby.plugin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.mappls.sdk.nearby.plugin.R;
import com.mappls.sdk.nearby.plugin.model.NearbyUIOption;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NearbyResultViewOption implements Parcelable {

    public static abstract class Builder {
        public abstract Builder addressTextColor(Integer num);

        public abstract Builder backgroundColor(Integer num);

        public abstract NearbyResultViewOption build();

        public abstract Builder categoryFilterBackgroundColor(Integer num);

        public abstract Builder distanceTextColor(Integer num);

        public abstract Builder listBackgroundColor(Integer num);

        public abstract Builder listSeperatorColor(Integer num);

        public abstract Builder locationCircleAlpha(Float f);

        public abstract Builder locationCircleColor(Integer num);

        public abstract Builder locationMarkerBitmap(Bitmap bitmap);

        public abstract Builder locationMarkerIcon(Integer num);

        public abstract Builder nextButtonBackgroundColor(Integer num);

        public abstract Builder paginationBackgroundColor(Integer num);

        public abstract Builder placeNameTextColor(Integer num);

        public abstract Builder prevButtonBackgroundColor(Integer num);

        public abstract Builder showDefaultMap(Boolean bool);

        public abstract Builder tabBackgroundColor(Integer num);

        public abstract Builder tabIconTint(Integer num);

        public abstract Builder tabIndicatorColor(Integer num);

        public abstract Builder tabSelectedTextColor(Integer num);

        public abstract Builder tabTextColor(Integer num);

        public abstract Builder toolbarBackgroundColor(Integer num);

        public abstract Builder toolbarText(String str);

        public abstract Builder toolbarTintColor(Integer num);
    }

    public static Builder builder() {
        return new a.C0106a().backgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).listBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).paginationBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).toolbarBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).prevButtonBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).nextButtonBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).categoryFilterBackgroundColor(Integer.valueOf(Color.parseColor("#FAFAFA"))).toolbarTintColor(Integer.valueOf(Color.parseColor("#212121"))).listSeperatorColor(Integer.valueOf(Color.parseColor("#212121"))).toolbarText("Nearby Search").tabTextColor(Integer.valueOf(Color.parseColor("#797979"))).tabSelectedTextColor(Integer.valueOf(Color.parseColor("#3A78E7"))).tabBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).tabIndicatorColor(Integer.valueOf(Color.parseColor("#3A78E7"))).tabIconTint(Integer.valueOf(R.color.mappls_nearby_icon_tab_color)).placeNameTextColor(Integer.valueOf(Color.parseColor("#212121"))).addressTextColor(Integer.valueOf(Color.parseColor("#212121"))).distanceTextColor(Integer.valueOf(Color.parseColor("#99212121"))).locationCircleColor(Integer.valueOf(Color.parseColor("#0099FF"))).locationMarkerIcon(Integer.valueOf(R.drawable.mappls_nearby_location_marker)).locationCircleAlpha(Float.valueOf(0.22f)).showDefaultMap(Boolean.TRUE);
    }

    public static NearbyResultViewOption createFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mappls_nearby_result, 0, 0);
        Builder builder = builder();
        builder.backgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_background, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.listBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_list_background, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.prevButtonBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_prev_button_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.nextButtonBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_next_button_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.listSeperatorColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_list_seperator, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.categoryFilterBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_category_filter_background_color, ContextCompat.getColor(context, R.color.mappls_nearby_address_background_color))));
        builder.paginationBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_pagination_background, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.toolbarBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_toolbar_background, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.toolbarTintColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_toolbar_tint_color, ContextCompat.getColor(context, R.color.mappls_nearby_primary_color))));
        builder.toolbarText(typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_result_mappls_nearby_result_toolbar_text) != null ? typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_result_mappls_nearby_result_toolbar_text) : "Nearby Search");
        builder.tabTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_tab_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_address_tooltip_text_color))));
        builder.tabSelectedTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_tab_selected_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_secondary_color))));
        builder.tabIndicatorColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_tab_indicator_color, ContextCompat.getColor(context, R.color.mappls_nearby_secondary_color))));
        builder.tabBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_tab_background_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.tabIconTint(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.mappls_nearby_result_mappls_nearby_result_tab_icon_tint, R.color.mappls_nearby_icon_tab_color)));
        builder.placeNameTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_place_name_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_primary_color))));
        builder.distanceTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_distance_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_primary_color_60))));
        builder.addressTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_address_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_primary_color))));
        builder.locationMarkerIcon(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.mappls_nearby_result_mappls_nearby_result_location_marker_icon, R.drawable.mappls_nearby_location_marker)));
        builder.locationCircleColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_result_mappls_nearby_result_location_circle_color, ContextCompat.getColor(context, R.color.mappls_nearby_circle_color))));
        builder.locationCircleAlpha(Float.valueOf(typedArrayObtainStyledAttributes.getFloat(R.styleable.mappls_nearby_result_mappls_nearby_result_location_circle_alpha, 0.22f)));
        builder.showDefaultMap(Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.mappls_nearby_result_mappls_nearby_result_show_default_map, true)));
        typedArrayObtainStyledAttributes.recycle();
        return builder.build();
    }

    public static NearbyResultViewOption createFromNearbyOption(NearbyUIOption nearbyUIOption) {
        Builder builder = builder();
        builder.backgroundColor(nearbyUIOption.backgroundColor());
        builder.paginationBackgroundColor(nearbyUIOption.paginationBackgroundColor());
        builder.toolbarBackgroundColor(nearbyUIOption.toolbarColor());
        builder.toolbarTintColor(nearbyUIOption.toolbarTintColor());
        builder.tabTextColor(nearbyUIOption.tabTextColor());
        builder.tabSelectedTextColor(nearbyUIOption.selectedTabTextColor());
        builder.tabIndicatorColor(nearbyUIOption.tabIndicatorColor());
        builder.tabBackgroundColor(nearbyUIOption.tabBackgroundColor());
        builder.tabIconTint(nearbyUIOption.tabIconTint());
        builder.prevButtonBackgroundColor(nearbyUIOption.prevButtonBackgroundColor());
        builder.categoryFilterBackgroundColor(nearbyUIOption.categoryFilterBackgroundColor());
        builder.nextButtonBackgroundColor(nearbyUIOption.nextButtonBackgroundColor());
        builder.placeNameTextColor(nearbyUIOption.placeNameTextColor());
        builder.distanceTextColor(nearbyUIOption.distanceTextColor());
        builder.addressTextColor(nearbyUIOption.placeAddressTextColor());
        builder.locationMarkerIcon(nearbyUIOption.refLocationIcon());
        builder.locationMarkerBitmap(nearbyUIOption.refLocationBitmap());
        builder.listBackgroundColor(nearbyUIOption.detailListBackgroundColor());
        builder.listSeperatorColor(nearbyUIOption.detailListSeperatorBackgroundColor());
        builder.locationCircleColor(nearbyUIOption.refLocationCircleColor());
        builder.locationCircleAlpha(nearbyUIOption.refLocationCircleAlpha());
        builder.showDefaultMap(nearbyUIOption.showDefaultMap());
        return builder.build();
    }

    public abstract Integer addressTextColor();

    public abstract Integer backgroundColor();

    public abstract Integer categoryFilterBackgroundColor();

    public abstract Integer distanceTextColor();

    public abstract Integer listBackgroundColor();

    public abstract Integer listSeperatorColor();

    public abstract Float locationCircleAlpha();

    public abstract Integer locationCircleColor();

    public abstract Bitmap locationMarkerBitmap();

    public abstract Integer locationMarkerIcon();

    public abstract Integer nextButtonBackgroundColor();

    public abstract Integer paginationBackgroundColor();

    public abstract Integer placeNameTextColor();

    public abstract Integer prevButtonBackgroundColor();

    public abstract Boolean showDefaultMap();

    public abstract Integer tabBackgroundColor();

    public abstract Integer tabIconTint();

    public abstract Integer tabIndicatorColor();

    public abstract Integer tabSelectedTextColor();

    public abstract Integer tabTextColor();

    public abstract Integer toolbarBackgroundColor();

    public abstract String toolbarText();

    public abstract Integer toolbarTintColor();
}
