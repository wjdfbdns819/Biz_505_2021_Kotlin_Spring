package com.callor.spring.service

import com.callor.spring.models.Sales
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface OrderService {

    fun selectAll():Array<Sales>
    fun selectAll(pageable: Pageable): Page<Sales>

    fun selectWithPageble(intPage: Int): Array<Sales>

    fun findById(seq : Long) : Sales

    fun findByUserId(userid:String) : Array<Sales>
    fun findByPName(pname:String) : Array<Sales>

    // 날짤범위를 지정하여 검색하기
    fun findByDateDestance(sDate:String, eDate:String) : Array<Sales>

    fun insert(sales:Sales) : Sales
    fun delete(seq:Long)
    fun update(sales:Sales) : Sales



}