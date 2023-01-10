package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.AdminLoginLog;
import com.jiasu.mdl.mapper.AdminLoginLogMapper;
import com.jiasu.mdl.service.IAdminLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员登录日志表 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class AdminLoginLogServiceImpl extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog> implements IAdminLoginLogService {

}
