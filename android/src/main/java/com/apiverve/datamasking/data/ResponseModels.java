// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DataMaskingData data = Converter.fromJsonString(jsonString);

package com.apiverve.datamasking.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DataMaskingData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DataMaskingData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DataMaskingData.class);
        writer = mapper.writerFor(DataMaskingData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DataMaskingData.java

package com.apiverve.datamasking.data;

import com.fasterxml.jackson.annotation.*;

public class DataMaskingData {
    private String masked;
    private Detected detected;

    @JsonProperty("masked")
    public String getMasked() { return masked; }
    @JsonProperty("masked")
    public void setMasked(String value) { this.masked = value; }

    @JsonProperty("detected")
    public Detected getDetected() { return detected; }
    @JsonProperty("detected")
    public void setDetected(Detected value) { this.detected = value; }
}

// Detected.java

package com.apiverve.datamasking.data;

import com.fasterxml.jackson.annotation.*;

public class Detected {
    private long email;
    private long phone;
    private long ssn;
    private long creditCard;
    private long ipAddress;
    private long url;
    private long date;

    @JsonProperty("email")
    public long getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(long value) { this.email = value; }

    @JsonProperty("phone")
    public long getPhone() { return phone; }
    @JsonProperty("phone")
    public void setPhone(long value) { this.phone = value; }

    @JsonProperty("ssn")
    public long getSsn() { return ssn; }
    @JsonProperty("ssn")
    public void setSsn(long value) { this.ssn = value; }

    @JsonProperty("credit_card")
    public long getCreditCard() { return creditCard; }
    @JsonProperty("credit_card")
    public void setCreditCard(long value) { this.creditCard = value; }

    @JsonProperty("ip_address")
    public long getIPAddress() { return ipAddress; }
    @JsonProperty("ip_address")
    public void setIPAddress(long value) { this.ipAddress = value; }

    @JsonProperty("url")
    public long getURL() { return url; }
    @JsonProperty("url")
    public void setURL(long value) { this.url = value; }

    @JsonProperty("date")
    public long getDate() { return date; }
    @JsonProperty("date")
    public void setDate(long value) { this.date = value; }
}