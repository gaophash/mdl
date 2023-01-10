package com.jiasu.mdl.service;

import com.jiasu.mdl.entity.Node;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiasu.mdl.entity.MenuTree;

import java.util.List;

/**
 * <p>
 * 权限节点 服务类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
public interface INodeService extends IService<Node> {

    public List<MenuTree> findMenus();

}
