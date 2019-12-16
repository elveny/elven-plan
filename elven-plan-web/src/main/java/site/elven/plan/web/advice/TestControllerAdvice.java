package site.elven.plan.web.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import site.elven.plan.web.base.response.DefaultResponse;
import site.elven.plan.web.base.response.DefaultResponseResultCode;
import site.elven.plan.web.rest.test.TestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = TestController.class)
public class TestControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<DefaultResponse> handleControllerException(HttpServletRequest request, Throwable ex) {
        return ResponseEntity.status(getStatus(request)).headers(getHeaders()).body(DefaultResponse.newResponse(DefaultResponseResultCode.UNKNOWN_EXCEPTION));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    private HttpHeaders getHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
