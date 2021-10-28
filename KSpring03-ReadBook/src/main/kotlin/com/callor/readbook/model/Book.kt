package com.callor.readbook.model

import javax.persistence.*

@Entity
@Table(name = "tbl_book", schema = "naraDB")
class Book {

    @Id
    @Column(columnDefinition = "BIGINT", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ISBN
    var isbn : Long? = 0

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    // 도서명
    var title : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    // 출판사
    var comp : String? = null

    @Column(columnDefinition = "VARCHAR(15)", nullable = true)
    // 저자
    var author : String? = null

    @Column(columnDefinition = "VARCHAR(15)", nullable = true )
    // 가격
    var price : String? = null

}