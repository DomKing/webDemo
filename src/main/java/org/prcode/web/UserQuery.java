package org.prcode.web;

import org.hibernate.validator.constraints.Length;
import org.prcode.busi.support.basic.group.Search;

/**
 * @ClassName: UserQuery
 * @Date: 2017-03-30 19:07
 * @Auther: kangduo
 * @Description: ()
 */
public class UserQuery {
    @Length(max = 5, groups = {Search.class}, message = "名称长度应该小于5")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
