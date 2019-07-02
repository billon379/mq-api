package fun.billon.mq.api.message;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * im聊天消息
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ImChatMessage {

    /**
     * 消息类型(1):文本消息
     */
    public static final int TYPE_TEXT = 1;
    /**
     * 消息类型(2):图片消息
     */
    public static final int TYPE_IMAGE = 2;
    /**
     * 消息类型(3):音频消息
     */
    public static final int TYPE_AUDIO = 3;
    /**
     * 消息类型(4):视频消息
     */
    public static final int TYPE_VIDEO = 4;

    /**
     * 消息发送者
     */
    private int sender;

    /**
     * 群组id
     */
    private int groupId;

    /**
     * 消息类型(1:文本消息;2:图片消息;3:音频消息;4:视频消息)
     */
    private int type;

    /**
     * 消息正文
     */
    private String content;

    /**
     * 消息附件
     */
    private String attachment;

    /**
     * 消息产生时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

}