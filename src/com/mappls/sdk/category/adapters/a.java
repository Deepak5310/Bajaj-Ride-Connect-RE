package com.mappls.sdk.category.adapters;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.category.R;
import com.mappls.sdk.category.fragment.CategorySearchFragment;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends RecyclerView.Adapter<b> implements Filterable {
    private final int a;
    private final SearchCategoryUIOption b;
    private final InterfaceC0067a c;
    private boolean d;
    private List<? extends CategoryCode> e;
    private List<? extends CategoryCode> f;
    private final int g;
    private int h;

    /* JADX INFO: renamed from: com.mappls.sdk.category.adapters.a$a, reason: collision with other inner class name */
    public interface InterfaceC0067a {
        void a(List<? extends CategoryCode> list);
    }

    public final class b extends RecyclerView.ViewHolder {
        private final ImageView a;
        private final TextView b;
        private final ImageView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.mappls_category_icon_image_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.m…category_icon_image_view)");
            ImageView imageView = (ImageView) viewFindViewById;
            this.a = imageView;
            View viewFindViewById2 = view.findViewById(R.id.mappls_category_name_text_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.m…_category_name_text_view)");
            TextView textView = (TextView) viewFindViewById2;
            this.b = textView;
            View viewFindViewById3 = view.findViewById(R.id.mappls_category_icon_selected_image_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.m…icon_selected_image_view)");
            ImageView imageView2 = (ImageView) viewFindViewById3;
            this.c = imageView2;
            Integer numIconTintColor = com.mappls.sdk.category.a.d().iconTintColor();
            Intrinsics.checkNotNullExpressionValue(numIconTintColor, "MapplsCategoryWidget.sea…yUIOption.iconTintColor()");
            imageView.setColorFilter(numIconTintColor.intValue(), PorterDuff.Mode.SRC_IN);
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.mappls_category_shape_circle);
            if (drawable != null) {
                Integer numIconTintColor2 = aVar.b.iconTintColor();
                Intrinsics.checkNotNullExpressionValue(numIconTintColor2, "uiOption.iconTintColor()");
                drawable.setColorFilter(new PorterDuffColorFilter(numIconTintColor2.intValue(), PorterDuff.Mode.SRC_IN));
            }
            imageView.setBackground(drawable);
            Integer numIconTintColor3 = aVar.b.iconTintColor();
            Intrinsics.checkNotNullExpressionValue(numIconTintColor3, "uiOption.iconTintColor()");
            imageView2.setColorFilter(numIconTintColor3.intValue(), PorterDuff.Mode.SRC_IN);
            Integer numItemTextColor = aVar.b.itemTextColor();
            Intrinsics.checkNotNullExpressionValue(numItemTextColor, "uiOption.itemTextColor()");
            textView.setTextColor(numItemTextColor.intValue());
        }

        public final ImageView a() {
            return this.a;
        }

        public final TextView b() {
            return this.b;
        }

        public final ImageView c() {
            return this.c;
        }
    }

    public static final class c extends Filter {
        c() {
        }

        @Override // android.widget.Filter
        protected final Filter.FilterResults performFiltering(CharSequence constraint) {
            List list;
            Intrinsics.checkNotNullParameter(constraint, "constraint");
            String string = constraint.toString();
            if (string.length() > 0) {
                a.this.h = 101;
            }
            a aVar = a.this;
            if (string.length() == 0) {
                list = a.this.e;
            } else {
                ArrayList arrayList = new ArrayList();
                for (CategoryCode categoryCode : a.this.e) {
                    String category = categoryCode.getCategory();
                    Boolean boolValueOf = null;
                    if (category != null) {
                        Locale locale = Locale.ROOT;
                        String lowerCase = category.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        if (lowerCase != null) {
                            String lowerCase2 = string.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            boolValueOf = Boolean.valueOf(StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null));
                        }
                    }
                    Intrinsics.checkNotNull(boolValueOf);
                    if (boolValueOf.booleanValue()) {
                        arrayList.add(categoryCode);
                    }
                }
                list = arrayList;
            }
            aVar.f = list;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = a.this.f;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected final void publishResults(CharSequence charSequence, Filter.FilterResults results) {
            Intrinsics.checkNotNullParameter(results, "results");
            a aVar = a.this;
            Object obj = results.values;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<com.mappls.sdk.nearby.plugin.CategoryCode>");
            aVar.f = (ArrayList) obj;
            a.this.d = charSequence == null || charSequence.length() <= 0;
            a.this.notifyDataSetChanged();
        }
    }

    public a(int i, SearchCategoryUIOption uiOption, CategorySearchFragment.b categorySelection) {
        Intrinsics.checkNotNullParameter(uiOption, "uiOption");
        Intrinsics.checkNotNullParameter(categorySelection, "categorySelection");
        this.a = i;
        this.b = uiOption;
        this.c = categorySelection;
        this.d = true;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = 4;
        this.h = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, b holder, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (this$0.getItemViewType(holder.getAdapterPosition()) == 2) {
            this$0.h = this$0.h == 100 ? 101 : 100;
            this$0.notifyDataSetChanged();
            return;
        }
        if (this$0.a == 1) {
            this$0.c.a(CollectionsKt.listOf(this$0.f.get(i)));
            return;
        }
        if (this$0.f.get(holder.getAdapterPosition()).isSelected() || this$0.a().size() <= this$0.a - 1) {
            this$0.f.get(holder.getAdapterPosition()).setSelected(!this$0.f.get(holder.getAdapterPosition()).isSelected());
            this$0.notifyItemChanged(holder.getAdapterPosition());
            return;
        }
        Toast.makeText(holder.itemView.getContext(), "Max " + this$0.a + " categories are allowed", 0).show();
    }

    public final ArrayList a() {
        List<? extends CategoryCode> list = this.f;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CategoryCode) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(final b holder, final int i) {
        ImageView imageViewA;
        int i2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getItemViewType(i) == 2) {
            if (this.h == 100) {
                holder.b().setText("More");
                imageViewA = holder.a();
                i2 = R.drawable.mappls_category_icon_more;
            } else {
                holder.b().setText("Less");
                imageViewA = holder.a();
                i2 = R.drawable.mappls_category_icon_less;
            }
            imageViewA.setImageResource(i2);
            holder.c().setVisibility(8);
            if (this.d) {
                holder.itemView.setVisibility(0);
            } else {
                holder.itemView.setVisibility(8);
            }
        } else {
            CategoryCode categoryCode = this.f.get(i);
            holder.b().setText(categoryCode.getCategory());
            if (categoryCode.getBitmapIcon() != null) {
                holder.a().setImageBitmap(categoryCode.getBitmapIcon());
            } else {
                try {
                    holder.a().setImageResource(categoryCode.getIcon());
                } catch (Exception e) {
                    e.printStackTrace();
                    holder.a().setImageResource(0);
                }
            }
            if (categoryCode.isSelected()) {
                holder.c().setVisibility(0);
            } else {
                holder.c().setVisibility(8);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.category.adapters.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.a(this.f$0, holder, i, view);
            }
        });
    }

    public final void a(List<? extends CategoryCode> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.e = list;
        this.f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.h != 100) {
            return this.f.size() + 1;
        }
        int size = this.f.size();
        int i = this.g;
        return size > i ? i : this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        int i2 = i + 1;
        if (this.h == 100) {
            if (i2 < this.g || i2 != getItemCount()) {
                return 1;
            }
        } else if (i2 < getItemCount()) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mappls_category_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…          false\n        )");
        return new b(this, viewInflate);
    }
}
