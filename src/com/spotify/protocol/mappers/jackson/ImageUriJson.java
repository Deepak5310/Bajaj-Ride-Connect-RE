package com.spotify.protocol.mappers.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.spotify.protocol.types.ImageUri;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ImageUriJson {

    public static class Deserializer extends StdDeserializer<ImageUri> {
        private static final long serialVersionUID = 1;

        public Deserializer() {
            super(ImageUri.class);
        }

        /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
        public ImageUri m2185deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return new ImageUri(jsonParser.getValueAsString());
        }
    }

    public static class Serializer extends StdSerializer<ImageUri> {
        private static final long serialVersionUID = 1;

        protected Serializer() {
            super(ImageUri.class);
        }

        public void serialize(ImageUri imageUri, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(imageUri.raw);
        }
    }
}
