package com.gaewoodi.bookstore.service.mypage;

import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SelectService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private PurchaseMapper purchaseMapper;

    public String getCartCheckboxResult(String result, int regId, CartDto cartDto) {

        cartDto.setRegId(regId);

        String[] splitResult = result.toString().split(" ");

        for(int i = 0; i < splitResult.length; i++) {
            if(i == 0) {
                cartDto.setBookId(Integer.parseInt(splitResult[0]));
            } else if(i == 1) {
                cartDto.setBookId(Integer.parseInt(splitResult[1]));
            } else if(i == 2) {
                cartDto.setBookId(Integer.parseInt(splitResult[2]));
            }
            cartMapper.saveCart(cartDto);

        }



        return "";

    }

    public String getPurchaseCheckboxResult(String result, int regId, PurchaseDto purchaseDto) {

        purchaseDto.setRegId(regId);

        String[] splitResult = result.toString().split(" ");

        for(int i = 0; i < splitResult.length; i++) {
            if(i == 0) {
                purchaseDto.setBookId(Integer.parseInt(splitResult[0]));
            } else if(i == 1) {
                purchaseDto.setBookId(Integer.parseInt(splitResult[1]));
            } else if(i == 2) {
                purchaseDto.setBookId(Integer.parseInt(splitResult[2]));
            }
            purchaseMapper.savePurchase(purchaseDto);


        }



        return "";

    }

}
