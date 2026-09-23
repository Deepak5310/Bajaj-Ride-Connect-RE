package com.mappls.sdk.nearby.plugin.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements OnResponseCallback<NearbyAtlasResponse> {
    final /* synthetic */ d a;

    c(d dVar) {
        this.a = dVar;
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onError(int i, String str) {
        MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> mutableLiveDataD;
        String str2;
        if (i == 1) {
            mutableLiveDataD = this.a.d();
            str2 = "No Internet Connection";
        } else if (i != 204) {
            mutableLiveDataD = this.a.d();
            str2 = "Something went wrong";
        } else {
            mutableLiveDataD = this.a.d();
            str2 = "No result found";
        }
        mutableLiveDataD.setValue(com.mappls.sdk.nearby.plugin.util.d.a.a(str2, null));
        Timber.e(str, new Object[0]);
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onSuccess(NearbyAtlasResponse nearbyAtlasResponse) {
        this.a.d().setValue(com.mappls.sdk.nearby.plugin.util.d.a.a(nearbyAtlasResponse));
    }
}
