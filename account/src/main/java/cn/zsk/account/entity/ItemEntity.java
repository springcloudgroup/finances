package cn.zsk.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 14:24
 */
@Data
@Accessors(chain = true)
@TableName("item")
public class ItemEntity implements Serializable {

    @TableId("id")
    private Integer id;

    //用户名外键
    @TableField("account_name")
    private String accountName;

    //标题
    @TableField("title")
    private String title;

    //合计
    @TableField("amount")
    private double amount;

    //货币类型
    @TableField("currency")
    private Integer currency;

    //时间段
    @TableField("period")
    private Integer period;

    @TableField("icon")
    private String icon;

    @TableField("incomes_or_expenses")
    private Integer incomesOrExpenses;

}
