package com.henninghall.date_picker;

import android.util.Log;
import com.henninghall.date_picker.models.Is24HourSource;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.models.Variant;
import com.henninghall.date_picker.models.WheelType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class DerivedData {
    private final State state;

    DerivedData(State state) {
        this.state = state;
    }

    public ArrayList<WheelType> getVisibleWheels() {
        ArrayList<WheelType> arrayList = new ArrayList<>();
        Mode mode = this.state.getMode();
        int i = AnonymousClass1.$SwitchMap$com$henninghall$date_picker$models$Mode[mode.ordinal()];
        if (i == 1) {
            arrayList.add(WheelType.DAY);
            arrayList.add(WheelType.HOUR);
            arrayList.add(WheelType.MINUTE);
        } else if (i == 2) {
            arrayList.add(WheelType.HOUR);
            arrayList.add(WheelType.MINUTE);
        } else if (i == 3) {
            arrayList.add(WheelType.YEAR);
            arrayList.add(WheelType.MONTH);
            arrayList.add(WheelType.DATE);
        }
        if ((mode == Mode.time || mode == Mode.datetime) && this.state.derived.usesAmPm()) {
            arrayList.add(WheelType.AM_PM);
        }
        return arrayList;
    }

    public ArrayList<WheelType> getOrderedVisibleWheels() {
        ArrayList<WheelType> orderedWheels = getOrderedWheels();
        ArrayList<WheelType> visibleWheels = getVisibleWheels();
        ArrayList<WheelType> arrayList = new ArrayList<>();
        for (WheelType wheelType : orderedWheels) {
            if (visibleWheels.contains(wheelType)) {
                arrayList.add(wheelType);
            }
        }
        return arrayList;
    }

    private ArrayList<WheelType> getOrderedWheels() {
        String strReplaceAll = LocaleUtils.getDateTimePattern(this.state.getLocale()).replaceAll("\\('(.+?)'\\)", "\\${$1}").replaceAll("'.+?'", "").replaceAll("\\$\\{(.+?)\\}", "('$1')");
        ArrayList arrayList = new ArrayList(Arrays.asList(WheelType.values()));
        ArrayList<WheelType> arrayList2 = new ArrayList<>();
        arrayList.remove(WheelType.DAY);
        arrayList2.add(WheelType.DAY);
        for (char c : strReplaceAll.toCharArray()) {
            try {
                WheelType wheelTypePatternCharToWheelType = Utils.patternCharToWheelType(c);
                if (arrayList.contains(wheelTypePatternCharToWheelType)) {
                    arrayList.remove(wheelTypePatternCharToWheelType);
                    arrayList2.add(wheelTypePatternCharToWheelType);
                }
            } catch (Exception unused) {
            }
        }
        if (arrayList.contains(WheelType.AM_PM)) {
            arrayList.remove(WheelType.AM_PM);
            arrayList2.add(WheelType.AM_PM);
        }
        if (!arrayList.isEmpty()) {
            Log.e(DatePickerModuleImpl.NAME, arrayList.size() + " wheel types cannot be ordered. Wheel type 0: " + arrayList.get(0));
        }
        return arrayList2;
    }

    public int getShownCount() {
        int iIntValue = this.state.getHeight().intValue() / 35;
        return iIntValue % 2 == 0 ? iIntValue + 1 : iIntValue;
    }

    public boolean hasNativeStyle() {
        return this.state.getVariant() == Variant.nativeAndroid;
    }

    /* JADX INFO: renamed from: com.henninghall.date_picker.DerivedData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$henninghall$date_picker$models$Mode;
        static final /* synthetic */ int[] $SwitchMap$com$henninghall$date_picker$models$Variant;

        static {
            int[] iArr = new int[Variant.values().length];
            $SwitchMap$com$henninghall$date_picker$models$Variant = iArr;
            try {
                iArr[Variant.nativeAndroid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$henninghall$date_picker$models$Variant[Variant.iosClone.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            $SwitchMap$com$henninghall$date_picker$models$Mode = iArr2;
            try {
                iArr2[Mode.datetime.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$henninghall$date_picker$models$Mode[Mode.time.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$henninghall$date_picker$models$Mode[Mode.date.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public int getRootLayout() {
        int i = AnonymousClass1.$SwitchMap$com$henninghall$date_picker$models$Variant[this.state.getVariant().ordinal()];
        if (i == 1) {
            return R.layout.native_picker;
        }
        if (i == 2) {
            return R.layout.ios_clone;
        }
        return R.layout.ios_clone;
    }

    public boolean usesAmPm() {
        return this.state.getIs24HourSource() == Is24HourSource.locale ? LocaleUtils.localeUsesAmPm(this.state.getLocale()) : Utils.deviceUsesAmPm();
    }

    public boolean hasOnly2Wheels() {
        return this.state.getMode() == Mode.time && !usesAmPm();
    }

    public String getLastDate() {
        Calendar lastSelectedDate = this.state.getLastSelectedDate();
        return lastSelectedDate != null ? Utils.dateToIso(lastSelectedDate) : this.state.getIsoDate();
    }
}
