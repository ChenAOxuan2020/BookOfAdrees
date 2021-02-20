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
    //test
    public int add(int A, int B){
        return A + B;
    }
    //change , add , delect
    public Map<String,String> bookOfAdress(Map<String,String> putIn,
                                           Map<String,String> addOrChange,
                                           List<String> delect){
        for (String Key : addOrChange.keySet()) {
            putIn.put(Key, addOrChange.get(Key));
        }
        for (String name : delect){
            putIn.remove(name);
        }
        System.out.println(putIn);
        return putIn;
    }
    //search adress/name
    public String search(String inPut,Map<String,String> adressBook){
        StringBuilder outPut = new StringBuilder();
        if (adressBook.containsKey(inPut)){
            outPut = new StringBuilder("this person " + inPut + " live in " + adressBook.get(inPut));
        }else {
            for (String Key : adressBook.keySet()) {
                if (adressBook.get(Key).equals(inPut)){
                    outPut.append(Key).append(" ");
                }
            }
        }
        if (outPut.toString().equals("")){
            outPut = new StringBuilder("information of this person/adress not found");
        }
        System.out.println(outPut);
        return outPut.toString();
    }
}
