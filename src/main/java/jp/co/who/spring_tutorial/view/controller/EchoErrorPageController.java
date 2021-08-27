package jp.co.who.spring_tutorial.view.controller;

import jp.co.who.spring_tutorial.api.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
public class EchoErrorPageController {
    // Servlet Exception handled.
    @RequestMapping("/error_")
    public ApiError handleError(HttpServletRequest req) {

        String exception = "";
        String message;
        Exception e = (Exception) req.getAttribute(
                RequestDispatcher.ERROR_EXCEPTION
        );
        Integer statusCode = (Integer) req.getAttribute(
                RequestDispatcher.ERROR_STATUS_CODE
        );
        if (e != null) {
            message = e.getMessage();
            exception = e.getCause().toString();
        } else {
            if (Arrays.asList(HttpStatus.values()).stream()
                    .anyMatch(st -> st.value() == statusCode))
                message = e.getMessage();
            else
                message = "Custom error %s is occured.".format(statusCode.toString());
        }
        return new ApiError(message, exception);
    }
}
