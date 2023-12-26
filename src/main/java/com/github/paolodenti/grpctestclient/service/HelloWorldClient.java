package com.github.paolodenti.grpctestclient.service;

import com.github.paolodenti.grpctestproto.HelloWorldRequest;
import com.github.paolodenti.grpctestproto.HelloWorldServiceGrpc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HelloWorldClient {

    @GrpcClient("grpc-server")
    private HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub;

    public void sendHelloWorldRequest() {

        log.debug("Sending request");
        var request = HelloWorldRequest.newBuilder()
                .setRequestMessage("Hello World")
                .build();
        var response = helloWorldServiceBlockingStub.helloWorld(request);
        log.debug("Received response: {}", response);
    }
}
