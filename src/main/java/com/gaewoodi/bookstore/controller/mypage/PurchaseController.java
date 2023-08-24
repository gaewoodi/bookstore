package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import com.gaewoodi.bookstore.mappers.mypage.PurchaseMapper;
import com.gaewoodi.bookstore.service.mypage.PagingService;
import com.gaewoodi.bookstore.service.mypage.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private PagingService pagingService;

    @Autowired
    private MypageMapper mypageMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private SelectService selectService;


    @GetMapping("")
    public String getPurchase(@RequestParam int regId, Model model) {
        model.addAttribute("count", cartMapper.getCartCount(regId));
        model.addAttribute("user", mypageMapper.getMypageId(regId));
        model.addAttribute("book", purchaseMapper.getPurchaseBook(regId));

        return "mypage/purchase";
    }

    @PostMapping("")
    @ResponseBody
    public Map<String, Object> setPurchase(@RequestParam(value = "checkboxResult") String result,
                              @RequestParam(value = "regIdValue") String regId,
                              @RequestParam(value = "checkArray") String checkArray) {
        Map<String, Object> map = new HashMap<>();


        map.put("msg", "success");

        return map;
    }

    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> savePurchase(@RequestParam(value = "checkboxResult") String result,
                                         @RequestParam(value = "regIdValue") int regId,
                                         @ModelAttribute PurchaseDto purchaseDto) {
        Map<String, Object> map = new HashMap<>();
        selectService.getPurchaseCheckboxResult(result, regId, purchaseDto);

        map.put("msg", "success");
        return map;
    }



    @PostMapping("/kakaopay")
    @ResponseBody
    public String getKakaopay(@RequestParam(value = "regIdValue") int regId) {
        try {
            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "KakaoAK 5c1eee7537b299534e582bd21b1e2bb8");
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            // 커넥션 input output 전해줄게 있는지 없는지
            connection.setDoOutput(true);

            String payData = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=2200&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8888/purchase/kakaopay&fail_url=http://localhost:8888/purchase&cancel_url=http://localhost:8888/purchase?regId="+regId;
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

        return "mypage/purchase_list";
    }

    //삭제 목록을 보여주는 페이지
    @GetMapping("/delete")
    public String getPurchaseDelete() {
        return "mypage/purchase_delete";
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> getPurchaseDelete(@RequestParam(value = "checkboxResult") int result,
                                                 @RequestParam(value = "regIdValue") int regId) {
        Map<String, Object> map = new HashMap<>();

        purchaseMapper.deletePurchase(regId, result);

        map.put("msg", "success");

        return map;
    }
}

