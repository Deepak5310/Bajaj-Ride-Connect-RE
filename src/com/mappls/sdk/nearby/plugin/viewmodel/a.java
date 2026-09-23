package com.mappls.sdk.nearby.plugin.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements OnResponseCallback<NearbyAtlasResponse> {
    final /* synthetic */ b a;

    a(b bVar) {
        this.a = bVar;
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onError(int i, String str) {
        MutableLiveData<com.mappls.sdk.nearby.plugin.util.d<NearbyAtlasResponse>> mutableLiveDataC;
        String str2;
        if (i == 1) {
            mutableLiveDataC = this.a.c();
            str2 = "No Internet Connection";
        } else if (i != 204) {
            mutableLiveDataC = this.a.c();
            str2 = "Something went wrong";
        } else {
            mutableLiveDataC = this.a.c();
            str2 = "No result found";
        }
        mutableLiveDataC.setValue(com.mappls.sdk.nearby.plugin.util.d.a.a(str2, null));
        Timber.e(str, new Object[0]);
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onSuccess(NearbyAtlasResponse nearbyAtlasResponse) {
        this.a.c().setValue(com.mappls.sdk.nearby.plugin.util.d.a.a(nearbyAtlasResponse));
    }
}
