package com.spotify.protocol.client;

import com.spotify.protocol.WampClient;
import com.spotify.protocol.client.error.RemoteClientException;
import com.spotify.protocol.error.SpotifyAppRemoteException;
import com.spotify.protocol.mappers.JsonMappingException;
import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.Types;

/* JADX INFO: loaded from: classes4.dex */
public class RemoteWampClient implements RemoteClient {
    private final AppProtocolCommunicator mCommunicator;
    private volatile Types.RequestId mHelloRecordId;
    private OnConnectionTerminatedListener mOnConnectionTerminatedListener;
    private final WampClient.Receiver mReceiver;
    private final WampCallsOrchestrator mWampCallsOrchestrator;

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteClientException getRemoteClientException(JsonObject jsonObject, String str) {
        String json;
        try {
            json = jsonObject.toJson();
        } catch (JsonMappingException e) {
            json = String.format("Could not parse error details: %s", e.getMessage());
        }
        return new RemoteClientException(json, str);
    }

    public RemoteWampClient(AppProtocolCommunicator appProtocolCommunicator, WampCallsOrchestrator wampCallsOrchestrator) {
        WampClient.Receiver receiver = new WampClient.Receiver() { // from class: com.spotify.protocol.client.RemoteWampClient.1
            @Override // com.spotify.protocol.WampClient.Receiver
            public void onUnsubscribed(Types.RequestId requestId) {
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onUnubscribeError(Types.RequestId requestId, JsonObject jsonObject, String str) {
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onWelcome(int i, JsonObject jsonObject) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(RemoteWampClient.this.mHelloRecordId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(RemoteWampClient.this.mHelloRecordId);
                    callRecordFindCallById.deliverResultWithPayload(jsonObject);
                }
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onAbort(JsonObject jsonObject, String str) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(RemoteWampClient.this.mHelloRecordId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(RemoteWampClient.this.mHelloRecordId);
                    callRecordFindCallById.mCallResult.deliverError(RemoteWampClient.this.getRemoteClientException(jsonObject, str));
                }
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onGoodbye(JsonObject jsonObject, String str) {
                if (!"wamp.error.system_shutdown".equals(str) || RemoteWampClient.this.mOnConnectionTerminatedListener == null) {
                    return;
                }
                RemoteWampClient.this.mOnConnectionTerminatedListener.onConnectionTerminated();
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onSubscribed(Types.RequestId requestId, Types.SubscriptionId subscriptionId) {
                RemoteWampClient.this.mWampCallsOrchestrator.onSubscriptionIdReceived(requestId, subscriptionId);
                Subscription<T> subscription = ((WampCallsOrchestrator.SubscriptionRecord) Coding.checkNotNull(RemoteWampClient.this.mWampCallsOrchestrator.findSubscriptionById(subscriptionId))).mSubscription;
                if (subscription != 0) {
                    subscription.deliverStart();
                }
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onSubscribeError(Types.RequestId requestId, JsonObject jsonObject, String str) {
                Subscription<?> subscription = RemoteWampClient.this.mWampCallsOrchestrator.findSubscriptionByRequestId(requestId).mSubscription;
                if (subscription != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeSubscriptionByRequestId(requestId);
                    subscription.deliverError(RemoteWampClient.this.getRemoteClientException(jsonObject, str));
                }
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onEvent(Types.SubscriptionId subscriptionId, int i, JsonObject jsonObject) {
                WampCallsOrchestrator.SubscriptionRecord<?> subscriptionRecordFindSubscriptionById = RemoteWampClient.this.mWampCallsOrchestrator.findSubscriptionById(subscriptionId);
                if (subscriptionRecordFindSubscriptionById != null) {
                    subscriptionRecordFindSubscriptionById.deliverEventWithPayload(jsonObject);
                }
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onResult(Types.RequestId requestId, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(requestId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(requestId);
                    callRecordFindCallById.deliverResultWithPayload(jsonObject2);
                }
            }

            @Override // com.spotify.protocol.WampClient.Receiver
            public void onError(Types.RequestId requestId, JsonObject jsonObject, String str) {
                WampCallsOrchestrator.CallRecord<?> callRecordFindCallById = RemoteWampClient.this.mWampCallsOrchestrator.findCallById(requestId);
                if (callRecordFindCallById != null) {
                    RemoteWampClient.this.mWampCallsOrchestrator.removeCall(requestId);
                    callRecordFindCallById.mCallResult.deliverError(RemoteWampClient.this.getRemoteClientException(jsonObject, str));
                }
            }
        };
        this.mReceiver = receiver;
        this.mCommunicator = appProtocolCommunicator;
        this.mWampCallsOrchestrator = wampCallsOrchestrator;
        appProtocolCommunicator.setMessageReceiver(receiver);
    }

    public void setOnConnectionTerminatedListener(OnConnectionTerminatedListener onConnectionTerminatedListener) {
        this.mOnConnectionTerminatedListener = onConnectionTerminatedListener;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> CallResult<T> hello(Class<T> cls) {
        WampCallsOrchestrator.CallRecord<T> callRecordNewCall = this.mWampCallsOrchestrator.newCall(cls);
        this.mHelloRecordId = callRecordNewCall.mId;
        try {
            this.mCommunicator.sendHello();
        } catch (SpotifyAppRemoteException e) {
            this.mWampCallsOrchestrator.removeCall(this.mHelloRecordId);
            callRecordNewCall.mCallResult.deliverError(e);
        }
        return callRecordNewCall.mCallResult;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public void goodbye() {
        try {
            this.mCommunicator.sendGoodbye();
        } catch (SpotifyAppRemoteException unused) {
        }
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> CallResult<T> call(String str, Class<T> cls) {
        WampCallsOrchestrator.CallRecord<T> callRecordNewCall = this.mWampCallsOrchestrator.newCall(cls);
        try {
            this.mCommunicator.sendCall(callRecordNewCall.mId.getRaw(), null, str);
        } catch (SpotifyAppRemoteException e) {
            callRecordNewCall.mCallResult.deliverError(e);
        }
        return callRecordNewCall.mCallResult;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> CallResult<T> call(String str, Object obj, Class<T> cls) {
        WampCallsOrchestrator.CallRecord<T> callRecordNewCall = this.mWampCallsOrchestrator.newCall(cls);
        try {
            this.mCommunicator.sendCall(callRecordNewCall.mId.getRaw(), null, str, null, obj);
        } catch (SpotifyAppRemoteException e) {
            callRecordNewCall.mCallResult.deliverError(e);
        }
        return callRecordNewCall.mCallResult;
    }

    @Override // com.spotify.protocol.client.RemoteClient
    public <T> Subscription<T> subscribe(String str, Class<T> cls) {
        WampCallsOrchestrator.SubscriptionRecord<T> subscriptionRecordNewSubscription = this.mWampCallsOrchestrator.newSubscription(this, cls);
        try {
            this.mCommunicator.sendSubscribe(subscriptionRecordNewSubscription.mId.getRaw(), null, str);
        } catch (SpotifyAppRemoteException e) {
            subscriptionRecordNewSubscription.mSubscription.deliverError(e);
        }
        return subscriptionRecordNewSubscription.mSubscription;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0033 A[Catch: SpotifyAppRemoteException -> 0x003d, TRY_LEAVE, TryCatch #0 {SpotifyAppRemoteException -> 0x003d, blocks: (B:4:0x000c, B:6:0x0016, B:7:0x0033), top: B:13:0x000c }] */
    @Override // com.spotify.protocol.client.RemoteClient
    public <T> void unsubscribe(Subscription<T> subscription) {
        WampCallsOrchestrator.SubscriptionRecord<?> subscriptionRecordFindSubscriptionByRequestId = this.mWampCallsOrchestrator.findSubscriptionByRequestId(subscription.getRequestId());
        if (subscriptionRecordFindSubscriptionByRequestId != null) {
            try {
                if (!subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId.equals(Types.SubscriptionId.NONE)) {
                    this.mCommunicator.sendUnsubscribe(this.mWampCallsOrchestrator.getNextRequestId().getRaw(), subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId.getRaw());
                    this.mWampCallsOrchestrator.removeSubscription(subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId);
                } else {
                    Debug.e("Cannot unsubscribe using record: %s", subscriptionRecordFindSubscriptionByRequestId);
                }
            } catch (SpotifyAppRemoteException e) {
                Debug.e(e, "Cannot unsubscribe", new Object[0]);
            }
        } else {
            Debug.e("Cannot unsubscribe using record: %s", subscriptionRecordFindSubscriptionByRequestId);
        }
    }
}
