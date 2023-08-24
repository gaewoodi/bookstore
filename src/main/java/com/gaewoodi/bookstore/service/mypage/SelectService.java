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

    public String getPurchaseListCheckboxResult(String result, int regId, PurchaseDto purchaseDto) {

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
            purchaseMapper.savePurchaseList(purchaseDto);

        }



        return "";

    }

    public String getPurchaseDeleteCheckboxResult(String result, int regId, PurchaseDto purchaseDto) {

        purchaseDto.setRegId(regId);
        System.out.println("서비스에서 result: " + result);

        String deleteQuery = "";

        String[] splitResult = result.toString().split(" ");

        for(int i = 0; i < splitResult.length; i++) {
            if(i == 0) {
                purchaseDto.setBookId(Integer.parseInt(splitResult[0]));
                deleteQuery = splitResult[0];
                purchaseMapper.deletePurchase(regId, deleteQuery);
            } else if(i == 1) {
                purchaseDto.setBookId(Integer.parseInt(splitResult[1]));
                deleteQuery = splitResult[1];
                purchaseMapper.deletePurchase(regId, deleteQuery);
            } else if(i == 2) {
                purchaseDto.setBookId(Integer.parseInt(splitResult[2]));
                deleteQuery = splitResult[2];
                purchaseMapper.deletePurchase(regId, deleteQuery);
            }

        }



        return "";

    }

}
