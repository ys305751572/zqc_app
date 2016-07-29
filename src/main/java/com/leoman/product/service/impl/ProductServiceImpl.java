package com.leoman.product.service.impl;

import com.leoman.common.exception.GeneralExceptionHandler;
import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.product.dao.ProductDao;
import com.leoman.product.dao.ProductExchangeRecordDao;
import com.leoman.product.entity.Product;
import com.leoman.product.entity.ProductExchangeRecord;
import com.leoman.product.service.ProductExchangeRecordService;
import com.leoman.product.service.ProductService;
import com.leoman.team.dao.TeamDao;
import com.leoman.team.entity.Team;
import com.leoman.user.dao.UserInfoDao;
import com.leoman.user.entity.UserInfo;
import com.leoman.utils.SeqNoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by Daisy on 2016/7/28.
 */
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl extends GenericManagerImpl<Product,ProductDao> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private ProductExchangeRecordService exchangeRecordService;

    @Override
    public Page<Product> findAll(Integer currentPage, Integer pageSize){
        return productDao.findAll(new PageRequest(currentPage-1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public void exchange(Integer joinType, Long productId, Long joinId, Integer days){
        Product product = productDao.findOne(productId);
        if(product == null){
            GeneralExceptionHandler.handle("该商品不存在");
        }

        //初始化商品兑换记录值
        ProductExchangeRecord per = new ProductExchangeRecord();
        per.setJoinId(joinId);
        per.setProduct_name(product.getName());
        per.setProduct_type(product.getType());
        per.setYm(product.getYm());

        //如果是个人
        if(joinType.equals(0)){
            UserInfo user = userInfoDao.findOne(joinId);
            if(user == null){
                GeneralExceptionHandler.handle("该用户不存在");
            }
            if(product.getYm() > user.getYm()){
                GeneralExceptionHandler.handle("该用户的益米数不够，不足以兑换该商品");
            }
            //新增兑换记录
            per.setName(user.getMobile());
            per.setNickname(user.getNickname());
        }

        //获取兑换商品的类型
        Integer productType = product.getType();
        //实物
        if(productType.equals(0)){
            //如果是团队
            if(joinType.equals(1)){
                Team team = teamDao.findOne(joinId);
                if(team == null){
                    GeneralExceptionHandler.handle("该团队不存在");
                }
                if(product.getYm() > team.getYm()){
                    GeneralExceptionHandler.handle("该团队的益米数不够，不足以兑换该商品");
                }
                //新增兑换记录
                per.setName(team.getName());
                per.setNickname(team.getName());
            }

            per.setJoinType(joinType);
            per.setProduct_type_name("实物");
            per.setStatus(1);//成功
            per.setIntegral(0);
            per.setCode(SeqNoUtils.getCouponCode(0,16));//兑换码
        }
        //众筹
        else if(productType.equals(1)){
            if(product.getBuyNum() >= product.getNums()){
                GeneralExceptionHandler.handle("众筹人数已达到，无需兑换");
            }
            per.setJoinType(0);
            per.setStatus(1);
            per.setIntegral(0);
            per.setProduct_type_name("众筹");
        }
        //banner广告位
        else if(productType.equals(2)){
            per.setDays(days);
            per.setStatus(0);//未处理
        }

        //新增兑换记录
        exchangeRecordService.create(per);
    }

}
