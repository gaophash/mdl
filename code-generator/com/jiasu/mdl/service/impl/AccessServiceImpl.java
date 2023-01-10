package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.Access;
import com.jiasu.mdl.mapper.AccessMapper;
import com.jiasu.mdl.service.IAccessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员权限表 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class AccessServiceImpl extends ServiceImpl<AccessMapper, Access> implements IAccessService {

}
