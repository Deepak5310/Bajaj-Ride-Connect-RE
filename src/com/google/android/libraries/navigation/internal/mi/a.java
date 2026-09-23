package com.google.android.libraries.navigation.internal.mi;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import com.google.android.libraries.navigation.internal.zp.c;
import com.google.android.libraries.navigation.internal.zp.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static d a(Context context) {
        List<AccessibilityServiceInfo> arrayList;
        List<AccessibilityServiceInfo> arrayList2;
        com.google.android.libraries.navigation.internal.zp.a aVar = (com.google.android.libraries.navigation.internal.zp.a) d.a.q();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        ContentResolver contentResolver = context.getContentResolver();
        try {
            arrayList = accessibilityManager.getInstalledAccessibilityServiceList();
        } catch (NullPointerException unused) {
            arrayList = new ArrayList<>();
        }
        if (arrayList != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : arrayList) {
                if (accessibilityServiceInfo != null) {
                    c(accessibilityServiceInfo.getId(), aVar, c.c);
                }
            }
        }
        try {
            arrayList2 = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } catch (NullPointerException unused2) {
            arrayList2 = new ArrayList<>();
        }
        if (arrayList2 != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo2 : arrayList2) {
                if (accessibilityServiceInfo2 != null) {
                    c(accessibilityServiceInfo2.getId(), aVar, c.b);
                }
            }
        }
        try {
            int iB = b(Settings.System.getFloat(contentResolver, "font_scale") > 1.0f);
            if (!aVar.b.H()) {
                aVar.v();
            }
            d dVar = (d) aVar.b;
            int i = iB - 1;
            if (iB == 0) {
                throw null;
            }
            dVar.g = i;
            dVar.b |= 16;
            try {
                int iB2 = b(Settings.Secure.getInt(contentResolver, "accessibility_display_magnification_enabled") == 1);
                if (!aVar.b.H()) {
                    aVar.v();
                }
                d dVar2 = (d) aVar.b;
                int i2 = iB2 - 1;
                if (iB2 == 0) {
                    throw null;
                }
                dVar2.h = i2;
                dVar2.b |= 32;
                try {
                    int iB3 = b(Settings.Secure.getInt(contentResolver, "high_text_contrast_enabled") == 1);
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    d dVar3 = (d) aVar.b;
                    int i3 = iB3 - 1;
                    if (iB3 == 0) {
                        throw null;
                    }
                    dVar3.i = i3;
                    dVar3.b |= 64;
                    return (d) aVar.t();
                } catch (Settings.SettingNotFoundException unused3) {
                }
            } catch (Settings.SettingNotFoundException unused4) {
            }
        } catch (Settings.SettingNotFoundException unused5) {
        }
    }

    private static int b(boolean z) {
        return z ? c.b : c.c;
    }

    private static void c(String str, com.google.android.libraries.navigation.internal.zp.a aVar, int i) {
        if (str.startsWith("com.google.") || str.startsWith("com.googlecode.")) {
            if (str.endsWith("TalkBackService")) {
                if (!aVar.b.H()) {
                    aVar.v();
                }
                d dVar = (d) aVar.b;
                d dVar2 = d.a;
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                dVar.c = i2;
                dVar.b |= 1;
                return;
            }
            if (str.endsWith("BrailleBackService")) {
                if (!aVar.b.H()) {
                    aVar.v();
                }
                d dVar3 = (d) aVar.b;
                d dVar4 = d.a;
                int i3 = i - 1;
                if (i == 0) {
                    throw null;
                }
                dVar3.d = i3;
                dVar3.b |= 2;
                return;
            }
            if (str.endsWith("SwitchAccessService") || str.endsWith("SwitchControlService")) {
                if (!aVar.b.H()) {
                    aVar.v();
                }
                d dVar5 = (d) aVar.b;
                d dVar6 = d.a;
                int i4 = i - 1;
                if (i == 0) {
                    throw null;
                }
                dVar5.e = i4;
                dVar5.b |= 4;
                return;
            }
            if (str.endsWith("JustSpeakService") || str.endsWith("VoiceAccessService")) {
                if (!aVar.b.H()) {
                    aVar.v();
                }
                d dVar7 = (d) aVar.b;
                d dVar8 = d.a;
                int i5 = i - 1;
                if (i == 0) {
                    throw null;
                }
                dVar7.f = i5;
                dVar7.b |= 8;
            }
        }
    }
}
