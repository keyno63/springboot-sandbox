package jp.co.who.spring_tutorial.api.filter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@WebFilter(
        urlPatterns = {"/*"},
        asyncSupported = true
)
public class HeaderFilter implements Filter {
    private final String TARGET_COOKIE_NAME = "target-cookie";

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderFilter.class);

    @Override
    public final void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public final void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain
    ) throws IOException, ServletException {
        Cookie[] cookies = Optional.ofNullable(((HttpServletRequest) request).getCookies())
                .orElse(new Cookie[0]);
        Cookie cookie = Arrays.stream(cookies)
                .filter(cookie1 -> cookie1.getName().equals(TARGET_COOKIE_NAME))
                .findFirst()
                .orElse(null);

        if (Objects.isNull(cookie)) {
            LOGGER.debug("cookie is null");
        } else {
            LOGGER.debug("cookie is exist {}", cookie.getValue());
        }

        request.setAttribute("new-cookie", cookie);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

}
