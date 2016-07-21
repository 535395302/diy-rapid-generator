package ${basePkg}.${business}.${task};

import com.ewandian.b2b2c.gl.arap.builder.IArApBuilder;
import com.ewandian.b2b2c.gl.arap.domain.po.base.ApMaster;
import com.ewandian.b2b2c.gl.arap.service.simple.IApMasterService;
import com.ewandian.platform.common.BusinessException;

/**
 * <b>${desc}</b> 构造器<br/>
 * @author Tian
 * @version 1.0
 * @date ${now?string("yyyy-MM-dd")}
 */
public class ${business?cap_first}${task?cap_first}Builder implements IArApBuilder<${entityType},${paramType}> {
    private static final Logger logger = LoggerFactory.getLogger(${business?cap_first}${task?cap_first}Builder.class);

    @Override
    public ${entityType} build(${paramType} param) throws BusinessException {
        return null;
    }
}
