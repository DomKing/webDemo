package org.prcode.web.security;

import org.prcode.business.support.basic.security.util.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: SecurityController
 * @Date: 2017-4-16 16:17
 * @Auther: kangduo
 * @Description: (安全相关controller)
 */
@Controller
public class SecurityController {

    @GetMapping(value = "")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        if (SecurityUtil.getOperId() != null) {
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping(value = "/deny")
    public String deny() {
        return "deny";
    }
}
