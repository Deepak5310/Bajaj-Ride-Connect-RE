package com.mappls.sdk.category.adapters;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.category.R;
import com.mappls.sdk.category.fragment.CategoryResultFragment;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends RecyclerView.Adapter<C0068b> {
    private List<? extends PoiResult> a;
    private final SearchCategoryUIOption b;
    private final a c;

    public interface a {
        void a(PoiResult poiResult);
    }

    /* JADX INFO: renamed from: com.mappls.sdk.category.adapters.b$b, reason: collision with other inner class name */
    public static final class C0068b extends RecyclerView.ViewHolder {
        private final TextView a;
        private final TextView b;
        private final TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0068b(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.mappls_category_result_place_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.m…tegory_result_place_name)");
            this.a = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.mappls_category_text_view_distance);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.m…egory_text_view_distance)");
            this.b = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.mappls_category_item_place_result_place_address);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.m…ace_result_place_address)");
            this.c = (TextView) viewFindViewById3;
        }

        public final TextView a() {
            return this.c;
        }

        public final TextView b() {
            return this.b;
        }

        public final TextView c() {
            return this.a;
        }
    }

    public b(ArrayList dataSet, SearchCategoryUIOption searchCategoryUIOption, CategoryResultFragment.c poiResultSelectedListener) {
        Intrinsics.checkNotNullParameter(dataSet, "dataSet");
        Intrinsics.checkNotNullParameter(searchCategoryUIOption, "searchCategoryUIOption");
        Intrinsics.checkNotNullParameter(poiResultSelectedListener, "poiResultSelectedListener");
        this.a = dataSet;
        this.b = searchCategoryUIOption;
        this.c = poiResultSelectedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b this$0, PoiResult data, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.c.a(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(C0068b viewHolder, final int i) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final PoiResult poiResult = this.a.get(i);
        TextView textViewA = viewHolder.a();
        Integer numResultPlaceAddressTextColor = this.b.resultPlaceAddressTextColor();
        Intrinsics.checkNotNullExpressionValue(numResultPlaceAddressTextColor, "searchCategoryUIOption.r…ltPlaceAddressTextColor()");
        textViewA.setTextColor(numResultPlaceAddressTextColor.intValue());
        TextView textViewC = viewHolder.c();
        Integer numResultPlaceNameTextColor = this.b.resultPlaceNameTextColor();
        Intrinsics.checkNotNullExpressionValue(numResultPlaceNameTextColor, "searchCategoryUIOption.resultPlaceNameTextColor()");
        textViewC.setTextColor(numResultPlaceNameTextColor.intValue());
        TextView textViewB = viewHolder.b();
        Integer numResultPlaceDistanceTextColor = this.b.resultPlaceDistanceTextColor();
        Intrinsics.checkNotNullExpressionValue(numResultPlaceDistanceTextColor, "searchCategoryUIOption.r…tPlaceDistanceTextColor()");
        textViewB.setTextColor(numResultPlaceDistanceTextColor.intValue());
        viewHolder.c().setText(!TextUtils.isEmpty(poiResult.getPlaceName()) ? poiResult.getPlaceName() : "");
        viewHolder.a().setText(!TextUtils.isEmpty(poiResult.getPlaceAddress()) ? poiResult.getPlaceAddress() : "");
        Long distance = poiResult.getDistance();
        if ((distance == null ? 0L : distance.longValue()) > 0) {
            TextView textViewB2 = viewHolder.b();
            long jLongValue = poiResult.getDistance().longValue();
            if (jLongValue >= 1000) {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setRoundingMode(RoundingMode.CEILING);
                str = decimalFormat.format(jLongValue / 1000.0d) + " km";
            } else {
                str = jLongValue + " m";
            }
            textViewB2.setText(str);
        } else {
            viewHolder.b().setText("");
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.adapters.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.a(this.f$0, poiResult, i, view);
            }
        });
    }

    public final void a(List<? extends PoiResult> list) {
        if (list != null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappls_category_place_result, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new C0068b(view);
    }
}
