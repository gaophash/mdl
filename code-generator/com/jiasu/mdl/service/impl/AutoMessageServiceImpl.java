package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.AutoMessage;
import com.jiasu.mdl.mapper.AutoMessageMapper;
import com.jiasu.mdl.service.IAutoMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自动过卡消息推送 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class AutoMessageServiceImpl extends ServiceImpl<AutoMessageMapper, AutoMessage> implements IAutoMessageService {

}
