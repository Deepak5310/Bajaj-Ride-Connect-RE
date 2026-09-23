package com.drew.metadata.jpeg;

import com.drew.metadata.Directory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class JpegCommentDirectory extends Directory {
    public static final int TAG_COMMENT = 0;
    protected static final HashMap<Integer, String> _tagNameMap;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        _tagNameMap = map;
        map.put(0, "JPEG Comment");
    }

    public JpegCommentDirectory() {
        setDescriptor(new JpegCommentDescriptor(this));
    }

    @Override // com.drew.metadata.Directory
    public String getName() {
        return "JpegComment";
    }

    @Override // com.drew.metadata.Directory
    protected HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
