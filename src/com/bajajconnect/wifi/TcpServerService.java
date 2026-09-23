package com.bajajconnect.wifi;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.RouteInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.util.LogUtils;
import com.bajajconnect.util.Md5Util;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler;
import com.bajajconnect.wifi.views.NavigationSearchScreen;
import com.bajajconnect.wifi.views.TftTurnByTurnScreen;
import com.google.common.base.Ascii;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.navigation.NavigationConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TcpServerService extends Service {
    private static final int BUFFER_FRAME_SIZE = 12;
    public static final String IP = "192.168.4.1";
    private static final int MAX_CLUSTER_REQUEST_PAYLOAD = 2048;
    private static final int PORT = 5558;
    private static final String TAG = "com.bajajconnect.wifi.TcpServerService";
    public Bitmap defaultImage;
    OutputStream dos;
    private InputStream rxBuffer;
    Socket socket;
    TouchPoint touchPoint;
    short xAxis;
    short yAxis;
    private final IBinder mBinder = new LocalBinder();
    private boolean mRun = false;
    private volatile boolean pendingMusicCover = false;
    private final boolean[] docImageTxSentThisSession = new boolean[3];
    private volatile boolean docsTxToastShownThisSession = false;
    public byte MX874U_EVENT_NO_EVENT = 0;
    public byte lastTouchType = 0;
    public boolean isSending = false;
    public TouchPoint lastTouchPoint = new TouchPoint(0, 0);
    int docNum = 0;
    private final Object tcpTxLock = new Object();
    int poly = -306674912;

    private static boolean isProdFlavor() {
        return true;
    }

    public int getBit(int i, int i2) {
        return (i2 >> i) & 1;
    }

    public void sendNullMusicCover() {
    }

    public synchronized void startServer() {
        Socket socket;
        if (this.mRun && (socket = this.socket) != null && !socket.isClosed() && NavApplication.streamingHandler != null && NavApplication.streamingHandler.isTcpInitialised) {
            Log.d("TCP Client", "C: already connected, skip startServer");
            if (this.pendingMusicCover) {
                flushPendingMusicCover();
            }
            return;
        }
        new Thread(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.initServer();
            }
        }).start();
    }

    public String getHotspotAdress() {
        DhcpInfo dhcpInfo;
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        String hostAddress;
        if (MirroringGlobarVar.network != null && (connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService("connectivity")) != null && (linkProperties = connectivityManager.getLinkProperties(MirroringGlobarVar.network)) != null) {
            for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                if (routeInfo.isDefaultRoute() && routeInfo.getGateway() != null && (hostAddress = routeInfo.getGateway().getHostAddress()) != null && !hostAddress.isEmpty() && !hostAddress.startsWith("fe80:") && !hostAddress.equals("0.0.0.0")) {
                    Log.d("TCP Client", "cluster gateway via LinkProperties: " + hostAddress);
                    return hostAddress;
                }
            }
        }
        try {
            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null || dhcpInfo.gateway == 0) {
                return null;
            }
            int iReverseBytes = dhcpInfo.gateway;
            if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                iReverseBytes = Integer.reverseBytes(iReverseBytes);
            }
            String hostAddress2 = InetAddress.getByAddress(BigInteger.valueOf(iReverseBytes).toByteArray()).getHostAddress();
            if (hostAddress2 == null || hostAddress2.equals("0.0.0.0")) {
                return null;
            }
            Log.d("TCP Client", "cluster gateway via DhcpInfo: " + hostAddress2);
            return hostAddress2;
        } catch (Exception e) {
            Log.e("Wifi Class", "Error getting Hotspot IP address ", e);
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtils.debug(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        LogUtils.debug(TAG, "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LogUtils.debug(TAG, "onUnbind");
        closeServer();
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initServer() {
        InetAddress byName;
        LogUtils.debug(TAG, "initServer TCP");
        this.dos = null;
        try {
            String hotspotAdress = getHotspotAdress();
            if (hotspotAdress != null) {
                byName = InetAddress.getByName(hotspotAdress);
            } else {
                byName = InetAddress.getByName(IP);
            }
            Log.e("TCP Client", "C: Connecting to " + byName.getHostAddress() + ":5558");
            this.socket = new Socket();
            if (MirroringGlobarVar.network != null) {
                MirroringGlobarVar.network.bindSocket(this.socket);
            }
            this.socket.connect(new InetSocketAddress(byName, PORT), NavigationConstants.UI_HANDLER_LOCATION_SERVICE);
            try {
                this.socket.setSoTimeout(3000);
            } catch (Exception unused) {
            }
            this.mRun = true;
            NavApplication.streamingHandler.isTcpInitialised = true;
            synchronized (this.tcpTxLock) {
                resetDocumentTxTracking();
            }
            try {
                Log.e("TCP Client", "C: Started....");
                this.rxBuffer = this.socket.getInputStream();
                Thread thread = new Thread(new RxTcpDataThread());
                thread.setPriority(10);
                thread.start();
                sendScreenInfo();
                try {
                    if (BleFeatures.getInstance().mMediaSessionListener != null && BleFeatures.getInstance().mMediaSessionListener.art != null && !BleFeatures.getInstance().mMediaSessionListener.art.isRecycled()) {
                        this.pendingMusicCover = true;
                    }
                } catch (Exception unused2) {
                }
                flushPendingMusicCover();
                NavigationProtocolV2Handler.getInstance().setClusterSessionActive(true);
                primeCachedDocumentMetadataOnTcpReady();
            } catch (Exception e) {
                Log.e("TCP", "S: Error", e);
            }
        } catch (Exception e2) {
            Log.e("TCP", "C: Error - " + e2.getClass().getSimpleName() + ": " + e2.getMessage());
            NavApplication.streamingHandler.isTcpInitialised = false;
            NavigationProtocolV2Handler.getInstance().setClusterSessionActive(false);
            try {
                Socket socket = this.socket;
                if (socket != null) {
                    socket.close();
                    this.socket = null;
                }
            } catch (Exception unused3) {
            }
            if (MirroringGlobarVar.isWifiConnected) {
                Log.d("TCP", "C: Retrying in 2 seconds...");
                UdpServerService.ensureExecutors();
                UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MirroringGlobarVar.isWifiConnected) {
                            TcpServerService.this.initServer();
                        } else {
                            TcpServerService.this.mRun = false;
                        }
                    }
                }, 2000L, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void stopAll() {
        this.mRun = false;
        NavApplication.streamingHandler.isTcpInitialised = false;
        NavigationProtocolV2Handler.getInstance().setClusterSessionActive(false);
        this.dos = null;
        try {
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
            this.socket = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetConnection() {
        try {
            this.socket.close();
            this.mRun = false;
            this.socket = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        initServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x01dd A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x01f2 A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01f6 A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x021d A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0221 A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0229 A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01d5 A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01d9 A[Catch: all -> 0x027c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x000d, B:10:0x0010, B:22:0x0063, B:28:0x00b7, B:31:0x00bd, B:33:0x00c5, B:38:0x00cf, B:40:0x00d3, B:42:0x00db, B:46:0x00e5, B:44:0x00e0, B:45:0x00e3, B:49:0x00ea, B:51:0x00f0, B:53:0x00f8, B:55:0x0100, B:57:0x0108, B:59:0x0110, B:61:0x0114, B:64:0x014a, B:66:0x0150, B:76:0x0191, B:67:0x015e, B:69:0x0164, B:71:0x016a, B:72:0x0171, B:75:0x017e, B:79:0x019e, B:81:0x01a6, B:83:0x01ae, B:85:0x01b6, B:87:0x01ba, B:89:0x01be, B:94:0x01cf, B:96:0x01d5, B:98:0x01d9, B:100:0x01dd, B:101:0x01f2, B:103:0x01f6, B:104:0x020a, B:105:0x021d, B:107:0x0221, B:109:0x0230, B:108:0x0229, B:92:0x01c7, B:110:0x023c, B:112:0x0246, B:116:0x0250, B:114:0x024b, B:115:0x024e, B:119:0x0255, B:121:0x025b, B:125:0x0261, B:127:0x026b, B:131:0x0275, B:129:0x0270, B:130:0x0273, B:12:0x0014, B:13:0x001c, B:14:0x0024, B:15:0x002c, B:16:0x0034, B:17:0x003c, B:18:0x0044, B:19:0x004c, B:20:0x0054, B:21:0x005c), top: B:139:0x0003 }] */
    public synchronized void processRecievedFrame(byte[] bArr) {
        TftTurnByTurnScreen.TouchEventType touchEventType;
        TftTurnByTurnScreen.TouchEventType touchEventType2;
        TftTurnByTurnScreen.TouchEventType touchEventType3;
        if (!MirroringGlobarVar.isSearchProcessing && MirroringGlobarVar.isOnMirroringPage) {
            byte b = bArr[0];
            switch (b) {
                case 1:
                    LogUtils.debug(TAG, "Tocuh event move");
                    break;
                case 2:
                    LogUtils.debug(TAG, "Touch event unsupress");
                    break;
                case 3:
                    LogUtils.debug(TAG, "Touch evetn supress");
                    break;
                case 4:
                    LogUtils.debug(TAG, "Touch event touch down");
                    break;
                case 5:
                    LogUtils.debug(TAG, "Touch event toch up");
                    break;
                case 6:
                    LogUtils.debug(TAG, "Touch event supress/unsupress");
                    break;
                case 7:
                    LogUtils.debug(TAG, "Touch event unsupress and touch up");
                    break;
                case 8:
                    LogUtils.debug(TAG, "Touch event supress and touch down");
                    break;
                case 9:
                    LogUtils.debug(TAG, "Touch event touch down and up");
                    break;
                case 10:
                    LogUtils.debug(TAG, "Touch event len");
                    break;
            }
            byte b2 = bArr[2];
            this.touchPoint = new TouchPoint(Util.getShort(new byte[]{bArr[3], bArr[4]}), Util.getShort(new byte[]{bArr[5], bArr[6]}));
            LogUtils.debug(TAG, "coordinates " + this.touchPoint.x + StringUtils.SPACE + this.touchPoint.y);
            if (b == 1 || b == 4 || b == 5) {
                if (this.lastTouchType != b || b == 1) {
                    this.lastTouchType = b;
                    if (MirroringGlobarVar.currentScreen == Screens.SEARCH_SCREEN) {
                        if (this.touchPoint.y < 105) {
                            return;
                        }
                        if (StreamingImageHandler.navigationSearchScreen != null) {
                            NavigationSearchScreen navigationSearchScreen = StreamingImageHandler.navigationSearchScreen;
                            TouchPoint touchPoint = this.touchPoint;
                            byte b3 = this.lastTouchType;
                            if (b3 == 4) {
                                touchEventType3 = TftTurnByTurnScreen.TouchEventType.DOWN;
                            } else {
                                touchEventType3 = b3 == 1 ? TftTurnByTurnScreen.TouchEventType.MOVE : TftTurnByTurnScreen.TouchEventType.UP;
                            }
                            navigationSearchScreen.injectTouchEvents(touchPoint, touchEventType3);
                            return;
                        }
                    }
                    if (MirroringGlobarVar.currentScreen == Screens.ROUTE_SCREEN) {
                        if (this.touchPoint.x > 25 && this.touchPoint.x < 80 && this.touchPoint.y > 115 && this.touchPoint.y < 168) {
                            if (!GlobalVar.isGoogleNavigation) {
                                NavApplication.customProjection.routeInfoPresentationMMI.isRouteDrawn = false;
                                MirroringGlobarVar.isSearchProcessing = true;
                                NavApplication.streamingHandler.udpServerService.setImage(StreamingImageHandler.getSearchScreenNew(this, NavApplication.customProjection.bitmap));
                                NavApplication.customProjection.stopPresentation();
                                NavApplication.streamingHandler.udpServerService.startScreenCaptures();
                                UdpServerService.ensureExecutors();
                                UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        TcpServerService.lambda$processRecievedFrame$0();
                                    }
                                }, 1000L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            if (MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO) {
                                Log.e("NAvigation", "stop fragment nav");
                                NavApplication.customProjection.stopNavigationCombined();
                            } else if (MirroringPolicy.deferMirroringUntilNavigation()) {
                                if (NavApplication.customProjection.routeInfoPresentation != null) {
                                    NavApplication.customProjection.routeInfoPresentation.stopNavigation();
                                }
                                MirroringPolicy.stopMirroringAfterNavigation(BleFeatures.getInstance().context, "TcpServerService.routeDropdownGoogle");
                                return;
                            } else {
                                NavApplication.customProjection.routeInfoPresentation.stopNavigation();
                                NavApplication.customProjection.stopPresentation();
                                NavApplication.streamingHandler.udpServerService.startScreenCaptures();
                            }
                            MirroringGlobarVar.currentScreen = Screens.SEARCH_SCREEN;
                            NavApplication.streamingHandler.udpServerService.onScreenChange();
                            return;
                        }
                        if (this.touchPoint.x > 169 && this.touchPoint.y > 414 && this.touchPoint.x < 631 && this.lastTouchType == 4) {
                            if (GlobalVar.isGoogleNavigation) {
                                if (NavApplication.customProjection.routeInfoPresentation.isRouteDrawn) {
                                    if (MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO) {
                                        if (GlobalVar.isGoogleNavigation) {
                                            if (MirroringGlobarVar.isWifiConnected) {
                                                LocalBroadcastManager.getInstance(BleFeatures.getInstance().context).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
                                            }
                                        } else {
                                            if (MirroringGlobarVar.isWifiConnected) {
                                                LocalBroadcastManager.getInstance(BleFeatures.getInstance().context).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
                                            }
                                            NavApplication.customProjection.routeInfoPresentationMMI.startNavigation();
                                            MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
                                            NavApplication.streamingHandler.udpServerService.onScreenChange();
                                        }
                                    } else {
                                        if (GlobalVar.isGoogleNavigation) {
                                            NavApplication.customProjection.routeInfoPresentation.startNavigation();
                                        } else {
                                            NavApplication.customProjection.routeInfoPresentationMMI.startNavigation();
                                        }
                                        MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
                                        NavApplication.streamingHandler.udpServerService.onScreenChange();
                                    }
                                }
                            } else if (NavApplication.customProjection.routeInfoPresentationMMI.isRouteDrawn) {
                                if (MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO) {
                                    if (GlobalVar.isGoogleNavigation) {
                                        if (MirroringGlobarVar.isWifiConnected) {
                                            LocalBroadcastManager.getInstance(BleFeatures.getInstance().context).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
                                        }
                                    } else {
                                        if (MirroringGlobarVar.isWifiConnected) {
                                            LocalBroadcastManager.getInstance(BleFeatures.getInstance().context).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
                                        }
                                        NavApplication.customProjection.routeInfoPresentationMMI.startNavigation();
                                        MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
                                        NavApplication.streamingHandler.udpServerService.onScreenChange();
                                    }
                                } else {
                                    if (GlobalVar.isGoogleNavigation) {
                                        NavApplication.customProjection.routeInfoPresentation.startNavigation();
                                    } else {
                                        NavApplication.customProjection.routeInfoPresentationMMI.startNavigation();
                                    }
                                    MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
                                    NavApplication.streamingHandler.udpServerService.onScreenChange();
                                }
                            }
                        } else {
                            TftTurnByTurnScreen tftTurnByTurnScreen = StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen;
                            TouchPoint touchPoint2 = this.touchPoint;
                            byte b4 = this.lastTouchType;
                            if (b4 == 4) {
                                touchEventType2 = TftTurnByTurnScreen.TouchEventType.DOWN;
                            } else {
                                touchEventType2 = b4 == 1 ? TftTurnByTurnScreen.TouchEventType.MOVE : TftTurnByTurnScreen.TouchEventType.UP;
                            }
                            tftTurnByTurnScreen.injectTouchPointsNew(touchPoint2, b2, touchEventType2);
                        }
                        return;
                    }
                    if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                        if (!MirroringGlobarVar.isBikeStationary) {
                            return;
                        }
                        TftTurnByTurnScreen tftTurnByTurnScreen2 = StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen;
                        TouchPoint touchPoint3 = this.touchPoint;
                        byte b5 = this.lastTouchType;
                        if (b5 == 4) {
                            touchEventType = TftTurnByTurnScreen.TouchEventType.DOWN;
                        } else {
                            touchEventType = b5 == 1 ? TftTurnByTurnScreen.TouchEventType.MOVE : TftTurnByTurnScreen.TouchEventType.UP;
                        }
                        tftTurnByTurnScreen2.injectTouchPointsNew(touchPoint3, b2, touchEventType);
                    }
                }
            }
        }
    }

    static /* synthetic */ void lambda$processRecievedFrame$0() {
        MirroringGlobarVar.isSearchProcessing = false;
        MirroringGlobarVar.currentScreen = Screens.SEARCH_SCREEN;
        NavApplication.streamingHandler.udpServerService.onScreenChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeServer() {
        LogUtils.error(TAG, "closeServer");
        try {
            this.socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public TcpServerService getService() {
            return TcpServerService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class RxTcpDataThread implements Runnable {
        private final ByteArrayOutputStream incoming;
        private final byte[] readChunk;

        private RxTcpDataThread() {
            this.incoming = new ByteArrayOutputStream(4096);
            this.readChunk = new byte[1024];
        }

        @Override // java.lang.Runnable
        public void run() {
            while (TcpServerService.this.mRun) {
                try {
                    try {
                        int i = TcpServerService.this.rxBuffer.read(this.readChunk);
                        if (i < 0) {
                            throw new IOException("EOF - remote closed");
                        }
                        if (i != 0) {
                            this.incoming.write(this.readChunk, 0, i);
                            drainIncomingFrames();
                        }
                    } catch (SocketTimeoutException unused) {
                    }
                } catch (IOException e) {
                    Log.e("TCP", "SP: Error - " + e.getMessage());
                    if (TcpServerService.this.mRun) {
                        if (MirroringGlobarVar.isWifiConnected) {
                            try {
                                if (TcpServerService.this.socket != null) {
                                    TcpServerService.this.socket.close();
                                }
                            } catch (Exception unused2) {
                            }
                            TcpServerService.this.socket = null;
                            TcpServerService.this.dos = null;
                            TcpServerService.this.mRun = false;
                            NavigationProtocolV2Handler.getInstance().setClusterSessionActive(false);
                            UdpServerService.ensureExecutors();
                            UdpServerService.executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService$RxTcpDataThread$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$run$0();
                                }
                            }, 1000L, TimeUnit.MILLISECONDS);
                            return;
                        }
                        TcpServerService.this.closeServer();
                        return;
                    }
                } catch (Exception e2) {
                    Log.e(TcpServerService.TAG, "RxTcpDataThread unexpected", e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (MirroringGlobarVar.isWifiConnected) {
                TcpServerService.this.initServer();
            }
        }

        private void drainIncomingFrames() {
            byte[] byteArray = this.incoming.toByteArray();
            int i = 0;
            while (byteArray.length - i >= 5) {
                int i2 = byteArray[i] & 255;
                if (i2 == 0) {
                    int i3 = ((byteArray[i + 3] & 255) << 8) | (byteArray[i + 4] & 255);
                    if (i3 < 0 || i3 > 2048) {
                        Log.w(TcpServerService.TAG, "RX resync: reject payloadLength=" + i3 + " (max=2048) — skip false 0x00 head=" + TcpServerService.previewHex(Arrays.copyOfRange(byteArray, i, Math.min(byteArray.length, i + 8)), 8));
                    } else {
                        int i4 = i3 + 5;
                        if (byteArray.length - i < i4) {
                            break;
                        }
                        int i5 = i4 + i;
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(byteArray, i, i5);
                        int i6 = bArrCopyOfRange[1] & 255;
                        int i7 = bArrCopyOfRange[2] & 255;
                        Log.i(TcpServerService.TAG, "RX frame header type=0x00 group=0x" + String.format("%02X", Integer.valueOf(i6)) + " cmd=0x" + String.format("%02X", Integer.valueOf(i7)) + " len=" + i3 + " head=" + TcpServerService.previewHex(bArrCopyOfRange, Math.min(5, bArrCopyOfRange.length)) + " ascii=" + TcpServerService.asciiPreview(bArrCopyOfRange, Math.min(5, bArrCopyOfRange.length)));
                        if (i6 == 0 && i7 == 0 && i3 > 5) {
                            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrCopyOfRange, 5, bArrCopyOfRange.length);
                            Log.i(TcpServerService.TAG, "RX legacy payload len=" + bArrCopyOfRange2.length + " preview=" + TcpServerService.previewHex(bArrCopyOfRange2, Math.min(24, bArrCopyOfRange2.length)));
                            TcpServerService.this.processRecievedFrame(bArrCopyOfRange2);
                        } else if (i3 == 0) {
                            Log.i(TcpServerService.TAG, "RX request no payload preview=" + TcpServerService.previewHex(bArrCopyOfRange, bArrCopyOfRange.length));
                            TcpServerService.this.processTftRequests(bArrCopyOfRange);
                        } else {
                            Log.i(TcpServerService.TAG, "RX request full len=" + bArrCopyOfRange.length + " preview=" + TcpServerService.previewHex(bArrCopyOfRange, Math.min(32, bArrCopyOfRange.length)));
                            TcpServerService.this.processTftRequests(bArrCopyOfRange);
                        }
                        i = i5;
                    }
                } else if (i2 == 123) {
                    int iMin = Math.min(byteArray.length, i + 512);
                    String str = TcpServerService.TAG;
                    StringBuilder sb = new StringBuilder("RX resync: skipping NON-H105GA noise ascii=");
                    int i8 = iMin - i;
                    sb.append(TcpServerService.asciiPreview(Arrays.copyOfRange(byteArray, i, iMin), i8));
                    sb.append(" hex=");
                    sb.append(TcpServerService.previewHex(Arrays.copyOfRange(byteArray, i, iMin), i8));
                    Log.w(str, sb.toString());
                } else {
                    Log.d(TcpServerService.TAG, "RX resync: skip byte=0x" + String.format("%02X", Integer.valueOf(i2)));
                }
                i++;
            }
            this.incoming.reset();
            if (i < byteArray.length) {
                this.incoming.write(byteArray, i, byteArray.length - i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void processTftRequests(byte[] bArr) {
        try {
            if (bArr[0] != 0) {
                Log.w(TAG, "RX dispatch: not a request (type=0x" + String.format("%02X", Integer.valueOf(bArr[0] & 255)) + ") — dropped preview=" + previewHex(bArr, Math.min(16, bArr.length)));
                return;
            }
            int i = bArr[1] & 255;
            int i2 = bArr[2] & 255;
            String str = TAG;
            Log.i(str, "RX dispatch group=0x" + String.format("%02X", Integer.valueOf(i)) + " cmd=0x" + String.format("%02X", Integer.valueOf(i2)) + " len=" + bArr.length);
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        switch (i2) {
                            case 0:
                                this.docNum = bArr[5];
                                StringBuilder sb = new StringBuilder("Image requested docNum=");
                                sb.append(this.docNum);
                                sb.append(" licenseData=");
                                sb.append(MirroringGlobarVar.licenseImageData != null ? MirroringGlobarVar.licenseImageData.length + "B md5=" + hexMd5(MirroringGlobarVar.licenseImageData) : BuildConfig.TRAVIS);
                                sb.append(" regData=");
                                sb.append(MirroringGlobarVar.registrationImageData != null ? MirroringGlobarVar.registrationImageData.length + "B md5=" + hexMd5(MirroringGlobarVar.registrationImageData) : BuildConfig.TRAVIS);
                                sb.append(" insData=");
                                sb.append(MirroringGlobarVar.insuranceImageData != null ? MirroringGlobarVar.insuranceImageData.length + "B md5=" + hexMd5(MirroringGlobarVar.insuranceImageData) : BuildConfig.TRAVIS);
                                Log.e("TCPservice", sb.toString());
                                int i3 = this.docNum;
                                if (i3 == 0) {
                                    if (MirroringGlobarVar.licenseImageData != null) {
                                        try {
                                            this.docNum = bArr[5];
                                            int length = MirroringGlobarVar.licenseImageData.length;
                                            int i4 = length + 5;
                                            int i5 = length + 14;
                                            byte[] bArr2 = new byte[i5];
                                            bArr2[0] = 1;
                                            bArr2[1] = 2;
                                            bArr2[2] = 0;
                                            if (i4 > 65530) {
                                                bArr2[3] = -1;
                                                bArr2[4] = -1;
                                            } else {
                                                bArr2[3] = (byte) ((i4 >> 8) & 255);
                                                bArr2[4] = (byte) (i4 & 255);
                                            }
                                            int i6 = length + 4;
                                            bArr2[5] = (byte) ((i6 >> 24) & 255);
                                            bArr2[6] = (byte) ((i6 >> 16) & 255);
                                            bArr2[7] = (byte) ((i6 >> 8) & 255);
                                            bArr2[8] = (byte) (i6 & 255);
                                            bArr2[9] = bArr[5];
                                            System.arraycopy(MirroringGlobarVar.licenseImageData, 0, bArr2, 10, length);
                                            int iCrc32Ethernet = crc32Ethernet(MirroringGlobarVar.licenseImageData);
                                            bArr2[length + 10] = (byte) ((iCrc32Ethernet >> 24) & 255);
                                            bArr2[length + 11] = (byte) ((iCrc32Ethernet >> 16) & 255);
                                            bArr2[length + 12] = (byte) ((iCrc32Ethernet >> 8) & 255);
                                            bArr2[length + 13] = (byte) (iCrc32Ethernet & 255);
                                            sendDataOverTCP(bArr2);
                                            Log.e("TCPservice", "TX License docNum=0 jpegBytes=" + length + " frameBytes=" + i5 + " header=" + headerHex(bArr2) + " crc32=0x" + String.format("%08x", Integer.valueOf(iCrc32Ethernet)) + " jpegMd5=" + hexMd5(MirroringGlobarVar.licenseImageData));
                                        } catch (Exception e) {
                                            Log.e("TCPservice", "TX License FAILED: " + e.getMessage());
                                            e.printStackTrace();
                                        }
                                    } else {
                                        Log.w("TCPservice", "TX License SKIPPED — licenseImageData is null (never assigned or cleared)");
                                    }
                                } else if (i3 == 1) {
                                    if (MirroringGlobarVar.registrationImageData != null) {
                                        this.docNum = bArr[5];
                                        int length2 = MirroringGlobarVar.registrationImageData.length;
                                        int i7 = length2 + 5;
                                        int i8 = length2 + 14;
                                        byte[] bArr3 = new byte[i8];
                                        bArr3[0] = 1;
                                        bArr3[1] = 2;
                                        bArr3[2] = 0;
                                        if (i7 > 65530) {
                                            bArr3[3] = -1;
                                            bArr3[4] = -1;
                                        } else {
                                            bArr3[3] = (byte) ((i7 >> 8) & 255);
                                            bArr3[4] = (byte) (i7 & 255);
                                        }
                                        int i9 = length2 + 4;
                                        bArr3[5] = (byte) ((i9 >> 24) & 255);
                                        bArr3[6] = (byte) ((i9 >> 16) & 255);
                                        bArr3[7] = (byte) ((i9 >> 8) & 255);
                                        bArr3[8] = (byte) (i9 & 255);
                                        bArr3[9] = bArr[5];
                                        System.arraycopy(MirroringGlobarVar.registrationImageData, 0, bArr3, 10, length2);
                                        int iCrc32Ethernet2 = crc32Ethernet(MirroringGlobarVar.registrationImageData);
                                        bArr3[length2 + 10] = (byte) ((iCrc32Ethernet2 >> 24) & 255);
                                        bArr3[length2 + 11] = (byte) ((iCrc32Ethernet2 >> 16) & 255);
                                        bArr3[length2 + 12] = (byte) ((iCrc32Ethernet2 >> 8) & 255);
                                        bArr3[length2 + 13] = (byte) (iCrc32Ethernet2 & 255);
                                        sendDataOverTCP(bArr3);
                                        Log.e("TCPservice", "TX Registration docNum=1 jpegBytes=" + length2 + " frameBytes=" + i8 + " header=" + headerHex(bArr3) + " crc32=0x" + String.format("%08x", Integer.valueOf(iCrc32Ethernet2)) + " jpegMd5=" + hexMd5(MirroringGlobarVar.registrationImageData));
                                    } else {
                                        Log.w("TCPservice", "TX Registration SKIPPED — registrationImageData is null");
                                    }
                                } else if (i3 == 2) {
                                    if (MirroringGlobarVar.insuranceImageData != null) {
                                        this.docNum = bArr[5];
                                        int length3 = MirroringGlobarVar.insuranceImageData.length;
                                        int i10 = length3 + 5;
                                        int i11 = length3 + 14;
                                        byte[] bArr4 = new byte[i11];
                                        bArr4[0] = 1;
                                        bArr4[1] = 2;
                                        bArr4[2] = 0;
                                        if (i10 > 65530) {
                                            bArr4[3] = -1;
                                            bArr4[4] = -1;
                                        } else {
                                            bArr4[3] = (byte) ((i10 >> 8) & 255);
                                            bArr4[4] = (byte) (i10 & 255);
                                        }
                                        int i12 = length3 + 4;
                                        bArr4[5] = (byte) ((i12 >> 24) & 255);
                                        bArr4[6] = (byte) ((i12 >> 16) & 255);
                                        bArr4[7] = (byte) ((i12 >> 8) & 255);
                                        bArr4[8] = (byte) (i12 & 255);
                                        bArr4[9] = bArr[5];
                                        System.arraycopy(MirroringGlobarVar.insuranceImageData, 0, bArr4, 10, length3);
                                        int iCrc32Ethernet3 = crc32Ethernet(MirroringGlobarVar.insuranceImageData);
                                        bArr4[length3 + 10] = (byte) ((iCrc32Ethernet3 >> 24) & 255);
                                        bArr4[length3 + 11] = (byte) ((iCrc32Ethernet3 >> 16) & 255);
                                        bArr4[length3 + 12] = (byte) ((iCrc32Ethernet3 >> 8) & 255);
                                        bArr4[length3 + 13] = (byte) (iCrc32Ethernet3 & 255);
                                        sendDataOverTCP(bArr4);
                                        Log.e("TCPservice", "TX Insurance docNum=2 jpegBytes=" + length3 + " frameBytes=" + i11 + " header=" + headerHex(bArr4) + " crc32=0x" + String.format("%08x", Integer.valueOf(iCrc32Ethernet3)) + " jpegMd5=" + hexMd5(MirroringGlobarVar.insuranceImageData));
                                    } else {
                                        Log.w("TCPservice", "TX Insurance SKIPPED — insuranceImageData is null");
                                    }
                                } else if (i3 == 3) {
                                    Log.e("TCP", "music cover requested");
                                    sendMusicCover();
                                }
                                break;
                            case 1:
                                this.docNum = bArr[5];
                                Log.e("TCPservice", "Image SIZE requested docNum=" + this.docNum);
                                int i13 = this.docNum;
                                if (i13 == 0) {
                                    if (MirroringGlobarVar.licenseImageData != null) {
                                        Log.e("TCPservice", "image size request License: " + (MirroringGlobarVar.licenseImageData.length + 4));
                                        int length4 = MirroringGlobarVar.licenseImageData.length + 4;
                                        byte b = bArr[5];
                                        this.docNum = b;
                                        sendDataOverTCP(new byte[]{1, 2, 1, 0, 5, (byte) ((length4 >> 24) & 255), (byte) ((length4 >> 16) & 255), (byte) ((length4 >> 8) & 255), (byte) (length4 & 255), b});
                                    }
                                } else if (i13 == 1) {
                                    if (MirroringGlobarVar.registrationImageData != null) {
                                        Log.e("TCPservice", "image size request Registration: " + (MirroringGlobarVar.registrationImageData.length + 4));
                                        int length5 = MirroringGlobarVar.registrationImageData.length + 4;
                                        byte b2 = bArr[5];
                                        this.docNum = b2;
                                        sendDataOverTCP(new byte[]{1, 2, 1, 0, 5, (byte) ((length5 >> 24) & 255), (byte) ((length5 >> 16) & 255), (byte) ((length5 >> 8) & 255), (byte) (length5 & 255), b2});
                                    }
                                } else if (i13 == 2 && MirroringGlobarVar.insuranceImageData != null) {
                                    Log.e("TCPservice", "image size request Insurance: " + (MirroringGlobarVar.insuranceImageData.length + 4));
                                    int length6 = MirroringGlobarVar.insuranceImageData.length + 4;
                                    byte b3 = bArr[5];
                                    this.docNum = b3;
                                    sendDataOverTCP(new byte[]{1, 2, 1, 0, 5, (byte) ((length6 >> 24) & 255), (byte) ((length6 >> 16) & 255), (byte) ((length6 >> 8) & 255), (byte) (length6 & 255), b3});
                                }
                                break;
                            case 2:
                                byte b4 = bArr[5];
                                this.docNum = b4;
                                if (b4 == 0) {
                                    if (MirroringGlobarVar.licenseImageData != null) {
                                        byte[] bArrDigest = Md5Util.digest(MirroringGlobarVar.licenseImageData);
                                        byte b5 = bArr[5];
                                        this.docNum = b5;
                                        byte[] bArr5 = new byte[22];
                                        bArr5[0] = 1;
                                        bArr5[1] = 2;
                                        bArr5[2] = 2;
                                        bArr5[3] = 0;
                                        bArr5[4] = 17;
                                        bArr5[5] = b5;
                                        System.arraycopy(bArrDigest, 0, bArr5, 6, bArrDigest.length);
                                        sendDataOverTCP(bArr5);
                                    }
                                } else if (b4 == 1) {
                                    if (MirroringGlobarVar.registrationImageData != null) {
                                        Log.e("TCPservice", "image md5 request");
                                        byte[] bArrDigest2 = Md5Util.digest(MirroringGlobarVar.registrationImageData);
                                        byte b6 = bArr[5];
                                        this.docNum = b6;
                                        byte[] bArr6 = new byte[22];
                                        bArr6[0] = 1;
                                        bArr6[1] = 2;
                                        bArr6[2] = 2;
                                        bArr6[3] = 0;
                                        bArr6[4] = 17;
                                        bArr6[5] = b6;
                                        System.arraycopy(bArrDigest2, 0, bArr6, 6, bArrDigest2.length);
                                        sendDataOverTCP(bArr6);
                                    }
                                } else if (b4 == 2 && MirroringGlobarVar.insuranceImageData != null) {
                                    Log.e("TCPservice", " insurance image md5 request");
                                    byte[] bArrDigest3 = Md5Util.digest(MirroringGlobarVar.insuranceImageData);
                                    byte b7 = bArr[5];
                                    this.docNum = b7;
                                    byte[] bArr7 = new byte[22];
                                    bArr7[0] = 1;
                                    bArr7[1] = 2;
                                    bArr7[2] = 2;
                                    bArr7[3] = 0;
                                    bArr7[4] = 17;
                                    bArr7[5] = b7;
                                    System.arraycopy(bArrDigest3, 0, bArr7, 6, bArrDigest3.length);
                                    sendDataOverTCP(bArr7);
                                }
                                break;
                            case 3:
                                Log.e("TCP", "date and time requested");
                                sendDateAndTime();
                                break;
                            case 4:
                                Log.e("TCPService", "stop mirroring recieved");
                                Log.e("TCPService", "stop mirroring recieved " + bArr.length);
                                if (bArr.length > 5) {
                                    startMirroring(bArr[5] == 1);
                                }
                                break;
                            case 5:
                                Log.e("TCP", "phone name requested");
                                sendPhoneName();
                                break;
                            case 6:
                                stopNavigation();
                                break;
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                                Log.i(str, "RX group=0x02 NAV_V2 cmd=0x" + String.format("%02X", Integer.valueOf(i2)) + " len=" + bArr.length + " preview=" + previewHex(bArr, Math.min(24, bArr.length)));
                                dispatchNavigationProtocolV2(i2, bArr);
                                break;
                            default:
                                Log.w(str, "RX unhandled group=0x02 cmd=0x" + String.format("%02X", Integer.valueOf(i2)) + " len=" + bArr.length + " preview=" + previewHex(bArr, Math.min(24, bArr.length)));
                                break;
                        }
                    } else {
                        Log.w(str, "RX unhandled group=0x" + String.format("%02X", Integer.valueOf(i)) + " cmd=0x" + String.format("%02X", Integer.valueOf(i2)) + " len=" + bArr.length + " preview=" + previewHex(bArr, Math.min(24, bArr.length)));
                    }
                } else if (i2 == 0) {
                    StringBuilder sb2 = new StringBuilder("RX group=0x01 cmd=0x00 BIKE_INFO stationary=");
                    sb2.append(bArr.length > 5 ? Boolean.valueOf(bArr[5] == 1) : "?");
                    Log.i(str, sb2.toString());
                    isBikeStationry(bArr[5] == 1);
                } else if (i2 == 1) {
                    Log.i(str, "RX group=0x01 cmd=0x01 SCREEN_INFO_REQ");
                    sendScreenInfo();
                } else if (i2 == 2) {
                    Log.i(str, "RX group=0x01 cmd=0x02 SCREEN_CONTROL len=" + bArr.length);
                    sendScreenControlDataToTft(bArr);
                } else {
                    Log.w(str, "RX unhandled group=0x01 cmd=0x" + String.format("%02X", Integer.valueOf(i2)) + " len=" + bArr.length + " preview=" + previewHex(bArr, Math.min(24, bArr.length)));
                }
            } else if (i2 == 0) {
                Log.i(str, "RX group=0x00 cmd=0x00 TOUCH len=" + bArr.length);
                if (bArr.length == 12) {
                    byte[] bArr8 = new byte[7];
                    System.arraycopy(bArr, 5, bArr8, 0, 7);
                    processRecievedFrame(bArr8);
                }
            } else if (i2 == 1) {
                Log.e("TCPService", "handlebar inputs data length " + bArr.length);
                processHandleBarEvents(bArr);
            } else {
                Log.w(str, "RX unhandled group=0x00 cmd=0x" + String.format("%02X", Integer.valueOf(i2)) + " len=" + bArr.length + " preview=" + previewHex(bArr, Math.min(24, bArr.length)));
            }
        } catch (Exception e2) {
            Log.e(TAG, "processTftRequests EXCEPTION", e2);
        }
    }

    private void dispatchNavigationProtocolV2(int i, byte[] bArr) {
        byte[] bArrCopyOfRange;
        int iMin = (bArr == null || bArr.length < 5) ? 0 : Math.min(((bArr[3] & 255) << 8) | (bArr[4] & 255), Math.max(0, bArr.length - 5));
        if (iMin > 0) {
            bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, iMin + 5);
        } else {
            bArrCopyOfRange = new byte[0];
        }
        NavigationProtocolV2Handler.getInstance().handle(i, bArrCopyOfRange, new NavigationProtocolV2Handler.FrameSender() { // from class: com.bajajconnect.wifi.TcpServerService$$ExternalSyntheticLambda5
            @Override // com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler.FrameSender
            public final void send(byte[] bArr2) {
                this.f$0.sendDataOverTCP(bArr2);
            }
        });
    }

    private void startMirroring(boolean z) {
        if (z) {
            Log.e("TCPService", "start mirroring recieved");
            MirroringGlobarVar.isOnMirroringPage = true;
        } else {
            MirroringGlobarVar.isOnMirroringPage = false;
            Log.e("TCPService", "stop mirroring recieved");
        }
    }

    public void stopNavigation() {
        Log.e("TcpService", "stopNavigation");
        if (GlobalVar.isGoogleNavigation) {
            StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.stopNavigationMain();
        } else {
            StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.stopNavigation();
        }
        if (MirroringPolicy.deferMirroringUntilNavigation()) {
            MirroringPolicy.stopMirroringAfterNavigation(BleFeatures.getInstance().context, "TcpServerService.stopNavigation");
        }
    }

    private void isBikeStationry(boolean z) {
        MirroringGlobarVar.isBikeStationary = z;
    }

    private void processHandleBarEvents(byte[] bArr) {
        getBit(1, bArr[5]);
        getBit(2, bArr[5]);
        if (getBit(3, bArr[5]) == 1) {
            StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.recenterMap();
        }
        getBit(4, bArr[5]);
        getBit(5, bArr[5]);
        getBit(6, bArr[5]);
    }

    private void sendScreenControlDataToTft(byte[] bArr) {
        Log.e("TCP", "hsend screen controll");
        sendDataOverTCP(new byte[]{1, 1, 2, 0, (byte) 1, (byte) 1});
    }

    public boolean isTcpSocketReady() {
        Socket socket;
        return (!this.mRun || (socket = this.socket) == null || socket.isClosed() || NavApplication.streamingHandler == null || !NavApplication.streamingHandler.isTcpInitialised) ? false : true;
    }

    public synchronized void sendMusicCover() {
        if (!isTcpSocketReady()) {
            this.pendingMusicCover = true;
            Log.d(TAG, "sendMusicCover: TCP not ready — pendingMusicCover=true");
        } else {
            sendMusicCoverWithRetry(0);
        }
    }

    public synchronized void flushPendingMusicCover() {
        if (this.pendingMusicCover) {
            if (!isTcpSocketReady()) {
                Log.d(TAG, "flushPendingMusicCover: socket not ready yet");
                return;
            }
            Log.d(TAG, "flushPendingMusicCover: sending album cover");
            this.pendingMusicCover = false;
            sendMusicCoverWithRetry(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sendMusicCoverWithRetry(final int i) {
        Bitmap bitmapCreateBitmap;
        try {
            String str = TAG;
            LogUtils.debug(str, "sendMusicCover attempt=" + i);
            if (!isTcpSocketReady()) {
                this.pendingMusicCover = true;
                LogUtils.debug(str, "sendMusicCoverWithRetry: TCP dropped — pendingMusicCover=true");
                return;
            }
            if (BleFeatures.getInstance().mMediaSessionListener == null) {
                this.pendingMusicCover = true;
                return;
            }
            Bitmap bitmap = BleFeatures.getInstance().mMediaSessionListener.art;
            if (bitmap == null || bitmap.isRecycled()) {
                if (i < 5) {
                    LogUtils.debug(str, "art null or recycled, scheduling retry " + (i + 1) + " (will wait 2000ms)");
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TcpServerService.this.sendMusicCoverWithRetry(i + 1);
                        }
                    }, 2000L);
                    return;
                }
                LogUtils.debug(str, "art still null after retries, using default image");
                if (this.defaultImage == null) {
                    this.defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.default_album);
                }
                bitmap = this.defaultImage;
            }
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 26 && bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                        bitmapCreateBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
                        if (bitmapCreateBitmap == null) {
                            if (this.defaultImage == null) {
                                this.defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.default_album);
                            }
                            bitmapCreateBitmap = this.defaultImage;
                        }
                    } else if (bitmap.getConfig() == null || bitmap.getConfig() == Bitmap.Config.ARGB_8888 || bitmap.getConfig() == Bitmap.Config.RGB_565) {
                        bitmapCreateBitmap = bitmap;
                    } else {
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    }
                } catch (Exception e) {
                    Log.e("TCPService", "sendMusicCover error: " + e.getMessage());
                }
            } catch (Exception unused) {
                if (this.defaultImage == null) {
                    this.defaultImage = BitmapFactory.decodeResource(getResources(), R.drawable.default_album);
                }
                bitmapCreateBitmap = this.defaultImage;
            }
            if (bitmapCreateBitmap != null) {
                try {
                    String string = bitmapCreateBitmap.getConfig() == null ? BuildConfig.TRAVIS : bitmapCreateBitmap.getConfig().toString();
                    LogUtils.debug(TAG, "softwareBitmap config=" + string + " size=" + bitmapCreateBitmap.getWidth() + "x" + bitmapCreateBitmap.getHeight());
                } catch (Exception e2) {
                    LogUtils.debug(TAG, "error reading softwareBitmap config: " + e2.getMessage());
                }
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 160, 160, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str2 = TAG;
            LogUtils.debug(str2, "compressed imageData length=" + byteArray.length);
            int length = byteArray.length;
            int i2 = length + 5;
            byte[] bArr = new byte[length + 14];
            bArr[0] = 1;
            bArr[1] = 2;
            bArr[2] = 0;
            if (i2 > 65530) {
                bArr[3] = -1;
                bArr[4] = -1;
            } else {
                bArr[3] = (byte) ((i2 >> 8) & 255);
                bArr[4] = (byte) (i2 & 255);
            }
            int i3 = length + 4;
            bArr[5] = (byte) ((i3 >> 24) & 255);
            bArr[6] = (byte) ((i3 >> 16) & 255);
            bArr[7] = (byte) ((i3 >> 8) & 255);
            bArr[8] = (byte) (i3 & 255);
            bArr[9] = 3;
            System.arraycopy(byteArray, 0, bArr, 10, length);
            int iCrc32Ethernet = crc32Ethernet(byteArray);
            bArr[length + 10] = (byte) ((iCrc32Ethernet >> 24) & 255);
            bArr[length + 11] = (byte) ((iCrc32Ethernet >> 16) & 255);
            bArr[length + 12] = (byte) ((iCrc32Ethernet >> 8) & 255);
            bArr[length + 13] = (byte) (iCrc32Ethernet & 255);
            this.pendingMusicCover = false;
            Log.d(str2, "sendMusicCover: TX docNum=3 jpegBytes=" + length);
            sendDataOverTCP(bArr);
            if (bitmapCreateScaledBitmap != bitmapCreateBitmap && bitmapCreateScaledBitmap != bitmap && bitmapCreateScaledBitmap != this.defaultImage && !bitmapCreateScaledBitmap.isRecycled()) {
                bitmapCreateScaledBitmap.recycle();
            }
            if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != this.defaultImage && !bitmapCreateBitmap.isRecycled()) {
                bitmapCreateBitmap.recycle();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void sendPhoneName() {
        Log.e("TCP", "send phone name");
        String str = BleFeatures.getInstance().phoneName;
        int length = str.length() + 5;
        byte[] bArr = new byte[length];
        bArr[0] = 1;
        bArr[1] = 2;
        bArr[2] = 5;
        bArr[3] = 0;
        bArr[4] = (byte) length;
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        sendDataOverTCP(bArr);
    }

    private void sendDateAndTime() {
        Log.e("TCP", "send date and time");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        int i = calendar.get(1);
        sendDataOverTCP(new byte[]{1, 2, 3, 0, Ascii.VT, (byte) calendar.get(12), (byte) calendar.get(10), (byte) calendar.get(5), (byte) calendar.get(2), (byte) ((i >> 8) & 255), (byte) (i & 255)});
    }

    public synchronized void sendScreenInfo() {
        byte b;
        byte b2 = (byte) 1;
        if (MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN || GlobalVar.isNavigationActive) {
            Log.e("TCPService", "send tbt screen");
            b = (byte) 3;
        } else {
            b = 2;
        }
        sendDataOverTCP(new byte[]{1, 1, 1, 0, b2, b});
    }

    public void senCommandToshowPopup() {
        Log.e("TCP", "send popu to show");
        sendDataOverTCP(new byte[]{0, 3, 0, 0, 0});
    }

    public void sendDataOverTCP(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        final byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            UdpServerService.ensureExecutors();
            UdpServerService.executors.execute(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendDataOverTCP$1(bArrCopyOf);
                }
            });
        } else {
            lambda$sendDataOverTCP$1(bArrCopyOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: writeTcpFrameLocked, reason: merged with bridge method [inline-methods] */
    public void lambda$sendDataOverTCP$1(byte[] bArr) {
        Socket socket;
        synchronized (this.tcpTxLock) {
            try {
                try {
                    if (this.mRun && (socket = this.socket) != null && !socket.isClosed()) {
                        if (this.dos == null) {
                            this.dos = this.socket.getOutputStream();
                        }
                        this.dos.write(bArr, 0, bArr.length);
                        this.dos.flush();
                        maybeMarkDocumentImageTx(bArr);
                        return;
                    }
                    if (bArr.length > 9 && bArr[1] == 2 && bArr[2] == 0 && bArr[9] == 3) {
                        this.pendingMusicCover = true;
                        Log.d(TAG, "TX dropped docNum=3 (socket down) — pendingMusicCover=true");
                    }
                } catch (IOException e) {
                    Log.e("TCPservice", "TX Error: " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void resetDocumentTxTracking() {
        Arrays.fill(this.docImageTxSentThisSession, false);
        this.docsTxToastShownThisSession = false;
    }

    private void primeCachedDocumentMetadataOnTcpReady() {
        int i = 0;
        for (int i2 = 0; i2 <= 2; i2++) {
            if (pushImageSizeResponse(i2, "tcpReady") && pushImageMd5Response(i2, "tcpReady")) {
                i++;
            }
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("doc prime complete — ");
        sb.append(i > 0 ? i + " doc(s) Size+MD5 queued" : "no cached docs");
        Log.i(str, sb.toString());
    }

    public void primeDocumentMetadataIfTcpReady(int i) {
        if (isTcpSocketReady() && i >= 0 && i <= 2 && pushImageSizeResponse(i, "cacheUpdate") && pushImageMd5Response(i, "cacheUpdate")) {
            Log.i(TAG, "doc prime after cache update docNum=" + i);
        }
    }

    private byte[] jpegPayloadForDocNum(int i) {
        if (i == 0) {
            return MirroringGlobarVar.licenseImageData;
        }
        if (i == 1) {
            return MirroringGlobarVar.registrationImageData;
        }
        if (i != 2) {
            return null;
        }
        return MirroringGlobarVar.insuranceImageData;
    }

    private boolean pushImageSizeResponse(int i, String str) {
        byte[] bArrJpegPayloadForDocNum = jpegPayloadForDocNum(i);
        if (bArrJpegPayloadForDocNum == null || bArrJpegPayloadForDocNum.length == 0) {
            return false;
        }
        int length = bArrJpegPayloadForDocNum.length + 4;
        Log.i(TAG, "doc prime ImageSize source=" + str + " docNum=" + i + " sizeWithCrc=" + length);
        sendDataOverTCP(new byte[]{1, 2, 1, 0, 5, (byte) ((length >> 24) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 8) & 255), (byte) (length & 255), (byte) (i & 255)});
        return true;
    }

    private boolean pushImageMd5Response(int i, String str) {
        byte[] bArrDigest;
        byte[] bArrJpegPayloadForDocNum = jpegPayloadForDocNum(i);
        if (bArrJpegPayloadForDocNum == null || bArrJpegPayloadForDocNum.length == 0 || (bArrDigest = Md5Util.digest(bArrJpegPayloadForDocNum)) == null || bArrDigest.length == 0) {
            return false;
        }
        byte[] bArr = new byte[22];
        bArr[0] = 1;
        bArr[1] = 2;
        bArr[2] = 2;
        bArr[3] = 0;
        bArr[4] = 17;
        bArr[5] = (byte) (i & 255);
        System.arraycopy(bArrDigest, 0, bArr, 6, Math.min(16, bArrDigest.length));
        Log.i(TAG, "doc prime ImageMD5 source=" + str + " docNum=" + i + " jpeg=" + bArrJpegPayloadForDocNum.length + "B");
        sendDataOverTCP(bArr);
        return true;
    }

    private void maybeMarkDocumentImageTx(byte[] bArr) {
        int i;
        final int i2;
        if (bArr == null || bArr.length < 10) {
            return;
        }
        int i3 = 0;
        if (bArr[0] == 1 && bArr[1] == 2 && bArr[2] == 0 && (i = bArr[9] & 255) <= 2) {
            boolean[] zArr = this.docImageTxSentThisSession;
            if (zArr[i]) {
                return;
            }
            zArr[i] = true;
            if (MirroringGlobarVar.licenseImageData == null) {
                i2 = i3;
            } else if (this.docImageTxSentThisSession[0]) {
                i3 = 1;
                i2 = i3;
            } else {
                i2 = 0;
                i3 = 1;
            }
            if (MirroringGlobarVar.registrationImageData != null) {
                i3++;
                if (this.docImageTxSentThisSession[1]) {
                    i2++;
                }
            }
            if (MirroringGlobarVar.insuranceImageData != null) {
                i3++;
                if (this.docImageTxSentThisSession[2]) {
                    i2++;
                }
            }
            Log.e("TCPservice", "Doc image TX confirmed over TCP docNum=" + i + " sent=" + i2 + RemoteSettings.FORWARD_SLASH_STRING + i3);
            if (isProdFlavor() || this.docsTxToastShownThisSession || i3 <= 0 || i2 != i3) {
                return;
            }
            this.docsTxToastShownThisSession = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.TcpServerService$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$maybeMarkDocumentImageTx$2(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeMarkDocumentImageTx$2(int i) {
        try {
            Toast.makeText(getApplicationContext(), "Sent " + i + " doc(s) to cluster", 0).show();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }

    public int crc32Ethernet(byte[] bArr) {
        int i = -1;
        for (byte b : bArr) {
            int i2 = (b ^ i) & 255;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ this.poly : i2 >>> 1;
            }
            i = (i >>> 8) ^ i2;
        }
        return ~i;
    }

    private static String hexMd5(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.TRAVIS;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Integer.valueOf(b & 255)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    private static String headerHex(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.TRAVIS;
        }
        int iMin = Math.min(10, bArr.length);
        StringBuilder sb = new StringBuilder(iMin * 3);
        for (int i = 0; i < iMin; i++) {
            sb.append(String.format("%02x", Integer.valueOf(bArr[i] & 255)));
            if (i < iMin - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String previewHex(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0 || i <= 0) {
            return "";
        }
        int iMin = Math.min(i, bArr.length);
        StringBuilder sb = new StringBuilder(iMin * 3);
        for (int i2 = 0; i2 < iMin; i2++) {
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(String.format("%02X", Integer.valueOf(bArr[i2] & 255)));
        }
        if (iMin < bArr.length) {
            sb.append(" ...");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String asciiPreview(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0 || i <= 0) {
            return "[]";
        }
        int iMin = Math.min(i, bArr.length);
        StringBuilder sb = new StringBuilder(iMin + 4);
        sb.append('[');
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = bArr[i2] & 255;
            sb.append((i3 < 32 || i3 >= 127) ? ClassUtils.PACKAGE_SEPARATOR_CHAR : (char) i3);
        }
        sb.append(']');
        if (iMin < bArr.length) {
            sb.append("...");
        }
        return sb.toString();
    }
}
