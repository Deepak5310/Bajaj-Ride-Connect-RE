package com.google.android.libraries.navigation.internal.tc;

import android.app.Application;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.google.android.libraries.navigation.internal.ady.al;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements com.google.android.libraries.navigation.internal.sp.b {
    public static final /* synthetic */ int c = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.tc.y");
    private static final int[] e = {2, 1};
    public BluetoothA2dp a;
    public int b;
    private final Application f;
    private final com.google.android.libraries.navigation.internal.ia.e g;
    private final BluetoothAdapter h;
    private boolean i;
    private final BroadcastReceiver j;
    private final BluetoothProfile.ServiceListener k;
    private final x l;

    public y(Application application, com.google.android.libraries.navigation.internal.ia.e eVar) {
        x xVar = new x(application);
        BluetoothAdapter defaultAdapter = xVar.a() ? BluetoothAdapter.getDefaultAdapter() : null;
        this.j = new v(this);
        this.k = new w(this);
        this.f = application;
        this.g = eVar;
        this.l = xVar;
        this.h = defaultAdapter;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final synchronized void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.i = false;
        if (this.l.a()) {
            if (cVar.b != al.DRIVE) {
                return;
            }
            BluetoothAdapter bluetoothAdapter = this.h;
            if (bluetoothAdapter != null) {
                try {
                    bluetoothAdapter.getProfileProxy(this.f, this.k, 2);
                    this.b = 0;
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
                    intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
                    this.f.registerReceiver(this.j, intentFilter);
                    this.i = true;
                } catch (SecurityException e2) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e2)).F((char) 1726)).o();
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final synchronized void b(boolean z) {
        BluetoothA2dp bluetoothA2dp;
        if (this.i) {
            this.i = false;
            this.f.unregisterReceiver(this.j);
            BluetoothAdapter bluetoothAdapter = this.h;
            if (bluetoothAdapter != null && (bluetoothA2dp = this.a) != null) {
                bluetoothAdapter.closeProfileProxy(2, bluetoothA2dp);
            }
            this.a = null;
        }
    }

    public final synchronized void c() {
        List<BluetoothDevice> arrayList = new ArrayList<>();
        BluetoothA2dp bluetoothA2dp = this.a;
        if (bluetoothA2dp != null) {
            try {
                arrayList = bluetoothA2dp.getDevicesMatchingConnectionStates(e);
            } catch (NullPointerException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1725)).p("bluetoothA2dp.getDevicesMatchingConnectionStates threw an NPE. See b/34821865.");
                return;
            }
        }
        int i = this.b;
        int size = arrayList.size();
        this.b = size;
        if (size > i) {
            this.g.a(com.google.android.libraries.navigation.internal.tf.a.a);
        }
    }
}
