package com.google.android.libraries.navigation.internal.xz;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private String b;
    private final eq f;
    public String a = "files";
    private String c = "common";
    private Account d = g.b;
    private String e = "";

    public f(Context context) {
        int i = ev.d;
        this.f = new eq();
        com.google.android.libraries.navigation.internal.yc.f.a(context != null, "Context cannot be null", new Object[0]);
        this.b = context.getPackageName();
    }

    public final Uri a() {
        String str;
        String str2 = this.a;
        String str3 = this.c;
        Account account = this.d;
        Account account2 = a.a;
        com.google.android.libraries.navigation.internal.yc.f.a(account.type.indexOf(58) == -1, "Account type contains ':'.", new Object[0]);
        com.google.android.libraries.navigation.internal.yc.f.a(account.type.indexOf(47) == -1, "Account type contains '/'.", new Object[0]);
        com.google.android.libraries.navigation.internal.yc.f.a(account.name.indexOf(47) == -1, "Account name contains '/'.", new Object[0]);
        if (a.a(account)) {
            str = "shared";
        } else {
            str = account.type + ":" + account.name;
        }
        return new Uri.Builder().scheme(SystemMediaRouteProvider.PACKAGE_NAME).authority(this.b).path(RemoteSettings.FORWARD_SLASH_STRING + str2 + RemoteSettings.FORWARD_SLASH_STRING + str3 + RemoteSettings.FORWARD_SLASH_STRING + str + RemoteSettings.FORWARD_SLASH_STRING + this.e).encodedFragment(com.google.android.libraries.navigation.internal.yc.e.a(this.f.g())).build();
    }

    public final void b(String str) {
        com.google.android.libraries.navigation.internal.yc.f.a(g.a.matcher(str).matches(), "Module must match [a-z]+(_[a-z]+)*: %s", str);
        com.google.android.libraries.navigation.internal.yc.f.a(!g.c.contains(str), "Module name is reserved and cannot be used: %s", str);
        this.c = str;
    }

    public final void c(String str) {
        if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = str.substring(1);
        }
        Pattern pattern = g.a;
        this.e = str;
    }
}
