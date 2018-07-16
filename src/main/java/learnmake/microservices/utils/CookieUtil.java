package learnmake.microservices.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class CookieUtil {

    // adapted from https://stackoverflow.com/a/48552163/492918
    final static Integer MAX_AGE_SECONDS = 3600;
    final static String COOKIE_SERVERTIME = "serverTime";
    final static String COOKIE_EXPIRYTIME = "sessionExpiry";
    final static String COOKIE_EXPIRYDURATION = "sessionExpiryDuration";
    public static void addCustomCookies(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        long currTime = System.currentTimeMillis();
        long expiryTime = currTime + servletRequest.getSession().getMaxInactiveInterval() * 1000;
        Cookie cookie;

        cookie = createCookie(COOKIE_SERVERTIME, String.valueOf(currTime));
        servletResponse.addCookie( cookie );

        cookie = createCookie(COOKIE_EXPIRYTIME, String.valueOf(expiryTime));
        servletResponse.addCookie( cookie );

        cookie = createCookie(COOKIE_EXPIRYDURATION, String.valueOf( expiryTime-currTime ));
        servletResponse.addCookie( cookie );
    }

    private static Cookie createCookie(String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(MAX_AGE_SECONDS);
        cookie.setHttpOnly(true);// true: the cookie cannot be accessed/modified via javascript
        //cookie.setSecure(true);// true: cookies to be accessed only over https protocol
        return cookie;
    }

    public static Map<String, Object> prepareAttrMap() {
        return prepareAttrMap("", null);
    }
    public static Map<String, Object> prepareAttrMap(String key, Object val) {

        Map<String, Object> attrMap = Maps.newHashMap();

        if (StringUtils.isNotEmpty(key) && val!=null) {
            attrMap.put(key, val);
        }

        return attrMap;
    }
}
