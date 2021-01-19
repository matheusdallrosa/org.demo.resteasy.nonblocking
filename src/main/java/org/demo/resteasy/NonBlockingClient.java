package org.demo.resteasy;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpAsyncClient4Engine;

import javax.ws.rs.client.ClientBuilder;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonBlockingClient {

    private static ApacheHttpAsyncClient4Engine httpEngine;

    public NonBlockingClient(){
        IOReactorConfig reactorConfig = IOReactorConfig.copy(IOReactorConfig.DEFAULT)
                .setIoThreadCount(1)
                .build();

        CloseableHttpAsyncClient closeableHttpAsyncClient = HttpAsyncClientBuilder
                .create()
                .setMaxConnTotal(10)
                .setDefaultIOReactorConfig(reactorConfig)
                .build();
        closeableHttpAsyncClient.start();

        httpEngine = new ApacheHttpAsyncClient4Engine(closeableHttpAsyncClient, false);
    }

    public static void main(String[] args) {
        NonBlockingClient nonBlockingClient = new NonBlockingClient();
    }
}
