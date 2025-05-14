package org.gianfranco.model.repository.exchange.rate;

import java.util.List;

public record CurrencyCodesDTO(
        String result,
        String documentation,
        String terms_of_use,
        List<List<String>> supported_codes
) {
}
