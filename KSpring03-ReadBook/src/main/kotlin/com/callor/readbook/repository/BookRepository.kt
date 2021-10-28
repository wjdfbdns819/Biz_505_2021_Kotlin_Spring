package com.callor.readbook.repository

import com.callor.readbook.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository:JpaRepository<Book,String> {


}