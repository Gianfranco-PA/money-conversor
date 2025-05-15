package org.gianfranco.model.repository.exchange.rate;

import com.google.gson.Gson;
import org.gianfranco.model.config.Config;
import org.gianfranco.model.entity.Conversion;
import org.gianfranco.model.entity.Currency;
import org.gianfranco.model.repository.CurrencyConverterRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ExchangeRateAPI implements CurrencyConverterRepository {

    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/{APIKEY}";

    @Override
    public List<Currency> getCurrencyCodes() {
        final String API_KEY = Config.get("exchange.rate.api.key");
        final String API_URL = BASE_URL.replace("{APIKEY}", API_KEY) + "/codes";

        Gson gson = new Gson();
        CurrencyCodesDTO dto = null;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                dto = gson.fromJson(responseBody, CurrencyCodesDTO.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error al obtener la lista de codigos: " + e);
            }
        }
        return ExchangeRateMapper.map(dto);
    }

    @Override
    public Conversion getExchangeRate(Currency base, Currency target) {
        final String API_KEY = Config.get("exchange.rate.api.key");
        final String API_URL = BASE_URL.replace("{APIKEY}", API_KEY) + "/pair/" + base.getCode() + "/" + target.getCode();

        Gson gson = new Gson();
        ConversionRateDTO dto = null;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                dto = gson.fromJson(responseBody, ConversionRateDTO.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error al obtener la lista de codigos: " + e);
            }
        }

        return new Conversion(base,target, dto.conversion_rate());
    }
}
