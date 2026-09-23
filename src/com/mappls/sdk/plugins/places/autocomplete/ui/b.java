package com.mappls.sdk.plugins.places.autocomplete.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.plugins.places.autocomplete.model.d;
import com.mappls.sdk.services.api.autosuggest.model.SuggestedSearchAtlas;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<d> a;
    private ResultClickCallback b;
    private PlaceOptions c;

    static class a extends RecyclerView.ViewHolder {
        private final View a;
        private final TextView b;
        private final TextView c;
        private final TextView d;
        private final ImageView e;

        /* JADX INFO: renamed from: com.mappls.sdk.plugins.places.autocomplete.ui.b$a$a, reason: collision with other inner class name */
        final class ViewOnClickListenerC0112a implements View.OnClickListener {
            final /* synthetic */ ResultClickCallback a;
            final /* synthetic */ d b;

            ViewOnClickListenerC0112a(ResultClickCallback resultClickCallback, d dVar) {
                this.a = resultClickCallback;
                this.b = dVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(this.b);
            }
        }

        a(View view) {
            super(view);
            this.b = (TextView) view.findViewById(R.id.tv_place_name);
            this.c = (TextView) view.findViewById(R.id.tv_address);
            this.d = (TextView) view.findViewById(R.id.tv_distance);
            this.e = (ImageView) view.findViewById(R.id.iv_search_type);
            this.a = view.findViewById(R.id.searchResultBackgroundLayout);
        }

        public final void a(d dVar, ResultClickCallback resultClickCallback) {
            this.itemView.setOnClickListener(new ViewOnClickListenerC0112a(resultClickCallback, dVar));
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.plugins.places.autocomplete.ui.b$b, reason: collision with other inner class name */
    static class C0113b extends RecyclerView.ViewHolder {
        private final View a;
        private final TextView b;

        /* JADX INFO: renamed from: com.mappls.sdk.plugins.places.autocomplete.ui.b$b$a */
        final class a implements View.OnClickListener {
            final /* synthetic */ ResultClickCallback a;
            final /* synthetic */ d b;

            a(ResultClickCallback resultClickCallback, d dVar) {
                this.a = resultClickCallback;
                this.b = dVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(this.b);
            }
        }

        C0113b(View view) {
            super(view);
            this.b = (TextView) view.findViewById(R.id.tv_suggested_name);
            this.a = view.findViewById(R.id.suggestedResultBackgroundLayout);
        }

        public final void a(d dVar, ResultClickCallback resultClickCallback) {
            this.itemView.setOnClickListener(new a(resultClickCallback, dVar));
        }
    }

    public b(List<d> list) {
        this.a = list;
    }

    public final void a(PlaceOptions placeOptions) {
        this.c = placeOptions;
        notifyDataSetChanged();
    }

    public final void a(ResultClickCallback resultClickCallback) {
        this.b = resultClickCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<d> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return this.a.get(i).c() == 4 ? 0 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x01a4  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        int iFavoritePlaceNameTextColor;
        TextView textView2;
        String placeAddress;
        a aVar;
        StringBuilder sb;
        if (!(viewHolder instanceof a)) {
            SuggestedSearchAtlas suggestedSearchAtlasB = this.a.get(i).b();
            StringBuilder sb2 = new StringBuilder(suggestedSearchAtlasB.keyword);
            sb2.append(StringUtils.SPACE);
            sb2.append(suggestedSearchAtlasB.identifier);
            sb2.append(StringUtils.SPACE);
            sb2.append(suggestedSearchAtlasB.location);
            C0113b c0113b = (C0113b) viewHolder;
            c0113b.b.setText(sb2);
            if (this.c != null) {
                c0113b.a.setBackgroundColor(this.c.resultBackgroundColor());
                c0113b.b.setTextColor(this.c.placeNameTextColor());
            }
            if (this.b != null) {
                c0113b.a(this.a.get(i), this.b);
                return;
            }
            return;
        }
        if (this.b != null) {
            ((a) viewHolder).a(this.a.get(i), this.b);
        }
        if (this.c != null) {
            a aVar2 = (a) viewHolder;
            aVar2.a.setBackgroundColor(this.c.resultBackgroundColor());
            aVar2.c.setTextColor(this.c.addressTextColor());
        }
        if (this.a.get(i).c() == 1) {
            a aVar3 = (a) viewHolder;
            aVar3.e.setImageDrawable(ContextCompat.getDrawable(aVar3.itemView.getContext(), R.drawable.mappls_search_ic_history));
            if (this.c != null) {
                textView = aVar3.b;
                iFavoritePlaceNameTextColor = this.c.savedPlaceNameTextColor();
                textView.setTextColor(iFavoritePlaceNameTextColor);
            }
        } else if (this.a.get(i).c() == 2) {
            a aVar4 = (a) viewHolder;
            aVar4.e.setImageDrawable(ContextCompat.getDrawable(aVar4.itemView.getContext(), R.drawable.mappls_search_ic_place));
            if (this.c != null) {
                textView = aVar4.b;
                iFavoritePlaceNameTextColor = this.c.placeNameTextColor();
                textView.setTextColor(iFavoritePlaceNameTextColor);
            }
        } else if (this.a.get(i).c() == 3) {
            a aVar5 = (a) viewHolder;
            aVar5.e.setImageDrawable(ContextCompat.getDrawable(aVar5.itemView.getContext(), R.drawable.mappls_search_ic_favorite));
            if (this.c != null) {
                textView = aVar5.b;
                iFavoritePlaceNameTextColor = this.c.favoritePlaceNameTextColor();
                textView.setTextColor(iFavoritePlaceNameTextColor);
            }
        }
        if (this.a.get(i).c() != 3) {
            if (this.a.get(i).d().placeName != null) {
                ((a) viewHolder).b.setText(this.a.get(i).d().placeName);
            } else {
                ((a) viewHolder).b.setHeight(0);
            }
            if (this.a.get(i).d().placeAddress != null) {
                textView2 = ((a) viewHolder).c;
                placeAddress = this.a.get(i).d().placeAddress;
                textView2.setText(placeAddress);
            } else {
                ((a) viewHolder).c.setHeight(0);
            }
        } else {
            if (this.a.get(i).a().getPlaceName() != null) {
                ((a) viewHolder).b.setText(this.a.get(i).a().getPlaceName());
            } else {
                ((a) viewHolder).b.setHeight(0);
            }
            if (this.a.get(i).a().getPlaceAddress() != null) {
                textView2 = ((a) viewHolder).c;
                placeAddress = this.a.get(i).a().getPlaceAddress();
                textView2.setText(placeAddress);
            } else {
                ((a) viewHolder).c.setHeight(0);
            }
        }
        if (this.a.get(i).c() == 2) {
            aVar = (a) viewHolder;
            aVar.d.setTextColor(this.c.distanceTextColor());
            if (this.a.get(i).d().distance != null && this.a.get(i).d().distance.doubleValue() > 0.0d) {
                aVar.d.setVisibility(0);
                TextView textView3 = aVar.d;
                double dDoubleValue = this.a.get(i).d().distance.doubleValue();
                if (dDoubleValue < 1000.0d) {
                    sb = new StringBuilder();
                    sb.append((int) dDoubleValue);
                    sb.append(" mtr");
                } else {
                    if (dDoubleValue < 10000.0d) {
                        sb = new StringBuilder();
                        sb.append(new DecimalFormat("#.#").format(dDoubleValue / 1000.0d));
                    } else {
                        sb = new StringBuilder();
                        sb.append((int) (dDoubleValue / 1000.0d));
                    }
                    sb.append(" km");
                }
                textView3.setText(sb.toString());
                return;
            }
        } else {
            aVar = (a) viewHolder;
        }
        aVar.d.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new C0113b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappls_search_suggested_item_result, viewGroup, false)) : new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappls_search_item_search_result, viewGroup, false));
    }
}
