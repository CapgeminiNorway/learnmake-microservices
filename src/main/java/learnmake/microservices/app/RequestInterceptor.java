package learnmake.microservices.app;

import learnmake.microservices.utils.AppConstants;
import learnmake.microservices.utils.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.debug("Request Intercepted! "
                    + "method: {} - servletPath: {}", request.getMethod(), request.getServletPath()
        );


        HttpSession session = request.getSession();
        String reqPath = request.getServletPath();

        if (!reqPath.contains("/"+AppConstants.Action.custom_action.name())) {

            if (session == null
                    //|| session.getAttribute(SessionDataManager.ATTR_CUSTOM) == null
                    ) {


                try {
                    FlashMap flashMap = new FlashMap();
                    flashMap.put(AppConstants.PARAM_FLASHATTR,
                            CookieUtil.prepareAttrMap(AppConstants.PARAM_REQORIGIN, AppConstants.PARAM_EXPIREDSESSION)
                    );
                    RequestContextUtils.getFlashMapManager(request)
                            .saveOutputFlashMap(flashMap, request, response);

                    response.sendRedirect(request.getContextPath());
                } catch (IOException ioex) {
                    LOGGER.error(RequestInterceptor.class.getSimpleName()+".preHandle", ioex);
                }

                return false;
            }

            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        // appending custom Cookie to share serverTime, sessionExpiry, etc
        if (request.getSession() != null) {
            CookieUtil.addCustomCookies(request, response);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // impl custom logic if necessary
    }
}
