package com.multidatasource.services;

import com.multidatasource.domain.creditcard.CreditCard;

public interface CreditCardService {

    CreditCard getCreditCardById(Long id);

    CreditCard saveCreditCard(CreditCard cc);
}