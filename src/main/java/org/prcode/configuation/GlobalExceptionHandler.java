package org.prcode.configuation;

import org.prcode.utility.exception.AppException;
import org.prcode.utility.exception.BusinessException;
import org.prcode.utility.exception.ValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GlobalExceptionHandler
 * @Date: 2017-03-28 10:44
 * @Auther: kangduo
 * @Description: ()
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final String DEFAULT_EXCEPTION_MESSAGE = "系统异常，请联系客服";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) 是否是ajax请求
        Map<String, String> res = new HashMap<>();
        if (e instanceof AppException || e instanceof BusinessException || e instanceof ValidateException) {
            res.put("message", e.getMessage());
        } else {
            res.put("message", DEFAULT_EXCEPTION_MESSAGE);
        }
        res.put("code", "error");
        res.put("url", req.getRequestURL().toString());
        res.put("data", "这是个有异常的请求");
        return res;
    }

}
