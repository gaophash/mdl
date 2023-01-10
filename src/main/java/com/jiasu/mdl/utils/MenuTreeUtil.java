package com.jiasu.mdl.utils;

import com.jiasu.mdl.entity.MenuTree;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.utils
 * @Description: 菜单树形构建
 * @date 2023/1/10 10:26
 */
public class MenuTreeUtil {
    /**
     * 所有的菜单数据
     */
    private List<MenuTree> menuList = new ArrayList<MenuTree>();

    public MenuTreeUtil(List<MenuTree> menuList) {
        this.menuList = menuList;
    }

    /**
     * 建立树形结构
     *
     * @return
     */
    public List<MenuTree> buildTree() {
        List<MenuTree> treeMenus = new ArrayList<MenuTree>();
        for (MenuTree menuNode : getRootNode()) {
            menuNode = buildChildTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    /**
     * 递归，建立子树形结构
     *
     * @param pNode
     * @return
     */
    private MenuTree buildChildTree(MenuTree pNode) {
        List<MenuTree> childMenus = new ArrayList<MenuTree>();
        for (MenuTree menuNode : menuList) {
            if (menuNode.getParentId().equals(pNode.getMenuId())) {
                childMenus.add(buildChildTree(menuNode));
            }
        }
        pNode.setChildren(childMenus);
        return pNode;
    }

    /**
     * 获取根节点
     *
     * @return
     */
    private List<MenuTree> getRootNode() {
        List<MenuTree> rootMenuLists = new ArrayList<MenuTree>();
        for (MenuTree menuNode : menuList) {
            if (menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

}
