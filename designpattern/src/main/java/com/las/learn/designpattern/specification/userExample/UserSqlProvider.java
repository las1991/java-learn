package com.las.learn.designpattern.specification.userExample;

import com.las.learn.designpattern.specification.ISpecification;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String selectList(ISpecification<User> userSpec) {
        return new SQL() {{
        }}.toString();
    }
}
