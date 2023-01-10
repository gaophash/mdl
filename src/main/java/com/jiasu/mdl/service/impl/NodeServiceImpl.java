package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.auth.utils.SessionUtil;
import com.jiasu.mdl.entity.Node;
import com.jiasu.mdl.mapper.NodeMapper;
import com.jiasu.mdl.entity.MenuTree;
import com.jiasu.mdl.service.INodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiasu.mdl.utils.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    @Autowired
    SessionUtil sessionUtil;
    @Autowired
    NodeMapper nodeMapper;

    @Override
    public List<MenuTree> findMenus() {
        List<String> authoritys = sessionUtil.getAuthoritys();
        List<Integer> authorityList = new LinkedList<>();
        authoritys.forEach(e -> {
            authorityList.add(Integer.valueOf(e));
        });
        List<Node> nodes = nodeMapper.selectBatchIds(authorityList);
        List<MenuTree> menuList = new ArrayList<MenuTree>();
        nodes.forEach(node -> {
            MenuTree menuTree = new MenuTree(String.valueOf(node.getId()), String.valueOf(node.getPid()), node.getTitle(), node.getName(), node.getIcon(), node.getListorder(), node.getShow());
            menuList.add(menuTree);
        });
        MenuTreeUtil menuTreeUtil = new MenuTreeUtil(menuList);
        List<MenuTree> menuTrees = menuTreeUtil.buildTree();
        return menuTrees;
    }

}