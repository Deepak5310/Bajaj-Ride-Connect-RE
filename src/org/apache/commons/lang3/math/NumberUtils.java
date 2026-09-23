package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes5.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int compare(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, 0.0d);
    }

    public static double toDouble(BigDecimal bigDecimal, double d) {
        return bigDecimal == null ? d : bigDecimal.doubleValue();
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Float f) {
        return toScaledBigDecimal(f, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Float f, int i, RoundingMode roundingMode) {
        if (f == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(f.floatValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d) {
        return toScaledBigDecimal(d, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double d, int i, RoundingMode roundingMode) {
        if (d == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d.doubleValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(String str, int i, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i, roundingMode);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0199 A[Catch: NumberFormatException -> 0x01a5, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x01a5, blocks: (B:106:0x018f, B:108:0x0199), top: B:159:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:159:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0137, code lost:
    
        if (r1 == 'l') goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) {
        int length;
        String mantissa;
        String strSubstring;
        Double dCreateDouble;
        Float fCreateFloat;
        String strSubstring2 = null;
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] strArr = {"0x", "0X", "-0x", "-0X", "#", "-#"};
        char cCharAt = 0;
        int i = 0;
        while (true) {
            if (i >= 6) {
                length = 0;
                break;
            }
            String str2 = strArr[i];
            if (str.startsWith(str2)) {
                length = str2.length();
                break;
            }
            i++;
        }
        if (length > 0) {
            int i2 = length;
            while (length < str.length() && (cCharAt = str.charAt(length)) == '0') {
                i2++;
                length++;
            }
            int length2 = str.length() - i2;
            if (length2 > 16 || (length2 == 16 && cCharAt > '7')) {
                return createBigInteger(str);
            }
            if (length2 > 8 || (length2 == 8 && cCharAt > '7')) {
                return createLong(str);
            }
            return createInteger(str);
        }
        char cCharAt2 = str.charAt(str.length() - 1);
        int iIndexOf = str.indexOf(46);
        int iIndexOf2 = str.indexOf(101) + str.indexOf(69);
        int i3 = iIndexOf2 + 1;
        if (iIndexOf > -1) {
            if (i3 > -1) {
                if (i3 < iIndexOf || i3 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                strSubstring = str.substring(iIndexOf + 1, i3);
            } else {
                strSubstring = str.substring(iIndexOf + 1);
            }
            mantissa = getMantissa(str, iIndexOf);
        } else {
            if (i3 > -1) {
                if (i3 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                mantissa = getMantissa(str, i3);
            } else {
                mantissa = getMantissa(str);
            }
            strSubstring = null;
        }
        if (!Character.isDigit(cCharAt2) && cCharAt2 != '.') {
            if (i3 > -1 && i3 < str.length() - 1) {
                strSubstring2 = str.substring(iIndexOf2 + 2, str.length() - 1);
            }
            String strSubstring3 = str.substring(0, str.length() - 1);
            boolean z = isAllZeros(mantissa) && isAllZeros(strSubstring2);
            if (cCharAt2 != 'D') {
                if (cCharAt2 != 'F') {
                    if (cCharAt2 != 'L') {
                        if (cCharAt2 == 'd') {
                            dCreateDouble = createDouble(str);
                            if (!dCreateDouble.isInfinite()) {
                                return dCreateDouble;
                            }
                            return createBigDecimal(strSubstring3);
                        }
                        if (cCharAt2 == 'f') {
                            fCreateFloat = createFloat(str);
                            if (!fCreateFloat.isInfinite()) {
                                return fCreateFloat;
                            }
                            dCreateDouble = createDouble(str);
                            if (!dCreateDouble.isInfinite()) {
                                return dCreateDouble;
                            }
                            return createBigDecimal(strSubstring3);
                        }
                    }
                    if (strSubstring != null || strSubstring2 != null || ((strSubstring3.isEmpty() || strSubstring3.charAt(0) != '-' || !isDigits(strSubstring3.substring(1))) && !isDigits(strSubstring3))) {
                        throw new NumberFormatException(str + " is not a valid number.");
                    }
                    try {
                        return createLong(strSubstring3);
                    } catch (NumberFormatException unused) {
                        return createBigInteger(strSubstring3);
                    }
                }
                try {
                    fCreateFloat = createFloat(str);
                    if (!fCreateFloat.isInfinite() && (fCreateFloat.floatValue() != 0.0f || z)) {
                        return fCreateFloat;
                    }
                } catch (NumberFormatException unused2) {
                }
                dCreateDouble = createDouble(str);
                if (!dCreateDouble.isInfinite()) {
                    return dCreateDouble;
                }
                return createBigDecimal(strSubstring3);
            }
            try {
                dCreateDouble = createDouble(str);
                if (!dCreateDouble.isInfinite() && (dCreateDouble.floatValue() != 0.0d || z)) {
                    return dCreateDouble;
                }
            } catch (NumberFormatException unused3) {
            }
            try {
                return createBigDecimal(strSubstring3);
            } catch (NumberFormatException unused4) {
            }
            throw new NumberFormatException(str + " is not a valid number.");
        }
        if (i3 > -1 && i3 < str.length() - 1) {
            strSubstring2 = str.substring(iIndexOf2 + 2, str.length());
        }
        if (strSubstring == null && strSubstring2 == null) {
            try {
                try {
                    return createInteger(str);
                } catch (NumberFormatException unused5) {
                    return createBigInteger(str);
                }
            } catch (NumberFormatException unused6) {
                return createLong(str);
            }
        }
        if (isAllZeros(mantissa) && isAllZeros(strSubstring2)) {
            cCharAt = 1;
        }
        try {
            Float fCreateFloat2 = createFloat(str);
            Double dCreateDouble2 = createDouble(str);
            if (!fCreateFloat2.isInfinite() && ((fCreateFloat2.floatValue() != 0.0f || cCharAt != 0) && fCreateFloat2.toString().equals(dCreateDouble2.toString()))) {
                return fCreateFloat2;
            }
            if (!dCreateDouble2.isInfinite() && (dCreateDouble2.doubleValue() != 0.0d || cCharAt != 0)) {
                BigDecimal bigDecimalCreateBigDecimal = createBigDecimal(str);
                return bigDecimalCreateBigDecimal.compareTo(BigDecimal.valueOf(dCreateDouble2.doubleValue())) == 0 ? dCreateDouble2 : bigDecimalCreateBigDecimal;
            }
        } catch (NumberFormatException unused7) {
        }
        return createBigDecimal(str);
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static String getMantissa(String str, int i) {
        char cCharAt = str.charAt(0);
        return str.substring((cCharAt == '-' || cCharAt == '+') ? 1 : 0, i);
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return !str.isEmpty();
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    public static BigInteger createBigInteger(String str) {
        int i;
        if (str == null) {
            return null;
        }
        boolean zStartsWith = str.startsWith("-");
        int i2 = 16;
        if (str.startsWith("0x", zStartsWith ? 1 : 0) || str.startsWith("0X", zStartsWith ? 1 : 0)) {
            i = (zStartsWith ? 1 : 0) + 2;
        } else if (str.startsWith("#", zStartsWith ? 1 : 0)) {
            i = (zStartsWith ? 1 : 0) + 1;
        } else if (str.startsWith("0", zStartsWith ? 1 : 0)) {
            int length = str.length();
            int i3 = (zStartsWith ? 1 : 0) + 1;
            if (length > i3) {
                i2 = 8;
                i = i3;
            } else {
                i2 = 10;
                i = zStartsWith ? 1 : 0;
            }
        } else {
            i2 = 10;
            i = zStartsWith ? 1 : 0;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i), i2);
        return zStartsWith ? bigInteger.negate() : bigInteger;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (str.trim().startsWith("--")) {
            throw new NumberFormatException(str + " is not a valid number.");
        }
        return new BigDecimal(str);
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 < i) {
                i = i3;
            }
        }
        return i;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    private static void validateArray(Object obj) {
        Validate.isTrue(obj != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isCreatable(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = charArray[0];
        boolean z = true;
        int i = (c == '-' || c == '+') ? 1 : 0;
        int i2 = i + 1;
        if (length > i2 && charArray[i] == '0' && !StringUtils.contains(str, 46)) {
            char c2 = charArray[i2];
            if (c2 == 'x' || c2 == 'X') {
                int i3 = i + 2;
                if (i3 == length) {
                    return false;
                }
                while (i3 < charArray.length) {
                    char c3 = charArray[i3];
                    if ((c3 < '0' || c3 > '9') && ((c3 < 'a' || c3 > 'f') && (c3 < 'A' || c3 > 'F'))) {
                        return false;
                    }
                    i3++;
                }
                return true;
            }
            if (Character.isDigit(c2)) {
                while (i2 < charArray.length) {
                    char c4 = charArray[i2];
                    if (c4 < '0' || c4 > '7') {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        int i4 = length - 1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i < i4 || (i < length && z2 && !z3)) {
                char c5 = charArray[i];
                if (c5 >= '0' && c5 <= '9') {
                    z2 = false;
                    z3 = true;
                } else if (c5 == '.') {
                    if (z5 || z4) {
                        break;
                    }
                    z5 = true;
                } else if (c5 == 'e' || c5 == 'E') {
                    if (z4 || !z3) {
                        return false;
                    }
                    z2 = true;
                    z4 = true;
                } else {
                    if ((c5 != '+' && c5 != '-') || !z2) {
                        return false;
                    }
                    z2 = false;
                    z3 = false;
                }
                i++;
                z = true;
            } else {
                if (i >= charArray.length) {
                    if (z2 || !z3) {
                        return false;
                    }
                    return z;
                }
                char c6 = charArray[i];
                if (c6 >= '0' && c6 <= '9') {
                    return z;
                }
                if (c6 == 'e' || c6 == 'E') {
                    return false;
                }
                if (c6 == '.') {
                    if (z5 || z4) {
                        return false;
                    }
                    return z3;
                }
                if (!z2 && (c6 == 'd' || c6 == 'D' || c6 == 'f' || c6 == 'F')) {
                    return z3;
                }
                if ((c6 == 'l' || c6 == 'L') && z3 && !z4 && !z5) {
                    return z;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return withDecimalsParsing(str, 1);
        }
        return withDecimalsParsing(str, 0);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            boolean z = str.charAt(i) == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
