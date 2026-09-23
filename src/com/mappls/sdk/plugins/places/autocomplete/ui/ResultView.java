package com.mappls.sdk.plugins.places.autocomplete.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.plugins.places.autocomplete.model.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ResultView extends LinearLayout {
    private b adapter;
    private final List<d> results;

    public ResultView(Context context) {
        this(context, null);
    }

    public ResultView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.results = new ArrayList();
        initialize(context);
    }

    private void initialize(Context context) {
        inflateView(context);
        this.adapter = new b(this.results);
    }

    private void initializeResultList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_search_results);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.addItemDecoration(new a(getContext()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setAdapter(this.adapter);
    }

    public List<d> getResultsList() {
        return this.results;
    }

    void inflateView(Context context) {
        View.inflate(context, R.layout.mappls_search_view_results, this);
    }

    public void notifyDataSetChanged() {
        this.adapter.notifyDataSetChanged();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initializeResultList();
    }

    public void setOnItemClickListener(ResultClickCallback resultClickCallback) {
        b bVar = this.adapter;
        if (bVar != null) {
            bVar.a(resultClickCallback);
        }
    }

    public void setPlaceOption(PlaceOptions placeOptions) {
        b bVar = this.adapter;
        if (bVar != null) {
            bVar.a(placeOptions);
        }
    }
}
