package com.example.demo.service;

import com.example.grpc.GreeterGrpc;
import com.example.grpc.HelloProto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        System.out.println("[DEBUG] 요청 받은 이름: " + name);  // breakpoint 걸기 용이

        String message = "Hello, " + name + "!";
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
