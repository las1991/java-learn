package com.las.learn.gof.specification.userExample;

import com.las.learn.gof.specification.ISpecification;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String selectList(ISpecification<User> userSpec) {
        return new SQL() {{
        }}.toString();
    }
}
