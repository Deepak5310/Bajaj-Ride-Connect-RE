package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessReader;
import com.drew.lang.Rational;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class TiffReader {
    private static int calculateTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public void processTiff(RandomAccessReader randomAccessReader, TiffHandler tiffHandler, int i) throws Throwable {
        short int16 = randomAccessReader.getInt16(i);
        if (int16 == 19789) {
            randomAccessReader.setMotorolaByteOrder(true);
        } else if (int16 == 18761) {
            randomAccessReader.setMotorolaByteOrder(false);
        } else {
            throw new TiffProcessingException("Unclear distinction between Motorola/Intel byte ordering: " + ((int) int16));
        }
        tiffHandler.setTiffMarker(randomAccessReader.getUInt16(i + 2));
        int int32 = randomAccessReader.getInt32(i + 4) + i;
        if (int32 >= randomAccessReader.getLength() - 1) {
            tiffHandler.warn("First IFD offset is beyond the end of the TIFF data segment -- trying default offset");
            int32 = i + 8;
        }
        processIfd(tiffHandler, randomAccessReader, new HashSet(), int32, i);
    }

    public static void processIfd(TiffHandler tiffHandler, RandomAccessReader randomAccessReader, Set<Integer> set, int i, int i2) throws Throwable {
        long componentSizeBytes;
        long j;
        int i3;
        boolean z;
        Boolean boolValueOf = null;
        try {
            if (set.contains(Integer.valueOf(i))) {
                tiffHandler.endingIFD();
                return;
            }
            set.add(Integer.valueOf(i));
            if (i < randomAccessReader.getLength() && i >= 0) {
                int uInt16 = randomAccessReader.getUInt16(i);
                if (uInt16 > 255 && (uInt16 & 255) == 0) {
                    boolValueOf = Boolean.valueOf(randomAccessReader.isMotorolaByteOrder());
                    uInt16 >>= 8;
                    randomAccessReader.setMotorolaByteOrder(!randomAccessReader.isMotorolaByteOrder());
                }
                Boolean bool = boolValueOf;
                int i4 = uInt16;
                try {
                    try {
                        if ((i4 * 12) + 6 + i > randomAccessReader.getLength()) {
                            tiffHandler.error("Illegally sized IFD");
                            tiffHandler.endingIFD();
                            if (bool != null) {
                                randomAccessReader.setMotorolaByteOrder(bool.booleanValue());
                                return;
                            }
                            return;
                        }
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < i4) {
                            int iCalculateTagOffset = calculateTagOffset(i, i5);
                            int uInt17 = randomAccessReader.getUInt16(iCalculateTagOffset);
                            int uInt18 = randomAccessReader.getUInt16(iCalculateTagOffset + 2);
                            TiffDataFormat tiffDataFormatFromTiffFormatCode = TiffDataFormat.fromTiffFormatCode(uInt18);
                            long uInt32 = randomAccessReader.getUInt32(iCalculateTagOffset + 4);
                            try {
                                if (tiffDataFormatFromTiffFormatCode == null) {
                                    Long lTryCustomProcessFormat = tiffHandler.tryCustomProcessFormat(uInt17, uInt18, uInt32);
                                    if (lTryCustomProcessFormat == null) {
                                        tiffHandler.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", Integer.valueOf(uInt18), Integer.valueOf(uInt17)));
                                        int i7 = i6 + 1;
                                        if (i7 > 5) {
                                            tiffHandler.error("Stopping processing as too many errors seen in TIFF IFD");
                                            tiffHandler.endingIFD();
                                            if (bool != null) {
                                                randomAccessReader.setMotorolaByteOrder(bool.booleanValue());
                                                return;
                                            }
                                            return;
                                        }
                                        i6 = i7;
                                    } else {
                                        componentSizeBytes = lTryCustomProcessFormat.longValue();
                                    }
                                    i3 = i5;
                                    bool = bool;
                                    i4 = i4;
                                    i5 = i3 + 1;
                                    i4 = i4;
                                    bool = bool;
                                } else {
                                    componentSizeBytes = ((long) tiffDataFormatFromTiffFormatCode.getComponentSizeBytes()) * uInt32;
                                }
                                if (componentSizeBytes > 4) {
                                    long uInt33 = randomAccessReader.getUInt32(iCalculateTagOffset + 8);
                                    if (uInt33 + componentSizeBytes > randomAccessReader.getLength()) {
                                        tiffHandler.error("Illegal TIFF tag pointer offset");
                                        i3 = i5;
                                        bool = bool;
                                        i4 = i4;
                                        i5 = i3 + 1;
                                        i4 = i4;
                                        bool = bool;
                                    } else {
                                        j = ((long) i2) + uInt33;
                                    }
                                } else {
                                    j = iCalculateTagOffset + 8;
                                }
                                i5 = i3 + 1;
                                i4 = i4;
                                bool = bool;
                            } catch (Throwable th) {
                                th = th;
                            }
                            if (j < 0 || j > randomAccessReader.getLength()) {
                                i3 = i5;
                                tiffHandler.error("Illegal TIFF tag pointer offset");
                            } else if (componentSizeBytes < 0 || j + componentSizeBytes > randomAccessReader.getLength()) {
                                i3 = i5;
                                tiffHandler.error("Illegal number of bytes for TIFF tag data: " + componentSizeBytes);
                            } else {
                                long j2 = componentSizeBytes;
                                if (componentSizeBytes == 4 * uInt32) {
                                    z = false;
                                    for (int i8 = 0; i8 < uInt32; i8++) {
                                        if (tiffHandler.tryEnterSubIfd(uInt17)) {
                                            processIfd(tiffHandler, randomAccessReader, set, randomAccessReader.getInt32((int) (((long) (i8 * 4)) + j)) + i2, i2);
                                            z = true;
                                        }
                                    }
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    i3 = i5;
                                } else {
                                    int i9 = (int) j;
                                    i3 = i5;
                                    if (!tiffHandler.customProcessTag(i9, set, i2, randomAccessReader, uInt17, (int) j2)) {
                                        processTag(tiffHandler, uInt17, i9, (int) uInt32, uInt18, randomAccessReader);
                                    }
                                }
                            }
                        }
                        bool = bool;
                        int int32 = randomAccessReader.getInt32(calculateTagOffset(i, i4));
                        if (int32 != 0) {
                            int i10 = int32 + i2;
                            if (i10 >= randomAccessReader.getLength()) {
                                tiffHandler.endingIFD();
                                if (bool != null) {
                                    randomAccessReader.setMotorolaByteOrder(bool.booleanValue());
                                    return;
                                }
                                return;
                            }
                            if (i10 < i) {
                                tiffHandler.endingIFD();
                                if (bool != null) {
                                    randomAccessReader.setMotorolaByteOrder(bool.booleanValue());
                                    return;
                                }
                                return;
                            }
                            if (tiffHandler.hasFollowerIfd()) {
                                processIfd(tiffHandler, randomAccessReader, set, i10, i2);
                            }
                        }
                        tiffHandler.endingIFD();
                        if (bool != null) {
                            randomAccessReader.setMotorolaByteOrder(bool.booleanValue());
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        boolValueOf = bool;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bool = bool;
                }
                boolValueOf = bool;
                tiffHandler.endingIFD();
                if (boolValueOf != null) {
                    randomAccessReader.setMotorolaByteOrder(boolValueOf.booleanValue());
                }
                throw th;
            }
            tiffHandler.error("Ignored IFD marked to start outside data segment");
            tiffHandler.endingIFD();
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void processTag(TiffHandler tiffHandler, int i, int i2, int i3, int i4, RandomAccessReader randomAccessReader) throws IOException {
        int i5 = 0;
        switch (i4) {
            case 1:
                if (i3 == 1) {
                    tiffHandler.setInt8u(i, randomAccessReader.getUInt8(i2));
                } else {
                    short[] sArr = new short[i3];
                    while (i5 < i3) {
                        sArr[i5] = randomAccessReader.getUInt8(i2 + i5);
                        i5++;
                    }
                    tiffHandler.setInt8uArray(i, sArr);
                }
                break;
            case 2:
                tiffHandler.setString(i, randomAccessReader.getNullTerminatedStringValue(i2, i3, null));
                break;
            case 3:
                if (i3 == 1) {
                    tiffHandler.setInt16u(i, randomAccessReader.getUInt16(i2));
                } else {
                    int[] iArr = new int[i3];
                    while (i5 < i3) {
                        iArr[i5] = randomAccessReader.getUInt16((i5 * 2) + i2);
                        i5++;
                    }
                    tiffHandler.setInt16uArray(i, iArr);
                }
                break;
            case 4:
                if (i3 == 1) {
                    tiffHandler.setInt32u(i, randomAccessReader.getUInt32(i2));
                } else {
                    long[] jArr = new long[i3];
                    while (i5 < i3) {
                        jArr[i5] = randomAccessReader.getUInt32((i5 * 4) + i2);
                        i5++;
                    }
                    tiffHandler.setInt32uArray(i, jArr);
                }
                break;
            case 5:
                if (i3 == 1) {
                    tiffHandler.setRational(i, new Rational(randomAccessReader.getUInt32(i2), randomAccessReader.getUInt32(i2 + 4)));
                } else if (i3 > 1) {
                    Rational[] rationalArr = new Rational[i3];
                    while (i5 < i3) {
                        int i6 = i5 * 8;
                        rationalArr[i5] = new Rational(randomAccessReader.getUInt32(i2 + i6), randomAccessReader.getUInt32(i2 + 4 + i6));
                        i5++;
                    }
                    tiffHandler.setRationalArray(i, rationalArr);
                }
                break;
            case 6:
                if (i3 == 1) {
                    tiffHandler.setInt8s(i, randomAccessReader.getInt8(i2));
                } else {
                    byte[] bArr = new byte[i3];
                    while (i5 < i3) {
                        bArr[i5] = randomAccessReader.getInt8(i2 + i5);
                        i5++;
                    }
                    tiffHandler.setInt8sArray(i, bArr);
                }
                break;
            case 7:
                tiffHandler.setByteArray(i, randomAccessReader.getBytes(i2, i3));
                break;
            case 8:
                if (i3 == 1) {
                    tiffHandler.setInt16s(i, randomAccessReader.getInt16(i2));
                } else {
                    short[] sArr2 = new short[i3];
                    while (i5 < i3) {
                        sArr2[i5] = randomAccessReader.getInt16((i5 * 2) + i2);
                        i5++;
                    }
                    tiffHandler.setInt16sArray(i, sArr2);
                }
                break;
            case 9:
                if (i3 == 1) {
                    tiffHandler.setInt32s(i, randomAccessReader.getInt32(i2));
                } else {
                    int[] iArr2 = new int[i3];
                    while (i5 < i3) {
                        iArr2[i5] = randomAccessReader.getInt32((i5 * 4) + i2);
                        i5++;
                    }
                    tiffHandler.setInt32sArray(i, iArr2);
                }
                break;
            case 10:
                if (i3 == 1) {
                    tiffHandler.setRational(i, new Rational(randomAccessReader.getInt32(i2), randomAccessReader.getInt32(i2 + 4)));
                } else if (i3 > 1) {
                    Rational[] rationalArr2 = new Rational[i3];
                    while (i5 < i3) {
                        int i7 = i5 * 8;
                        rationalArr2[i5] = new Rational(randomAccessReader.getInt32(i2 + i7), randomAccessReader.getInt32(i2 + 4 + i7));
                        i5++;
                    }
                    tiffHandler.setRationalArray(i, rationalArr2);
                }
                break;
            case 11:
                if (i3 == 1) {
                    tiffHandler.setFloat(i, randomAccessReader.getFloat32(i2));
                } else {
                    float[] fArr = new float[i3];
                    while (i5 < i3) {
                        fArr[i5] = randomAccessReader.getFloat32((i5 * 4) + i2);
                        i5++;
                    }
                    tiffHandler.setFloatArray(i, fArr);
                }
                break;
            case 12:
                if (i3 == 1) {
                    tiffHandler.setDouble(i, randomAccessReader.getDouble64(i2));
                } else {
                    double[] dArr = new double[i3];
                    while (i5 < i3) {
                        dArr[i5] = randomAccessReader.getDouble64((i5 * 4) + i2);
                        i5++;
                    }
                    tiffHandler.setDoubleArray(i, dArr);
                }
                break;
            default:
                tiffHandler.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", Integer.valueOf(i4), Integer.valueOf(i)));
                break;
        }
    }
}
