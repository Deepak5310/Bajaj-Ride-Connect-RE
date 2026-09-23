package net.time4j.format;

import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import java.lang.Comparable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.BasicElement;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DisplayElement<V extends Comparable<V>> extends BasicElement<V> {
    private static final Map<String, String> OTHER_DISPLAY_KEYS;

    static {
        HashMap map = new HashMap();
        map.put("YEAR_OF_DISPLAY", "L_year");
        map.put("MONTH_AS_NUMBER", "L_month");
        map.put("HOUR_FROM_0_TO_24", "L_hour");
        map.put("DAY_OF_MONTH", "L_day");
        map.put("DAY_OF_DIVISION", "L_day");
        OTHER_DISPLAY_KEYS = Collections.unmodifiableMap(map);
    }

    protected DisplayElement(String str) {
        super(str);
    }

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public String getDisplayName(Locale locale) {
        String str;
        switch (getSymbol()) {
            case 'E':
            case 'e':
                str = "L_weekday";
                break;
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                str = "L_era";
                break;
            case 'H':
            case 'K':
            case 'h':
            case 'k':
                str = "L_hour";
                break;
            case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                str = "L_month";
                break;
            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                str = "L_quarter";
                break;
            case 'W':
            case PanasonicMakernoteDirectory.TAG_BURST_SPEED /* 119 */:
                str = "L_week";
                break;
            case PanasonicMakernoteDirectory.TAG_TRANSFORM /* 89 */:
            case 'u':
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE /* 121 */:
                str = "L_year";
                break;
            case 'd':
                str = "L_day";
                break;
            case 'm':
                str = "L_minute";
                break;
            case 's':
                str = "L_second";
                break;
            default:
                String strName = name();
                String str2 = OTHER_DISPLAY_KEYS.get(strName);
                if (str2 == null) {
                    return strName;
                }
                str = str2;
                break;
        }
        String str3 = CalendarText.getIsoInstance(locale).getTextForms().get(str);
        return str3 == null ? name() : str3;
    }
}
