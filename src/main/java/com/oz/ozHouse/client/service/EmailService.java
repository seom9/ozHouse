package com.oz.ozHouse.client.service;

public interface EmailService {
	String sendOauthMessage(String to, String purpose)throws Exception;
}
