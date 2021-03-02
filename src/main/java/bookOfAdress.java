
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


//Вариант 14 -- адресная книга [Java]
//Хранит список адресов различных людей. Адрес состоит из улицы, номера дома и
//номера квартиры. Человек задаётся фамилией, для каждого человека хранится лишь
//один адрес.
//Методы: (1)добавление пары человек-адрес, (2)удаление человека, (3)изменение адреса
//человека, (4)получение адреса человека, (5)получение списка людей, живущих на заданной
//улице или в заданном доме
public class bookOfAdress {
    Map<String, String> book = new HashMap<>() {{
        put("name", "adress");
    }};

    // главная функция
    public static void main(String[] args)  {


        String Out = "input1       to add Name And Adress\n" +
                "input2       to remove\ninput3       to change Adress\n" +
                "input4       to get Adress\ninput5       to get Name\n" +
                "input0       to exit\ninput6       to print adrees which is saved\n";
        bookOfAdress ues = new bookOfAdress();
        System.out.println(Out);
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (i != 0) {
            switch (i) {
                // добавление пары
                case 1 -> {
                    System.out.println("input name and adress like: имя проспект12/дом1");
                    String inPutName = sc.next();
                    String inPutAdress = sc.next();
                    if (!ues.addNameAndAdress(inPutName, inPutAdress)) {
                        System.out.println("in book has this name");
                    }
                    System.out.println(inPutName + "  " + inPutAdress);
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
                //удаление
                case 2 -> {
                    System.out.println("input name");
                    String inPutName = sc.next();
                    if (!ues.removeName(inPutName)) {
                        System.out.println("in book has not this name");
                    }
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
                //изменение адреса
                case 3 -> {
                    System.out.println("input name and adress like: имя проспект12/дом1");
                    String inPutName = sc.next();
                    String inPutAdress = sc.next();
                    if (!ues.changeAdress(inPutName, inPutAdress)) {
                        System.out.println("the same adress,or in book has not this name");
                    }
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
                //получение адреса
                case 4 -> {
                    System.out.println("input name");
                    String inPutName = sc.next();
                    System.out.println(ues.getAdress(inPutName));
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
                //получение списка людей
                case 5 -> {
                    System.out.println("input adress like: проспект12/дом1 or проспект12");
                    String inPutAdress = sc.next();
                    System.out.println(ues.getName(inPutAdress));
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
                case 6 ->{
                    System.out.println(ues.saveOfAdress());
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
                default -> {
                    System.out.println("error in input");
                    System.out.println(Out);
                    i = sc.nextInt();
                    continue;
                }
            }

        }
    }


    //добавление пары человек-адрес,Возвращает false если человек уже был в книги
    public Boolean addNameAndAdress(String name, String adress) {
        if (!book.containsKey(name)) {
            book.put(name, adress);
            return true;
        } else return false;
    }

    //удаление человека  Возвращает false если человек с таким именем не был в книги
    public Boolean removeName(String name) {
        if (book.containsKey(name)) {
            book.remove(name);
            return true;
        } else return false;
    }

    // изменение адреса Возвращает false если человек с таким именем не был в книги либо у него уже был такой адрес
    public Boolean changeAdress(String name, String adress) {
        if (book.containsKey(name) && !(book.get(name).equals(adress))) {
            book.put(name, adress);
            return true;
        } else return false;
    }

    //получение адреса человека Возвращает not found если человек с таким именем не был в книги
    public String getAdress(String name) {
        return book.getOrDefault(name, "not found");
    }

    //получение списка людей, живущих на заданной улице или в заданном адрес
    public List<String> getName(String adress) {
        List<String> outPut = new ArrayList<>();
        for (String key : book.keySet()) {
            String mid = book.get(key);
            String[] midStr = mid.split("/");
            String[] adressStr = adress.split("/");
            if (midStr[0].equals(adressStr[0])) {
                outPut.add(key);
            }
        }
        return outPut;
    }

    //хранение адресс в отельном String.
    public String saveOfAdress()  {
        StringBuilder midSave = new StringBuilder();
        book.forEach((key,value)->{
            midSave.append(key + "\t" + value +"\n");
        });
        return midSave.toString();
    }

}
