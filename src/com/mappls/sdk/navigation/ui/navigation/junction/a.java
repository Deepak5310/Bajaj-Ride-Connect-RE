package com.mappls.sdk.navigation.ui.navigation.junction;

import android.graphics.Bitmap;
import com.mappls.sdk.navigation.iface.JunctionInfoChangedListener;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.ui.utils.d;
import com.mappls.sdk.plugin.directions.DirectionFormatter;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements JunctionInfoChangedListener {
    public final /* synthetic */ JunctionView a;

    public a(JunctionView junctionView) {
        this.a = junctionView;
    }

    @Override // com.mappls.sdk.navigation.iface.JunctionInfoChangedListener
    public final void junctionInfoChanged(Junction junction) {
        if (junction == null) {
            this.a.setVisibility(4);
            return;
        }
        Bitmap bitmap = junction.bitmap;
        if (bitmap == null) {
            this.a.setVisibility(4);
            return;
        }
        this.a.mBinding.ivJunctionImage.setImageBitmap(bitmap);
        this.a.mBinding.tvJunctionLeftDistance.setText(DirectionFormatter.getFormattedDistanceRound((float) junction.getLeftDistance(), d.a()));
        this.a.setVisibility(0);
    }
}
