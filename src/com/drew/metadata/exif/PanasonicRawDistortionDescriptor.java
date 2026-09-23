package com.drew.metadata.exif;

import com.drew.lang.Rational;
import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class PanasonicRawDistortionDescriptor extends TagDescriptor<PanasonicRawDistortionDirectory> {
    public PanasonicRawDistortionDescriptor(PanasonicRawDistortionDirectory panasonicRawDistortionDirectory) {
        super(panasonicRawDistortionDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 2) {
            return getDistortionParam02Description();
        }
        if (i == 11) {
            return getDistortionParam11Description();
        }
        if (i == 4) {
            return getDistortionParam04Description();
        }
        if (i == 5) {
            return getDistortionScaleDescription();
        }
        if (i == 7) {
            return getDistortionCorrectionDescription();
        }
        if (i == 8) {
            return getDistortionParam08Description();
        }
        if (i == 9) {
            return getDistortionParam09Description();
        }
        return super.getDescription(i);
    }

    public String getWbTypeDescription(int i) {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(i);
        if (integer == null) {
            return null;
        }
        return super.getLightSourceDescription(integer.shortValue());
    }

    public String getDistortionParam02Description() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(2);
        if (integer == null) {
            return null;
        }
        return new Rational(integer.intValue(), 32678L).toString();
    }

    public String getDistortionParam04Description() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(4);
        if (integer == null) {
            return null;
        }
        return new Rational(integer.intValue(), 32678L).toString();
    }

    public String getDistortionScaleDescription() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        return Integer.toString(1 / ((integer.intValue() / 32768) + 1));
    }

    public String getDistortionCorrectionDescription() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(7);
        if (integer == null) {
            return null;
        }
        int iIntValue = integer.intValue() & 15;
        if (iIntValue == 0) {
            return "Off";
        }
        if (iIntValue == 1) {
            return "On";
        }
        return "Unknown (" + integer + ")";
    }

    public String getDistortionParam08Description() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(8);
        if (integer == null) {
            return null;
        }
        return new Rational(integer.intValue(), 32678L).toString();
    }

    public String getDistortionParam09Description() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(9);
        if (integer == null) {
            return null;
        }
        return new Rational(integer.intValue(), 32678L).toString();
    }

    public String getDistortionParam11Description() {
        Integer integer = ((PanasonicRawDistortionDirectory) this._directory).getInteger(11);
        if (integer == null) {
            return null;
        }
        return new Rational(integer.intValue(), 32678L).toString();
    }
}
