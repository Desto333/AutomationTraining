package service;

import model.PlatformConfiguration;

public class PlatformConfigurationCreator {
    public static final String searchRequest = "testdata.platformconfiguration.searchRequest";
    public static final String numberOfInstances = "testdata.platformconfiguration.numberOfInstances";
    public static final String operatingSystem = "testdata.platformconfiguration.operatingSystem";
    public static final String vmClass = "testdata.platformconfiguration.vmClass";
    public static final String series = "testdata.platformconfiguration.series";
    public static final String machineType = "testdata.platformconfiguration.machineType";
    public static final String addGPUs = "testdata.platformconfiguration.addGPUs";
    public static final String numberOfGPU = "testdata.platformconfiguration.numberOfGPU";
    public static final String typeGPU = "testdata.platformconfiguration.typeGPU";
    public static final String localSSD = "testdata.platformconfiguration.localSSD";
    public static final String locationOfDatacenter = "testdata.platformconfiguration.locationOfDatacenter";
    public static final String committedUsagePeriod = "testdata.platformconfiguration.committedUsagePeriod";

    public static PlatformConfiguration createTestConfiguration() {
        return new PlatformConfiguration(TestDataReader.getTestData(searchRequest),
                TestDataReader.getTestData(numberOfInstances),
                TestDataReader.getTestData(operatingSystem),
                TestDataReader.getTestData(vmClass),
                TestDataReader.getTestData(series),
                TestDataReader.getTestData(machineType),
                TestDataReader.getTestData(addGPUs),
                TestDataReader.getTestData(numberOfGPU),
                TestDataReader.getTestData(typeGPU),
                TestDataReader.getTestData(localSSD),
                TestDataReader.getTestData(locationOfDatacenter),
                TestDataReader.getTestData(committedUsagePeriod));
    }
}
