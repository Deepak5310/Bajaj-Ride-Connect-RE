package net.time4j.history;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.List;
import java.util.Locale;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.base.GregorianDate;
import net.time4j.base.MathUtils;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.history.internal.StdHistoricalElement;

/* JADX INFO: loaded from: classes5.dex */
final class HistoricIntegerElement extends StdHistoricalElement implements DualFormatElement {
    static final int CENTURY_INDEX = 8;
    static final int DAY_OF_MONTH_INDEX = 4;
    static final int DAY_OF_YEAR_INDEX = 5;
    static final int MONTH_INDEX = 3;
    static final int YEAR_AFTER_INDEX = 6;
    static final int YEAR_BEFORE_INDEX = 7;
    static final int YEAR_OF_ERA_INDEX = 2;
    private static final long serialVersionUID = -6283098762945747308L;
    private final ChronoHistory history;
    private final transient int index;

    @Override // net.time4j.history.internal.StdHistoricalElement, net.time4j.engine.BasicElement
    protected boolean isSingleton() {
        return false;
    }

    HistoricIntegerElement(char c, int i, int i2, ChronoHistory chronoHistory, int i3) {
        super(toName(i3), c, i, i2);
        this.history = chronoHistory;
        this.index = i3;
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        char cCharAt;
        NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
        if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
            cCharAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
        } else {
            cCharAt = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
        }
        print(chronoDisplay, appendable, attributeQuery, numberSystem, cCharAt, 1, 10);
    }

    @Override // net.time4j.format.internal.DualFormatElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2) throws IOException {
        HistoricDate historicDateConvert;
        int yearOfEra;
        if (this.index == 5) {
            appendable.append(String.valueOf(chronoDisplay.get(this.history.dayOfYear())));
            return;
        }
        if (chronoDisplay instanceof GregorianDate) {
            historicDateConvert = this.history.convert(PlainDate.from((GregorianDate) chronoDisplay));
        } else {
            historicDateConvert = (HistoricDate) chronoDisplay.get(this.history.date());
        }
        int i3 = this.index;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    appendable.append(String.valueOf(historicDateConvert.getDayOfMonth()));
                    return;
                }
                throw new ChronoException("Not printable as text: " + name());
            }
            int iIntValue = ((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue();
            int month = historicDateConvert.getMonth();
            if (iIntValue == 0) {
                appendable.append(monthAccessor(attributeQuery, (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print(Month.valueOf(month)));
                return;
            }
            String numeral = numberSystem.toNumeral(month);
            if (numberSystem.isDecimal()) {
                numeral = pad(numeral, iIntValue, c);
            }
            appendable.append(numeral);
            return;
        }
        NewYearStrategy newYearStrategy = this.history.getNewYearStrategy();
        int yearOfEra2 = historicDateConvert.getYearOfEra();
        String string = null;
        if (!NewYearStrategy.DEFAULT.equals(newYearStrategy) && (yearOfEra = historicDateConvert.getYearOfEra(newYearStrategy)) != yearOfEra2) {
            if (attributeQuery.get(ChronoHistory.YEAR_DEFINITION, YearDefinition.DUAL_DATING) == YearDefinition.DUAL_DATING) {
                string = dual(numberSystem, c, yearOfEra, yearOfEra2, i);
            } else {
                yearOfEra2 = yearOfEra;
            }
        }
        if (string == null) {
            if (numberSystem.isDecimal()) {
                string = pad(numberSystem.toNumeral(yearOfEra2), i, c);
            } else {
                string = numberSystem.toNumeral(yearOfEra2);
            }
        }
        if (numberSystem.isDecimal()) {
            char cCharAt = numberSystem.getDigits().charAt(0);
            if (c != cCharAt) {
                StringBuilder sb = new StringBuilder();
                int length = string.length();
                for (int i4 = 0; i4 < length; i4++) {
                    char cCharAt2 = string.charAt(i4);
                    if (numberSystem.contains(cCharAt2)) {
                        sb.append((char) (cCharAt2 + (c - cCharAt)));
                    } else {
                        sb.append(cCharAt2);
                    }
                }
                string = sb.toString();
            }
            checkLength(string, i2);
        }
        appendable.append(string);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // net.time4j.format.TextElement
    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        return parse(charSequence, parsePosition, attributeQuery, null);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x016c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0170  */
    @Override // net.time4j.format.internal.DualFormatElement
    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, ChronoEntity<?> chronoEntity) {
        char cCharAt;
        int i;
        int i2;
        int num;
        int index;
        int i3 = this.index;
        if (i3 == 3) {
            int index2 = parsePosition.getIndex();
            if (((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue() == 0) {
                OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
                Month month = (Month) monthAccessor(attributeQuery, outputContext).parse(charSequence, parsePosition, Month.class, attributeQuery);
                if (month == null && ((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
                    parsePosition.setErrorIndex(-1);
                    parsePosition.setIndex(index2);
                    month = (Month) monthAccessor(attributeQuery, outputContext == OutputContext.FORMAT ? OutputContext.STANDALONE : OutputContext.FORMAT).parse(charSequence, parsePosition, Month.class, attributeQuery);
                }
                if (month == null) {
                    return null;
                }
                return Integer.valueOf(month.getValue());
            }
        } else if (i3 == 6 || i3 == 7 || i3 == 8) {
            throw new ChronoException("Not parseable as text element: " + name());
        }
        NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
        if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
            cCharAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
        } else {
            cCharAt = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
        }
        char c = cCharAt;
        Leniency leniency = numberSystem.isDecimal() ? Leniency.SMART : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        int index3 = parsePosition.getIndex();
        int num2 = parseNum(numberSystem, c, charSequence, index3, parsePosition, leniency);
        int index4 = parsePosition.getIndex();
        if (this.index != 2 || index4 <= index3 || NewYearStrategy.DEFAULT.equals(this.history.getNewYearStrategy()) || index4 >= charSequence.length() || charSequence.charAt(index4) != '/' || attributeQuery.get(ChronoHistory.YEAR_DEFINITION, YearDefinition.DUAL_DATING) != YearDefinition.DUAL_DATING) {
            i = index4;
            i2 = num2;
        } else {
            int i4 = index4 + 1;
            i = index4;
            i2 = num2;
            num = parseNum(numberSystem, c, charSequence, i4, parsePosition, leniency);
            index = parsePosition.getIndex();
            if (index == i4) {
                parsePosition.setIndex(i);
            } else {
                int i5 = this.history.getNewYearStrategy().rule(HistoricEra.AD, i2) == NewYearRule.CALCULUS_PISANUS ? 2 : 1;
                int ancientYear = getAncientYear(i2, num, i5);
                if (numberSystem.isDecimal() && ancientYear != Integer.MAX_VALUE) {
                    if (chronoEntity != null) {
                        chronoEntity.with(StdHistoricalElement.YEAR_OF_DISPLAY, i2);
                    }
                    num = ancientYear;
                } else if (Math.abs(num - i2) > i5) {
                    parsePosition.setIndex(i);
                } else if (chronoEntity != null) {
                    chronoEntity.with(StdHistoricalElement.YEAR_OF_DISPLAY, i2);
                }
                if (index == index3) {
                    parsePosition.setErrorIndex(index3);
                    return null;
                }
                return Integer.valueOf(num);
            }
        }
        num = i2;
        index = i;
        if (index == index3) {
            parsePosition.setErrorIndex(index3);
            return null;
        }
        return Integer.valueOf(num);
    }

    @Override // net.time4j.engine.BasicElement
    protected <T extends ChronoEntity<T>> ElementRule<T, Integer> derive(Chronology<T> chronology) {
        if (chronology.isRegistered(PlainDate.COMPONENT)) {
            return new Rule(this.index, this.history);
        }
        return null;
    }

    @Override // net.time4j.engine.BasicElement
    protected boolean doEquals(BasicElement<?> basicElement) {
        return this.history.equals(((HistoricIntegerElement) basicElement).history);
    }

    private int getAncientYear(int i, int i2, int i3) {
        if (i2 < 0) {
            return Integer.MAX_VALUE;
        }
        if (i2 >= 100 || i < 100) {
            return Integer.MAX_VALUE;
        }
        int i4 = i2 < 10 ? 10 : 100;
        if (Math.abs(i2 - MathUtils.floorModulo(i, i4)) <= i3) {
            return (MathUtils.floorDivide(i, i4) * i4) + i2;
        }
        return Integer.MAX_VALUE;
    }

    private String dual(NumberSystem numberSystem, char c, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(numberSystem.toNumeral(i));
        sb.append('/');
        if (numberSystem.isDecimal() && i2 >= 100 && MathUtils.floorDivide(i, 100) == MathUtils.floorDivide(i2, 100)) {
            int iFloorModulo = MathUtils.floorModulo(i2, 100);
            if (iFloorModulo < 10) {
                sb.append(c);
            }
            sb.append(numberSystem.toNumeral(iFloorModulo));
        } else {
            sb.append(numberSystem.toNumeral(i2));
        }
        if (numberSystem.isDecimal()) {
            return pad(sb.toString(), i3, c);
        }
        return sb.toString();
    }

    private static String pad(String str, int i, char c) {
        int length = str.length();
        if (i <= length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = i - length;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    private void checkLength(String str, int i) {
        if (str.length() <= i) {
            return;
        }
        throw new IllegalArgumentException("Element " + name() + " cannot be printed as the formatted value " + str + " exceeds the maximum width of " + i + ".");
    }

    private TextAccessor monthAccessor(AttributeQuery attributeQuery, OutputContext outputContext) {
        return CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getStdMonths((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), outputContext);
    }

    private static int parseNum(NumberSystem numberSystem, char c, CharSequence charSequence, int i, ParsePosition parsePosition, Leniency leniency) {
        int i2;
        boolean z;
        int iCharAt;
        int iCharAt2 = 0;
        long integer = 0;
        if (numberSystem.isDecimal()) {
            if (numberSystem == NumberSystem.ARABIC && charSequence.charAt(i) == '-') {
                i2 = i + 1;
                z = true;
            } else {
                i2 = i;
                z = false;
            }
            iCharAt2 = leniency.isStrict() ? 0 : numberSystem.getDigits().charAt(0);
            int iMin = Math.min(i2 + 9, charSequence.length());
            int i3 = i2;
            while (i2 < iMin) {
                int iCharAt3 = charSequence.charAt(i2) - c;
                if (iCharAt3 >= 0 && iCharAt3 <= 9) {
                    integer = (integer * 10) + ((long) iCharAt3);
                    i3++;
                } else {
                    if (iCharAt2 == 0 || c == iCharAt2 || (iCharAt = charSequence.charAt(i2) - iCharAt2) < 0 || iCharAt > 9) {
                        break;
                    }
                    integer = (integer * 10) + ((long) iCharAt);
                    i3++;
                    c = iCharAt2;
                }
                i2++;
            }
            if (integer > 2147483647L) {
                parsePosition.setErrorIndex(i);
                return Integer.MIN_VALUE;
            }
            if (!z) {
                i = i3;
            } else if (i3 != i + 1) {
                integer = MathUtils.safeNegate(integer);
                i = i3;
            }
        } else {
            int length = charSequence.length();
            for (int i4 = i; i4 < length && numberSystem.contains(charSequence.charAt(i4)); i4++) {
                iCharAt2++;
            }
            if (iCharAt2 > 0) {
                int i5 = iCharAt2 + i;
                integer = numberSystem.toInteger(charSequence.subSequence(i, i5).toString(), leniency);
                i = i5;
            }
        }
        parsePosition.setIndex(i);
        return (int) integer;
    }

    private static String toName(int i) {
        switch (i) {
            case 2:
                return "YEAR_OF_ERA";
            case 3:
                return "HISTORIC_MONTH";
            case 4:
                return "HISTORIC_DAY_OF_MONTH";
            case 5:
                return "HISTORIC_DAY_OF_YEAR";
            case 6:
                return "YEAR_AFTER";
            case 7:
                return "YEAR_BEFORE";
            case 8:
                return "CENTURY_OF_ERA";
            default:
                throw new UnsupportedOperationException("Unknown element index: " + i);
        }
    }

    private Object readResolve() throws ObjectStreamException {
        String strName = name();
        if (strName.equals("YEAR_OF_ERA")) {
            return this.history.yearOfEra();
        }
        if (strName.equals("HISTORIC_MONTH")) {
            return this.history.month();
        }
        if (strName.equals("HISTORIC_DAY_OF_MONTH")) {
            return this.history.dayOfMonth();
        }
        if (strName.equals("HISTORIC_DAY_OF_YEAR")) {
            return this.history.dayOfYear();
        }
        if (strName.equals("YEAR_AFTER")) {
            return this.history.yearOfEra(YearDefinition.AFTER_NEW_YEAR);
        }
        if (strName.equals("YEAR_BEFORE")) {
            return this.history.yearOfEra(YearDefinition.BEFORE_NEW_YEAR);
        }
        if (strName.equals("CENTURY_OF_ERA")) {
            return this.history.centuryOfEra();
        }
        throw new InvalidObjectException("Unknown element: " + strName);
    }

    private static class Rule<C extends ChronoEntity<C>> implements ElementRule<C, Integer> {
        private final ChronoHistory history;
        private final int index;

        Rule(int i, ChronoHistory chronoHistory) {
            this.index = i;
            this.history = chronoHistory;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(C c) {
            int yearOfEra;
            try {
                PlainDate plainDate = (PlainDate) c.get(PlainDate.COMPONENT);
                HistoricDate historicDateConvert = this.history.convert(plainDate);
                switch (this.index) {
                    case 2:
                        yearOfEra = historicDateConvert.getYearOfEra();
                        break;
                    case 3:
                        yearOfEra = historicDateConvert.getMonth();
                        break;
                    case 4:
                        yearOfEra = historicDateConvert.getDayOfMonth();
                        break;
                    case 5:
                        yearOfEra = (int) ((plainDate.getDaysSinceEpochUTC() - this.history.convert(this.history.getBeginOfYear(historicDateConvert.getEra(), historicDateConvert.getYearOfEra(this.history.getNewYearStrategy()))).getDaysSinceEpochUTC()) + 1);
                        break;
                    case 6:
                    case 7:
                        yearOfEra = historicDateConvert.getYearOfEra(this.history.getNewYearStrategy());
                        break;
                    case 8:
                        yearOfEra = ((historicDateConvert.getYearOfEra() - 1) / 100) + 1;
                        break;
                    default:
                        throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
                return Integer.valueOf(yearOfEra);
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(C c) {
            try {
                HistoricDate historicDateConvert = this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
                int i = this.index;
                if (i != 2 && i != 6 && i != 7 && i != 8) {
                    HistoricDate historicDateAdjust = adjust(c, 1);
                    if (this.history.isValid(historicDateAdjust)) {
                        return 1;
                    }
                    if (this.index == 5) {
                        throw new ChronoException("Historic New Year cannot be determined.");
                    }
                    List<CutOverEvent> events = this.history.getEvents();
                    for (int size = events.size() - 1; size >= 0; size--) {
                        CutOverEvent cutOverEvent = events.get(size);
                        if (historicDateConvert.compareTo(cutOverEvent.dateAtCutOver) >= 0) {
                            historicDateAdjust = cutOverEvent.dateAtCutOver;
                            break;
                        }
                    }
                    return Integer.valueOf(this.index == 3 ? historicDateAdjust.getMonth() : historicDateAdjust.getDayOfMonth());
                }
                if (historicDateConvert.getEra() == HistoricEra.BYZANTINE && historicDateConvert.getMonth() >= 9) {
                    return 0;
                }
                return 1;
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:32:0x009b A[Catch: RuntimeException -> 0x010b, TryCatch #0 {RuntimeException -> 0x010b, blocks: (B:3:0x0002, B:4:0x0017, B:5:0x001a, B:61:0x00f9, B:62:0x010a, B:6:0x001e, B:8:0x0035, B:10:0x003a, B:11:0x0041, B:12:0x0042, B:20:0x0067, B:22:0x006f, B:24:0x0074, B:26:0x0082, B:28:0x0090, B:29:0x0093, B:30:0x0096, B:32:0x009b, B:34:0x00a4, B:33:0x00a0, B:13:0x0051, B:15:0x0059, B:19:0x0062, B:36:0x00a9, B:56:0x00ea, B:58:0x00ee, B:59:0x00f4, B:39:0x00b0, B:41:0x00b6, B:45:0x00c6, B:47:0x00cc, B:51:0x00dc), top: B:66:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00a0 A[Catch: RuntimeException -> 0x010b, TryCatch #0 {RuntimeException -> 0x010b, blocks: (B:3:0x0002, B:4:0x0017, B:5:0x001a, B:61:0x00f9, B:62:0x010a, B:6:0x001e, B:8:0x0035, B:10:0x003a, B:11:0x0041, B:12:0x0042, B:20:0x0067, B:22:0x006f, B:24:0x0074, B:26:0x0082, B:28:0x0090, B:29:0x0093, B:30:0x0096, B:32:0x009b, B:34:0x00a4, B:33:0x00a0, B:13:0x0051, B:15:0x0059, B:19:0x0062, B:36:0x00a9, B:56:0x00ea, B:58:0x00ee, B:59:0x00f4, B:39:0x00b0, B:41:0x00b6, B:45:0x00c6, B:47:0x00cc, B:51:0x00dc), top: B:66:0x0002 }] */
        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(C c) {
            HistoricDate historicDateAdjust;
            int maximumDayOfMonth;
            int dayOfMonth;
            try {
                HistoricDate historicDateConvert = this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
                int i = 8;
                int i2 = 999984973;
                switch (this.index) {
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                        if (this.history != ChronoHistory.PROLEPTIC_BYZANTINE) {
                            if (this.history == ChronoHistory.PROLEPTIC_JULIAN) {
                                i2 = historicDateConvert.getEra() == HistoricEra.BC ? 999979466 : 999979465;
                            } else if (this.history == ChronoHistory.PROLEPTIC_GREGORIAN) {
                                i2 = historicDateConvert.getEra() == HistoricEra.BC ? 1000000000 : 999999999;
                            } else {
                                i2 = historicDateConvert.getEra() == HistoricEra.BC ? 45 : 9999;
                            }
                        }
                        if (this.index == 8) {
                            i2 = ((i2 - 1) / 100) + 1;
                        }
                        return Integer.valueOf(i2);
                    case 3:
                        if (historicDateConvert.getEra() != HistoricEra.BYZANTINE || historicDateConvert.getYearOfEra() != 999984973) {
                            i = 12;
                        }
                        historicDateAdjust = adjust(c, i);
                        maximumDayOfMonth = i;
                        break;
                    case 4:
                        maximumDayOfMonth = this.history.getAlgorithm(historicDateConvert).getMaximumDayOfMonth(historicDateConvert);
                        historicDateAdjust = adjust(c, maximumDayOfMonth);
                        break;
                    case 5:
                        int lengthOfYear = this.history.getLengthOfYear(historicDateConvert.getEra(), historicDateConvert.getYearOfEra(this.history.getNewYearStrategy()));
                        if (lengthOfYear == -1) {
                            throw new ChronoException("Length of historic year undefined.");
                        }
                        return Integer.valueOf(lengthOfYear);
                    default:
                        throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
                if (this.history.isValid(historicDateAdjust)) {
                    return Integer.valueOf(maximumDayOfMonth);
                }
                List<CutOverEvent> events = this.history.getEvents();
                for (int size = events.size() - 1; size >= 0; size--) {
                    CutOverEvent cutOverEvent = events.get(size);
                    if (historicDateConvert.compareTo(cutOverEvent.dateAtCutOver) < 0) {
                        historicDateAdjust = cutOverEvent.dateBeforeCutOver;
                        if (this.index == 3) {
                            dayOfMonth = historicDateAdjust.getMonth();
                        } else {
                            dayOfMonth = historicDateAdjust.getDayOfMonth();
                        }
                        return Integer.valueOf(dayOfMonth);
                    }
                }
                if (this.index == 3) {
                    dayOfMonth = historicDateAdjust.getMonth();
                } else {
                    dayOfMonth = historicDateAdjust.getDayOfMonth();
                }
                return Integer.valueOf(dayOfMonth);
            } catch (RuntimeException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: isValid, reason: merged with bridge method [inline-methods] */
        public boolean isValid2(C c, Integer num) {
            if (num == null) {
                return false;
            }
            try {
                return this.history.isValid(adjust(c, num.intValue()));
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // net.time4j.engine.ElementRule
        /* JADX INFO: renamed from: withValue, reason: merged with bridge method [inline-methods] */
        public C withValue2(C c, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing historic element value.");
            }
            return (C) c.with(PlainDate.COMPONENT, this.history.convert(adjust(c, num.intValue())));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtFloor(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement<?> getChildAtCeiling(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        private HistoricDate adjust(C c, int i) {
            HistoricDate historicDateConvert = this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
            YearDefinition yearDefinition = YearDefinition.DUAL_DATING;
            NewYearStrategy newYearStrategy = this.history.getNewYearStrategy();
            int i2 = this.index;
            switch (i2) {
                case 2:
                    break;
                case 3:
                    return this.history.adjustDayOfMonth(HistoricDate.of(historicDateConvert.getEra(), historicDateConvert.getYearOfEra(), i, historicDateConvert.getDayOfMonth()));
                case 4:
                    return HistoricDate.of(historicDateConvert.getEra(), historicDateConvert.getYearOfEra(), historicDateConvert.getMonth(), i);
                case 5:
                    int yearOfEra = historicDateConvert.getYearOfEra(this.history.getNewYearStrategy());
                    HistoricDate beginOfYear = this.history.getBeginOfYear(historicDateConvert.getEra(), yearOfEra);
                    int lengthOfYear = this.history.getLengthOfYear(historicDateConvert.getEra(), yearOfEra);
                    if (i == 1) {
                        return beginOfYear;
                    }
                    if (i > 1 && i <= lengthOfYear) {
                        return this.history.convert(this.history.convert(beginOfYear).plus(CalendarDays.of(i - 1)));
                    }
                    throw new IllegalArgumentException("Out of range: " + i);
                case 6:
                case 7:
                    yearDefinition = i2 == 6 ? YearDefinition.AFTER_NEW_YEAR : YearDefinition.BEFORE_NEW_YEAR;
                    break;
                case 8:
                    int yearOfEra2 = historicDateConvert.getYearOfEra() % 100;
                    return this.history.adjustDayOfMonth(HistoricDate.of(historicDateConvert.getEra(), ((i - 1) * 100) + (yearOfEra2 != 0 ? yearOfEra2 : 100), historicDateConvert.getMonth(), historicDateConvert.getDayOfMonth(), yearDefinition, newYearStrategy));
                default:
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
            return this.history.adjustDayOfMonth(HistoricDate.of(historicDateConvert.getEra(), i, historicDateConvert.getMonth(), historicDateConvert.getDayOfMonth(), yearDefinition, newYearStrategy));
        }
    }
}
