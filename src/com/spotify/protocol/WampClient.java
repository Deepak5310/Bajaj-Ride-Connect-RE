package com.spotify.protocol;

import com.spotify.protocol.error.SpotifyAppRemoteException;
import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.Types;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface WampClient {
    public static final String ERROR_INVALID_ARGUMENT = "wamp.error.invalid_argument";
    public static final String ERROR_INVALID_URI = "wamp.error.invalid_uri";
    public static final String WAMP_CLIENT_REQUEST_SYSTEM_SHUTDOWN = "wamp.client_request.system_shutdown";
    public static final String WAMP_ERROR = "wamp.error";
    public static final String WAMP_ERROR_SYSTEM_SHUTDOWN = "wamp.error.system_shutdown";

    public interface Receiver {
        void onAbort(JsonObject jsonObject, String str);

        void onError(Types.RequestId requestId, JsonObject jsonObject, String str);

        void onEvent(Types.SubscriptionId subscriptionId, int i, JsonObject jsonObject);

        void onGoodbye(JsonObject jsonObject, String str);

        void onResult(Types.RequestId requestId, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3);

        void onSubscribeError(Types.RequestId requestId, JsonObject jsonObject, String str);

        void onSubscribed(Types.RequestId requestId, Types.SubscriptionId subscriptionId);

        void onUnsubscribed(Types.RequestId requestId);

        void onUnubscribeError(Types.RequestId requestId, JsonObject jsonObject, String str);

        void onWelcome(int i, JsonObject jsonObject);
    }

    public interface RequestType {
        public static final int ABORT = 3;
        public static final int CALL = 48;
        public static final int CANCEL = 49;
        public static final int ERROR = 8;
        public static final int EVENT = 36;
        public static final int GOODBYE = 6;
        public static final int HELLO = 1;
        public static final int RESULT = 50;
        public static final int SUBSCRIBE = 32;
        public static final int SUBSCRIBED = 33;
        public static final int UNSUBSCRIBE = 34;
        public static final int UNSUBSCRIBED = 35;
        public static final int WELCOME = 2;
    }

    public interface Router {
        void addReceiver(Receiver receiver);

        void removeReceiver(Receiver receiver);

        boolean route(WampMessage wampMessage);
    }

    public interface Sender {
        void sendCall(int i, Object obj, String str) throws SpotifyAppRemoteException;

        void sendCall(int i, Object obj, String str, List<Object> list) throws SpotifyAppRemoteException;

        void sendCall(int i, Object obj, String str, List<Object> list, Object obj2) throws SpotifyAppRemoteException;

        void sendCancel(int i, Object obj);

        void sendGoodbye() throws SpotifyAppRemoteException;

        void sendHello() throws SpotifyAppRemoteException;

        void sendSubscribe(int i, Object obj, String str) throws SpotifyAppRemoteException;

        void sendUnsubscribe(int i, int i2) throws SpotifyAppRemoteException;
    }
}
