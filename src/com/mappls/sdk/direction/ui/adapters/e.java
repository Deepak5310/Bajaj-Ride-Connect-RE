package com.mappls.sdk.direction.ui.adapters;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionRouteSummaryHeaderBinding;
import com.mappls.sdk.direction.ui.databinding.MapplsDirectionRouteSummaryItemBinding;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<com.mappls.sdk.direction.ui.event.d> a;
    private b b;

    final class a implements View.OnClickListener {
        final /* synthetic */ com.mappls.sdk.direction.ui.event.c a;

        a(com.mappls.sdk.direction.ui.event.c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (e.this.b != null) {
                e.this.b.a(this.a.b(), this.a.d());
            }
        }
    }

    public interface b {
        void a(String str, ArrayList<ReportDetails> arrayList);
    }

    private class c extends RecyclerView.ViewHolder {
        private MapplsDirectionRouteSummaryHeaderBinding a;

        public c(MapplsDirectionRouteSummaryHeaderBinding mapplsDirectionRouteSummaryHeaderBinding) {
            super(mapplsDirectionRouteSummaryHeaderBinding.getRoot());
            this.a = mapplsDirectionRouteSummaryHeaderBinding;
        }
    }

    private class d extends RecyclerView.ViewHolder {
        private MapplsDirectionRouteSummaryItemBinding a;

        public d(MapplsDirectionRouteSummaryItemBinding mapplsDirectionRouteSummaryItemBinding) {
            super(mapplsDirectionRouteSummaryItemBinding.getRoot());
            this.a = mapplsDirectionRouteSummaryItemBinding;
        }
    }

    public e(ArrayList arrayList) {
        this.a = arrayList;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<com.mappls.sdk.direction.ui.event.d> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return com.mappls.sdk.direction.ui.event.a.a(this.a.get(i).a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        StringBuilder sb;
        String addedByName;
        if (viewHolder instanceof c) {
            com.mappls.sdk.direction.ui.event.c cVar = (com.mappls.sdk.direction.ui.event.c) this.a.get(i);
            c cVar2 = (c) viewHolder;
            Glide.with(cVar2.a.mapplsDirectionImageEventType).load(cVar.c()).placeholder(R.drawable.mappls_direction_report_placeholder_48_px).into(cVar2.a.mapplsDirectionImageEventType);
            cVar2.a.textReportSummaryEventName.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, Color.parseColor("#212121"), cVar2.a.getRoot().getContext()));
            cVar2.a.textReportSummaryEventName.setText(cVar.b());
            cVar2.a.textReportSummaryEventCount.setText(cVar.e() + "");
            if (cVar.f()) {
                cVar2.a.textReportSummaryViewAll.setVisibility(0);
            } else {
                cVar2.a.textReportSummaryViewAll.setVisibility(8);
            }
            cVar2.a.textReportSummaryViewAll.setOnClickListener(new a(cVar));
            return;
        }
        if (viewHolder instanceof d) {
            com.mappls.sdk.direction.ui.event.b bVar = (com.mappls.sdk.direction.ui.event.b) this.a.get(i);
            d dVar = (d) viewHolder;
            Glide.with(dVar.a.imageRouteSummaryEventType).load(bVar.b().getReportIcon("48px")).placeholder(R.drawable.mappls_direction_report_placeholder_48_px).into(dVar.a.imageRouteSummaryEventType);
            TextView textView2 = dVar.a.title;
            String childCategory = bVar.b().getChildCategory();
            String str = " at " + bVar.b().getAddress();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(childCategory);
            spannableString.setSpan(new StyleSpan(1), 0, childCategory.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(str);
            spannableString2.setSpan(new StyleSpan(0), 0, str.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            textView2.setText(spannableStringBuilder);
            dVar.a.title.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, Color.parseColor("#212121"), dVar.a.getRoot().getContext()));
            dVar.a.subTitle.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_secondary, Color.parseColor("#707070"), dVar.a.getRoot().getContext()));
            if (bVar.b().getUsersCount() != null && bVar.b().getUsersCount().longValue() > 1) {
                textView = dVar.a.subTitle;
                sb = new StringBuilder("Reported By: ");
                sb.append(bVar.b().getUsersCount());
                addedByName = " People";
            } else {
                if (bVar.b().getAddedByName() == null) {
                    return;
                }
                textView = dVar.a.subTitle;
                sb = new StringBuilder("Reported By: ");
                addedByName = bVar.b().getAddedByName();
            }
            sb.append(addedByName);
            textView.setText(sb.toString());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == com.mappls.sdk.direction.ui.event.a.a(1)) {
            return new c((MapplsDirectionRouteSummaryHeaderBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_route_summary_header, viewGroup, false));
        }
        return i == com.mappls.sdk.direction.ui.event.a.a(2) ? new d((MapplsDirectionRouteSummaryItemBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_route_summary_item, viewGroup, false)) : new d((MapplsDirectionRouteSummaryItemBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.mappls_direction_route_summary_item, viewGroup, false));
    }
}
