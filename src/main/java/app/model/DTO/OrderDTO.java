package app.model.DTO;

public class OrderDTO {

    private Integer order_id;
    private String client_name;
    private String client_phone;
    private int user_id;
    private int cargo_weight;
    private int cargo_size;
    private boolean isInCityLimitsDelivery;
    private String delivery_time;
    private double delivery_price;
    private String receipt;
    private String creation_time;
    private String status;


    public OrderDTO(Integer order_id, String client_name, String client_phone, int user_id, int cargo_weight, int cargo_size,
                    boolean isInCityLimitsDelivery, String delivery_time, double delivery_price, String receipt,
                    String creation_time, String status) {
        this.order_id = order_id;
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.user_id = user_id;
        this.cargo_weight = cargo_weight;
        this.cargo_size = cargo_size;
        this.isInCityLimitsDelivery = isInCityLimitsDelivery;
        this.delivery_time = delivery_time;
        this.delivery_price = delivery_price;
        this.receipt = receipt;
        this.creation_time = creation_time;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCargo_weight() {
        return cargo_weight;
    }

    public void setCargo_weight(int cargo_weight) {
        this.cargo_weight = cargo_weight;
    }

    public int getCargo_size() {
        return cargo_size;
    }

    public void setCargo_size(int cargo_size) {
        this.cargo_size = cargo_size;
    }

    public boolean isInCityLimitsDelivery() {
        return isInCityLimitsDelivery;
    }

    public void setInCityLimitsDelivery(boolean inCityLimitsDelivery) {
        isInCityLimitsDelivery = inCityLimitsDelivery;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public double getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(double delivery_price) {
        this.delivery_price = delivery_price;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
