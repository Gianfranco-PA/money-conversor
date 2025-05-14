package org.gianfranco.model.repository;

import org.gianfranco.model.entity.ConversionRate;
import org.gianfranco.model.entity.Currency;

import java.util.List;

public interface CurrencyConverterRepository {

    List<Currency> getCurrencyCodes();

    ConversionRate getExchangeRate(Currency base, Currency target);
}
