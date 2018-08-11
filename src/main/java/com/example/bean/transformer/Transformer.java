package com.example.bean.transformer;

import java.io.Serializable;

public interface Transformer <BEAN, MODEL extends Serializable>{
    BEAN transformToBean(MODEL model);
    MODEL transformFromBean(BEAN bean);
}
