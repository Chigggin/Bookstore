package Assignment.Bookstore.Security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String AUTH_TOKEN = "normal";

    private static final String SA_AUTH_TOKEN = "SA";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || (!apiKey.equals(AUTH_TOKEN) && !apiKey.equals(SA_AUTH_TOKEN))) {
            throw new BadCredentialsException("Invalid API Key");
        }

        if(apiKey.equals(SA_AUTH_TOKEN))
        {
            return new ApiKeyAuthentication(apiKey, AuthorityUtils.createAuthorityList("SA"));
        }
        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);



    }
}
