package cn.zsk.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

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

    private List<ItemEntity> incomes;

    private List<ItemEntity> expenses;

    private SavingEntity saving;

}
