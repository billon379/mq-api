package fun.billon.mq.api.producer;

import com.alibaba.fastjson.JSON;
import fun.billon.mq.api.constant.MqConstant;
import fun.billon.mq.api.message.ImEventMessage;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * im事件消息生产者
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ImEventMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean(name = MqConstant.MQ_IM_EVENT_EXCHANGE)
    public DirectExchange exchange() {
        return new DirectExchange(MqConstant.MQ_IM_EVENT_EXCHANGE);
    }

    /**
     * im事件消息
     *
     * @param imEventMessage imEventMessage.type  事件类型(1:群组更新;2:群组解散;3:移除用户;4:用户加入;5:用户离开;6:用户更新)
     *                       imEventMessage.groupId  群组id
     *                       imEventMessage.uid  群组用户uid
     *                       imEventMessage.targetUids 要通知的目标用户列表,群组解散消息需要使用该字段,因为群组已经解散,消费方无法根据群组获取用户
     *                       imEventMessage.time 事件产生时间
     */
    public void produce(ImEventMessage imEventMessage) {
        this.rabbitTemplate.convertAndSend(MqConstant.MQ_IM_EVENT_EXCHANGE, MqConstant.MQ_IM_EVENT_ROUTING_KEY,
                JSON.toJSONString(imEventMessage));
    }

}