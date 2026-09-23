package com.mappls.sdk.maps;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface CoordinateCallback {
    void coordinateResultSuccess(List<CoordinateResult> list);

    void onFailure();
}
