package com.leoman.product.api;

import com.leoman.common.controller.common.CommonController;
import com.leoman.common.core.Configue;
import com.leoman.common.entity.PageVO;
import com.leoman.enums.ErrorType;
import com.leoman.product.entity.Product;
import com.leoman.product.entity.ProductExchangeRecord;
import com.leoman.product.service.ProductExchangeRecordService;
import com.leoman.product.service.ProductService;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.Result;
import com.leoman.utils.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @Autowired
    private ProductExchangeRecordService exchangeRecordService;


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
            if(!StringUtils.isEmpty(product.getCoverUrl())){
                product.setCoverUrl(Configue.getUploadUrl()+product.getCoverUrl());
            }
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
     *
     * @apiSuccess {object}  ads 广告位规格
     * @apiSuccess {object}  ads.days  周期天数
     * @apiSuccess {object}  ads.ym  周期对应益米
     */
    @RequestMapping("detail")
    public void detail(HttpServletRequest request,
                     HttpServletResponse response,
                       @RequestParam(required=true) Long productId) throws Exception {

        Product product = productService.queryByPK(productId);
        if(!StringUtils.isEmpty(product.getDetailImageUrl())){
            product.setCoverUrl(Configue.getUploadUrl()+product.getDetailImageUrl());
        }
        WebUtil.printJson(response,new Result().success(createMap("product",product)));
    }

    /**
     * @api {post} /api/product/exchange  03、商品兑换
     * @apiVersion 0.0.1
     * @apiName product.exchange
     * @apiGroup product
     * @apiDescription 商品兑换
     *
     * @apiParam {NUMBER} joinType 兑换人类型：0-个人，1-团队
     * @apiParam {NUMBER} joinId 用户id或团队id
     * @apiParam {NUMBER} productId 商品id
     * @apiParam {NUMBER} days 天数
     */
    @RequestMapping("exchange")
    public void exchange(HttpServletRequest request,
                       HttpServletResponse response,
                         @RequestParam(required=true) Integer joinType,
                       @RequestParam(required=true) Long productId,
                         @RequestParam(required=true) Long joinId,
                         Integer days) throws Exception {

        if(!joinType.equals(0) && !joinType.equals(1)){
            WebUtil.printJson(response,new Result(ErrorType.ERROR_CODE_1001));//joinType参数值不正确
        }
        productService.exchange(joinType, productId, joinId, days);
        WebUtil.printJson(response,new Result().success());
    }

    /**
     * @api {post} /api/product/wish  04、获取许愿池详情
     * @apiVersion 0.0.1
     * @apiName product.wish
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
     *
     * @apiSuccess {object}  ads 广告位规格
     * @apiSuccess {object}  ads.days  周期天数
     * @apiSuccess {object}  ads.ym  周期对应益米
     */
    @RequestMapping("wish")
    public void wish(HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        Product product = productService.findWishWell();
        if(!StringUtils.isEmpty(product.getDetailImageUrl())){
            product.setCoverUrl(Configue.getUploadUrl()+product.getDetailImageUrl());
        }
        WebUtil.printJson(response,new Result().success(createMap("product",product)));
    }

    /**
     * @api {post} /api/product/wish/userList  05、获取许愿池的所有众筹用户
     * @apiVersion 0.0.1
     * @apiName product.wishUsers
     * @apiGroup product
     * @apiDescription 获取许愿池的所有众筹用户
     *
     * @apiParam {NUMBER} productId 商品id
     *
     * @apiSuccess {Object}   user  用户对象
     * @apiSuccess {NUMBER}   user.id 用户id
     * @apiSuccess {String}   user.mobile 手机号
     * @apiSuccess {String}   user.nickname 昵称
     * @apiSuccess {NUMBER}   user.gender 性别 男-0，女-1
     * @apiSuccess {String}   user.avater 头像
     * @apiSuccess {String}   user.status 状态 0:正常 1:冻结
     * @apiSuccess {String}   user.level 会员等级
     * @apiSuccess {String}   user.integral 积分
     * @apiSuccess {String}   user.ym 益米
     * @apiSuccess {String}   user.IDCard 身份证号
     * @apiSuccess {String}   user.sign index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数
     */
    @RequestMapping("wish/userList")
    public void wishUsers(HttpServletRequest request,
                     HttpServletResponse response,
                          @RequestParam(required=true) Long productId,
                          @RequestParam(required=true) Integer pageNum,
                          @RequestParam(required=true) Integer pageSize) throws Exception {

        Page<UserInfo> page = exchangeRecordService.findByProductId(productId,pageNum,pageSize);
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }

    /**
     * @api {post} /api/product/exchange/codeList  06、查询兑换码
     * @apiVersion 0.0.1
     * @apiName product.codeList
     * @apiGroup product
     * @apiDescription 查询兑换码
     *
     * @apiParam {NUMBER} type 类型：0-个人，1-团队
     * @apiParam {NUMBER} joinId 用户id或团队id
     * @apiParam {NUMBER} pageNum 页码
     * @apiParam {NUMBER} pageSize 每页请求数
     *
     * @apiSuccess {NUMBER} joinType 类型：0-个人，1-团队
     * @apiSuccess {NUMBER} joinId 用户id或团队id
     * @apiSuccess {String} name 手机/团体名称
     * @apiSuccess {String} nickname 昵称
     * @apiSuccess {String} productName 商品名称
     * @apiSuccess {NUMBER} productType 商品类型0:实物 1:众筹 2:广告位
     * @apiSuccess {NUMBER} ym 所需益米
     * @apiSuccess {String} code 兑换码
     * @apiSuccess {NUMBER} validStartDate 开始有效期 type = 0
     * @apiSuccess {NUMBER} validEndDate 结束有效期 type = 0
     * @apiSuccess {String} address 兑换地址 type = 0
     * @apiSuccess {NUMBER} isExchange 是否已兑换（0-否，1-是）
     */
    @RequestMapping("exchange/codeList")
    public void codeList(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam(required=true) Long userId,
                          @RequestParam(required=true) Integer pageNum,
                          @RequestParam(required=true) Integer pageSize) throws Exception {

        Page<ProductExchangeRecord> page = exchangeRecordService.findCodes(userId,pageNum,pageSize);
        WebUtil.printJson(response,new Result().success(new PageVO(page)));
    }

}
