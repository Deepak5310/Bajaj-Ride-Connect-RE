package j$.time.format;

import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;

/* JADX INFO: loaded from: classes8.dex */
public enum TextStyle {
    FULL(2, 0),
    FULL_STANDALONE(FujifilmMakernoteDirectory.TAG_ORDER_NUMBER, 0),
    SHORT(1, 1),
    SHORT_STANDALONE(PanasonicMakernoteDirectory.TAG_SCENE_MODE, 1),
    NARROW(4, 1),
    NARROW_STANDALONE(PanasonicMakernoteDirectory.TAG_WB_RED_LEVEL, 1);

    private final int calendarStyle;
    private final int zoneNameStyleIndex;

    TextStyle(int i, int i2) {
        this.calendarStyle = i;
        this.zoneNameStyleIndex = i2;
    }

    int zoneNameStyleIndex() {
        return this.zoneNameStyleIndex;
    }
}
