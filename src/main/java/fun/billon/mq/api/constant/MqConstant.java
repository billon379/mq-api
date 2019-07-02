package fun.billon.mq.api.constant;

/**
 * MQ常量定义
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
public class MqConstant {

    /**
     * ====================im聊天消息常量======================
     */
    /**
     * im聊天消息exchange
     */
    public static final String MQ_IM_CHAT_EXCHANGE = "im.chat.direct";
    /**
     * im聊天消息routingKey
     */
    public static final String MQ_IM_CHAT_ROUTING_KEY = "im.chat";
    /**
     * im聊天消息动态queue前缀
     */
    public static final String MQ_IM_CHAT_DYNAMIC_QUEUE_PREFIX = "queue.dynamic.im.chat.";

    /**
     * ====================im事件消息常量======================
     */
    /**
     * im事件消息exchange
     */
    public static final String MQ_IM_EVENT_EXCHANGE = "im.event.direct";
    /**
     * im事件消息routingKey
     */
    public static final String MQ_IM_EVENT_ROUTING_KEY = "im.event";
    /**
     * im事件消息动态queue前缀
     */
    public static final String MQ_IM_EVENT_DYNAMIC_QUEUE_PREFIX = "queue.dynamic.im.event.";

}