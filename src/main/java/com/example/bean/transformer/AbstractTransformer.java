package com.example.bean.transformer;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTransformer<BEAN, MODEL extends Serializable> implements Transformer<BEAN, MODEL> {

    public List<BEAN> transformToBeans(List<MODEL> models){
        return models.stream().map(this::transformToBean).collect(Collectors.toList());
    }

    public List<MODEL> transformFromBeans(List<BEAN> beans){
        return beans.stream().map(this::transformFromBean).collect(Collectors.toList());
    }
}
