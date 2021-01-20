package com.raeandres.cartrackapp.common.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.lang.reflect.Type;


public class GsonUtil {

    private GsonUtil() {}

    protected static synchronized Gson getInstance() {
        return LazyGsonLoader.gsonDefault;
    }

    public static <T> T getObjectFromJson(String mStr, Class<T> toJsonClass) throws JsonSyntaxException {
        return getInstance().fromJson(mStr, toJsonClass);
    }

    public static <T> T getObjectFromJson(String mStr, Type toType) throws JsonSyntaxException {
        return getInstance().fromJson(mStr, toType);
    }

    public static <T> String getJsonFromObject(T src) {
        return getInstance().toJson(src);
    }

    private static class LazyGsonLoader {
        /* By default, Gson escapes HTML characters such as < > etc.
         * @See https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/GsonBuilder.html#disableHtmlEscaping()
         */
        private static final Gson gsonDefault = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        // Gson object which excludeFieldsWithoutExposeAnnotation for parsing swagger model
        // Add support to serialize/de-serialize local date with null values
        private static final Gson gsonNoExpose = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new TypeAdapter<LocalDate>() {
                    @Override
                    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
                        jsonWriter.value(localDate.toString());
                    }

                    @Override
                    public LocalDate read(JsonReader jsonReader) throws IOException {
                        return LocalDate.parse(jsonReader.nextString());
                    }
                }.nullSafe())
                .registerTypeAdapter (OffsetDateTime.class, new TypeAdapter<OffsetDateTime>() {
                    @Override
                    public void write(JsonWriter jsonWriter, OffsetDateTime offsetDateTime) throws IOException {
                        jsonWriter.value (offsetDateTime.toString ());
                    }

                    @Override
                    public OffsetDateTime read(JsonReader in) throws IOException {
                        return OffsetDateTime.parse (in.nextString ());
                    }
                }.nullSafe ())
                .serializeNulls()
                .create();
    }

    public static <T> T getObjectFromJson(
            String mStr,
            Class<T> toJsonClass,
            boolean excludeFieldsWithoutExposeAnnotation) throws JsonSyntaxException
    {
        if (excludeFieldsWithoutExposeAnnotation) {
            return LazyGsonLoader.gsonNoExpose.fromJson(mStr, toJsonClass);
        } else {
            return LazyGsonLoader.gsonDefault.fromJson(mStr, toJsonClass);
        }
    }

    public static <T> T getObjectFromJson(
            String mStr,
            Type toType,
            boolean excludeFieldsWithoutExposeAnnotation) throws JsonSyntaxException
    {
        if (excludeFieldsWithoutExposeAnnotation) {
            return LazyGsonLoader.gsonNoExpose.fromJson(mStr, toType);
        } else {
            return LazyGsonLoader.gsonDefault.fromJson(mStr, toType);
        }
    }

    public static <T> String getJsonFromObject(
            T src,
            boolean excludeFieldsWithoutExposeAnnotation)
    {
        if (excludeFieldsWithoutExposeAnnotation) {
            return LazyGsonLoader.gsonNoExpose.toJson(src);
        } else {
            return LazyGsonLoader.gsonDefault.toJson(src);
        }
    }
}
