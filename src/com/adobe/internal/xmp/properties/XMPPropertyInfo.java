package com.adobe.internal.xmp.properties;

import com.adobe.internal.xmp.options.PropertyOptions;

/* JADX INFO: loaded from: classes3.dex */
public interface XMPPropertyInfo extends XMPProperty {
    String getNamespace();

    @Override // com.adobe.internal.xmp.properties.XMPProperty
    PropertyOptions getOptions();

    String getPath();

    @Override // com.adobe.internal.xmp.properties.XMPProperty
    String getValue();
}
