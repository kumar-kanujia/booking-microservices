//package com.example.fromtui.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.stereotype.Component;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//
//@Component
//public class FeignIntercepter implements RequestInterceptor {
//
//	private static final String AUTHORIZATION_HEADER = "Authorization";
//	private static final String TOKEN_TYPE = "Bearer";
//
//	@Autowired
//	private OAuth2AuthorizedClientService service;
//
//
//	@Override
//	public void apply(RequestTemplate template) {
//		// TODO Auto-generated method stub
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//
//		if (authentication != null && authentication instanceof OAuth2AuthenticationToken) {
//			OAuth2AuthenticationToken oauthAuthentication = (OAuth2AuthenticationToken) authentication;
//
//			OAuth2AuthorizedClient client = service.loadAuthorizedClient(
//					oauthAuthentication.getAuthorizedClientRegistrationId(), oauthAuthentication.getName());
//
//			String accessToken = client.getAccessToken().getTokenValue();
//			String header = String.format("%s %s", TOKEN_TYPE, accessToken);
//			System.out.println(header);
//			template.header(AUTHORIZATION_HEADER, header);
//		}
//	}
//}
//
