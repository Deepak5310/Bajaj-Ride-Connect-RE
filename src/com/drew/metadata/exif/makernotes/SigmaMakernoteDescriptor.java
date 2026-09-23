package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class SigmaMakernoteDescriptor extends TagDescriptor<SigmaMakernoteDirectory> {
    public SigmaMakernoteDescriptor(SigmaMakernoteDirectory sigmaMakernoteDirectory) {
        super(sigmaMakernoteDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 8) {
            return getExposureModeDescription();
        }
        if (i == 9) {
            return getMeteringModeDescription();
        }
        return super.getDescription(i);
    }

    private String getMeteringModeDescription() {
        String string = ((SigmaMakernoteDirectory) this._directory).getString(9);
        if (string == null || string.length() == 0) {
            return null;
        }
        char cCharAt = string.charAt(0);
        if (cCharAt == '8') {
            return "Multi Segment";
        }
        if (cCharAt != 'A') {
            return cCharAt != 'C' ? string : "Center Weighted Average";
        }
        return "Average";
    }

    private String getExposureModeDescription() {
        String string = ((SigmaMakernoteDirectory) this._directory).getString(8);
        if (string == null || string.length() == 0) {
            return null;
        }
        char cCharAt = string.charAt(0);
        if (cCharAt == 'A') {
            return "Aperture Priority AE";
        }
        if (cCharAt == 'M') {
            return "Manual";
        }
        if (cCharAt != 'P') {
            return cCharAt != 'S' ? string : "Shutter Speed Priority AE";
        }
        return "Program AE";
    }
}
