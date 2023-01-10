package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.ContainerVerificationInformation;
import com.jiasu.mdl.mapper.ContainerVerificationInformationMapper;
import com.jiasu.mdl.service.IContainerVerificationInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 集装箱验证信息 （过地磅时生成，java验证使用） 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class ContainerVerificationInformationServiceImpl extends ServiceImpl<ContainerVerificationInformationMapper, ContainerVerificationInformation> implements IContainerVerificationInformationService {

}
