package ru.spb.stec.divanov.service.httpconnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ApacheTestConnection {
    private static final String API_KEY = "*****";
    private static final String URL = "https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

    public void getTestConnection() {
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("start", "1"));
        parameters.add(new BasicNameValuePair("limit", "1000"));
        parameters.add(new BasicNameValuePair("convert", "USD"));

        try {
            String result = testAPICall(URL, parameters);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    private static String testAPICall(String url, List<NameValuePair> parameters) throws URISyntaxException, IOException {
        String responseContent = "";
        URIBuilder query = new URIBuilder(url);
        query.addParameters(parameters);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", API_KEY);

        CloseableHttpResponse response = client.execute(request);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return responseContent;

    }

}
