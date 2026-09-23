package com.bajajconnect.wifi;

import com.bajajconnect.security.SecurityAES;
import com.bajajconnect.util.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class UdpServerThread extends Thread {
    private static final String AES_256_KEY = "Z7in5HGAGFdXXU6ZfDc8lIff4iwLY01o";
    private static final int FRAME_PERIOD_MS = 1;
    private static final int FRAME_SIZE = 1008;
    private static final int IMAGE_PERIOD_MS = 33;
    private static final int PORT = 5556;
    private static final byte STREAMING_TRIGGER = 5;
    private static final String TAG = "com.bajajconnect.wifi.UdpServerThread";
    private InetAddress clientIp;
    private int clientPort;
    private ArrayBlockingQueue<byte[]> framesToSend;
    private InputStream inputStream;
    private DatagramSocket serverSocket;

    private void loadImage() throws Exception {
        int iAvailable = this.inputStream.available();
        byte[] bArr = new byte[iAvailable];
        this.inputStream.read(bArr);
        LogUtils.debug(TAG, "Total size image to send: " + iAvailable);
        this.framesToSend = new ArrayBlockingQueue<>(40);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write((byte) ((iAvailable >> 8) & 255));
        byteArrayOutputStream.write((byte) (iAvailable & 255));
        int i = 1006;
        byteArrayOutputStream.write(Arrays.copyOfRange(bArr, 0, 1006));
        SecurityAES securityAES = new SecurityAES(AES_256_KEY, new byte[16]);
        this.framesToSend.offer(securityAES.encode(byteArrayOutputStream.toByteArray()));
        while (i < iAvailable) {
            int i2 = (i + 1008 > iAvailable ? iAvailable - i : 1008) + i;
            this.framesToSend.offer((byte[]) securityAES.encode(Arrays.copyOfRange(bArr, i, i2)).clone());
            i = i2;
        }
    }

    private void startServer() throws Exception {
        String str = TAG;
        LogUtils.debug(str, "Starting UDP Server");
        this.serverSocket = new DatagramSocket(PORT);
        LogUtils.debug(str, "UDP Server is running... Wait the trigger");
        byte[] bArr = new byte[8];
        DatagramPacket datagramPacket = new DatagramPacket(bArr, 8);
        this.serverSocket.receive(datagramPacket);
        LogUtils.debug(str, "Trigger received length 8 Content " + Arrays.toString(bArr));
        if (bArr[0] != 5) {
            LogUtils.error(str, "Trigger not valid");
            return;
        }
        this.clientIp = datagramPacket.getAddress();
        this.clientPort = datagramPacket.getPort();
        LogUtils.debug(str, "Packet received from " + this.clientIp + " port " + this.clientPort);
    }

    private void sendImages() {
        LogUtils.debug(TAG, "sendImages");
        new Timer().scheduleAtFixedRate(new TimerTask() { // from class: com.bajajconnect.wifi.UdpServerThread.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                for (byte[] bArr : UdpServerThread.this.framesToSend) {
                    try {
                        UdpServerThread.this.serverSocket.send(new DatagramPacket(bArr, bArr.length, UdpServerThread.this.clientIp, UdpServerThread.this.clientPort));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0L, 33L);
    }

    private void sendOneImageFrame() throws Exception {
        LogUtils.debug(TAG, "sendOneImageFrame");
        byte[] bArrPoll = this.framesToSend.poll();
        while (true) {
            this.serverSocket.send(new DatagramPacket(bArrPoll, bArrPoll.length, this.clientIp, this.clientPort));
        }
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            loadImage();
            startServer();
            sendImages();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
