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
@RequestMapping(value=["/buyer"])
class BuyerController(val bService:BuyerService) {

    private val loggerFactory.getLogger(BuyerController::class.java)

    // @GetMapping(name="/list")
     @RequestMapping(value=["/list"],method=[RequestMethod.GET])
    fun list(model: Model):String {
        
        logger.debug("여기는 list 함수")
        
        val buyerList = bService.selectAll()
        model["BUYERS"] = buyerList
        return "buyer/list"
    }

    // localhost:8080/buyer/detail
    @RequestMapping(value=["/detail"],method=[RequestMethod.GET])
    fun detail( model:Model, @RequestParam("userid") userid:String):String {

        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/detail" // detail.html 을 열어라

    }

    /**
     * ModelAndAttribute 속성, 기능
     *  Controller 에서 Model의 객체를 담고,
     *  form 화면을 rendering 하도록 하면
     *  
     *  보통은 form의 value 속성에 일일이
     *   데이터를 추가하여 작성을 한다
     *  
     *  ModelAttr 을 사용하면
     *   각각 view Template의 고유 기능을 사용하여 
     *   id, name, value 값을 자동으로 채워넣는 기능을 만들 수 있다
     *  
     *  thymeleaf template 을 사용할때는 
     *   form tag에 model에 담긴 object를 지정해 주고
     *   각 input box에서는 field 속성으로 해당 멤버변수(요소,속성)dmf
     *   저장해 주면 template 엔진이 rendering을 수행하면서
     *   input에 필요한 요소들을 적절하게 생성해 준다
     */
    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert(model:Model): String {
        //val insertBuyer = ConfigData.BUYER_LIST[0]
        model["BUYER"] = Buyer()
//        bService.insert(insertBuyer)
        return "buyer/write"
    }

    @RequestMapping(value=["/insert"],method=[RequestMethod.POST])
    fun insert(model:Model, buyer:Buyer): String {
        bService.insert(buyer)
        return "redirect:/buyer/list"
    }

    @RequsetMapping(value=["/update/{userid}"], method=[RequsetMethod.GET])
    fun update(model:Model, @Pathvariable("userid") userid: String) : String {
        val buyer =bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/write"
    }

    /**
     * update를 실행할때
     *  localhost:8080/buyer/update/userid 값으로 URL이 구성되어있고
     *  update 화면에서 저장을 누르면 원래 요청했던 주소가
     *  action이 되어 요청되므로 여기에서는 userid가 필요없지만
     *  Pathvariable로 설정해 주어야 한다
     */
    @RequsetMapping(value=["/update/{userid}"], method=[RequsetMethod.POST])
    fun update(redirectAttribute:RedirectAttributes, model:Model, @Pathvariable("userid") userid: String) : String {

        bService.update(buyer)

        /**
         * Spring MVC 에서는 model에 변수를 담으면
         *  redirect를 실행할때 model에 담긴 변수를
         *  queryString으로 부착하여 전송을 한다
         *
         * 이 기능이 boot 에서는 금지되고,
         *  같은 기능을 구현하기 위하여
         *  model 대신 RedirectAttributes를 사용한다
        */


        // localhost:8080/buyer/detail?userid=??? 형식으로
        // redirect 주소가 만들어진다
        model["userid"] = buyer.userid.toString()
        return  "redirect:/buyer/detail"
    }

    @RequestMapping(value=["/delete/{userid}"], method=[RequestMethod.GET])
    fun delete(@PathVariable("userid")userid: String) {

        bService.delete(userid)
        return "redirect:/buyer/list"
    }

}