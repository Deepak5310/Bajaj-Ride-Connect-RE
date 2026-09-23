package com.drew.metadata.photoshop;

import com.drew.lang.ByteArrayReader;
import com.drew.lang.Charsets;
import com.drew.metadata.TagDescriptor;
import com.google.android.material.timepicker.TimeModel;
import de.patwoz.rn.bluetoothstatemanager.Constants;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import kotlin.text.Typography;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class PhotoshopDescriptor extends TagDescriptor<PhotoshopDirectory> {
    public PhotoshopDescriptor(PhotoshopDirectory photoshopDirectory) {
        super(photoshopDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i != 1002) {
            if (i == 1005) {
                return getResolutionInfoDescription();
            }
            if (i == 1028) {
                return getBinaryDataString(i);
            }
            if (i != 1030) {
                if (i != 1044 && i != 1054) {
                    if (i == 1057) {
                        return getVersionDescription();
                    }
                    if (i == 1062) {
                        return getPrintScaleDescription();
                    }
                    if (i == 1064) {
                        return getPixelAspectRatioString();
                    }
                    if (i == 2999) {
                        return getClippingPathNameString(i);
                    }
                    if (i != 1049) {
                        if (i != 1050) {
                            switch (i) {
                                case PhotoshopDirectory.TAG_THUMBNAIL_OLD /* 1033 */:
                                case PhotoshopDirectory.TAG_THUMBNAIL /* 1036 */:
                                    return getThumbnailDescription(i);
                                case PhotoshopDirectory.TAG_COPYRIGHT /* 1034 */:
                                    return getBooleanString(i);
                                case PhotoshopDirectory.TAG_URL /* 1035 */:
                                    break;
                                case 1037:
                                    break;
                                default:
                                    if (i >= 2000 && i <= 2998) {
                                        return getPathString(i);
                                    }
                                    return super.getDescription(i);
                            }
                        } else {
                            return getSlicesDescription();
                        }
                    }
                }
                return get32BitNumberString(i);
            }
            return getJpegQualityString();
        }
        return getSimpleString(i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x0053  */
    public String getJpegQualityString() {
        int i;
        String str;
        String str2;
        String str3;
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(1030);
            if (byteArray == null) {
                return ((PhotoshopDirectory) this._directory).getString(1030);
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int uInt16 = byteArrayReader.getUInt16(0);
            int uInt17 = byteArrayReader.getUInt16(2);
            int uInt18 = byteArrayReader.getUInt16(4);
            if (uInt16 > 65535 || uInt16 < 65533) {
                i = uInt16 <= 8 ? uInt16 + 4 : uInt16;
            } else {
                i = uInt16 - 65532;
            }
            switch (uInt16) {
                case 0:
                    str = "Low";
                    break;
                case 1:
                case 2:
                case 3:
                    str = "Medium";
                    break;
                case 4:
                case 5:
                    str = "High";
                    break;
                case 6:
                case 7:
                case 8:
                    str = "Maximum";
                    break;
                default:
                    switch (uInt16) {
                        case Utf8.REPLACEMENT_CODE_POINT /* 65533 */:
                        case 65534:
                        case 65535:
                            str = "Low";
                            break;
                        default:
                            str = Constants.BluetoothState.UNKNOWN;
                            break;
                    }
                    break;
            }
            if (uInt17 == 0) {
                str2 = "Standard";
            } else if (uInt17 == 1) {
                str2 = "Optimised";
            } else if (uInt17 != 257) {
                str2 = String.format("Unknown 0x%04X", Integer.valueOf(uInt17));
            } else {
                str2 = "Progressive";
            }
            if (uInt18 < 1 || uInt18 > 3) {
                str3 = String.format("Unknown 0x%04X", Integer.valueOf(uInt18));
            } else {
                str3 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(uInt18 + 2));
            }
            return String.format("%d (%s), %s format, %s scans", Integer.valueOf(i), str, str2, str3);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getPixelAspectRatioString() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_PIXEL_ASPECT_RATIO);
            if (byteArray == null) {
                return null;
            }
            return Double.toString(new ByteArrayReader(byteArray).getDouble64(4));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getPrintScaleDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_PRINT_SCALE);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(0);
            float float32 = byteArrayReader.getFloat32(2);
            float float33 = byteArrayReader.getFloat32(6);
            float float34 = byteArrayReader.getFloat32(10);
            if (int32 == 0) {
                return "Centered, Scale " + float34;
            }
            if (int32 == 1) {
                return "Size to fit";
            }
            if (int32 == 2) {
                return String.format("User defined, X:%s Y:%s, Scale:%s", Float.valueOf(float32), Float.valueOf(float33), Float.valueOf(float34));
            }
            return String.format("Unknown %04X, X:%s Y:%s, Scale:%s", Integer.valueOf(int32), Float.valueOf(float32), Float.valueOf(float33), Float.valueOf(float34));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getResolutionInfoDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(1005);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            float s15Fixed16 = byteArrayReader.getS15Fixed16(0);
            float s15Fixed17 = byteArrayReader.getS15Fixed16(8);
            DecimalFormat decimalFormat = new DecimalFormat("0.##");
            return decimalFormat.format(s15Fixed16) + "x" + decimalFormat.format(s15Fixed17) + " DPI";
        } catch (Exception unused) {
            return null;
        }
    }

    public String getVersionDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(PhotoshopDirectory.TAG_VERSION);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(0);
            int int33 = byteArrayReader.getInt32(5) * 2;
            String string = byteArrayReader.getString(9, int33, CharEncoding.UTF_16);
            int int34 = byteArrayReader.getInt32(9 + int33);
            int i = int33 + 13;
            int i2 = int34 * 2;
            return String.format("%d (%s, %s) %d", Integer.valueOf(int32), string, byteArrayReader.getString(i, i2, CharEncoding.UTF_16), Integer.valueOf(byteArrayReader.getInt32(i + i2)));
        } catch (IOException unused) {
            return null;
        }
    }

    public String getSlicesDescription() {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(1050);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(20) * 2;
            return String.format("%s (%d,%d,%d,%d) %d Slices", byteArrayReader.getString(24, int32, CharEncoding.UTF_16), Integer.valueOf(byteArrayReader.getInt32(4)), Integer.valueOf(byteArrayReader.getInt32(8)), Integer.valueOf(byteArrayReader.getInt32(12)), Integer.valueOf(byteArrayReader.getInt32(16)), Integer.valueOf(byteArrayReader.getInt32(int32 + 24)));
        } catch (IOException unused) {
            return null;
        }
    }

    public String getThumbnailDescription(int i) {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int32 = byteArrayReader.getInt32(0);
            int int33 = byteArrayReader.getInt32(4);
            int int34 = byteArrayReader.getInt32(8);
            int int35 = byteArrayReader.getInt32(16);
            int int36 = byteArrayReader.getInt32(20);
            return String.format("%s, %dx%d, Decomp %d bytes, %d bpp, %d bytes", int32 == 1 ? "JpegRGB" : "RawRGB", Integer.valueOf(int33), Integer.valueOf(int34), Integer.valueOf(int35), Integer.valueOf(byteArrayReader.getInt32(24)), Integer.valueOf(int36));
        } catch (IOException unused) {
            return null;
        }
    }

    private String getBooleanString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return byteArray[0] == 0 ? "No" : "Yes";
    }

    private String get32BitNumberString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        try {
            return String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(new ByteArrayReader(byteArray).getInt32(0)));
        } catch (IOException unused) {
            return null;
        }
    }

    private String getSimpleString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        return new String(byteArray);
    }

    private String getBinaryDataString(int i) {
        byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        return String.format("%d bytes binary data", Integer.valueOf(byteArray.length));
    }

    public String getClippingPathNameString(int i) {
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            return new String(byteArrayReader.getBytes(1, byteArrayReader.getByte(0)), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public String getPathString(int i) {
        int i2;
        short s;
        Knot knot;
        ByteArrayReader byteArrayReader;
        Subpath subpath;
        Knot knot2;
        String str = ")";
        String str2 = ",";
        try {
            byte[] byteArray = ((PhotoshopDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return null;
            }
            ByteArrayReader byteArrayReader2 = new ByteArrayReader(byteArray);
            short s2 = 1;
            int length = ((int) ((byteArrayReader2.getLength() - ((long) byteArrayReader2.getByte(((int) byteArrayReader2.getLength()) - 1))) - 1)) / 26;
            Subpath subpath2 = new Subpath();
            Subpath subpath3 = new Subpath();
            ArrayList<Subpath> arrayList = new ArrayList();
            String str3 = null;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 * 26;
                try {
                    short int16 = byteArrayReader2.getInt16(i4);
                    if (int16 == 0) {
                        str = str;
                        str2 = str2;
                        length = length;
                        i2 = i3;
                        if (subpath2.size() != 0) {
                            arrayList.add(subpath2);
                        }
                        subpath2 = new Subpath("Closed Subpath");
                    } else {
                        i2 = i3;
                        if (int16 == s2) {
                            s = s2;
                        } else if (int16 != 2) {
                            if (int16 == 3) {
                                str = str;
                                str2 = str2;
                                length = length;
                                byteArrayReader = byteArrayReader2;
                                subpath = subpath2;
                                if (subpath3.size() != 0) {
                                    arrayList.add(subpath3);
                                }
                                subpath3 = new Subpath("Open Subpath");
                            } else {
                                short s3 = 4;
                                if (int16 != 4) {
                                    if (int16 != 5) {
                                        if (int16 == 8) {
                                            if (byteArrayReader2.getInt16(i4 + 2) == 1) {
                                                str3 = "with all pixels";
                                            } else {
                                                str3 = "without all pixels";
                                            }
                                        }
                                        str = str;
                                        str2 = str2;
                                        length = length;
                                    } else {
                                        s3 = 4;
                                    }
                                }
                                if (int16 == s3) {
                                    knot2 = new Knot("Linked");
                                } else {
                                    knot2 = new Knot("Unlinked");
                                }
                                int i5 = 0;
                                while (i5 < 6) {
                                    int i6 = i5 * 4;
                                    knot2.setPoint(i5, ((double) byteArrayReader2.getInt8(i6 + 2 + i4)) + (((double) byteArrayReader2.getInt24((i6 + 3) + i4)) / Math.pow(2.0d, 24.0d)));
                                    i5++;
                                    length = length;
                                    str = str;
                                    str2 = str2;
                                    byteArrayReader2 = byteArrayReader2;
                                    subpath2 = subpath2;
                                }
                                str = str;
                                str2 = str2;
                                length = length;
                                byteArrayReader = byteArrayReader2;
                                subpath = subpath2;
                                subpath3.add(knot2);
                            }
                            byteArrayReader2 = byteArrayReader;
                            subpath2 = subpath;
                        } else {
                            s = 1;
                        }
                        if (int16 == s) {
                            knot = new Knot("Linked");
                        } else {
                            knot = new Knot("Unlinked");
                        }
                        int i7 = 0;
                        while (i7 < 6) {
                            int i8 = i7 * 4;
                            ByteArrayReader byteArrayReader3 = byteArrayReader2;
                            knot.setPoint(i7, ((double) byteArrayReader3.getInt8(i8 + 2 + i4)) + (((double) byteArrayReader3.getInt24((i8 + 3) + i4)) / Math.pow(2.0d, 24.0d)));
                            i7++;
                            i4 = i4;
                            byteArrayReader2 = byteArrayReader3;
                        }
                        byteArrayReader2 = byteArrayReader2;
                        subpath2 = subpath2;
                        subpath2.add(knot);
                    }
                    i3 = i2 + 1;
                    length = length;
                    str = str;
                    str2 = str2;
                    s2 = 1;
                } catch (Exception unused) {
                    return null;
                }
            }
            String str4 = str;
            String str5 = str2;
            if (subpath2.size() != 0) {
                arrayList.add(subpath2);
            }
            if (subpath3.size() != 0) {
                arrayList.add(subpath3);
            }
            byte b = byteArrayReader2.getByte(((int) byteArrayReader2.getLength()) - 1);
            String string = byteArrayReader2.getString((((int) byteArrayReader2.getLength()) - b) - 1, b, Charsets.ASCII);
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            sb.append(string);
            sb.append(Typography.quote);
            sb.append(" having ");
            if (str3 != null) {
                sb.append("initial fill rule \"");
                sb.append(str3);
                sb.append("\" and ");
            }
            sb.append(arrayList.size());
            sb.append(arrayList.size() == 1 ? " subpath:" : " subpaths:");
            for (Subpath subpath4 : arrayList) {
                sb.append("\n- ");
                sb.append(subpath4.getType());
                sb.append(" with ");
                sb.append(arrayList.size());
                sb.append(arrayList.size() == 1 ? " knot:" : " knots:");
                for (Knot knot3 : subpath4.getKnots()) {
                    sb.append("\n  - ");
                    sb.append(knot3.getType());
                    sb.append(" (");
                    sb.append(knot3.getPoint(0));
                    String str6 = str5;
                    sb.append(str6);
                    sb.append(knot3.getPoint(1));
                    String str7 = str4;
                    sb.append(str7);
                    sb.append(" (");
                    sb.append(knot3.getPoint(2));
                    sb.append(str6);
                    sb.append(knot3.getPoint(3));
                    sb.append(str7);
                    sb.append(" (");
                    sb.append(knot3.getPoint(4));
                    sb.append(str6);
                    sb.append(knot3.getPoint(5));
                    sb.append(str7);
                    str5 = str6;
                    str4 = str7;
                }
            }
            return sb.toString();
        } catch (Exception unused2) {
            return null;
        }
    }
}
