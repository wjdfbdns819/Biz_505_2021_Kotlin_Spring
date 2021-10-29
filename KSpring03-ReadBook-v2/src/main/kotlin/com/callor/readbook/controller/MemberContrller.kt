package com.callor.readbook.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value = ["/member"])
class MemberContrller {

    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    fun login() : String {

        return "member/login"
    }

    @RequestMapping(value = ["/mypage"], method = [RequestMethod.GET])
    fun myPage():String {
        return "hello"
    }


}