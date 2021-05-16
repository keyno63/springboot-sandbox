package jp.co.who.spring_tutorial.mockitosandbox;

import jp.co.who.spring_tutorial.mockitosandbox.libs.MockitoSandboxModule;

public class MockitoSandbox {

    private final MockitoSandboxModule mockitoSandboxModule;


    public MockitoSandbox(MockitoSandboxModule mockitoSandboxModule) {
        this.mockitoSandboxModule = mockitoSandboxModule;
    }

    public String getValue(String key) {
        return mockitoSandboxModule.get(key);
    }
}
