package ru.spb.stec.divanov.service.messagereader;

import com.google.gson.Gson;
import ru.spb.stec.divanov.model.BaseRate;

public class RateReader {

    private final String response;

    public RateReader(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public BaseRate getRatesFromResponse() {
        return new Gson().fromJson(response,BaseRate.class);
    }
}
