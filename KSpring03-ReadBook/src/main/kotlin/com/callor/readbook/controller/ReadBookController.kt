package com.callor.readbook.controller

import com.callor.readbook.model.Book
import com.callor.readbook.model.ReadBook
import com.callor.readbook.service.BookService
import com.callor.readbook.service.ReadBookService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController(val bService :  BookService , val rService: ReadBookService) {


    @RequestMapping(value = ["/read/insert"], method = [RequestMethod.GET])
    fun insert(model: Model):String {

        model["BOOK"] = Book()
         return "book/write"
    }


    @RequestMapping(value = ["/read/insert"], method = [RequestMethod.POST])
    fun insert(model: Model, book: Book, readBook: ReadBook):String {

        bService.insert(book)
        rService.insert(readBook)

        return "test/test"
    }

}