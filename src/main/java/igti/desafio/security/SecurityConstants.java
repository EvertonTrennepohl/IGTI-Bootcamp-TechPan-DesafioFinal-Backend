package igti.desafio.security;

public class SecurityConstants {
	
	public static final  String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 600_000; //10 minutes
//	public static final long EXPIRATION_TIME = 864_000_000; //10 days
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/login";
	public static final String STATUS_URL = "/status";
	public static final String CARDAPIO_URL = "/cardapio";
}
