package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysApi;
import cn.dhbin.minion.upms.mapper.SysApiMapper;
import cn.dhbin.minion.upms.service.SysApiService;
import org.springframework.stereotype.Service;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysApiServiceImpl extends MinionServiceImpl<SysApiMapper, SysApi> implements SysApiService {

}
