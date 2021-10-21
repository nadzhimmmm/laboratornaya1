import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
class List {
    List next;
    int value;
}

class List2
{
    private List head;
    private List last;



    void delete_element_position(int data)
    {
        List q=this.head;
        if (q==null) return;

        if ((head == last)&&(head.value==data)) {
            head=null;
            last=null;
            return;
        }

        if (q.value==data)
        {
            head=head.next;
            return;
        }
        while (q.next != null) {
            if (q.next.value == data) {

                q.next = q.next.next;
                return;
            }
            q = q.next;
        }
        System.out.println("Такого числа нету");
    }



    void add_in_back(int data)
    {
        List a = new List();
        a.value = data;
        if (last == null)
        {
            head = a;
            last = a;
        } else {
            last.next = a;
            last = a;
        }
    }

    void printList()
    {
        List q=this.head;
        if (q==null)
        {
            System.out.println("Список пуст, добавьте в него элементы.");
            return;
        }

        while (q != null)
        {
            System.out.print(q.value);
            System.out.print(" ");
            q = q.next;
        }
    }
    public void add(int num, int value)
    {
        List t = this.head;
        int i=0;
        if(num>0 && num<get_Size()) {
            while (t != null) {
                if (i + 1 == num) {
                    List e = new List();
                    e.value = value;
                    e.next = t.next;
                    t.next = e;
                    //t = e;
                    return;
                }
                t = t.next;
                i++;
            }
        }
        else
        if (num==get_Size())
        {
            add_in_back(value);
            return;
        }
        else
        if (num==0)
        {
            add_in_front(value);
            return;
        }
        else return;

    }

    public int get_element(int pos)
    {
        List q=this.head;
        if (pos<0||pos>get_Size())
            return 0;
        else {
            for (int i = 0; i < get_Size(); i++) {
                if (i == pos) return q.value;
                q = q.next;
            }
        }
        return 0;
    }
    public int get_Size()
    {
        List q=this.head;
        int n=0;

        while(q!=null)
        {
            n++;
            q=q.next;
        }
        return n;

    }
    void add_in_front(int value)
    {
        List a = new List();
        a.value = value;

        if(head == null)
        {
            head = a;
            last = a;
        }
        else {
            a.next = head;
            head = a;
        }
    }
    public String toString(){
        List q=this.head;
        String result=new String(" ");
        if(get_Size()==0)
        {
            return result;
        }
        for(int i=0;i<get_Size();i++)
        {
            String t=Integer.toString(q.value);
            result+=t.toString()+ " ";
            q=q.next;
        }
        result=result.substring(0,result.length()-1);
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        List2 l = new List2();
        System.out.println("Введите количество элементов");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i=0;i<n;i++)
        {
            System.out.println((i+1)+")");
            int val=in.nextInt();
            l.add_in_back(val);
        }
        l.printList();
        System.out.println();
        int option;
        int quit=1;
        int y;
        while(quit!=0)
        {
            System.out.println("1.Добавление");
            System.out.println("2.Удаление");
            System.out.println("3.Вывод");
            System.out.println("4.Извлечение");
            System.out.println("0.Выход");
            option=in.nextInt();
            if (option==1)
            {
                System.out.println("Значение добавляемого элемента");
                int data=in.nextInt();
                System.out.println("1.Добавить в начало");
                System.out.println("2.Добавить в конец");
                System.out.println("3.Добавить в произвольное место");

                y=in.nextInt();
                if(y==1) l.add_in_front(data);
                else if(y==2) l.add_in_back(data);
                else if(y==3)
                {
                    System.out.println("На какую позицию вы хотите поставить новый элемент?");
                    int pos=in.nextInt();
                    l.add(pos,data);
                }
            }
            else if (option==2)
            {
                System.out.println("Значение удаляемого элемента");
                int data=in.nextInt();
                l.delete_element_position(data);
            }
            else if (option==3)
            {
                l.printList();
                System.out.println();
            }
            else if (option==4)
            {
                System.out.println("Введите индекс элемента");
                int pos=in.nextInt();
                int data=l.get_element(pos);
                System.out.print("Значение элемента:"+data);
                System.out.println();
            }

            else if (option==0) quit=0;
            else quit =0;
        }
    }
}
