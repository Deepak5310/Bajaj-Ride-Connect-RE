package com.google.android.libraries.navigation.internal.ny;

import android.content.Context;
import android.os.StrictMode;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.libraries.navigation.environment.av;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements DefaultLifecycleObserver {
    private static b a;
    private final String b;
    private final LinkedHashSet c = new LinkedHashSet();
    private boolean d;
    private String e;

    public b(String str) {
        this.b = str;
    }

    public static synchronized b a() {
        if (a == null) {
            a = new b(b.class.getName());
        }
        return a;
    }

    private final void e() {
        File file = new File(this.e);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        }
    }

    public final synchronized boolean b(Context context, Lifecycle lifecycle) {
        if (this.d) {
            return false;
        }
        this.d = true;
        String strValueOf = String.valueOf(context.getFilesDir());
        String str = this.b;
        this.e = strValueOf + RemoteSettings.FORWARD_SLASH_STRING + File.separator + str;
        File file = new File(this.e);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        StrictMode.allowThreadDiskWrites();
        try {
            if (file.exists()) {
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    ((av) it2.next()).a();
                }
                file.delete();
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            lifecycle.addObserver(this);
            if (lifecycle.getState().isAtLeast(Lifecycle.State.RESUMED)) {
                e();
            }
            return true;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public final synchronized void c(av avVar) {
        this.c.add(avVar);
    }

    public final synchronized void d(Context context) {
        b(context, ProcessLifecycleOwner.get().getLifecycle());
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final synchronized void onPause(LifecycleOwner lifecycleOwner) {
        String str = this.e;
        if (str == null) {
            return;
        }
        File file = new File(str);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        StrictMode.allowThreadDiskWrites();
        try {
            if (file.exists()) {
                file.delete();
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final synchronized void onResume(LifecycleOwner lifecycleOwner) {
        e();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
    }
}
