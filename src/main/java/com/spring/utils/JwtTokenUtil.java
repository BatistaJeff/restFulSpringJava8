package com.spring.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	static final String CLAIN_KEY_USERNAME = "sub";
	static final String CLAIN_KEY_ROLE = "role";
	static final String CLAIN_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;
	
	/**
	 * Obtem o username (email) contido no token JWT
	 * @param token
	 * @return {@link String}
	 */
	public String getUsernameFronToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * Retorna a data de expiração de um token JWT
	 * @param token
	 * @return {@link Date}
	 */
	public Date getExpirationaDateFronToken(String token) {
		Date expiration;
		try {
			Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	/**
	 * Cria um novo token (refresh)
	 * @param token
	 * @return {@link String}
	 */
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			Claims claims = getClaimsFromToken(token);
			claims.put(CLAIN_KEY_CREATED, new Date());
			refreshedToken = gerarToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	/**
	 * Verifica se o token JWT é valido
	 * @param token
	 * @return {@link String}
	 */
	public boolean tokenValido(String token) {
		return !tokenExpirado(token);
	}
	
	/**
	 * Retorna um novo token JWT com base nos dados do usuário.
	 * @param userDetails
	 * @return {@link String}
	 */
	public String obterToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIN_KEY_USERNAME, userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIN_KEY_ROLE, authority.getAuthority()));
		claims.put(CLAIN_KEY_CREATED, new Date());
		return gerarToken(claims);
	}
	
	/**
	 * Realiza o parse do token JWT para extrair as informações contidas no corpo dele
	 * @param token
	 * @return {@link Claims}
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	/**
	 * Retorna a Data de expiração com base na data atual
	 * @return {@link Date}
	 */
	private Date gerarDataExpiracao() {
		return new Date(System.currentTimeMillis() + expiration * 100);
	}
	
	/**
	 * Verifica se um token JTW está expirado
	 * @param token
	 * @return {@link Boolean}
	 */
	private boolean tokenExpirado(String token) {
		Date dataExpiracao = this.getExpirationaDateFronToken(token);
		if(dataExpiracao == null)
			return false;
		return dataExpiracao.before(new Date());
	}	
	
	/**
	 * Gera um novo token contendo os dados (claims) fornecidos
	 * @param claims
	 * @return {@link String}
	 */
	private String gerarToken(Map<String, Object> claims) {
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(gerarDataExpiracao())
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	
	
	
	
	
}
