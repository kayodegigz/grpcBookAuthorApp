package com.kayode.controller;

import com.google.protobuf.Descriptors;
import com.kayode.service.BookAuthorClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BookAuthorController {
    public BookAuthorClientService bookAuthorClientService;

    public BookAuthorController(BookAuthorClientService bookAuthorClientService) {
        this.bookAuthorClientService = bookAuthorClientService;
    }

    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable(name = "id") String authorId) {
        return bookAuthorClientService.getAuthor(Integer.parseInt(authorId));
    }
}
