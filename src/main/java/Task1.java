import java.util.List;
import java.util.Map;
//Вариант 14 -- адресная книга [Java]
//Хранит список адресов различных людей. Адрес состоит из улицы, номера дома и
//номера квартиры. Человек задаётся фамилией, для каждого человека хранится лишь
//один адрес.
//Методы: добавление пары человек-адрес, удаление человека, изменение адреса
//человека, получение адреса человека, получение списка людей, живущих на заданной
//улице или в заданном доме
public class Task1 {
    public int add(int A, int B){
        int result = A + B;
        return result;
    }
    public Map<String,String> bookOfAdress(Map<String,String> putIn,
                                           Map<String,String> addOrChange,
                                           List<String> delect){
        Map<String,String> outPut = putIn;
        Map<String,String> aOrC = addOrChange;
        List<String> d = delect;
        for (String Key : aOrC.keySet()) {
            outPut.put(Key, aOrC.get(Key));
        }
        for (String name : d){
            if (outPut.containsKey(name)) {
                outPut.remove(name);
            }
        }
        System.out.println(outPut);
        return outPut;
    }
    public String search(String inPut,Map<String,String> adressBook){
        String outPut = "";
        if (adressBook.containsKey(inPut)){
            outPut = "this person " + inPut + " live in " + adressBook.get(inPut);
        }else {
            for (String Key : adressBook.keySet()) {
                if (adressBook.get(Key) == inPut){
                    outPut += Key + " ";
                }
            }
        }
        if (outPut ==""){
            outPut = "information of this person/adress not found";
        }
        System.out.println(outPut);
        return outPut;
    }
}
