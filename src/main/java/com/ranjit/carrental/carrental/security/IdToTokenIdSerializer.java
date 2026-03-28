package com.ranjit.carrental.carrental.security;

import org.springframework.beans.factory.annotation.Autowired;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class IdToTokenIdSerializer  extends StdSerializer<Long> {

    @Autowired
    private TokenIdService tokenService;

    public IdToTokenIdSerializer() {
        super(Long.class);
    }


    @Override
    public void serialize(Long value, JsonGenerator gen, SerializationContext provider) throws JacksonException {
        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeString(tokenService.encode(value));
        }
    }
}