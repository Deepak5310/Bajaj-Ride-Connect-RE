package com.mappls.sdk.plugins.places.placepicker.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions;
import com.mappls.sdk.services.api.Place;

/* JADX INFO: loaded from: classes4.dex */
public class CurrentPlaceSelectionBottomSheet extends CoordinatorLayout {
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private ProgressBar d;

    public CurrentPlaceSelectionBottomSheet(Context context) {
        this(context, null);
    }

    public CurrentPlaceSelectionBottomSheet(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CurrentPlaceSelectionBottomSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (str != null && !str.trim().equalsIgnoreCase(BuildConfig.TRAVIS) && !str.trim().equalsIgnoreCase("unnamed road") && str.trim().length() > 1) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(str.trim());
            }
        }
        return sb.toString();
    }

    public final void a() {
        this.a.setVisibility(b() ? 8 : 0);
    }

    public final void a(PlacePickerOptions placePickerOptions) {
        this.b.setTextColor(placePickerOptions.placeNameTextColor().intValue());
        this.c.setTextColor(placePickerOptions.addressTextColor().intValue());
    }

    public final boolean b() {
        return this.a.getVisibility() != 8;
    }

    private void a(Context context) {
        this.a = (LinearLayout) findViewById(R.id.root_bottom_sheet);
        this.b = (TextView) findViewById(R.id.text_view_place_name);
        this.c = (TextView) findViewById(R.id.text_view_place_address);
        this.d = (ProgressBar) findViewById(R.id.progress_bar_place);
        this.a.setVisibility(8);
    }

    public final void a(Place place, boolean z) {
        TextView textView;
        String poi;
        TextView textView2;
        String formattedAddress;
        String strA;
        if (!b()) {
            this.a.setVisibility(b() ? 8 : 0);
        }
        if (place == null) {
            this.b.setText("");
            this.c.setText("");
            this.d.setVisibility(0);
            return;
        }
        this.d.setVisibility(4);
        if (z) {
            if (place.getFormattedAddress() == null || TextUtils.isEmpty(place.getFormattedAddress())) {
                this.b.setText("Dropped pin");
                if (place.getArea() == null || TextUtils.isEmpty(place.getArea())) {
                    textView2 = this.c;
                    formattedAddress = place.getLat() + "," + place.getLng();
                } else {
                    textView2 = this.c;
                    formattedAddress = place.getArea();
                }
            } else {
                if (place.getPoiDist() == null || TextUtils.isEmpty(place.getPoiDist()) || Integer.parseInt(place.getPoiDist()) > 5) {
                    strA = (place.getCity() == null || TextUtils.isEmpty(place.getCity())) ? a(new String[]{place.getHouseNumber(), place.getHouseName(), place.getStreet(), place.getVillage(), place.getSubDistrict()}) : a(new String[]{place.getHouseNumber(), place.getHouseName(), place.getStreet(), place.getSubSubLocality(), place.getSubLocality(), place.getLocality(), place.getCity()});
                } else {
                    strA = (place.getCity() == null || TextUtils.isEmpty(place.getCity())) ? a(new String[]{place.getPoi(), place.getStreet(), place.getVillage(), place.getSubDistrict()}) : a(new String[]{place.getPoi(), place.getStreet(), place.getSubSubLocality(), place.getSubLocality(), place.getLocality(), place.getCity()});
                }
                if (TextUtils.isEmpty(strA)) {
                    textView = this.b;
                    poi = "Dropped Pin";
                } else {
                    this.b.setText(strA);
                }
                textView2 = this.c;
                formattedAddress = place.getFormattedAddress();
            }
            textView2.setText(formattedAddress);
        }
        if (TextUtils.isEmpty(place.getPoi())) {
            this.b.setText(place.getFormattedAddress());
            this.c.setText("");
            return;
        } else {
            textView = this.b;
            poi = place.getPoi();
        }
        textView.setText(poi);
        textView2 = this.c;
        formattedAddress = place.getFormattedAddress();
        textView2.setText(formattedAddress);
    }
}
