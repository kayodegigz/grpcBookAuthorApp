package com.kayode.service;

import com.google.protobuf.Descriptors;
import com.kayode.Author;
import com.kayode.BookAuthorServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookAuthorClientService {

    @GrpcClient("grpc-kayode-service")
    BookAuthorServiceGrpc.BookAuthorServiceBlockingStub synchronousClient;

//    public BookAuthorClientService(BookAuthorServiceGrpc.BookAuthorServiceBlockingStub synchronousClient) {
//        this.synchronousClient = synchronousClient;
//    }

    public Map<Descriptors.FieldDescriptor, Object> getAuthor(int authorId) {
        Author authorRequest = Author.newBuilder().setAuthorId(authorId).build();
        Author author = synchronousClient.getAuthor(authorRequest);
        return author.getAllFields();
    }

}
