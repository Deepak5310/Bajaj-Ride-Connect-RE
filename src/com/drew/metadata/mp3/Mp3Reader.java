package com.drew.metadata.mp3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adobe.internal.xmp.XMPConst;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.StreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.avi.AviDirectory;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class Mp3Reader {
    public static int getSyncSafeSize(int i) {
        int i2 = i & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 16) & 255;
        return (((i >> 24) & 255) << 21) | i2 | (i3 << 7) | (i4 << 14);
    }

    public void extract(InputStream inputStream, Metadata metadata) {
        double d;
        Mp3Directory mp3Directory = new Mp3Directory();
        metadata.addDirectory(mp3Directory);
        try {
            inputStream.reset();
            int int32 = new StreamReader(inputStream).getInt32();
            int i = (1572864 & int32) >> 19;
            if (i == 0) {
                mp3Directory.setString(1, "MPEG-2.5");
                throw new ImageProcessingException("MPEG-2.5 not supported.");
            }
            if (i == 2) {
                mp3Directory.setString(1, "MPEG-2");
                d = 2.0d;
            } else if (i != 3) {
                d = 0.0d;
            } else {
                mp3Directory.setString(1, "MPEG-1");
                d = 1.0d;
            }
            int i2 = (393216 & int32) >> 17;
            if (i2 == 0) {
                mp3Directory.setString(2, "Not defined");
            } else if (i2 == 1) {
                mp3Directory.setString(2, "Layer III");
            } else if (i2 == 2) {
                mp3Directory.setString(2, "Layer II");
            } else if (i2 == 3) {
                mp3Directory.setString(2, "Layer I");
            }
            int i3 = (61440 & int32) >> 12;
            if (i3 != 0 && i3 != 15) {
                mp3Directory.setInt(3, setBitrate(i3, i2, d));
            }
            int i4 = (int32 & 3072) >> 10;
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 3);
            int[] iArr2 = {44100, 48000, 32000};
            iArr[0] = iArr2;
            int[] iArr3 = {22050, 24000, 16000};
            iArr[1] = iArr3;
            if (d == 2.0d) {
                mp3Directory.setInt(4, iArr3[i4]);
                i4 = iArr[1][i4];
            } else if (d == 1.0d) {
                mp3Directory.setInt(4, iArr2[i4]);
                i4 = iArr[0][i4];
            }
            int i5 = (int32 & JfifUtil.MARKER_SOFn) >> 6;
            if (i5 == 0) {
                mp3Directory.setString(5, "Stereo");
            } else if (i5 == 1) {
                mp3Directory.setString(5, "Joint stereo");
            } else if (i5 == 2) {
                mp3Directory.setString(5, "Dual channel");
            } else if (i5 == 3) {
                mp3Directory.setString(5, "Mono");
            }
            int i6 = (int32 & 8) >> 3;
            if (i6 == 0) {
                mp3Directory.setString(7, XMPConst.FALSESTR);
            } else if (i6 == 1) {
                mp3Directory.setString(7, XMPConst.TRUESTR);
            }
            int i7 = int32 & 3;
            if (i7 == 0) {
                mp3Directory.setString(6, "none");
            } else if (i7 == 1) {
                mp3Directory.setString(6, "50/15ms");
            } else if (i7 == 3) {
                mp3Directory.setString(6, "CCITT j.17");
            }
            mp3Directory.setString(8, ((setBitrate(i3, i2, d) * 144000) / i4) + " bytes");
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00a7  */
    public int setBitrate(int i, int i2, double d) {
        char c = 2;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 14, 6);
        iArr[0] = new int[]{32, 32, 32, 32, 32, 8};
        iArr[1] = new int[]{64, 48, 40, 64, 48, 16};
        iArr[2] = new int[]{96, 56, 48, 96, 56, 24};
        iArr[3] = new int[]{128, 64, 56, 128, 64, 32};
        iArr[4] = new int[]{160, 80, 64, 160, 80, 64};
        iArr[5] = new int[]{JfifUtil.MARKER_SOFn, 96, 80, JfifUtil.MARKER_SOFn, 96, 80};
        iArr[6] = new int[]{CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION, 96, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION, 56};
        iArr[7] = new int[]{256, 128, PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION, 256, 128, 64};
        iArr[8] = new int[]{288, 160, 128, 28, 160, 128};
        iArr[9] = new int[]{AviDirectory.TAG_DATETIME_ORIGINAL, JfifUtil.MARKER_SOFn, 160, AviDirectory.TAG_DATETIME_ORIGINAL, JfifUtil.MARKER_SOFn, 160};
        iArr[10] = new int[]{352, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, JfifUtil.MARKER_SOFn, 352, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION};
        iArr[11] = new int[]{BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 256, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 256, 128};
        iArr[12] = new int[]{TypedValues.CycleType.TYPE_PATH_ROTATE, AviDirectory.TAG_DATETIME_ORIGINAL, 256, TypedValues.CycleType.TYPE_PATH_ROTATE, AviDirectory.TAG_DATETIME_ORIGINAL, 256};
        iArr[13] = new int[]{448, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, AviDirectory.TAG_DATETIME_ORIGINAL, 448, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, AviDirectory.TAG_DATETIME_ORIGINAL};
        int i3 = i - 1;
        if (d == 2.0d) {
            if (i2 == 1) {
                c = 5;
            } else if (i2 == 2) {
                c = 4;
            } else if (i2 != 3) {
                c = 0;
            } else {
                c = 3;
            }
        } else if (d != 1.0d) {
            c = 0;
        } else if (i2 != 1) {
            if (i2 != 2) {
                c = 0;
            } else {
                c = 1;
            }
        }
        return iArr[i3][c];
    }
}
