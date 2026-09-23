package com.mappls.sdk.direction.ui.adapters;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionRouteSummaryItemBinding;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends RecyclerView.Adapter<a> {
    private final ArrayList<ReportDetails> a;

    class a extends RecyclerView.ViewHolder {
        private final MapplsDirectionRouteSummaryItemBinding a;

        public a(MapplsDirectionRouteSummaryItemBinding mapplsDirectionRouteSummaryItemBinding) {
            super(mapplsDirectionRouteSummaryItemBinding.getRoot());
            this.a = mapplsDirectionRouteSummaryItemBinding;
        }
    }

    public g(ArrayList<ReportDetails> arrayList) {
        this.a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList<ReportDetails> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        StringBuilder sb;
        String addedByName;
        a aVar = (a) viewHolder;
        ReportDetails reportDetails = this.a.get(i);
        Glide.with(aVar.a.imageRouteSummaryEventType).load(reportDetails.getReportIcon("48px")).placeholder(R.drawable.mappls_direction_report_placeholder_48_px).into(aVar.a.imageRouteSummaryEventType);
        TextView textView2 = aVar.a.title;
        String childCategory = reportDetails.getChildCategory();
        String str = " at " + reportDetails.getAddress();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString = new SpannableString(childCategory);
        spannableString.setSpan(new StyleSpan(1), 0, childCategory.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        SpannableString spannableString2 = new SpannableString(str);
        spannableString2.setSpan(new StyleSpan(0), 0, str.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString2);
        textView2.setText(spannableStringBuilder);
        aVar.a.title.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, Color.parseColor("#212121"), aVar.a.getRoot().getContext()));
        aVar.a.subTitle.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, Color.parseColor("#707070"), aVar.a.getRoot().getContext()));
        if (reportDetails.getUsersCount() != null && reportDetails.getUsersCount().longValue() > 1) {
            textView = aVar.a.subTitle;
            sb = new StringBuilder("Reported By: ");
            sb.append(reportDetails.getUsersCount());
            addedByName = " People";
        } else {
            if (reportDetails.getAddedByName() == null) {
                return;
            }
            textView = aVar.a.subTitle;
            sb = new StringBuilder("Reported By: ");
            addedByName = reportDetails.getAddedByName();
        }
        sb.append(addedByName);
        textView.setText(sb.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((MapplsDirectionRouteSummaryItemBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_route_summary_item, viewGroup, false));
    }
}
