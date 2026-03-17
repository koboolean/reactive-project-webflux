package com.koboolean.reactiveproject.operators.createSequence.create;

import java.util.List;

public interface CryptoCurrencyPriceListener {
    void onPrice(List<Integer> priceList);
    void onComplete();
}
