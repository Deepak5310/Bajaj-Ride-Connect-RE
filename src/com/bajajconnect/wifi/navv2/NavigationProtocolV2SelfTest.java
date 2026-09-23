package com.bajajconnect.wifi.navv2;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class NavigationProtocolV2SelfTest {
    private static final String TAG = "NavV2SelfTest";
    private static final double TEST_LAT = 18.5204d;
    private static final double TEST_LNG = 73.8567d;

    public interface ResultCallback {
        void onComplete(JSONObject jSONObject);
    }

    private NavigationProtocolV2SelfTest() {
    }

    public static void runPoiFlow(Context context, final boolean z, final ResultCallback resultCallback) {
        new Thread(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationProtocolV2SelfTest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NavigationProtocolV2SelfTest.lambda$runPoiFlow$0(resultCallback, z);
            }
        }, "nav-v2-self-test").start();
    }

    static /* synthetic */ void lambda$runPoiFlow$0(ResultCallback resultCallback, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startedAt", System.currentTimeMillis());
            String str = BleFeatures.getInstance().modelCode;
            Double d = MirroringGlobarVar.currentLat;
            Double d2 = MirroringGlobarVar.currentLng;
            if (!NavigationProtocolV2Handler.isEnabledForCurrentSku()) {
                BleFeatures.getInstance().setModelCode("00JR54ZZ");
                jSONObject.put("skuForced", "00JR54ZZ");
            }
            jSONObject.put("sku", BleFeatures.getInstance().modelCode);
            jSONObject.put("poiEnabled", NavigationProtocolV2Handler.isEnabledForCurrentSku());
            MirroringGlobarVar.currentLat = Double.valueOf(TEST_LAT);
            MirroringGlobarVar.currentLng = Double.valueOf(TEST_LNG);
            jSONObject.put("originLat", TEST_LAT);
            jSONObject.put("originLng", TEST_LNG);
            CapturingSender capturingSender = new CapturingSender();
            if (NavigationProtocolV2Handler.getInstance().isClusterSessionActive()) {
                jSONObject.put("ok", false);
                jSONObject.put("error", "Cluster TCP session active — refuse self-test to avoid POI response races");
                restore(str, d, d2);
                resultCallback.onComplete(jSONObject);
                return;
            }
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(7, new byte[]{0, 0, 5, 5}, capturingSender);
            JSONObject listResponse = parseListResponse(capturingSender.awaitFrame(45L, TimeUnit.SECONDS));
            jSONObject.put("getPoiList", listResponse);
            if (listResponse.optInt("count", 0) <= 0) {
                jSONObject.put("ok", false);
                jSONObject.put("error", "GET_POI_LIST returned 0 results (check API key / network / location)");
                restore(str, d, d2);
                resultCallback.onComplete(jSONObject);
                return;
            }
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(8, new byte[]{0}, capturingSender);
            jSONObject.put("getPoiDetail", parseDetailResponse(capturingSender.awaitFrame(30L, TimeUnit.SECONDS)));
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(12, new byte[]{0, 0}, capturingSender);
            jSONObject.put("getRoutePreview", parseRoutePreviewResponse(capturingSender.awaitFrame(30L, TimeUnit.SECONDS)));
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(14, new byte[0], capturingSender);
            jSONObject.put("getRoutePreference", parsePreferenceResponse(capturingSender.awaitFrame(5L, TimeUnit.SECONDS)));
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(13, new byte[]{Ascii.CR, 0, 0, 0}, capturingSender);
            jSONObject.put("setRoutePreference", parseAckResponse(capturingSender.awaitFrame(5L, TimeUnit.SECONDS)));
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(9, new byte[0], capturingSender);
            jSONObject.put("getFavourites", parseListResponse(capturingSender.awaitFrame(5L, TimeUnit.SECONDS)));
            capturingSender.reset(1);
            NavigationProtocolV2Handler.getInstance().handle(10, new byte[0], capturingSender);
            jSONObject.put("getRecentTrips", parseListResponse(capturingSender.awaitFrame(5L, TimeUnit.SECONDS)));
            if (z) {
                capturingSender.reset(1);
                NavigationProtocolV2Handler.getInstance().handle(15, new byte[]{0, 0}, capturingSender);
                jSONObject.put("startNavigation", parseNavStatusResponse(capturingSender.awaitFrame(45L, TimeUnit.SECONDS)));
            } else {
                jSONObject.put("startNavigation", "skipped");
            }
            jSONObject.put("ok", true);
            restore(str, d, d2);
            Log.i(TAG, "self-test complete: " + jSONObject);
            resultCallback.onComplete(jSONObject);
        } catch (Exception e) {
            Log.e(TAG, "self-test failed", e);
            try {
                jSONObject.put("ok", false);
                jSONObject.put("error", e.getMessage() != null ? e.getMessage() : e.toString());
            } catch (Exception unused) {
            }
            resultCallback.onComplete(jSONObject);
        }
    }

    private static void restore(String str, Double d, Double d2) {
        if (str != null) {
            BleFeatures.getInstance().setModelCode(str);
        }
        MirroringGlobarVar.currentLat = d;
        MirroringGlobarVar.currentLng = d2;
    }

    private static JSONObject parseListResponse(byte[] bArr) throws Exception {
        String str;
        int i;
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            jSONObject.put("error", "timeout / no response");
            return jSONObject;
        }
        jSONObject.put("frameHex", toHex(bArr));
        jSONObject.put("packetType", bArr.length > 0 ? bArr[0] & 255 : -1);
        int i2 = 1;
        jSONObject.put("group", bArr.length > 1 ? bArr[1] & 255 : -1);
        jSONObject.put("command", bArr.length > 2 ? bArr[2] & 255 : -1);
        byte[] bArrPayloadOf = payloadOf(bArr);
        if (bArrPayloadOf.length == 0) {
            jSONObject.put("count", 0);
            jSONObject.put("names", new JSONArray());
            return jSONObject;
        }
        int i3 = bArrPayloadOf[0] & 255;
        jSONObject.put("count", i3);
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + 1;
            if (i5 >= bArrPayloadOf.length) {
                break;
            }
            int i6 = bArrPayloadOf[i2] & 255;
            int i7 = bArrPayloadOf[i5] & 255;
            i2 += 2;
            if (i7 > 0 && (i = i2 + i7) <= bArrPayloadOf.length) {
                str = new String(bArrPayloadOf, i2, i7, StandardCharsets.UTF_8);
                i2 = i;
            } else {
                str = "";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.Param.INDEX, i6);
            jSONObject2.put("name", str);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("names", jSONArray);
        return jSONObject;
    }

    private static JSONObject parseDetailResponse(byte[] bArr) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            jSONObject.put("error", "timeout / no response");
            return jSONObject;
        }
        jSONObject.put("frameHex", toHex(bArr));
        byte[] bArrPayloadOf = payloadOf(bArr);
        if (bArrPayloadOf.length < 1) {
            jSONObject.put("error", "empty payload");
            return jSONObject;
        }
        jSONObject.put(FirebaseAnalytics.Param.INDEX, bArrPayloadOf[0] & 255);
        String[] threeLengthPrefixed = readThreeLengthPrefixed(bArrPayloadOf, 1);
        jSONObject.put("name", threeLengthPrefixed[0]);
        jSONObject.put(DirectionsCriteria.ANNOTATION_DISTANCE, threeLengthPrefixed[1]);
        jSONObject.put("eta", threeLengthPrefixed[2]);
        return jSONObject;
    }

    private static JSONObject parseRoutePreviewResponse(byte[] bArr) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            jSONObject.put("error", "timeout / no response");
            return jSONObject;
        }
        jSONObject.put("frameHex", toHex(bArr));
        byte[] bArrPayloadOf = payloadOf(bArr);
        if (bArrPayloadOf.length < 3) {
            jSONObject.put("error", "short payload");
            return jSONObject;
        }
        jSONObject.put("source", bArrPayloadOf[0] & 255);
        jSONObject.put(FirebaseAnalytics.Param.INDEX, bArrPayloadOf[1] & 255);
        jSONObject.put("routeMode", bArrPayloadOf[2] & 255);
        String[] threeLengthPrefixed = readThreeLengthPrefixed(bArrPayloadOf, 3);
        jSONObject.put(DirectionsCriteria.ANNOTATION_DISTANCE, threeLengthPrefixed[0]);
        jSONObject.put("eta", threeLengthPrefixed[1]);
        return jSONObject;
    }

    private static JSONObject parsePreferenceResponse(byte[] bArr) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            jSONObject.put("error", "timeout / no response");
            return jSONObject;
        }
        jSONObject.put("frameHex", toHex(bArr));
        byte[] bArrPayloadOf = payloadOf(bArr);
        if (bArrPayloadOf.length >= 4) {
            jSONObject.put("bitmask", String.format(Locale.US, "0x%02X", Integer.valueOf(bArrPayloadOf[0] & 255)));
            jSONObject.put("routeMode", bArrPayloadOf[1] & 255);
            jSONObject.put("units", bArrPayloadOf[2] & 255);
            jSONObject.put("reserved", bArrPayloadOf[3] & 255);
        }
        return jSONObject;
    }

    private static JSONObject parseAckResponse(byte[] bArr) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            jSONObject.put("error", "timeout / no response");
            return jSONObject;
        }
        jSONObject.put("frameHex", toHex(bArr));
        byte[] bArrPayloadOf = payloadOf(bArr);
        boolean z = false;
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, bArrPayloadOf.length > 0 ? bArrPayloadOf[0] & 255 : -1);
        if (bArrPayloadOf.length > 0 && (bArrPayloadOf[0] & 255) == 0) {
            z = true;
        }
        jSONObject.put(FirebaseAnalytics.Param.SUCCESS, z);
        return jSONObject;
    }

    private static JSONObject parseNavStatusResponse(byte[] bArr) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            jSONObject.put("error", "timeout / no response");
            return jSONObject;
        }
        jSONObject.put("frameHex", toHex(bArr));
        byte[] bArrPayloadOf = payloadOf(bArr);
        if (bArrPayloadOf.length < 1) {
            jSONObject.put("error", "empty payload");
            return jSONObject;
        }
        jSONObject.put("navStatus", bArrPayloadOf[0] & 255);
        jSONObject.put("eta", readThreeLengthPrefixed(bArrPayloadOf, 1)[0]);
        return jSONObject;
    }

    private static String[] readThreeLengthPrefixed(byte[] bArr, int i) {
        int i2;
        String[] strArr = new String[3];
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "";
        for (int i3 = 0; i3 < 3 && i < bArr.length; i3++) {
            int i4 = i + 1;
            int i5 = bArr[i] & 255;
            if (i5 <= 0 || (i2 = i4 + i5) > bArr.length) {
                i = i4;
            } else {
                strArr[i3] = new String(bArr, i4, i5, StandardCharsets.UTF_8);
                i = i2;
            }
        }
        return strArr;
    }

    private static byte[] payloadOf(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            return new byte[0];
        }
        int iMin = Math.min(((bArr[3] & 255) << 8) | (bArr[4] & 255), bArr.length - 5);
        if (iMin <= 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[iMin];
        System.arraycopy(bArr, 5, bArr2, 0, iMin);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        for (byte b : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b)));
        }
        return sb.toString().trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CapturingSender implements NavigationProtocolV2Handler.FrameSender {
        private final List<byte[]> frames;
        private CountDownLatch latch;
        private final Object lock;

        private CapturingSender() {
            this.lock = new Object();
            this.frames = new ArrayList();
            this.latch = new CountDownLatch(1);
        }

        void reset(int i) {
            synchronized (this.lock) {
                this.frames.clear();
                this.latch = new CountDownLatch(Math.max(1, i));
            }
        }

        @Override // com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler.FrameSender
        public void send(byte[] bArr) {
            synchronized (this.lock) {
                this.frames.add(bArr != null ? (byte[]) bArr.clone() : new byte[0]);
                this.latch.countDown();
            }
            Log.i(NavigationProtocolV2SelfTest.TAG, "captured TX " + NavigationProtocolV2SelfTest.toHex(bArr));
        }

        byte[] awaitFrame(long j, TimeUnit timeUnit) throws InterruptedException {
            byte[] bArr = null;
            if (!this.latch.await(j, timeUnit)) {
                return null;
            }
            synchronized (this.lock) {
                if (!this.frames.isEmpty()) {
                    bArr = this.frames.get(0);
                }
            }
            return bArr;
        }
    }
}
