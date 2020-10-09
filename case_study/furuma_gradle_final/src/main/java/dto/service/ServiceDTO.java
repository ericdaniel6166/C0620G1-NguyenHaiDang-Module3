package dto.service;

public class ServiceDTO {
    private String serviceId;
    private String serviceName;
    private String area;
    private String numberOfFloors;
    private String maximumNumberOfCustomers;
    private String rentPrice;
    private String typeOfRentId;
    private String typeOfServiceId;
    private String status;
    private String typeOfRentName;
    private String typeOfRentPrice;
    private String typeOfServiceName;

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area='" + area + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'' +
                ", maximumNumberOfCustomers='" + maximumNumberOfCustomers + '\'' +
                ", rentPrice='" + rentPrice + '\'' +
                ", typeOfRentId='" + typeOfRentId + '\'' +
                ", typeOfServiceId='" + typeOfServiceId + '\'' +
                ", status='" + status + '\'' +
                ", typeOfRentName='" + typeOfRentName + '\'' +
                ", typeOfRentPrice='" + typeOfRentPrice + '\'' +
                ", typeOfServiceName='" + typeOfServiceName + '\'' +
                '}';
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getMaximumNumberOfCustomers() {
        return maximumNumberOfCustomers;
    }

    public void setMaximumNumberOfCustomers(String maximumNumberOfCustomers) {
        this.maximumNumberOfCustomers = maximumNumberOfCustomers;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getTypeOfRentId() {
        return typeOfRentId;
    }

    public void setTypeOfRentId(String typeOfRentId) {
        this.typeOfRentId = typeOfRentId;
    }

    public String getTypeOfServiceId() {
        return typeOfServiceId;
    }

    public void setTypeOfServiceId(String typeOfServiceId) {
        this.typeOfServiceId = typeOfServiceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeOfRentName() {
        return typeOfRentName;
    }

    public void setTypeOfRentName(String typeOfRentName) {
        this.typeOfRentName = typeOfRentName;
    }

    public String getTypeOfRentPrice() {
        return typeOfRentPrice;
    }

    public void setTypeOfRentPrice(String typeOfRentPrice) {
        this.typeOfRentPrice = typeOfRentPrice;
    }

    public String getTypeOfServiceName() {
        return typeOfServiceName;
    }

    public void setTypeOfServiceName(String typeOfServiceName) {
        this.typeOfServiceName = typeOfServiceName;
    }

    public ServiceDTO(String serviceId, String serviceName, String area, String numberOfFloors, String maximumNumberOfCustomers, String rentPrice, String typeOfRentId, String typeOfServiceId, String status, String TypeOfRentName, String typeOfRentPrice, String typeOfServiceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.area = area;
        this.numberOfFloors = numberOfFloors;
        this.maximumNumberOfCustomers = maximumNumberOfCustomers;
        this.rentPrice = rentPrice;
        this.typeOfRentId = typeOfRentId;
        this.typeOfServiceId = typeOfServiceId;
        this.status = status;
        this.typeOfRentName = TypeOfRentName;
        this.typeOfRentPrice = typeOfRentPrice;
        this.typeOfServiceName = typeOfServiceName;
    }

    public ServiceDTO() {
    }
}
