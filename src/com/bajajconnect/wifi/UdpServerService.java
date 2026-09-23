package com.bajajconnect.wifi;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.collection.CircularArray;
import com.bajajconnect.NavApplication;
import com.bajajconnect.security.SecurityAES;
import com.bajajconnect.util.LogUtils;
import com.bajajconnect.utils.Util;
import com.mappls.sdk.maps.MapplsMap;
import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public class UdpServerService extends Service implements ScreenChangeCallback {
    private static final String AES_256_KEY = "Z7in5HGAGFdXXU6ZfDc8lIff4iwLY01o";
    private static final int FRAME_SIZE_ENCRYPTED = 1024;
    private static final int FRAME_SIZE_PAYLOAD = 1008;
    private static final int INITIAL_COMPRESSION_QUALITY = 50;
    private static final int MAX_IMG_SIZE = 30000;
    private static final int MAX_REENCODE_ATTEMPTS = 2;
    private static final int MIN_COMPRESSION_QUALITY = 25;
    private static final int PORT = 5556;
    private static final String TAG = "com.bajajconnect.wifi.UdpServerService";
    private static final int THRESHOLD_IMG_SIZE = 25000;
    public static ScheduledExecutorService executors;
    private CircularArray<byte[]> circularFifo;
    private InetAddress clientIp;
    private int clientPort;
    private int compressionQuality;
    byte[] data;
    public MapplsMap mapplsMap;
    private Timer navigationBackgroundTimer;
    private Timer sendDataTimer;
    private DatagramSocket serverSocket;
    private final IBinder mBinder = new LocalBinder();
    private volatile boolean sendLoopRunning = false;
    private boolean isScreenCaptureRunning = false;

    public enum CurrentImageSent {
        NONE,
        NAVIGATION_MAP,
        BACKGROUND,
        INCOMING_CALL,
        ACTIVE_CALL
    }

    public static synchronized void ensureExecutors() {
        ScheduledExecutorService scheduledExecutorService = executors;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            executors = Executors.newScheduledThreadPool(2);
        }
    }

    @Override // com.bajajconnect.wifi.ScreenChangeCallback
    public void onScreenChange() {
        try {
            if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.tcpServerService != null) {
                NavApplication.streamingHandler.tcpServerService.sendScreenInfo();
            }
        } catch (Exception e) {
            Log.w(TAG, "onScreenChange sendScreenInfo failed", e);
        }
        if (MirroringGlobarVar.currentScreen == Screens.SEARCH_SCREEN) {
            startScreenCaptures();
        }
    }

    @Override // com.bajajconnect.wifi.ScreenChangeCallback
    public void onSearchScreenUpdated(Bitmap bitmap) {
        setImage(StreamingImageHandler.getSearchScreenNew(this, bitmap));
    }

    public void startServer() {
        DatagramSocket datagramSocket;
        if (this.sendLoopRunning && (datagramSocket = this.serverSocket) != null && !datagramSocket.isClosed() && NavApplication.streamingHandler != null && NavApplication.streamingHandler.isUdpInitialised) {
            try {
                this.clientIp = InetAddress.getByName(Util.getHotspotAdress(this));
                LogUtils.debug(TAG, "UDP already running — refreshed clientIp=" + this.clientIp);
                return;
            } catch (Exception unused) {
                LogUtils.debug(TAG, "UDP already running — clientIp refresh failed");
                return;
            }
        }
        initVariables();
        ensureExecutors();
        new Thread(new Runnable() { // from class: com.bajajconnect.wifi.UdpServerService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startServer$0();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startServer$0() {
        initServer();
        if (MirroringGlobarVar.currentScreen == Screens.SEARCH_SCREEN) {
            startScreenCaptures();
        }
        startSendData();
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
        stopNavigationBackgroundTimer();
        stopSendDataTimer();
        try {
            DatagramSocket datagramSocket = this.serverSocket;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onUnbind(intent);
    }

    private void initVariables() {
        this.circularFifo = new CircularArray<>(96);
    }

    private void initServer() {
        this.compressionQuality = 50;
        this.sendLoopRunning = false;
        try {
            LogUtils.debug(TAG, "Starting UDP Server");
            DatagramSocket datagramSocket = this.serverSocket;
            if (datagramSocket != null) {
                try {
                    datagramSocket.close();
                } catch (Exception unused) {
                }
                this.serverSocket = null;
            }
            DatagramSocket datagramSocket2 = new DatagramSocket(PORT);
            this.serverSocket = datagramSocket2;
            datagramSocket2.setReuseAddress(true);
            if (MirroringGlobarVar.network != null) {
                MirroringGlobarVar.network.bindSocket(this.serverSocket);
            }
            this.serverSocket.setSendBufferSize(1024);
            String str = TAG;
            LogUtils.debug(str, "UDP Server is running... Wait the trigger");
            String hotspotAdress = Util.getHotspotAdress(this);
            this.clientIp = InetAddress.getByName(hotspotAdress);
            this.clientPort = PORT;
            NavApplication.streamingHandler.isUdpInitialised = true;
            LogUtils.debug(str, "UDP peer " + this.clientIp + " port " + this.clientPort + " gateway=" + hotspotAdress);
        } catch (Exception e) {
            NavApplication.streamingHandler.isUdpInitialised = false;
            e.printStackTrace();
        }
    }

    public void startScreenCaptures() {
        if (this.isScreenCaptureRunning) {
            return;
        }
        this.isScreenCaptureRunning = true;
        executors.schedule(new Runnable() { // from class: com.bajajconnect.wifi.UdpServerService.1
            @Override // java.lang.Runnable
            public void run() {
                UdpServerService.this.onScreenChange();
            }
        }, 1000L, TimeUnit.MILLISECONDS);
        executors.scheduleWithFixedDelay(new Runnable() { // from class: com.bajajconnect.wifi.UdpServerService$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startScreenCaptures$1();
            }
        }, 0L, 75L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScreenCaptures$1() {
        setImage(StreamingImageHandler.getSearchScreenNew(this, null));
    }

    public void stopScreenCapture() {
        this.isScreenCaptureRunning = false;
        ScheduledExecutorService scheduledExecutorService = executors;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            executors = null;
            ensureExecutors();
        }
    }

    public void setImage(Bitmap bitmap) {
        boolean z;
        SecurityAES securityAES;
        byte[] bArrEncode;
        int i;
        if (bitmap == null) {
            return;
        }
        CircularArray<byte[]> circularArray = this.circularFifo;
        if (circularArray == null || circularArray.isEmpty()) {
            try {
                if (bitmap.getWidth() == 800 && bitmap.getHeight() == 480) {
                    z = false;
                } else {
                    z = true;
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 800, StreamingImageHandler.TFT_HEIGHT, true);
                    if (bitmapCreateScaledBitmap == bitmap) {
                        z = false;
                    }
                    bitmap = bitmapCreateScaledBitmap;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(30000);
                bitmap.compress(Bitmap.CompressFormat.JPEG, this.compressionQuality, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                for (int i2 = 0; byteArray.length >= 30000 && i2 < 2 && (i = this.compressionQuality) > 25; i2++) {
                    this.compressionQuality = Math.max(25, Math.min((int) (((double) i) * (25000.0d / ((double) byteArray.length))), i - 5));
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, this.compressionQuality, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                if (z) {
                    bitmap.recycle();
                }
                int iCrc32Ethernet = crc32Ethernet(byteArray);
                int length = byteArray.length;
                if (length < 30000) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    byteArrayOutputStream2.write((byte) ((length >> 24) & 255));
                    byteArrayOutputStream2.write((byte) ((length >> 16) & 255));
                    byteArrayOutputStream2.write((byte) ((length >> 8) & 255));
                    byteArrayOutputStream2.write((byte) (length & 255));
                    int i3 = 1006;
                    byteArrayOutputStream2.write(Arrays.copyOfRange(byteArray, 0, 1006));
                    if (MirroringGlobarVar.encryptionIV != null) {
                        securityAES = new SecurityAES(MirroringGlobarVar.encryptionKey, MirroringGlobarVar.encryptionIV);
                    } else {
                        securityAES = new SecurityAES(AES_256_KEY, new byte[16]);
                    }
                    this.circularFifo.addLast(securityAES.encode(byteArrayOutputStream2.toByteArray()));
                    while (i3 < length) {
                        int i4 = i3 + 1008;
                        int i5 = (i4 > length ? length - i3 : 1008) + i3;
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(byteArray, i3, i5);
                        if (i4 >= length) {
                            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                            byteArrayOutputStream3.write(bArrCopyOfRange);
                            byteArrayOutputStream3.write((byte) ((iCrc32Ethernet >> 24) & 255));
                            byteArrayOutputStream3.write((byte) ((iCrc32Ethernet >> 16) & 255));
                            byteArrayOutputStream3.write((byte) ((iCrc32Ethernet >> 8) & 255));
                            byteArrayOutputStream3.write((byte) (iCrc32Ethernet & 255));
                            bArrEncode = securityAES.encode(byteArrayOutputStream3.toByteArray());
                        } else {
                            bArrEncode = securityAES.encode(bArrCopyOfRange);
                        }
                        this.circularFifo.addLast(bArrEncode);
                        i3 = i5;
                    }
                }
                updateCompressionQuality(length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int crc32Ethernet(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return (int) crc32.getValue();
    }

    private void updateCompressionQuality(int i) {
        if (i > THRESHOLD_IMG_SIZE) {
            int i2 = this.compressionQuality;
            if (i2 > 0) {
                this.compressionQuality = i2 - 1;
                return;
            }
            return;
        }
        int i3 = this.compressionQuality;
        if (i3 < 100) {
            this.compressionQuality = i3 + 1;
        }
    }

    private void startSendData() {
        if (this.sendLoopRunning) {
            return;
        }
        this.sendLoopRunning = true;
        new Thread(new Runnable() { // from class: com.bajajconnect.wifi.UdpServerService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startSendData$2();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSendData$2() {
        while (this.sendLoopRunning) {
            if (this.serverSocket == null) {
                try {
                    Thread.sleep(50L);
                } catch (Exception unused) {
                }
            } else if (!this.circularFifo.isEmpty()) {
                byte[] bArrPopFirst = this.circularFifo.popFirst();
                this.data = bArrPopFirst;
                if (bArrPopFirst != null) {
                    byte[] bArr = this.data;
                    this.serverSocket.send(new DatagramPacket(bArr, bArr.length, this.clientIp, this.clientPort));
                    Thread.sleep(3L);
                }
            } else {
                Thread.sleep(10L);
            }
        }
    }

    private void stopNavigationBackgroundTimer() {
        Timer timer = this.navigationBackgroundTimer;
        if (timer != null) {
            timer.cancel();
            this.navigationBackgroundTimer = null;
        }
    }

    public void stopSendDataTimer() {
        Timer timer = this.sendDataTimer;
        if (timer != null) {
            timer.cancel();
            this.sendDataTimer = null;
        }
    }

    public void stopAllTasks() {
        this.sendLoopRunning = false;
        stopScreenCapture();
        stopSendDataTimer();
        DatagramSocket datagramSocket = this.serverSocket;
        if (datagramSocket != null) {
            try {
                datagramSocket.close();
            } catch (Exception unused) {
            }
            this.serverSocket = null;
        }
        NavApplication.streamingHandler.isUdpInitialised = false;
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public UdpServerService getService() {
            return UdpServerService.this;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
    }
}
