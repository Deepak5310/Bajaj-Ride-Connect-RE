package com.bajajconnect.wifi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bajajconnect.R;
import com.bajajconnect.wifi.model.SearchResultModel;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SearchResultAdapter extends ArrayAdapter<SearchResultModel> {
    private int selectedItem;

    public SearchResultAdapter(Context context, ArrayList<SearchResultModel> arrayList) {
        super(context, 0, arrayList);
        this.selectedItem = -1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.search_result_item, viewGroup, false);
        }
        SearchResultModel item = getItem(i);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.base);
        if (i == this.selectedItem) {
            linearLayout.setBackground(getContext().getResources().getDrawable(R.drawable.tft_searchlist_border_bg));
        } else {
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.tft_search_list_background));
        }
        ((TextView) view.findViewById(R.id.place_name)).setText(item.getPlaceName() + StringUtils.SPACE + item.getAddress());
        return view;
    }

    private void highlightItem(int i, View view) {
        if (i == this.selectedItem) {
            view.setBackground(getContext().getResources().getDrawable(R.drawable.tft_searchlist_border_bg));
        } else {
            view.setBackgroundColor(getContext().getResources().getColor(R.color.tft_search_list_background));
        }
    }

    public void setSelectedItem(int i) {
        this.selectedItem = i;
    }
}
