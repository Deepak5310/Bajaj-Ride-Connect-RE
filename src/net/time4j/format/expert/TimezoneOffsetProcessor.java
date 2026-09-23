package net.time4j.format.expert;

import androidx.core.app.NotificationManagerCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes5.dex */
final class TimezoneOffsetProcessor implements FormatProcessor<TZID> {
    static final TimezoneOffsetProcessor EXTENDED_LONG_PARSER = new TimezoneOffsetProcessor();
    private final boolean caseInsensitive;
    private final boolean extended;
    private final Leniency lenientMode;
    private final DisplayMode precision;
    private final List<String> zeroOffsets;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return false;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<TZID> withElement(ChronoElement<TZID> chronoElement) {
        return this;
    }

    TimezoneOffsetProcessor(DisplayMode displayMode, boolean z, List<String> list) {
        if (displayMode == null) {
            throw new NullPointerException("Missing display mode.");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing zero offsets.");
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).trim().isEmpty()) {
                throw new IllegalArgumentException("Zero offset must not be white-space-only.");
            }
        }
        this.precision = displayMode;
        this.extended = z;
        this.zeroOffsets = Collections.unmodifiableList(arrayList);
        this.caseInsensitive = true;
        this.lenientMode = Leniency.SMART;
    }

    private TimezoneOffsetProcessor() {
        this.precision = DisplayMode.LONG;
        this.extended = true;
        this.zeroOffsets = Collections.emptyList();
        this.caseInsensitive = true;
        this.lenientMode = Leniency.SMART;
    }

    private TimezoneOffsetProcessor(DisplayMode displayMode, boolean z, List<String> list, boolean z2, Leniency leniency) {
        this.precision = displayMode;
        this.extended = z;
        this.zeroOffsets = list;
        this.caseInsensitive = z2;
        this.lenientMode = leniency;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008f A[PHI: r1
      0x008f: PHI (r1v22 int) = (r1v12 int), (r1v12 int), (r1v12 int), (r1v9 int) binds: [B:41:0x00b4, B:43:0x00ba, B:47:0x00c4, B:32:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        ZonalOffset offset;
        int i;
        int length;
        int length2 = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        TZID timezone = chronoDisplay.hasTimezone() ? chronoDisplay.getTimezone() : null;
        if (timezone == null) {
            offset = getOffset(chronoDisplay, attributeQuery);
        } else if (timezone instanceof ZonalOffset) {
            offset = (ZonalOffset) timezone;
        } else if (chronoDisplay instanceof UnixTime) {
            offset = Timezone.of(timezone).getOffset((UnixTime) chronoDisplay);
        } else {
            throw new IllegalArgumentException("Cannot extract timezone offset from: " + chronoDisplay);
        }
        int integralAmount = offset.getIntegralAmount();
        int fractionalAmount = offset.getFractionalAmount();
        if ((integralAmount | fractionalAmount) == 0) {
            String str = this.zeroOffsets.get(0);
            appendable.append(str);
            length = str.length();
        } else {
            appendable.append((integralAmount < 0 || fractionalAmount < 0) ? '-' : '+');
            int iAbs = Math.abs(integralAmount);
            int i2 = iAbs / 3600;
            int i3 = (iAbs / 60) % 60;
            int i4 = iAbs % 60;
            if (i2 < 10) {
                appendable.append('0');
                i = 2;
            } else {
                i = 1;
            }
            String strValueOf = String.valueOf(i2);
            appendable.append(strValueOf);
            int length3 = strValueOf.length() + i;
            if (this.precision == DisplayMode.SHORT && i3 == 0) {
                length = length3;
            } else {
                if (this.extended) {
                    appendable.append(':');
                    length3++;
                }
                if (i3 < 10) {
                    appendable.append('0');
                    length3++;
                }
                String strValueOf2 = String.valueOf(i3);
                appendable.append(strValueOf2);
                length3 += strValueOf2.length();
                if (this.precision == DisplayMode.SHORT || this.precision == DisplayMode.MEDIUM || (this.precision != DisplayMode.FULL && (i4 | fractionalAmount) == 0)) {
                    length = length3;
                } else {
                    if (this.extended) {
                        appendable.append(':');
                        length3++;
                    }
                    if (i4 < 10) {
                        appendable.append('0');
                        length3++;
                    }
                    String strValueOf3 = String.valueOf(i4);
                    appendable.append(strValueOf3);
                    int length4 = strValueOf3.length() + length3;
                    if (fractionalAmount != 0) {
                        appendable.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        int i5 = length4 + 1;
                        String strValueOf4 = String.valueOf(Math.abs(fractionalAmount));
                        int length5 = 9 - strValueOf4.length();
                        for (int i6 = 0; i6 < length5; i6++) {
                            appendable.append('0');
                            i5++;
                        }
                        appendable.append(strValueOf4);
                        length = strValueOf4.length() + i5;
                    } else {
                        length = length4;
                    }
                }
            }
        }
        if (length2 != -1 && length > 0 && set != null) {
            set.add(new ElementPosition(TimezoneElement.TIMEZONE_ID, length2, length2 + length));
        }
        return length;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0173  */
    /* JADX WARN: Code duplicated, block: B:108:0x0193  */
    /* JADX WARN: Code duplicated, block: B:112:0x019d  */
    /* JADX WARN: Code duplicated, block: B:114:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00de  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:68:0x0105  */
    /* JADX WARN: Code duplicated, block: B:69:0x0112  */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:90:0x0151  */
    /* JADX WARN: Code duplicated, block: B:92:0x0157  */
    /* JADX WARN: Code duplicated, block: B:94:0x015d  */
    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        OffsetSign offsetSign;
        int num;
        int i;
        int i2;
        int i3;
        int i4;
        int num2;
        int i5;
        int i6;
        int i7;
        ZonalOffset zonalOffsetOfTotalSeconds;
        int num3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        char cCharAt;
        boolean zBooleanValue;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        if (position >= length) {
            parseLog.setError(position, "Missing timezone offset.");
            return;
        }
        for (String str : this.zeroOffsets) {
            int length2 = str.length();
            if (length - position >= length2) {
                int i13 = length2 + position;
                String string = charSequence.subSequence(position, i13).toString();
                if (z) {
                    zBooleanValue = this.caseInsensitive;
                } else {
                    zBooleanValue = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
                }
                if ((zBooleanValue && string.equalsIgnoreCase(str)) || (!zBooleanValue && string.equals(str))) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.UTC);
                    parseLog.setPosition(i13);
                    return;
                }
            }
        }
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        char cCharAt2 = charSequence.charAt(position);
        if (cCharAt2 == '+') {
            offsetSign = OffsetSign.AHEAD_OF_UTC;
        } else {
            if (cCharAt2 == '-') {
                offsetSign = OffsetSign.BEHIND_UTC;
            } else if (Character.isDigit(cCharAt2) && leniency.isLax()) {
                offsetSign = OffsetSign.AHEAD_OF_UTC;
            } else {
                parseLog.setError(position, "Missing sign of timezone offset.");
                return;
            }
            num = parseNum(charSequence, position, leniency);
            if (num == -1000) {
                parseLog.setError(position, "Hour part in timezone offset does not match expected pattern HH.");
                return;
            }
            if (num < 0) {
                num = ~num;
                i = position + 1;
            } else {
                i = position + 2;
            }
            if (i >= length) {
                if (this.precision == DisplayMode.SHORT) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                    parseLog.setPosition(i);
                    return;
                } else {
                    parseLog.setError(i, "Missing minute part in timezone offset.");
                    return;
                }
            }
            i2 = 0;
            if (this.extended) {
                i3 = 0;
            } else {
                if (charSequence.charAt(i) == ':') {
                    if (this.precision == DisplayMode.SHORT) {
                        parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                        parseLog.setPosition(i);
                        return;
                    } else {
                        parseLog.setError(i, "Colon expected in timezone offset.");
                        return;
                    }
                }
                i3 = 1;
            }
            i4 = i3 + i;
            num2 = parseNum(charSequence, i4, Leniency.STRICT);
            if (num2 == -1000) {
                if (this.precision == DisplayMode.SHORT) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                    parseLog.setPosition(i);
                    return;
                } else {
                    parseLog.setError(i4, "Minute part in timezone offset does not match expected pattern mm.");
                    return;
                }
            }
            i5 = i4 + 2;
            if (i5 < length || !(this.precision == DisplayMode.LONG || this.precision == DisplayMode.FULL)) {
                i6 = 0;
            } else {
                if (this.extended) {
                    if (charSequence.charAt(i5) == ':') {
                        num3 = parseNum(charSequence, i4 + 3, Leniency.STRICT);
                        i8 = 1;
                    } else {
                        if (this.precision == DisplayMode.FULL) {
                            parseLog.setError(i5, "Colon expected in timezone offset.");
                            return;
                        }
                        num3 = -1000;
                    }
                    if (num3 == -1000) {
                        if (this.precision == DisplayMode.FULL) {
                            parseLog.setError(i5, "Second part in timezone offset does not match expected pattern ss.");
                            return;
                        }
                        i6 = 0;
                    } else {
                        i9 = i5 + i8;
                        i10 = i9 + 2;
                        if (i9 + 12 <= length && charSequence.charAt(i10) == '.') {
                            i11 = i9 + 3;
                            i12 = i9 + 12;
                            i10 = i11;
                            while (i11 < i12) {
                                cCharAt = charSequence.charAt(i11);
                                if (cCharAt >= '0' || cCharAt > '9') {
                                    parseLog.setError(i10, "9 digits in fractional part of timezone offset expected.");
                                    return;
                                } else {
                                    i2 = (i2 * 10) + (cCharAt - '0');
                                    i10++;
                                    i11++;
                                }
                            }
                        }
                        i5 = i10;
                        i6 = i2;
                        i2 = num3;
                    }
                } else {
                    num3 = parseNum(charSequence, i5, Leniency.STRICT);
                }
                i8 = 0;
                if (num3 == -1000) {
                    if (this.precision == DisplayMode.FULL) {
                        parseLog.setError(i5, "Second part in timezone offset does not match expected pattern ss.");
                        return;
                    }
                    i6 = 0;
                } else {
                    i9 = i5 + i8;
                    i10 = i9 + 2;
                    if (i9 + 12 <= length) {
                        i11 = i9 + 3;
                        i12 = i9 + 12;
                        i10 = i11;
                        while (i11 < i12) {
                            cCharAt = charSequence.charAt(i11);
                            if (cCharAt >= '0') {
                            }
                            parseLog.setError(i10, "9 digits in fractional part of timezone offset expected.");
                            return;
                        }
                    }
                    i5 = i10;
                    i6 = i2;
                    i2 = num3;
                }
            }
            if (i2 != 0 && i6 == 0) {
                zonalOffsetOfTotalSeconds = ZonalOffset.ofHoursMinutes(offsetSign, num, num2);
            } else {
                i7 = (num * 3600) + (num2 * 60) + i2;
                if (offsetSign == OffsetSign.BEHIND_UTC) {
                    i7 = -i7;
                    i6 = -i6;
                }
                zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i7, i6);
            }
            parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, zonalOffsetOfTotalSeconds);
            parseLog.setPosition(i5);
        }
        position++;
        num = parseNum(charSequence, position, leniency);
        if (num == -1000) {
            parseLog.setError(position, "Hour part in timezone offset does not match expected pattern HH.");
            return;
        }
        if (num < 0) {
            num = ~num;
            i = position + 1;
        } else {
            i = position + 2;
        }
        if (i >= length) {
            if (this.precision == DisplayMode.SHORT) {
                parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                parseLog.setPosition(i);
                return;
            } else {
                parseLog.setError(i, "Missing minute part in timezone offset.");
                return;
            }
        }
        i2 = 0;
        if (this.extended) {
            i3 = 0;
        } else {
            if (charSequence.charAt(i) == ':') {
                if (this.precision == DisplayMode.SHORT) {
                    parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                    parseLog.setPosition(i);
                    return;
                } else {
                    parseLog.setError(i, "Colon expected in timezone offset.");
                    return;
                }
            }
            i3 = 1;
        }
        i4 = i3 + i;
        num2 = parseNum(charSequence, i4, Leniency.STRICT);
        if (num2 == -1000) {
            if (this.precision == DisplayMode.SHORT) {
                parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, ZonalOffset.ofHours(offsetSign, num));
                parseLog.setPosition(i);
                return;
            } else {
                parseLog.setError(i4, "Minute part in timezone offset does not match expected pattern mm.");
                return;
            }
        }
        i5 = i4 + 2;
        if (i5 < length) {
            i6 = 0;
        } else {
            i6 = 0;
        }
        if (i2 != 0) {
            i7 = (num * 3600) + (num2 * 60) + i2;
            if (offsetSign == OffsetSign.BEHIND_UTC) {
                i7 = -i7;
                i6 = -i6;
            }
            zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i7, i6);
        } else {
            i7 = (num * 3600) + (num2 * 60) + i2;
            if (offsetSign == OffsetSign.BEHIND_UTC) {
                i7 = -i7;
                i6 = -i6;
            }
            zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i7, i6);
        }
        parsedEntity.put(TimezoneElement.TIMEZONE_OFFSET, zonalOffsetOfTotalSeconds);
        parseLog.setPosition(i5);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement<TZID> getElement() {
        return TimezoneElement.TIMEZONE_OFFSET;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor<TZID> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new TimezoneOffsetProcessor(this.precision, this.extended, this.zeroOffsets, ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimezoneOffsetProcessor)) {
            return false;
        }
        TimezoneOffsetProcessor timezoneOffsetProcessor = (TimezoneOffsetProcessor) obj;
        return this.precision == timezoneOffsetProcessor.precision && this.extended == timezoneOffsetProcessor.extended && this.zeroOffsets.equals(timezoneOffsetProcessor.zeroOffsets);
    }

    public int hashCode() {
        return (this.precision.hashCode() * 7) + (this.zeroOffsets.hashCode() * 31) + (this.extended ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[precision=");
        sb.append(this.precision);
        sb.append(", extended=");
        sb.append(this.extended);
        sb.append(", zero-offsets=");
        sb.append(this.zeroOffsets);
        sb.append(']');
        return sb.toString();
    }

    private static ZonalOffset getOffset(ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        if (attributeQuery.contains(Attributes.TIMEZONE_ID)) {
            TZID tzid = (TZID) attributeQuery.get(Attributes.TIMEZONE_ID);
            if (tzid instanceof ZonalOffset) {
                return (ZonalOffset) tzid;
            }
            if (tzid != null) {
                throw new IllegalArgumentException("Use a timezone offset instead of [" + tzid.canonical() + "] when formatting [" + chronoDisplay + "].");
            }
        }
        throw new IllegalArgumentException("Cannot extract timezone offset from format attributes for: " + chronoDisplay);
    }

    private static int parseNum(CharSequence charSequence, int i, Leniency leniency) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2) {
            int i4 = i + i2;
            char cCharAt = i4 >= charSequence.length() ? (char) 0 : charSequence.charAt(i4);
            if (cCharAt < '0' || cCharAt > '9') {
                return (i2 == 0 || leniency.isStrict()) ? NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : ~i3;
            }
            i3 = (i3 * 10) + (cCharAt - '0');
            i2++;
        }
        return i3;
    }
}
