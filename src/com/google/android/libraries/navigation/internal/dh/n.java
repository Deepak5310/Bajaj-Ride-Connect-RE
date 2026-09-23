package com.google.android.libraries.navigation.internal.dh;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends ScanCallback {
    private static final UUID g;
    private static final ParcelUuid h;
    public final Context a;
    public boolean b;
    public boolean c;
    public Set d;
    public final j f;
    private final BluetoothAdapter i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.ct.a f397n;
    private final ScanSettings k = new ScanSettings.Builder().setScanMode(2).build();
    private final ScanFilter l = new ScanFilter.Builder().setServiceUuid(h).build();
    private BluetoothLeScanner m = null;
    private boolean j = false;
    public final BroadcastReceiver e = new m(this);

    static {
        UUID uuidFromString = UUID.fromString("0000feaa-0000-1000-8000-00805f9b34fb");
        g = uuidFromString;
        h = new ParcelUuid(uuidFromString);
    }

    public n(j jVar, Context context, com.google.android.libraries.navigation.internal.ct.a aVar, BluetoothAdapter bluetoothAdapter) {
        this.f = jVar;
        this.a = context;
        this.f397n = aVar;
        this.i = bluetoothAdapter;
    }

    public final void a() {
        Set set;
        boolean z = (!this.b || (set = this.d) == null || set.isEmpty()) ? false : true;
        this.c |= z;
        com.google.android.libraries.navigation.internal.ct.a aVar = this.f397n;
        if (Build.VERSION.SDK_INT >= 31 ? !aVar.a("android.permission.BLUETOOTH_SCAN") : !(aVar.a("android.permission.BLUETOOTH") && aVar.a("android.permission.BLUETOOTH_ADMIN"))) {
            this.f.a(17);
            return;
        }
        if (this.m == null) {
            try {
                if (!this.i.isEnabled()) {
                    return;
                } else {
                    this.m = this.i.getBluetoothLeScanner();
                }
            } catch (SecurityException unused) {
                this.f.a(18);
                return;
            }
        }
        BluetoothLeScanner bluetoothLeScanner = this.m;
        if (bluetoothLeScanner == null) {
            this.f.a(19);
            return;
        }
        try {
            if (!z) {
                if (this.j) {
                    bluetoothLeScanner.stopScan(this);
                    this.m = null;
                    this.j = false;
                    return;
                }
                return;
            }
            if (this.j) {
                return;
            }
            bluetoothLeScanner.startScan(new ArrayList(Arrays.asList(this.l)), this.k, this);
            this.j = true;
            j jVar = this.f;
            com.google.android.libraries.navigation.internal.ra.c.g.f();
            com.google.android.apps.gmm.location.navigation.ap.a(jVar.a.b, 9, true);
            jVar.a.b = null;
        } catch (IllegalStateException unused2) {
            this.j = false;
            this.m = null;
            this.f.a(20);
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i, ScanResult scanResult) {
        ScanRecord scanRecord;
        byte[] serviceData;
        if (scanResult == null || (scanRecord = scanResult.getScanRecord()) == null || (serviceData = scanRecord.getServiceData(h)) == null || serviceData.length < 18) {
            return;
        }
        if (serviceData[0] == 0) {
            long j = 0;
            long j2 = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                int i3 = serviceData[i2 + 2] & 255;
                j = (j << 8) | ((long) (serviceData[i2 + 10] & 255));
                j2 = (j2 << 8) | ((long) i3);
            }
            Set set = this.d;
            if (set == null || !set.contains(new UUID(j2, j))) {
                return;
            }
            this.f.a.a.a(new i(j2, j, scanResult.getRssi(), serviceData[1], scanResult.getTimestampNanos()));
        }
    }
}
