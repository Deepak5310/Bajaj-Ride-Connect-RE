package com.mappls.sdk.category.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.mappls.sdk.category.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SearchCategoryUIOption implements Parcelable {

    public static abstract class Builder {
        public abstract Builder backIcon(Integer num);

        public abstract Builder backgroundColor(Integer num);

        public abstract SearchCategoryUIOption build();

        public abstract Builder hintTextColor(Integer num);

        public abstract Builder iconTintColor(Integer num);

        public abstract Builder itemTextColor(Integer num);

        public abstract Builder nextButtonColor(Integer num);

        public abstract Builder nextButtonTextColor(Integer num);

        public abstract Builder polylineColor(Integer num);

        public abstract Builder polylineWidth(Float f);

        public abstract Builder resultCountTextColor(Integer num);

        public abstract Builder resultMessageTextColor(Integer num);

        public abstract Builder resultPlaceAddressTextColor(Integer num);

        public abstract Builder resultPlaceDistanceTextColor(Integer num);

        public abstract Builder resultPlaceNameTextColor(Integer num);

        public abstract Builder searchTextColor(Integer num);
    }

    public static Builder builder() {
        return new c.a().iconTintColor(Integer.valueOf(Color.parseColor("#3A78E7"))).itemTextColor(Integer.valueOf(Color.parseColor("#212121"))).nextButtonTextColor(-1).nextButtonColor(Integer.valueOf(Color.parseColor("#3A78E7"))).searchTextColor(Integer.valueOf(Color.parseColor("#212121"))).backgroundColor(-1).backIcon(Integer.valueOf(R.drawable.mappls_category_ic_baseline_arrow_back)).hintTextColor(Integer.valueOf(Color.parseColor("#797979"))).resultCountTextColor(Integer.valueOf(Color.parseColor("#3D3D3D"))).resultPlaceNameTextColor(Integer.valueOf(Color.parseColor("#212121"))).resultPlaceAddressTextColor(Integer.valueOf(Color.parseColor("#3D3D3D"))).resultPlaceDistanceTextColor(Integer.valueOf(Color.parseColor("#3D3D3D"))).resultMessageTextColor(Integer.valueOf(Color.parseColor("#3D3D3D"))).polylineWidth(Float.valueOf(4.0f)).polylineColor(Integer.valueOf(Color.parseColor("#07b9fc")));
    }

    public static Builder createFromAttributes(Context context) {
        return createFromAttributes(context, (AttributeSet) null);
    }

    public static Builder createFromAttributes(Context context, int i) {
        return createFromAttributes(context.obtainStyledAttributes(null, R.styleable.mappls_category, 0, i));
    }

    public static Builder createFromAttributes(Context context, AttributeSet attributeSet) {
        return createFromAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.mappls_category, 0, 0));
    }

    static Builder createFromAttributes(TypedArray typedArray) {
        Builder builder = builder();
        if (typedArray != null) {
            try {
                builder.iconTintColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_icon_tint_color, Color.parseColor("#3A78E7"))));
                builder.itemTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_item_text_color, Color.parseColor("#212121"))));
                builder.nextButtonTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_button_next_text_color, -1)));
                builder.nextButtonColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_button_next_background, Color.parseColor("#3A78E7"))));
                builder.searchTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_search_text_color, Color.parseColor("#212121"))));
                builder.backgroundColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_background, -1)));
                builder.backIcon(Integer.valueOf(typedArray.getResourceId(R.styleable.mappls_category_mappls_category_back_button_icon, R.drawable.mappls_category_ic_baseline_arrow_back)));
                builder.hintTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_search_hint_text_color, Color.parseColor("#797979"))));
                builder.resultCountTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_result_count_text_color, Color.parseColor("#3D3D3D"))));
                builder.resultPlaceNameTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_result_place_name_text_color, Color.parseColor("#212121"))));
                builder.resultPlaceAddressTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_result_place_address_text_color, Color.parseColor("#3D3D3D"))));
                builder.resultPlaceDistanceTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_result_place_distance_text_color, Color.parseColor("#3D3D3D"))));
                builder.resultMessageTextColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_result_message_text_color, Color.parseColor("#3D3D3D"))));
                builder.polylineWidth(Float.valueOf(typedArray.getFloat(R.styleable.mappls_category_mappls_category_result_polyline_width, 4.0f)));
                builder.polylineColor(Integer.valueOf(typedArray.getColor(R.styleable.mappls_category_mappls_category_result_polyline_color, Color.parseColor("#07b9fc"))));
            } finally {
                typedArray.recycle();
            }
        }
        return builder;
    }

    public abstract Integer backIcon();

    public abstract Integer backgroundColor();

    public abstract Integer hintTextColor();

    public abstract Integer iconTintColor();

    public abstract Integer itemTextColor();

    public abstract Integer nextButtonColor();

    public abstract Integer nextButtonTextColor();

    public abstract Integer polylineColor();

    public abstract Float polylineWidth();

    public abstract Integer resultCountTextColor();

    public abstract Integer resultMessageTextColor();

    public abstract Integer resultPlaceAddressTextColor();

    public abstract Integer resultPlaceDistanceTextColor();

    public abstract Integer resultPlaceNameTextColor();

    public abstract Integer searchTextColor();
}
