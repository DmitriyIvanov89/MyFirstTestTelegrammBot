package ru.spb.stec.divanov.service.printers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class ResponsePrinter {

    public String convertToView(String responseJson) {
        JsonObject responseInJson = new Gson().fromJson(responseJson, JsonObject.class);
        StringBuilder responseForUser = new StringBuilder();

        for (Map.Entry<String, JsonElement> entry : responseInJson.entrySet()) {
            responseForUser.append(entry.getKey() + ":\n");
            for (Map.Entry<String, JsonElement> inside : entry.getValue().getAsJsonObject().entrySet()) {
                responseForUser.append("\t\t" + inside.getKey() + " - " + inside.getValue().toString() + "\n");
            }

            responseForUser.append("\n");
        }

        return responseForUser.toString();
    }

}
