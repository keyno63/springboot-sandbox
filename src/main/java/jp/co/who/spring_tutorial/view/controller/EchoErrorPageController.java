package jp.co.who.spring_tutorial.view.controller;

import jp.co.who.spring_tutorial.api.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

@RestController
public class EchoErrorPageController {
    // Servlet Exception handled.
    @RequestMapping("/error_")
    public ApiError handleError(HttpServletRequest req) {
        Exception e = (Exception) req.
                getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        int statusCode = (int) req.
                getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        return getApiError(e, statusCode);
    }

    private ApiError getApiError(Exception e, int statusCode) {
        if (Objects.nonNull(e)) {
            return new ApiError(e.getMessage(), e.getCause().toString());
        } else {
            String message = String.format("Custom error %d is occurred.", statusCode);
            return new ApiError(message, "");
        }
    }
}
