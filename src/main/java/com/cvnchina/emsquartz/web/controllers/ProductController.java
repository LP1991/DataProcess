/********************** 版权声明 *************************
 * 文件名: ProductController.java
 * 包名: com.cvnchina.emsquartz.web.controllers
 * 版权:	杭州华量软件  EMSQuartz
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2017/6/15
 * 文件版本：V1.0
 *
 *******************************************************/
package com.cvnchina.emsquartz.web.controllers;

import com.cvnchina.emsquartz.domain.Product;
import com.cvnchina.emsquartz.service.business.NeService;
import com.cvnchina.emsquartz.service.business.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public void list(Product product , Model model){
        List<Object> list= productService.list(product);
        model.addAttribute("data",list);
        model.addAttribute("iTotalRecords",19);
        model.addAttribute("draw",1);
        model.addAttribute("iTotalDisplayRecords",17);
        model.addAttribute("success","success");
    }
}
