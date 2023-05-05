package com.example.fromtui;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fromtui.config.ClientSer;

@RestController
public class Cont {

	public final ClientSer proxy;

//	@Autowired
	// private OAuth2AuthorizedClientService service;

	public Cont(ClientSer client) {
		this.proxy = client;
	}

	@GetMapping("hello")
	public String sayHello() {
//		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) SecurityContextHolder.getContext()
//				.getAuthentication();
//		System.out.println(oauthToken);
//		OAuth2AuthorizedClient client = service.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(),
//				oauthToken.getName());
//		String accessToken = client.getAccessToken().getTokenValue();
//		System.out.println("access token --> " + accessToken);
		// client.getHello()
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		System.out.println(oauthToken);
		System.out.println(oauthToken.getAuthorizedClientRegistrationId());
		return proxy.getHello();
	}

	@GetMapping("bye")
	public String sayBye() {
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		System.out.println(oauthToken);
		System.out.println(oauthToken.getAuthorizedClientRegistrationId());
		return "bye";
	}

	@GetMapping("admin")
	public String admin() {
		return proxy.getAdmit();
	}

	@GetMapping("t")
	public String hgy() {
		return "t";
	}
}