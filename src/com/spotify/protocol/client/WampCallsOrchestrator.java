package com.spotify.protocol.client;

import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.Types;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class WampCallsOrchestrator {
    private final AtomicInteger mIdGenerator = new AtomicInteger(0);
    private final Map<Types.RequestId, CallRecord<?>> mCallsMap = new ConcurrentHashMap();
    private final Map<Types.RequestId, SubscriptionRecord<?>> mSubscriptionsMap = new ConcurrentHashMap();
    private final Map<Types.SubscriptionId, Types.RequestId> mSubscriptionIdToRequestId = new ConcurrentHashMap();

    static class CallRecord<T> {
        final CallResult<T> mCallResult;
        final Types.RequestId mId;
        private final Class<T> mType;

        CallRecord(Types.RequestId requestId, CallResult<T> callResult, Class<T> cls) {
            this.mType = cls;
            this.mId = (Types.RequestId) Coding.checkNotNull(requestId);
            this.mCallResult = (CallResult) Coding.checkNotNull(callResult);
        }

        public void deliverResultWithPayload(JsonObject jsonObject) {
            try {
                this.mCallResult.deliverResult(ResultUtils.createSuccessfulResult(jsonObject.getAs(this.mType)));
            } catch (Exception e) {
                this.mCallResult.deliverError(e);
            }
        }

        public int hashCode() {
            return this.mId.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof CallRecord) {
                return this.mId.equals(((CallRecord) obj).mId);
            }
            return false;
        }
    }

    static class SubscriptionRecord<T> {
        final Class<T> mEventType;
        final Types.RequestId mId;
        final Subscription<T> mSubscription;
        Types.SubscriptionId mSubscriptionId = Types.SubscriptionId.NONE;

        SubscriptionRecord(Types.RequestId requestId, Subscription<T> subscription, Class<T> cls) {
            this.mEventType = cls;
            this.mId = (Types.RequestId) Coding.checkNotNull(requestId);
            this.mSubscription = (Subscription) Coding.checkNotNull(subscription);
        }

        public void deliverEventWithPayload(JsonObject jsonObject) {
            try {
                this.mSubscription.deliverResult(ResultUtils.createSuccessfulResult(jsonObject.getAs(this.mEventType)));
            } catch (Exception e) {
                this.mSubscription.deliverError(e);
            }
        }

        public int hashCode() {
            return this.mId.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof SubscriptionRecord) {
                return this.mId.equals(((SubscriptionRecord) obj).mId);
            }
            return false;
        }
    }

    Types.RequestId getNextRequestId() {
        return Types.RequestId.from(this.mIdGenerator.getAndIncrement());
    }

    <T> CallRecord<T> newCall(Class<T> cls) {
        Types.RequestId nextRequestId = getNextRequestId();
        CallRecord<T> callRecord = new CallRecord<>(nextRequestId, new CallResult(nextRequestId), cls);
        this.mCallsMap.put(callRecord.mId, callRecord);
        return callRecord;
    }

    <T> SubscriptionRecord<T> newSubscription(RemoteWampClient remoteWampClient, Class<T> cls) {
        Types.RequestId nextRequestId = getNextRequestId();
        SubscriptionRecord<T> subscriptionRecord = new SubscriptionRecord<>(nextRequestId, new Subscription(nextRequestId, remoteWampClient), cls);
        this.mSubscriptionsMap.put(subscriptionRecord.mId, subscriptionRecord);
        return subscriptionRecord;
    }

    SubscriptionRecord<?> findSubscriptionByRequestId(Types.RequestId requestId) {
        return this.mSubscriptionsMap.get(requestId);
    }

    @Nullable
    SubscriptionRecord<?> findSubscriptionById(Types.SubscriptionId subscriptionId) {
        Types.RequestId requestId = this.mSubscriptionIdToRequestId.get(subscriptionId);
        if (requestId != null) {
            return findSubscriptionByRequestId(requestId);
        }
        return null;
    }

    void onSubscriptionIdReceived(Types.RequestId requestId, Types.SubscriptionId subscriptionId) {
        this.mSubscriptionIdToRequestId.put(subscriptionId, requestId);
        SubscriptionRecord<?> subscriptionRecordFindSubscriptionByRequestId = findSubscriptionByRequestId(requestId);
        if (subscriptionRecordFindSubscriptionByRequestId != null) {
            subscriptionRecordFindSubscriptionByRequestId.mSubscriptionId = subscriptionId;
            return;
        }
        String str = String.format("Cannot find a subscription record for [%s]", requestId);
        Debug.e(str, new Object[0]);
        Debug.assertTrue(false, str);
    }

    CallRecord<?> findCallById(Types.RequestId requestId) {
        return this.mCallsMap.get(requestId);
    }

    void removeCall(Types.RequestId requestId) {
        this.mCallsMap.remove(requestId);
    }

    void removeSubscription(Types.SubscriptionId subscriptionId) {
        this.mSubscriptionsMap.remove(this.mSubscriptionIdToRequestId.remove(subscriptionId));
    }

    void removeSubscriptionByRequestId(Types.RequestId requestId) {
        this.mSubscriptionsMap.remove(requestId);
    }
}
