package jp.co.who.spring_tutorial.api.filter.filter;

import javax.servlet.http.Cookie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;

class HeaderFilterTest {

    MockHttpServletRequest servletRequest;

    MockHttpServletResponse servletResponse;

    HeaderFilter target;

    @BeforeEach
    void setUp() {
        servletRequest = new MockHttpServletRequest();
        servletResponse = new MockHttpServletResponse();
        target = new HeaderFilter();
    }

    @Test
    void Cookieある時のテスト() throws Exception {
        var cookieValue = "B";

        var cookie = new Cookie(HeaderFilter.TARGET_COOKIE_NAME, cookieValue);
        servletRequest.setCookies(cookie);
        MockFilterChain mockChain = new MockFilterChain();
        target.doFilter(servletRequest, servletResponse, mockChain);

        assertThat(mockChain.getRequest()).isEqualTo(servletRequest);
        var v = mockChain.getRequest();
        assertThat(v).isNotNull();
        var vv = (Cookie) v.getAttribute("new-cookie");
        assertThat(vv).isNotNull();
        assertThat(vv.getValue()).isEqualTo(cookieValue);
    }

    @Test
    void Cookieない時のヘッダー値取得テスト() throws Exception {
        var cookieValue = "B";
        var testValue = "C";

        var cookie = new Cookie("not-target-cookie", cookieValue);
        servletRequest.setCookies(cookie);
        servletRequest.addHeader(HeaderFilter.ORIGINAL_HEADER_NAME, testValue);
        MockFilterChain mockChain = new MockFilterChain();
        target.doFilter(servletRequest, servletResponse, mockChain);

        assertThat(mockChain.getRequest()).isEqualTo(servletRequest);
        var v = mockChain.getRequest();
        assertThat(v).isNotNull();
        var vv = (Cookie) v.getAttribute("new-cookie");
        assertThat(vv.getValue()).isEqualTo(testValue);
    }
}