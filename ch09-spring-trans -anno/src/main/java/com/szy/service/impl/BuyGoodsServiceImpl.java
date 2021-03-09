package com.szy.service.impl;

import com.szy.dao.GoodsDao;
import com.szy.dao.SaleDao;
import com.szy.domain.Goods;
import com.szy.domain.Sale;
import com.szy.excep.NotEnoughException;
import com.szy.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /*
    * rollbackFor:发生指定异常一定回滚
    *   处理逻辑是：
    *       1）spring 框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中
    *           如果异常在rollbackGor列表中，不管是什么类型的异常，一定回滚
    *       2）如果你抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException
    *           如果是，一定会回滚
    * */
    /*@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )*/
    //使用事务控制的默认值，默认传播行为REQUIRED，默认隔离界别DEFAULT
    //默认回滚异常RuntimeException
    @Transactional
    @Override
    public void buy(Integer goodsid, Integer nums) {
        System.out.println("======buy方法开始======");
        //记录销售信息，向sale添加记录
        Sale sale=new Sale();
        sale.setGid(goodsid);
        sale.setNums(nums);
        saleDao.insertSale(sale);


        /*更新库存*/
        Goods goods=goodsDao.selectGoods(goodsid);
        if (goods==null){
            //商品不存在
            throw new NullPointerException("编号是"+goodsid+"商品不存在");
        }else if(goods.getAmount()<nums){
            //商品库存不足
            throw new NotEnoughException("编号是"+goodsid+"商品库存不足");
        }else {
            Goods buyGoods=new Goods();
            buyGoods.setId(goodsid);
            buyGoods.setAmount(nums);
            goodsDao.updateGoods(buyGoods);
        }

        System.out.println("======buy方法完成======");
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
