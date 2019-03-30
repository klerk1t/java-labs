import controller.Controller;
import model.Model;
import model.filework.SerializationData;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        SerializationData serializationData = new SerializationData();
        serializationData.setTeachersW(model.getTeachers());
        serializationData.writeData();
        serializationData.readData();
        model.setTeachers(serializationData.getTeachersR());
        Controller controller = new Controller(model, view);
        controller.execute();
    }

}
