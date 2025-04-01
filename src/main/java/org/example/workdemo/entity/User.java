package org.example.workdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("account")
public class User {
    @TableId(value = "username")
    private String username;
    private String password;
}
