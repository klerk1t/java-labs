import controller.Controller;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
/*        ReadSerializationData serializationData = new ReadSerializationData();
        serializationData.setTeachersWrite(model.getTeachers());
        serializationData.writeData();
        serializationData.readData();
        model.setTeachers(serializationData.getTeachersRead());*/
        Controller controller = new Controller(model, view);
        controller.execute();
    }

}
