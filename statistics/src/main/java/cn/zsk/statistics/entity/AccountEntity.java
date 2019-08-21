package cn.zsk.statistics.entity;

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
    private List<ItemEntity> incomes;

    @Valid
    @NotNull
    private List<ItemEntity> expenses;

    @Valid
    @NotNull
    private SavingEntity saving;

}
