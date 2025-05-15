package org.gianfranco.model.repository;

import org.gianfranco.model.entity.Conversion;
import org.gianfranco.model.entity.Currency;

import java.util.List;

public interface CurrencyConverterRepository {

    List<Currency> getCurrencyCodes();

    Conversion getExchangeRate(Currency base, Currency target);
}
