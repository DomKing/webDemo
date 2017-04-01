package org.prcode.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.prcode.business.basedomain.user.dao.UserMapper;
import org.prcode.business.basedomain.user.domain.User;
import org.prcode.business.basedomain.user.domain.UserExample;
import org.prcode.business.support.basic.busiSupportCache.service.IBusiSupportCacheService;
import org.prcode.business.support.basic.group.Search;
import org.prcode.business.support.basic.mail.SimpleMailSender;
import org.prcode.business.support.basic.util.BindingResultUtil;
import org.prcode.utility.basic.JsonResponse;
import org.prcode.utility.basic.PageKey;
import org.prcode.utility.exception.ValidateException;
import org.prcode.utility.util.StringUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
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

    @Resource
    private SimpleMailSender simpleMailSender;

    @Resource
    private IBusiSupportCacheService busiSupportCacheService;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @ApiIgnore
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("txt", "abc");
        return mav;
    }

    @GetMapping("/userListByPage.json")
    @ResponseBody
    @ApiOperation(value = "分页查询用户列表", notes = "不传分页默认1页15条")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "条数")
    })
    public JsonResponse getUserList(@Validated({Search.class}) UserQuery user,
                                    BindingResult bindingResult,
                                    PageKey pageKey)
            throws ValidateException {

        BindingResultUtil.validateResult(bindingResult);
        Page<Object> objects = PageHelper.startPage(pageKey.getPage(), pageKey.getPageSize(), true);
        UserExample example = new UserExample();
        example.createCriteria().andNickNameLike(StringUtil.turn2LikeStr(user.getName()));
        JsonResponse json = new JsonResponse();
        List<User> users = userMapper.selectByExample(example);
        json.putData("list", users);
        System.out.println("**********共有" + objects.getTotal() + "条数据*********");

        redisTemplate.opsForList().rightPushAll("userList", users);
        return json;
    }

    @GetMapping("/sendMail.json")
    @ResponseBody
    public JsonResponse sendMail() throws Exception {
        String subject = "test";
        String sendTo = "943697653@qq.com,";
        String template = "mail/demo.ftl";
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("username", "kangduo");
        simpleMailSender.sendTemplateMail(subject, Arrays.asList(sendTo.split(",")), null, template, map);
        return new JsonResponse();
    }

    @GetMapping("paramValue.json")
    @ResponseBody
    public String getParamValue(String param) {
//        PageHelper.startPage(1, 10, true);
        busiSupportCacheService.getCommSysParaValue(param);
//        busiSupportCacheService.getOmsCommSysParaValue(param);
//        busiSupportCacheService.updCommSysParaValue(param, "123abc");
//        busiSupportCacheService.delCommSysParaValue(param);
//        busiSupportCacheService.refreshSysParaCache();
        return "success";
    }
}
