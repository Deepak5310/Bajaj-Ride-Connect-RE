package com.google.android.libraries.navigation.internal.xz;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.yf.b {
    private final Context a;
    private String d;
    private final Object c = new Object();
    private final com.google.android.libraries.navigation.internal.yf.a b = new k(null);
    private final b e = new Object() { // from class: com.google.android.libraries.navigation.internal.xz.b
    };

    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.libraries.navigation.internal.xz.b] */
    public d(c cVar) {
        this.a = cVar.a;
    }

    private final boolean h(Uri uri) {
        return (TextUtils.isEmpty(uri.getAuthority()) || this.a.getPackageName().equals(uri.getAuthority())) ? false : true;
    }

    private static final void i() throws com.google.android.libraries.navigation.internal.yb.b {
        throw new com.google.android.libraries.navigation.internal.yb.b("Android backend cannot perform remote operations without a remote backend");
    }

    @Override // com.google.android.libraries.navigation.internal.yf.b
    protected final Uri a(Uri uri) throws IOException {
        if (h(uri)) {
            throw new com.google.android.libraries.navigation.internal.yb.d("Operation across authorities is not allowed.");
        }
        File fileC = c(uri);
        i iVar = new i();
        iVar.a.path(fileC.getAbsolutePath());
        return iVar.a.encodedFragment(com.google.android.libraries.navigation.internal.yc.e.a(iVar.b.g())).build();
    }

    @Override // com.google.android.libraries.navigation.internal.yf.b
    protected final com.google.android.libraries.navigation.internal.yf.a b() {
        return this.b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    @Override // com.google.android.libraries.navigation.internal.yf.b, com.google.android.libraries.navigation.internal.yf.a
    public final File c(Uri uri) throws IOException {
        byte b;
        File filesDir;
        String str;
        Account account;
        if (h(uri)) {
            throw new IOException("operation is not permitted in other authorities.");
        }
        h hVar = new h(this.a);
        if (!uri.getScheme().equals(SystemMediaRouteProvider.PACKAGE_NAME)) {
            throw new com.google.android.libraries.navigation.internal.yb.d("Scheme must be 'android'");
        }
        if (uri.getPathSegments().isEmpty()) {
            throw new com.google.android.libraries.navigation.internal.yb.d(String.format("Path must start with a valid logical location: %s", uri));
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new com.google.android.libraries.navigation.internal.yb.d("Did not expect uri to have query");
        }
        ArrayList arrayList = new ArrayList(uri.getPathSegments());
        switch ((String) arrayList.get(0)) {
            case "external":
                b = 5;
                break;
            case "cache":
                b = 3;
                break;
            case "files":
                b = 2;
                break;
            case "managed":
                b = 4;
                break;
            case "directboot-cache":
                b = 1;
                break;
            case "directboot-files":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            filesDir = hVar.a.createDeviceProtectedStorageContext().getFilesDir();
        } else if (b == 1) {
            filesDir = hVar.a.createDeviceProtectedStorageContext().getCacheDir();
        } else if (b == 2) {
            filesDir = e.a(hVar.a);
        } else if (b == 3) {
            filesDir = hVar.a.getCacheDir();
        } else if (b == 4) {
            File file = new File(e.a(hVar.a), "managed");
            if (arrayList.size() >= 3) {
                try {
                    String str2 = (String) arrayList.get(2);
                    Account account2 = a.a;
                    if ("shared".equals(str2)) {
                        account = a.a;
                    } else {
                        int iIndexOf = str2.indexOf(58);
                        com.google.android.libraries.navigation.internal.yc.f.a(iIndexOf >= 0, "Malformed account", new Object[0]);
                        account = new Account(str2.substring(iIndexOf + 1), str2.substring(0, iIndexOf));
                    }
                    if (!a.a(account)) {
                        throw new com.google.android.libraries.navigation.internal.yb.d("AccountManager cannot be null");
                    }
                } catch (IllegalArgumentException e) {
                    throw new com.google.android.libraries.navigation.internal.yb.d(e);
                }
            }
            filesDir = file;
        } else {
            if (b != 5) {
                throw new com.google.android.libraries.navigation.internal.yb.d(String.format("Path must start with a valid logical location: %s", uri));
            }
            filesDir = hVar.a.getExternalFilesDir(null);
        }
        File file2 = new File(filesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
        Context context = this.a;
        if (com.google.android.libraries.navigation.internal.nd.a.c() && !com.google.android.libraries.navigation.internal.nd.a.a(context)) {
            synchronized (this.c) {
                if (this.d == null) {
                    this.d = e.a(this.a.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                }
                str = this.d;
            }
            if (!file2.getAbsolutePath().startsWith(str)) {
                throw new com.google.android.libraries.navigation.internal.yb.b("Cannot access credential-protected data from direct boot");
            }
        }
        return file2;
    }

    @Override // com.google.android.libraries.navigation.internal.yf.b, com.google.android.libraries.navigation.internal.yf.a
    public final InputStream d(Uri uri) throws IOException {
        if (!h(uri)) {
            return b().d(a(uri));
        }
        i();
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yf.a
    public final String e() {
        return SystemMediaRouteProvider.PACKAGE_NAME;
    }

    @Override // com.google.android.libraries.navigation.internal.yf.b, com.google.android.libraries.navigation.internal.yf.a
    public final boolean f(Uri uri) throws IOException {
        if (!h(uri)) {
            return b().f(a(uri));
        }
        i();
        throw null;
    }
}
