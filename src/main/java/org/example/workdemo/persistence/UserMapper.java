package org.example.workdemo.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.workdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
