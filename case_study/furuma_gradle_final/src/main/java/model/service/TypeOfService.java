package model.service;

public class TypeOfService {
    private String typeOfServiceId;
    private String typeOfServiceName;

    @Override
    public String toString() {
        return "TypeOfService{" +
                "typeOfServiceId='" + typeOfServiceId + '\'' +
                ", typeOfServiceName='" + typeOfServiceName + '\'' +
                '}';
    }

    public String getTypeOfServiceId() {
        return typeOfServiceId;
    }

    public void setTypeOfServiceId(String typeOfServiceId) {
        this.typeOfServiceId = typeOfServiceId;
    }

    public String getTypeOfServiceName() {
        return typeOfServiceName;
    }

    public void setTypeOfServiceName(String typeOfServiceName) {
        this.typeOfServiceName = typeOfServiceName;
    }

    public TypeOfService(String typeOfServiceId, String typeOfServiceName) {
        this.typeOfServiceId = typeOfServiceId;
        this.typeOfServiceName = typeOfServiceName;
    }

    public TypeOfService() {
    }
}
