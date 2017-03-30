package org.prcode.web;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.prcode.basedomain.business.user.dao.UserMapper;
import org.prcode.basedomain.business.user.domain.User;
import org.prcode.basedomain.business.user.domain.UserExample;
import org.prcode.busi.support.basic.group.Search;
import org.prcode.busi.support.basic.util.BindingResultUtil;
import org.prcode.utility.basic.JsonResponse;
import org.prcode.utility.exception.ValidateException;
import org.prcode.utility.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;


/**
 * @ClassName: DemoController
 * @Date: 2017-03-30 15:02
 * @Auther: kangduo
 * @Description: (样例)
 */
@Controller
public class DemoController {
    private static final Logger logger = Logger.getLogger(DemoController.class);

    @Resource
    private UserMapper userMapper;

    @ApiIgnore
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("txt", "abc");
        return mav;
    }

    @GetMapping("/userListByPage.json")
    @ResponseBody
    public JsonResponse getUserList(@Validated({Search.class}) UserQuery user, BindingResult bindingResult, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) throws ValidateException {
        BindingResultUtil.validateResult(bindingResult);
        PageHelper.startPage(page, pageSize, false);
        UserExample example = new UserExample();
        example.createCriteria().andNickNameLike(StringUtil.turn2LikeStr(user.getName()));
        JsonResponse json = new JsonResponse();
        json.putData("list", userMapper.selectByExample(example));
        return json;
    }
}
