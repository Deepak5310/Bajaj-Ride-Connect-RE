package com.google.android.libraries.navigation.internal.aam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static List a(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(StringUtils.SPACE);
        int length = strArrSplit.length;
        if (length != 0) {
            int iMax = 20;
            if (length != 1) {
                int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, length);
                int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, length);
                int[] iArr3 = new int[length];
                int[] iArr4 = new int[length];
                for (String str2 : strArrSplit) {
                    iMax = Math.max(iMax, str2.length());
                }
                int i3 = 0;
                while (i3 < length) {
                    iArr[i3][i3] = iMax - strArrSplit[i3].length();
                    int i4 = i3 + 1;
                    for (int i5 = i4; i5 < length; i5++) {
                        int[] iArr5 = iArr[i3];
                        iArr5[i5] = (iArr5[i5 - 1] - strArrSplit[i5].length()) - 1;
                    }
                    i3 = i4;
                }
                for (int i6 = 0; i6 < length; i6++) {
                    for (int i7 = 0; i7 < length; i7++) {
                        int i8 = iArr[i6][i7];
                        if (i8 < 0) {
                            iArr2[i6][i7] = Integer.MAX_VALUE;
                        } else {
                            iArr2[i6][i7] = i8 < 46341 ? i8 * i8 : Integer.MAX_VALUE;
                        }
                    }
                }
                iArr3[0] = iArr2[0][0];
                for (int i9 = 1; i9 < length; i9++) {
                    iArr3[i9] = Integer.MAX_VALUE;
                    int i10 = iArr2[0][i9];
                    if (i10 != Integer.MAX_VALUE) {
                        iArr3[i9] = i10;
                        iArr4[i9] = 0;
                    }
                    int i11 = 0;
                    while (i11 < i9) {
                        int i12 = i11 + 1;
                        int i13 = iArr3[i11];
                        if (i13 != Integer.MAX_VALUE && (i = iArr2[i12][i9]) != Integer.MAX_VALUE && (i2 = i + i13) < iArr3[i9]) {
                            iArr3[i9] = i2;
                            iArr4[i9] = i12;
                        }
                        i11 = i12;
                    }
                }
                b(iArr4, length, strArrSplit, arrayList);
                return arrayList;
            }
            if (str.length() <= 20) {
                arrayList.add(str);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) str, 0, 20);
                sb.append(Typography.ellipsis);
                arrayList.add(sb.toString());
            }
        }
        return arrayList;
    }

    private static void b(int[] iArr, int i, String[] strArr, List list) {
        int i2 = i - 1;
        int i3 = iArr[i2];
        if (i3 > 0) {
            b(iArr, i3, strArr, list);
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = iArr[i2]; i4 < i2; i4++) {
            sb.append(strArr[i4]);
            sb.append(StringUtils.SPACE);
        }
        sb.append(strArr[i2]);
        list.add(sb.toString());
    }
}
