package com.spotify.protocol.mappers.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spotify.protocol.mappers.JsonArray;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.mappers.JsonMappingException;
import com.spotify.protocol.mappers.JsonObject;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class JacksonMapper implements JsonMapper {
    private final ObjectMapper mObjectMapper;

    public static JacksonMapper create() {
        return new JacksonMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false));
    }

    private JacksonMapper(ObjectMapper objectMapper) {
        this.mObjectMapper = objectMapper;
    }

    @Override // com.spotify.protocol.mappers.JsonMapper
    public JsonArray toJsonArray(String str) throws JsonMappingException {
        try {
            return new JacksonJsonArray(str);
        } catch (IOException e) {
            throw new JsonMappingException(e);
        }
    }

    @Override // com.spotify.protocol.mappers.JsonMapper
    public String toJson(Object obj) throws JsonMappingException {
        try {
            return this.mObjectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonMappingException(e);
        }
    }

    private class JacksonJsonArray implements JsonArray {
        private final JsonNode mJsonNode;

        JacksonJsonArray(String str) throws IOException {
            this.mJsonNode = JacksonMapper.this.mObjectMapper.readTree(str);
        }

        @Override // com.spotify.protocol.mappers.JsonArray
        public int getIntAt(int i) {
            JsonNode jsonNode = this.mJsonNode.get(i);
            if (jsonNode != null) {
                return jsonNode.asInt();
            }
            return 0;
        }

        @Override // com.spotify.protocol.mappers.JsonArray
        @Nullable
        public String getStringAt(int i) {
            JsonNode jsonNode = this.mJsonNode.get(i);
            if (jsonNode != null) {
                return jsonNode.asText();
            }
            return null;
        }

        @Override // com.spotify.protocol.mappers.JsonArray
        public JsonObject getObjectAt(int i) {
            return JacksonMapper.this.new JacksonJsonObject(this.mJsonNode.get(i));
        }
    }

    private class JacksonJsonObject implements JsonObject {
        private final JsonNode mJsonNode;

        JacksonJsonObject(JsonNode jsonNode) {
            this.mJsonNode = jsonNode;
        }

        @Override // com.spotify.protocol.mappers.JsonObject
        @Nullable
        public <T> T getAs(Class<T> cls) throws JsonMappingException {
            try {
                return (T) JacksonMapper.this.mObjectMapper.convertValue(this.mJsonNode, cls);
            } catch (IllegalArgumentException e) {
                throw new JsonMappingException(e);
            }
        }

        @Override // com.spotify.protocol.mappers.JsonObject
        public String toJson() throws JsonMappingException {
            try {
                return JacksonMapper.this.mObjectMapper.writeValueAsString(this.mJsonNode);
            } catch (JsonProcessingException e) {
                throw new JsonMappingException(e);
            }
        }
    }
}
