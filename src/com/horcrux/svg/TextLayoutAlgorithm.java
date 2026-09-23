package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
class TextLayoutAlgorithm {
    TextLayoutAlgorithm() {
    }

    class CharacterInformation {
        double advance;
        char character;
        TextView element;
        int index;
        double x = 0.0d;
        double y = 0.0d;
        double rotate = 0.0d;
        boolean hidden = false;
        boolean middle = false;
        boolean resolved = false;
        boolean xSpecified = false;
        boolean ySpecified = false;
        boolean addressable = true;
        boolean anchoredChunk = false;
        boolean rotateSpecified = false;
        boolean firstCharacterInResolvedDescendant = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    class LayoutInput {
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder sb, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            } else {
                while (i < str.length()) {
                    arrayList2.add(tSpanView);
                    arrayList.add(textPathView);
                    i++;
                }
                sb.append(str);
                return;
            }
        }
        if (view instanceof TextPathView) {
            textPathView = (TextPathView) view;
        }
        while (i < textPathView.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, textPathView.getChildAt(i), textPathView);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:153:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:85:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:88:0x01db  */
    /* JADX WARN: Code duplicated, block: B:89:0x01de  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e9 A[LOOP:6: B:94:0x01e7->B:95:0x01e9, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.graphics.Canvas, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r3v5 */
    CharacterInformation[] layoutText(LayoutInput layoutInput) {
        int i;
        boolean z;
        ArrayList<TextPathView> arrayList;
        int i2;
        PathMeasure pathMeasure;
        Object obj;
        Path path;
        char c;
        double d;
        double d2;
        TextProperties.Direction direction;
        int i3;
        double d3;
        int i4;
        int i5;
        int i6;
        TextView textView = layoutInput.text;
        StringBuilder sb = new StringBuilder();
        ArrayList<TextView> arrayList2 = new ArrayList<>();
        ArrayList<TextPathView> arrayList3 = new ArrayList<>();
        getSubTreeTypographicCharacterPositions(arrayList3, arrayList2, sb, textView, null);
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        final CharacterInformation[] characterInformationArr = new CharacterInformation[length];
        for (int i7 = 0; i7 < length; i7++) {
            characterInformationArr[i7] = new CharacterInformation(i7, charArray[i7]);
        }
        if (length == 0) {
            return characterInformationArr;
        }
        PointF[] pointFArr = new PointF[length];
        for (int i8 = 0; i8 < length; i8++) {
            pointFArr[i8] = new PointF(0.0f, 0.0f);
        }
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                break;
            }
            characterInformationArr[i9].addressable = true;
            characterInformationArr[i9].middle = false;
            characterInformationArr[i9].anchoredChunk = i9 == 0;
            if (characterInformationArr[i9].addressable && !characterInformationArr[i9].middle) {
                pointFArr[i9].set(0.0f, 0.0f);
            } else if (i9 > 0) {
                pointFArr[i9].set(pointFArr[i9 - 1]);
            }
            i9++;
        }
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        new C1CharacterPositioningResolver(characterInformationArr, strArr, strArr2, new String[length], new String[length]);
        PointF pointF = new PointF(0.0f, 0.0f);
        for (int i10 = 0; i10 < length; i10++) {
            if (strArr[i10].equals("")) {
                strArr[i10] = "0";
            }
            if (strArr2[i10].equals("")) {
                strArr2[i10] = "0";
            }
            pointF.x += Float.parseFloat(strArr[i10]);
            pointF.y += Float.parseFloat(strArr2[i10]);
            characterInformationArr[i10].x = pointFArr[i10].x + pointF.x;
            characterInformationArr[i10].y = pointFArr[i10].y + pointF.y;
        }
        new Object() { // from class: com.horcrux.svg.TextLayoutAlgorithm.1TextLengthResolver
            int global;

            /* JADX INFO: Access modifiers changed from: private */
            public void resolveTextLength(TextView textView2) {
                Class<?> cls = textView2.getClass();
                boolean z2 = textView2.mTextLength != null;
                if (cls == TSpanView.class && z2) {
                    TSpanView tSpanView = (TSpanView) textView2;
                    String str = tSpanView.mContent;
                    int i11 = this.global;
                    int length2 = (str == null ? 0 : str.length()) + i11;
                    double dMax = Double.NEGATIVE_INFINITY;
                    int i12 = i11;
                    double dMin = Double.POSITIVE_INFINITY;
                    while (i12 <= length2) {
                        if (characterInformationArr[i11].addressable) {
                            char c2 = characterInformationArr[i11].character;
                            if (c2 == '\n' || c2 == '\r') {
                                return;
                            }
                            double d4 = characterInformationArr[i12].x;
                            double d5 = characterInformationArr[i12].advance + d4;
                            dMin = Math.min(dMin, Math.min(d4, d5));
                            dMax = Math.max(dMax, Math.max(d4, d5));
                        }
                        i12++;
                        i11 = i11;
                    }
                    int i13 = i11;
                    if (dMin != Double.POSITIVE_INFINITY) {
                        double d6 = textView2.mTextLength.value - (dMax - dMin);
                        int length3 = 0;
                        int i14 = 0;
                        for (int i15 = 0; i15 < textView2.getChildCount(); i15++) {
                            if (((TextPathView) textView2.getChildAt(i15)).mTextLength == null) {
                                String str2 = tSpanView.mContent;
                                length3 += str2 == null ? 0 : str2.length();
                            } else {
                                characterInformationArr[length3].firstCharacterInResolvedDescendant = true;
                                i14++;
                            }
                        }
                        double d7 = d6 / ((double) (length3 + (i14 - 1)));
                        double d8 = 0.0d;
                        for (int i16 = i13; i16 <= length2; i16++) {
                            characterInformationArr[i16].x += d8;
                            if (!characterInformationArr[i16].middle && (!characterInformationArr[i16].resolved || characterInformationArr[i16].firstCharacterInResolvedDescendant)) {
                                d8 += d7;
                            }
                        }
                    }
                }
            }
        }.resolveTextLength(textView);
        pointF.set(0.0f, 0.0f);
        int i11 = 1;
        while (i11 < length) {
            String str = strArr[i11];
            if (str != null) {
                pointF.x = (float) (Double.parseDouble(str) - characterInformationArr[i11].x);
            }
            String str2 = strArr2[i11];
            if (str2 != null) {
                pointF.y = (float) (Double.parseDouble(str2) - characterInformationArr[i11].y);
            }
            characterInformationArr[i11].x += (double) pointF.x;
            characterInformationArr[i11].y += (double) pointF.y;
            if (characterInformationArr[i11].middle && characterInformationArr[i11].anchoredChunk) {
                characterInformationArr[i11].anchoredChunk = false;
            }
            i11++;
            if (i11 < length) {
                characterInformationArr[i11].anchoredChunk = true;
            }
        }
        int i12 = 0;
        double dMin = Double.POSITIVE_INFINITY;
        double d4 = Double.NEGATIVE_INFINITY;
        double d5 = Double.POSITIVE_INFINITY;
        double d6 = Double.NEGATIVE_INFINITY;
        for (int i13 = 0; i13 < length; i13++) {
            if (characterInformationArr[i13].addressable) {
                if (characterInformationArr[i13].anchoredChunk) {
                    d5 = dMin;
                    dMin = Double.POSITIVE_INFINITY;
                    d = Double.NEGATIVE_INFINITY;
                } else {
                    d = d4;
                    d4 = d6;
                }
                double d7 = characterInformationArr[i13].x;
                double d8 = characterInformationArr[i13].advance + d7;
                int i14 = i12;
                dMin = Math.min(dMin, Math.min(d7, d8));
                double dMax = Math.max(d, Math.max(d7, d8));
                if (i13 > 0 && characterInformationArr[i13].anchoredChunk) {
                    if (d5 != Double.POSITIVE_INFINITY) {
                        TextProperties.TextAnchor textAnchor = TextProperties.TextAnchor.start;
                        direction = TextProperties.Direction.ltr;
                        i3 = length - 1;
                        if (i13 == i3) {
                            d4 = dMax;
                            d5 = dMin;
                        }
                        d3 = characterInformationArr[i14].x;
                        i4 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
                        if (i4 != 1) {
                            if (i4 != 2) {
                                TextProperties.Direction direction2 = TextProperties.Direction.ltr;
                                d3 -= (d5 + d4) / 2.0d;
                            } else if (i4 == 3) {
                                if (direction == TextProperties.Direction.ltr) {
                                    d3 -= d4;
                                } else {
                                    d3 -= d5;
                                }
                            }
                        } else if (direction == TextProperties.Direction.ltr) {
                            d3 -= d5;
                        } else {
                            d3 -= d4;
                        }
                        if (i13 == i3) {
                            i5 = i13;
                        } else {
                            i5 = i13 - 1;
                        }
                        i6 = i14;
                        while (i6 <= i5) {
                            characterInformationArr[i6].x += d3;
                            i6++;
                            dMax = dMax;
                        }
                        d2 = dMax;
                        i12 = i13;
                    }
                    double d9 = d4;
                    d4 = d2;
                    d6 = d9;
                }
                if (i13 == length - 1) {
                    TextProperties.TextAnchor textAnchor2 = TextProperties.TextAnchor.start;
                    direction = TextProperties.Direction.ltr;
                    i3 = length - 1;
                    if (i13 == i3) {
                        d4 = dMax;
                        d5 = dMin;
                    }
                    d3 = characterInformationArr[i14].x;
                    i4 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor2.ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            TextProperties.Direction direction3 = TextProperties.Direction.ltr;
                            d3 -= (d5 + d4) / 2.0d;
                        } else if (i4 == 3) {
                            if (direction == TextProperties.Direction.ltr) {
                                d3 -= d4;
                            } else {
                                d3 -= d5;
                            }
                        }
                    } else if (direction == TextProperties.Direction.ltr) {
                        d3 -= d5;
                    } else {
                        d3 -= d4;
                    }
                    if (i13 == i3) {
                        i5 = i13;
                    } else {
                        i5 = i13 - 1;
                    }
                    i6 = i14;
                    while (i6 <= i5) {
                        characterInformationArr[i6].x += d3;
                        i6++;
                        dMax = dMax;
                    }
                    d2 = dMax;
                    i12 = i13;
                } else {
                    d2 = dMax;
                    i12 = i14;
                }
                double d10 = d4;
                d4 = d2;
                d6 = d10;
            }
        }
        int i15 = i12;
        PointF pointF2 = new PointF(0.0f, 0.0f);
        PathMeasure pathMeasure2 = new PathMeasure();
        ?? r3 = 0;
        Path path2 = null;
        boolean z2 = false;
        int i16 = 0;
        boolean z3 = false;
        while (i16 < length) {
            TextPathView textPathView = arrayList3.get(i16);
            if (textPathView == 0 || !characterInformationArr[i16].addressable) {
                i = i15;
                z = z3;
                arrayList = arrayList3;
                i2 = length;
                pathMeasure = pathMeasure2;
            } else {
                Path textPath = textPathView.getTextPath(r3, r3);
                if (!characterInformationArr[i16].middle) {
                    textPathView.getSide();
                    TextProperties.TextPathSide textPathSide = TextProperties.TextPathSide.right;
                    pathMeasure2.setPath(textPath, false);
                    double length2 = pathMeasure2.getLength();
                    i = i15;
                    double d11 = textPathView.getStartOffset().value;
                    PathMeasure pathMeasure3 = pathMeasure2;
                    double d12 = characterInformationArr[i16].advance;
                    z = z3;
                    path = textPath;
                    double d13 = characterInformationArr[i16].x;
                    arrayList = arrayList3;
                    i2 = length;
                    double d14 = characterInformationArr[i16].y;
                    double d15 = characterInformationArr[i16].rotate;
                    double d16 = d13 + (d12 / 2.0d) + d11;
                    if (!pathMeasure3.isClosed() && (d16 < 0.0d || d16 > length2)) {
                        characterInformationArr[i16].hidden = true;
                    }
                    if (pathMeasure3.isClosed()) {
                        TextProperties.TextAnchor textAnchor3 = TextProperties.TextAnchor.start;
                        TextProperties.Direction direction4 = TextProperties.Direction.ltr;
                        double d17 = characterInformationArr[i].x;
                        int i17 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor3.ordinal()];
                        if (i17 != 1) {
                            if (i17 != 2) {
                                if (i17 != 3) {
                                    c = 1;
                                } else if (direction4 != TextProperties.Direction.ltr) {
                                    c = 1;
                                    if (d16 < 0.0d || d16 > length2) {
                                        characterInformationArr[i16].hidden = true;
                                    }
                                } else if (d16 < (-length2) || d16 > 0.0d) {
                                    c = 1;
                                    characterInformationArr[i16].hidden = true;
                                } else {
                                    c = 1;
                                }
                            } else if (d16 < (-length2) / 2.0d || d16 > length2 / 2.0d) {
                                characterInformationArr[i16].hidden = true;
                                c = 1;
                            } else {
                                c = 1;
                            }
                        } else if (direction4 != TextProperties.Direction.ltr) {
                            c = 1;
                            if (d16 < (-length2) || d16 > 0.0d) {
                                characterInformationArr[i16].hidden = true;
                            }
                        } else if (d16 < 0.0d || d16 > length2) {
                            c = 1;
                            characterInformationArr[i16].hidden = true;
                        } else {
                            c = 1;
                        }
                    } else {
                        c = 1;
                    }
                    double d18 = d16 % length2;
                    if (characterInformationArr[i16].hidden) {
                        pathMeasure = pathMeasure3;
                    } else {
                        float[] fArr = new float[2];
                        float f = (float) d18;
                        pathMeasure = pathMeasure3;
                        pathMeasure.getPosTan(f, new float[2], fArr);
                        double dAtan2 = Math.atan2(fArr[c], fArr[0]) * 57.29577951308232d;
                        double d19 = 90.0d + dAtan2;
                        Math.cos(d19);
                        Math.sin(d19);
                        characterInformationArr[i16].rotate += dAtan2;
                    }
                } else {
                    i = i15;
                    z = z3;
                    path = textPath;
                    arrayList = arrayList3;
                    i2 = length;
                    pathMeasure = pathMeasure2;
                    int i18 = i16 - 1;
                    characterInformationArr[i16].x = characterInformationArr[i18].x;
                    characterInformationArr[i16].y = characterInformationArr[i18].y;
                    characterInformationArr[i16].rotate = characterInformationArr[i18].rotate;
                }
                path2 = path;
                z2 = true;
            }
            if (textPathView == 0 && characterInformationArr[i16].addressable) {
                if (z2) {
                    pathMeasure.setPath(path2, false);
                    float[] fArr2 = new float[2];
                    obj = null;
                    pathMeasure.getPosTan(pathMeasure.getLength(), fArr2, null);
                    pointF2.set(fArr2[0], fArr2[1]);
                    z2 = false;
                    z = true;
                } else {
                    obj = null;
                }
                if (z) {
                    if (characterInformationArr[i16].anchoredChunk) {
                        z = false;
                    } else {
                        characterInformationArr[i16].x += (double) pointF2.x;
                        characterInformationArr[i16].y += (double) pointF2.y;
                    }
                }
            } else {
                obj = null;
            }
            i16++;
            pathMeasure2 = pathMeasure;
            r3 = obj;
            i15 = i;
            z3 = z;
            arrayList3 = arrayList;
            length = i2;
        }
        return characterInformationArr;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver, reason: invalid class name */
    class C1CharacterPositioningResolver {
        private int global;
        private boolean horizontal;
        private boolean in_text_path;
        private String[] resolve_dx;
        private String[] resolve_dy;
        private String[] resolve_x;
        private String[] resolve_y;
        private CharacterInformation[] result;

        private C1CharacterPositioningResolver(CharacterInformation[] characterInformationArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.global = 0;
            this.horizontal = true;
            this.in_text_path = false;
            this.result = characterInformationArr;
            this.resolve_x = strArr;
            this.resolve_y = strArr2;
            this.resolve_dx = strArr3;
            this.resolve_dy = strArr4;
        }

        private void resolveCharacterPositioning(TextView textView) {
            boolean z = true;
            if (textView.getClass() == TextView.class || textView.getClass() == TSpanView.class) {
                int i = this.global;
                String[] strArr = new String[0];
                String[] strArr2 = new String[0];
                String[] strArr3 = new String[0];
                String[] strArr4 = new String[0];
                double[] dArr = new double[0];
                int iMax = !this.in_text_path ? Math.max(0, 0) : 0;
                String str = ((TSpanView) textView).mContent;
                int length = str == null ? 0 : str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i + i2;
                    if (this.result[i4].addressable) {
                        this.result[i4].anchoredChunk = i3 < iMax ? z : false;
                        if (i3 < 0) {
                            this.resolve_x[i4] = strArr[i3];
                        }
                        boolean z2 = this.in_text_path;
                        if (z2 && !this.horizontal) {
                            this.resolve_x[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_y[i4] = strArr2[i3];
                        }
                        if (z2 && this.horizontal) {
                            this.resolve_y[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_dx[i4] = strArr3[i3];
                        }
                        if (i3 < 0) {
                            this.resolve_dy[i4] = strArr4[i3];
                        }
                        if (i3 < 0) {
                            this.result[i4].rotate = dArr[i3];
                        }
                    }
                    i3++;
                    i2++;
                    z = true;
                }
                return;
            }
            if (textView.getClass() == TextPathView.class) {
                this.result[this.global].anchoredChunk = true;
                this.in_text_path = true;
                for (int i5 = 0; i5 < textView.getChildCount(); i5++) {
                    resolveCharacterPositioning((TextView) textView.getChildAt(i5));
                }
                if (textView instanceof TextPathView) {
                    this.in_text_path = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;

        static {
            int[] iArr = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr;
            try {
                iArr[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
