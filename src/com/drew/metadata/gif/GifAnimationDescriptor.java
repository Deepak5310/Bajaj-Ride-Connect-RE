package com.drew.metadata.gif;

import com.drew.metadata.TagDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class GifAnimationDescriptor extends TagDescriptor<GifAnimationDirectory> {
    public GifAnimationDescriptor(GifAnimationDirectory gifAnimationDirectory) {
        super(gifAnimationDirectory);
    }

    @Override // com.drew.metadata.TagDescriptor
    public String getDescription(int i) {
        if (i == 1) {
            return getIterationCountDescription();
        }
        return super.getDescription(i);
    }

    public String getIterationCountDescription() {
        Integer integer = ((GifAnimationDirectory) this._directory).getInteger(1);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "Infinite";
        }
        if (integer.intValue() == 1) {
            return "Once";
        }
        if (integer.intValue() == 2) {
            return "Twice";
        }
        return integer.toString() + " times";
    }
}
