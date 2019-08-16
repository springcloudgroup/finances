package cn.zsk.statistics.entity;

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
public class AccountEntity implements Serializable {

    @Valid
    @NotNull
    private List<Item> incomes;

    @Valid
    @NotNull
    private List<Item> expenses;

    @Valid
    @NotNull
    private Saving saving;

}
