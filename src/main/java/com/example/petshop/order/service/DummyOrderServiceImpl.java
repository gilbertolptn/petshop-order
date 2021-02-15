package com.example.petshop.order.service;

import com.example.petshop.order.client.AccountClient;
import com.example.petshop.order.dto.OrderDetails;
import com.example.petshop.order.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class DummyOrderServiceImpl implements OrderService {
    private AccountClient accountClient;

    @Override
    public void create(OrderDetails orderDetails) {
        if(orderDetails.getQuantity() < 1){
            throw new BusinessException("Please use at least 1 item on order!");
        }

        if(accountClient.isAcountStatusRegular(orderDetails.getAccountId())){
            throw new BusinessException("This account can't create any order.");
        }

        //Or save..

    }
}
