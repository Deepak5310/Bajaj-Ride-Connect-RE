package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import net.time4j.PlainDate;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.expert.Iso8601Format;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class Nengo implements CalendarEra, Serializable {
    private static final Map<String, Nengo> CHINESE_TO_NENGO;
    private static final byte COURT_NORTHERN = 1;
    private static final byte COURT_SOUTHERN = -1;
    private static final byte COURT_STANDARD = 0;
    public static final Nengo HEISEI;
    private static final Map<String, Nengo> KANJI_TO_NENGO;
    private static final TST KOREAN_TO_NENGO;
    public static final Nengo MEIJI;
    private static final String[] MODERN_KEYS;
    private static final Nengo[] MODERN_NENGOS;
    private static final Nengo NENGO_KENMU;
    private static final Nengo NENGO_OEI;
    public static final Nengo NEWEST;
    private static final String NEW_ERA_PROPERTY = "net.time4j.calendar.japanese.supplemental.era";
    private static final Nengo[] NORTHERN_NENGOS;
    private static final Nengo[] OFFICIAL_NENGOS;
    public static final Nengo REIWA;
    private static final TST ROMAJI_TO_NENGO;
    private static final TST RUSSIAN_TO_NENGO;
    public static final AttributeKey<Selector> SELECTOR;
    public static final Nengo SHOWA;
    public static final Nengo TAISHO;
    private static final long serialVersionUID = 5696395761628504723L;
    private final transient String chinese;
    private final byte court;
    private final int index;
    private final transient String kanji;
    private final transient String korean;
    private final transient int relgregyear;
    private final transient String romaji;
    private final transient String russian;
    private final transient long start;

    public enum Selector implements ChronoCondition<Nengo> {
        OFFICIAL { // from class: net.time4j.calendar.Nengo.Selector.1
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.court != 1;
            }
        },
        MODERN { // from class: net.time4j.calendar.Nengo.Selector.2
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.index >= Nengo.MEIJI.index;
            }
        },
        EDO_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.3
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1603 && nengo.relgregyear < 1868;
            }
        },
        AZUCHI_MOMOYAMA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.4
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1573 && nengo.relgregyear < 1603;
            }
        },
        MUROMACHI_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.5
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1336 && nengo.relgregyear < 1573 && nengo.court != 1;
            }
        },
        NORTHERN_COURT { // from class: net.time4j.calendar.Nengo.Selector.6
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.court == 1;
            }
        },
        SOUTHERN_COURT { // from class: net.time4j.calendar.Nengo.Selector.7
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.court == -1;
            }
        },
        KAMAKURA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.8
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1185 && nengo.relgregyear < 1332;
            }
        },
        HEIAN_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.9
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 794 && nengo.relgregyear < 1185;
            }
        },
        NARA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.10
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 710 && nengo.relgregyear < 794;
            }
        },
        ASUKA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.11
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 538 && nengo.relgregyear < 710;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0235  */
    /* JADX WARN: Code duplicated, block: B:102:0x023f  */
    /* JADX WARN: Code duplicated, block: B:104:0x024a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0260 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:128:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:154:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0212 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ab A[Catch: EOFException -> 0x0095, IOException -> 0x018b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x018b, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:24:0x00a0, B:27:0x00ab, B:41:0x0109, B:44:0x010e, B:50:0x011b, B:52:0x0124, B:53:0x0130, B:55:0x0136, B:57:0x013e, B:59:0x014e, B:60:0x016d, B:30:0x00da, B:32:0x00f1), top: B:140:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:38:0x0103  */
    /* JADX WARN: Code duplicated, block: B:39:0x0106  */
    /* JADX WARN: Code duplicated, block: B:49:0x0119  */
    /* JADX WARN: Code duplicated, block: B:52:0x0124 A[Catch: EOFException -> 0x016e, IOException -> 0x018b, TryCatch #4 {IOException -> 0x018b, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:24:0x00a0, B:27:0x00ab, B:41:0x0109, B:44:0x010e, B:50:0x011b, B:52:0x0124, B:53:0x0130, B:55:0x0136, B:57:0x013e, B:59:0x014e, B:60:0x016d, B:30:0x00da, B:32:0x00f1), top: B:140:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0136 A[Catch: EOFException -> 0x016e, IOException -> 0x018b, TRY_LEAVE, TryCatch #4 {IOException -> 0x018b, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:24:0x00a0, B:27:0x00ab, B:41:0x0109, B:44:0x010e, B:50:0x011b, B:52:0x0124, B:53:0x0130, B:55:0x0136, B:57:0x013e, B:59:0x014e, B:60:0x016d, B:30:0x00da, B:32:0x00f1), top: B:140:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01db  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x0205  */
    /* JADX WARN: Code duplicated, block: B:93:0x020f  */
    /* JADX WARN: Code duplicated, block: B:96:0x021a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0225  */
    /* JADX WARN: Code duplicated, block: B:99:0x022a  */
    static {
        ArrayList arrayList;
        Nengo nengo;
        Nengo nengo2;
        DataInputStream dataInputStream;
        short s;
        int i;
        String utf;
        String utf2;
        String utf3;
        String utf4;
        Nengo nengo3;
        byte b;
        Nengo nengo4;
        byte b2;
        TST tst;
        ArrayList arrayList2;
        int i2;
        String str;
        DataInputStream dataInputStream2;
        String str2;
        String str3;
        Nengo nengo5;
        int i3;
        Nengo nengo6;
        Iterator it2;
        String property;
        Nengo nengo7;
        String[] strArrSplit;
        int length;
        String strHepburn;
        int i4;
        PlainDate date;
        String str4;
        String str5;
        String strCapitalize;
        String str6;
        String[] strArrSplit2;
        String str7;
        String str8;
        ArrayList arrayList3 = new ArrayList(256);
        ArrayList arrayList4 = new ArrayList(16);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TST tst2 = new TST();
        TST tst3 = new TST();
        TST tst4 = new TST();
        InputStream inputStreamLoad = ResourceLoader.getInstance().load(ResourceLoader.getInstance().locate("calendar", Nengo.class, "data/nengo.data"), true);
        if (inputStreamLoad == null) {
            try {
                try {
                    inputStreamLoad = ResourceLoader.getInstance().load(Nengo.class, "data/nengo.data", true);
                    try {
                        dataInputStream = new DataInputStream(inputStreamLoad);
                        nengo = null;
                        nengo2 = null;
                        while (true) {
                            try {
                                s = dataInputStream.readShort();
                                i = dataInputStream.readInt();
                                utf = dataInputStream.readUTF();
                                utf2 = dataInputStream.readUTF();
                                utf3 = dataInputStream.readUTF();
                                utf4 = dataInputStream.readUTF();
                                nengo3 = nengo;
                                try {
                                    b = dataInputStream.readByte();
                                    nengo4 = nengo2;
                                    try {
                                        b2 = dataInputStream.readByte();
                                        tst = tst4;
                                        try {
                                            arrayList2 = new ArrayList(b2);
                                            i2 = 0;
                                            while (i2 < b2) {
                                                byte b3 = b2;
                                                try {
                                                    arrayList2.add(dataInputStream.readUTF());
                                                    i2++;
                                                    b2 = b3;
                                                } catch (EOFException unused) {
                                                    arrayList = arrayList4;
                                                    nengo = nengo3;
                                                    nengo2 = nengo4;
                                                    tst4 = tst;
                                                    property = System.getProperty(NEW_ERA_PROPERTY);
                                                    if (property != null) {
                                                        strArrSplit = property.split(",");
                                                        length = strArrSplit.length;
                                                        strHepburn = null;
                                                        i4 = 0;
                                                        date = null;
                                                        str4 = null;
                                                        str5 = null;
                                                        strCapitalize = null;
                                                        str6 = null;
                                                        while (i4 < length) {
                                                            int i5 = length;
                                                            String[] strArr = strArrSplit;
                                                            strArrSplit2 = strArrSplit[i4].split("=");
                                                            Nengo nengo8 = nengo;
                                                            if (strArrSplit2.length != 2) {
                                                                if (strArrSplit2[0].equals("name")) {
                                                                    strHepburn = hepburn(strArrSplit2[1], 0);
                                                                } else if (strArrSplit2[0].equals("kanji")) {
                                                                    str8 = strArrSplit2[1];
                                                                    if (str8.length() == 2) {
                                                                        throw new IllegalArgumentException("Japanese kanji must be of length 2.");
                                                                    }
                                                                    str5 = str8;
                                                                } else if (strArrSplit2[0].equals(LocalePreferences.CalendarType.CHINESE)) {
                                                                    str7 = strArrSplit2[1];
                                                                    if (str7.length() == 2) {
                                                                        throw new IllegalArgumentException("Chinese kanji must be of length 2.");
                                                                    }
                                                                    str6 = str7;
                                                                } else if (strArrSplit2[0].equals("korean")) {
                                                                    str4 = strArrSplit2[1];
                                                                } else if (strArrSplit2[0].equals("russian")) {
                                                                    strCapitalize = capitalize(strArrSplit2[1], 0);
                                                                } else if (strArrSplit2[0].equals("since")) {
                                                                    try {
                                                                        date = Iso8601Format.parseDate(strArrSplit2[1]);
                                                                    } catch (ParseException unused2) {
                                                                    }
                                                                }
                                                            }
                                                            i4++;
                                                            length = i5;
                                                            strArrSplit = strArr;
                                                            nengo = nengo8;
                                                        }
                                                        nengo7 = nengo;
                                                        if (strHepburn == null) {
                                                        }
                                                        throw new IllegalStateException("Invalid syntax: " + property);
                                                    }
                                                    nengo7 = nengo;
                                                    Nengo[] nengoArr = (Nengo[]) arrayList3.toArray(new Nengo[arrayList3.size()]);
                                                    OFFICIAL_NENGOS = nengoArr;
                                                    NORTHERN_NENGOS = (Nengo[]) arrayList.toArray(new Nengo[arrayList.size()]);
                                                    NENGO_KENMU = nengo7;
                                                    NENGO_OEI = nengo2;
                                                    KANJI_TO_NENGO = Collections.unmodifiableMap(map);
                                                    CHINESE_TO_NENGO = Collections.unmodifiableMap(map2);
                                                    KOREAN_TO_NENGO = tst2;
                                                    RUSSIAN_TO_NENGO = tst3;
                                                    ROMAJI_TO_NENGO = tst4;
                                                    Nengo nengo9 = nengoArr[223];
                                                    MEIJI = nengo9;
                                                    Nengo nengo10 = nengoArr[224];
                                                    TAISHO = nengo10;
                                                    Nengo nengo11 = nengoArr[225];
                                                    SHOWA = nengo11;
                                                    Nengo nengo12 = nengoArr[226];
                                                    HEISEI = nengo12;
                                                    Nengo nengo13 = nengoArr[227];
                                                    REIWA = nengo13;
                                                    NEWEST = nengoArr[nengoArr.length - 1];
                                                    SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
                                                    MODERN_KEYS = new String[]{"reiwa", "heisei", "showa", "taisho", "meiji"};
                                                    MODERN_NENGOS = new Nengo[]{nengo13, nengo12, nengo11, nengo10, nengo9};
                                                }
                                            }
                                            str = (String) arrayList2.get(0);
                                            if (b == 1) {
                                                str2 = utf3;
                                                dataInputStream2 = dataInputStream;
                                                str3 = utf;
                                                Nengo nengo14 = new Nengo(s, i, str3, utf2, str2, utf4, str, b, arrayList4.size());
                                                arrayList4.add(nengo14);
                                                arrayList = arrayList4;
                                                nengo6 = nengo14;
                                                nengo2 = nengo4;
                                                i3 = 1334;
                                            } else {
                                                dataInputStream2 = dataInputStream;
                                                str2 = utf3;
                                                str3 = utf;
                                                arrayList = arrayList4;
                                                try {
                                                    nengo5 = new Nengo(s, i, str3, utf2, str2, utf4, str, b, arrayList3.size());
                                                    arrayList3.add(nengo5);
                                                    i3 = 1334;
                                                    if (s == 1334) {
                                                        nengo6 = nengo5;
                                                        nengo3 = nengo6;
                                                    } else if (s == 1394) {
                                                        nengo2 = nengo5;
                                                        nengo6 = nengo2;
                                                    } else {
                                                        nengo6 = nengo5;
                                                    }
                                                    nengo2 = nengo4;
                                                } catch (EOFException unused3) {
                                                    tst4 = tst;
                                                    nengo = nengo3;
                                                    nengo2 = nengo4;
                                                    property = System.getProperty(NEW_ERA_PROPERTY);
                                                    if (property != null) {
                                                        strArrSplit = property.split(",");
                                                        length = strArrSplit.length;
                                                        strHepburn = null;
                                                        i4 = 0;
                                                        date = null;
                                                        str4 = null;
                                                        str5 = null;
                                                        strCapitalize = null;
                                                        str6 = null;
                                                        while (i4 < length) {
                                                            int i6 = length;
                                                            String[] strArr2 = strArrSplit;
                                                            strArrSplit2 = strArrSplit[i4].split("=");
                                                            Nengo nengo15 = nengo;
                                                            if (strArrSplit2.length != 2) {
                                                                if (strArrSplit2[0].equals("name")) {
                                                                    strHepburn = hepburn(strArrSplit2[1], 0);
                                                                } else if (strArrSplit2[0].equals("kanji")) {
                                                                    str8 = strArrSplit2[1];
                                                                    if (str8.length() == 2) {
                                                                        throw new IllegalArgumentException("Japanese kanji must be of length 2.");
                                                                    }
                                                                    str5 = str8;
                                                                } else if (strArrSplit2[0].equals(LocalePreferences.CalendarType.CHINESE)) {
                                                                    str7 = strArrSplit2[1];
                                                                    if (str7.length() == 2) {
                                                                        throw new IllegalArgumentException("Chinese kanji must be of length 2.");
                                                                    }
                                                                    str6 = str7;
                                                                } else if (strArrSplit2[0].equals("korean")) {
                                                                    str4 = strArrSplit2[1];
                                                                } else if (strArrSplit2[0].equals("russian")) {
                                                                    strCapitalize = capitalize(strArrSplit2[1], 0);
                                                                } else if (strArrSplit2[0].equals("since")) {
                                                                    date = Iso8601Format.parseDate(strArrSplit2[1]);
                                                                }
                                                            }
                                                            i4++;
                                                            length = i6;
                                                            strArrSplit = strArr2;
                                                            nengo = nengo15;
                                                        }
                                                        nengo7 = nengo;
                                                        if (strHepburn == null) {
                                                        }
                                                        throw new IllegalStateException("Invalid syntax: " + property);
                                                    }
                                                    nengo7 = nengo;
                                                    Nengo[] nengoArr2 = (Nengo[]) arrayList3.toArray(new Nengo[arrayList3.size()]);
                                                    OFFICIAL_NENGOS = nengoArr2;
                                                    NORTHERN_NENGOS = (Nengo[]) arrayList.toArray(new Nengo[arrayList.size()]);
                                                    NENGO_KENMU = nengo7;
                                                    NENGO_OEI = nengo2;
                                                    KANJI_TO_NENGO = Collections.unmodifiableMap(map);
                                                    CHINESE_TO_NENGO = Collections.unmodifiableMap(map2);
                                                    KOREAN_TO_NENGO = tst2;
                                                    RUSSIAN_TO_NENGO = tst3;
                                                    ROMAJI_TO_NENGO = tst4;
                                                    Nengo nengo16 = nengoArr2[223];
                                                    MEIJI = nengo16;
                                                    Nengo nengo17 = nengoArr2[224];
                                                    TAISHO = nengo17;
                                                    Nengo nengo18 = nengoArr2[225];
                                                    SHOWA = nengo18;
                                                    Nengo nengo19 = nengoArr2[226];
                                                    HEISEI = nengo19;
                                                    Nengo nengo110 = nengoArr2[227];
                                                    REIWA = nengo110;
                                                    NEWEST = nengoArr2[nengoArr2.length - 1];
                                                    SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
                                                    MODERN_KEYS = new String[]{"reiwa", "heisei", "showa", "taisho", "meiji"};
                                                    MODERN_NENGOS = new Nengo[]{nengo110, nengo19, nengo18, nengo17, nengo16};
                                                }
                                            }
                                            try {
                                                if (nengo6.court == 1) {
                                                    map.put(str3, nengo6);
                                                    if (map2.put(utf2, nengo6) == null) {
                                                        tst4 = tst;
                                                        throw new IllegalStateException(nengo6.relgregyear + StringUtils.SPACE + nengo6.chinese);
                                                    }
                                                    tst2.insert(str2, nengo6);
                                                    tst3.insert(utf4, nengo6);
                                                    it2 = arrayList2.iterator();
                                                    while (it2.hasNext()) {
                                                        tst4 = tst;
                                                        tst4.insert((String) it2.next(), nengo6);
                                                        tst = tst4;
                                                    }
                                                    nengo = nengo3;
                                                } else {
                                                    try {
                                                        if (nengo6.relgregyear != i3) {
                                                            map.put(str3, nengo6);
                                                            if (map2.put(utf2, nengo6) == null) {
                                                                tst4 = tst;
                                                                throw new IllegalStateException(nengo6.relgregyear + StringUtils.SPACE + nengo6.chinese);
                                                            }
                                                            tst2.insert(str2, nengo6);
                                                            tst3.insert(utf4, nengo6);
                                                            it2 = arrayList2.iterator();
                                                            while (it2.hasNext()) {
                                                                tst4 = tst;
                                                                try {
                                                                    tst4.insert((String) it2.next(), nengo6);
                                                                    tst = tst4;
                                                                } catch (EOFException unused4) {
                                                                }
                                                            }
                                                            nengo = nengo3;
                                                        }
                                                    } catch (EOFException unused5) {
                                                        nengo = nengo3;
                                                        tst4 = tst;
                                                        property = System.getProperty(NEW_ERA_PROPERTY);
                                                        if (property != null) {
                                                            strArrSplit = property.split(",");
                                                            length = strArrSplit.length;
                                                            strHepburn = null;
                                                            i4 = 0;
                                                            date = null;
                                                            str4 = null;
                                                            str5 = null;
                                                            strCapitalize = null;
                                                            str6 = null;
                                                            while (i4 < length) {
                                                                int i7 = length;
                                                                String[] strArr3 = strArrSplit;
                                                                strArrSplit2 = strArrSplit[i4].split("=");
                                                                Nengo nengo111 = nengo;
                                                                if (strArrSplit2.length != 2) {
                                                                    if (strArrSplit2[0].equals("name")) {
                                                                        strHepburn = hepburn(strArrSplit2[1], 0);
                                                                    } else if (strArrSplit2[0].equals("kanji")) {
                                                                        str8 = strArrSplit2[1];
                                                                        if (str8.length() == 2) {
                                                                            throw new IllegalArgumentException("Japanese kanji must be of length 2.");
                                                                        }
                                                                        str5 = str8;
                                                                    } else if (strArrSplit2[0].equals(LocalePreferences.CalendarType.CHINESE)) {
                                                                        str7 = strArrSplit2[1];
                                                                        if (str7.length() == 2) {
                                                                            throw new IllegalArgumentException("Chinese kanji must be of length 2.");
                                                                        }
                                                                        str6 = str7;
                                                                    } else if (strArrSplit2[0].equals("korean")) {
                                                                        str4 = strArrSplit2[1];
                                                                    } else if (strArrSplit2[0].equals("russian")) {
                                                                        strCapitalize = capitalize(strArrSplit2[1], 0);
                                                                    } else if (strArrSplit2[0].equals("since")) {
                                                                        date = Iso8601Format.parseDate(strArrSplit2[1]);
                                                                    }
                                                                }
                                                                i4++;
                                                                length = i7;
                                                                strArrSplit = strArr3;
                                                                nengo = nengo111;
                                                            }
                                                            nengo7 = nengo;
                                                            if (strHepburn == null) {
                                                            }
                                                            throw new IllegalStateException("Invalid syntax: " + property);
                                                        }
                                                        nengo7 = nengo;
                                                        Nengo[] nengoArr3 = (Nengo[]) arrayList3.toArray(new Nengo[arrayList3.size()]);
                                                        OFFICIAL_NENGOS = nengoArr3;
                                                        NORTHERN_NENGOS = (Nengo[]) arrayList.toArray(new Nengo[arrayList.size()]);
                                                        NENGO_KENMU = nengo7;
                                                        NENGO_OEI = nengo2;
                                                        KANJI_TO_NENGO = Collections.unmodifiableMap(map);
                                                        CHINESE_TO_NENGO = Collections.unmodifiableMap(map2);
                                                        KOREAN_TO_NENGO = tst2;
                                                        RUSSIAN_TO_NENGO = tst3;
                                                        ROMAJI_TO_NENGO = tst4;
                                                        Nengo nengo112 = nengoArr3[223];
                                                        MEIJI = nengo112;
                                                        Nengo nengo113 = nengoArr3[224];
                                                        TAISHO = nengo113;
                                                        Nengo nengo114 = nengoArr3[225];
                                                        SHOWA = nengo114;
                                                        Nengo nengo115 = nengoArr3[226];
                                                        HEISEI = nengo115;
                                                        Nengo nengo116 = nengoArr3[227];
                                                        REIWA = nengo116;
                                                        NEWEST = nengoArr3[nengoArr3.length - 1];
                                                        SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
                                                        MODERN_KEYS = new String[]{"reiwa", "heisei", "showa", "taisho", "meiji"};
                                                        MODERN_NENGOS = new Nengo[]{nengo116, nengo115, nengo114, nengo113, nengo112};
                                                    }
                                                }
                                                tst4 = tst;
                                                nengo = nengo3;
                                                dataInputStream = dataInputStream2;
                                                arrayList4 = arrayList;
                                            } catch (EOFException unused6) {
                                                tst4 = tst;
                                            }
                                        } catch (EOFException unused7) {
                                            arrayList = arrayList4;
                                        }
                                    } catch (EOFException unused8) {
                                        arrayList = arrayList4;
                                    }
                                } catch (EOFException unused9) {
                                    arrayList = arrayList4;
                                }
                            } catch (EOFException unused10) {
                                arrayList = arrayList4;
                            }
                        }
                    } catch (EOFException unused11) {
                        arrayList = arrayList4;
                        nengo = null;
                        nengo2 = null;
                    }
                } catch (EOFException unused12) {
                    arrayList = arrayList4;
                    nengo = null;
                    nengo2 = null;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Invalid nengo data.", e);
            }
        } else {
            dataInputStream = new DataInputStream(inputStreamLoad);
            nengo = null;
            nengo2 = null;
            while (true) {
                s = dataInputStream.readShort();
                i = dataInputStream.readInt();
                utf = dataInputStream.readUTF();
                utf2 = dataInputStream.readUTF();
                utf3 = dataInputStream.readUTF();
                utf4 = dataInputStream.readUTF();
                nengo3 = nengo;
                b = dataInputStream.readByte();
                nengo4 = nengo2;
                b2 = dataInputStream.readByte();
                tst = tst4;
                arrayList2 = new ArrayList(b2);
                i2 = 0;
                while (i2 < b2) {
                    byte b4 = b2;
                    arrayList2.add(dataInputStream.readUTF());
                    i2++;
                    b2 = b4;
                }
                str = (String) arrayList2.get(0);
                if (b == 1) {
                    str2 = utf3;
                    dataInputStream2 = dataInputStream;
                    str3 = utf;
                    Nengo nengo117 = new Nengo(s, i, str3, utf2, str2, utf4, str, b, arrayList4.size());
                    arrayList4.add(nengo117);
                    arrayList = arrayList4;
                    nengo6 = nengo117;
                    nengo2 = nengo4;
                    i3 = 1334;
                } else {
                    dataInputStream2 = dataInputStream;
                    str2 = utf3;
                    str3 = utf;
                    arrayList = arrayList4;
                    nengo5 = new Nengo(s, i, str3, utf2, str2, utf4, str, b, arrayList3.size());
                    arrayList3.add(nengo5);
                    i3 = 1334;
                    if (s == 1334) {
                        nengo6 = nengo5;
                        nengo3 = nengo6;
                    } else if (s == 1394) {
                        nengo2 = nengo5;
                        nengo6 = nengo2;
                    } else {
                        nengo6 = nengo5;
                    }
                    nengo2 = nengo4;
                }
                if (nengo6.court == 1) {
                    map.put(str3, nengo6);
                    if (map2.put(utf2, nengo6) == null) {
                        tst4 = tst;
                        throw new IllegalStateException(nengo6.relgregyear + StringUtils.SPACE + nengo6.chinese);
                    }
                    tst2.insert(str2, nengo6);
                    tst3.insert(utf4, nengo6);
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        tst4 = tst;
                        tst4.insert((String) it2.next(), nengo6);
                        tst = tst4;
                    }
                    nengo = nengo3;
                } else if (nengo6.relgregyear != i3) {
                    map.put(str3, nengo6);
                    if (map2.put(utf2, nengo6) == null) {
                        tst4 = tst;
                        throw new IllegalStateException(nengo6.relgregyear + StringUtils.SPACE + nengo6.chinese);
                    }
                    tst2.insert(str2, nengo6);
                    tst3.insert(utf4, nengo6);
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        tst4 = tst;
                        tst4.insert((String) it2.next(), nengo6);
                        tst = tst4;
                    }
                    nengo = nengo3;
                }
                tst4 = tst;
                nengo = nengo3;
                dataInputStream = dataInputStream2;
                arrayList4 = arrayList;
            }
        }
        property = System.getProperty(NEW_ERA_PROPERTY);
        if (property != null) {
            strArrSplit = property.split(",");
            length = strArrSplit.length;
            strHepburn = null;
            i4 = 0;
            date = null;
            str4 = null;
            str5 = null;
            strCapitalize = null;
            str6 = null;
            while (i4 < length) {
                int i8 = length;
                String[] strArr4 = strArrSplit;
                strArrSplit2 = strArrSplit[i4].split("=");
                Nengo nengo118 = nengo;
                if (strArrSplit2.length != 2) {
                    if (strArrSplit2[0].equals("name")) {
                        strHepburn = hepburn(strArrSplit2[1], 0);
                    } else if (strArrSplit2[0].equals("kanji")) {
                        str8 = strArrSplit2[1];
                        if (str8.length() == 2) {
                            throw new IllegalArgumentException("Japanese kanji must be of length 2.");
                        }
                        str5 = str8;
                    } else if (strArrSplit2[0].equals(LocalePreferences.CalendarType.CHINESE)) {
                        str7 = strArrSplit2[1];
                        if (str7.length() == 2) {
                            throw new IllegalArgumentException("Chinese kanji must be of length 2.");
                        }
                        str6 = str7;
                    } else if (strArrSplit2[0].equals("korean")) {
                        str4 = strArrSplit2[1];
                    } else if (strArrSplit2[0].equals("russian")) {
                        strCapitalize = capitalize(strArrSplit2[1], 0);
                    } else if (strArrSplit2[0].equals("since")) {
                        date = Iso8601Format.parseDate(strArrSplit2[1]);
                    }
                }
                i4++;
                length = i8;
                strArrSplit = strArr4;
                nengo = nengo118;
            }
            nengo7 = nengo;
            if (strHepburn == null && str5 != null && date != null) {
                Nengo nengo20 = (Nengo) arrayList3.get(arrayList3.size() - 1);
                if (!date.isAfter((CalendarDate) nengo20.getStart())) {
                    throw new IllegalStateException("New Japanese era must be after last defined nengo: " + nengo20.romaji);
                }
                String str9 = str6 == null ? str5 : str6;
                String str10 = str4 == null ? strHepburn : str4;
                String str11 = strCapitalize == null ? strHepburn : strCapitalize;
                String str12 = str5;
                Nengo nengo21 = new Nengo(date.getYear(), date.getDaysSinceEpochUTC(), str12, str9, str10, str11, strHepburn, (byte) 0, arrayList3.size());
                arrayList3.add(nengo21);
                map.put(str12, nengo21);
                map2.put(str9, nengo21);
                tst2.insert(str10, nengo21);
                tst3.insert(str11, nengo21);
                tst4.insert(strHepburn, nengo21);
            } else {
                throw new IllegalStateException("Invalid syntax: " + property);
            }
        } else {
            nengo7 = nengo;
        }
        Nengo[] nengoArr4 = (Nengo[]) arrayList3.toArray(new Nengo[arrayList3.size()]);
        OFFICIAL_NENGOS = nengoArr4;
        NORTHERN_NENGOS = (Nengo[]) arrayList.toArray(new Nengo[arrayList.size()]);
        NENGO_KENMU = nengo7;
        NENGO_OEI = nengo2;
        KANJI_TO_NENGO = Collections.unmodifiableMap(map);
        CHINESE_TO_NENGO = Collections.unmodifiableMap(map2);
        KOREAN_TO_NENGO = tst2;
        RUSSIAN_TO_NENGO = tst3;
        ROMAJI_TO_NENGO = tst4;
        Nengo nengo119 = nengoArr4[223];
        MEIJI = nengo119;
        Nengo nengo1110 = nengoArr4[224];
        TAISHO = nengo1110;
        Nengo nengo1111 = nengoArr4[225];
        SHOWA = nengo1111;
        Nengo nengo1112 = nengoArr4[226];
        HEISEI = nengo1112;
        Nengo nengo1113 = nengoArr4[227];
        REIWA = nengo1113;
        NEWEST = nengoArr4[nengoArr4.length - 1];
        SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
        MODERN_KEYS = new String[]{"reiwa", "heisei", "showa", "taisho", "meiji"};
        MODERN_NENGOS = new Nengo[]{nengo1113, nengo1112, nengo1111, nengo1110, nengo119};
    }

    private Nengo(int i, long j, String str, String str2, String str3, String str4, String str5, byte b, int i2) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing kanji.");
        }
        if (str5.isEmpty()) {
            throw new IllegalArgumentException("Missing latin transcription.");
        }
        if (b > 1 || b < -1) {
            throw new IllegalArgumentException("Undefined court byte: " + ((int) b));
        }
        this.relgregyear = i;
        this.start = j;
        this.kanji = str;
        this.chinese = str2;
        this.korean = str3;
        this.russian = str4;
        this.romaji = str5;
        this.court = b;
        this.index = i2;
    }

    public static Nengo ofRelatedGregorianYear(int i) {
        return ofRelatedGregorianYear(i, Selector.OFFICIAL);
    }

    public static Nengo ofRelatedGregorianYear(int i, Selector selector) {
        Nengo nengo;
        Nengo nengo2;
        Nengo nengo3 = null;
        if (i >= 701) {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()];
            if (i2 == 1) {
                if (i >= 1873) {
                    return ofRelatedGregorianYear(i, Selector.MODERN);
                }
                int length = OFFICIAL_NENGOS.length - 1;
                int i3 = 0;
                while (i3 <= length) {
                    int i4 = (i3 + length) >> 1;
                    if (OFFICIAL_NENGOS[i4].getFirstRelatedGregorianYear() <= i) {
                        i3 = i4 + 1;
                    } else {
                        length = i4 - 1;
                    }
                }
                if (i3 != 0) {
                    return OFFICIAL_NENGOS[i3 - 1];
                }
            } else if (i2 == 2) {
                int lowerBound = getLowerBound(selector);
                for (int length2 = OFFICIAL_NENGOS.length - 1; length2 >= lowerBound; length2--) {
                    nengo = OFFICIAL_NENGOS[length2];
                    if (nengo.relgregyear <= i) {
                        nengo3 = nengo;
                        break;
                    }
                }
            } else if (i2 != 3) {
                if (i2 != 4) {
                    int lowerBound2 = getLowerBound(selector);
                    int upperBound = getUpperBound(selector);
                    Nengo[] nengoArr = OFFICIAL_NENGOS;
                    if (i >= nengoArr[lowerBound2].relgregyear && i <= nengoArr[upperBound + 1].relgregyear) {
                        while (upperBound >= lowerBound2) {
                            nengo = OFFICIAL_NENGOS[upperBound];
                            if (nengo.relgregyear <= i) {
                                nengo3 = nengo;
                                break;
                            }
                            upperBound--;
                        }
                    }
                } else if (i >= 1334 && i <= 1393) {
                    int i5 = NENGO_OEI.index - 1;
                    while (true) {
                        nengo2 = OFFICIAL_NENGOS[i5];
                        if (nengo2.court != -1) {
                            break;
                        }
                        if (nengo2.relgregyear <= i) {
                            nengo3 = nengo2;
                            break;
                        }
                        i5--;
                    }
                }
            } else if (i >= 1332 && i <= 1394) {
                for (int length3 = NORTHERN_NENGOS.length - 1; length3 >= 0; length3--) {
                    nengo2 = NORTHERN_NENGOS[length3];
                    if (nengo2.relgregyear <= i) {
                        nengo3 = nengo2;
                        break;
                    }
                }
            }
        }
        if (nengo3 != null) {
            return nengo3;
        }
        throw new IllegalArgumentException("Could not find nengo for year=" + i + ", selector=" + selector + ".");
    }

    public static Nengo ofKanji(String str) {
        Nengo nengo = KANJI_TO_NENGO.get(str);
        if (nengo != null) {
            return nengo;
        }
        throw new IllegalArgumentException("Could not find any nengo for Japanese kanji: " + str);
    }

    public static List<Nengo> parseRomaji(String str) {
        String strHepburn = hepburn(str, 0);
        TST tst = ROMAJI_TO_NENGO;
        return tst.find(tst.longestPrefixOf(strHepburn, 0));
    }

    public static List<Nengo> list() {
        return list(Selector.OFFICIAL);
    }

    public static List<Nengo> list(Selector selector) {
        List listAsList;
        int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()];
        if (i == 1) {
            listAsList = Arrays.asList(OFFICIAL_NENGOS);
        } else if (i == 3) {
            listAsList = Arrays.asList(NORTHERN_NENGOS);
        } else {
            int lowerBound = getLowerBound(selector);
            int upperBound = getUpperBound(selector);
            listAsList = new ArrayList((upperBound - lowerBound) + 1);
            while (lowerBound <= upperBound) {
                listAsList.add(OFFICIAL_NENGOS[lowerBound]);
                lowerBound++;
            }
        }
        return Collections.unmodifiableList(listAsList);
    }

    public boolean matches(Selector selector) {
        return selector.test(this);
    }

    public int getFirstRelatedGregorianYear() {
        return this.relgregyear;
    }

    public PlainDate getStart() {
        return PlainDate.of(this.start, EpochDays.UTC);
    }

    public boolean isModern() {
        return this.index >= MEIJI.index;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        String str;
        if (locale.getLanguage().isEmpty()) {
            return this.romaji;
        }
        int i = this.index;
        if (i < MEIJI.index || i > NEWEST.index || locale.getLanguage().equals("ru")) {
            if (locale.getLanguage().equals("ja")) {
                return this.kanji;
            }
            if (locale.getLanguage().equals("zh")) {
                return this.chinese;
            }
            if (locale.getLanguage().equals("ko")) {
                return this.korean;
            }
            if (locale.getLanguage().equals("ru")) {
                return "Период " + this.russian;
            }
            return this.romaji;
        }
        int i2 = 0;
        while (true) {
            Nengo[] nengoArr = MODERN_NENGOS;
            if (i2 >= nengoArr.length) {
                str = null;
                break;
            }
            if (equals(nengoArr[i2])) {
                str = MODERN_KEYS[i2];
                break;
            }
            i2++;
        }
        if (str == null) {
            throw new IllegalStateException("Modern nengos need an update.");
        }
        if (textWidth == TextWidth.NARROW) {
            str = str + "_n";
        }
        return CalendarText.getInstance("japanese", locale).getTextForms().get(str);
    }

    public Nengo findNext() {
        if (this.court == 1) {
            int i = this.index;
            Nengo[] nengoArr = NORTHERN_NENGOS;
            if (i == nengoArr.length - 1) {
                return NENGO_OEI;
            }
            return nengoArr[i + 1];
        }
        int i2 = this.index;
        Nengo[] nengoArr2 = OFFICIAL_NENGOS;
        if (i2 == nengoArr2.length - 1) {
            return null;
        }
        return nengoArr2[i2 + 1];
    }

    public Nengo findPrevious() {
        if (this.court == 1) {
            int i = this.index;
            if (i == 0) {
                return OFFICIAL_NENGOS[NENGO_KENMU.index - 1];
            }
            return NORTHERN_NENGOS[i - 1];
        }
        int i2 = this.index;
        if (i2 == 0) {
            return null;
        }
        return OFFICIAL_NENGOS[i2 - 1];
    }

    @Override // net.time4j.engine.CalendarEra
    public String name() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.romaji);
        sb.append(" (");
        Nengo nengoFindNext = findNext();
        if (nengoFindNext != null) {
            sb.append(this.relgregyear);
            sb.append('-');
            sb.append(nengoFindNext.relgregyear);
        } else {
            sb.append("since ");
            sb.append(this.relgregyear);
        }
        sb.append(')');
        return sb.toString();
    }

    int getValue() {
        int length;
        int i;
        if (matches(Selector.NORTHERN_COURT)) {
            length = (this.index - NORTHERN_NENGOS.length) + NENGO_OEI.index;
            i = SHOWA.index;
        } else {
            length = this.index;
            i = SHOWA.index;
        }
        return (length - i) + 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Nengo)) {
            return false;
        }
        Nengo nengo = (Nengo) obj;
        return this.relgregyear == nengo.relgregyear && this.start == nengo.start && this.kanji.equals(nengo.kanji) && this.romaji.equals(nengo.romaji) && this.court == nengo.court;
    }

    public int hashCode() {
        long j = this.start;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.romaji);
        sb.append(' ');
        sb.append(this.kanji);
        sb.append(' ');
        Nengo nengoFindNext = findNext();
        if (nengoFindNext != null) {
            sb.append(this.relgregyear);
            sb.append('-');
            sb.append(nengoFindNext.relgregyear);
        } else {
            sb.append("since ");
            sb.append(this.relgregyear);
        }
        if (this.court != 0) {
            sb.append(" (");
            sb.append(this.court == 1 ? 'N' : 'S');
            sb.append(')');
        }
        return sb.toString();
    }

    long getStartAsDaysSinceEpochUTC() {
        return this.start;
    }

    int getIndexOfficial() {
        return this.index;
    }

    static Nengo ofIndexOfficial(int i) {
        return OFFICIAL_NENGOS[i];
    }

    static String hepburn(CharSequence charSequence, int i) {
        int iMin = Math.min(charSequence.length(), i + 32);
        StringBuilder sb = null;
        for (int i2 = i; i2 < iMin; i2++) {
            char cCharAt = charSequence.charAt(i2);
            char c = 362;
            char c2 = 363;
            char upperCase = 332;
            char lowerCase = 333;
            if (i2 == i) {
                if (cCharAt != 212 && cCharAt != 244 && cCharAt != 333) {
                    upperCase = Character.toUpperCase(cCharAt);
                }
                if (cCharAt != 219 && cCharAt != 251 && cCharAt != 363) {
                    c = upperCase;
                }
            } else {
                if (cCharAt != 212 && cCharAt != 244 && cCharAt != 332) {
                    lowerCase = Character.toLowerCase(cCharAt);
                }
                if (cCharAt != 219 && cCharAt != 251 && cCharAt != 362) {
                    c2 = lowerCase;
                }
                c = c2;
            }
            if (cCharAt == '\'') {
                c = Typography.rightSingleQuote;
            }
            if (cCharAt == ' ') {
                c = '-';
            }
            if (sb != null || c != cCharAt) {
                if (sb == null) {
                    sb = new StringBuilder(32);
                    sb.append(charSequence.subSequence(i, i2));
                }
                sb.append(c);
            }
        }
        return sb == null ? charSequence.subSequence(i, iMin).toString() : sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String capitalize(CharSequence charSequence, int i) {
        int iMin = Math.min(charSequence.length(), i + 32);
        StringBuilder sb = null;
        int i2 = i;
        boolean z = true;
        while (i2 < iMin) {
            char cCharAt = charSequence.charAt(i2);
            char upperCase = z ? Character.toUpperCase(cCharAt) : Character.toLowerCase(cCharAt);
            boolean z2 = cCharAt == ' ';
            if (sb != null || upperCase != cCharAt) {
                if (sb == null) {
                    sb = new StringBuilder(32);
                    sb.append(charSequence.subSequence(i, i2));
                }
                sb.append(upperCase);
            }
            i2++;
            z = z2;
        }
        return sb == null ? charSequence.subSequence(i, iMin).toString() : sb.toString();
    }

    private static int getUpperBound(Selector selector) {
        switch (selector) {
            case NORTHERN_COURT:
                return NORTHERN_NENGOS.length - 1;
            case SOUTHERN_COURT:
                return NENGO_KENMU.index + 8;
            case EDO_PERIOD:
                return MEIJI.index - 1;
            case AZUCHI_MOMOYAMA_PERIOD:
                return NikonType2MakernoteDirectory.TAG_UNKNOWN_49;
            case MUROMACHI_PERIOD:
                return NikonType2MakernoteDirectory.TAG_FILE_INFO;
            case KAMAKURA_PERIOD:
                return NENGO_KENMU.index - 1;
            case HEIAN_PERIOD:
                return 102;
            case NARA_PERIOD:
                return 14;
            case ASUKA_PERIOD:
                return 2;
            default:
                return OFFICIAL_NENGOS.length - 1;
        }
    }

    private static int getLowerBound(Selector selector) {
        switch (selector) {
            case MODERN:
                return MEIJI.index;
            case NORTHERN_COURT:
            default:
                return 0;
            case SOUTHERN_COURT:
                return NENGO_KENMU.index;
            case EDO_PERIOD:
                return 188;
            case AZUCHI_MOMOYAMA_PERIOD:
                return NikonType2MakernoteDirectory.TAG_AF_TUNE;
            case MUROMACHI_PERIOD:
                return NENGO_KENMU.index + 1;
            case KAMAKURA_PERIOD:
                return 103;
            case HEIAN_PERIOD:
                return 15;
            case NARA_PERIOD:
                return 3;
        }
    }

    private static Nengo of(int i, boolean z) {
        return z ? NORTHERN_NENGOS[i] : OFFICIAL_NENGOS[i];
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            int i = this.index;
            boolean z = true;
            if (this.court != 1) {
                z = false;
            }
            return of(i, z);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new StreamCorruptedException();
        }
    }

    static class Element implements TextElement<Nengo>, Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Element SINGLETON = new Element();
        private static final long serialVersionUID = -1099321098836107792L;

        @Override // net.time4j.engine.ChronoElement
        public char getSymbol() {
            return 'G';
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        private Element() {
        }

        @Override // net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(((Nengo) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE)));
        }

        /* JADX WARN: Code duplicated, block: B:45:0x00e8  */
        @Override // net.time4j.format.TextElement
        public Nengo parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            int length;
            Nengo nengo;
            String strLongestPrefixOf;
            int i;
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            Map<String, String> textForms = CalendarText.getInstance("japanese", locale).getTextForms();
            int index = parsePosition.getIndex();
            if (index >= charSequence.length()) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            String strCapitalize = locale.getLanguage().equals("ru") ? Nengo.capitalize(charSequence, index) : Nengo.hepburn(charSequence, index);
            int i2 = 0;
            while (true) {
                if (i2 >= Nengo.MODERN_KEYS.length) {
                    length = 0;
                    nengo = null;
                    break;
                }
                String str = Nengo.MODERN_KEYS[i2];
                if (textWidth == TextWidth.NARROW) {
                    str = str + "_n";
                }
                String str2 = textForms.get(str);
                if (strCapitalize.startsWith(str2)) {
                    nengo = Nengo.MODERN_NENGOS[i2];
                    length = str2.length();
                    if (textWidth == TextWidth.NARROW || nengo == Nengo.SHOWA) {
                        break;
                        break;
                    }
                    parsePosition.setIndex(index + length);
                    return nengo;
                }
                i2++;
            }
            if (strCapitalize.length() < 2) {
                if (nengo != null) {
                    parsePosition.setIndex(index + 1);
                }
                return nengo;
            }
            List<Nengo> listEmptyList = Collections.emptyList();
            if (locale.getLanguage().equals("ja")) {
                int i3 = strCapitalize.length() >= 4 ? 4 : 2;
                strLongestPrefixOf = strCapitalize.substring(0, i3);
                Nengo nengo2 = (Nengo) Nengo.KANJI_TO_NENGO.get(strLongestPrefixOf);
                if (nengo2 == null && i3 == 4) {
                    strLongestPrefixOf = strCapitalize.substring(0, 2);
                    nengo2 = (Nengo) Nengo.KANJI_TO_NENGO.get(strLongestPrefixOf);
                }
                if (nengo2 != null) {
                    if (nengo2 == nengo) {
                        nengo = null;
                    }
                    listEmptyList = Collections.singletonList(nengo2);
                } else {
                    strLongestPrefixOf = null;
                }
                i = 0;
            } else {
                if (locale.getLanguage().equals("zh")) {
                    int i4 = strCapitalize.length() >= 4 ? 4 : 2;
                    strLongestPrefixOf = strCapitalize.substring(0, i4);
                    Nengo nengo3 = (Nengo) Nengo.CHINESE_TO_NENGO.get(strLongestPrefixOf);
                    if (nengo3 == null && i4 == 4) {
                        strLongestPrefixOf = strCapitalize.substring(0, 2);
                        nengo3 = (Nengo) Nengo.CHINESE_TO_NENGO.get(strLongestPrefixOf);
                    }
                    if (nengo3 != null) {
                        if (nengo3 == nengo) {
                            nengo = null;
                        }
                        listEmptyList = Collections.singletonList(nengo3);
                    } else {
                        strLongestPrefixOf = null;
                    }
                } else if (locale.getLanguage().equals("ko")) {
                    strLongestPrefixOf = Nengo.KOREAN_TO_NENGO.longestPrefixOf(strCapitalize, index);
                    listEmptyList = Nengo.KOREAN_TO_NENGO.find(strLongestPrefixOf);
                } else if (!locale.getLanguage().equals("ru")) {
                    strLongestPrefixOf = Nengo.ROMAJI_TO_NENGO.longestPrefixOf(strCapitalize, index);
                    listEmptyList = Nengo.ROMAJI_TO_NENGO.find(strLongestPrefixOf);
                } else {
                    if (strCapitalize.startsWith("Период ")) {
                        i = 7;
                        strCapitalize = strCapitalize.substring(7);
                    } else {
                        i = 0;
                    }
                    strLongestPrefixOf = Nengo.RUSSIAN_TO_NENGO.longestPrefixOf(strCapitalize, index);
                    listEmptyList = Nengo.RUSSIAN_TO_NENGO.find(strLongestPrefixOf);
                }
                i = 0;
            }
            int size = listEmptyList.size();
            if (size == 0 || strLongestPrefixOf == null) {
                if (nengo == null) {
                    return null;
                }
                parsePosition.setIndex(index + length);
                return nengo;
            }
            int length2 = strLongestPrefixOf.length() + i;
            if (length < length2) {
                nengo = null;
            } else if (length > length2) {
                parsePosition.setIndex(index + length);
                return nengo;
            }
            if (size == 1) {
                Nengo nengo4 = listEmptyList.get(0);
                if (nengo == null || nengo4 == nengo) {
                    parsePosition.setIndex(index + length2);
                    return nengo4;
                }
            }
            Selector selector = (Selector) attributeQuery.get(Nengo.SELECTOR, Selector.OFFICIAL);
            ArrayList arrayList = new ArrayList(listEmptyList);
            if (nengo != null && !arrayList.contains(nengo)) {
                arrayList.add(nengo);
            }
            Collections.sort(arrayList, new Comparator<Nengo>() { // from class: net.time4j.calendar.Nengo.Element.1
                @Override // java.util.Comparator
                public int compare(Nengo nengo5, Nengo nengo6) {
                    if (nengo5.start < nengo6.start) {
                        return 1;
                    }
                    return nengo5.start == nengo6.start ? 0 : -1;
                }
            });
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!((Nengo) it2.next()).matches(selector)) {
                    it2.remove();
                }
            }
            if (arrayList.size() == 1) {
                parsePosition.setIndex(index + length2);
                return (Nengo) arrayList.get(0);
            }
            if (arrayList.size() <= 1 || ((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict()) {
                return null;
            }
            parsePosition.setIndex(index + length2);
            return (Nengo) arrayList.get(0);
        }

        @Override // net.time4j.engine.ChronoElement
        public String name() {
            return "ERA";
        }

        @Override // net.time4j.engine.ChronoElement
        public Class<Nengo> getType() {
            return Nengo.class;
        }

        @Override // java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            Nengo nengo = (Nengo) chronoDisplay.get(this);
            Nengo nengo2 = (Nengo) chronoDisplay2.get(this);
            if (nengo.start < nengo2.start) {
                return -1;
            }
            if (nengo.start > nengo2.start) {
                return 1;
            }
            if (nengo.court == 1) {
                return nengo2.court == 1 ? 0 : 1;
            }
            return nengo2.court == 1 ? -1 : 0;
        }

        @Override // net.time4j.engine.ChronoElement
        public Nengo getDefaultMinimum() {
            return Nengo.OFFICIAL_NENGOS[0];
        }

        @Override // net.time4j.engine.ChronoElement
        public Nengo getDefaultMaximum() {
            return Nengo.OFFICIAL_NENGOS[Nengo.OFFICIAL_NENGOS.length - 1];
        }

        @Override // net.time4j.engine.ChronoElement
        public String getDisplayName(Locale locale) {
            String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_era");
            return str == null ? name() : str;
        }

        private Object readResolve() throws ObjectStreamException {
            return SINGLETON;
        }
    }

    private static class TST {
        private Node root;

        private TST() {
            this.root = null;
        }

        List<Nengo> find(String str) {
            if (str == null || str.length() == 0) {
                return Collections.emptyList();
            }
            Node nodeFind = find(this.root, str, 0);
            if (nodeFind == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(nodeFind.nengos);
        }

        private static Node find(Node node, String str, int i) {
            if (node == null) {
                return null;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt < node.c) {
                return find(node.left, str, i);
            }
            if (cCharAt > node.c) {
                return find(node.right, str, i);
            }
            return i < str.length() + (-1) ? find(node.mid, str, i + 1) : node;
        }

        void insert(String str, Nengo nengo) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Empty key cannot be inserted.");
            }
            this.root = insert(this.root, str, nengo, 0);
        }

        private static Node insert(Node node, String str, Nengo nengo, int i) {
            char cCharAt = str.charAt(i);
            if (node == null) {
                node = new Node();
                node.c = cCharAt;
            }
            if (cCharAt < node.c) {
                node.left = insert(node.left, str, nengo, i);
            } else if (cCharAt <= node.c) {
                if (i < str.length() - 1) {
                    node.mid = insert(node.mid, str, nengo, i + 1);
                } else {
                    if (node.nengos == null) {
                        node.nengos = new ArrayList();
                    }
                    node.nengos.add(nengo);
                }
            } else {
                node.right = insert(node.right, str, nengo, i);
            }
            return node;
        }

        String longestPrefixOf(CharSequence charSequence, int i) {
            Node node = this.root;
            int length = charSequence.length();
            int i2 = i;
            int i3 = i2;
            while (node != null && i2 < length) {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt < node.c) {
                    node = node.left;
                } else if (cCharAt > node.c) {
                    node = node.right;
                } else {
                    i2++;
                    if (node.nengos != null) {
                        i3 = i2;
                    }
                    node = node.mid;
                }
            }
            if (i >= i3) {
                return null;
            }
            return charSequence.subSequence(i, i3).toString();
        }
    }

    private static class Node {
        private char c;
        private Node left;
        private Node mid;
        private List<Nengo> nengos;
        private Node right;

        private Node() {
            this.c = (char) 0;
            this.left = null;
            this.mid = null;
            this.right = null;
            this.nengos = null;
        }
    }
}
