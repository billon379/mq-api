package fun.billon.mq.api.producer;

import com.alibaba.fastjson.JSON;
import fun.billon.mq.api.constant.MqConstant;
import fun.billon.mq.api.message.ImChatMessage;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * im聊天消息生产者
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ImChatMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean(name = MqConstant.MQ_IM_CHAT_EXCHANGE)
    public DirectExchange exchange() {
        return new DirectExchange(MqConstant.MQ_IM_CHAT_EXCHANGE);
    }

    /**
     * im聊天消息
     *
     * @param imChatMessage imChatMessage.sender  消息发送者
     *                      imChatMessage.groupId 群组id
     *                      imChatMessage.type  消息类型(1:文本消息;2:图片消息;3:音频消息;4:视频消息)
     *                      imChatMessage.content  消息正文
     *                      imChatMessage.attachment  消息附件
     *                      imChatMessage.time 消息发送时间
     */
    public void produce(ImChatMessage imChatMessage) {
        this.rabbitTemplate.convertAndSend(MqConstant.MQ_IM_CHAT_EXCHANGE, MqConstant.MQ_IM_CHAT_ROUTING_KEY,
                JSON.toJSONString(imChatMessage));
    }

}