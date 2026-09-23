package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class KodakMakernoteDescriptor extends TagDescriptor<KodakMakernoteDirectory> {
    public KodakMakernoteDescriptor(KodakMakernoteDirectory kodakMakernoteDirectory) {
        super(kodakMakernoteDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 9) {
            return getQualityDescription();
        }
        if (i == 10) {
            return getBurstModeDescription();
        }
        if (i == 27) {
            return getShutterModeDescription();
        }
        if (i == 56) {
            return getFocusModeDescription();
        }
        if (i == 64) {
            return getWhiteBalanceDescription();
        }
        if (i == 102) {
            return getColorModeDescription();
        }
        if (i == 107) {
            return getSharpnessDescription();
        }
        if (i == 92) {
            return getFlashModeDescription();
        }
        if (i == 93) {
            return getFlashFiredDescription();
        }
        return super.getDescription(i);
    }

    public String getSharpnessDescription() {
        return getIndexedDescription(107, "Normal");
    }

    public String getColorModeDescription() {
        Integer integer = ((KodakMakernoteDirectory) this._directory).getInteger(102);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 1) {
            return "B&W";
        }
        if (iIntValue == 2) {
            return "Sepia";
        }
        if (iIntValue == 3) {
            return "B&W Yellow Filter";
        }
        if (iIntValue == 4) {
            return "B&W Red Filter";
        }
        if (iIntValue == 32) {
            return "Saturated Color";
        }
        if (iIntValue == 64) {
            return "Neutral Color";
        }
        if (iIntValue == 256) {
            return "Saturated Color";
        }
        if (iIntValue == 512) {
            return "Neutral Color";
        }
        if (iIntValue == 8192) {
            return "B&W";
        }
        if (iIntValue == 16384) {
            return "Sepia";
        }
        return "Unknown (" + integer + ")";
    }

    public String getFlashFiredDescription() {
        return getIndexedDescription(93, "No", "Yes");
    }

    public String getFlashModeDescription() {
        Integer integer = ((KodakMakernoteDirectory) this._directory).getInteger(92);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Auto";
        }
        if (iIntValue == 1) {
            return "Fill Flash";
        }
        if (iIntValue == 2) {
            return "Off";
        }
        if (iIntValue == 3) {
            return "Red Eye";
        }
        if (iIntValue == 16) {
            return "Fill Flash";
        }
        if (iIntValue == 32) {
            return "Off";
        }
        if (iIntValue == 64) {
            return "Red Eye";
        }
        return "Unknown (" + integer + ")";
    }

    public String getWhiteBalanceDescription() {
        return getIndexedDescription(64, "Auto", ExifInterface.TAG_FLASH, "Tungsten", "Daylight");
    }

    public String getFocusModeDescription() {
        return getIndexedDescription(56, "Normal", null, "Macro");
    }

    public String getShutterModeDescription() {
        Integer integer = ((KodakMakernoteDirectory) this._directory).getInteger(27);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Auto";
        }
        if (iIntValue == 8) {
            return "Aperture Priority";
        }
        if (iIntValue == 32) {
            return "Manual";
        }
        return "Unknown (" + integer + ")";
    }

    public String getBurstModeDescription() {
        return getIndexedDescription(10, "Off", "On");
    }

    public String getQualityDescription() {
        return getIndexedDescription(9, 1, "Fine", "Normal");
    }
}
