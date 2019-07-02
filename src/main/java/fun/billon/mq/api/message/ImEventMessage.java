package fun.billon.mq.api.message;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * im事件消息
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ImEventMessage {

    /**
     * 事件类型(1):群组更新
     */
    public static final int GROUP_UPDATE = 1;
    /**
     * 事件类型(2):群组解散
     */
    public static final int GROUP_DELETE = 2;
    /**
     * 事件类型(3):移除用户
     */
    public static final int REMOVE_MEMBER = 3;
    /**
     * 事件类型(4):用户加入
     */
    public static final int MEMBER_JOIN = 4;
    /**
     * 事件类型(5):用户离开
     */
    public static final int MEMBER_LEAVE = 5;
    /**
     * 事件类型(6):用户更新
     */
    public static final int MEMBER_UPDATE = 6;

    /**
     * 事件类型(1:群组更新;2:群组解散;3:移除用户;4:用户加入;5:用户离开;6:用户更新)
     */
    private int type;

    /**
     * 群组id
     */
    private int groupId;

    /**
     * 群组用户uid
     */
    private int uid;

    /**
     * 要通知的目标用户列表,群组解散消息需要使用该字段,因为群组已经解散,消费方无法根据群组获取用户
     */
    private List<Integer> targetUids;

    /**
     * 事件产生时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

}