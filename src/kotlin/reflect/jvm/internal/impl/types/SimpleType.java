package kotlin.reflect.jvm.internal.impl.types;

import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType makeNullableAsSpecified(boolean z);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAttributes(TypeAttributes typeAttributes);

    public SimpleType() {
        super(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it2 = getAnnotations().iterator();
        while (it2.hasNext()) {
            StringsKt.append(sb, "[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, it2.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            CollectionsKt.joinTo(getArguments(), sb, (PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION & 2) != 0 ? ", " : ", ", (PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION & 4) != 0 ? "" : "<", (PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION & 8) != 0 ? "" : ">", (PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION & 16) != 0 ? -1 : 0, (PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION & 32) != 0 ? "..." : null, (PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION & 64) != 0 ? null : null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
