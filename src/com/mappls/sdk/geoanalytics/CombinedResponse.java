package com.mappls.sdk.geoanalytics;

import java.util.List;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes6.dex */
class CombinedResponse {
    private List<ResponseBody> responseBodies;

    public CombinedResponse(List<ResponseBody> list) {
        this.responseBodies = list;
    }

    public List<ResponseBody> getResponseBodies() {
        return this.responseBodies;
    }
}
