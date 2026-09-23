package com.drew.metadata.icc;

import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.ByteArrayReader;
import com.drew.metadata.TagDescriptor;
import de.patwoz.rn.bluetoothstatemanager.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class IccDescriptor extends TagDescriptor<IccDirectory> {
    private static final int ICC_TAG_TYPE_CURV = 1668641398;
    private static final int ICC_TAG_TYPE_DESC = 1684370275;
    private static final int ICC_TAG_TYPE_MEAS = 1835360627;
    private static final int ICC_TAG_TYPE_MLUC = 1835824483;
    private static final int ICC_TAG_TYPE_SIG = 1936287520;
    private static final int ICC_TAG_TYPE_TEXT = 1952807028;
    private static final int ICC_TAG_TYPE_XYZ_ARRAY = 1482250784;

    public IccDescriptor(IccDirectory iccDirectory) {
        super(iccDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 8) {
            return getProfileVersionDescription();
        }
        if (i == 12) {
            return getProfileClassDescription();
        }
        if (i == 40) {
            return getPlatformDescription();
        }
        if (i == 64) {
            return getRenderingIntentDescription();
        }
        if (i > 538976288 && i < 2054847098) {
            return getTagDataString(i);
        }
        return super.getDescription(i);
    }

    private String getTagDataString(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            byte[] byteArray = ((IccDirectory) this._directory).getByteArray(i);
            if (byteArray == null) {
                return ((IccDirectory) this._directory).getString(i);
            }
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int i2 = 0;
            int int32 = byteArrayReader.getInt32(0);
            switch (int32) {
                case ICC_TAG_TYPE_XYZ_ARRAY /* 1482250784 */:
                    StringBuilder sb = new StringBuilder();
                    DecimalFormat decimalFormat = new DecimalFormat("0.####");
                    int length = (byteArray.length - 8) / 12;
                    while (i2 < length) {
                        int i3 = i2 * 12;
                        float s15Fixed16 = byteArrayReader.getS15Fixed16(i3 + 8);
                        float s15Fixed17 = byteArrayReader.getS15Fixed16(i3 + 12);
                        float s15Fixed18 = byteArrayReader.getS15Fixed16(i3 + 16);
                        if (i2 > 0) {
                            sb.append(", ");
                        }
                        sb.append("(");
                        sb.append(decimalFormat.format(s15Fixed16));
                        sb.append(", ");
                        sb.append(decimalFormat.format(s15Fixed17));
                        sb.append(", ");
                        sb.append(decimalFormat.format(s15Fixed18));
                        sb.append(")");
                        i2++;
                    }
                    return sb.toString();
                case ICC_TAG_TYPE_CURV /* 1668641398 */:
                    int int33 = byteArrayReader.getInt32(8);
                    StringBuilder sb2 = new StringBuilder();
                    for (int i4 = 0; i4 < int33; i4++) {
                        if (i4 != 0) {
                            sb2.append(", ");
                        }
                        sb2.append(formatDoubleAsString(((double) byteArrayReader.getUInt16((i4 * 2) + 12)) / 65535.0d, 7, false));
                    }
                    return sb2.toString();
                case 1684370275:
                    return new String(byteArray, 12, byteArrayReader.getInt32(8) - 1);
                case 1835360627:
                    int int34 = byteArrayReader.getInt32(8);
                    float s15Fixed19 = byteArrayReader.getS15Fixed16(12);
                    float s15Fixed110 = byteArrayReader.getS15Fixed16(16);
                    float s15Fixed111 = byteArrayReader.getS15Fixed16(20);
                    int int35 = byteArrayReader.getInt32(24);
                    float s15Fixed112 = byteArrayReader.getS15Fixed16(28);
                    int int36 = byteArrayReader.getInt32(32);
                    String str5 = Constants.BluetoothState.UNKNOWN;
                    if (int34 != 0) {
                        if (int34 == 1) {
                            str3 = "1931 2°";
                        } else if (int34 == 2) {
                            str3 = "1964 10°";
                        } else {
                            str3 = String.format("Unknown %d", Integer.valueOf(int34));
                        }
                        str = str3;
                    } else {
                        str = Constants.BluetoothState.UNKNOWN;
                    }
                    if (int35 != 0) {
                        if (int35 == 1) {
                            str5 = "0/45 or 45/0";
                        } else if (int35 == 2) {
                            str5 = "0/d or d/0";
                        } else {
                            str5 = String.format("Unknown %d", Integer.valueOf(int34));
                        }
                    }
                    String str6 = str5;
                    switch (int36) {
                        case 0:
                            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                            break;
                        case 1:
                            str2 = "D50";
                            break;
                        case 2:
                            str2 = "D65";
                            break;
                        case 3:
                            str2 = "D93";
                            break;
                        case 4:
                            str2 = "F2";
                            break;
                        case 5:
                            str2 = "D55";
                            break;
                        case 6:
                            str2 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                            break;
                        case 7:
                            str2 = "Equi-Power (E)";
                            break;
                        case 8:
                            str2 = "F8";
                            break;
                        default:
                            str2 = String.format("Unknown %d", Integer.valueOf(int36));
                            break;
                    }
                    String str7 = str2;
                    DecimalFormat decimalFormat2 = new DecimalFormat("0.###");
                    return String.format("%s Observer, Backing (%s, %s, %s), Geometry %s, Flare %d%%, Illuminant %s", str, decimalFormat2.format(s15Fixed19), decimalFormat2.format(s15Fixed110), decimalFormat2.format(s15Fixed111), str6, Integer.valueOf(Math.round(s15Fixed112 * 100.0f)), str7);
                case ICC_TAG_TYPE_MLUC /* 1835824483 */:
                    int int37 = byteArrayReader.getInt32(8);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(int37);
                    while (i2 < int37) {
                        int i5 = i2 * 12;
                        String stringFromInt32 = IccReader.getStringFromInt32(byteArrayReader.getInt32(i5 + 16));
                        int int38 = byteArrayReader.getInt32(i5 + 20);
                        int int39 = byteArrayReader.getInt32(i5 + 24);
                        try {
                            str4 = new String(byteArray, int39, int38, CharEncoding.UTF_16BE);
                        } catch (UnsupportedEncodingException unused) {
                            str4 = new String(byteArray, int39, int38);
                        }
                        sb3.append(StringUtils.SPACE);
                        sb3.append(stringFromInt32);
                        sb3.append("(");
                        sb3.append(str4);
                        sb3.append(")");
                        i2++;
                    }
                    return sb3.toString();
                case ICC_TAG_TYPE_SIG /* 1936287520 */:
                    return IccReader.getStringFromInt32(byteArrayReader.getInt32(8));
                case ICC_TAG_TYPE_TEXT /* 1952807028 */:
                    try {
                        return new String(byteArray, 8, byteArray.length - 9, "ASCII");
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(byteArray, 8, byteArray.length - 9);
                    }
                default:
                    return String.format("%s (0x%08X): %d bytes", IccReader.getStringFromInt32(int32), Integer.valueOf(int32), Integer.valueOf(byteArray.length));
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    public static String formatDoubleAsString(double d, int i, boolean z) {
        int i2 = i;
        boolean z2 = true;
        if (i2 < 1) {
            return "" + Math.round(d);
        }
        long jAbs = Math.abs((long) d);
        long jRound = (int) Math.round((Math.abs(d) - jAbs) * Math.pow(10.0d, i2));
        String str = "";
        long j = jRound;
        while (i2 > 0) {
            byte bAbs = (byte) Math.abs(j % 10);
            j /= 10;
            if (str.length() > 0 || z || bAbs != 0 || i2 == 1) {
                str = ((int) bAbs) + str;
            }
            i2--;
        }
        long j2 = jAbs + j;
        if (d >= 0.0d || (j2 == 0 && jRound == 0)) {
            z2 = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z2 ? "-" : "");
        sb.append(j2);
        sb.append(".");
        sb.append(str);
        return sb.toString();
    }

    private String getRenderingIntentDescription() {
        return getIndexedDescription(64, "Perceptual", "Media-Relative Colorimetric", ExifInterface.TAG_SATURATION, "ICC-Absolute Colorimetric");
    }

    private String getPlatformDescription() {
        String string = ((IccDirectory) this._directory).getString(40);
        if (string == null) {
            return null;
        }
        try {
            switch (getInt32FromString(string)) {
                case 1095782476:
                    return "Apple Computer, Inc.";
                case 1297303124:
                    return "Microsoft Corporation";
                case 1397180704:
                    return "Silicon Graphics, Inc.";
                case 1398099543:
                    return "Sun Microsystems, Inc.";
                case 1413959252:
                    return "Taligent, Inc.";
                default:
                    return String.format("Unknown (%s)", string);
            }
        } catch (IOException unused) {
            return string;
        }
    }

    private String getProfileClassDescription() {
        String string = ((IccDirectory) this._directory).getString(12);
        if (string == null) {
            return null;
        }
        try {
            switch (getInt32FromString(string)) {
                case 1633842036:
                    return "Abstract";
                case 1818848875:
                    return "DeviceLink";
                case 1835955314:
                    return "Display Device";
                case 1852662636:
                    return "Named Color";
                case 1886549106:
                    return "Output Device";
                case 1935896178:
                    return "Input Device";
                case 1936744803:
                    return "ColorSpace Conversion";
                default:
                    return String.format("Unknown (%s)", string);
            }
        } catch (IOException unused) {
            return string;
        }
    }

    private String getProfileVersionDescription() {
        Integer integer = ((IccDirectory) this._directory).getInteger(8);
        if (integer == null) {
            return null;
        }
        return String.format("%d.%d.%d", Integer.valueOf((integer.intValue() & ViewCompat.MEASURED_STATE_MASK) >> 24), Integer.valueOf((integer.intValue() & 15728640) >> 20), Integer.valueOf((integer.intValue() & 983040) >> 16));
    }

    private static int getInt32FromString(String str) throws IOException {
        return new ByteArrayReader(str.getBytes()).getInt32(0);
    }
}
