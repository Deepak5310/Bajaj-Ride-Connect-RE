package com.mappls.sdk.plugins.places.autocomplete.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.mappls.sdk.plugins.places.R;

/* JADX INFO: loaded from: classes4.dex */
public class ResultCardView extends ResultView {
    public ResultCardView(Context context) {
        this(context, null);
    }

    public ResultCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ResultCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.mappls.sdk.plugins.places.autocomplete.ui.ResultView
    void inflateView(Context context) {
        View.inflate(context, R.layout.mappls_search_view_card_results, this);
    }
}
