package org.gianfranco.model.repository;

import org.gianfranco.model.entity.Conversion;
import org.gianfranco.model.entity.Currency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheRepository implements CurrencyConverterRepository{

    private final CurrencyConverterRepository repository;
    private List<Currency> currencies;
    private Map<Currency, Map<Currency, Conversion>> conversions;

    public CacheRepository(CurrencyConverterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Currency> getCurrencyCodes() {
        if (currencies == null) {
            currencies = repository.getCurrencyCodes();
        }
        return currencies;
    }

    @Override
    public Conversion getExchangeRate(Currency base, Currency target) {
        if(conversions == null) {
            conversions = new HashMap<>();
            conversions.computeIfAbsent(base, _ -> new HashMap<>())
                    .put(target, repository.getExchangeRate(base, target));
        }
        return conversions.get(base).get(target);
    }
}
