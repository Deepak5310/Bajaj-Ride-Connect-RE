package com.bajajconnect.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.RouteInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.bajajconnect.wifi.TcpServerService;
import com.google.common.base.Ascii;
import j$.time.Instant;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class Util {
    public static int bitExtracted(int i, int i2, int i3) {
        return (i >> (i3 - 1)) & ((1 << i2) - 1);
    }

    public static short getShort(byte[] bArr) {
        byte b = bArr[0];
        return (short) ((bArr[1] & 255) | (b << 8));
    }

    public static byte[] toBytes(short s) {
        return new byte[]{(byte) ((65280 & s) >> 8), (byte) (s & 255)};
    }

    public static byte[] shortToBytes(short s) {
        return new byte[]{(byte) ((s >>> 8) & 255), (byte) (s & 255)};
    }

    public static String toHex(String str) {
        return String.format("%x", new BigInteger(1, str.getBytes()));
    }

    public static byte[] decodeHexString(String str) {
        if (str.length() % 2 == 1) {
            throw new IllegalArgumentException("Invalid hexadecimal String supplied.");
        }
        byte[] bArr = new byte[str.length() / 2];
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            bArr[i / 2] = hexToByte(str.substring(i, i2));
            i = i2;
        }
        return bArr;
    }

    public static String byteToHex(byte b) {
        return new String(new char[]{Character.forDigit((b >> 4) & 15, 16), Character.forDigit(b & Ascii.SI, 16)});
    }

    public static byte hexToByte(String str) {
        return (byte) ((toDigit(str.charAt(0)) << 4) + toDigit(str.charAt(1)));
    }

    private static int toDigit(char c) {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new IllegalArgumentException("Invalid Hexadecimal Character: " + c);
    }

    public static String getHotspotAdress(Context context) {
        LinkProperties linkProperties;
        String hostAddress;
        DhcpInfo dhcpInfo;
        if (MirroringGlobarVar.network != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null && (linkProperties = connectivityManager.getLinkProperties(MirroringGlobarVar.network)) != null) {
                    for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                        if (routeInfo.isDefaultRoute() && routeInfo.getGateway() != null && (hostAddress = routeInfo.getGateway().getHostAddress()) != null && !hostAddress.isEmpty() && !hostAddress.startsWith("fe80:") && !hostAddress.equals("0.0.0.0")) {
                            Log.d("Wifi Class", "cluster gateway via LinkProperties: " + hostAddress);
                            return hostAddress;
                        }
                    }
                }
            } catch (Exception e) {
                Log.w("Wifi Class", "LinkProperties gateway lookup failed", e);
            }
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null && dhcpInfo.gateway != 0) {
                int iReverseBytes = dhcpInfo.gateway;
                if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                    iReverseBytes = Integer.reverseBytes(iReverseBytes);
                }
                String hostAddress2 = InetAddress.getByAddress(BigInteger.valueOf(iReverseBytes).toByteArray()).getHostAddress();
                if (hostAddress2 != null && !hostAddress2.equals("0.0.0.0")) {
                    Log.d("Wifi Class", "cluster gateway via DhcpInfo: " + hostAddress2);
                    return hostAddress2;
                }
            }
        } catch (Exception e2) {
            Log.e("Wifi Class", "Error getting Hotspot IP address ", e2);
        }
        Log.w("Wifi Class", "cluster gateway fallback 192.168.4.1");
        return TcpServerService.IP;
    }

    public static byte[] timeToByte(String str, String str2) {
        byte[] bArr = new byte[4];
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes2 = str2.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length <= 2) {
            if (bytes.length == 1) {
                bArr[0] = 0;
                bArr[1] = bytes[0];
            } else {
                bArr[0] = bytes[0];
                bArr[1] = bytes[1];
            }
        }
        if (bytes2.length <= 2) {
            if (bytes2.length == 1) {
                bArr[2] = 0;
                bArr[3] = bytes2[0];
            } else {
                bArr[2] = bytes2[0];
                bArr[3] = bytes2[1];
            }
        }
        return bArr;
    }

    public static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        byteBufferAllocate.rewind();
        return byteBufferAllocate.array();
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i) {
        int i2;
        float width = bitmap.getWidth() / bitmap.getHeight();
        if (width > 1.0f) {
            i2 = (int) (i / width);
        } else {
            int i3 = (int) (i * width);
            i2 = i;
            i = i3;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static byte[] to4Bytes(long j) {
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & (-16777216)) >> 16)};
    }

    public static byte[] longToBytes(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putLong(j);
        return byteBufferAllocate.array();
    }

    public static byte[] longToBytes2(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    public static String toHex(int i) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String str = "";
        while (i > 0) {
            str = cArr[i % 16] + str;
            i /= 16;
        }
        return str;
    }

    public static long getTimeStamp() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Instant.now().getEpochSecond();
        }
        return System.currentTimeMillis() / 1000;
    }

    public static void createNetworkRouteMobile(Context context) {
        MirroringPolicy.ensureCellularNetworkForRouting(context);
    }
}
