package cn.zsk.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 14:06
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserEntity implements Serializable {

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;
}
