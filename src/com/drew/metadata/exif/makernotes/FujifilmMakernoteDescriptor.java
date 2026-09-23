package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.Rational;
import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class FujifilmMakernoteDescriptor extends TagDescriptor<FujifilmMakernoteDirectory> {
    public FujifilmMakernoteDescriptor(FujifilmMakernoteDirectory fujifilmMakernoteDirectory) {
        super(fujifilmMakernoteDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 0) {
            return getMakernoteVersionDescription();
        }
        if (i == 4102) {
            return getContrastDescription();
        }
        if (i == 4107) {
            return getNoiseReductionDescription();
        }
        if (i == 4110) {
            return getHighIsoNoiseReductionDescription();
        }
        if (i == 4352) {
            return getAutoBracketingDescription();
        }
        if (i == 4624) {
            return getFinePixColorDescription();
        }
        if (i == 4112) {
            return getFlashModeDescription();
        }
        if (i == 4113) {
            return getFlashExposureValueDescription();
        }
        if (i == 4128) {
            return getMacroDescription();
        }
        if (i == 4129) {
            return getFocusModeDescription();
        }
        if (i == 4144) {
            return getSlowSyncDescription();
        }
        if (i == 4145) {
            return getPictureModeDescription();
        }
        if (i == 4147) {
            return getExrAutoDescription();
        }
        if (i != 4148) {
            switch (i) {
                case 4097:
                    return getSharpnessDescription();
                case 4098:
                    return getWhiteBalanceDescription();
                case 4099:
                    return getColorSaturationDescription();
                case 4100:
                    return getToneDescription();
                default:
                    switch (i) {
                        case FujifilmMakernoteDirectory.TAG_BLUR_WARNING /* 4864 */:
                            return getBlurWarningDescription();
                        case FujifilmMakernoteDirectory.TAG_FOCUS_WARNING /* 4865 */:
                            return getFocusWarningDescription();
                        case FujifilmMakernoteDirectory.TAG_AUTO_EXPOSURE_WARNING /* 4866 */:
                            return getAutoExposureWarningDescription();
                        default:
                            switch (i) {
                                case FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE /* 5120 */:
                                    return getDynamicRangeDescription();
                                case FujifilmMakernoteDirectory.TAG_FILM_MODE /* 5121 */:
                                    return getFilmModeDescription();
                                case FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE_SETTING /* 5122 */:
                                    return getDynamicRangeSettingDescription();
                                default:
                                    return super.getDescription(i);
                            }
                    }
            }
        }
        return getExrModeDescription();
    }

    private String getMakernoteVersionDescription() {
        return getVersionBytesDescription(0, 2);
    }

    public String getSharpnessDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4097);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 1) {
            return "Softest";
        }
        if (iIntValue == 2) {
            return "Soft";
        }
        if (iIntValue == 3) {
            return "Normal";
        }
        if (iIntValue == 4) {
            return "Hard";
        }
        if (iIntValue == 5) {
            return "Hardest";
        }
        if (iIntValue == 130) {
            return "Medium Soft";
        }
        if (iIntValue == 132) {
            return "Medium Hard";
        }
        if (iIntValue == 32768) {
            return "Film Simulation";
        }
        if (iIntValue == 65535) {
            return "N/A";
        }
        return "Unknown (" + integer + ")";
    }

    public String getWhiteBalanceDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4098);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Auto";
        }
        if (iIntValue == 256) {
            return "Daylight";
        }
        if (iIntValue == 512) {
            return "Cloudy";
        }
        if (iIntValue == 1024) {
            return "Incandescence";
        }
        if (iIntValue == 1280) {
            return ExifInterface.TAG_FLASH;
        }
        if (iIntValue != 4080) {
            switch (iIntValue) {
                case 768:
                    return "Daylight Fluorescent";
                case 769:
                    return "Day White Fluorescent";
                case 770:
                    return "White Fluorescent";
                case 771:
                    return "Warm White Fluorescent";
                case 772:
                    return "Living Room Warm White Fluorescent";
                default:
                    switch (iIntValue) {
                        case 3840:
                            return "Custom White Balance";
                        case OlympusMakernoteDirectory.TAG_DATA_DUMP_2 /* 3841 */:
                            return "Custom White Balance 2";
                        case 3842:
                            return "Custom White Balance 3";
                        case 3843:
                            return "Custom White Balance 4";
                        case 3844:
                            return "Custom White Balance 5";
                        default:
                            return "Unknown (" + integer + ")";
                    }
            }
        }
        return "Kelvin";
    }

    public String getColorSaturationDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4099);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Normal";
        }
        if (iIntValue == 128) {
            return "Medium High";
        }
        if (iIntValue == 256) {
            return "High";
        }
        if (iIntValue == 384) {
            return "Medium Low";
        }
        if (iIntValue == 512) {
            return "Low";
        }
        if (iIntValue != 32768) {
            switch (iIntValue) {
                case 768:
                    return "None (B&W)";
                case 769:
                    return "B&W Green Filter";
                case 770:
                    return "B&W Yellow Filter";
                case 771:
                    return "B&W Blue Filter";
                case 772:
                    return "B&W Sepia";
                default:
                    return "Unknown (" + integer + ")";
            }
        }
        return "Film Simulation";
    }

    public String getToneDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4100);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Normal";
        }
        if (iIntValue == 128) {
            return "Medium High";
        }
        if (iIntValue == 256) {
            return "High";
        }
        if (iIntValue == 384) {
            return "Medium Low";
        }
        if (iIntValue == 512) {
            return "Low";
        }
        if (iIntValue == 768) {
            return "None (B&W)";
        }
        if (iIntValue == 32768) {
            return "Film Simulation";
        }
        return "Unknown (" + integer + ")";
    }

    public String getContrastDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4102);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Normal";
        }
        if (iIntValue == 256) {
            return "High";
        }
        if (iIntValue == 768) {
            return "Low";
        }
        return "Unknown (" + integer + ")";
    }

    public String getNoiseReductionDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4107);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 64) {
            return "Low";
        }
        if (iIntValue == 128) {
            return "Normal";
        }
        if (iIntValue == 256) {
            return "N/A";
        }
        return "Unknown (" + integer + ")";
    }

    public String getHighIsoNoiseReductionDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4110);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Normal";
        }
        if (iIntValue == 256) {
            return "Strong";
        }
        if (iIntValue == 512) {
            return "Weak";
        }
        return "Unknown (" + integer + ")";
    }

    public String getFlashModeDescription() {
        return getIndexedDescription(4112, "Auto", "On", "Off", "Red-eye Reduction", "External");
    }

    public String getFlashExposureValueDescription() {
        Rational rational = ((FujifilmMakernoteDirectory) this._directory).getRational(4113);
        if (rational == null) {
            return null;
        }
        return rational.toSimpleString(false) + " EV (Apex)";
    }

    public String getMacroDescription() {
        return getIndexedDescription(4128, "Off", "On");
    }

    public String getFocusModeDescription() {
        return getIndexedDescription(4129, "Auto Focus", "Manual Focus");
    }

    public String getSlowSyncDescription() {
        return getIndexedDescription(4144, "Off", "On");
    }

    public String getPictureModeDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4145);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 27) {
            return "Dog Face Detection";
        }
        if (iIntValue == 28) {
            return "Cat Face Detection";
        }
        if (iIntValue == 256) {
            return "Aperture priority AE";
        }
        if (iIntValue == 512) {
            return "Shutter priority AE";
        }
        if (iIntValue != 768) {
            switch (iIntValue) {
                case 0:
                    return "Auto";
                case 1:
                    return "Portrait scene";
                case 2:
                    return "Landscape scene";
                case 3:
                    return "Macro";
                case 4:
                    return "Sports scene";
                case 5:
                    return "Night scene";
                case 6:
                    return "Program AE";
                case 7:
                    return "Natural Light";
                case 8:
                    return "Anti-blur";
                case 9:
                    return "Beach & Snow";
                case 10:
                    return "Sunset";
                case 11:
                    return "Museum";
                case 12:
                    return "Party";
                case 13:
                    return "Flower";
                case 14:
                    return "Text";
                case 15:
                    return "Natural Light & Flash";
                case 16:
                    return "Beach";
                case 17:
                    return "Snow";
                case 18:
                    return "Fireworks";
                case 19:
                    return "Underwater";
                case 20:
                    return "Portrait with Skin Correction";
                default:
                    switch (iIntValue) {
                        case 22:
                            return "Panorama";
                        case 23:
                            return "Night (Tripod)";
                        case 24:
                            return "Pro Low-light";
                        case 25:
                            return "Pro Focus";
                        default:
                            return "Unknown (" + integer + ")";
                    }
            }
        }
        return "Manual exposure";
    }

    public String getExrAutoDescription() {
        return getIndexedDescription(4147, "Auto", "Manual");
    }

    public String getExrModeDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4148);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 256) {
            return "HR (High Resolution)";
        }
        if (iIntValue == 512) {
            return "SN (Signal to Noise Priority)";
        }
        if (iIntValue == 768) {
            return "DR (Dynamic Range Priority)";
        }
        return "Unknown (" + integer + ")";
    }

    public String getAutoBracketingDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_AUTO_BRACKETING, "Off", "On", "No Flash & Flash");
    }

    public String getFinePixColorDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(FujifilmMakernoteDirectory.TAG_FINE_PIX_COLOR);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Standard";
        }
        if (iIntValue == 16) {
            return "Chrome";
        }
        if (iIntValue == 48) {
            return "B&W";
        }
        return "Unknown (" + integer + ")";
    }

    public String getBlurWarningDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_BLUR_WARNING, "No Blur Warning", "Blur warning");
    }

    public String getFocusWarningDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_FOCUS_WARNING, "Good Focus", "Out Of Focus");
    }

    public String getAutoExposureWarningDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_AUTO_EXPOSURE_WARNING, "AE Good", "Over Exposed");
    }

    public String getDynamicRangeDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE, 1, "Standard", null, "Wide");
    }

    public String getFilmModeDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(FujifilmMakernoteDirectory.TAG_FILM_MODE);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "F0/Standard (Provia) ";
        }
        if (iIntValue == 256) {
            return "F1/Studio Portrait";
        }
        if (iIntValue == 272) {
            return "F1a/Studio Portrait Enhanced Saturation";
        }
        if (iIntValue == 288) {
            return "F1b/Studio Portrait Smooth Skin Tone (Astia)";
        }
        if (iIntValue == 304) {
            return "F1c/Studio Portrait Increased Sharpness";
        }
        if (iIntValue == 512) {
            return "F2/Fujichrome (Velvia)";
        }
        if (iIntValue == 768) {
            return "F3/Studio Portrait Ex";
        }
        if (iIntValue == 1024) {
            return "F4/Velvia";
        }
        if (iIntValue == 1280) {
            return "Pro Neg. Std";
        }
        if (iIntValue == 1281) {
            return "Pro Neg. Hi";
        }
        return "Unknown (" + integer + ")";
    }

    public String getDynamicRangeSettingDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE_SETTING);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue();
        if (iIntValue == 0) {
            return "Auto (100-400%)";
        }
        if (iIntValue == 1) {
            return "Manual";
        }
        if (iIntValue == 256) {
            return "Standard (100%)";
        }
        if (iIntValue == 32768) {
            return "Film Simulation";
        }
        if (iIntValue == 512) {
            return "Wide 1 (230%)";
        }
        if (iIntValue == 513) {
            return "Wide 2 (400%)";
        }
        return "Unknown (" + integer + ")";
    }
}
