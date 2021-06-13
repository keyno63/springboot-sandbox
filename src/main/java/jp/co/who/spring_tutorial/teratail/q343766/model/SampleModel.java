package jp.co.who.spring_tutorial.teratail.q343766.model;

import jp.co.who.spring_tutorial.teratail.q343766.service.SampleService;

public class SampleModel {

    private final SampleService sampleService;
    public SampleModel(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public void write(int value) {
        sampleService.update(value);
    }

    public void writeByte(byte[] values) {
        sampleService.update(values);
    }
}
