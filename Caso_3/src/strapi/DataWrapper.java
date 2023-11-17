package strapi;

public class DataWrapper<T> {
    private T data;

    public DataWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
