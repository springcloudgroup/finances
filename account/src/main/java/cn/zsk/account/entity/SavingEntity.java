package cn.zsk.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 14:09
 */
@Data
@Accessors(chain = true)
@TableName("saving")
public class SavingEntity implements Serializable {

    @TableField("id")
    private Integer id;

    @TableField("account_name")
    private String accountName;

    @TableField("amount")
    private double amount;

    @TableField("currentcy")
    private Integer currenty;

    @TableField("interest")
    private double interest;

    @TableField("deposit")
    private Integer deposit;

    @TableField("capitalization")
    private Integer capitalization;
}
