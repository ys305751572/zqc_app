package com.leoman.product.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.common.entity.PageVO;
import com.leoman.product.entity.Product;
import com.leoman.product.service.ProductService;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商品
 * Created by Daisy on 2016/7/28.
 */
@Controller
@RequestMapping("/api/product")
public class ProductApi extends CommonController{

    private static Logger logger = LoggerFactory.getLogger(ProductApi.class);

    @Autowired
    private ProductService productService;


    /**
     * @api {post} /api/product/list  01、获取商品列表
     * @apiVersion 0.0.1
     * @apiName product.list
     * @apiGroup product
     * @apiDescription 获取商品列表
     *
     * @apiParam {NUMBER} pageNum 页码
     * @apiParam {NUMBER} pageSize 每页请求数
     *
     * @apiSuccess {NUMBER}  id 商品id
     * @apiSuccess {NUMBER}  type 商品类型 0:实物 1:众筹 2:广告位
     * @apiSuccess {String}  name 商品名称
     * @apiSuccess {String}  coverUrl 封面图片
     * @apiSuccess {String}  shortDesc 简短描述
     * @apiSuccess {NUMBER}  ym 所需益米（type=1时，表示单人所需益米）
     * @apiSuccess {NUMBER}  nums type = 1时所需人数
     * @apiSuccess {NUMBER}  buyNum type = 1时已经众筹人数
     * @apiSuccess {NUMBER}  validStartDate 开始有效期 type = 0
     * @apiSuccess {NUMBER}  validEndDate 结束有效期 type = 0
     * @apiSuccess {String}  address 兑换地址 type = 0
     */
    @RequestMapping("list")
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required=true) Integer pageNum,
                     @RequestParam(required=true) Integer pageSize) throws Exception {
        Page<Product> page = productService.findAll(pageNum, pageSize);
        for (Product product:page.getContent()) {
            product.setCoverUrl(Configue.getUploadUrl()+product.getCoverUrl());
        }
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }


    /**
     * @api {post} /api/product/detail  02、获取商品详情
     * @apiVersion 0.0.1
     * @apiName product.detail
     * @apiGroup product
     * @apiDescription 获取商品详情
     *
     * @apiParam {NUMBER} productId 商品id
     *
     * @apiSuccess {NUMBER}  id 商品id
     * @apiSuccess {NUMBER}  type 商品类型 0:实物 1:众筹 2:广告位
     * @apiSuccess {String}  name 商品名称
     * @apiSuccess {String}  coverUrl 封面图片
     * @apiSuccess {String}  detailImageUrl 详情图片
     * @apiSuccess {String}  shortDesc 简短描述
     * @apiSuccess {NUMBER}  ym 所需益米（type=1时，表示单人所需益米）
     * @apiSuccess {NUMBER}  nums type = 1时所需人数
     * @apiSuccess {NUMBER}  buyNum type = 1时已经众筹人数
     * @apiSuccess {NUMBER}  validStartDate 开始有效期 type = 0
     * @apiSuccess {NUMBER}  validEndDate 结束有效期 type = 0
     * @apiSuccess {String}  address 兑换地址 type = 0
     */
    @RequestMapping("detail")
    public void detail(HttpServletRequest request,
                     HttpServletResponse response,
                       @RequestParam(required=true) Long productId,
                       Long joinId) throws Exception {

        Product product = productService.queryByPK(productId);
        WebUtil.printJson(response,new Result().success(createMap("product",product)));
    }

}
