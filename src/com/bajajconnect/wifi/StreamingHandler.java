package com.bajajconnect.wifi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.mappls.sdk.maps.MapplsMap;

/* JADX INFO: loaded from: classes3.dex */
public class StreamingHandler {
    public static AssetManager assetManager;
    private final Context context;
    public MapplsMap mMap;
    public TcpServerService tcpServerService;
    public UdpServerService udpServerService;
    public boolean isUdpInitialised = false;
    public boolean isTcpInitialised = false;
    private boolean tcpBindRequested = false;
    private boolean udpBindRequested = false;
    private int tcpBindCount = 0;
    private int udpBindCount = 0;
    private final ServiceConnection udpServerServiceConnection = new ServiceConnection() { // from class: com.bajajconnect.wifi.StreamingHandler.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("StreamingHandler", "udp onServiceConnected");
            StreamingHandler.this.udpServerService = ((UdpServerService.LocalBinder) iBinder).getService();
            StreamingHandler.this.udpBindRequested = true;
            StreamingHandler.this.udpServerService.startServer();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("StreamingHandler", "udp onServiceDisconnected");
            StreamingHandler.this.udpServerService = null;
            StreamingHandler.this.isUdpInitialised = false;
            StreamingHandler.this.udpBindRequested = false;
            StreamingHandler.this.udpBindCount = 0;
        }
    };
    private final ServiceConnection tcpServerServiceConnection = new ServiceConnection() { // from class: com.bajajconnect.wifi.StreamingHandler.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("StreamingHandler", "tcp onServiceConnected");
            StreamingHandler.this.tcpServerService = ((TcpServerService.LocalBinder) iBinder).getService();
            StreamingHandler.this.tcpBindRequested = true;
            StreamingHandler.this.tcpServerService.startServer();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("StreamingHandler", "tcp onServiceDisconnected");
            StreamingHandler.this.tcpServerService = null;
            StreamingHandler.this.isTcpInitialised = false;
            StreamingHandler.this.tcpBindRequested = false;
            StreamingHandler.this.tcpBindCount = 0;
        }
    };

    public static native void getAndroidVersion(Context context, byte[] bArr);

    public StreamingHandler(Context context) {
        this.context = context;
    }

    public boolean onTcpReady() {
        return this.isTcpInitialised && this.tcpServerService != null;
    }

    public boolean onUdpReady() {
        return this.isUdpInitialised && this.udpServerService != null;
    }

    public boolean onSocketsInitialise() {
        return onTcpReady() && onUdpReady();
    }

    public boolean isTcpBoundOrBinding() {
        return this.tcpServerService != null || this.tcpBindRequested;
    }

    public boolean isUdpBoundOrBinding() {
        return this.udpServerService != null || this.udpBindRequested;
    }

    public synchronized void initTcpServer() {
        assetManager = this.context.getAssets();
        UdpServerService.ensureExecutors();
        TcpServerService tcpServerService = this.tcpServerService;
        if (tcpServerService != null) {
            try {
                tcpServerService.startServer();
            } catch (Exception e) {
                Log.e("StreamingHandler", "initTcpServer: restart failed", e);
            }
        } else {
            if (this.tcpBindRequested) {
                return;
            }
            if (this.context.getApplicationContext().bindService(new Intent(this.context.getApplicationContext(), (Class<?>) TcpServerService.class), this.tcpServerServiceConnection, 1)) {
                this.tcpBindRequested = true;
                this.tcpBindCount++;
                Log.e("StreamingHandler", "start TCP (docs/control) bindOk=true count=" + this.tcpBindCount);
            } else {
                Log.e("StreamingHandler", "start TCP bindService FAILED");
            }
        }
    }

    public synchronized void initUdpServer() {
        assetManager = this.context.getAssets();
        if (this.udpServerService != null) {
            if (!this.isUdpInitialised) {
                try {
                    Log.i("StreamingHandler", "initUdpServer: restart startServer on existing bind");
                    this.udpServerService.startServer();
                } catch (Exception e) {
                    Log.e("StreamingHandler", "initUdpServer restart failed", e);
                }
            }
            return;
        }
        if (this.udpBindRequested) {
            return;
        }
        if (this.context.getApplicationContext().bindService(new Intent(this.context.getApplicationContext(), (Class<?>) UdpServerService.class), this.udpServerServiceConnection, 1)) {
            this.udpBindRequested = true;
            this.udpBindCount++;
            Log.e("StreamingHandler", "start UDP (screen mirror) bindOk=true count=" + this.udpBindCount);
        } else {
            Log.e("StreamingHandler", "start UDP bindService FAILED");
        }
    }

    public void initWifiServers() {
        if (MirroringGlobarVar.currentScreen == Screens.NONE && !MirroringPolicy.deferMirroringUntilNavigation()) {
            MirroringGlobarVar.currentScreen = Screens.SEARCH_SCREEN;
        }
        if (this.udpServerService != null || this.tcpServerService != null || this.tcpBindRequested || this.udpBindRequested) {
            stopAllConnections();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.StreamingHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.initWifiServers();
                }
            }, 1000L);
        } else {
            Log.e("StreamingHandler", "start mirroring (TCP + UDP)");
            initTcpServer();
            initUdpServer();
        }
    }

    public synchronized void stopScreenMirroring() {
        this.isUdpInitialised = false;
        UdpServerService udpServerService = this.udpServerService;
        if (udpServerService != null) {
            try {
                udpServerService.stopAllTasks();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        unbindUdpFully();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized void stopAllConnections() {
        UdpServerService udpServerService;
        this.isTcpInitialised = false;
        this.isUdpInitialised = false;
        TcpServerService tcpServerService = this.tcpServerService;
        if (tcpServerService != null) {
            try {
                tcpServerService.stopAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            udpServerService = this.udpServerService;
            if (udpServerService != null) {
                try {
                    udpServerService.stopAllTasks();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            unbindTcpFully();
            unbindUdpFully();
        } else {
            udpServerService = this.udpServerService;
            if (udpServerService != null) {
                udpServerService.stopAllTasks();
            }
            unbindTcpFully();
            unbindUdpFully();
        }
        throw th;
    }

    private void unbindTcpFully() {
        while (this.tcpBindCount > 0) {
            try {
                this.context.getApplicationContext().unbindService(this.tcpServerServiceConnection);
                this.tcpBindCount--;
            } catch (Exception unused) {
            }
        }
        try {
            this.context.getApplicationContext().unbindService(this.tcpServerServiceConnection);
        } catch (Exception unused2) {
        }
        this.tcpBindCount = 0;
        this.tcpBindRequested = false;
        this.tcpServerService = null;
    }

    private void unbindUdpFully() {
        while (this.udpBindCount > 0) {
            try {
                this.context.getApplicationContext().unbindService(this.udpServerServiceConnection);
                this.udpBindCount--;
            } catch (Exception unused) {
            }
        }
        try {
            this.context.getApplicationContext().unbindService(this.udpServerServiceConnection);
        } catch (Exception unused2) {
        }
        this.udpBindCount = 0;
        this.udpBindRequested = false;
        this.udpServerService = null;
    }
}
