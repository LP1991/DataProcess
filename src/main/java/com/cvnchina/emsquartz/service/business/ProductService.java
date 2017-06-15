/********************** 版权声明 *************************
 * 文件名: ProductService.java
 * 包名: com.cvnchina.emsquartz.service.business
 * 版权:	杭州华量软件  EMSQuartz
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2017/6/15
 * 文件版本：V1.0
 *
 *******************************************************/
package com.cvnchina.emsquartz.service.business;

import com.cvnchina.emsquartz.dataaccess.ProductMapper;
import com.cvnchina.emsquartz.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<Object> list(Product params){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(params);
            Map<String,Object> p = mapper.readValue(json,Map.class);
            return productMapper.queryAll(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
