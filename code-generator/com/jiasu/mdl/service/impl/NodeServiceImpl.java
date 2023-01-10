package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.Node;
import com.jiasu.mdl.mapper.NodeMapper;
import com.jiasu.mdl.service.INodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限节点 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements INodeService {

}
