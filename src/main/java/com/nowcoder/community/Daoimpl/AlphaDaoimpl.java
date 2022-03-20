package com.nowcoder.community.Daoimpl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoimpl implements AlphaDao {


    @Override
    public String select() {
        return "A输出";
    }
}
