package net.time4j.format.expert;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.NumericalElement;
import net.time4j.format.internal.DualFormatElement;

/* JADX INFO: loaded from: classes5.dex */
class NumberProcessor<V> implements FormatProcessor<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] THRESHOLDS = {9, 99, 999, 9999, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    private final ChronoElement<V> element;
    private final boolean fixedInt;
    private final boolean fixedWidth;
    private final Leniency lenientMode;
    private final int maxDigits;
    private final int minDigits;
    private final NumberSystem numberSystem;
    private final int protectedLength;
    private final boolean protectedMode;
    private final int reserved;
    private final int scaleOfNumsys;
    private final SignPolicy signPolicy;
    private final boolean yearOfEra;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return true;
    }

    NumberProcessor(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy, boolean z2) {
        this(chronoElement, z, i, i2, signPolicy, z2, 0, '0', NumberSystem.ARABIC, Leniency.SMART, 0, false);
    }

    private NumberProcessor(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy, boolean z2, int i3, char c, NumberSystem numberSystem, Leniency leniency, int i4, boolean z3) {
        this.element = chronoElement;
        this.fixedWidth = z;
        this.minDigits = i;
        this.maxDigits = i2;
        this.signPolicy = signPolicy;
        this.protectedMode = z2;
        this.fixedInt = z3;
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        if (signPolicy == null) {
            throw new NullPointerException("Missing sign policy.");
        }
        if (i < 1) {
            throw new IllegalArgumentException("Not positive: " + i);
        }
        if (i > i2) {
            throw new IllegalArgumentException("Max smaller than min: " + i2 + " < " + i);
        }
        if (z && i != i2) {
            throw new IllegalArgumentException("Variable width in fixed-width-mode: " + i2 + " != " + i);
        }
        if (z && signPolicy != SignPolicy.SHOW_NEVER) {
            throw new IllegalArgumentException("Sign policy must be SHOW_NEVER in fixed-width-mode.");
        }
        int scale = getScale(numberSystem);
        if (numberSystem.isDecimal()) {
            if (i > scale) {
                throw new IllegalArgumentException("Min digits out of range: " + i);
            }
            if (i2 > scale) {
                throw new IllegalArgumentException("Max digits out of range: " + i2);
            }
        }
        this.yearOfEra = chronoElement.name().equals("YEAR_OF_ERA");
        this.reserved = i3;
        this.zeroDigit = c;
        this.numberSystem = numberSystem;
        this.lenientMode = leniency;
        this.protectedLength = i4;
        this.scaleOfNumsys = scale;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0202 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x0204  */
    /* JADX WARN: Code duplicated, block: B:106:0x0233  */
    /* JADX WARN: Code duplicated, block: B:109:0x0239  */
    /* JADX WARN: Code duplicated, block: B:111:0x023f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0245  */
    /* JADX WARN: Code duplicated, block: B:114:0x024b  */
    /* JADX WARN: Code duplicated, block: B:116:0x025a  */
    /* JADX WARN: Code duplicated, block: B:124:0x026a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:129:0x0277 A[LOOP:2: B:128:0x0275->B:129:0x0277, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:132:0x0282 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x0284  */
    /* JADX WARN: Code duplicated, block: B:135:0x0287  */
    /* JADX WARN: Code duplicated, block: B:136:0x028b  */
    /* JADX WARN: Code duplicated, block: B:138:0x028e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0294  */
    /* JADX WARN: Code duplicated, block: B:141:0x0298  */
    /* JADX WARN: Code duplicated, block: B:144:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ae A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:149:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:150:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:158:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:160:0x0306  */
    /* JADX WARN: Code duplicated, block: B:56:0x0132  */
    /* JADX WARN: Code duplicated, block: B:58:0x014b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0155 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x0159  */
    /* JADX WARN: Code duplicated, block: B:64:0x015b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0166  */
    /* JADX WARN: Code duplicated, block: B:68:0x016a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0182  */
    /* JADX WARN: Code duplicated, block: B:71:0x0184  */
    /* JADX WARN: Code duplicated, block: B:74:0x018b  */
    /* JADX WARN: Code duplicated, block: B:75:0x018e  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:81:0x01af  */
    /* JADX WARN: Code duplicated, block: B:83:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:84:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:93:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:97:0x01eb A[LOOP:1: B:95:0x01e8->B:97:0x01eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x01fc  */
    /* JADX WARN: Instruction removed from duplicated block: B:158:0x02f0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:160:0x0306, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        NumberSystem numberSystem;
        char cCharAt;
        char cCharAt2;
        Class<V> type;
        boolean zIsDecimal;
        String numeral;
        ChronoElement<V> chronoElement;
        boolean z2;
        int iPrintToInt;
        int iAbs;
        boolean z3;
        int length;
        long jLongValue;
        String string;
        String str;
        int i;
        int i2;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char[] charArray;
        int i8;
        int i9;
        int i10;
        int length3 = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        if (z) {
            numberSystem = this.numberSystem;
            cCharAt = this.zeroDigit;
        } else {
            numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
                cCharAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
            } else {
                cCharAt = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
            }
        }
        if (z && this.fixedInt) {
            int i11 = chronoDisplay.getInt(this.element);
            if (i11 < 0) {
                if (i11 == Integer.MIN_VALUE) {
                    return -1;
                }
                throw new IllegalArgumentException("Negative value not allowed according to sign policy.");
            }
            int length4 = length(i11);
            if (length4 > this.maxDigits) {
                throw new IllegalArgumentException("Element " + this.element.name() + " cannot be printed as the formatted value " + i11 + " exceeds the maximum width of " + this.maxDigits + ".");
            }
            int i12 = this.minDigits - length4;
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                appendable.append('0');
                i13++;
            }
            if (length4 == 2) {
                appendTwoDigits(i11, appendable, '0');
            } else if (length4 == 1) {
                appendable.append((char) (i11 + 48));
            } else if (i11 >= 2000 && i11 < 2100) {
                appendable.append('2');
                appendable.append('0');
                appendTwoDigits(i11 - Constants.MAX_URL_LENGTH, appendable, '0');
            } else if (i11 >= 1900 && i11 < 2000) {
                appendable.append('1');
                appendable.append('9');
                appendTwoDigits(i11 - 1900, appendable, '0');
            } else {
                appendable.append(Integer.toString(i11));
            }
            length2 = i13 + length4;
            i10 = -1;
            i3 = length3;
        } else {
            if (this.yearOfEra) {
                ChronoElement<V> chronoElement2 = this.element;
                if (chronoElement2 instanceof DualFormatElement) {
                    DualFormatElement dualFormatElement = (DualFormatElement) DualFormatElement.class.cast(chronoElement2);
                    StringBuilder sb = new StringBuilder();
                    dualFormatElement.print(chronoDisplay, sb, attributeQuery, numberSystem, cCharAt, this.minDigits, this.maxDigits);
                    appendable.append(sb.toString());
                    length2 = sb.length();
                    i3 = length3;
                } else {
                    cCharAt2 = numberSystem.getDigits().charAt(0);
                    type = this.element.getType();
                    zIsDecimal = numberSystem.isDecimal();
                    numeral = null;
                    if (type == Integer.class) {
                        i9 = chronoDisplay.getInt(this.element);
                        if (i9 == Integer.MIN_VALUE) {
                            return -1;
                        }
                        if (i9 < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        iAbs = Math.abs(i9);
                        length = length(iAbs);
                    } else if (type == Long.class) {
                        jLongValue = ((Long) Long.class.cast(chronoDisplay.get(this.element))).longValue();
                        if (jLongValue < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (jLongValue == Long.MIN_VALUE) {
                            string = "9223372036854775808";
                        } else {
                            string = Long.toString(Math.abs(jLongValue));
                        }
                        numeral = string;
                        length = numeral.length();
                        cCharAt2 = '0';
                        iAbs = Integer.MIN_VALUE;
                    } else if (Enum.class.isAssignableFrom(type)) {
                        chronoElement = this.element;
                        if (chronoElement instanceof NumericalElement) {
                            iPrintToInt = ((NumericalElement) this.element).printToInt(chronoDisplay.get(chronoElement), chronoDisplay, attributeQuery);
                            if (iPrintToInt < 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                            iPrintToInt = Integer.MIN_VALUE;
                        }
                        if (iPrintToInt != Integer.MIN_VALUE) {
                            throw new IllegalArgumentException("Cannot print: " + this.element);
                        }
                        iAbs = Math.abs(iPrintToInt);
                        z3 = z2;
                        length = length(iAbs);
                    } else {
                        throw new IllegalArgumentException("Not formattable: " + this.element);
                    }
                    if (zIsDecimal) {
                        if (cCharAt != cCharAt2) {
                            i7 = cCharAt - cCharAt2;
                            if (numeral == null) {
                                numeral = numberSystem.toNumeral(iAbs);
                            }
                            charArray = numeral.toCharArray();
                            for (i8 = 0; i8 < charArray.length; i8++) {
                                charArray[i8] = (char) (charArray[i8] + i7);
                            }
                            numeral = new String(charArray);
                        }
                        if (length > this.maxDigits) {
                            if (numeral == null) {
                                numeral = numberSystem.toNumeral(iAbs);
                            }
                            throw new IllegalArgumentException("Element " + this.element.name() + " cannot be printed as the formatted value " + numeral + " exceeds the maximum width of " + this.maxDigits + ".");
                        }
                    } else {
                        length3 = length3;
                    }
                    str = numeral;
                    if (z3) {
                        if (this.signPolicy != SignPolicy.SHOW_NEVER) {
                            throw new IllegalArgumentException("Negative value not allowed according to sign policy.");
                        }
                        appendable.append('-');
                    } else {
                        i = AnonymousClass1.$SwitchMap$net$time4j$format$expert$SignPolicy[this.signPolicy.ordinal()];
                        if (i == 1) {
                            appendable.append('+');
                        } else {
                            if (i == 2 && zIsDecimal && length > this.minDigits) {
                                appendable.append('+');
                            } else {
                                i2 = 0;
                            }
                            if (zIsDecimal) {
                                i4 = this.minDigits - length;
                                i5 = i2;
                                for (i6 = 0; i6 < i4; i6++) {
                                    appendable.append(cCharAt);
                                    i5++;
                                }
                                i2 = i5;
                            }
                            if (str == null) {
                                appendable.append(str);
                                length = str.length();
                            } else if (zIsDecimal) {
                                length = numberSystem.toNumeral(iAbs, appendable);
                            } else if (length == 2) {
                                appendTwoDigits(iAbs, appendable, cCharAt);
                            } else if (length == 1) {
                                appendable.append((char) (iAbs + cCharAt));
                            } else if (iAbs < 2000 && iAbs < 2100) {
                                appendable.append((char) (cCharAt + 2));
                                appendable.append(cCharAt);
                                appendTwoDigits(iAbs - Constants.MAX_URL_LENGTH, appendable, cCharAt);
                            } else if (iAbs < 1900 && iAbs < 2000) {
                                appendable.append((char) (cCharAt + 1));
                                appendable.append((char) (cCharAt + '\t'));
                                appendTwoDigits(iAbs - 1900, appendable, cCharAt);
                            } else {
                                appendable.append(numberSystem.toNumeral(iAbs));
                            }
                            length2 = i2 + length;
                            i3 = length3;
                        }
                    }
                    i2 = 1;
                    if (zIsDecimal) {
                        i4 = this.minDigits - length;
                        i5 = i2;
                        while (i6 < i4) {
                            appendable.append(cCharAt);
                            i5++;
                        }
                        i2 = i5;
                    }
                    if (str == null) {
                        appendable.append(str);
                        length = str.length();
                    } else if (zIsDecimal) {
                        length = numberSystem.toNumeral(iAbs, appendable);
                    } else if (length == 2) {
                        appendTwoDigits(iAbs, appendable, cCharAt);
                    } else if (length == 1) {
                        appendable.append((char) (iAbs + cCharAt));
                    } else if (iAbs < 2000) {
                        if (iAbs < 1900) {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        } else {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        }
                    } else if (iAbs < 1900) {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    } else {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    }
                    length2 = i2 + length;
                    i3 = length3;
                }
            } else {
                cCharAt2 = numberSystem.getDigits().charAt(0);
                type = this.element.getType();
                zIsDecimal = numberSystem.isDecimal();
                numeral = null;
                if (type == Integer.class) {
                    i9 = chronoDisplay.getInt(this.element);
                    if (i9 == Integer.MIN_VALUE) {
                        return -1;
                    }
                    if (i9 < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    iAbs = Math.abs(i9);
                    length = length(iAbs);
                } else if (type == Long.class) {
                    jLongValue = ((Long) Long.class.cast(chronoDisplay.get(this.element))).longValue();
                    if (jLongValue < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (jLongValue == Long.MIN_VALUE) {
                        string = "9223372036854775808";
                    } else {
                        string = Long.toString(Math.abs(jLongValue));
                    }
                    numeral = string;
                    length = numeral.length();
                    cCharAt2 = '0';
                    iAbs = Integer.MIN_VALUE;
                } else if (Enum.class.isAssignableFrom(type)) {
                    chronoElement = this.element;
                    if (chronoElement instanceof NumericalElement) {
                        iPrintToInt = ((NumericalElement) this.element).printToInt(chronoDisplay.get(chronoElement), chronoDisplay, attributeQuery);
                        if (iPrintToInt < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                        iPrintToInt = Integer.MIN_VALUE;
                    }
                    if (iPrintToInt != Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("Cannot print: " + this.element);
                    }
                    iAbs = Math.abs(iPrintToInt);
                    z3 = z2;
                    length = length(iAbs);
                } else {
                    throw new IllegalArgumentException("Not formattable: " + this.element);
                }
                if (zIsDecimal) {
                    if (cCharAt != cCharAt2) {
                        i7 = cCharAt - cCharAt2;
                        if (numeral == null) {
                            numeral = numberSystem.toNumeral(iAbs);
                        }
                        charArray = numeral.toCharArray();
                        while (i8 < charArray.length) {
                            charArray[i8] = (char) (charArray[i8] + i7);
                        }
                        numeral = new String(charArray);
                    }
                    if (length > this.maxDigits) {
                        if (numeral == null) {
                            numeral = numberSystem.toNumeral(iAbs);
                        }
                        throw new IllegalArgumentException("Element " + this.element.name() + " cannot be printed as the formatted value " + numeral + " exceeds the maximum width of " + this.maxDigits + ".");
                    }
                } else {
                    length3 = length3;
                }
                str = numeral;
                if (z3) {
                    if (this.signPolicy != SignPolicy.SHOW_NEVER) {
                        throw new IllegalArgumentException("Negative value not allowed according to sign policy.");
                    }
                    appendable.append('-');
                } else {
                    i = AnonymousClass1.$SwitchMap$net$time4j$format$expert$SignPolicy[this.signPolicy.ordinal()];
                    if (i == 1) {
                        if (i == 2) {
                            appendable.append('+');
                        }
                        i2 = 0;
                        if (zIsDecimal) {
                            i4 = this.minDigits - length;
                            i5 = i2;
                            while (i6 < i4) {
                                appendable.append(cCharAt);
                                i5++;
                            }
                            i2 = i5;
                        }
                        if (str == null) {
                            appendable.append(str);
                            length = str.length();
                        } else if (zIsDecimal) {
                            length = numberSystem.toNumeral(iAbs, appendable);
                        } else if (length == 2) {
                            appendTwoDigits(iAbs, appendable, cCharAt);
                        } else if (length == 1) {
                            appendable.append((char) (iAbs + cCharAt));
                        } else if (iAbs < 2000) {
                            if (iAbs < 1900) {
                                appendable.append(numberSystem.toNumeral(iAbs));
                            } else {
                                appendable.append(numberSystem.toNumeral(iAbs));
                            }
                        } else if (iAbs < 1900) {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        } else {
                            appendable.append(numberSystem.toNumeral(iAbs));
                        }
                        length2 = i2 + length;
                        i3 = length3;
                    } else {
                        appendable.append('+');
                    }
                }
                i2 = 1;
                if (zIsDecimal) {
                    i4 = this.minDigits - length;
                    i5 = i2;
                    while (i6 < i4) {
                        appendable.append(cCharAt);
                        i5++;
                    }
                    i2 = i5;
                }
                if (str == null) {
                    appendable.append(str);
                    length = str.length();
                } else if (zIsDecimal) {
                    length = numberSystem.toNumeral(iAbs, appendable);
                } else if (length == 2) {
                    appendTwoDigits(iAbs, appendable, cCharAt);
                } else if (length == 1) {
                    appendable.append((char) (iAbs + cCharAt));
                } else if (iAbs < 2000) {
                    if (iAbs < 1900) {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    } else {
                        appendable.append(numberSystem.toNumeral(iAbs));
                    }
                } else if (iAbs < 1900) {
                    appendable.append(numberSystem.toNumeral(iAbs));
                } else {
                    appendable.append(numberSystem.toNumeral(iAbs));
                }
                length2 = i2 + length;
                i3 = length3;
            }
            i10 = -1;
        }
        if (i3 != i10 && length2 > 0 && set != null) {
            set.add(new ElementPosition(this.element, i3, i3 + length2));
        }
        return length2;
    }

    /* JADX INFO: renamed from: net.time4j.format.expert.NumberProcessor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$SignPolicy;

        static {
            int[] iArr = new int[SignPolicy.values().length];
            $SwitchMap$net$time4j$format$expert$SignPolicy = iArr;
            try {
                iArr[SignPolicy.SHOW_ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$SignPolicy[SignPolicy.SHOW_WHEN_BIG_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:192:0x0353  */
    /* JADX WARN: Code duplicated, block: B:193:0x035c  */
    /* JADX WARN: Code duplicated, block: B:195:0x0362  */
    /* JADX WARN: Code duplicated, block: B:196:0x036c  */
    /* JADX WARN: Code duplicated, block: B:198:0x0372  */
    /* JADX WARN: Code duplicated, block: B:199:0x0379  */
    /* JADX WARN: Code duplicated, block: B:201:0x0381  */
    /* JADX WARN: Code duplicated, block: B:203:0x0387  */
    /* JADX WARN: Code duplicated, block: B:204:0x038f  */
    /* JADX WARN: Code duplicated, block: B:206:0x0392  */
    /* JADX WARN: Code duplicated, block: B:210:0x039a  */
    /* JADX WARN: Code duplicated, block: B:215:0x03c0  */
    /* JADX WARN: Instruction removed from duplicated block: B:215:0x03c0, please report this as an issue */
    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int scale;
        char cCharAt;
        boolean z2;
        NumberSystem numberSystem;
        int iMin;
        int i;
        boolean z3;
        int i2;
        char c;
        int i3;
        long integer;
        char c2;
        ChronoElement<V> chronoElement;
        boolean fromInt;
        int i4;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        if (z && this.fixedInt) {
            if (position >= length) {
                parseLog.setError(position, "Missing digits for: " + this.element.name());
                parseLog.setWarning();
                return;
            }
            char cCharAt2 = charSequence.charAt(position);
            if (cCharAt2 == '-' || cCharAt2 == '+') {
                parseLog.setError(position, "Sign not allowed due to sign policy.");
                return;
            }
            int i5 = this.minDigits + position;
            int iMin2 = Math.min(length, i5);
            int i6 = position;
            long j = 0;
            while (i6 < iMin2) {
                int iCharAt = charSequence.charAt(i6) - '0';
                if (iCharAt < 0 || iCharAt > 9) {
                    break;
                }
                j = (j * 10) + ((long) iCharAt);
                i6++;
            }
            if (j > 2147483647L) {
                parseLog.setError(position, "Parsed number does not fit into an integer: " + j);
                return;
            }
            if (i6 < i5) {
                if (i6 == position) {
                    parseLog.setError(position, "Digit expected.");
                    return;
                }
                parseLog.setError(position, "Not enough digits found for: " + this.element.name());
                return;
            }
            parsedEntity.put((ChronoElement<?>) this.element, (int) j);
            parseLog.setPosition(i6);
            return;
        }
        int iIntValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (iIntValue > 0) {
            length -= iIntValue;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing digits for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        if (this.yearOfEra) {
            ChronoElement<V> chronoElement2 = this.element;
            if (chronoElement2 instanceof DualFormatElement) {
                Integer num = ((DualFormatElement) DualFormatElement.class.cast(chronoElement2)).parse(charSequence, parseLog.getPP(), attributeQuery, parsedEntity);
                if (parseLog.isError()) {
                    parseLog.setError(parseLog.getErrorIndex(), "Unparseable element: " + this.element.name());
                    return;
                }
                if (num == null) {
                    parseLog.setError(position, "No interpretable value.");
                    return;
                } else {
                    parsedEntity.put((ChronoElement<?>) this.element, (Object) num);
                    return;
                }
            }
        }
        if (z) {
            NumberSystem numberSystem2 = this.numberSystem;
            boolean zIsDecimal = numberSystem2.isDecimal();
            scale = this.scaleOfNumsys;
            cCharAt = this.zeroDigit;
            z2 = zIsDecimal;
            numberSystem = numberSystem2;
        } else {
            NumberSystem numberSystem3 = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            boolean zIsDecimal2 = numberSystem3.isDecimal();
            scale = getScale(numberSystem3);
            if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
                cCharAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
            } else {
                cCharAt = zIsDecimal2 ? numberSystem3.getDigits().charAt(0) : '0';
            }
            z2 = zIsDecimal2;
            numberSystem = numberSystem3;
        }
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        if (!z2 || (!this.fixedWidth && leniency.isLax())) {
            iMin = scale;
            i = 1;
        } else {
            i = this.minDigits;
            iMin = this.maxDigits;
        }
        char cCharAt3 = charSequence.charAt(position);
        if (cCharAt3 == '-' || cCharAt3 == '+') {
            if (this.signPolicy == SignPolicy.SHOW_NEVER && (this.fixedWidth || leniency.isStrict())) {
                parseLog.setError(position, "Sign not allowed due to sign policy.");
                return;
            }
            if (this.signPolicy == SignPolicy.SHOW_WHEN_NEGATIVE && cCharAt3 == '+' && leniency.isStrict()) {
                parseLog.setError(position, "Positive sign not allowed due to sign policy.");
                return;
            } else {
                position++;
                z3 = cCharAt3 == '-';
                i2 = position;
            }
        } else if (this.signPolicy == SignPolicy.SHOW_ALWAYS && leniency.isStrict()) {
            parseLog.setError(position, "Missing sign of number.");
            return;
        } else {
            i2 = position;
            z3 = false;
        }
        if (position >= length) {
            parseLog.setError(i2, "Missing digits for: " + this.element.name());
            return;
        }
        if (this.fixedWidth || this.reserved <= 0 || iIntValue > 0) {
            c = cCharAt3;
        } else {
            if (z2) {
                int i7 = position;
                i4 = 0;
                while (true) {
                    if (i7 < length) {
                        int iCharAt2 = charSequence.charAt(i7) - cCharAt;
                        if (iCharAt2 >= 0) {
                            c = cCharAt3;
                            if (iCharAt2 > 9) {
                                break;
                            }
                            i4++;
                            i7++;
                            cCharAt3 = c;
                        }
                    }
                    c = cCharAt3;
                    break;
                }
            } else {
                c = cCharAt3;
                i4 = 0;
                for (int i8 = position; i8 < length && numberSystem.contains(charSequence.charAt(i8)); i8++) {
                    i4++;
                }
            }
            iMin = Math.min(iMin, i4 - this.reserved);
        }
        int i9 = i + position;
        int iMin3 = Math.min(length, iMin + position);
        if (z2) {
            integer = 0;
            while (position < iMin3) {
                int iCharAt3 = charSequence.charAt(position) - cCharAt;
                if (iCharAt3 < 0 || iCharAt3 > 9) {
                    break;
                }
                integer = (integer * 10) + ((long) iCharAt3);
                position++;
                i9 = i9;
            }
            i3 = i9;
        } else {
            i3 = i9;
            int i10 = 0;
            while (position < iMin3 && numberSystem.contains(charSequence.charAt(position))) {
                i10++;
                position++;
            }
            if (i10 > 0) {
                try {
                    integer = numberSystem.toInteger(charSequence.subSequence(position - i10, position).toString(), leniency);
                } catch (NumberFormatException e) {
                    parseLog.setError(i2, e.getMessage());
                    return;
                }
            } else {
                integer = 0;
            }
        }
        Class<V> type = this.element.getType();
        if (integer > 2147483647L && type == Integer.class) {
            parseLog.setError(i2, "Parsed number does not fit into an integer: " + integer);
            return;
        }
        int i11 = i3;
        if (position < i11) {
            if (position == i2) {
                parseLog.setError(i2, "Digit expected.");
                return;
            } else if (this.fixedWidth || !leniency.isLax()) {
                parseLog.setError(i2, "Not enough digits found for: " + this.element.name());
                return;
            }
        }
        if (z3) {
            if (integer == 0 && leniency.isStrict()) {
                parseLog.setError(i2 - 1, "Negative zero is not allowed.");
                return;
            }
            integer = -integer;
        } else {
            if (this.signPolicy == SignPolicy.SHOW_WHEN_BIG_NUMBER && leniency.isStrict() && z2) {
                c2 = c;
                if (c2 == '+' && position <= i11) {
                    parseLog.setError(i2 - 1, "Positive sign only allowed for big number.");
                } else if (c2 != '+' && position > i11) {
                    parseLog.setError(i2, "Positive sign must be present for big number.");
                }
            }
            if (type == Integer.class) {
                parsedEntity.put((ChronoElement<?>) this.element, (int) integer);
            } else if (type == Long.class) {
                parsedEntity.put((ChronoElement<?>) this.element, (Object) Long.valueOf(integer));
            } else if (this.element == PlainDate.MONTH_OF_YEAR) {
                parsedEntity.put(PlainDate.MONTH_AS_NUMBER, (int) integer);
            } else if (Enum.class.isAssignableFrom(type)) {
                chronoElement = this.element;
                if (chronoElement instanceof NumericalElement) {
                    fromInt = ((NumericalElement) chronoElement).parseFromInt(parsedEntity, (int) integer);
                } else {
                    fromInt = false;
                }
                if (!fromInt) {
                    if (c2 != '-' || c2 == '+') {
                        i2--;
                    }
                    parseLog.setError(i2, "[" + this.element.name() + "] No enum found for value: " + integer);
                    return;
                }
            } else {
                throw new IllegalArgumentException("Not parseable: " + this.element);
            }
            parseLog.setPosition(position);
        }
        c2 = c;
        if (type == Integer.class) {
            parsedEntity.put((ChronoElement<?>) this.element, (int) integer);
        } else if (type == Long.class) {
            parsedEntity.put((ChronoElement<?>) this.element, (Object) Long.valueOf(integer));
        } else if (this.element == PlainDate.MONTH_OF_YEAR) {
            parsedEntity.put(PlainDate.MONTH_AS_NUMBER, (int) integer);
        } else if (Enum.class.isAssignableFrom(type)) {
            chronoElement = this.element;
            if (chronoElement instanceof NumericalElement) {
                fromInt = ((NumericalElement) chronoElement).parseFromInt(parsedEntity, (int) integer);
            } else {
                fromInt = false;
            }
            if (!fromInt) {
                if (c2 != '-') {
                    i2--;
                } else {
                    i2--;
                }
                parseLog.setError(i2, "[" + this.element.name() + "] No enum found for value: " + integer);
                return;
            }
        } else {
            throw new IllegalArgumentException("Not parseable: " + this.element);
        }
        parseLog.setPosition(position);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberProcessor)) {
            return false;
        }
        NumberProcessor numberProcessor = (NumberProcessor) obj;
        return this.element.equals(numberProcessor.element) && this.fixedWidth == numberProcessor.fixedWidth && this.minDigits == numberProcessor.minDigits && this.maxDigits == numberProcessor.maxDigits && this.signPolicy == numberProcessor.signPolicy && this.protectedMode == numberProcessor.protectedMode;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.minDigits + (this.maxDigits * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", fixed-width-mode=");
        sb.append(this.fixedWidth);
        sb.append(", min-digits=");
        sb.append(this.minDigits);
        sb.append(", max-digits=");
        sb.append(this.maxDigits);
        sb.append(", sign-policy=");
        sb.append(this.signPolicy);
        sb.append(", protected-mode=");
        sb.append(this.protectedMode);
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<V> getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<V> withElement(ChronoElement<V> chronoElement) {
        return (this.protectedMode || this.element == chronoElement) ? this : new NumberProcessor(chronoElement, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, false);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<V> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        char c;
        char cCharAt;
        boolean z;
        NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
        if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
            cCharAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
        } else {
            if (numberSystem.isDecimal()) {
                cCharAt = numberSystem.getDigits().charAt(0);
            } else {
                c = '0';
            }
            int iIntValue = ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
            if (numberSystem != NumberSystem.ARABIC && c == '0' && this.fixedWidth && iIntValue == 0 && this.element.getType() == Integer.class && !this.yearOfEra) {
                z = true;
            } else {
                z = false;
            }
            return new NumberProcessor(this.element, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, this.protectedMode, i, c, numberSystem, (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), iIntValue, z);
        }
        c = cCharAt;
        int iIntValue2 = ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (numberSystem != NumberSystem.ARABIC) {
            z = false;
        } else {
            z = false;
        }
        return new NumberProcessor(this.element, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, this.protectedMode, i, c, numberSystem, (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), iIntValue2, z);
    }

    private int getScale(NumberSystem numberSystem) {
        if (!numberSystem.isDecimal()) {
            return 100;
        }
        Class<V> type = this.element.getType();
        if (type == Integer.class) {
            return 10;
        }
        return type == Long.class ? 18 : 9;
    }

    private static int length(int i) {
        int i2 = 0;
        while (i > THRESHOLDS[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    private static void appendTwoDigits(int i, Appendable appendable, char c) throws IOException {
        int i2 = (i * 103) >>> 10;
        appendable.append((char) (i2 + c));
        appendable.append((char) ((i - ((i2 << 3) + (i2 << 1))) + c));
    }
}
