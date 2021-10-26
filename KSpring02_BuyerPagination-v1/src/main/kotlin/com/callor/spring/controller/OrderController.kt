package com.callor.spring.controller

import com.callor.spring.config.logger
import com.callor.spring.service.OrderService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value=["/order"])
class OrderController(val orService:OrderService) {

    //  localhost:8080/order/ 또는
    //  localhost:8080/order 요청을 모두 수용
    @RequestMapping(value=["/list"],method=[RequestMethod.GET])
    fun list(model:Model, pageable: Pageable) : String {
        
        logger().debug("order list 함수")
        
        
        val salesList = orService.selectAll(pageable)
        model["SALES"] = salesList
        return "order/list"
    }

    @RequestMapping(value = ["/sublist"], method = [RequestMethod.GET])
    fun subPage(model: Model, pageable: Pageable) : String {

        val  salesList = orService.selectAll(pageable)
        model["SALES"] = salesList

        return "order/sublist"

    }

    @RequestMapping(value = ["/list/{page}"], method = [RequestMethod.GET])
    fun list(model: Model,  @PathVariable("page")page:String="0"):String {

        val  intPage = try {

            page.toInt()
        } catch (e:Exception) {

            logger().debug("변수 오류")
            0
        }
        val  salesList = orService.selectWithPageble(intPage)

        model["SALES"] = salesList
        return "buyer/list"
    }

}