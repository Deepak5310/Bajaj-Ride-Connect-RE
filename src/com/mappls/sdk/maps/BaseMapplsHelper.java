package com.mappls.sdk.maps;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BaseMapplsHelper {
    void getAnnotation(String str, final CoordinateCallback coordinateCallback) {
        MapplsPinHelper.getInstance().getAnnotation(str, new CoordinateCallback() { // from class: com.mappls.sdk.maps.BaseMapplsHelper.1
            @Override // com.mappls.sdk.maps.CoordinateCallback
            public void coordinateResultSuccess(List<CoordinateResult> list) {
                coordinateCallback.coordinateResultSuccess(list);
            }

            @Override // com.mappls.sdk.maps.CoordinateCallback
            public void onFailure() {
                coordinateCallback.onFailure();
            }
        });
    }

    void getAnnotation(List<String> list, final CoordinateCallback coordinateCallback) {
        MapplsPinHelper.getInstance().getAnnotation(list, new CoordinateCallback() { // from class: com.mappls.sdk.maps.BaseMapplsHelper.2
            @Override // com.mappls.sdk.maps.CoordinateCallback
            public void coordinateResultSuccess(List<CoordinateResult> list2) {
                coordinateCallback.coordinateResultSuccess(list2);
            }

            @Override // com.mappls.sdk.maps.CoordinateCallback
            public void onFailure() {
                coordinateCallback.onFailure();
            }
        });
    }
}
