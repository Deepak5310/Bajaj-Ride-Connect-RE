package com.google.android.libraries.navigation.internal.afn;

import android.graphics.Matrix;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import java.util.ArrayList;
import org.xml.sax.Attributes;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    static final float a = 72.0f;

    public static Matrix a(String str) {
        float fFloatValue;
        float fFloatValue2;
        int i;
        Matrix matrix = new Matrix();
        String strReplaceFirst = str;
        while (true) {
            if (strReplaceFirst.startsWith("matrix(")) {
                j jVarB = b(strReplaceFirst.substring(7));
                if (jVarB.a.size() == 6) {
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{((Float) jVarB.a.get(0)).floatValue(), ((Float) jVarB.a.get(2)).floatValue(), ((Float) jVarB.a.get(4)).floatValue(), ((Float) jVarB.a.get(1)).floatValue(), ((Float) jVarB.a.get(3)).floatValue(), ((Float) jVarB.a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                }
            } else if (strReplaceFirst.startsWith("translate(")) {
                j jVarB2 = b(strReplaceFirst.substring(10));
                if (jVarB2.a.size() > 0) {
                    matrix.preTranslate(((Float) jVarB2.a.get(0)).floatValue(), jVarB2.a.size() > 1 ? ((Float) jVarB2.a.get(1)).floatValue() : 0.0f);
                }
            } else if (strReplaceFirst.startsWith("scale(")) {
                j jVarB3 = b(strReplaceFirst.substring(6));
                if (jVarB3.a.size() > 0) {
                    float fFloatValue3 = ((Float) jVarB3.a.get(0)).floatValue();
                    matrix.preScale(fFloatValue3, jVarB3.a.size() > 1 ? ((Float) jVarB3.a.get(1)).floatValue() : fFloatValue3);
                }
            } else if (strReplaceFirst.startsWith("skewX(")) {
                j jVarB4 = b(strReplaceFirst.substring(6));
                if (jVarB4.a.size() > 0) {
                    matrix.preSkew((float) Math.tan(((Float) jVarB4.a.get(0)).floatValue()), 0.0f);
                }
            } else if (strReplaceFirst.startsWith("skewY(")) {
                j jVarB5 = b(strReplaceFirst.substring(6));
                if (jVarB5.a.size() > 0) {
                    matrix.preSkew(0.0f, (float) Math.tan(((Float) jVarB5.a.get(0)).floatValue()));
                }
            } else if (strReplaceFirst.startsWith("rotate(")) {
                j jVarB6 = b(strReplaceFirst.substring(7));
                if (jVarB6.a.size() > 0) {
                    float fFloatValue4 = ((Float) jVarB6.a.get(0)).floatValue();
                    if (jVarB6.a.size() > 2) {
                        fFloatValue2 = ((Float) jVarB6.a.get(1)).floatValue();
                        fFloatValue = ((Float) jVarB6.a.get(2)).floatValue();
                    } else {
                        fFloatValue = 0.0f;
                        fFloatValue2 = 0.0f;
                    }
                    matrix.preTranslate(fFloatValue2, fFloatValue);
                    matrix.preRotate(fFloatValue4);
                    matrix.preTranslate(-fFloatValue2, -fFloatValue);
                }
            }
            int iIndexOf = strReplaceFirst.indexOf(")");
            if (iIndexOf <= 0 || strReplaceFirst.length() <= (i = iIndexOf + 1)) {
                break;
            }
            strReplaceFirst = strReplaceFirst.substring(i).replaceFirst("[\\s,]*", "");
        }
        return matrix;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:5:0x0012 A[PHI: r5
      0x0012: PHI (r5v10 int) = (r5v1 int), (r5v1 int), (r5v2 int) binds: [B:4:0x0010, B:7:0x0018, B:24:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    public static j b(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 1; i2 < length; i2++) {
            if (!z) {
                char cCharAt = str.charAt(i2);
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                    case '-':
                        int i3 = i2 + 1;
                        String strSubstring = str.substring(i, i2);
                        if (strSubstring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(strSubstring)));
                            boolean z2 = cCharAt != '-';
                            i = cCharAt == '-' ? i2 : i3;
                            z = z2;
                        } else {
                            i++;
                            z = false;
                        }
                        break;
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                    case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                    case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                    case 'T':
                    case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
                    case 'Z':
                    case PanasonicMakernoteDirectory.TAG_FACE_RECOGNITION_INFO /* 97 */:
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        String strSubstring2 = str.substring(i, i2);
                        if (strSubstring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(strSubstring2)));
                        }
                        break;
                    default:
                        z = false;
                        break;
                }
                return new j(arrayList);
            }
            z = false;
        }
        String strSubstring3 = str.substring(i);
        if (strSubstring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(strSubstring3)));
            } catch (NumberFormatException unused) {
            }
        }
        return new j(arrayList);
    }

    public static String c(String str) {
        return str.replaceAll("\"", "&quot;").replaceAll("'", "&apos").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;");
    }

    public static String d(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (attributes.getLocalName(i).equals(str)) {
                return attributes.getValue(i);
            }
        }
        return null;
    }
}
