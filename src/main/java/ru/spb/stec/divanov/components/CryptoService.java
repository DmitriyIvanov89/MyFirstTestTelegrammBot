package ru.spb.stec.divanov.components;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CryptoService implements BaseCryptoService {

    private static final String HOST = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,JPY,EUR";
    private static final String TOKEN_API = "";

    @Override
    public String requestCryptoCourses() {
        return null;
    }

}
