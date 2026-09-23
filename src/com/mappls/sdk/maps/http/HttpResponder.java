package com.mappls.sdk.maps.http;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpResponder {
    void handleFailure(int i, String str);

    void onResponse(int i, String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr);
}
