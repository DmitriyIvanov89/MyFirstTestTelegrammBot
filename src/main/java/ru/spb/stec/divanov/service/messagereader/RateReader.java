package ru.spb.stec.divanov.service.messagereader;

import com.google.gson.Gson;
import ru.spb.stec.divanov.model.BaseRate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RateReader {

    private final String response;

    public RateReader(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public BaseRate getRatesFromResponse() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(response))) {
            return new Gson().fromJson(reader, BaseRate.class);
        }
    }
}
