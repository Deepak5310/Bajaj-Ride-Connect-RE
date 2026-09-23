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
public abstract class NearbyViewOption implements Parcelable {

    public static abstract class Builder {
        public abstract Builder addressBackgroundColor(Integer num);

        public abstract Builder addressTextColor(Integer num);

        public abstract Builder addressTooltipTextColor(Integer num);

        public abstract Builder backgroundColor(Integer num);

        public abstract NearbyViewOption build();

        public abstract Builder categoryBackgroundColor(Integer num);

        public abstract Builder categoryTextColor(Integer num);

        public abstract Builder categoryTintColor(Integer num);

        public abstract Builder changeLocationButtonTextColor(Integer num);

        public abstract Builder locationInfoLabelText(String str);

        public abstract Builder selectedCategoryBackgroundColor(Integer num);

        public abstract Builder selectedCategoryTextColor(Integer num);

        public abstract Builder selectedCategoryTintColor(Integer num);

        public abstract Builder submitButtonColor(Integer num);

        public abstract Builder submitButtonResource(Integer num);

        public abstract Builder submitButtonText(String str);

        public abstract Builder submitButtonTextColor(Integer num);

        public abstract Builder toolbarBackgroundColor(Integer num);

        public abstract Builder toolbarBitmap(Bitmap bitmap);

        public abstract Builder toolbarIcon(Integer num);

        public abstract Builder toolbarText(String str);

        public abstract Builder toolbarTextColor(Integer num);

        public abstract Builder useCurrentLocationButtonTextColor(Integer num);
    }

