package com.callor.readbook.service

import com.callor.readbook.model.ReadBook

interface ReadBookService {

    fun insert(readbook : ReadBook) : ReadBook
}