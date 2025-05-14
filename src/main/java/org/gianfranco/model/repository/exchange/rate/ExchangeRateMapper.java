package org.gianfranco.model.repository.exchange.rate;

import org.gianfranco.model.config.Config;
import org.gianfranco.model.entity.ConversionRate;
import org.gianfranco.model.entity.Currency;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateMapper {

    public static List<Currency> map(CurrencyCodesDTO dto) {
        List<String> codes = Config.getAsList("exchange.rate.api.codes");
        List<Currency> currencies = new ArrayList<>();
        for (List<String> currencyCode : dto.supported_codes()) {
            String code = currencyCode.get(0);
            if (!codes.contains(code)) continue;

            String name = currencyCode.get(1);
            currencies.add(new Currency(code, name));
        }
        return currencies;
    }
}