    public static Builder builder() {
        return new b.a().backgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).toolbarBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).toolbarIcon(Integer.valueOf(R.drawable.mappls_nearby_marker)).toolbarTextColor(Integer.valueOf(Color.parseColor("#212121"))).toolbarText("Nearby Search").addressBackgroundColor(Integer.valueOf(Color.parseColor("#FAFAFA"))).addressTooltipTextColor(Integer.valueOf(Color.parseColor("#797979"))).addressTextColor(Integer.valueOf(Color.parseColor("#212121"))).changeLocationButtonTextColor(Integer.valueOf(Color.parseColor("#3A78E7"))).useCurrentLocationButtonTextColor(Integer.valueOf(Color.parseColor("#3A78E7"))).selectedCategoryBackgroundColor(Integer.valueOf(Color.parseColor("#3A78E7"))).selectedCategoryTextColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).selectedCategoryTintColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).categoryBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).categoryTextColor(Integer.valueOf(Color.parseColor("#3D3D3D"))).categoryTintColor(Integer.valueOf(Color.parseColor("#3A78E7"))).submitButtonResource(Integer.valueOf(R.drawable.mappls_nearby_btn_bg)).submitButtonText("Next").locationInfoLabelText("Your location is auto-detected as").submitButtonTextColor(Integer.valueOf(Color.parseColor("#FFFFFF")));
    }

    public static NearbyViewOption createFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mappls_nearby, 0, 0);
        Builder builder = builder();
        builder.backgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_background, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.toolbarBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_toolbar_background, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.toolbarIcon(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.mappls_nearby_mappls_nearby_toolbar_icon, R.drawable.mappls_nearby_marker)));
        builder.toolbarTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_toolbar_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_primary_color))));
        builder.toolbarText(typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_mappls_nearby_toolbar_text) != null ? typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_mappls_nearby_toolbar_text) : "Nearby Search");
        builder.addressBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_address_background, ContextCompat.getColor(context, R.color.mappls_nearby_address_background_color))));
        builder.addressTooltipTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_address_tooltip_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_address_tooltip_text_color))));
        builder.addressTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_address_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_primary_color))));
        builder.changeLocationButtonTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_change_location_button_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_secondary_color))));
        builder.useCurrentLocationButtonTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_use_current_location_button_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_secondary_color))));
        builder.selectedCategoryBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_selected_category_background_color, ContextCompat.getColor(context, R.color.mappls_nearby_secondary_color))));
        builder.selectedCategoryTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_selected_category_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.selectedCategoryTintColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_selected_category_tint_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.categoryBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_category_background_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.categoryTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_category_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_text_color))));
        builder.categoryTintColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_category_tint_color, ContextCompat.getColor(context, R.color.mappls_nearby_secondary_color))));
        builder.submitButtonResource(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.mappls_nearby_mappls_nearby_submit_button_color, R.drawable.mappls_nearby_btn_bg)));
        builder.submitButtonTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R.styleable.mappls_nearby_mappls_nearby_submit_text_color, ContextCompat.getColor(context, R.color.mappls_nearby_white))));
        builder.submitButtonText(typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_mappls_nearby_submit_button_text) != null ? typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_mappls_nearby_submit_button_text) : "Next");
        builder.locationInfoLabelText(typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_mappls_nearby_location_info_label_text) != null ? typedArrayObtainStyledAttributes.getString(R.styleable.mappls_nearby_mappls_nearby_location_info_label_text) : "Your location is auto-detected as");
        typedArrayObtainStyledAttributes.recycle();
        return builder.build();
    }

    public static NearbyViewOption createFromNearbyOption(NearbyUIOption nearbyUIOption) {
        Builder builder = builder();
        builder.backgroundColor(nearbyUIOption.backgroundColor());
        builder.toolbarBackgroundColor(nearbyUIOption.nearbyToolbarColor());
        builder.toolbarIcon(nearbyUIOption.nearbyToolbarIcon());
        builder.toolbarBitmap(nearbyUIOption.nearbyToolbarBitmap());
        builder.toolbarTextColor(nearbyUIOption.nearbyToolbarTintColor());
        builder.addressBackgroundColor(nearbyUIOption.locationDetailsBackgroundColor());
        builder.addressTextColor(nearbyUIOption.locationDetailFormattedAddressTextColor());
        builder.addressTooltipTextColor(nearbyUIOption.locationDetailInfoTextColor());
        builder.changeLocationButtonTextColor(nearbyUIOption.changeLocationButtonTextColor());
        builder.useCurrentLocationButtonTextColor(nearbyUIOption.useCurrentLocationButtonTextColor());
        builder.submitButtonTextColor(nearbyUIOption.submitButtonTextColor());
        builder.submitButtonResource(nearbyUIOption.submitButtonResource());
        builder.submitButtonColor(nearbyUIOption.submitButtonColor());
        builder.submitButtonText(nearbyUIOption.submitButtonText());
        builder.selectedCategoryBackgroundColor(nearbyUIOption.selectedCategoryBackgroundColor());
        builder.selectedCategoryTextColor(nearbyUIOption.selectedCategoryTextColor());
        builder.selectedCategoryTintColor(nearbyUIOption.selectedCategoryTintColor());
        builder.categoryBackgroundColor(nearbyUIOption.categoryBackgroundColor());
        builder.categoryTextColor(nearbyUIOption.categoryTextColor());
        builder.categoryTintColor(nearbyUIOption.categoryTintColor());
        builder.locationInfoLabelText(nearbyUIOption.locationDetailsInfoLabelText());
        return builder.build();
    }

    abstract Integer addressBackgroundColor();

    abstract Integer addressTextColor();

    abstract Integer addressTooltipTextColor();

    abstract Integer backgroundColor();

    public abstract Integer categoryBackgroundColor();

    public abstract Integer categoryTextColor();

    public abstract Integer categoryTintColor();

    abstract Integer changeLocationButtonTextColor();

    public abstract String locationInfoLabelText();

    public abstract Integer selectedCategoryBackgroundColor();

    public abstract Integer selectedCategoryTextColor();

    public abstract Integer selectedCategoryTintColor();

    public abstract Integer submitButtonColor();

    public abstract Integer submitButtonResource();

    public abstract String submitButtonText();

    public abstract Integer submitButtonTextColor();

    abstract Integer toolbarBackgroundColor();

    abstract Bitmap toolbarBitmap();

    abstract Integer toolbarIcon();

    abstract String toolbarText();

    abstract Integer toolbarTextColor();

    abstract Integer useCurrentLocationButtonTextColor();
}
