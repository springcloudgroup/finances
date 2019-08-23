package cn.zsk.notification.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author:zsk
 * @CreateTime:2019-08-23 14:08
 */
@Data
@TableName("notification_type")
public class NotificationTypeEntity {

    @TableId
    private Integer id;

    private String subject;

    private String text;

    private String attachment;
}
