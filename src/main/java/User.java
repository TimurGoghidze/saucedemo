import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter//будет реализовано для всех в классе
@AllArgsConstructor // realize constructor for all elements in this class
public class User {
    // здесь
    //@Getter// generate getter, we not need to write code less space used
    private String name;
    private String password;

    //generate constructor

//   public User(String name, String password) { // we can use @AllArgsConstructor
//        this.name = name;
//        this.password = password;
//    }
//если мы загружаем в pom библиотеку lombok то getter удаляем и вверху устанавливаем аннотацию @Getter
//    public String getName() { //даёт возможность получить но не менять
//        return name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}
