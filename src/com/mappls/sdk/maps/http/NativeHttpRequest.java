package com.mappls.sdk.maps.http;

import com.mappls.sdk.maps.Mappls;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class NativeHttpRequest implements HttpResponder {
    private final HttpRequest httpRequest;
    private final ReentrantLock lock;
    private long nativePtr;

    private native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnResponse(int i, String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr);

    private NativeHttpRequest(long j, String str, String str2, String str3, boolean z) {
        HttpRequest httpRequestCreateHttpRequest = Mappls.getModuleProvider().createHttpRequest();
        this.httpRequest = httpRequestCreateHttpRequest;
        this.lock = new ReentrantLock();
        this.nativePtr = j;
        if (str.startsWith("local://")) {
            executeLocalRequest(str);
        } else {
            httpRequestCreateHttpRequest.executeRequest(this, j, str, str2, str3, z);
        }
    }

    public void cancel() {
        this.httpRequest.cancelRequest();
        this.lock.lock();
        this.nativePtr = 0L;
        this.lock.unlock();
    }

    @Override // com.mappls.sdk.maps.http.HttpResponder
    public void onResponse(int i, String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr) {
        this.lock.lock();
        if (this.nativePtr != 0) {
            nativeOnResponse(i, str, str2, str3, str4, str5, str6, bArr);
        }
        this.lock.unlock();
    }

    private void executeLocalRequest(String str) {
        new LocalRequestTask(new LocalRequestTask.OnLocalRequestResponse() { // from class: com.mappls.sdk.maps.http.NativeHttpRequest.1
            @Override // com.mappls.sdk.maps.http.LocalRequestTask.OnLocalRequestResponse
            public void onResponse(byte[] bArr) {
                if (bArr != null) {
                    NativeHttpRequest.this.lock.lock();
                    if (NativeHttpRequest.this.nativePtr != 0) {
                        NativeHttpRequest.this.nativeOnResponse(200, null, null, null, null, null, null, bArr);
                    }
                    NativeHttpRequest.this.lock.unlock();
                }
            }
        }).execute(str);
    }

    @Override // com.mappls.sdk.maps.http.HttpResponder
    public void handleFailure(int i, String str) {
        this.lock.lock();
        if (this.nativePtr != 0) {
            nativeOnFailure(i, str);
        }
        this.lock.unlock();
    }
}
