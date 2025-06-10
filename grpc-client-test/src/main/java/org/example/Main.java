package org.example;

import com.example.grpc.GreeterGrpc;
import com.example.grpc.HelloProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloProto.HelloRequest request = HelloProto.HelloRequest.newBuilder()
                .setName("kim kyungmin")
                .build();

        HelloProto.HelloReply response = stub.sayHello(request);   // breakpoint

        System.out.println("response: " + response.getMessage());

        channel.shutdown();
    }
}