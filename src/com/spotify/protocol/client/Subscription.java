package com.spotify.protocol.client;

import com.spotify.protocol.types.Types;

/* JADX INFO: loaded from: classes4.dex */
public class Subscription<T> extends PendingResultBase<T> {
    private volatile EventCallback<T> mEventCallback;
    private volatile LifecycleCallback mLifecycleCallback;
    private final RemoteClient mRemoteWampClient;
    private final Types.RequestId mRequestId;

    public interface EventCallback<T> {
        void onEvent(T t);
    }

    public interface LifecycleCallback {
        void onStart();

        void onStop();
    }

    public Subscription(Types.RequestId requestId, RemoteClient remoteClient) {
        this.mRequestId = requestId;
        this.mRemoteWampClient = remoteClient;
    }

    @Override // com.spotify.protocol.client.PendingResultBase
    protected void onResultDelivered() {
        if (isCanceled() || this.mEventCallback == null) {
            return;
        }
        this.mEventCallback.onEvent(this.mRecentResult.getData());
    }

    @Override // com.spotify.protocol.client.PendingResultBase, com.spotify.protocol.client.PendingResult
    public void cancel() {
        if (isCanceled()) {
            return;
        }
        super.cancel();
        this.mRemoteWampClient.unsubscribe(this);
    }

    public Types.RequestId getRequestId() {
        return this.mRequestId;
    }

    public Subscription<T> setEventCallback(EventCallback<T> eventCallback) {
        this.mEventCallback = eventCallback;
        if (this.mRecentResult != null && this.mRecentResult.isSuccessful()) {
            onResultDelivered();
        }
        return this;
    }

    public Subscription<T> setLifecycleCallback(LifecycleCallback lifecycleCallback) {
        this.mLifecycleCallback = lifecycleCallback;
        return this;
    }

    final void deliverStart() {
        if (isCanceled() || this.mLifecycleCallback == null) {
            return;
        }
        this.mLifecycleCallback.onStart();
    }

    final void deliverStop() {
        if (isCanceled() || this.mLifecycleCallback == null) {
            return;
        }
        this.mLifecycleCallback.onStop();
    }
}
