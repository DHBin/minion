# 代码生成

目前代码依赖idea的插件`EasyCode`，导入一下模板

## 后端

### Entity

```
##导入宏定义
$!define

##保存文件（宏定义）
#save("/entity", ".java")

##包路径（宏定义）
#setPackageSuffix("entity")

##自动导入包（全局变量）
$!autoImport
import cn.dhbin.minion.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end 实体类
 * 
 * @author $author
 * @date $time.currTime()
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "$!tableInfo.obj.name")
public class $!{tableInfo.name} extends BaseEntity {

    private static final long serialVersionUID = $tool.serial();
    
#foreach($column in $tableInfo.pkColumn)

    /**
     * #if(${column.comment})${column.comment}#end
     
     */    
    @TableId(value = "$!column.obj.name", type = IdType.ASSIGN_ID)
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#break
#end

#foreach($column in $tableInfo.otherColumn)

    /**
     * #if(${column.comment})${column.comment}#end
     
     */    
    @TableField(value = "$!column.obj.name")
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end

}
```

### Mapper

```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("Mapper")

##保存文件（宏定义）
#save("/mapper", "Mapper.java")

##包路径（宏定义）
#setPackageSuffix("mapper")

import cn.dhbin.minion.core.mybatis.mapper.MinionMapper;
import $!{tableInfo.savePackageName}.entity.$!tableInfo.name;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end Mapper
 * 
 * @author $author
 * @date $time.currTime()
 */
public interface $!{tableName} extends MinionMapper<$!tableInfo.name> {

}
```

### mapper.xml

```
##引入mybatis支持
$!mybatisSupport

##设置保存名称与保存位置
$!callback.setFileName($tool.append($!{tableInfo.name}, "Mapper.xml"))
$!callback.setSavePath($tool.append($modulePath, "/src/main/resources/mapper"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="$!{tableInfo.savePackageName}.mapper.$!{tableInfo.name}Mapper">

    <resultMap type="$!{tableInfo.savePackageName}.entity.$!{tableInfo.name}" id="$!{tableInfo.name}Map">
#foreach($column in $tableInfo.fullColumn)
        <result property="$!column.name" column="$!column.obj.name" jdbcType="$!column.ext.jdbcType"/>
#end
    </resultMap>

</mapper>
```

### Service

```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("Service")

##保存文件（宏定义）
#save("/service", "Service.java")

##包路径（宏定义）
#setPackageSuffix("service")

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import $!{tableInfo.savePackageName}.entity.$!tableInfo.name;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end Service
 * 
 * @author $author
 * @date $time.currTime()
 */
public interface $!{tableName} extends IMinionService<$!tableInfo.name> {

}
```

### ServiceImpl

```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("ServiceImpl")

##保存文件（宏定义）
#save("/service/impl", "ServiceImpl.java")

##包路径（宏定义）
#setPackageSuffix("service.impl")

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import $!{tableInfo.savePackageName}.mapper.$!{tableInfo.name}Mapper;
import $!{tableInfo.savePackageName}.entity.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import org.springframework.stereotype.Service;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end ServiceImpl
 * 
 * @author $author
 * @date $time.currTime()
 */
@Service
public class $!{tableName} extends MinionServiceImpl<$!{tableInfo.name}Mapper, $!{tableInfo.name}> implements $!{tableInfo.name}Service {

}
```

### Controller

