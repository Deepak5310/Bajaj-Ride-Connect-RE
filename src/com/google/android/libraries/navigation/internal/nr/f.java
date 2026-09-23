package com.google.android.libraries.navigation.internal.nr;

import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.google.android.libraries.navigation.internal.nk.r;
import com.google.android.libraries.navigation.internal.nk.s;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static final j b = j.e("com.google.android.libraries.navigation.internal.nr.f");
    public final JSONObject a;

    public f(com.google.android.libraries.navigation.internal.afo.a aVar) {
        JSONObject jSONObject;
        if ((((s) aVar.a()).a().b & 1) != 0) {
            r rVar = ((s) aVar.a()).a().c;
            String str = (rVar == null ? r.a : rVar).e;
            jSONObject = null;
            if (!str.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F(LeicaMakernoteDirectory.TAG_WB_GREEN_LEVEL)).s("QUIC connection settings in networkParameters is invalid JSON string: %s", str);
                }
            }
            jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("idle_connection_timeout_seconds", 300);
                jSONObject2.put("migrate_sessions_on_network_change_v2", true);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject.has(next)) {
                        jSONObject.put(next, jSONObject2.get(next));
                    }
                }
            } catch (JSONException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) j.b.F((char) 802)).p("Failed to create default QUIC settings, using empty");
            }
        } else {
            jSONObject = new JSONObject();
        }
        this.a = jSONObject;
    }
}
