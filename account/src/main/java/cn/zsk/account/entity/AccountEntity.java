package cn.zsk.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 14:40
 */
@Data
@Accessors(chain = true)
@TableName("account")
public class AccountEntity implements Serializable {

    @TableId("name")
    private String name;

    @TableField("last_seen")
    private String lastSeen;

    @TableField("note")
    private String note;

}
