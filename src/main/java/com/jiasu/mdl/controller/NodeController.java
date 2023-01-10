package com.jiasu.mdl.controller;


import com.jiasu.mdl.entity.Response;
import com.jiasu.mdl.service.INodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 权限节点 前端控制器
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@RestController
@RequestMapping("/node")
@Api(tags = "菜单管理")
public class NodeController {

    @Autowired
    INodeService iNodeService;

    @GetMapping("/getMenusTree")
    @ApiOperation(value = "获取树形菜单", tags = "菜单管理")
    public Response getMenusTree() {
        return Response.ok(iNodeService.findMenus());
    }

}

