package com.mappls.sdk.nearby.plugin.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcelable;
import com.mappls.sdk.nearby.plugin.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NearbyUIOption implements Parcelable {

    public static abstract class Builder {
        public abstract Builder backgroundColor(Integer num);

        public abstract NearbyUIOption build();

        public abstract Builder categoryBackgroundColor(Integer num);

        public abstract Builder categoryFilterBackgroundColor(Integer num);

        public abstract Builder categoryTextColor(Integer num);

        public abstract Builder categoryTintColor(Integer num);

        public abstract Builder changeLocationButtonTextColor(Integer num);

        public abstract Builder detailListBackgroundColor(Integer num);

        public abstract Builder detailListSeperatorBackgroundColor(Integer num);

        public abstract Builder distanceTextColor(Integer num);

        public abstract Builder locationDetailFormattedAddressTextColor(Integer num);

        public abstract Builder locationDetailInfoTextColor(Integer num);

        public abstract Builder locationDetailsBackgroundColor(Integer num);

        public abstract Builder locationDetailsInfoLabelText(String str);

        protected abstract Builder nearbyToolbarBitmap(Bitmap bitmap);

        public abstract Builder nearbyToolbarColor(Integer num);

        public Builder nearbyToolbarIcon(Bitmap bitmap) {
            return nearbyToolbarBitmap(bitmap);
        }

        public abstract Builder nearbyToolbarIcon(Integer num);

        public abstract Builder nearbyToolbarTintColor(Integer num);

        public abstract Builder nextButtonBackgroundColor(Integer num);

        public abstract Builder paginationBackgroundColor(Integer num);

        public abstract Builder placeAddressTextColor(Integer num);

        public abstract Builder placeNameTextColor(Integer num);

        public abstract Builder prevButtonBackgroundColor(Integer num);

        abstract Builder refLocationBitmap(Bitmap bitmap);

        public abstract Builder refLocationCircleAlpha(Float f);

        public abstract Builder refLocationCircleColor(Integer num);

        public Builder refLocationIcon(Bitmap bitmap) {
            return refLocationBitmap(bitmap);
        }

        public abstract Builder refLocationIcon(Integer num);

        public abstract Builder selectedCategoryBackgroundColor(Integer num);

        public abstract Builder selectedCategoryTextColor(Integer num);

        public abstract Builder selectedCategoryTintColor(Integer num);

        public abstract Builder selectedTabTextColor(Integer num);

        public abstract Builder showDefaultMap(Boolean bool);

        public abstract Builder submitButtonColor(Integer num);

        public abstract Builder submitButtonResource(Integer num);

        public abstract Builder submitButtonText(String str);

        public abstract Builder submitButtonTextColor(Integer num);

        public abstract Builder tabBackgroundColor(Integer num);

        public abstract Builder tabIconTint(Integer num);

        public abstract Builder tabIndicatorColor(Integer num);

        public abstract Builder tabTextColor(Integer num);

        public abstract Builder toolbarColor(Integer num);

        public abstract Builder toolbarTintColor(Integer num);

        public abstract Builder useCurrentLocationButtonTextColor(Integer num);
    }

    public static Builder builder() {
        return new c.a().backgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).detailListBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).toolbarColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).nearbyToolbarColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).prevButtonBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).nextButtonBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).nearbyToolbarIcon(Integer.valueOf(R.drawable.mappls_nearby_marker)).toolbarTintColor(Integer.valueOf(Color.parseColor("#212121"))).nearbyToolbarTintColor(Integer.valueOf(Color.parseColor("#212121"))).detailListSeperatorBackgroundColor(Integer.valueOf(Color.parseColor("#212121"))).locationDetailsBackgroundColor(Integer.valueOf(Color.parseColor("#FAFAFA"))).categoryFilterBackgroundColor(Integer.valueOf(Color.parseColor("#FAFAFA"))).locationDetailInfoTextColor(Integer.valueOf(Color.parseColor("#797979"))).locationDetailsInfoLabelText("Your location is auto-detected as").locationDetailFormattedAddressTextColor(Integer.valueOf(Color.parseColor("#212121"))).changeLocationButtonTextColor(Integer.valueOf(Color.parseColor("#3A78E7"))).useCurrentLocationButtonTextColor(Integer.valueOf(Color.parseColor("#3A78E7"))).submitButtonResource(Integer.valueOf(R.drawable.mappls_nearby_btn_bg)).submitButtonTextColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).selectedCategoryBackgroundColor(Integer.valueOf(Color.parseColor("#3A78E7"))).selectedCategoryTextColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).selectedCategoryTintColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).categoryBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).tabBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).categoryTextColor(Integer.valueOf(Color.parseColor("#3D3D3D"))).categoryTintColor(Integer.valueOf(Color.parseColor("#3A78E7"))).paginationBackgroundColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).tabTextColor(Integer.valueOf(Color.parseColor("#797979"))).selectedTabTextColor(Integer.valueOf(Color.parseColor("#3A78E7"))).tabIndicatorColor(Integer.valueOf(Color.parseColor("#3A78E7"))).tabIconTint(Integer.valueOf(R.color.mappls_nearby_icon_tab_color)).placeNameTextColor(Integer.valueOf(Color.parseColor("#212121"))).distanceTextColor(Integer.valueOf(Color.parseColor("#99212121"))).placeAddressTextColor(Integer.valueOf(Color.parseColor("#212121"))).refLocationIcon(Integer.valueOf(R.drawable.mappls_nearby_location_marker)).refLocationCircleColor(Integer.valueOf(Color.parseColor("#0099FF"))).submitButtonText("Next").refLocationCircleAlpha(Float.valueOf(0.22f)).showDefaultMap(Boolean.TRUE);
    }

    public abstract Integer backgroundColor();

    public abstract Integer categoryBackgroundColor();

    public abstract Integer categoryFilterBackgroundColor();

    public abstract Integer categoryTextColor();

    public abstract Integer categoryTintColor();

    public abstract Integer changeLocationButtonTextColor();

    public abstract Integer detailListBackgroundColor();

    public abstract Integer detailListSeperatorBackgroundColor();

    public abstract Integer distanceTextColor();

    public abstract Integer locationDetailFormattedAddressTextColor();

    public abstract Integer locationDetailInfoTextColor();

    public abstract Integer locationDetailsBackgroundColor();

    public abstract String locationDetailsInfoLabelText();

    public abstract Bitmap nearbyToolbarBitmap();

    public abstract Integer nearbyToolbarColor();

    public abstract Integer nearbyToolbarIcon();

    public abstract Integer nearbyToolbarTintColor();

    public abstract Integer nextButtonBackgroundColor();

    public abstract Integer paginationBackgroundColor();

    public abstract Integer placeAddressTextColor();

    public abstract Integer placeNameTextColor();

    public abstract Integer prevButtonBackgroundColor();

    public abstract Bitmap refLocationBitmap();

    public abstract Float refLocationCircleAlpha();

    public abstract Integer refLocationCircleColor();

    public abstract Integer refLocationIcon();

    public abstract Integer selectedCategoryBackgroundColor();

    public abstract Integer selectedCategoryTextColor();

    public abstract Integer selectedCategoryTintColor();

    public abstract Integer selectedTabTextColor();

    public abstract Boolean showDefaultMap();

    public abstract Integer submitButtonColor();

    public abstract Integer submitButtonResource();

    public abstract String submitButtonText();

    public abstract Integer submitButtonTextColor();

    public abstract Integer tabBackgroundColor();

    public abstract Integer tabIconTint();

    public abstract Integer tabIndicatorColor();

    public abstract Integer tabTextColor();

    public abstract Integer toolbarColor();

    public abstract Integer toolbarTintColor();

    public abstract Integer useCurrentLocationButtonTextColor();
}
