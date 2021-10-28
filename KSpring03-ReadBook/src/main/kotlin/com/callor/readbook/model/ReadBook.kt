package com.callor.readbook.model

import javax.persistence.*

@Entity
@Table(name = "tbl_readbook", schema = "naraDB")
class ReadBook {

    @Id
    @Column(columnDefinition = "BIGINT" , nullable = false, unique = true )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq : Long? = 0

    @Column(columnDefinition = "BIGINT" , nullable = true)
    var isbn : Long? = 0

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var rdate : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var stime : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var etime : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var rating : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var comment : String? = null

}