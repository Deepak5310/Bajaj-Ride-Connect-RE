package com.google.android.libraries.navigation.internal.nr;

import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.google.android.libraries.navigation.internal.nk.r;
import com.google.android.libraries.navigation.internal.nk.s;
import com.google.android.libraries.navigation.internal.zb.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h {
    private static final j b = j.e("com.google.android.libraries.navigation.internal.nr.h");
    public final JSONObject a;

    public h(com.google.android.libraries.navigation.internal.afo.a aVar) {
        JSONObject jSONObject;
        if ((((s) aVar.a()).a().b & 1) != 0) {
            r rVar = ((s) aVar.a()).a().c;
            String str = (rVar == null ? r.a : rVar).f;
            if (str.isEmpty()) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F(LeicaMakernoteDirectory.TAG_WB_BLUE_LEVEL)).s("Cronet StaleDNS settings in NetworkParameters is invalid JSON string: %s", str);
                    jSONObject = new JSONObject();
                }
            }
        } else {
            jSONObject = new JSONObject();
        }
        this.a = jSONObject;
    }
}
