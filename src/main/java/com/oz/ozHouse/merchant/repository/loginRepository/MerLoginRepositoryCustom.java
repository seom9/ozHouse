package com.oz.ozHouse.merchant.repository.loginRepository;

import com.oz.ozHouse.domain.Merchant;

public interface MerLoginRepositoryCustom {

	public Merchant findMerchantEmail(String mer_email);
}
