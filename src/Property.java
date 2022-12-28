public class Property {
    private String city;
    private String street;
    private Integer numberOfRooms;
    private Integer price;
    private String buildingType;
    private boolean isRentable;
    private Integer houseNumber;
    private Integer floorNumber;
    private User sellerName;


    public Property(String city, String street, Integer numberOfRooms, Integer price, String buildingType, boolean isRentable, Integer houseNumber, Integer floorNumber, User sellerName) {
        this.city = city;
        this.street = street;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.buildingType = buildingType;
        this.isRentable = isRentable;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Property{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                ", buildingType='" + buildingType + '\'' +
                ", isRentable=" + isRentable +
                ", houseNumber=" + houseNumber +
                ", floorNumber=" + floorNumber +
                ", sellerName=" + sellerName +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public boolean isRentable() {
        return isRentable;
    }

    public void setRentable(boolean rentable) {
        isRentable = rentable;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public User getSellerName() {
        return sellerName;
    }

    public void setSellerName(User sellerName) {
        this.sellerName = sellerName;
    }

}
