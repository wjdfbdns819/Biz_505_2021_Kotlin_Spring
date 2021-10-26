package com.callor.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


/**
 * DTO(VO) 클래스
 *  date class를 사용하여 객체를 생성할때
 *  val buyer = Buyer(각 속성의 초기값) 처럼 초기값을 강제로
 *   지정해야 한다
 *   
 *  date class를 사용하여 객체를 생성할때
 *   때로는 요소값이 필요없는 빈(blank) 객체가 필요할때도 있다
 *   이때를 대비하여 각 속성(멤버) 변수에는 null을 지정한다
 *   속성에 null 값을 지정하는 방법
 *   var 변수명? = null 형식으로 지정한다
 *   
 *  val buyer = Buyer() : blank buyer 객채를 생성한다
 */

@SpringBootApplication
class KSpringApplication

fun main(args: Array<String>) {
	runApplication<KSpringApplication>(*args)
}
