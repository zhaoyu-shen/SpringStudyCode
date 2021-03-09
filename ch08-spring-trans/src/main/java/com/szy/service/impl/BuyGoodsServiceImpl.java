package com.szy.service.impl;

import com.szy.dao.GoodsDao;
import com.szy.dao.SaleDao;
import com.szy.domain.Goods;
import com.szy.domain.Sale;
import com.szy.excep.NotEnoughException;
import com.szy.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;


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
