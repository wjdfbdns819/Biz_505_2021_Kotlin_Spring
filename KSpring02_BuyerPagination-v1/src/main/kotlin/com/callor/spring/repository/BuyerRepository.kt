package com.callor.spring.repository

import com.callor.spring.models.Buyer
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

// 현재 BuyerRepository interface 를 bean 으로 등록하라
// @Repository 는 선택적인 option
//@Repository
interface BuyerRepository:JpaRepository<Buyer,String> {

    /**
     *
     * JpaRepository 를 상속받은 Repository 에서
     * 기본 CRUD 외에 다른 칼럼으로 조회하는 method를 추가할 수 있다
     * 단 조건이 있다
     * findBy 로 시작해야 한다
     * data(Entity) 클래스에 정의된 맴버 변수 이름만 설정이 가능핟
     *
      */
    fun findByName(name:String):Array<Buyer>
    fun findByTel(tel:String) : Array<Buyer>

//    fun findByUserName(userName:String) : Array<Buyer>

    // Select All과 똑같음 전체 리스트를 출력
    @Query("SELECT B FROM Buyer B")
    fun findWithpagination(pageable:Pageable?) : List<Buyer>


    // tbl_buyer table에서 가장 마지막 usesrid를 찾아서 return 함수

    /**
     * JSQL(JPA SQL)
     *  JPA가 적용된 프로젝트에서 기본 규칙으로 제공하는 함수 외에
     *   custom 함수를 만들고자 할때 적용하는 SQL
     *   
     *   FROM 절에 table이름이 아닌 DTO 클래스를 적용한다
     */
    @Query("SELECT max(userid) FROM Buyer")

    // 데이터가 없을때를 대비해서 null safe(?)를 적용한다
    fun  maxserId() : String?

}