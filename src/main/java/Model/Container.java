package Model;

public class Container {
    public int idCon,lengthCon, heightCon;
    public String typeCon;
    public Boolean flagCon;

    @Override
    public String toString() {
        return "Container{" +
                "Mã Id: " + idCon +
                ", Chiều dài: " + lengthCon +
                ", Chiều rộng: " + heightCon +
                ", Loại: " + typeCon + '\'' +
                ", Trạng thái: " + flagCon +
                '}';
    }
}
