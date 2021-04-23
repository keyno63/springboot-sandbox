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
    protected static final String TARGET_COOKIE_NAME = "target-cookie";

    protected static final String ORIGINAL_HEADER_NAME = "sample-header";

    protected static final String ATTR_NAME_VALUE = "new-cookie";

    protected static final String ATTR_NAME_SERVERNAME = "filter-server";

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
            var x = ((HttpServletRequest) request).getHeader(ORIGINAL_HEADER_NAME);
            var ret = Optional.ofNullable(x).orElse("");
            var cookiev = new Cookie(TARGET_COOKIE_NAME, ret);
            request.setAttribute("new-cookie", cookiev);
            chain.doFilter(request, response);
            return;
        } else {
            LOGGER.debug("cookie is exist {}", cookie.getValue());
        }

        request.setAttribute(ATTR_NAME_VALUE, cookie);
        request.setAttribute(ATTR_NAME_SERVERNAME, request.getServerName());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

}
