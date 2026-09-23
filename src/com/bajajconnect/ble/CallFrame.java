package com.bajajconnect.ble;

import com.bajajconnect.ble.protocol.NewAlertsPacketV2;
import com.bajajconnect.ble.protocol.NewBtProtocolSelector;
import com.bajajconnect.ble.protocol.NewGeneralPacketV2;
import com.bajajconnect.ble.protocol.NewMissedCallPacketV2;
import com.bajajconnect.enums.Alert;
import com.bajajconnect.enums.music.PlayStatus;
import com.bajajconnect.models.SongInfo;
import com.bajajconnect.music.MusicCallbackImpl;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.common.base.Ascii;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CallFrame {
    private static final String HEXES = "0123456789ABCDEF";

    public static byte[] generalForVehicle() {
        if (NewBtProtocolSelector.useNewGeneralProtocol()) {
            return NewGeneralPacketV2.build();
        }
        return com.bajajconnect.utils.CallFrame.phoneStatusNew();
    }

    public static byte[] missedCallForVehicle(String str, String str2, long j) {
        if (NewBtProtocolSelector.useNewMissedCallProtocol()) {
            return NewMissedCallPacketV2.build(str, str2, j);
        }
        return com.bajajconnect.utils.CallFrame.missedCallFrame(str, str2, j);
    }

    public static byte[] alertsForVehicle(Alert alert, String str, long j) {
        if (NewBtProtocolSelector.useNewAlertsProtocol()) {
            return NewAlertsPacketV2.build(alert, str, j);
        }
        return com.bajajconnect.utils.CallFrame.alertsFrame(alert, str, j);
    }

    public static byte[] musicInfoForVehicle(String str, String str2, String str3, int i, int i2, PlayStatus playStatus) {
        return musicInfoFrame(str, str2, str3, i, i2, playStatus);
    }

    public static byte[] musicInfoFrame(String str, String str2, String str3, int i, int i2, PlayStatus playStatus) {
        int value;
        byte[] bArr = new byte[PanasonicMakernoteDirectory.TAG_LANDMARK];
        bArr[0] = 1;
        if (str != null) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            bArr[1] = (byte) Math.min(bytes.length, 32);
            System.arraycopy(bytes, 0, bArr, 2, Math.min(bytes.length, 32));
        }
        if (str2 != null) {
            byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
            bArr[34] = (byte) Math.min(bytes2.length, 32);
            System.arraycopy(bytes2, 0, bArr, 35, Math.min(bytes2.length, 32));
        }
        if (str3 != null) {
            byte[] bytes3 = str3.getBytes(StandardCharsets.UTF_8);
            bArr[67] = (byte) Math.min(bytes3.length, 32);
            System.arraycopy(bytes3, 0, bArr, 68, Math.min(bytes3.length, 32));
        }
        byte[] bytes4 = Util.toBytes((short) i);
        bArr[100] = bytes4[0];
        bArr[101] = bytes4[1];
        byte[] bytes5 = Util.toBytes((short) i2);
        bArr[102] = bytes5[0];
        bArr[103] = bytes5[1];
        if (playStatus != null) {
            value = playStatus.getValue();
        } else {
            value = GlobalVar.playStatus.getValue();
        }
        bArr[104] = (byte) value;
        return bArr;
    }

    public static byte[] resetPlaylist() {
        byte[] bArr = new byte[177];
        bArr[4] = (byte) GlobalVar.userChangePlaylistCounter;
        bArr[0] = (byte) (GlobalVar.pagePlaylistAck | (GlobalVar.newPlaylistAck << 6));
        bArr[5] = (byte) 31;
        return bArr;
    }

    public static byte[] playlist(List<SongInfo> list, int i) {
        byte[] bArr = new byte[177];
        bArr[1] = (byte) MusicCallbackImpl.totalsongs;
        bArr[2] = (byte) MusicCallbackImpl.totalNumberOfPages;
        bArr[3] = (byte) MusicCallbackImpl.currentTrackNumber;
        bArr[4] = (byte) GlobalVar.userChangePlaylistCounter;
        if (i == 1) {
            bArr[0] = (byte) GlobalVar.olderplaylistAck;
            bArr[5] = 9;
        } else if (i == 2) {
            bArr[0] = (byte) GlobalVar.olderplaylistAck;
            bArr[5] = 19;
        } else if (i == 3) {
            GlobalVar.olderplaylistAck = GlobalVar.pagePlaylistAck;
            bArr[0] = (byte) (GlobalVar.pagePlaylistAck | (GlobalVar.newPlaylistAck << 6));
            bArr[5] = Ascii.US;
        }
        if (list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3) {
                                if (list.get(3) != null) {
                                    try {
                                        byte[] bytes = list.get(3).getPrimaryInfo().getBytes(StandardCharsets.UTF_8);
                                        bArr[105] = (byte) Math.min(bytes.length, 32);
                                        System.arraycopy(bytes, 0, bArr, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN, Math.min(bytes.length, 32));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i2 == 4 && list.get(4) != null) {
                                try {
                                    byte[] bytes2 = list.get(4).getPrimaryInfo().getBytes(StandardCharsets.UTF_8);
                                    bArr[138] = (byte) Math.min(bytes2.length, 32);
                                    System.arraycopy(bytes2, 0, bArr, NikonType2MakernoteDirectory.TAG_LENS_STOPS, Math.min(bytes2.length, 32));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else if (list.get(2) != null) {
                            try {
                                byte[] bytes3 = list.get(2).getPrimaryInfo().getBytes(StandardCharsets.UTF_8);
                                bArr[72] = (byte) Math.min(bytes3.length, 32);
                                System.arraycopy(bytes3, 0, bArr, 73, Math.min(bytes3.length, 32));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else if (list.get(1) != null) {
                        try {
                            byte[] bytes4 = list.get(1).getPrimaryInfo().getBytes(StandardCharsets.UTF_8);
                            bArr[39] = (byte) Math.min(bytes4.length, 32);
                            System.arraycopy(bytes4, 0, bArr, 40, Math.min(bytes4.length, 32));
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } else if (list.get(0) != null) {
                    try {
                        byte[] bytes5 = list.get(i2).getPrimaryInfo().getBytes(StandardCharsets.UTF_8);
                        bArr[6] = (byte) Math.min(bytes5.length, 32);
                        System.arraycopy(bytes5, 0, bArr, 7, Math.min(bytes5.length, 32));
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        return bArr;
    }

    static String getHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(HEXES.charAt((b & 240) >> 4));
            sb.append(HEXES.charAt(b & Ascii.SI));
        }
        return sb.toString();
    }
}
