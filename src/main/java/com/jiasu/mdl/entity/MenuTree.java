package com.jiasu.mdl.entity;

import lombok.Data;

import java.util.List;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.model
 * @Description:
 * @date 2023/1/10 10:28
 */
@Data
public class MenuTree {
    private String menuId;
    private String parentId;
    private String menuDescribe;
    private String name;
    private String icon;
    private Integer listorder;
    private Integer show;
    private List<MenuTree> children;

    public MenuTree(String menuId, String parentId, String menuDescribe, String name, String icon, Integer listorder, Integer show) {
        this.menuId = menuId;
        this.parentId = parentId;
        this.menuDescribe = menuDescribe;
        this.name = name;
        this.icon = icon;
        this.listorder = listorder;
        this.show = show;
    }
}
