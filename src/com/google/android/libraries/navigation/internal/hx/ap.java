package com.google.android.libraries.navigation.internal.hx;

import android.os.Looper;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.metrics.resource.ResourceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public enum ap implements com.google.android.libraries.navigation.internal.ws.c {
    UI_THREAD("main", 0, 2),
    LIGHTWEIGHT_THREADPOOL("Lite", 0, 0, 0),
    GMM_PICKER("Picker", 0, 0, 3),
    SCHEDULER("Scheduler", 0, 0, 1),
    LABELING_THREAD("Labeling", 1),
    TILE_PREP_THREADPOOL("TilePrep", 1, 0, 0),
    LOCATION_FRESHNESS_WAITING_THREADPOOL("LocFresh", 2, 0, 2),
    NETWORK_THREADPOOL(ResourceType.NETWORK, 2, 0, 5),
    LOCATION_SENSORS("Sensors", 2, 2),
    LOCATION_DISPATCHER(HttpHeaders.LOCATION, 4),
    MID_PRIORITY_THREADPOOL("MidPri", 4, 0, 0),
    SUGGEST_CALLBACK_THREAD("SuggestCallback", 4),
    ALERT_CONTROLLER("AlertController", 10),
    BACKGROUND_THREADPOOL("Background", 10, 0, 0),
    BLOCKING_THREADPOOL("Blocking", 10, 0, Integer.MAX_VALUE),
    DOWNLOADER_THREADPOOL("Download", 10, 0, 3),
    NAVIGATION_INTERNAL("NavInternal", 10),
    NAV_STATE_THREAD("NavState", 10),
    LOCATION_TILE_PREP("LocTilePrep", 4, MID_PRIORITY_THREADPOOL),
    NETWORK_TTS_SYNTHESIS("NetworkTTS", 10, 8),
    OFFLINE_DYNAMIC_THREAD("OfflineDynamic", 10),
    OFFLINE_REGION_MANAGEMENT("OfflineManage", 10),
    OFFLINE_REGION_PROCESSING_THREADPOOL("OfflinePr", 10, 0, 2),
    PREWARM_GMM_ACTIVITY("PrewarmActivity", 10),
    ROAD_GRAPH_TILE_PREP_THREADPOOL("RoadGraph", 10),
    GMM_STORAGE("Storage", 10),
    PROTO_DATA_STORE("ProtoDataStore", 10, 0, 16, BACKGROUND_THREADPOOL),
    WEARABLE_DATA("WearableData", 10, BACKGROUND_THREADPOOL),
    MEMORY_MONITOR("MemoryMon", 13, BACKGROUND_THREADPOOL),
    NETWORK_MONITOR("NetworkMon", 16, BACKGROUND_THREADPOOL),
    BATTERY_MONITOR("BatteryMon", 16, BACKGROUND_THREADPOOL),
    LOW_PRIORITY_BACKGROUND_THREADPOOL("LowPri", 15, 0, 0),
    NATIVE_LIBRARY_LOADER("NativeLibLoader", 19),
    NATIVE_LIBRARY_LOADER_HIGH("NativeLoaderHi", 0),
    CURRENT("Current", -1),
    DANGEROUS_PUBLISHER_THREAD("Unspecified", -1);

    public static volatile am K;
    public static final ThreadLocal L = new ThreadLocal() { // from class: com.google.android.libraries.navigation.internal.hx.al
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Object initialValue() {
            return new ArrayList();
        }
    };
    public final int M;
    public final String N;
    public final com.google.android.libraries.navigation.internal.xn.a O;
    private final int Q;
    private final int R;
    private final ap S;

    ap(String str, int i) {
        this(str, i, 0, 1);
    }

    public static ap c() {
        Object objCurrentThread = Thread.currentThread();
        if (objCurrentThread == Looper.getMainLooper().getThread()) {
            return UI_THREAD;
        }
        if (objCurrentThread instanceof ao) {
            return ((ao) objCurrentThread).a();
        }
        return null;
    }

    static void h(an anVar) {
        List list = (List) L.get();
        int size = list.size() - 1;
        ar.a(anVar == list.get(size));
        list.remove(size);
    }

    public static boolean i(ap apVar) {
        if (apVar == CURRENT || apVar == c()) {
            return true;
        }
        ap apVarD = apVar.d();
        if (apVarD == null || !i(apVarD)) {
            return false;
        }
        Iterator it2 = ((List) L.get()).iterator();
        while (it2.hasNext()) {
            if (apVar == ((an) it2.next()).q()) {
                return true;
            }
        }
        return false;
    }

    public final int a() {
        am amVar = K;
        if (amVar == null) {
            return this.R;
        }
        int i = this.R;
        if (i != 0) {
            return i;
        }
        int iOrdinal = ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 5) {
                return ak.a <= 4 ? 1 : 3;
            }
            if (iOrdinal != 10) {
                if (iOrdinal == 13) {
                    return ak.b;
                }
                if (iOrdinal == 31) {
                    return Math.min(ak.a, true != ((ak) amVar).e ? 3 : 1);
                }
                throw new IllegalArgumentException("CALCULATED not implemented for ".concat(toString()));
            }
        }
        return Math.max(2, ak.a - 2);
    }

    public final int b() {
        if (K == null) {
            return this.Q;
        }
        int i = this.Q;
        if (this != LOCATION_DISPATCHER) {
            return i;
        }
        com.google.android.libraries.navigation.internal.iy.a aVar = com.google.android.libraries.navigation.internal.iy.a.a;
        return i;
    }

    public final ap d() {
        if (K == null) {
            return this.S;
        }
        ap apVar = this.S;
        if (this == GMM_STORAGE) {
            com.google.android.libraries.navigation.internal.iy.a aVar = com.google.android.libraries.navigation.internal.iy.a.a;
        }
        if (this == NETWORK_THREADPOOL) {
            com.google.android.libraries.navigation.internal.iy.a aVar2 = com.google.android.libraries.navigation.internal.iy.a.a;
        }
        if (this == PROTO_DATA_STORE) {
            com.google.android.libraries.navigation.internal.iy.a aVar3 = com.google.android.libraries.navigation.internal.iy.a.a;
        }
        if (this == BACKGROUND_THREADPOOL) {
            return apVar;
        }
        b();
        return apVar;
    }

    @Deprecated
    public final void e() {
        g(false);
    }

    @Override // com.google.android.libraries.navigation.internal.ws.c
    @Deprecated
    public final void f() {
        g(true);
    }

    final void g(boolean z) {
        if (i(this) != z) {
            String string = toString();
            String strValueOf = String.valueOf(c());
            String strValueOf2 = String.valueOf(Thread.currentThread());
            StringBuilder sb = new StringBuilder();
            sb.append(true != z ? "Should not" : "Should");
            sb.append(" be running on ");
            sb.append(string);
            sb.append(", but we're on ");
            sb.append(strValueOf);
            sb.append(" (Java Thread ");
            sb.append(strValueOf2);
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
    }

    public final boolean j() {
        int i = this.R;
        return i > 1 || i == 0;
    }

    ap(String str, int i, int i2) {
        this(str, i, i2, 1);
    }

    ap(String str, int i, int i2, int i3) {
        this(str, i, i2, i3, null);
    }

    ap(String str, int i, int i2, int i3, ap apVar) {
        boolean z;
        this.M = i2;
        ah.a(str, null);
        this.N = str;
        this.O = com.google.android.libraries.navigation.internal.xn.a.d(str);
        this.Q = i;
        this.R = i3;
        this.S = apVar;
        int i4 = i2 & 2;
        if (i4 == 0) {
            z = true;
        } else if (i3 == 1) {
            z = true;
            i3 = 1;
        } else {
            z = false;
        }
        ar.a(z);
        ar.a(apVar == null || i3 != 0);
        ar.a(apVar == null || i4 == 0);
    }

    ap(String str, int i, ap apVar) {
        this(str, i, 0, 1, apVar);
    }
}