```
##导入宏定义
$!define
##设置表后缀（宏定义）
#setTableSuffix("Controller")
##保存文件（宏定义）
#save("/controller", "Controller.java")
##包路径（宏定义）
#setPackageSuffix("controller")
##定义服务名
#set($serviceName = $!tool.append($!tool.firstLowerCase($!tableInfo.name), "Service"))
##定义实体对象名
#set($entityName = $!tool.firstLowerCase($!tableInfo.name))
#if($tableInfo.comment)#set($comment = $tableInfo.comment)#else#set($comment = $tableInfo.name)#end

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import $!{tableInfo.savePackageName}.entity.$!tableInfo.name;
import $!{tableInfo.savePackageName}.model.dto.$!{tableInfo.name}Dto;
import $!{tableInfo.savePackageName}.model.param.$!{tableInfo.name}Param;
import $!{tableInfo.savePackageName}.model.query.$!{tableInfo.name}Query;
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end Controller
 * 
 * @author $author
 * @date $time.currTime()
 */
@RestController
@RequestMapping("$!tool.firstLowerCase($!tableInfo.name)")
@RequiredArgsConstructor
@Api(tags = "$comment")
public class $!{tableName} extends RestfulController {

    private final $!{tableInfo.name}Service $!{serviceName};

    /**
     * 分页获取
     */
    @GetMapping
    @ApiOperation(value = "分页获取$comment", authorizations = @Authorization("$!{tableInfo.obj.name}_page}"))
    public ApiResponse<?> page(PageModel<$!{tableInfo.name}> pageModel, $!{tableInfo.name}Query query) {
        IPage<$!{tableInfo.name}Dto> record = this.$serviceName
                .page(pageModel.convert(), Wrappers.lambdaQuery(query.convert($!{tableInfo.name}.class)))
                .convert($!{tool.firstLowerCase($!tableInfo.name)} -> ${tool.firstLowerCase($!tableInfo.name)}.convert($!{tableInfo.name}Dto.class));
        return ok(record);
    }

    /**
     * 新建
     */
    @PostMapping
    @ApiOperation(value = "新建$comment", authorizations = @Authorization("$!{tableInfo.obj.name}_create"))
    public ApiResponse<?> create(@Validated @RequestBody $!{tableInfo.name}Param param) {
        param.setId(null);
        this.${serviceName}.save(param.convert($!{tableInfo.name}.class));
        return created();
    }

    /**
     * 删除
     */
    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "删除$comment", authorizations = @Authorization("$!{tableInfo.obj.name}_delete"))
    public ApiResponse<?> delete(@PathVariable Long id) {
        this.${serviceName}.removeById(id);
        return noContent();
    }

    /**
     * 更新
     */
    @PutMapping
    @ApiOperation(value = "更新$comment", authorizations = @Authorization("$!{tableInfo.obj.name}_update"))
    public ApiResponse<?> update(@Validated @RequestBody $!{tableInfo.name}Param param) {
        this.${serviceName}.updateByIdAndReturn(param.convert($!{tableInfo.name}.class));
        return created();
    }



    /**
     * 通过id获取
     *
     * @param id 主键
     */
    @GetMapping("{id:\\d+}")
    @ApiOperation(value = "通过id获取$comment", authorizations = @Authorization("$!{tableInfo.obj.name}_retrieve"))
    public ApiResponse<?> retrieve(@PathVariable("id") Long id) {
        return ok(this.${serviceName}.getById(id));
    }

}


```

### Dto

```
##导入宏定义
$!define

##保存文件（宏定义）
#save("/model/dto", "Dto.java")

##包路径（宏定义）
#setPackageSuffix("model.dto")

##自动导入包（全局变量）
$!autoImport
import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end Dto
 * 
 * @author $author
 * @date $time.currTime()
 */
@Data
public class $!{tableInfo.name}Dto implements Convert {

    private static final long serialVersionUID = $tool.serial();

#foreach($column in $tableInfo.pkColumn)

    /**
     * #if(${column.comment})${column.comment}#end
     
     */    
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#break
#end

#foreach($column in $tableInfo.otherColumn)

    /**
     * #if(${column.comment})${column.comment}#end
     
     */    
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
}
```

### Param

```
##导入宏定义
$!define

##保存文件（宏定义）
#save("/model/param", "Param.java")

##包路径（宏定义）
#setPackageSuffix("model.param")

##自动导入包（全局变量）
$!autoImport
import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end Param
 * 
 * @author $author
 * @date $time.currTime()
 */
@Data
public class $!{tableInfo.name}Param implements Convert {

    private static final long serialVersionUID = $tool.serial();

#foreach($column in $tableInfo.pkColumn)

    /**
     * #if(${column.comment})${column.comment}#end
     
     */    
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#break
#end

#foreach($column in $tableInfo.otherColumn)

    /**
     * #if(${column.comment})${column.comment}#end
     
     */    
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
}

```

### Query

```
##导入宏定义
$!define

##保存文件（宏定义）
#save("/model/query", "Query.java")

##包路径（宏定义）
#setPackageSuffix("model.query")

##自动导入包（全局变量）
$!autoImport
import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;

/**
 * #if($tableInfo.comment) ($tableInfo.comment)#else $tableInfo.name#end Query
 * 
 * @author $author
 * @date $time.currTime()
 */
@Data
public class $!{tableInfo.name}Query implements Convert {

    private static final long serialVersionUID = $tool.serial();

}

```



