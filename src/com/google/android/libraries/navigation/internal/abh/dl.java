package com.google.android.libraries.navigation.internal.abh;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.MessageFormat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dl extends ArrayAdapter {
    final /* synthetic */ dn a;
    private final be b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public dl(dn dnVar, be beVar, com.google.android.libraries.navigation.internal.abm.ag agVar) {
        super(beVar.a, -1);
        this.a = dnVar;
        this.b = beVar;
        if (agVar.d()) {
            add(new dm(null));
        }
        com.google.android.libraries.navigation.internal.yz.ev evVarB = agVar.b();
        int size = evVarB.size();
        for (int i = 0; i < size; i++) {
            add(new dm((com.google.android.libraries.navigation.internal.abm.ah) evVarB.get(i)));
        }
    }

    private final int a(int i) {
        return Math.round(TypedValue.applyDimension(1, i, this.b.a.getResources().getDisplayMetrics()));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (view == null) {
            relativeLayout = new RelativeLayout(this.b.a);
            relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, a(44)));
        }
        TextView textView = (TextView) relativeLayout.getTag();
        if (textView == null) {
            TextView textView2 = new TextView(this.b.i());
            textView2.setPadding(0, 0, 0, 0);
            textView2.setClickable(false);
            textView2.setTextSize(0, this.b.c() * 18.0f);
            textView2.setTextColor(this.b.d(com.google.android.gms.maps.aj.d));
            textView2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(36));
            layoutParams.addRule(10);
            relativeLayout.addView(textView2, layoutParams);
            relativeLayout.setTag(textView2);
            textView = textView2;
        }
        String strValueOf = String.valueOf(getItem(i));
        textView.setText(strValueOf);
        textView.setContentDescription(MessageFormat.format(this.b.n(com.google.android.gms.maps.am.e), strValueOf));
        if (i == this.a.a) {
            textView.setTextColor(this.b.d(com.google.android.gms.maps.aj.c));
            relativeLayout.setBackgroundDrawable(this.b.l(com.google.android.gms.maps.al.p));
            relativeLayout.destroyDrawingCache();
        } else {
            textView.setTextColor(this.b.d(com.google.android.gms.maps.aj.d));
            if (relativeLayout.getBackground() != null) {
                relativeLayout.setBackgroundDrawable(null);
                relativeLayout.destroyDrawingCache();
            }
        }
        return relativeLayout;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
