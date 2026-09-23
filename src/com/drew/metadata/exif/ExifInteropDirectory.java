package com.drew.metadata.exif;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ExifInteropDirectory extends ExifDirectoryBase {
    protected static final HashMap<Integer, String> _tagNameMap;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        _tagNameMap = map;
        addExifTagNames(map);
    }

    public ExifInteropDirectory() {
        setDescriptor(new ExifInteropDescriptor(this));
    }

    @Override // com.drew.metadata.Directory
    public String getName() {
        return "Interoperability";
    }

    @Override // com.drew.metadata.Directory
    protected HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
