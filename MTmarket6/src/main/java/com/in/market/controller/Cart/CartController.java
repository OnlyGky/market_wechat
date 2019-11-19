package com.in.market.controller.cart;




import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.market.dto.UserAndGoods;
import com.in.market.pojo.cart.Cart;
import com.in.market.service.cart.CartService;
import com.in.market.util.ResultList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/cart")
@Controller
public class CartController {

    @Autowired
    @Qualifier("cartForRedisServiceImpl")
    private CartService cartService = null;

    @Autowired
    private ObjectMapper objectMapper = null;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 将商品加入到购物车
     * */
    @PostMapping(value = "/add")
    public ResponseEntity<Void> addGoodsToCart(@RequestBody String jsonData){
        try{
            logger.info(jsonData);
            this.cartService.saveGoodsToCart(jsonData);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
     //  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 修改商品购买个数
     * */
    @PutMapping(value = "/update")
    public ResponseEntity<Void> updateGoodsNumForCart(@RequestBody String jsonData){
        try{
            UserAndGoods userAndGoods = objectMapper.readValue(jsonData, UserAndGoods.class);
            this.cartService.updateRedisCart(userAndGoods);
        //204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 从购物车删除商品
     * */

    @DeleteMapping(value = "/delete/{goodsId}/{userId}")
    public ResponseEntity<Void> deleteGoodsFromCart(@PathVariable(value = "goodsId")Integer goodsId,
                                                    @PathVariable(value = "userId")Integer userId){
        try{
            this.cartService.deleteGoodsForRedisCart(userId, goodsId);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 通过userId查询购物车
     * */
    @GetMapping(value = "/{cartUser}/query")
    public ResponseEntity<Map<Object,Object>> queryCarts(@PathVariable(value = "cartUser") Integer cartUser){
        try{
//            List<Cart> carts = this.cartService.queryByUserId(cartUser);
//            ResultList resultList = new ResultList(carts.size(),carts);

            return ResponseEntity.ok(cartService.queryByUserIdForMap(cartUser));
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



}
