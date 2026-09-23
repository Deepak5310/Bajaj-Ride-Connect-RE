package com.mappls.sdk.navigation.ui.navigation.infobar;

import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public final AdviseInfo a;
    public final String b;
    public final String c;
    public final String d;
    public final List e;
    public final int f;
    public final double g;

    public l(AdviseInfo adviseInfo, List list, double d, int i) {
        this.b = DirectionFormatter.getFormattedDistanceRound(adviseInfo.getLeftDistance(), com.mappls.sdk.navigation.ui.utils.d.a());
        this.d = DirectionFormatter.getFormattedDuration(adviseInfo.getLeftTime());
        this.g = d;
        this.c = "Arrival: " + adviseInfo.getEta();
        this.a = adviseInfo;
        this.e = list;
        this.f = i;
    }
}
