package org.prcode.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.prcode.basedomain.dredgeType.dao.DredgeTypeMapper;
import org.prcode.basedomain.dredgeType.domain.DredgeType;
import org.prcode.basedomain.dredgeType.domain.DredgeTypeExample;
import org.prcode.utility.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: DredgeController
 * @Date: 2017-03-28 10:11
 * @Auther: kangduo
 * @Description: ()
 */
@Controller
public class DredgeController {
    private static final Logger logger = Logger.getLogger(DredgeController.class);

    @Autowired
    private DredgeTypeMapper dredgeTypeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiIgnore
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        if (true) {
            throw new AppException("lkd");
        }
        mav.addObject("txt", "abc");
        return mav;
    }

    @ApiOperation(value="查询维修类型", notes="查询全部维修类型")
    @GetMapping("/dredgeTypeList")
    @ResponseBody
    @Cacheable(value = "dredgeTypeList:ice", sync = true)
    public String getDredgeTypeList(){
        DredgeTypeExample example = new DredgeTypeExample();
        example.createCriteria().andSysDelStateEqualTo(false).andNameLike("%冰箱%");
        Page<Object> objects = PageHelper.startPage(1, 2);
        List<DredgeType> dredgeTypes = dredgeTypeMapper.selectByExample(example);
        System.out.println("一共有" + objects.getTotal());
        System.out.println("objects======" + JSON.toJSONString(objects));
        return JSON.toJSONString(dredgeTypes);
    }

    @ApiOperation(value="查询维修类型", notes="查询指定ID维修类型")
    @ApiImplicitParam(name = "id", value = "维修ID", required = true, dataType = "Long")
    @GetMapping("/dredgeType/{id:[\\d]+}")
    @ResponseBody
    public DredgeType getDredgeTypeById(@PathVariable Long id) {
        DredgeType type = dredgeTypeMapper.selectByPrimaryKey(id);
        stringRedisTemplate.opsForValue().set("dredgeTypeId_" + id.toString(), JSON.toJSONString(type),1, TimeUnit.MINUTES);
        return type;
    }
}
