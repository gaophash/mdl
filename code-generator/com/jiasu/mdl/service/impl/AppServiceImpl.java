package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.App;
import com.jiasu.mdl.mapper.AppMapper;
import com.jiasu.mdl.service.IAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements IAppService {

}
