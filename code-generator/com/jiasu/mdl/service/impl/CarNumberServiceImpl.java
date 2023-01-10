package com.jiasu.mdl.service.impl;

import com.jiasu.mdl.entity.CarNumber;
import com.jiasu.mdl.mapper.CarNumberMapper;
import com.jiasu.mdl.service.ICarNumberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 排号 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class CarNumberServiceImpl extends ServiceImpl<CarNumberMapper, CarNumber> implements ICarNumberService {

}
