package com.callor.spring.service

import com.callor.spring.models.Buyer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BuyerService {

    fun selectAll(): Array<Buyer>
    
    // Pageable을 매개변수로 받고,
    //  Page<T>를 return type으로 갖는 함수를 선언
    fun selectAll(pageable: Pageable): Page<Buyer>

    fun findById(userid: String): Buyer
    fun findByName(name: String): Array<Buyer>
    fun findByTel(name: String): Array<Buyer>

    fun insert(buyer: Buyer): Buyer
    fun insert(): Buyer

    fun delete(userid: String)
    fun update(buyer: Buyer): Buyer
    fun selectWithPageble(intPage: Int): Array<Buyer>



}