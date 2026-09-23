package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPDateTime;
import com.adobe.internal.xmp.XMPException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class ISO8601Converter {
    private ISO8601Converter() {
    }

    public static XMPDateTime parse(String str) throws XMPException {
        return parse(str, new XMPDateTimeImpl());
    }

    /* JADX WARN: Code duplicated, block: B:137:0x021e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x021f  */
    public static XMPDateTime parse(String str, XMPDateTime xMPDateTime) throws XMPException {
        int i;
        int i2;
        int i3;
        if (str == null) {
            throw new XMPException("Parameter must not be null", 4);
        }
        if (str.length() == 0) {
            return xMPDateTime;
        }
        ParseState parseState = new ParseState(str);
        int iGatherInt = 0;
        if (parseState.ch(0) == '-') {
            parseState.skip();
        }
        int iGatherInt2 = parseState.gatherInt("Invalid year in date string", 9999);
        if (parseState.hasNext() && parseState.ch() != '-') {
            throw new XMPException("Invalid date string, after year", 5);
        }
        if (parseState.ch(0) == '-') {
            iGatherInt2 = -iGatherInt2;
        }
        xMPDateTime.setYear(iGatherInt2);
        if (!parseState.hasNext()) {
            return xMPDateTime;
        }
        parseState.skip();
        int iGatherInt3 = parseState.gatherInt("Invalid month in date string", 12);
        if (parseState.hasNext() && parseState.ch() != '-') {
            throw new XMPException("Invalid date string, after month", 5);
        }
        xMPDateTime.setMonth(iGatherInt3);
        if (!parseState.hasNext()) {
            return xMPDateTime;
        }
        parseState.skip();
        int iGatherInt4 = parseState.gatherInt("Invalid day in date string", 31);
        if (parseState.hasNext() && parseState.ch() != 'T') {
            throw new XMPException("Invalid date string, after day", 5);
        }
        xMPDateTime.setDay(iGatherInt4);
        if (!parseState.hasNext()) {
            return xMPDateTime;
        }
        parseState.skip();
        xMPDateTime.setHour(parseState.gatherInt("Invalid hour in date string", 23));
        if (!parseState.hasNext()) {
            return xMPDateTime;
        }
        if (parseState.ch() == ':') {
            parseState.skip();
            int iGatherInt5 = parseState.gatherInt("Invalid minute in date string", 59);
            if (parseState.hasNext() && parseState.ch() != ':' && parseState.ch() != 'Z' && parseState.ch() != '+' && parseState.ch() != '-') {
                throw new XMPException("Invalid date string, after minute", 5);
            }
            xMPDateTime.setMinute(iGatherInt5);
        }
        if (!parseState.hasNext()) {
            return xMPDateTime;
        }
        if (parseState.hasNext() && parseState.ch() == ':') {
            parseState.skip();
            int iGatherInt6 = parseState.gatherInt("Invalid whole seconds in date string", 59);
            if (parseState.hasNext() && parseState.ch() != '.' && parseState.ch() != 'Z' && parseState.ch() != '+' && parseState.ch() != '-') {
                throw new XMPException("Invalid date string, after whole seconds", 5);
            }
            xMPDateTime.setSecond(iGatherInt6);
            if (parseState.ch() == '.') {
                parseState.skip();
                int iPos = parseState.pos();
                int iGatherInt7 = parseState.gatherInt("Invalid fractional seconds in date string", 999999999);
                if (parseState.hasNext() && parseState.ch() != 'Z' && parseState.ch() != '+' && parseState.ch() != '-') {
                    throw new XMPException("Invalid date string, after fractional second", 5);
                }
                int iPos2 = parseState.pos() - iPos;
                while (iPos2 > 9) {
                    iGatherInt7 /= 10;
                    iPos2--;
                }
                while (iPos2 < 9) {
                    iGatherInt7 *= 10;
                    iPos2++;
                }
                xMPDateTime.setNanoSecond(iGatherInt7);
            }
        } else if (parseState.ch() != 'Z' && parseState.ch() != '+' && parseState.ch() != '-') {
            throw new XMPException("Invalid date string, after time", 5);
        }
        if (!parseState.hasNext()) {
            return xMPDateTime;
        }
        if (parseState.ch() == 'Z') {
            parseState.skip();
        } else {
            if (parseState.hasNext()) {
                if (parseState.ch() == '+') {
                    i = 1;
                } else {
                    if (parseState.ch() != '-') {
                        throw new XMPException("Time zone must begin with 'Z', '+', or '-'", 5);
                    }
                    i = -1;
                }
                parseState.skip();
                int iGatherInt8 = parseState.gatherInt("Invalid time zone hour in date string", 23);
                if (parseState.hasNext()) {
                    if (parseState.ch() == ':') {
                        parseState.skip();
                        iGatherInt = parseState.gatherInt("Invalid time zone minute in date string", 59);
                    } else {
                        throw new XMPException("Invalid date string, after time zone hour", 5);
                    }
                }
                int i4 = i;
                i2 = iGatherInt;
                iGatherInt = iGatherInt8;
                i3 = i4;
            }
            xMPDateTime.setTimeZone(new SimpleTimeZone(((iGatherInt * DateTimeConstants.MILLIS_PER_HOUR) + (i2 * DateTimeConstants.MILLIS_PER_MINUTE)) * i3, ""));
            if (parseState.hasNext()) {
                throw new XMPException("Invalid date string, extra chars at end", 5);
            }
            return xMPDateTime;
        }
        i2 = 0;
        i3 = 0;
        xMPDateTime.setTimeZone(new SimpleTimeZone(((iGatherInt * DateTimeConstants.MILLIS_PER_HOUR) + (i2 * DateTimeConstants.MILLIS_PER_MINUTE)) * i3, ""));
        if (parseState.hasNext()) {
            return xMPDateTime;
        }
        throw new XMPException("Invalid date string, extra chars at end", 5);
    }

    public static String render(XMPDateTime xMPDateTime) {
        StringBuffer stringBuffer = new StringBuffer();
        if (xMPDateTime.hasDate()) {
            DecimalFormat decimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
            stringBuffer.append(decimalFormat.format(xMPDateTime.getYear()));
            if (xMPDateTime.getMonth() == 0) {
                return stringBuffer.toString();
            }
            decimalFormat.applyPattern("'-'00");
            stringBuffer.append(decimalFormat.format(xMPDateTime.getMonth()));
            if (xMPDateTime.getDay() == 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(decimalFormat.format(xMPDateTime.getDay()));
            if (xMPDateTime.hasTime()) {
                stringBuffer.append('T');
                decimalFormat.applyPattern("00");
                stringBuffer.append(decimalFormat.format(xMPDateTime.getHour()));
                stringBuffer.append(':');
                stringBuffer.append(decimalFormat.format(xMPDateTime.getMinute()));
                if (xMPDateTime.getSecond() != 0 || xMPDateTime.getNanoSecond() != 0) {
                    double second = ((double) xMPDateTime.getSecond()) + (((double) xMPDateTime.getNanoSecond()) / 1.0E9d);
                    decimalFormat.applyPattern(":00.#########");
                    stringBuffer.append(decimalFormat.format(second));
                }
                if (xMPDateTime.hasTimeZone()) {
                    int offset = xMPDateTime.getTimeZone().getOffset(xMPDateTime.getCalendar().getTimeInMillis());
                    if (offset == 0) {
                        stringBuffer.append('Z');
                    } else {
                        int i = offset / DateTimeConstants.MILLIS_PER_HOUR;
                        int iAbs = Math.abs((offset % DateTimeConstants.MILLIS_PER_HOUR) / DateTimeConstants.MILLIS_PER_MINUTE);
                        decimalFormat.applyPattern("+00;-00");
                        stringBuffer.append(decimalFormat.format(i));
                        decimalFormat.applyPattern(":00");
                        stringBuffer.append(decimalFormat.format(iAbs));
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
