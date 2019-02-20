package com.sdxmxy.bookmanage.entity.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("broTime", new Date(), metaObject);
        this.setFieldValByName("rnTime", new Date(), metaObject);
        this.setFieldValByName("stuDetele", false, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("rnTime", new Date(), metaObject);
    }
}
