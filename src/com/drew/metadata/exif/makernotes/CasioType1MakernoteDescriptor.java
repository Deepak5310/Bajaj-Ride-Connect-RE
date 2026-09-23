package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class CasioType1MakernoteDescriptor extends TagDescriptor<CasioType1MakernoteDirectory> {
    public CasioType1MakernoteDescriptor(CasioType1MakernoteDirectory casioType1MakernoteDirectory) {
        super(casioType1MakernoteDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i != 20) {
            switch (i) {
                case 1:
                    return getRecordingModeDescription();
                case 2:
                    return getQualityDescription();
                case 3:
                    return getFocusingModeDescription();
                case 4:
                    return getFlashModeDescription();
                case 5:
                    return getFlashIntensityDescription();
                case 6:
                    return getObjectDistanceDescription();
                case 7:
                    return getWhiteBalanceDescription();
                default:
                    switch (i) {
                        case 10:
                            return getDigitalZoomDescription();
                        case 11:
                            return getSharpnessDescription();
                        case 12:
                            return getContrastDescription();
                        case 13:
                            return getSaturationDescription();
                        default:
                            return super.getDescription(i);
                    }
            }
        }
        return getCcdSensitivityDescription();
    }

    public String getCcdSensitivityDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(20);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 64) {
            return "Normal";
        }
        if (iIntValue == 80) {
            return "Normal (ISO 80 equivalent)";
        }
        if (iIntValue == 100) {
            return "High";
        }
        if (iIntValue == 125) {
            return "+1.0";
        }
        if (iIntValue == 244) {
            return "+3.0";
        }
        if (iIntValue == 250) {
            return "+2.0";
        }
        return "Unknown (" + integer + ")";
    }

    public String getSaturationDescription() {
        return getIndexedDescription(13, "Normal", "Low", "High");
    }

    public String getContrastDescription() {
        return getIndexedDescription(12, "Normal", "Low", "High");
    }

    public String getSharpnessDescription() {
        return getIndexedDescription(11, "Normal", "Soft", "Hard");
    }

    public String getDigitalZoomDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(10);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 65536) {
            return "No digital zoom";
        }
        if (iIntValue == 65537 || iIntValue == 131072) {
            return "2x digital zoom";
        }
        if (iIntValue == 262144) {
            return "4x digital zoom";
        }
        return "Unknown (" + integer + ")";
    }

    public String getWhiteBalanceDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(7);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 1) {
            return "Auto";
        }
        if (iIntValue == 2) {
            return "Tungsten";
        }
        if (iIntValue == 3) {
            return "Daylight";
        }
        if (iIntValue == 4) {
            return "Florescent";
        }
        if (iIntValue == 5) {
            return "Shade";
        }
        if (iIntValue == 129) {
            return "Manual";
        }
        return "Unknown (" + integer + ")";
    }

    public String getObjectDistanceDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(6);
        if (integer == null) {
            return null;
        }
        return getFocalLengthDescription(integer.intValue());
    }

    public String getFlashIntensityDescription() {
        Integer integer = ((CasioType1MakernoteDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 11) {
            return "Weak";
        }
        if (iIntValue == 13) {
            return "Normal";
        }
        if (iIntValue == 15) {
            return "Strong";
        }
        return "Unknown (" + integer + ")";
    }

    public String getFlashModeDescription() {
        return getIndexedDescription(4, 1, "Auto", "On", "Off", "Red eye reduction");
    }

    public String getFocusingModeDescription() {
        return getIndexedDescription(3, 2, "Macro", "Auto focus", "Manual focus", "Infinity");
    }

    public String getQualityDescription() {
        return getIndexedDescription(2, 1, "Economy", "Normal", "Fine");
    }

    public String getRecordingModeDescription() {
        return getIndexedDescription(1, 1, "Single shutter", "Panorama", "Night scene", "Portrait", "Landscape");
    }
}
