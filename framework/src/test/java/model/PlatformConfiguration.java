package model;

import java.util.Objects;

public class PlatformConfiguration {
    private String searchRequest;
    private String numberOfInstances;
    private String operatingSystem;
    private String vmClass;
    private String series;
    private String machineType;
    private String addGPUs;
    private String numberOfGPU;
    private String typeGPU;
    private String localSSD;
    private String locationOfDatacenter;
    private String committedUsagePeriod;

    public PlatformConfiguration(String searchRequest, String numberOfInstances, String operatingSystem, String vmClass, String series
            , String machineType, String addGPUs, String numberOfGPU, String typeGPU, String localSSD
            , String locationOfDatacenter, String committedUsagePeriod) {
        this.searchRequest = searchRequest;
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.vmClass = vmClass;
        this.series = series;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.numberOfGPU = numberOfGPU;
        this.typeGPU = typeGPU;
        this.localSSD = localSSD;
        this.locationOfDatacenter = locationOfDatacenter;
        this.committedUsagePeriod = committedUsagePeriod;
    }

    public String getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(String searchRequest) {
        this.searchRequest = searchRequest;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String isAddGPUs() {
        return addGPUs;
    }

    public void setAddGPUs(String addGPUs) {
        this.addGPUs = addGPUs;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getTypeGPU() {
        return typeGPU;
    }

    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getLocationOfDatacenter() {
        return locationOfDatacenter;
    }

    public void setLocationOfDatacenter(String locationOfDatacenter) {
        this.locationOfDatacenter = locationOfDatacenter;
    }

    public String getCommittedUsagePeriod() {
        return committedUsagePeriod;
    }

    public void setCommittedUsagePeriod(String committedUsagePeriod) {
        this.committedUsagePeriod = committedUsagePeriod;
    }

    @Override
    public String toString() {
        return "PlatformConfiguration{" +
                "searchRequest='" + searchRequest + '\'' +
                ", numberOfInstances=" + numberOfInstances +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", addGPUs=" + addGPUs +
                ", numberOfGPU=" + numberOfGPU +
                ", typeGPU='" + typeGPU + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", locationOfDatacenter='" + locationOfDatacenter + '\'' +
                ", committedUsagePeriod='" + committedUsagePeriod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatformConfiguration that = (PlatformConfiguration) o;
        return numberOfInstances.equals(that.numberOfInstances)
                && addGPUs.equals(that.addGPUs)
                && numberOfGPU.equals(that.numberOfGPU)
                && searchRequest.equals(that.searchRequest)
                && operatingSystem.equals(that.operatingSystem)
                && vmClass.equals(that.vmClass)
                && series.equals(that.series)
                && machineType.equals(that.machineType)
                && typeGPU.equals(that.typeGPU)
                && localSSD.equals(that.localSSD)
                && locationOfDatacenter.equals(that.locationOfDatacenter)
                && committedUsagePeriod.equals(that.committedUsagePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchRequest, numberOfInstances, operatingSystem, vmClass, series, machineType,
                addGPUs, numberOfGPU, typeGPU, localSSD, locationOfDatacenter, committedUsagePeriod);
    }
}
