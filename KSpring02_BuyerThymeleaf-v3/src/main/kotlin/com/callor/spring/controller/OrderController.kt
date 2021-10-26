package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value=["/order"])
class OrderController(val oService : OrderService) {

    @RequestMapping(value=["/list"], method=[RequestMethod.Get])
    fun list(model:Model) : String {

        val orderList = oService.selectAll()
        model["ORDERS"] = orderList
        return "order/list"
    }


}