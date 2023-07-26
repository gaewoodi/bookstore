package com.gaewoodi.bookstore.controller.purchase;

import com.gaewoodi.bookstore.mappers.purchase.PurchaseMapper;
import com.gaewoodi.bookstore.service.purchase.PagingService;
import com.siot.IamportRestClient.IamportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private PagingService pagingService;

    @GetMapping("")
    public String getPurchase() {
        return "purchase/purchase";
    }

    @PostMapping("/kakaopay")
    @ResponseBody
    public String getKakaopay() {
        try {
            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "KakaoAK 5c1eee7537b299534e582bd21b1e2bb8");
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            // 커넥션 input output 전해줄게 있는지 없는지
            connection.setDoOutput(true);

            String payData = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=2200&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8888/purchase/kakaopay&fail_url=http://localhost:8888/purchase&cancel_url=http://localhost:8888/purchase";
            OutputStream outputStream = connection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(payData);
            dataOutputStream.close();

            int resultCode = connection.getResponseCode();

            InputStream inputStream;

            if (resultCode == 200) {
                inputStream = connection.getInputStream();
            } else {
                inputStream = connection.getErrorStream();
            }

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // 형변환 해줌
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "{\"result\":\"NO\"}";
    }


    @GetMapping("/list")
    public String getPurchaseList(Model model) {

        return "purchase/purchase_list";
    }

    @GetMapping("/delete")
    public String getPurchaseDelete() {
        return "purchase/purchase_delete";
    }
}

