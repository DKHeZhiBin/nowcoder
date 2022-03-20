package com.nowcoder.community.Daoimpl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository("jojo")
@Primary
public class BaltaDaoImpl implements AlphaDao {
    @Override
    public String select() {
        return "B输出";
    }
}
