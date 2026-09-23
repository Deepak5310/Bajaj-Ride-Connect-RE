package com.mappls.sdk.navigation.ui.navigation.finished;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends RecyclerView.ViewHolder {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final View d;

    public d(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.heading_text_view);
        TextView textView = (TextView) view.findViewById(R.id.value_text_view);
        this.b = textView;
        this.c = (ImageView) view.findViewById(R.id.image_view_logo);
        this.d = view.findViewById(R.id.view_color);
        ((LinearLayout) view.findViewById(R.id.nav_finished_item_layout)).setBackgroundColor(com.mappls.sdk.navigation.ui.theme.a.b(view.getContext(), R.attr.navigationViewPrimary));
        textView.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(view.getContext(), R.attr.navigationTextColorPrimary));
    }
}
